package com.larus.bmhome.social.userchat.model;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.internal.core.conversation.ConversationReceiverServiceImpl;
import com.larus.im.internal.core.conversation.bot.BotServiceImpl;
import com.larus.im.internal.legacy.NativeConversationServiceImpl;
import com.larus.utils.logger.FLogger;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes26.dex */
public final class ChatConversationRequestModel {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f314048r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f314049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f314050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f314051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f314052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f314053e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f314054f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NativeConversationServiceImpl f314055g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConversationReceiverServiceImpl f314056h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BotServiceImpl f314057i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableLiveData<wc9.e> f314058j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MutableLiveData f314059k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LiveData<com.larus.bmhome.social.userchat.model.a> f314060l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public h f314061m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final MutableLiveData<wc9.e> f314062n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final MutableLiveData f314063o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f314064p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f314065q;

    public static final class a {
    }

    public static final class b implements com.larus.im.service.d0<wc9.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatConversationRequestModel f314066a;

        public b(ChatConversationRequestModel r100) {
            this.f314066a = r100;
        }

        @Override // com.larus.im.service.z
        public final void c(Object r100) {
            final wc9.e r101 = (wc9.e) r100;
            Intrinsics.checkNotNullParameter(r101, "conversation");
            FLogger.f375446a.i(this.f314066a.f314065q, "Conversation onChange " + r101);
            SoftReference<Handler> r102 = com.larus.utils.y.f375498a;
            final ChatConversationRequestModel r103 = this.f314066a;
            com.larus.utils.y.c(new e(r103, r101));
        }

        @Override // com.larus.im.service.d0
        public final void a(wc9.e r100, final wc9.e r101) {
            Intrinsics.checkNotNullParameter(r101, "new");
            SoftReference<Handler> r102 = com.larus.utils.y.f375498a;
            final ChatConversationRequestModel r103 = this.f314066a;
            com.larus.utils.y.c(new d(r103, r101));
        }
    }

    static {
    }

    public final Map<String, String> c() {
        String r100 = this.f314051c;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L20;
        String r103 = this.f314053e;
        if (r103 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == false) goto L20;
        return null;
    L13:
        if (r103.length() == 0) goto L16;
        r104 = false;
    L20:
        LinkedHashMap r105 = new LinkedHashMap();
        String r106 = this.f314051c;
        if (r106 != null) goto L23;
    L26:
        boolean r107 = true;
    L27:
        if (r107 == true) goto L29;
        r105.put("push_content_id", this.f314051c);
    L29:
        String r108 = this.f314053e;
        if (r108 != null) goto L32;
    L33:
        r101 = true;
    L34:
        if (r101 == true) goto L36;
        r105.put("ug_advertise_schema", this.f314053e);
    L36:
        return r105;
    L32:
        if (r108.length() != 0) goto L34;
    L23:
        if (r106.length() == 0) goto L26;
        r107 = false;
        goto L27
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final void d() {
        com.larus.bmhome.social.userchat.model.a r100 = this.f314060l.getValue();
        if (r100 == null) goto L12;
        BotModel r101 = r100.f314112b;
        if (r101 == null) goto L13;
        String r102 = r101.getBotId();
        if (r102 == null) goto L14;
        h r103 = this.f314061m;
        if (r103 == null) goto L15;
        this.f314057i.unregisterBotChangeListener(r102, r103);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public static final void a(ChatConversationRequestModel r100, wc9.e r101) {
        r100.getClass();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.f314058j.setValue(r101);
        return;
    L5:
        r100.f314058j.postValue(r101);
    }

    public final Object b(String r110, String r111, MutableLiveData<com.larus.bmhome.social.userchat.model.a> r112, Continuation<? super Unit> r113) {
        if ((r113 instanceof ChatConversationRequestModel$getBotFromDbAndServer$1) == false) goto L7;
        ChatConversationRequestModel$getBotFromDbAndServer$1 r100 = (ChatConversationRequestModel$getBotFromDbAndServer$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r100.label) {
            case 0: goto L19;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r114);
    L56:
        return Unit.INSTANCE;
    L13:
        MutableLiveData<com.larus.bmhome.social.userchat.model.a> r115 = (MutableLiveData) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L52:
        MainCoroutineDispatcher r116 = Dispatchers.getMain();
        ChatConversationRequestModel$getBotFromDbAndServer$4 r117 = new ChatConversationRequestModel$getBotFromDbAndServer$4((BotModel) r114, this, r115, null);
        r100.L$0 = null;
        r100.label = 6;
        if (BuildersKt.withContext(r116, r117, r100) != r102) goto L56;
        return r102;
    L14:
        ResultKt.throwOnFailure(r114);
    L45:
        return Unit.INSTANCE;
    L15:
        MutableLiveData<com.larus.bmhome.social.userchat.model.a> r118 = (MutableLiveData) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L41:
        MainCoroutineDispatcher r119 = Dispatchers.getMain();
        ChatConversationRequestModel$getBotFromDbAndServer$3 r120 = new ChatConversationRequestModel$getBotFromDbAndServer$3(r118, (BotModel) r114, null);
        r100.L$0 = null;
        r100.label = 4;
        if (BuildersKt.withContext(r119, r120, r100) != r102) goto L45;
        return r102;
    L16:
        BotModel r121 = (BotModel) r100.L$2;
        MutableLiveData<com.larus.bmhome.social.userchat.model.a> r122 = (MutableLiveData) r100.L$1;
        String r123 = (String) r100.L$0;
        ResultKt.throwOnFailure(r114);
        String r103 = r123;
    L32:
        if (this.f314054f == true) goto L47;
        IBotRepoService r104 = RepoDispatcherDelegate.f307737b.b();
        String r124 = r121.getBotId();
        if (r124 != null) goto L36;
        String r105 = "";
    L37:
        r100.L$0 = r122;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.label = 3;
        r114 = IBotRepoService.b.a(r104, r105, true, r103, false, r100, 24);
        if (r114 != r102) goto L40;
        return r102;
    L40:
        r118 = r122;
        goto L41
    L36:
        r105 = r124;
        goto L37
    L47:
        return Unit.INSTANCE;
    L17:
        r112 = (MutableLiveData) r100.L$2;
        r111 = (String) r100.L$1;
        r110 = (String) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L18:
        String r106 = r110;
        r121 = (BotModel) r114;
        if (r121 == null) goto L48;
        String r125 = r121.getBotId();
        if (r125 != null) goto L27;
        r125 = "";
    L27:
        d();
        h r107 = new h(r112);
        this.f314061m = r107;
        this.f314057i.registerBotChangeListener(r125, r107);
        MainCoroutineDispatcher r126 = Dispatchers.getMain();
        ChatConversationRequestModel$getBotFromDbAndServer$2 r108 = new ChatConversationRequestModel$getBotFromDbAndServer$2(r112, r121, null);
        r100.L$0 = r111;
        r100.L$1 = r112;
        r100.L$2 = r121;
        r100.label = 2;
        if (BuildersKt.withContext(r126, r108, r100) != r102) goto L30;
        return r102;
    L30:
        r103 = r111;
        r122 = r112;
        goto L32
    L48:
        IBotRepoService r109 = RepoDispatcherDelegate.f307737b.b();
        r100.L$0 = r112;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.label = 5;
        r114 = IBotRepoService.b.a(r109, r106, true, null, false, r100, 28);
        if (r114 != r102) goto L51;
        return r102;
    L51:
        r115 = r112;
        goto L52
    L19:
        ResultKt.throwOnFailure(r114);
        IBotRepoService r127 = RepoDispatcherDelegate.f307737b.b();
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.L$2 = r112;
        r100.label = 1;
        r114 = IBotRepoService.b.a(r127, r110, false, null, false, r100, 30);
        if (r114 != r102) goto L18;
        return r102;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r100 = new ChatConversationRequestModel$getBotFromDbAndServer$1(this, r113);
        goto L8
    }

    public ChatConversationRequestModel(String r100, boolean r101, String r102, CoroutineScope r103, String r104, boolean r105, String r106) {
        Intrinsics.checkNotNullParameter(r103, "scope");
        this.f314049a = r100;
        this.f314050b = r101;
        this.f314051c = r102;
        this.f314052d = r103;
        this.f314053e = r104;
        this.f314054f = r105;
        if (com.larus.platform.exp.c.f365374d == false) goto L5;
        RepoDispatcherDelegate.f307737b.b().g1(r100, r106);
    L5:
        this.f314055g = com.larus.im.d.d();
        this.f314056h = com.larus.im.d.c();
        this.f314057i = com.larus.im.d.a();
        MutableLiveData<wc9.e> r107 = new MutableLiveData();
        this.f314058j = r107;
        this.f314059k = r107;
        final MediatorLiveData r108 = new MediatorLiveData();
        r108.addSource(r107, new ChatConversationRequestModel$special$$inlined$distinctUntilChanged$1(r108));
        this.f314060l = Transformations.switchMap(r108, new c(this));
        MutableLiveData<wc9.e> r109 = new MutableLiveData();
        this.f314062n = r109;
        this.f314063o = r109;
        this.f314064p = new b(this);
        this.f314065q = "ChatConversationRequestModel_" + hashCode();
    }
}
