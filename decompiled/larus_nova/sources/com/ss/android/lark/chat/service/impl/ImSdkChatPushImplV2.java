package com.ss.android.lark.chat.service.impl;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.ExternalDisplayTimezoneSettingType;
import com.bytedance.lark.pb.im.v1.DoubaoTyping;
import com.bytedance.lark.pb.im.v1.PushChatChatterListDepartmentName;
import com.bytedance.lark.pb.im.v1.PushChatChattersResponse;
import com.bytedance.lark.pb.im.v1.PushChatTimeTipNotify;
import com.bytedance.lark.pb.im.v1.PushDoubaoSmartReply;
import com.bytedance.lark.pb.im.v1.PushDoubaoTyping;
import com.bytedance.lark.pb.im.v1.PushOfflineUpdatedChats;
import com.bytedance.lark.pb.im.v1.PushPinReadStatusResponse;
import com.bytedance.lark.pb.im.v1.PushPreloadUpdatedChats;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.ModelParserMessage;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class ImSdkChatPushImplV2 implements m6b.s {
    public final f A;
    public final List<d0> B;
    public final Lazy C;
    public final h D;
    public final List<c0> E;
    public final Lazy F;
    public final g G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f416325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f416326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f416327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f416328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<y> f416329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f416330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f416331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<y> f416332h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f416333i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f416334j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f416335k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f416336l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<z> f416337m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<x> f416338n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<a0> f416339o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<aqb.f> f416340p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f416341q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final j f416342r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<aqb.e> f416343s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f416344t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final e f416345u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List<f0> f416346v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f416347w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final k f416348x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<b0> f416349y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f416350z;

    public static final class a {
    }

    public static final class b implements Function1<Throwable, Unit> {
        public b() {
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable r100) {
            Throwable r101 = r100;
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            Log.e("ImSdkChatPushImplV2", r101);
            return Unit.INSTANCE;
        }
    }

    public static final class c implements Function1<PushChatChattersResponse, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImSdkChatPushImplV2 f416351a;

        public c(ImSdkChatPushImplV2 r100) {
            this.f416351a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PushChatChattersResponse r100) {
            PushChatChattersResponse r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "response");
            Chat r102 = com.ss.android.lark.parser.internal.h.a(r101.chat, null);     // Catch: Throwable -> L16
            Map<String, ChatChatter> r103 = com.ss.android.lark.parser.internal.j.b(r101.entity, null).a();     // Catch: Throwable -> L16
            Map<String, Message> r104 = ModelParserMessage.h(r101.entity);     // Catch: Throwable -> L16
            PushChatChattersResponse.Type r105 = r101.type;     // Catch: Throwable -> L16
            JSONObject r106 = new JSONObject();     // Catch: Throwable -> L16
            r106.put("chat", r102);     // Catch: Throwable -> L16
            r106.put("params_messages", r104);     // Catch: Throwable -> L16
            r106.put("params_chatters", r103);     // Catch: Throwable -> L16
            r106.put("params_push_chat_users_type", Integer.valueOf(r105.getValue()));     // Catch: Throwable -> L16
            int r107 = r105.getValue();     // Catch: Throwable -> L16
            if (r107 != PushChatChattersResponse.Type.DELETE_CHATTER.getValue()) goto L7;
            CoreThreadPool.getDefault().getUIExecutor().execute(new h0(this.f416351a, r102, r103));     // Catch: Throwable -> L16
        L20:
        L19:
            return Unit.INSTANCE;
        L7:
            if (r107 != PushChatChattersResponse.Type.DELETE_ME.getValue()) goto L10;
            CoreThreadPool.getDefault().getUIExecutor().execute(new i0(this.f416351a, r102));     // Catch: Throwable -> L16
            goto L20
        L10:
            if (r107 != PushChatChattersResponse.Type.ADD_CHATTER.getValue()) goto L13;
            CoreThreadPool.getDefault().getUIExecutor().execute(new j0(this.f416351a, r102, r103));     // Catch: Throwable -> L16
            goto L20
        L13:
            if (r107 != PushChatChattersResponse.Type.UPDATE_CHATTER.getValue()) goto L20;
            CoreThreadPool.getDefault().getUIExecutor().execute(new k0(this.f416351a, r102, r103));     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            Log.e("ImSdkChatPushImplV2", th, true);
            goto L19
        }
    }

    public static final class d implements Function1<Entity, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImSdkChatPushImplV2 f416352a;

        public d(ImSdkChatPushImplV2 r100) {
            this.f416352a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Entity r100) {
            Entity r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "entity");
            Map<String, Chat> r102 = com.ss.android.lark.parser.internal.h.d(r101.chats, null, r101.mail_setting);     // Catch: Throwable -> L9
            CoreThreadPool.getDefault().getUIExecutor().execute(new l0(r102, this.f416352a));     // Catch: Throwable -> L9
            StringBuilder r103 = new StringBuilder();     // Catch: Throwable -> L9
            HashMap r104 = (HashMap) r102;     // Catch: Throwable -> L9
            Iterator r105 = r104.keySet().iterator();     // Catch: Throwable -> L9
        L5:
            if (r105.hasNext() == false) goto L7;
            r103.append((String) r105.next());     // Catch: Throwable -> L9
            r103.append(", ");     // Catch: Throwable -> L9
            goto L5
        L7:
            Log.i("ImSdkChatPushImplV2", "PushChats success, size = " + r104.size() + ", ids: " + r103);     // Catch: Throwable -> L9
        L12:
            return Unit.INSTANCE;
        L9:
            th = move-exception;
            Log.e("ImSdkChatPushImplV2", th, true);
            goto L12
        }
    }

    public static final class e implements Function1<PushChatTimeTipNotify, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImSdkChatPushImplV2 f416353a;

        public e(ImSdkChatPushImplV2 r100) {
            this.f416353a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PushChatTimeTipNotify r100) {
            PushChatTimeTipNotify r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "response");
            com.ss.android.lark.chat.entity.timetip.PushChatTimeTipNotify r102 = new com.ss.android.lark.chat.entity.timetip.PushChatTimeTipNotify();     // Catch: Throwable -> L5
            String r103 = r101.chat_id;     // Catch: Throwable -> L5
            r101.status.getValue();     // Catch: Throwable -> L5
            ExternalDisplayTimezoneSettingType r104 = ExternalDisplayTimezoneSettingType.UNKNOWN;     // Catch: Throwable -> L5
            CoreThreadPool.getDefault().getUIExecutor().execute(new m0(this.f416353a, r102));     // Catch: Throwable -> L5
        L8:
            return Unit.INSTANCE;
        L5:
            th = move-exception;
            Log.e("ImSdkChatPushImplV2", th, true);
            goto L8
        }
    }

    public static final class f implements Function1<PushChatChatterListDepartmentName, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImSdkChatPushImplV2 f416354a;

        public f(ImSdkChatPushImplV2 r100) {
            this.f416354a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PushChatChatterListDepartmentName r100) {
            PushChatChatterListDepartmentName r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "response");
            String r102 = r101.chat_id;     // Catch: Throwable -> L21
            boolean r103 = false;
            if (r102 != null) goto L6;
        L9:
            boolean r104 = true;
        L10:
            if (r104 == false) goto L12;
            Log.e("ImSdkChatPushImplV2", "response.chat_id is null or empty");     // Catch: Throwable -> L21
        L24:
            return Unit.INSTANCE;
        L12:
            Map<String, String> r105 = r101.chatter_id_to_department_name;     // Catch: Throwable -> L21
            if (r105 != null) goto L15;
        L16:
            r103 = true;
        L17:
            if (r103 == false) goto L19;
            Log.e("ImSdkChatPushImplV2", "response.chatter_id_to_department_name is null or empty");     // Catch: Throwable -> L21
            goto L24
        L19:
            Log.i("ImSdkChatPushImplV2", "onPushDepartment chatId: " + r101.chat_id + ", departments.size: " + r101.chatter_id_to_department_name.size());     // Catch: Throwable -> L21
            CoreThreadPool.getDefault().getUIExecutor().execute(new n0(this.f416354a, r101));     // Catch: Throwable -> L21
            goto L24
        L15:
            if (r105.isEmpty() == false) goto L17;
        L6:
            if (r102.length() == 0) goto L9;
            r104 = false;
        L21:
            th = move-exception;
            Log.e("ImSdkChatPushImplV2", th, true);
            goto L24
        }
    }

    public static final class g implements Function1<PushDoubaoSmartReply, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImSdkChatPushImplV2 f416355a;

        public g(ImSdkChatPushImplV2 r100) {
            this.f416355a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PushDoubaoSmartReply r100) {
            PushDoubaoSmartReply r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "response");
        L8:
            th = move-exception;
            Log.e("ImSdkChatPushImplV2", th, true);
        L11:
            return Unit.INSTANCE;
        L4:
            if (r101.doubao_smart_reply != null) goto L6;
            Log.e("ImSdkChatPushImplV2", "response.doubao_smart_reply is null");     // Catch: Throwable -> L8
        L12:
            goto L11
        L6:
            CoreThreadPool.getDefault().getUIExecutor().execute(new o0(this.f416355a, r101));     // Catch: Throwable -> L8
            goto L12
        }
    }

    public static final class h implements Function1<PushDoubaoTyping, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImSdkChatPushImplV2 f416356a;

        public h(ImSdkChatPushImplV2 r100) {
            this.f416356a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PushDoubaoTyping r100) {
            PushDoubaoTyping r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "response");
            DoubaoTyping r102 = r101.doubao_typing;     // Catch: Throwable -> L8
            if (r102 != null) goto L6;
            Log.e("ImSdkChatPushImplV2", "response.doubao_typing is null or empty");     // Catch: Throwable -> L8
        L12:
        L11:
            return Unit.INSTANCE;
        L6:
            CoreThreadPool.getDefault().getUIExecutor().execute(new p0(this.f416356a, r102));     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            Log.e("ImSdkChatPushImplV2", th, true);
            goto L11
        }
    }

    public static final class i implements Function1<PushOfflineUpdatedChats, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImSdkChatPushImplV2 f416357a;

        public i(ImSdkChatPushImplV2 r100) {
            this.f416357a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PushOfflineUpdatedChats r100) {
            PushOfflineUpdatedChats r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "pushOfflineUpdatedChats");
            Entity r102 = r101.entity;     // Catch: Throwable -> L29
            if (r102 != null) goto L6;
            Log.e("ImSdkChatPushImplV2", "Entity from PushOfflineUpdatedChats is null");     // Catch: Throwable -> L29
        L32:
            return Unit.INSTANCE;
        L6:
            Map<String, Chat> r103 = com.ss.android.lark.parser.internal.h.d(r102.chats, null, r102.mail_setting);     // Catch: Throwable -> L29
            CoreThreadPool.getDefault().getUIExecutor().execute(new q0(r103, this.f416357a));     // Catch: Throwable -> L29
            StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L29
            HashMap r105 = (HashMap) r103;     // Catch: Throwable -> L29
            Iterator r106 = r105.keySet().iterator();     // Catch: Throwable -> L29
        L8:
            if (r106.hasNext() == false) goto L10;
            r104.append((String) r106.next());     // Catch: Throwable -> L29
            r104.append(", ");     // Catch: Throwable -> L29
            goto L8
        L10:
            Log.i("ImSdkChatPushImplV2", "PushOfflineChats success, size = " + r105.size() + ", ids: " + r104);     // Catch: Throwable -> L29
            List<PushOfflineUpdatedChats.UpdatedItem> r107 = r101.updated_items;     // Catch: Throwable -> L29
            if (CollectionUtils.isEmpty(r107) == true) goto L32;
            if (CollectionUtils.isEmpty(r102.threads) == true) goto L32;
            Iterator<PushOfflineUpdatedChats.UpdatedItem> r108 = r107.iterator();     // Catch: Throwable -> L29
        L18:
            if (r108.hasNext() == false) goto L32;
            PushOfflineUpdatedChats.UpdatedItem r109 = r108.next();     // Catch: Throwable -> L29
            if (r109 == null) goto L18;
            if (TextUtils.isEmpty(r109.item_id) == true) goto L18;
            if (r109.item_type != PushOfflineUpdatedChats.UpdatedItem.Type.THREAD) goto L18;
            ThreadTopic r110 = com.ss.android.lark.parser.internal.b0.a(r102.threads.get(r109.item_id));     // Catch: Throwable -> L29
            if (r110 == null) goto L18;
            CoreThreadPool.getDefault().getUIExecutor().execute(new r0(this.f416357a, r110));     // Catch: Throwable -> L29
        L29:
            th = move-exception;
            Log.e("ImSdkChatPushImplV2", th, true);
            goto L32
        }
    }

    public static final class j implements Function1<PushPinReadStatusResponse, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImSdkChatPushImplV2 f416358a;

        public j(ImSdkChatPushImplV2 r100) {
            this.f416358a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PushPinReadStatusResponse r100) {
            PushPinReadStatusResponse r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "response");
            CoreThreadPool.getDefault().getUIExecutor().execute(new s0(this.f416358a, r101));     // Catch: Throwable -> L5
        L8:
            return Unit.INSTANCE;
        L5:
            th = move-exception;
            Log.e("ImSdkChatPushImplV2", th, true);
            goto L8
        }
    }

    public static final class k implements Function1<PushPreloadUpdatedChats, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImSdkChatPushImplV2 f416359a;

        public k(ImSdkChatPushImplV2 r100) {
            this.f416359a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PushPreloadUpdatedChats r100) {
            PushPreloadUpdatedChats r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "pushPreloadUpdatedChats");
            List<PushPreloadUpdatedChats.UpdatedItem> r102 = r101.updated_items;     // Catch: Throwable -> L20
            ArrayList r103 = new ArrayList();     // Catch: Throwable -> L20
            List<PushPreloadUpdatedChats.UpdatedItem> r104 = r102;     // Catch: Throwable -> L20
            if (r104 != null) goto L6;
        L9:
            boolean r105 = true;
        L10:
            if (r105 == true) goto L18;
            if (r102 == null) goto L18;
            List r106 = CollectionsKt.filterNotNull(r102);     // Catch: Throwable -> L20
            if (r106 == null) goto L18;
            Iterator r107 = r106.iterator();     // Catch: Throwable -> L20
        L16:
            if (r107.hasNext() == false) goto L18;
            r103.add(((PushPreloadUpdatedChats.UpdatedItem) r107.next()).item_id);     // Catch: Throwable -> L20
        L18:
            CoreThreadPool.getDefault().getUIExecutor().execute(new t0(this.f416359a, r103));     // Catch: Throwable -> L20
        L23:
            return Unit.INSTANCE;
        L6:
            if (r104.isEmpty() == true) goto L9;
            r105 = false;
        L20:
            th = move-exception;
            Log.e("ImSdkChatPushImplV2", th, true);
            goto L23
        }
    }

    static {
    }

    @Override // m6b.s
    public final void Cc(x r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.f416338n).remove(r100);
    }

    @Override // m6b.s
    public final void Ce(f0 r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.f416346v).contains(r100) == true) goto L8;
        ((CopyOnWriteArrayList) this.f416346v).add(r100);
        Disposable r101 = (Disposable) this.f416347w.getValue();
        Log.i("ImSdkChatPushImplV2", "add listener to pushPreloadUpdatedChatsDisposable");
        return;
    }

    @Override // m6b.s
    public final void Gb(a0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.f416339o).remove(r100);
    }

    @Override // m6b.s
    public final void Ge(b0 r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.f416349y).contains(r100) == true) goto L8;
        ((CopyOnWriteArrayList) this.f416349y).add(r100);
        Disposable r101 = (Disposable) this.f416350z.getValue();
        Log.i("ImSdkChatPushImplV2", "add listener to pushDepartmentDisposable");
        return;
    }

    @Override // m6b.s
    public final void Hc(b0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.f416349y).remove(r100);
    }

    @Override // m6b.s
    public final void Nd(com.ss.android.lark.chat.service.impl.h.f r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.E).contains(r100) == true) goto L8;
        ((CopyOnWriteArrayList) this.E).add(r100);
        Disposable r101 = (Disposable) this.F.getValue();
        Log.i("ImSdkChatPushImplV2", "add listener to pushDoubaoSmartReplyDisposable");
        return;
    }

    @Override // m6b.s
    public final void O1(x r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.f416338n).contains(r100) == true) goto L8;
        ((CopyOnWriteArrayList) this.f416338n).add(r100);
        Disposable r101 = (Disposable) this.f416335k.getValue();
        Log.i("ImSdkChatPushImplV2", "add listener to pushChatChattersDisposable");
        return;
    }

    @Override // m6b.s
    public final void O5(y r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.f416332h).remove(r100);
    }

    @Override // m6b.s
    public final void Qa(z r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.f416337m).contains(r100) == true) goto L8;
        ((CopyOnWriteArrayList) this.f416337m).add(r100);
        Disposable r101 = (Disposable) this.f416335k.getValue();
        Log.i("ImSdkChatPushImplV2", "add listener to pushChatChattersDisposable");
        return;
    }

    @Override // m6b.s
    public final void Se(aqb.f r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.f416340p).remove(r100);
    }

    @Override // m6b.s
    public final void V2(com.ss.android.lark.chat.service.impl.h.g r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.B).remove(r100);
    }

    @Override // m6b.s
    public final void W6(com.ss.android.lark.chat.service.impl.h.g r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.B).contains(r100) == true) goto L8;
        ((CopyOnWriteArrayList) this.B).add(r100);
        Disposable r101 = (Disposable) this.C.getValue();
        Log.i("ImSdkChatPushImplV2", "add listener to pushDoubaoTypingDisposable");
        return;
    }

    @Override // m6b.s
    public final void Z4(z r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.f416337m).remove(r100);
    }

    @Override // m6b.s
    public final void b3(y r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.f416329e).remove(r100);
    }

    @Override // m6b.s
    public final void c1(y r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.f416332h).contains(r100) == true) goto L8;
        ((CopyOnWriteArrayList) this.f416332h).add(r100);
        Disposable r101 = (Disposable) this.f416333i.getValue();
        Log.i("ImSdkChatPushImplV2", "add listener to pushOfflineChatDisposable");
        return;
    }

    @Override // m6b.s
    public final void d1(aqb.e r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.f416343s).remove(r100);
    }

    @Override // m6b.s
    public final void f8(aqb.e r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.f416343s).contains(r100) == true) goto L8;
        ((CopyOnWriteArrayList) this.f416343s).add(r100);
        Disposable r101 = (Disposable) this.f416344t.getValue();
        Log.i("ImSdkChatPushImplV2", "add listener to pushChatTimeTipNotifyDisposable");
        return;
    }

    @Override // m6b.s
    public final void gd(aqb.f r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.f416340p).contains(r100) == true) goto L8;
        ((CopyOnWriteArrayList) this.f416340p).add(r100);
        Disposable r101 = (Disposable) this.f416341q.getValue();
        Log.i("ImSdkChatPushImplV2", "add listener to pushPinReadStatusDisposable");
        return;
    }

    @Override // m6b.s
    public final void ha(a0 r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.f416339o).contains(r100) == true) goto L8;
        ((CopyOnWriteArrayList) this.f416339o).add(r100);
        Disposable r101 = (Disposable) this.f416335k.getValue();
        Log.i("ImSdkChatPushImplV2", "add listener to pushChatChattersDisposable");
        return;
    }

    @Override // m6b.s
    public final void k5(com.ss.android.lark.chat.service.impl.h.f r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.E).remove(r100);
    }

    @Override // m6b.s
    public final void ke(y r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.f416329e).contains(r100) == true) goto L8;
        ((CopyOnWriteArrayList) this.f416329e).add(r100);
        Disposable r101 = (Disposable) this.f416330f.getValue();
        Log.i("ImSdkChatPushImplV2", "add listener to pushChatDisposable");
        return;
    }

    @Override // m6b.s
    public final void vd(f0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.f416346v).remove(r100);
    }

    @Inject
    public ImSdkChatPushImplV2(String r100, com.bytedance.lark.rustclient.api.l r101) {
        Intrinsics.checkNotNullParameter(r100, "currentUserId");
        Intrinsics.checkNotNullParameter(r101, "userRustClient");
        this.f416325a = r100;
        this.f416326b = r101;
        Log.i("ImSdkChatPushImplV2", "current user id is " + r100);
        this.f416327c = new CompositeDisposable();
        this.f416328d = new b();
        this.f416329e = new CopyOnWriteArrayList();
        LazyThreadSafetyMode r102 = LazyThreadSafetyMode.SYNCHRONIZED;
        this.f416330f = LazyKt.lazy(r102, new ImSdkChatPushImplV2$pushChatDisposable$2(this));
        this.f416331g = new d(this);
        this.f416332h = new CopyOnWriteArrayList();
        this.f416333i = LazyKt.lazy(r102, new ImSdkChatPushImplV2$pushOfflineChatDisposable$2(this));
        this.f416334j = new i(this);
        this.f416335k = LazyKt.lazy(r102, new ImSdkChatPushImplV2$pushChatChattersDisposable$2(this));
        this.f416336l = new c(this);
        this.f416337m = new CopyOnWriteArrayList();
        this.f416338n = new CopyOnWriteArrayList();
        this.f416339o = new CopyOnWriteArrayList();
        this.f416340p = new CopyOnWriteArrayList();
        this.f416341q = LazyKt.lazy(r102, new ImSdkChatPushImplV2$pushPinReadStatusDisposable$2(this));
        this.f416342r = new j(this);
        this.f416343s = new CopyOnWriteArrayList();
        this.f416344t = LazyKt.lazy(r102, new ImSdkChatPushImplV2$pushChatTimeTipNotifyDisposable$2(this));
        this.f416345u = new e(this);
        this.f416346v = new CopyOnWriteArrayList();
        this.f416347w = LazyKt.lazy(r102, new ImSdkChatPushImplV2$pushPreloadUpdatedChatsDisposable$2(this));
        this.f416348x = new k(this);
        this.f416349y = new CopyOnWriteArrayList();
        this.f416350z = LazyKt.lazy(r102, new ImSdkChatPushImplV2$pushDepartmentDisposable$2(this));
        this.A = new f(this);
        this.B = new CopyOnWriteArrayList();
        this.C = LazyKt.lazy(r102, new ImSdkChatPushImplV2$pushDoubaoTypingDisposable$2(this));
        this.D = new h(this);
        this.E = new CopyOnWriteArrayList();
        this.F = LazyKt.lazy(r102, new ImSdkChatPushImplV2$pushDoubaoSmartReplyDisposable$2(this));
        this.G = new g(this);
    }
}
