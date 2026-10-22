package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.structure.OutlineStructureFragment;
import com.bytedance.ee.bear.drive.view.preview.wrapper.TitleBarViewModel;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFOutlinePlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "outlineDialog", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/structure/OutlineStructureFragment;", "hasLoad", "", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "showPdfOutline", "hidePdfOutline", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PDFOutlinePlugin extends AbsDrivePlugin {
    public static final a Companion = null;
    private static final String TAG = "PDFOutlineFragment";
    private boolean hasLoad;
    private OutlineStructureFragment outlineDialog;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ PDFOutlinePlugin a;

        public b(PDFOutlinePlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            if (((Boolean) r1).booleanValue() == false) goto L5;
            PDFOutlinePlugin.access$showPdfOutline(this.a);
            return;
        L5:
            PDFOutlinePlugin.access$hidePdfOutline(this.a);
        }
    }

    public static final class c extends u75.b.C0306b {
        public final /* synthetic */ PDFOutlinePlugin a;
        public final /* synthetic */ TitleBarViewModel b;

        public c(PDFOutlinePlugin r1, TitleBarViewModel r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r1, T r2) {
            Intrinsics.checkNotNullParameter(r1, "code");
            if (r1 == InfoCode.LoadStart) goto L5;
            return;
        L5:
            if (PDFOutlinePlugin.access$getHasLoad$p(this.a) == false) goto L7;
            PDFOutlinePlugin.access$hidePdfOutline(this.a);
            this.b.hideOutlineMenu();
        L7:
            PDFOutlinePlugin.access$setHasLoad$p(this.a, true);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void hidePdfOutline() {
        tt5.a.h(TAG, "hidePdfOutline. ");
        OutlineStructureFragment r0 = this.outlineDialog;
        if (r0 == null) goto L5;
        INVOKEVIRTUAL_com_bytedance_ee_bear_drive_view_preview_ttreader_pdf_tron_PDFOutlinePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r0);
    L5:
        this.outlineDialog = null;
    }

    private final void showPdfOutline() {
        tt5.a.h(TAG, "showPdfOutline. ");
        com.bytedance.ee.bear.drive.report.c r1 = o75.b.a().Ke();
        r1.getClass();
        HashMap<String, Object> r2 = new HashMap();
        r1.a(r2);
        com.bytedance.ee.bear.drive.report.c.d(r2);
        r1.d.n("ccm_space_docs_contents_view", r2);
        OutlineStructureFragment r3 = instantiateFragment(OutlineStructureFragment.class);
        FragmentTransaction r4 = getHost().a.getChildFragmentManager().beginTransaction();
        INVOKEVIRTUAL_com_bytedance_ee_bear_drive_view_preview_ttreader_pdf_tron_PDFOutlinePlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r4, r3, TAG);
        r4.commitAllowingStateLoss();
        this.outlineDialog = r3;
    }

    public PDFOutlinePlugin() {
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_drive_view_preview_ttreader_pdf_tron_PDFOutlinePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(OutlineStructureFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static final /* synthetic */ boolean access$getHasLoad$p(PDFOutlinePlugin r0) {
        return r0.hasLoad;
    }

    public static final /* synthetic */ void access$hidePdfOutline(PDFOutlinePlugin r0) {
        r0.hidePdfOutline();
    }

    public static final /* synthetic */ void access$showPdfOutline(PDFOutlinePlugin r0) {
        r0.showPdfOutline();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r5) {
        Intrinsics.checkNotNullParameter(r5, "host");
        super.onAttachToHost(r5);
        TitleBarViewModel r0 = (TitleBarViewModel) viewModel(TitleBarViewModel.class);
        r0.getOutlineActive().observe(getLifecycleOwner(), new b(this));
        r5.c().c(new c(this, r0));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$setHasLoad$p(PDFOutlinePlugin r0, boolean r1) {
        r0.hasLoad = r1;
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_bytedance_ee_bear_drive_view_preview_ttreader_pdf_tron_PDFOutlinePlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, 0) == false) goto L6;
        return r2;
    L6:
        return r2.add(r3, r4);
    }
}
