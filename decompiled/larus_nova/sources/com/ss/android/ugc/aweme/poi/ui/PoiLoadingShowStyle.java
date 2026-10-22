package com.ss.android.ugc.aweme.poi.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/ui/PoiLoadingShowStyle;", "", "", "style", "I", "getStyle", "()I", "DOUBLE_BALL", "LOCAL_LIFE", "LOCAL_LIFE_WITH_DOUBLE_BALL", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum PoiLoadingShowStyle extends Enum<PoiLoadingShowStyle> {
    public static final PoiLoadingShowStyle DOUBLE_BALL = null;
    public static final PoiLoadingShowStyle LOCAL_LIFE = null;
    public static final PoiLoadingShowStyle LOCAL_LIFE_WITH_DOUBLE_BALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiLoadingShowStyle[] f451363a = null;
    private final int style;

    public static PoiLoadingShowStyle valueOf(String r100) {
        return (PoiLoadingShowStyle) a.a(PoiLoadingShowStyle.class, r100);
    }

    public static PoiLoadingShowStyle[] values() {
        return (PoiLoadingShowStyle[]) f451363a.clone();
    }

    static {
        PoiLoadingShowStyle r100 = new PoiLoadingShowStyle("DOUBLE_BALL", 0, 0);
        DOUBLE_BALL = r100;
        PoiLoadingShowStyle r101 = new PoiLoadingShowStyle("LOCAL_LIFE", 1, 1);
        LOCAL_LIFE = r101;
        PoiLoadingShowStyle r102 = new PoiLoadingShowStyle("LOCAL_LIFE_WITH_DOUBLE_BALL", 2, 2);
        LOCAL_LIFE_WITH_DOUBLE_BALL = r102;
        f451363a = new PoiLoadingShowStyle[]{r100, r101, r102};
    }

    public final int getStyle() {
        return this.style;
    }

    public PoiLoadingShowStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.style = r102;
    }

    public /* synthetic */ PoiLoadingShowStyle(String r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = 0;
    L5:
        this(r100, r101, r102);
    }
}
