package yhb;

import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel;
import com.ss.android.lark.flow.replyinthread.pages.viewmodel.MergeForwardReplyInThreadViewModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zhb.a f567678a;

    @Override // yhb.b
    public final FlowBaseReplyInThreadViewModel a1() {
        return (FlowBaseReplyInThreadViewModel) this.f567678a.getViewModel(MergeForwardReplyInThreadViewModel.class);
    }

    @Override // yhb.b
    public final List<TitleBarActionKey> a() {
        return CollectionsKt.emptyList();
    }

    public c(zhb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        this.f567678a = r100;
    }
}
