package dr3;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends e<fr3.a.h, fr3.a.g, TextView> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // dr3.e
    public final View b(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        AppCompatTextView r0 = new AppCompatTextView(r3);
        r0.setTextSize(1, ((fr3.a.h) ((fr3.a.g) this.b).e).a);
        r0.setTextColor(((fr3.a.h) ((fr3.a.g) this.b).e).b);
        r0.setText(((fr3.a.h) ((fr3.a.g) this.b).e).c);
        if (((fr3.a.h) ((fr3.a.g) this.b).e).d == false) goto L5;
        r0.setTypeface(Typeface.DEFAULT_BOLD);
    L5:
        return r0;
    }

    public h(List<? extends er3.d> r2, fr3.a.g r3) {
        Intrinsics.checkNotNullParameter(r2, "actions");
        Intrinsics.checkNotNullParameter(r3, "textConfig");
        super(r2, r3);
    }
}
