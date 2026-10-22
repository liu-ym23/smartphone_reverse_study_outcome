package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper;

import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.model.PhotoModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import r14.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public l() {
    }

    public static List a(r14.c r3) {
        if (r3 == null) goto L4;
        List r4 = r3.v();
    L5:
        ArrayList r0 = new ArrayList();
        if (r4 == null) goto L11;
        Iterator r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L11;
        y r1 = (y) r5.next();
        PhotoModel r2 = new PhotoModel();
        r2.setUrlStruct(r1);
        r0.add(r2);
    L11:
        return r0;
    L4:
        r4 = null;
        goto L5
    }
}
