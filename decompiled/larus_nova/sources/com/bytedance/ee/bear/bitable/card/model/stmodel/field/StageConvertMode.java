package com.bytedance.ee.bear.bitable.card.model.stmodel.field;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/StageConvertMode;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NextStage", "StartStage", "NextStageWhenSequenceNoChange", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StageConvertMode extends Enum<StageConvertMode> {
    public static final a Companion = null;
    public static final StageConvertMode NextStage = null;
    public static final StageConvertMode NextStageWhenSequenceNoChange = null;
    public static final StageConvertMode StartStage = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StageConvertMode[] f207130a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f207131b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<StageConvertMode> getEntries() {
        return f207131b;
    }

    static {
        StageConvertMode r100 = new StageConvertMode("NextStage", 0, "NextStage");
        NextStage = r100;
        StageConvertMode r101 = new StageConvertMode("StartStage", 1, "StartStage");
        StartStage = r101;
        StageConvertMode r102 = new StageConvertMode("NextStageWhenSequenceNoChange", 2, "NextStageWhenSequenceNoChange");
        NextStageWhenSequenceNoChange = r102;
        StageConvertMode[] r103 = {r100, r101, r102};
        f207130a = r103;
        f207131b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static StageConvertMode[] values() {
        return (StageConvertMode[]) f207130a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @JvmStatic
    public static final StageConvertMode lookup(String r100) {
        Companion.getClass();
        StageConvertMode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        StageConvertMode r104 = r101[r103];
        if (Intrinsics.areEqual(r104.getValue(), r100) == true) goto L12;
        r103 = r103 + 1;
        goto L3
    L12:
        return r104;
    L8:
        return null;
    }

    public static StageConvertMode valueOf(String r100) {
        return (StageConvertMode) r27.a.a(StageConvertMode.class, r100);
    }

    public StageConvertMode(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
