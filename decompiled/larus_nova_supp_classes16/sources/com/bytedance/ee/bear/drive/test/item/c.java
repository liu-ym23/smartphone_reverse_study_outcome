package com.bytedance.ee.bear.drive.test.item;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.drive.services.v;
import com.bytedance.ee.util.io.FileUtils;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements z85.a {
    public final FragmentActivity a;
    public View b;
    public UDSwitch c;
    public TextView d;
    public UDButton e;
    public boolean f;
    public String g;
    public UDDialog h;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            c r5 = this.a;
            r5.getClass();
            FragmentActivity r0 = r5.a;
            Intrinsics.checkNotNullParameter(r0, "context");
            UDDialogBuilder r1 = new UDDialogBuilder(r0);
            r1.autoDismiss(true);
            View r2 = r5.b;
            if (r2 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
            r2 = null;
        L5:
            Intrinsics.checkNotNullParameter(r2, "value");
            r1.rootLayout(r2);
            UDDialog r3 = r1.build();
            if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L13;
            DialogLancet.handleBlockedDialogShow(r3);
        L10:
            r5.h = r3;
            return;
        L13:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
        L9:
            DialogLancet.beforeDialogShow(r3);
            r3.show();
            DialogLancet.afterDialogShow(r3);
            goto L10
        }
    }

    static {
    }

    @Override // z85.a
    public final View.OnClickListener a() {
        Button r2 = null;
        View r0 = LayoutInflater.from(this.a).inflate(2131560238, null);
        this.b = r0;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r0 = null;
    L5:
        this.c = r0.findViewById(2131387948);
        View r1 = this.b;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r1 = null;
    L8:
        this.d = (TextView) r1.findViewById(2131391339);
        View r3 = this.b;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r3 = null;
    L11:
        this.e = r3.findViewById(2131364821);
        int r4 = v.a;
        y85.a r5 = v.a.a();
        if (r5 == null) goto L29;
        this.f = r5.b;
        this.g = r5.c;
        UDSwitch r6 = this.c;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("switchView");
        r6 = null;
    L16:
        r6.setChecked(r5.a);
        CharSequence r7 = FileUtils.x(r5.b, r5.c);     // Catch: Exception -> L19
    L21:
        TextView r8 = this.d;
        if (r8 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("tvSaveFileSelection");
        r8 = null;
    L25:
        if (TextUtils.isEmpty(r7) == false) goto L28;
        r7 = this.a.getText(2131914296);
    L28:
        r8.setText(r7);
    L19:
        e = move-exception;
        tt5.a.k("DriveUploadCacheTestItem", "getFileName fail: " + e);
        r7 = null;
    L29:
        TextView r9 = this.d;
        if (r9 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("tvSaveFileSelection");
        r9 = null;
    L32:
        r9.setOnClickListener(new d(this));
        Button r10 = this.e;
        if (r10 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("btnSave");
    L36:
        r2.setOnClickListener(new e(this));
        return new b(this);
    L35:
        r2 = r10;
        goto L36
    }

    @Override // z85.a
    public final String getButtonName() {
        return this.a.getString(2131914299);
    }

    public final FragmentActivity getActivity() {
        return this.a;
    }

    public c(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
    }
}
