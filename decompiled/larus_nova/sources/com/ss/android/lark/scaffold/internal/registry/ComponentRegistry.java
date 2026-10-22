package com.ss.android.lark.scaffold.internal.registry;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.framework.larkwidget.WidgetManager;
import com.ss.android.lark.scaffold.Component;
import com.ss.android.lark.scaffold.IComponent;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class ComponentRegistry implements l3c.b, l3c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f439758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<l3c.f> f439759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy<WidgetManager> f439760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<Function1<l3c.d, List<l3c.c>>> f439761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<c> f439762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Class<? extends IComponent>, IComponent> f439763f;

    public static final class a<T extends l3c.a> implements c {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            ((a) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "C2(factory=null, block=null)";
        }
    }

    public static final class b {
    }

    public interface c {
    }

    public static final class d implements c {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            ((d) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Logic2(block=null)";
        }
    }

    public static final class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<l3c.b, Component> f439764a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f439764a, ((e) r100).f439764a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f439764a.hashCode();
        }

        public final String toString() {
            return "Logic(block=" + this.f439764a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e(Function1<? super l3c.b, ? extends Component> r100) {
            Intrinsics.checkNotNullParameter(r100, "block");
            this.f439764a = r100;
        }
    }

    public static final class f implements c {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            ((f) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Ui2(container=null, block=null)";
        }
    }

    public static final class g implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f439765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<l3c.b, Component> f439766b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (this.f439765a == r101.f439765a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f439766b, r101.f439766b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f439765a * 31) + this.f439766b.hashCode();
        }

        public final String toString() {
            return "Ui(containerId=" + this.f439765a + ", block=" + this.f439766b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public g(int r100, Function1<? super l3c.b, ? extends Component> r101) {
            Intrinsics.checkNotNullParameter(r101, "block");
            this.f439765a = r100;
            this.f439766b = r101;
        }
    }

    static {
    }

    public final void b() {
        l3c.f r100 = this.f439759b.invoke();
        Iterator<T> r101 = this.f439761d.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Iterator r102 = ((List) ((Function1) r101.next()).invoke(this)).iterator();
    L7:
        if (r102.hasNext() == false) goto L4;
        ((l3c.c) r102.next()).a(r100);
        goto L7
    }

    public final void a(final Function1<? super l3c.d, ? extends l3c.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        this.f439761d.add((Function1<l3c.d, List<l3c.c>>) new ComponentRegistry$configurator$1(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ComponentRegistry(FragmentActivity r100, final Fragment r101, LifecycleOwner r102, final View r103, Function0<? extends l3c.f> r104) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r103, "view");
        Intrinsics.checkNotNullParameter(r104, "runtime");
        this.f439758a = r102;
        this.f439759b = r104;
        this.f439760c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new ComponentRegistry$widgetManager$1(r101, r103));
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
        this.f439761d = new ArrayList();
        this.f439762e = new ArrayList();
        this.f439763f = new LinkedHashMap();
    }
}
