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
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes16.dex */
public class SelectColorFragment extends BaseSubToolbarFragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f222362k = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SelectColorViewModel f222363h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f222364i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SelectColorAdapter f222365j;

    public class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SelectColorFragment f222366c;

        public a(SelectColorFragment r100) {
            this.f222366c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            this.f222366c.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L12;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public SelectColorViewModel Z90() {
        return (SelectColorViewModel) ViewModelProviders.of(getActivity()).get(SelectColorViewModel.class);
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment
    public View getContentView() {
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.select_color_fragment, null);
        TextView r101 = (TextView) r100.findViewById(R.id.title);
        this.f222364i = r101;
        r101.setOnClickListener(new a(this));
        RecyclerView r102 = (RecyclerView) r100.findViewById(R.id.colorList);
        SelectColorDecoration r103 = new SelectColorDecoration(getContext());
        SelectColorAdapter r104 = new SelectColorAdapter();
        this.f222365j = r104;
        r102.setAdapter(r104);
        r102.setLayoutManager(new GridLayoutManager(getContext(), 5, 1, false));
        r102.addItemDecoration(r103);
        SelectColorAdapter r105 = this.f222365j;
        r105.f222354c = r103;
        r105.f222355d = new b(this);
        this.f222363h.getSelectParam().observe(this, new c(this));
        return r100;
    }

    static {
    }

    public SelectColorFragment() {
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        getActivity();
        this.f222363h = Z90();
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        if (r101.getWindow() == null) goto L5;
        WindowManager.LayoutParams r102 = r101.getWindow().getAttributes();
        int r103 = (int) (r102.height + getResources().getDimension(R.dimen.toolbar_menu_height));
        r102.height = r103;
        r102.height = (int) (r103 + (getResources().getDimension(R.dimen.doc_input_divider_height) * 2.0f));
    L5:
        return r101;
    }
}
