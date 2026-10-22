package com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import gv4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0016B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/uikit/FooterView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "footerDesc", "Landroid/widget/TextView;", "footerDivider", "Landroid/view/View;", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "setTopDividerVisible", "visible", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FooterView extends FrameLayout implements b<SimpleItemModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f213369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f213370b;

    public static final class a {
    }

    static {
    }

    public FooterView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setTopDividerVisible(boolean r100) {
        View r101 = this.f213370b;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public FooterView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.bitable_native_view_uikit_footer_layout, this, true);
        this.f213369a = (TextView) findViewById(R.id.footer_desc);
        this.f213370b = findViewById(R.id.footer_divider);
    }

    public final void a(SimpleItemModel r100, gv4.a r101) {
        String r102 = null;
        if (r100 == null) goto L5;
        String r103 = r100.getStyle();
    L7:
        if (Intrinsics.areEqual(r103, "footerHide") == false) goto L9;
        setVisibility(8);
        setMinimumHeight(0);
    L16:
        if (r100 == null) goto L18;
        String r104 = r100.getText();
    L20:
        if (TextUtils.isEmpty(r104) == false) goto L22;
        this.f213369a.setVisibility(8);
        return;
    L22:
        this.f213369a.setVisibility(0);
        TextView r105 = this.f213369a;
        if (r100 == null) goto L25;
        r102 = r100.getText();
    L25:
        r105.setText(r102);
        return;
    L18:
        r104 = null;
        goto L20
    L9:
        if (r100 == null) goto L11;
        String r106 = r100.getStyle();
    L13:
        if (Intrinsics.areEqual(r106, "footerAutoHeight") == false) goto L15;
        setVisibility(0);
        setMinimumHeight(0);
        goto L16
    L15:
        setVisibility(0);
        setMinimumHeight(n.d(40));
        goto L16
    L11:
        r106 = null;
        goto L13
    L5:
        r103 = null;
        goto L7
    }
}
