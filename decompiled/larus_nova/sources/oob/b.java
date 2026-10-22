package oob;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.keyboard2.f;
import com.ss.android.lark.keyboard.utils.h;
import com.ss.android.lark.keyboard.widget.KBMenuContainerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends KBMenuContainerView {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<Unit> f524666m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f524667n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f524668o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f524669p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f524670q;

    public static final class a implements f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f524671b;

        public a(Context r100) {
            this.f524671b = y9c.d.d(r100, R.dimen.keyboard_icon_horizontal_margin_ig_aa);
        }

        @Override // com.ss.android.lark.keyboard.keyboard2.f
        public final void a(KBMenuContainerView r100, List<? extends View> r101) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            Intrinsics.checkNotNullParameter(r101, "visibleChildViews");
            Iterator<T> r102 = r101.iterator();
        L4:
            if (r102.hasNext() == false) goto L10;
            View r103 = (View) r102.next();
            ViewGroup.LayoutParams r104 = r103.getLayoutParams();
            if (r104 == null) goto L9;
            ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
            r105.rightMargin = this.f524671b;
            r103.setLayoutParams(r105);
            goto L4
        L9:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
    }

    /* JADX INFO: renamed from: oob.b$b, reason: collision with other inner class name */
    public static final class C7081b {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.widget.KBMenuContainerView
    public int getIconWidth() {
        return this.f524669p;
    }

    @Override // com.ss.android.lark.keyboard.widget.KBMenuContainerView
    public int getSendWrapperWidth() {
        return this.f524670q;
    }

    @Override // com.ss.android.lark.keyboard.widget.KBMenuContainerView
    public int getVerticalPadding() {
        return this.f524668o;
    }

    public final void setBackViewVisibility$keyboard_biz_aa_release(int r100) {
        View r101 = this.f524667n;
        if (r101 == null) goto L6;
        r101.setVisibility(r100);
        return;
    }

    @Override // com.ss.android.lark.keyboard.widget.KBMenuContainerView
    public void setIconWidth(int r100) {
        this.f524669p = r100;
    }

    @Override // com.ss.android.lark.keyboard.widget.KBMenuContainerView
    public void setSendWrapperWidth(int r100) {
        this.f524670q = r100;
    }

    @Override // com.ss.android.lark.keyboard.widget.KBMenuContainerView
    public void setVerticalPadding(int r100) {
        this.f524668o = r100;
    }

    public b(Context r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(null, "subIcons");
        Intrinsics.checkNotNullParameter(r101, "exitAction");
        super(r100, null, 0, 14);
        this.f524666m = r101;
        LinkedList r102 = new LinkedList(null);
        this.f524668o = y9c.d.d(r100, R.dimen.keyboard_icon_vertical_margin_ig_aa);
        this.f524669p = y9c.d.a(32);
        this.f524670q = y9c.d.a(100);
        setOrientation(0);
        setGravity(8388627);
        AppCompatImageView r103 = h.a(getContext(), R.id.kb_plugin_style_back, R.drawable.ic_sub_plugin_back);
        r103.setSelected(true);
        r103.setOnClickListener(new c(this));
        r103.setPadding(0, 0, y9c.d.d(getContext(), R.dimen.keyboard_icon_padding_ig_aa), 0);
        r102.add(0, r103);
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r105 = r102.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        View r106 = (View) r105.next();
        FrameLayout r107 = new FrameLayout(getContext());
        r107.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
        r107.addView(r106);
        r104.add(r107);
        goto L4
    L6:
        this.f524667n = (View) CollectionsKt.first(r104);
        Iterator r108 = r104.iterator();
    L8:
        if (r108.hasNext() == false) goto L10;
        addView((FrameLayout) r108.next());
        goto L8
    L10:
        setOnClickListener(oob.a.f524665a);
        setMenuLayoutManager(new a(r100));
    }
}
