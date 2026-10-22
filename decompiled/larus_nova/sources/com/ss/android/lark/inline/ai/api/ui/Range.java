package com.ss.android.lark.inline.ai.api.ui;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0005H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/Range;", "Ljava/io/Serializable;", "show", "", "text", "", "enable", "suffixIcon", "<init>", "(ZLjava/lang/String;ZLjava/lang/String;)V", "getShow", "()Z", "getText", "()Ljava/lang/String;", "getEnable", "getSuffixIcon", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Range implements Serializable {
    private final boolean enable;
    private final boolean show;
    private final String suffixIcon;
    private final String text;

    public Range() {
        this(false, null, false, null, 15, null);
    }

    public static /* synthetic */ Range copy$default(Range r100, boolean r101, String r102, boolean r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.show;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.text;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.enable;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.suffixIcon;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.show;
    }

    public final String component2() {
        return this.text;
    }

    public final boolean component3() {
        return this.enable;
    }

    public final String component4() {
        return this.suffixIcon;
    }

    public final Range copy(boolean r100, String r101, boolean r102, String r103) {
        return new Range(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Range) == true) goto L8;
        return false;
    L8:
        Range r101 = (Range) r100;
        if (this.show == r101.show) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L15;
        return false;
    L15:
        if (this.enable == r101.enable) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.suffixIcon, r101.suffixIcon) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.show == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        String r103 = this.text;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        if (this.enable == true) goto L14;
        r100 = 1237;
    L14:
        int r107 = (r106 + r100) * 31;
        String r108 = this.suffixIcon;
        if (r108 == null) goto L19;
        r104 = r108.hashCode();
    L19:
        return r107 + r104;
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "Range(show=" + this.show + ", text=" + this.text + ", enable=" + this.enable + ", suffixIcon=" + this.suffixIcon + ')';
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final String getSuffixIcon() {
        return this.suffixIcon;
    }

    public final String getText() {
        return this.text;
    }

    public Range(boolean r100, String r101, boolean r102, String r103) {
        this.show = r100;
        this.text = r101;
        this.enable = r102;
        this.suffixIcon = r103;
    }

    public /* synthetic */ Range(boolean r100, String r101, boolean r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = "";
    L14:
        this(r100, r101, r102, r103);
    }
}
