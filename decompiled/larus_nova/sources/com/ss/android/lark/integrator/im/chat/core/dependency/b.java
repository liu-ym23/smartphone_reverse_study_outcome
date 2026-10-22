package com.ss.android.lark.integrator.im.chat.core.dependency;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.im.base.browser.IImBrowserService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements BrowserDependency {
    public b() {
    }

    @Override // com.ss.android.lark.chat.core.dependency.BrowserDependency
    public final void openUrl(Context r100, String r101) {
        ((IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class)).sendLinkClickEvent("messenger", IImBrowserService.LINK_LOCATION_CHAT);
        ((IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class)).openUrl(r100, r101);
    }

    @Override // com.ss.android.lark.chat.core.dependency.BrowserDependency
    public final void a(Context r100, String r101, int r102) {
        b(r100, r101, r102, null);
    }

    @Override // com.ss.android.lark.chat.core.dependency.BrowserDependency
    public final void c(Context r100, String r101, int r110) {
        ((IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class)).sendLinkClickEvent("messenger", IImBrowserService.LINK_LOCATION_CHAT);
        IImBrowserService r102 = (IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class);
        if (r110 != 1) goto L5;
        int r103 = 6;
    L9:
        r102.openUrl(r100, r101, r103, null, nmb.a.a().getCCMDependency().getDocArgsMessage());
        return;
    L5:
        if (r110 == 2) goto L7;
        r103 = 5;
        goto L9
    L7:
        r103 = 7;
        goto L9
    }

    @Override // com.ss.android.lark.chat.core.dependency.BrowserDependency
    public final void b(Context r100, String r110, int r111, Bundle r112) {
        d(r100, r110, r111, BrowserDependency.UrlClickType.INLINE, r112, null, null);
    }

    @Override // com.ss.android.lark.chat.core.dependency.BrowserDependency
    public final void d(Context r110, String r111, int r112, String r113, Bundle r114, Fragment r115, String r116) {
        ((IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class)).sendLinkClickEvent("messenger", IImBrowserService.LINK_LOCATION_CHAT);
        Map<String, String> r100 = nmb.a.a().getCCMDependency().getDocArgsMessage();
        HashMap r101 = new HashMap();
        r101.putAll(r100);
        r101.put("url_click_type", r113);
        Bundle r102 = new Bundle();
        r102.putString("fromScene", "chat");
        if (r112 != 0) goto L5;
        int r103 = 1009;
    L6:
        r102.putInt(IImBrowserService.KEY_WEB_SCENE, r103);
        if (r114 == null) goto L10;
        r102.putAll(r114);
    L10:
        if (TextUtils.isEmpty(r116) == true) goto L13;
        r101.put(IImBrowserService.KEY_DOC_TITLE, r116);
    L13:
        if (r114 != null) goto L15;
    L17:
        boolean r104 = false;
    L18:
        if (r104 == true) goto L20;
    L24:
        IImBrowserService r105 = (IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class);
        if (r112 != 1) goto L27;
        int r106 = 6;
    L31:
        r105.openUrl(r110, r111, r106, r102, r100, r101, r115);
        return;
    L27:
        if (r112 == 2) goto L29;
        r106 = 5;
        goto L31
    L29:
        r106 = 7;
        goto L31
    L20:
        if (TextUtils.isEmpty(r116) == true) goto L24;
        if (TextUtils.equals(r111, r116) == true) goto L24;
        ((IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class)).createSecLinkHelper(r111, r116);
        Log.i("BrowserDependencyImpl", "secLinkHelper empty");
        goto L24
    L15:
        if (r114.getBoolean("custom_url_sec_link_check") == false) goto L17;
        r104 = true;
        goto L18
    L5:
        r103 = 1010;
        goto L6
    }
}
