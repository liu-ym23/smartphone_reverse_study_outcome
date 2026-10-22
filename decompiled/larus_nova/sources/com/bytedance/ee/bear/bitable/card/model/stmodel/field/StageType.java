package com.bytedance.ee.bear.bitable.card.model.stmodel.field;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/StageType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Default", "EndDone", "EndCancel", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StageType extends Enum<StageType> {
    public static final a Companion = null;
    public static final StageType Default = null;
    public static final StageType EndCancel = null;
    public static final StageType EndDone = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StageType[] f207135a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f207136b = null;
    private final String value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static StageType a(String r100) {
            StageType[] r101 = StageType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            StageType r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getValue(), r100) == true) goto L9;
            r103 = r103 + 1;
        L9:
            if (r104 == null) goto L11;
            return r104;
        L11:
            return StageType.Default;
        L8:
            r104 = null;
            goto L9
        }
    }

    public static EnumEntries<StageType> getEntries() {
        return f207136b;
    }

    @JvmStatic
    public static final StageType lookup(String r100) {
        Companion.getClass();
        return a.a(r100);
    }

    static {
        StageType r100 = new StageType("Default", 0, "Default");
        Default = r100;
        StageType r101 = new StageType("EndDone", 1, "EndDone");
        EndDone = r101;
        StageType r102 = new StageType("EndCancel", 2, "EndCancel");
        EndCancel = r102;
        StageType[] r103 = {r100, r101, r102};
        f207135a = r103;
        f207136b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static StageType[] values() {
        return (StageType[]) f207135a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static StageType valueOf(String r100) {
        return (StageType) r27.a.a(StageType.class, r100);
    }

    public StageType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
