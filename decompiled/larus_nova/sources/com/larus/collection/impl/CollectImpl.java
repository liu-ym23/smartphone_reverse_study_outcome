package com.larus.collection.impl;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.collection.profile.api.ICollectService;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common.apphost.AppHost;
import com.larus.feedback.api.FlowFeedbackServiceDelegate;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.minor.api.IMinorService;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.network.http.y;
import com.larus.nova.R;
import com.larus.platform.api.y0;
import com.larus.platform.model.CancelCollectionResponse;
import com.larus.platform.model.CollectionType;
import com.larus.platform.model.SaveCollectionResponse;
import com.larus.platform.service.i3;
import com.larus.platform.service.z2;
import com.larus.profile.api.IProfileApi;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.ttm.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.j;
import org.json.JSONArray;
import org.json.JSONObject;
import t19.s;
import wc9.e;
import yc9.m;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J,\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0096@¢\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\u001c\u0010\u0019\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0096@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0082@¢\u0006\u0002\u0010\u001fJ$\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0006H\u0016J\u0010\u0010(\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0006H\u0016J\n\u0010)\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010*\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010+\u001a\u00020&H\u0016J\b\u0010,\u001a\u00020&H\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larus/collection/impl/CollectImpl;", "Lcom/collection/profile/api/ICollectService;", "<init>", "()V", "weakCollectFragmentReference", "Ljava/lang/ref/WeakReference;", "Lcom/larus/platform/api/IMineCollectFragment;", "weakLikeRevisitFragmentReference", "collectionEnable", "", "collectionBaseConstraint", "collectMessage", "Lcom/larus/network/http/Async;", "Lcom/larus/platform/model/SaveCollectionResponse;", "collectionType", "", "messages", "", "Lcom/larus/im/bean/message/Message;", "(ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelCollect", "Lcom/larus/platform/model/CancelCollectionResponse;", "collectionId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelLikeMultiMessages", "messageList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitMessageFeedback", "fbRequest", "Lcom/larus/im/bean/message/FeedbackMessageRequest;", "(Lcom/larus/im/bean/message/FeedbackMessageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelMessageCollect", "message", "(Lcom/larus/im/bean/message/Message;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectFragment", "Landroidx/fragment/app/Fragment;", "updateFragment", "", WidgetService.PARAM_FRAGMENT, "updateLikeRevisitFragment", "getCurrentCollectFragment", "getCurrentLikeRevisitFragment", "refreshCollectFragment", "refreshLikeRevisitFragment", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CollectImpl implements ICollectService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<y0> f325584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<y0> f325585b;

    public static final class a {
    }

    static {
    }

    public CollectImpl() {
    }

    @Override // com.collection.profile.api.ICollectService
    public final boolean a() {
        if (z2.f365865a.collectEnable() == true) goto L5;
    L7:
        return false;
    L5:
        if (k() == false) goto L7;
        return true;
    }

    @Override // com.collection.profile.api.ICollectService
    public final y0 b() {
        WeakReference<y0> r100 = this.f325584a;
        if (r100 == null) goto L5;
        y0 r101 = r100.get();
    L7:
        if ((r101 instanceof Fragment) == false) goto L19;
        Fragment r102 = (Fragment) r101;
        if (r102.isAdded() == true) goto L11;
    L15:
        boolean r103 = false;
    L16:
        if (r103 == true) goto L19;
        FLogger.f375446a.i("CollectImpl", "getCurrentCollectFragment, ignore unavailable fragment=" + r101);
        return null;
    L11:
        if (r102.isDetached() == true) goto L15;
        if (r102.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
        r103 = true;
    L19:
        FLogger.f375446a.i("CollectImpl", "getCurrentCollectFragment, fragment=" + r101);
        return r101;
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.collection.profile.api.ICollectService
    public final y0 h() {
        WeakReference<y0> r100 = this.f325585b;
        if (r100 == null) goto L5;
        y0 r101 = r100.get();
    L6:
        FLogger.f375446a.i("CollectImpl", "getCurrentLikeRevisitFragment, fragment=" + r101);
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.collection.profile.api.ICollectService
    public final void j() {
        WeakReference<y0> r100 = this.f325585b;
        if (r100 == null) goto L8;
        y0 r101 = r100.get();
        if (r101 == null) goto L9;
        r101.w10();
        return;
    L9:
        return;
    }

    @Override // com.collection.profile.api.ICollectService
    public final boolean k() {
        boolean r100 = i3.f365750a.f();
        boolean r101 = IMinorService.f359156a.a();
        if (r100 == true) goto L6;
        if (r101 == true) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.collection.profile.api.ICollectService
    public final void c(y0 r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        FLogger.f375446a.i("CollectImpl", "updateFragment, fragment=" + r100);
        this.f325584a = new WeakReference(r100);
    }

    @Override // com.collection.profile.api.ICollectService
    public final void d(y0 r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        FLogger.f375446a.i("CollectImpl", "updateLikeRevisitFragment, fragment=" + r100);
        this.f325585b = new WeakReference(r100);
    }

    @Override // com.collection.profile.api.ICollectService
    public final Object e(String r110, Continuation<? super com.larus.network.http.a<CancelCollectionResponse>> r111) {
        if ((r111 instanceof CollectImpl$cancelCollect$1) == false) goto L7;
        CollectImpl$cancelCollect$1 r100 = (CollectImpl$cancelCollect$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        CollectImpl$cancelCollect$1 r112 = r100;
        Object r113 = r112.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r112.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        r110 = (String) r112.L$0;
        ResultKt.throwOnFailure(r113);
    L17:
        com.larus.network.http.a r114 = (com.larus.network.http.a) r113;
        if ((r114 instanceof y) == false) goto L23;
        y0 r104 = b();
        if (r104 == null) goto L22;
        r104.Of(r110);
    L22:
        IProfileApi.f365981a.j().postValue(Boxing.boxBoolean(false));
    L23:
        return r114;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        FLogger.f375446a.i("CollectImpl", "cancelCollect, collectionId=" + r110);
        JSONObject r105 = new JSONObject();
        r105.put("collection_id", r110);
        Unit r106 = Unit.INSTANCE;
        r112.L$0 = r110;
        r112.label = 1;
        r113 = HttpExtKt.k(ServiceType.UGC, CancelCollectionResponse.class, "/profile/collection/cancel/collection/", r105, null, null, true, null, null, null, r112, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        if (r113 != r102) goto L17;
        return r102;
    L7:
        r100 = new CollectImpl$cancelCollect$1(this, r111);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x01ac -> B:61:0x01b0). Please report as a decompilation issue!!! */
    @Override // com.collection.profile.api.ICollectService
    public final Object i(List<Message> r310, Continuation<? super Boolean> r311) {
        if ((r311 instanceof CollectImpl$cancelLikeMultiMessages$1) == false) goto L7;
        CollectImpl$cancelLikeMultiMessages$1 r100 = (CollectImpl$cancelLikeMultiMessages$1) r311;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        int r105 = 1;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        Message r106 = (Message) r100.L$2;
        Iterator r110 = (Iterator) r100.L$1;
        Ref.BooleanRef r111 = (Ref.BooleanRef) r100.L$0;
        ResultKt.throwOnFailure(r102);
        String r112 = "";
        String r113 = "CollectImpl";
        Iterator r107 = r110;
        Ref.BooleanRef r108 = r111;
    L61:
        boolean r109 = ((Boolean) r102).booleanValue();
        if (r109 == true) goto L65;
        FLogger.f375446a.i(r113, "cancelLikeFromRevisit fail, messageId=" + r106.getMessageId());
    L65:
        if (r108.element == false) goto L68;
        if (r109 == false) goto L68;
        boolean r114 = true;
    L69:
        r108.element = r114;
        Iterator r115 = r107;
        Ref.BooleanRef r116 = r108;
        r105 = 1;
    L28:
        if (r115.hasNext() == false) goto L71;
        Message r117 = (Message) r115.next();
        String r118 = r117.getConversationId();
        if (r118 != null) goto L32;
        String r119 = r112;
    L33:
        RepoDispatcher.f307729a.getClass();
        ConversationRepo r120 = RepoDispatcher.f307734f;
        r100.L$0 = r116;
        r100.L$1 = r115;
        r100.L$2 = r117;
        r100.L$3 = r119;
        r100.label = r105;
        String r121 = r119;
        Object r122 = IConversationRepoService.a.c(r120, r119, false, null, r100, 6);
        if (r122 != r103) goto L36;
        return r103;
    L36:
        String r210 = r112;
        String r211 = r113;
        String r123 = r121;
        Ref.BooleanRef r124 = r116;
        Iterator r125 = r115;
        r102 = r122;
        r106 = r117;
    L37:
        e r126 = (e) r102;
        if (r126 == null) goto L50;
        Integer r127 = r126.f559207j;
        if (r127 == null) goto L50;
        if (r127.intValue() != 0) goto L44;
        boolean r128 = true;
    L45:
        if (r128 == false) goto L48;
        r127 = null;
    L48:
        if (r127 == null) goto L50;
        int r129 = r127.intValue();
    L51:
        String r130 = r106.getMessageId();
        if (r130 != null) goto L54;
        String r131 = r210;
    L55:
        r108 = r124;
        r107 = r125;
        m r132 = new m(r123, r131, MsgFeedbackType.MsgFeedbackTypeDefault, 0, null, null, null, null, null, null, Boxing.boxInt(r129), true, null, 5112);
        r100.L$0 = r108;
        r100.L$1 = r107;
        r100.L$2 = r106;
        r100.L$3 = null;
        r100.label = 2;
        j r133 = new j(IntrinsicsKt.intercepted(r100), 1);
        r133.C();
        FlowFeedbackServiceDelegate.f343027a.g(new q99.m(r132, null, null, null, null, null, null, 126), new com.larus.collection.impl.a(r132, r133));
        r102 = r133.B();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L58;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L58:
        if (r102 != r103) goto L60;
        return r103;
    L60:
        r112 = r210;
        r113 = r211;
        goto L61
    L54:
        r131 = r130;
        goto L55
    L44:
        r128 = false;
    L50:
        r129 = 3;
        goto L51
    L32:
        r119 = r118;
        goto L33
    L71:
        return Boxing.boxBoolean(r116.element);
    L68:
        r114 = false;
        goto L69
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r134 = (String) r100.L$3;
        Message r135 = (Message) r100.L$2;
        Iterator r136 = (Iterator) r100.L$1;
        Ref.BooleanRef r137 = (Ref.BooleanRef) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r210 = "";
        r211 = "CollectImpl";
        r125 = r136;
        r124 = r137;
        r123 = r134;
        r106 = r135;
        goto L37
    L16:
        ResultKt.throwOnFailure(r102);
        if (r310.isEmpty() == false) goto L20;
        FLogger.f375446a.w("CollectImpl", "cancelLikeFromRevisit, messageList is empty");
        return Boxing.boxBoolean(false);
    L20:
        r116 = new Ref.BooleanRef();
        r116.element = true;
        ArrayList r138 = new ArrayList();
        Iterator<T> r139 = r310.iterator();
    L22:
        if (r139.hasNext() == false) goto L26;
        Object r140 = r139.next();
        if (o0.d(((Message) r140).getMessageId()) == false) goto L22;
        r138.add(r140);
        goto L22
    L26:
        r115 = r138.iterator();
        r112 = "";
        r113 = "CollectImpl";
    L7:
        r100 = new CollectImpl$cancelLikeMultiMessages$1(this, r311);
        goto L8
    }

    @Override // com.collection.profile.api.ICollectService
    public final Object f(@CollectionType int r110, List<Message> r111, Continuation<? super com.larus.network.http.a<SaveCollectionResponse>> r210) {
        if ((r210 instanceof CollectImpl$collectMessage$1) == false) goto L7;
        CollectImpl$collectMessage$1 r100 = (CollectImpl$collectMessage$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        CollectImpl$collectMessage$1 r112 = r100;
        Object r102 = r112.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r112.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
        boolean r105 = true;
    L21:
        com.larus.network.http.a r106 = (com.larus.network.http.a) r102;
        if ((r106 instanceof y) == false) goto L27;
        y0 r107 = b();
        if (r107 == null) goto L26;
        r107.Of(null);
    L26:
        IProfileApi.f365981a.j().postValue(Boxing.boxBoolean(r105));
    L27:
        return r106;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        FLogger.f375446a.i("CollectImpl", "collectMessage, collectionType=" + r110 + ", messages=" + r111);
        JSONObject r108 = new JSONObject();
        r108.put("collection_type", r110);
        List<Message> r109 = r111;
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator<T> r114 = r109.iterator();
    L16:
        if (r114.hasNext() == false) goto L18;
        Message r115 = (Message) r114.next();
        JSONObject r116 = new JSONObject();
        r116.put(MusicAppletPage.KEY_MESSAGE_ID, r115.getMessageId());
        r113.add(r116);
        goto L16
    L18:
        r108.put("detail_list", new JSONArray(r113));
        Unit r117 = Unit.INSTANCE;
        r112.label = 1;
        r105 = true;
        r102 = HttpExtKt.k(ServiceType.UGC, SaveCollectionResponse.class, "/profile/collection/save/collection/", r108, null, null, true, null, null, null, r112, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        if (r102 != r103) goto L21;
        return r103;
    L7:
        r100 = new CollectImpl$collectMessage$1(this, r210);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.collection.profile.api.ICollectService
    public final Object g(Message r110, int r111, Continuation<? super com.larus.network.http.a<CancelCollectionResponse>> r112) {
        if ((r112 instanceof CollectImpl$cancelMessageCollect$1) == false) goto L7;
        CollectImpl$cancelMessageCollect$1 r100 = (CollectImpl$cancelMessageCollect$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        CollectImpl$cancelMessageCollect$1 r113 = r100;
        Object r102 = r113.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r113.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L17:
        com.larus.network.http.a r105 = (com.larus.network.http.a) r102;
        if ((r105 instanceof y) == false) goto L29;
        y0 r106 = b();
        if (r106 == null) goto L26;
        CancelCollectionResponse r107 = (CancelCollectionResponse) ((y) r105).f360135b;
        if (r107 == null) goto L24;
        String r108 = r107.getCollectionId();
    L25:
        r106.Of(r108);
        goto L26
    L24:
        r108 = null;
    L26:
        IProfileApi.f365981a.j().postValue(Boxing.boxBoolean(false));
        Activity r109 = AppHost.f326268a.a().getCurrentActivity();
        if (r109 == null) goto L29;
        s.f544207a.g(r109, R.string.larus_undo_toast, false);
    L29:
        return r105;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        FLogger.f375446a.i("CollectImpl", "cancelMessageCollect, message");
        JSONObject r114 = new JSONObject();
        r114.put("reference_id", r110.getMessageId());
        r114.put("collection_type", r111);
        Unit r115 = Unit.INSTANCE;
        r113.label = 1;
        r102 = HttpExtKt.k(ServiceType.UGC, CancelCollectionResponse.class, "/profile/collection/cancel/collection/", r114, null, null, true, null, null, null, r113, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        if (r102 != r103) goto L17;
        return r103;
    L7:
        r100 = new CollectImpl$cancelMessageCollect$1(this, r112);
        goto L8
    }
}
