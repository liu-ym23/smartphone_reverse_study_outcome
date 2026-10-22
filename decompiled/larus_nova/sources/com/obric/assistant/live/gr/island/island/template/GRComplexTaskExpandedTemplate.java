package com.obric.assistant.live.gr.island.island.template;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pea.k;
import pea.l;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0001,B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J.\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006-"}, d2 = {"Lcom/obric/assistant/live/gr/island/island/template/GRComplexTaskExpandedTemplate;", "Lcom/obric/assistant/live/gr/island/island/entity/ITemplateData;", "dialogue", "Lcom/obric/assistant/live/gr/island/island/template/GRExpandedDialogueTemplate;", "normal", "Lcom/obric/assistant/live/gr/island/island/template/GRExpandedNormalTemplate;", "showPro", "", "<init>", "(Lcom/obric/assistant/live/gr/island/island/template/GRExpandedDialogueTemplate;Lcom/obric/assistant/live/gr/island/island/template/GRExpandedNormalTemplate;Ljava/lang/Boolean;)V", "getDialogue", "()Lcom/obric/assistant/live/gr/island/island/template/GRExpandedDialogueTemplate;", "setDialogue", "(Lcom/obric/assistant/live/gr/island/island/template/GRExpandedDialogueTemplate;)V", "getNormal", "()Lcom/obric/assistant/live/gr/island/island/template/GRExpandedNormalTemplate;", "setNormal", "(Lcom/obric/assistant/live/gr/island/island/template/GRExpandedNormalTemplate;)V", "getShowPro", "()Ljava/lang/Boolean;", "setShowPro", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "create", "Lcom/obric/assistant/live/gr/island/island/entity/GRIslandWidget;", "isDefault", "(Ljava/lang/Boolean;)Lcom/obric/assistant/live/gr/island/island/entity/GRIslandWidget;", "getActions", "Landroid/os/Bundle;", "getPics", "toJSONObject", "Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", "(Lcom/obric/assistant/live/gr/island/island/template/GRExpandedDialogueTemplate;Lcom/obric/assistant/live/gr/island/island/template/GRExpandedNormalTemplate;Ljava/lang/Boolean;)Lcom/obric/assistant/live/gr/island/island/template/GRComplexTaskExpandedTemplate;", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GRComplexTaskExpandedTemplate implements l {
    public static final a Companion = null;
    public static final String TEMPLATE_ID = "com.obric.island_assistant:gr_complex_task_dialogue_island";
    private GRExpandedDialogueTemplate dialogue;
    private GRExpandedNormalTemplate normal;
    private Boolean showPro;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ GRComplexTaskExpandedTemplate copy$default(GRComplexTaskExpandedTemplate r100, GRExpandedDialogueTemplate r101, GRExpandedNormalTemplate r102, Boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.dialogue;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.normal;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.showPro;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final GRExpandedDialogueTemplate component1() {
        return this.dialogue;
    }

    public final GRExpandedNormalTemplate component2() {
        return this.normal;
    }

    public final Boolean component3() {
        return this.showPro;
    }

    public final GRComplexTaskExpandedTemplate copy(GRExpandedDialogueTemplate r100, GRExpandedNormalTemplate r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "dialogue");
        Intrinsics.checkNotNullParameter(r101, "normal");
        return new GRComplexTaskExpandedTemplate(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GRComplexTaskExpandedTemplate) == true) goto L8;
        return false;
    L8:
        GRComplexTaskExpandedTemplate r101 = (GRComplexTaskExpandedTemplate) r100;
        if (Intrinsics.areEqual(this.dialogue, r101.dialogue) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.normal, r101.normal) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.showPro, r101.showPro) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.dialogue.hashCode() * 31) + this.normal.hashCode()) * 31;
        Boolean r101 = this.showPro;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "GRComplexTaskExpandedTemplate(dialogue=" + this.dialogue + ", normal=" + this.normal + ", showPro=" + this.showPro + ')';
    }

    @Override // pea.l
    public Bundle getActions() {
        return new Bundle();
    }

    @Override // pea.l
    public Bundle getPics() {
        return new Bundle();
    }

    @Override // pea.l
    public JSONObject toJSONObject() {
        return new JSONObject();
    }

    public final GRExpandedDialogueTemplate getDialogue() {
        return this.dialogue;
    }

    public final GRExpandedNormalTemplate getNormal() {
        return this.normal;
    }

    public final Boolean getShowPro() {
        return this.showPro;
    }

    @Override // pea.l
    public k create(Boolean r100) {
        return new k(TEMPLATE_ID, this, r100);
    }

    public final void setDialogue(GRExpandedDialogueTemplate r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.dialogue = r100;
    }

    public final void setNormal(GRExpandedNormalTemplate r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.normal = r100;
    }

    public final void setShowPro(Boolean r100) {
        this.showPro = r100;
    }

    public GRComplexTaskExpandedTemplate(GRExpandedDialogueTemplate r100, GRExpandedNormalTemplate r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "dialogue");
        Intrinsics.checkNotNullParameter(r101, "normal");
        this.dialogue = r100;
        this.normal = r101;
        this.showPro = r102;
    }

    public /* synthetic */ GRComplexTaskExpandedTemplate(GRExpandedDialogueTemplate r100, GRExpandedNormalTemplate r101, Boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
