package com.larus.bmhome.view.screenmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.databinding.LarusLayoutCaseMenuBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0016\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/view/screenmenu/CaseListMenu;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Lcom/larus/bmhome/view/screenmenu/ICaseListMenu;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "menuBinding", "Lcom/larus/bmhome/databinding/LarusLayoutCaseMenuBinding;", "init", "", "setOnDeleteListener", "listener", "Lkotlin/Function0;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaseListMenu extends LinearLayoutCompat {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f317221b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusLayoutCaseMenuBinding f317222a;

    public CaseListMenu(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        d(r100, null);
    }

    public void setOnDeleteListener(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        LarusLayoutCaseMenuBinding r101 = this.f317222a;
        LarusLayoutCaseMenuBinding r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r101 = null;
    L5:
        r101.f311009b.setVisibility(0);
        LarusLayoutCaseMenuBinding r103 = this.f317222a;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L9:
        com.larus.utils.e1.d(r102.f311009b, new e(r100));
        return;
    L8:
        r102 = r103;
        goto L9
    }

    public CaseListMenu(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        d(r100, r101);
    }

    public final void d(Context r100, AttributeSet r101) {
        LayoutInflater.from(r100).inflate(R.layout.larus_layout_case_menu, this);
        FrameLayout r102 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.fl_menu_remove);
        if (r102 == null) goto L7;
        this.f317222a = new LarusLayoutCaseMenuBinding(this, r102);
        setOrientation(1);
        setDividerDrawable(AppCompatResources.getDrawable(r100, R.drawable.larus_common_menu_divider));
        setShowDividers(2);
        setBackgroundResource(R.drawable.larus_bg_conversation_menu);
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(R.id.fl_menu_remove)));
    }

    public CaseListMenu(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        d(r100, r101);
    }
}
