package com.bytedance.android.shopping.commentv3.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/view/SheetPanelDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "CloseReason", "SheetCellViewHolder", "SheetPanelAdapter", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SheetPanelDialog extends BottomSheetDialog {
    public RecyclerView a;
    public final TextView b;
    public CloseReason c;
    public final fc3.a d;
    public final Map<?, ?> e;
    public final Map<?, ?> f;
    public final List<?> g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/view/SheetPanelDialog$CloseReason;", "", "NONE", "CLICK_ACTION", "CLICK_CANCEL", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum CloseReason extends Enum<CloseReason> {
        public static final CloseReason CLICK_ACTION = null;
        public static final CloseReason CLICK_CANCEL = null;
        public static final CloseReason NONE = null;
        public static final /* synthetic */ CloseReason[] a = null;

        static {
            CloseReason r1 = new CloseReason("NONE", 0);
            NONE = r1;
            CloseReason r2 = new CloseReason("CLICK_ACTION", 1);
            CLICK_ACTION = r2;
            CloseReason r3 = new CloseReason("CLICK_CANCEL", 2);
            CLICK_CANCEL = r3;
            a = new CloseReason[]{r1, r2, r3};
        }

        public static CloseReason valueOf(String r1) {
            return (CloseReason) r27.a.a(CloseReason.class, r1);
        }

        public static CloseReason[] values() {
            return (CloseReason[]) a.clone();
        }

        public CloseReason(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/view/SheetPanelDialog$SheetCellViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class SheetCellViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final /* synthetic */ SheetPanelDialog b;

        public SheetCellViewHolder(SheetPanelDialog r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.b = r2;
            super(r3);
            this.a = (TextView) r3.findViewById(2131388920);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/view/SheetPanelDialog$SheetPanelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/shopping/commentv3/view/SheetPanelDialog$SheetCellViewHolder;", "Lcom/bytedance/android/shopping/commentv3/view/SheetPanelDialog;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class SheetPanelAdapter extends RecyclerView.Adapter<SheetCellViewHolder> {
        public final List<Map<String, Object>> a;
        public final /* synthetic */ SheetPanelDialog b;

        public final int getItemCount() {
            return ((ArrayList) this.a).size();
        }

        public SheetPanelAdapter(SheetPanelDialog r1) {
            this.b = r1;
            this.a = new ArrayList();
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
            SheetCellViewHolder r6 = (SheetCellViewHolder) r4;
            Intrinsics.checkNotNullParameter(r6, "holder");
            if (r5 >= 0) goto L5;
            return;
        L5:
            if (r5 >= ((ArrayList) this.a).size()) goto L20;
            Map r7 = (Map) CollectionsKt.getOrNull(this.a, r5);
            if (r7 == null) goto L21;
            r6.getClass();
            Object r1 = null;
            String r0 = nc3.a.e(r7, "title", null);
            if (r0 != null) goto L11;
            r0 = "";
        L11:
            Object r8 = r7.get("click_action");
            if ((r8 instanceof Map) == false) goto L15;
            r1 = r8;
        L15:
            Map r2 = (Map) r1;
            TextView r9 = r6.a;
            if (r9 == null) goto L22;
            r9.setText(r0);
            r9.setOnClickListener(new d(r6, r2));
            return;
        L22:
            return;
        L21:
            return;
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            View r5 = th.a.c(r3.getContext(), 2131560416, r3, false);
            return new SheetCellViewHolder(this.b, r5);
        }
    }

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ SheetPanelDialog a;

        public a(SheetPanelDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r6v1, types: [android.app.Dialog, com.bytedance.android.shopping.commentv3.view.SheetPanelDialog] */
        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r6) {
            ?? r7 = this.a;
            if (r7.c != CloseReason.CLICK_ACTION) goto L5;
            return;
        L5:
            Map<?, ?> r0 = r7.f;
            if (r0 == null) goto L17;
            Map<String, Object> r1 = nc3.a.g(r0);
            SlcCommonAction.Companion.getClass();
            SlcCommonAction r2 = SlcCommonAction.a.b(r1);
            if (r2 == null) goto L18;
            fc3.a r3 = r7.d;
            if (r3 == null) goto L19;
            Window r8 = r7.getWindow();
            if (r8 == null) goto L14;
            View r9 = SheetPanelDialog.I0(r8);
        L15:
            r3.a(new fc3.c(r2, r9, null, 12));
            return;
        L14:
            r9 = null;
            goto L15
        L19:
            return;
        L18:
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ SheetPanelDialog a;

        public b(SheetPanelDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            AppCompatDialog r5 = this.a;
            r5.c = CloseReason.CLICK_CANCEL;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public static View I0(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        this.a = findViewById(2131362158);
        SheetPanelAdapter r7 = new SheetPanelAdapter(this);
        RecyclerView r0 = this.a;
        if (r0 == null) goto L5;
        r0.setAdapter(r7);
    L5:
        RecyclerView r1 = this.a;
        if (r1 == null) goto L8;
        final Context r2 = getContext();
        r1.setLayoutManager(new AnonymousClass1(r2));
    L8:
        List<?> r3 = this.g;
        ArrayList r4 = new ArrayList();
        if (r3 == null) goto L16;
        Iterator<T> r5 = r3.iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        Object r8 = r5.next();
        if ((r8 instanceof Map) == false) goto L12;
        r4.add(nc3.a.g((Map) r8));
    L16:
        ((ArrayList) r7.a).clear();
        ((ArrayList) r7.a).addAll(r4);
        r7.notifyDataSetChanged();
        Map<?, ?> r9 = this.e;
        if (r9 == null) goto L27;
        Map<String, Object> r10 = nc3.a.g(r9);
        SlcCommonAction.Companion.getClass();
        SlcCommonAction r11 = SlcCommonAction.a.b(r10);
        if (r11 == null) goto L27;
        fc3.a r12 = this.d;
        if (r12 == null) goto L27;
        Window r13 = getWindow();
        if (r13 == null) goto L25;
        View r14 = I0(r13);
    L26:
        r12.a(new fc3.c(r11, r14, null, 12));
        goto L27
    L25:
        r14 = null;
    L27:
        setOnDismissListener(new a(this));
        TextView r15 = this.b;
        if (r15 == null) goto L36;
        r15.setOnClickListener(new b(this));
        return;
    }

    public SheetPanelDialog(Context r2, fc3.a r3, Map r4, Map r5, List r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r6, "panelCellList");
        super(r2, 2131954163);
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        setContentView(2131560417);
        View r7 = findViewById(2131368870);
        if (r7 == null) goto L5;
        r7.setBackgroundResource(2131106784);
    L5:
        this.b = (TextView) findViewById(2131365135);
        this.c = CloseReason.NONE;
    }
}
