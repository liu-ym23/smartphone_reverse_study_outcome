package com.ss.android.lark.reaction.service.impl;

import android.os.SystemClock;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.im.v1.CreateReactionRequest;
import com.bytedance.lark.pb.im.v1.CreateReactionResponse;
import com.bytedance.lark.pb.im.v1.DeleteReactionRequest;
import com.bytedance.lark.pb.im.v1.DeleteReactionResponse;
import com.bytedance.lark.pb.im.v1.GetEmojiPanelRequest;
import com.bytedance.lark.pb.im.v1.GetEmojiPanelResponse;
import com.bytedance.lark.pb.im.v1.GetUserMRUReactionsRequest;
import com.bytedance.lark.pb.im.v1.GetUserMRUReactionsResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.pb.reactions.UpdateUserRecentlyUsedReactionRequest;
import com.ss.android.lark.pb.reactions.UpdateUserRecentlyUsedReactionResponse;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import qsb.f;

/* JADX INFO: loaded from: classes37.dex */
@UserScope
public final class ReactionService2 extends c0c.c implements m2c.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f439182b;

    public static final class a {
    }

    static {
    }

    @Override // m2c.b
    public final List<String> N(final boolean r110) {
        Log.i("ReactionService2", "getMRUReactionList, local: " + r110);
        final long r100 = SystemClock.elapsedRealtime();
        if (r110 == false) goto L5;
        SyncDataStrategy r101 = SyncDataStrategy.LOCAL;
    L6:
        GetUserMRUReactionsRequest.Builder r102 = new GetUserMRUReactionsRequest.Builder().sync_data_strategy(r101);
        l r103 = this.f439182b;
        Intrinsics.checkNotNull(r102);
        GetUserMRUReactionsResponse r104 = (GetUserMRUReactionsResponse) t.c(r103.h(new com.bytedance.lark.rustclient.api.d(r102, GetUserMRUReactionsResponse.ADAPTER, Command.GET_USER_MRU_REACTIONS, null, null, null, null, 248)).execute(), new ReactionService2$getMRUReactionList$1(r100, r110));
        if (r104 == null) goto L11;
        Log.i("ReactionService2", "getMRUReactionList success, local: " + r110);
        long r105 = SystemClock.elapsedRealtime() - r100;
        int r106 = qsb.c.f534734a;
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new f(r110, null, r105, 0));
        ArrayList r111 = new ArrayList();
        List<String> r107 = r104.user_mru_reactions;
        if (r107 == null) goto L13;
        r111.addAll(r107);
        return r111;
    L13:
        return r111;
    L11:
        return null;
    L5:
        r101 = SyncDataStrategy.FORCE_SERVER;
        goto L6
    }

    @Inject
    public ReactionService2(m r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "rustClient");
        super(r100);
        this.f439182b = r101;
    }

    @Override // m2c.b
    public final void o7(final boolean r110, final ReactionOrderService2$fetchEmojiPanelData$2 r111) {
        Log.i("ReactionService2", "getEmojiPanelData, local: " + r110);
        if (r110 == false) goto L5;
        SyncDataStrategy r100 = SyncDataStrategy.LOCAL;
    L6:
        GetEmojiPanelRequest.Builder r101 = new GetEmojiPanelRequest.Builder().sync_data_strategy(r100);
        l r102 = this.f439182b;
        Intrinsics.checkNotNull(r101);
        t.a(r102.h(new com.bytedance.lark.rustclient.api.d(r101, GetEmojiPanelResponse.ADAPTER, Command.GET_EMOJI_PANEL, null, null, null, null, 248)).a(), new ReactionService2$getEmojiPanelData$1(r110, r111), new ReactionService2$getEmojiPanelData$2(r110, r111), new ReactionService2$getEmojiPanelData$3(r110, r111));
        return;
    L5:
        r100 = SyncDataStrategy.FORCE_SERVER;
        goto L6
    }

    @Override // m2c.b
    public final void q(final String r110, final IGetDataCallback<Integer> r111) {
        Intrinsics.checkNotNullParameter(r110, "reactionKey");
        Log.i("ReactionService2", "putReactionPassThrough, key: " + r110);
        UpdateUserRecentlyUsedReactionRequest.Builder r100 = new UpdateUserRecentlyUsedReactionRequest.Builder().reaction_key(r110);
        l r101 = this.f439182b;
        Intrinsics.checkNotNull(r100);
        t.a(r101.h(new com.bytedance.lark.rustclient.api.d(r100, UpdateUserRecentlyUsedReactionResponse.ADAPTER, Command.POST_GATEWAY, null, null, com.ss.android.lark.pb.improto.Command.UPDATE_USER_RECENTLY_USED_EMOJI, null, 184)).a(), new ReactionService2$putReactionPassThrough$1(r110, r111), new ReactionService2$putReactionPassThrough$2(r110, r111), new ReactionService2$putReactionPassThrough$3(r110, r111));
    }

    @Override // m2c.b
    public final void Ya(final String r110, final String r111, boolean r112, final IGetDataCallback<Integer> r113) {
        Intrinsics.checkNotNullParameter(r110, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r111, "reactionType");
        if (r112 == false) goto L5;
        Log.i("ReactionService2", "deleteReaction, msgId: " + r110 + ", key: " + r111);
        DeleteReactionRequest.Builder r100 = new DeleteReactionRequest.Builder().message_id(r110).type(r111);
        l r114 = this.f439182b;
        Intrinsics.checkNotNull(r100);
        t.a(r114.h(new com.bytedance.lark.rustclient.api.d(r100, DeleteReactionResponse.ADAPTER, Command.DELETE_REACTION, null, null, null, null, 248)).a(), new ReactionService2$deleteReaction$1(r110, r111, r113), new ReactionService2$deleteReaction$2(r110, r111, r113), new ReactionService2$deleteReaction$3(r110, r111, r113));
        return;
    L5:
        Log.i("ReactionService2", "addReaction, msgId: " + r110 + ", key: " + r111);
        CreateReactionRequest.Builder r101 = new CreateReactionRequest.Builder().message_id(r110).type(r111);
        l r115 = this.f439182b;
        Intrinsics.checkNotNull(r101);
        t.a(r115.h(new com.bytedance.lark.rustclient.api.d(r101, CreateReactionResponse.ADAPTER, Command.CREATE_REACTION, null, null, null, null, 248)).a(), new ReactionService2$addReaction$1(r110, r111, this, r113), new ReactionService2$addReaction$2(r110, r111, r113), new ReactionService2$addReaction$3(r110, r111, r113));
    }
}
