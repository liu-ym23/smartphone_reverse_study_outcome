package com.ss.android.lark.newemoji.emoji_list.adapter.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.newemoji.emoji_list.adapter.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import qsb.i;
import s5c.d;
import z5c.k0;
import z5c.n3;
import z5c.p3;
import z5c.r;
import z5c.r2;
import z5c.w1;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/newemoji/emoji_list/adapter/view/SingleEmojiView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "emojiIv", "Landroid/widget/ImageView;", "params", "Lcom/ss/android/lark/newemoji/emoji_list/CreateItemParams;", "initView", "", "bindData", "emojiViewData", "Lcom/ss/android/lark/newemoji/emoji_list/EmojiItemData$Emoji;", "emojiSkinTonesEnabled", "", "listener", "Lcom/ss/android/lark/newemoji/emoji_list/adapter/OnEmojiSelectListener;", "Companion", "lark-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SingleEmojiView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f432950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ssb.a f432951b;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<String> f432952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<d> f432953b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f432954c;

        public b(Function0<String> r100, Ref.ObjectRef<d> r101, e r102) {
            this.f432952a = r100;
            this.f432953b = r101;
            this.f432954c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            String r101 = this.f432952a.invoke();
            d r102 = this.f432953b.element.plus(k0.f570231c.a(r101));
            e r103 = this.f432954c;
            if (r103 == null) goto L6;
            r103.a(r101, r102);
            return;
        }
    }

    static {
    }

    public SingleEmojiView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f432950a = new ImageView(getContext());
    }

    public final void b(ssb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f432951b = r100;
        setLayoutParams(new FlexboxLayoutManager.LayoutParams(r100.f543495a, r100.f543496b));
        setBackgroundResource(R.drawable.item_emoji_bg_emoji);
        this.f432950a.setId(R.id.emoji_iv);
        ImageView r101 = this.f432950a;
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-2, r100.f543498d);
        r102.gravity = 17;
        r101.setLayoutParams(r102);
        this.f432950a.setAdjustViewBounds(true);
        this.f432950a.setScaleType(ImageView.ScaleType.FIT_CENTER);
        addView(this.f432950a);
    }

    public SingleEmojiView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f432950a = new ImageView(getContext());
    }

    public SingleEmojiView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        this.f432950a = new ImageView(getContext());
    }

    /* JADX WARN: Type inference failed for: r7v5, types: [T, s5c.d] */
    /* JADX WARN: Type inference failed for: r8v7, types: [T, s5c.d] */
    public final void a(ssb.b.c r100, boolean r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, "emojiViewData");
        final com.ss.android.lark.newemoji.larkemoji.a r103 = r100.f543507b;
        ViewGroup.LayoutParams r104 = getLayoutParams();
        if (r103.getWidth() <= 45) goto L14;
        float r105 = r103.getWidth() * 1.0f;
        ssb.a r106 = this.f432951b;
        if (r106 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r106 = null;
    L7:
        int r107 = (int) ((r105 * r106.f543498d) / r103.getHeight());
        ssb.a r108 = this.f432951b;
        if (r108 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r108 = null;
    L10:
        int r109 = r107 + r108.f543495a;
        ssb.a r110 = this.f432951b;
        if (r110 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r110 = null;
    L13:
        int r111 = r109 - r110.f543498d;
    L18:
        r104.width = r111;
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == false) goto L24;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r104;
        ssb.a r113 = this.f432951b;
        if (r113 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r113 = null;
    L23:
        r112.setMarginEnd(r113.f543497c);
    L24:
        setLayoutParams(r104);
        if (r100.f543508c == false) goto L28;
        if (r101 == false) goto L28;
        final boolean r114 = true;
    L29:
        if (r114 == false) goto L31;
        Bitmap r115 = r103.d();
    L32:
        if (r115 == null) goto L34;
        this.f432950a.setImageBitmap(r115);
        Function0<String> r116 = new SingleEmojiView$bindData$selectedEmojiKey$1(r114, r103);
        d r117 = r100.f543509d;
        if (r117 == null) goto L42;
    L45:
        Ref.ObjectRef r118 = new Ref.ObjectRef();
        ?? r119 = r117.plus(r.f570317c).plus(p3.f570282c).plus(w1.f570395d);
        r118.element = r119;
        Integer r120 = r100.f543510e;
        if (r120 == null) goto L48;
        r118.element = r119.plus(r2.f570360c.a(r120.toString()));
    L48:
        setOnClickListener(new b(r116, r118, r102));
        return;
    L42:
        if ((!r100.f543508c) == false) goto L44;
        r117 = n3.f570264c;
        goto L45
    L44:
        r117 = n3.f570265d;
        goto L45
    L34:
        if (i.a(r103.getWidth(), getContext()) <= 134) goto L36;
        int r121 = r103.getWidth();
    L37:
        this.f432950a.setImageDrawable(new xsb.a(getContext(), i.a(r121, getContext()), i.a(r103.getHeight(), getContext())));
        Log.i("SingleEmojiView", "bitmap is null, emojiId is " + r103.getId() + ", skinedReactionKey is " + r103.f());
        setOnClickListener(null);
        return;
    L36:
        r121 = r103.getHeight();
        goto L37
    L31:
        r115 = r103.a();
    L28:
        r114 = false;
        goto L29
    L14:
        ssb.a r122 = this.f432951b;
        if (r122 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("params");
        r122 = null;
    L17:
        r111 = r122.f543495a;
        goto L18
    }
}
