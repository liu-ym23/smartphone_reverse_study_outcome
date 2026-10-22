package com.bytedance.ee.bear.drive.test.item;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveUploadTestItem implements z85.a {
    public final FragmentActivity a;
    public View b;
    public UDSwitch c;
    public TextView d;
    public SpaceEditText e;
    public TextView f;
    public TextView g;
    public UDButton h;
    public String i;
    public boolean j;
    public final CompositeDisposable k;
    public boolean l;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J,\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0017¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/drive/test/item/DriveUploadTestItem$TestUploadCallback;", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback;", "<init>", "(Lcom/bytedance/ee/bear/drive/test/item/DriveUploadTestItem;)V", "updateProgress", "", "key", "", "info", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback$TransmissionInfo;", "extra", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback$Extra;", "onFailed", "errorCode", "", "mountNodePoint", "bytesTotal", "", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class TestUploadCallback implements UploadCallback {
        final /* synthetic */ DriveUploadTestItem this$0;

        public static final class a implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ DriveUploadTestItem b;

            public a(int r1, DriveUploadTestItem r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                tt5.a.h("DriveUploadTestItem", "upload file, onFailed: errorCode=" + this.a);
                DriveUploadTestItem r0 = this.b;
                r0.l = false;
                Button r1 = r0.h;
                TextView r2 = null;
                if (r1 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("btnStart");
                r1 = null;
            L5:
                r1.setText(this.b.getActivity().getString(2131914297));
                TextView r3 = this.b.g;
                if (r3 != null) goto L8;
                Intrinsics.throwUninitializedPropertyAccessException("tvUploadProgress");
            L9:
                r2.setText(this.b.getActivity().getString(2131914292) + " : " + this.a);
                return;
            L8:
                r2 = r3;
                goto L9
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ UploadCallback.b a;
            public final /* synthetic */ DriveUploadTestItem b;

            public b(UploadCallback.b r1, DriveUploadTestItem r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                tt5.a.h("DriveUploadTestItem", "upload file, status: " + this.a.a + ", bytesTransferred=" + this.a.b + ", bytesTotal=" + this.a.c);
                TextView r2 = null;
                if (this.a.a != DriveFile.Status.SUCCESS) goto L8;
                DriveUploadTestItem r0 = this.b;
                r0.l = false;
                Button r1 = r0.h;
                if (r1 != null) goto L7;
                Intrinsics.throwUninitializedPropertyAccessException("btnStart");
                r1 = null;
            L7:
                r1.setText(this.b.getActivity().getString(2131914297));
            L8:
                UploadCallback.b r4 = this.a;
                double r3 = (((double) 100) * r4.b) / r4.c;
                TextView r5 = this.b.g;
                if (r5 != null) goto L11;
                Intrinsics.throwUninitializedPropertyAccessException("tvUploadProgress");
            L12:
                r2.setText(this.b.getActivity().getString(2131914294, new Object[]{String.valueOf(r3)}));
                return;
            L11:
                r2 = r5;
                goto L12
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public TestUploadCallback(DriveUploadTestItem r1) {
            this.this$0 = r1;
        }

        public boolean updateProgress(String r1, UploadCallback.b r2, UploadCallback.a r3) {
            Intrinsics.checkNotNullParameter(r2, "info");
            Intrinsics.checkNotNullParameter(r3, "extra");
            com.bytedance.ee.util.ui.m.a(new b(r2, this.this$0));
            return false;
        }

        public boolean onFailed(String r1, int r2, String r3, long r4) {
            com.bytedance.ee.util.ui.m.a(new a(r2, this.this$0));
            return false;
        }
    }

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ DriveUploadTestItem a;

        public b(DriveUploadTestItem r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            DriveUploadTestItem r4 = this.a;
            r4.getClass();
            FragmentActivity r0 = r4.a;
            Intrinsics.checkNotNullParameter(r0, "context");
            UDDialogBuilder r1 = new UDDialogBuilder(r0);
            r1.autoDismiss(true);
            View r5 = r4.b;
            if (r5 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
            r5 = null;
        L5:
            Intrinsics.checkNotNullParameter(r5, "value");
            r1.rootLayout(r5);
            UDDialog r6 = r1.build();
            if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L12;
            DialogLancet.handleBlockedDialogShow(r6);
            return;
        L12:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
        L9:
            DialogLancet.beforeDialogShow(r6);
            r6.show();
            DialogLancet.afterDialogShow(r6);
        }
    }

    static {
    }

    @Override // z85.a
    public final View.OnClickListener a() {
        Button r2 = null;
        View r0 = LayoutInflater.from(this.a).inflate(2131560237, null);
        this.b = r0;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r0 = null;
    L5:
        this.c = r0.findViewById(2131387837);
        View r1 = this.b;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r1 = null;
    L8:
        this.d = (TextView) r1.findViewById(2131391663);
        View r3 = this.b;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r3 = null;
    L11:
        this.e = r3.findViewById(2131371486);
        View r4 = this.b;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r4 = null;
    L14:
        this.f = (TextView) r4.findViewById(2131391661);
        View r5 = this.b;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r5 = null;
    L17:
        this.g = (TextView) r5.findViewById(2131391662);
        View r6 = this.b;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r6 = null;
    L20:
        this.h = r6.findViewById(2131364840);
        UDSwitch r7 = this.c;
        if (r7 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("switchView");
        r7 = null;
    L23:
        r7.setOnCheckedChangeListener(new g(this));
        EditText r8 = this.e;
        if (r8 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("edtCode");
        r8 = null;
    L26:
        r8.setText(this.a.getString(2131914288));
        TextView r9 = this.f;
        if (r9 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("tvUploadFileSelection");
        r9 = null;
    L29:
        r9.setOnClickListener(new h(this));
        Button r10 = this.h;
        if (r10 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("btnStart");
    L33:
        r2.setOnClickListener(new i(this));
        return new b(this);
    L32:
        r2 = r10;
        goto L33
    }

    @Override // z85.a
    public final String getButtonName() {
        return this.a.getString(2131914287);
    }

    public final FragmentActivity getActivity() {
        return this.a;
    }

    public DriveUploadTestItem(FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        this.a = r3;
        this.k = new CompositeDisposable();
        com.bytedance.ee.bear.drive.sdk.service.g r4 = ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.c(com.bytedance.ee.bear.drive.sdk.service.f.class, null, null, 6)).d0();
        r4.init();
        r4.o();
    }
}
