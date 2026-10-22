package ij8;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.bmhome.chat.standarduikit.clarification.view.InteractionAskAttachmentView;
import com.larus.bmhome.chat.standarduikit.clarification.view.InteractionAskOptionView;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.im.bean.message.block.InteractionAskOption;
import com.larus.mainbot.impl.databinding.LarusInteractionAskBlockViewBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
public final class i extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f490122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f490123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f490124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f490125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f490126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f490127f;

    public static final class a {
    }

    static {
    }

    private final InteractionAskAttachmentView getAttachmentView() {
        return (InteractionAskAttachmentView) this.f490127f.getValue();
    }

    private final LarusInteractionAskBlockViewBinding getBinding() {
        return (LarusInteractionAskBlockViewBinding) this.f490122a.getValue();
    }

    private final LinearLayout getCardContainer() {
        return (LinearLayout) this.f490123b.getValue();
    }

    private final AppCompatImageView getCloseView() {
        return (AppCompatImageView) this.f490125d.getValue();
    }

    private final LinearLayout getOptionContainer() {
        return (LinearLayout) this.f490126e.getValue();
    }

    private final TextView getTitleView() {
        return (TextView) this.f490124c.getValue();
    }

    public i(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f490122a = LazyKt.lazy(new ij8.a(r100, this));
        this.f490123b = LazyKt.lazy(new b(this));
        this.f490124c = LazyKt.lazy(new c(this));
        this.f490125d = LazyKt.lazy(new d(this));
        this.f490126e = LazyKt.lazy(new e(this));
        this.f490127f = LazyKt.lazy(new f(this));
        setOrientation(1);
        setGravity(80);
        setClipToOutline(false);
        setBackground(null);
        getCardContainer().setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        LinearLayout r101 = getCardContainer();
        GradientDrawable r102 = new GradientDrawable();
        r102.setShape(0);
        float r103 = c7.c(16);
        r102.setCornerRadii(new float[]{r103, r103, r103, r103, 0.0f, 0.0f, 0.0f, 0.0f});
        r102.setColor(v19.c.a(R.attr.larus_base_3, getContext(), R.color.larus_base_3));
        r101.setBackground(r102);
    }

    public static InteractionAskAttachmentView a(i r100) {
        return r100.getBinding().f358658b;
    }

    public static TextView b(i r100) {
        return r100.getBinding().f358662f;
    }

    public static LinearLayout c(i r100) {
        return r100.getBinding().f358659c;
    }

    public static LinearLayout d(i r100) {
        return r100.getBinding().f358661e;
    }

    public static AppCompatImageView e(i r100) {
        return r100.getBinding().f358660d;
    }

    public final void f(p r110, final jj8.h.a r111) {
        Intrinsics.checkNotNullParameter(r110, "input");
        Intrinsics.checkNotNullParameter(r111, BdpAppEventConstant.PARAMS_OUTPUT);
        TextView r100 = getTitleView();
        if (r110.f490137b != 2) goto L5;
        String r101 = r110.f490136a;
        SpannableStringBuilder r102 = new SpannableStringBuilder();
        ForegroundColorSpan r103 = new ForegroundColorSpan(v19.c.a(R.attr.larus_neutral_50, getContext(), R.color.larus_neutral_50));
        int r104 = r102.length();
        r102.append(getContext().getString(R.string.larus_cot_askQ_title_selectMulti));
        r102.setSpan(r103, r104, r102.length(), 17);
        StyleSpan r105 = new StyleSpan(1);
        int r106 = r102.length();
        r102.append(r101);
        r102.setSpan(r105, r106, r102.length(), 17);
        SpannedString r107 = new SpannedString(r102);
    L6:
        r100.setText(r107);
        AppCompatImageView r108 = getCloseView();
        if (r110.f490145j == false) goto L9;
        int r109 = 0;
    L10:
        r108.setVisibility(r109);
        getCloseView().setOnClickListener(new g(r111));
        getOptionContainer().removeAllViews();
        Iterator<T> r112 = r110.f490138c.iterator();
        int r113 = 0;
    L12:
        if (r112.hasNext() == false) goto L42;
        Object r114 = r112.next();
        int r115 = r113 + 1;
        if (r113 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        InteractionAskOption r116 = (InteractionAskOption) r114;
        int r117 = r110.f490137b;
        if (r117 == 1) goto L21;
        if (r117 == 2) goto L21;
        boolean r118 = false;
    L22:
        InteractionAskOptionView r119 = new InteractionAskOptionView(getContext(), null, 6, 0);
        r119.e(r113, r116);
        if (r118 == true) goto L25;
    L27:
        boolean r120 = false;
    L28:
        r119.f308965d = r118;
        if (r118 == false) goto L32;
        if (r120 == false) goto L32;
        boolean r121 = true;
    L33:
        r119.f308964c = r121;
        r119.setSelected(r121);
        r119.f();
        r119.setOnOptionClickListener(new h(r111));
        if (r113 != CollectionsKt.getLastIndex(r110.f490138c)) goto L36;
        boolean r122 = true;
    L37:
        LinearLayout r123 = new LinearLayout(getContext());
        r123.setOrientation(1);
        r123.addView(r119, new LinearLayout.LayoutParams(-1, -2));
        if (r122 == true) goto L40;
        View r124 = new View(r123.getContext());
        r124.setBackgroundColor(v19.c.a(R.attr.larus_neutral_transparent_2, getContext(), R.color.larus_neutral_transparent_2));
        r123.addView(r124, new LinearLayout.LayoutParams(-1, r123.getContext().getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_0_5, null, R.dimen.larus_dp_0_5))));
    L40:
        getOptionContainer().addView(r123, new LinearLayout.LayoutParams(-1, -2));
        r113 = r115;
        goto L12
    L36:
        r122 = false;
    L32:
        r121 = false;
        goto L33
    L25:
        if (CollectionsKt.contains(r110.f490139d, r116.getOptionId()) == false) goto L27;
        r120 = true;
    L21:
        r118 = true;
        goto L22
    L42:
        if (r110.f490142g == false) goto L44;
    L47:
        e1.o(getOptionContainer());
    L48:
        InteractionAskAttachmentView r125 = getAttachmentView();
        List<ResourceItemBean> r126 = r110.f490144i;
        BaseResourceViewHolder.a r127 = r111.b();
        int r128 = InteractionAskAttachmentView.f308959b;
        r125.a(r126, r127, new ResourceBarConfig(Mode.EDIT, true, 0, 0, null, null, 60, null));
        return;
    L44:
        if (r110.f490138c.isEmpty() == true) goto L47;
        e1.x(getOptionContainer());
        goto L48
    L9:
        r109 = 8;
        goto L10
    L5:
        String r129 = r110.f490136a;
        SpannableStringBuilder r130 = new SpannableStringBuilder();
        StyleSpan r131 = new StyleSpan(1);
        int r132 = r130.length();
        r130.append(r129);
        r130.setSpan(r131, r132, r130.length(), 17);
        r107 = new SpannedString(r130);
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = Math.min(MathKt.roundToInt(com.larus.utils.i.c(getContext()) * 0.7f), getContext().getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_460, null, R.dimen.larus_dp_460)));
        int r103 = View.MeasureSpec.getMode(r101);
        int r104 = View.MeasureSpec.getSize(r101);
        if (r103 == 0) goto L6;
        r102 = Math.min(r102, r104);
    L6:
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(r102, Integer.MIN_VALUE));
    }
}
