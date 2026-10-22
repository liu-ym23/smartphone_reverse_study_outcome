package com.bytedance.ies.bullet.service.base;

import android.view.View;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public interface o {
    void b(String r100, p r101);

    void c();

    void f(byte[] r100, String r101, Map<String, ? extends Object> r102);

    void g();

    q26.j getContext();

    KitType getKitType();

    String getSessionId();

    String getViewTag();

    SccConfig.SccLevel i();

    boolean k(String r100);

    void m();

    boolean onBackPressed();

    void onHide();

    void onShow();

    View realView();

    void reload();

    void sendEvent(String r100, Object r101);

    void updateData(Map<String, ? extends Object> r100);

    void updateGlobalProps(Map<String, ? extends Object> r100);
}
