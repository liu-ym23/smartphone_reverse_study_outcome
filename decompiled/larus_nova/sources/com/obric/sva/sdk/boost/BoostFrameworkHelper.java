package com.obric.sva.sdk.boost;

import android.content.Context;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u0013J\u0012\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u000fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/obric/sva/sdk/boost/BoostFrameworkHelper;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "processName", "", "kotlin.jvm.PlatformType", "boostFrameworkObj", "perfHintAcqRelMethod", "Ljava/lang/reflect/Method;", "VENDOR_HINT_FIRST_LAUNCH_BOOST", "", "Ljava/lang/Integer;", "Launch_TYPE_ATTACH_APPLICATION", "boost", "", "schedPerTaskBoostLocked", "tid", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BoostFrameworkHelper {
    public static final Companion Companion = null;
    private static final String TAG = "BoostFrameworkHelper";
    private volatile Integer Launch_TYPE_ATTACH_APPLICATION;
    private volatile Integer VENDOR_HINT_FIRST_LAUNCH_BOOST;
    private volatile Object boostFrameworkObj;
    private final Context context;
    private volatile Method perfHintAcqRelMethod;
    private final String processName;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/sva/sdk/boost/BoostFrameworkHelper$Companion;", "", "<init>", "()V", "TAG", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final void boost() {
        schedPerTaskBoostLocked$default(this, 0, 1, null);
    }

    public final Context getContext() {
        return this.context;
    }

    public BoostFrameworkHelper(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r110;
        this.processName = r110.getPackageName();
        String r100 = null;
        Class<?> r101 = DoubleReflector.getClass("android.util.BoostFramework");     // Catch: Throwable -> L13
        Object r111 = DoubleReflector.getConstructor(r101, new Class[]{Context.class}).newInstance(new Object[]{r110});     // Catch: Throwable -> L6
    L7:
        this.boostFrameworkObj = r111;     // Catch: Throwable -> L13
        if (r101 == null) goto L10;
        Class<?> r102 = Integer.TYPE;     // Catch: Throwable -> L13
        Method r112 = r101.getMethod("perfHintAcqRel", new Class[]{r102, r102, String.class, r102, r102, r102, int[].class});     // Catch: Throwable -> L13
    L11:
        this.perfHintAcqRelMethod = r112;     // Catch: Throwable -> L13
        Object r113 = DoubleReflector.getField(r101, "VENDOR_HINT_FIRST_LAUNCH_BOOST").get(null);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L13
        this.VENDOR_HINT_FIRST_LAUNCH_BOOST = (Integer) r113;     // Catch: Throwable -> L13
        Object r114 = DoubleReflector.getField(DoubleReflector.getClass("android.util.BoostFramework$Launch"), "TYPE_ATTACH_APPLICATION").get(null);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L13
        this.Launch_TYPE_ATTACH_APPLICATION = (Integer) r114;     // Catch: Throwable -> L13
    L15:
        LogUtils.d(TAG, "boostFrameworkObj = " + this.boostFrameworkObj, new Object[0]);
        LogUtils.d(TAG, "perfHintAcqRelMethod = " + this.perfHintAcqRelMethod, new Object[0]);
        StringBuilder r115 = new StringBuilder("VENDOR_HINT_FIRST_LAUNCH_BOOST = 0x");
        Integer r103 = this.VENDOR_HINT_FIRST_LAUNCH_BOOST;
        if (r103 == null) goto L18;
        r100 = Integer.toString(r103.intValue(), CharsKt.checkRadix(16));
    L18:
        r115.append(r100);
        LogUtils.d(TAG, r115.toString(), new Object[0]);
        LogUtils.d(TAG, "Launch_TYPE_ATTACH_APPLICATION = " + this.Launch_TYPE_ATTACH_APPLICATION, new Object[0]);
        return;
    L10:
        r112 = null;
        goto L11
    L6:
        r111 = DoubleReflector.getConstructor(r101, new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        LogUtils.i(TAG, String.valueOf(th.getMessage()), new Object[]{th});
        goto L15
    }

    private final void schedPerTaskBoostLocked(int r110) {
        if (this.perfHintAcqRelMethod != null) goto L7;
        LogUtils.i(TAG, "perfHintAcqRelMethod is null", new Object[0]);
        return;
    L7:
        if (this.boostFrameworkObj != null) goto L22;
        LogUtils.i(TAG, "boostFrameworkObj is null", new Object[0]);
        return;
    L22:
        Method r100 = this.perfHintAcqRelMethod;     // Catch: Throwable -> L15
        if (r100 == null) goto L20;
        r100.invoke(this.boostFrameworkObj, new Object[]{-1, this.VENDOR_HINT_FIRST_LAUNCH_BOOST, this.processName, Integer.valueOf(r110), this.Launch_TYPE_ATTACH_APPLICATION, 1, new int[]{-1}});     // Catch: Throwable -> L15
    L20:
        LogUtils.d(TAG, "schedPerTaskBoost: tid = " + r110, new Object[0]);
        return;
    L15:
        th = move-exception;
        String r101 = th.getMessage();
        if (r101 != null) goto L19;
        r101 = "";
    L19:
        LogUtils.i(TAG, r101, new Object[]{th});
        goto L20
    }

    public static /* synthetic */ void schedPerTaskBoostLocked$default(BoostFrameworkHelper r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = JniUtils.INSTANCE.getThreadTid();
    L5:
        r100.schedPerTaskBoostLocked(r101);
    }
}
