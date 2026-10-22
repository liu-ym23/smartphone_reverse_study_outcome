package com.bytedance.locallife.poi.poidetail.screenshot.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/poi/poidetail/screenshot/model/PoiScreenshotMode;", "", "", "value", "I", "getValue", "()I", "FULL_SCREEN", "HALF_SCREEN", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum PoiScreenshotMode extends Enum<PoiScreenshotMode> {
    public static final PoiScreenshotMode FULL_SCREEN = null;
    public static final PoiScreenshotMode HALF_SCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiScreenshotMode[] f264187a = null;
    private final int value;

    public static PoiScreenshotMode valueOf(String r100) {
        return (PoiScreenshotMode) r27.a.a(PoiScreenshotMode.class, r100);
    }

    public static PoiScreenshotMode[] values() {
        return (PoiScreenshotMode[]) f264187a.clone();
    }

    static {
        PoiScreenshotMode r100 = new PoiScreenshotMode("FULL_SCREEN", 0, 1);
        FULL_SCREEN = r100;
        PoiScreenshotMode r101 = new PoiScreenshotMode("HALF_SCREEN", 1, 2);
        HALF_SCREEN = r101;
        f264187a = new PoiScreenshotMode[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public PoiScreenshotMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }

    public /* synthetic */ PoiScreenshotMode(String r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = 1;
    L5:
        this(r100, r101, r102);
    }
}
