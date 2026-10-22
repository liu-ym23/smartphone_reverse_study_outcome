package com.ss.android.lark.biz.core.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/biz/core/api/BaseCodeType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "QRCODE", "BARCODE", "qrcode-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BaseCodeType extends Enum<BaseCodeType> {
    public static final BaseCodeType BARCODE = null;
    public static final BaseCodeType QRCODE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BaseCodeType[] f409790a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f409791b = null;
    private final int value;

    public static EnumEntries<BaseCodeType> getEntries() {
        return f409791b;
    }

    static {
        BaseCodeType r100 = new BaseCodeType("QRCODE", 0, 0);
        QRCODE = r100;
        BaseCodeType r101 = new BaseCodeType("BARCODE", 1, 1);
        BARCODE = r101;
        BaseCodeType[] r102 = {r100, r101};
        f409790a = r102;
        f409791b = EnumEntriesKt.enumEntries(r102);
    }

    public static BaseCodeType[] values() {
        return (BaseCodeType[]) f409790a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static BaseCodeType valueOf(String r100) {
        return (BaseCodeType) a.a(BaseCodeType.class, r100);
    }

    public BaseCodeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
