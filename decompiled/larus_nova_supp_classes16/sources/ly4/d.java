package ly4;

import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.ee.bear.route.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends ClickableSpan {
    public final /* synthetic */ String a;

    public d(String r1) {
        this.a = r1;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        tt5.a.b("DocCover_LocalCoverSelectionFragment", "" + this.a);
        ((h) org.koin.java.a.c(h.class, null, null, 6)).u5(this.a);
    }
}
