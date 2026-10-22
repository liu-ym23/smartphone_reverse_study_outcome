package com.bytedance.ee.bear.drive.view.preview.wps;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.biz.permission.model.DrivePermissionInfoViewModel;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.google.gson.annotations.SerializedName;
import com.larksuite.component.universe_design.toast.UDToast;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class WpsCanWriteController implements e {
    public final WpsView a;
    public volatile boolean b;
    public PreviewViewModel c;
    public DrivePermissionInfoViewModel d;
    public LifecycleOwner e;
    public boolean f;
    public boolean g;
    public final boolean h;
    public WpsViewModel i;
    public final k j;
    public final l k;
    public final a l;
    public final m m;

    public class MemoryOverPushResult implements Serializable {

        @SerializedName("biz_code")
        int bizCode;

        @SerializedName("edit_limit")
        int editLimit;
        final /* synthetic */ WpsCanWriteController this$0;

        public int getBizCode() {
            return this.bizCode;
        }

        public int getEditLimit() {
            return this.editLimit;
        }

        public void setBizCode(int r1) {
            this.bizCode = r1;
        }

        public void setEditLimit(int r1) {
            this.editLimit = r1;
        }

        public MemoryOverPushResult(WpsCanWriteController r1, int r2, int r3) {
            this.this$0 = r1;
            this.bizCode = r2;
            this.editLimit = r3;
        }
    }

    public class a implements Observer<u55.b> {
        public u55.b a;
        public final /* synthetic */ WpsCanWriteController b;

        public a(WpsCanWriteController r1) {
            this.b = r1;
        }

        public final void onChanged(Object r5) {
            u55.b r6 = (u55.b) r5;
            boolean r0 = r6.c();
            u55.b r1 = this.a;
            if (r1 != null) goto L5;
        L7:
            this.a = r6;
            this.b.a.getEntity().c = r0;
            tt5.a.h("WpsCanWriteController", "liveInnerFileEditable editable=" + r0 + ", lastSuccess=" + this.b.a.r + ", isEditMode=" + this.b.a.getEntity().a() + ", accessTokenNeedEdit= " + this.b.f);
            if (r0 == true) goto L22;
            if (this.a.b.a.isSecretFileEdit() == false) goto L12;
            Toast.showFailureText(this.b.a.getContext(), this.b.a.getContext().getString(2131889703), 0);
        L12:
            WpsView r7 = this.b.a;
            if (r7.r == false) goto L15;
            String r8 = xo5.a.c(r7.getContext(), 2131887280, "type", this.b.a.getContext().getString(2131888224));
            UDToast.a r2 = UDToast.build(this.b.a.getContext());
            r2.g(r8);
            r2.h();
        L15:
            a65.a.a(this.b.c);
            this.b.c.liveInnerExtraViewVisible().postValue(Boolean.TRUE);
            if (this.b.a.getEntity().a() == false) goto L37;
            WpsView.c r9 = this.b.a.getEntity();
            if (r9.b != 2) goto L20;
            r9.b = 1;
        L20:
            this.b.a.show();
            return;
        L37:
            return;
        L22:
            if (this.b.a.r == true) goto L24;
        L28:
            WpsView r10 = this.b.a;
            if (r10.r == true) goto L31;
            return;
        L31:
            if (r10.getEntity().a() == true) goto L40;
            WpsCanWriteController r11 = this.b;
            if (r11.f == false) goto L41;
            a65.a.b(r11.c);
            return;
        L41:
            return;
        L40:
            return;
        L24:
            if (r6.k() == false) goto L26;
            int r12 = 2131887512;
        L27:
            String r13 = xo5.a.c(this.b.a.getContext(), 2131887280, "type", this.b.a.getContext().getString(r12));
            UDToast.a r3 = UDToast.build(this.b.a.getContext());
            r3.g(r13);
            r3.h();
            goto L28
        L26:
            r12 = 2131888223;
            goto L27
        L5:
            if (r1.c() != r0) goto L7;
            tt5.a.h("WpsCanWriteController", "liveInnerFileEditable receive the same permission info");
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ErrCode.values().length];
            a = r0;
            r0[ErrCode.WPS_PREVIEW_GET_ACCESS_TOKEN_USER_MEMORY_OVER_LIMIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[ErrCode.WPS_PREVIEW_GET_ACCESS_TOKEN_TENANT_MEMORY_OVER_LIMIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[ErrCode.WPS_PREVIEW_GET_ACCESS_TOKEN_EDITOR_MEMORY_OVER_LIMIT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.e
    public final void a() {
        if (this.b == true) goto L6;
        tt5.a.h("WpsCanWriteController", "onSwitchHide current file can't be editted and forced to read");
        return;
    L6:
        a65.a.a(this.c);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.e
    public final void b() {
        if (this.b == true) goto L5;
    L13:
        tt5.a.h("WpsCanWriteController", "onSwitchShow current file can't be editted and forced to read");
        return;
    L5:
        if (this.a.getEntity().b == 2) goto L13;
        if (this.a.getEntity().c == true) goto L10;
        return;
    L10:
        if (this.f == false) goto L16;
        a65.a.b(this.c);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.e
    public final boolean c() {
        if (this.g == false) goto L7;
        this.g = false;
        return true;
    L7:
        if (this.a.getEntity().a() == true) goto L9;
    L13:
        return false;
    L9:
        if (this.f == false) goto L13;
        if (this.b == false) goto L13;
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.e
    public final WpsMainOptions f() {
        WpsMainOptions r0 = new WpsMainOptions();
        String r2 = "normal";
        if (this.b == true) goto L11;
        tt5.a.h("WpsCanWriteController", "generateWpsMainOptions current file can't be editted and forced to read");
        if (this.a.t.a == true) goto L8;
        r2 = WpsMainOptions.OPEN_MODE_SIMPLE;
    L8:
        r0.mode = r2;
        return r0;
    L11:
        if (this.a.t.a == false) goto L14;
        r0.wordOptions = new WpsWordOptions();
        WpsWordOptions.Mobile r1 = new WpsWordOptions.Mobile();
        r1.isOpenIntoEdit = Boolean.TRUE;
        r0.wordOptions.mobile = r1;
    L14:
        if (this.a.t.b == true) goto L16;
    L18:
        r0.mode = "normal";
        r0.hiddenCommandBarOptions = q.a;
        return r0;
    L16:
        if (this.h == false) goto L18;
        r0.excelOptions = new r();
        goto L18
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.e
    public final String g() {
        if (this.b == true) goto L5;
        return "";
    L5:
        WpsView r0 = this.a;
        com.bytedance.ee.bear.drive.view.preview.wps.b r2 = r0.t;
        if (r2.a == false) goto L9;
        return "";
    L9:
        if (r2.b == true) goto L13;
        if (r2.c == true) goto L13;
    L18:
        return "&hidecmb";
    L13:
        if (r0.getEntity().a() == false) goto L18;
        if (this.f == false) goto L18;
        return "";
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.e
    public final void onDetachedFromWindow() {
        this.a.setPadding(0, 0, 0, 0);
        if (this.c != null) goto L5;
    L9:
        tt5.a.h("WpsCanWriteController", "onDetachedFromWindow current file can't be editted and forced to read");
        return;
    L5:
        if (this.b == false) goto L9;
        this.c.liveInnerEditModeSwitchAction().removeObserver(this.k);
        this.d.getLiveInnerFilePermissionChanged().removeObserver(this.l);
        this.c.liveInnerWPSViewPaddingChanged().removeObserver(this.m);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.e
    public final void d(Throwable r6) {
        if (this.b == true) goto L6;
        tt5.a.h("WpsCanWriteController", "handleAuthTokenFailed current file can't be editted and forced to read");
        return;
    L6:
        a();
        if ((r6 instanceof DriveException) == true) goto L9;
    L31:
        this.a.m(r6);
        return;
    L9:
        if (this.f == false) goto L31;
        DriveException r0 = (DriveException) r6;
        int r2 = b.a[r0.getErrorCode().ordinal()];
        if (r2 != 1) goto L14;
        this.c.liveInnerMemoryOverLimit().postValue(90001061);
        this.f = false;
        this.a.show();
        return;
    L14:
        if (r2 != 2) goto L16;
        this.c.liveInnerMemoryOverLimit().postValue(11001);
        this.f = false;
        this.a.show();
        return;
    L16:
        if (r2 == 3) goto L18;
        this.a.m(r6);
        return;
    L18:
        this.f = false;
        if (this.a.getEntity().c == true) goto L33;
        this.a.show();
        return;
    L33:
        String r7 = xo5.a.c(this.a.getContext(), 2131889312, "number", String.valueOf((new JSONObject(((NetService.ServerErrorException) r0.getCause()).getData()).optInt("edit_limit") / 1024) / 1024));
        UDToast.a r1 = UDToast.build(this.a.getContext());
        r1.g(r7);
        r1.h();
        this.a.show();
        return;
    L25:
        e = move-exception;
        tt5.a.d("WpsCanWriteController", "parse editor memory over limit: " + e);
        this.f = false;
        this.a.show();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.e
    public final void e(ViewOwner r3) {
        this.e = r3.lifecycleOwner();
        this.c = (PreviewViewModel) r3.viewModel(PreviewViewModel.class);
        this.d = (DrivePermissionInfoViewModel) r3.viewModel(DrivePermissionInfoViewModel.class);
        this.i = (WpsViewModel) r3.viewModel(WpsViewModel.class);
        this.b = !this.a.t.d;
        if (this.c != null) goto L5;
    L9:
        tt5.a.h("WpsCanWriteController", "setPreviewModel current file can't be editted and forced to read");
        return;
    L5:
        if (this.b == false) goto L9;
        this.c.liveInnerEditModeSwitchAction().observe(this.e, this.k);
        this.d.getLiveInnerFilePermissionChanged().observe(this.e, this.l);
        this.c.liveInnerWPSViewPaddingChanged().observe(this.e, this.m);
        this.i.getEditLimitOverLiveData().observe(this.e, this.j);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ee.bear.drive.view.preview.wps.k] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.drive.view.preview.wps.l] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.ee.bear.drive.view.preview.wps.m] */
    public WpsCanWriteController(WpsView r2, boolean r3) {
        this.f = true;
        this.g = true;
        this.j = new k(this);
        this.k = new l(this);
        this.l = new a(this);
        this.m = new m(this);
        this.a = r2;
        this.h = r3;
    }
}
