package com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v2.view;

import androidx.recyclerview.widget.AsyncListDiffer;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v2/view/ChatTabTitleData;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class TabTitleView$TabItemAdapter$differ$2 extends Lambda implements Function0<AsyncListDiffer<ChatTabTitleData>> {
    final /* synthetic */ TabTitleView.TabItemAdapter this$0;

    public TabTitleView$TabItemAdapter$differ$2(TabTitleView.TabItemAdapter r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AsyncListDiffer<ChatTabTitleData> invoke() {
        return new AsyncListDiffer(this.this$0, new AnonymousClass1());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AsyncListDiffer<ChatTabTitleData> invoke() {
        return invoke();
    }
}
