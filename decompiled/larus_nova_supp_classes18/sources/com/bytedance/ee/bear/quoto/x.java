package com.bytedance.ee.bear.quoto;

import com.larksuite.framework.mvp.IView;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface x extends IView<a> {

    public interface a extends IView.IViewDelegate {
    }

    void K0(Map r1, String r2, boolean r3);

    void Q0(Map<String, Long> r1, String r2, boolean r3, List<BusinessInfoRequester$BusinessAdminInfo> r4);

    void a2(String r1, boolean r2, Long r3);

    void r4(Map<String, Long> r1, String r2, boolean r3);

    void w0();
}
