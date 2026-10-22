package com.huawei.hms.healthlite;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.huawei.hms.hihealthlite.LoginFreeSDKStatusCodes;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.nova.R;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes23.dex */
public class aaba extends Fragment {

    /* JADX INFO: renamed from: aab, reason: collision with root package name */
    private View f277481aab;
    private Activity aaba;
    private String[] aabb;
    private String aabc;
    private String aabd;
    private String aabe;
    private String aabf;
    private String aabg;

    public aaba() {
    }

    private Intent aab(int r100) {
        return aabg.aab(r100);
    }

    private void aabb() {
        Intent r100 = this.aaba.getIntent();     // Catch: Throwable -> L13 IllegalArgumentException -> L14
        if (r100 == null) goto L21;
        this.aabb = r100.getStringArrayExtra(ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE);     // Catch: Throwable -> L13 IllegalArgumentException -> L14
        this.aabd = r100.getStringExtra("state");     // Catch: Throwable -> L13 IllegalArgumentException -> L14
        this.aabf = r100.getStringExtra("clientId");     // Catch: Throwable -> L13 IllegalArgumentException -> L14
        this.aabe = r100.getStringExtra("deepLinkUrl");     // Catch: Throwable -> L13 IllegalArgumentException -> L14
        this.aabg = r100.getStringExtra("signature");     // Catch: Throwable -> L13 IllegalArgumentException -> L14
        this.aabc = "";     // Catch: Throwable -> L13 IllegalArgumentException -> L14
        int r101 = 0;
        if (this.aabb != null) goto L9;
        aabg.aabb("HealthKitAuthAppFragment", "scopes params is null");     // Catch: Throwable -> L13 IllegalArgumentException -> L14
        this.aabb = new String[0];     // Catch: Throwable -> L13 IllegalArgumentException -> L14
    L9:
        if (r101 >= this.aabb.length) goto L11;
        this.aabc += this.aabb[r101] + " ";     // Catch: Throwable -> L13 IllegalArgumentException -> L14
        r101 = r101 + 1;     // Catch: Throwable -> L13 IllegalArgumentException -> L14
        goto L9
    L11:
        aabg.aaba("HealthKitAuthAppFragment", "init pararms success ");     // Catch: Throwable -> L13 IllegalArgumentException -> L14
    L22:
        return;
    L21:
        return;
    L14:
        String r102 = "IllegalArgumentException error";
    L15:
        aabg.aab("HealthKitAuthAppFragment", r102);
        this.aabc = "";
        return;
    L13:
        r102 = "initParams error";
        goto L15
    }

    private void aabc() {
        aabg.aaba("HealthKitAuthAppFragment", "go to SportHealth APP");
        Intent r100 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(aaba()));     // Catch: Exception -> L5
        aabg.aaba("HealthKitAuthAppFragment", "openSportHealthApp begin to open activity from healthkit sdk");     // Catch: Exception -> L5
        startActivityForResult(r100, 1005);     // Catch: Exception -> L5
        return;
    L5:
        aabg.aab("HealthKitAuthAppFragment", "openSportHealthApp  error");
        aab("", "51012");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        if (this.f277481aab != null) goto L6;
        this.f277481aab = r100.inflate(R.layout.fragment_health_kit_auth_app, r101, false);
    L6:
        return this.f277481aab;
    }

    private void aab() {
        aabg.aaba("HealthKitAuthAppFragment", "auth success");
        this.aaba.setResult(-1, aabg.aab(0));
        this.aaba.finish();
    }

    private String aaba() {
        String r100 = "";
        String r101 = Uri.encode(this.aabe);
        String r102 = this.aabf;
        String r103 = this.aabg;
        byte[] r104 = Base64.getDecoder().decode(r103);
        if (TextUtils.isEmpty(r103) == true) goto L10;
        if (TextUtils.isEmpty(this.aabf) == true) goto L10;
        Mac r105 = Mac.getInstance("HmacSHA256");     // Catch: Throwable -> L9
        r105.init(new SecretKeySpec(r104, "HmacSHA256"));     // Catch: Throwable -> L9
        String r106 = Base64.getEncoder().encodeToString(r105.doFinal((r102 + "_" + r103).getBytes(XML.CHARSET_UTF8)));     // Catch: Throwable -> L9
    L11:
        StringBuilder r107 = new StringBuilder("huaweischeme://healthapp/oauth/linkagelogin?client_id=");
        r107.append(this.aabf);
        r107.append("&thirdUrlScheme=");
        r107.append(r101);
        r107.append("&state=");
        r107.append(this.aabd);
        r107.append("&scope=");
        if ("".equals(this.aabc.trim()) == true) goto L15;
        r100 = Uri.encode(this.aabc);
    L15:
        r107.append(r100);
        r107.append("&signature=");
        r107.append(Uri.encode(r106));
        return r107.toString();
    L10:
        r106 = "";
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        aabg.aaba("HealthKitAuthAppFragment", "HealthKitAuthHubActivity onCreate");
        super.onCreate(r100);     // Catch: Throwable -> L5 IllegalArgumentException -> L6
        aabg.aaba("HealthKitAuthAppFragment", "HealthKit auth sdk connect to service");     // Catch: Throwable -> L5 IllegalArgumentException -> L6
        this.aaba = getActivity();     // Catch: Throwable -> L5 IllegalArgumentException -> L6
        aabb();     // Catch: Throwable -> L5 IllegalArgumentException -> L6
        aabc();     // Catch: Throwable -> L5 IllegalArgumentException -> L6
    L11:
        return;
    L6:
        String r101 = "finish has IllegalArgumentException";
    L7:
        aabg.aab("HealthKitAuthAppFragment", r101);
        return;
    L5:
        r101 = "finish has exception";
        goto L7
    }

    private void aab(String r100, String r101) {
        Intent r102 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(aabg.aab(this.aabe, r100, this.aabd, r101)));
        aabg.aaba("HealthKitAuthAppFragment", "handleCheckAuthToThirdService begin to open activity from healthkit sdk");
        startActivityForResult(r102, 1006);     // Catch: Exception -> L5
        aab();     // Catch: Exception -> L5
        return;
    L5:
        aabg.aab("HealthKitAuthAppFragment", "deeplinkThirdService error");
        aabg.aaba("HealthKitAuthAppFragment", "APP auth:deeplink fail with errorCode is 51014");
        this.aaba.setResult(-1, aab(LoginFreeSDKStatusCodes.HEALTHKIT_DEEPLINK_THIRDSERVICE_FAIL));
        this.aaba.finish();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        aabg.aaba("HealthKitAuthAppFragment", "onActivityResult requestCode:" + r100);
        if (r100 != 1005) goto L17;
        if (r100 != 1005) goto L18;
        aabg.aaba("HealthKitAuthAppFragment", "handleHealthAuthResultFromApp to sdk auth" + r101);     // Catch: Exception -> L11
        if (r101 != 0) goto L9;
        aabg.aaba("HealthKitAuthAppFragment", "handleHealthAuthResultFromApp success");     // Catch: Exception -> L11
        aab();     // Catch: Exception -> L11
    L13:
        return;
    L9:
        aab("", "51012");     // Catch: Exception -> L11
    L11:
        aabg.aab("HealthKitAuthAppFragment", "onActivityResult has throwable");
        aab("", "51012");
        return;
    L18:
        return;
    }
}
