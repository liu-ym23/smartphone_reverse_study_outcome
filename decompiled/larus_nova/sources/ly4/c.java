package ly4;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.bytedance.ee.bear.doc.cover.selectcover.local.LocalCoverSelectionFragment;
import com.bytedance.ee.bear.doc.cover.selectcover.local.LocalCoverSelectionFragment$setTipTextStyle$underLineSpan$1;
import com.bytedance.ee.bear.facade.common.widget.u;
import com.larus.nova.R;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f511305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f511306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f511307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TextView f511308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ float f511309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f511310f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ LocalCoverSelectionFragment f511311g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f511312h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f511313i;

    /* JADX WARN: Type inference failed for: r1v6, types: [T, java.lang.String] */
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.f511305a.element == false) goto L5;
        return;
    L5:
        int r100 = this.f511306b;
        float r101 = r100 - (this.f511307c % r100);
        int r102 = this.f511308d.getLineCount();
        double r103 = Math.ceil(this.f511307c / this.f511306b);
        if (r101 < (this.f511309e * 1.5f)) goto L8;
    L10:
        final LocalCoverSelectionFragment r104 = this.f511311g;
        TextView r105 = this.f511308d;
        String r106 = this.f511310f.element + this.f511312h;
        String r107 = this.f511310f.element;
        String r108 = this.f511313i;
        int r109 = LocalCoverSelectionFragment.f217814g;
        r104.getClass();
        SpannableStringBuilder r110 = new SpannableStringBuilder();
        r110.append(r106);
        r110.setSpan(new d(r108), r107.length(), r106.length(), 33);
        r110.setSpan(new LocalCoverSelectionFragment$setTipTextStyle$underLineSpan$1(r104), r107.length(), r106.length(), 33);
        r110.setSpan(new ForegroundColorSpan(r104.getResources().getColor(R.color.text_caption)), 0, r107.length(), 33);
        r105.setText(r110);
        r105.setMovementMethod(u.a());
        this.f511305a.element = true;
        return;
    L8:
        if (r103 < r102) goto L10;
        this.f511310f.element = this.f511310f.element + '\n';
        goto L10
    }

    public c(Ref.BooleanRef r100, int r101, float r102, TextView r103, float r104, Ref.ObjectRef<String> r105, LocalCoverSelectionFragment r106, String r107, String r108) {
        this.f511305a = r100;
        this.f511306b = r101;
        this.f511307c = r102;
        this.f511308d = r103;
        this.f511309e = r104;
        this.f511310f = r105;
        this.f511311g = r106;
        this.f511312h = r107;
        this.f511313i = r108;
    }
}
