package com.larus.business.multitask_management.impl.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.business.multitask_management.impl.databinding.LarusMtmLayoutScreenMenuBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bJ\u0014\u0010\f\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/business/multitask_management/impl/view/MtmQuickAccessScreenMenu;", "Landroidx/appcompat/widget/LinearLayoutCompat;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "binding", "Lcom/larus/business/multitask_management/impl/databinding/LarusMtmLayoutScreenMenuBinding;", "bindPin", "", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "bindUnpin", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MtmQuickAccessScreenMenu extends LinearLayoutCompat {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f321136b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusMtmLayoutScreenMenuBinding f321137a;

    public MtmQuickAccessScreenMenu(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        View r101 = LayoutInflater.from(r100).inflate(R.layout.larus_mtm_layout_screen_menu, this, false);
        addView(r101);
        int r102 = R.id.mtm_menu_action;
        FrameLayout r103 = (FrameLayout) ViewBindings.findChildViewById(r101, R.id.mtm_menu_action);
        if (r103 == null) goto L11;
        r102 = R.id.mtm_menu_action_icon;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r101, R.id.mtm_menu_action_icon);
        if (r104 == null) goto L11;
        r102 = R.id.mtm_menu_action_text;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r101, R.id.mtm_menu_action_text);
        if (r105 == null) goto L11;
        this.f321137a = new LarusMtmLayoutScreenMenuBinding((LinearLayoutCompat) r101, r103, r104, r105);
        setOrientation(1);
        setBackgroundResource(v19.c.b(R.attr.larus_bg_conversation_menu, null, R.drawable.larus_bg_conversation_menu));
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    }
}
