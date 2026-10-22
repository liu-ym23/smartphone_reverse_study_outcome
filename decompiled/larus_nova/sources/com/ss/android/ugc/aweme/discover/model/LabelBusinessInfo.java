package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/LabelBusinessInfo;", "Ljava/io/Serializable;", "notDisplayedDuringPlay", "", "(Z)V", "getNotDisplayedDuringPlay", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LabelBusinessInfo implements Serializable {

    @SerializedName("not_displayed_during_play")
    private final boolean notDisplayedDuringPlay;

    public LabelBusinessInfo() {
        boolean r100 = false;
        this(r100, 1, null);
    }

    public static /* synthetic */ LabelBusinessInfo copy$default(LabelBusinessInfo r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.notDisplayedDuringPlay;
    L6:
        return r100.copy(r101);
    }

    public final boolean component1() {
        return this.notDisplayedDuringPlay;
    }

    public final LabelBusinessInfo copy(boolean r100) {
        return new LabelBusinessInfo(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LabelBusinessInfo) == true) goto L6;
        return false;
    L6:
        if (this.notDisplayedDuringPlay == ((LabelBusinessInfo) r100).notDisplayedDuringPlay) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        boolean r100 = this.notDisplayedDuringPlay;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public String toString() {
        return "LabelBusinessInfo(notDisplayedDuringPlay=" + this.notDisplayedDuringPlay + ")";
    }

    public final boolean getNotDisplayedDuringPlay() {
        return this.notDisplayedDuringPlay;
    }

    public LabelBusinessInfo(boolean r100) {
        this.notDisplayedDuringPlay = r100;
    }

    public /* synthetic */ LabelBusinessInfo(boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = false;
    L5:
        this(r100);
    }
}
