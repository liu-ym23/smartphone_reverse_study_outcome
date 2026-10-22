package yz8;

import android.app.Application;
import com.bytedance.sdk.account.platform.OnekeyLoginAdapter;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.platform.base.OnekeyLoginErrorResponse;
import com.larus.account.base.impl.p;
import com.larus.account.base.model.LoginPlatform;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class e extends OnekeyLoginAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n38.h f569563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f569564b;

    @Override // com.bytedance.sdk.account.platform.IOnekeyLoginAdapter
    public final void onLoginError(AuthorizeErrorResponse r110) {
        Intrinsics.checkNotNullParameter(r110, "response");
        if ((r110 instanceof OnekeyLoginErrorResponse) == false) goto L24;
        String r100 = r110.platformErrorCode;
        Map r101 = null;
        if (r100 == null) goto L9;
        Integer r102 = StringsKt.toIntOrNull(r100);
        if (r102 == null) goto L9;
    L17:
        int r103 = r102.intValue();
    L19:
        n38.h r104 = this.f569563a;
        LoginPlatform r105 = LoginPlatform.PHONE;
        String r106 = r110.platformErrorMsg;
        String r107 = this.f569564b;
        OnekeyLoginErrorResponse r111 = (OnekeyLoginErrorResponse) r110;
        Integer r112 = Integer.valueOf(r111.mDetailErrorCode);
        String r113 = r111.mDetailErrorMsg;
        JSONObject r114 = r111.rawResult;
        if (r114 == null) goto L22;
        r101 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(EventConstant.Key.RAW_DATA, r114.toString())});
    L22:
        n38.h.a.a(r104, r105, r103, r106, r107, null, r112, r113, r101, 32);
        return;
    L9:
        r102 = Integer.valueOf(((OnekeyLoginErrorResponse) r110).error);
        if (r102.intValue() == 0) goto L12;
        boolean r108 = true;
    L13:
        if (r108 == true) goto L16;
        r102 = null;
    L16:
        if (r102 != null) goto L17;
        r103 = -2;
        goto L19
    L12:
        r108 = false;
        goto L13
    }

    @Override // com.bytedance.sdk.account.platform.IOnekeyLoginAdapter
    public final void onLoginSuccess(xa7.g r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        this.f569563a.b(LoginPlatform.PHONE, this.f569564b, Boolean.valueOf(r100.f563088v.f541366g));
    }

    public e(p r100, Application r101) {
        this.f569563a = r100;
        this.f569564b = "phone_one_key";
        super(r101);
    }
}
