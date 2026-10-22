package com.bytedance.ee.bear.middleground.comment.uitls;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j {
    public static final AtomicInteger a = null;

    static {
        a = new AtomicInteger(CCMLynxCardView.ViewType.BANNER);
    }

    public static ImageData a(CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r10, List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r11, ImageData.ToolStatus r12) {
        if (r10 == null) goto L28;
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11.isEmpty() == true) goto L36;
        ImageData r0 = new ImageData();
        ArrayList r1 = new ArrayList();
        Iterator<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r13 = r11.iterator();
    L9:
        if (r13.hasNext() == false) goto L23;
        CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r2 = r13.next();
        ImageData.Image r5 = new ImageData.Image();
        r5.setSrc(r2.getSrc());
        r5.setOriginalSrc(r2.getOriginalSrc());
        if (TextUtils.isEmpty(r2.getUuid()) == false) goto L19;
        String r3 = String.format(Locale.CHINA, "%d_%d", new Object[]{Long.valueOf(System.currentTimeMillis()), Integer.valueOf(a.getAndIncrement())});
        if (TextUtils.isEmpty(r2.getSrc()) == true) goto L16;
        r3 = UriProtector.parse(r2.getSrc()).getLastPathSegment();
    L18:
        r5.setUuid(r3);
    L20:
        r1.add(r5);
        if (r2 != r10) goto L9;
        r0.setImage(r5);
        goto L9
    L16:
        if (TextUtils.isEmpty(r2.getOriginalSrc()) == true) goto L18;
        r3 = UriProtector.parse(r2.getOriginalSrc()).getLastPathSegment();
        goto L18
    L19:
        r5.setUuid(r2.getUuid());
        goto L20
    L23:
        r0.setImageList(r1);
        if (r12 != null) goto L26;
        r12 = new ImageData.ToolStatus();
        r12.setComment(false);
        r12.setCommentable(false);
        r12.setCopy(true);
        r12.setExport(true);
        r12.setDelete(false);
        r12.setAreaComment(true);
    L26:
        r0.setToolStatus(r12);
        return r0;
    L36:
        return null;
    L28:
        return null;
    }
}
