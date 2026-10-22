package com.ss.android.ugc.aweme.poi.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/ui/PoiSkinMode;", "", "", "mode", "I", "getMode", "()I", "AUTO_SKIN", "FORCE_WHITE", "FORCE_NIGHT", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum PoiSkinMode extends Enum<PoiSkinMode> {
    public static final PoiSkinMode AUTO_SKIN = null;
    public static final PoiSkinMode FORCE_NIGHT = null;
    public static final PoiSkinMode FORCE_WHITE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiSkinMode[] f451364a = null;
    private final int mode;

    public static PoiSkinMode valueOf(String r100) {
        return (PoiSkinMode) a.a(PoiSkinMode.class, r100);
    }

    public static PoiSkinMode[] values() {
        return (PoiSkinMode[]) f451364a.clone();
    }

    static {
        PoiSkinMode r100 = new PoiSkinMode("AUTO_SKIN", 0, 0);
        AUTO_SKIN = r100;
        PoiSkinMode r101 = new PoiSkinMode("FORCE_WHITE", 1, 1);
        FORCE_WHITE = r101;
        PoiSkinMode r102 = new PoiSkinMode("FORCE_NIGHT", 2, 2);
        FORCE_NIGHT = r102;
        f451364a = new PoiSkinMode[]{r100, r101, r102};
    }

    public final int getMode() {
        return this.mode;
    }

    public PoiSkinMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.mode = r102;
    }

    public /* synthetic */ PoiSkinMode(String r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = 0;
    L5:
        this(r100, r101, r102);
    }
}
