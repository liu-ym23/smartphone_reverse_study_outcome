package ly4;

import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.ee.bear.route.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f511314a;

    public d(String r100) {
        this.f511314a = r100;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        tt5.a.b("DocCover_LocalCoverSelectionFragment", "" + this.f511314a);
        ((h) org.koin.java.a.c(h.class, null, null, 6)).u5(this.f511314a);
    }
}
