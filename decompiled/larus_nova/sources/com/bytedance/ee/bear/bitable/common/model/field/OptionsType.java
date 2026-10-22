package com.bytedance.ee.bear.bitable.common.model.field;

import com.ss.android.lark.banner.export.entity.BannerBizName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/model/field/OptionsType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "STATIC", BannerBizName.DYNAMIC, "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OptionsType extends Enum<OptionsType> {
    public static final OptionsType DYNAMIC = null;
    public static final OptionsType STATIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OptionsType[] f209861a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f209862b = null;
    private final int value;

    public static EnumEntries<OptionsType> getEntries() {
        return f209862b;
    }

    static {
        OptionsType r100 = new OptionsType("STATIC", 0, 0);
        STATIC = r100;
        OptionsType r101 = new OptionsType(BannerBizName.DYNAMIC, 1, 1);
        DYNAMIC = r101;
        OptionsType[] r102 = {r100, r101};
        f209861a = r102;
        f209862b = EnumEntriesKt.enumEntries(r102);
    }

    public static OptionsType[] values() {
        return (OptionsType[]) f209861a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static OptionsType valueOf(String r100) {
        return (OptionsType) a.a(OptionsType.class, r100);
    }

    public OptionsType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
