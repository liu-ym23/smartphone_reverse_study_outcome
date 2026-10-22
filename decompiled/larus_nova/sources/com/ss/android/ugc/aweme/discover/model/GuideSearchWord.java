package com.ss.android.ugc.aweme.discover.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/GuideSearchWord;", "Ljava/io/Serializable;", "viewType", "", "(I)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GuideSearchWord implements Serializable {
    public GuideSearchWord() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public GuideSearchWord(int r100) {
    }

    public /* synthetic */ GuideSearchWord(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 1;
    L5:
        this(r100);
    }
}
