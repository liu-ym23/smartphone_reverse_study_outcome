package com.ss.android.lark.inline.ai.ui;

import android.content.Intent;
import com.ss.android.lark.inline.ai.api.ui.InlineAIPanel;
import com.ss.android.lark.inline.ai.api.ui.PromptGroup;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes36.dex */
public interface b {
    void b(List<PromptGroup> r100, String r101, boolean r102, Function0<Unit> r103);

    void c();

    void d(InlineAIPanel r100);

    void destroy();

    void hide();

    StateFlowImpl isShowing();

    void onActivityResult(int r100, int r101, Intent r102);

    boolean onBackPressed();
}
