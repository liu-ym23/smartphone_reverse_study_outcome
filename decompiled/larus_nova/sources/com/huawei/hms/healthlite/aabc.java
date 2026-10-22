package com.huawei.hms.healthlite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.huawei.hms.hihealthlite.LoginFreeSDKStatusCodes;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.nova.R;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class aabc extends Fragment {

    /* JADX INFO: renamed from: aab, reason: collision with root package name */
    private View f277483aab;
    private WebView aaba;
    private String[] aabb;
    private String aabc;
    private String aabd;
    private String aabe;
    private String aabf;
    private String aabg;
    private Activity aabh;

    public class aab extends OnBackPressedCallback {

        /* JADX INFO: renamed from: aab, reason: collision with root package name */
        final /* synthetic */ aabc f277484aab;

        public aab(aabc r100, boolean r101) {
            this.f277484aab = r100;
            super(r101);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            aabc.aab(this.f277484aab).finish();
        }
    }

    public class aaba {

        /* JADX INFO: renamed from: aab, reason: collision with root package name */
        final /* synthetic */ aabc f277485aab;

        public aaba(aabc r100) {
            this.f277485aab = r100;
        }

        @JavascriptInterface
        public void handleAuthLoginResult(String r100) {
            aabg.aaba("AuthWebViewFragment", "AuthorizationtoJs invoke is Called");
            aabg.aaba("AuthWebViewFragment", "AuthorizationtoJs invoke is Called message: ");     // Catch: Throwable -> L17
            JSONObject r101 = new JSONObject(r100);     // Catch: Throwable -> L17
            if (r101.has("code") == false) goto L6;
            String r102 = JSONObjectProtectorUtils.getString(r101, "code");     // Catch: Throwable -> L17
        L8:
            if (r101.has("state") == false) goto L10;
            String r103 = JSONObjectProtectorUtils.getString(r101, "state");     // Catch: Throwable -> L17
        L12:
            if (r101.has("error") == false) goto L14;
            String r104 = JSONObjectProtectorUtils.getString(r101, "error");     // Catch: Throwable -> L17
        L15:
            aabc.aab(this.f277485aab, r102, r103, r104);     // Catch: Throwable -> L17
            return;
        L14:
            r104 = "";
            goto L15
        L10:
            r103 = "";
            goto L12
        L6:
            r102 = "";
        L17:
            aabc r105 = this.f277485aab;
            aabc.aab(r105, "", aabc.aaba(r105), "51013");
        }
    }

    public aabc() {
    }

    public static /* synthetic */ Activity aab(aabc r100) {
        return r100.aabh;
    }

    private Intent aab(int r100) {
        return aabg.aab(r100);
    }

    private String aab() {
        String r100 = URLEncoder.encode(this.aabd, StandardCharsets.UTF_8.name());     // Catch: Exception -> L16
        List<aabe> r101 = aabf.aaba().aab();     // Catch: Exception -> L16
        int r102 = 0;
        String r103 = "";
        String r104 = r103;
    L6:
        if (r102 >= r101.size()) goto L12;
        if ("product".equals(((aabe) ListProtector.get(r101, r102)).aabb()) == false) goto L11;
        r103 = ((aabe) ListProtector.get(r101, r102)).aab();     // Catch: Exception -> L16
        r104 = ((aabe) ListProtector.get(r101, r102)).aaba();     // Catch: Exception -> L16
    L11:
        r102 = r102 + 1;     // Catch: Exception -> L16
        goto L6
    L12:
        aabg.aaba("AuthWebViewFragment", "redirectUrl " + r103);     // Catch: Exception -> L16
        aabg.aaba("AuthWebViewFragment", "h5Url " + r104);     // Catch: Exception -> L16
        String r105 = r104 + "?response_type=code&state=" + r100 + "&client_id=" + this.aabf + "&redirect_uri=" + Uri.encode(r103) + "&scope=" + Uri.encode(this.aabc) + "&access_type=offline&display=touch";     // Catch: Exception -> L16
        this.aabg = r105;     // Catch: Exception -> L16
        if (TextUtils.isEmpty(r105) == false) goto L18;
        aabg.aaba("AuthWebViewFragment", "buildHealthAuthUrl  fail");     // Catch: Exception -> L16
        return "";
    L18:
        return this.aabg;
    L16:
        aabg.aab("AuthWebViewFragment", "buildHealthAuthUrl Exception");
        goto L18
    }

    public static /* synthetic */ String aaba(aabc r100) {
        return r100.aabd;
    }

    private void aaba() {
        Intent r100 = this.aabh.getIntent();     // Catch: Throwable -> L14 IllegalArgumentException -> L15
        if (r100 == null) goto L11;
        this.aabb = r100.getStringArrayExtra(ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE);     // Catch: Throwable -> L14 IllegalArgumentException -> L15
        this.aabd = r100.getStringExtra("state");     // Catch: Throwable -> L14 IllegalArgumentException -> L15
        this.aabf = r100.getStringExtra("clientId");     // Catch: Throwable -> L14 IllegalArgumentException -> L15
        this.aabe = r100.getStringExtra("deepLinkUrl");     // Catch: Throwable -> L14 IllegalArgumentException -> L15
        this.aabc = "";     // Catch: Throwable -> L14 IllegalArgumentException -> L15
        int r101 = 0;
    L7:
        if (r101 >= this.aabb.length) goto L9;
        this.aabc += this.aabb[r101] + " ";     // Catch: Throwable -> L14 IllegalArgumentException -> L15
        r101 = r101 + 1;     // Catch: Throwable -> L14 IllegalArgumentException -> L15
        goto L7
    L9:
        aabg.aaba("AuthWebViewFragment", "init para ms success ");     // Catch: Throwable -> L14 IllegalArgumentException -> L15
    L11:
        if (this.aabb != null) goto L20;
        aabg.aabb("AuthWebViewFragment", "scopes params is null");     // Catch: Throwable -> L14 IllegalArgumentException -> L15
        this.aabb = new String[0];     // Catch: Throwable -> L14 IllegalArgumentException -> L15
    L22:
        return;
    L20:
        return;
    L15:
        aabg.aab("AuthWebViewFragment", "IllegalArgumentException error");
        this.aabb = new String[0];
        return;
    L14:
        aabg.aab("AuthWebViewFragment", "initParams error");
        this.aabb = new String[0];
    }

    private void aabb() {
        this.aaba.getSettings().setJavaScriptEnabled(true);     // Catch: Exception -> L4
        this.aaba.getSettings().setAllowFileAccess(false);     // Catch: Exception -> L4
        this.aaba.getSettings().setAllowFileAccessFromFileURLs(false);     // Catch: Exception -> L4
        this.aaba.getSettings().setGeolocationEnabled(false);     // Catch: Exception -> L4
        this.aaba.getSettings().setAllowContentAccess(false);     // Catch: Exception -> L4
        this.aaba.getSettings().setUseWideViewPort(true);     // Catch: Exception -> L4
        this.aaba.getSettings().setSupportZoom(true);     // Catch: Exception -> L4
        this.aaba.getSettings().setLoadWithOverviewMode(true);     // Catch: Exception -> L4
        this.aaba.getSettings().setBuiltInZoomControls(true);     // Catch: Exception -> L4
        this.aaba.getSettings().setDisplayZoomControls(false);     // Catch: Exception -> L4
        String r100 = aab();     // Catch: Exception -> L4
        this.aaba.loadUrl(r100);     // Catch: Exception -> L4
        this.aaba.getSettings().setJavaScriptEnabled(true);     // Catch: Exception -> L4
        this.aaba.addJavascriptInterface(new aaba(this), "android");     // Catch: Exception -> L4
        this.aaba.setWebViewClient(new WebViewClient());     // Catch: Exception -> L4
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r100) {
        super.onAttach(r100);
        requireActivity().getOnBackPressedDispatcher().addCallback(new aab(this, true));
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        this.aabh = getActivity();     // Catch: Throwable -> L7
        if (this.f277483aab != null) goto L5;
        this.f277483aab = r100.inflate(R.layout.fragment_health_kit_auth_web_view, r101, false);     // Catch: Throwable -> L7
    L5:
        aaba();     // Catch: Throwable -> L7
        this.aaba = (WebView) this.f277483aab.findViewById(R.id.healthkit_auth_webView);     // Catch: Throwable -> L7
        this.aabh = getActivity();     // Catch: Throwable -> L7
        ((ImageView) this.f277483aab.findViewById(R.id.healthkit_auth_web_back_icon)).setOnClickListener(new aabb(this));     // Catch: Throwable -> L7
        aabb();     // Catch: Throwable -> L7
        return this.f277483aab;
    L7:
        aabg.aab("AuthWebViewFragment", "webView onCreateView has exception");
        return null;
    }

    public static /* synthetic */ void aab(aabc r100, String r101, String r102, String r103) {
        Intent r104 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(aabg.aab(r100.aabe, r101, r102, r103)));
        aabg.aaba("AuthWebViewFragment", "handleCheckAuthToThirdService begin to open activity from healthkit sdk");
        r100.startActivityForResult(r104, 1008);     // Catch: Exception -> L5
        aabg.aaba("AuthWebViewFragment", "auth success");     // Catch: Exception -> L5
        r100.aabh.setResult(-1, r100.aab(0));     // Catch: Exception -> L5
        r100.aabh.finish();     // Catch: Exception -> L5
        return;
    L5:
        aabg.aab("AuthWebViewFragment", "deeplinkThirdService error");
        aabg.aaba("AuthWebViewFragment", "APP auth:deeplink fail with errorCode is 51014");
        r100.aabh.setResult(-1, r100.aab(LoginFreeSDKStatusCodes.HEALTHKIT_DEEPLINK_THIRDSERVICE_FAIL));
        r100.aabh.finish();
    }
}
