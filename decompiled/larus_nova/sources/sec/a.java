package sec;

import android.content.Context;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.light.e;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.ss.android.lark.widget.table.entity.TableInfo;
import com.ss.android.lark.widget.table.newrefactor.TableViewLinearLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements kcc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TableInfo f541668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f541669b;

    /* JADX INFO: renamed from: sec.a$a, reason: collision with other inner class name */
    public static final class C7603a extends OnSingleClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f541670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TableInfo f541671b;

        @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
        public final void onSingleClick(View r100) {
            Object r101 = this.f541670a.getTag(R.id.tag_span_container_view);
            if ((r101 instanceof LKUILightTextView) == false) goto L5;
            LKUILightTextView r102 = (LKUILightTextView) r101;
        L6:
            if (r102 == null) goto L9;
            r102.g(r102, this.f541671b);
            return;
        L9:
            return;
        L5:
            r102 = null;
            goto L6
        }

        public C7603a(View r100, TableInfo r101) {
            this.f541670a = r100;
            this.f541671b = r101;
        }
    }

    @Override // kcc.a
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        TableViewLinearLayout r101 = (TableViewLinearLayout) r100;
        TableInfo r102 = this.f541668a;
        e r103 = this.f541669b;
        int r104 = r103.L;
        r101.b(r102, Integer.valueOf(r103.f445982J));
        r101.setOnClickListener(new C7603a(r100, r102));
    }

    @Override // kcc.a
    public final View b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new TableViewLinearLayout(r100, null);
    }

    public a(TableInfo r100, e r101) {
        this.f541668a = r100;
        this.f541669b = r101;
    }
}
