package com.bytedance.ee.bear.office.list.selectpanel;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\b\u0000\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J$\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010)\u001a\u00020\u0007H\u0016J\u0014\u0010*\u001a\u00020\u00072\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060,J\b\u0010-\u001a\u00020\u0007H\u0016J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0013H\u0002R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onActionClick", "Lkotlin/Function1;", "Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelItemSpec;", "", "getOnActionClick", "()Lkotlin/jvm/functions/Function1;", "setOnActionClick", "(Lkotlin/jvm/functions/Function1;)V", "onBackClick", "Lkotlin/Function0;", "getOnBackClick", "()Lkotlin/jvm/functions/Function0;", "setOnBackClick", "(Lkotlin/jvm/functions/Function0;)V", "onHeightChanged", "", "getOnHeightChanged", "setOnHeightChanged", "adapter", "Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelAdapter;", "panelRoot", "Landroid/view/View;", "lastReportedHeight", "layoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "update", "items", "", "onDestroyView", "reportPanelHeight", "height", "Companion", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSelectPanelDialog extends DialogFragment {
    public static final /* synthetic */ int k = 0;
    public Function1<? super com.bytedance.ee.bear.office.list.selectpanel.d, Unit> d;
    public Function0<Unit> e;
    public Function1<? super Integer, Unit> f;
    public final OfficeSelectPanelAdapter g;
    public View h;
    public int i;
    public final b j;

    public static final class a {
    }

    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ OfficeSelectPanelDialog a;

        public b(OfficeSelectPanelDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            OfficeSelectPanelDialog r10 = this.a;
            int r11 = r1.getHeight();
            int r12 = OfficeSelectPanelDialog.k;
            r10.S90(r11);
        }
    }

    public static final class c implements DialogInterface.OnKeyListener {
        public final /* synthetic */ OfficeSelectPanelDialog a;

        public c(OfficeSelectPanelDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
            if (r2 == 4) goto L5;
        L9:
            return false;
        L5:
            if (r3.getAction() != 1) goto L9;
            Function0<Unit> r4 = this.a.e;
            if (r4 == null) goto L11;
            r4.invoke();
            return true;
        L11:
            return true;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ OfficeSelectPanelDialog b;

        public d(View r1, OfficeSelectPanelDialog r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.a.isAttachedToWindow() == false) goto L9;
            OfficeSelectPanelDialog r0 = this.b;     // Catch: Throwable -> L6
            int r1 = this.a.getHeight();     // Catch: Throwable -> L6
            int r2 = OfficeSelectPanelDialog.k;     // Catch: Throwable -> L6
            r0.S90(r1);     // Catch: Throwable -> L6
            return;
        }
    }

    static {
    }

    public final void onDestroyView() {
        View r0 = this.h;
        if (r0 == null) goto L5;
        r0.removeOnLayoutChangeListener(this.j);
    L5:
        this.h = null;
        S90(0);
        super.onDestroyView();
    }

    public OfficeSelectPanelDialog() {
        this.g = new OfficeSelectPanelAdapter(new OfficeSelectPanelDialog$adapter$1(this));
        this.i = -1;
        this.j = new b(this);
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        r1.setBackgroundDrawable(new ColorDrawable(0));
        r1.setDimAmount(0.0f);
        r1.clearFlags(2);
        r1.addFlags(32);
        r1.setLayout(-1, -2);
        r1.setGravity(80);
        return;
    L9:
        return;
    }

    public final void S90(int r2) {
        int r3 = RangesKt.coerceAtLeast(r2, 0);
        if (r3 != this.i) goto L5;
        return;
    L5:
        this.i = r3;
        Function1<? super Integer, Unit> r0 = this.f;
        if (r0 == null) goto L9;
        r0.invoke(Integer.valueOf(r3));
        return;
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        setCancelable(false);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnKeyListener(new c(this));
        return r3;
    }

    public final void update(List<com.bytedance.ee.bear.office.list.selectpanel.d> r3) {
        Intrinsics.checkNotNullParameter(r3, "items");
        OfficeSelectPanelAdapter r0 = this.g;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "nextItems");
        ((ArrayList) r0.b).clear();
        ArrayList r1 = (ArrayList) r0.b;
        r1.addAll(r3);
        r0.notifyDataSetChanged();
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        this.h = r4;
        r4.addOnLayoutChangeListener(this.j);
        RecyclerView r6 = r4.findViewById(2131381376);
        r6.setLayoutManager(new LinearLayoutManager(requireContext(), 0, false));
        r6.setAdapter(this.g);
        r4.post(new d(r4, this));
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564115, r3, false);
    }
}
