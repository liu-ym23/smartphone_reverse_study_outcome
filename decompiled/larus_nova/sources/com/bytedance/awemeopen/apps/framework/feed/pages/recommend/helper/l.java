package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper;

import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.model.PhotoModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import r14.y;

/* JADX INFO: loaded from: classes14.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f195077a = 0;

    static {
    }

    public l() {
    }

    public static List a(r14.c r100) {
        if (r100 == null) goto L4;
        List<y> r101 = r100.v();
    L5:
        ArrayList r102 = new ArrayList();
        if (r101 == null) goto L11;
        Iterator<y> r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        y r104 = r103.next();
        PhotoModel r105 = new PhotoModel();
        r105.setUrlStruct(r104);
        r102.add(r105);
    L11:
        return r102;
    L4:
        r101 = null;
        goto L5
    }
}
