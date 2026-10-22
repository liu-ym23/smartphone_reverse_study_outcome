package v7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f553411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f553412e;

    @Override // u7.a
    public final View b() {
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.annie_lynx_loading, this.f549022b, false);
        View r101 = r100.findViewById(R.id.double_loading_view);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f553411d = r101;
        TextView r102 = (TextView) r100.findViewById(R.id.double_loading_text);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f553412e = r102;
        return r100;
    }

    @Override // u7.a
    public final void c() {
        super.c();
        View r100 = this.f553411d;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
        r100 = null;
    L6:
        r100.setVisibility(8);
    }

    @Override // u7.a
    public final void d() {
        super.d();
        View r100 = this.f553411d;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
        r100 = null;
    L6:
        r100.setVisibility(0);
    }

    @Override // v7.b
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        TextView r101 = this.f553412e;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r101 = null;
    L6:
        r101.setText(r100);
    }

    public a(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        super(r100, r101);
    }
}
