package ugb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar;
import com.ss.android.lark.flow.common.component.tag.FlowTagView;
import com.ss.android.lark.flow.common.utils.FlowTagBuilder;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends a {
    public b(CoreNavigationBar r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        super(r100);
    }

    @Override // ugb.e
    public final void a(Context r100, sxa.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "titleContext");
        FlowTagBuilder r102 = new FlowTagBuilder(r100);
        r102.f423180c = r101.f543850a.isPublic();
        r102.f423181d = r101.f543850a.is_department();
        r102.f423186i = d.a(r101.f543850a);
        FlowTagView r103 = r102.b();
        if (r103 == null) goto L5;
        r103.setTagStyle(new ahb.a(10.0f, 4.0f, 18.0f, 5.0f, 48));
    L6:
        View r104 = this.f550078c;
        if (r104 == null) goto L11;
        ViewGroup r105 = this.f550077b;
        if (r105 == null) goto L11;
        r105.removeView(r104);
    L11:
        this.f550078c = r103;
        if (r103 != null) goto L16;
        ViewGroup r106 = this.f550077b;
        if (r106 == null) goto L23;
        r106.setVisibility(8);
        return;
    L23:
        return;
    L16:
        ViewGroup r107 = this.f550077b;
        if (r107 == null) goto L19;
        r107.addView(r103);
    L19:
        ViewGroup r108 = this.f550077b;
        if (r108 == null) goto L25;
        r108.setVisibility(0);
        return;
    L25:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
