package com.ss.android.ugc.aweme.search.common.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/ActionStyle;", "", "", "color", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "text", "c", "", "enable", "Z", "b", "()Z", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActionStyle {

    @SerializedName("color")
    private String color;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("text")
    private final String text;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ActionStyle) == false) goto L12;
        ActionStyle r101 = (ActionStyle) r100;
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L10;
        return false;
    L10:
        if (this.enable == r101.enable) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.color;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.text;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.enable;
        ?? r107 = r106;
        if (r106 == false) goto L13;
        r107 = 1;
    L13:
        return r105 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ActionStyle(color=" + this.color + ", text=" + this.text + ", enable=" + this.enable + ")";
    }

    public ActionStyle() {
        Intrinsics.checkNotNullParameter("#161823", "color");
        this.color = "#161823";
        this.text = "搜索";
        this.enable = false;
    }

    public final String a() {
        return this.color;
    }

    public final boolean b() {
        return this.enable;
    }

    public final String c() {
        return this.text;
    }
}
