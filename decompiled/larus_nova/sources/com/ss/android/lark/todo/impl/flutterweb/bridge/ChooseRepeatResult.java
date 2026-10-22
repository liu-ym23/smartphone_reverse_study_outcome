package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.ss.android.lark.diskmanage.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u0003H\u0016J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/ChooseRepeatResult;", "Lcom/ss/android/lark/diskmanage/NonProguard;", "rrule", "", "rruleText", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getRrule", "()Ljava/lang/String;", "getRruleText", "toString", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChooseRepeatResult implements NonProguard {
    private final String rrule;
    private final String rruleText;

    public static /* synthetic */ ChooseRepeatResult copy$default(ChooseRepeatResult r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.rrule;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.rruleText;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.rrule;
    }

    public final String component2() {
        return this.rruleText;
    }

    public final ChooseRepeatResult copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "rrule");
        Intrinsics.checkNotNullParameter(r101, "rruleText");
        return new ChooseRepeatResult(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChooseRepeatResult) == true) goto L8;
        return false;
    L8:
        ChooseRepeatResult r101 = (ChooseRepeatResult) r100;
        if (Intrinsics.areEqual(this.rrule, r101.rrule) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rruleText, r101.rruleText) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.rrule.hashCode() * 31) + this.rruleText.hashCode();
    }

    public String toString() {
        return "ChooseRepeatResult(rrule='" + this.rrule + "', rruleText='" + this.rruleText + "')";
    }

    public final String getRrule() {
        return this.rrule;
    }

    public final String getRruleText() {
        return this.rruleText;
    }

    public ChooseRepeatResult(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "rrule");
        Intrinsics.checkNotNullParameter(r101, "rruleText");
        this.rrule = r100;
        this.rruleText = r101;
    }
}
