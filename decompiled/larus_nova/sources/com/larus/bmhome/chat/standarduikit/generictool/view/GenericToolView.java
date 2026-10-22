package com.larus.bmhome.chat.standarduikit.generictool.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusGenericToolViewBinding;
import com.larus.nova.R;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import jl8.c;
import jl8.f;
import jl8.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import v19.h;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 &2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0001&B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0017\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u001a\u0010\"\u001a\u00020\u00162\b\u0010#\u001a\u0004\u0018\u00010\u00162\u0006\u0010$\u001a\u00020\u0019H\u0002J\u0006\u0010%\u001a\u00020\u0013R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006'"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/generictool/view/GenericToolView;", "Landroid/widget/FrameLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/generictool/view/GenericToolViewInput;", "Lcom/larus/bmhome/chat/standarduikit/generictool/view/GenericToolViewOutput;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BdpAppEventConstant.PARAMS_OUTPUT, "binding", "Lcom/larus/mainbot/impl/databinding/LarusGenericToolViewBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusGenericToolViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "bindData", "", "input", "currentTitle", "", "setupBackground", "res", "", "(Ljava/lang/Integer;)V", "updatePadding", "setupIcon", "setupTitle", "setupShimmerAnimation", "setupExposure", "setupClick", "setupArrow", "getCardId", "messageId", "cardPosition", "onRecycle", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GenericToolView extends FrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f309175b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f309176a;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f309177a = null;

        static {
            int[] r100 = new int[GenericToolViewStage.values().length];
            r100[GenericToolViewStage.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[GenericToolViewStage.FINISHED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f309177a = r100;
        }
    }

    static {
    }

    private final LarusGenericToolViewBinding getBinding() {
        return (LarusGenericToolViewBinding) this.f309176a.getValue();
    }

    public final void b() {
        getBinding().f358656e.x();
    }

    public GenericToolView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    private final void setupArrow(f r100) {
        View r101 = getBinding().f358653b;
        if (r100.f499549i == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        if (r100.f499549i == false) goto L14;
        View r103 = getBinding().f358653b;
        if (r100.f499550j == false) goto L11;
        int r104 = R.drawable.larus_ic_tool_header_arrow_down;
    L12:
        r103.setBackgroundResource(r104);
        return;
    L11:
        r104 = R.drawable.larus_ic_tool_header_arrow_right;
        goto L12
    L14:
        return;
    L5:
        r102 = 8;
        goto L6
    }

    private final void setupBackground(Integer r100) {
        if (r100 == null) goto L5;
        r100.intValue();
        getBinding().f358654c.setBackgroundResource(r100.intValue());
        return;
    }

    private final void setupClick(final g r100) {
        View r101 = getBinding().f358652a;
        if (r100.f499556b == null) goto L5;
        View.OnClickListener r102 = new jl8.a(r100);
    L6:
        r101.setOnClickListener(r102);
        View r103 = getBinding().f358652a;
        boolean r104 = true;
        if (r100.f499556b == null) goto L9;
        boolean r105 = true;
    L10:
        r103.setClickable(r105);
        View r106 = getBinding().f358652a;
        if (r100.f499556b != null) goto L14;
        r104 = false;
    L14:
        r106.setFocusable(r104);
        return;
    L9:
        r105 = false;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    private final void setupIcon(f r100) {
        boolean r101 = h.f552477a;
        RoundingParams r102 = null;
        if (h.a(null) == false) goto L5;
        String r103 = r100.f499542b;
    L6:
        LinearLayout r104 = getBinding().f358654c;
        r104.setPaddingRelative(r100.f499553m, r104.getPaddingTop(), r104.getPaddingEnd(), r104.getPaddingBottom());
        SimpleDraweeView r105 = getBinding().f358655d;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L16;
        LinearLayout.LayoutParams r107 = (LinearLayout.LayoutParams) r106;
        int r108 = r100.f499552l;
        r107.width = r108;
        r107.height = r108;
        r107.setMarginEnd(r100.f499554n);
        r105.setLayoutParams(r107);
        GenericDraweeHierarchy r109 = getBinding().f358655d.getHierarchy();
        if (r100.f499551k == false) goto L11;
        r102 = RoundingParams.asCircle();
    L11:
        r109.setRoundingParams(r102);
        if (o0.d(r103) == false) goto L17;
        ImageLoaderKt.u(getBinding().f358655d, r103, "GenericToolView");
        return;
    L17:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L5:
        r103 = r100.f499541a;
        goto L6
    }

    private final void setupShimmerAnimation(f r100) {
        GenericToolViewStage r101 = r100.f499544d;
        int r102 = b.f309177a[r101.ordinal()];
        if (r102 != 1) goto L5;
        ShimmerTextView r103 = getBinding().f358656e;
        int r104 = ShimmerTextView.f304901h;
        r103.z(false);
        return;
    L5:
        if (r102 != 2) goto L8;
        getBinding().f358656e.x();
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    private final void setupTitle(f r100) {
        ShimmerTextView r101 = getBinding().f358656e;
        r101.setText(r100.f499543c);
        Intrinsics.checkNotNull(r101);
        we8.a.b(r101, i5.t(), false, null, null, 12);
        r101.setTypeface(Typeface.DEFAULT, 0);
    }

    public GenericToolView(final Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f309176a = LazyKt.lazy(new jl8.b(r100, this));
    }

    public final void a(final f r100, final g r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_OUTPUT);
        setupIcon(r100);
        setupTitle(r100);
        setupShimmerAnimation(r100);
        Pair<Integer, Integer> r102 = r100.f499545e;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.getFirst().intValue();
    L6:
        Pair<Integer, Integer> r105 = r100.f499545e;
        if (r105 == null) goto L9;
        r103 = r105.getSecond().intValue();
    L9:
        setPaddingRelative(getPaddingStart(), r104, getPaddingEnd(), r103);
        ExposeXTrackerExtKt.b(this, new c(this, r100, r101));
        setupBackground(r100.f499548h);
        setupClick(r101);
        setupArrow(r100);
        return;
    L5:
        r104 = 0;
        goto L6
    }
}
