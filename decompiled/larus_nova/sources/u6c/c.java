package u6c;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.thirdshare.base.export.ShareActionType;
import com.ss.android.lark.thirdshare.base.export.downgrade.CtaBtnStyle;
import com.ss.android.lark.thirdshare.base.export.downgrade.ShareDowngradePanelCallback;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.ViewUtils;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.emm.impl.SCClipboardProvider;
import com.suite.lark.emm.impl.clipboard.SCClipboardScene;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Token f548994a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Token f548995b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Token f548996c = null;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f548997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f548998b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f548999c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f549000d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ CtaBtnStyle f549001e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ShareActionType f549002f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ ShareDowngradePanelCallback f549003g;

        /* JADX WARN: Type inference failed for: r7v0, types: [u6c.a] */
        /* JADX WARN: Type inference failed for: r8v0, types: [u6c.b] */
        public final void a() {
            Context r100 = this.f548997a;
            String r101 = this.f548998b;
            boolean r102 = this.f548999c;
            String r103 = this.f549000d;
            CtaBtnStyle r104 = this.f549001e;
            final ShareActionType r105 = this.f549002f;
            final ShareDowngradePanelCallback r106 = this.f549003g;
            ?? r107 = new u6c.a(r105, r106);
            final ?? r108 = new u6c.b(r106, r105);
            if (ViewUtils.isActivityAlive(r100) == true) goto L6;
            Log.i("ThirdShare", "downgrade panel called without activity alive");
            return;
        L6:
            if (TextUtils.isEmpty(r101) == false) goto L8;
            Log.i("ThirdShare", "copyText is empty.");
        L12:
            if ((r100 instanceof ContextThemeWrapper) == true) goto L14;
        L16:
            Context r109 = r100;
        L17:
            com.larksuite.component.ui.dialog.d r110 = new com.larksuite.component.ui.dialog.d(r109);
            r110.f284133d = new com.larksuite.component.ui.dialog.e(r100);
            r110.f284132c.rootLayoutRes(R.layout.ts_share_paste_panel);
            DialogInterface.OnCancelListener r111 = new x6c.a(r108);
            r110.f284132c.onCancelListener(r111);
            r110.g(new x6c.d(r103, r101, r104, r100, r107, r108));
            LKUIDialog r112 = r110.c();
            if (DialogLancet.shouldBlockDialogShow(r112) == false) goto L24;
            DialogLancet.handleBlockedDialogShow(r112);
            return;
        L24:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
        L21:
            DialogLancet.beforeDialogShow(r112);
            r112.show();
            DialogLancet.afterDialogShow(r112);
            return;
        L14:
            if ((r100 instanceof Activity) == true) goto L16;
            r109 = ((ContextThemeWrapper) r100).getBaseContext();
            goto L17
        L8:
            if (r102 == false) goto L10;
            c.c(r101);
            goto L12
        L10:
            c.b(r101);
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

        public a(Context r100, String r101, boolean r102, String r103, CtaBtnStyle r104, ShareActionType r105, ShareDowngradePanelCallback r106) {
            this.f548997a = r100;
            this.f548998b = r101;
            this.f548999c = r102;
            this.f549000d = r103;
            this.f549001e = r104;
            this.f549002f = r105;
            this.f549003g = r106;
        }
    }

    public interface b extends InterfaceC7842c {
    }

    /* JADX INFO: renamed from: u6c.c$c, reason: collision with other inner class name */
    public interface InterfaceC7842c {
        void a(File r100);

        void b(String r100);
    }

    static {
        f548994a = new Token("LARK-PSDA-third-share-base-utils-copy");
        f548995b = new Token("LARK-PSDA-third-share-base-utils-copy-security");
        f548996c = new Token("LARK-PSDA-third_share_panel_picture_save_notify_system_scan_file");
    }

    public static boolean b(CharSequence r100) {
        qf7.a.f532746a.a((ClipboardManager) LarkContext.getApplication().getSystemService(DataType.CLIPBOARD), ClipData.newPlainText("text", r100), f548994a);     // Catch: SensitiveAPIException -> L5
        return true;
    L5:
        UDToast.show(LarkContext.getApplication(), R.string.Lark_IM_CopyContent_CopyingIsForbidden_Toast);
        Log.e("ThirdShare", "share base utils item Clip fail");
        return false;
    }

    public static boolean c(CharSequence r100) {
        int r101 = com.suite.lark.emm.impl.a.f460436a;
        com.suite.lark.emm.impl.a.C5524a.a().getClass();
        boc.b r102 = SCClipboardProvider.a();
        StringBuilder r103 = new StringBuilder("copy text with exempt, scManager is ");
        if (r102 == null) goto L5;
        boolean r104 = true;
    L6:
        r103.append(r104);
        Log.i("ThirdShare", r103.toString());
        r102.Q0(SCClipboardScene.SCENE_SYSTEM_ONCE);
        r102.M0(ClipData.newPlainText("text", r100), f548995b);     // Catch: SensitiveAPIException -> L9
        return true;
    L9:
        e = move-exception;
        UDToast.show(LarkContext.getApplication(), R.string.Lark_IM_CopyContent_CopyingIsForbidden_Toast);
        Log.e("ThirdShare", "copyTextWithExempt: failed, " + e.getMessage());
        return false;
    L5:
        r104 = false;
        goto L6
    }

    public static String d(String r100) {
        Intent r101 = new Intent("android.intent.action.MAIN", null);
        r101.addCategory("android.intent.category.LAUNCHER");
        r101.setPackage(r100);
        List<ResolveInfo> r102 = LarkContext.getApplication().getPackageManager().queryIntentActivities(r101, 0);
        int r103 = r102.size();
        if (r103 != 0) goto L6;
        return "";
    L6:
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L14;
        ResolveInfo r105 = (ResolveInfo) ListProtector.get(r102, r104);
        if (r105.activityInfo.processName.equals(r100) == true) goto L11;
        r104 = r104 + 1;
        goto L7
    L11:
        return r105.activityInfo.name;
    L14:
        return ((ResolveInfo) ListProtector.get(r102, 0)).activityInfo.name;
    }

    public static boolean e(ShareActionType r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isThirdAppShareType() == false) goto L14;
        String r101 = r100.getPkgName();
        return LarkContext.getApplication().getPackageManager().getApplicationInfo(r101, 0).enabled;
    L15:
        return false;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedOutputStream, java.io.OutputStream] */
    public static boolean a(VFSFile r100, InputStream r101) {
        boolean r102 = false;
        ?? r103 = 0;
        r103 = 0;
        ?? r104 = new BufferedOutputStream(r100.newOutputStream(), 524288);     // Catch: Throwable -> L22 IOException -> L24
        byte[] r105 = new byte[524288];     // Catch: Throwable -> L18 IOException -> L20
    L5:
        r103 = r101.read(r105);     // Catch: Throwable -> L18 IOException -> L20
        if (r103 == (-1)) goto L59;
        r104.write(r105, 0, r103);     // Catch: Throwable -> L18 IOException -> L20
    L59:
        r101.close();     // Catch: IOException -> L11
    L54:
        r104.close();     // Catch: IOException -> L15
    L17:
        r102 = true;
    L49:
        return r102;
    L15:
        e = move-exception;
        e.printStackTrace();
    L11:
        e = move-exception;
        e.printStackTrace();
    L20:
        e = e;
        r103 = r104;
    L25:
        e.printStackTrace();     // Catch: Throwable -> L22
        r101.close();     // Catch: IOException -> L28
    L30:
        if (r103 == 0) goto L49;
        r103.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
    L28:
        e = move-exception;
        e.printStackTrace();
    L18:
        th = th;
    L57:
        r101.close();     // Catch: IOException -> L39
    L41:
        if (r104 == 0) goto L66;
        r104.close();     // Catch: IOException -> L44
        throw th;
    L44:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L66:
        throw th;
    L39:
        e = move-exception;
        e.printStackTrace();
    L22:
        th = th;
        r104 = r103;
    L24:
        e = e;
        goto L25
    }

    public static VFSFile f(Bitmap r100, VFSPath r101) {
        if (r100 != null) goto L7;
        Log.i("ThirdShare", "bitmap is null");
        return null;
    L7:
        if (r100.isRecycled() == false) goto L15;
        Log.i("ThirdShare", "bitmap is recycled");
        return null;
    L15:
        VFSFile r102 = r101.subPath(System.currentTimeMillis() + ".jpg").toFile();     // Catch: Throwable -> L12
        OutputStream r103 = r102.newOutputStream();     // Catch: Throwable -> L12
        r100.compress(Bitmap.CompressFormat.JPEG, 100, r103);     // Catch: Throwable -> L12
        r103.flush();     // Catch: Throwable -> L12
        r103.close();     // Catch: Throwable -> L12
        return r102;
    L12:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static void g(Context r110, String r111, boolean r112, String r113, ShareActionType r114, ShareDowngradePanelCallback r115) {
        CtaBtnStyle r100 = CtaBtnStyle.getThirdAppCtaBtnStyle(r114);
        if (r100 != null) goto L6;
        Log.e("ThirdShare", r114 + "not support");
        ViewUtils.showCommonErrorTip();
        return;
    L6:
        new Handler(r110.getMainLooper()).post(new a(r110, r111, r112, r113, r100, r114, r115));
    }
}
