package com.bytedance.ee.bear.bitable.filter.step;

import com.byted.cast.common.TeaEventTrack;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\b\u0010\n\u001a\u0004\u0018\u00010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\f\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\u0010R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/step/EFilterStep;", "", "<init>", "(Ljava/lang/String;I)V", "Field", "Operator", "Value", "subValueStep", "Lcom/bytedance/ee/bear/bitable/filter/step/EFilterStep$SubValueStep;", "setSubValueStep", "getSubValueStep", "previous", "shouldHandleSubValueStep", "", TeaEventTrack.ACTION_DRAMA_NEXT, "getReportText", "", "SubValueStep", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EFilterStep extends Enum<EFilterStep> {
    public static final EFilterStep Field = null;
    public static final EFilterStep Operator = null;
    public static final EFilterStep Value = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EFilterStep[] f211885a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f211886b = null;
    private SubValueStep subValueStep;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/step/EFilterStep$SubValueStep;", "", "<init>", "(Ljava/lang/String;I)V", "Duration", "ExactDate", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SubValueStep extends Enum<SubValueStep> {
        public static final SubValueStep Duration = null;
        public static final SubValueStep ExactDate = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SubValueStep[] f211887a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f211888b = null;

        public static EnumEntries<SubValueStep> getEntries() {
            return f211888b;
        }

        static {
            SubValueStep r100 = new SubValueStep("Duration", 0);
            Duration = r100;
            SubValueStep r101 = new SubValueStep("ExactDate", 1);
            ExactDate = r101;
            SubValueStep[] r102 = {r100, r101};
            f211887a = r102;
            f211888b = EnumEntriesKt.enumEntries(r102);
        }

        public static SubValueStep[] values() {
            return (SubValueStep[]) f211887a.clone();
        }

        public static SubValueStep valueOf(String r100) {
            return (SubValueStep) r27.a.a(SubValueStep.class, r100);
        }

        public SubValueStep(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f211889a = null;

        static {
            int[] r100 = new int[EFilterStep.values().length];
            r100[EFilterStep.Field.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[EFilterStep.Operator.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[EFilterStep.Value.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f211889a = r100;
        }
    }

    public static EnumEntries<EFilterStep> getEntries() {
        return f211886b;
    }

    static {
        EFilterStep r100 = new EFilterStep("Field", 0);
        Field = r100;
        EFilterStep r101 = new EFilterStep("Operator", 1);
        Operator = r101;
        EFilterStep r102 = new EFilterStep("Value", 2);
        Value = r102;
        EFilterStep[] r103 = {r100, r101, r102};
        f211885a = r103;
        f211886b = EnumEntriesKt.enumEntries(r103);
    }

    public static EFilterStep[] values() {
        return (EFilterStep[]) f211885a.clone();
    }

    public final String getReportText() {
        int r100 = a.f211889a[ordinal()];
        if (r100 != 1) goto L5;
        return "field";
    L5:
        if (r100 != 2) goto L7;
        return WikiFolderPushPlugin.OPT;
    L7:
        if (r100 != 3) goto L10;
        return "input";
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final SubValueStep getSubValueStep() {
        return this.subValueStep;
    }

    public static EFilterStep valueOf(String r100) {
        return (EFilterStep) r27.a.a(EFilterStep.class, r100);
    }

    public final EFilterStep next(boolean r100) {
        if (r100 == false) goto L17;
        EFilterStep[] r101 = values();
        EFilterStep r102 = Value;
        if (this == r101[r102.ordinal() - 1]) goto L6;
        if (this != r102) goto L17;
        if (this.subValueStep == ArraysKt.last(SubValueStep.values())) goto L17;
        SubValueStep r103 = this.subValueStep;
        if (r103 == null) goto L13;
        int r104 = r103.ordinal();
    L15:
        return r102.setSubValueStep(SubValueStep.values()[r104 + 1]);
    L13:
        r104 = -1;
        goto L15
    L6:
        return r102.setSubValueStep(SubValueStep.values()[0]);
    L17:
        if (ordinal() < (values().length - 1)) goto L19;
        return null;
    L19:
        return values()[ordinal() + 1].setSubValueStep(null);
    }

    public final EFilterStep previous(boolean r100) {
        if (r100 == false) goto L12;
        EFilterStep r101 = Value;
        if (this != r101) goto L12;
        SubValueStep r102 = this.subValueStep;
        if (r102 == null) goto L12;
        if (r102 == ArraysKt.first(SubValueStep.values())) goto L12;
        SubValueStep[] r103 = SubValueStep.values();
        SubValueStep r104 = this.subValueStep;
        Intrinsics.checkNotNull(r104);
        return r101.setSubValueStep(r103[r104.ordinal() - 1]);
    L12:
        if (ordinal() > 0) goto L14;
        return null;
    L14:
        return values()[ordinal() - 1].setSubValueStep(null);
    }

    public final EFilterStep setSubValueStep(SubValueStep r100) {
        if (this != Value) goto L5;
        this.subValueStep = r100;
    L5:
        return this;
    }

    public EFilterStep(String r100, int r101) {
        super(r100, r101);
    }

    public static /* synthetic */ EFilterStep next$default(EFilterStep r100, boolean r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L7;
        r101 = false;
    L7:
        return r100.next(r101);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: next");
    }

    public static /* synthetic */ EFilterStep previous$default(EFilterStep r100, boolean r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L7;
        r101 = false;
    L7:
        return r100.previous(r101);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: previous");
    }
}
