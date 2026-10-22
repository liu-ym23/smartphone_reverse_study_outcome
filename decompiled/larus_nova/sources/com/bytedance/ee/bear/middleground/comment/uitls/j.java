package com.bytedance.ee.bear.middleground.comment.uitls;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes18.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f232211a = null;

    static {
        f232211a = new AtomicInteger(1000);
    }

    public static ImageData a(CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r110, List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r111, ImageData.ToolStatus r112) {
        if (r110 == null) goto L28;
        if (r111 != null) goto L5;
        return null;
    L5:
        if (r111.isEmpty() == true) goto L36;
        ImageData r100 = new ImageData();
        ArrayList r101 = new ArrayList();
        Iterator<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r113 = r111.iterator();
    L9:
        if (r113.hasNext() == false) goto L23;
        CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r102 = r113.next();
        ImageData.Image r103 = new ImageData.Image();
        r103.setSrc(r102.getSrc());
        r103.setOriginalSrc(r102.getOriginalSrc());
        if (TextUtils.isEmpty(r102.getUuid()) == false) goto L19;
        String r104 = String.format(Locale.CHINA, "%d_%d", new Object[]{Long.valueOf(System.currentTimeMillis()), Integer.valueOf(f232211a.getAndIncrement())});
        if (TextUtils.isEmpty(r102.getSrc()) == true) goto L16;
        r104 = UriProtector.parse(r102.getSrc()).getLastPathSegment();
    L18:
        r103.setUuid(r104);
    L20:
        r101.add(r103);
        if (r102 != r110) goto L9;
        r100.setImage(r103);
        goto L9
    L16:
        if (TextUtils.isEmpty(r102.getOriginalSrc()) == true) goto L18;
        r104 = UriProtector.parse(r102.getOriginalSrc()).getLastPathSegment();
        goto L18
    L19:
        r103.setUuid(r102.getUuid());
        goto L20
    L23:
        r100.setImageList(r101);
        if (r112 != null) goto L26;
        r112 = new ImageData.ToolStatus();
        r112.setComment(false);
        r112.setCommentable(false);
        r112.setCopy(true);
        r112.setExport(true);
        r112.setDelete(false);
        r112.setAreaComment(true);
    L26:
        r100.setToolStatus(r112);
        return r100;
    L36:
        return null;
    L28:
        return null;
    }
}
