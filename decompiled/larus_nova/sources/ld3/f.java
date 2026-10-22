package ld3;

import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.dataplatform.config.SettingPanel;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f508690a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f508691a = 0;

        static {
        }
    }

    @SettingPanel("内流播放控制")
    public static final boolean a() {
        int r100 = p.f45243a;
        Object r101 = Boolean.TRUE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ec_inflow_video_play_control", Boolean.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r104).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("BST接口升级2.0")
    public static final boolean b() {
        int r100 = p.f45243a;
        Object r101 = Boolean.FALSE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ec_inflow_isBstEnable", Boolean.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r104).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    static {
    }
}
