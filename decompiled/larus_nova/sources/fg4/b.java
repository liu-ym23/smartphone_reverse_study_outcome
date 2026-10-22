package fg4;

import android.view.View;
import com.bytedance.commerce.uikit.flowlayout.TagFlowLayout;
import java.util.HashSet;
import java.util.Set;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TagFlowLayout f476830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f476831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f476832c;

    public b(TagFlowLayout r100, c r101, int r102) {
        this.f476830a = r100;
        this.f476831b = r101;
        this.f476832c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TagFlowLayout r101 = this.f476830a;
        c r102 = this.f476831b;
        int r103 = this.f476832c;
        int r104 = TagFlowLayout.f202948l;
        r101.getClass();
        if (r102.f476834a == false) goto L5;
        r102.setChecked(false);
        if (r101.f202951k == null) goto L31;
        r102.getTagView();
    L31:
        Set<Integer> r105 = r101.f202950j;
        HashSet r106 = (HashSet) r105;
        r106.remove(Integer.valueOf(r103));
    L32:
        this.f476830a.getTagClickListener();
        return;
    L5:
        if (r101.f202949i != 1) goto L20;
        if (((HashSet) r101.f202950j).size() != 1) goto L20;
        int r107 = ((Number) ((HashSet) r101.f202950j).iterator().next()).intValue();
        View r108 = r101.getChildAt(r107);
        if (r108 == null) goto L18;
        c r109 = (c) r108;
        r109.setChecked(false);
        if (r101.f202951k == null) goto L13;
        r109.getTagView();
    L13:
        r102.setChecked(true);
        if (r101.f202951k == null) goto L16;
        r102.getTagView();
    L16:
        Set<Integer> r110 = r101.f202950j;
        HashSet r111 = (HashSet) r110;
        r111.remove(Integer.valueOf(r107));
        Set<Integer> r112 = r101.f202950j;
        HashSet r113 = (HashSet) r112;
        r113.add(Integer.valueOf(r103));
        goto L32
    L18:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.commerce.uikit.flowlayout.TagView");
    L20:
        if (r101.f202949i > 0) goto L22;
    L24:
        r102.setChecked(true);
        if (r101.f202951k == null) goto L27;
        r102.getTagView();
    L27:
        Set<Integer> r114 = r101.f202950j;
        HashSet r115 = (HashSet) r114;
        r115.add(Integer.valueOf(r103));
        goto L32
    L22:
        if (((HashSet) r101.f202950j).size() < r101.f202949i) goto L24;
        goto L24
    }
}
