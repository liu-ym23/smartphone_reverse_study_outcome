package com.bytedance.ee.bear.list.offlinecache;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.google.gson.annotations.SerializedName;
import du5.b;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/list/offlinecache/UpdateStatusRequest;", "Ljava/io/Serializable;", ResourceData.KEY_TOKEN, "", "objType", "", "action", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getToken", "()Ljava/lang/String;", "getObjType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAction", "toString", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/ee/bear/list/offlinecache/UpdateStatusRequest;", "equals", "", "other", "", "hashCode", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateStatusRequest implements Serializable {
    private final Integer action;

    @SerializedName("obj_type")
    private final Integer objType;
    private final String token;

    public static /* synthetic */ UpdateStatusRequest copy$default(UpdateStatusRequest r0, String r1, Integer r2, Integer r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.token;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.objType;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.action;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.token;
    }

    public final Integer component2() {
        return this.objType;
    }

    public final Integer component3() {
        return this.action;
    }

    public final UpdateStatusRequest copy(String r2, Integer r3, Integer r4) {
        return new UpdateStatusRequest(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UpdateStatusRequest) == true) goto L8;
        return false;
    L8:
        UpdateStatusRequest r6 = (UpdateStatusRequest) r5;
        if (Intrinsics.areEqual(this.token, r6.token) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.objType, r6.objType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.action, r6.action) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.token;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.objType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.action;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "UpdateStatusRequest(token='" + b.i(this.token) + "', objType=" + this.objType + ", action=" + this.action + ')';
    }

    public final Integer getAction() {
        return this.action;
    }

    public final Integer getObjType() {
        return this.objType;
    }

    public final String getToken() {
        return this.token;
    }

    public UpdateStatusRequest(String r1, Integer r2, Integer r3) {
        this.token = r1;
        this.objType = r2;
        this.action = r3;
    }

    public /* synthetic */ UpdateStatusRequest(String r1, Integer r2, Integer r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = 0;
    L5:
        this(r1, r2, r3);
    }
}
