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
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends cp5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f240135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cp5.a f240136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<cp5.b> f240137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LKUIDialog f240138d;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.widgets.a$a, reason: collision with other inner class name */
    public class C3447a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ cp5.b f240139c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f240140d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            cp5.b r101 = this.f240139c;
            if (r101.f464695g == false) goto L9;
            View.OnClickListener r102 = r101.f464694f;
            if (r102 == null) goto L7;
            r102.onClick(r100);
        L7:
            this.f240140d.n();
            return;
        }

        public C3447a(a r100, cp5.b r101) {
            this.f240140d = r100;
            this.f240139c = r101;
        }
    }

    public class b extends UDBaseListDialogAdapter {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final List<cp5.b> f240141i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ a f240142j;

        @Override // com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f240141i.size();
        }

        @Override // com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            y2((UDBaseListDialogAdapter.UDDialogListItemViewHolder) r100, r101);
        }

        @Override // com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            return new c(LayoutInflater.from(r100.getContext()).inflate(R.layout.widget_action_sheet_content_item_layout, r100, false));
        }

        @Override // com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter
        public final void y2(UDBaseListDialogAdapter.UDDialogListItemViewHolder r100, int r101) {
            cp5.b r102 = (cp5.b) ListProtector.get(this.f240141i, r101);
            this.f240142j.o((c) r100, r102);
        }

        @Override // com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter
        public final UDBaseListDialogAdapter.UDDialogListItemViewHolder z2(ViewGroup r100, int r101) {
            return new c(LayoutInflater.from(r100.getContext()).inflate(R.layout.widget_action_sheet_content_item_layout, r100, false));
        }

        public b(a r100, Context r101, List<cp5.b> r102) {
            this.f240142j = r100;
            super(r101);
            this.f240141i = r102;
        }
    }

    public class c extends UDBaseListDialogAdapter.UDDialogListItemViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f240143b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final UDBadgeView f240144c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f240145d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ViewGroup f240146e;

        public c(View r100) {
            super(r100);
            this.f240143b = (TextView) r100.findViewById(R.id.ud_dialog_content_item_tv);
            this.f240145d = (ImageView) r100.findViewById(R.id.action_sheet_icon);
            this.f240144c = (UDBadgeView) r100.findViewById(R.id.action_sheet_badge);
            this.f240146e = (ViewGroup) r100.findViewById(R.id.ud_dialog_content_item);
        }
    }

    public final void a() {
        CharSequence r100 = this.f240135a.getText(R.string.Doc_Widget_Cancel);
        cp5.b r101 = new cp5.b();
        r101.f464689a = r100;
        r101.f464692d = false;
        r101.f464693e = null;
        r101.f464694f = null;
        r101.f464691c = false;
        r101.f464690b = -1;
        r101.f464695g = true;
        r101.f464696h = 1.0f;
        r101.f464697i = true;
        c(r101);
    }

    public final LKUIDialog l() {
        return m(-1.0f);
    }

    public final void n() {
        LKUIDialog r100 = this.f240138d;
        if (r100 == null) goto L21;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r102 == null) goto L18;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r101.getLooper()) goto L9;
        r101.post(DialogLancet.createDismissRunnable(r100));
        return;
    }

    public final void q() {
        LKUIDialog r100 = this.f240138d;     // Catch: Exception -> L17
        if (r100 != null) goto L5;
        LKUIDialog r101 = l();     // Catch: Exception -> L17
        this.f240138d = r101;     // Catch: Exception -> L17
        if (DialogLancet.shouldBlockDialogShow(r101) == false) goto L25;
        DialogLancet.handleBlockedDialogShow(r101);     // Catch: Exception -> L17
    L22:
        return;
    L25:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
    L15:
        DialogLancet.beforeDialogShow(r101);     // Catch: Exception -> L17
        r101.show();     // Catch: Exception -> L17
        DialogLancet.afterDialogShow(r101);     // Catch: Exception -> L17
        goto L22
    L5:
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L27;
        DialogLancet.handleBlockedDialogShow(r100);     // Catch: Exception -> L17
        goto L22
    L27:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L9:
        DialogLancet.beforeDialogShow(r100);     // Catch: Exception -> L17
        r100.show();     // Catch: Exception -> L17
        DialogLancet.afterDialogShow(r100);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        tt5.a.f("ActionSheet", e, false);
    }

    public a(Context r100) {
        this.f240135a = r100;
        this.f240136b = new cp5.a(r100);
        this.f240137c = new ArrayList(10);
    }

    public final void b(View.OnClickListener r100) {
        CharSequence r101 = this.f240135a.getText(R.string.Doc_Widget_Cancel);
        cp5.b r102 = new cp5.b();
        r102.f464689a = r101;
        r102.f464692d = false;
        r102.f464693e = null;
        r102.f464694f = r100;
        r102.f464691c = false;
        r102.f464690b = -1;
        r102.f464695g = true;
        r102.f464696h = 1.0f;
        r102.f464697i = true;
        c(r102);
    }

    public final void c(cp5.b r100) {
        if (TextUtils.isEmpty(r100.f464689a) == false) goto L5;
        r100.f464689a = this.f240135a.getText(R.string.Doc_Widget_Cancel);
    L5:
        View r101 = View.inflate(this.f240135a, R.layout.widget_action_sheet_content_cancel_item_layout, null);
        o(new c(r101), r100);
        this.f240136b.f284132c.footerLayout(r101);
    }

    public final void d(CharSequence r100) {
        cp5.b r101 = new cp5.b();
        r101.f464689a = r100;
        r101.f464692d = false;
        r101.f464693e = null;
        r101.f464694f = null;
        r101.f464691c = false;
        r101.f464690b = -1;
        r101.f464695g = false;
        r101.f464696h = 1.0f;
        r101.f464697i = true;
        ((ArrayList) this.f240137c).add(r101);
    }

    public final void f(cp5.b r100) {
        ((ArrayList) this.f240137c).add(r100);
    }

    public final void j(int r100) {
        k(this.f240135a.getText(r100).toString());
    }

    public final void k(CharSequence r100) {
        cp5.a r101 = this.f240136b;
        r101.k(r100);
        r101.f284132c.titleColor(R.color.text_placeholder);
        r101.f284132c.titleSize(14);
        r101.f284132c.titleLineCount(2);
    }

    public final LKUIDialog m(float r100) {
        b r101 = new b(this, this.f240135a, this.f240137c);
        this.f240136b.f284127g.adapter(r101);
        if (r100 >= 0.0f) goto L5;
    L7:
        LKUIDialog r102 = this.f240136b.c();
        this.f240138d = r102;
        return r102;
    L5:
        if (r100 > 1.0f) goto L7;
        this.f240136b.f284132c.maskAlpha(r100);
        goto L7
    }

    public final void p(DialogInterface.OnDismissListener r100) {
        LKUIDialog r101 = this.f240138d;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L12;
        LKUIDialog r103 = this.f240138d;
        if (r103 == null) goto L12;
        r103.setOnDismissListener(r100);
    L12:
        this.f240136b.f284132c.onDismissListener(r100);
        return;
    L5:
        if (r101.isShowing() == false) goto L7;
        r102 = true;
        goto L8
    }

    public final void e(int r100, View.OnClickListener r101) {
        CharSequence r102 = this.f240135a.getText(r100);
        cp5.b r103 = new cp5.b();
        r103.f464689a = r102;
        r103.f464692d = false;
        r103.f464693e = null;
        r103.f464694f = r101;
        r103.f464691c = false;
        r103.f464690b = -1;
        r103.f464695g = true;
        r103.f464696h = 1.0f;
        r103.f464697i = true;
        f(r103);
    }

    public final void g(CharSequence r100, View.OnClickListener r101) {
        cp5.b r102 = new cp5.b();
        r102.f464689a = r100;
        r102.f464692d = false;
        r102.f464693e = null;
        r102.f464694f = r101;
        r102.f464691c = false;
        r102.f464690b = -1;
        r102.f464695g = true;
        r102.f464696h = 1.0f;
        r102.f464697i = true;
        f(r102);
    }

    public final void h(int r100, View.OnClickListener r101) {
        i(this.f240135a.getText(r100), r101);
    }

    public final void i(CharSequence r100, View.OnClickListener r101) {
        int r102 = this.f240135a.getResources().getColor(R.color.function_danger_fill_default);
        cp5.b r103 = new cp5.b();
        r103.f464689a = r100;
        r103.f464692d = false;
        r103.f464693e = null;
        r103.f464694f = r101;
        r103.f464691c = false;
        r103.f464690b = r102;
        r103.f464695g = true;
        r103.f464696h = 1.0f;
        r103.f464697i = true;
        f(r103);
    }

    public final void o(c r100, cp5.b r101) {
        if (TextUtils.isEmpty(r101.f464689a) == true) goto L5;
        r100.f240143b.setText(r101.f464689a);
    L5:
        ViewGroup r102 = r100.f240146e;
        if (r102 == null) goto L11;
        if (r101.f464697i == true) goto L11;
        r102.setBackground(null);
    L11:
        if (r101.f464691c == false) goto L14;
        int r103 = h18.e.f483540a;
        Typeface r104 = h18.e.b(r100.f240143b.getContext(), 1);
        r100.f240143b.setTypeface(r104);
    L14:
        if (r101.f464695g == true) goto L16;
        TextView r105 = r100.f240143b;
        r105.setTextColor(r105.getResources().getColor(R.color.text_disable));
    L20:
        int r106 = 8;
        if (r101.f464693e == null) goto L23;
        r100.f240145d.setVisibility(0);
        r100.f240145d.setImageDrawable(r101.f464693e);
    L24:
        r100.f240143b.setAlpha(r101.f464696h);
        UDBadgeView r107 = r100.f240144c;
        if (r101.f464692d == false) goto L27;
        r106 = 0;
    L27:
        r107.setVisibility(r106);
        r100.itemView.setEnabled(r101.f464695g);
        r100.itemView.setOnClickListener(new C3447a(this, r101));
        return;
    L23:
        r100.f240145d.setVisibility(8);
        r100.f240145d.setImageDrawable(null);
        goto L24
    L16:
        int r108 = r101.f464690b;
        if (r108 == (-1)) goto L19;
        r100.f240143b.setTextColor(r108);
        goto L20
    L19:
        TextView r109 = r100.f240143b;
        r109.setTextColor(r109.getResources().getColor(R.color.text_title));
        goto L20
    }
}
