package com.ss.android.lark.chameleon.api;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chameleon/api/TitlebarConfig;", "Ljava/io/Serializable;", "showTitlebar", "", "titleType", "Lcom/ss/android/lark/chameleon/api/TitleType;", "(ZLcom/ss/android/lark/chameleon/api/TitleType;)V", "getShowTitlebar", "()Z", "setShowTitlebar", "(Z)V", "getTitleType", "()Lcom/ss/android/lark/chameleon/api/TitleType;", "setTitleType", "(Lcom/ss/android/lark/chameleon/api/TitleType;)V", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TitlebarConfig implements Serializable {
    private boolean showTitlebar;
    private TitleType titleType;

    /* JADX WARN: Multi-variable type inference failed */
    public TitlebarConfig() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TitlebarConfig copy$default(TitlebarConfig r100, boolean r101, TitleType r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.showTitlebar;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.titleType;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.showTitlebar;
    }

    public final TitleType component2() {
        return this.titleType;
    }

    public final TitlebarConfig copy(boolean r100, TitleType r101) {
        return new TitlebarConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TitlebarConfig) == true) goto L8;
        return false;
    L8:
        TitlebarConfig r101 = (TitlebarConfig) r100;
        if (this.showTitlebar == r101.showTitlebar) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.titleType, r101.titleType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean r100 = this.showTitlebar;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        TitleType r103 = this.titleType;
        if (r103 != null) goto L8;
        int r104 = 0;
    L10:
        return r102 + r104;
    L8:
        r104 = r103.hashCode();
        goto L10
    }

    public String toString() {
        return "TitlebarConfig(showTitlebar=" + this.showTitlebar + ", titleType=" + this.titleType + ')';
    }

    public final boolean getShowTitlebar() {
        return this.showTitlebar;
    }

    public final TitleType getTitleType() {
        return this.titleType;
    }

    public final void setShowTitlebar(boolean r100) {
        this.showTitlebar = r100;
    }

    public final void setTitleType(TitleType r100) {
        this.titleType = r100;
    }

    public TitlebarConfig(boolean r100, TitleType r101) {
        this.showTitlebar = r100;
        this.titleType = r101;
    }

    public /* synthetic */ TitlebarConfig(boolean r100, TitleType r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
