package nk6;

import ak6.e;
import ak6.g;
import com.bytedance.live.richcontent.widget.RichContentTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RichContentTextView f519481a;

    public b(RichContentTextView r100) {
        this.f519481a = r100;
    }

    @Override // ak6.e
    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        this.f519481a.setSpanRendResult(r100);
    }

    @Override // ak6.e
    public final void b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        this.f519481a.setSpanRendResult(r100);
    }
}
