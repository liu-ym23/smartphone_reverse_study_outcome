package com.bytedance.kmp.ec.yata.common.render;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/render/LayoutType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Banner", "yata-store-kmp_release"}, k = 1, mv = {1, 7, 0})
public final enum LayoutType extends Enum<LayoutType> {
    public static final LayoutType Banner = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LayoutType[] f251560a = null;
    private final String value;

    public LayoutType() {
        super("Banner", 0);
        this.value = "Banner";
    }

    public static LayoutType valueOf(String r100) {
        return (LayoutType) a.a(LayoutType.class, r100);
    }

    public static LayoutType[] values() {
        return (LayoutType[]) f251560a.clone();
    }

    static {
        LayoutType r100 = new LayoutType();
        Banner = r100;
        f251560a = new LayoutType[]{r100};
    }

    public final String getValue() {
        return this.value;
    }
}
