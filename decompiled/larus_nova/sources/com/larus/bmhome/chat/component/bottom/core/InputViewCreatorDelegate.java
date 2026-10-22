package com.larus.bmhome.chat.component.bottom.core;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u001b\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0096\u0001J \u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0001¢\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\tH\u0096\u0001¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/InputViewCreatorDelegate;", "Lcom/larus/bmhome/chat/component/bottom/core/InputViewCreatorService;", "<init>", "()V", "addCreateInputViewToViewGroup", "", "viewRoot", "Landroid/view/ViewGroup;", "id", "", "createInputView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "createResourceBarView", "Lcom/larus/bmhome/view/resourcebar/bean/IResourceItemOperator;", "findInputView", "Lcom/larus/bmhome/chat/component/bottom/core/InputView;", "setIsImmersiveSlidingFeedVertical", "inputView", "isVertical", "", "stubCreateInputView", "viewStub", "Landroid/view/ViewStub;", "(Landroid/view/ViewStub;Ljava/lang/Integer;)Landroid/view/View;", "stubCreateSpringInputView", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InputViewCreatorDelegate implements InputViewCreatorService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final InputViewCreatorDelegate f298409b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InputViewCreatorService f298410a;

    static {
        f298409b = new InputViewCreatorDelegate();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService
    public final View a(ViewStub r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "viewStub");
        return this.f298410a.a(r100, r101);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService
    public final void b(ViewGroup r100) {
        this.f298410a.b(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService
    public final void c(g9 r100, boolean r101) {
        this.f298410a.c(r100, r101);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService
    public final View d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f298410a.d(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService
    public final mt8.a e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f298410a.e(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService
    public final g9 f(ViewGroup r100) {
        return this.f298410a.f(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService
    public final void g(ViewStub r100) {
        Intrinsics.checkNotNullParameter(r100, "viewStub");
        this.f298410a.g(r100);
    }

    private InputViewCreatorDelegate() {
        InputViewCreatorService r100 = (InputViewCreatorService) ServiceManager.get().getService(InputViewCreatorService.class);
        if (r100 != null) goto L5;
        r100 = EmptyInputViewCreatorService.f298402a;
    L5:
        this.f298410a = r100;
    }
}
