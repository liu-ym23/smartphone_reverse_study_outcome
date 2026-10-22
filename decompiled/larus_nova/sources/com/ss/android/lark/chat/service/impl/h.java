package com.ss.android.lark.chat.service.impl;

import android.text.TextUtils;
import com.bytedance.lark.pb.im.v1.DoubaoTyping;
import com.bytedance.lark.pb.im.v1.PushDoubaoSmartReply;
import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.bytedance.lark.pb.im.v1.PushMessageReadStates;
import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class h implements m6b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m6b.d f416482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f416483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m6b.o f416484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C4875h f416485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f416486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f416487f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f416488g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g f416489h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f416490i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f416491j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e f416492k;

    public static final class a {
    }

    public static final class b implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f416493a;

        public b(h r100) {
            this.f416493a = r100;
        }

        @Override // com.ss.android.lark.chat.service.impl.x
        public final void a(Chat r100, Map<String, ChatChatter> r101) {
            if (r100 == null) goto L8;
            if (r101 == null) goto L9;
            m6b.o r102 = this.f416493a.f416484c;
            if (r102 == null) goto L10;
            r102.h(r100, r101);
            return;
        L10:
            return;
        L9:
            return;
        }
    }

    public static final class c implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f416494a;

        public c(h r100) {
            this.f416494a = r100;
        }

        @Override // com.ss.android.lark.chat.service.impl.y
        public final void onPushChat(Chat r100) {
            if (r100 == null) goto L7;
            m6b.o r101 = this.f416494a.f416484c;
            if (r101 == null) goto L8;
            r101.onPushChat(r100);
            return;
        L8:
            return;
        }

        @Override // com.ss.android.lark.chat.service.impl.y
        public final void onPushThreadTopic(ThreadTopic r100) {
            if (r100 == null) goto L7;
            m6b.o r101 = this.f416494a.f416484c;
            if (r101 == null) goto L8;
            r101.onPushThreadTopic(r100);
            return;
        L8:
            return;
        }
    }

    public static final class d implements z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f416495a;

        public d(h r100) {
            this.f416495a = r100;
        }

        @Override // com.ss.android.lark.chat.service.impl.z
        public final void onPushChatRemoveMe(Chat r100) {
            if (r100 == null) goto L7;
            m6b.o r101 = this.f416495a.f416484c;
            if (r101 == null) goto L8;
            r101.onPushChatRemoveMe(r100);
            return;
        L8:
            return;
        }

        @Override // com.ss.android.lark.chat.service.impl.z
        public final void a(Chat r100, Map<String, ChatChatter> r101) {
            if (r100 == null) goto L8;
            if (r101 == null) goto L9;
            m6b.o r102 = this.f416495a.f416484c;
            if (r102 == null) goto L10;
            r102.g(r100, r101);
            return;
        L10:
            return;
        L9:
            return;
        }
    }

    public static final class e implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f416496a;

        public e(h r100) {
            this.f416496a = r100;
        }

        @Override // com.ss.android.lark.chat.service.impl.a0
        public final void a(Chat r100, Map<String, ChatChatter> r101) {
            if (r100 == null) goto L8;
            if (r101 == null) goto L9;
            m6b.o r102 = this.f416496a.f416484c;
            if (r102 == null) goto L10;
            r102.i(r100, r101);
            return;
        L10:
            return;
        L9:
            return;
        }
    }

    public static final class f implements c0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f416497a;

        public f(h r100) {
            this.f416497a = r100;
        }

        @Override // com.ss.android.lark.chat.service.impl.c0
        public final void d(PushDoubaoSmartReply r100) {
            Intrinsics.checkNotNullParameter(r100, "push");
            m6b.o r101 = this.f416497a.f416484c;
            if (r101 == null) goto L6;
            r101.d(r100);
            return;
        }
    }

    public static final class g implements d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f416498a;

        public g(h r100) {
            this.f416498a = r100;
        }

        @Override // com.ss.android.lark.chat.service.impl.d0
        public final void e(DoubaoTyping r100) {
            Intrinsics.checkNotNullParameter(r100, "doubaoTyping");
            m6b.o r101 = this.f416498a.f416484c;
            if (r101 == null) goto L6;
            r101.e(r100);
            return;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.service.impl.h$h, reason: collision with other inner class name */
    public static final class C4875h implements com.ss.android.lark.biz.im.api.k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f416499a;

        public C4875h(h r100) {
            this.f416499a = r100;
        }

        @Override // com.ss.android.lark.biz.im.api.k0
        public final void a(com.ss.android.lark.biz.im.api.g1 r100) {
            Intrinsics.checkNotNullParameter(r100, "pushMessageDTO");
            m6b.o r101 = this.f416499a.f416484c;
            if (r101 == null) goto L6;
            r101.a(r100);
            return;
        }

        @Override // com.ss.android.lark.biz.im.api.k0
        public final void b(PushMessageReadStates r100) {
            Intrinsics.checkNotNullParameter(r100, "readStates");
            m6b.o r101 = this.f416499a.f416484c;
            if (r101 == null) goto L6;
            r101.b(r100);
            return;
        }

        @Override // com.ss.android.lark.biz.im.api.k0
        public final void f(PushMessageReactions r100) {
            Intrinsics.checkNotNullParameter(r100, "reactions");
            m6b.o r101 = this.f416499a.f416484c;
            if (r101 == null) goto L6;
            r101.f(r100);
            return;
        }
    }

    public static final class i implements g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f416500a;

        public i(h r100) {
            this.f416500a = r100;
        }

        @Override // com.ss.android.lark.chat.service.impl.g0
        public final void c(MessageInfo r100) {
            m6b.o r101 = this.f416500a.f416484c;
            if (r101 == null) goto L6;
            r101.c(r100);
            return;
        }
    }

    static {
    }

    public final void g() {
        ImSdkService.a().b3(this.f416487f);
        ImSdkService.a().O5(this.f416487f);
        ImSdkService.e().O3(this.f416485d);
        ImSdkService.e().kd(this.f416486e);
        ImSdkService.a().Z4(this.f416488g);
        ImSdkService.a().Cc(this.f416491j);
        ImSdkService.a().Gb(this.f416492k);
        ImSdkService.a().V2(this.f416489h);
        ImSdkService.a().k5(this.f416490i);
    }

    public h(m6b.d r100) {
        Intrinsics.checkNotNullParameter(r100, "chatSubscriber");
        this.f416482a = r100;
        this.f416485d = new C4875h(this);
        this.f416486e = new i(this);
        this.f416487f = new c(this);
        this.f416488g = new d(this);
        this.f416489h = new g(this);
        this.f416490i = new f(this);
        this.f416491j = new b(this);
        this.f416492k = new e(this);
    }

    @Override // m6b.c
    public final void b(String r100) {
        if (r100 != null) goto L4;
    L6:
        g();
        return;
    L4:
        if (TextUtils.isEmpty(r100) == true) goto L6;
        h(r100, null);
        goto L6
    }

    public final void e(m6b.o r100) {
        this.f416484c = r100;
        ImSdkService.a().b3(this.f416487f);
        ImSdkService.a().ke(this.f416487f);
        ImSdkService.a().O5(this.f416487f);
        ImSdkService.a().c1(this.f416487f);
        ImSdkService.e().O3(this.f416485d);
        ImSdkService.e().gc(this.f416485d);
        ImSdkService.e().kd(this.f416486e);
        ImSdkService.e().K3(this.f416486e);
        ImSdkService.a().Z4(this.f416488g);
        ImSdkService.a().Qa(this.f416488g);
        ImSdkService.a().Cc(this.f416491j);
        ImSdkService.a().O1(this.f416491j);
        ImSdkService.a().Gb(this.f416492k);
        ImSdkService.a().ha(this.f416492k);
        ImSdkService.a().V2(this.f416489h);
        ImSdkService.a().W6(this.f416489h);
        ImSdkService.a().k5(this.f416490i);
        ImSdkService.a().Nd(this.f416490i);
    }

    @Override // m6b.c
    public final void c(String r100, aqb.a r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        if (r100 != null) goto L5;
    L7:
        e(r101);
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L7;
        f(r100, null);
        goto L7
    }

    @Override // m6b.c
    public final void d(String r100, SubscribeChatEventRequest.SubscriptionKey r101) {
        Intrinsics.checkNotNullParameter(r101, "subscriptionKey");
        if (r100 != null) goto L5;
    L7:
        g();
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L7;
        h(r100, r101);
        goto L7
    }

    public final void f(String r100, SubscribeChatEventRequest.SubscriptionKey r101) {
        Log.i("ChatRelationPushSubscriber", "subscribeChat old chat id: " + this.f416483b + " new chat id: " + r100);
        if (TextUtils.isEmpty(this.f416483b) == true) goto L8;
        if (Intrinsics.areEqual(this.f416483b, r100) == false) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(this.f416483b) == true) goto L13;
        if (Intrinsics.areEqual(this.f416483b, r100) == true) goto L13;
        this.f416482a.z9(this.f416483b, r101);
    L13:
        if (TextUtils.isEmpty(r100) == true) goto L16;
        this.f416482a.K6(r100, r101);
        this.f416483b = r100;
        return;
    }

    public final void h(String r100, SubscribeChatEventRequest.SubscriptionKey r101) {
        Log.i("ChatRelationPushSubscriber", "unSubscribeChat cur chat id: " + this.f416483b + " new unSubscribeC hat id: " + r100);
        if (TextUtils.isEmpty(this.f416483b) == false) goto L5;
    L7:
        Log.e("ChatRelationPushSubscriber", "unSubscribeChat : mSubscribedChatId = " + this.f416483b + " and getChatId = " + r100);
        return;
    L5:
        if (Intrinsics.areEqual(this.f416483b, r100) == false) goto L7;
        this.f416482a.z9(this.f416483b, r101);
        this.f416483b = null;
    }

    @Override // m6b.c
    public final void a(String r100, SubscribeChatEventRequest.SubscriptionKey r101, m6b.o r102) {
        Intrinsics.checkNotNullParameter(r101, "subscriptionKey");
        Intrinsics.checkNotNullParameter(r102, "listener");
        if (r100 != null) goto L5;
    L7:
        e(r102);
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L7;
        f(r100, r101);
        goto L7
    }
}
