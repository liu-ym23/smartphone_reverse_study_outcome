package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen;

import com.bytedance.lark.pb.basic.v1.Entity;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.job.RucketJob;

/* JADX INFO: loaded from: classes35.dex */
public interface f {
    @SdkPush(5003)
    RucketJob<Entity> chatsPush();
}
