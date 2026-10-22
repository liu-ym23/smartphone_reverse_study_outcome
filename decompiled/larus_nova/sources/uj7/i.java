package uj7;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.ug.sdk.luckycat.impl.manager.LuckyCatSettingsManger;
import com.bytedance.ug.sdk.luckycat.impl.utils.LuckyCatALogHelper;
import java.util.ArrayList;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes22.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f550416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f550417b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        String r111 = this.f550416a.getText().toString();
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("StaticResourceManager", "replaceDomain begin, url= " + r111);
        if (TextUtils.isEmpty(r111) == true) goto L50;
        LuckyCatSettingsManger r100 = LuckyCatSettingsManger.b.f271283a;
        Object r101 = r100.c(new String[]{"disaster_config", "assets_origin_domain"});
        String r102 = null;
        if ((r101 instanceof String) == false) goto L8;
        String r103 = (String) r101;
    L9:
        Object r104 = r100.c(new String[]{"disaster_config", "assets_domain_list"});
        if ((r104 instanceof JSONArray) == false) goto L19;
        JSONArray r105 = (JSONArray) r104;
        ArrayList r106 = new ArrayList();
        int r107 = 0;
    L13:
        if (r107 >= r105.length()) goto L20;
        String r108 = r105.optString(r107);
        if (bd7.a.a(r108) == true) goto L18;
        r106.add(r108);
    L18:
        r107 = r107 + 1;
    L20:
        if (r103 == null) goto L49;
        if (r106 == null) goto L49;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("StaticResourceManager", "assetsOriginDomain: " + r103 + ", domainList: " + r106);
        if (TextUtils.isEmpty(r103) == false) goto L26;
    L48:
        com.bytedance.ug.sdk.luckycat.impl.utils.a.b("StaticResourceManager", "TextUtils.isEmpty(assetsOriginDomain) || domainList == null || domainList.size() < 1");
        goto L50
    L26:
        if (r106.size() < 1) goto L48;
        Uri r109 = UriProtector.parse(r111);
        boolean r112 = r109.getBooleanQueryParameter("no_dispatch", false);
        if (r103.equals(r109.getAuthority()) == false) goto L50;
        if (r112 == true) goto L50;
        if (r106.size() >= 1) goto L52;
    L44:
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("StaticResourceManager", "ready to replace: domain= " + r102);
        if (TextUtils.isEmpty(r102) == true) goto L50;
        r111 = r109.buildUpon().authority(r102).build().toString();
        goto L50
    L52:
        long r113 = CastLongProtector.parseLong(com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.i());     // Catch: NumberFormatException -> L36
    L38:
        int r114 = Math.min(((int) (r113 % 100)) / (100 / r106.size()), r106.size() - 1);
        if (ListProtector.get(r106, r114) == null) goto L44;
        r102 = (String) ListProtector.get(r106, r114);     // Catch: Exception -> L42
    L42:
        e = move-exception;
        e.printStackTrace();
    L36:
        e = move-exception;
        String r115 = e.getMessage();
        LuckyCatALogHelper.f271505e.getClass();
        LuckyCatALogHelper.a(5, "StaticResourceManager", r115);
        r113 = 0;
    L49:
        com.bytedance.ug.sdk.luckycat.impl.utils.a.b("StaticResourceManager", "assets_origin_domain is null or assets_domain_list is null");
        goto L50
    L19:
        r106 = null;
        goto L20
    L8:
        r103 = null;
    L50:
        this.f550417b.setText("result: " + r111 + "\ndid: " + com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.i() + "\n");
    }

    public i(TextView r100, TextView r101) {
        this.f550416a = r100;
        this.f550417b = r101;
    }
}
