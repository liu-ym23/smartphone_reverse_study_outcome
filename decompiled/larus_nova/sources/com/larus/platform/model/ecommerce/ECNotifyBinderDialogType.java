package com.larus.platform.model.ecommerce;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/model/ecommerce/ECNotifyBinderDialogType;", "", "<init>", "(Ljava/lang/String;I)V", "CheckNeedBinder", "NotifyBinder", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ECNotifyBinderDialogType extends Enum<ECNotifyBinderDialogType> {
    public static final ECNotifyBinderDialogType CheckNeedBinder = null;
    public static final ECNotifyBinderDialogType NotifyBinder = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECNotifyBinderDialogType[] f365634a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365635b = null;

    public static EnumEntries<ECNotifyBinderDialogType> getEntries() {
        return f365635b;
    }

    static {
        ECNotifyBinderDialogType r100 = new ECNotifyBinderDialogType("CheckNeedBinder", 0);
        CheckNeedBinder = r100;
        ECNotifyBinderDialogType r101 = new ECNotifyBinderDialogType("NotifyBinder", 1);
        NotifyBinder = r101;
        ECNotifyBinderDialogType[] r102 = {r100, r101};
        f365634a = r102;
        f365635b = EnumEntriesKt.enumEntries(r102);
    }

    public static ECNotifyBinderDialogType[] values() {
        return (ECNotifyBinderDialogType[]) f365634a.clone();
    }

    public static ECNotifyBinderDialogType valueOf(String r100) {
        return (ECNotifyBinderDialogType) a.a(ECNotifyBinderDialogType.class, r100);
    }

    public ECNotifyBinderDialogType(String r100, int r101) {
        super(r100, r101);
    }
}
