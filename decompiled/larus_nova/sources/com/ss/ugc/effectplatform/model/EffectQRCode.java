package com.ss.ugc.effectplatform.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/ss/ugc/effectplatform/model/EffectQRCode;", "", "qrCodeText", "", "(Ljava/lang/String;)V", "getQrCodeText", "()Ljava/lang/String;", "setQrCodeText", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class EffectQRCode {
    private String qrCodeText;

    /* JADX WARN: Multi-variable type inference failed */
    public EffectQRCode() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public String getQrCodeText() {
        return this.qrCodeText;
    }

    public EffectQRCode(String r100) {
        this.qrCodeText = r100;
    }

    public void setQrCodeText(String r100) {
        this.qrCodeText = r100;
    }

    public /* synthetic */ EffectQRCode(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "";
    L5:
        this(r100);
    }
}
