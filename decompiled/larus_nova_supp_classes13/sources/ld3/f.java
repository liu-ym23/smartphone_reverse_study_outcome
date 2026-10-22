package ld3;

import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.dataplatform.config.SettingPanel;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    @SettingPanel("内流播放控制")
    public static final boolean a() {
        int r0 = p.a;
        Object r1 = Boolean.TRUE;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r3 = jj4.b.b;     // Catch: Throwable -> L7
        Object r4 = jj4.a.a("ec_inflow_video_play_control", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r4 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r4).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r6) == true) goto L12;
        r1 = r6;
    L12:
        r4 = r1;
        goto L14
    }

    @SettingPanel("BST接口升级2.0")
    public static final boolean b() {
        int r0 = p.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r3 = jj4.b.b;     // Catch: Throwable -> L7
        Object r4 = jj4.a.a("ec_inflow_isBstEnable", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r4 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r4).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r6) == true) goto L12;
        r1 = r6;
    L12:
        r4 = r1;
        goto L14
    }

    static {
    }
}
