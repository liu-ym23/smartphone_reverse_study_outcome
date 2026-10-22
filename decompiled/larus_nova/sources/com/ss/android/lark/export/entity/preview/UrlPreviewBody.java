package com.ss.android.lark.export.entity.preview;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BÝ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0005\u0012&\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000ej\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f`\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012T\b\u0002\u0010\u0013\u001aN\u0012\u0004\u0012\u00020\u0006\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0005j\u0004\u0018\u0001`\u0015\u0018\u00010\u000ej&\u0012\u0004\u0012\u00020\u0006\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0005j\u0004\u0018\u0001`\u0015\u0018\u0001`\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0096\u0002J\b\u00104\u001a\u000205H\u0016J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\u0019\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0005HÆ\u0003J)\u0010;\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000ej\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f`\u0010HÆ\u0003J\t\u0010<\u001a\u00020\u0012HÆ\u0003JU\u0010=\u001aN\u0012\u0004\u0012\u00020\u0006\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0005j\u0004\u0018\u0001`\u0015\u0018\u00010\u000ej&\u0012\u0004\u0012\u00020\u0006\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0005j\u0004\u0018\u0001`\u0015\u0018\u0001`\u0010HÆ\u0003Jç\u0001\u0010>\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u00052(\b\u0002\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000ej\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f`\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122T\b\u0002\u0010\u0013\u001aN\u0012\u0004\u0012\u00020\u0006\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0005j\u0004\u0018\u0001`\u0015\u0018\u00010\u000ej&\u0012\u0004\u0012\u00020\u0006\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0005j\u0004\u0018\u0001`\u0015\u0018\u0001`\u0010HÆ\u0001J\t\u0010?\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR*\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010!R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR:\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000ej\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R]\u0010\u0013\u001aN\u0012\u0004\u0012\u00020\u0006\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0005j\u0004\u0018\u0001`\u0015\u0018\u00010\u000ej&\u0012\u0004\u0012\u00020\u0006\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0005j\u0004\u0018\u0001`\u0015\u0018\u0001`\u0010¢\u0006\b\n\u0000\u001a\u0004\b/\u0010(¨\u0006@"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/UrlPreviewBody;", "Ljava/io/Serializable;", "urlPreviewComponents", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewComponents;", SlcCommonAction.KEY_ACTIONS, "", "", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewAction;", "cardUrl", "Lcom/ss/android/lark/export/entity/preview/Url;", "currentStateId", "states", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewState;", "templates", "Ljava/util/HashMap;", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewTemplate;", "Lkotlin/collections/HashMap;", "uiRenderTime", "", "componentHangPoints", "Lcom/ss/android/lark/export/entity/PreviewHangPoint;", "Lcom/ss/android/lark/export/entity/PreviewHangPointPair;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/UrlPreviewComponents;Ljava/util/Map;Lcom/ss/android/lark/export/entity/preview/Url;Ljava/lang/String;Ljava/util/Map;Ljava/util/HashMap;JLjava/util/HashMap;)V", "getUrlPreviewComponents$annotations", "()V", "getUrlPreviewComponents", "()Lcom/ss/android/lark/export/entity/preview/UrlPreviewComponents;", "getActions$annotations", "getActions", "()Ljava/util/Map;", "getCardUrl$annotations", "getCardUrl", "()Lcom/ss/android/lark/export/entity/preview/Url;", "getCurrentStateId", "()Ljava/lang/String;", "setCurrentStateId", "(Ljava/lang/String;)V", "getStates", "getTemplates", "()Ljava/util/HashMap;", "setTemplates", "(Ljava/util/HashMap;)V", "getUiRenderTime", "()J", "setUiRenderTime", "(J)V", "getComponentHangPoints", "equals", "", "other", "", "hashCode", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlPreviewBody implements Serializable {
    private final Map<String, UrlPreviewAction> actions;
    private final Url cardUrl;
    private final HashMap<String, Map<String, PreviewHangPoint>> componentHangPoints;
    private String currentStateId;
    private final Map<String, UrlPreviewState> states;
    private HashMap<String, UrlPreviewTemplate> templates;
    private long uiRenderTime;
    private final UrlPreviewComponents urlPreviewComponents;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UrlPreviewBody copy$default(UrlPreviewBody r110, UrlPreviewComponents r111, Map r112, Url r113, String r114, Map r115, HashMap r116, long r117, HashMap r118, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        UrlPreviewComponents r100 = r110.urlPreviewComponents;
    L7:
        if ((r210 & 2) == 0) goto L9;
        Map r101 = r110.actions;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Url r102 = r110.cardUrl;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.currentStateId;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Map r104 = r110.states;
    L23:
        if ((r210 & 32) == 0) goto L25;
        HashMap r105 = r110.templates;
    L27:
        if ((r210 & 64) == 0) goto L29;
        long r106 = r110.uiRenderTime;
    L31:
        if ((r210 & 128) == 0) goto L33;
        HashMap r107 = r110.componentHangPoints;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107);
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @Deprecated(message = "state")
    public static /* synthetic */ void getActions$annotations() {
    }

    @Deprecated(message = "state")
    public static /* synthetic */ void getCardUrl$annotations() {
    }

    @Deprecated(message = ThumbGlideUrl.SOURCE_TEMPLATE)
    public static /* synthetic */ void getUrlPreviewComponents$annotations() {
    }

    public final UrlPreviewComponents component1() {
        return this.urlPreviewComponents;
    }

    public final Map<String, UrlPreviewAction> component2() {
        return this.actions;
    }

    public final Url component3() {
        return this.cardUrl;
    }

    public final String component4() {
        return this.currentStateId;
    }

    public final Map<String, UrlPreviewState> component5() {
        return this.states;
    }

    public final HashMap<String, UrlPreviewTemplate> component6() {
        return this.templates;
    }

    public final long component7() {
        return this.uiRenderTime;
    }

    public final HashMap<String, Map<String, PreviewHangPoint>> component8() {
        return this.componentHangPoints;
    }

    public final UrlPreviewBody copy(UrlPreviewComponents r110, Map<String, UrlPreviewAction> r111, Url r112, String r113, Map<String, UrlPreviewState> r114, HashMap<String, UrlPreviewTemplate> r115, long r116, HashMap<String, Map<String, PreviewHangPoint>> r210) {
        Intrinsics.checkNotNullParameter(r113, "currentStateId");
        Intrinsics.checkNotNullParameter(r115, "templates");
        return new UrlPreviewBody(r110, r111, r112, r113, r114, r115, r116, r210);
    }

    public String toString() {
        return "UrlPreviewBody(urlPreviewComponents=" + this.urlPreviewComponents + ", actions=" + this.actions + ", cardUrl=" + this.cardUrl + ", currentStateId=" + this.currentStateId + ", states=" + this.states + ", templates=" + this.templates + ", uiRenderTime=" + this.uiRenderTime + ", componentHangPoints=" + this.componentHangPoints + ')';
    }

    public int hashCode() {
        UrlPreviewComponents r100 = this.urlPreviewComponents;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, UrlPreviewAction> r104 = this.actions;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Url r107 = this.cardUrl;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.currentStateId.hashCode()) * 31;
        Map<String, UrlPreviewState> r110 = this.states;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        HashMap<String, UrlPreviewTemplate> r113 = this.templates;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        HashMap<String, Map<String, PreviewHangPoint>> r116 = this.componentHangPoints;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
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

    public final Map<String, UrlPreviewAction> getActions() {
        return this.actions;
    }

    public final Url getCardUrl() {
        return this.cardUrl;
    }

    public final HashMap<String, Map<String, PreviewHangPoint>> getComponentHangPoints() {
        return this.componentHangPoints;
    }

    public final String getCurrentStateId() {
        return this.currentStateId;
    }

    public final Map<String, UrlPreviewState> getStates() {
        return this.states;
    }

    public final HashMap<String, UrlPreviewTemplate> getTemplates() {
        return this.templates;
    }

    public final long getUiRenderTime() {
        return this.uiRenderTime;
    }

    public final UrlPreviewComponents getUrlPreviewComponents() {
        return this.urlPreviewComponents;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UrlPreviewBody) == true) goto L8;
        return false;
    L8:
        UrlPreviewBody r101 = (UrlPreviewBody) r100;
        if (Intrinsics.areEqual(this.urlPreviewComponents, r101.urlPreviewComponents) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actions, r101.actions) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cardUrl, r101.cardUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.currentStateId, r101.currentStateId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.states, r101.states) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.templates, r101.templates) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.componentHangPoints, r101.componentHangPoints) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final void setCurrentStateId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.currentStateId = r100;
    }

    public final void setTemplates(HashMap<String, UrlPreviewTemplate> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.templates = r100;
    }

    public final void setUiRenderTime(long r100) {
        this.uiRenderTime = r100;
    }

    public UrlPreviewBody(UrlPreviewComponents r100, Map<String, UrlPreviewAction> r101, Url r102, String r103, Map<String, UrlPreviewState> r104, HashMap<String, UrlPreviewTemplate> r105, long r106, HashMap<String, Map<String, PreviewHangPoint>> r110) {
        Intrinsics.checkNotNullParameter(r103, "currentStateId");
        Intrinsics.checkNotNullParameter(r105, "templates");
        this.urlPreviewComponents = r100;
        this.actions = r101;
        this.cardUrl = r102;
        this.currentStateId = r103;
        this.states = r104;
        this.templates = r105;
        this.uiRenderTime = r106;
        this.componentHangPoints = r110;
    }

    public /* synthetic */ UrlPreviewBody(UrlPreviewComponents r110, Map r111, Url r112, String r113, Map r114, HashMap r115, long r116, HashMap r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 8) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r211 & 16) == 0) goto L9;
        Map r101 = null;
    L11:
        if ((r211 & 64) == 0) goto L13;
        long r102 = 0;
    L15:
        if ((r211 & 128) == 0) goto L17;
        HashMap r117 = null;
    L18:
        this(r110, r111, r112, r100, r101, r115, r102, r117);
        return;
    L17:
        r117 = r210;
        goto L18
    L13:
        r102 = r116;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
