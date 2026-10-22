package com.ss.android.lark.chameleon.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B³\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012(\b\u0002\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000e\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0019\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\u0019\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\u0019\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J)\u00102\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000eHÆ\u0003J\u0017\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0010HÆ\u0003J·\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072(\b\u0002\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000e2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0010HÆ\u0001J\u0013\u00105\u001a\u00020\u00032\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u000209HÖ\u0001J\b\u0010:\u001a\u00020\u0006H\u0016R*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR:\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)¨\u0006;"}, d2 = {"Lcom/ss/android/lark/chameleon/api/ResInterceptConfig;", "Ljava/io/Serializable;", "enable", "", "necessaryCookieKeys", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "filetype", "rootHtml", "pathRewrites", "commonTemplateVars", "mapPattern", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getBizTemplateVars", "", "(ZLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/HashMap;Ljava/util/Map;)V", "getCommonTemplateVars", "()Ljava/util/ArrayList;", "setCommonTemplateVars", "(Ljava/util/ArrayList;)V", "getEnable", "()Z", "setEnable", "(Z)V", "getFiletype", "setFiletype", "getGetBizTemplateVars", "()Ljava/util/Map;", "setGetBizTemplateVars", "(Ljava/util/Map;)V", "getMapPattern", "()Ljava/util/HashMap;", "setMapPattern", "(Ljava/util/HashMap;)V", "getNecessaryCookieKeys", "setNecessaryCookieKeys", "getPathRewrites", "()Ljava/lang/String;", "setPathRewrites", "(Ljava/lang/String;)V", "getRootHtml", "setRootHtml", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ResInterceptConfig implements Serializable {
    private ArrayList<String> commonTemplateVars;
    private boolean enable;
    private ArrayList<String> filetype;
    private Map<String, String> getBizTemplateVars;
    private HashMap<String, String> mapPattern;
    private ArrayList<String> necessaryCookieKeys;
    private String pathRewrites;
    private String rootHtml;

    public ResInterceptConfig() {
        this(false, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResInterceptConfig copy$default(ResInterceptConfig r100, boolean r110, ArrayList r111, ArrayList r112, String r113, String r114, ArrayList r115, HashMap r116, Map r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        boolean r101 = r100.enable;
    L7:
        if ((r118 & 2) == 0) goto L9;
        ArrayList r102 = r100.necessaryCookieKeys;
    L11:
        if ((r118 & 4) == 0) goto L13;
        ArrayList r103 = r100.filetype;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.rootHtml;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.pathRewrites;
    L23:
        if ((r118 & 32) == 0) goto L25;
        ArrayList r106 = r100.commonTemplateVars;
    L27:
        if ((r118 & 64) == 0) goto L29;
        HashMap r107 = r100.mapPattern;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Map r108 = r100.getBizTemplateVars;
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

    public final boolean component1() {
        return this.enable;
    }

    public final ArrayList<String> component2() {
        return this.necessaryCookieKeys;
    }

    public final ArrayList<String> component3() {
        return this.filetype;
    }

    public final String component4() {
        return this.rootHtml;
    }

    public final String component5() {
        return this.pathRewrites;
    }

    public final ArrayList<String> component6() {
        return this.commonTemplateVars;
    }

    public final HashMap<String, String> component7() {
        return this.mapPattern;
    }

    public final Map<String, String> component8() {
        return this.getBizTemplateVars;
    }

    public final ResInterceptConfig copy(boolean r110, ArrayList<String> r111, ArrayList<String> r112, String r113, String r114, ArrayList<String> r115, HashMap<String, String> r116, Map<String, String> r117) {
        Intrinsics.checkNotNullParameter(r111, "necessaryCookieKeys");
        Intrinsics.checkNotNullParameter(r112, "filetype");
        Intrinsics.checkNotNullParameter(r113, "rootHtml");
        Intrinsics.checkNotNullParameter(r114, "pathRewrites");
        Intrinsics.checkNotNullParameter(r115, "commonTemplateVars");
        return new ResInterceptConfig(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResInterceptConfig) == true) goto L8;
        return false;
    L8:
        ResInterceptConfig r101 = (ResInterceptConfig) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.necessaryCookieKeys, r101.necessaryCookieKeys) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.filetype, r101.filetype) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.rootHtml, r101.rootHtml) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.pathRewrites, r101.pathRewrites) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.commonTemplateVars, r101.commonTemplateVars) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.mapPattern, r101.mapPattern) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.getBizTemplateVars, r101.getBizTemplateVars) == true) goto L32;
        return false;
    L32:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    public int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = ((((((((((r101 * 31) + this.necessaryCookieKeys.hashCode()) * 31) + this.filetype.hashCode()) * 31) + this.rootHtml.hashCode()) * 31) + this.pathRewrites.hashCode()) * 31) + this.commonTemplateVars.hashCode()) * 31;
        HashMap<String, String> r103 = this.mapPattern;
        int r104 = 0;
        if (r103 != null) goto L8;
        int r105 = 0;
    L9:
        int r106 = (r102 + r105) * 31;
        Map<String, String> r107 = this.getBizTemplateVars;
        if (r107 == null) goto L14;
        r104 = r107.hashCode();
    L14:
        return r106 + r104;
    L8:
        r105 = r103.hashCode();
        goto L9
    }

    public String toString() {
        return "ResInterceptConfig(enable=" + this.enable + ", necessaryCookieKeys=" + this.necessaryCookieKeys + ", filetype=" + this.filetype + ", rootHtml='" + this.rootHtml + "', pathRewrites='" + this.pathRewrites + "', commonTemplateVars=" + this.commonTemplateVars + ", mapPattern=" + this.mapPattern + ')';
    }

    public final ArrayList<String> getCommonTemplateVars() {
        return this.commonTemplateVars;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final ArrayList<String> getFiletype() {
        return this.filetype;
    }

    public final Map<String, String> getGetBizTemplateVars() {
        return this.getBizTemplateVars;
    }

    public final HashMap<String, String> getMapPattern() {
        return this.mapPattern;
    }

    public final ArrayList<String> getNecessaryCookieKeys() {
        return this.necessaryCookieKeys;
    }

    public final String getPathRewrites() {
        return this.pathRewrites;
    }

    public final String getRootHtml() {
        return this.rootHtml;
    }

    public final void setCommonTemplateVars(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.commonTemplateVars = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setFiletype(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.filetype = r100;
    }

    public final void setGetBizTemplateVars(Map<String, String> r100) {
        this.getBizTemplateVars = r100;
    }

    public final void setMapPattern(HashMap<String, String> r100) {
        this.mapPattern = r100;
    }

    public final void setNecessaryCookieKeys(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.necessaryCookieKeys = r100;
    }

    public final void setPathRewrites(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pathRewrites = r100;
    }

    public final void setRootHtml(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rootHtml = r100;
    }

    public ResInterceptConfig(boolean r100, ArrayList<String> r101, ArrayList<String> r102, String r103, String r104, ArrayList<String> r105, HashMap<String, String> r106, Map<String, String> r107) {
        Intrinsics.checkNotNullParameter(r101, "necessaryCookieKeys");
        Intrinsics.checkNotNullParameter(r102, "filetype");
        Intrinsics.checkNotNullParameter(r103, "rootHtml");
        Intrinsics.checkNotNullParameter(r104, "pathRewrites");
        Intrinsics.checkNotNullParameter(r105, "commonTemplateVars");
        this.enable = r100;
        this.necessaryCookieKeys = r101;
        this.filetype = r102;
        this.rootHtml = r103;
        this.pathRewrites = r104;
        this.commonTemplateVars = r105;
        this.mapPattern = r106;
        this.getBizTemplateVars = r107;
    }

    public /* synthetic */ ResInterceptConfig(boolean r110, ArrayList r111, ArrayList r112, String r113, String r114, ArrayList r115, HashMap r116, Map r117, int r118, DefaultConstructorMarker r119) {
        if ((r118 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r118 & 2) == 0) goto L9;
        ArrayList r101 = new ArrayList();
    L11:
        if ((r118 & 4) == 0) goto L13;
        ArrayList r102 = new ArrayList();
    L14:
        String r103 = "";
        if ((r118 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r118 & 16) != 0) goto L23;
        r103 = r114;
    L23:
        if ((r118 & 32) == 0) goto L25;
        ArrayList r105 = new ArrayList();
    L26:
        Map r106 = null;
        if ((r118 & 64) == 0) goto L29;
        HashMap r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r106 = r117;
    L34:
        this(r100, r101, r102, r104, r103, r105, r107, r106);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r105 = r115;
        goto L26
    L17:
        r104 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L14
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
