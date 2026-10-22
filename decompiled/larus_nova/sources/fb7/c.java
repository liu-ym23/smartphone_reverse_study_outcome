package fb7;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;

/* JADX INFO: loaded from: classes22.dex */
public final class c extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f476270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f476271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f476272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f476273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f476274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f476275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f476276i;

    @Override // fb7.a
    public int getType() {
        return 1;
    }

    public c() {
        this.f476273f = ParamKeyConstants.WebViewConstants.VALUE_FROM_OPENSDK;
    }

    public c(Bundle r100) {
        this.f476273f = ParamKeyConstants.WebViewConstants.VALUE_FROM_OPENSDK;
        this.f476265a = r100.getString(ParamKeyConstants.BaseParams.CALLER_PKG);
        r100.getString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_VERSION);
        r100.getBundle(ParamKeyConstants.BaseParams.EXTRA);
        this.f476266b = r100.getString(ParamKeyConstants.BaseParams.FROM_ENTRY);
        this.f476270c = r100.getString(ParamKeyConstants.AuthParams.STATE);
        this.f476272e = r100.getString(ParamKeyConstants.AuthParams.CLIENT_KEY);
        r100.getString("_bytedance_params_client_secret");
        this.f476271d = r100.getString(ParamKeyConstants.AuthParams.REDIRECT_URI);
        r100.getString("_bytedance_params_next_url");
        this.f476274g = r100.getString(ParamKeyConstants.AuthParams.SCOPE);
        this.f476275h = r100.getString(ParamKeyConstants.AuthParams.OPTIONAL_SCOPE0);
        this.f476276i = r100.getString(ParamKeyConstants.AuthParams.OPTIONAL_SCOPE1);
        r100.getInt(ParamKeyConstants.AuthParams.WAP_REQUESETED_ORIENTATION, -1);
        this.f476273f = r100.getString("wap_to_native_from_tag", ParamKeyConstants.WebViewConstants.VALUE_FROM_OPENSDK);
    }
}
