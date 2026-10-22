package com.ss.android.ugc.effectmanager.effect.model;

import com.ss.android.ugc.effectmanager.effect.model.template.DownloadEffectExtraTemplate;
import com.ss.ugc.effectplatform.model.a;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R(\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/DownloadEffectExtra;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/DownloadEffectExtraTemplate;", "Ljava/io/Serializable;", "Lcom/ss/ugc/effectplatform/model/a;", "kDownloadEffect", "Lcom/ss/ugc/effectplatform/model/a;", "getKDownloadEffect", "()Lcom/ss/ugc/effectplatform/model/a;", "", "value", "getPanel", "()Ljava/lang/String;", "setPanel", "(Ljava/lang/String;)V", "panel", "<init>", "(Lcom/ss/ugc/effectplatform/model/a;)V", "effectmanager_release"}, k = 1, mv = {1, 4, 0})
public final class DownloadEffectExtra extends DownloadEffectExtraTemplate implements Serializable {
    private final transient a kDownloadEffect;

    /* JADX WARN: Multi-variable type inference failed */
    public DownloadEffectExtra() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.ugc.effectplatform.model.a
    public String getPanel() {
        a r100 = getKDownloadEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getPanel();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getPanel();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.DownloadEffectExtraTemplate
    public a getKDownloadEffect() {
        return this.kDownloadEffect;
    }

    public DownloadEffectExtra(a r100) {
        super(r100);
        this.kDownloadEffect = r100;
        a r101 = getKDownloadEffect();
        if (r101 == null) goto L8;
        String r102 = r101.getPanel();
        if (r102 == null) goto L9;
        super.setPanel(r102);
        return;
    L9:
        return;
    }

    @Override // com.ss.ugc.effectplatform.model.a
    public void setPanel(String r100) {
        a r101 = getKDownloadEffect();
        if (r101 == null) goto L5;
        r101.setPanel(r100);
    L5:
        super.setPanel(r100);
    }

    public /* synthetic */ DownloadEffectExtra(a r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
