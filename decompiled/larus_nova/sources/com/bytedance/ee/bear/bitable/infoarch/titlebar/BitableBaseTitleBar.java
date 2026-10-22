package com.bytedance.ee.bear.bitable.infoarch.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0014J\u0015\u0010\u0013\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J2\u0010\u0018\u001a\u00020\u00102\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\rJ(\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\rH\u0002R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/titlebar/BitableBaseTitleBar;", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "isDarkMode", "", "Ljava/lang/Boolean;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setThemeMode", "(Ljava/lang/Boolean;)V", "updateActionThemeMode", "updateActionIconTint", "stateListColor", "setIconMenus", "items", "", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "type", "Lcom/bytedance/ee/bear/browser/plugin/TitleBar$MenuType;", "actionHandler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "inApp", "addIconMenu", "icon", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BitableBaseTitleBar extends BaseTitleBar {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Boolean f213692x;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f213693a = null;

        static {
            int[] r100 = new int[TitleBar.MenuType.values().length];
            r100[TitleBar.MenuType.Left.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[TitleBar.MenuType.Right.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f213693a = r100;
        }
    }

    public BitableBaseTitleBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // com.bytedance.ee.bear.widgets.BaseTitleBar
    public final void j(int r100) {
        super.j(r100);
        m(this.f213692x);
    }

    public final void m(Boolean r100) {
        ViewGroup r101 = this.f240030e;
        int r102 = 0;
        if (r101 == null) goto L10;
        int r103 = r101.getChildCount();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L10;
        View r105 = r101.getChildAt(r104);
        if ((r105 instanceof TitleMenuItem) == false) goto L9;
        ((TitleMenuItem) r105).setThemeMode(r100);
    L9:
        r104 = r104 + 1;
    L10:
        LinearLayout r106 = this.f240031f;
        if (r106 == null) goto L18;
        int r107 = r106.getChildCount();
    L13:
        if (r102 >= r107) goto L25;
        View r108 = r106.getChildAt(r102);
        if ((r108 instanceof TitleMenuItem) == false) goto L17;
        ((TitleMenuItem) r108).setThemeMode(r100);
    L17:
        r102 = r102 + 1;
        goto L13
    L25:
        return;
    }

    public final void setThemeMode(Boolean r100) {
        this.f213692x = r100;
        if (r100 != null) goto L6;
        int r101 = R.color.facade_selector_icon_n1;
    L11:
        setLeftImageTint(r101);
        m(r100);
        return;
    L6:
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L9;
        r101 = R.color.b_icon_n1_night;
        goto L11
    L9:
        if (Intrinsics.areEqual(r100, Boolean.FALSE) == false) goto L14;
        r101 = R.color.b_icon_n1;
        goto L11
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public BitableBaseTitleBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, -1);
    }

    @Override // com.bytedance.ee.bear.widgets.BaseTitleBar, android.widget.LinearLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = getRightLayout().getMeasuredWidth();
        measureChild(getLeftLayout(), r100 - r102, r101);
    }

    public BitableBaseTitleBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }
}
