package dr3;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h extends e<fr3.a.h, fr3.a.g, TextView> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // dr3.e
    public final View b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AppCompatTextView r101 = new AppCompatTextView(r100);
        r101.setTextSize(1, ((fr3.a.h) ((fr3.a.g) this.f469762b).f478585e).f478600a);
        r101.setTextColor(((fr3.a.h) ((fr3.a.g) this.f469762b).f478585e).f478601b);
        r101.setText(((fr3.a.h) ((fr3.a.g) this.f469762b).f478585e).f478602c);
        if (((fr3.a.h) ((fr3.a.g) this.f469762b).f478585e).f478603d == false) goto L5;
        r101.setTypeface(Typeface.DEFAULT_BOLD);
    L5:
        return r101;
    }

    public h(List<? extends er3.d> r100, fr3.a.g r101) {
        Intrinsics.checkNotNullParameter(r100, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r101, "textConfig");
        super(r100, r101);
    }
}
