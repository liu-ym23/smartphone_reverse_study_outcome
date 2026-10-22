package fu4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.loading.loadingview.GlobalShareRecordLoadingFactory;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends GlobalShareRecordLoadingFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f478904a = 0;

    /* JADX INFO: renamed from: fu4.a$a, reason: collision with other inner class name */
    public static final class C5952a {
    }

    static {
        f478904a = UIHelper.dp2px(27.0f);
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.bitable.loading.loadingview.GlobalShareRecordLoadingFactory, du4.d
    public final View a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r101 = super.a(r100);
        View r102 = r101.findViewById(R.id.loading_tab_view);
        if (r102 == null) goto L5;
        r102.setVisibility(8);
    L5:
        ViewGroup.LayoutParams r103 = ((RecyclerView) r101.findViewById(R.id.recycler_view)).getLayoutParams();
        if ((r103 instanceof LinearLayout.LayoutParams) == false) goto L8;
        LinearLayout.LayoutParams r104 = (LinearLayout.LayoutParams) r103;
    L9:
        if (r104 == null) goto L11;
        r104.topMargin = f478904a;
    L11:
        return r101;
    L8:
        r104 = null;
        goto L9
    }
}
