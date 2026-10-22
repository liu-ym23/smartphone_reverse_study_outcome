package com.larus.bmhome.chat.markdown.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.bmhome.chat.markdown.reference.ToolType;
import com.larus.bmhome.chat.markdown.reference.r;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.mainbot.impl.databinding.LarusDeepThinkCommonToolHeaderBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import po8.z;
import sh8.b;
import v19.c;
import v19.h;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 42\u00020\u0001:\u00014B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J*\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010\u00132\b\u0010 \u001a\u0004\u0018\u00010\u0013JE\u0010!\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010\u00192\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010'¢\u0006\u0002\u0010(J\u001e\u0010)\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0019J\b\u0010*\u001a\u0004\u0018\u00010\u0013J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0019H\u0002J\u0010\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u0013H\u0002J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0019H\u0002J\b\u0010/\u001a\u000200H\u0002J\u0016\u00101\u001a\u00020\u00192\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0006\u00102\u001a\u00020\u0010J\u0010\u00103\u001a\u0004\u0018\u00010\u0013*\u0004\u0018\u00010\u0013H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/larus/bmhome/chat/markdown/view/DeepThinkCommonToolHeader;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "swipeTextViewList", "", "Lcom/larus/bmhome/chat/layout/widget/ShimmerTextView;", "binding", "Lcom/larus/mainbot/impl/databinding/LarusDeepThinkCommonToolHeaderBinding;", "switcherAdapter", "Lcom/larus/bmhome/chat/view/SearchSwitcherAdapter;", "refreshSearchViewSearchIng", "", "switcherList", "", "", "refreshSearchViewSearchEnd", "startSwipeLight", "stopSwipeLight", "updateSwitcherVisible", "visible", "", "setUpTextSwitcher", "refreshIcon", "toolType", "Lcom/larus/bmhome/chat/markdown/reference/ToolType;", "hideArrow", "lightIcon", "darkIcon", "updateSearchTitleWhenSearched", "isUserFold", "searchedTitle", "isFold", "forceHideArrow", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "(Lcom/larus/bmhome/chat/markdown/reference/ToolType;ZLjava/lang/String;ZLjava/lang/Boolean;Lkotlin/jvm/functions/Function0;)V", "refreshArrow", "currentTitle", "setArrow", "setSearchTitle", "title", "setArrowRotation", "resolveTextColor", "", "tryInitSwitchAdapter", "onRecycle", "takeNonEmpty", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeepThinkCommonToolHeader extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f307300d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ShimmerTextView> f307301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarusDeepThinkCommonToolHeaderBinding f307302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z f307303c;

    public static final class a {
    }

    static {
    }

    public DeepThinkCommonToolHeader(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    private final void setArrow(boolean r100) {
        setArrowRotation(r100);
    }

    private final void setArrowRotation(boolean r100) {
        View r101 = this.f307302b.f358574b;
        if (r100 == false) goto L5;
        int r102 = R.drawable.larus_ic_tool_header_arrow_right;
    L6:
        r101.setBackgroundResource(r102);
        return;
    L5:
        r102 = R.drawable.larus_ic_tool_header_arrow_down;
        goto L6
    }

    private final void setSearchTitle(String r100) {
        TextView r101 = this.f307302b.f358577e;
        r101.setTextColor(c.a(R.attr.larus_neutral_70, getContext(), R.color.larus_neutral_70));
        Intrinsics.checkNotNull(r101);
        we8.a.b(r101, i5.t(), false, null, null, 12);
        r101.setSingleLine(true);
        r101.setEllipsize(TextUtils.TruncateAt.END);
        r101.setGravity(16);
        r101.setIncludeFontPadding(false);
        r101.setText(r100);
        r101.setTypeface(Typeface.DEFAULT, 0);
    }

    private final void setUpTextSwitcher(final Context r100) {
        this.f307302b.f358576d.setFactory(new sh8.a(r100, this));
    }

    public final void c(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "switcherList");
        this.f307302b.f358578f.setOnClickListener(null);
        this.f307302b.f358578f.setClickable(false);
        if (this.f307303c != null) goto L8;
        setUpTextSwitcher(getContext());
        z r101 = new z(this.f307302b.f358576d, r100);
        this.f307303c = r101;
        r101.a(getContext());
        z r102 = this.f307303c;
        if (r102 == null) goto L7;
        r102.c();
    L7:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L17;
        Iterator r104 = ((ArrayList) this.f307301a).iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        ShimmerTextView r105 = (ShimmerTextView) r104.next();
        int r106 = ShimmerTextView.f304901h;
        r105.z(false);
        goto L12
    L14:
        this.f307302b.f358576d.setVisibility(0);
        return;
    L17:
        return;
    L8:
        r103 = false;
        goto L9
    }

    public DeepThinkCommonToolHeader(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f307301a = new ArrayList();
        LayoutInflater.from(r100).inflate(R.layout.larus_deep_think_common_tool_header, this);
        int r102 = R.id.arrow;
        View r103 = ViewBindings.findChildViewById(this, R.id.arrow);
        if (r103 == null) goto L15;
        r102 = R.id.searchIcon;
        SimpleDraweeView r104 = (SimpleDraweeView) ViewBindings.findChildViewById(this, R.id.searchIcon);
        if (r104 == null) goto L15;
        r102 = R.id.search_reference_switcher;
        TextSwitcher r105 = (TextSwitcher) ViewBindings.findChildViewById(this, R.id.search_reference_switcher);
        if (r105 == null) goto L15;
        r102 = R.id.search_reference_title;
        TextView r106 = (TextView) ViewBindings.findChildViewById(this, R.id.search_reference_title);
        if (r106 == null) goto L15;
        r102 = R.id.searchReferenceTitleContainer;
        LinearLayout r107 = (LinearLayout) ViewBindings.findChildViewById(this, R.id.searchReferenceTitleContainer);
        if (r107 == null) goto L15;
        this.f307302b = new LarusDeepThinkCommonToolHeaderBinding(this, r103, r104, r105, r106, r107);
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }

    public final void a(ToolType r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "toolType");
        View r102 = this.f307302b.f358574b;
        if (r.d(r100) == false) goto L5;
        int r103 = 0;
    L6:
        r102.setVisibility(r103);
        setArrow(r101);
        return;
    L5:
        r103 = 8;
        goto L6
    }

    public final void b(ToolType r100, boolean r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "toolType");
        if (r.d(r100) == true) goto L5;
        e1.o(this.f307302b.f358574b);
    L8:
        boolean r104 = h.f552477a;
        if (h.a(null) == false) goto L12;
        r102 = r103;
    L12:
        if (o0.d(r102) == false) goto L14;
        this.f307302b.f358575c.setBackgroundResource(0);
        ImageLoaderKt.u(this.f307302b.f358575c, r102, "DeepThinkCommonToolHeader");
        return;
    L14:
        SimpleDraweeView r105 = this.f307302b.f358575c;
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(i5.E(), i5.E());
        r106.gravity = 16;
        r106.setMargins(0, 0, i5.Y(), 0);
        r105.setLayoutParams(r106);
        SimpleDraweeView r107 = this.f307302b.f358575c;
        if (r107 == null) goto L19;
        r107.setBackgroundResource(c.b(R.attr.larus_ic_search_grap_sug_bar, r107.getContext(), R.drawable.larus_ic_search_grap_sug_bar));
        return;
    L19:
        return;
    L5:
        if (r101 == false) goto L7;
        e1.o(this.f307302b.f358574b);
        goto L8
    L7:
        e1.x(this.f307302b.f358574b);
        goto L8
    }

    public final void d(final ToolType r100, String r101, final boolean r102, Boolean r103, final Function0 r104) {
        Intrinsics.checkNotNullParameter(r100, "toolType");
        Intrinsics.checkNotNullParameter(r101, "searchedTitle");
        z r105 = this.f307303c;
        if (r105 == null) goto L5;
        r105.b();
    L5:
        Iterator r106 = ((ArrayList) this.f307301a).iterator();
    L7:
        if (r106.hasNext() == false) goto L9;
        ((ShimmerTextView) r106.next()).x();
        goto L7
    L9:
        int r107 = 8;
        this.f307302b.f358576d.setVisibility(8);
        View r108 = this.f307302b.f358574b;
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L12;
        boolean r109 = false;
    L13:
        if (r109 == false) goto L15;
        r107 = 0;
    L15:
        r108.setVisibility(r107);
        setSearchTitle(r101);
        setArrow(r102);
        this.f307302b.f358578f.setOnClickListener(null);
        this.f307302b.f358578f.setClickable(false);
        if (r104 == null) goto L20;
        e1.d(this.f307302b.f358578f, new b(r102, r100, r104));
        return;
    L20:
        return;
    L12:
        r109 = r.d(r100);
        goto L13
    }
}
