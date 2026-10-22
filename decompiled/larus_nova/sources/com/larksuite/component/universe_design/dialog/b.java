package com.larksuite.component.universe_design.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b extends UDDialogController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f284872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f284873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public UDCheckBox.c f284874c;

    public static final class a implements UDCheckBox.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f284875a;

        public a(b r100) {
            this.f284875a = r100;
        }

        @Override // com.larksuite.component.universe_design.checkbox.UDCheckBox.c
        public final void a(UDCheckBox r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "buttonView");
            b r102 = this.f284875a;
            r102.f284872a = r101;
            r102.getClass();
            UDCheckBox.c r103 = this.f284875a.f284874c;
            if (r103 == null) goto L6;
            r103.a(r100, r101);
            return;
        }
    }

    /* JADX INFO: renamed from: com.larksuite.component.universe_design.dialog.b$b, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC3916b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDCheckBox f284876a;

        public ViewOnClickListenerC3916b(UDCheckBox r100) {
            this.f284876a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            UDCheckBox r101 = this.f284876a;
            if (r101 == null) goto L6;
            r101.toggle();
            return;
        }
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final int getDefaultContentRes() {
        return R.layout.ud_dialog_checkbox_content;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateContent() {
        View r100 = super.onCreateContent();
        if (r100 != null) goto L7;
        return null;
    L7:
        if (TextUtils.isEmpty(getMMessage()) == false) goto L11;
        TextView r101 = (TextView) r100.findViewById(R.id.ud_dialog_content_message_tv);
        if (r101 == null) goto L11;
        r101.setVisibility(8);
    L11:
        UDCheckBox r102 = (UDCheckBox) r100.findViewById(R.id.ud_dialog_checkbox);
        if (r102 == null) goto L14;
        r102.setChecked(this.f284872a);
        r102.setOnCheckedChangeListener(new a(this));
    L14:
        TextView r103 = (TextView) r100.findViewById(R.id.ud_dialog_checkbox_hint);
        if (r103 == null) goto L17;
        r103.setText(this.f284873b);
        r103.setOnClickListener(new ViewOnClickListenerC3916b(r102));
    L17:
        return r100;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateFooter() {
        View r100 = super.onCreateFooter();
        if (r100 != null) goto L6;
        return null;
    L6:
        r100.findViewById(R.id.ud_dialog_btn_primary);
        return r100;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f284873b = "";
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r100, UDDialog r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Intrinsics.checkNotNullParameter(r101, "dialog");
        if ((r100 instanceof com.larksuite.component.universe_design.dialog.a) == false) goto L7;
        super.apply(r100, r101);
        com.larksuite.component.universe_design.dialog.a r102 = (com.larksuite.component.universe_design.dialog.a) r100;
        r102.getClass();
        this.f284872a = false;
        this.f284873b = r102.f284870a;
        this.f284874c = r102.f284871b;
        return;
    L7:
        throw new IllegalArgumentException("builder should be UDCheckBoxDialogBuilder, but actually ".concat(r100.getClass().getSimpleName()).toString());
    }
}
