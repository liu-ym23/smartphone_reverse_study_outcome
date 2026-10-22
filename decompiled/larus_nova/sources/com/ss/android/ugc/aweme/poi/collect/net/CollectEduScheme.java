package com.ss.android.ugc.aweme.poi.collect.net;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/collect/net/CollectEduScheme;", "Ljava/io/Serializable;", "forDialog", "", "forToast", "(Ljava/lang/String;Ljava/lang/String;)V", "getForDialog", "()Ljava/lang/String;", "getForToast", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CollectEduScheme implements Serializable {

    @SerializedName("gif_btn")
    private final String forDialog;

    @SerializedName("bar")
    private final String forToast;

    /* JADX WARN: Multi-variable type inference failed */
    public CollectEduScheme() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CollectEduScheme copy$default(CollectEduScheme r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.forDialog;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.forToast;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.forDialog;
    }

    public final String component2() {
        return this.forToast;
    }

    public final CollectEduScheme copy(String r100, String r101) {
        return new CollectEduScheme(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CollectEduScheme) == true) goto L8;
        return false;
    L8:
        CollectEduScheme r101 = (CollectEduScheme) r100;
        if (Intrinsics.areEqual(this.forDialog, r101.forDialog) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.forToast, r101.forToast) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.forDialog;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.forToast;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CollectEduScheme(forDialog=" + this.forDialog + ", forToast=" + this.forToast + ')';
    }

    public final String getForDialog() {
        return this.forDialog;
    }

    public final String getForToast() {
        return this.forToast;
    }

    public CollectEduScheme(String r100, String r101) {
        this.forDialog = r100;
        this.forToast = r101;
    }

    public /* synthetic */ CollectEduScheme(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
