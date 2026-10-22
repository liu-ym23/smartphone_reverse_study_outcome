package com.bytedance.ee.bear.bitable.toast;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toast/ToastTypeEnum;", "", "imageRes", "", "<init>", "(Ljava/lang/String;II)V", "getImageRes", "()I", "NORMAL", "LOADING", "FAIL", "SUCCESS", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ToastTypeEnum extends Enum<ToastTypeEnum> {
    public static final ToastTypeEnum FAIL = null;
    public static final ToastTypeEnum LOADING = null;
    public static final ToastTypeEnum NORMAL = null;
    public static final ToastTypeEnum SUCCESS = null;
    public static final /* synthetic */ ToastTypeEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int imageRes;

    public static EnumEntries<ToastTypeEnum> getEntries() {
        return b;
    }

    static {
        ToastTypeEnum r0 = new ToastTypeEnum("NORMAL", 0);
        NORMAL = r0;
        ToastTypeEnum r1 = new ToastTypeEnum("LOADING", 1);
        LOADING = r1;
        ToastTypeEnum r3 = new ToastTypeEnum("FAIL", 2);
        FAIL = r3;
        ToastTypeEnum r5 = new ToastTypeEnum("SUCCESS", 3);
        SUCCESS = r5;
        ToastTypeEnum[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ToastTypeEnum[] values() {
        return (ToastTypeEnum[]) a.clone();
    }

    public final int getImageRes() {
        return this.imageRes;
    }

    public static ToastTypeEnum valueOf(String r1) {
        return (ToastTypeEnum) r27.a.a(ToastTypeEnum.class, r1);
    }

    public ToastTypeEnum(String r1, int r2) {
        super(r1, r2);
        this.imageRes = -1;
    }
}
