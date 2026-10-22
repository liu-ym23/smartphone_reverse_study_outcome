package com.bytedance.ee.bear.attachment.filereader;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.route.PostCard;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.dora.impl.ota.g2.j0;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f206422a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f206423b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f206424c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f206425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static com.bytedance.ee.bear.contract.d f206426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f206427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f206428g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f206429h;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.attachment.filereader.x$a$a, reason: collision with other inner class name */
        public static final class DialogInterfaceOnClickListenerC2974a implements DialogInterface.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f206430a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FileClickData f206431b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef<com.bytedance.ee.bear.route.h> f206432c;

            public DialogInterfaceOnClickListenerC2974a(String r100, FileClickData r101, Ref.ObjectRef<com.bytedance.ee.bear.route.h> r102) {
                this.f206430a = r100;
                this.f206431b = r101;
                this.f206432c = r102;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r100, int r101) {
                String r102 = x.f206422a;
                a.c(this.f206430a, this.f206431b, this.f206432c.element);
                a.e("client_attachment_alert_goon", "-1", "0");
            }
        }

        public static final class b implements DialogInterface.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f206433a = null;

            static {
                f206433a = new b();
            }

            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r100, int r101) {
                String r102 = x.f206422a;
                a.e("client_attachment_alert_cancel", "-1", "0");
            }
        }

        public static VFSPath b() {
            int r100 = ay4.c.f16749a;
            VFSPath r101 = ay4.c.a.b(Biz.DYNAMIC, x.f206422a, false, 12);
            if (r101.toFile().exists() == false) goto L5;
        L7:
            return r101;
        L5:
            if (r101.toFile().mkdirs() == true) goto L7;
            tt5.a.h("FileReaderActivity", " getDownloadPath create downloadPath fail ");
            goto L7
        }

        public a() {
        }

        public static final void a(String r100) {
            String r101 = x.f206422a;
            if (x.f206425d == true) goto L22;
            x.f206425d = true;
        L14:
            e = move-exception;
            tt5.a.e("FileReaderActivity", "removeExceedCache fail ", e, false);
            return;
        L7:
            if (FileUtils.B(ay4.d.a().z(r100)) <= x.f206423b) goto L20;
            List<VFSFile> r102 = FileUtils.q(ay4.d.a().z(r100));     // Catch: Exception -> L14
            int r103 = x.f206424c;     // Catch: Exception -> L14
            if (r103 < 0) goto L21;
            int r104 = 0;
        L11:
            FileUtils.m(((VFSFile) ListProtector.get(r102, r104)).getVfsPath());     // Catch: Exception -> L14
            if (r104 == r103) goto L23;
            r104 = r104 + 1;
            goto L11
        L23:
            return;
        L21:
            return;
        L20:
            return;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
        @JvmStatic
        public static void d(String r100, FileClickData r101) {
            Intrinsics.checkNotNullParameter(r101, "data");
            AccountService$Account r102 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).U5();
            if (r102 != null) goto L6;
            tt5.a.k("FileReaderUtil", "openFileReaderActivity()... account is empty");
            return;
        L6:
            Ref.ObjectRef r103 = new Ref.ObjectRef();
            ?? r104 = org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
            r103.element = r104;
            com.bytedance.ee.bear.contract.j r105 = com.bytedance.ee.bear.contract.j.a.f217090a;
            Activity r106 = ((com.bytedance.ee.bear.route.h) r104).getCurrentActivity();
            if (r106 != null) goto L11;
            tt5.a.d("FileReaderUtil", "currentActivity is null");
            return;
        L11:
            if (r102.hasLogin() == true) goto L13;
            tt5.a.d("FileReaderUtil", "onFileClick account error ");
            return;
        L13:
            if (b().subPath(r100 + '_' + r101.getFile_id() + '_' + r101.getFile_name()).toFile().exists() == false) goto L16;
            c(r100, r101, (com.bytedance.ee.bear.route.h) r103.element);
            return;
        L16:
            if (r105.getNetworkState().a() == true) goto L18;
            Toast.showFailureText(r106, r106.getString(R.string.Doc_Facade_NetworkInterrutedRetry), 0);
            return;
        L18:
            if (r105.getNetworkState().getType() != 1) goto L20;
            c(r100, r101, (com.bytedance.ee.bear.route.h) r103.element);
            return;
        L20:
            Intrinsics.checkNotNullParameter(r106, PerfLog.PARAM_KEY_CONTEXT_ID);
            UDDialogBuilder r107 = new UDDialogBuilder(r106);
            r107.autoDismiss(true);
            r107.message(R.string.Doc_Attachment_NotInWIFI);
            r107.addActionButton(R.id.ud_dialog_btn_primary, R.string.Doc_Attachment_ContinueLook, new DialogInterfaceOnClickListenerC2974a(r100, r101, r103));
            r107.addActionButton(R.id.ud_dialog_btn_secondary, R.string.Doc_Facade_Cancel, b.f206433a);
            UDDialog r108 = r107.build();
            if (DialogLancet.shouldBlockDialogShow(r108) == false) goto L30;
            DialogLancet.handleBlockedDialogShow(r108);
        L25:
            e("client_attachment_alert", "-1", "0");
            return;
        L30:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L29
        L24:
            DialogLancet.beforeDialogShow(r108);
            r108.show();
            DialogLancet.afterDialogShow(r108);
            goto L25
        }

        public static void c(String r100, FileClickData r101, com.bytedance.ee.bear.route.h r102) {
            PostCard r103 = r102.w2("/doc/filereader/activity").i("file_reader_file_id", r101.getFile_id()).i("file_reader_file_drive_key", r101.getDrive_file_key()).i("file_reader_file_name", r101.getFile_name()).i("file_reader_file_mime_type", r101.getFile_mime_type()).i("file_reader_file_mount_node_token", r101.getMount_node_token()).i("file_reader_file_mount_point", r101.getMount_point()).j("file_reader_file_type", r101.getType()).f("file_reader_file_size", r101.getFile_size());
            if (r100 != null) goto L5;
            r100 = "";
        L5:
            r103.i("obj_token", r100).i("file_reader_download_path", r101.getDownLoadPath()).e();
        }

        @JvmStatic
        public static void e(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r101, "openType");
            Intrinsics.checkNotNullParameter(r102, "statusCode");
            if (x.f206426e != null) goto L5;
            x.f206426e = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        L5:
            HashMap r103 = new HashMap();
            r103.put("file_id", x.f206427f);
            r103.put("file_type", x.f206428g);
            r103.put("file_size", x.f206429h);
            if (Intrinsics.areEqual(r101, "-1") == true) goto L8;
            r103.put("open_type", r101);
        L8:
            r103.put("status_code", r102);
            com.bytedance.ee.bear.contract.d r104 = x.f206426e;
            if (r104 == null) goto L12;
            r104.v(r100, r103);
            return;
        }
    }

    static {
        new a();
        f206422a = "/FileReader/Download/";
        f206423b = j0.G2_OTA_SPACE_RESERVE_BYTES;
        f206424c = 10;
    }
}
