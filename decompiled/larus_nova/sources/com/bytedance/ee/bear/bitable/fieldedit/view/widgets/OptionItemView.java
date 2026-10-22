package com.bytedance.ee.bear.bitable.fieldedit.view.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.widgets.t;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000bJ\u0014\u0010\u0016\u001a\u00020\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u0018J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u000bR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/widgets/OptionItemView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mDeletable", "", "wrapCustomContentView", "", "layoutRes", "customContentView", "Landroid/view/View;", "setSelected", "selected", "dispatchSetSelected", "setDeletable", "deletable", "setDeleteMenuClickEvent", "event", "Lkotlin/Function0;", "setDividerVisible", "visible", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OptionItemView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f211733a;

    public static final class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OptionItemView f211734c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f211735d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            if (this.f211734c.f211733a == false) goto L6;
            this.f211735d.invoke();
            return;
        }

        public a(OptionItemView r100, Function0<Unit> r101) {
            this.f211734c = r100;
            this.f211735d = r101;
        }
    }

    public OptionItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OptionItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSetSelected(boolean r100) {
    }

    public final void a(int r100) {
        View r101 = LayoutInflater.from(getContext()).inflate(r100, null);
        Intrinsics.checkNotNullParameter(r101, "customContentView");
        ViewGroup r102 = (ViewGroup) findViewById(R.id.custom_content_container);
        if (r102 == null) goto L6;
        r102.addView(r101, new LinearLayout.LayoutParams(-1, -1));
        return;
    }

    public final void setDeletable(boolean r100) {
        this.f211733a = r100;
        View r101 = findViewById(R.id.delete_menu);
        Resources r102 = getResources();
        if (r100 == false) goto L5;
        int r103 = R.color.colorful_red;
    L6:
        r101.setBackgroundColor(r102.getColor(r103));
        return;
    L5:
        r103 = R.color.icon_disable;
        goto L6
    }

    public final void setDeleteMenuClickEvent(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        findViewById(R.id.delete_menu).setOnClickListener(new a(this, r100));
    }

    public final void setDividerVisible(boolean r100) {
        View r101 = findViewById(R.id.divider);
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    @Override // android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        findViewById(R.id.operation_area).setSelected(r100);
        View r101 = findViewById(R.id.bottom_shadow);
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public OptionItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f211733a = true;
        LayoutInflater.from(r100).inflate(R.layout.bitable_field_edit_common_option_item, this);
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    }

    public /* synthetic */ OptionItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
