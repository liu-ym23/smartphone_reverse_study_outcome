package com.ss.android.lark.flow.feed.action.delete;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class FlowDeleteActionFactory$createFeedMenuActionHandler$1$handle$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ aeb.a $actionStatusListener;
    final /* synthetic */ UIFeedCard $data;
    final /* synthetic */ FeedActionEvent $event;
    final /* synthetic */ a this$0;

    public FlowDeleteActionFactory$createFeedMenuActionHandler$1$handle$1(a r100, UIFeedCard r101, FeedActionEvent r102, aeb.a r103) {
        this.$data = r101;
        this.$event = r102;
        this.$actionStatusListener = r103;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        throw null;
    }
}
