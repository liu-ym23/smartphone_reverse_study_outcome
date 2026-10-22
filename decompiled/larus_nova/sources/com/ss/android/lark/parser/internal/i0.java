package com.ss.android.lark.parser.internal;

import com.ss.android.lark.image.entity.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes37.dex */
public final class i0 {
    public static Image a(com.ss.android.lark.widget.richtext.Image r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Image r101 = new Image();
        r101.setHeight(r100.getHeight());
        r101.setWidth(r100.getWidth());
        r101.setKey(r100.getKey());
        r101.setToken(r100.getToken());
        r101.setCrypto(r100.getCrypto());
        r101.setFsUnit(r100.getFsUnit());
        r101.setResourceCleanScene(r100.getResourceCleanScene());
        r101.setResourceIsCleaned(r100.isResourceIsCleaned());
        com.ss.android.lark.widget.richtext.Image.Type r102 = r100.getType();
        if (r102 == null) goto L8;
        r101.setType(Image.Type.forNumber(r102.getNumber()));
    L8:
        r101.setUrls(r100.getUrls());
        return r101;
    }

    public static List<Image> b(List<com.ss.android.lark.widget.richtext.Image> r100) {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
        return r101;
    L5:
        Iterator<com.ss.android.lark.widget.richtext.Image> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        com.ss.android.lark.widget.richtext.Image r103 = r102.next();
        if (r103 == null) goto L7;
        r101.add(a(r103));
        goto L7
    L12:
        return r101;
    }
}
