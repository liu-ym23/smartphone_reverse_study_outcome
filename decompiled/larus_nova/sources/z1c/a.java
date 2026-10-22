package z1c;

import android.content.Context;
import com.ss.android.lark.qrcode.ui.QRScanResultDefaultActivity;
import com.ss.android.lark.qrcode.ui.e;
import com.ss.android.lark.qrcode.ui.h;
import com.ss.android.lark.qrcode.ui.i;
import com.ss.android.lark.qrcode.ui.y;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import qqb.c;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a2c.a f569729a = null;

    /* JADX INFO: renamed from: z1c.a$a, reason: collision with other inner class name */
    public static final class C8411a {
        @JvmStatic
        public static void a(String r100, Context r101) {
            Intrinsics.checkNotNullParameter(r100, "qrContent");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            h r102 = h.c.f439070a;
            r102.getClass();
            r102.f439060c = new i(r101);
            if (((y) c.b("QRCodeScanManager handleParseResult", new e(r102, 2, r100))).f439097a == true) goto L5;
            QRScanResultDefaultActivity.z1(r101, r100, false);
        L5:
            r102.f439060c = null;
        }
    }

    static {
        f569729a = (a2c.a) ApiUtils.getApi(a2c.a.class);
    }
}
