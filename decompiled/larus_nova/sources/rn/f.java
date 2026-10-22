package rn;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f extends c<tn.a.f, tn.a.e, TextView> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // rn.c
    public final View b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AppCompatTextView r101 = new AppCompatTextView(r100);
        r101.setTextSize(1, ((tn.a.f) ((tn.a.e) this.f538637b).f546839e).f546851a);
        r101.setTextColor(((tn.a.f) ((tn.a.e) this.f538637b).f546839e).f546852b);
        r101.setText(((tn.a.f) ((tn.a.e) this.f538637b).f546839e).f546853c);
        if (((tn.a.f) ((tn.a.e) this.f538637b).f546839e).f546854d == false) goto L5;
        r101.setTypeface(Typeface.DEFAULT_BOLD);
    L5:
        return r101;
    }

    public f(List<? extends sn.d> r100, tn.a.e r101) {
        Intrinsics.checkNotNullParameter(r100, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r101, "textConfig");
        super(r100, r101);
    }
}
