package ehb;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.flow.feed.component.title.FlowTitleView;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends FeedCardComponent<b, FlowTitleView> {
    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        return new FlowTitleView(getContext());
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final ViewGroup.MarginLayoutParams b() {
        ViewGroup.MarginLayoutParams r100 = super.b();
        r100.width = 0;
        return r100;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    public final void d(b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        FlowTitleView r101 = c();
        String r102 = r100.f472751a;
        List<com.ss.android.lark.flow.feed.component.title.a> r103 = r100.f472752b;
        boolean r104 = r100.f472753c;
        int r105 = r100.f472754d;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "titleText");
        Intrinsics.checkNotNullParameter(r103, PromotionProductPrivilegesStruct.TAGS);
        com.ss.android.lark.flow.feed.component.title.b r106 = r101.getTitleViewComponent();
        com.ss.android.lark.flow.feed.component.title.b.C4999b r107 = new com.ss.android.lark.flow.feed.component.title.b.C4999b(r102, r104, r105);
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "data");
        r106.c().setTextSize(0, zz7.b.h(r106.getContext(), r107.f423361c));
        if (r107.f423360b == false) goto L5;
        r106.c().setTypeface(Typeface.DEFAULT, 1);
    L5:
        r106.c().setText(r107.f423359a);
        Iterator<vdb.a> r108 = r101.f423353c.iterator();
    L7:
        if (r108.hasNext() == false) goto L9;
        r101.removeView(r108.next().c());
        goto L7
    L9:
        r101.f423353c.clear();
        Iterator<View> r109 = r101.f423354d.iterator();
    L11:
        if (r109.hasNext() == false) goto L13;
        r101.removeView(r109.next());
        goto L11
    L13:
        r101.f423354d.clear();
        if (r103.isEmpty() == true) goto L30;
        Iterator<T> r110 = r103.iterator();
    L18:
        if (r110.hasNext() == false) goto L43;
        com.ss.android.lark.flow.feed.component.title.a r111 = (com.ss.android.lark.flow.feed.component.title.a) r110.next();
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(-2, -2);
        r112.leftMargin = UIHelper.dp2px(6.0f);
        r112.gravity = 16;
        if ((r111 instanceof com.ss.android.lark.flow.feed.component.title.a.C4998a) == true) goto L21;
        if ((r111 instanceof com.ss.android.lark.flow.feed.component.title.a.b) == false) goto L29;
        com.ss.android.lark.flow.feed.component.title.a.b r113 = (com.ss.android.lark.flow.feed.component.title.a.b) r111;
        r101.f423354d.add(r113.f423358a);
        r101.addView(r113.f423358a, r112);
        goto L18
    L29:
        throw new NoWhenBranchMatchedException();
    L21:
        vdb.a r114 = new vdb.a(r101.getContext());
        r101.f423353c.add(r114);
        r101.addView(r114.c(), r112);
        Drawable r115 = ((com.ss.android.lark.flow.feed.component.title.a.C4998a) r111).f423357a;
        Intrinsics.checkNotNullParameter(new vdb.a.b(r115), "data");
        if (r115 != null) goto L23;
        r114.c().setVisibility(8);
        goto L18
    L23:
        r114.c().setVisibility(0);
        r114.c().setImageDrawable(r115);
        goto L18
    L43:
        return;
    }
}
