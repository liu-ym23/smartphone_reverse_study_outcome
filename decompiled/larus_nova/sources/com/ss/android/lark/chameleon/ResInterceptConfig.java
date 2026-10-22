package com.ss.android.lark.chameleon;

import com.ss.android.lark.vfs.VFSPath;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B¨\u0001\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u00123\b\u0002\u0010\n\u001a-\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010+\u001a\u00020\u0000J\b\u0010,\u001a\u00020\u0004H\u0016J\u0019\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u0019\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0004HÆ\u0003J\t\u00100\u001a\u00020\u0004HÆ\u0003J\u0019\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J4\u00102\u001a-\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010\u0018\u00010\u000bHÆ\u0003J\t\u00103\u001a\u00020\u0012HÆ\u0003Jª\u0001\u0010+\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u000523\b\u0002\u0010\n\u001a-\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010\u0018\u00010\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u00104\u001a\u00020\u00122\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001R*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018RE\u0010\n\u001a-\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00069"}, d2 = {"Lcom/ss/android/lark/chameleon/ResInterceptConfig;", "Ljava/io/Serializable;", "necessaryCookieKeys", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "filetype", "rootHtml", "pathRewrites", "commonTemplateVars", "getBizTemplateVars", "Lkotlin/Function1;", "Lcom/ss/android/lark/vfs/VFSPath;", "Lkotlin/ParameterName;", "name", "vfsPath", "", "serviceWorkerEnable", "", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;Z)V", "getNecessaryCookieKeys", "()Ljava/util/ArrayList;", "setNecessaryCookieKeys", "(Ljava/util/ArrayList;)V", "getFiletype", "setFiletype", "getRootHtml", "()Ljava/lang/String;", "setRootHtml", "(Ljava/lang/String;)V", "getPathRewrites", "setPathRewrites", "getCommonTemplateVars", "setCommonTemplateVars", "getGetBizTemplateVars", "()Lkotlin/jvm/functions/Function1;", "setGetBizTemplateVars", "(Lkotlin/jvm/functions/Function1;)V", "getServiceWorkerEnable", "()Z", "setServiceWorkerEnable", "(Z)V", "copy", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "equals", "other", "", "hashCode", "", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResInterceptConfig implements Serializable {
    private ArrayList<String> commonTemplateVars;
    private ArrayList<String> filetype;
    private Function1<? super VFSPath, ? extends Map<String, String>> getBizTemplateVars;
    private ArrayList<String> necessaryCookieKeys;
    private String pathRewrites;
    private String rootHtml;
    private boolean serviceWorkerEnable;

    public ResInterceptConfig() {
        this(null, null, null, null, null, null, false, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResInterceptConfig copy$default(ResInterceptConfig r100, ArrayList r101, ArrayList r102, String r103, String r104, ArrayList r110, Function1 r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.necessaryCookieKeys;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.filetype;
    L8:
        ArrayList r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.rootHtml;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.pathRewrites;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.commonTemplateVars;
    L17:
        ArrayList r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.getBizTemplateVars;
    L20:
        Function1 r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.serviceWorkerEnable;
    L23:
        ArrayList r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final ArrayList<String> component1() {
        return this.necessaryCookieKeys;
    }

    public final ArrayList<String> component2() {
        return this.filetype;
    }

    public final String component3() {
        return this.rootHtml;
    }

    public final String component4() {
        return this.pathRewrites;
    }

    public final ArrayList<String> component5() {
        return this.commonTemplateVars;
    }

    public final Function1<VFSPath, Map<String, String>> component6() {
        return this.getBizTemplateVars;
    }

    public final boolean component7() {
        return this.serviceWorkerEnable;
    }

    public final ResInterceptConfig copy(ArrayList<String> r110, ArrayList<String> r111, String r112, String r113, ArrayList<String> r114, Function1<? super VFSPath, ? extends Map<String, String>> r115, boolean r116) {
        Intrinsics.checkNotNullParameter(r110, "necessaryCookieKeys");
        Intrinsics.checkNotNullParameter(r111, "filetype");
        Intrinsics.checkNotNullParameter(r112, "rootHtml");
        Intrinsics.checkNotNullParameter(r113, "pathRewrites");
        Intrinsics.checkNotNullParameter(r114, "commonTemplateVars");
        return new ResInterceptConfig(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResInterceptConfig) == true) goto L8;
        return false;
    L8:
        ResInterceptConfig r101 = (ResInterceptConfig) r100;
        if (Intrinsics.areEqual(this.necessaryCookieKeys, r101.necessaryCookieKeys) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.filetype, r101.filetype) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rootHtml, r101.rootHtml) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pathRewrites, r101.pathRewrites) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.commonTemplateVars, r101.commonTemplateVars) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.getBizTemplateVars, r101.getBizTemplateVars) == true) goto L27;
        return false;
    L27:
        if (this.serviceWorkerEnable == r101.serviceWorkerEnable) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((this.necessaryCookieKeys.hashCode() * 31) + this.filetype.hashCode()) * 31) + this.rootHtml.hashCode()) * 31) + this.pathRewrites.hashCode()) * 31) + this.commonTemplateVars.hashCode()) * 31;
        Function1<? super VFSPath, ? extends Map<String, String>> r101 = this.getBizTemplateVars;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.serviceWorkerEnable == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final ResInterceptConfig copy() {
        return new ResInterceptConfig(new ArrayList(this.necessaryCookieKeys), new ArrayList(this.filetype), this.rootHtml, this.pathRewrites, new ArrayList(this.commonTemplateVars), this.getBizTemplateVars, this.serviceWorkerEnable);
    }

    public String toString() {
        return "ResInterceptConfig(filetype=" + this.filetype + ", rootHtml='" + this.rootHtml + "', pathRewrites='" + this.pathRewrites + "', commonTemplateVars=" + this.commonTemplateVars + ", serviceWorkerEnable=" + this.serviceWorkerEnable + ')';
    }

    public final ArrayList<String> getCommonTemplateVars() {
        return this.commonTemplateVars;
    }

    public final ArrayList<String> getFiletype() {
        return this.filetype;
    }

    public final Function1<VFSPath, Map<String, String>> getGetBizTemplateVars() {
        return this.getBizTemplateVars;
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

    public final boolean getServiceWorkerEnable() {
        return this.serviceWorkerEnable;
    }

    public final void setCommonTemplateVars(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.commonTemplateVars = r100;
    }

    public final void setFiletype(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.filetype = r100;
    }

    public final void setGetBizTemplateVars(Function1<? super VFSPath, ? extends Map<String, String>> r100) {
        this.getBizTemplateVars = r100;
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

    public final void setServiceWorkerEnable(boolean r100) {
        this.serviceWorkerEnable = r100;
    }

    public ResInterceptConfig(ArrayList<String> r100, ArrayList<String> r101, String r102, String r103, ArrayList<String> r104, Function1<? super VFSPath, ? extends Map<String, String>> r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "necessaryCookieKeys");
        Intrinsics.checkNotNullParameter(r101, "filetype");
        Intrinsics.checkNotNullParameter(r102, "rootHtml");
        Intrinsics.checkNotNullParameter(r103, "pathRewrites");
        Intrinsics.checkNotNullParameter(r104, "commonTemplateVars");
        this.necessaryCookieKeys = r100;
        this.filetype = r101;
        this.rootHtml = r102;
        this.pathRewrites = r103;
        this.commonTemplateVars = r104;
        this.getBizTemplateVars = r105;
        this.serviceWorkerEnable = r106;
    }

    public /* synthetic */ ResInterceptConfig(ArrayList r100, ArrayList r101, String r102, String r103, ArrayList r110, Function1 r111, boolean r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r113 & 2) == 0) goto L8;
        r101 = new ArrayList();
    L8:
        ArrayList r115 = r101;
        String r104 = "";
        if ((r113 & 4) == 0) goto L11;
        String r105 = "";
    L13:
        if ((r113 & 8) != 0) goto L17;
        r104 = r103;
    L17:
        if ((r113 & 16) == 0) goto L19;
        r110 = new ArrayList();
    L19:
        ArrayList r106 = r110;
        if ((r113 & 32) == 0) goto L22;
        r111 = null;
    L22:
        Function1 r107 = r111;
        if ((r113 & 64) == 0) goto L25;
        boolean r108 = false;
    L26:
        this(r100, r115, r105, r104, r106, r107, r108);
        return;
    L25:
        r108 = r112;
        goto L26
    L11:
        r105 = r102;
        goto L13
    }
}
