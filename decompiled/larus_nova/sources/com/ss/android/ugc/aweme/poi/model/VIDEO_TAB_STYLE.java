package com.ss.android.ugc.aweme.poi.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/model/VIDEO_TAB_STYLE;", "", "", "value", "I", "getValue", "()I", "DRAK", "LIGHT", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum VIDEO_TAB_STYLE extends Enum<VIDEO_TAB_STYLE> {
    public static final VIDEO_TAB_STYLE DRAK = null;
    public static final VIDEO_TAB_STYLE LIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VIDEO_TAB_STYLE[] f451357a = null;
    private final int value;

    public static VIDEO_TAB_STYLE valueOf(String r100) {
        return (VIDEO_TAB_STYLE) a.a(VIDEO_TAB_STYLE.class, r100);
    }

    public static VIDEO_TAB_STYLE[] values() {
        return (VIDEO_TAB_STYLE[]) f451357a.clone();
    }

    static {
        VIDEO_TAB_STYLE r100 = new VIDEO_TAB_STYLE("DRAK", 0, 0);
        DRAK = r100;
        VIDEO_TAB_STYLE r101 = new VIDEO_TAB_STYLE("LIGHT", 1, 1);
        LIGHT = r101;
        f451357a = new VIDEO_TAB_STYLE[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public VIDEO_TAB_STYLE(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
