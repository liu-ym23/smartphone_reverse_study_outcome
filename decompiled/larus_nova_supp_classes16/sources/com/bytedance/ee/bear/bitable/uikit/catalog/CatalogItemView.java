package com.bytedance.ee.bear.bitable.uikit.catalog;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.bitable.common.widgets.SyncIconImageView;
import com.bytedance.ee.bear.bitable.infoarch.SafeLinearLayout;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.panel.Style;
import com.bytedance.ee.bear.bitable.panel.e;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.bitable.uikit.drag.DragAreaState;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.util.ui.n;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 k2\u00020\u0001:\u0001kB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0007H\u0014J \u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020\u0007J\u001c\u0010E\u001a\u00020?2\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\b\u0010H\u001a\u00020?H\u0002J\u000e\u0010I\u001a\u00020?2\u0006\u0010@\u001a\u00020AJ\u0010\u0010J\u001a\u00020?2\u0006\u0010K\u001a\u00020\u0007H\u0002J\u000e\u0010L\u001a\u00020?2\u0006\u0010M\u001a\u000200J\u000e\u0010N\u001a\u00020?2\u0006\u0010/\u001a\u000200J\u000e\u0010O\u001a\u00020?2\u0006\u00101\u001a\u000202J\u000e\u0010P\u001a\u00020?2\u0006\u0010Q\u001a\u000200J\u001a\u0010R\u001a\u00020?2\b\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010D\u001a\u00020\u0007H\u0002J\u0019\u0010U\u001a\u00020?2\n\b\u0001\u0010V\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010WJ\u0012\u0010X\u001a\u00020?2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0002J\u0019\u0010[\u001a\u00020?2\n\b\u0001\u0010\\\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010WJ\u001a\u0010]\u001a\u00020?2\b\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010^\u001a\u000200H\u0002J\u0019\u0010_\u001a\u00020?2\n\b\u0001\u0010\\\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010WJ&\u0010`\u001a\u00020?2\b\u0010Y\u001a\u0004\u0018\u00010Z2\b\u0010a\u001a\u0004\u0018\u00010T2\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\u0010\u0010b\u001a\u00020?2\u0006\u0010c\u001a\u00020dH\u0002J\u0010\u0010e\u001a\u00020?2\u0006\u0010c\u001a\u00020dH\u0002J\u000e\u0010f\u001a\u00020?2\u0006\u0010@\u001a\u00020AJ\u0018\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u0002002\u0006\u0010j\u001a\u000200H\u0002R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u0004\u0018\u00010\u00018FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001bR\u001e\u0010*\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010\u001bR\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b7\u00108¨\u0006l"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "catalogWrapperFromXml", "Lcom/bytedance/ee/bear/bitable/infoarch/SafeLinearLayout;", "getCatalogWrapperFromXml", "()Lcom/bytedance/ee/bear/bitable/infoarch/SafeLinearLayout;", "setCatalogWrapperFromXml", "(Lcom/bytedance/ee/bear/bitable/infoarch/SafeLinearLayout;)V", "leftIconFromXml", "Lcom/bytedance/ee/bear/bitable/common/widgets/SyncIconImageView;", "getLeftIconFromXml", "()Lcom/bytedance/ee/bear/bitable/common/widgets/SyncIconImageView;", "setLeftIconFromXml", "(Lcom/bytedance/ee/bear/bitable/common/widgets/SyncIconImageView;)V", "tipsIconFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getTipsIconFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setTipsIconFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "leftTextFromXml", "Landroid/widget/TextView;", "getLeftTextFromXml", "()Landroid/widget/TextView;", "setLeftTextFromXml", "(Landroid/widget/TextView;)V", "rightIconWrapperFromXml", "getRightIconWrapperFromXml", "()Landroid/widget/FrameLayout;", "setRightIconWrapperFromXml", "(Landroid/widget/FrameLayout;)V", "rightIconFromXml", "getRightIconFromXml", "setRightIconFromXml", "rightIconSecondaryFromXml", "getRightIconSecondaryFromXml", "setRightIconSecondaryFromXml", "treeLayoutParam", "Lcom/bytedance/ee/bear/bitable/uikit/drag/TreeLayoutParam;", "isDragging", "", "dragAreaState", "Lcom/bytedance/ee/bear/bitable/uikit/drag/DragAreaState;", "originViewOutlineProvider", "Landroid/view/ViewOutlineProvider;", "shadowHelper", "Lcom/bytedance/ee/bear/shadow/ShadowLayoutHelper;", "getShadowHelper", "()Lcom/bytedance/ee/bear/shadow/ShadowLayoutHelper;", "shadowHelper$delegate", "Lkotlin/Lazy;", "onCreateDrawableState", "", "extraSpace", "setData", "", "item", "Lcom/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemModel;", "actionHandler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "parentWidth", "setTableStatusTag", "tag", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "setMarginInfo", "updateLeftIconRotation", "setLeftMarginByLevel", "level", "adjustTheme", "whiteThene", "setDragState", "setDragAreaState", "toggleBackground", "isDrag", "setLeftText", "text", "", "setLeftTextColor", "colorRes", "(Ljava/lang/Integer;)V", "setLeftIcon", CustomHeaderConfig.Menu.Style.ICON_STYLE, "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "setLeftIconTint", "tint", "setRightIcon", "isSelected", "setRightIconTint", "setRightSecondaryIcon", "id", "setRightIconListener", "listener", "Landroid/view/View$OnClickListener;", "setLeftIconListener", "startRotationLeftIcon", "getRotation", "", "enableCollapsed", "isCollapsed", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CatalogItemView extends FrameLayout {
    public static final int m = 0;
    public static final int n = 0;
    public static final int o = 0;
    public static final int p = 0;
    public static final int q = 0;
    public static final int[] r = null;
    public static final int[] s = null;
    public static final int[] t = null;
    public SafeLinearLayout a;
    public SyncIconImageView b;
    public AppCompatImageView c;
    public TextView d;
    public FrameLayout e;
    public AppCompatImageView f;
    public AppCompatImageView g;
    public final hv4.b h;
    public boolean i;
    public DragAreaState j;
    public final ViewOutlineProvider k;
    public final Lazy l;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ gv4.a b;
        public final /* synthetic */ CatalogItemModel c;

        public b(String r1, gv4.a r2, CatalogItemModel r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            if (TextUtils.equals(this.a, "ToggleFolder") == false) goto L7;
            gv4.a r5 = this.b;
            if (r5 == null) goto L11;
            r5.a(new ToggleFolderAction(this.c.getId(), !this.c.isCollapsed()));
            return;
        L11:
            return;
        L7:
            gv4.a r6 = this.b;
            if (r6 == null) goto L13;
            r6.a(new Action(this.c.getId(), this.a));
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ gv4.a a;
        public final /* synthetic */ CatalogItemModel b;

        public c(gv4.a r1, CatalogItemModel r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            gv4.a r5 = this.a;
            if (r5 == null) goto L10;
            String r1 = this.b.getId();
            Icon r2 = this.b.getRightIcon();
            if (r2 == null) goto L7;
            String r3 = r2.getClickAction();
        L8:
            r5.a(new Action(r1, r3));
            return;
        L7:
            r3 = null;
            goto L8
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ CatalogItemModel a;
        public final /* synthetic */ gv4.a b;

        public d(CatalogItemModel r1, gv4.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            if (TextUtils.equals(this.a.getClickAction(), "ToggleFolder") == false) goto L7;
            gv4.a r5 = this.b;
            if (r5 == null) goto L11;
            r5.a(new ToggleFolderAction(this.a.getId(), !this.a.isCollapsed()));
            return;
        L11:
            return;
        L7:
            gv4.a r6 = this.b;
            if (r6 == null) goto L13;
            r6.a(new Action(this.a.getId(), this.a.getClickAction()));
            return;
        }
    }

    public CatalogItemView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CatalogItemView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    static {
        m = UIUtils.dp2px(LarkContext.getApplication(), 16.0f);
        n = UIUtils.dp2px(LarkContext.getApplication(), 8.0f);
        o = UIUtils.dp2px(LarkContext.getApplication(), 4.0f);
        p = UIUtils.getColor(LarkContext.getApplication(), 2131100631);
        q = UIUtils.dp2px(LarkContext.getApplication(), 2.0f);
        r = new int[]{2130974259};
        s = new int[]{2130974258};
        t = new int[]{2130974257};
    }

    private final jm5.a getShadowHelper() {
        return (jm5.a) this.l.getValue();
    }

    public final SafeLinearLayout getCatalogWrapperFromXml() {
        SafeLinearLayout r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131365283);
        this.a = r0;
    L6:
        return r0;
    }

    public final SyncIconImageView getLeftIconFromXml() {
        SyncIconImageView r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131377773);
        this.b = r0;
    L6:
        return r0;
    }

    public final TextView getLeftTextFromXml() {
        KeyEvent.Callback r0 = this.d;
        if (r0 != null) goto L6;
        r0 = findViewById(2131377814);
        this.d = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    public final AppCompatImageView getRightIconFromXml() {
        AppCompatImageView r0 = this.f;
        if (r0 != null) goto L6;
        r0 = findViewById(2131384584);
        this.f = r0;
    L6:
        return r0;
    }

    public final AppCompatImageView getRightIconSecondaryFromXml() {
        AppCompatImageView r0 = this.g;
        if (r0 != null) goto L6;
        r0 = findViewById(2131384592);
        this.g = r0;
    L6:
        return r0;
    }

    public final FrameLayout getRightIconWrapperFromXml() {
        KeyEvent.Callback r0 = this.e;
        if (r0 != null) goto L6;
        r0 = findViewById(2131384594);
        this.e = (FrameLayout) r0;
    L6:
        return (FrameLayout) r0;
    }

    public final AppCompatImageView getTipsIconFromXml() {
        AppCompatImageView r0 = this.c;
        if (r0 != null) goto L6;
        r0 = findViewById(2131388760);
        this.c = r0;
    L6:
        return r0;
    }

    private final void setLeftIcon(Icon r2) {
        e.n(getLeftIconFromXml(), r2);
    }

    private final void setLeftIconListener(View.OnClickListener r2) {
        SyncIconImageView r0 = getLeftIconFromXml();
        if (r0 == null) goto L6;
        r0.setOnClickListener(r2);
        return;
    }

    private final void setLeftIconTint(Integer r3) {
        if (r3 == null) goto L7;
        r3.intValue();
        SyncIconImageView r0 = getLeftIconFromXml();
        if (r0 == null) goto L8;
        r0.setImageTintList(AppCompatResources.getColorStateList(getContext(), r3.intValue()));
        return;
    L8:
        return;
    }

    private final void setLeftMarginByLevel(int r5) {
        if (r5 > 0) goto L4;
        return;
    L4:
        hv4.b r0 = this.h;
        int r1 = r0.a + (r0.b * Math.max(0, r5 - 1));
        m.s(this, r1, false);
        tt5.a.h("CatalogItemView", "setLeftMarginByLevel level:" + r5 + " marginLeft:" + r1);
    }

    private final void setLeftTextColor(Integer r3) {
        if (r3 == null) goto L5;
        r3.intValue();
        getLeftTextFromXml().setTextColor(AppCompatResources.getColorStateList(getContext(), r3.intValue()));
        return;
    }

    private final void setRightIconListener(View.OnClickListener r2) {
        FrameLayout r0 = getRightIconWrapperFromXml();
        if (r0 == null) goto L6;
        r0.setOnClickListener(r2);
        return;
    }

    private final void setRightIconTint(Integer r3) {
        if (r3 == null) goto L5;
        r3.intValue();
        getRightIconFromXml().setImageTintList(AppCompatResources.getColorStateList(getContext(), r3.intValue()));
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int r3) {
        int[] r4 = super.onCreateDrawableState(r3 + 1);
        DragAreaState r0 = this.j;
        if (r0 != DragAreaState.PARENT_SELECTED) goto L6;
        FrameLayout.mergeDrawableStates(r4, s);
    L11:
        Intrinsics.checkNotNull(r4);
        return r4;
    L6:
        if (r0 != DragAreaState.ERROR) goto L9;
        FrameLayout.mergeDrawableStates(r4, t);
        goto L11
    L9:
        if (this.i == false) goto L11;
        FrameLayout.mergeDrawableStates(r4, r);
        goto L11
    }

    public final void setCatalogWrapperFromXml(SafeLinearLayout r1) {
        this.a = r1;
    }

    public final void setDragAreaState(DragAreaState r2) {
        Intrinsics.checkNotNullParameter(r2, "dragAreaState");
        if (this.j != r2) goto L5;
        return;
    L5:
        this.j = r2;
        refreshDrawableState();
    }

    public final void setDragState(boolean r10) {
        if (this.i != r10) goto L5;
        return;
    L5:
        this.i = r10;
        if (r10 == false) goto L12;
        jm5.a r11 = getShadowHelper();
        int r0 = -o;
        View r1 = (View) r11.I.get();
        if (r1 == null) goto L11;
        r11.P = 0;
        r11.Q = 0;
        r11.R = 0;
        r11.S = r0;
        r1.invalidateOutline();
    L11:
        getShadowHelper().b(n, 0, q, p, 1.0f);
    L15:
        refreshDrawableState();
        return;
    L12:
        SafeLinearLayout r12 = getCatalogWrapperFromXml();
        if (r12 == null) goto L15;
        r12.setOutlineProvider(this.k);
        goto L15
    }

    public final void setLeftIconFromXml(SyncIconImageView r1) {
        this.b = r1;
    }

    public final void setLeftTextFromXml(TextView r1) {
        this.d = r1;
    }

    public final void setRightIconFromXml(AppCompatImageView r1) {
        this.f = r1;
    }

    public final void setRightIconSecondaryFromXml(AppCompatImageView r1) {
        this.g = r1;
    }

    public final void setRightIconWrapperFromXml(FrameLayout r1) {
        this.e = r1;
    }

    public final void setTipsIconFromXml(AppCompatImageView r1) {
        this.c = r1;
    }

    public CatalogItemView(final Context r2, final AttributeSet r3, final int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.h = new hv4.b();
        this.j = DragAreaState.NONE;
        this.l = LazyKt.lazy(new CatalogItemView$shadowHelper$2(r2, r3, r4, this));
        LayoutInflater.from(r2).inflate(2131558899, this, true);
        setClipChildren(false);
        this.k = getOutlineProvider();
    }

    public final void a(CatalogItemModel r17, gv4.a r18, int r19) {
        Intrinsics.checkNotNullParameter(r17, "item");
        m.x(this, r17.isSelected());
        String r4 = r17.getLeftText();
        com.bytedance.ee.bear.bitable.uikit.catalog.c r7 = null;
        boolean r8 = true;
        if (r4 == null) goto L38;
        float r10 = getLeftTextFromXml().getPaint().measureText(r4);
        if (r19 > 0) goto L8;
    L32:
        TextView r6 = getLeftTextFromXml();
        Intrinsics.checkNotNullParameter(r6, "view");
        r6.setText(r4);
        if (TextUtils.isEmpty(r4) == false) goto L35;
        int r5 = 8;
    L36:
        r6.setVisibility(r5);
        goto L38
    L35:
        r5 = 0;
        goto L36
    L8:
        if (((r19 - UIUtils.dp2px(LarkContext.getApplication(), 112.0f)) - r10) < 0.0f) goto L10;
        boolean r11 = true;
    L11:
        SyncIconImageView r12 = getLeftIconFromXml();
        if (r11 == false) goto L14;
        char r13 = 1;
    L15:
        Intrinsics.checkNotNullParameter(r12, "view");
        ViewGroup.LayoutParams r14 = r12.getLayoutParams();
        if ((r14 instanceof LinearLayout.LayoutParams) == false) goto L18;
        LinearLayout.LayoutParams r16 = (LinearLayout.LayoutParams) r14;
    L19:
        if (r16 == null) goto L27;
        if (r13 <= 1) goto L22;
        r16.gravity = 48;
        r16.topMargin = n.l(r12.getContext(), 2131166203);
    L23:
        Context r110 = r12.getContext();
        if (r110 == null) goto L26;
        r16.width = a08.b.b(n.c(16.0f), r110);
        r16.height = a08.b.b(n.c(16.0f), r110);
    L26:
        r12.setLayoutParams(r16);
        goto L27
    L22:
        r16.gravity = 16;
        r16.topMargin = 0;
    L27:
        AppCompatImageView r9 = getTipsIconFromXml();
        if (r11 == false) goto L30;
        float r111 = 1.0f;
    L31:
        r9.setTranslationY(UIHelper.dp2px(r111));
        goto L32
    L30:
        r111 = -1.0f;
        goto L31
    L18:
        r16 = null;
        goto L19
    L14:
        r13 = 2;
        goto L15
    L10:
        r11 = false;
    L38:
        if (r17.isSelected() == false) goto L40;
        Style r20 = Style.Select;
    L41:
        setLeftTextColor(e.g(Integer.valueOf(r20.getValue())));
        setLeftIcon(r17.getLeftIcon());
        Intrinsics.checkNotNullParameter(r17, "item");
        SyncIconImageView r3 = getLeftIconFromXml();
        if (r3 == null) goto L49;
        boolean r21 = r17.getEnableCollapsed();
        boolean r22 = r17.isCollapsed();
        if (r21 == false) goto L47;
        if (r22 == false) goto L47;
        float r23 = -90.0f;
    L48:
        r3.setRotation(r23);
    L47:
        r23 = 0.0f;
    L49:
        SyncIconImageView r24 = getLeftIconFromXml();
        if (r24 == null) goto L52;
        r24.setColorFilter(null);
    L52:
        Icon r26 = r17.getLeftIcon();
        if (r26 == null) goto L55;
        String r27 = r26.getUrl();
    L57:
        if (TextUtils.isEmpty(r27) == false) goto L64;
        if (r17.isSelected() == false) goto L61;
        Style r28 = Style.Select;
    L62:
        setLeftIconTint(e.f(Integer.valueOf(r28.getValue())));
    L68:
        Icon r29 = r17.getLeftIcon();
        if (r29 == null) goto L73;
        String r30 = r29.getClickAction();
        if (r30 == null) goto L73;
        setLeftIconListener(new b(r30, r18, r17));
    L73:
        Integer r31 = r17.getLeftStyle();
        if (r31 == null) goto L76;
        r31.intValue();
        setLeftTextColor(e.g(r17.getLeftStyle()));
    L76:
        Icon r32 = r17.getRightIcon();
        boolean r33 = r17.isSelected();
        if (r32 == null) goto L79;
        String r34 = r32.getVisibleType();
    L81:
        if (TextUtils.equals(r34, "VisibleForSelected") == true) goto L84;
        r33 = true;
    L84:
        FrameLayout r36 = getRightIconWrapperFromXml();
        if (r36 == null) goto L91;
        if (r32 == null) goto L89;
        if (r33 == false) goto L89;
        int r37 = 0;
    L90:
        r36.setVisibility(r37);
    L89:
        r37 = 8;
    L91:
        e.n(getRightIconFromXml(), r32);
        Icon r38 = r17.getRightSecondaryIcon();
        String r39 = r17.getId();
        AppCompatImageView r40 = getRightIconSecondaryFromXml();
        if (r40 == null) goto L97;
        if (r38 == null) goto L95;
        int r41 = 0;
    L96:
        r40.setVisibility(r41);
        goto L97
    L95:
        r41 = 8;
    L97:
        e.n(getRightIconSecondaryFromXml(), r38);
        AppCompatImageView r42 = getRightIconSecondaryFromXml();
        if (r42 == null) goto L100;
        r42.setOnClickListener(new com.bytedance.ee.bear.bitable.uikit.catalog.b(r18, r39, r38));
    L100:
        SimpleItemModel r43 = r17.getBlockStatusTag();
        AppCompatImageView r44 = getTipsIconFromXml();
        if (r43 == null) goto L103;
        Icon r46 = r43.getIcon();
    L104:
        e.n(r44, r46);
        com.bytedance.ee.bear.bitable.uikit.catalog.c r47 = new com.bytedance.ee.bear.bitable.uikit.catalog.c(r18, r43);
        AppCompatImageView r48 = getTipsIconFromXml();
        if (r43 == null) goto L107;
        String r49 = r43.getClickAction();
    L108:
        if (r49 != null) goto L110;
    L113:
        if (r8 == true) goto L116;
        r7 = r47;
    L116:
        r48.setOnClickListener(r7);
        ViewGroup.LayoutParams r50 = getLayoutParams();
        if ((r50 instanceof ViewGroup.MarginLayoutParams) == false) goto L119;
        int r51 = m;
        ((ViewGroup.MarginLayoutParams) r50).setMargins(r51, 0, r51, 0);
        setLayoutParams(r50);
    L119:
        setLeftMarginByLevel(r17.getLevel());
        setRightIconListener(new c(r18, r17));
        setOnClickListener(new d(r17, r18));
        return;
    L110:
        if (r49.length() == 0) goto L113;
        r8 = false;
        goto L113
    L107:
        r49 = null;
        goto L108
    L103:
        r46 = null;
        goto L104
    L79:
        r34 = null;
        goto L81
    L61:
        r28 = Style.Desc;
        goto L62
    L64:
        if (r17.isSelected() == true) goto L68;
        SyncIconImageView r52 = getLeftIconFromXml();
        if (r52 == null) goto L68;
        ColorMatrix r53 = new ColorMatrix();
        r53.setSaturation(0.0f);
        r52.setColorFilter(new ColorMatrixColorFilter(r53));
        goto L68
    L55:
        r27 = null;
        goto L57
    L40:
        r20 = Style.Normal;
        goto L41
    }

    public /* synthetic */ CatalogItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
