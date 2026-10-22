package com.bytedance.ee.bear.bitable.toast;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toast/ToastTypeEnum;", "", "imageRes", "", "<init>", "(Ljava/lang/String;II)V", "getImageRes", "()I", EffectConstants.NORMAL, "LOADING", "FAIL", "SUCCESS", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ToastTypeEnum extends Enum<ToastTypeEnum> {
    public static final ToastTypeEnum FAIL = null;
    public static final ToastTypeEnum LOADING = null;
    public static final ToastTypeEnum NORMAL = null;
    public static final ToastTypeEnum SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ToastTypeEnum[] f215977a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f215978b = null;
    private final int imageRes;

    public static EnumEntries<ToastTypeEnum> getEntries() {
        return f215978b;
    }

    static {
        ToastTypeEnum r100 = new ToastTypeEnum(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        ToastTypeEnum r101 = new ToastTypeEnum("LOADING", 1);
        LOADING = r101;
        ToastTypeEnum r102 = new ToastTypeEnum("FAIL", 2);
        FAIL = r102;
        ToastTypeEnum r103 = new ToastTypeEnum("SUCCESS", 3);
        SUCCESS = r103;
        ToastTypeEnum[] r104 = {r100, r101, r102, r103};
        f215977a = r104;
        f215978b = EnumEntriesKt.enumEntries(r104);
    }

    public static ToastTypeEnum[] values() {
        return (ToastTypeEnum[]) f215977a.clone();
    }

    public final int getImageRes() {
        return this.imageRes;
    }

    public static ToastTypeEnum valueOf(String r100) {
        return (ToastTypeEnum) r27.a.a(ToastTypeEnum.class, r100);
    }

    public ToastTypeEnum(String r100, int r101) {
        super(r100, r101);
        this.imageRes = -1;
    }
}
