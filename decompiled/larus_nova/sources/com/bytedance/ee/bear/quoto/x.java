package com.bytedance.ee.bear.quoto;

import com.larksuite.framework.mvp.IView;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public interface x extends IView<a> {

    public interface a extends IView.IViewDelegate {
    }

    void K0(Map r100, String r101, boolean r102);

    void Q0(Map<String, Long> r100, String r101, boolean r102, List<BusinessInfoRequester$BusinessAdminInfo> r103);

    void a2(String r100, boolean r101, Long r102);

    void r4(Map<String, Long> r100, String r101, boolean r102);

    void w0();
}
