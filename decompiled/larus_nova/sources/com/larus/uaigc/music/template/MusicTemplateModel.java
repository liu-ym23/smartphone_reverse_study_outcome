package com.larus.uaigc.music.template;

import com.larus.bmhome.music.protocol.ListMusicGenTemplateApi;
import com.larus.network.FlowHttpConnection;
import com.larus.network.http.ServiceType;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.RandomKt;

/* JADX INFO: loaded from: classes31.dex */
public final class MusicTemplateModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f373766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ad9.d.a f373767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.larus.bmhome.music.protocol.c f373768c;

    public MusicTemplateModel() {
        this.f373766a = RandomKt.Random(System.currentTimeMillis()).nextLong();
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.larus.uaigc.music.template.x] */
    public final Object b(Continuation<? super Unit> r110) {
        if ((r110 instanceof MusicTemplateModel$preFetch$1) == false) goto L7;
        MusicTemplateModel$preFetch$1 r100 = (MusicTemplateModel$preFetch$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MusicTemplateModel$preFetch$1 r102 = r100;
        Object r111 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        com.larus.bmhome.music.protocol.c r112 = null;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L17:
        dm9.a r113 = (dm9.a) r111;
        if ((r113 instanceof dm9.a.b) == false) goto L35;
        dm9.a.b r114 = (dm9.a.b) r113;
        if (r114.f469231a.isSuccess() == false) goto L33;
        int r105 = 0;
        ad9.d.a r106 = new ad9.d.a(String.valueOf(this.f373766a), false, new x(), 2);
        com.larus.bmhome.music.protocol.c r115 = (com.larus.bmhome.music.protocol.c) r114.f469231a.getData();
        if (r115 == null) goto L32;
        List<bq8.a> r107 = r115.c();
        if (r107 == null) goto L31;
        List r108 = CollectionsKt.filterNotNull(r107);
        if (r108 == null) goto L31;
        Iterator r109 = r108.iterator();
    L29:
        if (r109.hasNext() == false) goto L31;
        bq8.a r116 = (bq8.a) r109.next();
        int r117 = r105 + 1;
        String r118 = String.valueOf(r105);
        r106.a(r116, r118);
        com.larus.bmhome.music.player.b.a r119 = com.larus.bmhome.music.player.b.f312937a;
        String r120 = r106.f3044a;
        r119.getClass();
        com.larus.bmhome.music.player.b.a.c(r120, r118, r116);
        r105 = r117;
    L31:
        r112 = r115;
    L32:
        this.f373768c = r112;
        this.f373767b = r106;
        FLogger.f375446a.i("MusicTemplateRepository", "success in fetch template list ");
    L38:
        return Unit.INSTANCE;
    L33:
        FLogger.f375446a.e("MusicTemplateRepository", "failed in fetch template list code " + r114.f469231a.getCode() + " message " + r114.f469231a.getMsg());
        goto L38
    L35:
        if ((r113 instanceof dm9.a.C5690a) == false) goto L38;
        FLogger.f375446a.e("MusicTemplateRepository", "failed in fetch template list remote " + ((dm9.a.C5690a) r113).f469230c);
        goto L38
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        ListMusicGenTemplateApi.a r121 = ListMusicGenTemplateApi.f313033a;
        MusicTemplateModel$preFetch$result$1 r122 = new MusicTemplateModel$preFetch$result$1(this, null);
        r102.label = 1;
        r121.getClass();
        FlowHttpConnection r123 = FlowHttpConnection.f359975a;
        r111 = FlowHttpConnection.g(ServiceType.UGC, ListMusicGenTemplateApi.class, r122, false, null, null, null, r102, 248);
        if (r111 != r103) goto L17;
        return r103;
    L7:
        r100 = new MusicTemplateModel$preFetch$1(this, r110);
        goto L8
    }

    public final Object a(int r110, Continuation<? super com.larus.bmhome.music.protocol.c> r111) {
        if ((r111 instanceof MusicTemplateModel$fetchNextInternal$1) == false) goto L7;
        MusicTemplateModel$fetchNextInternal$1 r100 = (MusicTemplateModel$fetchNextInternal$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MusicTemplateModel$fetchNextInternal$1 r102 = r100;
        Object r112 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        r110 = r102.I$0;
        ResultKt.throwOnFailure(r112);
    L17:
        dm9.a r113 = (dm9.a) r112;
        if ((r113 instanceof dm9.a.b) == false) goto L41;
        dm9.a.b r114 = (dm9.a.b) r113;
        if (r114.f469231a.isSuccess() == false) goto L39;
        FLogger.f375446a.i("MusicTemplateRepository", "success in fetch template list ");
        com.larus.bmhome.music.protocol.c r115 = (com.larus.bmhome.music.protocol.c) r114.f469231a.getData();
        if (r115 == null) goto L47;
        List<bq8.a> r105 = r115.c();
        if (r105 == null) goto L38;
        List r106 = CollectionsKt.filterNotNull(r105);
        if (r106 == null) goto L38;
        Iterator r107 = r106.iterator();
    L29:
        if (r107.hasNext() == false) goto L38;
        bq8.a r108 = (bq8.a) r107.next();
        int r109 = r110 + 1;
        String r116 = String.valueOf(r110);
        ad9.d.a r117 = this.f373767b;
        if (r117 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("playListDecorator");
        r117 = null;
    L33:
        r117.a(r108, r116);
        com.larus.bmhome.music.player.b.a r118 = com.larus.bmhome.music.player.b.f312937a;
        ad9.d.a r119 = this.f373767b;
        if (r119 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("playListDecorator");
        r119 = null;
    L36:
        String r120 = r119.f3044a;
        r118.getClass();
        com.larus.bmhome.music.player.b.a.c(r120, r116, r108);
        r110 = r109;
    L38:
        return r115;
    L47:
        return null;
    L39:
        FLogger.f375446a.e("MusicTemplateRepository", "failed in fetch template list code " + r114.f469231a.getCode() + " message " + r114.f469231a.getMsg());
    L43:
        return null;
    L41:
        if ((r113 instanceof dm9.a.C5690a) == false) goto L43;
        FLogger.f375446a.e("MusicTemplateRepository", "failed in fetch template list remote " + ((dm9.a.C5690a) r113).f469230c);
        goto L43
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        ListMusicGenTemplateApi.a r121 = ListMusicGenTemplateApi.f313033a;
        MusicTemplateModel$fetchNextInternal$result$1 r122 = new MusicTemplateModel$fetchNextInternal$result$1(this, r110, null);
        r102.I$0 = r110;
        r102.label = 1;
        r121.getClass();
        FlowHttpConnection r123 = FlowHttpConnection.f359975a;
        r112 = FlowHttpConnection.g(ServiceType.UGC, ListMusicGenTemplateApi.class, r122, false, null, null, null, r102, 248);
        if (r112 != r103) goto L17;
        return r103;
    L7:
        r100 = new MusicTemplateModel$fetchNextInternal$1(this, r111);
        goto L8
    }
}
