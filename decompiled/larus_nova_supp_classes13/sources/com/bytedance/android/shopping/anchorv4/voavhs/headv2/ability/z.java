package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import com.bytedance.android.ec.model.response.f0;
import com.bytedance.android.ec.model.response.u1;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class z implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.o {
    public final /* synthetic */ y a;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.o
    public final void a() {
        s r0 = this.a.f;
        r0.TB(r0.getCurrentPosition(), true);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.o
    public final boolean b() {
        AnchorV4HeadV2VO r0 = this.a.f.K10();
        if (r0 == null) goto L11;
        HeaderContentModel r1 = AnchorV4HeadV2VO.getMultiPreviewCell$default(r0, this.a.f.getCurrentPosition(), 0, 2, null);
        if (r1 == null) goto L11;
        HeaderMediaModel r2 = r1.getMedia();
        if (r2 == null) goto L11;
        if (r2.getSupportPreview() != true) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L23;
        AnchorV4HeadV2VO r4 = this.a.f.K10();
        if (r4 == null) goto L25;
        List<HeaderContentModel> r5 = r4.getCells();
        if (r5 == null) goto L26;
        HeaderContentModel r6 = (HeaderContentModel) CollectionsKt.getOrNull(r5, this.a.f.getCurrentPosition());
        if (r6 == null) goto L27;
        HeaderMediaModel r7 = r6.getMedia();
        if (r7 != null) goto L22;
        return false;
    L22:
        if (r7.getSupportPreview() == true) goto L23;
        return false;
    L27:
        return false;
    L26:
        return false;
    L25:
        return false;
    L23:
        return true;
    L11:
        r3 = false;
        goto L12
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.o
    public final boolean c() {
        AnchorV4HeadV2VO r0 = this.a.f.K10();
        Integer r1 = null;
        if (r0 == null) goto L18;
        List<com.bytedance.android.shopping.anchorv4.voavhs.headv2.m> r2 = r0.getHeaderTabs();
        if (r2 == null) goto L18;
        Iterator<T> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        Object r4 = r3.next();
        if (((com.bytedance.android.shopping.anchorv4.voavhs.headv2.m) r4).a(this.a.f.getCurrentPosition()) == false) goto L8;
    L13:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.m r5 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.m) r4;
        if (r5 == null) goto L18;
        Map<String, Object> r6 = r5.h();
        if (r6 == null) goto L18;
        Object r7 = r6.get("type");
    L20:
        if (Intrinsics.areEqual(r7, "videos") == false) goto L22;
        return false;
    L22:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r8 = getVideoModel();
        if (r8 == null) goto L29;
        u1 r9 = r8.b();
        if (r9 == null) goto L29;
        f0 r10 = r9.a();
        if (r10 == null) goto L29;
        r1 = r10.c();
    L29:
        if (r1 != null) goto L32;
        return false;
    L32:
        if (r1.intValue() != 1) goto L38;
        return true;
    L38:
        return false;
    L12:
        r4 = null;
    L18:
        r7 = null;
        goto L20
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.o
    public final Map<String, Object> d() {
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r1 = getVideoModel();
        if (r1 == null) goto L10;
        u1 r2 = r1.b();
        if (r2 == null) goto L10;
        f0 r3 = r2.a();
        if (r3 == null) goto L10;
        Map r4 = r3.a();
        if (r4 == null) goto L10;
    L11:
        r0.putAll(r4);
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r5 = getVideoModel();
        if (r5 == null) goto L14;
        String r6 = r5.j();
    L15:
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        r0.put("video_id", r6);
        return r0;
    L14:
        r6 = null;
    L10:
        r4 = MapsKt.emptyMap();
        goto L11
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.o
    public final com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b getVideoModel() {
        y r0 = this.a;
        return r0.f(r0.f.getCurrentPosition());
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.o
    public final x73.c getSharePlayer() {
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L9;
        y r0 = this.a;
        l r1 = r0.c(r0.f.getCurrentPosition());
        if (r1 == null) goto L12;
        x73.a r2 = r1.e;
        if (r2 == null) goto L12;
        return r2.getSharePlayer();
    L12:
        return null;
    L9:
        y r3 = this.a;
        PlayerBlock r4 = r3.d(r3.f.getCurrentPosition());
        if (r4 == null) goto L12;
        return r4.getSharePlayer();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.o
    public final boolean isPlaying() {
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L11;
        y r0 = this.a;
        l r1 = r0.c(r0.f.getCurrentPosition());
        if (r1 == null) goto L16;
        x73.a r2 = r1.e;
        if (r2 == null) goto L16;
        if (r2.isPlaying() != true) goto L16;
        return true;
    L16:
        return false;
    L11:
        y r3 = this.a;
        PlayerBlock r4 = r3.d(r3.f.getCurrentPosition());
        if (r4 == null) goto L16;
        if (r4.isPlaying() != true) goto L16;
        return true;
    }

    public z(y r1) {
        this.a = r1;
    }
}
