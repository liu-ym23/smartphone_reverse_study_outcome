package com.larus.bmhome.chat.model;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010%\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 22\u00020\u0001:\u00012B\u009b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u001e\u001a\u00020\u0003J\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030 J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\rHÆ\u0003J\u0019\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\rHÆ\u0003J\u009d\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r2\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\rHÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R&\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR&\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001c¨\u00063"}, d2 = {"Lcom/larus/bmhome/chat/model/ImportedImageRouteParam;", "", "imageUriString", "", "mode", "Lcom/larus/bmhome/chat/model/ImportedImageRouteMode;", "text", "scene", "sceneForText", "enterMethod", "previousPage", "contentSource", "eventExt", "", "msgExt", "<init>", "(Ljava/lang/String;Lcom/larus/bmhome/chat/model/ImportedImageRouteMode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getImageUriString", "()Ljava/lang/String;", "getMode", "()Lcom/larus/bmhome/chat/model/ImportedImageRouteMode;", "getText", "getScene", "getSceneForText", "getEnterMethod", "getPreviousPage", "getContentSource", "getEventExt", "()Ljava/util/Map;", "getMsgExt", "toJson", "toMultimodalEventExt", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImportedImageRouteParam {
    public static final a Companion = null;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CONTENT_SOURCE)
    private final String contentSource;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName("event_ext")
    private final Map<String, String> eventExt;

    @SerializedName("image_uri_string")
    private final String imageUriString;

    @SerializedName("mode")
    private final ImportedImageRouteMode mode;

    @SerializedName(ChatDraftItem.TYPE_MSG_EXT)
    private final Map<String, String> msgExt;

    @SerializedName("previous_page")
    private final String previousPage;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("scene_for_text")
    private final String sceneForText;

    @SerializedName("text")
    private final String text;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ImportedImageRouteParam() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImportedImageRouteParam copy$default(ImportedImageRouteParam r110, String r111, ImportedImageRouteMode r112, String r113, String r114, String r115, String r116, String r117, String r118, Map r210, Map r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.imageUriString;
    L7:
        if ((r212 & 2) == 0) goto L9;
        ImportedImageRouteMode r101 = r110.mode;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.text;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.scene;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.sceneForText;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.enterMethod;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r106 = r110.previousPage;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r107 = r110.contentSource;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Map r119 = r110.eventExt;
    L39:
        if ((r212 & 512) == 0) goto L41;
        Map r108 = r110.msgExt;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
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

    public final String component1() {
        return this.imageUriString;
    }

    public final Map<String, String> component10() {
        return this.msgExt;
    }

    public final ImportedImageRouteMode component2() {
        return this.mode;
    }

    public final String component3() {
        return this.text;
    }

    public final String component4() {
        return this.scene;
    }

    public final String component5() {
        return this.sceneForText;
    }

    public final String component6() {
        return this.enterMethod;
    }

    public final String component7() {
        return this.previousPage;
    }

    public final String component8() {
        return this.contentSource;
    }

    public final Map<String, String> component9() {
        return this.eventExt;
    }

    public final ImportedImageRouteParam copy(String r110, ImportedImageRouteMode r111, String r112, String r113, String r114, String r115, String r116, String r210, Map<String, String> r211, Map<String, String> r212) {
        return new ImportedImageRouteParam(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImportedImageRouteParam) == true) goto L8;
        return false;
    L8:
        ImportedImageRouteParam r101 = (ImportedImageRouteParam) r100;
        if (Intrinsics.areEqual(this.imageUriString, r101.imageUriString) == true) goto L12;
        return false;
    L12:
        if (this.mode == r101.mode) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sceneForText, r101.sceneForText) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.previousPage, r101.previousPage) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.contentSource, r101.contentSource) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.eventExt, r101.eventExt) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.msgExt, r101.msgExt) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r100 = this.imageUriString;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ImportedImageRouteMode r104 = this.mode;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.text;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.scene;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.sceneForText;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.enterMethod;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.previousPage;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.contentSource;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Map<String, String> r125 = this.eventExt;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Map<String, String> r128 = this.msgExt;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ImportedImageRouteParam(imageUriString=" + this.imageUriString + ", mode=" + this.mode + ", text=" + this.text + ", scene=" + this.scene + ", sceneForText=" + this.sceneForText + ", enterMethod=" + this.enterMethod + ", previousPage=" + this.previousPage + ", contentSource=" + this.contentSource + ", eventExt=" + this.eventExt + ", msgExt=" + this.msgExt + ')';
    }

    public final String toJson() {
        return GsonProtectorUtils.toJson(new Gson(), this);
    }

    public final Map<String, String> toMultimodalEventExt() {
        LinkedHashMap r100 = new LinkedHashMap();
        String r101 = this.scene;
        if (r101 == null) goto L5;
        String r102 = (String) r100.put("scene", r101);
    L5:
        String r103 = this.enterMethod;
        String r104 = null;
        boolean r105 = true;
        if (r103 != null) goto L8;
    L16:
        String r106 = this.previousPage;
        if (r106 != null) goto L19;
    L27:
        String r107 = this.contentSource;
        if (r107 != null) goto L30;
    L37:
        Map<String, String> r108 = this.eventExt;
        if (r108 == null) goto L45;
        Iterator<Map.Entry<String, String>> r109 = r108.entrySet().iterator();
    L41:
        if (r109.hasNext() == false) goto L45;
        Map.Entry<String, String> r110 = r109.next();
        String r111 = r110.getKey();
        String r112 = r110.getValue();
        if (r112 == null) goto L41;
        r100.put(r111, r112);
    L45:
        return r100;
    L30:
        if (r107.length() > 0) goto L33;
        r105 = false;
    L33:
        if (r105 == false) goto L35;
        r104 = r107;
    L35:
        if (r104 == null) goto L37;
        String r113 = (String) r100.put(com.bytedance.android.ec.core.event.a.KEY_CONTENT_SOURCE, r104);
        goto L37
    L19:
        if (r106.length() <= 0) goto L21;
        boolean r114 = true;
    L22:
        if (r114 == true) goto L25;
        r106 = null;
    L25:
        if (r106 == null) goto L27;
        String r115 = (String) r100.put("previous_page", r106);
        goto L27
    L21:
        r114 = false;
        goto L22
    L8:
        if (r103.length() <= 0) goto L10;
        boolean r116 = true;
    L11:
        if (r116 == true) goto L14;
        r103 = null;
    L14:
        if (r103 == null) goto L16;
        r100.put("enter_method", r103);
        String r117 = (String) r100.put("enter_method_trace", r103);
        goto L16
    L10:
        r116 = false;
        goto L11
    }

    public final String getContentSource() {
        return this.contentSource;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final Map<String, String> getEventExt() {
        return this.eventExt;
    }

    public final String getImageUriString() {
        return this.imageUriString;
    }

    public final ImportedImageRouteMode getMode() {
        return this.mode;
    }

    public final Map<String, String> getMsgExt() {
        return this.msgExt;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getSceneForText() {
        return this.sceneForText;
    }

    public final String getText() {
        return this.text;
    }

    public ImportedImageRouteParam(String r100, ImportedImageRouteMode r101, String r102, String r103, String r104, String r105, String r106, String r107, Map<String, String> r108, Map<String, String> r110) {
        this.imageUriString = r100;
        this.mode = r101;
        this.text = r102;
        this.scene = r103;
        this.sceneForText = r104;
        this.enterMethod = r105;
        this.previousPage = r106;
        this.contentSource = r107;
        this.eventExt = r108;
        this.msgExt = r110;
    }

    public /* synthetic */ ImportedImageRouteParam(String r110, ImportedImageRouteMode r111, String r112, String r113, String r114, String r115, String r116, String r117, Map r210, Map r211, int r212, DefaultConstructorMarker r213) {
        Map r100 = null;
        if ((r212 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        ImportedImageRouteMode r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r104 = "album";
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r105 = "router_auto_send";
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Map r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
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
}
