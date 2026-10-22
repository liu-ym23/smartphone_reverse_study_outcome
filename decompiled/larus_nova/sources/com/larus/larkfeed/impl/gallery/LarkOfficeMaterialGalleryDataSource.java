package com.larus.larkfeed.impl.gallery;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.larus.gallery.api.GalleryType;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryImageType;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryItemType;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class LarkOfficeMaterialGalleryDataSource implements com.larus.gallery.api.r<kza.m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kza.n f355185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0 f355186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f355187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public kza.m f355188d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public kza.m f355189e;

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final boolean b() {
        return true;
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final boolean h() {
        return true;
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final int k() {
        return 3;
    }

    @Override // com.larus.gallery.api.r
    public final boolean a(kza.m r100) {
        kza.m r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "originalData");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        Set<String> r102 = this.f355187c;
        String r103 = r101.f506780d;
        if (r103 != null) goto L6;
        r103 = "";
    L6:
        return !r102.contains(r103);
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final Object c(Continuation<? super com.larus.gallery.api.b0<? extends List<kza.m>>> r100) {
        List r101 = CollectionsKt.toList(this.f355185a.f506785b);
        this.f355188d = (kza.m) CollectionsKt.lastOrNull(r101);
        this.f355189e = (kza.m) CollectionsKt.firstOrNull(r101);
        return new com.larus.gallery.api.b0.b(r101, true, true);
    }

    public LarkOfficeMaterialGalleryDataSource(kza.n r100, b0 r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "mediaSecurityGuard");
        this.f355185a = r100;
        this.f355186b = r101;
        this.f355187c = Collections.synchronizedSet(new LinkedHashSet());
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final /* bridge */ /* synthetic */ Object d(Object r100, Continuation r101) {
        return l((kza.m) r100, r101);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x007a -> B:21:0x0081). Please report as a decompilation issue!!! */
    @Override // com.larus.gallery.api.IGalleryDataSource
    public final Object e(List<kza.m> r100, Continuation<? super List<Pair<kza.m, com.larus.gallery.api.k>>> r101) {
        if ((r101 instanceof LarkOfficeMaterialGalleryDataSource$refreshDisplayItems$1) == false) goto L7;
        LarkOfficeMaterialGalleryDataSource$refreshDisplayItems$1 r102 = (LarkOfficeMaterialGalleryDataSource$refreshDisplayItems$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        Collection r107 = (Collection) r102.L$3;
        kza.m r108 = (kza.m) r102.L$2;
        Iterator r109 = (Iterator) r102.L$1;
        Collection r110 = (Collection) r102.L$0;
        ResultKt.throwOnFailure(r104);
        Iterator r111 = r109;
        kza.m r112 = r108;
        Object r113 = r105;
        LarkOfficeMaterialGalleryDataSource$refreshDisplayItems$1 r114 = r102;
        LarkOfficeMaterialGalleryDataSource r115 = this;
    L21:
        r107.add(TuplesKt.to(r112, r104));
        LarkOfficeMaterialGalleryDataSource r116 = r115;
        r102 = r114;
        r105 = r113;
        r107 = r110;
        Iterator r117 = r111;
    L16:
        if (r117.hasNext() == false) goto L23;
        kza.m r118 = (kza.m) r117.next();
        r102.L$0 = r107;
        r102.L$1 = r117;
        r102.L$2 = r118;
        r102.L$3 = r107;
        r102.label = 1;
        Object r119 = r116.n(r118, r102);
        if (r119 != r105) goto L20;
        return r105;
    L20:
        r111 = r117;
        r112 = r118;
        r113 = r105;
        r114 = r102;
        r115 = r116;
        r104 = r119;
        r110 = r107;
        goto L21
    L23:
        return (List) r107;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        List<kza.m> r120 = r100;
        ArrayList r121 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r120, 10));
        r117 = r120.iterator();
        r107 = r121;
        r116 = this;
    L7:
        r102 = new LarkOfficeMaterialGalleryDataSource$refreshDisplayItems$1(this, r101);
        goto L8
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final Object f(Object r100, Continuation r101) {
        return (kza.m) r100;
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final /* bridge */ /* synthetic */ Object g(Object r100, Continuation r101) {
        return m((kza.m) r100, r101);
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final /* bridge */ /* synthetic */ Object i(Object r100, Continuation r101) {
        return n((kza.m) r100, r101);
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final boolean j(Object r100, Object r101) {
        kza.m r102 = (kza.m) r100;
        kza.m r103 = (kza.m) r101;
        Intrinsics.checkNotNullParameter(r102, SoloKtvContext.SOLO_PAGE_FIRST);
        Intrinsics.checkNotNullParameter(r103, "second");
        this.f355186b.getClass();
        return b0.c(r102, r103);
    }

    public final Object l(kza.m r100, Continuation<? super com.larus.gallery.api.b0<? extends List<kza.m>>> r110) {
        if ((r110 instanceof LarkOfficeMaterialGalleryDataSource$loadMore$1) == false) goto L7;
        LarkOfficeMaterialGalleryDataSource$loadMore$1 r101 = (LarkOfficeMaterialGalleryDataSource$loadMore$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        r100 = (kza.m) r101.L$0;
        ResultKt.throwOnFailure(r111);
    L23:
        List r112 = (List) r111;
    L25:
        List r105 = r112;
        if (r105 != null) goto L28;
    L31:
        boolean r106 = true;
    L33:
        if (r106 == false) goto L35;
        FLogger.f375446a.i("LarkOfficeMaterialGalleryHelper", "load more no more data");
        return new com.larus.gallery.api.b0.b(CollectionsKt.emptyList(), false, false, 4);
    L35:
        if (r100 == null) goto L39;
        b0 r107 = this.f355186b;
        kza.m r108 = (kza.m) CollectionsKt.last(r112);
        r107.getClass();
        if (b0.c(r100, r108) == false) goto L39;
        FLogger.f375446a.w("LarkOfficeMaterialGalleryHelper", "load more cursor did not advance, stop loading");
        return new com.larus.gallery.api.b0.b(CollectionsKt.emptyList(), false, false, 4);
    L39:
        this.f355188d = (kza.m) CollectionsKt.last(r112);
        List r109 = r112;
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator r114 = r109.iterator();
    L41:
        if (r114.hasNext() == false) goto L43;
        kza.m r115 = (kza.m) r114.next();
        StringBuilder r116 = new StringBuilder();
        r116.append(r115.getType());
        r116.append('-');
        r116.append(r115.f506781e);
        r113.add(r116.toString());
        goto L41
    L43:
        FLogger.f375446a.i("LarkOfficeMaterialGalleryHelper", "load " + r112.size() + " more data: " + r113);
        return new com.larus.gallery.api.b0.b(r112, true, false, 4);
    L28:
        if (r105.isEmpty() == true) goto L31;
        r106 = false;
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        kza.m r117 = this.f355188d;
        if (r117 == null) goto L18;
        r100 = r117;
    L18:
        kza.f r118 = this.f355185a.f506787d;
        if (r118 == null) goto L24;
        r101.L$0 = r100;
        r101.label = 1;
        r111 = r118.b(r100, 20, r101);
        if (r111 != r103) goto L23;
        return r103;
    L24:
        r112 = null;
    L7:
        r101 = new LarkOfficeMaterialGalleryDataSource$loadMore$1(this, r110);
        goto L8
    }

    public final Object m(kza.m r100, Continuation<? super com.larus.gallery.api.b0<? extends List<kza.m>>> r110) {
        if ((r110 instanceof LarkOfficeMaterialGalleryDataSource$loadPrevious$1) == false) goto L7;
        LarkOfficeMaterialGalleryDataSource$loadPrevious$1 r101 = (LarkOfficeMaterialGalleryDataSource$loadPrevious$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        r100 = (kza.m) r101.L$0;
        ResultKt.throwOnFailure(r111);
    L23:
        List r112 = (List) r111;
    L25:
        List r105 = r112;
        if (r105 != null) goto L28;
    L31:
        boolean r106 = true;
    L33:
        if (r106 == false) goto L35;
        FLogger.f375446a.i("LarkOfficeMaterialGalleryHelper", "load previous no more data");
        return new com.larus.gallery.api.b0.b(CollectionsKt.emptyList(), false, false, 2);
    L35:
        if (r100 == null) goto L39;
        b0 r107 = this.f355186b;
        kza.m r108 = (kza.m) CollectionsKt.first(r112);
        r107.getClass();
        if (b0.c(r100, r108) == false) goto L39;
        FLogger.f375446a.w("LarkOfficeMaterialGalleryHelper", "load previous cursor did not advance, stop loading");
        return new com.larus.gallery.api.b0.b(CollectionsKt.emptyList(), false, false, 2);
    L39:
        this.f355189e = (kza.m) CollectionsKt.first(r112);
        List r109 = r112;
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator r114 = r109.iterator();
    L41:
        if (r114.hasNext() == false) goto L43;
        kza.m r115 = (kza.m) r114.next();
        StringBuilder r116 = new StringBuilder();
        r116.append(r115.getType());
        r116.append('-');
        r116.append(r115.f506781e);
        r113.add(r116.toString());
        goto L41
    L43:
        FLogger.f375446a.i("LarkOfficeMaterialGalleryHelper", "load " + r112.size() + " previous data: " + r113);
        return new com.larus.gallery.api.b0.b(r112, false, true, 2);
    L28:
        if (r105.isEmpty() == true) goto L31;
        r106 = false;
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        kza.m r117 = this.f355189e;
        if (r117 == null) goto L18;
        r100 = r117;
    L18:
        kza.f r118 = this.f355185a.f506787d;
        if (r118 == null) goto L24;
        r101.L$0 = r100;
        r101.label = 1;
        r111 = r118.a(r100, 20, r101);
        if (r111 != r103) goto L23;
        return r103;
    L24:
        r112 = null;
    L7:
        r101 = new LarkOfficeMaterialGalleryDataSource$loadPrevious$1(this, r110);
        goto L8
    }

    public final Object n(kza.m r210, Continuation<? super com.larus.gallery.api.k> r310) {
        kza.m r100 = r210;
        if ((r310 instanceof LarkOfficeMaterialGalleryDataSource$mapToDisplayItem$1) == false) goto L7;
        LarkOfficeMaterialGalleryDataSource$mapToDisplayItem$1 r101 = (LarkOfficeMaterialGalleryDataSource$mapToDisplayItem$1) r310;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        String r106 = null;
        Double r107 = null;
        String r108 = null;
        r108 = null;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        m r109 = (m) r101.L$1;
        kza.m r110 = (kza.m) r101.L$0;
        ResultKt.throwOnFailure(r103);
        m r111 = r109;
        r100 = r110;
        Object r112 = r103;
    L54:
        String r113 = (String) r112;
    L57:
        if (r111.f355246a == true) goto L63;
        GalleryType r114 = GalleryType.Custom;
        String r115 = c0.a(r100);
        if (r115 != null) goto L62;
        r115 = c0.b(r100);
    L62:
        return new com.larus.gallery.api.k(r114, null, null, new com.larus.gallery.api.h(r115, null, r111.f355250e, r100), null, 22);
    L63:
        GalleryType r116 = GalleryType.Video;
        String r117 = UUID.randomUUID().toString();
        kza.p r118 = r100.f506779c;
        if (r118 == null) goto L66;
        String r119 = r118.f506798b;
    L67:
        if (r118 == null) goto L69;
        Integer r120 = r118.f506802f;
    L70:
        if (r118 == null) goto L72;
        Integer r121 = r118.f506801e;
    L73:
        nr9.f r211 = new nr9.f(null, r113, r113, r121, r120, null, 33);
        kza.p r122 = r100.f506779c;
        if (r122 == null) goto L76;
        r107 = r122.f506800d;
    L76:
        com.larus.gallery.api.k r123 = new com.larus.gallery.api.k(r116, null, new com.larus.gallery.api.q(r117, new nr9.g(null, null, r119, null, r107, null, r211, null, null, null, MediaPlayer.MEDIA_PLAYER_OPTION_PROTOCOL_RETRY_TIMES), 0, null, null, 60), null, null, 26);
    L77:
        return r123;
    L72:
        r121 = null;
        goto L73
    L69:
        r120 = null;
        goto L70
    L66:
        r119 = null;
        goto L67
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        m r124 = (m) r101.L$1;
        kza.m r125 = (kza.m) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r111 = r124;
        r100 = r125;
        Object r126 = r103;
    L29:
        String r127 = (String) r126;
        if (r127 == null) goto L33;
        r108 = r127;
    L36:
        GalleryType r128 = GalleryType.Custom;
        String r129 = c0.a(r100);
        if (r129 != null) goto L39;
        r129 = c0.b(r100);
    L39:
        r123 = new com.larus.gallery.api.k(r128, null, null, new com.larus.gallery.api.h(r129, r108, r111.f355250e, r100), null, 22);
    L33:
        kza.l r130 = r100.f506778b;
        if (r130 == null) goto L36;
        r108 = r130.f506772d;
        goto L36
    L16:
        ResultKt.throwOnFailure(r103);
        this.f355186b.getClass();
        PreviewState r131 = b0.d(r210);
        int r132 = m.f355245f;
        r111 = m.a.a(r131);
        if (r210.getType() == com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryType.Image) goto L19;
        kza.p r133 = r100.f506779c;
        if (r133 == null) goto L55;
        Function1<? super Continuation<? super String>, ? extends Object> r134 = r133.f506806j;
        if (r134 == null) goto L55;
        r101.L$0 = r100;
        r101.L$1 = r111;
        r101.label = 2;
        r112 = r134.invoke(r101);
        if (r112 != r104) goto L54;
        return r104;
    L55:
        r113 = null;
        goto L57
    L19:
        if (r100.f506781e == GalleryItemType.Lark) goto L21;
        GalleryType r135 = GalleryType.Image;
        kza.l r136 = r100.f506778b;
        if (r136 == null) goto L43;
        String r137 = r136.f506771c;
    L44:
        if (r136 == null) goto L46;
        r106 = r136.f506772d;
    L46:
        r123 = new com.larus.gallery.api.k(r135, new com.larus.gallery.api.m(r137, r106, null, null, null, null, null, 508), null, null, null, 28);
        goto L77
    L43:
        r137 = null;
        goto L44
    L21:
        if (r111.f355247b == false) goto L36;
        kza.l r138 = r100.f506778b;
        if (r138 == null) goto L33;
        kza.e r139 = r138.f506774f;
        if (r139 == null) goto L33;
        GalleryImageType r140 = GalleryImageType.Thumbnail;
        r101.L$0 = r100;
        r101.L$1 = r111;
        r101.label = 1;
        r126 = r139.b(r140, false, r101);
        if (r126 != r104) goto L29;
        return r104;
    L7:
        r101 = new LarkOfficeMaterialGalleryDataSource$mapToDisplayItem$1(this, r310);
        goto L8
    }
}
