package com.bytedance.locallife.dito.host.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/dito/host/ui/SkinMode;", "", "", "mode", "I", "getMode", "()I", "AUTO_SKIN", "FORCE_WHITE", "FORCE_NIGHT", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum SkinMode extends Enum<SkinMode> {
    public static final SkinMode AUTO_SKIN = null;
    public static final SkinMode FORCE_NIGHT = null;
    public static final SkinMode FORCE_WHITE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SkinMode[] f258315a = null;
    private final int mode;

    public static SkinMode valueOf(String r100) {
        return (SkinMode) a.a(SkinMode.class, r100);
    }

    public static SkinMode[] values() {
        return (SkinMode[]) f258315a.clone();
    }

    static {
        SkinMode r100 = new SkinMode("AUTO_SKIN", 0, 0);
        AUTO_SKIN = r100;
        SkinMode r101 = new SkinMode("FORCE_WHITE", 1, 1);
        FORCE_WHITE = r101;
        SkinMode r102 = new SkinMode("FORCE_NIGHT", 2, 2);
        FORCE_NIGHT = r102;
        f258315a = new SkinMode[]{r100, r101, r102};
    }

    public final int getMode() {
        return this.mode;
    }

    public SkinMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.mode = r102;
    }

    public /* synthetic */ SkinMode(String r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = 0;
    L5:
        this(r100, r101, r102);
    }
}
