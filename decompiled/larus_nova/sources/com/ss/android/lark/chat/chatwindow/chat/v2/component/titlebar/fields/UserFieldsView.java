package com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.larus.nova.R;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003@ABB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u0004\u0018\u00010\u001cJ\u0018\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0014J\u0018\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0007H\u0002J(\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0018\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0002J0\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0017H\u0002J\u0018\u00105\u001a\u0002022\u0006\u00106\u001a\u0002022\u0006\u0010.\u001a\u000207H\u0002J \u00108\u001a\u00020\u001e2\u0006\u00106\u001a\u0002022\u0006\u0010.\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0017H\u0002J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020;H\u0014J\u0010\u0010<\u001a\u00020\u001e2\b\u0010=\u001a\u0004\u0018\u00010>J\b\u0010?\u001a\u00020 H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/titlebar/fields/UserFieldsView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textPaint", "Landroid/text/TextPaint;", "dividerPaint", "Landroid/graphics/Paint;", "getDividerPaint", "()Landroid/graphics/Paint;", "dividerPaint$delegate", "Lkotlin/Lazy;", SlcElement.KEY_ELEMENTS, "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/titlebar/fields/UserFieldsView$Element;", "Lkotlin/collections/ArrayList;", "dividerWidth", "", "dividerHeight", "dividerMargin", "maxWidth", "data", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/titlebar/fields/UserFields;", "setUserFields", "", "hasContent", "", "getCurrentFields", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "calcDefaultSize", "size", "measureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "updateElements", "width", "height", "addTwoTextElement", SoloKtvContext.SOLO_PAGE_FIRST, "", "second", "textBaseline", "ellipseText", "text", "", "addSingleTextElement", "onDraw", "canvas", "Landroid/graphics/Canvas;", "updateTheme", "themeType", "Lcom/ss/android/lark/chat/entity/theme/TitleTheme$ThemeType;", "isChatTitleLeftAlignEnable", "Element", "TextElement", "DividerElement", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserFieldsView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f414378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f414379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<b> f414380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f414381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f414382e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f414383f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f414384g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.c f414385h;

    public final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f414386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f414387b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f414388c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f414389d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ UserFieldsView f414390e;

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.UserFieldsView.b
        public final void draw(Canvas r100) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            r100.drawRect(this.f414386a, this.f414387b, this.f414388c, this.f414389d, UserFieldsView.a(this.f414390e));
        }

        public a(UserFieldsView r100, float r101, float r102) {
            this.f414390e = r100;
            this.f414386a = r101;
            this.f414387b = r102;
            this.f414388c = r101 + r100.f414381d;
            this.f414389d = r102 + r100.f414382e;
        }
    }

    public interface b {
        void draw(Canvas r100);
    }

    public final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f414391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f414392b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f414393c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ UserFieldsView f414394d;

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.UserFieldsView.b
        public final void draw(Canvas r100) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            r100.drawText(this.f414391a, this.f414392b, this.f414393c, this.f414394d.f414378a);
        }

        public c(UserFieldsView r100, String r101, float r102, float r103) {
            Intrinsics.checkNotNullParameter(r101, "text");
            this.f414394d = r100;
            this.f414391a = r101;
            this.f414392b = r102;
            this.f414393c = r103;
        }
    }

    public UserFieldsView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public UserFieldsView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final Paint getDividerPaint() {
        return (Paint) this.f414379b.getValue();
    }

    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.c getCurrentFields() {
        return this.f414385h;
    }

    public static final /* synthetic */ Paint a(UserFieldsView r100) {
        return r100.getDividerPaint();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Iterator<T> r101 = this.f414380c.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((b) r101.next()).draw(r100);
        goto L4
    }

    public final void setUserFields(com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.c r100) {
        this.f414385h = r100;
        int r101 = getWidth();
        int r102 = getHeight();
        if (r101 <= 0) goto L6;
        if (r102 <= 0) goto L6;
        d(r101, r102);
    L6:
        requestLayout();
    }

    public final String c(String r100, Number r101) {
        return TextUtils.ellipsize(r100, this.f414378a, r101.floatValue(), TextUtils.TruncateAt.END).toString();
    }

    public final void d(int r110, int r210) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.c r100 = this.f414385h;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.f414398d;
    L6:
        if (r100 == null) goto L8;
        r101 = r100.f414399e;
    L8:
        this.f414380c.clear();
        Paint.FontMetrics r103 = this.f414378a.getFontMetrics();
        float r104 = r210;
        float r105 = r103.bottom;
        float r106 = r103.top;
        float r107 = ((r104 - (r105 - r106)) / 2.0f) - r106;
        if (r102 == null) goto L13;
        if (r101 != null) goto L13;
        b(r102, r110, r107);
        return;
    L13:
        if (r102 != null) goto L17;
        if (r101 == null) goto L17;
        b(r101, r110, r107);
        return;
    L17:
        if (r102 == null) goto L52;
        if (r101 == null) goto L53;
        float r108 = this.f414378a.measureText(r102);
        float r109 = this.f414378a.measureText(r101);
        float r111 = r110;
        float r112 = this.f414381d;
        float r113 = this.f414383f;
        float r114 = ((r111 - r112) / 2.0f) - r113;
        float r115 = (r104 - this.f414382e) / 2.0f;
        float r116 = 0.0f;
        if (r108 <= r114) goto L30;
        if (r109 >= r114) goto L30;
        float r117 = r111 - r109;
        float r118 = (r117 - r112) - (2 * r113);
        String r119 = c(r102, Float.valueOf(r118));
        float r120 = r118 - this.f414378a.measureText(r119);
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("im.chat.header_left_title") == true) goto L26;
    L28:
        this.f414380c.add(new a(this, ((r117 - this.f414381d) - this.f414383f) - r116, r115));
        this.f414380c.add(new c(this, r119, r120 - r116, r107));
        this.f414380c.add(new c(this, r101, r117 - r116, r107));
        return;
    L26:
        if (r120 <= 0.0f) goto L28;
        r116 = r120;
    L30:
        if (r108 < r114) goto L32;
    L34:
        float r121 = r111 / 2.0f;
        float r122 = r113 + r121;
        if (r108 > r114) goto L37;
    L44:
        if (r108 <= r114) goto L46;
        return;
    L46:
        if (r109 <= r114) goto L48;
        return;
    L48:
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("im.chat.header_left_title") == false) goto L50;
        r116 = (r121 - this.f414383f) - r108;
    L50:
        this.f414380c.add(new a(this, (r114 + this.f414383f) - r116, r115));
        this.f414380c.add(new c(this, r102, ((r121 - this.f414383f) - r108) - r116, r107));
        this.f414380c.add(new c(this, r101, r122 - r116, r107));
        return;
    L37:
        if (r109 <= r114) goto L44;
        String r123 = c(r102, Float.valueOf(r114));
        float r124 = r114 - this.f414378a.measureText(r123);
        String r125 = c(r101, Float.valueOf(r114));
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("im.chat.header_left_title") == true) goto L41;
    L43:
        this.f414380c.add(new a(this, (r114 + this.f414383f) - r116, r115));
        this.f414380c.add(new c(this, r123, r124 - r116, r107));
        this.f414380c.add(new c(this, r125, r122 - r116, r107));
        return;
    L41:
        if (r124 <= 0.0f) goto L43;
        r116 = r124;
        goto L43
    L32:
        if (r109 <= r114) goto L34;
        float r126 = (r112 + r108) + (2 * r113);
        this.f414380c.add(new a(this, r108 + r113, r115));
        this.f414380c.add(new c(this, r102, 0.0f, r107));
        this.f414380c.add(new c(this, c(r101, Float.valueOf(r111 - r126)), r126, r107));
        return;
    L53:
        return;
    L52:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.c r102 = this.f414385h;
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.f414398d;
    L6:
        if (r102 == null) goto L8;
        r103 = r102.f414399e;
    L8:
        float r105 = 0.0f;
        if (r104 == null) goto L11;
        float r106 = this.f414378a.measureText(r104);
    L12:
        if (r103 == null) goto L14;
        float r107 = this.f414378a.measureText(r103);
    L15:
        float r108 = r106 + r107;
        if (r108 <= 0.0f) goto L18;
        float r109 = RangesKt.coerceAtMost((r108 + (2 * this.f414383f)) + this.f414381d, this.f414384g);
    L20:
        if (r109 <= 0.0f) goto L22;
        r105 = this.f414378a.getFontMetrics().bottom - this.f414378a.getFontMetrics().top;
    L22:
        int r110 = MathKt.roundToInt(r109);
        int r111 = View.MeasureSpec.getMode(r100);
        int r112 = View.MeasureSpec.getSize(r100);
        if (r111 == Integer.MIN_VALUE) goto L27;
        if (r111 != 1073741824) goto L28;
        r110 = r112;
    L28:
        int r113 = MathKt.roundToInt(r105);
        int r114 = View.MeasureSpec.getMode(r101);
        int r115 = View.MeasureSpec.getSize(r101);
        if (r114 == Integer.MIN_VALUE) goto L33;
        if (r114 != 1073741824) goto L34;
        r113 = r115;
    L34:
        setMeasuredDimension(r110, r113);
        return;
    L33:
        r113 = Math.min(r113, r115);
        goto L34
    L27:
        r110 = Math.min(r110, r112);
        goto L28
    L18:
        r109 = 0.0f;
        goto L20
    L14:
        r107 = 0.0f;
        goto L15
    L11:
        r106 = 0.0f;
        goto L12
    L5:
        r104 = null;
        goto L6
    }

    public UserFieldsView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TextPaint r103 = new TextPaint(1);
        this.f414378a = r103;
        this.f414379b = LazyKt.lazy(new UserFieldsView$dividerPaint$2(r100));
        this.f414380c = new ArrayList();
        this.f414381d = y9c.d.b(r100, 1.0f);
        this.f414382e = y9c.d.b(r100, 10.0f);
        this.f414383f = y9c.d.b(r100, 4.0f);
        this.f414384g = y9c.d.b(r100, 175.0f);
        r103.setTextSize(y9c.d.b(r100, 10.0f));
        r103.setColor(y9c.d.c(r100, R.color.text_placeholder));
    }

    public final void b(String r100, int r101, float r102) {
        float r103 = this.f414378a.measureText(r100);
        float r104 = r101;
        float r105 = 0.0f;
        if (r103 <= r104) goto L6;
        c r106 = new c(this, c(r100, Integer.valueOf(r101)), 0.0f, r102);
    L10:
        this.f414380c.add(r106);
        return;
    L6:
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("im.chat.header_left_title") == true) goto L9;
        r105 = (r104 - r103) / 2.0f;
    L9:
        r106 = new c(this, r100, r105, r102);
        goto L10
    }

    public /* synthetic */ UserFieldsView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        d(r100, r101);
    }
}
