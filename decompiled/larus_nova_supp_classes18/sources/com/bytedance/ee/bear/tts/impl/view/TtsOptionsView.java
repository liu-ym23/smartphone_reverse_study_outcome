package com.bytedance.ee.bear.tts.impl.view;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment;
import com.bytedance.ee.bear.content.common.morepanel.CommonPanelAdapter;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\"\u0010\u0010\u001a\u00020\r2\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014J\u001a\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020\rH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/tts/impl/view/TtsOptionsView;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseUDBottomSheetDialogFragment;", "<init>", "()V", "adapter", "Lcom/bytedance/ee/bear/content/common/morepanel/CommonPanelAdapter;", "getAdapter", "()Lcom/bytedance/ee/bear/content/common/morepanel/CommonPanelAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setOnItemClickListener", "", "listener", "Lcom/bytedance/ee/bear/content/common/morepanel/OnItemClickListener;", "updateData", WikiFolderPushPlugin.DATA, "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/content/common/morepanel/CommonMorePanelItemData;", "Lkotlin/collections/ArrayList;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "getCornerRadius", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseUDBottomSheetDialogFragment$CornerRadius;", "getMaxHeightRate", "", "createOptionsView", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsOptionsView extends BaseUDBottomSheetDialogFragment {
    public static final int u = 0;
    public final Lazy t;

    public static final class a {
    }

    public final float ha0() {
        return 0.5f;
    }

    static {
        u = LarkContext.getApplication().getResources().getDimensionPixelSize(2131169387);
    }

    public TtsOptionsView() {
        super("TtsOptionsView");
        this.t = LazyKt.lazy(TtsOptionsView$adapter$2.INSTANCE);
    }

    public final BaseUDBottomSheetDialogFragment.a ga0() {
        int r0 = BaseUDBottomSheetDialogFragment.a.d;
        return BaseUDBottomSheetDialogFragment.a.a.a(u);
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Context r0 = getContext();
        if (r0 == null) goto L5;
        int r1 = UIUtils.getColor(r0, 2131100557);
    L6:
        pa0(r1);
        return;
    L5:
        r1 = -1;
        goto L6
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment*/.onConfigurationChanged(r2);
        tt5.a.h("TtsOptionsView", "onConfigurationChanged, dismiss self.");
        dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L12;
        d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void ra0(hw4.d r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        CommonPanelAdapter r1 = (CommonPanelAdapter) this.t.getValue();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        r1.c = r3;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        FrameLayout r6 = fa0();
        if (r6 != null) goto L5;
        tt5.a.d("TtsOptionsView", "createOptionsView, contentContainer not found.");
        return;
    L5:
        RecyclerView r7 = new RecyclerView(r6.getContext());
        r7.setMinimumHeight(200);
        r7.setLayoutManager(new LinearLayoutManager(r6.getContext()));
        r7.setAdapter((CommonPanelAdapter) this.t.getValue());
        r6.addView(r7, new ViewGroup.LayoutParams(-1, -2));
    }
}
