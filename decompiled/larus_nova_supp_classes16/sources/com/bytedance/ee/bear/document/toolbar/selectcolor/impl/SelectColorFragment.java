package com.bytedance.ee.bear.document.toolbar.selectcolor.impl;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment;
import com.bytedance.ee.bear.widgets.t;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectColorFragment extends BaseSubToolbarFragment {
    public static final /* synthetic */ int k = 0;
    public SelectColorViewModel h;
    public TextView i;
    public SelectColorAdapter j;

    public class a extends t {
        public final /* synthetic */ SelectColorFragment c;

        public a(SelectColorFragment r1) {
            this.c = r1;
        }

        public final void a(View r2) {
            this.c.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public SelectColorViewModel Z90() {
        return (SelectColorViewModel) ViewModelProviders.of(getActivity()).get(SelectColorViewModel.class);
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment
    public View getContentView() {
        View r0 = LayoutInflater.from(getContext()).inflate(2131564496, null);
        TextView r1 = (TextView) r0.findViewById(2131388772);
        this.i = r1;
        r1.setOnClickListener(new a(this));
        RecyclerView r2 = r0.findViewById(2131367166);
        SelectColorDecoration r3 = new SelectColorDecoration(getContext());
        SelectColorAdapter r4 = new SelectColorAdapter();
        this.j = r4;
        r2.setAdapter(r4);
        r2.setLayoutManager(new GridLayoutManager(getContext(), 5, 1, false));
        r2.addItemDecoration(r3);
        SelectColorAdapter r5 = this.j;
        r5.c = r3;
        r5.d = new b(this);
        this.h.getSelectParam().observe(this, new c(this));
        return r0;
    }

    static {
    }

    public SelectColorFragment() {
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        getActivity();
        this.h = Z90();
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment
    public Dialog onCreateDialog(Bundle r5) {
        Dialog r6 = super.onCreateDialog(r5);
        if (r6.getWindow() == null) goto L5;
        WindowManager.LayoutParams r0 = r6.getWindow().getAttributes();
        int r1 = (int) (r0.height + getResources().getDimension(2131168470));
        r0.height = r1;
        r0.height = (int) (r1 + (getResources().getDimension(2131165833) * 2.0f));
    L5:
        return r6;
    }
}
