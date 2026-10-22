package com.ss.android.ugc.effectmanager.effect.model.template;

import com.ss.ugc.effectplatform.model.EffectPanelModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/EffectPanelModelTemplate;", "Lcom/ss/ugc/effectplatform/model/EffectPanelModel;", "kPanelModel", "(Lcom/ss/ugc/effectplatform/model/EffectPanelModel;)V", "getKPanelModel", "()Lcom/ss/ugc/effectplatform/model/EffectPanelModel;", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class EffectPanelModelTemplate extends EffectPanelModel {
    private final transient EffectPanelModel kPanelModel;

    /* JADX WARN: Multi-variable type inference failed */
    public EffectPanelModelTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public EffectPanelModel getKPanelModel() {
        return this.kPanelModel;
    }

    public EffectPanelModelTemplate(EffectPanelModel r110) {
        super(null, null, null, null, null, null, 63, null);
        this.kPanelModel = r110;
    }

    public /* synthetic */ EffectPanelModelTemplate(EffectPanelModel r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
