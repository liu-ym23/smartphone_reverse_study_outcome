package mwb;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmSummaryLoadingTextView;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.textselection.MmSelectableSummaryTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class l {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f516110p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f516111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f516112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NestedScrollView f516113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MmSelectableSummaryTextView f516114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MmSummaryLoadingTextView f516115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final UDShadowLayout f516116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f516117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConstraintLayout f516118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f516119i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FrameLayout f516120j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FrameLayout f516121k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final UDShadowLayout f516122l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinearLayout f516123m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AppCompatImageView f516124n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AppCompatImageView f516125o;

    public static final class a {
    }

    static {
    }

    public l(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        this.f516111a = r100;
        View r101 = r100.findViewById(R.id.markdownContainer);
        if (r101 == null) goto L63;
        this.f516112b = (FrameLayout) r101;
        View r102 = r100.findViewById(R.id.markdownScrollView);
        if (r102 == null) goto L61;
        this.f516113c = (NestedScrollView) r102;
        View r103 = r100.findViewById(R.id.markdownLayout);
        if (r103 == null) goto L59;
        LinearLayout r104 = (LinearLayout) r103;
        View r105 = r100.findViewById(R.id.markDownText);
        if (r105 == null) goto L57;
        this.f516114d = (MmSelectableSummaryTextView) r105;
        View r106 = r100.findViewById(R.id.markdownLoadingView);
        if (r106 == null) goto L55;
        this.f516115e = (MmSummaryLoadingTextView) r106;
        View r107 = r100.findViewById(R.id.backToBottomLayout);
        if (r107 == null) goto L53;
        this.f516116f = (UDShadowLayout) r107;
        View r108 = r100.findViewById(R.id.backToBottomView);
        if (r108 == null) goto L51;
        this.f516117g = (AppCompatImageView) r108;
        View r109 = r100.findViewById(R.id.markdownEmptyView);
        if (r109 == null) goto L49;
        this.f516118h = (ConstraintLayout) r109;
        this.f516119i = r100.findViewById(R.id.summaryDegradedEmptyView);
        View r110 = r100.findViewById(R.id.emptyLoadingTextView);
        if (r110 == null) goto L47;
        TextView r111 = (TextView) r110;
        View r112 = r100.findViewById(R.id.fishboneContainerLayout);
        if (r112 == null) goto L45;
        this.f516120j = (FrameLayout) r112;
        View r113 = r100.findViewById(R.id.fishboneWebContainer);
        if (r113 == null) goto L43;
        this.f516121k = (FrameLayout) r113;
        View r114 = r100.findViewById(R.id.summarySwitchContainerLayout);
        if (r114 == null) goto L41;
        this.f516122l = (UDShadowLayout) r114;
        View r115 = r100.findViewById(R.id.summarySwitchLayout);
        if (r115 == null) goto L39;
        this.f516123m = (LinearLayout) r115;
        View r116 = r100.findViewById(R.id.switchToFishboneBtn);
        if (r116 == null) goto L37;
        this.f516124n = (AppCompatImageView) r116;
        View r117 = r100.findViewById(R.id.switchToMarkdownBtn);
        if (r117 == null) goto L35;
        this.f516125o = (AppCompatImageView) r117;
        return;
    L35:
        throw new IllegalStateException("Required view not found, id=2131387836, type=AppCompatImageView");
    L37:
        throw new IllegalStateException("Required view not found, id=2131387835, type=AppCompatImageView");
    L39:
        throw new IllegalStateException("Required view not found, id=2131387722, type=".concat(LinearLayout.class.getSimpleName()));
    L41:
        throw new IllegalStateException("Required view not found, id=2131387721, type=UDShadowLayout");
    L43:
        throw new IllegalStateException("Required view not found, id=2131372619, type=".concat(FrameLayout.class.getSimpleName()));
    L45:
        throw new IllegalStateException("Required view not found, id=2131372618, type=".concat(FrameLayout.class.getSimpleName()));
    L47:
        throw new IllegalStateException("Required view not found, id=2131371561, type=".concat(TextView.class.getSimpleName()));
    L49:
        throw new IllegalStateException("Required view not found, id=2131379575, type=ConstraintLayout");
    L51:
        throw new IllegalStateException("Required view not found, id=2131363768, type=AppCompatImageView");
    L53:
        throw new IllegalStateException("Required view not found, id=2131363767, type=UDShadowLayout");
    L55:
        throw new IllegalStateException("Required view not found, id=2131379579, type=MmSummaryLoadingTextView");
    L57:
        throw new IllegalStateException("Required view not found, id=2131379536, type=MmSelectableSummaryTextView");
    L59:
        throw new IllegalStateException("Required view not found, id=2131379578, type=".concat(LinearLayout.class.getSimpleName()));
    L61:
        throw new IllegalStateException("Required view not found, id=2131379581, type=NestedScrollView");
    L63:
        throw new IllegalStateException("Required view not found, id=2131379574, type=".concat(FrameLayout.class.getSimpleName()));
    }
}
