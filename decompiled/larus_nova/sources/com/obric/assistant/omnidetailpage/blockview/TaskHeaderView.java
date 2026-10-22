package com.obric.assistant.omnidetailpage.blockview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.nova.R;
import com.obric.assistant.card.databinding.ObricOmniBlockTaskHeaderBinding;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 J2\u00020\u0001:\u0002IJB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJF\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001a0\u001e2 \b\u0002\u0010\u001f\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001a0 Jd\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u00152\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001a0\u001e2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001a0\u001e2 \b\u0002\u0010\u001f\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001a0 J6\u0010$\u001a\u00020\u001a2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130\r2\u001e\u0010\u001f\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001a0 H\u0002J\b\u0010&\u001a\u00020\u001aH\u0002J\b\u0010'\u001a\u00020\u001aH\u0002J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0002J\u0018\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0010\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u0015H\u0002J\u0010\u00100\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u0015H\u0002J\u0016\u00101\u001a\u00020\u001a2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0010\u00102\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u0015H\u0002J \u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0007H\u0002J\u0016\u00107\u001a\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\b\u0010:\u001a\u00020\u001aH\u0002J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u000eH\u0002J\u0010\u0010>\u001a\u0002082\u0006\u0010=\u001a\u00020\u000eH\u0002J\u0018\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020A2\u0006\u0010=\u001a\u00020\u000eH\u0002J\b\u0010B\u001a\u00020\u0007H\u0002J\b\u0010C\u001a\u00020\u0007H\u0002J\u0010\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0007H\u0002J\u0010\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020<H\u0002J\u0010\u0010H\u001a\u00020\u00072\u0006\u0010G\u001a\u00020<H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/obric/assistant/omnidetailpage/blockview/TaskHeaderView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/obric/assistant/card/databinding/ObricOmniBlockTaskHeaderBinding;", "additionTips", "", "", "resourceBar", "Lcom/larus/bmhome/view/resourcebar/bean/IResourceItemOperator;", "attachmentsByDisplayKey", "", "Lcom/obric/assistant/omnidetailpage/model/HeaderAttachment;", "isExpanded", "", "needToggle", "collapseConfig", "Lcom/obric/assistant/omnidetailpage/blockview/TaskHeaderView$CollapseConfig;", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$Header;", "onItemClick", "Lkotlin/Function1;", "onAttachmentClick", "Lkotlin/Function3;", "Landroid/view/View;", "expanded", "onExpandChanged", "bindAttachments", "attachments", "bindPlaceholder", "resetPlaceholderState", "bindNormalBlock", "textBlock", "Lcom/larus/im/bean/message/block/TextBlock;", "bindQuickBlock", "updateToggleView", "show", "prepareForMeasure", "isQuick", "applyExpandState", "bindAdditionTips", "updateCollapseState", "buildCollapseConfig", "primaryFullLines", "additionPreviewFullLines", "totalBudget", "buildAdditionPreviewText", "", "tips", "renderExpandedAdditionTips", "createAdditionTipTextView", "Landroid/widget/TextView;", AppConstants.BUNDLE_TIP, "buildSingleAdditionText", "appendAdditionSpan", "builder", "Landroid/text/SpannableStringBuilder;", "resolveAdditionPrefixColor", "resolveAdditionContentColor", "dp", "value", "measureFullLineCount", "textView", "resolveTextWidth", "CollapseConfig", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskHeaderView extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f390575h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObricOmniBlockTaskHeaderBinding f390576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f390577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final mt8.a f390578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, ifa.a> f390579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f390580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f390581f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f390582g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f390583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f390584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f390585c;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f390583a == r101.f390583a) goto L12;
            return false;
        L12:
            if (this.f390584b == r101.f390584b) goto L15;
            return false;
        L15:
            if (this.f390585c == r101.f390585c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.f390583a == false) goto L5;
            int r100 = 1231;
        L7:
            return (((r100 * 31) + this.f390584b) * 31) + this.f390585c;
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "CollapseConfig(needToggle=" + this.f390583a + ", primaryCollapsedLines=" + this.f390584b + ", additionPreviewCollapsedLines=" + this.f390585c + ')';
        }

        public /* synthetic */ a(int r100) {
            int r101 = TaskHeaderView.f390575h;
            this(false, 4, 0);
        }

        public a(boolean r100, int r101, int r102) {
            this.f390583a = r100;
            this.f390584b = r101;
            this.f390585c = r102;
        }
    }

    public static final class b {
    }

    static {
    }

    public TaskHeaderView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TaskHeaderView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void b(boolean r100) {
        ObricOmniBlockTaskHeaderBinding r101 = this.f390576a;
        if (r101 == null) goto L39;
        if (r100 == false) goto L6;
        TextView r102 = r101.f386289g;
    L7:
        Intrinsics.checkNotNull(r102);
        TextView r103 = r101.f386288f;
        LinearLayout r104 = r101.f386286d;
        if (this.f390580e == false) goto L10;
        int r105 = Integer.MAX_VALUE;
    L11:
        r102.setMaxLines(r105);
        if (this.f390580e == false) goto L14;
        TextUtils.TruncateAt r106 = null;
    L15:
        r102.setEllipsize(r106);
        if (this.f390577b.isEmpty() == false) goto L19;
        r103.setVisibility(8);
        r104.setVisibility(8);
    L36:
        e(this.f390581f, this.f390580e);
        return;
    L19:
        if (this.f390580e == false) goto L32;
        r103.setVisibility(8);
        r104.setVisibility(0);
        ObricOmniBlockTaskHeaderBinding r107 = this.f390576a;
        if (r107 == null) goto L36;
        LinearLayout r108 = r107.f386286d;
        if (r108 == null) goto L36;
        if (r108.getChildCount() == this.f390577b.size()) goto L36;
        r108.removeAllViews();
        Iterator<T> r109 = this.f390577b.iterator();
    L30:
        if (r109.hasNext() == false) goto L36;
        String r110 = (String) r109.next();
        AppCompatTextView r111 = new AppCompatTextView(getContext());
        SpannableStringBuilder r112 = new SpannableStringBuilder();
        a(r112, r110);
        r111.setText(r112);
        r111.setTextSize(0, r111.getResources().getDimension(R.dimen.dp_14));
        r111.setTypeface(Typeface.create("sans-serif-medium", 0));
        r111.setLineSpacing(r111.getResources().getDimension(R.dimen.dp_4), 1.0f);
        r111.setTextColor(ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_neutral_100, getContext(), R.color.larus_neutral_100)));
        LinearLayout.LayoutParams r113 = new LinearLayout.LayoutParams(-1, -2);
        r113.topMargin = c(6);
        r111.setLayoutParams(r113);
        r108.addView(r111);
        goto L30
    L32:
        r104.setVisibility(8);
        if (this.f390582g.f390585c <= 0) goto L35;
        r103.setVisibility(0);
        r103.setMaxLines(this.f390582g.f390585c);
        r103.setEllipsize(TextUtils.TruncateAt.END);
        goto L36
    L35:
        r103.setVisibility(8);
        goto L36
    L14:
        r106 = TextUtils.TruncateAt.END;
        goto L15
    L10:
        r105 = this.f390582g.f390584b;
        goto L11
    L6:
        r102 = r101.f386290h;
        goto L7
    }

    public final int c(int r100) {
        Resources r101 = getResources();
        return MathKt.roundToInt(r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density);
    }

    public final int d(TextView r110) {
        CharSequence r100 = r110.getText();
        if (r100 == null) goto L5;
        String r101 = r100.toString();
    L6:
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        String r102 = r101;
        if (r102.length() != 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        return 0;
    L14:
        int r104 = (r110.getWidth() - r110.getPaddingStart()) - r110.getPaddingEnd();
        if (r104 <= 0) goto L17;
    L16:
        int r105 = r104;
        if (r105 > 0) goto L42;
        return 0;
    L42:
        return new StaticLayout(r102, r110.getPaint(), r105, Layout.Alignment.ALIGN_NORMAL, r110.getLineSpacingMultiplier(), r110.getLineSpacingExtra(), r110.getIncludeFontPadding()).getLineCount();
    L17:
        r104 = (r110.getMeasuredWidth() - r110.getPaddingStart()) - r110.getPaddingEnd();
        if (r104 > 0) goto L16;
        ObricOmniBlockTaskHeaderBinding r106 = this.f390576a;
        if (r106 == null) goto L25;
        LinearLayout r107 = r106.f386283a;
        if (r107 == null) goto L25;
        int r108 = r107.getWidth();
    L26:
        ObricOmniBlockTaskHeaderBinding r109 = this.f390576a;
        if (r109 == null) goto L31;
        LinearLayout r111 = r109.f386283a;
        if (r111 == null) goto L31;
        int r112 = r111.getPaddingStart();
    L32:
        ObricOmniBlockTaskHeaderBinding r113 = this.f390576a;
        if (r113 == null) goto L37;
        LinearLayout r114 = r113.f386283a;
        if (r114 == null) goto L37;
        int r115 = r114.getPaddingEnd();
    L38:
        r104 = RangesKt.coerceAtLeast(r108 - (r112 + r115), 0);
    L37:
        r115 = 0;
    L31:
        r112 = 0;
    L25:
        r108 = 0;
        goto L26
    L11:
        r103 = false;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    public final void a(SpannableStringBuilder r100, String r101) {
        int r102 = r100.length();
        r100.append("补充：");
        r100.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_neutral_50, getContext(), R.color.larus_neutral_50))), r102, r100.length(), 33);
        int r103 = r100.length();
        r100.append(r101);
        r100.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_neutral_100, getContext(), R.color.larus_neutral_100))), r103, r100.length(), 33);
    }

    public final void e(boolean r100, boolean r101) {
        ObricOmniBlockTaskHeaderBinding r102 = this.f390576a;
        if (r102 == null) goto L10;
        ImageView r103 = r102.f386285c;
        if (r103 == null) goto L10;
        if (r100 == false) goto L8;
        int r104 = 0;
    L9:
        r103.setVisibility(r104);
        goto L10
    L8:
        r104 = 8;
    L10:
        if (r100 == true) goto L12;
        return;
    L12:
        ObricOmniBlockTaskHeaderBinding r105 = this.f390576a;
        if (r105 == null) goto L21;
        ImageView r106 = r105.f386285c;
        if (r106 == null) goto L22;
        if (r101 == false) goto L18;
        float r107 = 180.0f;
    L19:
        r106.setRotation(r107);
        return;
    L18:
        r107 = 0.0f;
        goto L19
    L22:
        return;
    }

    public TaskHeaderView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f390577b = CollectionsKt.emptyList();
        mt8.a r113 = InputViewCreatorDelegate.f298409b.e(r110);
        this.f390578c = r113;
        this.f390579d = MapsKt.emptyMap();
        this.f390582g = new a(0);
        View r114 = LayoutInflater.from(r110).inflate(R.layout.obric_omni_block_task_header, this, false);
        addView(r114);
        int r115 = R.id.flHeaderAttachments;
        FrameLayout r100 = (FrameLayout) ViewBindings.findChildViewById(r114, R.id.flHeaderAttachments);
        if (r100 == null) goto L21;
        r115 = R.id.ivExpand;
        ImageView r101 = (ImageView) ViewBindings.findChildViewById(r114, R.id.ivExpand);
        if (r101 == null) goto L21;
        r115 = R.id.llHeaderAdditionContainer;
        LinearLayout r102 = (LinearLayout) ViewBindings.findChildViewById(r114, R.id.llHeaderAdditionContainer);
        if (r102 == null) goto L21;
        r115 = R.id.llHeaderLabel;
        LinearLayout r103 = (LinearLayout) ViewBindings.findChildViewById(r114, R.id.llHeaderLabel);
        if (r103 == null) goto L21;
        r115 = R.id.tvHeaderAdditionPreview;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r114, R.id.tvHeaderAdditionPreview);
        if (r104 == null) goto L21;
        r115 = R.id.tvHeaderDesc;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r114, R.id.tvHeaderDesc);
        if (r105 == null) goto L21;
        r115 = R.id.tvHeaderLabel;
        if (((TextView) ViewBindings.findChildViewById(r114, R.id.tvHeaderLabel)) == null) goto L21;
        r115 = R.id.tvHeaderTitle;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r114, R.id.tvHeaderTitle);
        if (r106 == null) goto L21;
        this.f390576a = new ObricOmniBlockTaskHeaderBinding((LinearLayout) r114, r100, r101, r102, r103, r104, r105, r106);
        r100.addView(r113.getView(), new FrameLayout.LayoutParams(-1, -2));
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r114.getResources().getResourceName(r115)));
    }

    public /* synthetic */ TaskHeaderView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
