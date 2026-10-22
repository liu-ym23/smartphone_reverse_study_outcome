package com.bytedance.ttcnpa;

import android.os.SystemClock;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.ttcnpa.utils.Logger;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yh7.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ttcnpa/TTCNPA;", "", "<init>", "()V", "ttcnpa_release"}, k = 1, mv = {1, 7, 1})
public final class TTCNPA {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TTCNPA f271037a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f271038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f271039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ITTCNPADepend f271040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static TtCnpaManager f271041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ScheduledExecutorService f271042f;

    private TTCNPA() {
    }

    static {
        f271037a = new TTCNPA();
    }

    public static ITTCNPADepend c() {
        ITTCNPADepend r100 = f271040d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTtCnpaDepend");
        return null;
    }

    public static TtCnpaResult b(TtCnpaCallback r110) {
        if (f271038b == true) goto L8;
        if (r110 == null) goto L7;
        r110.onResult(-1, "Not initialized");
    L7:
        return new TtCnpaResult(-1, "Not initialized", new TtCnpaManifest("", "", "", "", "", "", ""), "");
    L8:
        return null;
    }

    public static TtCnpaResult f(String r100, String r101, TtCnpaManifest r110) {
        Intrinsics.checkNotNullParameter(r100, "inputFilePath");
        Intrinsics.checkNotNullParameter(r101, "outputFilePath");
        Intrinsics.checkNotNullParameter(r110, ErrorType.MANIFEST);
        TtCnpaManager r102 = null;
        TtCnpaResult r103 = b(null);
        if (r103 != null) goto L10;
        JSONObject r104 = new JSONObject();
        long r105 = SystemClock.uptimeMillis();
        TtCnpaManager r106 = f271041e;
        if (r106 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mTtCnpaManager");
    L8:
        TtCnpaResult r107 = r102.f(r100, r101, r110);
        d("cnpa_write", null, r104, r105, r107);
        return r107;
    L7:
        r102 = r106;
        goto L8
    L10:
        return r103;
    }

    public final void a(final String r100, final String r110, final String r111, final TtCnpaCallback r112) {
        Intrinsics.checkNotNullParameter(r100, "inputFilePath");
        Intrinsics.checkNotNullParameter(r110, "outputFilePath");
        Intrinsics.checkNotNullParameter("1", "labelValue");
        Intrinsics.checkNotNullParameter(r111, "pId");
        Intrinsics.checkNotNullParameter(r112, "callback");
        if (b(r112) != null) goto L9;
        ScheduledExecutorService r101 = f271042f;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mExecutor");
        r101 = null;
    L7:
        r101.submit(new a(this, r100, r110, r111, r112));
        return;
    }

    public static void d(String r100, TtCnpaCallback r101, JSONObject r102, long r103, TtCnpaResult r104) {
        r102.put(ChameleonOpenTracker.ParamKey.COST, SystemClock.uptimeMillis() - r103);
        r102.put("error_code", r104.getErrorCode());
        r102.put(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, r104.getErrorDesc());
        c().f(r100, r102.toString());
        Logger r105 = Logger.f271058a;
        r102.toString();
        r105.getClass();
        if (r101 == null) goto L5;
        int r106 = (int) r104.getErrorCode();
        String r107 = r104.getErrorDesc();
        r104.getResultManifest();
        r104.getRawJsonManifest();
        r101.onResult(r106, r107);
    L5:
        r104.getErrorCode();
        r104.getErrorDesc();
        Objects.toString(r104.getResultManifest());
    }

    public static TtCnpaResult e(String r110, String r111, String r112, String r113, boolean r114, boolean r115, boolean r116, TtCnpaCallback r117) {
        JSONObject r100 = new JSONObject();
        long r101 = SystemClock.uptimeMillis();
        TtCnpaManager r102 = f271041e;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTtCnpaManager");
        r102 = null;
    L5:
        TtCnpaResult r103 = r102.e(r110, r111, r112, r113, r114, r115, r116);
        d("cnpa_write", r117, r100, r101, r103);
        return r103;
    }
}
