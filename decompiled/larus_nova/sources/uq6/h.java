package uq6;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R0\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020,\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00063"}, d2 = {"Luq6/h;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", RXScreenCaptureService.KEY_INDEX, "(Ljava/lang/String;)V", "tag", "getTag", "h", "", "index", "Ljava/lang/Integer;", "getIndex", "()Ljava/lang/Integer;", "e", "(Ljava/lang/Integer;)V", "fmpType", "getFmpType", "setFmpType", "Luq6/f;", "request", "Luq6/f;", "d", "()Luq6/f;", ce.f26391f, "(Luq6/f;)V", "Luq6/d;", "parse", "Luq6/d;", "b", "()Luq6/d;", "f", "(Luq6/d;)V", "Luq6/e;", ChameleonOpenTracker.Stage.RENDER, "Luq6/e;", "c", "()Luq6/e;", "setRender", "(Luq6/e;)V", "", "Luq6/c;", "componentDetail", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "setComponentDetail", "(Ljava/util/Map;)V", "dito-performance-saas_release"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("component_detail")
    private Map<String, c> componentDetail;

    @SerializedName("fmp_type")
    private String fmpType;

    @SerializedName("index")
    private Integer index;

    @SerializedName("parse")
    private d parse;

    @SerializedName(ChameleonOpenTracker.Stage.RENDER)
    private e render;

    @SerializedName("request")
    private f request;

    @SerializedName("tag")
    private String tag;

    @SerializedName("type")
    private String type;

    public h() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tag, r101.tag) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.index, r101.index) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fmpType, r101.fmpType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.request, r101.request) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.parse, r101.parse) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.render, r101.render) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.componentDetail, r101.componentDetail) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.type;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.tag;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.index;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.fmpType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        f r113 = this.request;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        d r116 = this.parse;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        e r119 = this.render;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Map<String, c> r122 = this.componentDetail;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
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

    public final String toString() {
        return "DitoPageUpdateTimingInfo(type=" + this.type + ", tag=" + this.tag + ", index=" + this.index + ", fmpType=" + this.fmpType + ", request=" + this.request + ", parse=" + this.parse + ", render=" + this.render + ", componentDetail=" + this.componentDetail + ')';
    }

    public final Map<String, c> a() {
        return this.componentDetail;
    }

    public final d b() {
        return this.parse;
    }

    public final e c() {
        return this.render;
    }

    public final f d() {
        return this.request;
    }

    public final String getType() {
        return this.type;
    }

    public h(Object r100) {
        f r101 = new f(null, 3);
        d r102 = new d(0);
        e r103 = new e(0);
        LinkedHashMap r104 = new LinkedHashMap();
        this.type = null;
        this.tag = null;
        this.index = null;
        this.fmpType = null;
        this.request = r101;
        this.parse = r102;
        this.render = r103;
        this.componentDetail = r104;
    }

    public final void e(Integer r100) {
        this.index = r100;
    }

    public final void f(d r100) {
        this.parse = r100;
    }

    public final void g(f r100) {
        this.request = r100;
    }

    public final void h(String r100) {
        this.tag = r100;
    }

    public final void i(String r100) {
        this.type = r100;
    }
}
