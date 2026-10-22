package my4;

import android.content.Context;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.doc.cover.selectcover.official.CoverImageAdapter;
import com.bytedance.ee.util.ui.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements w85.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoverImageAdapter f516364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f516365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ImageView f516366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f516367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f516368e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ lt7.d f516369f;

    @Override // w85.a.b
    public final void e(String r100) {
    }

    @Override // w85.a.b
    public final void c(String r100, w85.b r110) {
        CoverImageAdapter r101 = this.f516364a;
        Context r102 = this.f516365b;
        Intrinsics.checkNotNull(r110);
        String r103 = r110.f558653b.getAbsolutePath();
        ImageView r104 = this.f516366c;
        int r105 = this.f516367d;
        int r106 = this.f516368e;
        lt7.d r107 = this.f516369f;
        int r108 = CoverImageAdapter.f217821d;
        r101.getClass();
        if (r102 != null) goto L6;
        return;
    L6:
        if (com.bytedance.ee.util.ui.b.b(r102) == false) goto L11;
        j.c(new com.bytedance.ee.bear.doc.cover.selectcover.official.b(r102, r103, r105, r106, r101, r104, r107));
        return;
    }

    @Override // w85.a.b
    public final void a(String r100, String r101, int r102) {
        tt5.a.d("DocCover_OfficialCoverSelectionFragment", "onFailed, key = " + r101 + ", errorCode = " + r102);
    }

    public a(CoverImageAdapter r100, Context r101, AppCompatImageView r102, int r103, int r104, lt7.d r105) {
        this.f516364a = r100;
        this.f516365b = r101;
        this.f516366c = r102;
        this.f516367d = r103;
        this.f516368e = r104;
        this.f516369f = r105;
    }
}
