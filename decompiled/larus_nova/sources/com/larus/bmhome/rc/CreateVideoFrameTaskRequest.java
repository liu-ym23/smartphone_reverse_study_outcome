package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/rc/CreateVideoFrameTaskRequest;", "", "uri", "", "configId", "", "<init>", "(Ljava/lang/String;I)V", "getUri", "()Ljava/lang/String;", "getConfigId", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateVideoFrameTaskRequest {

    @SerializedName("config_id")
    private final int configId;

    @SerializedName("uri")
    private final String uri;

    /* JADX WARN: Multi-variable type inference failed */
    public CreateVideoFrameTaskRequest() {
        String r100 = null;
        this(r100, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CreateVideoFrameTaskRequest copy$default(CreateVideoFrameTaskRequest r100, String r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.uri;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.configId;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.uri;
    }

    public final int component2() {
        return this.configId;
    }

    public final CreateVideoFrameTaskRequest copy(String r100, int r101) {
        return new CreateVideoFrameTaskRequest(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreateVideoFrameTaskRequest) == true) goto L8;
        return false;
    L8:
        CreateVideoFrameTaskRequest r101 = (CreateVideoFrameTaskRequest) r100;
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L12;
        return false;
    L12:
        if (this.configId == r101.configId) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.uri;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.configId;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "CreateVideoFrameTaskRequest(uri=" + this.uri + ", configId=" + this.configId + ')';
    }

    public final int getConfigId() {
        return this.configId;
    }

    public final String getUri() {
        return this.uri;
    }

    public CreateVideoFrameTaskRequest(String r100, int r101) {
        this.uri = r100;
        this.configId = r101;
    }

    public /* synthetic */ CreateVideoFrameTaskRequest(String r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
