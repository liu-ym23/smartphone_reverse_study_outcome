package com.ss.android.ugc.effectmanager.effect.model;

import com.ss.android.ugc.effectmanager.effect.model.template.EffectQRCodeTemplate;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/EffectQRCode;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/EffectQRCodeTemplate;", "Ljava/io/Serializable;", "kQrcode", "Lcom/ss/ugc/effectplatform/model/EffectQRCode;", "(Lcom/ss/ugc/effectplatform/model/EffectQRCode;)V", "getKQrcode", "()Lcom/ss/ugc/effectplatform/model/EffectQRCode;", "value", "", "qrCodeText", "getQrCodeText", "()Ljava/lang/String;", "setQrCodeText", "(Ljava/lang/String;)V", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class EffectQRCode extends EffectQRCodeTemplate implements Serializable {
    private final transient com.ss.ugc.effectplatform.model.EffectQRCode kQrcode;

    /* JADX WARN: Multi-variable type inference failed */
    public EffectQRCode() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectQRCode
    public String getQrCodeText() {
        com.ss.ugc.effectplatform.model.EffectQRCode r100 = getKQrcode();
        if (r100 == null) goto L8;
        String r101 = r100.getQrCodeText();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getQrCodeText();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectQRCodeTemplate
    public com.ss.ugc.effectplatform.model.EffectQRCode getKQrcode() {
        return this.kQrcode;
    }

    public EffectQRCode(com.ss.ugc.effectplatform.model.EffectQRCode r100) {
        super(r100);
        this.kQrcode = r100;
        com.ss.ugc.effectplatform.model.EffectQRCode r101 = getKQrcode();
        if (r101 == null) goto L8;
        String r102 = r101.getQrCodeText();
        if (r102 == null) goto L9;
        super.setQrCodeText(r102);
        return;
    L9:
        return;
    }

    @Override // com.ss.ugc.effectplatform.model.EffectQRCode
    public void setQrCodeText(String r100) {
        com.ss.ugc.effectplatform.model.EffectQRCode r101 = getKQrcode();
        if (r101 == null) goto L5;
        r101.setQrCodeText(r100);
    L5:
        super.setQrCodeText(r100);
    }

    public /* synthetic */ EffectQRCode(com.ss.ugc.effectplatform.model.EffectQRCode r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
