package ghb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.larus.nova.R;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.feed.shared.page.binder2.ConstraintLayoutInfoKt;
import com.ss.android.lark.feed.shared.page.binder2.n;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.VideoRef;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import zz7.b;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f481319a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f481320b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f481321c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f481322d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f481323e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f481324f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f481325g = 0;

    /* JADX INFO: renamed from: ghb.a$a, reason: collision with other inner class name */
    public static final class C6023a {
    }

    public a() {
    }

    @Override // com.ss.android.lark.feed.shared.page.binder2.n
    public final void a() {
    }

    @Override // com.ss.android.lark.feed.shared.page.binder2.n
    public final void c() {
    }

    static {
        f481319a = UIHelper.dp2px(12.0f);
        f481320b = UIHelper.dp2px(3.0f);
        f481321c = UIHelper.dp2px(16.0f);
        f481322d = UIHelper.dp2px(5.5f);
        f481323e = UIHelper.dp2px(8.0f);
        f481324f = UIHelper.dp2px(16.0f);
        f481325g = UIHelper.dp2px(1.0f);
    }

    @Override // com.ss.android.lark.feed.shared.page.binder2.n
    public final void b(Context r210, ConstraintLayout r211, com.ss.android.lark.feed.export.feedcard.a r310) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "contentView");
        Intrinsics.checkNotNullParameter(r310, "componentInfo");
        b.g(r210, 60);
        ViewGroup.LayoutParams r100 = r211.getLayoutParams();
        if (r100 != null) goto L5;
        r100 = new ViewGroup.LayoutParams(-1, UIHelper.dp2px(80.0f));
    L5:
        r100.height = UIHelper.dp2px(80.0f);
        r211.setLayoutParams(r100);
        r211.setPadding(0, UIHelper.dp2px(8.0f), 0, 0);
        int r101 = UIHelper.dp2px(48.0f) / 2;
        int r102 = f481323e;
        int r103 = r101 + r102;
        View r104 = new Guideline(r210);
        if (r104.getId() != (-1)) goto L8;
        r104.setId(R.id.feed_card_guideline_horizontal);
    L8:
        ConstraintLayout.LayoutParams r105 = new ConstraintLayout.LayoutParams(-2, -2);
        r105.orientation = 0;
        r105.guideBegin = r103;
        r211.addView(r104, r105);
        FeedCardComponent<?, ?> r106 = r310.f420999b;
        if (r106 == null) goto L60;
        View r107 = r106.c();
        if (r107.getId() != (-1)) goto L13;
        r107.setId(View.generateViewId());
    L13:
        ViewGroup.MarginLayoutParams r108 = r106.b();
        ConstraintLayout.LayoutParams r109 = new ConstraintLayout.LayoutParams(r108.width, r108.height);
        ((ViewGroup.MarginLayoutParams) r109).leftMargin = r108.leftMargin;
        ((ViewGroup.MarginLayoutParams) r109).topMargin = r108.topMargin;
        ((ViewGroup.MarginLayoutParams) r109).rightMargin = r108.rightMargin;
        ((ViewGroup.MarginLayoutParams) r109).bottomMargin = r108.bottomMargin;
        r109.topToTop = r104.getId();
        r109.bottomToBottom = r104.getId();
        r109.startToStart = 0;
        Unit r110 = Unit.INSTANCE;
        r211.addView(r107, r109);
        FeedCardComponent<?, ?> r111 = r310.f421000c;
        if (r111 == null) goto L16;
        ViewGroup.MarginLayoutParams r112 = r111.b();
        View r113 = r111.c();
        ConstraintLayout.LayoutParams r114 = new ConstraintLayout.LayoutParams(r112.width, r112.height);
        r114.startToEnd = r107.getId();
        r114.endToStart = R.id.title_right_vertical_guide_line;
        r114.topToTop = 0;
        ((ViewGroup.MarginLayoutParams) r114).leftMargin = f481321c;
        ((ViewGroup.MarginLayoutParams) r114).topMargin = r102 / 2;
        r211.addView(r113, r114);
    L16:
        View r115 = ConstraintLayoutInfoKt.a(r211, r310.f421002e, new com.ss.android.lark.feed.shared.page.binder2.a(0, 0, R.id.title_right_vertical_guide_line, r104.getId(), 0, 0, 0, f481322d, 115));
        if (r115 != null) goto L19;
        r115 = null;
    L22:
        FeedCardComponent<?, ?>[] r116 = r310.f421001d;
        int r117 = r107.getId();
        if (r115 == null) goto L25;
        int r118 = r115.getId();
    L26:
        int r119 = r104.getId();
        int r120 = f481319a;
        int r121 = f481320b;
        int r122 = f481324f;
        View r123 = ConstraintLayoutInfoKt.a(r211, r116, new com.ss.android.lark.feed.shared.page.binder2.a(r117, 0, r118, r119, r122, 0, r120, r121, 34));
        if (r123 != null) goto L29;
    L31:
        FeedCardComponent<?, ?>[] r124 = r310.f421003f;
        int r125 = r107.getId();
        int r126 = r104.getId();
        int r127 = f481325g;
        View r128 = ConstraintLayoutInfoKt.a(r211, r124, new com.ss.android.lark.feed.shared.page.binder2.a(r125, r126, R.id.title_right_vertical_guide_line, 0, r122, r127, 0, 0, 200));
        if (r128 != null) goto L34;
        r128 = null;
    L37:
        FeedCardComponent<?, ?>[] r129 = r310.f421004g;
        if (r128 == null) goto L40;
        int r130 = r128.getId();
    L41:
        int r131 = r107.getId();
        View r132 = ConstraintLayoutInfoKt.a(r211, r129, new com.ss.android.lark.feed.shared.page.binder2.a(r131, r130, R.id.title_right_vertical_guide_line, 0, r122, r127, 0, 0, 200));
        if (r132 != null) goto L44;
        r132 = null;
    L47:
        FeedCardComponent<?, ?>[] r133 = r310.f421005h;
        if (r132 == null) goto L51;
        int r134 = r132.getId();
    L50:
        int r135 = r134;
        View r136 = ConstraintLayoutInfoKt.a(r211, r133, new com.ss.android.lark.feed.shared.page.binder2.a(r107.getId(), r135, R.id.title_right_vertical_guide_line, 0, f481321c, 0, 0, 0, VideoRef.VALUE_VIDEO_REF_CATEGORY));
        if (r136 != null) goto L57;
        return;
    L57:
        if (r136.getId() != (-1)) goto L62;
        r136.setId(View.generateViewId());
        return;
    L62:
        return;
    L51:
        if (r128 == null) goto L53;
        r134 = r128.getId();
        goto L50
    L53:
        r134 = r104.getId();
        goto L50
    L44:
        if (r132.getId() != (-1)) goto L47;
        r132.setId(View.generateViewId());
        goto L47
    L40:
        r130 = r104.getId();
        goto L41
    L34:
        if (r128.getId() != (-1)) goto L37;
        r128.setId(View.generateViewId());
        goto L37
    L29:
        if (r123.getId() != (-1)) goto L31;
        r123.setId(View.generateViewId());
        goto L31
    L25:
        r118 = -1;
        goto L26
    L19:
        if (r115.getId() != (-1)) goto L22;
        r115.setId(View.generateViewId());
        goto L22
    }
}
