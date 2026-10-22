package com.ss.android.lark.im.sdk.service;

import android.os.Looper;
import com.alibaba.fastjson.JSON;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v1.MGetChattersRequest;
import com.bytedance.lark.pb.contact.v1.MGetChattersResponse;
import com.bytedance.lark.pb.contact.v1.UpdateChatterRequest;
import com.bytedance.lark.pb.contact.v1.UpdateChatterResponse;
import com.bytedance.lark.pb.im.v1.DeleteContactRequest;
import com.bytedance.lark.pb.im.v1.DeleteContactResponse;
import com.bytedance.lark.pb.im.v1.GetChatApplicationBadgeRequest;
import com.bytedance.lark.pb.im.v1.GetChatApplicationBadgeResponse;
import com.bytedance.lark.pb.im.v1.GetChatChattersByIdsRequest;
import com.bytedance.lark.pb.im.v1.GetChatChattersByIdsResponse;
import com.google.gson.Gson;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.utils.z0;
import com.ss.android.lark.contact.customized.externalcontact.repository.NewFriendBadgeRepository$getBadge$1;
import com.ss.android.lark.contact.customized.externalcontact.view.OfficeExternalContactViewModel;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.rxjava.LarkRxSchedulers;
import com.ss.android.lark.utils.rxjava.ReportErrorConsumer;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@UserScope
public final class ImSdkChatterServiceImplV2 implements com.ss.android.lark.im.sdk.service.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f426006c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f426007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Chatter f426008b;

    public static final class a {
        public a() {
        }

        public static final ErrorResult a(String r100) {
            int r101 = ImSdkChatterServiceImplV2.f426006c;
            Exception r102 = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
            ErrorResult r103 = new ErrorResult(0);
            ErrorResult.access$002(r103, -1);
            ErrorResult.access$102(r103, -9999);
            ErrorResult.access$202(r103, 0);
            ErrorResult.access$302(r103, r102);
            ErrorResult.access$402(r103, "");
            ErrorResult.access$502(r103, r100);
            ErrorResult.access$602(r103, "");
            ErrorResult.access$702(r103, "");
            ErrorResult.access$802(r103, 0);
            ErrorResult.access$902(r103, null);
            ErrorResult.access$1002(r103, null);
            ErrorResult.access$1102(r103, null);
            return r103;
        }
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T, R> f426009a = null;

        static {
            f426009a = new b();
        }

        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            com.bytedance.lark.rustclient.api.x r101 = (com.bytedance.lark.rustclient.api.x) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return (DeleteContactResponse) r101.f253935c;
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f426010a;

        public c(String r100) {
            this.f426010a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            com.bytedance.lark.rustclient.api.x r101 = (com.bytedance.lark.rustclient.api.x) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return com.ss.android.lark.parser.internal.j.b(((GetChatChattersByIdsResponse) r101.f253935c).entity, this.f426010a).c();
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f426011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IGetDataCallback<Chatter> f426012b;

        public d(String r100, IGetDataCallback<Chatter> r101) {
            this.f426011a = r100;
            this.f426012b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Chatter r101 = (Chatter) ((Map) r100).get(this.f426011a);
            if (ImSdkProxy.e().a() == true) goto L7;
            if (r101 != null) goto L7;
            IGetDataCallback<Chatter> r102 = this.f426012b;
            int r103 = ImSdkChatterServiceImplV2.f426006c;
            r102.onError(a.a("Can't find target chatter!"));
            return;
        L7:
            this.f426012b.onSuccess(r101);
        }
    }

    public static final class e extends ReportErrorConsumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IGetDataCallback<Chatter> f426013a;

        public e(IGetDataCallback<Chatter> r100) {
            this.f426013a = r100;
        }

        @Override // com.ss.android.lark.utils.rxjava.ReportErrorConsumer
        public final void error(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            IGetDataCallback<Chatter> r101 = this.f426013a;
            int r102 = ImSdkChatterServiceImplV2.f426006c;
            r101.onError(a.a(r100.getMessage()));
        }
    }

    public static final class f<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f<T, R> f426014a = null;

        static {
            f426014a = new f();
        }

        public f() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            com.bytedance.lark.rustclient.api.x r101 = (com.bytedance.lark.rustclient.api.x) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return new HashMap(com.ss.android.lark.parser.internal.j.b(((MGetChattersResponse) r101.f253935c).entity, null).f415194a);
        }
    }

    public static final class g<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g<T, R> f426015a = null;

        static {
            f426015a = new g();
        }

        public g() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            com.bytedance.lark.rustclient.api.x r101 = (com.bytedance.lark.rustclient.api.x) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (((UpdateChatterResponse) r101.f253935c).message.length() != 0) goto L5;
            boolean r102 = true;
        L7:
            return Boolean.valueOf(r102);
        L5:
            r102 = false;
            goto L7
        }
    }

    public static final class h<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImSdkChatterServiceImplV2 f426018a;

        public h(ImSdkChatterServiceImplV2 r100) {
            this.f426018a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((Boolean) r100, "it");
            String r101 = ImSdkProxy.e().getCurrentUserId();
            return this.f426018a.b(CollectionsKt.listOf(r101)).map(new n(r101));
        }
    }

    static {
        new a();
    }

    public static Chatter c() {
        String r100 = ((okb.g) ImSdkProxy.f425902h.getValue()).a().getString();
        Chatter r101 = (Chatter) com.ss.android.lark.utils.z.a(r100, Chatter.class);
        if (r101 != null) goto L5;
        Log.e("ImSdkChatterServiceImplV2", "loadChatter, parseJson failed, data is:" + r100);
    L5:
        return r101;
    }

    public final Chatter a() {
        Log.i("ImSdkChatterServiceImplV2", "getLoginUser");
        if (com.larksuite.framework.utils.z.e(ImSdk.f425890a.getContext()) == false) goto L5;
        Chatter r100 = this.f426008b;
        if (r100 == null) goto L9;
        return r100;
    L9:
        Chatter r101 = c();
        this.f426008b = r101;
        return r101;
    L5:
        return c();
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Chatter zb() {
        Log.i("ImSdkChatterServiceImplV2", "getLocalLoginChatter");
        String r100 = ImSdkProxy.e().getCurrentUserId();
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        Log.e("ImSdkChatterServiceImplV2", "getLocalLoginChatter, userId is null");
        return null;
    L9:
        Chatter r102 = l7(r100);
        if (r102 == null) goto L13;
        return r102;
    L13:
        return a();
    L5:
        r101 = false;
        goto L6
    }

    @Inject
    public ImSdkChatterServiceImplV2(com.bytedance.lark.rustclient.api.l r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f426007a = r100;
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void F5(Chatter r100) {
        Gson r101 = com.ss.android.lark.utils.z.f444793a;
        if (r100 != null) goto L11;
    L7:
        String r102 = SliceInitService.DEFAULT_SWITCH;
    L8:
        ((okb.g) ImSdkProxy.f425902h.getValue()).a().b(r102);
        return;
    L11:
        r102 = JSON.toJSONString(r100);     // Catch: Throwable -> L10
        goto L8
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void L2(NewFriendBadgeRepository$getBadge$1 r110) {
        Intrinsics.checkNotNullParameter(r110, "callback");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(new GetChatApplicationBadgeRequest.Builder(), GetChatApplicationBadgeResponse.ADAPTER, Command.GET_CHAT_APPLICATION_BADGE, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.f426007a.h(r100).a()).map(i.f426101a), r110);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void W8(OfficeExternalContactViewModel.AnonymousClass1 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        RxScheduledExecutor.execInIO(new j(this), new k(r100));
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Map<String, Chatter> a0(List<String> r110) {
        Intrinsics.checkNotNullParameter(r110, "chatterIds");
        z0.a();
        if (r110.isEmpty() == true) goto L5;
        MGetChattersRequest.Builder r100 = new MGetChattersRequest.Builder();
        r100.chatter_ids(r110);
        com.bytedance.lark.rustclient.api.s r111 = this.f426007a.h(new com.bytedance.lark.rustclient.api.d(r100, MGetChattersResponse.ADAPTER, Command.MGET_CHATTERS, null, null, null, null, 248)).execute();
        Intrinsics.checkNotNullParameter(r111, "<this>");
        HashMap r101 = null;
        if ((r111 instanceof com.bytedance.lark.rustclient.api.x) == false) goto L9;
        Object r112 = ((com.bytedance.lark.rustclient.api.x) r111).f253935c;
    L10:
        MGetChattersResponse r113 = (MGetChattersResponse) r112;
        if (r113 == null) goto L13;
        r101 = new HashMap(com.ss.android.lark.parser.internal.j.b(r113.entity, null).f415194a);
    L13:
        if (r101 == null) goto L15;
        return r101;
    L15:
        return MapsKt.emptyMap();
    L9:
        r112 = null;
        goto L10
    L5:
        return MapsKt.emptyMap();
    }

    public final Observable<Map<String, Chatter>> b(List<String> r110) {
        if (CollectionUtils.isEmpty(r110) == true) goto L5;
        MGetChattersRequest.Builder r100 = new MGetChattersRequest.Builder();
        r100.chatter_ids(r110);
        r100.is_from_server(Boolean.TRUE);
        com.bytedance.lark.rustclient.api.d r111 = new com.bytedance.lark.rustclient.api.d(r100, MGetChattersResponse.ADAPTER, Command.MGET_CHATTERS, null, null, null, null, 248);
        return com.bytedance.lark.rustclient.api.t.b(this.f426007a.h(r111).a()).map(f.f426014a);
    L5:
        return Observable.just(MapsKt.emptyMap());
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Map<String, Chatter> l0(List<String> r110) {
        Intrinsics.checkNotNullParameter(r110, "chatterIds");
        if (r110.isEmpty() == true) goto L5;
        List<String> r111 = CollectionsKt.toList(r110);
        Map<String, Chatter> r100 = a0(r111);
        List<String> r112 = CollectionsKt.minus(r111, r100.keySet());
        if (r112.isEmpty() == false) goto L9;
        return r100;
    L9:
        Intrinsics.checkNotNullParameter(r112, "chatterIds");
        z0.a();
        if (r112.isEmpty() == false) goto L12;
        Map r113 = MapsKt.emptyMap();
    L28:
        return MapsKt.plus(r100, r113);
    L12:
        Observable<Map<String, Chatter>> r101 = b(r112);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L15
        Object r103 = Result.m9449constructorimpl(r101.blockingFirst());     // Catch: Throwable -> L15
    L18:
        if (Result.m9455isFailureimpl(r103) == false) goto L21;
        Log.e("ImSdkChatterServiceImplV2", "getNetChatters failed, chatters:" + CollectionsKt.joinToString$default(r112, null, null, null, 0, null, null, 63, null), Result.m9452exceptionOrNullimpl(r103));
    L21:
        if (Result.m9455isFailureimpl(r103) == false) goto L23;
        r103 = null;
    L23:
        Map r104 = (Map) r103;
        if (r104 != null) goto L26;
        r113 = MapsKt.emptyMap();
        goto L28
    L26:
        r113 = r104;
    L15:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    L5:
        return MapsKt.emptyMap();
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Chatter l7(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chatterId");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return null;
    L9:
        return a0(CollectionsKt.listOf(r100)).get(r100);
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Chatter ue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chatterId");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        return null;
    L10:
        return l0(CollectionsKt.listOf(r100)).get(r100);
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final ChatChatter x1(String r100) {
        Log.i("ImSdkChatterServiceImplV2", "getLoginChatChatter chatId:" + r100);
        String r101 = ImSdkProxy.e().getCurrentUserId();
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        Object r103 = null;
        if (r102 == false) goto L10;
        Log.i("ImSdkChatterServiceImplV2", "getLoginChatChatter userId empty");
        return null;
    L10:
        ChatChatter r104 = H5(r100, r101);
        if (r104 == null) goto L13;
        return r104;
    L13:
        Chatter r105 = a();
        if (r105 != null) goto L30;
        Log.e("ImSdkChatterServiceImplV2", "getLoginChatChatter null getLoginUser");
        return null;
    L30:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L19
        Object r107 = Result.m9449constructorimpl(new ChatChatter(r105));     // Catch: Throwable -> L19
    L22:
        if (Result.m9455isFailureimpl(r107) == false) goto L25;
        Log.e("ImSdkChatterServiceImplV2", "getLoginChatChatter failed", Result.m9452exceptionOrNullimpl(r107));
    L25:
        if (Result.m9455isFailureimpl(r107) == true) goto L29;
        r103 = r107;
    L29:
        return (ChatChatter) r103;
    L19:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Map<String, ChatChatter> A2(String r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r101, "chatterIds");
        return I3(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final ChatChatter H5(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "chatterId");
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return null;
    L9:
        return A2(r100, CollectionsKt.listOf(r101)).get(r101);
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final ChatChatter He(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "chatterId");
        z0.a();
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return null;
    L9:
        if (r100 != null) goto L11;
        r100 = "";
    L11:
        List<String> r103 = CollectionsKt.listOf(r101);
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r103, "chatterIds");
        List r104 = CollectionsKt.toList(r103);
        if (r104.isEmpty() == false) goto L14;
        Map r105 = MapsKt.emptyMap();
    L19:
        return (ChatChatter) r105.get(r101);
    L14:
        Intrinsics.checkNotNullParameter(r104, "chatterIds");
        Map r106 = I3(r100, r104);
        if (CollectionsKt.minus(r104, r106.keySet()).isEmpty() == false) goto L17;
        r105 = r106;
        goto L19
    L17:
        r105 = MapsKt.plus(r106, ld(r100, r103));
        goto L19
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Map I3(final String r110, List r111) {
        Intrinsics.checkNotNullParameter(r111, "chatterIds");
        z0.a();
        if (r111.isEmpty() == true) goto L5;
        GetChatChattersByIdsRequest.Builder r100 = new GetChatChattersByIdsRequest.Builder();
        r100.chat_id(r110);
        r100.chatter_ids(r111);
        com.bytedance.lark.rustclient.api.d r112 = new com.bytedance.lark.rustclient.api.d(r100, GetChatChattersByIdsResponse.ADAPTER, Command.GET_CHAT_CHATTERS_BY_IDS, null, null, null, null, 248);
        com.bytedance.lark.rustclient.api.s r113 = com.bytedance.lark.rustclient.api.t.e(this.f426007a.h(r112).execute(), new ImSdkChatterServiceImplV2$getLocalChatChatters$resp$2(r110));
        Intrinsics.checkNotNullParameter(r113, "<this>");
        if ((r113 instanceof com.bytedance.lark.rustclient.api.x) == false) goto L9;
        Object r114 = ((com.bytedance.lark.rustclient.api.x) r113).f253935c;
    L10:
        Map r115 = (Map) r114;
        if (r115 == null) goto L13;
        return r115;
    L13:
        return MapsKt.emptyMap();
    L9:
        r114 = null;
        goto L10
    L5:
        return MapsKt.emptyMap();
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void N7(String r110, final IGetDataCallback<Boolean> r111) {
        Intrinsics.checkNotNullParameter(r110, "contactUserId");
        Intrinsics.checkNotNullParameter(r111, "callback");
        DeleteContactRequest.Builder r100 = new DeleteContactRequest.Builder().user_id(r110);
        Intrinsics.checkNotNull(r100);
        com.bytedance.lark.rustclient.api.d r112 = new com.bytedance.lark.rustclient.api.d(r100, DeleteContactResponse.ADAPTER, Command.DELETE_CONTACT, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.f426007a.h(r112).a()).map(b.f426009a), new ImSdkChatterServiceImplV2$deleteExternalContact$2(r111));
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void j1(String r110, IGetDataCallback<Chatter> r111) {
        Intrinsics.checkNotNullParameter(r110, "avatarKey");
        Intrinsics.checkNotNullParameter(r111, "callback");
        UpdateChatterRequest.Builder r100 = new UpdateChatterRequest.Builder().icon_key(r110);
        Intrinsics.checkNotNull(r100);
        com.bytedance.lark.rustclient.api.d r112 = new com.bytedance.lark.rustclient.api.d(r100, UpdateChatterResponse.ADAPTER, Command.UPDATE_CHATTER, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.f426007a.h(r112).a()).map(g.f426015a).flatMap(new h(this)), r111);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Map<String, ChatChatter> ld(String r110, List<String> r111) {
        Intrinsics.checkNotNullParameter(r111, "chatterIds");
        z0.a();
        List<String> r100 = r111;
        if (CollectionsKt.toList(r100).isEmpty() == true) goto L5;
        GetChatChattersByIdsRequest.Builder r101 = new GetChatChattersByIdsRequest.Builder();
        r101.chat_id(r110);
        r101.chatter_ids(r111);
        r101.strategy(SyncDataStrategy.FORCE_SERVER);
        Observable r112 = com.bytedance.lark.rustclient.api.t.b(this.f426007a.h(new com.bytedance.lark.rustclient.api.d(r101, GetChatChattersByIdsResponse.ADAPTER, Command.GET_CHAT_CHATTERS_BY_IDS, null, null, null, null, 248)).a()).map(new m(r110));
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        Object r113 = Result.m9449constructorimpl((Map) r112.blockingFirst());     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r113) == false) goto L15;
        Log.e("ImSdkChatterServiceImplV2", "getNetChatChatters failed, chatId:" + r110 + ",chatters:" + CollectionsKt.joinToString$default(r100, null, null, null, 0, null, null, 63, null), Result.m9452exceptionOrNullimpl(r113));
    L15:
        if (Result.m9455isFailureimpl(r113) == false) goto L17;
        r113 = null;
    L17:
        Map<String, ChatChatter> r114 = (Map) r113;
        if (r114 == null) goto L20;
        return r114;
    L20:
        return MapsKt.emptyMap();
    L9:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L5:
        return MapsKt.emptyMap();
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void pd(String r100, IGetDataCallback<Chatter> r101) {
        Intrinsics.checkNotNullParameter(r100, "chatterId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        Scheduler r103 = LarkRxSchedulers.mainThread();
        Intrinsics.checkNotNull(r103);
    L9:
        final List r104 = CollectionsKt.toList(CollectionsKt.listOf(r100));
        Observable.create(new ImSdkChatterServiceImplV2$getChattersObservable$1(this, r104)).subscribeOn(LarkRxSchedulers.io()).observeOn(r103).subscribe(new d(r100, r101), new e(r101));
        return;
    L8:
        r103 = LarkRxSchedulers.io();
        Intrinsics.checkNotNull(r103);
        goto L9
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Pair<ChatChatter, OpenApp> qb(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "botId");
        z0.a();
        List<String> r100 = CollectionsKt.mutableListOf(new String[]{r111});
        GetChatChattersByIdsRequest.Builder r101 = new GetChatChattersByIdsRequest.Builder();
        r101.chat_id(r110);
        r101.chatter_ids(r100);
        r101.strategy(SyncDataStrategy.FORCE_SERVER);
        Observable r102 = com.bytedance.lark.rustclient.api.t.b(this.f426007a.h(new com.bytedance.lark.rustclient.api.d(r101, GetChatChattersByIdsResponse.ADAPTER, Command.GET_CHAT_CHATTERS_BY_IDS, null, null, null, null, 248)).a()).map(new l(r110));
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl((Map) r102.blockingFirst());     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r104) == false) goto L11;
        Log.e("ImSdkChatterServiceImplV2", "getNetChatChattersAndOpenApp failed, chatId:" + r110 + ",chatters:" + CollectionsKt.joinToString$default(r100, null, null, null, 0, null, null, 63, null), Result.m9452exceptionOrNullimpl(r104));
    L11:
        if (Result.m9455isFailureimpl(r104) == false) goto L13;
        r104 = null;
    L13:
        Map r105 = (Map) r104;
        if (r105 != null) goto L17;
        r105 = MapsKt.emptyMap();
    L17:
        return (Pair) r105.get(r111);
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void v3(List<String> r100, IGetDataCallback<Map<String, Chatter>> r101) {
        Intrinsics.checkNotNullParameter(r100, "chatterIds");
        Intrinsics.checkNotNullParameter(r101, "callback");
        com.ss.android.lark.im.sdk.utils.e.a(b(r100), r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void E9(String r110, List<String> r111, IGetDataCallback<Map<String, ChatChatter>> r112) {
        Intrinsics.checkNotNullParameter(r110, "chatId");
        Intrinsics.checkNotNullParameter(r111, "chatterIds");
        Intrinsics.checkNotNullParameter(r112, "callback");
        GetChatChattersByIdsRequest.Builder r100 = new GetChatChattersByIdsRequest.Builder();
        r100.chat_id(r110).chatter_ids(r111);
        com.bytedance.lark.rustclient.api.d r113 = new com.bytedance.lark.rustclient.api.d(r100, GetChatChattersByIdsResponse.ADAPTER, Command.GET_CHAT_CHATTERS_BY_IDS, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.f426007a.h(r113).a()).map(new c(r110)), r112);
    }
}
