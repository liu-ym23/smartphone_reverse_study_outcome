package com.bytedance.locallife.dito.host.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/dito/host/ui/LoadingShowStyle;", "", "", "style", "I", "getStyle", "()I", "DOUBLE_BALL", "LOCAL_LIFE", "LOCAL_LIFE_WITH_DOUBLE_BALL", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum LoadingShowStyle extends Enum<LoadingShowStyle> {
    public static final LoadingShowStyle DOUBLE_BALL = null;
    public static final LoadingShowStyle LOCAL_LIFE = null;
    public static final LoadingShowStyle LOCAL_LIFE_WITH_DOUBLE_BALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadingShowStyle[] f258314a = null;
    private final int style;

    public static LoadingShowStyle valueOf(String r100) {
        return (LoadingShowStyle) a.a(LoadingShowStyle.class, r100);
    }

    public static LoadingShowStyle[] values() {
        return (LoadingShowStyle[]) f258314a.clone();
    }

    static {
        LoadingShowStyle r100 = new LoadingShowStyle("DOUBLE_BALL", 0, 0);
        DOUBLE_BALL = r100;
        LoadingShowStyle r101 = new LoadingShowStyle("LOCAL_LIFE", 1, 1);
        LOCAL_LIFE = r101;
        LoadingShowStyle r102 = new LoadingShowStyle("LOCAL_LIFE_WITH_DOUBLE_BALL", 2, 2);
        LOCAL_LIFE_WITH_DOUBLE_BALL = r102;
        f258314a = new LoadingShowStyle[]{r100, r101, r102};
    }

    public final int getStyle() {
        return this.style;
    }

    public LoadingShowStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.style = r102;
    }

    public /* synthetic */ LoadingShowStyle(String r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = 0;
    L5:
        this(r100, r101, r102);
    }
}
