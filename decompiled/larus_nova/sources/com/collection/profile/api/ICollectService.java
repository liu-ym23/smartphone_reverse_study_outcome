package com.collection.profile.api;

import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.im.bean.message.Message;
import com.larus.network.http.a;
import com.larus.platform.api.y0;
import com.larus.platform.model.CancelCollectionResponse;
import com.larus.platform.model.CollectionType;
import com.larus.platform.model.SaveCollectionResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J,\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH¦@¢\u0006\u0002\u0010\rJ$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\u00020\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH¦@¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u001eH&J\n\u0010!\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\"\u001a\u00020\u001cH&J\b\u0010#\u001a\u00020\u001cH\u0016¨\u0006$"}, d2 = {"Lcom/collection/profile/api/ICollectService;", "", "collectionEnable", "", "collectionBaseConstraint", "collectMessage", "Lcom/larus/network/http/Async;", "Lcom/larus/platform/model/SaveCollectionResponse;", "collectionType", "", "messages", "", "Lcom/larus/im/bean/message/Message;", "(ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelMessageCollect", "Lcom/larus/platform/model/CancelCollectionResponse;", "message", "(Lcom/larus/im/bean/message/Message;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelCollect", "collectionId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelLikeMultiMessages", "messageList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectFragment", "Landroidx/fragment/app/Fragment;", "updateFragment", "", WidgetService.PARAM_FRAGMENT, "Lcom/larus/platform/api/IMineCollectFragment;", "updateLikeRevisitFragment", "getCurrentCollectFragment", "getCurrentLikeRevisitFragment", "refreshCollectFragment", "refreshLikeRevisitFragment", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICollectService {
    boolean a();

    y0 b();

    void c(y0 r100);

    void d(y0 r100);

    Object e(String r100, Continuation<? super a<CancelCollectionResponse>> r101);

    Object f(@CollectionType int r100, List<Message> r101, Continuation<? super a<SaveCollectionResponse>> r102);

    Object g(Message r100, int r101, Continuation<? super a<CancelCollectionResponse>> r102);

    y0 h();

    Object i(List<Message> r100, Continuation<? super Boolean> r101);

    void j();

    boolean k();
}
