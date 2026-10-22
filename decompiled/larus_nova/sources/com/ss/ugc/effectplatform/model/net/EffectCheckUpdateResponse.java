package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.model.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0014\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b$\u0010%J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\t\u0010\t\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0007HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/EffectCheckUpdateResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "", "getResponseData", "()Ljava/lang/Boolean;", "", "getResponseMessage", "", "getStatusCode", "component1", "component2", "component3", "updated", "message", "status_code", "copy", "toString", "hashCode", "", "other", "equals", "Z", "getUpdated", "()Z", "setUpdated", "(Z)V", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "<init>", "(ZLjava/lang/String;I)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class EffectCheckUpdateResponse extends e<Boolean> {
    private String message;
    private int status_code;
    private boolean updated;

    public EffectCheckUpdateResponse() {
        this(false, null, 0, 7, null);
    }

    public static /* synthetic */ EffectCheckUpdateResponse copy$default(EffectCheckUpdateResponse r100, boolean r101, String r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.updated;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.message;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.status_code;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.updated;
    }

    public final String component2() {
        return this.message;
    }

    public final int component3() {
        return this.status_code;
    }

    public final EffectCheckUpdateResponse copy(boolean r100, String r101, int r102) {
        return new EffectCheckUpdateResponse(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof EffectCheckUpdateResponse) == false) goto L12;
        EffectCheckUpdateResponse r101 = (EffectCheckUpdateResponse) r100;
        if (this.updated == r101.updated) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L10;
        return false;
    L10:
        if (this.status_code == r101.status_code) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean r100 = this.updated;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.message;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return ((r102 + r104) * 31) + this.status_code;
    L8:
        r104 = 0;
        goto L10
    }

    public String toString() {
        return "EffectCheckUpdateResponse(updated=" + this.updated + ", message=" + this.message + ", status_code=" + this.status_code + ")";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ss.ugc.effectplatform.model.e
    public Boolean getResponseData() {
        return Boolean.valueOf(this.updated);
    }

    public final String getMessage() {
        return this.message;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public String getResponseMessage() {
        return this.message;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public int getStatusCode() {
        return this.status_code;
    }

    public final int getStatus_code() {
        return this.status_code;
    }

    public final boolean getUpdated() {
        return this.updated;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public /* bridge */ /* synthetic */ Boolean getResponseData() {
        return getResponseData();
    }

    public final void setMessage(String r100) {
        this.message = r100;
    }

    public final void setStatus_code(int r100) {
        this.status_code = r100;
    }

    public final void setUpdated(boolean r100) {
        this.updated = r100;
    }

    public EffectCheckUpdateResponse(boolean r100, String r101, int r102) {
        this.updated = r100;
        this.message = r101;
        this.status_code = r102;
    }

    public /* synthetic */ EffectCheckUpdateResponse(boolean r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
