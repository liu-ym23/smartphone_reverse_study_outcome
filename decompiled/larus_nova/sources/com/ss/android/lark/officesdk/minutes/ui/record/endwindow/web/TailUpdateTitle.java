package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/TailUpdateTitle;", "Ljava/io/Serializable;", "titleName", "", "<init>", "(Ljava/lang/String;)V", "getTitleName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TailUpdateTitle implements Serializable {
    private final String titleName;

    public static /* synthetic */ TailUpdateTitle copy$default(TailUpdateTitle r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.titleName;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.titleName;
    }

    public final TailUpdateTitle copy(String r100) {
        Intrinsics.checkNotNullParameter(r100, "titleName");
        return new TailUpdateTitle(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TailUpdateTitle) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.titleName, ((TailUpdateTitle) r100).titleName) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.titleName.hashCode();
    }

    public String toString() {
        return "TailUpdateTitle(titleName=" + this.titleName + ')';
    }

    public final String getTitleName() {
        return this.titleName;
    }

    public TailUpdateTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "titleName");
        this.titleName = r100;
    }
}
