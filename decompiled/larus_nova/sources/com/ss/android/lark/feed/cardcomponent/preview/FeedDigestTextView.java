package com.ss.android.lark.feed.cardcomponent.preview;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.feed.app.entity.DigestElement;
import com.ss.android.lark.feed.app.entity.EmojiProperty;
import com.ss.android.lark.feed.app.entity.TextProperty;
import com.ss.android.lark.feed.app.entity.TextWithEmojiProperty;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\u000bJ8\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u0007J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J0\u0010\u001a\u001a\u00020\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020\u0016H\u0014R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/preview/FeedDigestTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mDigestMessage", "", "Lcom/ss/android/lark/feed/app/entity/DigestElement;", "prefix", "", "suffix", "emojiCallback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "setDigest", "", "digest", "emojiSizeDp", "createCallback", "buildText", "", "digestMessage", "emojiLoadAction", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onDetachedFromWindow", "Companion", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedDigestTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f420873e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends DigestElement> f420874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f420875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f420876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FeedDigestTextView$setDigest$spannableString$1$1 f420877d;

    public static final class a {
    }

    static {
        f420873e = (int) zz7.b.h(UIHelper.getContext(), 14);
        UIHelper.dp2px(5.0f);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f420877d = null;
    }

    public FeedDigestTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
    }

    public FeedDigestTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public FeedDigestTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public final CharSequence x(List<? extends DigestElement> r110, IGetDataCallback<Boolean> r111, int r112) {
        SpannableStringBuilder r100 = new SpannableStringBuilder();
        String r101 = this.f420875b;
        if (r101 == null) goto L5;
        r100.append(r101);
    L5:
        List<? extends DigestElement> r102 = r110;
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        r100.append("");
    L31:
        String r113 = this.f420876c;
        if (r113 == null) goto L35;
        r100.append(r113);
    L35:
        if (r100.length() <= 150) goto L38;
        CharSequence r114 = r100.subSequence(0, 150);
        Intrinsics.checkNotNull(r114);
        return r114;
    L38:
        return r100;
    L14:
        Iterator<? extends DigestElement> r115 = r110.iterator();
        int r104 = 0;
    L16:
        if (r115.hasNext() == false) goto L31;
        DigestElement r105 = r115.next();
        if ((r105 instanceof TextProperty) == true) goto L19;
        if ((r105 instanceof EmojiProperty) == true) goto L22;
        if ((r105 instanceof TextWithEmojiProperty) == false) goto L30;
        r100.append(((TextWithEmojiProperty) r105).component1());
        EmojiHandler.a(UIHelper.getContext(), r100, zz7.b.g(getContext(), r112), 2, f420873e, 0, -1);
        goto L16
    L30:
        throw new NoWhenBranchMatchedException();
    L22:
        EmojiProperty r106 = (EmojiProperty) r105;
        String r107 = r106.component1();
        String r108 = r106.component2();
        if (r104 > 100) goto L25;
        sdb.a.a(getContext(), r100, r107, r108, r111, zz7.b.g(getContext(), r112));
    L25:
        r104 = r104 + 1;
        goto L16
    L19:
        r100.append(((TextProperty) r105).getContent());
        goto L16
    L8:
        if (r102.isEmpty() == true) goto L11;
        r103 = false;
        goto L12
    }
}
