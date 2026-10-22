package com.larus.bmhome.chat.component.bottom.core;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.larus.bmhome.view.chatinput.ChatInput;
import com.larus.bmhome.view.resourcebar.ResourceBar;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/InputViewCreator;", "Lcom/larus/bmhome/chat/component/bottom/core/InputViewCreatorService;", "<init>", "()V", "stubCreateInputView", "Landroid/view/View;", "viewStub", "Landroid/view/ViewStub;", "id", "", "(Landroid/view/ViewStub;Ljava/lang/Integer;)Landroid/view/View;", "stubCreateSpringInputView", "", "addCreateInputViewToViewGroup", "viewRoot", "Landroid/view/ViewGroup;", "findInputView", "Lcom/larus/bmhome/chat/component/bottom/core/InputView;", "createInputView", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "createResourceBarView", "Lcom/larus/bmhome/view/resourcebar/bean/IResourceItemOperator;", "setIsImmersiveSlidingFeedVertical", "inputView", "isVertical", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InputViewCreator implements InputViewCreatorService {
    public InputViewCreator() {
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService
    public final void b(ViewGroup r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        View r101 = com.larus.utils.e1.m(r100).inflate(R.layout.larus_layout_input_view, r100, false);
        r100.addView(r101);
        r101.setId(R.id.input_delegate);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService
    public final View d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new ChatInput(r100, null, 6, 0);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService
    public final mt8.a e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new ResourceBar(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService
    public final g9 f(ViewGroup r100) {
        return new h9(new g9.b(r100), R.id.input_delegate);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService
    public final void g(ViewStub r100) {
        Intrinsics.checkNotNullParameter(r100, "viewStub");
        r100.setLayoutResource(R.layout.larus_layout_input_view_spring);
        r100.setInflatedId(R.id.input_delegate);
        r100.inflate();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService
    public final View a(ViewStub r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "viewStub");
        r100.setLayoutResource(R.layout.larus_layout_input_view);
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L6:
        r100.setInflatedId(r102);
        return r100.inflate();
    L5:
        r102 = R.id.input_delegate;
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService
    public final void c(g9 r100, boolean r101) {
        ChatInput r102 = null;
        if (r100 == null) goto L5;
        View r103 = r100.root();
    L7:
        if ((r103 instanceof ChatInput) == false) goto L9;
        r102 = (ChatInput) r103;
    L9:
        if (r102 == null) goto L12;
        r102.setIsImmersiveSlidingFeedVertical(r101);
        return;
    L12:
        return;
    L5:
        r103 = null;
        goto L7
    }
}
