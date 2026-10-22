package my4;

import android.content.Context;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.doc.cover.selectcover.official.CoverImageAdapter;
import com.bytedance.ee.util.ui.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements w85.a.b {
    public final /* synthetic */ CoverImageAdapter a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ ImageView c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ lt7.d f;

    @Override // w85.a.b
    public final void e(String r1) {
    }

    @Override // w85.a.b
    public final void c(String r9, w85.b r10) {
        CoverImageAdapter r5 = this.a;
        Context r1 = this.b;
        Intrinsics.checkNotNull(r10);
        String r2 = r10.b.getAbsolutePath();
        ImageView r6 = this.c;
        int r3 = this.d;
        int r4 = this.e;
        lt7.d r7 = this.f;
        int r11 = CoverImageAdapter.d;
        r5.getClass();
        if (r1 != null) goto L6;
        return;
    L6:
        if (com.bytedance.ee.util.ui.b.b(r1) == false) goto L11;
        j.c(new com.bytedance.ee.bear.doc.cover.selectcover.official.b(r1, r2, r3, r4, r5, r6, r7));
        return;
    }

    @Override // w85.a.b
    public final void a(String r2, String r3, int r4) {
        tt5.a.d("DocCover_OfficialCoverSelectionFragment", "onFailed, key = " + r3 + ", errorCode = " + r4);
    }

    public a(CoverImageAdapter r1, Context r2, AppCompatImageView r3, int r4, int r5, lt7.d r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
