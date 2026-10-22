package com.bytedance.ee.bear.contract.imageviewer.api;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageCommentData;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.bear.document.imageviewer.ImageViewerPlugin;
import com.bytedance.ee.bear.document.imageviewer.areacomment.c;
import r27.a;
import tw4.b;
import uw4.f;

/* JADX INFO: loaded from: classes16.dex */
public interface IImageViewer {

    public static final enum ImageCommentMode extends Enum<ImageCommentMode> {
        public static final ImageCommentMode AREA_COMMENT_ADD = null;
        public static final ImageCommentMode COMMENT_VIEW = null;
        public static final ImageCommentMode EXIT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ImageCommentMode[] f217067a = null;

        static {
            ImageCommentMode r100 = new ImageCommentMode("EXIT", 0);
            EXIT = r100;
            ImageCommentMode r101 = new ImageCommentMode("COMMENT_VIEW", 1);
            COMMENT_VIEW = r101;
            ImageCommentMode r102 = new ImageCommentMode("AREA_COMMENT_ADD", 2);
            AREA_COMMENT_ADD = r102;
            f217067a = new ImageCommentMode[]{r100, r101, r102};
        }

        public static ImageCommentMode[] values() {
            return (ImageCommentMode[]) f217067a.clone();
        }

        public static ImageCommentMode valueOf(String r100) {
            return (ImageCommentMode) a.a(ImageCommentMode.class, r100);
        }

        public ImageCommentMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    void JB(ImageCommentData r100);

    void LN(c.f r100);

    void Ob(ImageViewerPlugin.f r100);

    void RX(b r100);

    void Wh();

    void Ws(com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.a.c r100);

    void aQ(r15.c r100);

    ImageData.Image c7();

    void c80(ImageViewerPlugin.e r100);

    void close();

    void f00(boolean r100);

    ViewGroup getContainerView();

    void hl(ImageCommentMode r100);

    View iF();

    boolean isShowing();

    String mC();

    void mG(uw4.b r100);

    void oZ(boolean r100);

    void qK(f r100);

    void wn(ImageData r100);

    void xJ(uw4.c r100);
}
