package com.bytedance.bdp.bdpplatform.service.accout;

import android.app.Activity;
import com.byted.mgl.merge.service.api.host.BdpGameAccountService;
import com.bytedance.bdp.serviceapi.hostimpl.account.listener.BdpLoginCallback;
import com.bytedance.bdp.serviceapi.hostimpl.account.model.BdpUserInfo;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import jb4.a;
import jb4.b;
import jb4.c;
import jb4.d;

/* JADX INFO: loaded from: classes3.dex */
public class BdpGameAccountServiceImpl implements BdpGameAccountService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f201350a;

    @Override // com.byted.mgl.merge.service.api.host.BdpGameAccountService
    public final boolean bindPhoneNumber(Activity r100, a r101) {
        return false;
    }

    @Override // com.byted.mgl.merge.service.api.host.BdpGameAccountService
    public final String getCurrentCarrier() {
        return null;
    }

    @Override // com.byted.mgl.merge.service.api.host.BdpGameAccountService
    public final String getDomainCookie(String r100) {
        return "";
    }

    @Override // com.byted.mgl.merge.service.api.host.BdpGameAccountService
    public final String getLoginCookie() {
        return "";
    }

    @Override // com.byted.mgl.merge.service.api.host.BdpGameAccountService
    public final void getMaskedPhone(String r100, c r101) {
    }

    @Override // com.byted.mgl.merge.service.api.host.BdpGameAccountService
    public final void getMaskedPhoneAuthToken(String r100, b r101) {
    }

    @Override // com.byted.mgl.merge.service.api.host.BdpGameAccountService
    public final String getUserUniqueId(String r100) {
        return null;
    }

    @Override // com.byted.mgl.merge.service.api.host.BdpGameAccountService
    public final String getXTTToken() {
        return "";
    }

    @Override // com.byted.mgl.merge.service.api.host.BdpGameAccountService
    public final void updateCurUser(String r100) {
    }

    @Override // com.byted.mgl.merge.service.api.host.BdpGameAccountService
    public final void updateDomainCookie(String r100, List<String> r101) {
    }

    public BdpGameAccountServiceImpl() {
        this.f201350a = new CopyOnWriteArrayList();
    }

    @Override // com.byted.mgl.merge.service.api.host.BdpGameAccountService
    public final BdpUserInfo getUserInfo(String r100) {
        return new BdpUserInfo();
    }

    @Override // com.byted.mgl.merge.service.api.host.BdpGameAccountService
    public final void registerLogoutListener(d r100) {
        ((CopyOnWriteArrayList) this.f201350a).add(null);
    }

    @Override // com.byted.mgl.merge.service.api.host.BdpGameAccountService
    public final void unRegisterLogoutListener(d r100) {
        ((CopyOnWriteArrayList) this.f201350a).remove(null);
    }

    @Override // com.byted.mgl.merge.service.api.host.BdpGameAccountService
    public final boolean login(Activity r100, HashMap<String, Object> r101, BdpLoginCallback r102, String r103) {
        if (r102 == null) goto L6;
        r102.onFail(String.valueOf(-10000), "BdpAccountServiceservice not impl");
        return false;
    L6:
        return false;
    }
}
