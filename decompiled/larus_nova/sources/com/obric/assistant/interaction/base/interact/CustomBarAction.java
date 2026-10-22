package com.obric.assistant.interaction.base.interact;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ8\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/interaction/base/interact/CustomBarAction;", "", "key", "", "uri", "errorMsg", "fileSize", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getKey", "()Ljava/lang/String;", "getUri", "getErrorMsg", "getFileSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/obric/assistant/interaction/base/interact/CustomBarAction;", "equals", "", "other", "hashCode", "", "toString", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomBarAction {
    private final String errorMsg;
    private final Long fileSize;
    private final String key;
    private final String uri;

    public static /* synthetic */ CustomBarAction copy$default(CustomBarAction r100, String r101, String r102, String r103, Long r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.key;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.uri;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.errorMsg;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.fileSize;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.uri;
    }

    public final String component3() {
        return this.errorMsg;
    }

    public final Long component4() {
        return this.fileSize;
    }

    public final CustomBarAction copy(@ObricCustomBarActionType String r100, String r101, String r102, Long r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r102, "errorMsg");
        return new CustomBarAction(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CustomBarAction) == true) goto L8;
        return false;
    L8:
        CustomBarAction r101 = (CustomBarAction) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.errorMsg, r101.errorMsg) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fileSize, r101.fileSize) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.key.hashCode() * 31) + this.uri.hashCode()) * 31) + this.errorMsg.hashCode()) * 31;
        Long r101 = this.fileSize;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "CustomBarAction(key=" + this.key + ", uri=" + this.uri + ", errorMsg=" + this.errorMsg + ", fileSize=" + this.fileSize + ')';
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final Long getFileSize() {
        return this.fileSize;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getUri() {
        return this.uri;
    }

    public CustomBarAction(@ObricCustomBarActionType String r100, String r101, String r102, Long r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r102, "errorMsg");
        this.key = r100;
        this.uri = r101;
        this.errorMsg = r102;
        this.fileSize = r103;
    }

    public /* synthetic */ CustomBarAction(String r100, String r101, String r102, Long r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = "";
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        this(r100, r101, r102, r103);
    }
}
