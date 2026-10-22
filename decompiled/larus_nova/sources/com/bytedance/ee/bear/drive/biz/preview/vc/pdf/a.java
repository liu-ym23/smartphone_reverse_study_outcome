package com.bytedance.ee.bear.drive.biz.preview.vc.pdf;

import com.bytedance.ee.bear.drive.view.preview.pdf.ExhibitionMode;

/* JADX INFO: loaded from: classes16.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a$a, reason: collision with other inner class name */
    public interface InterfaceC3211a {
    }

    public interface b {
    }

    public interface c {
    }

    int a(int r100);

    boolean b(int r100);

    DrivePdfState.V2Offset c();

    float d(int r100);

    void e(int r100, int r101);

    int f();

    ExhibitionMode getCurrentMode();

    int getCurrentPage();

    int getPageCount();

    int getViewHeight();

    void setCurrentPosition(int r100);

    void setExhibitionMode(ExhibitionMode r100);

    void setListenerChange(InterfaceC3211a r100);

    void setPDFActionListener(b r100);

    void setScrollListener(c r100);

    void setState(DrivePdfState r100);
}
