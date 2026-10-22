package com.bytedance.ee.bear.drive.biz.preview.error.resourceblocked;

import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/resourceblocked/DriveImFileBlockedByAdminPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "showFileDeletedByAdminDialog", "strRes", "", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveImFileBlockedByAdminPlugin extends AbsDrivePreviewPlugin {
    public static final a Companion = null;
    public static final String TAG = "DriveImFileBlockedByAdminPlugin";

    public static final class a {
        public a() {
        }
    }

    public static final class b extends u75.b.C0306b {
        public final /* synthetic */ DriveImFileBlockedByAdminPlugin a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ErrCode.values().length];
                r0[ErrCode.STATIC_RESOURCE_FROZEN_BY_ADMIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[ErrCode.STATIC_RESOURCE_SHREDDED_BY_ADMIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public b(DriveImFileBlockedByAdminPlugin r1) {
            this.a = r1;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void c(ErrCode r3) {
            Intrinsics.checkNotNullParameter(r3, "code");
            int r4 = a.a[r3.ordinal()];
            if (r4 != 1) goto L5;
            tt5.a.h(DriveImFileBlockedByAdminPlugin.TAG, "STATIC_RESOURCE_FROZEN_BY_ADMIN, showDialog");
            DriveImFileBlockedByAdminPlugin.access$showFileDeletedByAdminDialog(this.a, 2131888473);
            return;
        L5:
            if (r4 != 2) goto L11;
            tt5.a.h(DriveImFileBlockedByAdminPlugin.TAG, "STATIC_RESOURCE_SHREDDED_BY_ADMIN, showDialog");
            DriveImFileBlockedByAdminPlugin.access$showFileDeletedByAdminDialog(this.a, 2131888474);
            return;
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ DriveImFileBlockedByAdminPlugin a;

        public c(DriveImFileBlockedByAdminPlugin r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            if (com.bytedance.ee.util.ui.b.a(DriveImFileBlockedByAdminPlugin.access$getActivity(this.a)) == false) goto L6;
            DriveImFileBlockedByAdminPlugin.access$getActivity(this.a).finish();
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveImFileBlockedByAdminPlugin() {
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_drive_biz_preview_error_resourceblocked_DriveImFileBlockedByAdminPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(UDDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveImFileBlockedByAdminPlugin r0) {
        return r0.getActivity();
    }

    private final void showFileDeletedByAdminDialog(int r4) {
        removePreviewView();
        Context r0 = getContext();
        Intrinsics.checkNotNullParameter(r0, "context");
        UDDialogBuilder r1 = new UDDialogBuilder(r0);
        r1.autoDismiss(true);
        r1.title(2131888475);
        r1.message(r4);
        BearUDDialogBuilder.ActionBottomOrientation r5 = BearUDDialogBuilder.ActionBottomOrientation.VERTICAL;
        Intrinsics.checkNotNullParameter(r5, "value");
        if (r5 != BearUDDialogBuilder.ActionBottomOrientation.HORIZONTAL) goto L5;
        UDBaseDialogBuilder.ActionBottomOrientation r6 = UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL;
    L6:
        r1.actionButtonOrientation(r6);
        r1.addActionButton(2131391777, 2131887759, new c(this));
        INVOKEVIRTUAL_com_bytedance_ee_bear_drive_biz_preview_error_resourceblocked_DriveImFileBlockedByAdminPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r1.build());
        return;
    L5:
        r6 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
        r2.c().c(new b(this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$showFileDeletedByAdminDialog(DriveImFileBlockedByAdminPlugin r0, int r1) {
        r0.showFileDeletedByAdminDialog(r1);
    }
}
