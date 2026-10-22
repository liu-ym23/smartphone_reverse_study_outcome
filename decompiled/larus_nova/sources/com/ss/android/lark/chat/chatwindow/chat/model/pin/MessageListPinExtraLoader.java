package com.ss.android.lark.chat.chatwindow.chat.model.pin;

import com.bytedance.lark.pb.im.v1.ChatPinInfo;
import com.bytedance.lark.pb.im.v1.GetChatPinInfoRequest;
import com.bytedance.lark.pb.im.v1.GetChatPinInfoResponse;
import com.bytedance.lark.pb.im.v1.PushChatPinInfo;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.chat.entity.message.AnnouncementUniversalPinExtra;
import com.ss.android.lark.chat.entity.message.MessageUniversalPinExtra;
import com.ss.android.lark.chat.entity.message.UniversalPinExtra;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes35.dex */
public final class MessageListPinExtraLoader implements CoroutineScope {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f413353j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f413354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f413355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineContext f413356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f413357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f413358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f413359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f413360g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile Long f413361h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicLong f413362i;

    public static final class a {
    }

    public interface b {
        void a(Map<Long, MessageUniversalPinExtra> r100);
    }

    static {
    }

    public final void b() {
        if (this.f413355b == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(this, (ExecutorCoroutineDispatcher) this.f413357d.getValue(), null, new MessageListPinExtraLoader$create$1(this, null), 2, null);
        BuildersKt.launch$default(this, (ExecutorCoroutineDispatcher) this.f413357d.getValue(), null, new MessageListPinExtraLoader$create$2(this, null), 2, null);
    }

    public final CopyOnWriteArrayList<UniversalPinExtra> c() {
        return (CopyOnWriteArrayList) this.f413359f.getValue();
    }

    public final ConcurrentHashMap<Long, MessageUniversalPinExtra> d() {
        return (ConcurrentHashMap) this.f413360g.getValue();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f413356c;
    }

    public final Object f(Continuation<? super Unit> r110) {
        if ((r110 instanceof MessageListPinExtraLoader$loadSync$1) == false) goto L7;
        MessageListPinExtraLoader$loadSync$1 r100 = (MessageListPinExtraLoader$loadSync$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L19:
        com.larksuite.rucket.job.base.b r112 = (com.larksuite.rucket.job.base.b) r111;
        if ((r112 instanceof com.larksuite.rucket.job.base.b.C3939b) == false) goto L25;
        StringBuilder r105 = new StringBuilder("Error get chat ");
        r105.append(this.f413354a);
        r105.append(" pin info for message list: ");
        String r113 = ((com.larksuite.rucket.job.base.b.C3939b) r112).f286078b.getDisplayMsg();
        if (r113 != null) goto L24;
        r113 = "";
    L24:
        r105.append(r113);
        Log.e("ChatPinModel_Message_List", r105.toString());
    L61:
        return Unit.INSTANCE;
    L25:
        GetChatPinInfoResponse r106 = (GetChatPinInfoResponse) r112.b();
        if (this.f413362i.get() <= ((GetChatPinInfoResponse) r112.b()).version.longValue()) goto L29;
        Log.i("ChatPinModel_Message_List", "current version is newer than response ");
        return Unit.INSTANCE;
    L29:
        Long r107 = null;
        com.ss.android.lark.chat.entity.chatter.a r108 = j.b(((GetChatPinInfoResponse) r112.b()).entity, null);
        d().clear();
        c().clear();
        Iterator<T> r109 = r106.infos.iterator();
    L31:
        if (r109.hasNext() == false) goto L35;
        ChatPinInfo r114 = (ChatPinInfo) r109.next();
        UniversalPinExtra.a r115 = UniversalPinExtra.Companion;
        Intrinsics.checkNotNull(r114);
        String r116 = this.f413354a;
        r115.getClass();
        UniversalPinExtra r117 = UniversalPinExtra.a.a(r114, r116, r108);
        if (r117 == null) goto L31;
        c().add(r117);
        goto L31
    L35:
        CopyOnWriteArrayList<UniversalPinExtra> r118 = c();
        ArrayList r119 = new ArrayList();
        Iterator<T> r120 = r118.iterator();
    L37:
        if (r120.hasNext() == false) goto L41;
        Object r121 = r120.next();
        if ((r121 instanceof MessageUniversalPinExtra) == false) goto L37;
        r119.add(r121);
        goto L37
    L41:
        Iterator r122 = r119.iterator();
    L43:
        if (r122.hasNext() == false) goto L45;
        MessageUniversalPinExtra r123 = (MessageUniversalPinExtra) r122.next();
        d().put(Boxing.boxLong(r123.getMessageId()), r123);
        goto L43
    L45:
        Iterator<T> r124 = c().iterator();
    L47:
        if (r124.hasNext() == false) goto L51;
        Object r125 = r124.next();
        if ((((UniversalPinExtra) r125) instanceof AnnouncementUniversalPinExtra) == false) goto L47;
    L52:
        UniversalPinExtra r126 = (UniversalPinExtra) r125;
        if (r126 == null) goto L55;
        r107 = r126.getPinId();
    L55:
        this.f413361h = r107;
        StringBuilder r127 = new StringBuilder("[getPinInfo] update chat ");
        r127.append(this.f413354a);
        r127.append(" pin info for message list, size = ");
        r127.append(d().size());
        r127.append(", has announcement = ");
        if (this.f413361h != null) goto L59;
        r104 = false;
    L59:
        r127.append(r104);
        r127.append(", version = ");
        r127.append(r106.version);
        Log.i("ChatPinModel_Message_List", r127.toString());
        this.f413362i.set(((GetChatPinInfoResponse) r112.b()).version.longValue());
        goto L61
    L51:
        r125 = null;
        goto L52
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        Long r128 = StringsKt.toLongOrNull(this.f413354a);
        if (r128 == null) goto L63;
        RucketJob<GetChatPinInfoResponse> r129 = ((com.ss.android.lark.chat.chatwindow.chat.model.pin.a) b38.b.f17382a.create(com.ss.android.lark.chat.chatwindow.chat.model.pin.a.class)).getChatPinExtras(new GetChatPinInfoRequest.Builder().chat_id(Boxing.boxLong(r128.longValue())).build());
        r100.label = 1;
        r111 = r129.awaitGet(r100);
        if (r111 != r102) goto L19;
        return r102;
    L63:
        return Unit.INSTANCE;
    L7:
        r100 = new MessageListPinExtraLoader$loadSync$1(this, r110);
        goto L8
    }

    public MessageListPinExtraLoader(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        this.f413354a = r100;
        this.f413355b = r101;
        this.f413356c = SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain());
        this.f413357d = LazyKt.lazy(MessageListPinExtraLoader$dispatcher$2.INSTANCE);
        this.f413358e = LazyKt.lazy(MessageListPinExtraLoader$listeners$2.INSTANCE);
        this.f413359f = LazyKt.lazy(MessageListPinExtraLoader$allExtraInfo$2.INSTANCE);
        this.f413360g = LazyKt.lazy(MessageListPinExtraLoader$messageExtraInfoMap$2.INSTANCE);
        this.f413362i = new AtomicLong(-1);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0082 -> B:17:0x0058). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0097 -> B:17:0x0058). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0198 -> B:17:0x0058). Please report as a decompilation issue!!! */
    public static final Object a(MessageListPinExtraLoader r110, Continuation r111) {
        r110.getClass();
        if ((r111 instanceof MessageListPinExtraLoader$startPush$1) == false) goto L7;
        MessageListPinExtraLoader$startPush$1 r100 = (MessageListPinExtraLoader$startPush$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        com.larksuite.rucket.job.extension.a<com.larksuite.rucket.job.base.b<PushChatPinInfo>> r104 = (com.larksuite.rucket.job.extension.a) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L17:
        r100.L$0 = r104;
        r100.label = 1;
        r112 = r104.hasNext(r100);
        if (r112 != r102) goto L21;
        return r102;
    L21:
        if (((Boolean) r112).booleanValue() == false) goto L63;
        PushChatPinInfo r113 = (PushChatPinInfo) r104.a().b();
        if (Intrinsics.areEqual(r113.chat_id, StringsKt.toLongOrNull(r110.f413354a)) == false) goto L17;
        if (r110.f413362i.get() <= r113.version.longValue()) goto L28;
        Log.i("ChatPinModel_Message_List", "current version is newer than response ");
        goto L17
    L28:
        com.ss.android.lark.chat.entity.chatter.a r105 = j.b(r113.entity, null);
        r110.d().clear();
        r110.c().clear();
        Iterator<T> r106 = r113.infos.iterator();
    L30:
        if (r106.hasNext() == false) goto L34;
        ChatPinInfo r107 = (ChatPinInfo) r106.next();
        UniversalPinExtra.a r114 = UniversalPinExtra.Companion;
        Intrinsics.checkNotNull(r107);
        String r115 = r110.f413354a;
        r114.getClass();
        UniversalPinExtra r108 = UniversalPinExtra.a.a(r107, r115, r105);
        if (r108 == null) goto L30;
        r110.c().add(r108);
        goto L30
    L34:
        CopyOnWriteArrayList<UniversalPinExtra> r109 = r110.c();
        ArrayList r116 = new ArrayList();
        Iterator<T> r117 = r109.iterator();
    L36:
        if (r117.hasNext() == false) goto L40;
        Object r118 = r117.next();
        if ((r118 instanceof MessageUniversalPinExtra) == false) goto L36;
        r116.add(r118);
        goto L36
    L40:
        Iterator r119 = r116.iterator();
    L42:
        if (r119.hasNext() == false) goto L44;
        MessageUniversalPinExtra r120 = (MessageUniversalPinExtra) r119.next();
        r110.d().put(Boxing.boxLong(r120.getMessageId()), r120);
        goto L42
    L44:
        Iterator<T> r121 = r110.c().iterator();
    L46:
        if (r121.hasNext() == false) goto L50;
        Object r122 = r121.next();
        if ((((UniversalPinExtra) r122) instanceof AnnouncementUniversalPinExtra) == false) goto L46;
    L51:
        UniversalPinExtra r123 = (UniversalPinExtra) r122;
        if (r123 == null) goto L54;
        Long r124 = r123.getPinId();
    L55:
        r110.f413361h = r124;
        StringBuilder r125 = new StringBuilder("[pushChatPinInfo] update chat ");
        r125.append(r110.f413354a);
        r125.append(" pin info for message list, size = ");
        r125.append(r110.d().size());
        r125.append(", has announcement = ");
        if (r110.f413361h == null) goto L58;
        boolean r126 = true;
    L59:
        r125.append(r126);
        r125.append(", version = ");
        r125.append(r113.version);
        Log.i("ChatPinModel_Message_List", r125.toString());
        r110.f413362i.set(r113.version.longValue());
        MessageListPinExtraLoader$startPush$5 r127 = new MessageListPinExtraLoader$startPush$5(r110, null);
        r100.L$0 = r104;
        r100.label = 2;
        if (CoroutineScopeKt.coroutineScope(r127, r100) != r102) goto L17;
        return r102;
    L58:
        r126 = false;
        goto L59
    L54:
        r124 = null;
        goto L55
    L50:
        r122 = null;
        goto L51
    L63:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r104 = (com.larksuite.rucket.job.extension.a) r100.L$0;
        ResultKt.throwOnFailure(r112);
        goto L21
    L16:
        ResultKt.throwOnFailure(r112);
        r104 = ((com.ss.android.lark.chat.chatwindow.chat.model.pin.a) b38.b.f17382a.create(com.ss.android.lark.chat.chatwindow.chat.model.pin.a.class)).pushChatPinExtras().iterator();
    L7:
        r100 = new MessageListPinExtraLoader$startPush$1(r110, r111);
        goto L8
    }

    public final Object e(List<Long> r100, Continuation<? super Map<Long, ? extends UniversalPinExtra>> r110) {
        if ((r110 instanceof MessageListPinExtraLoader$getUniversalPinExtras$1) == false) goto L7;
        MessageListPinExtraLoader$getUniversalPinExtras$1 r101 = (MessageListPinExtraLoader$getUniversalPinExtras$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        r100 = (List) r101.L$0;
        ResultKt.throwOnFailure(r111);
    L19:
        HashMap r112 = new HashMap();
        Iterator<T> r105 = r100.iterator();
    L21:
        if (r105.hasNext() == false) goto L25;
        long r106 = ((Number) r105.next()).longValue();
        MessageUniversalPinExtra r107 = d().get(Boxing.boxLong(r106));
        if (r107 == null) goto L21;
        r112.put(Boxing.boxLong(r106), r107);
        goto L21
    L25:
        return r112;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        if (this.f413362i.get() != (-1)) goto L19;
        r101.L$0 = r100;
        r101.label = 1;
        if (f(r101) != r103) goto L19;
        return r103;
    L7:
        r101 = new MessageListPinExtraLoader$getUniversalPinExtras$1(this, r110);
        goto L8
    }
}
