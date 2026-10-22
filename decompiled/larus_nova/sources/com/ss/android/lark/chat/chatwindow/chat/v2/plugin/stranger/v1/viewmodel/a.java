package com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel;

import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.im.v1.GetP2PChatUnfamiliarStrategyRequest;
import com.bytedance.lark.pb.im.v1.GetP2PChatUnfamiliarStrategyResponse;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.f;

/* JADX INFO: loaded from: classes35.dex */
public interface a extends f {
    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.f
    @SdkPush(5003)
    /* synthetic */ RucketJob<Entity> chatsPush();

    @SdkCall(4189)
    RucketJob<GetP2PChatUnfamiliarStrategyResponse> getP2PChatUnFamiliarStrategy(GetP2PChatUnfamiliarStrategyRequest r100);
}
