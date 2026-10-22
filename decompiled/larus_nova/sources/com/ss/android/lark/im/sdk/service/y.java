package com.ss.android.lark.im.sdk.service;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.im.v1.GetTopicGroupsRequest;
import com.bytedance.lark.pb.im.v1.GetTopicGroupsResponse;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.thread.TopicGroup;
import com.ss.android.lark.parser.internal.c0;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@UserScope
public final class y implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f426118a;

    @Inject
    public y(com.bytedance.lark.rustclient.api.l r100) {
        Intrinsics.checkNotNullParameter(r100, "userClient");
        this.f426118a = r100;
    }

    @Override // com.ss.android.lark.im.sdk.service.x
    public final TopicGroup fc(String r110) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return null;
    L5:
        if (r110 != null) goto L7;
        return null;
    L7:
        GetTopicGroupsRequest.Builder r100 = new GetTopicGroupsRequest.Builder().group_ids(CollectionsKt.listOf(r110));
        Boolean r101 = Boolean.FALSE;
        GetTopicGroupsRequest.Builder r102 = r100.sync_data(r101).need_sync_unsubscribe_groups(r101);
        Intrinsics.checkNotNull(r102);
        com.bytedance.lark.rustclient.api.d r103 = new com.bytedance.lark.rustclient.api.d(r102, GetTopicGroupsResponse.ADAPTER, Command.GET_TOPIC_GROUPS, null, null, null, null, 248);
        GetTopicGroupsResponse r104 = (GetTopicGroupsResponse) com.bytedance.lark.rustclient.api.t.c(this.f426118a.h(r103).execute(), null);
        if (r104 == null) goto L17;
        Entity r105 = r104.entity;
        if (r105 == null) goto L17;
        if (CollectionUtils.isNotEmpty(r105.topic_groups) == false) goto L17;
        com.bytedance.lark.pb.basic.v1.TopicGroup r111 = r104.entity.topic_groups.get(r110);
        if (r111 == null) goto L17;
        return c0.a(r111, null);
    L17:
        return null;
    }
}
