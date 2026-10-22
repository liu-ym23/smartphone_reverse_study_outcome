package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.model.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B5\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\n\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\"\u0010\u0007\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/AddCustomizedEffectResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "getResponseData", "", "getResponseMessage", "", "getStatusCode", "status_code", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "effectZipPath", "getEffectZipPath", "setEffectZipPath", "iconPath", "getIconPath", "setIconPath", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public class AddCustomizedEffectResponse extends e<AddCustomizedEffectResponse> {
    private String effectZipPath;
    private String iconPath;
    private String message;
    private int status_code;

    public AddCustomizedEffectResponse() {
        this(0, null, null, null, 15, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ss.ugc.effectplatform.model.e
    public AddCustomizedEffectResponse getResponseData() {
        return this;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public /* bridge */ /* synthetic */ AddCustomizedEffectResponse getResponseData() {
        return getResponseData();
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public String getResponseMessage() {
        return getMessage();
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public int getStatusCode() {
        return getStatus_code();
    }

    public String getEffectZipPath() {
        return this.effectZipPath;
    }

    public String getIconPath() {
        return this.iconPath;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatus_code() {
        return this.status_code;
    }

    public void setEffectZipPath(String r100) {
        this.effectZipPath = r100;
    }

    public void setIconPath(String r100) {
        this.iconPath = r100;
    }

    public void setMessage(String r100) {
        this.message = r100;
    }

    public void setStatus_code(int r100) {
        this.status_code = r100;
    }

    public AddCustomizedEffectResponse(int r100, String r101, String r102, String r103) {
        this.status_code = r100;
        this.message = r101;
        this.effectZipPath = r102;
        this.iconPath = r103;
    }

    public /* synthetic */ AddCustomizedEffectResponse(int r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
