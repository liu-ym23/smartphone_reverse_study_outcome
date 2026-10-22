package com.ss.android.lark.flow.chat.page.flow.plugin.tip;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Long;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class FlowMentionDoubaoTipPlugin$uid$2 extends Lambda implements Function0<Long> {
    public static final FlowMentionDoubaoTipPlugin$uid$2 INSTANCE = null;

    static {
        INSTANCE = new FlowMentionDoubaoTipPlugin$uid$2();
    }

    public FlowMentionDoubaoTipPlugin$uid$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return StringsKt.toLongOrNull(ChatCoreModule.a().getLoginDependency().getUserId());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return invoke();
    }
}
