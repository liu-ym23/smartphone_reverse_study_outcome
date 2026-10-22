package com.ss.android.ugc.aweme.poi.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/model/RateDiggHint;", "Ljava/io/Serializable;", "showDiggHint", "", "hintText", "", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "getHintText", "()Ljava/lang/String;", "setHintText", "(Ljava/lang/String;)V", "getShowDiggHint", "()Ljava/lang/Boolean;", "setShowDiggHint", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;)Lcom/ss/android/ugc/aweme/poi/model/RateDiggHint;", "equals", "other", "", "hashCode", "", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class RateDiggHint implements Serializable {

    @SerializedName("hint_text")
    private String hintText;

    @SerializedName("show_digg_hint")
    private Boolean showDiggHint;

    /* JADX WARN: Multi-variable type inference failed */
    public RateDiggHint() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RateDiggHint copy$default(RateDiggHint r100, Boolean r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.showDiggHint;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.hintText;
    L9:
        return r100.copy(r101, r102);
    }

    public final Boolean component1() {
        return this.showDiggHint;
    }

    public final String component2() {
        return this.hintText;
    }

    public final RateDiggHint copy(Boolean r100, String r101) {
        return new RateDiggHint(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RateDiggHint) == true) goto L8;
        return false;
    L8:
        RateDiggHint r101 = (RateDiggHint) r100;
        if (Intrinsics.areEqual(this.showDiggHint, r101.showDiggHint) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.hintText, r101.hintText) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.showDiggHint;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.hintText;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "RateDiggHint(showDiggHint=" + this.showDiggHint + ", hintText=" + this.hintText + ')';
    }

    public final String getHintText() {
        return this.hintText;
    }

    public final Boolean getShowDiggHint() {
        return this.showDiggHint;
    }

    public final void setHintText(String r100) {
        this.hintText = r100;
    }

    public final void setShowDiggHint(Boolean r100) {
        this.showDiggHint = r100;
    }

    public RateDiggHint(Boolean r100, String r101) {
        this.showDiggHint = r100;
        this.hintText = r101;
    }

    public /* synthetic */ RateDiggHint(Boolean r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = Boolean.FALSE;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
