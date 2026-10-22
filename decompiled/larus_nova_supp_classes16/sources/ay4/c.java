package ay4;

import android.content.Context;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.diskmanager.dirs.CCMLarkDir;
import com.bytedance.ee.bear.diskmanager.dirs.CCMUserDir;
import com.ss.android.lark.diskmanage.storage.Storage;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import com.suite.lark.platform.component.storage.file.dirs.UniPathProvider;
import com.suite.lark.platform.component.storage.file.dirs.h;
import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Deprecated(message = "user userScope interface ICCMUserFileStorage")
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public a() {
        }

        public static VFSPath a(Biz r6, String r7, int r8) {
            int r0 = c.a;
            if ((r8 & 1) == 0) goto L6;
            r6 = null;
        L6:
            if ((r8 & 2) == 0) goto L8;
            r7 = null;
        L8:
            FileStorage r9 = LarkFileStorage.c();
            f r1 = f.h;
            String[] r3 = new String[3];
            r3[0] = "ccm";
            if (r6 == null) goto L12;
            String r10 = r6.getBizRootDir();
            if (r10 == null) goto L12;
        L13:
            r3[1] = r10;
            if (r7 != null) goto L16;
            r7 = "";
        L16:
            r3[2] = r7;
            return d.a().z(r9.b(r1, new com.ss.android.lark.storage.d(r3)).getRealPath());
        L12:
            r10 = "";
            goto L13
        }

        @Deprecated(message = "user userScope interface ICCMUserFileStorage")
        @JvmStatic
        public static VFSPath d(Biz r5, String r6, String r7) {
            Intrinsics.checkNotNullParameter(r5, "biz");
            Intrinsics.checkNotNullParameter(r7, "userSpace");
            FileStorage r8 = LarkFileStorage.d(r7);
            f r0 = f.e;
            String[] r2 = new String[3];
            r2[0] = "ccm";
            r2[1] = r5.getBizRootDir();
            if (r6 != null) goto L5;
            r6 = "";
        L5:
            r2[2] = r6;
            VFSPath r9 = r8.b(r0, new com.ss.android.lark.storage.d(r2));
            return d.a().z(r9.getRealPath());
        }

        @Deprecated(message = "user userScope interface ICCMUserFileStorage")
        @JvmStatic
        public static VFSPath g(Biz r5, String r6, String r7) {
            Intrinsics.checkNotNullParameter(r5, "biz");
            Intrinsics.checkNotNullParameter(r7, "userSpace");
            FileStorage r8 = LarkFileStorage.d(r7);
            f r0 = f.d;
            String[] r2 = new String[3];
            r2[0] = "ccm";
            r2[1] = r5.getBizRootDir();
            if (r6 != null) goto L5;
            r6 = "";
        L5:
            r2[2] = r6;
            VFSPath r9 = r8.b(r0, new com.ss.android.lark.storage.d(r2));
            return d.a().z(r9.getRealPath());
        }

        public static VFSPath b(Biz r7, String r8, boolean r9, int r10) {
            int r0 = c.a;
            if ((r10 & 1) == 0) goto L6;
            r7 = null;
        L6:
            if ((r10 & 2) == 0) goto L9;
            r8 = null;
        L9:
            if ((r10 & 4) == 0) goto L12;
            r9 = false;
        L12:
            if (r9 == false) goto L22;
            FileStorage r11 = LarkFileStorage.b();
            f r5 = f.g;
            String[] r3 = new String[3];
            r3[0] = "ccm";
            if (r7 == null) goto L17;
            String r12 = r7.getBizRootDir();
            if (r12 == null) goto L17;
        L18:
            r3[1] = r12;
            if (r8 != null) goto L21;
            r8 = "";
        L21:
            r3[2] = r8;
            VFSPath r13 = r11.b(r5, new com.ss.android.lark.storage.d(r3));
        L32:
            return d.a().z(r13.getRealPath());
        L17:
            r12 = "";
            goto L18
        L22:
            FileStorage r14 = LarkFileStorage.c();
            f r6 = f.g;
            String[] r4 = new String[3];
            r4[0] = "ccm";
            if (r7 == null) goto L26;
            String r16 = r7.getBizRootDir();
            if (r16 == null) goto L26;
        L27:
            r4[1] = r16;
            if (r8 != null) goto L30;
            r8 = "";
        L30:
            r4[2] = r8;
            r13 = r14.b(r6, new com.ss.android.lark.storage.d(r4));
        L26:
            r16 = "";
            goto L27
        }

        public static VFSPath c(Biz r7, String r8, boolean r9, int r10) {
            int r0 = c.a;
            if ((r10 & 1) == 0) goto L6;
            r7 = null;
        L6:
            if ((r10 & 2) == 0) goto L9;
            r8 = null;
        L9:
            if ((r10 & 4) == 0) goto L12;
            r9 = false;
        L12:
            if (r9 == false) goto L22;
            FileStorage r11 = LarkFileStorage.b();
            f r5 = f.e;
            String[] r3 = new String[3];
            r3[0] = "ccm";
            if (r7 == null) goto L17;
            String r12 = r7.getBizRootDir();
            if (r12 == null) goto L17;
        L18:
            r3[1] = r12;
            if (r8 != null) goto L21;
            r8 = "";
        L21:
            r3[2] = r8;
            VFSPath r13 = r11.b(r5, new com.ss.android.lark.storage.d(r3));
        L32:
            return d.a().z(r13.getRealPath());
        L17:
            r12 = "";
            goto L18
        L22:
            FileStorage r14 = LarkFileStorage.c();
            f r6 = f.e;
            String[] r4 = new String[3];
            r4[0] = "ccm";
            if (r7 == null) goto L26;
            String r16 = r7.getBizRootDir();
            if (r16 == null) goto L26;
        L27:
            r4[1] = r16;
            if (r8 != null) goto L30;
            r8 = "";
        L30:
            r4[2] = r8;
            r13 = r14.b(r6, new com.ss.android.lark.storage.d(r4));
        L26:
            r16 = "";
            goto L27
        }

        @JvmStatic
        public static VFSPath e(Biz r7, String r8, boolean r9, boolean r10) {
            boolean r0 = true;
            if (r10 == false) goto L20;
            int r11 = h.c;
            h r12 = h.a.a(LarkContext.getApplication());
            r12.c(d.a());
            if (r9 == false) goto L7;
            UniPathProvider r13 = (CCMLarkDir) CCMLarkDir.c.getValue();
        L8:
            Intrinsics.checkNotNullParameter(r13, "pathProvider");
            h.b r14 = r12.a(r13);
            if (r7 == null) goto L11;
            r14.c(r7.getBizRootDir());
        L11:
            if (r8 != null) goto L13;
        L16:
            if (r0 == true) goto L41;
            r14.c(r8);
        L41:
            return r14.a();
        L13:
            if (r8.length() == 0) goto L16;
            r0 = false;
            goto L16
        L7:
            r13 = (CCMUserDir) CCMUserDir.c.getValue();
            goto L8
        L20:
            if (r9 == false) goto L30;
            FileStorage r16 = LarkFileStorage.b();
            f r5 = f.d;
            String[] r3 = new String[3];
            r3[0] = "ccm";
            if (r7 == null) goto L25;
            String r17 = r7.getBizRootDir();
            if (r17 == null) goto L25;
        L26:
            r3[1] = r17;
            if (r8 != null) goto L29;
            r8 = "";
        L29:
            r3[2] = r8;
            VFSPath r18 = r16.b(r5, new com.ss.android.lark.storage.d(r3));
        L40:
            return d.a().z(r18.getRealPath());
        L25:
            r17 = "";
            goto L26
        L30:
            FileStorage r19 = LarkFileStorage.c();
            f r6 = f.d;
            String[] r4 = new String[3];
            r4[0] = "ccm";
            if (r7 == null) goto L34;
            String r20 = r7.getBizRootDir();
            if (r20 == null) goto L34;
        L35:
            r4[1] = r20;
            if (r8 != null) goto L38;
            r8 = "";
        L38:
            r4[2] = r8;
            r18 = r19.b(r6, new com.ss.android.lark.storage.d(r4));
        L34:
            r20 = "";
            goto L35
        }

        public static /* synthetic */ VFSPath f(Biz r2, String r3, boolean r4, boolean r5, int r6) {
            if ((r6 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = false;
        L12:
            if ((r6 & 8) == 0) goto L15;
            r5 = false;
        L15:
            return e(r2, r3, r4, r5);
        }
    }

    @Deprecated(message = "旧的接口，非特殊情况不要用")
    public static final class b {
        public static final /* synthetic */ int a = 0;

        static {
        }

        @JvmStatic
        public static final String a(Context r3, Biz r4, String r5) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "biz");
            Intrinsics.checkNotNullParameter(r5, "relativePath");
            int r0 = com.ss.android.lark.diskmanage.storage.c.a;
            return com.ss.android.lark.diskmanage.storage.c.a.a(r3, "ccm", Storage.Type.INNER_FILES, new String[]{r4.getBizRootDir(), r5});
        }
    }

    static {
        new a();
    }

    @JvmStatic
    public static final VFSPath a(Biz r2, String r3) {
        return a.b(r2, r3, true, 8);
    }

    @JvmStatic
    public static final VFSPath b(Biz r2, String r3) {
        return a.c(r2, r3, false, 12);
    }
}
