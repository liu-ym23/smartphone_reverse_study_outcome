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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface IImageViewer {

    public static final enum ImageCommentMode extends Enum<ImageCommentMode> {
        public static final ImageCommentMode AREA_COMMENT_ADD = null;
        public static final ImageCommentMode COMMENT_VIEW = null;
        public static final ImageCommentMode EXIT = null;
        public static final /* synthetic */ ImageCommentMode[] a = null;

        static {
            ImageCommentMode r0 = new ImageCommentMode("EXIT", 0);
            EXIT = r0;
            ImageCommentMode r1 = new ImageCommentMode("COMMENT_VIEW", 1);
            COMMENT_VIEW = r1;
            ImageCommentMode r3 = new ImageCommentMode("AREA_COMMENT_ADD", 2);
            AREA_COMMENT_ADD = r3;
            a = new ImageCommentMode[]{r0, r1, r3};
        }

        public static ImageCommentMode[] values() {
            return (ImageCommentMode[]) a.clone();
        }

        public static ImageCommentMode valueOf(String r1) {
            return (ImageCommentMode) a.a(ImageCommentMode.class, r1);
        }

        public ImageCommentMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    void JB(ImageCommentData r1);

    void LN(c.f r1);

    void Ob(ImageViewerPlugin.f r1);

    void RX(b r1);

    void Wh();

    void Ws(com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.a.c r1);

    void aQ(r15.c r1);

    ImageData.Image c7();

    void c80(ImageViewerPlugin.e r1);

    void close();

    void f00(boolean r1);

    ViewGroup getContainerView();

    void hl(ImageCommentMode r1);

    View iF();

    boolean isShowing();

    String mC();

    void mG(uw4.b r1);

    void oZ(boolean r1);

    void qK(f r1);

    void wn(ImageData r1);

    void xJ(uw4.c r1);
}
