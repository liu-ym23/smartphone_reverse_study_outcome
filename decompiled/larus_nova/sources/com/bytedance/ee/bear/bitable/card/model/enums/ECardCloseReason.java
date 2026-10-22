package com.bytedance.ee.bear.bitable.card.model.enums;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/enums/ECardCloseReason;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "StageFieldInvalid", "Other", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ECardCloseReason extends Enum<ECardCloseReason> {
    public static final a Companion = null;
    public static final ECardCloseReason Other = null;
    public static final ECardCloseReason StageFieldInvalid = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECardCloseReason[] f207083a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f207084b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ECardCloseReason> getEntries() {
        return f207084b;
    }

    static {
        ECardCloseReason r100 = new ECardCloseReason("StageFieldInvalid", 0, "stageFieldInvalid");
        StageFieldInvalid = r100;
        ECardCloseReason r101 = new ECardCloseReason("Other", 1, "other");
        Other = r101;
        ECardCloseReason[] r102 = {r100, r101};
        f207083a = r102;
        f207084b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static ECardCloseReason[] values() {
        return (ECardCloseReason[]) f207083a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @JvmStatic
    public static final ECardCloseReason lookup(String r100) {
        Companion.getClass();
        ECardCloseReason[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        ECardCloseReason r104 = r101[r103];
        if (Intrinsics.areEqual(r104.getValue(), r100) == true) goto L12;
        r103 = r103 + 1;
        goto L3
    L12:
        return r104;
    L8:
        return null;
    }

    public static ECardCloseReason valueOf(String r100) {
        return (ECardCloseReason) r27.a.a(ECardCloseReason.class, r100);
    }

    public ECardCloseReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
