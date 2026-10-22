package com.ss.android.lark.chat.preview.components.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0016\u0018\u0000 32\u00020\u0001:\u00013B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000fJ \u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u00112\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nJ\u001c\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010%H\u0002J\u0018\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\nH\u0014J\u0018\u0010-\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\nH\u0002J \u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020%2\u0006\u00101\u001a\u000202H\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u00064"}, d2 = {"Lcom/ss/android/lark/chat/preview/components/view/TailDrawableTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mWidthMeasureSpec", "mHeightMeasureSpec", "mTailContent", "", "mTailDrawable", "Landroid/graphics/drawable/Drawable;", "mTailDrawablePaddingLeft", "mTailDrawablePaddingRight", "mEllipsizeFinal", "", "mImageLoaderListener", "Lcom/ss/android/lark/chat/preview/components/view/RemoteImageLoadListener;", "getMImageLoaderListener", "()Lcom/ss/android/lark/chat/preview/components/view/RemoteImageLoadListener;", "mImageLoaderListener$delegate", "Lkotlin/Lazy;", "setTailContent", "", "tailContent", "setTailDrawable", "drawable", "drawablePaddingLeft", "drawablePaddingRight", "setText", "text", "", "type", "Landroid/widget/TextView$BufferType;", "bindDrawableCallback", "content", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "doMeasure", "calculateLastLineText", "lastLineStartIndex", "lastLineText", "tailWidth", "", "Companion", "chat-preview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TailDrawableTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f416151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f416152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f416153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f416154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f416155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f416156f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f416157g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f416158h;

    public static final class a {
    }

    static {
    }

    private final d getMImageLoaderListener() {
        return (d) this.f416158h.getValue();
    }

    public TailDrawableTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f416153c = "";
        this.f416158h = LazyKt.lazy(new TailDrawableTextView$mImageLoaderListener$2(this));
    }

    public final void setTailContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tailContent");
        this.f416153c = r100;
        this.f416157g = false;
    }

    public TailDrawableTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f416153c = "";
        this.f416158h = LazyKt.lazy(new TailDrawableTextView$mImageLoaderListener$2(this));
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        if (this.f416151a == r110) goto L5;
    L7:
        boolean r100 = false;
    L9:
        if (TextUtils.isEmpty(this.f416153c) == false) goto L11;
        return;
    L11:
        if (this.f416157g == false) goto L14;
        if (r100 == false) goto L14;
        return;
    L14:
        this.f416151a = r110;
        this.f416152b = r111;
        int r101 = getLineCount();
        Layout r102 = getLayout();
        int r103 = getMaxLines();
        if (r103 == 0) goto L63;
        if (r101 >= r103) goto L18;
        return;
    L18:
        if (TextUtils.isEmpty(getText()) == true) goto L66;
        int r104 = r103 - 1;
        int r105 = r102.getLineEnd(r104);
        if (r105 >= getText().length()) goto L67;
        int r106 = r102.getLineStart(r104);
        int r107 = r105 - 1;
        if (r107 > 0) goto L26;
    L28:
        CharSequence r108 = getText().subSequence(r106, r105);
    L29:
        String r109 = this.f416153c;
        float r112 = getPaint().measureText(r109);
        Drawable r113 = this.f416154d;
        if (r113 == null) goto L34;
        Rect r114 = r113.getBounds();
        if (r114 == null) goto L34;
        int r115 = r114.width();
    L35:
        float r116 = r112 + ((r115 + this.f416156f) + this.f416155e);
        float r117 = getMeasuredWidth() - r116;
        Log.d("[URLPreview]TailTextView", "measureWidth is:" + getMeasuredWidth() + ", tailWidth is:" + r116 + ", widthAvailable:" + r117);
        int r118 = r108.length();
        int r119 = 0;
    L36:
        if (r119 >= r118) goto L41;
        float r120 = getLayout().getPrimaryHorizontal(r106 + r119);
        Log.d("[URLPreview]TailTextView", "index is:" + r119 + ", text is:" + r108.charAt(r119) + ", offset is:" + r120);
        if (r120 > r117) goto L51;
        r119 = r119 + 1;
    L51:
        int r121 = (r106 + r119) - 1;
        if (r121 <= 0) goto L54;
        r108 = getText().subSequence(0, r121);
    L55:
        Log.d("[URLPreview]TailTextView", "index is: " + r119 + ", mustShowText is: " + r108);
        SpannableStringBuilder r122 = new SpannableStringBuilder(r108);
        r122.append(r109);
        Drawable r123 = this.f416154d;
        if (r123 == null) goto L58;
        r122.append("$", new com.ss.android.lark.chat.preview.components.view.a(getContext(), r123.getIntrinsicWidth(), r123.getIntrinsicHeight(), UIHelper.dp2px(4.0f), r123), 33);
    L58:
        setText(r122);
        this.f416157g = true;
        measure(r110, r111);
        return;
    L54:
        Log.i("[URLPreview]TailTextView", "index is: " + r119 + ", text is: " + getText());
        goto L55
    L41:
        float r124 = getLayout().getPrimaryHorizontal((r108.length() + r106) - 1);
        if (r108.length() != 0) goto L44;
        boolean r125 = true;
    L45:
        if (r125 == false) goto L48;
        r119 = 0;
        goto L51
    L48:
        if ((r124 + getPaint().measureText(r108.subSequence(r108.length() - 1, r108.length()).toString())) <= r117) goto L50;
        r119 = r108.length();
        goto L51
    L50:
        r119 = r108.length() + 1;
        goto L51
    L44:
        r125 = false;
    L34:
        r115 = 0;
        goto L35
    L26:
        if (Intrinsics.areEqual("\n", String.valueOf(getText().charAt(r107))) == false) goto L28;
        r108 = getText().subSequence(r106, r107);
        goto L29
    L67:
        return;
    L66:
        return;
    L63:
        return;
    L5:
        if (this.f416152b != r111) goto L7;
        r100 = true;
        goto L9
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        boolean r102 = false;
        this.f416157g = false;
        if ((r100 instanceof Spannable) == false) goto L16;
        Spannable r103 = (Spannable) r100;
        com.ss.android.lark.chat.preview.components.view.a[] r104 = (com.ss.android.lark.chat.preview.components.view.a[]) r103.getSpans(0, r103.length(), com.ss.android.lark.chat.preview.components.view.a.class);
        if (r104 == null) goto L16;
        if (r104.length != 0) goto L11;
        r102 = true;
    L11:
        if ((!r102) == false) goto L16;
        Iterator r105 = ArrayIteratorKt.iterator(r104);
    L14:
        if (r105.hasNext() == false) goto L16;
        com.ss.android.lark.chat.preview.components.view.a r106 = (com.ss.android.lark.chat.preview.components.view.a) r105.next();
        d r107 = getMImageLoaderListener();
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "listener");
        r106.f416179l = r107;
    L16:
        super.setText(r100, r101);
    }

    public TailDrawableTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f416153c = "";
        this.f416158h = LazyKt.lazy(new TailDrawableTextView$mImageLoaderListener$2(this));
    }
}
