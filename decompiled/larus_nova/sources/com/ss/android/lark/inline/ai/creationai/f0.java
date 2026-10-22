package com.ss.android.lark.inline.ai.creationai;

import com.ss.android.lark.inline.ai.api.creationai.CreationAIPanel;
import com.ss.android.lark.inline.ai.api.creationai.FeedbackJSParams;
import com.ss.android.lark.inline.ai.api.creationai.SubPanelInfo;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes36.dex */
public interface f0 {
    void b(SubPanelInfo r100);

    void c(FeedbackJSParams r100);

    void d(SubPanelInfo r100);

    void destroy();

    void e();

    void f(Object r100);

    void g();

    void h(CreationAIPanel r100);

    void hide();

    StateFlowImpl isShowing();

    void onActivityResult();

    boolean onBackPressed();
}
