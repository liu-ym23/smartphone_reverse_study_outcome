package com.bytedance.bdp.serviceapi.hostimpl.account;

import android.app.Activity;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import com.bytedance.bdp.serviceapi.hostimpl.account.listener.BdpLoginCallback;
import com.bytedance.bdp.serviceapi.hostimpl.account.model.BdpUserInfo;
import java.util.HashMap;
import java.util.List;
import jb4.a;
import jb4.b;
import jb4.c;
import jb4.d;

/* JADX INFO: loaded from: classes3.dex */
public interface BdpAccountService extends IBdpService {
    boolean bindPhoneNumber(Activity r100, a r101);

    String getCurrentCarrier();

    String getDomainCookie(String r100);

    String getLoginCookie();

    void getMaskedPhone(String r100, c r101);

    void getMaskedPhoneAuthToken(String r100, b r101);

    BdpUserInfo getUserInfo(String r100);

    String getUserUniqueId(String r100);

    String getXTTToken();

    boolean login(Activity r100, HashMap<String, Object> r101, BdpLoginCallback r102, String r103);

    void registerLogoutListener(d r100);

    void unRegisterLogoutListener(d r100);

    void updateDomainCookie(String r100, List<String> r101);
}
