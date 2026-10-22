package com.ss.android.ugc.aweme.search.vision.model.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/model/data/ToolBarStyle;", "", "", "value", "I", "getValue", "()I", "WHITE", "TRANSPARENT", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ToolBarStyle extends Enum<ToolBarStyle> {
    public static final ToolBarStyle TRANSPARENT = null;
    public static final ToolBarStyle WHITE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ToolBarStyle[] f453652a = null;
    private final int value;

    static {
        ToolBarStyle r100 = new ToolBarStyle("WHITE", 0, 0);
        WHITE = r100;
        ToolBarStyle r101 = new ToolBarStyle("TRANSPARENT", 1, 1);
        TRANSPARENT = r101;
        f453652a = new ToolBarStyle[]{r100, r101};
    }

    public static ToolBarStyle valueOf(String r100) {
        return (ToolBarStyle) a.a(ToolBarStyle.class, r100);
    }

    public static ToolBarStyle[] values() {
        return (ToolBarStyle[]) f453652a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ToolBarStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
