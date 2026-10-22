package com.bytedance.locallife.poi.view.mall.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/poi/view/mall/model/SelectorLevel;", "", "", "level", "Ljava/lang/String;", "getLevel", "()Ljava/lang/String;", "HEAD_TYPE", "SECOND_TYPE", "THIRD_TYPE", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum SelectorLevel extends Enum<SelectorLevel> {
    public static final SelectorLevel HEAD_TYPE = null;
    public static final SelectorLevel SECOND_TYPE = null;
    public static final SelectorLevel THIRD_TYPE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SelectorLevel[] f264267a = null;
    private final String level;

    public static SelectorLevel valueOf(String r100) {
        return (SelectorLevel) a.a(SelectorLevel.class, r100);
    }

    public static SelectorLevel[] values() {
        return (SelectorLevel[]) f264267a.clone();
    }

    static {
        SelectorLevel r100 = new SelectorLevel("HEAD_TYPE", 0, "head_tab");
        HEAD_TYPE = r100;
        SelectorLevel r101 = new SelectorLevel("SECOND_TYPE", 1, "second_tab");
        SECOND_TYPE = r101;
        SelectorLevel r102 = new SelectorLevel("THIRD_TYPE", 2, "third_tab");
        THIRD_TYPE = r102;
        f264267a = new SelectorLevel[]{r100, r101, r102};
    }

    public final String getLevel() {
        return this.level;
    }

    public SelectorLevel(String r100, int r101, String r102) {
        super(r100, r101);
        this.level = r102;
    }
}
