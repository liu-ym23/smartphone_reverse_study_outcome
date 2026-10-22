package com.bytedance.locallife.poi.poidetail.screenshot.ui;

import com.bytedance.crash.d;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
public final class PoiScreenshotPanelFragment$onViewCreated$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PoiScreenshotPanelFragment this$0;

    public PoiScreenshotPanelFragment$onViewCreated$2$1(PoiScreenshotPanelFragment r100) {
        this.this$0 = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        INVOKEVIRTUAL_com_bytedance_locallife_poi_poidetail_screenshot_ui_PoiScreenshotPanelFragment$onViewCreated$2$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(this.this$0);
    }

    public static void INVOKEVIRTUAL_com_bytedance_locallife_poi_poidetail_screenshot_ui_PoiScreenshotPanelFragment$onViewCreated$2$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(PoiScreenshotPanelFragment r100) {
        r100.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
