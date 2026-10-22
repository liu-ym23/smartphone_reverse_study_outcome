package com.larus.bmhome.chat.component.bottom.core;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H&J\u001a\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H&¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/InputViewCreatorService;", "", "stubCreateInputView", "Landroid/view/View;", "viewStub", "Landroid/view/ViewStub;", "id", "", "(Landroid/view/ViewStub;Ljava/lang/Integer;)Landroid/view/View;", "stubCreateSpringInputView", "", "addCreateInputViewToViewGroup", "viewRoot", "Landroid/view/ViewGroup;", "findInputView", "Lcom/larus/bmhome/chat/component/bottom/core/InputView;", "createInputView", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "createResourceBarView", "Lcom/larus/bmhome/view/resourcebar/bean/IResourceItemOperator;", "setIsImmersiveSlidingFeedVertical", "inputView", "isVertical", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface InputViewCreatorService {
    View a(ViewStub r100, Integer r101);

    void b(ViewGroup r100);

    void c(g9 r100, boolean r101);

    View d(Context r100);

    mt8.a e(Context r100);

    g9 f(ViewGroup r100);

    void g(ViewStub r100);
}
