package eia;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class n extends v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f472804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f472805e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f472806f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f472807g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f472808h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f472809i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f472810j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f472811k;

    public static final class a {
    }

    static {
    }

    @Override // eia.v
    public void a() {
        boolean r100 = b();
        FLogger r101 = FLogger.f375446a;
        r101.i("BaseInputStrategy", "applyOrientationChange " + hashCode());
        if (r100 == false) goto L21;
        maa.e r102 = (maa.e) this.f472806f.getValue();
        if (r102 == null) goto L7;
        Boolean r103 = Boolean.valueOf(r102.x3());
    L8:
        maa.e r104 = (maa.e) this.f472806f.getValue();
        if (r104 == null) goto L13;
        boolean r105 = true;
        if (r104.L4() != true) goto L13;
    L14:
        r101.i("BaseInputStrategy", "resumeClickTalk " + hashCode() + ", isClickTalking " + r103 + ", isClickTalkClosing " + r105);
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L22;
        if (r105 == true) goto L23;
        laa.m r106 = (laa.m) this.f472807g.getValue();
        if (r106 == null) goto L24;
        r106.Tb();
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L13:
        r105 = false;
        goto L14
    L7:
        r103 = null;
        goto L8
    }

    public n(Context r100, final t1a.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "vContext");
        super(r100, r101);
        this.f472804d = LazyKt.lazy(new f(r101));
        this.f472805e = LazyKt.lazy(new g(r101));
        this.f472806f = LazyKt.lazy(new h(r101));
        this.f472807g = LazyKt.lazy(new i(r101));
        this.f472808h = LazyKt.lazy(new j(r101));
        this.f472809i = LazyKt.lazy(new k(r101));
        this.f472810j = LazyKt.lazy(new l(r101));
        this.f472811k = LazyKt.lazy(new m(r101));
    }
}
