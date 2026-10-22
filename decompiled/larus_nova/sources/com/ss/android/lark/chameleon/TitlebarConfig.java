package com.ss.android.lark.chameleon;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0000J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/chameleon/TitlebarConfig;", "Ljava/io/Serializable;", "showTitlebar", "", "titleType", "Lcom/ss/android/lark/chameleon/TitleType;", "<init>", "(ZLcom/ss/android/lark/chameleon/TitleType;)V", "getShowTitlebar", "()Z", "setShowTitlebar", "(Z)V", "getTitleType", "()Lcom/ss/android/lark/chameleon/TitleType;", "setTitleType", "(Lcom/ss/android/lark/chameleon/TitleType;)V", "copy", "toString", "", "component1", "component2", "equals", "other", "", "hashCode", "", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public int hashCode() {
        if (this.showTitlebar == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        TitleType r102 = this.titleType;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final TitlebarConfig copy() {
        boolean r100 = this.showTitlebar;
        TitleType r101 = this.titleType;
        if (r101 == null) goto L5;
        TitleType r102 = r101.copy();
    L7:
        return new TitlebarConfig(r100, r102);
    L5:
        r102 = null;
        goto L7
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
