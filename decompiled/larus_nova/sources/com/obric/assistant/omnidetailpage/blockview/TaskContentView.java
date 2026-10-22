package com.obric.assistant.omnidetailpage.blockview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.business.markdown.api.model.CodeBlockConfig;
import com.larus.business.markdown.api.model.TableConfig;
import com.larus.nova.R;
import com.obric.assistant.card.databinding.ObricOmniBlockTaskContentBinding;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.omnidetailpage.blockview.base.OmniDetailVerticalLineFrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 62\u00020\u0001:\u0003456B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\"\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00180\u001dJ<\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001e2\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001dH\u0002J0\u0010#\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u001e2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001dH\u0002J\u0018\u0010%\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020$H\u0002J\u0018\u0010'\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020$H\u0002J8\u0010)\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020$2\b\u0010\"\u001a\u0004\u0018\u00010\u001e2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001dH\u0002J \u0010*\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\u0007H\u0002J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0002J\u0018\u0010/\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020$H\u0002J\u0010\u00100\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0007H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015¨\u00067"}, d2 = {"Lcom/obric/assistant/omnidetailpage/blockview/TaskContentView;", "Lcom/obric/assistant/omnidetailpage/blockview/base/OmniDetailVerticalLineFrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/obric/assistant/card/databinding/ObricOmniBlockTaskContentBinding;", "defaultMovementMethod", "Landroid/text/method/MovementMethod;", "getDefaultMovementMethod", "()Landroid/text/method/MovementMethod;", "defaultMovementMethod$delegate", "Lkotlin/Lazy;", "arrowDrawable", "Landroid/graphics/drawable/Drawable;", "getArrowDrawable", "()Landroid/graphics/drawable/Drawable;", "arrowDrawable$delegate", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$Content;", "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$ModeSetting;", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function1;", "", "bindContent", "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem;", "content", "clickAction", "isModeSettingClickable", "", "buildRenderContent", "appendAction", "updateClickState", "isClickable", "applyModeSettingActionSpan", "updateContentPadding", "useCompactIndent", "topSpacingDp", "dpToPx", "dp", "updateContentTextColor", "resolveContentWidth", "buildTableConfig", "Lcom/larus/business/markdown/api/model/TableConfig;", "tableWidth", "DebouncedClickableSpan", "ModeSettingActionSpan", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskContentView extends OmniDetailVerticalLineFrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f390564f = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ObricOmniBlockTaskContentBinding f390565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f390566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f390567e;

    public static final class a {
    }

    public static final class b extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<Unit> f390568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f390569b;

        public b(v r100) {
            Intrinsics.checkNotNullParameter(r100, SendEventContainerMethodParamModel.EventKinds.onClick);
            this.f390568a = r100;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            long r101 = System.currentTimeMillis();
            if ((r101 - this.f390569b) >= 500) goto L5;
            return;
        L5:
            this.f390569b = r101;
            this.f390568a.invoke();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "ds");
            r100.setUnderlineText(false);
        }
    }

    public static final class c extends ReplacementSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable f390570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f390571b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Typeface f390572c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Typeface f390573a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f390574b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L8;
                return false;
            L8:
                a r101 = (a) r100;
                if (Intrinsics.areEqual(this.f390573a, r101.f390573a) == true) goto L12;
                return false;
            L12:
                if (this.f390574b == r101.f390574b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                Typeface r100 = this.f390573a;
                if (r100 != null) goto L5;
                int r101 = 0;
            L6:
                int r102 = r101 * 31;
                if (this.f390574b == false) goto L9;
                int r103 = 1231;
            L11:
                return r102 + r103;
            L9:
                r103 = 1237;
                goto L11
            L5:
                r101 = r100.hashCode();
                goto L6
            }

            public final String toString() {
                return "PaintState(typeface=" + this.f390573a + ", fakeBoldText=" + this.f390574b + ')';
            }

            public a(Typeface r100, boolean r101) {
                this.f390573a = r100;
                this.f390574b = r101;
            }
        }

        public final a a(Paint r100) {
            Typeface r101 = r100.getTypeface();
            boolean r102 = r100.isFakeBoldText();
            if (Build.VERSION.SDK_INT < 28) goto L8;
            if (r101 != null) goto L6;
            Typeface r103 = Typeface.DEFAULT;
        L7:
            Typeface r104 = Typeface.create(r103, 500, false);
        L9:
            r100.setTypeface(r104);
            r100.setFakeBoldText(false);
            return new a(r101, r102);
        L6:
            r103 = r101;
            goto L7
        L8:
            r104 = this.f390572c;
            goto L9
        }

        public c(Drawable r100, int r101) {
            this.f390570a = r100;
            this.f390571b = r101;
            this.f390572c = Typeface.create("sans-serif-medium", 0);
        }

        @Override // android.text.style.ReplacementSpan
        public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
            Intrinsics.checkNotNullParameter(r100, "paint");
            Intrinsics.checkNotNullParameter(r101, "text");
            a r105 = a(r100);
            Drawable r106 = this.f390570a;
            int r107 = 0;
            if (r106 == null) goto L7;
            Rect r108 = r106.getBounds();
            if (r108 == null) goto L7;
            int r109 = r108.width();
        L8:
            if (r109 <= 0) goto L10;
            r107 = this.f390571b;
        L10:
            int r110 = MathKt.roundToInt((r100.measureText("去设置") + r107) + r109);
            r100.setTypeface(r105.f390573a);
            r100.setFakeBoldText(r105.f390574b);
            return r110;
        L7:
            r109 = 0;
            goto L8
        }

        @Override // android.text.style.ReplacementSpan
        public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            Intrinsics.checkNotNullParameter(r101, "text");
            Intrinsics.checkNotNullParameter(r108, "paint");
            a r109 = a(r108);
            r100.drawText("去设置", r104, r106, r108);
            float r110 = r108.measureText("去设置");
            r108.setTypeface(r109.f390573a);
            r108.setFakeBoldText(r109.f390574b);
            Drawable r111 = this.f390570a;
            if (r111 != null) goto L5;
            return;
        L5:
            float r112 = (r104 + r110) + this.f390571b;
            int r113 = r105 + (((r107 - r105) - r111.getBounds().height()) / 2);
            r100.save();
            r100.translate(r112, r113);
            r111.draw(r100);
            r100.restore();
        }
    }

    static {
    }

    public TaskContentView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TaskContentView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final Drawable getArrowDrawable() {
        return (Drawable) this.f390567e.getValue();
    }

    private final MovementMethod getDefaultMovementMethod() {
        return (MovementMethod) this.f390566d.getValue();
    }

    public TaskContentView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f390566d = LazyKt.lazy(new t(this));
        this.f390567e = LazyKt.lazy(new u(r100));
        View r103 = LayoutInflater.from(r100).inflate(R.layout.obric_omni_block_task_content, this, false);
        addView(r103);
        CustomMarkdownTextView r104 = (CustomMarkdownTextView) ViewBindings.findChildViewById(r103, R.id.tvContent);
        if (r104 == null) goto L7;
        this.f390565c = new ObricOmniBlockTaskContentBinding((LinearLayout) r103, r104);
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(R.id.tvContent)));
    }

    public /* synthetic */ TaskContentView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [com.obric.assistant.omnidetailpage.blockview.v] */
    public final void a(ifa.f r710, String r810, final String r811, final Function1<? super String, Unit> r812) {
        setShowLine(r710.f489686c);
        ObricOmniBlockTaskContentBinding r100 = this.f390565c;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r710.f489688e == true) goto L7;
    L11:
        boolean r101 = false;
    L12:
        int r102 = r710.f489690g;
        LinearLayout r103 = r100.f386281a;
        if (r101 == false) goto L15;
        int r110 = i5.q();
    L16:
        Resources r111 = getResources();
        r103.setPaddingRelative(r110, (int) ((r102 * WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics()).density) + 0.5f), i5.q(), r100.f386281a.getPaddingBottom());
        if ((r710 instanceof ifa.f.g) == false) goto L35;
        if (r811 != null) goto L20;
    L23:
        boolean r104 = true;
    L24:
        if (r104 == true) goto L35;
        String r105 = r710.f489685b.getBlockId();
        if (r105 != null) goto L28;
    L31:
        boolean r106 = true;
    L32:
        if (r106 == true) goto L35;
        if (r812 == null) goto L35;
        boolean r107 = true;
    L36:
        r100.f386282b.setClickable(r107);
        r100.f386282b.setOnClickListener(null);
        if (r107 == true) goto L39;
        r100.f386282b.setMovementMethod(getDefaultMovementMethod());
    L39:
        int r108 = r100.f386282b.getWidth();
        if (r108 > 0) goto L43;
        r108 = RangesKt.coerceAtLeast((com.larus.utils.i.f(getContext()) - r100.f386281a.getPaddingStart()) - r100.f386281a.getPaddingEnd(), 0);
    L43:
        int r112 = r108;
        if (r107 == true) goto L46;
        String r113 = r810;
    L47:
        gw8.c.f483071a.getClass();
        gw8.c r114 = gw8.c.a.b();
        if (r114 == null) goto L50;
        Context r115 = getContext();
        int r116 = j19.c.c(8);
        int r109 = ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_primary_50, getContext(), R.color.larus_primary_50));
        CodeBlockConfig r210 = new CodeBlockConfig(null, null, false, null, 0, null, false, null, false, false, null, false, null, null, null, null, false, false, null, false, null, null, null, false, null, true, true, 33554431, null);
        Context r117 = getContext();
        int r118 = ContextCompat.getColor(r117, v19.c.b(R.attr.larus_neutral_transparent_3_web, r117, R.color.larus_neutral_transparent_3_web));
        int r119 = ContextCompat.getColor(r117, v19.c.b(R.attr.larus_neutral_transparent_1, r117, R.color.larus_neutral_transparent_1));
        int r120 = RangesKt.coerceAtLeast(r112 / 2, 0);
        int r121 = i5.r0();
        int r122 = i5.r0();
        lw8.l r123 = gw8.c.b.a(r114, r115, r112, r113, true, new lw8.d(0, null, null, false, Integer.valueOf(r109), 0, Float.valueOf(1.0f), 0.0f, Float.valueOf(1.0f), 0, 0, Integer.valueOf(r116), null, null, null, null, r210, new TableConfig(false, 0, Float.valueOf(we8.a.a(i5.o(), false)), Integer.valueOf(i5.b()), Integer.valueOf(r118), null, Integer.valueOf(r122), Integer.valueOf(r121), Integer.valueOf(r112), Integer.valueOf(r120), Integer.valueOf(i5.q()), Integer.valueOf(i5.r0()), null, null, false, false, false, false, false, null, Integer.valueOf(ContextCompat.getColor(r117, android.R.color.transparent)), Integer.valueOf(r119), 1044515, null), null, null, null, null, null, null, -6330945, 31), null, null, 224);
    L51:
        CustomMarkdownTextView r124 = r100.f386282b;
        String r125 = r710.f489685b.getBlockId();
        if (r125 != null) goto L54;
        r125 = "";
    L54:
        com.larus.bmhome.chat.layout.widget.handler.e.b(r124, "obric_omni_detail_block_id", r125);
        r100.f386282b.setMarkdown(r123);
        if (r107 == false) goto L78;
        if (r811 != null) goto L58;
    L61:
        boolean r126 = true;
    L62:
        if (r126 == true) goto L78;
        if (r812 == null) goto L78;
        CharSequence r127 = r100.f386282b.getText();
        if ((r127 instanceof Spannable) == false) goto L69;
        Spannable r128 = (Spannable) r127;
    L70:
        if (r128 == null) goto L78;
        int r129 = r128.length();
        int r130 = r129 - 3;
        if (r130 < 0) goto L78;
        if (Intrinsics.areEqual(r128.subSequence(r130, r129).toString(), "去设置") == false) goto L78;
        r128.setSpan(new c(getArrowDrawable(), i5.z()), r130, r129, 33);
        r128.setSpan(new b(new v(r812, r811)), r130, r129, 33);
        r100.f386282b.setMovementMethod(LinkMovementMethod.getInstance());
        goto L78
    L69:
        r128 = null;
        goto L70
    L58:
        if (r811.length() == 0) goto L61;
        r126 = false;
    L78:
        if (r101 == 0) goto L80;
        int r131 = R.attr.larus_neutral_100;
    L81:
        if (r101 == false) goto L83;
        int r132 = R.color.larus_neutral_100;
    L84:
        int r133 = ContextCompat.getColor(getContext(), v19.c.b(r131, getContext(), r132));
        r100.f386282b.setTextColor(r133);
        Drawable r134 = getArrowDrawable();
        if (r134 == null) goto L89;
        DrawableCompat.setTint(r134, r133);
        return;
    L89:
        return;
    L83:
        r132 = R.color.larus_neutral_70;
        goto L84
    L80:
        r131 = R.attr.larus_neutral_70;
        goto L81
    L50:
        r123 = null;
        goto L51
    L46:
        r113 = r810.concat("去设置");
        goto L47
    L28:
        if (r105.length() == 0) goto L31;
        r106 = false;
        goto L32
    L20:
        if (r811.length() == 0) goto L23;
        r104 = false;
    L35:
        r107 = false;
        goto L36
    L15:
        r110 = i5.d0();
        goto L16
    L7:
        if (r710.f489689f == false) goto L11;
        if (r710.f489686c == true) goto L11;
        r101 = true;
        goto L12
    }
}
