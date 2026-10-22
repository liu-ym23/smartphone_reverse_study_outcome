package com.bytedance.ee.bear.drive.biz.preview.vc.pdf;

import com.bytedance.ee.bear.drive.view.preview.pdf.ExhibitionMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a$a, reason: collision with other inner class name */
    public interface InterfaceC0155a {
    }

    public interface b {
    }

    public interface c {
    }

    int a(int r1);

    boolean b(int r1);

    DrivePdfState.V2Offset c();

    float d(int r1);

    void e(int r1, int r2);

    int f();

    ExhibitionMode getCurrentMode();

    int getCurrentPage();

    int getPageCount();

    int getViewHeight();

    void setCurrentPosition(int r1);

    void setExhibitionMode(ExhibitionMode r1);

    void setListenerChange(InterfaceC0155a r1);

    void setPDFActionListener(b r1);

    void setScrollListener(c r1);

    void setState(DrivePdfState r1);
}
