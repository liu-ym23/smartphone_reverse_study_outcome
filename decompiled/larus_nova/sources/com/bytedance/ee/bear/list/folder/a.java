package com.bytedance.ee.bear.list.folder;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.sort.FilterItemDecoration;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CommonActionPanelLayout f228046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f228047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f228048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DeleteSingleContainerUserAdapter f228049d;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.folder.a$a, reason: collision with other inner class name */
    public static class C3261a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f228050a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.list.folder.a$a$a, reason: collision with other inner class name */
        public interface InterfaceC3262a {
            void a(Document r100);
        }

        public C3261a() {
            this.f228050a = new b();
        }

        public final a a(Context r100, AccountService$Account r101) {
            final a r102 = new a(r100);
            final b r103 = this.f228050a;
            r103.getClass();
            DeleteSingleContainerUserAdapter r104 = new DeleteSingleContainerUserAdapter();
            r102.f228049d = r104;
            r104.f227935d = r101;
            r104.notifyDataSetChanged();
            DeleteSingleContainerUserAdapter r105 = r102.f228049d;
            r105.f227934c = new uc5.h(r103, r102);
            r102.f228047b.setOnClickListener(new uc5.i(r103, r102));
            r102.f228046a.setOnActionListener(new com.bytedance.ee.bear.list.folder.b(r103, r102));
            r102.f228048c.setAdapter(r102.f228049d);
            DeleteSingleContainerUserAdapter r106 = r102.f228049d;
            ArrayList<Document> r107 = r103.f228051a.getDocumentList();
            r106.getClass();
            if (r107 == null) goto L6;
            r106.f227933b = r107;
            r106.notifyDataSetChanged();
        L6:
            return r102;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DocumentListInfo f228051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public C3261a.InterfaceC3262a f228052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public DialogInterface.OnClickListener f228053c;

        public b() {
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (isShowing() == false) goto L21;
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(this);
        return;
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r101 == null) goto L18;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r100.getLooper()) goto L9;
        r100.post(DialogLancet.createDismissRunnable(this));
        return;
    }

    @Override // android.app.Dialog
    public final void show() {
        if (isShowing() == false) goto L5;
        return;
    L5:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L11;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L11:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    public a(Context r100) {
        super(r100, R.style.ActionSheetDialogStyle);
        setContentView(getLayoutInflater().inflate(R.layout.list_dialog_delete_single_container_fail, null));
    }

    @Override // android.app.Dialog
    public final void setContentView(View r100) {
        super.setContentView(r100);
        this.f228046a = (CommonActionPanelLayout) r100.findViewById(R.id.panel_layout);
        this.f228047b = (TextView) r100.findViewById(R.id.tv_done);
        this.f228048c = (RecyclerView) r100.findViewById(R.id.rv_users);
        LinearLayoutManager r101 = new LinearLayoutManager(getContext(), 1, false);
        this.f228048c.setLayoutManager(r101);
        this.f228048c.addItemDecoration(new FilterItemDecoration());
        Window r102 = getWindow();
        if (r102 != null) goto L5;
        tt5.a.d("DeleteSingleContainerFailDialog", "window is null");
        return;
    L5:
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r102.setGravity(80);
        r103.width = -1;
        r103.height = -2;
        TypedValue r104 = new TypedValue();
        getContext().getResources().getValue(R.dimen.spacekit_dialog_background_dim_amount, r104, true);
        r102.setDimAmount(r104.getFloat());
        r102.setAttributes(r103);
    }
}
