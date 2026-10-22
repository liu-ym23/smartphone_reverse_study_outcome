package com.ss.android.lark.reaction.widget.flowlayout.reaction;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 m2\u00020\u0001:\u0004mnopB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bJ\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000fH\u0016J\u0010\u0010&\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010\u0012J\u0016\u0010(\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018J\u0012\u0010)\u001a\u00020$2\b\b\u0001\u0010*\u001a\u00020\u000fH\u0007J\u000e\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\u000fJ\u000e\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020\u000fJ\u000e\u0010/\u001a\u00020$2\u0006\u0010\"\u001a\u00020\u000fJ\u000e\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020 J\u0012\u00102\u001a\u00020$2\n\u00103\u001a\u00060\u001aR\u00020\u001bJ\u000e\u00104\u001a\u00020$2\u0006\u00105\u001a\u00020\u0016J\u000e\u00106\u001a\u00020$2\u0006\u00107\u001a\u00020\u000fJ\u000e\u00108\u001a\u00020$2\u0006\u00109\u001a\u00020\nJ\u000e\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020\nJ\u000e\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020\nJ\u0016\u0010>\u001a\u00020$2\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@J\u0018\u0010B\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\nH\u0002J\"\u0010D\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\n0E2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\r0@H\u0002J$\u0010G\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u000f0E2\u0006\u0010I\u001a\u00020A2\u0006\u0010J\u001a\u00020HH\u0002JH\u0010K\u001a\u00020\u000f2\u0006\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020N2\u0006\u0010I\u001a\u00020\r2\u0006\u0010Q\u001a\u00020N2\u0006\u0010R\u001a\u00020\n2\u0006\u0010S\u001a\u00020FH\u0002JX\u0010T\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0006\u0012\u0004\u0018\u00010H0E2\u0006\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020N2\u0006\u0010P\u001a\u00020N2\u0006\u0010O\u001a\u00020\u000f2\b\u0010U\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020A2\u0006\u0010V\u001a\u00020H2\u0006\u0010J\u001a\u00020HH\u0002J(\u0010W\u001a\u00020$2\u0006\u0010X\u001a\u00020Y2\u0006\u0010I\u001a\u00020A2\u0006\u0010Z\u001a\u00020H2\u0006\u0010L\u001a\u00020\u000fH\u0002J(\u0010[\u001a\u00020$2\u0006\u0010X\u001a\u00020Y2\u0006\u0010\\\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010]\u001a\u00020HH\u0002J(\u0010^\u001a\u00020$2\u0006\u0010X\u001a\u00020Y2\u0006\u0010I\u001a\u00020A2\u0006\u0010Z\u001a\u00020H2\u0006\u0010_\u001a\u00020HH\u0002J\"\u0010`\u001a\u00020$2\u0006\u0010I\u001a\u00020A2\u0006\u0010X\u001a\u00020Y2\b\u0010U\u001a\u0004\u0018\u00010HH\u0002J\u0010\u0010a\u001a\u00020$2\u0006\u0010X\u001a\u00020YH\u0002J\u0018\u0010b\u001a\u00020$2\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u000fH\u0014J\u0010\u0010e\u001a\u00020$2\u0006\u0010f\u001a\u00020gH\u0014J\u0010\u0010h\u001a\u00020\n2\u0006\u0010i\u001a\u00020\u000fH\u0002J\u0010\u0010j\u001a\u00020\u000f2\u0006\u0010k\u001a\u00020HH\u0002J\u0010\u0010;\u001a\u00020\n2\u0006\u0010I\u001a\u00020AH\u0002J\u0010\u0010l\u001a\u00020\n2\u0006\u0010I\u001a\u00020AH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0018\u00010\u001aR\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006q"}, d2 = {"Lcom/ss/android/lark/reaction/widget/flowlayout/reaction/ReactionTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", SlcElement.KEY_ATTR, "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "mAllowOnlyShowCount", "", "mViewDataList", "", "Lcom/ss/android/lark/reaction/widget/flowlayout/bean/FlowLayoutViewModel;", "mDividerColor", "", "Ljava/lang/Integer;", "mBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "extendIconDrawable", "isExtendIconEnable", "mReactionClickListener", "Lcom/ss/android/lark/reaction/widget/flowlayout/ReactionFlowLayout$OnReactionItemClickListener;", "extendIconClickListener", "Lcom/ss/android/lark/reaction/widget/flowlayout/ReactionFlowLayout$OnExtendIconClickListener;", "mOnContributorClickNew", "Lcom/ss/android/lark/reaction/widget/flowlayout/ReactionFlowLayout$OnContributorClickNew;", "Lcom/ss/android/lark/reaction/widget/flowlayout/ReactionFlowLayout;", "shownNamesNumberLimit", "isTapAnimationEnabled", "sizeChanged", "resourceLoader", "Lcom/ss/android/lark/reaction/widget/flowlayout/reaction/ReactionResourceLoaderWrap;", "baseLineSpacingExtra", "extraLineHeight", "setMaxWidth", "", "maxPixels", "setLineBackground", "lineBackground", "setExtendIconInfo", "setExtendIconTint", "iconTint", "setDividerColor", "dividerColor", "setSeparatorWidth", "separatorWidth", "setExtraLineHeight", "setReactionResourceLoader", "loader", "setOnContributorClickNew", "onContributorClickNew", "setReactionClickListener", "listener", "setShownNamesNumberLimit", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "setEnableLongClick", "enableLongClick", "setOnlyShowCount", "onlyShowCount", "setTapAnimationEnabled", "enabled", "setReactionData", "viewDataList", "", "Lcom/ss/android/lark/reaction/widget/flowlayout/bean/ReactionFlowLayoutViewModel;", "setupSeparatorDrawable", "forceUpdateColor", "getSpannableResult", "Lkotlin/Pair;", "Landroid/text/SpannableStringBuilder;", "getOriginalLineText", "", INotificationHitPoint.NoticeType.REACTION, "nameSeparator", "handleNewLine", "realEmojiWidth", "measuredWidth", "", "usedWidth", "lineMaxWidth", "dataSeparatorWidth", "firstReaction", "result", "handleLineText", "suffix", "lineOriginal", "setupEmojiSpan", "lineSpannable", "Landroid/text/SpannableString;", "emoji", "setupExtendSpan", "drawable", "extendIconText", "setupSeparatorSpan", "emojiSeparator", "setupClickSpan", "setupBackgroundSpan", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "needAdjustLineHeight", "startLine", "getDisplayWidth", "reactionKey", "needShowCountWithEllipsis", "Companion", "ReactionClickableSpan", "SeparatorDrawableSpan", "BackgroundSpan", "reaction-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactionTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f439390o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f439391p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f439392q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f439393r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static int f439394s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static int f439395t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static int f439396u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static int f439397v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static int f439398w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static Drawable f439399x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static Drawable f439400y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f439401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<q2c.b> f439402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f439403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f439404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f439405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f439406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ReactionFlowLayout.f f439407g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ReactionFlowLayout.e f439408h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ReactionFlowLayout.d f439409i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f439410j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f439411k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f439412l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f439413m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f439414n;

    public static final class a extends CharacterStyle {
        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
        }

        public a() {
        }
    }

    public static final class b {
    }

    public static final class c extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f439415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q2c.d f439416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f439417c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ReactionFlowLayout.d f439418d;

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "ds");
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            ReactionFlowLayout.d r101 = this.f439418d;
            if (r101 == null) goto L23;
            q2c.d r102 = this.f439416b;
            if (r102 == null) goto L7;
            String r103 = r102.f531477a;
        L8:
            String r104 = this.f439415a;
            boolean r105 = this.f439417c;
            long r106 = SystemClock.uptimeMillis();
            long r107 = r106 - r101.f439386a;
            r101.f439386a = r106;
            if (r107 >= 500) goto L11;
            Log.i("OnSingleClickListener", "elapsedTime is short than LENGTH_SHORT");
            return;
        L11:
            if (r105 == false) goto L18;
            if (r101.f439387b.f439376l != null) goto L15;
            return;
        L15:
            if (TextUtils.isEmpty(r104) == true) goto L26;
            r101.f439387b.f439376l.a(r104);
            return;
        L26:
            return;
        L18:
            if (r101.f439387b.f439375k != null) goto L20;
            return;
        L20:
            if (TextUtils.isEmpty(r103) == true) goto L29;
            r101.f439387b.f439375k.a(r103);
            return;
        L29:
            return;
        L7:
            r103 = null;
            goto L8
        }

        public c(String r100, q2c.d r101, boolean r102, ReactionFlowLayout.d r103) {
            Intrinsics.checkNotNullParameter(r100, "reactionType");
            this.f439415a = r100;
            this.f439416b = r101;
            this.f439417c = r102;
            this.f439418d = r103;
        }
    }

    public static final class d extends com.ss.android.lark.reaction.widget.flowlayout.reaction.d {
        public d() {
            super(1);
        }

        @Override // com.ss.android.lark.reaction.widget.flowlayout.reaction.ClearCacheDynamicDrawableSpan
        public final Drawable b() {
            Drawable r100 = ReactionTextView.f439400y;
            if (r100 == null) goto L5;
            return r100;
        L5:
            return new ShapeDrawable();
        }
    }

    public static final class e implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReactionTextView f439419a;

        public e(ReactionTextView r100) {
            this.f439419a = r100;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            ReactionTextView r101 = this.f439419a;
            if (r101 == null) goto L17;
            ViewParent r102 = r101.getParent();
        L6:
            if (r102 == null) goto L18;
            if ((r102 instanceof ViewGroup) == false) goto L19;
            ViewGroup r103 = (ViewGroup) r102;
            if (r103.isLongClickable() == true) goto L11;
            r102 = r102.getParent();
            goto L6
        L11:
            r103.performLongClick();
            return true;
        L19:
            return false;
        L18:
            return false;
        L17:
            return false;
        }
    }

    static {
        f439390o = -1;
        f439391p = -1;
        f439392q = -1;
        f439393r = -1;
        f439394s = -1;
        f439395t = -1;
        f439396u = -1;
        f439397v = -1;
        f439398w = -1;
    }

    public ReactionTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    private final void setupBackgroundSpan(SpannableString r100) {
        r100.setSpan(new a(), 0, r100.length(), 17);
    }

    public final boolean A(q2c.c r100) {
        if (this.f439401a == false) goto L14;
        List<q2c.d> r101 = r100.f531476c;
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L15;
        return true;
    L15:
        return false;
    L7:
        if (r101.isEmpty() == true) goto L10;
        r102 = false;
        goto L11
    L14:
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if ((getText() instanceof SpannableString) == true) goto L5;
    L42:
        super.onDraw(r110);
        return;
    L5:
        if (getLayout() == null) goto L42;
        CharSequence r100 = getText();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.text.SpannableString");
        SpannableString r101 = (SpannableString) r100;
        int r102 = this.f439414n / 2;
        CharSequence r103 = getText();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.text.SpannableString");
        char r104 = 0;
        a[] r105 = (a[]) ((SpannableString) r103).getSpans(0, getText().length() - 1, a.class);
        if (r105 == null) goto L42;
        Iterator r106 = ArrayIteratorKt.iterator(r105);
    L10:
        if (r106.hasNext() == false) goto L42;
        a r107 = (a) r106.next();
        int r108 = r101.getSpanStart(r107);
        int r109 = r101.getSpanEnd(r107);
        int r111 = getLayout().getLineForOffset(r108);
        int r112 = getLayout().getLineForOffset(r109);
        int r113 = (int) ((getLayout().getPrimaryHorizontal(r108) + ((getLayout().getParagraphDirection(r111) * (-1)) * f439396u)) + getPaddingLeft());
        int r114 = (int) ((getLayout().getPrimaryHorizontal(r109) + (getLayout().getParagraphDirection(r112) * f439396u)) + getPaddingLeft());
        if (r111 == (getLineCount() - 1)) goto L14;
    L34:
        int r115 = ((getLayout().getLineTop(r111) + getPaddingTop()) - r102) + (f439397v * 4);
        int r116 = (getLayout().getLineBottom(r111) + getPaddingTop()) - r102;
    L35:
        int r117 = Math.min(r113, r114);
        int r118 = Math.max(r113, r114);
        Drawable r119 = this.f439404d;
        if (r119 == null) goto L38;
        r119.setBounds(r117, r115, r118, r116);
    L38:
        Drawable r120 = this.f439404d;
        if (r120 == null) goto L41;
        r120.draw(r110);
    L41:
        r104 = 0;
        goto L10
    L14:
        if (y(r111) == false) goto L34;
        r115 = (((getLayout().getLineTop(r111) + getPaddingTop()) + this.f439413m) - r102) - (f439397v / 2);
        r116 = (((getLayout().getLineBottom(r111) + getPaddingTop()) + this.f439413m) + r102) - f439397v;
        CharSequence r121 = getText();
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type android.text.SpannableString");
        com.ss.android.lark.reaction.widget.flowlayout.reaction.d[] r122 = (com.ss.android.lark.reaction.widget.flowlayout.reaction.d[]) ((SpannableString) r121).getSpans(r108, r109, com.ss.android.lark.reaction.widget.flowlayout.reaction.d.class);
        if (r122 != null) goto L18;
    L24:
        CharSequence r123 = getText();
        Intrinsics.checkNotNull(r123, "null cannot be cast to non-null type android.text.SpannableString");
        d[] r124 = (d[]) ((SpannableString) r123).getSpans(r108, r109, d.class);
        if (r124 == null) goto L35;
        if (r124.length != 0) goto L29;
        boolean r125 = true;
    L31:
        if ((!r125) == false) goto L35;
        d r126 = r124[0];
        float r127 = getLineSpacingExtra();
        r126.f439441c = 0.0f;
        r126.f439442d = r127;
        goto L35
    L29:
        r125 = false;
        goto L31
    L18:
        if (r122.length != 0) goto L20;
        boolean r128 = true;
    L22:
        if ((!r128) == false) goto L24;
        com.ss.android.lark.reaction.widget.flowlayout.reaction.d r129 = r122[r104];
        float r130 = getLineSpacingExtra();
        r129.f439441c = 0.0f;
        r129.f439442d = r130;
        goto L24
    L20:
        r128 = false;
        goto L22
    }

    public final void setDividerColor(int r100) {
        this.f439403c = Integer.valueOf(r100);
        B(getContext(), true);
    }

    public final void setEnableLongClick(boolean r100) {
        if (r100 == false) goto L4;
        setOnLongClickListener(new e(this));
        return;
    L4:
        setOnLongClickListener(null);
    }

    public final void setExtendIconTint(int r100) {
        Drawable r101 = this.f439405e;
        if (r101 == null) goto L5;
        r101.setTint(r100);
    L5:
        invalidate();
    }

    public final void setExtraLineHeight(int r100) {
        if (r100 > 0) goto L5;
        r100 = 0;
    L5:
        this.f439414n = r100;
        setLineSpacing(this.f439413m + r100, 1.0f);
    }

    public final void setLineBackground(Drawable r100) {
        if (r100 == null) goto L5;
        this.f439404d = r100;
        return;
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int r100) {
        if (getMaxWidth() == r100) goto L5;
        this.f439412l = true;
    L5:
        super.setMaxWidth(r100);
    }

    public final void setOnContributorClickNew(ReactionFlowLayout.d r100) {
        Intrinsics.checkNotNullParameter(r100, "onContributorClickNew");
        this.f439409i = r100;
    }

    public final void setOnlyShowCount(boolean r100) {
        this.f439401a = r100;
    }

    public final void setReactionClickListener(ReactionFlowLayout.f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f439407g = r100;
    }

    public final void setReactionData(List<? extends q2c.c> r310) {
        if (Intrinsics.areEqual(this.f439402b, r310) == false) goto L8;
        if (this.f439412l == true) goto L8;
        return;
    L8:
        if (r310 != null) goto L11;
        setText(null);
        return;
    L11:
        ((ArrayList) this.f439402b).clear();
        ((ArrayList) this.f439402b).addAll(r310);
        if (this.f439406f == false) goto L14;
        List<q2c.b> r100 = this.f439402b;
        q2c.a r101 = new q2c.a();
        r101.f531473a = this.f439405e;
        ((ArrayList) r100).add(r101);
    L14:
        long r110 = System.currentTimeMillis();
        List<q2c.b> r102 = this.f439402b;
        String r111 = "ReactionView";
        Log.i("ReactionView", "use new reaction view");
        String r112 = v2c.a.getResources(getContext()).getString(R.string.Lark_Legacy_ReactionSeparator);
        float r113 = getPaint().measureText("       ");
        float r114 = ((getMaxWidth() - getPaddingLeft()) - getPaddingRight()) - f439398w;
        SpannableStringBuilder r103 = new SpannableStringBuilder();
        Iterator r115 = ((ArrayList) r102).iterator();
        int r104 = 0;
        int r105 = 0;
        boolean r116 = false;
    L16:
        if (r115.hasNext() == false) goto L199;
        int r117 = r104 + 1;
        q2c.b r106 = (q2c.b) r115.next();
        SpannableString r107 = new SpannableString("");
        if ((r106 instanceof q2c.c) == false) goto L183;
        StringBuilder r108 = new StringBuilder("[");
        q2c.c r109 = (q2c.c) r106;
        r108.append(r109.f531474a);
        r108.append(']');
        String r118 = r108.toString();
        String r119 = r109.f531474a;
        int r120 = k2c.b.b(r119);
        int r121 = k2c.b.a(r119);
        if (r120 == (-1)) goto L25;
        if (r121 == (-1)) goto L25;
        if (r121 == 0) goto L25;
        int r122 = (f439391p * r120) / r121;
    L26:
        Intrinsics.checkNotNull(r112);
        if (A(r109) == false) goto L29;
        Pair r123 = new Pair("", Integer.valueOf(r109.f531475b));
        SpannableStringBuilder r210 = r103;
    L46:
        if (((Number) r123.getSecond()).intValue() != this.f439410j) goto L50;
        if (r109.f531476c.size() <= this.f439410j) goto L50;
    L51:
        boolean r124 = true;
    L53:
        if (r124 == false) goto L55;
        String r125 = v2c.a.e(getContext(), String.valueOf(r109.f531475b - ((Number) r123.getSecond()).intValue()));
        float r126 = ((f439392q + r122) + getPaint().measureText((String) r123.getFirst())) + getPaint().measureText(r125);
    L56:
        String r211 = r125;
        float r212 = r126;
        if (r212 < getMaxWidth()) goto L59;
        r116 = true;
    L59:
        if (r104 != 0) goto L61;
        boolean r127 = true;
    L62:
        String r311 = r111;
        int r128 = r122;
        long r213 = r110;
        SpannableStringBuilder r214 = r210;
        int r129 = x(r122, r212, r105, r114, r106, r113, r127, r214);
        String r130 = (String) r123.getFirst();
        if (A(r109) == false) goto L66;
        Pair r131 = new Pair(" " + r109.f531475b, String.valueOf(r109.f531475b));
    L65:
        String r215 = r112;
    L148:
        String r132 = (String) r131.getFirst();
        String r133 = (String) r131.getSecond();
        int r134 = r129 + ((((int) getPaint().measureText(r132)) + r128) + f439392q);
        if (A(r109) == false) goto L151;
        SpannableString r135 = new SpannableString(r118 + r132);
    L152:
        SpannableString r136 = r135;
        Context r216 = getContext();
        String r137 = r109.f531474a;
        ReactionFlowLayout.f r138 = this.f439407g;
        if (r138 != null) goto L155;
        Intrinsics.throwUninitializedPropertyAccessException("mReactionClickListener");
        r138 = null;
    L155:
        r136.setSpan(new com.ss.android.lark.reaction.widget.flowlayout.reaction.a(r216, r137, r138, r128, new WeakReference(this), this.f439411k), 0, r118.length(), 18);
        if (A(r109) == true) goto L160;
        r136.setSpan(new d(), r118.length(), r118.length() + 1, 18);
    L160:
        if (A(r109) == true) goto L182;
        Iterator<q2c.d> r139 = r109.f531476c.iterator();
        int r140 = 0;
    L164:
        if (r139.hasNext() == false) goto L178;
        q2c.d r141 = r139.next();
        int r142 = StringsKt.indexOf$default(r136, r141.f531478b, r140, false, 4, null);
        if (r142 <= 0) goto L169;
        r140 = r141.f531478b.length() + r142;
        r136.setSpan(new c(r109.f531474a, r141, false, this.f439409i), r142, r141.f531478b.length() + r142, 33);
        goto L164
    L169:
        if (r140 == (-1)) goto L178;
        if (r140 >= (r136.length() - 1)) goto L178;
        int r143 = StringsKt.lastIndexOf$default(r136, '+', 0, false, 6, null);
        if (r143 != (-1)) goto L175;
        r136.setSpan(new c(r109.f531474a, r141, false, this.f439409i), r140 + 1, r136.length() - 1, 33);
        goto L178
    L175:
        int r144 = r143 - 1;
        if (r140 >= r144) goto L178;
        r136.setSpan(new c(r109.f531474a, r141, false, this.f439409i), r140 + 1, r144, 33);
    L178:
        if (r133 == null) goto L182;
        int r145 = StringsKt.indexOf$default(r136, r133, 0, false, 6, null);
        if (r145 == (-1)) goto L182;
        r136.setSpan(new c(r109.f531474a, null, true, this.f439409i), r145 + 1, r145 + r133.length(), 33);
    L182:
        r105 = r134;
        r107 = r136;
    L198:
        setupBackgroundSpan(r107);
        SpannableStringBuilder r146 = r214;
        r146.append(r107);
        r111 = r311;
        r103 = r146;
        r104 = r117;
        r110 = r213;
        r112 = r215;
        goto L16
    L151:
        r135 = new SpannableString(r118 + '|' + r132);
        goto L152
    L66:
        float r147 = r129;
        float r148 = r114 - r147;
        if (r212 <= r148) goto L69;
    L77:
        if (r211 != null) goto L79;
    L82:
        boolean r149 = true;
    L83:
        if (r149 == false) goto L87;
        int r150 = 1;
        if (r109.f531476c.size() <= 1) goto L88;
        r211 = v2c.a.e(getContext(), String.valueOf(r109.f531475b));
    L88:
        String r151 = r211;
        if (r109.f531476c.size() <= r150) goto L94;
        String r152 = String.valueOf(r109.f531475b);
        StringBuilder r153 = new StringBuilder();
        int r154 = r152.length();
        int r155 = 0;
    L91:
        if (r155 >= r154) goto L93;
        r153.append("8");
        r155 = r155 + 1;
        goto L91
    L93:
        String r156 = v2c.a.e(getContext(), r153.toString());
    L95:
        if (r156 == null) goto L97;
        float r157 = getPaint().measureText(r156);
    L98:
        float r158 = (r114 - r157) - r147;
        float r159 = r128;
        CharSequence r160 = TextUtils.ellipsize(r130, getPaint(), (r158 - r159) - f439392q, TextUtils.TruncateAt.END);
        if (r109.f531476c.size() <= 1) goto L101;
    L103:
        Iterator r161 = r109.f531476c.iterator();
        int r162 = 0;
        int r312 = 0;
    L105:
        if (r161.hasNext() == false) goto L139;
        int r163 = r162 + 1;
        q2c.d r164 = (q2c.d) r161.next();
        Intrinsics.checkNotNull(r160);
        Iterator r165 = r161;
        int r166 = StringsKt.indexOf$default(r160, r164.f531478b, r312, false, 4, null);
        r312 = (r164.f531478b.length() + r166) - 1;
        if (r166 == (-1)) goto L108;
        r161 = r165;
        r162 = r163;
        goto L105
    L108:
        int r167 = r109.f531475b - r162;
        Intrinsics.checkNotNull(r160);
        if (r160.length() <= 0) goto L111;
        boolean r168 = true;
    L112:
        if (r168 == true) goto L114;
    L137:
        r215 = r112;
    L141:
        if (this.f439401a == false) goto L144;
        if (r167 != 0) goto L144;
        r167 = r167 + (r109.f531475b - r109.f531476c.size());
    L144:
        if (r167 <= 0) goto L146;
        String r169 = v2c.a.e(getContext(), String.valueOf(r167));
        String r170 = r169;
        String r171 = r160 + r169;
    L147:
        r131 = new Pair(r171, r170);
        goto L148
    L146:
        r171 = TextUtils.ellipsize(r130, getPaint(), (r148 - r159) - f439392q, TextUtils.TruncateAt.END).toString();
        r211 = null;
    L76:
        r170 = r211;
        goto L147
    L114:
        if (r112.length() <= 0) goto L116;
        boolean r172 = true;
    L117:
        if (r172 == false) goto L137;
        if (r160.length() < (r112.length() + 1)) goto L137;
        if (Intrinsics.areEqual(r112, r160.subSequence((r160.length() - 1) - r112.length(), r160.length() - 1)) == false) goto L123;
        r167 = r109.f531475b - r162;
        Intrinsics.checkNotNull(r160);
        r160 = StringsKt.removeRange(r160, (r160.length() - 1) - r112.length(), r160.length() - 1);
    L123:
        if (r162 <= 0) goto L137;
        q2c.d r173 = (q2c.d) ListProtector.get(r109.f531476c, r162 - 1);
        if (r173 == null) goto L128;
        String r174 = r173.f531478b;
        if (r174 == null) goto L128;
    L130:
        if (r174.length() <= 0) goto L132;
        boolean r175 = true;
    L133:
        if (r175 == false) goto L137;
        Intrinsics.checkNotNull(r160);
        r215 = r112;
        if (StringsKt.endsWith$default(r160, r174.concat("…"), false, 2, null) == true) goto L141;
        r167 = r167 - 1;
        goto L141
    L132:
        r175 = false;
    L128:
        r174 = r5;
        goto L130
    L116:
        r172 = false;
        goto L117
    L111:
        r168 = false;
        goto L112
    L139:
        r215 = r112;
        r167 = 0;
        goto L141
    L101:
        if (z(r109) == true) goto L103;
        r131 = new Pair(r160.toString(), r151);
        goto L65
    L97:
        r157 = 0.0f;
        goto L98
    L94:
        r156 = r151;
        goto L95
    L87:
        r150 = 1;
        goto L88
    L79:
        if (r211.length() == 0) goto L82;
        r149 = false;
        goto L83
    L69:
        if (this.f439401a == true) goto L77;
        StringBuilder r176 = new StringBuilder();
        r176.append(r130);
        if (r211 != null) goto L74;
        String r177 = "";
    L75:
        r176.append(r177);
        r171 = r176.toString();
        r215 = r112;
        goto L76
    L74:
        r177 = r211;
        goto L75
    L61:
        r127 = false;
        goto L62
    L55:
        r126 = getPaint().measureText((String) r123.getFirst()) + (f439392q + r122);
        r125 = null;
    L50:
        if (z(r109) == true) goto L51;
        r124 = false;
        goto L53
    L29:
        StringBuilder r178 = new StringBuilder();
        Iterator r179 = r109.f531476c.iterator();
        int r217 = 0;
        int r180 = 0;
    L31:
        if (r179.hasNext() == false) goto L39;
        int r181 = r180 + 1;
        Iterator r218 = r179;
        r178.append(((q2c.d) r179.next()).f531478b);
        int r182 = r217 + 1;
        r210 = r103;
        if (r182 == this.f439410j) goto L34;
        if (r180 >= (r109.f531476c.size() - 1)) goto L38;
        r178.append(r112);
    L38:
        r217 = r182;
        r180 = r181;
        r103 = r210;
        r179 = r218;
        goto L31
    L34:
        r217 = r182;
    L41:
        if (z(r109) == false) goto L43;
        r178.append("...");
        String r183 = r178.toString();
    L44:
        r123 = new Pair(r183, Integer.valueOf(r217));
        goto L46
    L43:
        r183 = r178.toString();
        goto L44
    L39:
        r210 = r103;
    L25:
        r122 = f439391p;
        goto L26
    L183:
        r214 = r103;
        r213 = r110;
        r311 = r111;
        r215 = r112;
        if ((r106 instanceof q2c.a) == false) goto L198;
        if (r104 != 0) goto L188;
        boolean r184 = true;
    L189:
        r105 = x(0, 0.0f, r105, r114, r106, r113, r184, r214);
        if (this.f439406f == false) goto L196;
        r107 = new SpannableString("[ExtendIcon]");
        Drawable r185 = ((q2c.a) r106).f531473a;
        if (r185 == null) goto L198;
        if (this.f439408h == null) goto L198;
        Intrinsics.checkNotNull(r185);
        ReactionFlowLayout.e r186 = this.f439408h;
        Intrinsics.checkNotNull(r186);
        r107.setSpan(new com.ss.android.lark.reaction.widget.flowlayout.reaction.c(r186, r185), r107.length() - 12, r107.length(), 18);
        goto L198
    L196:
        r107 = r107;
        goto L198
    L188:
        r184 = false;
        goto L189
    L199:
        Pair r187 = new Pair(r103, Boolean.valueOf(r116));
        StringBuilder r188 = new StringBuilder("getSpanableResult cost:");
        r188.append(System.currentTimeMillis() - r110);
        Log.d(r111, r188.toString());
        if (((Boolean) r187.getSecond()).booleanValue() == false) goto L202;
        ViewGroup.LayoutParams r189 = getLayoutParams();
        r189.width = getMaxWidth();
        setLayoutParams(r189);
    L202:
        this.f439412l = false;
        setText((CharSequence) r187.getFirst());
    }

    public final void setReactionResourceLoader(com.ss.android.lark.reaction.widget.flowlayout.reaction.e r100) {
        Intrinsics.checkNotNullParameter(r100, "loader");
        Log.i("ReactionView", "setReactionResourceLoader: " + r100);
    }

    public final void setSeparatorWidth(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        if (f439392q == r100) goto L9;
        f439392q = r100;
        B(getContext(), true);
        return;
    }

    public final void setShownNamesNumberLimit(int r100) {
        this.f439410j = r100;
    }

    public final void setTapAnimationEnabled(boolean r100) {
        this.f439411k = r100;
    }

    public final boolean y(int r100) {
        if ((getLayout().getLineBottom(r100) - getLayout().getLineBaseline(r100)) >= getLineSpacingExtra()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean z(q2c.c r100) {
        List<q2c.d> r101 = r100.f531476c;
        if (r101 != null) goto L6;
        return false;
    L6:
        if (this.f439401a == true) goto L8;
        return false;
    L8:
        if (r101.size() >= r100.f531475b) goto L12;
        return true;
    L12:
        return false;
    }

    public ReactionTextView(Context r100, AttributeSet r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110);
        this.f439402b = new ArrayList();
        this.f439410j = 12;
        this.f439411k = true;
        int r101 = v2c.a.a(r100, 5.0f);
        this.f439413m = r101;
        if (f439390o != (-1)) goto L6;
        f439390o = v2c.a.a(r100, 20.0f);
    L6:
        if (f439391p != (-1)) goto L9;
        f439391p = v2c.a.a(r100, 20.0f);
    L9:
        if (f439392q != (-1)) goto L12;
        f439392q = v2c.a.a(r100, 14.5f);
    L12:
        if (f439393r != (-1)) goto L15;
        f439393r = v2c.a.a(r100, 0.5f);
    L15:
        if (f439394s != (-1)) goto L18;
        f439394s = v2c.a.a(r100, 5.0f);
    L18:
        if (f439395t != (-1)) goto L21;
        f439395t = v2c.a.a(r100, 2.0f);
    L21:
        if (f439397v != (-1)) goto L24;
        f439397v = v2c.a.a(r100, 1.0f);
    L24:
        if (f439396u != (-1)) goto L27;
        f439396u = v2c.a.a(r100, 7.0f);
    L27:
        if (f439398w != (-1)) goto L30;
        f439398w = v2c.a.a(r100, 3.0f);
    L30:
        if (f439399x != null) goto L34;
        ShapeDrawable r102 = new ShapeDrawable();
        f439399x = r102;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.graphics.drawable.ShapeDrawable");
        float[] r103 = new float[8];
        ArraysKt.fill(r103, 100.0f, 0, 8);
        r102.setShape(new RoundRectShape(r103, null, null));
        Drawable r104 = f439399x;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.graphics.drawable.ShapeDrawable");
        Paint r105 = ((ShapeDrawable) r104).getPaint();
        if (r105 == null) goto L34;
        r105.setColor(167772160);
    L34:
        this.f439404d = f439399x;
        B(r100, false);
        getPaint().setAntiAlias(true);
        setHighlightColor(0);
        if (com.ss.android.lark.reaction.widget.flowlayout.reaction.b.f439432a != null) goto L37;
        com.ss.android.lark.reaction.widget.flowlayout.reaction.b.f439432a = new com.ss.android.lark.reaction.widget.flowlayout.reaction.b();
    L37:
        setMovementMethod(com.ss.android.lark.reaction.widget.flowlayout.reaction.b.f439432a);
        setLineSpacing(r101, 1.0f);
        setPadding(getPaddingLeft() + f439396u, getPaddingTop(), getPaddingRight() + f439396u, getPaddingBottom());
    }

    public final void B(Context r100, boolean r101) {
        if (f439400y == null) goto L5;
        if (r101 == true) goto L5;
        return;
    L5:
        Bitmap r102 = Bitmap.createBitmap(f439392q, f439391p, Bitmap.Config.ARGB_8888);
        Canvas r103 = new Canvas(r102);
        Paint r104 = new Paint(1);
        Integer r105 = this.f439403c;
        if (r105 == null) goto L8;
        int r106 = r105.intValue();
    L9:
        r104.setColor(r106);
        r104.setStrokeWidth(1.0f);
        float r107 = (f439392q - f439393r) / 2.0f;
        r103.drawLine(r107, f439394s, r107, f439391p - f439395t, r104);
        r103.save();
        BitmapDrawable r108 = new BitmapDrawable(r100.getResources(), r102);
        f439400y = r108;
        r108.setBounds(0, 0, f439392q, f439391p);
        return;
    L8:
        r106 = v2c.a.b(r100, R.color.line_divider_default);
        goto L9
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (getMeasuredHeight() > 0) goto L5;
        return;
    L5:
        if (getLineCount() > 0) goto L8;
        return;
    L8:
        if (y(getLineCount() - 1) == false) goto L12;
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() + ((int) getLineSpacingExtra()));
        return;
    }

    public final int x(int r100, float r101, int r102, float r110, q2c.b r111, float r112, boolean r113, SpannableStringBuilder r114) {
        int r103 = 0;
        if ((r111 instanceof q2c.c) == false) goto L23;
        float r104 = r102;
        if (((r101 + r104) + r112) <= r110) goto L19;
        q2c.c r115 = (q2c.c) r111;
        if ((!r115.f531476c.isEmpty()) == false) goto L9;
        String r105 = ((q2c.d) ListProtector.get(r115.f531476c, 0)).f531478b;
    L10:
        StringBuilder r106 = new StringBuilder(r105);
        if (r115.f531476c.size() <= 1) goto L13;
        r106.append(v2c.a.e(getContext(), String.valueOf(r115.f531476c.size() - 1)));
    L13:
        float r107 = (getPaint().measureText(r106.toString()) + r100) + f439392q;
        if (r104 <= (r110 / 2)) goto L16;
    L17:
        if (r113 == true) goto L19;
        r114.append("\n");
        r102 = 0;
        r103 = 1;
        goto L19
    L16:
        if (r107 <= ((r110 - r104) - r112)) goto L19;
    L9:
        r105 = "";
    L19:
        if (r103 != 0) goto L36;
        if (r113 == true) goto L37;
        r114.append("       ");
        return r102 + ((int) r112);
    L37:
        return r102;
    L36:
        return r102;
    L23:
        if ((r111 instanceof q2c.a) == false) goto L39;
        Drawable r108 = ((q2c.a) r111).f531473a;
        if (r108 != null) goto L28;
        return r102;
    L28:
        if (r108.getIntrinsicHeight() == 0) goto L31;
        r103 = (r108.getIntrinsicWidth() / r108.getIntrinsicHeight()) * f439391p;
    L31:
        if (r103 <= ((r110 - r102) - r112)) goto L33;
        r114.append("\n");
        return r102;
    L33:
        if (r113 == true) goto L41;
        r114.append("       ");
        return r102 + ((int) r112);
    L41:
        return r102;
    L39:
        return r102;
    }
}
