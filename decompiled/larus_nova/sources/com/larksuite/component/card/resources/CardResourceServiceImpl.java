package com.larksuite.component.card.resources;

import android.util.LruCache;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.data.media.VisitInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.suite.lark.platform.service.resourcerepository.api.ResourceRequestBaseSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes24.dex */
public final class CardResourceServiceImpl implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f283908c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache<String, CardResource> f283909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f283910b;

    public static final class a {
    }

    static {
    }

    @Override // com.larksuite.component.card.service.c
    public final void destroy() {
        Log.i("CardResourceService", MapMonitorConst.EVENT_DESTROY);
        CoroutineScopeKt.cancel(this.f283910b, new CancellationException("CardResourceService is destroyed"));
        this.f283909a.evictAll();
    }

    public CardResourceServiceImpl() {
        this.f283909a = new LruCache(100);
        this.f283910b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
    }

    @Override // com.larksuite.component.card.resources.e
    public final void g(CardData r100) {
        Intrinsics.checkNotNullParameter(r100, "cardData");
        Log.i("CardResourceService", "preload resources, bizID=" + r100.getCardID() + ", uniCardID=" + r100.getUniversalCardID());
        BuildersKt.launch$default(this.f283910b, null, null, new CardResourceServiceImpl$preloadResources$1(this, r100, null), 3, null);
    }

    @Override // com.larksuite.component.card.resources.e
    public final CardResource i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fileKey");
        return this.f283909a.get(r100);
    }

    @Override // com.larksuite.component.card.resources.e
    public final Object b(b r100, Continuation<? super CardResource> r101) {
        if ((r101 instanceof CardResourceServiceImpl$forceLoadResource$1) == false) goto L7;
        CardResourceServiceImpl$forceLoadResource$1 r102 = (CardResourceServiceImpl$forceLoadResource$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (b) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L17:
        List r107 = (List) r104;
        if (r107.isEmpty() == true) goto L24;
        if (Intrinsics.areEqual(((CardResource) ListProtector.get(r107, 0)).f283904b, r100.f283915b) == false) goto L24;
        return ListProtector.get(r107, 0);
    L24:
        throw new RuntimeException("cannot load resource with key: " + r100.f283915b);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        Log.i("CardResourceService", "force load resource with key: " + r100.f283915b);
        List<b> r108 = CollectionsKt.listOf(r100);
        r102.L$0 = r100;
        r102.label = 1;
        r104 = m(r108, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new CardResourceServiceImpl$forceLoadResource$1(this, r101);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object m(List<b> r210, Continuation<? super List<CardResource>> r211) {
        if ((r211 instanceof CardResourceServiceImpl$doLoadResourceSuspend$1) == false) goto L7;
        CardResourceServiceImpl$doLoadResourceSuspend$1 r100 = (CardResourceServiceImpl$doLoadResourceSuspend$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        List r105 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L47:
        List r106 = (List) r102;
        Iterator r107 = r106.iterator();
    L49:
        if (r107.hasNext() == false) goto L52;
        CardResource r108 = (CardResource) r107.next();
        this.f283909a.put(r108.f283904b, r108);
        goto L49
    L52:
        return CollectionsKt.plus(r105, r106);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        ArrayList r109 = new ArrayList();
        final ArrayList r110 = new ArrayList();
        Iterator<T> r111 = r210.iterator();
    L16:
        if (r111.hasNext() == false) goto L21;
        b r112 = (b) r111.next();
        CardResource r113 = this.f283909a.get(r112.f283915b);
        if (r113 == null) goto L19;
        r109.add(r113);
        goto L16
    L19:
        r110.add(r112);
        goto L16
    L21:
        Log.i("CardResourceService", "hit: " + CollectionsKt.joinToString$default(r109, ",", null, null, 0, null, CardResourceServiceImpl$doLoadResourceSuspend$3.INSTANCE, 30, null) + ", miss: " + CollectionsKt.joinToString$default(r110, ",", null, null, 0, null, CardResourceServiceImpl$doLoadResourceSuspend$4.INSTANCE, 30, null));
        if (r110.isEmpty() == false) goto L24;
        return r109;
    L24:
        r100.L$0 = r109;
        r100.label = 1;
        final j r114 = new j(IntrinsicsKt.intercepted(r100), 1);
        r114.C();
        Log.i("CardResourceService", "mGetResources with keys: " + CollectionsKt.joinToString$default(r110, ",", null, null, 0, null, CardResourceServiceImpl$mGetResourcesSuspend$2$1.INSTANCE, 30, null));
        if (r110.isEmpty() == false) goto L27;
        Result.Companion r115 = Result.Companion;
        r114.resumeWith(Result.m9449constructorimpl(CollectionsKt.emptyList()));
    L41:
        r102 = r114.B();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L44;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L44:
        if (r102 != r103) goto L46;
        return r103;
    L46:
        r105 = r109;
        goto L47
    L27:
        ArrayList r116 = new ArrayList();
        Iterator r117 = r110.iterator();
    L29:
        if (r117.hasNext() == false) goto L40;
        b r118 = (b) r117.next();
        VisitInfo r119 = r118.f283916c;
        ResourceRequestBaseSet r120 = null;
        if (r119 == null) goto L33;
        ResourceRequestBaseSet.a r121 = new ResourceRequestBaseSet.a();
        r121.f461390a = r119.getSceneType();
        r121.f461391b = r119.getEntityType();
        r121.f461392c = r119.getEntityId();
        r121.f461393d = r119.getInnerMsgId();
        r121.f461394e = r119.getAuthFileKey();
        r121.f461395f = r119.getImExt();
        r121.f461396g = r119.getExt();
    L34:
        HashMap<CardResource.ResourceType, String> r122 = com.larksuite.component.card.resources.a.f283911a;
        CardResource.ResourceType r123 = r118.getType();
        Intrinsics.checkNotNullParameter(r123, "type");
        String r124 = com.larksuite.component.card.resources.a.f283911a.get(r123);
        if (r124 == null) goto L38;
        ResourceRequestBaseSet r125 = new ResourceRequestBaseSet(r118.f283915b, r124, null, null);
        r125.f461388h = r121;
        r120 = r125;
    L38:
        if (r120 == null) goto L29;
        r116.add(r120);
        goto L29
    L33:
        r121 = null;
        goto L34
    L40:
        ((qpc.e) ApiUtils.getApi(qpc.e.class)).getResources(r116, 9, new CardResourceServiceImpl$mGetResourcesSuspend$2$2(r110, r114));
    L7:
        r100 = new CardResourceServiceImpl$doLoadResourceSuspend$1(this, r211);
        goto L8
    }
}
