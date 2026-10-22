package uzb;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import java.net.URL;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes37.dex */
public final class i implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ URLSpan f552250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f552251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f552252c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Activity r101 = this.f552251b;
        String r102 = this.f552250a.getURL();
        JSONObject r103 = this.f552252c;
        if (r103 != null) goto L5;
    L35:
        boolean r104 = false;
    L36:
        if (r104 == false) goto L39;
        return;
    L39:
        if (TextUtils.isEmpty(this.f552250a.getURL()) == true) goto L48;
        Activity r105 = this.f552251b;
        Intent r106 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(this.f552250a.getURL()));     // Catch: Exception -> L46
        if ((r105 instanceof Activity) == true) goto L44;
        r106.addFlags(268435456);     // Catch: Exception -> L46
    L44:
        r105.startActivity(r106);     // Catch: Exception -> L46
        return;
    L46:
        e = move-exception;
        PassportLog.b("RichTextUtil", "open url error " + e.getMessage());
        return;
    L48:
        PassportLog.b("RichTextUtil", "subtitleLinkText href is empty");
        return;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L35;
        PassportLog.d("RichTextUtil", "url: " + r102);     // Catch: Exception -> L33
        String r107 = new URL(r102).getHost();     // Catch: Exception -> L33
        if (r103.containsKey(r107) == false) goto L16;
        Object r108 = r103.get(r107);     // Catch: Exception -> L33
        if ((r108 instanceof JSONObject) == false) goto L16;
        AtomicReference<syb.b> r109 = com.ss.android.lark.passport.flow.core.router.a.f437790c;     // Catch: Exception -> L33
        if (com.ss.android.lark.passport.flow.core.router.a.C5229a.a(r101, r107, (JSONObject) r108).a() == false) goto L16;
    L32:
        r104 = true;
    L16:
        if (TextUtils.equals(r107, r103.getString("next_step")) == false) goto L24;
        JSONObject r110 = r103.getJSONObject("step_data");     // Catch: Exception -> L33
        if (r110 != null) goto L21;
        r110 = r103.getJSONObject("step_info");     // Catch: Exception -> L33
    L21:
        AtomicReference<syb.b> r111 = com.ss.android.lark.passport.flow.core.router.a.f437790c;     // Catch: Exception -> L33
        if (com.ss.android.lark.passport.flow.core.router.a.C5229a.a(r101, r107, r110).a() == true) goto L32;
    L24:
        String r112 = r103.getString("next_step");     // Catch: Exception -> L33
        if (TextUtils.isEmpty(r112) == true) goto L35;
        JSONObject r113 = r103.getJSONObject("step_data");     // Catch: Exception -> L33
        if (r113 != null) goto L30;
        r113 = r103.getJSONObject("step_info");     // Catch: Exception -> L33
    L30:
        AtomicReference<syb.b> r114 = com.ss.android.lark.passport.flow.core.router.a.f437790c;     // Catch: Exception -> L33
        if (com.ss.android.lark.passport.flow.core.router.a.C5229a.a(r101, r112, r113).a() == false) goto L35;
    L33:
        e = move-exception;
        PassportLog.b("RichTextUtil", "error " + e.getMessage());
        goto L35
    }

    public i(URLSpan r100, FragmentActivity r101) {
        this.f552250a = r100;
        this.f552251b = r101;
        this.f552252c = null;
    }
}
