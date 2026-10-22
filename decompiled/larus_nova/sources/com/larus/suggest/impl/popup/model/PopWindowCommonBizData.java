package com.larus.suggest.impl.popup.model;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÂ\u0003J!\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\bHÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/larus/suggest/impl/popup/model/PopWindowCommonBizData;", "", "showMessageValue", "Lcom/google/gson/JsonElement;", "isSuccessValue", "<init>", "(Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;)V", "showMessage", "", "getShowMessage", "()Ljava/lang/String;", "isSuccess", "", "()Ljava/lang/Boolean;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopWindowCommonBizData {

    @SerializedName("is_success")
    private final JsonElement isSuccessValue;

    @SerializedName("show_message")
    private final JsonElement showMessageValue;

    /* JADX WARN: Multi-variable type inference failed */
    public PopWindowCommonBizData() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    private final JsonElement component1() {
        return this.showMessageValue;
    }

    private final JsonElement component2() {
        return this.isSuccessValue;
    }

    public static /* synthetic */ PopWindowCommonBizData copy$default(PopWindowCommonBizData r100, JsonElement r101, JsonElement r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.showMessageValue;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.isSuccessValue;
    L9:
        return r100.copy(r101, r102);
    }

    public final PopWindowCommonBizData copy(JsonElement r100, JsonElement r101) {
        return new PopWindowCommonBizData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PopWindowCommonBizData) == true) goto L8;
        return false;
    L8:
        PopWindowCommonBizData r101 = (PopWindowCommonBizData) r100;
        if (Intrinsics.areEqual(this.showMessageValue, r101.showMessageValue) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isSuccessValue, r101.isSuccessValue) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        JsonElement r100 = this.showMessageValue;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        JsonElement r104 = this.isSuccessValue;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PopWindowCommonBizData(showMessageValue=" + this.showMessageValue + ", isSuccessValue=" + this.isSuccessValue + ')';
    }

    public final String getShowMessage() {
        return a.a(this.showMessageValue);
    }

    public final Boolean isSuccess() {
        String r100 = a.a(this.isSuccessValue);
        if (r100 == null) goto L32;
        String r101 = StringsKt.trim(r100).toString();
        if (r101 == null) goto L32;
        String r102 = r101.toLowerCase(Locale.ROOT);
        if (r102 == null) goto L32;
        int r103 = r102.hashCode();
        if (r103 == 48) goto L29;
        if (r103 == 49) goto L25;
        if (r103 == 3569038) goto L22;
        if (r103 != 97196323) goto L32;
        if (r102.equals("false") == false) goto L32;
    L35:
        return Boolean.FALSE;
    L22:
        if (r102.equals("true") == false) goto L32;
    L34:
        return Boolean.TRUE;
    L25:
        if (r102.equals("1") == true) goto L34;
    L29:
        if (r102.equals("0") == true) goto L35;
    L32:
        return null;
    }

    public PopWindowCommonBizData(JsonElement r100, JsonElement r101) {
        this.showMessageValue = r100;
        this.isSuccessValue = r101;
    }

    public /* synthetic */ PopWindowCommonBizData(JsonElement r100, JsonElement r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
