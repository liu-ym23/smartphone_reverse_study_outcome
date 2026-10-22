package com.ss.android.lark.utils;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.supervisor.token.Token;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.permission.StoragePermissionUtils;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes38.dex */
public final class h {

    public class a implements Consumer<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f444710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f444711b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Token f444712c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ k f444713d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f444714e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f444715f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f444716g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ e f444717h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f444718i;

        @Override // io.reactivex.functions.Consumer
        public final void accept(Boolean r110) throws Exception {
            Boolean r111 = r110;
            d r100 = this.f444710a;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L10:
            if (r111.booleanValue() == true) goto L26;
            if (r101 == false) goto L26;
            Activity r102 = this.f444711b;
            Token r103 = this.f444712c;
            k r104 = this.f444713d;
            String r105 = this.f444714e;
            int r106 = this.f444715f;
            boolean r107 = this.f444716g;
            e r112 = this.f444717h;
            int r108 = this.f444718i;
            String r109 = "";
            if (r104.e() == 0) goto L16;
            String r113 = UIHelper.mustacheFormat(r104.e());
        L20:
            if (r104.a() == 0) goto L23;
            r109 = UIHelper.mustacheFormat(r104.a());
        L25:
            com.larksuite.component.ui.dialog.d r114 = new com.larksuite.component.ui.dialog.d(r102);
            r114.k(r113);
            r114.h(r109);
            r114.f284132c.cancelable(false);
            r114.f284132c.cancelOnTouchOutside(false);
            r114.a(R.id.lkui_dialog_btn_right, R.string.Lark_Legacy_Settings, new j(r107, r102, r105, r106, r108, r103, r112, r104, r111));
            r114.a(R.id.lkui_dialog_btn_left, R.string.Lark_Legacy_LarkCancel, new i(r112, r111));
            r114.i();
            return;
        L23:
            if (r104.c().isEmpty() == true) goto L25;
            r109 = r104.c();
            goto L25
        L16:
            if (r104.f().isEmpty() == true) goto L18;
            r113 = r104.f();
            goto L20
        L18:
            r113 = "";
        L26:
            e r115 = this.f444717h;
            if (r115 == null) goto L31;
            r115.a(r111.booleanValue());
            return;
        L31:
            return;
        L5:
            if (r100.a() == true) goto L8;
            r101 = false;
            goto L10
        }

        public a(d r100, Activity r101, Token r102, k r103, String r104, int r105, boolean r106, e r107, int r108) {
            this.f444710a = r100;
            this.f444711b = r101;
            this.f444712c = r102;
            this.f444713d = r103;
            this.f444714e = r104;
            this.f444715f = r105;
            this.f444716g = r106;
            this.f444717h = r107;
            this.f444718i = r108;
        }
    }

    public class b implements d {
        public b() {
        }

        @Override // com.ss.android.lark.utils.h.d
        public final boolean a() {
            return true;
        }

        @Override // com.ss.android.lark.utils.h.d
        public final boolean b() {
            return true;
        }
    }

    public interface c extends StoragePermissionUtils.a {
    }

    public interface d {
        boolean a();

        boolean b();
    }

    public interface e {
        void a(boolean r100);
    }

    public static void b(FragmentActivity r100, e r110) {
        int r101 = n.f444741a;
        d(r100, r110, "android.permission.CAMERA", null, new l(R.string.Lark_Core_CameraAccess_Title, R.string.Lark_Legacy_ApplyCameraPermission, R.string.Lark_Core_CameraAccess_Title, R.string.Lark_Legacy_ApplyCameraPermission, null, null, 240));
    }

    public static void a(Activity r100, Token r110, e r111) {
        int r101 = n.f444741a;
        c(r100, r110, r111, "android.permission.RECORD_AUDIO", new l(R.string.Lark_Core_MicrophoneAccess_Title, R.string.Lark_Legacy_ApplyAudioPermission, R.string.Lark_Core_MicrophoneAccess_Title, R.string.Lark_Legacy_ApplyAudioPermission, null, null, 240), false, 0, 0);
    }

    public static void d(Activity r100, e r101, String r110, Token r111, l r112) {
        c(r100, r111, r101, r110, r112, true, 0, 0);
    }

    public static void g(Activity r100, c r101, l r102, Token r103, String... r110) {
        f(r100, r101, r102, r103, 16, r110);
    }

    public static void f(Activity r100, c r110, l r111, Token r112, int r113, String... r114) {
        StoragePermissionUtils.b r115 = StoragePermissionUtils.c(r100, r113, r114);
        if (r115.f438542a == false) goto L5;
        r110.b(new StoragePermissionUtils.c(r100, r114));
        return;
    L5:
        String[] r101 = r115.f438543b;
        e(r100, new com.ss.android.lark.utils.c(r110, r100, r114), r111, r112, true, r101.length, 0, new f(), r101);
    }

    public static void c(Activity r100, Token r110, e r111, String r112, k r113, boolean r114, int r115, int r116) {
        e(r100, r111, r113, r110, r114, r115, r116, new b(), new String[]{r112});
    }

    public static void e(Activity r110, final e r111, k r112, Token r113, boolean r114, int r115, int r116, d r117, String... r210) {
        if (r110 != null) goto L7;
        Log.e("AppPermission", "checkPermissions activity is null");
        return;
    L7:
        if (r110.isDestroyed() == false) goto L9;
    L36:
        Log.e("AppPermission", "checkPermissions activity is destroyed or finishing");
        return;
    L9:
        if (r110.isFinishing() == true) goto L36;
        o0c.c r100 = new o0c.c(r110);
        if (r210.length > 0) goto L14;
        return;
    L14:
        boolean r101 = false;
        String r102 = r210[0];
        int r103 = r210.length;
        int r104 = 0;
    L16:
        if (r104 >= r103) goto L21;
        String r118 = r210[r104];
        if (r100.d(r118) == false) goto L19;
        r104 = r104 + 1;
        goto L16
    L19:
        r102 = r118;
        boolean r105 = false;
    L22:
        if (r105 == false) goto L26;
        if (r111 == null) goto L40;
        r111.a(r105);
        return;
    L40:
        return;
    L26:
        if (r117 != null) goto L28;
    L29:
        r101 = true;
    L30:
        g0 r106 = (g0) LarkContext.spiByDwarf(g0.class);
        if ((r106 instanceof n0) == true) goto L34;
        r106.requestPermissions(r113, r210, new com.ss.android.lark.utils.b(r111));
        return;
    L34:
        Observable.just(o0c.c.f521655b).compose(r100.c(r113, r101, r210)).subscribe(new a(r117, r110, r113, r112, r102, r115, r114, r111, r116));
        return;
    L28:
        if (r117.b() == false) goto L30;
    L21:
        r105 = true;
        goto L22
    }
}
