package zm;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes44.dex */
public final class b<T> extends LinearLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f572839g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f572840h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<List<T>> f572841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b<T>.C8476b> f572842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zm.a f572843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f572844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f572845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<T, View> f572846f;

    public static final class a {
    }

    /* JADX INFO: renamed from: zm.b$b, reason: collision with other inner class name */
    public final class C8476b extends LinearLayout {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f572847c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f572848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f572849b;

        static {
            f572847c = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(C8476b.class, "data", "getData()Ljava/util/List;", 0))};
        }

        public final List<T> getData() {
            return (List) this.f572848a.getValue(this, f572847c[0]);
        }

        public final void setData(List<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.f572848a.setValue(this, f572847c[0], r100);
        }

        public C8476b(b r100, Context r101) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f572849b = r100;
            super(r101, null);
            Delegates r102 = Delegates.INSTANCE;
            ArrayList r103 = new ArrayList();
            this.f572848a = new c(r103, r103, this);
            setOrientation(1);
            setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
    }

    static {
        f572839g = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(b.class, "data", "getData()Ljava/util/List;", 0))};
        f572840h = com.bytedance.android.shopping.extensions.b.b(38);
    }

    public final List<T> getData() {
        return (List) this.f572843c.getValue(this, f572839g[0]);
    }

    public final void setData(List<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f572843c.setValue(this, f572839g[0], r100);
    }

    public final Function1<T, View> getItemCreator() {
        return this.f572846f;
    }

    public b(Context r100, int r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "itemCreator");
        super(r100, null);
        this.f572844d = 2;
        this.f572845e = r101;
        this.f572846f = r102;
        ArrayList r103 = new ArrayList(2);
        int r104 = 0;
    L3:
        if (r104 >= 2) goto L5;
        r103.add(new ArrayList());
        r104 = r104 + 1;
        goto L3
    L5:
        this.f572841a = r103;
        int r105 = this.f572844d;
        ArrayList r106 = new ArrayList(r105);
        int r107 = 0;
    L6:
        if (r107 >= r105) goto L8;
        r106.add(new C8476b(this, r100));
        r107 = r107 + 1;
        goto L6
    L8:
        this.f572842b = r106;
        Delegates r108 = Delegates.INSTANCE;
        ArrayList r109 = new ArrayList();
        this.f572843c = new zm.a(r109, r109, this);
        Iterator<T> r110 = r106.iterator();
        int r111 = 0;
    L10:
        if (r110.hasNext() == false) goto L18;
        T r112 = r110.next();
        int r113 = r111 + 1;
        if (r111 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        C8476b r114 = (C8476b) r112;
        LinearLayout.LayoutParams r115 = new LinearLayout.LayoutParams(0, -2);
        r115.weight = 1.0f;
        r115.leftMargin = this.f572845e;
        if (r111 != 0) goto L17;
        r115.leftMargin = 0;
    L17:
        addView(r114, r115);
        r111 = r113;
        goto L10
    L18:
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    }
}
