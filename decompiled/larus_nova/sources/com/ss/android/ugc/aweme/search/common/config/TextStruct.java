package com.ss.android.ugc.aweme.search.common.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/TextStruct;", "", "", "text", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "textColor", "d", "setTextColor", "", "leftIconId", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "setLeftIconId", "(Ljava/lang/Integer;)V", "rightIconId", "b", "setRightIconId", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TextStruct {

    @SerializedName("left_icon_id")
    private Integer leftIconId;

    @SerializedName("right_icon_id")
    private Integer rightIconId;

    @SerializedName("text")
    private String text;

    @SerializedName("text_color")
    private String textColor;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TextStruct) == false) goto L14;
        TextStruct r101 = (TextStruct) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.leftIconId, r101.leftIconId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rightIconId, r101.rightIconId) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.textColor;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.leftIconId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.rightIconId;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TextStruct(text=" + this.text + ", textColor=" + this.textColor + ", leftIconId=" + this.leftIconId + ", rightIconId=" + this.rightIconId + ")";
    }

    public TextStruct() {
        this.text = null;
        this.textColor = null;
        this.leftIconId = null;
        this.rightIconId = null;
    }

    public final Integer a() {
        return this.leftIconId;
    }

    public final Integer b() {
        return this.rightIconId;
    }

    public final String c() {
        return this.text;
    }

    public final String d() {
        return this.textColor;
    }
}
