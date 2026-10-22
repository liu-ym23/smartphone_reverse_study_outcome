package com.bytedance.locallife.dito.host.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/dito/host/ui/LoadingMode;", "", "", "mode", "I", "getMode", "()I", "FORCE_DOUBLE_BALL", "LOCAL_LIFE_FULL_SCREEN", "LOCAL_LIFE_LOAD_MORE", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum LoadingMode extends Enum<LoadingMode> {
    public static final LoadingMode FORCE_DOUBLE_BALL = null;
    public static final LoadingMode LOCAL_LIFE_FULL_SCREEN = null;
    public static final LoadingMode LOCAL_LIFE_LOAD_MORE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadingMode[] f258313a = null;
    private final int mode;

    public static LoadingMode valueOf(String r100) {
        return (LoadingMode) a.a(LoadingMode.class, r100);
    }

    public static LoadingMode[] values() {
        return (LoadingMode[]) f258313a.clone();
    }

    static {
        LoadingMode r100 = new LoadingMode("FORCE_DOUBLE_BALL", 0, 0);
        FORCE_DOUBLE_BALL = r100;
        LoadingMode r101 = new LoadingMode("LOCAL_LIFE_FULL_SCREEN", 1, 1);
        LOCAL_LIFE_FULL_SCREEN = r101;
        LoadingMode r102 = new LoadingMode("LOCAL_LIFE_LOAD_MORE", 2, 2);
        LOCAL_LIFE_LOAD_MORE = r102;
        f258313a = new LoadingMode[]{r100, r101, r102};
    }

    public final int getMode() {
        return this.mode;
    }

    public LoadingMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.mode = r102;
    }

    public /* synthetic */ LoadingMode(String r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = 0;
    L5:
        this(r100, r101, r102);
    }
}
