package com.ss.android.ugc.aweme.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/base/ImageUrlModel;", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ImageUrlModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f449994a;

    public ImageUrlModel(List r100) {
        this.f449994a = new ArrayList();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L29;
        Iterator r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L30;
        String r102 = (String) r101.next();
        if (r102 != null) goto L13;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == true) goto L9;
        List<String> r104 = this.f449994a;
        if (r104 == null) goto L9;
        ((ArrayList) r104).add(r102);
        goto L9
    L13:
        if (r102.length() == 0) goto L16;
        r103 = false;
        goto L17
    L30:
        return;
    }
}
