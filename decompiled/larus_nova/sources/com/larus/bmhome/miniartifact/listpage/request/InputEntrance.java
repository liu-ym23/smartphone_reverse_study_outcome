package com.larus.bmhome.miniartifact.listpage.request;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/miniartifact/listpage/request/InputEntrance;", "Ljava/io/Serializable;", "inputPreviewWebUrl", "", "<init>", "(Ljava/lang/String;)V", "getInputPreviewWebUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InputEntrance implements Serializable {

    @SerializedName("input_preview_web_url")
    private final String inputPreviewWebUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public InputEntrance() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ InputEntrance copy$default(InputEntrance r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.inputPreviewWebUrl;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.inputPreviewWebUrl;
    }

    public final InputEntrance copy(String r100) {
        return new InputEntrance(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InputEntrance) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.inputPreviewWebUrl, ((InputEntrance) r100).inputPreviewWebUrl) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r100 = this.inputPreviewWebUrl;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "InputEntrance(inputPreviewWebUrl=" + this.inputPreviewWebUrl + ')';
    }

    public final String getInputPreviewWebUrl() {
        return this.inputPreviewWebUrl;
    }

    public InputEntrance(String r100) {
        this.inputPreviewWebUrl = r100;
    }

    public /* synthetic */ InputEntrance(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
