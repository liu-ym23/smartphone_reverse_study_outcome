package com.ss.android.lark.export.entity;

import android.view.View;
import com.ss.android.lark.export.api.UrlPreviewApi;
import com.ss.android.lark.export.d;
import com.ss.android.lark.export.engine.EngineProperty;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.export.entity.preview.UrlPreviewComponent;
import com.ss.android.lark.export.entity.preview.UrlPreviewState;
import com.ss.android.lark.export.entity.preview.UrlPreviewTemplate;
import com.ss.android.lark.export.entity.turtle.TurtleCanvasEntity;
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
import r6c.a;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002BW\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010BO\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0011J\u0006\u0010\u001f\u001a\u00020\tJ\u0006\u0010 \u001a\u00020\tJ\u0006\u0010!\u001a\u00020\tJ\u0006\u0010\"\u001a\u00020\tJ\b\u0010#\u001a\u0004\u0018\u00010\u0004J\b\u0010$\u001a\u0004\u0018\u00010%J\u0013\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010(H\u0096\u0002J\b\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010-\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\u0000H\u0016J\b\u0010.\u001a\u0004\u0018\u00010/J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\t\u00105\u001a\u00020\tHÆ\u0003J\t\u00106\u001a\u00020\fHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jc\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\t\u00109\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006:"}, d2 = {"Lcom/ss/android/lark/export/entity/PreviewHangPoint;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "url", "", "hangPointId", "messageId", "previewId", "needLocalPreview", "", "isLazyLoad", "sendScene", "Lcom/ss/android/lark/export/entity/SendScene;", "urlCardPreviewEntity", "Lcom/ss/android/lark/export/entity/UrlCardPreviewEntity;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/ss/android/lark/export/entity/SendScene;Lcom/ss/android/lark/export/entity/UrlCardPreviewEntity;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/ss/android/lark/export/entity/UrlCardPreviewEntity;)V", "getUrl", "()Ljava/lang/String;", "getHangPointId", "getMessageId", "getPreviewId", "getNeedLocalPreview", "()Z", "getSendScene", "()Lcom/ss/android/lark/export/entity/SendScene;", "getUrlCardPreviewEntity", "()Lcom/ss/android/lark/export/entity/UrlCardPreviewEntity;", "setUrlCardPreviewEntity", "(Lcom/ss/android/lark/export/entity/UrlCardPreviewEntity;)V", "isValidCardData", "isSmartCard", "isMessageLink", "isTurtleCard", "getTurtleScriptId", "getTurtleCanvasEntity", "Lcom/ss/android/lark/export/entity/turtle/TurtleCanvasEntity;", "equals", "other", "", "hashCode", "", "isItemSame", "diffable", "isContentSame", "parseToPB", "Lcom/bytedance/lark/pb/basic/v1/PreviewHangPoint;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewHangPoint implements Serializable, b<PreviewHangPoint> {
    private final String hangPointId;
    private final boolean isLazyLoad;
    private final String messageId;
    private final boolean needLocalPreview;
    private final String previewId;
    private final SendScene sendScene;
    private final String url;
    private UrlCardPreviewEntity urlCardPreviewEntity;

    public static /* synthetic */ PreviewHangPoint copy$default(PreviewHangPoint r100, String r110, String r111, String r112, String r113, boolean r114, boolean r115, SendScene r116, UrlCardPreviewEntity r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.url;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.hangPointId;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.messageId;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.previewId;
    L19:
        if ((r118 & 16) == 0) goto L21;
        boolean r105 = r100.needLocalPreview;
    L23:
        if ((r118 & 32) == 0) goto L25;
        boolean r106 = r100.isLazyLoad;
    L27:
        if ((r118 & 64) == 0) goto L29;
        SendScene r107 = r100.sendScene;
    L31:
        if ((r118 & 128) == 0) goto L33;
        UrlCardPreviewEntity r108 = r100.urlCardPreviewEntity;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.hangPointId;
    }

    public final String component3() {
        return this.messageId;
    }

    public final String component4() {
        return this.previewId;
    }

    public final boolean component5() {
        return this.needLocalPreview;
    }

    public final boolean component6() {
        return this.isLazyLoad;
    }

    public final SendScene component7() {
        return this.sendScene;
    }

    public final UrlCardPreviewEntity component8() {
        return this.urlCardPreviewEntity;
    }

    public final PreviewHangPoint copy(String r110, String r111, String r112, String r113, boolean r114, boolean r115, SendScene r116, UrlCardPreviewEntity r117) {
        Intrinsics.checkNotNullParameter(r116, "sendScene");
        return new PreviewHangPoint(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public String toString() {
        return "PreviewHangPoint(url=" + this.url + ", hangPointId=" + this.hangPointId + ", messageId=" + this.messageId + ", previewId=" + this.previewId + ", needLocalPreview=" + this.needLocalPreview + ", isLazyLoad=" + this.isLazyLoad + ", sendScene=" + this.sendScene + ", urlCardPreviewEntity=" + this.urlCardPreviewEntity + ')';
    }

    public final TurtleCanvasEntity getTurtleCanvasEntity() {
        UrlCardPreviewEntity r100 = this.urlCardPreviewEntity;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTurtleCanvasEntity();
    }

    public final String getTurtleScriptId() {
        UrlCardPreviewEntity r100 = this.urlCardPreviewEntity;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTurtleScriptId();
    }

    public int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.hangPointId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.messageId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.previewId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        int r113 = 1231;
        if (this.needLocalPreview == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r112 + r114) * 31;
        UrlCardPreviewEntity r116 = this.urlCardPreviewEntity;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        int r117 = (r115 + r101) * 31;
        if (this.isLazyLoad == true) goto L30;
        r113 = 1237;
    L30:
        return r117 + r113;
    L21:
        r114 = 1237;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final boolean isMessageLink() {
        UrlCardPreviewEntity r100 = this.urlCardPreviewEntity;
        if (r100 == null) goto L36;
        UrlPreviewBody r101 = r100.getPreviewBody();
        if (r101 == null) goto L44;
        Map<String, UrlPreviewState> r102 = r101.getStates();
        Boolean r103 = null;
        if (r102 == null) goto L9;
        UrlPreviewState r104 = r102.get(r101.getCurrentStateId());
    L10:
        HashMap<String, UrlPreviewTemplate> r105 = r101.getTemplates();
        if (r104 == null) goto L14;
        String r106 = r104.getTemplateId();
        if (r106 == null) goto L14;
    L15:
        UrlPreviewTemplate r107 = r105.get(r106);
        if (r107 == null) goto L18;
        Map<String, UrlPreviewComponent> r108 = r107.getElements();
    L19:
        if (r108 == null) goto L45;
        Iterator<Map.Entry<String, UrlPreviewComponent>> r109 = r108.entrySet().iterator();
    L22:
        if (r109.hasNext() == false) goto L46;
        UrlPreviewComponent r110 = r109.next().getValue();
        if (r110 == null) goto L26;
        BaseProperty r111 = r110.getProperty();
    L28:
        if ((r111 instanceof EngineProperty) == false) goto L22;
        BaseProperty r112 = r110.getProperty();
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type com.ss.android.lark.export.engine.EngineProperty");
        EngineProperty.EngineType r113 = ((EngineProperty) r112).getEngineType();
        EngineProperty.EngineType r114 = EngineProperty.EngineType.MESSAGE;
        if (r113 != r114) goto L22;
        d<? extends e<? extends Props, ? extends View, ? extends a>> r115 = ((UrlPreviewApi) ApiUtils.getApi(UrlPreviewApi.class)).getEngineComponentFactory(r114);
        if (r115 == null) goto L35;
        r103 = Boolean.valueOf(r115.a());
    L35:
        return Intrinsics.areEqual(r103, Boolean.TRUE);
    L26:
        r111 = null;
        goto L28
    L46:
        return false;
    L45:
        return false;
    L18:
        r108 = null;
    L14:
        r106 = "";
        goto L15
    L9:
        r104 = null;
        goto L10
    L44:
        return false;
    L36:
        return false;
    }

    public final boolean isSmartCard() {
        UrlCardPreviewEntity r100 = this.urlCardPreviewEntity;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isSmartCard() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isTurtleCard() {
        UrlCardPreviewEntity r100 = this.urlCardPreviewEntity;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isTurtleCard();
    }

    public final boolean isValidCardData() {
        String r100 = this.url;
        if (r100 != null) goto L5;
    L10:
        boolean r101 = false;
    L11:
        if (r101 == false) goto L20;
        UrlCardPreviewEntity r102 = this.urlCardPreviewEntity;
        if (r102 != null) goto L15;
    L17:
        boolean r103 = false;
    L18:
        if (r103 == false) goto L20;
        return true;
    L15:
        if (r102.isValidCardData() != true) goto L17;
        r103 = true;
    L20:
        return false;
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 != true) goto L10;
        r101 = true;
        goto L11
    L7:
        r104 = false;
        goto L8
    }

    public final com.bytedance.lark.pb.basic.v1.PreviewHangPoint parseToPB() {
        String r100 = this.url;
        if (r100 != null) goto L7;
        return null;
    L7:
        return new com.bytedance.lark.pb.basic.v1.PreviewHangPoint.Builder().url(r100).preview_id(this.previewId).close_card_preview(Boolean.FALSE).need_local_preview(Boolean.valueOf(this.needLocalPreview)).is_lazy_load(Boolean.valueOf(this.isLazyLoad)).build();
    }

    public final String getHangPointId() {
        return this.hangPointId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final boolean getNeedLocalPreview() {
        return this.needLocalPreview;
    }

    public final String getPreviewId() {
        return this.previewId;
    }

    public final SendScene getSendScene() {
        return this.sendScene;
    }

    public final String getUrl() {
        return this.url;
    }

    public final UrlCardPreviewEntity getUrlCardPreviewEntity() {
        return this.urlCardPreviewEntity;
    }

    public final boolean isLazyLoad() {
        return this.isLazyLoad;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(PreviewHangPoint.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.export.entity.PreviewHangPoint");
        PreviewHangPoint r102 = (PreviewHangPoint) r100;
        if (Intrinsics.areEqual(this.url, r102.url) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.hangPointId, r102.hangPointId) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.messageId, r102.messageId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.previewId, r102.previewId) == true) goto L25;
        return false;
    L25:
        if (this.needLocalPreview == r102.needLocalPreview) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.urlCardPreviewEntity, r102.urlCardPreviewEntity) == true) goto L31;
        return false;
    L31:
        if (this.isLazyLoad == r102.isLazyLoad) goto L33;
        return false;
    L33:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public boolean isContentSame(PreviewHangPoint r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.url, r100.url) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.hangPointId, r100.hangPointId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageId, r100.messageId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.previewId, r100.previewId) == true) goto L18;
        return false;
    L18:
        if (this.needLocalPreview == r100.needLocalPreview) goto L21;
        return false;
    L21:
        if (y28.a.c(this.urlCardPreviewEntity, r100.urlCardPreviewEntity) == true) goto L24;
        return false;
    L24:
        if (this.isLazyLoad == r100.isLazyLoad) goto L26;
        return false;
    L26:
        return true;
    }

    public boolean isItemSame(PreviewHangPoint r100) {
        UrlCardPreviewEntity r101 = this.urlCardPreviewEntity;
        if (r101 == null) goto L8;
        if (r100 == null) goto L6;
        UrlCardPreviewEntity r102 = r100.urlCardPreviewEntity;
    L10:
        return r101.isItemSame(r102);
    L6:
        r102 = null;
        goto L10
    L8:
        return false;
    }

    public final void setUrlCardPreviewEntity(UrlCardPreviewEntity r100) {
        this.urlCardPreviewEntity = r100;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((PreviewHangPoint) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((PreviewHangPoint) r100);
    }

    public PreviewHangPoint(String r110, String r111, String r112, String r113, boolean r114, boolean r115, UrlCardPreviewEntity r116) {
        this(r110, r111, r112, r113, r114, r115, SendScene.DEFAULT, r116);
    }

    public PreviewHangPoint(String r100, String r101, String r102, String r103, boolean r104, boolean r105, SendScene r106, UrlCardPreviewEntity r107) {
        Intrinsics.checkNotNullParameter(r106, "sendScene");
        this.url = r100;
        this.hangPointId = r101;
        this.messageId = r102;
        this.previewId = r103;
        this.needLocalPreview = r104;
        this.isLazyLoad = r105;
        this.sendScene = r106;
        this.urlCardPreviewEntity = r107;
    }

    public /* synthetic */ PreviewHangPoint(String r110, String r111, String r112, String r113, boolean r114, boolean r115, UrlCardPreviewEntity r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 16) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r117 & 32) == 0) goto L9;
        boolean r101 = false;
    L10:
        this(r110, r111, r112, r113, r100, r101, r116);
        return;
    L9:
        r101 = r115;
        goto L10
    L5:
        r100 = r114;
        goto L7
    }

    public /* synthetic */ PreviewHangPoint(String r110, String r111, String r112, String r113, boolean r114, boolean r115, SendScene r116, UrlCardPreviewEntity r117, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 16) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r210 & 32) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r210 & 64) == 0) goto L13;
        SendScene r102 = SendScene.DEFAULT;
    L14:
        this(r110, r111, r112, r113, r100, r101, r102, r117);
        return;
    L13:
        r102 = r116;
        goto L14
    L9:
        r101 = r115;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }
}
