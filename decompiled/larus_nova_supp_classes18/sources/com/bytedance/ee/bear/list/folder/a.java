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
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.sort.FilterItemDecoration;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends Dialog {
    public CommonActionPanelLayout a;
    public TextView b;
    public RecyclerView c;
    public DeleteSingleContainerUserAdapter d;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.folder.a$a, reason: collision with other inner class name */
    public static class C0014a {
        public final b a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.list.folder.a$a$a, reason: collision with other inner class name */
        public interface InterfaceC0015a {
            void a(Document r1);
        }

        public C0014a() {
            this.a = new b();
        }

        public final a a(Context r3, AccountService.Account r4) {
            final a r0 = new a(r3);
            final b r5 = this.a;
            r5.getClass();
            DeleteSingleContainerUserAdapter r1 = new DeleteSingleContainerUserAdapter();
            r0.d = r1;
            r1.d = r4;
            r1.notifyDataSetChanged();
            DeleteSingleContainerUserAdapter r6 = r0.d;
            r6.c = new uc5.h(r5, r0);
            r0.b.setOnClickListener(new uc5.i(r5, r0));
            r0.a.setOnActionListener(new com.bytedance.ee.bear.list.folder.b(r5, r0));
            r0.c.setAdapter(r0.d);
            DeleteSingleContainerUserAdapter r7 = r0.d;
            ArrayList<Document> r8 = r5.a.getDocumentList();
            r7.getClass();
            if (r8 == null) goto L6;
            r7.b = r8;
            r7.notifyDataSetChanged();
        L6:
            return r0;
        }
    }

    public static class b {
        public DocumentListInfo a;
        public C0014a.InterfaceC0015a b;
        public DialogInterface.OnClickListener c;

        public b() {
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (isShowing() == false) goto L21;
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L7;
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
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r1 == null) goto L18;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r0.getLooper()) goto L9;
        r0.post(DialogLancet.createDismissRunnable(this));
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

    public a(Context r3) {
        super(r3, 2131951622);
        setContentView(getLayoutInflater().inflate(2131563471, null));
    }

    @Override // android.app.Dialog
    public final void setContentView(View r6) {
        super.setContentView(r6);
        this.a = (CommonActionPanelLayout) r6.findViewById(2131381877);
        this.b = (TextView) r6.findViewById(2131390524);
        this.c = r6.findViewById(2131385025);
        LinearLayoutManager r7 = new LinearLayoutManager(getContext(), 1, false);
        this.c.setLayoutManager(r7);
        this.c.addItemDecoration(new FilterItemDecoration());
        Window r8 = getWindow();
        if (r8 != null) goto L5;
        tt5.a.d("DeleteSingleContainerFailDialog", "window is null");
        return;
    L5:
        WindowManager.LayoutParams r0 = r8.getAttributes();
        r8.setGravity(80);
        r0.width = -1;
        r0.height = -2;
        TypedValue r2 = new TypedValue();
        getContext().getResources().getValue(2131168390, r2, true);
        r8.setDimAmount(r2.getFloat());
        r8.setAttributes(r0);
    }
}
