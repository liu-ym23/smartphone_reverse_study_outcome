package com.ss.android.lark.export.entity;

import android.view.View;
import com.ss.android.lark.export.a;
import com.ss.android.lark.export.api.UrlPreviewApi;
import com.ss.android.lark.export.d;
import com.ss.android.lark.export.engine.EngineProperty;
import com.ss.android.lark.export.engine.TurtleCardEngineProperty;
import com.ss.android.lark.export.engine.smartcard.SmartCardEngineProperty;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.export.entity.preview.UrlPreviewComponent;
import com.ss.android.lark.export.entity.preview.UrlPreviewState;
import com.ss.android.lark.export.entity.preview.UrlPreviewTemplate;
import com.ss.android.lark.export.entity.turtle.TurtleCanvasEntity;
import com.ss.android.lark.export.parser.ModelParserRenderRouterEntity;
import com.ss.android.lark.tangram.base.props.Props;
import com.ss.android.lark.utils.ApiUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import q6c.e;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B=\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fB3\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u0010J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0000H\u0096\u0002J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010#\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0000H\u0016J\u0006\u0010$\u001a\u00020!J\u0012\u0010%\u001a\u00020!*\u00020&2\u0006\u0010'\u001a\u00020(J\n\u0010)\u001a\u00020!*\u00020&J\n\u0010*\u001a\u00020!*\u00020&J\u0006\u0010+\u001a\u00020!J\u0006\u0010,\u001a\u00020!J\b\u0010-\u001a\u0004\u0018\u00010.J\b\u0010/\u001a\u0004\u0018\u000100J\t\u00101\u001a\u00020\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u00104\u001a\u00020\u000bHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\rHÆ\u0003JA\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u00107\u001a\u00020!2\b\u0010\u001f\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020\u001eHÖ\u0001J\t\u0010:\u001a\u00020.HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006;"}, d2 = {"Lcom/ss/android/lark/export/entity/UrlCardPreviewEntity;", "Ljava/io/Serializable;", "", "Lcom/larksuite/framework/utils/diff/Diffable;", "inlineEntity", "Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;", "previewBody", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewBody;", "renderRouterEntity", "Lcom/ss/android/lark/export/entity/RenderRouterEntity;", "componentTreeTime", "", "extTranslateInfo", "Lcom/ss/android/lark/export/entity/ExtTranslateInfo;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;Lcom/ss/android/lark/export/entity/preview/UrlPreviewBody;Lcom/ss/android/lark/export/entity/RenderRouterEntity;JLcom/ss/android/lark/export/entity/ExtTranslateInfo;)V", "(Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;Lcom/ss/android/lark/export/entity/preview/UrlPreviewBody;Lcom/ss/android/lark/export/entity/RenderRouterEntity;J)V", "getInlineEntity", "()Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;", "getPreviewBody", "()Lcom/ss/android/lark/export/entity/preview/UrlPreviewBody;", "getRenderRouterEntity", "()Lcom/ss/android/lark/export/entity/RenderRouterEntity;", "getComponentTreeTime", "()J", "setComponentTreeTime", "(J)V", "getExtTranslateInfo", "()Lcom/ss/android/lark/export/entity/ExtTranslateInfo;", "compareTo", "", "other", "isItemSame", "", "diffable", "isContentSame", "isValidCardData", "engineFGIsEnable", "Lcom/ss/android/lark/export/engine/EngineProperty;", "engineType", "Lcom/ss/android/lark/export/engine/EngineProperty$EngineType;", "isMessageEngine", "isTurtleEngine", "isSmartCard", "isTurtleCard", "getTurtleScriptId", "", "getTurtleCanvasEntity", "Lcom/ss/android/lark/export/entity/turtle/TurtleCanvasEntity;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "hashCode", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlCardPreviewEntity implements Serializable, Comparable<UrlCardPreviewEntity>, b<UrlCardPreviewEntity> {
    private long componentTreeTime;
    private final ExtTranslateInfo extTranslateInfo;
    private final UrlInlinePreviewEntity inlineEntity;
    private final UrlPreviewBody previewBody;
    private final RenderRouterEntity renderRouterEntity;

    public static /* synthetic */ UrlCardPreviewEntity copy$default(UrlCardPreviewEntity r100, UrlInlinePreviewEntity r101, UrlPreviewBody r102, RenderRouterEntity r103, long r104, ExtTranslateInfo r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.inlineEntity;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.previewBody;
    L8:
        UrlPreviewBody r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.renderRouterEntity;
    L11:
        RenderRouterEntity r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.componentTreeTime;
    L14:
        long r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.extTranslateInfo;
    L17:
        UrlInlinePreviewEntity r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(UrlCardPreviewEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return 0;
    }

    public final UrlInlinePreviewEntity component1() {
        return this.inlineEntity;
    }

    public final UrlPreviewBody component2() {
        return this.previewBody;
    }

    public final RenderRouterEntity component3() {
        return this.renderRouterEntity;
    }

    public final long component4() {
        return this.componentTreeTime;
    }

    public final ExtTranslateInfo component5() {
        return this.extTranslateInfo;
    }

    public final UrlCardPreviewEntity copy(UrlInlinePreviewEntity r100, UrlPreviewBody r110, RenderRouterEntity r111, long r112, ExtTranslateInfo r113) {
        Intrinsics.checkNotNullParameter(r100, "inlineEntity");
        return new UrlCardPreviewEntity(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UrlCardPreviewEntity) == true) goto L8;
        return false;
    L8:
        UrlCardPreviewEntity r101 = (UrlCardPreviewEntity) r100;
        if (Intrinsics.areEqual(this.inlineEntity, r101.inlineEntity) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.previewBody, r101.previewBody) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.renderRouterEntity, r101.renderRouterEntity) == true) goto L18;
        return false;
    L18:
        if (this.componentTreeTime == r101.componentTreeTime) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.extTranslateInfo, r101.extTranslateInfo) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.inlineEntity.hashCode() * 31;
        UrlPreviewBody r101 = this.previewBody;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        RenderRouterEntity r105 = this.renderRouterEntity;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        long r107 = this.componentTreeTime;
        int r108 = (((r104 + r106) * 31) + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        ExtTranslateInfo r109 = this.extTranslateInfo;
        if (r109 == null) goto L15;
        r102 = r109.hashCode();
    L15:
        return r108 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "UrlCardPreviewEntity(inlineEntity=" + this.inlineEntity + ", previewBody=" + this.previewBody + ", renderRouterEntity=" + this.renderRouterEntity + ", componentTreeTime=" + this.componentTreeTime + ", extTranslateInfo=" + this.extTranslateInfo + ')';
    }

    public final TurtleCanvasEntity getTurtleCanvasEntity() {
        UrlPreviewBody r100 = this.previewBody;
        if (r100 == null) goto L17;
        Map<String, UrlPreviewState> r101 = r100.getStates();
        if (r101 == null) goto L7;
        UrlPreviewState r102 = r101.get(r100.getCurrentStateId());
    L8:
        HashMap<String, UrlPreviewTemplate> r103 = r100.getTemplates();
        if (r102 == null) goto L11;
        String r104 = r102.getTemplateId();
    L12:
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        UrlPreviewTemplate r105 = r103.get(r104);
        if (r105 == null) goto L17;
        Map<String, UrlPreviewComponent> r106 = r105.getElements();
    L18:
        if (r106 == null) goto L38;
        Iterator<Map.Entry<String, UrlPreviewComponent>> r107 = r106.entrySet().iterator();
    L21:
        if (r107.hasNext() == false) goto L39;
        UrlPreviewComponent r108 = r107.next().getValue();
        if (r108 == null) goto L25;
        BaseProperty r109 = r108.getProperty();
    L27:
        if ((r109 instanceof TurtleCardEngineProperty) == false) goto L29;
        TurtleCanvasEntity r110 = ((TurtleCardEngineProperty) r109).getTurtleContent();
    L30:
        if (r110 == null) goto L21;
        return r110;
    L29:
        r110 = null;
        goto L30
    L25:
        r109 = null;
        goto L27
    L39:
        return null;
    L38:
        return null;
    L11:
        r104 = null;
        goto L12
    L7:
        r102 = null;
    L17:
        r106 = null;
        goto L18
    }

    public final boolean isSmartCard() {
        RenderRouterEntity r100 = this.renderRouterEntity;
        if (r100 == null) goto L34;
        HashMap<String, CardComponent> r101 = r100.getElements();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.isEmpty() == true) goto L25;
        Iterator<Map.Entry<String, CardComponent>> r102 = r101.entrySet().iterator();
    L11:
        if (r102.hasNext() == false) goto L25;
        CardComponent r103 = r102.next().getValue();
        if ((r103.getProperty() instanceof SmartCardEngineProperty) == false) goto L22;
        ModelParserRenderRouterEntity.CardEngineType r104 = ((SmartCardEngineProperty) r103.getProperty()).getEngineType();
        ModelParserRenderRouterEntity.CardEngineType r105 = ModelParserRenderRouterEntity.CardEngineType.UNIVERSAL_CARD;
        if (r104 != r105) goto L22;
        a<? extends e<? extends Props, ? extends View, ? extends r6c.a>> r106 = ((UrlPreviewApi) ApiUtils.getApi(UrlPreviewApi.class)).getCardEngineComponentFactory(r105);
        if (r106 == null) goto L19;
        r106.a();
        boolean r107 = true;
    L20:
        if (r107 == false) goto L22;
        boolean r108 = true;
    L23:
        if (r108 == false) goto L11;
        boolean r109 = true;
    L26:
        if (r109 != true) goto L36;
        return true;
    L36:
        return false;
    L19:
        r107 = false;
    L22:
        r108 = false;
    L25:
        r109 = false;
        goto L26
    L34:
        return false;
    }

    public final boolean isTurtleCard() {
        UrlPreviewBody r100 = this.previewBody;
        if (r100 == null) goto L44;
        Map<String, UrlPreviewState> r101 = r100.getStates();
        if (r101 == null) goto L7;
        UrlPreviewState r102 = r101.get(r100.getCurrentStateId());
    L8:
        HashMap<String, UrlPreviewTemplate> r103 = r100.getTemplates();
        if (r102 == null) goto L11;
        String r104 = r102.getTemplateId();
    L12:
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        UrlPreviewTemplate r105 = r103.get(r104);
        if (r105 == null) goto L17;
        Map<String, UrlPreviewComponent> r106 = r105.getElements();
    L18:
        if (r106 != null) goto L21;
        return false;
    L21:
        if (r106.isEmpty() == true) goto L46;
        Iterator<Map.Entry<String, UrlPreviewComponent>> r107 = r106.entrySet().iterator();
    L25:
        if (r107.hasNext() == false) goto L47;
        UrlPreviewComponent r108 = r107.next().getValue();
        if (r108 == null) goto L29;
        BaseProperty r109 = r108.getProperty();
    L31:
        if ((r109 instanceof EngineProperty) == true) goto L33;
    L35:
        boolean r110 = false;
    L36:
        if (r110 == false) goto L25;
        return true;
    L33:
        if (isTurtleEngine((EngineProperty) r109) == false) goto L35;
        r110 = true;
        goto L36
    L29:
        r109 = null;
        goto L31
    L47:
        return false;
    L46:
        return false;
    L17:
        r106 = null;
        goto L18
    L11:
        r104 = null;
        goto L12
    L7:
        r102 = null;
        goto L8
    L44:
        return false;
    }

    public final boolean isValidCardData() {
        UrlPreviewBody r100 = this.previewBody;
        if (r100 == null) goto L44;
        Map<String, UrlPreviewState> r101 = r100.getStates();
        if (r101 == null) goto L7;
        UrlPreviewState r102 = r101.get(r100.getCurrentStateId());
    L8:
        HashMap<String, UrlPreviewTemplate> r103 = r100.getTemplates();
        if (r102 == null) goto L11;
        String r104 = r102.getTemplateId();
    L12:
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        UrlPreviewTemplate r105 = r103.get(r104);
        if (r105 == null) goto L17;
        Map<String, UrlPreviewComponent> r106 = r105.getElements();
    L18:
        if (r106 == null) goto L44;
        if (r106.isEmpty() == false) goto L23;
    L22:
        boolean r107 = true;
    L38:
        if (r107 == true) goto L40;
        return false;
    L40:
        if (r106.size() <= 1) goto L51;
        return true;
    L51:
        return false;
    L23:
        Iterator<Map.Entry<String, UrlPreviewComponent>> r108 = r106.entrySet().iterator();
    L25:
        if (r108.hasNext() == false) goto L22;
        UrlPreviewComponent r109 = r108.next().getValue();
        if (r109 == null) goto L29;
        BaseProperty r110 = r109.getProperty();
    L31:
        if ((r110 instanceof EngineProperty) == false) goto L35;
        EngineProperty r111 = (EngineProperty) r110;
        if (engineFGIsEnable(r111, r111.getEngineType()) == true) goto L35;
        boolean r112 = true;
    L36:
        if (r112 == false) goto L25;
        r107 = false;
    L35:
        r112 = false;
        goto L36
    L29:
        r110 = null;
        goto L31
    L17:
        r106 = null;
        goto L18
    L11:
        r104 = null;
        goto L12
    L7:
        r102 = null;
    L44:
        return isSmartCard();
    }

    public final String getTurtleScriptId() {
        TurtleCanvasEntity r100 = getTurtleCanvasEntity();
        if (r100 == null) goto L5;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.getScriptKey() + r100.getScriptVersion();
    L5:
        return null;
    }

    public final long getComponentTreeTime() {
        return this.componentTreeTime;
    }

    public final ExtTranslateInfo getExtTranslateInfo() {
        return this.extTranslateInfo;
    }

    public final UrlInlinePreviewEntity getInlineEntity() {
        return this.inlineEntity;
    }

    public final UrlPreviewBody getPreviewBody() {
        return this.previewBody;
    }

    public final RenderRouterEntity getRenderRouterEntity() {
        return this.renderRouterEntity;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UrlCardPreviewEntity r100) {
        return compareTo2(r100);
    }

    public boolean isContentSame(UrlCardPreviewEntity r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        UrlInlinePreviewEntity r101 = this.inlineEntity;
        ExtTranslateInfo r102 = null;
        if (r100 == null) goto L8;
        UrlInlinePreviewEntity r103 = r100.inlineEntity;
    L10:
        if (r101.isContentSame(r103) == true) goto L12;
        return false;
    L12:
        UrlPreviewBody r104 = this.previewBody;
        if (r100 == null) goto L15;
        UrlPreviewBody r105 = r100.previewBody;
    L17:
        if (Intrinsics.areEqual(r104, r105) == true) goto L19;
        return false;
    L19:
        RenderRouterEntity r106 = this.renderRouterEntity;
        if (r100 == null) goto L22;
        RenderRouterEntity r107 = r100.renderRouterEntity;
    L24:
        if (Intrinsics.areEqual(r106, r107) == true) goto L26;
        return false;
    L26:
        ExtTranslateInfo r108 = this.extTranslateInfo;
        if (r100 == null) goto L30;
        r102 = r100.extTranslateInfo;
    L30:
        if (Intrinsics.areEqual(r108, r102) == true) goto L32;
        return false;
    L32:
        return true;
    L22:
        r107 = null;
        goto L24
    L15:
        r105 = null;
        goto L17
    L8:
        r103 = null;
        goto L10
    }

    public boolean isItemSame(UrlCardPreviewEntity r100) {
        UrlInlinePreviewEntity r101 = this.inlineEntity;
        if (r101 == null) goto L8;
        if (r100 == null) goto L6;
        UrlInlinePreviewEntity r102 = r100.inlineEntity;
    L10:
        return r101.isItemSame(r102);
    L6:
        r102 = null;
        goto L10
    L8:
        return false;
    }

    public final boolean isMessageEngine(EngineProperty r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getEngineType() == EngineProperty.EngineType.MESSAGE) goto L5;
    L7:
        return false;
    L5:
        if (engineFGIsEnable(r100, r100.getEngineType()) == false) goto L7;
        return true;
    }

    public final boolean isTurtleEngine(EngineProperty r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getEngineType() == EngineProperty.EngineType.TURTLE_CANVAS) goto L5;
    L7:
        return false;
    L5:
        if (engineFGIsEnable(r100, r100.getEngineType()) == false) goto L7;
        return true;
    }

    public final void setComponentTreeTime(long r100) {
        this.componentTreeTime = r100;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((UrlCardPreviewEntity) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((UrlCardPreviewEntity) r100);
    }

    public final boolean engineFGIsEnable(EngineProperty r100, EngineProperty.EngineType r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "engineType");
        d<? extends e<? extends Props, ? extends View, ? extends r6c.a>> r102 = ((UrlPreviewApi) ApiUtils.getApi(UrlPreviewApi.class)).getEngineComponentFactory(r101);
        if (r102 != null) goto L5;
        return false;
    L5:
        if (r102.a() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public UrlCardPreviewEntity(UrlInlinePreviewEntity r100, UrlPreviewBody r110, RenderRouterEntity r111, long r112) {
        Intrinsics.checkNotNullParameter(r100, "inlineEntity");
        this(r100, r110, r111, r112, null);
    }

    public UrlCardPreviewEntity(UrlInlinePreviewEntity r100, UrlPreviewBody r101, RenderRouterEntity r102, long r103, ExtTranslateInfo r104) {
        Intrinsics.checkNotNullParameter(r100, "inlineEntity");
        this.inlineEntity = r100;
        this.previewBody = r101;
        this.renderRouterEntity = r102;
        this.componentTreeTime = r103;
        this.extTranslateInfo = r104;
    }

    public /* synthetic */ UrlCardPreviewEntity(UrlInlinePreviewEntity r100, UrlPreviewBody r101, RenderRouterEntity r110, long r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 2) == 0) goto L5;
        UrlPreviewBody r102 = null;
    L7:
        if ((r112 & 4) == 0) goto L9;
        RenderRouterEntity r103 = null;
    L11:
        if ((r112 & 8) == 0) goto L13;
        r111 = 0;
    L13:
        this(r100, r102, r103, r111);
        return;
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }

    public /* synthetic */ UrlCardPreviewEntity(UrlInlinePreviewEntity r100, UrlPreviewBody r101, RenderRouterEntity r102, long r110, ExtTranslateInfo r111, int r112, DefaultConstructorMarker r113) {
        ExtTranslateInfo r103 = null;
        if ((r112 & 2) == 0) goto L5;
        UrlPreviewBody r104 = null;
    L7:
        if ((r112 & 4) == 0) goto L9;
        RenderRouterEntity r105 = null;
    L11:
        if ((r112 & 8) == 0) goto L13;
        long r106 = 0;
    L15:
        if ((r112 & 16) != 0) goto L18;
        r103 = r111;
    L18:
        this(r100, r104, r105, r106, r103);
        return;
    L13:
        r106 = r110;
        goto L15
    L9:
        r105 = r102;
        goto L11
    L5:
        r104 = r101;
        goto L7
    }
}
