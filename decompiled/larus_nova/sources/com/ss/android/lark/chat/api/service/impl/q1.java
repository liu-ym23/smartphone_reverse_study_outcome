package com.ss.android.lark.chat.api.service.impl;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.ChannelDataIncompleteStrategy;
import com.bytedance.lark.pb.basic.v1.ChannelDataScene;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.QuasiMessage;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.bytedance.lark.pb.im.v1.ChannelDataType;
import com.bytedance.lark.pb.im.v1.DeleteMessageNoTraceRequest;
import com.bytedance.lark.pb.im.v1.GetThreadMessagesV2Request;
import com.bytedance.lark.pb.im.v1.GetThreadMessagesV2Response;
import com.bytedance.lark.pb.im.v1.MGetThreadsRequest;
import com.bytedance.lark.pb.im.v1.MGetThreadsResponse;
import com.bytedance.lark.pb.im.v1.UpdateThreadRequest;
import com.bytedance.lark.pb.im.v1.UpdateThreadsMeReadRequest;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.ThreadStateInfo;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.core.model.ChannelDataFetcherStrategy;
import com.ss.android.lark.chat.core.model.MessageFetchScene;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.flow.replyinthread.pages.plugin.ReplyInThreadTitleBarPlugin$showMoreOperationMenu$1;
import com.ss.android.lark.flow.replyinthread.pages.plugin.ReplyInThreadTitleBarPlugin$showMoreOperationMenu$2;
import com.ss.android.lark.im.sdk.utils.ImSdkMessageUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.ModelParserMessage;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class q1 implements com.ss.android.lark.biz.im.api.o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a2b.m f411629a;

    public class a implements Function1<GetThreadMessagesV2Response, l5b.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f411630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f411631b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ q1 f411632c;

        @Override // kotlin.jvm.functions.Function1
        public final l5b.a invoke(GetThreadMessagesV2Response r210) {
            GetThreadMessagesV2Response r100 = r210;
            q1 r101 = this.f411632c;
            String r102 = this.f411630a;
            Long r103 = Long.valueOf(this.f411631b);
            r101.getClass();
            ArrayList r104 = new ArrayList();
            long r105 = System.currentTimeMillis();
            l5b.a r106 = new l5b.a();
            r106.f507580f = System.currentTimeMillis() - r103.longValue();
            if (CollectionUtils.isNotEmpty(r100.invalid_positions) == false) goto L6;
            r106.f507577c.addAll(r100.invalid_positions);
        L6:
            if (CollectionUtils.isNotEmpty(r100.missing_positions) == false) goto L8;
            r106.f507578d.addAll(r100.missing_positions);
        L8:
            Entity r107 = r100.entity;
            com.ss.android.lark.chat.entity.chatter.a r110 = com.ss.android.lark.parser.internal.b.d(r107, true);
            Map<String, Message> r111 = ModelParserMessage.h(r107);
            HashMap r112 = new HashMap();
            boolean r113 = !FeatureGatingModule.getFeatureGatingService().isEnable("im.thread.loading_opt.reverse", false);
            Iterator<GetThreadMessagesV2Response.MessageItem> r108 = r100.message_items.iterator();
        L9:
            n5b.a r114 = null;
            if (r108.hasNext() == false) goto L49;
            GetThreadMessagesV2Response.MessageItem r109 = r108.next();
            String r115 = r109.item_id;
            ChannelDataType r116 = r109.item_type;
            if (r116 != ChannelDataType.NORMAL_DATA) goto L31;
            com.bytedance.lark.pb.basic.v1.Message r117 = r107.messages.get(r115);
            Message r118 = (Message) ((LinkedHashMap) r111).get(r115);
            if (r118 == null) goto L30;
            if (r117 == null) goto L9;
            if (r113 == false) goto L19;
            Map<String, Message> r119 = r111;
        L20:
            HashMap r120 = r112;
            HashMap r121 = r112;
            Map<String, Message> r122 = r119;
            Iterator<GetThreadMessagesV2Response.MessageItem> r123 = r108;
            com.ss.android.lark.chat.entity.chatter.a r124 = r110;
            MessageInfo r125 = com.ss.android.lark.parser.internal.a.l(r118, r117, r107, r110, r120, r122, true);
            r104.add(r125);
            r125.setOriginalSender(com.ss.android.lark.parser.internal.a.g(r125.getMessage(), r124));
            r121.put(r115, r125);
            MessageInfo r126 = r125.getParentMessageInfo();
            if (r126 != null) goto L23;
        L25:
            MessageInfo r127 = r125.getRootMessageInfo();
            if (r127 != null) goto L28;
        L48:
            r112 = r121;
            r110 = r124;
            r108 = r123;
            goto L9
        L28:
            if (r121.containsKey(r127.getMessage().getId()) == true) goto L48;
            r121.put(r127.getMessage().getId(), r127);
            goto L48
        L23:
            if (r121.containsKey(r126.getMessage().getId()) == true) goto L25;
            r121.put(r126.getMessage().getId(), r126);
            goto L25
        L19:
            r119 = null;
            goto L20
        L30:
            r123 = r108;
            r121 = r112;
            r124 = r110;
            goto L48
        L31:
            r123 = r108;
            r121 = r112;
            r124 = r110;
            if (r116 != ChannelDataType.QUASI_DATA) goto L48;
            QuasiMessage r128 = r107.quasi_messages.get(r115);
            if (r128 == null) goto L48;
            MessageInfo r129 = ModelParserMessage.k(ModelParserMessage.d(r107, r128), r107, r124, r121);
            if (r129 == null) goto L48;
            r104.add(r129);
            MessageInfo r130 = r129.getParentMessageInfo();
            if (r130 != null) goto L41;
        L43:
            MessageInfo r131 = r129.getRootMessageInfo();
            if (r131 == null) goto L48;
            if (r121.containsKey(r131.getMessage().getId()) == true) goto L48;
            r121.put(r131.getMessage().getId(), r130);
            goto L48
        L41:
            if (r121.containsKey(r130.getMessage().getId()) == true) goto L43;
            r121.put(r130.getMessage().getId(), r130);
            goto L43
        L49:
            com.ss.android.lark.chat.entity.chatter.a r132 = r110;
            r106.f507575a.addAll(r104);
            Thread r133 = r107.threads.get(r102);
            Message r134 = (Message) ((LinkedHashMap) r111).get(r102);
            com.bytedance.lark.pb.basic.v1.Message r135 = r107.messages.get(r102);
            ThreadTopic r136 = com.ss.android.lark.parser.internal.b0.a(r133);
            if (r134 == null) goto L60;
            if (r136 == null) goto L60;
            ChatChatter r137 = r132.b(r134.getChatId(), r135.from_id);
            if (r137 == null) goto L60;
            List<ReactionInfo> r138 = com.ss.android.lark.parser.internal.a.e(r132, r137.getChatId(), com.ss.android.lark.parser.internal.x.b(r135.reactions));
            n5b.a r139 = new n5b.a(r137, r136, r134);
            r139.f518084i = com.ss.android.lark.parser.internal.a.g(r134, r132);
            r139.f518079d = r138;
            r139.f518082g = com.ss.android.lark.parser.internal.a.h(r135.pin, r134.getChatId(), r132);
            com.ss.android.lark.parser.internal.a.m(r135, r139, r132);
            String r140 = r134.getRecallerId();
            if (TextUtils.isEmpty(r140) == true) goto L59;
            r139.f518090o = r132.b(r134.getChatId(), r140);
        L59:
            r139.f518083h = com.ss.android.lark.parser.internal.d0.e(r134, r107, true);
            r139.f518087l = com.ss.android.lark.parser.internal.h.a(r107.chats.get(r134.getChatId()), null);
            r114 = r139;
        L60:
            r106.f507576b = r114;
            r106.f507579e = System.currentTimeMillis() - r105;
            return r106;
        }

        public a(q1 r100, String r101, long r102) {
            this.f411632c = r100;
            this.f411630a = r101;
            this.f411631b = r102;
        }
    }

    public class b implements SdkSender.IParser<ThreadTopic> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f411633a;

        public b(String r100) {
            this.f411633a = r100;
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final ThreadTopic parse(byte[] r100) throws IOException {
            MGetThreadsResponse r101 = MGetThreadsResponse.ADAPTER.decode(r100);
            Entity r102 = r101.entity;
            if (r102 != null) goto L5;
        L7:
            return null;
        L5:
            if (CollectionUtils.isNotEmpty(r102.threads) == false) goto L7;
            return com.ss.android.lark.parser.internal.b0.a(r101.entity.threads.get(this.f411633a));
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f411634a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f411635b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f411636c = null;

        static {
            int[] r100 = new int[MessageFetchScene.values().length];
            f411636c = r100;
            r100[MessageFetchScene.FIRST_SCREEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L30:
            f411636c[MessageFetchScene.SPECIFIED_POSITION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L36:
            f411636c[MessageFetchScene.NEXT_PAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L46:
            f411636c[MessageFetchScene.PREVIOUS_PAGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L9:
            int[] r101 = new int[ThreadStateInfo.ThreadState.values().length];
            f411635b = r101;
            r101[ThreadStateInfo.ThreadState.OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L32:
            f411635b[ThreadStateInfo.ThreadState.CLOSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L34:
            f411635b[ThreadStateInfo.ThreadState.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L13:
            int[] r102 = new int[ChannelDataFetcherStrategy.values().length];
            f411634a = r102;
            r102[ChannelDataFetcherStrategy.IGNORE_LOCAL_DATA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L44:
            f411634a[ChannelDataFetcherStrategy.RETURN_LOCAL_DATA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L28:
            f411634a[ChannelDataFetcherStrategy.SYNC_SERVER_DATA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q1 f411637a = null;

        static {
            f411637a = new q1(new k1());
        }
    }

    @Inject
    public q1(a2b.m r100) {
        this.f411629a = r100;
    }

    public static ChannelDataScene b(MessageFetchScene r100) {
        int r101 = c.f411636c[r100.ordinal()];
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L17;
        if (r101 == 3) goto L15;
        if (r101 == 4) goto L13;
        return ChannelDataScene.FIRST_SCREEN;
    L13:
        return ChannelDataScene.PREVIOUS_PAGE;
    L15:
        return ChannelDataScene.NEXT_PAGE;
    L17:
        return ChannelDataScene.SPECIFIED_POSITION;
    L19:
        return ChannelDataScene.FIRST_SCREEN;
    }

    public static ChannelDataIncompleteStrategy c(ChannelDataFetcherStrategy r100) {
        int r101 = c.f411634a[r100.ordinal()];
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L13;
        if (r101 == 3) goto L11;
        return ChannelDataIncompleteStrategy.SYNC_SERVER_DATA;
    L11:
        return ChannelDataIncompleteStrategy.SYNC_SERVER_DATA;
    L13:
        return ChannelDataIncompleteStrategy.RETURN_LOCAL_DATA;
    L15:
        return ChannelDataIncompleteStrategy.IGNORE_LOCAL_DATA;
    }

    @Override // com.ss.android.lark.biz.im.api.o0
    public final ThreadTopic Vd(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        MGetThreadsRequest.Builder r101 = new MGetThreadsRequest.Builder();
        r101.thread_ids(Collections.singletonList(r100)).strategy(SyncDataStrategy.FORCE_SERVER);
        return (ThreadTopic) SdkSender.sendRequest(Command.MGET_THREADS, r101, new b(r100));
    }

    @Override // com.ss.android.lark.biz.im.api.o0
    public final void Dd(String r100, UIGetDataCallback r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        r101.onError(new ErrorResult("thread id is empty"));
    L5:
        DeleteMessageNoTraceRequest.Builder r102 = new DeleteMessageNoTraceRequest.Builder();
        r102.message_id(r100);
        SdkSender.asynSendRequestNonWrap(Command.DELETE_MESSAEG_NO_TRACE, r102, r101, new com.bytedance.ee.bear.middleground.drive.rustsdk.init.a());
    }

    @Override // com.ss.android.lark.biz.im.api.o0
    public final void J7(String r100, boolean r101, ReplyInThreadTitleBarPlugin$showMoreOperationMenu$1.AnonymousClass2 r102) {
        UpdateThreadRequest.Builder r103 = new UpdateThreadRequest.Builder();
        r103.thread_id(r100).is_follow(Boolean.valueOf(r101));
        this.f411629a.c(r103, r102);
    }

    @Override // com.ss.android.lark.biz.im.api.o0
    public final void N6(final String r100, SyncDataStrategy r101, IGetDataCallback r102) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        if (r102 == null) goto L9;
        r102.onError(new ErrorResult("thread id is empty"));
        return;
    L9:
        return;
    L7:
        MGetThreadsRequest.Builder r103 = new MGetThreadsRequest.Builder();
        r103.thread_ids(Collections.singletonList(r100)).for_normal_chat_message(Boolean.TRUE).strategy(r101);
        SdkSender.asynSendRequestNonWrap(Command.MGET_THREADS, r103, r102, new n1(r100));
    }

    @Override // com.ss.android.lark.biz.im.api.o0
    public final void ja(String r100, boolean r101, ReplyInThreadTitleBarPlugin$showMoreOperationMenu$2.AnonymousClass1 r102) {
        UpdateThreadRequest.Builder r103 = new UpdateThreadRequest.Builder();
        r103.thread_id(r100).is_remind(Boolean.valueOf(r101));
        this.f411629a.c(r103, r102);
    }

    @Override // com.ss.android.lark.biz.im.api.o0
    public final void q5(List r110, int r111, int r112) {
        if (CollectionUtils.isEmpty(r110) == false) goto L6;
        Log.i("ThreadService", "readThread, intervalThreads is empty");
        return;
    L6:
        ArrayList r100 = new ArrayList();
        Iterator r101 = r110.iterator();
        int r102 = Integer.MIN_VALUE;
        int r103 = Integer.MIN_VALUE;
        int r104 = Integer.MIN_VALUE;
    L7:
        boolean r105 = false;
        if (r101.hasNext() == false) goto L20;
        n5b.a r106 = (n5b.a) r101.next();
        ThreadTopic r107 = r106.f518077b;
        Message r108 = r106.f518078c;
        if (r108.isPreMessage() == true) goto L7;
        r102 = Math.max(r107.getPosition(), r102);
        r103 = Math.max(r107.getBadgeCount(), r103);
        r104 = Math.max(r107.getOriginBadgeCount(), r104);
        Lazy r109 = ImSdkMessageUtils.f426208a;
        Intrinsics.checkNotNullParameter(r108, "message");
        if (r108.getType() == Message.Type.AUDIO) goto L14;
        r105 = true;
    L14:
        if (r105 == false) goto L7;
        if (r108.isFromMe() == true) goto L7;
        if (r108.getMeReadType() > 0) goto L7;
        r100.add(r108.getId());
        goto L7
    L20:
        Log.i("ThreadService", "readThread, maxPosition:" + r102 + ", lastReadPosition:" + r111 + ", maxBadgeCount:" + r103 + ", lastReadBadgeCount:" + r112);
        if (CollectionUtils.isNotEmpty(r100) == true) goto L25;
        if (r102 > r111) goto L25;
        if (r103 > r112) goto L25;
        Log.i("ThreadService", "needReadThreadIds is empty, maxPosition:" + r102 + ", lastReadPosition:" + r111 + ", maxBadgeCount:" + r103 + ", lastReadBadgeCount:" + r112);
        return;
    L25:
        Channel r113 = ((n5b.a) ListProtector.get(r110, 0)).f518078c.getChannel();
        Log.i("ThreadService", "readThreadInner max:" + r102 + ", maxBadgeCount:" + r104);
        SdkSender.asynSendRequestNonWrap(Command.UPDATE_THREADS_ME_READ, new UpdateThreadsMeReadRequest.Builder().channel(com.ss.android.lark.parser.internal.g.b(r113)).thread_ids(r100).read_position(Integer.valueOf(r102)).read_position_badge_count(Integer.valueOf(r104)), null, new com.bytedance.ee.bear.middleground.drive.rustsdk.init.a());
    }

    public static List<MessageInfo> a(Entity r100, ThreadTopic r101, com.ss.android.lark.chat.entity.chatter.a r102, Map<String, Message> r103) {
        ArrayList r104 = new ArrayList();
        if (r101 != null) goto L6;
        return r104;
    L6:
        if (CollectionUtils.isEmpty(r101.getLatestAtMessageIds()) == false) goto L9;
        return r104;
    L9:
        return d(r100, r102, r103, r101.getLatestAtMessageIds());
    }

    public static List<MessageInfo> d(Entity r100, com.ss.android.lark.chat.entity.chatter.a r101, Map<String, Message> r102, List<String> r103) {
        ArrayList r104 = new ArrayList();
        Iterator<String> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L12;
        String r106 = r105.next();
        Message r107 = (Message) ((LinkedHashMap) r102).get(r106);
        if (r107 == null) goto L7;
        ChatChatter r108 = r101.b(r107.getChatId(), r107.getFromId());
        if (r108 == null) goto L10;
        MessageInfo r109 = new MessageInfo(r107, r108);
        r109.setTranslateInfo(com.ss.android.lark.parser.internal.d0.e(r107, r100, true));
        r109.setOriginalSender(com.ss.android.lark.parser.internal.a.g(r107, r101));
        r104.add(r109);
        goto L4
    L10:
        Log.e("ThreadService", "last at message sender is null: Id: " + r106);
        goto L4
    L7:
        Log.e("ThreadService", "last at message is null; Id: " + r106);
        goto L4
    L12:
        return r104;
    }

    @Override // com.ss.android.lark.biz.im.api.o0
    public final l5b.a Qb(String r100, MessageFetchScene r101, int r102, int r103, int r104, ChannelDataFetcherStrategy r105, int r110, boolean r111) {
        if (TextUtils.isEmpty(r100) == true) goto L9;
        if (r102 < 0) goto L9;
        a r106 = new a(this, r100, System.currentTimeMillis());
        GetThreadMessagesV2Request.Builder r107 = new GetThreadMessagesV2Request.Builder();
        r107.thread_id(r100).scene(b(r101)).redundancy_count(Integer.valueOf(r104)).position(Integer.valueOf(r102)).count(Integer.valueOf(r103)).strategy(c(r105)).preload_count(Integer.valueOf(r110)).need_response(Boolean.valueOf(r111));
        return this.f411629a.d(r107, r106);
    L9:
        return new l5b.a();
    }
}
