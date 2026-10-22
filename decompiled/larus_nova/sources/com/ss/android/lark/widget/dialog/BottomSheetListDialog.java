package com.ss.android.lark.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes38.dex */
public class BottomSheetListDialog extends AppCompatDialog implements DialogInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.Adapter f445739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f445740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DialogInterface.OnClickListener f445741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f445742d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f445743e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DialogInterface.OnClickListener f445744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f445745g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f445746h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f445747i;

    @BindView(7382)
    TextView mMessageView;

    @BindView(7521)
    TextView mNegativeBtn;

    @BindView(7522)
    TextView mPositiveBtn;

    @BindView(7381)
    RecyclerView mRecyclerView;

    @BindView(7383)
    TextView mTitleView;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetListDialog f445748a;

        public a(BottomSheetListDialog r100) {
            this.f445748a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            BottomSheetListDialog r101 = this.f445748a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetListDialog f445749a;

        public b(BottomSheetListDialog r100) {
            this.f445749a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            BottomSheetListDialog r101 = this.f445749a;
            DialogInterface.OnClickListener r102 = r101.f445744f;
            if (r102 == null) goto L5;
            r102.onClick(r101, 0);
        L5:
            BottomSheetListDialog r103 = this.f445749a;
            Handler r104 = DialogLancet.resolveDialogHandler(r103);
            if (r104 != null) goto L8;
        L10:
            DialogLancet.beforeDialogDismiss(r103);
            r103.dismiss();     // Catch: Throwable -> L13 Exception -> L15
        L19:
            DialogLancet.afterDialogDismiss(r103);
            return;
        L15:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
            Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
            if (r105 == null) goto L19;
            com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r103);
            throw th;
        L8:
            if (Looper.myLooper() == r104.getLooper()) goto L10;
            r104.post(DialogLancet.createDismissRunnable(r103));
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetListDialog f445750a;

        public c(BottomSheetListDialog r100) {
            this.f445750a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            BottomSheetListDialog r101 = this.f445750a;
            DialogInterface.OnClickListener r102 = r101.f445741c;
            if (r102 == null) goto L5;
            r102.onClick(r101, 0);
        L5:
            BottomSheetListDialog r103 = this.f445750a;
            Handler r104 = DialogLancet.resolveDialogHandler(r103);
            if (r104 != null) goto L8;
        L10:
            DialogLancet.beforeDialogDismiss(r103);
            r103.dismiss();     // Catch: Throwable -> L13 Exception -> L15
        L19:
            DialogLancet.afterDialogDismiss(r103);
            return;
        L15:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
            Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
            if (r105 == null) goto L19;
            com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r103);
            throw th;
        L8:
            if (Looper.myLooper() == r104.getLooper()) goto L10;
            r104.post(DialogLancet.createDismissRunnable(r103));
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f445751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f445752b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f445753c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f445754d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public RecyclerView.Adapter f445755e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f445756f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public DialogInterface.OnClickListener f445757g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f445758h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public DialogInterface.OnClickListener f445759i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f445760j;

        public d(FragmentActivity r100) {
            this.f445752b = false;
            this.f445760j = true;
            this.f445751a = r100;
        }
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Window r100 = getWindow();
        if (r100 == null) goto L14;
        WindowManager.LayoutParams r101 = r100.getAttributes();
        r101.width = -1;
        r101.height = -2;
        r101.gravity = 80;
        r100.setAttributes(r101);
        return;
    L14:
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public BottomSheetListDialog(d r100) {
        super(r100.f445751a, R.style.customDialog);
        supportRequestWindowFeature(1);
        this.f445747i = r100.f445752b;
        this.f445739a = r100.f445755e;
        this.f445740b = r100.f445756f;
        this.f445741c = r100.f445757g;
        this.f445742d = r100.f445758h;
        this.f445744f = r100.f445759i;
        this.f445743e = r100.f445760j;
        this.f445745g = r100.f445753c;
        this.f445746h = r100.f445754d;
    }

    public final void I0(String r100) {
        this.f445742d = r100;
        this.mPositiveBtn.setText(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        getWindow().setSoftInputMode(16);
        super.onCreate(r100);
        setContentView(R.layout.bottom_sheet_list_dialog);
        ButterKnife.bind(this);
        BottomSheetBehavior.from((LinearLayout) findViewById(R.id.bottom_sheet)).setHideable(false);
        setCancelable(this.f445747i);
        setCanceledOnTouchOutside(true);
        findViewById(R.id.touch_outside).setOnClickListener(new a(this));
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        RecyclerView.Adapter r101 = this.f445739a;
        if (r101 == null) goto L5;
        this.mRecyclerView.setAdapter(r101);
    L5:
        this.mTitleView.setText(this.f445745g);
        this.mMessageView.setText(this.f445746h);
        this.mPositiveBtn.setText(this.f445742d);
        this.mPositiveBtn.setEnabled(this.f445743e);
        this.mPositiveBtn.setOnClickListener(new b(this));
        this.mNegativeBtn.setText(this.f445740b);
        this.mNegativeBtn.setOnClickListener(new c(this));
    }
}
