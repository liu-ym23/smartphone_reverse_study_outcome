package com.ss.android.lark.chat.message.menu.v2.popup;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.OneShotPreDrawListener;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.message.menu.v2.DragPanelLayout;
import com.ss.android.lark.chat.message.menu.v2.PanelType;
import com.ss.android.lark.chat.message.menu.v2.emoji.BuiltInEmojiPanelView;
import com.ss.android.lark.chat.message.menu.v2.i0;
import com.ss.android.lark.chat.message.menu.v2.l0;
import com.ss.android.lark.chat.message.menu.v2.o0;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001$\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010&\u001a\u00020\"H\u0002J\b\u0010'\u001a\u00020(H\u0002J*\u0010)\u001a\u00020*2\u0006\u0010!\u001a\u00020\"2\u0006\u0010+\u001a\u00020\"2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010-H\u0002R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%¨\u0006."}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuEmojiPanelContent;", "Landroid/widget/FrameLayout;", "Lcom/ss/android/lark/chat/message/menu/v2/popup/IPopupMenuContent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "panelType", "Lcom/ss/android/lark/chat/message/menu/v2/PanelType;", "getPanelType", "()Lcom/ss/android/lark/chat/message/menu/v2/PanelType;", "shadowTarget", "Lcom/ss/android/lark/chat/message/menu/v2/popup/IPopupMenuContent$ShadowTarget;", "getShadowTarget", "()Lcom/ss/android/lark/chat/message/menu/v2/popup/IPopupMenuContent$ShadowTarget;", "menuContext", "Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContext;", "getMenuContext", "()Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContext;", "setMenuContext", "(Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContext;)V", "onReactionClickListener", "Lcom/ss/android/lark/chat/message/menu/v2/ReactionClickListener;", "getOnReactionClickListener", "()Lcom/ss/android/lark/chat/message/menu/v2/ReactionClickListener;", "setOnReactionClickListener", "(Lcom/ss/android/lark/chat/message/menu/v2/ReactionClickListener;)V", "dragPanelLayout", "Lcom/ss/android/lark/chat/message/menu/v2/DragPanelLayout;", "startTransY", "", "panelDragLayoutChangeListener", "com/ss/android/lark/chat/message/menu/v2/popup/PopupMenuEmojiPanelContent$panelDragLayoutChangeListener$1", "Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuEmojiPanelContent$panelDragLayoutChangeListener$1;", "computeHalfTranslationY", "isFullExpanded", "", "startRestoreAnimator", "", "endTransY", "endAction", "Lkotlin/Function0;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopupMenuEmojiPanelContent extends FrameLayout implements IPopupMenuContent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PanelType f415806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IPopupMenuContent.ShadowTarget f415807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f415808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o0 f415809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DragPanelLayout f415810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f415811f;

    public static final class a implements com.ss.android.lark.newemoji.emoji_list.adapter.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PopupMenuEmojiPanelContent f415812a;

        public a(PopupMenuEmojiPanelContent r100) {
            this.f415812a = r100;
        }

        @Override // com.ss.android.lark.newemoji.emoji_list.adapter.e
        public final void a(String r100, s5c.d r101) {
            Intrinsics.checkNotNullParameter(r100, "reactionKey");
            Intrinsics.checkNotNullParameter(r101, "param");
            o0 r102 = this.f415812a.getOnReactionClickListener();
            if (r102 == null) goto L5;
            r102.a(r100, 2);
        L5:
            d r103 = this.f415812a.getMenuContext();
            if (r103 == null) goto L10;
            com.ss.android.lark.chat.message.menu.v2.popup.a r104 = r103.a();
            if (r104 == null) goto L10;
            i0.a(r104, false, null, 7);
        L10:
            int r105 = com.ss.android.lark.reaction.widget.panel.a.f439490a;
            Intrinsics.checkNotNullParameter(r101, "extraParams");
            Statistics.sendEvent("public_reaction_panel_select_click", r101.toJson());
        }

        @Override // com.ss.android.lark.newemoji.emoji_list.adapter.e
        public final void b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "reactionKey");
            Intrinsics.checkNotNullParameter(r101, "skinedKey");
            k2c.a.a().Wc(r100, r101);
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f415813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PopupMenuEmojiPanelContent f415814b;

        public b(DragPanelLayout r100, PopupMenuEmojiPanelContent r101) {
            this.f415813a = r100;
            this.f415814b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DragPanelLayout r100 = this.f415814b.f415810e;     // Catch: Throwable -> L11
            DragPanelLayout r101 = null;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("dragPanelLayout");     // Catch: Throwable -> L11
            r100 = null;
        L5:
            r100.setTranslationY(PopupMenuEmojiPanelContent.a(this.f415814b));     // Catch: Throwable -> L11
            DragPanelLayout r102 = this.f415814b.f415810e;     // Catch: Throwable -> L11
            if (r102 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("dragPanelLayout");     // Catch: Throwable -> L11
        L9:
            r101.setInterceptChildMove(true);     // Catch: Throwable -> L11
            return;
        L8:
            r101 = r102;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        }
    }

    public PopupMenuEmojiPanelContent(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PopupMenuEmojiPanelContent(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final d getMenuContext() {
        return this.f415808c;
    }

    public final o0 getOnReactionClickListener() {
        return this.f415809d;
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.IPopupMenuContent
    public PanelType getPanelType() {
        return this.f415806a;
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.IPopupMenuContent
    public IPopupMenuContent.ShadowTarget getShadowTarget() {
        return this.f415807b;
    }

    public static final float a(PopupMenuEmojiPanelContent r100) {
        DragPanelLayout r101 = r100.f415810e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragPanelLayout");
        r101 = null;
    L5:
        float r102 = r101.getHeight();
        if (r102 > 0.0f) goto L9;
        return 0.0f;
    L9:
        return RangesKt.coerceAtLeast(r102 - (0.46f * r102), 0.0f);
    }

    public final void setMenuContext(d r100) {
        this.f415808c = r100;
    }

    public final void setOnReactionClickListener(o0 r100) {
        this.f415809d = r100;
    }

    public PopupMenuEmojiPanelContent(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f415806a = PanelType.EMOJI;
        this.f415807b = IPopupMenuContent.ShadowTarget.NONE;
        l0 r103 = new PopupMenuEmojiPanelContent$panelDragLayoutChangeListener$1(this);
        Resources r104 = r100.getResources();
        boolean r105 = true;
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-1, RangesKt.coerceAtLeast((int) (WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).heightPixels * 0.91f), 1));
        r106.gravity = 80;
        setLayoutParams(r106);
        LayoutInflater.from(r100).inflate(R.layout.popup_menu_emoji_panel_content, this, true);
        DragPanelLayout r107 = (DragPanelLayout) findViewById(R.id.emoji_panel_container);
        this.f415810e = r107;
        Message.Type r108 = null;
        if (r107 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragPanelLayout");
        DragPanelLayout r109 = null;
    L6:
        r109.setListener(r103);
        if (r107 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("dragPanelLayout");
        r107 = null;
    L9:
        OneShotPreDrawListener.add(r107, new b(r107, this));
        FrameLayout r110 = (FrameLayout) findViewById(R.id.all_emoji_container);
        BuiltInEmojiPanelView r111 = new BuiltInEmojiPanelView(r100);
        r111.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        int r112 = UIUtils.dp2px(r100, 28.0f);
        int r113 = UIUtils.dp2px(r100, 50.0f);
        int r114 = UIUtils.dp2px(r100, 40.0f);
        int r115 = UIUtils.dp2px(r100, 16.0f);
        r111.f415727e = r112;
        r111.f415728f = r113;
        r111.f415729g = r114;
        r111.f415730h = r115;
        if (r111.getWidth() <= 0) goto L12;
        r111.e();
    L12:
        r111.setOnEmojiSelectListener(new a(this));
        d r116 = this.f415808c;
        if (r116 == null) goto L20;
        yya.a r117 = r116.f415883a;
        if (r117 == null) goto L20;
        v5b.c<?> r118 = r117.m();
        if (r118 == null) goto L20;
        r108 = r118.getType();
    L20:
        if (r108 == Message.Type.DOUBAO) goto L23;
        r105 = false;
    L23:
        r111.setLikeInFront(r105);
        r110.addView(r111);
        return;
    L5:
        r109 = r107;
        goto L6
    }

    public /* synthetic */ PopupMenuEmojiPanelContent(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static final void b(PopupMenuEmojiPanelContent r100, float r101, float r102, Function0 r103) {
        r100.getClass();
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{r101, r102});
        r104.setDuration(50);
        r104.setInterpolator(new AccelerateInterpolator());
        r104.addUpdateListener(new e(r100));
        r104.addListener(new f(r103));
        r104.start();
    }
}
