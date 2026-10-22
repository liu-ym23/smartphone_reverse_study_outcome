package com.larksuite.component.ui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.larksuite.component.ui.dialog.d;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public class d<T extends d> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SparseIntArray f284129e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f284130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f284131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public UDBaseDialogBuilder f284132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UDDialogController f284133d;

    public static abstract class a<T extends LKUIDialog> {
        public a() {
        }

        public void a(T r100) {
        }

        public void b(T r100) {
        }
    }

    static {
        SparseIntArray r100 = new SparseIntArray();
        f284129e = r100;
        r100.put(R.id.lkui_dialog_title_tv, R.id.ud_dialog_title_tv);
        r100.put(R.id.lkui_dialog_content_message_tv, R.id.ud_dialog_content_message_tv);
        r100.put(R.id.lkui_dialog_list_rv, R.id.ud_action_panel_list_rv);
        r100.put(R.id.lkui_dialog_btn_left, R.id.ud_dialog_btn_secondary);
        r100.put(R.id.lkui_dialog_btn_right, R.id.ud_dialog_btn_primary);
        r100.put(R.id.lkui_dialog_btn_center, R.id.ud_dialog_btn_primary);
        r100.put(R.id.lkui_dialog_content_item_tv, R.id.ud_dialog_content_item_tv);
        r100.put(R.id.lkui_dialog_btn_cancel, R.id.ud_dialog_btn_cancel);
    }

    public final LKUIDialog c() {
        if (this.f284131b != 0) goto L5;
        LKUIDialog r100 = new LKUIDialog(this.f284130a);
    L6:
        this.f284133d.apply(this.f284132c, r100);
        return r100;
    L5:
        r100 = new LKUIDialog(this.f284130a, this.f284131b);
        goto L6
    }

    public final void d() {
        f r100 = new f(this);
        Context r101 = this.f284130a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = LKUIGlobalDialogActivity.f284119b;
        Intrinsics.checkNotNullParameter(r100, "lkuiDialog");
        LKUIGlobalDialogActivity.f284119b++;
        LKUIGlobalDialogActivity.f284120c.put(Integer.valueOf(LKUIGlobalDialogActivity.f284119b), new WeakReference(r100));
        int r103 = LKUIGlobalDialogActivity.f284119b;
        Intent r104 = new Intent(r101, LKUIGlobalDialogActivity.class);
        r104.putExtra("id_key", r103);
        r104.addFlags(268435456);
        r101.startActivity(r104);
    }

    public final LKUIDialog i() {
        LKUIDialog r100 = c();
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r100);
    L7:
        return r100;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
        goto L7
    }

    public d(Context r100) {
        this.f284130a = r100;
        this.f284132c = new UDDialogBuilder(this.f284130a);
        this.f284133d = new e(this.f284130a);
    }

    public final void e(int r100) {
        this.f284132c.gravity(r100);
        if (r100 != 80) goto L6;
        int r101 = LKUIDialog.f284116c;
        return;
    }

    public final void f(float r100) {
        this.f284132c.height(r100);
        if (r100 != 1.0f) goto L8;
        this.f284132c.height(-1.0f);
        if (this.f284131b != 0) goto L9;
        this.f284131b = R.style.LKUI_Dialog_NoFloating;
        return;
    L9:
        return;
    }

    public final void g(a r100) {
        if (r100 != null) goto L4;
        this.f284132c.lifecycleCallback(null);
        return;
    L4:
        this.f284132c.lifecycleCallback(new j(r100));
    }

    public final void h(CharSequence r100) {
        UDBaseDialogBuilder r101 = this.f284132c;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        r100 = "";
    L5:
        r101.message(r100);
    }

    public final void j(int r100) {
        this.f284132c.title(r100);
        this.f284130a.getString(r100);
    }

    public final void k(CharSequence r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        this.f284132c.title("");
        return;
    L5:
        this.f284132c.title(r100);
    }

    public final void a(int r100, int r101, DialogInterface.OnClickListener r102) {
        this.f284132c.addActionButton(f284129e.get(r100, r100), r101, r102);
    }

    public final void b(int r100, CharSequence r101, DialogInterface.OnClickListener r102) {
        this.f284132c.addActionButton(f284129e.get(r100, r100), r101, r102);
    }
}
