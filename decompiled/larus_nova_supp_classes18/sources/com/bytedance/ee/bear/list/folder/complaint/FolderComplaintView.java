package com.bytedance.ee.bear.list.folder.complaint;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.list.t0;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class FolderComplaintView extends com.larksuite.framework.mvp.a<j.a> implements j {
    public final View b;
    public final String c;
    public final String d;
    public final boolean e;
    public final boolean f;
    public UDButton g;

    public static final class a implements DialogInterface.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            t0.K((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6));
        }
    }

    public final void create() {
        ((TextView) this.b.findViewById(2131378099)).setText(this.c);
        TextView r0 = (TextView) this.b.findViewById(2131378095);
        TextView r1 = (TextView) this.b.findViewById(2131378096);
        TextView r2 = (TextView) this.b.findViewById(2131378067);
        if (this.e == false) goto L5;
        r0.setVisibility(0);
        r0.setText(this.d);
        r1.setVisibility(0);
        r2.setText(2131887547);
    L7:
        if (this.f == false) goto L9;
        TextView r3 = (TextView) this.b.findViewById(2131378083);
        TextView r4 = (TextView) this.b.findViewById(2131378065);
        TextView r5 = (TextView) this.b.findViewById(2131378067);
        TextView r6 = (TextView) this.b.findViewById(2131378066);
        r3.setText(2131888722);
        r4.setText(2131888715);
        r5.setText(2131888716);
        r6.setText(2131888717);
    L9:
        UDButton r7 = this.b.findViewById(2131378078);
        this.g = r7;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mBtnSend");
        r7 = null;
    L12:
        r7.setOnClickListener(new h(this));
        return;
    L5:
        r0.setVisibility(8);
        r1.setVisibility(8);
        r2.setText(2131887540);
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.folder.complaint.j
    public final void i1() {
        UDButton r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBtnSend");
        r0 = null;
    L5:
        com.larksuite.component.universe_design.button.e.c(r0, 2131894314);
    }

    @Override // com.bytedance.ee.bear.list.folder.complaint.j
    public final void x4() {
        UDButton r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBtnSend");
        r0 = null;
    L5:
        com.larksuite.component.universe_design.button.e.h(r0, new FolderComplaintView$showComplaintLoading$1(this));
    }

    @Override // com.bytedance.ee.bear.list.folder.complaint.j
    public final void J6(int r3, Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r4, "context");
        UDDialogBuilder r0 = new UDDialogBuilder(r4);
        r0.autoDismiss(true);
        r0.message(r3);
        r0.addActionButton(2131391778, 2131888721, null);
        r0.addActionButton(2131391777, 2131888720, a.a);
        r0.cancelOnTouchOutside(false);
        UDDialog r5 = r0.build();
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r5);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
    }

    public FolderComplaintView(View r2, String r3, String r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "mRootView");
        Intrinsics.checkNotNullParameter(r3, "mName");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
