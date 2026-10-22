package com.bytedance.ee.bear.bitable.infoarch.titlebar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.bear.widgets.BadgeStyle;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 62\u00020\u0001:\u00016B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020$J\u0006\u0010(\u001a\u00020)J\u0010\u0010*\u001a\u00020)2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0015\u0010+\u001a\u00020)2\b\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0002\u0010,J\u000e\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020/J\u0010\u00100\u001a\u00020)2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0015\u00101\u001a\u00020)2\b\u00102\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u00103J\u0010\u00104\u001a\u00020)2\u0006\u00105\u001a\u00020$H\u0016R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0004\n\u0002\u0010%¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/titlebar/TitleMenuItem;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widgetTitleMenuImgFromXml", "Landroid/widget/ImageView;", "getWidgetTitleMenuImgFromXml", "()Landroid/widget/ImageView;", "setWidgetTitleMenuImgFromXml", "(Landroid/widget/ImageView;)V", "widgetTitleMenuBadgePointFromXml", "Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "getWidgetTitleMenuBadgePointFromXml", "()Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "setWidgetTitleMenuBadgePointFromXml", "(Lcom/larksuite/component/universe_design/badge/UDBadgeView;)V", "widgetTitleMenuBadgeNumFrameFromXml", "getWidgetTitleMenuBadgeNumFrameFromXml", "setWidgetTitleMenuBadgeNumFrameFromXml", "badgeStyle", "Lcom/bytedance/ee/bear/widgets/BadgeStyle;", "menuText", "Landroid/widget/TextView;", "menuImg", "menuItemBg", "Landroid/view/View;", "menuImgBg", "id", "", "isDarkMode", "", "Ljava/lang/Boolean;", "init", "enableTextMode", "removeBackground", "", "setId", "setThemeMode", "(Ljava/lang/Boolean;)V", "setIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "setBadgeStyle", "setBadge", "num", "(Ljava/lang/Integer;)V", "setEnabled", "enabled", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TitleMenuItem extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f213694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UDBadgeView f213695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public UDBadgeView f213696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BadgeStyle f213697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f213698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f213699f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f213700g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f213701h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f213702i;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f213703a = null;

        static {
            int[] r100 = new int[BadgeStyle.values().length];
            r100[BadgeStyle.point.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[BadgeStyle.mute.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[BadgeStyle.num.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f213703a = r100;
        }
    }

    static {
    }

    public TitleMenuItem(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TitleMenuItem(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setId(String r100) {
    }

    public final UDBadgeView getWidgetTitleMenuBadgeNumFrameFromXml() {
        KeyEvent.Callback r100 = this.f213696c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.widgetTitleMenuBadgeNumFrame);
        this.f213696c = (UDBadgeView) r100;
    L6:
        return (UDBadgeView) r100;
    }

    public final UDBadgeView getWidgetTitleMenuBadgePointFromXml() {
        KeyEvent.Callback r100 = this.f213695b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.widgetTitleMenuBadgePoint);
        this.f213695b = (UDBadgeView) r100;
    L6:
        return (UDBadgeView) r100;
    }

    public final ImageView getWidgetTitleMenuImgFromXml() {
        KeyEvent.Callback r100 = this.f213694a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.widgetTitleMenuImg);
        this.f213694a = (ImageView) r100;
    L6:
        return (ImageView) r100;
    }

    public final void setBadge(Integer r100) {
        if (r100 == null) goto L24;
        int r101 = r100.intValue();
        BadgeStyle r102 = this.f213697d;
        int r103 = b.f213703a[r102.ordinal()];
        int r104 = 0;
        if (r103 != 1) goto L6;
        UDBadgeView r105 = getWidgetTitleMenuBadgePointFromXml();
        if (r101 > 0) goto L22;
        r104 = 8;
    L22:
        r105.setVisibility(r104);
        getWidgetTitleMenuBadgeNumFrameFromXml().setVisibility(8);
        return;
    L6:
        if (r103 == 2) goto L15;
        if (r103 == 3) goto L11;
        getWidgetTitleMenuBadgePointFromXml().setVisibility(8);
        getWidgetTitleMenuBadgeNumFrameFromXml().setVisibility(8);
        return;
    L11:
        if (r100.intValue() <= 0) goto L13;
        getWidgetTitleMenuBadgePointFromXml().setVisibility(8);
        getWidgetTitleMenuBadgeNumFrameFromXml().setVisibility(0);
        getWidgetTitleMenuBadgeNumFrameFromXml().setBadgeColorRes(R.color.function_danger_500);
        getWidgetTitleMenuBadgeNumFrameFromXml().setText(r100.toString());
        getWidgetTitleMenuBadgeNumFrameFromXml().a();
        return;
    L13:
        getWidgetTitleMenuBadgePointFromXml().setVisibility(8);
        getWidgetTitleMenuBadgeNumFrameFromXml().setVisibility(8);
        return;
    L15:
        if (r100.intValue() <= 0) goto L17;
        getWidgetTitleMenuBadgePointFromXml().setVisibility(8);
        getWidgetTitleMenuBadgeNumFrameFromXml().setVisibility(0);
        getWidgetTitleMenuBadgeNumFrameFromXml().setBadgeColorRes(R.color.icon_disable);
        getWidgetTitleMenuBadgeNumFrameFromXml().setText(r100.toString());
        getWidgetTitleMenuBadgeNumFrameFromXml().a();
        return;
    L17:
        getWidgetTitleMenuBadgePointFromXml().setVisibility(8);
        getWidgetTitleMenuBadgeNumFrameFromXml().setVisibility(8);
        return;
    }

    public final void setBadgeStyle(BadgeStyle r100) {
        if (r100 == null) goto L5;
        this.f213697d = r100;
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        getWidgetTitleMenuImgFromXml().setEnabled(r100);
    }

    public final void setIcon(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        getWidgetTitleMenuImgFromXml().setBackground(r100);
    }

    public final void setThemeMode(Boolean r100) {
        if (Intrinsics.areEqual(this.f213702i, r100) == false) goto L5;
        return;
    L5:
        this.f213702i = r100;
        if (r100 != null) goto L20;
        TextView r101 = this.f213698e;
        if (r101 == null) goto L10;
        r101.setTextColor(UDColorUtils.getColor(getContext(), R.color.text_title));
    L10:
        ImageView r102 = this.f213699f;
        if (r102 == null) goto L13;
        r102.setBackgroundTintList(UDColorUtils.getColorStateList(getContext(), R.color.facade_selector_icon_n1));
    L13:
        View r103 = this.f213700g;
        if (r103 == null) goto L16;
        r103.setBackgroundTintList(UDColorUtils.getColorStateList(getContext(), R.color.ud_N900_05));
    L16:
        View r104 = this.f213701h;
        if (r104 == null) goto L46;
        r104.setBackgroundColor(UDColorUtils.getColor(getContext(), R.color.ud_N900_05));
        return;
    L46:
        return;
    L20:
        if (r100.booleanValue() == false) goto L33;
        TextView r105 = this.f213698e;
        if (r105 == null) goto L24;
        r105.setTextColor(UDColorUtils.getColor(getContext(), R.color.b_text_title_night));
    L24:
        ImageView r106 = this.f213699f;
        if (r106 == null) goto L27;
        r106.setBackgroundTintList(UDColorUtils.getColorStateList(getContext(), R.color.b_icon_n1_night));
    L27:
        View r107 = this.f213700g;
        if (r107 == null) goto L30;
        r107.setBackgroundTintList(UDColorUtils.getColorStateList(getContext(), R.color.lkui_N900_05_night));
    L30:
        View r108 = this.f213701h;
        if (r108 == null) goto L48;
        r108.setBackgroundColor(UDColorUtils.getColor(getContext(), R.color.lkui_N900_05_night));
        return;
    L48:
        return;
    L33:
        TextView r109 = this.f213698e;
        if (r109 == null) goto L36;
        r109.setTextColor(UDColorUtils.getColor(getContext(), R.color.b_text_title));
    L36:
        ImageView r110 = this.f213699f;
        if (r110 == null) goto L39;
        r110.setBackgroundTintList(UDColorUtils.getColorStateList(getContext(), R.color.b_icon_n1));
    L39:
        View r111 = this.f213700g;
        if (r111 == null) goto L42;
        r111.setBackgroundTintList(UDColorUtils.getColorStateList(getContext(), R.color.lkui_N900_05));
    L42:
        View r112 = this.f213701h;
        if (r112 == null) goto L50;
        r112.setBackgroundColor(UDColorUtils.getColor(getContext(), R.color.lkui_N900_05));
        return;
    }

    public final void setWidgetTitleMenuBadgeNumFrameFromXml(UDBadgeView r100) {
        this.f213696c = r100;
    }

    public final void setWidgetTitleMenuBadgePointFromXml(UDBadgeView r100) {
        this.f213695b = r100;
    }

    public final void setWidgetTitleMenuImgFromXml(ImageView r100) {
        this.f213694a = r100;
    }

    public TitleMenuItem(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f213697d = BadgeStyle.point;
    }

    public /* synthetic */ TitleMenuItem(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
