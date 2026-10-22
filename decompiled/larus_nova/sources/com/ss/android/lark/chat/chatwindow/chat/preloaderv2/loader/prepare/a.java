package com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare;

import android.util.LruCache;
import com.larksuite.framework.utils.i0;
import com.ss.android.lark.biz.im.api.ChatWindowPrepareData;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.biz.im.api.h0;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.thread.TopicGroup;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.h;
import com.ss.android.lark.im.sdk.service.x;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.passportc.dwarf.UserScope;
import h7b.j;
import javax.inject.Inject;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import m6b.t;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class a implements com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.b, r {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f413502k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f413503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f413504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImSdkChatService f413505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f413506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final x f413507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final t f413508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CoroutineScope f413509g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LruCache<String, Chat> f413510h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i0<ChatChatter> f413511i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f413512j;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.a$a, reason: collision with other inner class name */
    public static final class C4817a {
    }

    public static final class b implements h0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f413513a;

        public b(a r100) {
            this.f413513a = r100;
        }

        @Override // com.ss.android.lark.biz.im.api.h0
        public final void a(Chatter r100) {
            a r101 = this.f413513a;
            r101.getClass();
            if (r100 != null) goto L6;
            return;
        L6:
            if ((r100 instanceof ChatChatter) == false) goto L14;
            ChatChatter r102 = (ChatChatter) r100;
            ChatChatter r103 = r101.f413511i.a(r102.getChatId(), r102.getId());
            if (r103 != null) goto L11;
            return;
        L11:
            if (r103.getUpdateTime() > r102.getUpdateTime()) goto L15;
            r101.f413511i.b(r102.getId(), r102.getId(), r102);
            return;
        L15:
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final m getPassport() {
        return this.f413503a;
    }

    public final ChatWindowPrepareData c(String r100) {
        com.ss.android.lark.chat.entity.chat.a r101 = this.f413505c.nd(r100);
        if (r101 != null) goto L6;
        Log.e("ChatPrepareDataLoader", "prepare botChat in ChatWindow , but cannot get botChat" + r100);
        return null;
    L6:
        Chat r102 = r101.f415170a;
        if (r102 == null) goto L10;
        this.f413510h.put(r100, r102);
    L10:
        if (this.f413511i.a(r100, this.f413504b) != null) goto L12;
        i0<ChatChatter> r103 = this.f413511i;
        String r104 = this.f413504b;
        r103.b(r100, r104, this.f413506d.He(r100, r104));
    L12:
        if (r102 != null) goto L16;
        Log.e("ChatPrepareDataLoader", "prepare chat in ChatWindow , but cannot get chat" + r100);
        return null;
    L16:
        if (r102.getType() != Chat.Type.P2P) goto L28;
        String r105 = this.f413505c.getOtherP2PChatterId(r102);
        if (r105 != null) goto L22;
        return b(r100, r101.f415171b, r101.f415173d);
    L22:
        if (this.f413511i.a(r100, r105) != null) goto L28;
        Chatter r106 = r101.f415172c;
        if (r106 == null) goto L26;
        this.f413511i.b(r100, r105, new ChatChatter(r106));
        goto L28
    L26:
        this.f413511i.b(r100, r105, this.f413506d.He(r100, r105));
    L28:
        return b(r100, r101.f415171b, r101.f415173d);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f413508f.te(this.f413512j);
        CoroutineScope r101 = this.f413509g;
        if (r101 == null) goto L5;
        CoroutineScopeKt.cancel$default(r101, null, 1, null);
    L5:
        this.f413509g = null;
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f413508f.J1(this.f413512j);
        this.f413509g = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.b
    public final ChatWindowPrepareData a(String r100, Continuation r101) {
        return c(r100);
    }

    public final ChatWindowPrepareData b(String r100, OpenApp r110, ChatThemeInfo r111) {
        ChatChatter r101 = this.f413511i.a(r100, this.f413504b);
        Chat r102 = this.f413510h.get(r100);
        if (r102.getType() != Chat.Type.P2P) goto L17;
        Intrinsics.checkNotNull(r102);
        j.a r103 = new j(r102, this.f413506d).a();
        if (r103 == null) goto L7;
        ChatChatter r104 = r103.f484037a;
    L8:
        if (r104 != null) goto L10;
        Log.e("ChatPrepareDataLoader", "opening p2p chat in ChatWindow , but cannot get chatter");
        return null;
    L10:
        ChatChatter r105 = r103.f484037a;
        OpenApp r106 = r103.f484038b;
        if (r106 != null) goto L13;
        OpenApp r107 = r110;
    L15:
        return new ChatWindowPrepareData(r102, r105, r101, r107, null, r111);
    L13:
        r107 = r106;
        goto L15
    L7:
        r104 = null;
        goto L8
    L17:
        if (r102.getChatMode() != Chat.ChatMode.THREAD_V2) goto L26;
        TopicGroup r108 = this.f413507e.fc(r100);
        if (r108 != null) goto L21;
    L23:
        Log.i("ChatPrepareDataLoader", "prepare chat from cache chat");
        return new ChatWindowPrepareData(r102, null, r101, r110, r108, r111);
    L21:
        if (r108.getChat() == null) goto L23;
        Log.i("ChatPrepareDataLoader", "prepare chat from topGroup");
        return new ChatWindowPrepareData(r108.getChat(), null, r101, r110, r108, r111);
    L26:
        return new ChatWindowPrepareData(r102, null, r101, r110, null, r111);
    }

    @Inject
    public a(m r100, String r101, ImSdkChatService r102, h r103, x r104, t r105) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r102, "chatService");
        Intrinsics.checkNotNullParameter(r103, "chatterService");
        Intrinsics.checkNotNullParameter(r104, "threadService");
        Intrinsics.checkNotNullParameter(r105, "chatterPush");
        this.f413503a = r100;
        this.f413504b = r101;
        this.f413505c = r102;
        this.f413506d = r103;
        this.f413507e = r104;
        this.f413508f = r105;
        r100.d(this);
        this.f413510h = new LruCache(200);
        this.f413511i = new i0();
        this.f413512j = new b(this);
    }
}
