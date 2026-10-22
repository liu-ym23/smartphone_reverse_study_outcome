package y22;

import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentEntry;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentInputConfig;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public interface e {
    CommentInputConfig a(CommentFlowContext r100);

    CommentFlowContext b(CommentEntry r100, Map r101);

    void c(CommentFlowContext r100);

    void d(CommentFlowContext r100);

    void destroy();

    boolean e(CommentFlowContext r100);

    void f(CommentFlowContext r100);

    String getName();
}
