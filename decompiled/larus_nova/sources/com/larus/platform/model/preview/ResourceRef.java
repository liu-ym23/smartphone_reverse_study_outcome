package com.larus.platform.model.preview;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006 "}, d2 = {"Lcom/larus/platform/model/preview/ResourceRef;", "Ljava/io/Serializable;", "uri", "", "kind", "Lcom/larus/platform/model/preview/ResourceRefKind;", "remoteKey", "width", "", "height", "<init>", "(Ljava/lang/String;Lcom/larus/platform/model/preview/ResourceRefKind;Ljava/lang/String;II)V", "getUri", "()Ljava/lang/String;", "getKind", "()Lcom/larus/platform/model/preview/ResourceRefKind;", "getRemoteKey", "getWidth", "()I", "getHeight", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceRef implements Serializable {
    private final int height;
    private final ResourceRefKind kind;
    private final String remoteKey;
    private final String uri;
    private final int width;

    public static /* synthetic */ ResourceRef copy$default(ResourceRef r100, String r101, ResourceRefKind r102, String r103, int r104, int r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.uri;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.kind;
    L8:
        ResourceRefKind r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.remoteKey;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.width;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.height;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.uri;
    }

    public final ResourceRefKind component2() {
        return this.kind;
    }

    public final String component3() {
        return this.remoteKey;
    }

    public final int component4() {
        return this.width;
    }

    public final int component5() {
        return this.height;
    }

    public final ResourceRef copy(String r100, ResourceRefKind r101, String r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "kind");
        return new ResourceRef(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResourceRef) == true) goto L8;
        return false;
    L8:
        ResourceRef r101 = (ResourceRef) r100;
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L12;
        return false;
    L12:
        if (this.kind == r101.kind) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.remoteKey, r101.remoteKey) == true) goto L18;
        return false;
    L18:
        if (this.width == r101.width) goto L21;
        return false;
    L21:
        if (this.height == r101.height) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.uri.hashCode() * 31) + this.kind.hashCode()) * 31;
        String r101 = this.remoteKey;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((r100 + r102) * 31) + this.width) * 31) + this.height;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "ResourceRef(uri=" + this.uri + ", kind=" + this.kind + ", remoteKey=" + this.remoteKey + ", width=" + this.width + ", height=" + this.height + ')';
    }

    public final int getHeight() {
        return this.height;
    }

    public final ResourceRefKind getKind() {
        return this.kind;
    }

    public final String getRemoteKey() {
        return this.remoteKey;
    }

    public final String getUri() {
        return this.uri;
    }

    public final int getWidth() {
        return this.width;
    }

    public ResourceRef(String r100, ResourceRefKind r101, String r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "kind");
        this.uri = r100;
        this.kind = r101;
        this.remoteKey = r102;
        this.width = r103;
        this.height = r104;
    }

    public /* synthetic */ ResourceRef(String r100, ResourceRefKind r101, String r102, int r110, int r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 2) == 0) goto L5;
        r101 = ResourceRefKind.LOCAL_URI;
    L5:
        ResourceRefKind r103 = r101;
        if ((r112 & 4) == 0) goto L8;
        r102 = null;
    L8:
        String r104 = r102;
        if ((r112 & 8) == 0) goto L11;
        int r105 = 0;
    L13:
        if ((r112 & 16) == 0) goto L15;
        int r106 = 0;
    L16:
        this(r100, r103, r104, r105, r106);
        return;
    L15:
        r106 = r111;
        goto L16
    L11:
        r105 = r110;
        goto L13
    }
}
