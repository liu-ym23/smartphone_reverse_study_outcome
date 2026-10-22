package com.collection.profile.api;

import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.im.bean.message.Message;
import com.larus.network.http.a;
import com.larus.platform.api.y0;
import com.larus.platform.model.CancelCollectionResponse;
import com.larus.platform.model.CollectionType;
import com.larus.platform.model.SaveCollectionResponse;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096A¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0096A¢\u0006\u0002\u0010\u000fJ$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096A¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0001J,\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00052\b\b\u0001\u0010\u0012\u001a\u00020\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0096A¢\u0006\u0002\u0010\u001aJ\t\u0010\u001b\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u001c\u001a\u00020\u000bH\u0096\u0001J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0001J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0096\u0001J\t\u0010 \u001a\u00020!H\u0096\u0001J\t\u0010\"\u001a\u00020!H\u0096\u0001J\u0011\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u001eH\u0096\u0001J\u0011\u0010%\u001a\u00020!2\u0006\u0010$\u001a\u00020\u001eH\u0096\u0001¨\u0006&"}, d2 = {"Lcom/collection/profile/api/CollectServiceDelegate;", "Lcom/collection/profile/api/ICollectService;", "<init>", "()V", "cancelCollect", "Lcom/larus/network/http/Async;", "Lcom/larus/platform/model/CancelCollectionResponse;", "collectionId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelLikeMultiMessages", "", "messageList", "", "Lcom/larus/im/bean/message/Message;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelMessageCollect", "message", "collectionType", "", "(Lcom/larus/im/bean/message/Message;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectFragment", "Landroidx/fragment/app/Fragment;", "collectMessage", "Lcom/larus/platform/model/SaveCollectionResponse;", "messages", "(ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectionBaseConstraint", "collectionEnable", "getCurrentCollectFragment", "Lcom/larus/platform/api/IMineCollectFragment;", "getCurrentLikeRevisitFragment", "refreshCollectFragment", "", "refreshLikeRevisitFragment", "updateFragment", WidgetService.PARAM_FRAGMENT, "updateLikeRevisitFragment", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CollectServiceDelegate implements ICollectService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CollectServiceDelegate f273530b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ICollectService f273531a;

    static {
        f273530b = new CollectServiceDelegate();
    }

    @Override // com.collection.profile.api.ICollectService
    public final boolean a() {
        return this.f273531a.a();
    }

    @Override // com.collection.profile.api.ICollectService
    public final y0 b() {
        return this.f273531a.b();
    }

    @Override // com.collection.profile.api.ICollectService
    public final void c(y0 r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f273531a.c(r100);
    }

    @Override // com.collection.profile.api.ICollectService
    public final void d(y0 r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f273531a.d(r100);
    }

    @Override // com.collection.profile.api.ICollectService
    public final Object e(String r100, Continuation<? super a<CancelCollectionResponse>> r101) {
        return this.f273531a.e(r100, r101);
    }

    @Override // com.collection.profile.api.ICollectService
    public final Object f(@CollectionType int r100, List<Message> r101, Continuation<? super a<SaveCollectionResponse>> r102) {
        return this.f273531a.f(r100, r101, r102);
    }

    @Override // com.collection.profile.api.ICollectService
    public final Object g(Message r100, int r101, Continuation<? super a<CancelCollectionResponse>> r102) {
        return this.f273531a.g(r100, r101, r102);
    }

    @Override // com.collection.profile.api.ICollectService
    public final y0 h() {
        return this.f273531a.h();
    }

    @Override // com.collection.profile.api.ICollectService
    public final Object i(List<Message> r100, Continuation<? super Boolean> r101) {
        return this.f273531a.i(r100, r101);
    }

    @Override // com.collection.profile.api.ICollectService
    public final void j() {
        this.f273531a.j();
    }

    @Override // com.collection.profile.api.ICollectService
    public final boolean k() {
        return this.f273531a.k();
    }

    private CollectServiceDelegate() {
        this.f273531a = (ICollectService) ServiceManager.get().getService(ICollectService.class);
    }
}
