package com.ss.android.lark.biz.im.api.extension.keyboard.attachment;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/DoubaoFileInfo;", "Ljava/io/Serializable;", "resourceUri", "", "storageType", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getResourceUri", "()Ljava/lang/String;", "setResourceUri", "(Ljava/lang/String;)V", "getStorageType", "()Ljava/lang/Integer;", "setStorageType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/DoubaoFileInfo;", "equals", "", "other", "", "hashCode", "toString", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoFileInfo implements Serializable {

    @SerializedName("resource_uri")
    private String resourceUri;

    @SerializedName("storage_type")
    private Integer storageType;

    /* JADX WARN: Multi-variable type inference failed */
    public DoubaoFileInfo() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DoubaoFileInfo copy$default(DoubaoFileInfo r100, String r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.resourceUri;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.storageType;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.resourceUri;
    }

    public final Integer component2() {
        return this.storageType;
    }

    public final DoubaoFileInfo copy(String r100, Integer r101) {
        return new DoubaoFileInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoubaoFileInfo) == true) goto L8;
        return false;
    L8:
        DoubaoFileInfo r101 = (DoubaoFileInfo) r100;
        if (Intrinsics.areEqual(this.resourceUri, r101.resourceUri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.storageType, r101.storageType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.resourceUri;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.storageType;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "DoubaoFileInfo(resourceUri=" + this.resourceUri + ", storageType=" + this.storageType + ')';
    }

    public final String getResourceUri() {
        return this.resourceUri;
    }

    public final Integer getStorageType() {
        return this.storageType;
    }

    public final void setResourceUri(String r100) {
        this.resourceUri = r100;
    }

    public final void setStorageType(Integer r100) {
        this.storageType = r100;
    }

    public DoubaoFileInfo(String r100, Integer r101) {
        this.resourceUri = r100;
        this.storageType = r101;
    }

    public /* synthetic */ DoubaoFileInfo(String r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
