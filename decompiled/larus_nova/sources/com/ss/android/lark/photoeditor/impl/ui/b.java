package com.ss.android.lark.photoeditor.impl.ui;

import android.graphics.Bitmap;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes37.dex */
public interface b extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void F6(String r100, Bitmap r101);

        void L7(Bitmap r100, ArrayList<pfc.f.a> r101);

        void n0(Bitmap r100, vfc.d r101);
    }

    void A2();

    void K3();

    boolean onBackPressed();

    void showToast(String r100);

    void v2(String r100, boolean r101, boolean r102, String r103, String r104, String r105, q0c.a r106);

    void y();

    void z(int r100);
}
