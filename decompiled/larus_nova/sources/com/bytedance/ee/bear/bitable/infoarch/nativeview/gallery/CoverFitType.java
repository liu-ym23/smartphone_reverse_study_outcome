package com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery;

import com.alibaba.gaiax.template.GXMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/CoverFitType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FIT", "CROP", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CoverFitType extends Enum<CoverFitType> {
    public static final CoverFitType CROP = null;
    public static final CoverFitType FIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CoverFitType[] f213438a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f213439b = null;
    private final String value;

    public static EnumEntries<CoverFitType> getEntries() {
        return f213439b;
    }

    static {
        CoverFitType r100 = new CoverFitType("FIT", 0, "fit");
        FIT = r100;
        CoverFitType r101 = new CoverFitType("CROP", 1, GXMode.MODE_TYPE_CROP);
        CROP = r101;
        CoverFitType[] r102 = {r100, r101};
        f213438a = r102;
        f213439b = EnumEntriesKt.enumEntries(r102);
    }

    public static CoverFitType[] values() {
        return (CoverFitType[]) f213438a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static CoverFitType valueOf(String r100) {
        return (CoverFitType) a.a(CoverFitType.class, r100);
    }

    public CoverFitType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
