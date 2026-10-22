package com.bytedance.ee.bear.drive.biz.preview.more.save2space;

import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.quoto.FullQuotoConfig;
import com.bytedance.ee.bear.quoto.SingleFileQuotaConfig;
import com.bytedance.ee.bear.quoto.t;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static boolean a(Throwable r11, FragmentActivity r12, Long r13, a95.a r14) {
            Intrinsics.checkNotNullParameter(r14, "userComponentAbility");
            String r2 = null;
            if ((r11 instanceof NetService.ServerErrorException) == false) goto L24;
            if (com.bytedance.ee.util.ui.b.a(r12) == false) goto L24;
            if (r12 == null) goto L24;
            int r16 = ((NetService.ServerErrorException) r11).getCode();
            t r4 = (t) org.koin.java.a.c(t.class, null, null, 6);
            if (r4.q(r16) == false) goto L12;
            r4.j(r12, FullQuotoConfig.SAVE_TO_DRIVE);
            return true;
        L12:
            if (r4.k(r16) == false) goto L16;
            r4.c(r12, null, null, false, false, "");
            return true;
        L16:
            if (r4.s(r16) == false) goto L20;
            r4.c(r12, null, null, false, true, "");
            return true;
        L20:
            if (r4.g(r16) == false) goto L51;
            r4.f(r12, SingleFileQuotaConfig.SAVE, r13);
            return true;
        L51:
            return false;
        L24:
            if ((r11 instanceof NetService.HttpErrorException) == false) goto L51;
            int r17 = JSONObjectProtectorUtils.getInt(new JSONObject(((NetService.HttpErrorException) r11).getHttpStr()), "code");     // Catch: Throwable -> L49
            if (r17 == 900099001) goto L40;
            if (r17 != 900099003) goto L30;
            if (r12 == null) goto L37;
            Resources r18 = r12.getResources();     // Catch: Throwable -> L49
            if (r18 == null) goto L37;
            r2 = r18.getString(2131888914);     // Catch: Throwable -> L49
        L37:
            Toast.showFailureText(r12, r2, 0);     // Catch: Throwable -> L49
            return true;
        L30:
            if (r17 != 900099005) goto L51;
            return true;
        L40:
            if (ex4.a.a(r14.c) == false) goto L42;
            int r19 = 2131889590;
        L43:
            if (r12 == null) goto L47;
            Resources r110 = r12.getResources();     // Catch: Throwable -> L49
            if (r110 == null) goto L47;
            r2 = r110.getString(r19);     // Catch: Throwable -> L49
        L47:
            Toast.showFailureText(r12, r2, 0);     // Catch: Throwable -> L49
            return true;
        L42:
            r19 = 2131889534;
        L49:
            th = move-exception;
            tt5.a.e("SaveToSpaceErrorUtils", "handle NetService.HttpErrorException error!", th, false);
            goto L51
        }
    }

    static {
    }
}
