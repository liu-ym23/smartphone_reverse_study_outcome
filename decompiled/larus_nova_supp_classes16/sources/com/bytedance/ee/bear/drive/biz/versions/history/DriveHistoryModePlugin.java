package com.bytedance.ee.bear.drive.biz.versions.history;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import b95.e;
import b95.f;
import b95.g;
import b95.l;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/versions/history/DriveHistoryModePlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "mVersionChangeDialog", "Landroid/app/Dialog;", "mDialogManager", "Lcom/bytedance/ee/bear/drive/view/dialog/DriveDialogManager;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onAttachPreview", "onDetachPreview", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveHistoryModePlugin extends AbsDrivePlugin {
    private final l mDialogManager;
    private Dialog mVersionChangeDialog;

    public static final class a<T> implements Observer {
        public final /* synthetic */ DriveHistoryVM a;
        public final /* synthetic */ DriveHistoryModePlugin b;

        public a(DriveHistoryVM r1, DriveHistoryModePlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r8) {
            if (TextUtils.equals((String) r8, this.a.getCurrentDataVersion()) == true) goto L22;
            Dialog r9 = DriveHistoryModePlugin.access$getMVersionChangeDialog$p(this.b);
            if (r9 != null) goto L7;
        L9:
            boolean r10 = false;
        L10:
            if (r10 == true) goto L23;
            DriveHistoryModePlugin r11 = this.b;
            final l r2 = DriveHistoryModePlugin.access$getMDialogManager$p(r11);
            FragmentActivity r3 = DriveHistoryModePlugin.access$getActivity(this.b);
            final com.bytedance.ee.bear.drive.biz.versions.history.a r4 = new com.bytedance.ee.bear.drive.biz.versions.history.a(this.b);
            r2.getClass();
            Intrinsics.checkNotNullParameter(r3, "context");
            UDDialogBuilder r5 = new UDDialogBuilder(r3);
            r5.autoDismiss(true);
            r5.title(2131888463);
            r5.message(2131888461);
            r5.messageTextSize(16);
            r5.addActionButton(2131391777, 2131888462, new e(r4));
            r5.addActionButton(2131391778, 2131887716, new f(r4));
            r5.cancelable(false);
            r5.width(303.0f);
            r5.marginInDp(0);
            final Dialog r0 = r5.build();
            if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L20;
            DialogLancet.handleBlockedDialogShow(r0);
        L17:
            r2.a.put(Integer.valueOf(r0.hashCode()), r0);
            r0.setOnDismissListener(new g(r2, r0));
            DriveHistoryModePlugin.access$setMVersionChangeDialog$p(r11, r0);
            return;
        L20:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
        L16:
            DialogLancet.beforeDialogShow(r0);
            r0.show();
            DialogLancet.afterDialogShow(r0);
            goto L17
        L23:
            return;
        L7:
            if (r9.isShowing() != true) goto L9;
            r10 = true;
            goto L10
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DriveHistoryVM a;
        public final /* synthetic */ DriveHistoryModePlugin b;

        public b(DriveHistoryVM r1, DriveHistoryModePlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r7) {
            if (TextUtils.equals((String) r7, this.a.getCurrentDataVersion()) == false) goto L22;
            Dialog r8 = DriveHistoryModePlugin.access$getMVersionChangeDialog$p(this.b);
            if (r8 == null) goto L9;
            boolean r0 = true;
            if (r8.isShowing() != true) goto L9;
        L10:
            if (r0 == true) goto L23;
            l r1 = DriveHistoryModePlugin.access$getMDialogManager$p(this.b);
            FragmentActivity r2 = DriveHistoryModePlugin.access$getActivity(this.b);
            String r3 = DriveHistoryModePlugin.access$getResources(this.b).getString(2131888460);
            String r4 = DriveHistoryModePlugin.access$getResources(this.b).getString(2131888459);
            com.bytedance.ee.bear.drive.biz.versions.history.b r5 = new com.bytedance.ee.bear.drive.biz.versions.history.b(this.b);
            r1.getClass();
            UDDialog r9 = r1.b(r2, r3, r4, r2.getString(2131888375), r5);
            if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L20;
            DialogLancet.handleBlockedDialogShow(r9);
        L17:
            DriveHistoryModePlugin.access$setMVersionChangeDialog$p(this.b, r9);
            return;
        L20:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
        L16:
            DialogLancet.beforeDialogShow(r9);
            r9.show();
            DialogLancet.afterDialogShow(r9);
            goto L17
        L23:
            return;
        L9:
            r0 = false;
            goto L10
        }
    }

    public static final class c extends u75.b.C0306b {
        public final /* synthetic */ DriveHistoryModePlugin a;

        public c(DriveHistoryModePlugin r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r2, T r3) {
            Intrinsics.checkNotNullParameter(r2, "code");
            if (r2 == InfoCode.FileInfoSuccess) goto L5;
            return;
        L5:
            if ((r3 instanceof f85.a) == false) goto L9;
            ((DriveHistoryVM) DriveHistoryModePlugin.access$viewModel(this.a, DriveHistoryVM.class)).setCurrentDataVersion(((f85.a.C0229a) ((f85.a) r3).a).o);
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DriveHistoryModePlugin b;

        public d(DrivePluginHost r1, DriveHistoryModePlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L10;
            Bundle r4 = this.a.c.getOpenEntity().getExtras();
            if (r4 == null) goto L11;
            DriveHistoryModePlugin r0 = this.b;
            String r5 = r4.getString("extra_history_date");
            if (TextUtils.isEmpty(r5) == true) goto L12;
            DriveHistoryModePlugin.access$getTitleBar(r0).setSubTitle(r5);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveHistoryModePlugin() {
        this.mDialogManager = o75.b.a().H7();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        DriveHistoryVM r0 = (DriveHistoryVM) viewModel(DriveHistoryVM.class);
        r0.getLiveHasNewVersion().observe(getLifecycleOwner(), new a(r0, this));
        r0.getLiveVersionDeleted().observe(getLifecycleOwner(), new b(r0, this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveHistoryModePlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ l access$getMDialogManager$p(DriveHistoryModePlugin r0) {
        return r0.mDialogManager;
    }

    public static final /* synthetic */ Dialog access$getMVersionChangeDialog$p(DriveHistoryModePlugin r0) {
        return r0.mVersionChangeDialog;
    }

    public static final /* synthetic */ Resources access$getResources(DriveHistoryModePlugin r0) {
        return r0.getResources();
    }

    public static final /* synthetic */ TitleBar access$getTitleBar(DriveHistoryModePlugin r0) {
        return r0.getTitleBar();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        r4.c().c(new c(this));
        r4.c.liveHistoryMode().observe(getLifecycleOwner(), new d(r4, this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$setMVersionChangeDialog$p(DriveHistoryModePlugin r0, Dialog r1) {
        r0.mVersionChangeDialog = r1;
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveHistoryModePlugin r0, Class r1) {
        return r0.viewModel(r1);
    }
}
