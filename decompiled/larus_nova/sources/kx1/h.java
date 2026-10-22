package kx1;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.feedback.Option;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class h extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f506549d;

    @Override // kx1.a, kx1.c
    public final void b() {
        this.f506537a = true;
        ((ConstraintLayout) d(R.id.root_view)).setBackgroundResource(R.drawable.ttlive_bg_feedback_option_select);
        d(R.id.ic_select).setVisibility(0);
    }

    @Override // kx1.a, kx1.c
    public final void c() {
        this.f506537a = false;
        ((ConstraintLayout) d(R.id.root_view)).setBackgroundResource(R.drawable.ttlive_bg_feedback_option_unselected);
        d(R.id.ic_select).setVisibility(8);
    }

    @Override // kx1.a
    public int getLayoutId() {
        return R.layout.ttlive_layout_feedback_option;
    }

    public final View d(int r100) {
        if (this.f506549d != null) goto L5;
        this.f506549d = new LinkedHashMap();
    L5:
        View r101 = this.f506549d.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f506549d.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public h(Context r100, Option r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "option");
        Intrinsics.checkNotNullParameter(r102, "listener");
        super(r100, r101, r102);
        this.f506549d = new LinkedHashMap();
        View.inflate(r100, getLayoutId(), this);
        TextView r103 = (TextView) d(R.id.option_view);
        String r104 = r101.text;
        if (r104 != null) goto L6;
        r104 = "";
    L6:
        r103.setText(r104);
    }
}
