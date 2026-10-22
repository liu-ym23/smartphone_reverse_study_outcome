package com.larus.bmhome.chat.component.bottom.core;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/EmptyInputViewCreatorService;", "Lcom/larus/bmhome/chat/component/bottom/core/InputViewCreatorService;", "<init>", "()V", "stubCreateInputView", "", "viewStub", "Landroid/view/ViewStub;", "id", "", "(Landroid/view/ViewStub;Ljava/lang/Integer;)Ljava/lang/Void;", "stubCreateSpringInputView", "", "addCreateInputViewToViewGroup", "viewRoot", "Landroid/view/ViewGroup;", "findInputView", "Lcom/larus/bmhome/chat/component/bottom/core/InputView;", "createInputView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "createResourceBarView", "Lcom/larus/bmhome/view/resourcebar/bean/IResourceItemOperator;", "setIsImmersiveSlidingFeedVertical", "inputView", "isVertical", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmptyInputViewCreatorService implements InputViewCreatorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EmptyInputViewCreatorService f298402a = null;

    static {
        f298402a = new EmptyInputViewCreatorService();
    }

    private EmptyInputViewCreatorService() {
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService
    public final void b(ViewGroup r100) {
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService
    public final void c(g9 r100, boolean r101) {
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService
    public final g9 f(ViewGroup r100) {
        return null;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService
    public final void g(ViewStub r100) {
        Intrinsics.checkNotNullParameter(r100, "viewStub");
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService
    public final View d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new View(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService
    public final mt8.a e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        throw new UnsupportedOperationException("empty impl for resource item view");
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService
    public final View a(ViewStub r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "viewStub");
        throw new IllegalStateException("EmptyInputViewCreatorService");
    }
}
