package com.bytedance.ee.bear.bitable.uikit;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/Constants$BlockType;", "", "<init>", "(Ljava/lang/String;I)V", "BITABLE_FOLDER", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Constants$BlockType extends Enum<Constants$BlockType> {
    public static final Constants$BlockType BITABLE_FOLDER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Constants$BlockType[] f216053a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f216054b = null;

    public static EnumEntries<Constants$BlockType> getEntries() {
        return f216054b;
    }

    static {
        Constants$BlockType r100 = new Constants$BlockType();
        BITABLE_FOLDER = r100;
        Constants$BlockType[] r101 = {r100};
        f216053a = r101;
        f216054b = EnumEntriesKt.enumEntries(r101);
    }

    public Constants$BlockType() {
        super("BITABLE_FOLDER", 0);
    }

    public static Constants$BlockType[] values() {
        return (Constants$BlockType[]) f216053a.clone();
    }

    public static Constants$BlockType valueOf(String r100) {
        return (Constants$BlockType) r27.a.a(Constants$BlockType.class, r100);
    }
}
