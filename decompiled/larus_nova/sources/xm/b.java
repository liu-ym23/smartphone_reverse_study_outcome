package xm;

import android.view.View;
import com.bytedance.android.ec.store.product.widget.ECTagFlowLayout;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECTagFlowLayout f564524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f564525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f564526c;

    public b(ECTagFlowLayout r100, d r101, int r102) {
        this.f564524a = r100;
        this.f564525b = r101;
        this.f564526c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ECTagFlowLayout r101 = this.f564524a;
        d r102 = this.f564525b;
        int r103 = this.f564526c;
        int r104 = ECTagFlowLayout.f48377m;
        r101.getClass();
        if (r102.f564531a == false) goto L5;
        r102.setChecked(false);
        if (r101.f48383f == null) goto L31;
        r102.getTagView();
    L31:
        Set<Integer> r105 = r101.f48384g;
        HashSet r106 = (HashSet) r105;
        r106.remove(Integer.valueOf(r103));
    L32:
        ECTagFlowLayout.b r107 = this.f564524a.f48385h;
        if (r107 == null) goto L36;
        Intrinsics.checkNotNull(r107);
        r107.a(this.f564525b, this.f564524a);
        return;
    L36:
        return;
    L5:
        if (r101.f48382e != 1) goto L20;
        if (((HashSet) r101.f48384g).size() != 1) goto L20;
        int r108 = ((Number) ((HashSet) r101.f48384g).iterator().next()).intValue();
        View r109 = r101.getChildAt(r108);
        if (r109 == null) goto L18;
        d r110 = (d) r109;
        r110.setChecked(false);
        if (r101.f48383f == null) goto L13;
        r110.getTagView();
    L13:
        r102.setChecked(true);
        if (r101.f48383f == null) goto L16;
        r102.getTagView();
    L16:
        Set<Integer> r111 = r101.f48384g;
        HashSet r112 = (HashSet) r111;
        r112.remove(Integer.valueOf(r108));
        Set<Integer> r113 = r101.f48384g;
        HashSet r114 = (HashSet) r113;
        r114.add(Integer.valueOf(r103));
        goto L32
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.store.product.widget.TagView");
    L20:
        if (r101.f48382e > 0) goto L22;
    L24:
        r102.setChecked(true);
        if (r101.f48383f == null) goto L27;
        r102.getTagView();
    L27:
        Set<Integer> r115 = r101.f48384g;
        HashSet r116 = (HashSet) r115;
        r116.add(Integer.valueOf(r103));
        goto L32
    L22:
        if (((HashSet) r101.f48384g).size() < r101.f48382e) goto L24;
        goto L24
    }
}
