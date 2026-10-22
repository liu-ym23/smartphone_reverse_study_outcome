package com.bytedance.ee.bear.drive.test.item;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.drive.services.v;
import com.bytedance.ee.util.io.FileUtils;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements z85.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f224670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f224671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public UDSwitch f224672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f224673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public UDButton f224674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f224675f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f224676g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public UDDialog f224677h;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f224678a;

        public b(c r100) {
            this.f224678a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            c r101 = this.f224678a;
            r101.getClass();
            FragmentActivity r102 = r101.f224670a;
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            UDDialogBuilder r103 = new UDDialogBuilder(r102);
            r103.autoDismiss(true);
            View r104 = r101.f224671b;
            if (r104 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
            r104 = null;
        L5:
            Intrinsics.checkNotNullParameter(r104, "value");
            r103.rootLayout(r104);
            UDDialog r105 = r103.build();
            if (DialogLancet.shouldBlockDialogShow(r105) == false) goto L13;
            DialogLancet.handleBlockedDialogShow(r105);
        L10:
            r101.f224677h = r105;
            return;
        L13:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
        L9:
            DialogLancet.beforeDialogShow(r105);
            r105.show();
            DialogLancet.afterDialogShow(r105);
            goto L10
        }
    }

    static {
    }

    @Override // z85.a
    public final View.OnClickListener a() {
        UDButton r100 = null;
        View r101 = LayoutInflater.from(this.f224670a).inflate(R.layout.drive_test_upload_save_layout, null);
        this.f224671b = r101;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r101 = null;
    L5:
        this.f224672c = (UDSwitch) r101.findViewById(R.id.switch_view);
        View r102 = this.f224671b;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r102 = null;
    L8:
        this.f224673d = (TextView) r102.findViewById(R.id.tv_save_file_selection);
        View r103 = this.f224671b;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r103 = null;
    L11:
        this.f224674e = (UDButton) r103.findViewById(R.id.btn_save);
        int r104 = v.f224636a;
        y85.a r105 = v.a.a();
        if (r105 == null) goto L29;
        this.f224675f = r105.f566909b;
        this.f224676g = r105.f566910c;
        UDSwitch r106 = this.f224672c;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("switchView");
        r106 = null;
    L16:
        r106.setChecked(r105.f566908a);
        CharSequence r107 = FileUtils.x(r105.f566909b, r105.f566910c);     // Catch: Exception -> L19
    L21:
        TextView r108 = this.f224673d;
        if (r108 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("tvSaveFileSelection");
        r108 = null;
    L25:
        if (TextUtils.isEmpty(r107) == false) goto L28;
        r107 = this.f224670a.getText(R.string.test_upload_file_selection);
    L28:
        r108.setText(r107);
    L19:
        e = move-exception;
        tt5.a.k("DriveUploadCacheTestItem", "getFileName fail: " + e);
        r107 = null;
    L29:
        TextView r109 = this.f224673d;
        if (r109 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("tvSaveFileSelection");
        r109 = null;
    L32:
        r109.setOnClickListener(new d(this));
        UDButton r110 = this.f224674e;
        if (r110 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("btnSave");
    L36:
        r100.setOnClickListener(new e(this));
        return new b(this);
    L35:
        r100 = r110;
        goto L36
    }

    @Override // z85.a
    public final String getButtonName() {
        return this.f224670a.getString(R.string.test_upload_save);
    }

    public final FragmentActivity getActivity() {
        return this.f224670a;
    }

    public c(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f224670a = r100;
    }
}
