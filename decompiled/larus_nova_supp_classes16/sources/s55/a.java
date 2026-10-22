package s55;

import android.app.Application;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.biz.permission.handler.PermissionOperation;
import com.bytedance.ee.bear.drive.biz.preview.more.l;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ErrorResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ImPermEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UniBaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityOperate;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final a a = null;

    /* JADX INFO: renamed from: s55.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0289a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[PermissionOperation.values().length];
            r0[PermissionOperation.DOWNLOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[PermissionOperation.COPY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L33:
            r0[PermissionOperation.EXPORT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L25:
            r0[PermissionOperation.UPLOAD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[PermissionOperation.CREATE_COPY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L9:
            a = r0;
            int[] r1 = new int[FileAuthResultFrom.values().length];
            r1[FileAuthResultFrom.COME_FROM_AUTHZ.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L21:
            r1[FileAuthResultFrom.COME_FROM_FILE_POLICY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L12:
            b = r1;
        }
    }

    static {
        a = new a();
    }

    public a() {
    }

    public final PermissionResponse g(String r12, String r13, String r14, String r16) {
        Intrinsics.checkNotNullParameter("DOWNLOAD", "operation");
        return h(this, "DOWNLOAD", r12, r13, r14, r16, null, null, null, null, 480);
    }

    public final boolean i(e r16) {
        Intrinsics.checkNotNullParameter(r16, "param");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L7;
        PermissionResponse r17 = h(this, r16.a, r16.d, r16.e, null, null, r16.g, r16.h, r16.i, r16.j, 24);
        return ((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).e(r17);
    L7:
        return ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g(d(r16.b, r16), pw4.b.d(r16.d), pw4.b.f(r16.d), r16.e).a;
    }

    public static String d(PermissionOperation r1, e r2) {
        int r3 = C0289a.a[r1.ordinal()];
        if (r3 == 1) goto L18;
        if (r3 == 2) goto L23;
        if (r3 == 3) goto L22;
        if (r3 != 4) goto L11;
        r2.getClass();
        int r4 = pw4.b.a;
        return "CCM_FILE_UPLOAD";
    L11:
        if (r3 == 5) goto L13;
        return "";
    L13:
        return "CCM_CREATE_COPY";
    L22:
        return pw4.b.c(r2.d);
    L23:
        return pw4.b.b(r2.d);
    L18:
        return pw4.b.c(r2.d);
    }

    public final boolean k(e r16, Context r17) {
        Intrinsics.checkNotNullParameter(r16, "param");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L10;
        String r5 = r16.a;
        String r6 = r16.d;
        String r7 = r16.e;
        if (r17 != null) goto L7;
        Context r8 = eu5.b.a;
    L9:
        return l(this, r5, r6, r7, r8, null, r16.g, r16.h, r16.i, r16.j, 48);
    L7:
        r8 = r17;
        goto L9
    L10:
        gj5.c r1 = ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g(d(r16.b, r16), pw4.b.d(r16.d), pw4.b.f(r16.d), r16.e);
        if (r1.a == true) goto L14;
        n(r1, r16.c, d(r16.b, r16), r16);
    L14:
        return r1.a;
    }

    public static void e(e r7, FragmentActivity r8, l r9) {
        Intrinsics.checkNotNullParameter(r7, "param");
        Intrinsics.checkNotNullParameter(r9, "callBack");
        Application r0 = eu5.b.a;
        Toast.showLoading(r0, r0.getString(2131887769));
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L5;
        a(r7, "", "", new b(r8, r9));
        return;
    L5:
        gj5.b r1 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
        String r2 = pw4.b.c(r7.d);
        FileBizDomain r3 = pw4.b.d(r7.d);
        int r4 = pw4.b.f(r7.d);
        String r5 = r7.e;
        Long r10 = r7.f;
        if (r10 == null) goto L8;
        long r6 = r10.longValue();
    L9:
        r1.d(r2, r3, r4, r5, Long.valueOf(r6), new c(r7, r9));
        return;
    L8:
        r6 = -1;
        goto L9
    }

    public static PermissionResponse m(String r4, String r5, DocPermission r6) {
        Intrinsics.checkNotNullParameter(r5, "operation");
        Intrinsics.checkNotNullParameter(r6, "docPermission");
        BaseEntity r0 = new BaseEntity(r4, sbb.e.l, BizDomain.FileBizDomainCCM, "");
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r0, r5), new UserPermissionEntity(r6.a, null));
    }

    public static void a(e r18, String r19, String r20, ph5.d r21) {
        Intrinsics.checkNotNullParameter(r18, "param");
        Intrinsics.checkNotNullParameter(r21, "callBack");
        ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).b(new PermissionRequest(b(r18.d, r18.e, r19, r18.f, r20, r18.g, r18.h, r18.i, r18.j, r18.k, r18.m, r18.n, r18.o), r18.a), null, r21);
    }

    public static boolean f(int r3, String r4, String r5, Context r6) {
        Intrinsics.checkNotNullParameter(r4, "operation");
        NetService.ServerErrorException r0 = new NetService.ServerErrorException(r3, "", "", "");
        ErrorResponse r7 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).e(r5, Integer.valueOf(sbb.e.l.b), r4, r0);
        ph5.a r8 = r7.getCallback();
        if (r6 != null) goto L5;
        r6 = eu5.b.a;
    L5:
        Intrinsics.checkNotNull(r6);
        r8.a(r6, r7);
        return r7.getHasHandledUiAction();
    }

    public static void n(gj5.c r1, int r2, @EntityOperate String r3, e r4) {
        Intrinsics.checkNotNullParameter(r1, "validateResult");
        Intrinsics.checkNotNullParameter(r3, "operate");
        Intrinsics.checkNotNullParameter(r4, "param");
        FileAuthResultFrom r5 = r1.b;
        int r6 = C0289a.b[r5.ordinal()];
        if (r6 == 1) goto L9;
        if (r6 != 2) goto L15;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c(r3, pw4.b.d(r4.d), pw4.b.f(r4.d), r4.e);
        return;
    L15:
        return;
    L9:
        if (r2 != (-1)) goto L12;
        Toast.showText(eu5.b.a, 2131887246);
        return;
    L12:
        Toast.showText(eu5.b.a, r2);
    }

    public final boolean j(String r18, String r19, String r20, Context r21, String r22, String r23, sbb.e r24, FileBizDomain r26, @EntityOperate String r27, @EntityType String r28) {
        Intrinsics.checkNotNullParameter(r18, "operation");
        PermissionResponse r0 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(c(this, r19, r20, r22, -1L, r23, r24, r26, r27, r28, 7680), r18), null);
        ph5.e r1 = r0.getCallback();
        if (r21 != null) goto L5;
        Context r2 = eu5.b.a;
    L6:
        Intrinsics.checkNotNull(r2);
        r1.a(r2, r0);
        return r0.getAllow();
    L5:
        r2 = r21;
        goto L6
    }

    public static /* synthetic */ BaseEntity c(a r16, String r17, String r18, String r19, Long r110, String r20, sbb.e r21, FileBizDomain r22, String r23, String r24, int r26) {
        if ((r26 & 8) == 0) goto L5;
        Long r5 = -1L;
    L7:
        if ((r26 & 32) == 0) goto L9;
        sbb.e r7 = null;
    L11:
        if ((r26 & 64) == 0) goto L13;
        FileBizDomain r8 = null;
    L15:
        if ((r26 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) == 0) goto L17;
        String r9 = null;
    L19:
        if ((r26 & 256) == 0) goto L21;
        String r10 = null;
    L22:
        r16.getClass();
        return b(r17, r18, r19, r5, r20, r7, r8, r9, r10, null, null, null, null);
    L21:
        r10 = r24;
        goto L22
    L17:
        r9 = r23;
        goto L19
    L13:
        r8 = r22;
        goto L15
    L9:
        r7 = r21;
        goto L11
    L5:
        r5 = r110;
        goto L7
    }

    public static PermissionResponse h(a r16, String r17, String r18, String r19, String r110, String r20, sbb.e r21, FileBizDomain r22, String r23, String r24, int r26) {
        if ((r26 & 8) == 0) goto L5;
        String r7 = "";
    L7:
        if ((r26 & 16) == 0) goto L9;
        String r9 = "";
    L11:
        if ((r26 & 32) == 0) goto L13;
        sbb.e r10 = null;
    L15:
        if ((r26 & 64) == 0) goto L17;
        FileBizDomain r11 = null;
    L19:
        if ((r26 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) == 0) goto L21;
        String r12 = null;
    L23:
        if ((r26 & 256) == 0) goto L25;
        String r13 = null;
    L26:
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "operation");
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(c(r16, r18, r19, r7, null, r9, r10, r11, r12, r13, 7688), r17), null);
    L25:
        r13 = r24;
        goto L26
    L21:
        r12 = r23;
        goto L23
    L17:
        r11 = r22;
        goto L19
    L13:
        r10 = r21;
        goto L15
    L9:
        r9 = r20;
        goto L11
    L5:
        r7 = r110;
        goto L7
    }

    public static /* synthetic */ boolean l(a r14, String r16, String r17, String r18, Context r19, String r110, sbb.e r20, FileBizDomain r21, String r22, String r23, int r24) {
        if ((r24 & 16) == 0) goto L5;
        String r8 = "";
    L7:
        if ((r24 & 32) == 0) goto L9;
        String r9 = "";
    L11:
        if ((r24 & 64) == 0) goto L13;
        sbb.e r10 = null;
    L15:
        if ((r24 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) == 0) goto L17;
        FileBizDomain r11 = null;
    L19:
        if ((r24 & 256) == 0) goto L21;
        String r12 = null;
    L23:
        if ((r24 & 512) == 0) goto L25;
        String r13 = null;
    L27:
        return r14.j(r16, r17, r18, r19, r8, r9, r10, r11, r12, r13);
    L25:
        r13 = r23;
        goto L27
    L21:
        r12 = r22;
        goto L23
    L17:
        r11 = r21;
        goto L19
    L13:
        r10 = r20;
        goto L15
    L9:
        r9 = null;
        goto L11
    L5:
        r8 = r110;
        goto L7
    }

    public static BaseEntity b(String r24, String r26, String r27, Long r28, String r29, sbb.e r210, FileBizDomain r30, @EntityOperate String r31, @EntityType String r32, String r33, Long r34, Long r36, Long r37) {
        if (Intrinsics.areEqual(r24, "im_file") == false) goto L6;
        return new ImPermEntity(r26, pw4.b.e(r24), pw4.b.a(r24), "", r37, r28, r33, null, r34, r36, Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE, null);
    L6:
        return new UniBaseEntity(r26, pw4.b.e(r24), pw4.b.a(r24), r27, r29, r210, r30, r31, r32);
    }
}
