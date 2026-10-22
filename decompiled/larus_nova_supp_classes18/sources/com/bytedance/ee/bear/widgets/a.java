package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends cp5.c {
    public final Context a;
    public final cp5.a b;
    public final List<cp5.b> c;
    public LKUIDialog d;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.widgets.a$a, reason: collision with other inner class name */
    public class C0200a extends t {
        public final /* synthetic */ cp5.b c;
        public final /* synthetic */ a d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r3) {
            cp5.b r0 = this.c;
            if (r0.g == false) goto L9;
            View.OnClickListener r1 = r0.f;
            if (r1 == null) goto L7;
            r1.onClick(r3);
        L7:
            this.d.n();
            return;
        }

        public C0200a(a r1, cp5.b r2) {
            this.d = r1;
            this.c = r2;
        }
    }

    public class b extends UDBaseListDialogAdapter {
        public final List<cp5.b> i;
        public final /* synthetic */ a j;

        public final int getItemCount() {
            return this.i.size();
        }

        public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
            y2((UDBaseListDialogAdapter.UDDialogListItemViewHolder) r1, r2);
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            return new c(LayoutInflater.from(r3.getContext()).inflate(2131568218, r3, false));
        }

        public final void y2(UDBaseListDialogAdapter.UDDialogListItemViewHolder r2, int r3) {
            cp5.b r4 = (cp5.b) ListProtector.get(this.i, r3);
            this.j.o((c) r2, r4);
        }

        public final UDBaseListDialogAdapter.UDDialogListItemViewHolder z2(ViewGroup r3, int r4) {
            return new c(LayoutInflater.from(r3.getContext()).inflate(2131568218, r3, false));
        }

        public b(a r1, Context r2, List<cp5.b> r3) {
            this.j = r1;
            super(r2);
            this.i = r3;
        }
    }

    public class c extends UDBaseListDialogAdapter.UDDialogListItemViewHolder {
        public final TextView b;
        public final UDBadgeView c;
        public final ImageView d;
        public final ViewGroup e;

        public c(View r2) {
            super(r2);
            this.b = (TextView) r2.findViewById(2131391793);
            this.d = (ImageView) r2.findViewById(2131362138);
            this.c = r2.findViewById(2131362134);
            this.e = (ViewGroup) r2.findViewById(2131391791);
        }
    }

    public final void a() {
        CharSequence r0 = this.a.getText(2131888309);
        cp5.b r1 = new cp5.b();
        r1.a = r0;
        r1.d = false;
        r1.e = null;
        r1.f = null;
        r1.c = false;
        r1.b = -1;
        r1.g = true;
        r1.h = 1.0f;
        r1.i = true;
        c(r1);
    }

    public final LKUIDialog l() {
        return m(-1.0f);
    }

    public final void n() {
        LKUIDialog r0 = this.d;
        if (r0 == null) goto L21;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
        return;
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r1.getLooper()) goto L9;
        r1.post(DialogLancet.createDismissRunnable(r0));
        return;
    }

    public final void q() {
        LKUIDialog r0 = this.d;     // Catch: Exception -> L17
        if (r0 != null) goto L5;
        LKUIDialog r1 = l();     // Catch: Exception -> L17
        this.d = r1;     // Catch: Exception -> L17
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L25;
        DialogLancet.handleBlockedDialogShow(r1);     // Catch: Exception -> L17
    L22:
        return;
    L25:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
    L15:
        DialogLancet.beforeDialogShow(r1);     // Catch: Exception -> L17
        r1.show();     // Catch: Exception -> L17
        DialogLancet.afterDialogShow(r1);     // Catch: Exception -> L17
        goto L22
    L5:
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L27;
        DialogLancet.handleBlockedDialogShow(r0);     // Catch: Exception -> L17
        goto L22
    L27:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L9:
        DialogLancet.beforeDialogShow(r0);     // Catch: Exception -> L17
        r0.show();     // Catch: Exception -> L17
        DialogLancet.afterDialogShow(r0);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        tt5.a.f("ActionSheet", e, false);
    }

    public a(Context r2) {
        this.a = r2;
        this.b = new cp5.a(r2);
        this.c = new ArrayList(10);
    }

    public final void b(View.OnClickListener r4) {
        CharSequence r0 = this.a.getText(2131888309);
        cp5.b r1 = new cp5.b();
        r1.a = r0;
        r1.d = false;
        r1.e = null;
        r1.f = r4;
        r1.c = false;
        r1.b = -1;
        r1.g = true;
        r1.h = 1.0f;
        r1.i = true;
        c(r1);
    }

    public final void c(cp5.b r4) {
        if (TextUtils.isEmpty(r4.a) == false) goto L5;
        r4.a = this.a.getText(2131888309);
    L5:
        View r0 = View.inflate(this.a, 2131568217, null);
        o(new c(r0), r4);
        ((com.larksuite.component.ui.dialog.d) this.b).c.footerLayout(r0);
    }

    public final void d(CharSequence r3) {
        cp5.b r0 = new cp5.b();
        r0.a = r3;
        r0.d = false;
        r0.e = null;
        r0.f = null;
        r0.c = false;
        r0.b = -1;
        r0.g = false;
        r0.h = 1.0f;
        r0.i = true;
        ((ArrayList) this.c).add(r0);
    }

    public final void f(cp5.b r2) {
        ((ArrayList) this.c).add(r2);
    }

    public final void j(int r2) {
        k(this.a.getText(r2).toString());
    }

    public final void k(CharSequence r3) {
        cp5.a r0 = this.b;
        r0.k(r3);
        ((com.larksuite.component.ui.dialog.d) r0).c.titleColor(2131106620);
        ((com.larksuite.component.ui.dialog.d) r0).c.titleSize(14);
        ((com.larksuite.component.ui.dialog.d) r0).c.titleLineCount(2);
    }

    public final LKUIDialog m(float r4) {
        b r0 = new b(this, this.a, this.c);
        ((com.larksuite.component.ui.dialog.b) this.b).g.adapter(r0);
        if (r4 >= 0.0f) goto L5;
    L7:
        LKUIDialog r5 = this.b.c();
        this.d = r5;
        return r5;
    L5:
        if (r4 > 1.0f) goto L7;
        ((com.larksuite.component.ui.dialog.d) this.b).c.maskAlpha(r4);
        goto L7
    }

    public final void p(DialogInterface.OnDismissListener r2) {
        LKUIDialog r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L12;
        LKUIDialog r3 = this.d;
        if (r3 == null) goto L12;
        r3.setOnDismissListener(r2);
    L12:
        ((com.larksuite.component.ui.dialog.d) this.b).c.onDismissListener(r2);
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        r1 = true;
        goto L8
    }

    public final void e(int r3, View.OnClickListener r4) {
        CharSequence r5 = this.a.getText(r3);
        cp5.b r0 = new cp5.b();
        r0.a = r5;
        r0.d = false;
        r0.e = null;
        r0.f = r4;
        r0.c = false;
        r0.b = -1;
        r0.g = true;
        r0.h = 1.0f;
        r0.i = true;
        f(r0);
    }

    public final void g(CharSequence r3, View.OnClickListener r4) {
        cp5.b r0 = new cp5.b();
        r0.a = r3;
        r0.d = false;
        r0.e = null;
        r0.f = r4;
        r0.c = false;
        r0.b = -1;
        r0.g = true;
        r0.h = 1.0f;
        r0.i = true;
        f(r0);
    }

    public final void h(int r2, View.OnClickListener r3) {
        i(this.a.getText(r2), r3);
    }

    public final void i(CharSequence r4, View.OnClickListener r5) {
        int r0 = this.a.getResources().getColor(2131102093);
        cp5.b r1 = new cp5.b();
        r1.a = r4;
        r1.d = false;
        r1.e = null;
        r1.f = r5;
        r1.c = false;
        r1.b = r0;
        r1.g = true;
        r1.h = 1.0f;
        r1.i = true;
        f(r1);
    }

    public final void o(c r5, cp5.b r6) {
        if (TextUtils.isEmpty(r6.a) == true) goto L5;
        r5.b.setText(r6.a);
    L5:
        ViewGroup r0 = r5.e;
        if (r0 == null) goto L11;
        if (r6.i == true) goto L11;
        r0.setBackground(null);
    L11:
        if (r6.c == false) goto L14;
        int r1 = h18.e.a;
        Typeface r2 = h18.e.b(r5.b.getContext(), 1);
        r5.b.setTypeface(r2);
    L14:
        if (r6.g == true) goto L16;
        TextView r3 = r5.b;
        r3.setTextColor(r3.getResources().getColor(2131106610));
    L20:
        int r4 = 8;
        if (r6.e == null) goto L23;
        r5.d.setVisibility(0);
        r5.d.setImageDrawable(r6.e);
    L24:
        r5.b.setAlpha(r6.h);
        UDBadgeView r7 = r5.c;
        if (r6.d == false) goto L27;
        r4 = 0;
    L27:
        r7.setVisibility(r4);
        ((RecyclerView.ViewHolder) r5).itemView.setEnabled(r6.g);
        ((RecyclerView.ViewHolder) r5).itemView.setOnClickListener(new C0200a(this, r6));
        return;
    L23:
        r5.d.setVisibility(8);
        r5.d.setImageDrawable(null);
        goto L24
    L16:
        int r8 = r6.b;
        if (r8 == (-1)) goto L19;
        r5.b.setTextColor(r8);
        goto L20
    L19:
        TextView r9 = r5.b;
        r9.setTextColor(r9.getResources().getColor(2131106622));
        goto L20
    }
}
