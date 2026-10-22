package com.larus.bmhome.chat.standarduikit.complextask.blockadapter.view;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import ck8.b;
import ck8.c;
import ck8.d;
import ck8.g;
import ck8.h;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusComplexTaskColorCapsuleViewBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0001\u001dB\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J\u0006\u0010\u001c\u001a\u00020\u0017R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/complextask/blockadapter/view/ComplexTaskColorCapsuleView;", "Landroid/widget/FrameLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/complextask/blockadapter/view/ComplexTaskColorCapsuleViewInput;", "Lcom/larus/bmhome/chat/standarduikit/complextask/blockadapter/view/ComplexTaskColorCapsuleViewOutput;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusComplexTaskColorCapsuleViewBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusComplexTaskColorCapsuleViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "defaultNameColors", "Landroid/content/res/ColorStateList;", "getDefaultNameColors", "()Landroid/content/res/ColorStateList;", "defaultNameColors$delegate", "bindData", "", "input", BdpAppEventConstant.PARAMS_OUTPUT, "bindPill", "bindSummary", "onRecycle", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComplexTaskColorCapsuleView extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f309031c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f309032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f309033b;

    public static final class a {
    }

    static {
    }

    private final LarusComplexTaskColorCapsuleViewBinding getBinding() {
        return (LarusComplexTaskColorCapsuleViewBinding) this.f309032a.getValue();
    }

    private final ColorStateList getDefaultNameColors() {
        return (ColorStateList) this.f309033b.getValue();
    }

    public final void c() {
        getBinding().f358551g.x();
    }

    public ComplexTaskColorCapsuleView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static ColorStateList a(ComplexTaskColorCapsuleView r100) {
        return r100.getBinding().f358550f.getTextColors();
    }

    public ComplexTaskColorCapsuleView(final Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f309032a = LazyKt.lazy(new ck8.a(r100, this));
        this.f309033b = LazyKt.lazy(new b(this));
    }

    public final void b(final g r110, final h r111) {
        Intrinsics.checkNotNullParameter(r110, "input");
        Intrinsics.checkNotNullParameter(r111, BdpAppEventConstant.PARAMS_OUTPUT);
        ImageLoaderKt.u(getBinding().f358549e, r110.f24052a, "ComplexTaskColorCapsuleView");
        getBinding().f358550f.setText(r110.f24053b);
        we8.a.b(getBinding().f358550f, i5.t(), false, null, null, 12);
        TextView r100 = getBinding().f358550f;
        Integer r101 = r110.f24054c;
        if (r101 == null) goto L6;
        ColorStateList r102 = ColorStateList.valueOf(r101.intValue());
        if (r102 == null) goto L6;
    L7:
        r100.setTextColor(r102);
        LinearLayout r103 = getBinding().f358548d;
        Integer r104 = r110.f24055d;
        boolean r105 = false;
        if (r104 == null) goto L10;
        int r106 = r104.intValue();
    L11:
        r103.setBackgroundTintList(ColorStateList.valueOf(r106));
        ShimmerTextView r107 = getBinding().f358551g;
        r107.setText(r110.f24056e);
        Intrinsics.checkNotNull(r107);
        we8.a.b(r107, i5.t(), false, null, null, 12);
        r107.setTypeface(Typeface.DEFAULT, 0);
        if (r110.f24057f == false) goto L14;
        r107.z(false);
    L15:
        View r108 = getBinding().f358546b;
        if (r110.f24058g == false) goto L18;
        int r109 = 0;
    L19:
        r108.setVisibility(r109);
        LinearLayout r112 = getBinding().f358547c;
        Integer r113 = r110.f24062k;
        if (r113 == null) goto L22;
        int r114 = r113.intValue();
    L23:
        r112.setBackgroundResource(r114);
        Pair<Integer, Integer> r115 = r110.f24059h;
        if (r115 == null) goto L26;
        int r116 = r115.getFirst().intValue();
    L27:
        Pair<Integer, Integer> r117 = r110.f24059h;
        if (r117 == null) goto L30;
        int r118 = r117.getSecond().intValue();
    L31:
        setPaddingRelative(getPaddingStart(), r116, getPaddingEnd(), r118);
        View r119 = getBinding().f358545a;
        final Function0<Unit> r120 = r111.f24064b;
        if (r120 == null) goto L34;
        View.OnClickListener r121 = new c(r120);
    L35:
        r119.setOnClickListener(r121);
        View r122 = getBinding().f358545a;
        if (r111.f24064b == null) goto L38;
        boolean r123 = true;
    L39:
        r122.setClickable(r123);
        View r124 = getBinding().f358545a;
        if (r111.f24064b == null) goto L42;
        r105 = true;
    L42:
        r124.setFocusable(r105);
        ExposeXTrackerExtKt.b(this, new d(r110, r111));
        return;
    L38:
        r123 = false;
        goto L39
    L34:
        r121 = null;
        goto L35
    L30:
        r118 = 0;
        goto L31
    L26:
        r116 = 0;
        goto L27
    L22:
        r114 = R.color.transparent;
        goto L23
    L18:
        r109 = 8;
        goto L19
    L14:
        r107.x();
        goto L15
    L10:
        r106 = 0;
    L6:
        r102 = getDefaultNameColors();
        goto L7
    }
}
