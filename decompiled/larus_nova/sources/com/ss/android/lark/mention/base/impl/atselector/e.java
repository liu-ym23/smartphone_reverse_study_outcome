package com.ss.android.lark.mention.base.impl.atselector;

import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public interface e extends IView<a> {

    public interface a extends IView.IViewDelegate {
        boolean V0();

        void V2(int r100);

        void b6();

        void c5(BaseAtBean r100);

        void f6();

        void l1(BaseAtBean r100);

        void l8(BaseAtBean r100);

        String n6();

        boolean o0();

        void onLoadMore();

        void onSearch(String r100);

        void u4(BaseAtBean r100);
    }

    void D4(Map<String, BaseAtBean> r100, boolean r101);

    void E8(String r100, List<BaseAtBean> r101);

    void G8(List<BaseAtBean> r100);

    void S3(List<BaseAtBean> r100);

    void T5(Map<String, BaseAtBean> r100);

    void j1(com.ss.android.lark.mention.base.impl.atselector.bean.d r100);

    void o3(String r100);

    void o7();

    void p1(List<BaseAtBean> r100);

    void s4(int r100);

    int y0();
}
