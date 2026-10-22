package com.larus.bmhome.upload.sdk.impl;

import com.larus.bmhome.upload.sdk.ResourceCenterRegisterPostAction;
import com.larus.bmhome.upload.sdk.ResourceUploadEngine;
import com.larus.bmhome.upload.sdk.api.model.UploadEngineType;
import com.larus.bmhome.upload.sdk.f;
import com.larus.bmhome.upload.sdk.impl.core.UploadOrchestrator;
import com.larus.bmhome.upload.sdk.impl.core.UploadPreprocessChain;
import com.larus.bmhome.upload.sdk.impl.core.e;
import com.larus.bmhome.upload.sdk.impl.engine.SkeletonUploadEngine;
import com.larus.bmhome.upload.sdk.impl.post.PostUploadActionChain;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements hs8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.larus.bmhome.upload.sdk.impl.core.c> f314844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<js8.c> f314845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.larus.bmhome.upload.sdk.impl.engine.c> f314846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.larus.bmhome.upload.sdk.impl.post.b> f314847d;

    public final c e() {
        CoroutineScope r100 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        ks8.a r101 = new ks8.a();
        ArrayList r102 = (ArrayList) this.f314844a;
        boolean r103 = r102.isEmpty();
        List r104 = r102;
        if (r103 == false) goto L5;
        r104 = CollectionsKt.listOf(new com.larus.bmhome.upload.sdk.impl.core.b());
    L5:
        List r105 = r104;
        List<js8.c> r106 = this.f314845b;
        List r107 = CollectionsKt.plus(this.f314846c, CollectionsKt.listOf(new SkeletonUploadEngine[]{new SkeletonUploadEngine(UploadEngineType.IMAGE), new SkeletonUploadEngine(UploadEngineType.VIDEO), new SkeletonUploadEngine(UploadEngineType.FILE)}));
        if (((ArrayList) this.f314847d).isEmpty() == false) goto L8;
        List<com.larus.bmhome.upload.sdk.impl.post.b> r108 = CollectionsKt.listOf(new com.larus.bmhome.upload.sdk.impl.post.a());
    L10:
        return new c(r100, new e(), new UploadOrchestrator(r101, new js8.a(r106), new com.larus.bmhome.upload.sdk.impl.engine.a(r107), new PostUploadActionChain(r108), new UploadPreprocessChain(r105)));
    L8:
        r108 = this.f314847d;
        goto L10
    }

    public a() {
        this.f314844a = new ArrayList();
        this.f314845b = new ArrayList();
        this.f314846c = new ArrayList();
        this.f314847d = new ArrayList();
    }

    @Override // hs8.b
    public final a a(f r100) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        r100.a(this);
        return this;
    }

    @Override // hs8.b
    public final a b(hs8.f r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        ApiCredentialProviderAdapter r101 = new ApiCredentialProviderAdapter(r100);
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        ((ArrayList) this.f314845b).add(r101);
        return this;
    }

    public final a c(ResourceUploadEngine r100) {
        Intrinsics.checkNotNullParameter(r100, "engine");
        ApiUploadEngineAdapter r101 = new ApiUploadEngineAdapter(r100);
        Intrinsics.checkNotNullParameter(r101, "engine");
        ((ArrayList) this.f314846c).add(r101);
        return this;
    }

    public final a d(ResourceCenterRegisterPostAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        ApiPostUploadActionAdapter r101 = new ApiPostUploadActionAdapter(r100);
        Intrinsics.checkNotNullParameter(r101, "action");
        ((ArrayList) this.f314847d).add(r101);
        return this;
    }
}
