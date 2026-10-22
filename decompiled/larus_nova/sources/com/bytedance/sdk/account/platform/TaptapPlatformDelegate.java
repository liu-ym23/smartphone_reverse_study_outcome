package com.bytedance.sdk.account.platform;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.ITaptapService;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class TaptapPlatformDelegate extends f {
    String accessToken;
    HashMap<String, String> extraInfo;
    private PlatformBindAdapter.a mBindCallback;
    private PlatformLoginAdapter.LoginCallback mLoginCallback;
    private PlatformProfileAdapter.ProfileCallback mProfileCallback;
    String macKey;
    String version;

    /* JADX INFO: loaded from: classes3.dex */
    public static class Factory implements f.a {
        public Factory() {
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createBind(PlatformBindAdapter r100) {
            return new TaptapPlatformDelegate(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createLogin(PlatformLoginAdapter r100) {
            return new TaptapPlatformDelegate(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createProfile(PlatformProfileAdapter r100) {
            return new TaptapPlatformDelegate(r100);
        }
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void cancelBind() {
        PlatformBindAdapter.a r100 = this.mBindCallback;
        if (r100 == null) goto L5;
        r100.cancel();
        this.mBindCallback = null;
    L5:
        this.bindDelegate = null;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void cancelLogin() {
        PlatformLoginAdapter.LoginCallback r100 = this.mLoginCallback;
        if (r100 == null) goto L5;
        r100.cancel();
        this.mLoginCallback = null;
    L5:
        this.loginDelegate = null;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void cancelProfile() {
        PlatformProfileAdapter.ProfileCallback r100 = this.mProfileCallback;
        if (r100 == null) goto L5;
        r100.cancel();
        this.mProfileCallback = null;
    L5:
        this.profileAdapter = null;
    }

    public TaptapPlatformDelegate(PlatformBindAdapter r100) {
        super(r100);
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestBind(Bundle r110) {
        PlatformBindAdapter r100 = this.bindDelegate;
        if (r100 == null) goto L6;
        parseData(r110, r100.mExtendParam);
        PlatformBindAdapter r111 = this.bindDelegate;
        r111.getClass();
        PlatformBindAdapter.a r101 = new PlatformBindAdapter.a(r111);
        this.mBindCallback = r101;
        PlatformBindAdapter r112 = this.bindDelegate;
        r112.api.f(r112.platformId, null, this.accessToken, 0, this.extraInfo, r101);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestLogin(Bundle r110) {
        PlatformLoginAdapter r100 = this.loginDelegate;
        if (r100 == null) goto L6;
        parseData(r110, r100.mExtendParam);
        PlatformLoginAdapter r111 = this.loginDelegate;
        r111.getClass();
        PlatformLoginAdapter.LoginCallback r101 = new PlatformLoginAdapter.LoginCallback(r111);
        this.mLoginCallback = r101;
        PlatformLoginAdapter r112 = this.loginDelegate;
        r112.api.j(r112.platformId, null, this.accessToken, 0, this.extraInfo, r101);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestProfile(Bundle r110) {
        PlatformProfileAdapter r100 = this.profileAdapter;
        if (r100 == null) goto L6;
        parseData(r110, r100.mExtendParam);
        PlatformProfileAdapter r111 = this.profileAdapter;
        r111.getClass();
        PlatformProfileAdapter.ProfileCallback r101 = new PlatformProfileAdapter.ProfileCallback(r111);
        this.mProfileCallback = r101;
        PlatformProfileAdapter r112 = this.profileAdapter;
        r112.api.a(r112.platformId, null, this.accessToken, 0, this.extraInfo, r101);
        return;
    }

    public TaptapPlatformDelegate(PlatformLoginAdapter r100) {
        super(r100);
    }

    public TaptapPlatformDelegate(PlatformProfileAdapter r100) {
        super(r100);
    }

    private void parseData(Bundle r100, Map<String, String> r101) {
        this.accessToken = r100.getString(ITaptapService.ResponseConstants.KID);
        this.macKey = r100.getString(ITaptapService.ResponseConstants.MAC_KEY);
        String r102 = r100.getString(ITaptapService.TAPTAP_VERSION);
        this.version = r102;
        if (TextUtils.isEmpty(r102) == false) goto L5;
        this.version = "v2";
    L5:
        HashMap<String, String> r103 = new HashMap();
        this.extraInfo = r103;
        r103.put(ITaptapService.ResponseConstants.MAC_KEY, this.macKey);
        if (r101 == null) goto L8;
        this.extraInfo.putAll(r101);
    L8:
        this.extraInfo.put(ITaptapService.TAPTAP_VERSION, this.version);
    }
}
