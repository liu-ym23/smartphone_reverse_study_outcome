package com.bytedance.ee.bear.bitable.infoarch.toolbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.infoarch.BaseLoadingContainer;
import com.bytedance.ee.bear.bitable.loading.ELoadingType;
import com.bytedance.ee.bear.bitable.panel.EPanelItemIcon;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.panel.e;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import pt4.b;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 <2\u00020\u0001:\u0001<B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'J\u0016\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0007H\u0002J\u001a\u0010-\u001a\u00020#2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010&\u001a\u00020'H\u0002J \u00100\u001a\u00020#2\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020/\u0018\u0001022\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u00103\u001a\u0002042\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u00105\u001a\u00020#2\u0006\u00106\u001a\u000207H\u0014J\b\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020;H\u0016R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/toolbar/BitableToolbarContainer;", "Lcom/bytedance/ee/bear/bitable/infoarch/BaseLoadingContainer;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "leftArrorFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getLeftArrorFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setLeftArrorFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "leftTextFromXml", "Landroid/widget/TextView;", "getLeftTextFromXml", "()Landroid/widget/TextView;", "setLeftTextFromXml", "(Landroid/widget/TextView;)V", "leftWrapperFromXml", "Landroid/widget/LinearLayout;", "getLeftWrapperFromXml", "()Landroid/widget/LinearLayout;", "setLeftWrapperFromXml", "(Landroid/widget/LinearLayout;)V", "menuContainerFromXml", "getMenuContainerFromXml", "setMenuContainerFromXml", SVGRenderEngine.CLIP_PATH, "Landroid/graphics/Path;", "clipAmount", "setData", "", "data", "Lcom/bytedance/ee/bear/bitable/infoarch/toolbar/ToolbarContainerModel;", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "onOffsetChanged", "absOffset", "headerHeight", "clipView", "amount", "setLeftText", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "setMenuItemList", "list", "", "createMenuItem", "Landroid/widget/ImageView;", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "getLoadingType", "Lcom/bytedance/ee/bear/bitable/loading/ELoadingType;", "interruptLoading", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableToolbarContainer extends BaseLoadingContainer {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppCompatImageView f213704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f213705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f213706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f213707g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Path f213708h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f213709i;

    public static final class a {
    }

    static {
    }

    public BitableToolbarContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BitableToolbarContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final AppCompatImageView getLeftArrorFromXml() {
        KeyEvent.Callback r100 = this.f213704d;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.left_arror);
        this.f213704d = (AppCompatImageView) r100;
    L6:
        return (AppCompatImageView) r100;
    }

    public final TextView getLeftTextFromXml() {
        KeyEvent.Callback r100 = this.f213705e;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.left_text);
        this.f213705e = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final LinearLayout getLeftWrapperFromXml() {
        KeyEvent.Callback r100 = this.f213706f;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.left_wrapper);
        this.f213706f = (LinearLayout) r100;
    L6:
        return (LinearLayout) r100;
    }

    public final LinearLayout getMenuContainerFromXml() {
        KeyEvent.Callback r100 = this.f213707g;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.menu_container);
        this.f213707g = (LinearLayout) r100;
    L6:
        return (LinearLayout) r100;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.BaseLoadingContainer, com.bytedance.ee.bear.bitable.loading.a
    public final boolean A30() {
        super.A30();
        return true;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.BaseLoadingContainer, com.bytedance.ee.bear.bitable.loading.a
    public ELoadingType getLoadingType() {
        return ELoadingType.TOOL_BAR;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f213708h.reset();
        this.f213708h.addRect(0.0f, this.f213709i, getWidth(), getHeight(), Path.Direction.CW);
        int r101 = r100.save();
        r100.clipPath(this.f213708h);
        super.dispatchDraw(r100);
        r100.restoreToCount(r101);
    }

    public final void setLeftArrorFromXml(AppCompatImageView r100) {
        this.f213704d = r100;
    }

    public final void setLeftTextFromXml(TextView r100) {
        this.f213705e = r100;
    }

    public final void setLeftWrapperFromXml(LinearLayout r100) {
        this.f213706f = r100;
    }

    public final void setMenuContainerFromXml(LinearLayout r100) {
        this.f213707g = r100;
    }

    public final void b(int r100, int r101) {
        int r102 = RangesKt.coerceAtLeast(r100 - r101, 0);
        if (this.f213709i == r102) goto L7;
        tt5.a.h("BitableToolbarContainer", "setClipAmount>>> amount" + r102);
        this.f213709i = r102;
        invalidate();
        return;
    }

    public final void c(ToolbarContainerModel r100, gv4.a r101) {
        Intrinsics.checkNotNullParameter(r101, "handler");
        ArrayList<SimpleItemModel> r102 = null;
        if (r100 == null) goto L5;
        SimpleItemModel r103 = r100.getStat();
    L6:
        getLeftArrorFromXml().setVisibility(8);
        if (r103 == null) goto L9;
        String r104 = r103.getText();
    L11:
        if (TextUtils.isEmpty(r104) == false) goto L13;
        getLeftTextFromXml().setVisibility(8);
    L25:
        if (r100 == null) goto L27;
        r102 = r100.getToolMenu();
    L27:
        getMenuContainerFromXml().removeAllViews();
        if (r102 == null) goto L36;
        Iterator<T> r105 = r102.iterator();
    L31:
        if (r105.hasNext() == false) goto L36;
        SimpleItemModel r106 = (SimpleItemModel) r105.next();
        AppCompatImageView r107 = new AppCompatImageView(getContext());
        r107.setLayoutParams(new ViewGroup.MarginLayoutParams(n.d(42), n.d(32)));
        r107.setPadding(n.d(12), n.d(7), n.d(12), n.d(7));
        r107.setImageTintList(UDColorUtils.getColorStateList(r107.getContext(), R.color.icon_n2));
        getMenuContainerFromXml().addView(r107);
        Icon r108 = r106.getIcon();
        if (r108 == null) goto L35;
        e.i(r107, r108);
    L35:
        r107.setOnClickListener(new b(r101, r106));
    L36:
        a();
        return;
    L13:
        TextView r109 = getLeftTextFromXml();
        if (r103 == null) goto L16;
        String r110 = r103.getText();
    L17:
        r109.setText(r110);
        getLeftTextFromXml().setVisibility(0);
        if (r103 == null) goto L24;
        Icon r111 = r103.getIcon();
        if (r111 == null) goto L24;
        String r112 = r111.getUdKey();
        if (r112 == null) goto L24;
        getLeftArrorFromXml().setVisibility(0);
        getLeftArrorFromXml().setImageResource(EPanelItemIcon.getDrawableId(getLeftArrorFromXml().getContext(), r112));
    L24:
        getLeftWrapperFromXml().setOnClickListener(new pt4.a(r101, r103));
        goto L25
    L16:
        r110 = null;
        goto L17
    L9:
        r104 = null;
        goto L11
    L5:
        r103 = null;
        goto L6
    }

    public BitableToolbarContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f213708h = new Path();
        LayoutInflater.from(r100).inflate(R.layout.bitable_toolbar_container_layout, this, true);
    }

    public /* synthetic */ BitableToolbarContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
