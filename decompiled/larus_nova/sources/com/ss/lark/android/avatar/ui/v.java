package com.ss.lark.android.avatar.ui;

import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;

/* JADX INFO: loaded from: classes40.dex */
public interface v extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void B3();

        void Q3(String r100);

        void U2(String r100);

        boolean V4();

        String o4();

        void r8();
    }

    void D5();

    void D8(String r100);

    void E7(boolean r100);

    void J5();

    void M1(String r100);

    void O4();

    void T2();

    boolean U5();

    String getEntityId();

    boolean i3();

    void j5(String r100);

    void p8(PhotoItem r100);

    void q5();

    void w1();

    void z5(String r100);
}
