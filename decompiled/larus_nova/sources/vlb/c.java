package vlb;

import android.content.Intent;
import com.ss.android.lark.inline.ai.api.creationai.CreationAIPanel;
import com.ss.android.lark.inline.ai.api.creationai.FeedbackJSParams;
import com.ss.android.lark.inline.ai.api.creationai.SubPanelInfo;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes36.dex */
public interface c {
    void a();

    void b(SubPanelInfo r100);

    void c(FeedbackJSParams r100);

    void d(SubPanelInfo r100);

    void destroy();

    void e();

    void f(Object r100);

    void g();

    void h(CreationAIPanel r100);

    i1<Boolean> isShowing();

    void onActivityResult(int r100, int r101, Intent r102);

    boolean onBackPressed();
}
