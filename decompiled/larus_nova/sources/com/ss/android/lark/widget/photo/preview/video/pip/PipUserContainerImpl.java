package com.ss.android.lark.widget.photo.preview.video.pip;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.s;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.widget.photo.preview.video.online.j0;
import f0c.h;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class PipUserContainerImpl extends c0c.c implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f447404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, a> f447405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f447406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f447407e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/widget/photo/preview/video/pip/PipUserContainerImpl$ActivityState;", "", "<init>", "(Ljava/lang/String;I)V", "CREATED", "RESUMED", "PAUSED", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ActivityState extends Enum<ActivityState> {
        public static final ActivityState CREATED = null;
        public static final ActivityState PAUSED = null;
        public static final ActivityState RESUMED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ActivityState[] f447408a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f447409b = null;

        public static EnumEntries<ActivityState> getEntries() {
            return f447409b;
        }

        static {
            ActivityState r100 = new ActivityState("CREATED", 0);
            CREATED = r100;
            ActivityState r101 = new ActivityState("RESUMED", 1);
            RESUMED = r101;
            ActivityState r102 = new ActivityState("PAUSED", 2);
            PAUSED = r102;
            ActivityState[] r103 = {r100, r101, r102};
            f447408a = r103;
            f447409b = EnumEntriesKt.enumEntries(r103);
        }

        public static ActivityState[] values() {
            return (ActivityState[]) f447408a.clone();
        }

        public static ActivityState valueOf(String r100) {
            return (ActivityState) r27.a.a(ActivityState.class, r100);
        }

        public ActivityState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<Activity> f447410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f447411b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ActivityState f447412c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LifecycleObserver f447413d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f447410a, r101.f447410a) == true) goto L12;
            return false;
        L12:
            if (this.f447411b == r101.f447411b) goto L15;
            return false;
        L15:
            if (this.f447412c == r101.f447412c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f447413d, r101.f447413d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f447410a.hashCode() * 31;
            long r101 = this.f447411b;
            return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f447412c.hashCode()) * 31) + this.f447413d.hashCode();
        }

        public final String toString() {
            return "ActivityInfo(ref=" + this.f447410a + ", createTime=" + this.f447411b + ", state=" + this.f447412c + ", lifecycleObserver=" + this.f447413d + ')';
        }

        public a(WeakReference r100, long r101, ActivityState r102, PipUserContainerImpl$whenActivityCreate$lifecycleObserver$1 r103) {
            Intrinsics.checkNotNullParameter(r100, TemplateNodeType.REF);
            Intrinsics.checkNotNullParameter(r102, "state");
            Intrinsics.checkNotNullParameter(r103, "lifecycleObserver");
            this.f447410a = r100;
            this.f447411b = r101;
            this.f447412c = r102;
            this.f447413d = r103;
        }
    }

    public final void n() {
        a r100 = this.f447406d;
        if (r100 != null) goto L5;
    L9:
        this.f447406d = null;
        return;
    L5:
        if (UIUtils.isActivityRunning(r100.f447410a.get()) == false) goto L9;
        Activity r101 = r100.f447410a.get();
        if (r101 == null) goto L9;
        r101.finish();
        goto L9
    }

    @Override // com.ss.android.lark.widget.photo.preview.video.pip.b
    public final void zc() {
        ((com.ss.android.lark.widget.photopicker.f.h) this.f447407e.getValue()).a();
    }

    @Inject
    public PipUserContainerImpl(m r100) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        super(r100);
        this.f447404b = "PipModeInstanceManager";
        this.f447405c = new LinkedHashMap();
        this.f447407e = LazyKt.lazy(PipUserContainerImpl$vcDependency$2.INSTANCE);
        s.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.lifecycle.LifecycleObserver, com.ss.android.lark.widget.photo.preview.video.pip.PipUserContainerImpl$whenActivityCreate$lifecycleObserver$1] */
    @Override // com.ss.android.lark.widget.photo.preview.video.pip.b
    public final void H4(final Activity r110) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        final long r100 = System.currentTimeMillis();
        Log.i(this.f447404b, "onCreate, createTime: " + r100);
        ?? r101 = new PipUserContainerImpl$whenActivityCreate$lifecycleObserver$1(this, r100, r110);
        LifecycleOwner r102 = i2c.a.a(r110);
        if (r102 == null) goto L7;
        Lifecycle r103 = r102.getLifecycle();
        if (r103 == 0) goto L7;
        r103.addObserver(r101);
    L7:
        this.f447405c.put(Integer.valueOf(r110.hashCode()), new a(new WeakReference(r110), r100, ActivityState.CREATED, r101));
    }

    @Override // com.ss.android.lark.widget.photo.preview.video.pip.b
    public final void K7(j0 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        new f(r100);
        ((com.ss.android.lark.widget.photopicker.f.h) this.f447407e.getValue()).b();
    }

    @Override // c0c.c
    public final void d(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        Log.i(this.f447404b, "destroy state: " + r100.f475035a);
        ((LinkedHashMap) this.f447405c).clear();
        n();
        s.b(this);
    }

    @Override // c0c.c
    public final void i(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        Log.i(this.f447404b, "onPrepared state: " + r100.f475035a);
    }

    @Override // com.ss.android.lark.widget.photo.preview.video.pip.b
    public final void ne(FragmentActivity r100, boolean r101) {
        Integer r102 = null;
        if (r101 == false) goto L27;
        Map<Integer, a> r103 = this.f447405c;
        if (r100 == null) goto L7;
        r102 = Integer.valueOf(r100.hashCode());
    L7:
        a r104 = (a) TypeIntrinsics.asMutableMap(r103).remove(r102);
        if (r104 != null) goto L10;
    L25:
        Log.e(this.f447404b, "onActivityPipModeChange, Activity state error");
        return;
    L10:
        if (UIUtils.isActivityRunning(r104.f447410a.get()) == false) goto L25;
        this.f447406d = r104;
        Iterator r105 = ((LinkedHashMap) this.f447405c).entrySet().iterator();
    L14:
        if (r105.hasNext() == false) goto L44;
        a r106 = (a) ((Map.Entry) r105.next()).getValue();
        if (r106.f447412c != ActivityState.RESUMED) goto L14;
        if (r104.f447411b > r106.f447411b) goto L20;
        n();
        goto L14
    L20:
        Activity r107 = r106.f447410a.get();
        if (r107 == null) goto L23;
        r107.onBackPressed();
    L23:
        r105.remove();
        goto L14
    L44:
        return;
    L27:
        a r108 = this.f447406d;
        if (r108 == null) goto L34;
        Map<Integer, a> r109 = this.f447405c;
        if (r100 == null) goto L32;
        int r110 = r100.hashCode();
    L33:
        r109.put(Integer.valueOf(r110), r108);
        goto L34
    L32:
        r110 = 0;
    L34:
        this.f447406d = null;
    }

    public static final void m(PipUserContainerImpl r100, long r101, Activity r102, ActivityState r103) {
        r100.getClass();
        if (PipModeProcessor.b(r102) == false) goto L34;
        a r104 = r100.f447406d;
        if (r104 == null) goto L10;
        WeakReference<Activity> r105 = r104.f447410a;
        if (r105 == null) goto L10;
        Activity r106 = r105.get();
    L12:
        if (Intrinsics.areEqual(r106, r102) == false) goto L16;
        a r107 = r100.f447406d;
        if (r107 == null) goto L20;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r107.f447412c = r103;
    L20:
        if (r103 != ActivityState.RESUMED) goto L30;
        a r108 = r100.f447406d;
        if (r108 != null) goto L24;
        return;
    L24:
        if (r108.f447411b > r101) goto L26;
        r100.n();
        return;
    L26:
        if (UIUtils.isActivityRunning(r102) == false) goto L32;
        r102.onBackPressed();
        return;
    L32:
        return;
    L30:
        return;
    L16:
        Map<Integer, a> r109 = r100.f447405c;
        LinkedHashMap r110 = (LinkedHashMap) r109;
        a r111 = (a) r110.get(Integer.valueOf(r102.hashCode()));
        if (r111 == null) goto L20;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r111.f447412c = r103;
    L10:
        r106 = null;
        goto L12
    }
}
