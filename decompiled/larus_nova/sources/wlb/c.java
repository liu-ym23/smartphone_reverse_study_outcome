package wlb;

import android.content.Intent;
import com.ss.android.lark.inline.ai.api.ui.InlineAIPanel;
import com.ss.android.lark.inline.ai.api.ui.PromptGroup;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes36.dex */
public interface c {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(c r100, List r101, String r102, boolean r103, Function0 r104, int r105) {
            if ((r105 & 2) == 0) goto L6;
            r102 = null;
        L6:
            if ((r105 & 4) == 0) goto L9;
            r103 = false;
        L9:
            if ((r105 & 8) == 0) goto L11;
            r104 = null;
        L11:
            r100.b(r101, r102, r103, r104);
        }
    }

    void a();

    void b(List<PromptGroup> r100, String r101, boolean r102, Function0<Unit> r103);

    void c();

    void d(InlineAIPanel r100);

    void destroy();

    i1<Boolean> isShowing();

    void onActivityResult(int r100, int r101, Intent r102);

    boolean onBackPressed();
}
