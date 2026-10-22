package com.ss.android.ugc.effectmanager.effect.model.template;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.ugc.effectplatform.model.net.CustomizedEffectsResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003R6\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR6\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/CustomizedEffectsResponseTemplate;", "Lcom/ss/ugc/effectplatform/model/net/CustomizedEffectsResponse;", "kCustomizedEffectsResponse", "(Lcom/ss/ugc/effectplatform/model/net/CustomizedEffectsResponse;)V", "value", "", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "customEffects", "getCustomEffects", "()Ljava/util/List;", "setCustomEffects", "(Ljava/util/List;)V", "getKCustomizedEffectsResponse", "()Lcom/ss/ugc/effectplatform/model/net/CustomizedEffectsResponse;", "templateEffects", "getTemplateEffects", "setTemplateEffects", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class CustomizedEffectsResponseTemplate extends CustomizedEffectsResponse {
    private List<? extends Effect> customEffects;
    private final transient CustomizedEffectsResponse kCustomizedEffectsResponse;
    private List<? extends Effect> templateEffects;

    /* JADX WARN: Multi-variable type inference failed */
    public CustomizedEffectsResponseTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public List<Effect> getCustomEffects() {
        CustomizedEffectsResponse r100 = getKCustomizedEffectsResponse();
        if (r100 == null) goto L7;
        List r101 = r100.getCustom_effects();
        List r102 = r101;
        if (r101 == null) goto L7;
    L8:
        List r103 = r102;
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L17;
        return null;
    L17:
        if ((ListProtector.get(r102, 0) instanceof Effect) == false) goto L22;
        if (r102 == null) goto L21;
        return r102;
    L21:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.ss.android.ugc.effectmanager.effect.model.Effect>");
    L22:
        List r105 = r102;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L24:
        if (r107.hasNext() == false) goto L26;
        r106.add(new Effect((com.ss.ugc.effectplatform.model.Effect) r107.next()));
        goto L24
    L26:
        if (r100 == null) goto L28;
        r100.setCustom_effects(r106);
    L28:
        super.setCustom_effects(r106);
        return r106;
    L11:
        if (r103.isEmpty() == true) goto L14;
        r104 = false;
    L7:
        r102 = super.getCustom_effects();
        goto L8
    }

    public List<Effect> getTemplateEffects() {
        CustomizedEffectsResponse r100 = getKCustomizedEffectsResponse();
        if (r100 == null) goto L7;
        List r101 = r100.getTemplate_effects();
        List r102 = r101;
        if (r101 == null) goto L7;
    L8:
        List r103 = r102;
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L17;
        return null;
    L17:
        if ((ListProtector.get(r102, 0) instanceof Effect) == false) goto L22;
        if (r102 == null) goto L21;
        return r102;
    L21:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.ss.android.ugc.effectmanager.effect.model.Effect>");
    L22:
        List r105 = r102;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L24:
        if (r107.hasNext() == false) goto L26;
        r106.add(new Effect((com.ss.ugc.effectplatform.model.Effect) r107.next()));
        goto L24
    L26:
        if (r100 == null) goto L28;
        r100.setTemplate_effects(r106);
    L28:
        super.setTemplate_effects(r106);
        return r106;
    L11:
        if (r103.isEmpty() == true) goto L14;
        r104 = false;
    L7:
        r102 = super.getTemplate_effects();
        goto L8
    }

    public CustomizedEffectsResponse getKCustomizedEffectsResponse() {
        return this.kCustomizedEffectsResponse;
    }

    public CustomizedEffectsResponseTemplate(CustomizedEffectsResponse r100) {
        super(0, null, null, null, 15, null);
        this.kCustomizedEffectsResponse = r100;
    }

    public void setCustomEffects(List<? extends Effect> r100) {
        this.customEffects = r100;
        CustomizedEffectsResponse r101 = getKCustomizedEffectsResponse();
        if (r101 == null) goto L5;
        r101.setCustom_effects(r100);
    L5:
        super.setCustom_effects(r100);
    }

    public void setTemplateEffects(List<? extends Effect> r100) {
        this.templateEffects = r100;
        CustomizedEffectsResponse r101 = getKCustomizedEffectsResponse();
        if (r101 == null) goto L5;
        r101.setTemplate_effects(r100);
    L5:
        super.setTemplate_effects(r100);
    }

    public /* synthetic */ CustomizedEffectsResponseTemplate(CustomizedEffectsResponse r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
