package com.ss.android.lark.chat.base.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@AppConfig(key = "message_content_folding_control_params")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/chat/base/model/MessageContentFoldingControlParams;", "", "<init>", "()V", "chatFoldingTriggerHeightFactor", "", "getChatFoldingTriggerHeightFactor", "()F", "setChatFoldingTriggerHeightFactor", "(F)V", "chatFoldedHeightFactor", "getChatFoldedHeightFactor", "setChatFoldedHeightFactor", "topicFoldingTriggerHeightFactor", "getTopicFoldingTriggerHeightFactor", "setTopicFoldingTriggerHeightFactor", "topicFoldedHeightFactor", "getTopicFoldedHeightFactor", "setTopicFoldedHeightFactor", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageContentFoldingControlParams {

    @SerializedName("chat_folded_height_factor")
    private float chatFoldedHeightFactor;

    @SerializedName("chat_folding_trigger_height_factor")
    private float chatFoldingTriggerHeightFactor;

    @SerializedName("topic_folded_height_factor")
    private float topicFoldedHeightFactor;

    @SerializedName("topic_folding_trigger_height_factor")
    private float topicFoldingTriggerHeightFactor;

    public MessageContentFoldingControlParams() {
        this.chatFoldingTriggerHeightFactor = 3.2f;
        this.chatFoldedHeightFactor = 2.2f;
        this.topicFoldingTriggerHeightFactor = 0.9f;
        this.topicFoldedHeightFactor = 0.9f;
    }

    public final float a() {
        return this.chatFoldedHeightFactor;
    }

    public final float b() {
        return this.chatFoldingTriggerHeightFactor;
    }

    public final float c() {
        return this.topicFoldedHeightFactor;
    }

    public final float d() {
        return this.topicFoldingTriggerHeightFactor;
    }
}
