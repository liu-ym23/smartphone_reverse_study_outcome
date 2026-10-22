package com.ss.android.ugc.aweme.search.vision.model.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/model/data/BackIconStyle;", "", "BACK", "CLOSE", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BackIconStyle extends Enum<BackIconStyle> {
    public static final BackIconStyle BACK = null;
    public static final BackIconStyle CLOSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BackIconStyle[] f453597a = null;

    static {
        BackIconStyle r100 = new BackIconStyle("BACK", 0);
        BACK = r100;
        BackIconStyle r101 = new BackIconStyle("CLOSE", 1);
        CLOSE = r101;
        f453597a = new BackIconStyle[]{r100, r101};
    }

    public static BackIconStyle valueOf(String r100) {
        return (BackIconStyle) a.a(BackIconStyle.class, r100);
    }

    public static BackIconStyle[] values() {
        return (BackIconStyle[]) f453597a.clone();
    }

    public BackIconStyle(String r100, int r101) {
        super(r100, r101);
    }
}
