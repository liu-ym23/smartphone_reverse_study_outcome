package com.bytedance.ee.bear.drive.test.item;

import android.view.LayoutInflater;
import android.view.View;
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
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveUploadTestItem implements z85.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f224650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f224651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public UDSwitch f224652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f224653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SpaceEditText f224654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f224655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f224656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public UDButton f224657h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f224658i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f224659j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CompositeDisposable f224660k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f224661l;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J,\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0017¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/drive/test/item/DriveUploadTestItem$TestUploadCallback;", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback;", "<init>", "(Lcom/bytedance/ee/bear/drive/test/item/DriveUploadTestItem;)V", "updateProgress", "", "key", "", "info", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback$TransmissionInfo;", "extra", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback$Extra;", "onFailed", "errorCode", "", "mountNodePoint", "bytesTotal", "", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class TestUploadCallback implements UploadCallback {
        final /* synthetic */ DriveUploadTestItem this$0;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f224662a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ DriveUploadTestItem f224663b;

            public a(int r100, DriveUploadTestItem r101) {
                this.f224662a = r100;
                this.f224663b = r101;
            }

            public final void a() {
                tt5.a.h("DriveUploadTestItem", "upload file, onFailed: errorCode=" + this.f224662a);
                DriveUploadTestItem r100 = this.f224663b;
                r100.f224661l = false;
                UDButton r101 = r100.f224657h;
                TextView r102 = null;
                if (r101 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("btnStart");
                r101 = null;
            L5:
                r101.setText(this.f224663b.getActivity().getString(R.string.test_upload_file_start));
                TextView r103 = this.f224663b.f224656g;
                if (r103 != null) goto L8;
                Intrinsics.throwUninitializedPropertyAccessException("tvUploadProgress");
            L9:
                r102.setText(this.f224663b.getActivity().getString(R.string.test_upload_file_progress_fail) + " : " + this.f224662a);
                return;
            L8:
                r102 = r103;
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

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ UploadCallback.b f224664a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ DriveUploadTestItem f224665b;

            public b(UploadCallback.b r100, DriveUploadTestItem r101) {
                this.f224664a = r100;
                this.f224665b = r101;
            }

            public final void a() {
                tt5.a.h("DriveUploadTestItem", "upload file, status: " + this.f224664a.f232490a + ", bytesTransferred=" + this.f224664a.f232491b + ", bytesTotal=" + this.f224664a.f232492c);
                TextView r100 = null;
                if (this.f224664a.f232490a != DriveFile.Status.SUCCESS) goto L8;
                DriveUploadTestItem r101 = this.f224665b;
                r101.f224661l = false;
                UDButton r102 = r101.f224657h;
                if (r102 != null) goto L7;
                Intrinsics.throwUninitializedPropertyAccessException("btnStart");
                r102 = null;
            L7:
                r102.setText(this.f224665b.getActivity().getString(R.string.test_upload_file_start));
            L8:
                UploadCallback.b r103 = this.f224664a;
                double r104 = (((double) 100) * r103.f232491b) / r103.f232492c;
                TextView r105 = this.f224665b.f224656g;
                if (r105 != null) goto L11;
                Intrinsics.throwUninitializedPropertyAccessException("tvUploadProgress");
            L12:
                r100.setText(this.f224665b.getActivity().getString(R.string.test_upload_file_progress_parse, new Object[]{String.valueOf(r104)}));
                return;
            L11:
                r100 = r105;
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

        public TestUploadCallback(DriveUploadTestItem r100) {
            this.this$0 = r100;
        }

        @Override // com.bytedance.ee.bear.middleground.drive.export.UploadCallback
        public boolean updateProgress(String r100, UploadCallback.b r101, UploadCallback.a r102) {
            Intrinsics.checkNotNullParameter(r101, "info");
            Intrinsics.checkNotNullParameter(r102, "extra");
            com.bytedance.ee.util.ui.m.a(new b(r101, this.this$0));
            return false;
        }

        @Override // com.bytedance.ee.bear.middleground.drive.export.UploadCallback
        public boolean onFailed(String r100, int r101, String r102, long r103) {
            com.bytedance.ee.util.ui.m.a(new a(r101, this.this$0));
            return false;
        }
    }

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveUploadTestItem f224666a;

        public b(DriveUploadTestItem r100) {
            this.f224666a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            DriveUploadTestItem r101 = this.f224666a;
            r101.getClass();
            FragmentActivity r102 = r101.f224650a;
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            UDDialogBuilder r103 = new UDDialogBuilder(r102);
            r103.autoDismiss(true);
            View r104 = r101.f224651b;
            if (r104 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
            r104 = null;
        L5:
            Intrinsics.checkNotNullParameter(r104, "value");
            r103.rootLayout(r104);
            UDDialog r105 = r103.build();
            if (DialogLancet.shouldBlockDialogShow(r105) == false) goto L12;
            DialogLancet.handleBlockedDialogShow(r105);
            return;
        L12:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
        L9:
            DialogLancet.beforeDialogShow(r105);
            r105.show();
            DialogLancet.afterDialogShow(r105);
        }
    }

    static {
    }

    @Override // z85.a
    public final View.OnClickListener a() {
        UDButton r100 = null;
        View r101 = LayoutInflater.from(this.f224650a).inflate(R.layout.drive_test_upload_file_layout, null);
        this.f224651b = r101;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r101 = null;
    L5:
        this.f224652c = (UDSwitch) r101.findViewById(R.id.switchView);
        View r102 = this.f224651b;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r102 = null;
    L8:
        this.f224653d = (TextView) r102.findViewById(R.id.tv_upload_type);
        View r103 = this.f224651b;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r103 = null;
    L11:
        this.f224654e = (SpaceEditText) r103.findViewById(R.id.edt_code);
        View r104 = this.f224651b;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r104 = null;
    L14:
        this.f224655f = (TextView) r104.findViewById(R.id.tv_upload_file_selection);
        View r105 = this.f224651b;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r105 = null;
    L17:
        this.f224656g = (TextView) r105.findViewById(R.id.tv_upload_progress);
        View r106 = this.f224651b;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r106 = null;
    L20:
        this.f224657h = (UDButton) r106.findViewById(R.id.btn_start);
        UDSwitch r107 = this.f224652c;
        if (r107 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("switchView");
        r107 = null;
    L23:
        r107.setOnCheckedChangeListener(new g(this));
        SpaceEditText r108 = this.f224654e;
        if (r108 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("edtCode");
        r108 = null;
    L26:
        r108.setText(this.f224650a.getString(R.string.test_upload_file_auth_code));
        TextView r109 = this.f224655f;
        if (r109 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("tvUploadFileSelection");
        r109 = null;
    L29:
        r109.setOnClickListener(new h(this));
        UDButton r110 = this.f224657h;
        if (r110 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("btnStart");
    L33:
        r100.setOnClickListener(new i(this));
        return new b(this);
    L32:
        r100 = r110;
        goto L33
    }

    @Override // z85.a
    public final String getButtonName() {
        return this.f224650a.getString(R.string.test_upload_file);
    }

    public final FragmentActivity getActivity() {
        return this.f224650a;
    }

    public DriveUploadTestItem(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f224650a = r100;
        this.f224660k = new CompositeDisposable();
        com.bytedance.ee.bear.drive.sdk.service.g r101 = ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.c(com.bytedance.ee.bear.drive.sdk.service.f.class, null, null, 6)).d0();
        r101.init();
        r101.o();
    }
}
