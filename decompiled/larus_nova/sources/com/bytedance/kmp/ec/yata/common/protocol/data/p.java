package com.bytedance.kmp.ec.yata.common.protocol.data;

import com.amap.api.col.s.ce;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.kmp.ec.yata.common.platform.jsonadapter.YataFieldsAdapter;
import com.bytedance.kmp.ec.yata.common.protocol.CopyConfig;
import com.facebook.keyframes.model.KFImage;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R2\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR:\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/protocol/data/p;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/m;", "Lcom/bytedance/kmp/ec/yata/common/platform/l;", "", "", "", SlcCommonAction.KEY_PARAMS, "Ljava/util/Map;", "h", "()Ljava/util/Map;", ce.f26395j, "(Ljava/util/Map;)V", "", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/g;", "events", "e", RXScreenCaptureService.KEY_INDEX, "Lcom/bytedance/kmp/ec/yata/common/protocol/data/k;", KFImage.FEATURES_JSON_FIELD, "Lcom/bytedance/kmp/ec/yata/common/protocol/data/k;", ce.f26391f, "()Lcom/bytedance/kmp/ec/yata/common/protocol/data/k;", "setFeatures", "(Lcom/bytedance/kmp/ec/yata/common/protocol/data/k;)V", "yata-store-kmp_release"}, k = 1, mv = {1, 7, 0})
public final class p implements m<p>, com.bytedance.kmp.ec.yata.common.platform.l {

    @SerializedName("events")
    private Map<String, List<g>> events;

    @SerializedName(KFImage.FEATURES_JSON_FIELD)
    private k features;

    @SerializedName(SlcCommonAction.KEY_PARAMS)
    @JsonAdapter(YataFieldsAdapter.class)
    private Map<String, Object> fields;

    public p() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.fields, r101.fields) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.events, r101.events) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.features, r101.features) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Map<String, Object> r100 = this.fields;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, List<g>> r104 = this.events;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        k r107 = this.features;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final void i() {
        this.events = null;
    }

    public final String toString() {
        return "NodeData(fields=" + this.fields + ", events=" + this.events + ", features=" + this.features + ')';
    }

    public final p a() {
        return new p(this.fields, null, this.features);
    }

    @Override // com.bytedance.kmp.ec.yata.common.protocol.data.m
    public final Map<String, Object> f() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Pair[] r100 = new Pair[3];
        r100[0] = TuplesKt.to(SlcCommonAction.KEY_PARAMS, h());
        Map<String, List<g>> r101 = e();
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = com.bytedance.kmp.ec.yata.common.protocol.utils.c.a(r101);
    L6:
        r100[1] = TuplesKt.to("events", r103);
        k r104 = g();
        if (r104 == null) goto L9;
        r102 = com.bytedance.kmp.ec.yata.common.protocol.utils.c.a(r104);
    L9:
        r100[2] = TuplesKt.to(KFImage.FEATURES_JSON_FIELD, r102);
        return MapsKt.mapOf(r100);
    L5:
        r103 = null;
        goto L6
    }

    public final Map<String, List<g>> e() {
        return this.events;
    }

    public final k g() {
        return this.features;
    }

    public final Map<String, Object> h() {
        return this.fields;
    }

    public final p b(Map<String, Object> r100) {
        return new p(r100, null, this.features);
    }

    public final p c(@CopyConfig int r100) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        k r101 = null;
        if (r100 != 1) goto L5;
    L7:
        Map<String, Object> r102 = this.fields;
        if (r102 == null) goto L10;
        Map<String, Object> r103 = com.bytedance.kmp.ec.yata.common.protocol.utils.b.b(r102, r100);
    L11:
        if (r100 != 1) goto L20;
        Map<String, List<g>> r104 = this.events;
        if (r104 == null) goto L15;
        Map<String, Object> r105 = com.bytedance.kmp.ec.yata.common.protocol.utils.b.b(r104, r100);
    L17:
        if (TypeIntrinsics.isMutableMap(r105) == true) goto L21;
        r105 = null;
    L21:
        if (r100 != 1) goto L25;
        k r106 = this.features;
        if (r106 == null) goto L27;
        r101 = r106.a();
    L27:
        return new p(r103, r105, r101);
    L25:
        r101 = this.features;
        goto L27
    L15:
        r105 = null;
        goto L17
    L20:
        r105 = this.events;
        goto L21
    L10:
        r103 = null;
        goto L11
    L5:
        if (r100 == 2) goto L7;
        r103 = this.fields;
        goto L11
    }

    @Override // com.bytedance.kmp.ec.yata.common.protocol.data.m
    public final /* bridge */ /* synthetic */ p d(int r100) {
        return c(r100);
    }

    public final void j(Map<String, Object> r100) {
        this.fields = r100;
    }

    public p(Map<String, Object> r100, Map<String, List<g>> r101, k r102) {
        this.fields = r100;
        this.events = r101;
        this.features = r102;
    }
}
