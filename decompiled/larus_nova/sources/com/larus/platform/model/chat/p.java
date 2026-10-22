package com.larus.platform.model.chat;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/larus/platform/model/chat/DeepThinkingConfig;", "", "deepThinkOnlySupportHalfFold", "", "deepThinkSupportDynamicBg", "streamTypingOptimize", "keepAnchorTopOptimize", "<init>", "(ZZZZ)V", "getDeepThinkOnlySupportHalfFold", "()Z", "getDeepThinkSupportDynamicBg", "getStreamTypingOptimize", "getKeepAnchorTopOptimize", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class p {

    @SerializedName("deep_think_only_support_half_fold")
    private final boolean deepThinkOnlySupportHalfFold;

    @SerializedName("deep_think_support_dynamic_bg")
    private final boolean deepThinkSupportDynamicBg;

    @SerializedName("keep_anchor_top_optimize")
    private final boolean keepAnchorTopOptimize;

    @SerializedName("stream_typing_optimize")
    private final boolean streamTypingOptimize;

    public p() {
        this(0);
    }

    public final boolean a() {
        return this.deepThinkOnlySupportHalfFold;
    }

    public final boolean b() {
        return this.keepAnchorTopOptimize;
    }

    public final boolean c() {
        return this.streamTypingOptimize;
    }

    public p(int r100) {
        this.deepThinkOnlySupportHalfFold = false;
        this.deepThinkSupportDynamicBg = false;
        this.streamTypingOptimize = true;
        this.keepAnchorTopOptimize = true;
    }
}
