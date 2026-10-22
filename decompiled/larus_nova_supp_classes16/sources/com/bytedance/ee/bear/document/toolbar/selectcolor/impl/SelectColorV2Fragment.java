package com.bytedance.ee.bear.document.toolbar.selectcolor.impl;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.RectColorView;
import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.t;
import com.larksuite.component.universe_design.button.UDButton;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectColorV2Fragment extends BaseAntiScreenshotsDialogFragment {
    public static final /* synthetic */ int p = 0;
    public SelectColorV2ViewModel h;
    public SelectColorV2Adapter i;
    public SelectColorV2Adapter j;
    public GridLayoutManager k;
    public GridLayoutManager l;
    public UDButton m;
    public Dialog n;
    public View o;

    public class a extends t {
        public final /* synthetic */ SelectColorV2Fragment c;

        public a(SelectColorV2Fragment r1) {
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

    public class b extends t {
        public final /* synthetic */ SelectColorItemDivider c;
        public final /* synthetic */ SelectColorItemDivider d;
        public final /* synthetic */ SelectColorV2Fragment e;

        public final void a(View r4) {
            Highlight r5 = (Highlight) this.e.h.getHighlightLiveData().getValue();
            if (r5 == null) goto L6;
            SelectColorItemDivider r0 = this.c;
            Objects.requireNonNull(r0);
            r0.c = -1;
            SelectColorItemDivider r1 = this.d;
            Objects.requireNonNull(this.c);
            r1.c = -1;
            this.e.i.y2(null);
            this.e.j.y2(null);
            this.e.h.selectColor(null, null, r5.getClear(), r5.getReset());
            return;
        }

        public b(SelectColorV2Fragment r1, SelectColorItemDivider r2, SelectColorItemDivider r3) {
            this.e = r1;
            this.c = r2;
            this.d = r3;
        }
    }

    public View getContentView() {
        Highlight.ColorItem r2 = null;
        View r0 = LayoutInflater.from(getContext()).inflate(2131563709, null);
        BaseTitleBar r1 = r0.findViewById(2131388772);
        r1.setMainTitleSize(17.0f);
        r1.setLeftClickListener(new a(this));
        Highlight r3 = (Highlight) this.h.getHighlightLiveData().getValue();
        if (r3 != null) goto L6;
        r3 = new Highlight();
    L6:
        RecyclerView r4 = r0.findViewById(2131388371);
        RecyclerView r5 = r0.findViewById(2131363763);
        GridLayoutManager r6 = new GridLayoutManager(getContext(), 7);
        this.k = r6;
        r4.setLayoutManager(r6);
        GridLayoutManager r7 = new GridLayoutManager(getContext(), 7);
        this.l = r7;
        r5.setLayoutManager(r7);
        r0.findViewById(2131367179).setBackgroundResource(2131100548);
        int r8 = h18.d.d(getContext(), 2131168297);
        final SelectColorItemDivider r9 = new SelectColorItemDivider(getContext());
        r9.b = r8;
        r4.addItemDecoration(r9);
        final SelectColorItemDivider r10 = new SelectColorItemDivider(getContext());
        r10.b = r8;
        r5.addItemDecoration(r10);
        if (r3.getSelected() == null) goto L9;
        Highlight.ColorItem r11 = r3.getSelected().getText();
    L10:
        int r12 = h18.d.d(getContext(), 2131168369);
        SelectColorV2Adapter r13 = new SelectColorV2Adapter("text", r3.getText(), r11, r12);
        this.i = r13;
        r4.setAdapter(r13);
        if (r3.getSelected() == null) goto L13;
        r2 = r3.getSelected().getBackground();
    L13:
        SelectColorV2Adapter r14 = new SelectColorV2Adapter(RectColorView.RectColorType.TYPE_BACKGROUND, r3.getBackground(), r2, r12);
        this.j = r14;
        r5.setAdapter(r14);
        SelectColorV2Adapter r16 = this.i;
        r16.f = new e(this);
        r16.g = new f(r9);
        SelectColorV2Adapter r17 = this.j;
        r17.f = new g(this);
        r17.g = new h(r10);
        UDButton r18 = r0.findViewById(2131366928);
        this.m = r18;
        r18.setOnClickListener(new b(this, r9, r10));
        this.h.getHighlightLiveData().observe(this, new i(this));
        return r0;
    L9:
        r11 = null;
        goto L10
    }

    static {
    }

    public SelectColorV2Fragment() {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.h = (SelectColorV2ViewModel) q.a(this, SelectColorV2ViewModel.class);
    }

    public Dialog onCreateDialog(Bundle r3) {
        Dialog r4 = super.onCreateDialog(r3);
        this.n = r4;
        r4.requestWindowFeature(1);
        View r5 = getContentView();
        this.o = r5;
        ViewGroup r6 = (ViewGroup) r5.getParent();
        if (r6 == null) goto L5;
        r6.removeAllViews();
    L5:
        this.n.setContentView(this.o);
        if (this.n.getWindow() == null) goto L9;
        WindowManager.LayoutParams r7 = this.n.getWindow().getAttributes();
        r7.type = UploadResult.UPLOAD_CACELL;
        r7.width = -1;
        r7.softInputMode = 1;
        r7.flags = (r7.flags & (-3)) | 8;
        r7.gravity = 80;
        this.n.getWindow().setAttributes(r7);
        this.n.getWindow().setBackgroundDrawableResource(R.color.transparent);
        this.n.setCanceledOnTouchOutside(false);
    L9:
        return this.n;
    }
}
