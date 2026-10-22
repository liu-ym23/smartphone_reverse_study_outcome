package com.bytedance.kmp.ec.yata.common.protocol.data;

import com.amap.api.col.s.ce;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.kmp.ec.yata.common.platform.jsonadapter.YataFieldsAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u000e8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R*\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u000e8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014R*\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u000e8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 R\u001c\u0010$\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/n;", "Lcom/bytedance/kmp/ec/yata/common/platform/l;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/i;", "facade", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/i;", "f", "()Lcom/bytedance/kmp/ec/yata/common/protocol/data/i;", "", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/b;", KtvSubElement.CONTAINER, "Ljava/util/List;", "d", "()Ljava/util/List;", "", "", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/p;", "data", "Ljava/util/Map;", "getData", "()Ljava/util/Map;", "", "linkage", "h", "global", ce.f26391f, "endpoint", "e", "", "reload", "Ljava/lang/Boolean;", ce.f26395j, "()Ljava/lang/Boolean;", "clear", "c", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/r;", "patches", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/r;", RXScreenCaptureService.KEY_INDEX, "()Lcom/bytedance/kmp/ec/yata/common/protocol/data/r;", "yata-store-kmp_release"}, k = 1, mv = {1, 7, 0})
public final class c implements n, com.bytedance.kmp.ec.yata.common.platform.l {

    @SerializedName("clear")
    private final Boolean clear;

    @SerializedName(KtvSubElement.CONTAINER)
    private final List<b> container;

    @SerializedName("data")
    private final Map<String, p> data;

    @SerializedName("end_point")
    @JsonAdapter(YataFieldsAdapter.class)
    private final Map<String, Object> endpoint;

    @SerializedName("facade")
    private final i facade;

    @SerializedName("global")
    @JsonAdapter(YataFieldsAdapter.class)
    private final Map<String, Object> global;

    @SerializedName("linkage")
    @JsonAdapter(YataFieldsAdapter.class)
    private final Map<String, Object> linkage;

    @SerializedName("patches")
    private final r patches;

    @SerializedName("reload")
    private final Boolean reload;

    public c() {
        this(null, null, null, null, null, null, null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.facade, r101.facade) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.container, r101.container) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.linkage, r101.linkage) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.global, r101.global) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.endpoint, r101.endpoint) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.reload, r101.reload) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.clear, r101.clear) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.patches, r101.patches) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        i r100 = this.facade;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<b> r104 = this.container;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, p> r107 = this.data;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Object> r110 = this.linkage;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, Object> r113 = this.global;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, Object> r116 = this.endpoint;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.reload;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.clear;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        r r125 = this.patches;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
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

    public final String toString() {
        return "DownLinkData(facade=" + this.facade + ", container=" + this.container + ", data=" + this.data + ", linkage=" + this.linkage + ", global=" + this.global + ", endpoint=" + this.endpoint + ", reload=" + this.reload + ", clear=" + this.clear + ", patches=" + this.patches + ')';
    }

    public final Boolean c() {
        return this.clear;
    }

    public final List<b> d() {
        return this.container;
    }

    public final Map<String, Object> e() {
        return this.endpoint;
    }

    public final i f() {
        return this.facade;
    }

    public final Map<String, Object> g() {
        return this.global;
    }

    @Override // com.bytedance.kmp.ec.yata.common.protocol.data.n
    public final Map<String, p> getData() {
        return this.data;
    }

    public final Map<String, Object> h() {
        return this.linkage;
    }

    public final r i() {
        return this.patches;
    }

    public final Boolean j() {
        return this.reload;
    }

    public static c a(c r110, Map r111, Map r112, int r113) {
        r r100 = null;
        if ((r113 & 1) == 0) goto L5;
        i r101 = r110.facade;
    L7:
        if ((r113 & 2) == 0) goto L9;
        List<b> r102 = r110.container;
    L11:
        if ((r113 & 4) == 0) goto L13;
        r111 = r110.data;
    L13:
        Map r103 = r111;
        if ((r113 & 8) == 0) goto L16;
        r112 = r110.linkage;
    L16:
        Map r104 = r112;
        if ((r113 & 16) == 0) goto L19;
        Map<String, Object> r105 = r110.global;
    L21:
        if ((r113 & 32) == 0) goto L23;
        Map<String, Object> r106 = r110.endpoint;
    L25:
        if ((r113 & 64) == 0) goto L27;
        Boolean r107 = r110.reload;
    L29:
        if ((r113 & 128) == 0) goto L31;
        Boolean r114 = r110.clear;
    L33:
        if ((r113 & 256) == 0) goto L36;
        r100 = r110.patches;
    L36:
        return new c(r101, r102, r103, r104, r105, r106, r107, r114, r100);
    L31:
        r114 = null;
        goto L33
    L27:
        r107 = null;
        goto L29
    L23:
        r106 = null;
        goto L25
    L19:
        r105 = null;
        goto L21
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public static c b(c r110, i r111, Map r112, Map r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        r111 = r110.facade;
    L5:
        i r100 = r111;
        if ((r114 & 2) == 0) goto L8;
        List<b> r101 = r110.container;
    L10:
        if ((r114 & 4) == 0) goto L12;
        r112 = r110.data;
    L12:
        Map r102 = r112;
        if ((r114 & 8) == 0) goto L15;
        Map<String, Object> r103 = r110.linkage;
    L17:
        if ((r114 & 16) == 0) goto L19;
        r113 = r110.global;
    L19:
        Map r104 = r113;
        if ((r114 & 32) == 0) goto L22;
        Map<String, Object> r105 = r110.endpoint;
    L24:
        if ((r114 & 64) == 0) goto L26;
        Boolean r106 = r110.reload;
    L28:
        if ((r114 & 128) == 0) goto L30;
        Boolean r107 = r110.clear;
    L32:
        if ((r114 & 256) == 0) goto L34;
        r r108 = r110.patches;
    L35:
        r110.getClass();
        return new c(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L34:
        r108 = null;
        goto L35
    L30:
        r107 = null;
        goto L32
    L26:
        r106 = null;
        goto L28
    L22:
        r105 = null;
        goto L24
    L15:
        r103 = null;
        goto L17
    L8:
        r101 = null;
        goto L10
    }

    public /* synthetic */ c(i r110, List r111, Map r112, Map r113, Map r114, Map r115, Boolean r210, Boolean r211, int r212) {
        if ((r212 & 1) == 0) goto L5;
        i r100 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        List r101 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        Map r102 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        Map r103 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Map r104 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Map r105 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        Boolean r116 = Boolean.TRUE;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Boolean r117 = Boolean.FALSE;
    L34:
        this(r100, r101, r102, r103, r104, r105, r116, r117, null);
        return;
    L33:
        r117 = r211;
        goto L34
    L29:
        r116 = r210;
        goto L31
    L25:
        r105 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public c(i r100, List<b> r101, Map<String, p> r102, Map<String, ? extends Object> r103, Map<String, ? extends Object> r104, Map<String, ? extends Object> r105, Boolean r106, Boolean r107, r r108) {
        this.facade = r100;
        this.container = r101;
        this.data = r102;
        this.linkage = r103;
        this.global = r104;
        this.endpoint = r105;
        this.reload = r106;
        this.clear = r107;
        this.patches = r108;
    }
}
