package com.ss.android.lark.widget.photo.preview.video.online;

import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.player.entity.DataSource;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;

/* JADX INFO: loaded from: classes38.dex */
public interface c extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void A4();

        void B0(PhotoItem r100);

        void X4(PhotoItem r100, Integer r101);
    }

    void P3(String r100);

    void Y7(DataSource r100, boolean r101, Integer r102);

    void c3();

    void f4(int r100);

    void i4(float r100);

    void k2();

    void p6(boolean r100);

    void pause();

    void resume();

    void showToast(String r100);

    void w7(String r100);

    void y();
}
