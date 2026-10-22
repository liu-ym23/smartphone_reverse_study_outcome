package com.ss.android.lark.chat.message.menu.v2.popup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larksuite.framework.utils.UIUtils;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.chat.message.menu.v2.PanelType;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002@AB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010/\u001a\u000200H\u0002J\u0006\u00101\u001a\u000202J\u0010\u00103\u001a\u0002002\u0006\u00104\u001a\u00020$H\u0002J\u0012\u00105\u001a\u0002002\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0010\u00108\u001a\u0002002\u0006\u00109\u001a\u00020:H\u0014J\u0010\u0010;\u001a\u0002002\u0006\u00109\u001a\u00020:H\u0002J \u0010<\u001a\u0002002\u0006\u00109\u001a\u00020:2\u0006\u0010=\u001a\u0002072\u0006\u0010>\u001a\u00020?H\u0002R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContentContainer;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "anchorPoint", "Landroid/graphics/Point;", "getAnchorPoint", "()Landroid/graphics/Point;", "setAnchorPoint", "(Landroid/graphics/Point;)V", "anchorRect", "Landroid/graphics/Rect;", "getAnchorRect", "()Landroid/graphics/Rect;", "setAnchorRect", "(Landroid/graphics/Rect;)V", "anchorStyle", "Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContentContainer$AnchorStyle;", "getAnchorStyle", "()Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContentContainer$AnchorStyle;", "setAnchorStyle", "(Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContentContainer$AnchorStyle;)V", "anchorAlignment", "Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContentContainer$AnchorAlignment;", "getAnchorAlignment", "()Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContentContainer$AnchorAlignment;", "setAnchorAlignment", "(Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContentContainer$AnchorAlignment;)V", "shadowColor", "isShadowEnabled", "", "shadowPaint", "Landroid/graphics/Paint;", "getShadowPaint", "()Landroid/graphics/Paint;", "shadowPaint$delegate", "Lkotlin/Lazy;", SVGRenderEngine.RECT, "Landroid/graphics/RectF;", "roundRadius", "", "setupPadding", "", "getPanelType", "Lcom/ss/android/lark/chat/message/menu/v2/PanelType;", "setShadowEnabled", "enable", "addView", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "drawShadow", "drawShadowForView", "view", "selfLoc", "", "AnchorStyle", "AnchorAlignment", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopupMenuContentContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Point f415792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Rect f415793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnchorStyle f415794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AnchorAlignment f415795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f415796e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f415797f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f415798g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f415799h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f415800i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContentContainer$AnchorAlignment;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AnchorAlignment extends Enum<AnchorAlignment> {
        public static final AnchorAlignment LEFT = null;
        public static final AnchorAlignment RIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AnchorAlignment[] f415801a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415802b = null;

        public static EnumEntries<AnchorAlignment> getEntries() {
            return f415802b;
        }

        static {
            AnchorAlignment r100 = new AnchorAlignment("LEFT", 0);
            LEFT = r100;
            AnchorAlignment r101 = new AnchorAlignment("RIGHT", 1);
            RIGHT = r101;
            AnchorAlignment[] r102 = {r100, r101};
            f415801a = r102;
            f415802b = EnumEntriesKt.enumEntries(r102);
        }

        public static AnchorAlignment[] values() {
            return (AnchorAlignment[]) f415801a.clone();
        }

        public static AnchorAlignment valueOf(String r100) {
            return (AnchorAlignment) r27.a.a(AnchorAlignment.class, r100);
        }

        public AnchorAlignment(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContentContainer$AnchorStyle;", "", "<init>", "(Ljava/lang/String;I)V", "OVERLAY", "ASIDE", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AnchorStyle extends Enum<AnchorStyle> {
        public static final AnchorStyle ASIDE = null;
        public static final AnchorStyle OVERLAY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AnchorStyle[] f415803a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415804b = null;

        public static EnumEntries<AnchorStyle> getEntries() {
            return f415804b;
        }

        static {
            AnchorStyle r100 = new AnchorStyle("OVERLAY", 0);
            OVERLAY = r100;
            AnchorStyle r101 = new AnchorStyle("ASIDE", 1);
            ASIDE = r101;
            AnchorStyle[] r102 = {r100, r101};
            f415803a = r102;
            f415804b = EnumEntriesKt.enumEntries(r102);
        }

        public static AnchorStyle[] values() {
            return (AnchorStyle[]) f415803a.clone();
        }

        public static AnchorStyle valueOf(String r100) {
            return (AnchorStyle) r27.a.a(AnchorStyle.class, r100);
        }

        public AnchorStyle(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f415805a = null;

        static {
            int[] r100 = new int[IPopupMenuContent.ShadowTarget.values().length];
            r100[IPopupMenuContent.ShadowTarget.SELF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[IPopupMenuContent.ShadowTarget.CHILD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[IPopupMenuContent.ShadowTarget.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f415805a = r100;
        }
    }

    public PopupMenuContentContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PopupMenuContentContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final Paint getShadowPaint() {
        return (Paint) this.f415798g.getValue();
    }

    public final PanelType getPanelType() {
        if (getChildCount() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        KeyEvent.Callback r101 = getChildAt(0);
        if ((r101 instanceof IPopupMenuContent) == false) goto L12;
        IPopupMenuContent r102 = (IPopupMenuContent) r101;
    L13:
        if (r102 == null) goto L17;
        PanelType r103 = r102.getPanelType();
        if (r103 == null) goto L17;
        return r103;
    L17:
        return PanelType.ACTION;
    L12:
        r102 = null;
        goto L13
    L8:
        return PanelType.ACTION;
    L5:
        r100 = false;
        goto L6
    }

    public final AnchorAlignment getAnchorAlignment() {
        return this.f415795d;
    }

    public final Point getAnchorPoint() {
        return this.f415792a;
    }

    public final Rect getAnchorRect() {
        return this.f415793b;
    }

    public final AnchorStyle getAnchorStyle() {
        return this.f415794c;
    }

    private final void setShadowEnabled(boolean r100) {
        this.f415797f = r100;
        if (r100 == false) goto L5;
        int r101 = UIUtils.dp2px(getContext(), 27.0f);
    L6:
        setPadding(r101, r101, r101, r101);
        return;
    L5:
        r101 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final void addView(View r100) {
        super.addView(r100);
        if ((r100 instanceof IPopupMenuContent) == true) goto L5;
        return;
    L5:
        if (((IPopupMenuContent) r100).getShadowTarget() == IPopupMenuContent.ShadowTarget.NONE) goto L7;
        boolean r101 = true;
    L8:
        setShadowEnabled(r101);
        return;
    L7:
        r101 = false;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (this.f415797f == false) goto L28;
        int[] r100 = new int[2];
        getLocationInWindow(r100);
        int r101 = getChildCount();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L28;
        View r103 = getChildAt(r102);
        if ((r103 instanceof ViewGroup) == false) goto L9;
        ViewGroup r104 = (ViewGroup) r103;
    L10:
        if (r104 == null) goto L27;
        if ((r104 instanceof IPopupMenuContent) == false) goto L27;
        IPopupMenuContent.ShadowTarget r105 = ((IPopupMenuContent) r104).getShadowTarget();
        int r106 = a.f415805a[r105.ordinal()];
        if (r106 == 1) goto L26;
        if (r106 != 2) goto L19;
        int r107 = r104.getChildCount();
        int r108 = 0;
    L24:
        if (r108 >= r107) goto L27;
        View r109 = r104.getChildAt(r108);
        Intrinsics.checkNotNull(r109);
        a(r110, r109, r100);
        r108 = r108 + 1;
        goto L24
    L19:
        if (r106 == 3) goto L27;
        throw new NoWhenBranchMatchedException();
    L26:
        a(r110, r104, r100);
    L27:
        r102 = r102 + 1;
        goto L5
    L9:
        r104 = null;
    L28:
        super.dispatchDraw(r110);
    }

    public final void setAnchorAlignment(AnchorAlignment r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f415795d = r100;
    }

    public final void setAnchorPoint(Point r100) {
        this.f415792a = r100;
    }

    public final void setAnchorRect(Rect r100) {
        this.f415793b = r100;
    }

    public final void setAnchorStyle(AnchorStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f415794c = r100;
    }

    public PopupMenuContentContainer(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f415794c = AnchorStyle.ASIDE;
        this.f415795d = AnchorAlignment.LEFT;
        this.f415796e = 637534208;
        this.f415797f = true;
        this.f415798g = LazyKt.lazy(new PopupMenuContentContainer$shadowPaint$2(r100, this));
        this.f415799h = new RectF();
        this.f415800i = UIUtils.dp2px(r100, 12.0f);
        if (this.f415797f == false) goto L5;
        int r103 = UIUtils.dp2px(getContext(), 27.0f);
    L6:
        setPadding(r103, r103, r103, r103);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public final void a(Canvas r100, View r101, int[] r102) {
        int[] r103 = new int[2];
        r101.getLocationInWindow(r103);
        int r104 = r103[0] - r102[0];
        float r105 = r104;
        float r106 = r103[1] - r102[1];
        this.f415799h.set(r105, r106, r101.getMeasuredWidth() + r105, r101.getMeasuredHeight() + r106);
        RectF r107 = this.f415799h;
        float r108 = this.f415800i;
        r100.drawRoundRect(r107, r108, r108, getShadowPaint());
    }

    public /* synthetic */ PopupMenuContentContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
