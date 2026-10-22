package com.bytedance.kmp.ec.yata.common.protocol.data;

import com.amap.api.col.s.ce;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.kmp.ec.yata.chain.event.EventState;
import com.bytedance.kmp.ec.yata.common.platform.jsonadapter.YataFieldsAdapter;
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

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0003R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR8\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\b\u000b\u0010\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/protocol/data/g;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/m;", "Lcom/bytedance/kmp/ec/yata/chain/event/a;", "Lcom/bytedance/kmp/ec/yata/common/platform/l;", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "", "", SlcCommonAction.KEY_PARAMS, "Ljava/util/Map;", RXScreenCaptureService.KEY_INDEX, "()Ljava/util/Map;", "l", "(Ljava/util/Map;)V", "getFields$yata_store_kmp_release$annotations", "()V", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/o;", TeaEventTrack.ACTION_DRAMA_NEXT, "Lcom/bytedance/kmp/ec/yata/common/protocol/data/o;", ce.f26395j, "()Lcom/bytedance/kmp/ec/yata/common/protocol/data/o;", "eventControlFlow", ce.f26391f, "yata-store-kmp_release"}, k = 1, mv = {1, 7, 0})
public final class g implements m<g>, com.bytedance.kmp.ec.yata.chain.event.a, com.bytedance.kmp.ec.yata.common.platform.l {

    @SerializedName("event_control_flow")
    private final String eventControlFlow;

    @SerializedName(SlcCommonAction.KEY_PARAMS)
    @JsonAdapter(YataFieldsAdapter.class)
    private Map<String, Object> fields;

    @SerializedName(TeaEventTrack.ACTION_DRAMA_NEXT)
    private final o next;

    @SerializedName("type")
    private final String type;

    public g() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fields, r101.fields) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.next, r101.next) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.eventControlFlow, r101.eventControlFlow) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final Map<String, List<com.bytedance.kmp.ec.yata.chain.event.a>> h() {
        Pair[] r100 = new Pair[2];
        o r101 = this.next;
        List<g> r102 = null;
        if (r101 == null) goto L5;
        List<g> r103 = r101.b();
    L6:
        r100[0] = TuplesKt.to("success", r103);
        o r104 = this.next;
        if (r104 == null) goto L9;
        r102 = r104.a();
    L9:
        r100[1] = TuplesKt.to("failed", r102);
        return MapsKt.mapOf(r100);
    L5:
        r103 = null;
        goto L6
    }

    public final int hashCode() {
        String r100 = this.type;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.fields;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        o r107 = this.next;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.eventControlFlow;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "Event(type=" + this.type + ", fields=" + this.fields + ", next=" + this.next + ", eventControlFlow=" + this.eventControlFlow + ')';
    }

    @Override // com.bytedance.kmp.ec.yata.common.protocol.data.m
    public final Map<String, Object> f() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("type", getType()), TuplesKt.to(SlcCommonAction.KEY_PARAMS, i()), TuplesKt.to(TeaEventTrack.ACTION_DRAMA_NEXT, com.bytedance.kmp.ec.yata.common.protocol.utils.c.a(j())), TuplesKt.to("event_control_flow", g())});
    }

    @Override // com.bytedance.kmp.ec.yata.chain.event.a
    public final List<com.bytedance.kmp.ec.yata.chain.event.a> b() {
        Map<String, List<com.bytedance.kmp.ec.yata.chain.event.a>> r100 = h();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get(EventState.FAILED.getKey());
    }

    @Override // com.bytedance.kmp.ec.yata.chain.event.a
    public final List<com.bytedance.kmp.ec.yata.chain.event.a> c() {
        Map<String, List<com.bytedance.kmp.ec.yata.chain.event.a>> r100 = h();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get(EventState.SUCCESS.getKey());
    }

    public final boolean k() {
        List<com.bytedance.kmp.ec.yata.chain.event.a> r100 = b();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        return !r101;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L10
    }

    @Override // com.bytedance.kmp.ec.yata.chain.event.a
    public final Map<String, Object> a() {
        return this.fields;
    }

    @Override // com.bytedance.kmp.ec.yata.chain.event.a
    public final String e() {
        return this.eventControlFlow;
    }

    public final String g() {
        return this.eventControlFlow;
    }

    @Override // com.bytedance.kmp.ec.yata.chain.event.a
    public final String getEventName() {
        return this.type;
    }

    public final String getType() {
        return this.type;
    }

    public final Map<String, Object> i() {
        return this.fields;
    }

    public final o j() {
        return this.next;
    }

    @Override // com.bytedance.kmp.ec.yata.common.protocol.data.m
    public final g d(int r100) {
        if (r100 == 1) goto L8;
        if (r100 == 2) goto L8;
        return new g(this.type, this.fields, this.next, this.eventControlFlow);
    L8:
        return new g(this.type, this.fields, this.next, this.eventControlFlow);
    }

    public final void l(Map<String, Object> r100) {
        this.fields = r100;
    }

    public g(String r100, Map<String, Object> r101, o r102, String r103) {
        this.type = r100;
        this.fields = r101;
        this.next = r102;
        this.eventControlFlow = r103;
    }
}
