package com.larus.chat.gallery.impl.preview.datasource;

import androidx.camera.video.AudioStats;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.locallife.dito.data.DitoNode;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.gallery.api.GalleryType;
import com.larus.gallery.api.IGalleryDataSource;
import com.larus.gallery.api.b0;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AiBeautifyUserContent;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.api.creation.UserCreationUserAvatar;
import com.larus.platform.api.creation.VideoContentFromChat;
import com.larus.platform.api.creation.VideoInfo;
import com.larus.platform.api.creation.VideoUserContent;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes26.dex */
public final class PreviewCreationRecordDataSource implements IGalleryDataSource<xy8.d> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f324234c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.chat.gallery.api.i f324235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f324236b;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final boolean h() {
        return false;
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final int k() {
        return 20;
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final boolean b() {
        return IAIChatUgcAIGCService.f365905a.U();
    }

    public static boolean o(UserCreation r100) {
        String r101 = r100.f364987a;
        boolean r102 = false;
        if (r101 != null) goto L5;
        return false;
    L5:
        String r103 = null;
        if (zp9.d.f(r100) == false) goto L20;
        UserCreationContent r104 = r100.f364991e;
        if (r104 == null) goto L14;
        VideoUserContent r105 = r104.f365010e;
        if (r105 == null) goto L14;
        VideoInfo r106 = r105.f365079a;
        if (r106 == null) goto L14;
        r103 = r106.f365061a;
    L14:
        if (r103 != null) goto L16;
    L17:
        r102 = true;
    L19:
        return !r102;
    L16:
        if (r103.length() != 0) goto L19;
    L20:
        UserCreationContent r107 = r100.f364991e;
        if (r107 == null) goto L26;
        UserCreationImage r108 = r107.f365006a;
        if (r108 == null) goto L26;
        ImageInfo r109 = r108.f365014a;
        if (r109 == null) goto L26;
    L37:
        if (r109 == null) goto L42;
        Image r110 = r109.f364800c;
        if (r110 == null) goto L42;
        String r111 = r110.f364791a;
        if (r111 == null) goto L42;
    L50:
        if (r111.length() != 0) goto L52;
        boolean r112 = true;
    L53:
        if (r112 == true) goto L55;
    L56:
        return true;
    L55:
        if (s(r100, r101, 1, true) != null) goto L56;
        return false;
    L52:
        r112 = false;
    L42:
        if (r109 == null) goto L46;
        Image r113 = r109.f364798a;
        if (r113 == null) goto L46;
        r103 = r113.f364791a;
    L46:
        if (r103 != null) goto L48;
        r111 = r100.j();
        goto L50
    L48:
        r111 = r103;
    L26:
        if (r107 == null) goto L30;
        UserCreationUserAvatar r114 = r107.f365008c;
        if (r114 == null) goto L30;
        r109 = r114.f365050a;
    L31:
        if (r109 != null) goto L37;
        if (r107 == null) goto L36;
        AiBeautifyUserContent r115 = r107.f365009d;
        if (r115 == null) goto L36;
        r109 = r115.f364882a;
    L36:
        r109 = null;
    L30:
        r109 = null;
        goto L31
    }

    public static Object u(List r100) {
        if (IAIChatUgcAIGCService.f365905a.U() == true) goto L5;
        return r100;
    L5:
        List r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L16;
        xy8.d r104 = (xy8.d) r103.next();
        UserCreation r105 = r104.f565439n;
        if (r105 == null) goto L15;
        xy8.d r106 = q(r105, r104.f565442q, true);
        if (r106 == null) goto L15;
        r104 = r106;
    L15:
        r102.add(r104);
        goto L7
    L16:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.HashSet] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.Set] */
    @Override // com.larus.gallery.api.IGalleryDataSource
    public final Object c(Continuation<? super b0<? extends List<? extends xy8.d>>> r100) {
        FLogger r101 = FLogger.f375446a;
        r101.i("PreviewCreationRecordDS", "loadInitial, selectCreationId=" + this.f324236b);
        List<UserCreation> r102 = this.f324235a.a();
        List<UserCreation> r103 = r102;
        boolean r104 = true;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.e("PreviewCreationRecordDS", "loadInitial: creations is empty");
        return new b0.a(new IllegalStateException("creations is empty"), false);
    L12:
        Iterator<UserCreation> r106 = r102.iterator();
        int r107 = 0;
    L14:
        if (r106.hasNext() == false) goto L19;
        if (Intrinsics.areEqual(r106.next().f364987a, this.f324236b) == true) goto L20;
        r107 = r107 + 1;
    L20:
        int r108 = RangesKt.coerceAtLeast(r107, 0);
        int r109 = RangesKt.coerceAtLeast(r108 - 3, 0);
        int r110 = RangesKt.coerceAtMost(r108 + 3, CollectionsKt.getLastIndex(r102));
        if (IAIChatUgcAIGCService.f365905a.U() == false) goto L28;
        List<UserCreation> r111 = r102.subList(r109, r110 + 1);
        final ?? r112 = new HashSet();
        Iterator r113 = r111.iterator();
    L24:
        if (r113.hasNext() == false) goto L29;
        String r114 = ((UserCreation) r113.next()).f364987a;
        if (r114 == null) goto L24;
        r112.add(r114);
    L29:
        List r115 = r(r102, CollectionsKt.emptyList(), new k(r112));
        Integer r116 = this.f324235a.d().getValue();
        if (r116 == null) goto L37;
        if (r116.intValue() != 1) goto L37;
        r104 = false;
    L37:
        return new b0.b(r115, r104, false);
    L28:
        r112 = SetsKt.emptySet();
        goto L29
    L19:
        r107 = -1;
        goto L20
    L5:
        if (r103.isEmpty() == true) goto L8;
        r105 = false;
        goto L9
    }

    public final Object p(Continuation r100) {
        if ((r100 instanceof PreviewCreationRecordDataSource$loadMore$1) == false) goto L7;
        PreviewCreationRecordDataSource$loadMore$1 r101 = (PreviewCreationRecordDataSource$loadMore$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        int r106 = r101.I$0;
        ResultKt.throwOnFailure(r103);
    L22:
        g r107 = (g) r103;
        if ((r107 instanceof g.c) == false) goto L29;
        List<UserCreation> r108 = this.f324235a.a();
        if (r108 != null) goto L27;
        r108 = CollectionsKt.emptyList();
    L27:
        List<UserCreation> r109 = r108;
        List r110 = CollectionsKt.drop(r109, r106);
        final boolean r111 = IAIChatUgcAIGCService.f365905a.U();
        return new b0.b(r(r110, CollectionsKt.take(r109, r106), new i(r111)), true, false, 4);
    L29:
        if ((r107 instanceof g.a) == false) goto L35;
        List<UserCreation> r112 = this.f324235a.a();
        if (r112 != null) goto L33;
        r112 = CollectionsKt.emptyList();
    L33:
        List<UserCreation> r113 = r112;
        List r114 = CollectionsKt.drop(r113, r106);
        final boolean r115 = IAIChatUgcAIGCService.f365905a.U();
        return new b0.b(r(r114, CollectionsKt.take(r113, r106), new j(r115)), false, false, 4);
    L35:
        if ((r107 instanceof g.b) == false) goto L38;
        return new b0.a(new RuntimeException("loadMore error"), true);
    L38:
        if ((r107 instanceof g.d) == false) goto L42;
        FLogger.f375446a.e("PreviewCreationRecordDS", "loadMore timeout");
        return new b0.a(new RuntimeException("loadMore timeout"), true);
    L42:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        FLogger.f375446a.i("PreviewCreationRecordDS", DitoNode.LOAD_MORE);
        List<UserCreation> r116 = this.f324235a.a();
        if (r116 == null) goto L17;
        int r117 = r116.size();
    L18:
        r101.I$0 = r117;
        r101.label = 1;
        Object r118 = l(r117, r101);
        if (r118 != r104) goto L21;
        return r104;
    L21:
        r106 = r117;
        r103 = r118;
        goto L22
    L17:
        r117 = 0;
    L7:
        r101 = new PreviewCreationRecordDataSource$loadMore$1(this, r100);
        goto L8
    }

    public final com.larus.gallery.api.k v(xy8.d r210) {
        GalleryType r100 = r210.f565430e;
        xy8.b r101 = r210.f565428c;
        com.larus.gallery.api.q r102 = null;
        nr9.f r103 = null;
        if (r101 == null) goto L26;
        String r104 = r101.f565413a;
        String r105 = r101.f565414b;
        Integer r106 = Integer.valueOf(r101.f565421i);
        Integer r107 = Integer.valueOf(r101.f565422j);
        z2 r108 = z2.f365865a;
        boolean r109 = true;
        if (r108.getCreationPreviewPerformanceOptConfig().f365593b == false) goto L16;
        com.larus.platform.model.chat.n r110 = r108.getCreationPreviewPerformanceOptConfig();
        if (r110.f365593b == true) goto L9;
    L13:
        boolean r111 = false;
    L14:
        if (r111 == true) goto L16;
        boolean r112 = true;
    L17:
        Boolean r113 = Boolean.valueOf(r112);
        com.larus.platform.model.chat.n r114 = r108.getCreationPreviewPerformanceOptConfig();
        if (r114.f365593b == true) goto L20;
    L24:
        r109 = false;
    L25:
        com.larus.gallery.api.m r115 = new com.larus.gallery.api.m(r104, r105, r106, r107, r113, Boolean.valueOf(r109), Integer.valueOf(r108.getCreationPreviewPerformanceOptConfig().f365594c), 144);
    L27:
        xy8.g r116 = r210.f565429d;
        if (r116 == null) goto L34;
        String r117 = r116.f565460a;
        String r118 = r116.f565466g;
        String r119 = r116.f565461b;
        String r120 = r116.f565462c;
        double r121 = r116.f565471l;
        String r122 = r116.f565465f;
        String r123 = r116.f565463d;
        if (r123 == null) goto L32;
        r103 = new nr9.f(r123, r123, null, null, null, null, 60);
    L32:
        r102 = new com.larus.gallery.api.q(r117, new nr9.g(r117, r118, r119, r120, Double.valueOf(r121), null, r103, r122, null, null, 800), r116.f565472m, "ugc_video", "immersive_preview", 32);
    L34:
        return new com.larus.gallery.api.k(r100, r115, r102, null, null, 8);
    L20:
        if (r114.f365594c <= 0) goto L24;
        if (r108.a2() == false) goto L24;
    L9:
        if (r110.f365594c <= 0) goto L13;
        if (r108.a2() == false) goto L13;
        r111 = true;
    L16:
        r112 = false;
        goto L17
    L26:
        r115 = null;
        goto L27
    }

    public PreviewCreationRecordDataSource(com.larus.chat.gallery.api.i r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "dataBridge");
        Intrinsics.checkNotNullParameter(r101, "selectCreationId");
        this.f324235a = r100;
        this.f324236b = r101;
    }

    public static xy8.e m(UserCreation r110, String r111) {
        Integer r100 = Integer.valueOf(r110.f364988b);
        CreationDynamicInfo r101 = r110.f364994h;
        if (r101 == null) goto L5;
        String r102 = r101.f364914d;
    L6:
        UserCreationRefContent r103 = r110.f365001o;
        if (r103 == null) goto L9;
        String r104 = HttpExtKt.p(r103);
    L10:
        UserCreationContent r105 = r110.f364991e;
        if (r105 == null) goto L19;
        VideoContentFromChat r106 = r105.f365011f;
        if (r106 == null) goto L19;
        String r107 = r106.f365057a;
        if (r107 == null) goto L19;
        if ((!StringsKt.isBlank(r107)) == false) goto L19;
        String r108 = r107;
    L20:
        String r112 = r110.k();
        Integer r113 = r110.f364990d;
        if (r113 != null) goto L24;
    L26:
        boolean r114 = false;
    L28:
        return new xy8.e(r111, r100, r102, r104, r108, null, null, null, r112, r114, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION);
    L24:
        if (r113.intValue() != 1) goto L26;
        r114 = true;
    L19:
        r108 = null;
        goto L20
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public static Map n(UserCreation r100, boolean r101) {
        Pair[] r102 = new Pair[3];
        String r103 = r100.f364987a;
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r102[0] = TuplesKt.to("creation_id", r103);
        if (r101 == false) goto L8;
        String r104 = "video_detail";
    L9:
        r102[1] = TuplesKt.to("current_page", r104);
        r102[2] = TuplesKt.to("enter_from", "creation_record");
        return MapsKt.mapOf(r102);
    L8:
        r104 = "picture_detail";
        goto L9
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final /* bridge */ /* synthetic */ Object d(xy8.d r100, Continuation<? super b0<? extends List<? extends xy8.d>>> r101) {
        return p(r101);
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final Object e(List<? extends xy8.d> r100, Continuation<? super List<? extends Pair<? extends xy8.d, com.larus.gallery.api.k>>> r101) {
        if ((r101 instanceof PreviewCreationRecordDataSource$refreshDisplayItems$1) == false) goto L7;
        PreviewCreationRecordDataSource$refreshDisplayItems$1 r102 = (PreviewCreationRecordDataSource$refreshDisplayItems$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        List r107 = (List) r104;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator r109 = r107.iterator();
    L19:
        if (r109.hasNext() == false) goto L21;
        xy8.d r110 = (xy8.d) r109.next();
        r108.add(TuplesKt.to(r110, v(r110)));
        goto L19
    L21:
        return r108;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r102.label = 1;
        r104 = u(r100);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new PreviewCreationRecordDataSource$refreshDisplayItems$1(this, r101);
        goto L8
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final /* bridge */ /* synthetic */ Object f(xy8.d r100, Continuation<? super xy8.d> r101) {
        return t(r100, r101);
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final Object g(xy8.d r100, Continuation<? super b0<? extends List<? extends xy8.d>>> r101) {
        return new b0.b(CollectionsKt.emptyList(), false, false, 2);
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final Object i(xy8.d r100, Continuation r101) {
        return v(r100);
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final boolean j(xy8.d r100, xy8.d r101) {
        xy8.d r102 = r100;
        xy8.d r103 = r101;
        Intrinsics.checkNotNullParameter(r102, SoloKtvContext.SOLO_PAGE_FIRST);
        Intrinsics.checkNotNullParameter(r103, "second");
        return Intrinsics.areEqual(r102.f565427b, r103.f565427b);
    }

    public final Object l(int r100, Continuation<? super g> r101) {
        if ((r101 instanceof PreviewCreationRecordDataSource$awaitLoadMore$1) == false) goto L7;
        PreviewCreationRecordDataSource$awaitLoadMore$1 r102 = (PreviewCreationRecordDataSource$awaitLoadMore$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        g r107 = (g) r104;
        if (r107 == null) goto L20;
        return r107;
    L20:
        return g.d.f324270a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        PreviewCreationRecordDataSource$awaitLoadMore$2 r108 = new PreviewCreationRecordDataSource$awaitLoadMore$2(this, r100, null);
        r102.label = 1;
        r104 = TimeoutKt.c(10000, r108, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new PreviewCreationRecordDataSource$awaitLoadMore$1(this, r101);
        goto L8
    }

    public final Object t(xy8.d r100, Continuation<? super xy8.d> r101) {
        if ((r101 instanceof PreviewCreationRecordDataSource$refreshOriginalData$1) == false) goto L7;
        PreviewCreationRecordDataSource$refreshOriginalData$1 r102 = (PreviewCreationRecordDataSource$refreshOriginalData$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (xy8.d) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L17:
        xy8.d r107 = (xy8.d) CollectionsKt.firstOrNull((List) r104);
        if (r107 != null) goto L21;
        return r100;
    L21:
        return r107;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        List r108 = CollectionsKt.listOf(r100);
        r102.L$0 = r100;
        r102.label = 1;
        r104 = u(r108);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new PreviewCreationRecordDataSource$refreshOriginalData$1(this, r101);
        goto L8
    }

    public static xy8.d q(UserCreation r410, int r411, boolean r510) {
        String r100 = r410.f364987a;
        Integer r101 = null;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (zp9.d.f(r410) == false) goto L147;
        UserCreationContent r102 = r410.f364991e;
        if (r102 == null) goto L10;
        VideoUserContent r103 = r102.f365010e;
    L11:
        if (r103 == null) goto L13;
        VideoInfo r104 = r103.f365079a;
    L14:
        if (r104 == null) goto L16;
        String r105 = r104.f365061a;
    L18:
        if (r105 != null) goto L20;
    L23:
        boolean r106 = true;
    L24:
        if (r106 == true) goto L149;
        if (r103 == null) goto L31;
        ImageInfo r107 = r103.f365080b;
        if (r107 == null) goto L31;
        Image r108 = r107.f364800c;
        if (r108 == null) goto L31;
    L42:
        if (r108 == null) goto L50;
        String r109 = r108.f364791a;
        if (r109 == null) goto L50;
        if ((!StringsKt.isBlank(r109)) == true) goto L49;
        r109 = null;
    L49:
        if (r109 == null) goto L50;
    L59:
        String r110 = r104.f365066f;
        String r111 = r104.f365062b;
        String r112 = r104.f365063c;
        Double r113 = r104.f365064d;
        String r114 = r104.f365065e;
        long r210 = 0;
        if (r108 == null) goto L70;
        Long r115 = Long.valueOf(r108.f364793c);
        if (r115.longValue() <= 0) goto L64;
        boolean r116 = true;
    L65:
        if (r116 == true) goto L68;
        r115 = null;
    L68:
        if (r115 == null) goto L70;
        Integer r211 = Integer.valueOf((int) r115.longValue());
    L71:
        if (r108 == null) goto L81;
        Long r117 = Long.valueOf(r108.f364794d);
        if (r117.longValue() <= 0) goto L75;
        boolean r118 = true;
    L76:
        if (r118 == true) goto L79;
        r117 = null;
    L79:
        if (r117 == null) goto L81;
        Integer r212 = Integer.valueOf((int) r117.longValue());
    L82:
        nr9.g r119 = new nr9.g(r105, r110, r111, r112, r113, r114, new nr9.f(r109, r109, null, r212, r211, null, 36), null, null, null, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT);
        if (r510 == false) goto L92;
        IAIChatUgcAIGCService.Companion r120 = IAIChatUgcAIGCService.f365905a;
        if (r103 == null) goto L87;
        ImageInfo r121 = r103.f365080b;
    L88:
        nr9.g r122 = r120.D0(r105, r119, r120.Z(r121));
        if (r122 == null) goto L92;
        r119 = r122;
        goto L92
    L87:
        r121 = null;
    L92:
        SourceType r123 = SourceType.CREATION_RECORD;
        String r124 = "record_".concat(r100);
        String r125 = r119.f520257a;
        if (r125 != null) goto L95;
        String r310 = r105;
    L96:
        String r126 = r119.f520259c;
        String r127 = r119.f520260d;
        nr9.f r128 = r119.f520263g;
        if (r128 == null) goto L102;
        String r129 = r128.f520252b;
        if (r129 == null) goto L102;
        String r311 = r129;
    L103:
        String r130 = r119.f520258b;
        if (r128 == null) goto L116;
        Integer r131 = r128.f520255e;
        if (r131 == null) goto L116;
        if (r131.intValue() <= 0) goto L110;
        boolean r132 = true;
    L111:
        if (r132 == true) goto L114;
        r131 = null;
    L114:
        if (r131 == null) goto L116;
        int r412 = r131.intValue();
    L117:
        nr9.f r133 = r119.f520263g;
        if (r133 == null) goto L129;
        Integer r134 = r133.f520254d;
        if (r134 == null) goto L129;
        if (r134.intValue() <= 0) goto L124;
        boolean r135 = true;
    L125:
        if (r135 == false) goto L127;
        r101 = r134;
    L127:
        if (r101 == null) goto L129;
        int r413 = r101.intValue();
    L130:
        Double r136 = r119.f520261e;
        if (r136 != null) goto L135;
        r136 = r104.f365064d;
        if (r136 != null) goto L135;
        double r137 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L136:
        double r414 = r137;
        String r138 = r119.f520262f;
        String r139 = r119.f520257a;
        if (r139 != null) goto L141;
        String r415 = r105;
    L142:
        xy8.g r140 = new xy8.g(r310, r126, r127, r311, r128, null, r130, r138, null, r412, r413, r414, null, r415, null, 45344);
        GalleryType r141 = GalleryType.Video;
        Map r142 = n(r410, true);
        String r143 = r410.k();
        Long r144 = r410.f364999m;
        if (r144 == null) goto L148;
        r210 = r144.longValue();
    L148:
        return new xy8.d(r123, r124, null, r140, r141, r142, r143, r210, null, null, null, null, m(r410, r100), r410, null, null, r411, 52996);
    L141:
        r415 = r139;
    L135:
        r137 = r136.doubleValue();
        goto L136
    L124:
        r135 = false;
    L129:
        r413 = 0;
        goto L130
    L110:
        r132 = false;
    L116:
        r412 = 0;
    L102:
        r311 = r109;
        goto L103
    L95:
        r310 = r125;
        goto L96
    L75:
        r118 = false;
    L81:
        r212 = null;
        goto L82
    L64:
        r116 = false;
    L70:
        r211 = null;
    L50:
        if (r108 == null) goto L56;
        r109 = r108.f364792b;
        if (r109 == null) goto L56;
        if ((!StringsKt.isBlank(r109)) == false) goto L56;
    L57:
        if (r109 != null) goto L59;
        r109 = r410.e();
    L56:
        r109 = null;
    L31:
        if (r103 == null) goto L35;
        ImageInfo r145 = r103.f365080b;
        if (r145 == null) goto L35;
        r108 = r145.f364799b;
    L36:
        if (r108 != null) goto L42;
        if (r103 == null) goto L41;
        ImageInfo r146 = r103.f365080b;
        if (r146 == null) goto L41;
        r108 = r146.f364798a;
    L41:
        r108 = null;
    L35:
        r108 = null;
        goto L36
    L149:
        return null;
    L20:
        if (r105.length() == 0) goto L23;
        r106 = false;
        goto L24
    L16:
        r105 = null;
        goto L18
    L13:
        r104 = null;
        goto L14
    L10:
        r103 = null;
        goto L11
    L147:
        return s(r410, r100, r411, r510);
    }

    public static List r(List r100, List r101, Function1 r102) {
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator r104 = r101.iterator();
    L3:
        int r105 = 0;
        if (r104.hasNext() == false) goto L17;
        UserCreation r106 = (UserCreation) r104.next();
        UserCreationTrackParams r107 = r106.f365000n;
        if (r107 == null) goto L10;
        Integer r108 = r107.f365042c;
        if (r108 == null) goto L10;
        int r109 = r108.intValue();
    L12:
        if (o(r106) == false) goto L3;
        Integer r110 = Integer.valueOf(r109);
        Integer r111 = (Integer) r103.get(Integer.valueOf(r109));
        if (r111 == null) goto L16;
        r105 = r111.intValue();
    L16:
        r103.put(r110, Integer.valueOf(r105 + 1));
    L10:
        r109 = 0;
        goto L12
    L17:
        ArrayList r112 = new ArrayList();
        Iterator r113 = r100.iterator();
    L19:
        if (r113.hasNext() == false) goto L33;
        UserCreation r114 = (UserCreation) r113.next();
        UserCreationTrackParams r115 = r114.f365000n;
        if (r115 == null) goto L25;
        Integer r116 = r115.f365042c;
        if (r116 == null) goto L25;
        int r117 = r116.intValue();
    L26:
        Integer r118 = (Integer) r103.get(Integer.valueOf(r117));
        if (r118 == null) goto L29;
        int r119 = r118.intValue();
    L30:
        int r120 = r119 + 1;
        r103.put(Integer.valueOf(r117), Integer.valueOf(r120));
        xy8.d r121 = q(r114, r120, ((Boolean) r102.invoke(r114)).booleanValue());
        if (r121 == null) goto L19;
        r112.add(r121);
        goto L19
    L29:
        r119 = 0;
    L25:
        r117 = 0;
        goto L26
    L33:
        return r112;
    }

    public static xy8.d s(UserCreation r210, String r211, int r310, boolean r311) {
        UserCreationContent r100 = r210.f364991e;
        if (r100 == null) goto L8;
        UserCreationImage r101 = r100.f365006a;
        if (r101 == null) goto L8;
        ImageInfo r102 = r101.f365014a;
        if (r102 == null) goto L8;
    L19:
        if (r311 == false) goto L22;
        ImageInfo r103 = IAIChatUgcAIGCService.f365905a.o0(r102);
        if (r103 == null) goto L22;
    L23:
        boolean r104 = true;
        if (r311 == true) goto L26;
    L28:
        boolean r212 = false;
    L29:
        if (r103 == null) goto L36;
        Image r105 = r103.f364800c;
        if (r105 == null) goto L36;
        String r106 = r105.f364791a;
        if (r106 == null) goto L36;
    L35:
        String r110 = r106;
        if (r110.length() != 0) goto L46;
        boolean r107 = true;
    L47:
        if (r107 == false) goto L52;
        if (r311 == true) goto L52;
        return s(r210, r211, r310, true);
    L52:
        if (r110.length() != 0) goto L54;
        boolean r108 = true;
    L55:
        if (r108 == false) goto L57;
        return null;
    L57:
        if (r103 == null) goto L67;
        Image r109 = r103.f364799b;
        if (r109 == null) goto L67;
        String r111 = r109.f364791a;
        if (r111 == null) goto L67;
        if ((!StringsKt.isBlank(r111)) == true) goto L66;
        r111 = null;
    L66:
        if (r111 == null) goto L67;
    L98:
        String r112 = r111;
        if (r103 == null) goto L103;
        Image r113 = r103.f364800c;
        if (r113 == null) goto L103;
    L106:
        int r114 = (int) r113.f364793c;
    L108:
        if (r103 == null) goto L112;
        Image r115 = r103.f364800c;
        if (r115 == null) goto L112;
        long r116 = r115.f364794d;
    L116:
        int r117 = (int) r116;
    L118:
        if (r102 == null) goto L122;
        Image r118 = r102.f364798a;
        if (r118 == null) goto L122;
        String r119 = r118.f364791a;
    L123:
        FLogger r120 = FLogger.f375446a;
        StringBuilder r121 = new StringBuilder("mapImageCreation: creationId=");
        r121.append(r211);
        r121.append(", width=");
        r121.append(r114);
        r121.append(", height=");
        r121.append(r117);
        r121.append(", hasOrigin=");
        if (r119 != null) goto L126;
    L129:
        boolean r122 = true;
    L130:
        r121.append(!r122);
        r120.i("PreviewCreationRecordDS", r121.toString());
        LinkedHashMap r123 = new LinkedHashMap();
        if (r102 == null) goto L137;
        Image r124 = r102.f364800c;
        if (r124 == null) goto L137;
        String r125 = r124.f364791a;
        if (r125 == null) goto L137;
        r123.put("share_preview_url", r125);
    L137:
        if (r102 == null) goto L143;
        Image r126 = r102.f364798a;
        if (r126 == null) goto L143;
        String r127 = r126.f364791a;
        if (r127 == null) goto L143;
        r123.put("share_download_url", r127);
    L143:
        if (r102 == null) goto L149;
        Image r128 = r102.f364806i;
        if (r128 == null) goto L149;
        String r129 = r128.f364791a;
        if (r129 == null) goto L149;
        r123.put("share_raw_url", r129);
    L149:
        if (r102 == null) goto L153;
        Image r130 = r102.f364798a;
        if (r130 == null) goto L153;
        r123.put("share_image_origin_width", String.valueOf(r130.f364793c));
    L153:
        if (r102 == null) goto L157;
        Image r131 = r102.f364798a;
        if (r131 == null) goto L157;
        r123.put("share_image_origin_height", String.valueOf(r131.f364794d));
    L157:
        AuthorInfo r132 = r210.f364993g;
        if (r132 == null) goto L162;
        String r133 = r132.f364897b;
        if (r133 == null) goto L162;
        r123.put("share_author_uid", r133);
    L162:
        UserCreationRefContent r134 = r210.f365001o;
        if (r134 == null) goto L165;
        boolean r135 = Intrinsics.areEqual(r134.f365036b, Boolean.TRUE);
    L167:
        if (r210.f364988b == 3) goto L170;
        r104 = false;
    L170:
        if (r135 == true) goto L175;
        if (r104 == true) goto L175;
        String r136 = r210.o();
        if (r136 == null) goto L175;
        r123.put("share_ref_url", r136);
    L175:
        if (r135 == false) goto L177;
        r123.put("share_disable_puzzle", "true");
    L177:
        SourceType r137 = SourceType.CREATION_RECORD;
        String r138 = "record_".concat(r211);
        if (r102 == null) goto L182;
        Image r139 = r102.f364806i;
        if (r139 == null) goto L182;
        String r213 = r139.f364791a;
    L183:
        Boolean r214 = Boolean.TRUE;
        if (r102 == null) goto L189;
        Image r140 = r102.f364798a;
        if (r140 == null) goto L189;
        String r141 = r140.f364795e;
        if (r141 == null) goto L189;
    L206:
        String r215 = r141;
    L207:
        xy8.b r142 = new xy8.b(r110, r112, r119, r213, r214, r212, r215, r114, r117, 64);
        GalleryType r143 = GalleryType.Image;
        Map r144 = n(r210, false);
        String r145 = r210.k();
        Long r146 = r210.f364999m;
        if (r146 == null) goto L210;
        long r147 = r146.longValue();
    L212:
        return new xy8.d(r137, r138, r142, null, r143, r144, r145, r147, null, r123, IUgcAIGCService.f373945a.H(r210, null), null, m(r210, r211), r210, null, null, r310, 51464);
    L210:
        r147 = 0;
    L189:
        if (r102 == null) goto L193;
        Image r148 = r102.f364800c;
        if (r148 == null) goto L193;
        r141 = r148.f364795e;
    L194:
        if (r141 != null) goto L206;
        if (r102 == null) goto L199;
        Image r149 = r102.f364799b;
        if (r149 == null) goto L199;
        r141 = r149.f364795e;
    L200:
        if (r141 != null) goto L206;
        if (r102 == null) goto L205;
        Image r150 = r102.f364806i;
        if (r150 == null) goto L205;
        r215 = r150.f364795e;
    L205:
        r215 = null;
    L199:
        r141 = null;
    L193:
        r141 = null;
    L182:
        r213 = null;
        goto L183
    L165:
        r135 = false;
        goto L167
    L126:
        if (StringsKt.isBlank(r119) == true) goto L129;
        r122 = false;
    L122:
        r119 = null;
    L112:
        if (r103 == null) goto L117;
        Image r151 = r103.f364798a;
        if (r151 == null) goto L117;
        r116 = r151.f364794d;
    L117:
        r117 = 0;
    L103:
        if (r103 == null) goto L107;
        r113 = r103.f364798a;
        if (r113 != null) goto L106;
    L107:
        r114 = 0;
    L67:
        if (r103 == null) goto L75;
        Image r152 = r103.f364799b;
        if (r152 == null) goto L75;
        r111 = r152.f364792b;
        if (r111 == null) goto L75;
        if ((!StringsKt.isBlank(r111)) == false) goto L75;
    L76:
        if (r111 != null) goto L98;
        if (r102 == null) goto L85;
        Image r153 = r102.f364799b;
        if (r153 == null) goto L85;
        r111 = r153.f364791a;
        if (r111 == null) goto L85;
        if ((!StringsKt.isBlank(r111)) == false) goto L85;
    L86:
        if (r111 != null) goto L98;
        if (r102 == null) goto L95;
        Image r154 = r102.f364799b;
        if (r154 == null) goto L95;
        r111 = r154.f364792b;
        if (r111 == null) goto L95;
        if ((!StringsKt.isBlank(r111)) == false) goto L95;
    L96:
        if (r111 != null) goto L98;
        r111 = r210.e();
    L95:
        r111 = null;
    L85:
        r111 = null;
    L75:
        r111 = null;
        goto L76
    L54:
        r108 = false;
        goto L55
    L46:
        r107 = false;
    L36:
        if (r103 == null) goto L40;
        Image r155 = r103.f364798a;
        if (r155 == null) goto L40;
        r106 = r155.f364791a;
    L41:
        if (r106 != null) goto L35;
        r106 = r210.j();
    L40:
        r106 = null;
        goto L41
    L26:
        if (IAIChatUgcAIGCService.f365905a.k0(r102) == false) goto L28;
        r212 = true;
    L22:
        r103 = r102;
    L8:
        if (r100 == null) goto L12;
        UserCreationUserAvatar r156 = r100.f365008c;
        if (r156 == null) goto L12;
        r102 = r156.f365050a;
    L13:
        if (r102 != null) goto L19;
        if (r100 == null) goto L18;
        AiBeautifyUserContent r157 = r100.f365009d;
        if (r157 == null) goto L18;
        r102 = r157.f364882a;
    L18:
        r102 = null;
    L12:
        r102 = null;
        goto L13
    }
}
