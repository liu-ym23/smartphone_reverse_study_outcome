package fa1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.share.jsbridge.n;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import m60.i;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final TokenCert f476000j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f476001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f476002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f476003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f476004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f476005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f476006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f476007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CompositeDisposable f476008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CallContext f476009i;

    /* JADX INFO: renamed from: fa1.a$a, reason: collision with other inner class name */
    public static final class C5875a {
    }

    public interface b {
        void a(String r100, String r101, String r102, String r103);

        void b();
    }

    static {
        f476000j = TokenCert.Companion.with("bpea-livescreenshotsharedialog_request_permission");
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CompositeDisposable r100 = this.f476008h;
        if (r100 == null) goto L6;
        r100.clear();
        return;
    }

    public static void a(a r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Deprecated(message = "后续不要使用这个方法，使用checkAndSaveImage(channel: String,cert: Cert) 这个方法")
    public final void b(String r100) {
        TokenCert r101 = f476000j;
        if (Build.VERSION.SDK_INT < 29) goto L5;
        List r102 = null;
    L7:
        if (m60.c.c(getContext(), r102) == false) goto L9;
        e(r100);
        return;
    L9:
        Activity r103 = ContextUtil.contextToActivity(getContext());
        SettingKey<Boolean> r104 = i.f512260a;
        new i.b(r103).a(new fa1.b(this, r100), r101, r102);
        return;
    L5:
        r102 = CollectionsKt.listOf(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"});
        goto L7
    }

    public final View c(int r100) {
        View r101 = getLayoutInflater().inflate(R.layout.ttlive_view_share_item, null);
        r101.setTag(Integer.valueOf(r100));
        r101.setOnClickListener(this);
        ImageView r102 = (ImageView) r101.findViewById(R.id.image);
        TextView r103 = (TextView) r101.findViewById(R.id.text);
        if (r100 != 1) goto L5;
        int r104 = R.drawable.ttlive_icon_share_weixin;
        int r105 = R.string.ttlive_live_name_share_wechat;
    L18:
        if (r104 == (-1)) goto L20;
        r102.setImageResource(r104);
    L20:
        if (r105 == (-1)) goto L22;
        r103.setText(r105);
    L22:
        return r101;
    L5:
        if (r100 != 2) goto L7;
        r104 = R.drawable.ttlive_icon_share_weixin_circle;
        r105 = R.string.ttlive_live_name_share_moments;
        goto L18
    L7:
        if (r100 != 3) goto L9;
        r104 = R.drawable.ttlive_icon_share_qq;
        r105 = R.string.ttlive_live_name_share_qq;
        goto L18
    L9:
        if (r100 != 4) goto L11;
        r104 = R.drawable.ttlive_icon_share_qzone;
        r105 = R.string.ttlive_live_name_share_qzone;
        goto L18
    L11:
        if (r100 == 5) goto L13;
        r104 = -1;
        r105 = -1;
        goto L18
    L13:
        r104 = R.drawable.ttlive_ic_live_save;
        r105 = R.string.ttlive_live_name_share_save;
        goto L18
    }

    public final void d(String r100) {
        String r101 = "douyin_" + System.currentTimeMillis() + ".jpeg";
        Context r102 = getContext();
        String r103 = this.f476005e;
        MediaStore.Images.Media.insertImage(r102.getContentResolver(), r103, r101, null);     // Catch: FileNotFoundException -> L5
    L7:
        r102.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", UriProtector.parse(MSkiaImageRegionDecoder.FILE_PREFIX + r103)));
        String r104 = "";
        if (StringUtils.isEmpty(r100) == false) goto L10;
    L26:
        String r105 = rm3.c.f538539a;
        rm3.c.f(getContext(), R.string.ttlive_save_image_success, true, 16);
        this.f476007g.a(r100, "", "", "");
    L27:
        a(this);
        return;
    L10:
        if (Intrinsics.areEqual("picture_save", r100) == true) goto L26;
        String r106 = s1.B(R.string.ttlive_save_image_success);
        if (Intrinsics.areEqual("weixin", r100) == false) goto L15;
    L24:
        r104 = s1.B(R.string.ttlive_open_wechat);
        String r107 = "com.tencent.mm";
    L25:
        this.f476007g.a(r100, r106, r104, r107);
        goto L27
    L15:
        if (Intrinsics.areEqual("weixin_moment", r100) == true) goto L24;
        if (Intrinsics.areEqual("qq", r100) == false) goto L20;
    L23:
        r104 = s1.B(R.string.ttlive_open_qq);
        r107 = "com.tencent.mobileqq";
        goto L25
    L20:
        if (Intrinsics.areEqual("qzone", r100) == true) goto L23;
        r107 = "";
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public final void e(String r110) {
        if (StringUtils.isEmpty(this.f476005e) == false) goto L76;
        String r100 = "";
        if (this.f476006f == true) goto L86;
        this.f476006f = true;
        Activity r101 = ContextUtil.contextToActivity(getContext());
        if (r101 != null) goto L10;
    L75:
        this.f476006f = false;
        String r111 = rm3.c.f538539a;
        rm3.c.f(getContext(), R.string.ttlive_save_image_failed, true, 16);
        return;
    L10:
        if (r101.isFinishing() == true) goto L75;
        View r102 = this.f476009i.f249269d;
        if (r102 != null) goto L19;
        r102 = r101.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L19;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L19;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L19:
        r102.setDrawingCacheEnabled(true);
        r102.buildDrawingCache();
        Bitmap r104 = r102.getDrawingCache();
        if (r104 == null) goto L87;
        int r105 = this.f476003c;
        if ((this.f476001a + r105) <= r104.getWidth()) goto L25;
        r105 = r104.getWidth() - this.f476001a;
    L25:
        int r112 = this.f476004d;
        if ((this.f476002b + r112) <= r104.getHeight()) goto L28;
        r112 = r104.getHeight() - this.f476002b;
    L28:
        Bitmap r106 = Bitmap.createBitmap(r104, this.f476001a, this.f476002b, r105, r112);
        r102.destroyDrawingCache();
        r102.setDrawingCacheEnabled(false);
        File r107 = r101.getExternalCacheDir();     // Catch: Throwable -> L63 Exception -> L68
        if (r107 == null) goto L32;
        String r108 = r107.getAbsolutePath();     // Catch: Throwable -> L63 Exception -> L68
    L37:
        if (StringUtils.isEmpty(r108) == false) goto L44;
        String r109 = rm3.c.f538539a;     // Catch: Throwable -> L63 Exception -> L68
        rm3.c.f(getContext(), R.string.ttlive_save_image_failed, true, 16);     // Catch: Throwable -> L63 Exception -> L68
        this.f476006f = false;     // Catch: Throwable -> L63 Exception -> L68
        r104.recycle();
        if (r106 == null) goto L79;
    L54:
        r106.recycle();
        return;
    L79:
        return;
    L44:
        if (StringsKt.contains$default(r108, "../", false, 2, null) == false) goto L49;
        String r113 = rm3.c.f538539a;     // Catch: Throwable -> L63 Exception -> L68
        rm3.c.f(getContext(), R.string.ttlive_save_image_failed, true, 16);     // Catch: Throwable -> L63 Exception -> L68
        this.f476006f = false;     // Catch: Throwable -> L63 Exception -> L68
        r104.recycle();
        if (r106 != null) goto L54;
        return;
    L49:
        String r114 = r108 + "/temp_screen.jpeg";     // Catch: Throwable -> L63 Exception -> L68
        if (StringsKt.contains$default(r114, "../", false, 2, null) == false) goto L55;
        String r115 = rm3.c.f538539a;     // Catch: Throwable -> L63 Exception -> L68
        rm3.c.f(getContext(), R.string.ttlive_save_image_failed, true, 16);     // Catch: Throwable -> L63 Exception -> L68
        this.f476006f = false;     // Catch: Throwable -> L63 Exception -> L68
        r104.recycle();
        if (r106 != null) goto L54;
        return;
    L55:
        PolarisFileOutputStreamWrapper r116 = new PolarisFileOutputStreamWrapper(r114);     // Catch: Throwable -> L63 Exception -> L68
        if (r106 == null) goto L58;
        r106.compress(Bitmap.CompressFormat.JPEG, 50, r116);     // Catch: Throwable -> L63 Exception -> L68
    L58:
        r116.close();     // Catch: Throwable -> L63 Exception -> L68
        r104.recycle();
        if (r106 == null) goto L62;
        r106.recycle();
    L62:
        r100 = r114;
    L71:
        this.f476006f = false;
        if (StringUtils.isEmpty(r100) == false) goto L74;
        String r117 = rm3.c.f538539a;
        rm3.c.f(getContext(), R.string.ttlive_save_image_failed, true, 16);
        return;
    L74:
        this.f476005e = r100;
        d(r110);
        return;
    L32:
        File r118 = r101.getExternalFilesDir("");     // Catch: Throwable -> L63 Exception -> L68
        if (r118 == null) goto L35;
        r108 = r118.getAbsolutePath();     // Catch: Throwable -> L63 Exception -> L68
        goto L37
    L35:
        r108 = "";
    L68:
        r104.recycle();
        if (r106 == null) goto L71;
        r106.recycle();
    L63:
        th = move-exception;
        r104.recycle();
        if (r106 == null) goto L67;
        r106.recycle();
    L67:
        throw th;
    L87:
        return;
    L86:
        return;
    L76:
        d(r110);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 != null) goto L4;
    L7:
        Object r101 = null;
        if (r100 == null) goto L10;
        Object r102 = r100.getTag();
    L12:
        if ((r102 instanceof Integer) == true) goto L14;
        return;
    L14:
        if (r100 == null) goto L16;
        r101 = r100.getTag();
    L16:
        if (r101 == null) goto L34;
        int r103 = ((Integer) r101).intValue();
        if (r103 != 3) goto L21;
        b("qq");
        return;
    L21:
        if (r103 != 4) goto L24;
        b("qzone");
        return;
    L24:
        if (r103 != 1) goto L27;
        b("weixin");
        return;
    L27:
        if (r103 != 2) goto L30;
        b("weixin_moment");
        return;
    L30:
        if (r103 != 5) goto L39;
        b("picture_save");
        return;
    L39:
        return;
    L34:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L10:
        r102 = null;
        goto L12
    L4:
        if (R.id.cancel != r100.getId()) goto L7;
        this.f476007g.b();
        a(this);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.ttlive_simple_share_picture_dialog);
        boolean r101 = false;
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        LinearLayout r102 = (LinearLayout) findViewById(R.id.action_container);
        Context r103 = getContext();
        if (r103 != null) goto L5;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L13;
        r102.addView(c(3));
        r102.addView(c(4));
    L13:
        Context r105 = getContext();
        if (r105 != null) goto L16;
    L21:
        if (r101 == false) goto L23;
        r102.addView(c(1));
        r102.addView(c(2));
    L23:
        r102.addView(c(5));
        findViewById(R.id.cancel).setOnClickListener(this);
        this.f476008h = new CompositeDisposable();
        return;
    L16:
        if (TextUtils.isEmpty("com.tencent.mm") == true) goto L21;
        r105.getPackageManager().getPackageInfo("com.tencent.mm", 0);     // Catch: Exception -> L25
        r101 = true;
        goto L21
    L5:
        if (TextUtils.isEmpty("com.tencent.mobileqq") == true) goto L10;
        r103.getPackageManager().getPackageInfo("com.tencent.mobileqq", 0);     // Catch: Exception -> L26
        r104 = true;
        goto L11
    }

    public a(CallContext r100, int r101, int r102, int r103, int r104, n r105) {
        Intrinsics.checkNotNullParameter(r100, "callContext");
        Intrinsics.checkNotNullParameter(r105, "callback");
        super(r100.getContext(), R.style.ttlive_anchor_list_fragment);
        this.f476009i = r100;
        this.f476005e = "";
        this.f476001a = r101;
        this.f476002b = r102;
        this.f476003c = r103;
        this.f476004d = r104;
        this.f476007g = r105;
    }
}
