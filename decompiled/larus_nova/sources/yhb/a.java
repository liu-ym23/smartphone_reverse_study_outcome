package yhb;

import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.flow.replyinthread.pages.viewmodel.CardVisitorReplyInThreadViewModel;
import com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zhb.a f567677a;

    @Override // yhb.b
    public final List<TitleBarActionKey> a() {
        return CollectionsKt.listOf(TitleBarActionKey.FORWARD);
    }

    @Override // yhb.b
    public final FlowBaseReplyInThreadViewModel a1() {
        return (FlowBaseReplyInThreadViewModel) this.f567677a.getViewModel(CardVisitorReplyInThreadViewModel.class);
    }

    public a(zhb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        this.f567677a = r100;
    }
}
