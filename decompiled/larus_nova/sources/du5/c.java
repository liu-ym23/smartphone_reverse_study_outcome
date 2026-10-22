package du5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.dirs.h;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f470045a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f470046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final VFSPath f470047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Bitmap.CompressFormat f470048c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f470049d;

        public a(VFSPath r100) {
            this.f470048c = Bitmap.CompressFormat.JPEG;
            this.f470049d = 3;
            this.f470047b = r100;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f470050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteArrayOutputStream f470051b;

        public class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f470052a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f470053b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final int f470054c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final long f470055d;

            public a(int r100, int r101, int r102, long r103) {
                this.f470052a = r100;
                this.f470053b = r101;
                this.f470054c = r102;
                this.f470055d = r103;
            }
        }

        public b(a r100) {
            this.f470050a = r100;
        }

        public static int[] e(String r100) {
            BitmapFactory.Options r101 = new BitmapFactory.Options();
            r101.inJustDecodeBounds = true;
            r101.inSampleSize = 1;
            BitmapFactory.decodeFile(r100, r101);
            return new int[]{r101.outWidth, r101.outHeight};
        }

        public static int f(String r210) {
            ExifInterface r100 = new ExifInterface(r210);     // Catch: IOException -> L34
            ArrayList r110 = new ArrayList();
            Object[] r111 = {androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1};
            f06.b r112 = new f06.b();
            g06.a r101 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH));
            if (r101 == null) goto L7;
            f06.a[] r102 = r101.f479473i;
        L8:
            f06.a[] r103 = r102;
            int r104 = r103.length;
            int r105 = 0;
        L10:
            if (r105 >= r104) goto L17;
            f06.a r106 = r103[r105];
            int r113 = r105;
            int r114 = r104;
            f06.a[] r211 = r103;
            f06.d r107 = r106.preInvoke(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH, "android/media/ExifInterface", "getAttributeInt", r100, r111, "int", r112);     // Catch: Exception -> L33
            if (r107.f474982a == true) goto L19;
            r110.add(r106);     // Catch: Exception -> L33
        L19:
            if (r107.f474982a == false) goto L21;
            int r108 = ((Integer) r107.f474983b).intValue();
        L23:
            if (r108 != 3) goto L25;
            return 180;
        L25:
            if (r108 != 6) goto L27;
            return 90;
        L27:
            if (r108 != 8) goto L44;
            return 270;
        L44:
            return 0;
        L21:
            r108 = r100.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        L16:
            r105 = r113 + 1;
            r104 = r114;
            r103 = r211;
            goto L10
        L17:
            r107 = new f06.d(false, null);
            goto L19
        L7:
            r102 = ApiHookConfig.f245613d;
        L45:
            return 0;
        }

        public final VFSPath c(VFSPath r210) throws IOException {
            int r100 = this.f470050a.f470049d;
            int r101 = 0;
            if (r100 != 1) goto L5;
            String r102 = d(r210);
            String r103 = r210.toFile().getAbsolutePath();
            long r104 = r210.toFile().length() / 5;
            int r211 = f(r103);
            int[] r105 = e(r103);
            int r106 = r105[0];
            int r107 = r105[1];
            if (r106 > r107) goto L125;
            double r110 = ((double) r106) / ((double) r107);
            if (r110 > 1.0d) goto L117;
            if (r110 <= 0.5625d) goto L117;
            if (r106 <= 1280) goto L114;
            int r111 = 1280;
        L115:
            int r108 = (r107 * r111) / r106;
            r104 = 60;
            r101 = r111;
        L124:
            long r212 = r104;
            int r213 = r101;
            int r214 = r108;
        L143:
            return b(r103, r102, new a(r213, r214, r211, r212));
        L114:
            r111 = r106;
        L117:
            if (r110 <= 0.5625d) goto L119;
            r104 = 0;
            r108 = 0;
            goto L124
        L119:
            if (r107 <= 720) goto L121;
            int r112 = 720;
        L122:
            r101 = (r106 * r112) / r107;
            r108 = r112;
            goto L124
        L121:
            r112 = r107;
            goto L122
        L125:
            double r113 = ((double) r107) / ((double) r106);
            if (r113 > 1.0d) goto L135;
            if (r113 <= 0.5625d) goto L135;
            int r114 = 1280;
            if (r107 > 1280) goto L133;
            r114 = r107;
        L133:
            r212 = 60;
            r213 = (r106 * r114) / r107;
            r214 = r114;
        L135:
            if (r113 <= 0.5625d) goto L137;
            r213 = 0;
            r214 = 0;
            r212 = 0;
            goto L143
        L137:
            if (r106 <= 720) goto L139;
            int r109 = 720;
        L140:
            r212 = r104;
            r214 = (r107 * r109) / r106;
            r213 = r109;
            goto L143
        L139:
            r109 = r106;
            goto L140
        L5:
            if (r100 == 3) goto L26;
            if (r100 == 4) goto L8;
            return r210;
        L8:
            String r115 = d(r210);
            String r116 = r210.toFile().getAbsolutePath();
            int r117 = f(r116);
            int r118 = this.f470050a.f470046a;
            if (r118 > 0) goto L11;
        L13:
            long r119 = r210.toFile().length() / 1024;
        L14:
            long r120 = r119;
            int[] r121 = e(r116);
            int r122 = r121[0];
            int r123 = r121[1];
            int r124 = this.f470050a.f470046a;
            if (r124 > 0) goto L17;
        L19:
            this.f470050a.getClass();
            this.f470050a.getClass();
            float r125 = Math.min(r122 / r121[0], r123 / r121[1]);
            int r126 = (int) (r121[0] * r125);
            int r127 = (int) (r121[1] * r125);
            if (this.f470050a.f470046a <= (r210.toFile().length() / 1024.0f)) goto L25;
            if (r125 != 1.0f) goto L25;
            return r210;
        L25:
            return b(r116, r115, new a(r126, r127, r117, r120));
        L17:
            if (r124 >= (r210.toFile().length() / 1024.0f)) goto L19;
            float r128 = (float) Math.sqrt((r210.toFile().length() / 1024.0f) / this.f470050a.f470046a);
            r122 = (int) (r122 / r128);
            r123 = (int) (r123 / r128);
            goto L19
        L11:
            if (r118 >= (r210.toFile().length() / 1024)) goto L13;
            r119 = this.f470050a.f470046a;
            goto L14
        L26:
            String r129 = d(r210);
            String r130 = r210.toFile().getAbsolutePath();
            int r131 = f(r130);
            int[] r132 = e(r130);
            int r133 = r132[0];
            int r134 = r132[1];
            if (r133 <= r134) goto L30;
            r101 = 1;
        L30:
            if ((r133 % 2) != 1) goto L33;
            r133 = r133 + 1;
        L33:
            if ((r134 % 2) != 1) goto L35;
            r134 = r134 + 1;
        L35:
            if (r133 <= r134) goto L37;
            int r135 = r134;
        L38:
            if (r133 <= r134) goto L40;
            int r136 = r133;
        L41:
            double r137 = r136;
            double r138 = ((double) r135) / r137;
            double r139 = 100.0d;
            if (r138 > 1.0d) goto L76;
            if (r138 <= 0.5625d) goto L76;
            if (r136 >= 1664) goto L55;
            if ((r210.toFile().length() / 1024) < 150) goto L145;
            double r140 = (((double) (r135 * r136)) / Math.pow(1664.0d, 2.0d)) * 150.0d;
            if (r140 >= 60.0d) goto L53;
            double r141 = 60.0d;
        L97:
            if (r101 == 0) goto L99;
            int r142 = r134;
        L100:
            if (r101 == 0) goto L102;
            int r143 = r133;
        L104:
            return b(r130, r129, new a(r142, r143, r131, (long) r141));
        L102:
            r143 = r134;
            goto L104
        L99:
            r142 = r133;
        L53:
            r141 = r140;
        L145:
            return r210;
        L55:
            if (r136 < 1664) goto L61;
            if (r136 >= 4990) goto L61;
            r133 = r135 / 2;
            r134 = r136 / 2;
            r140 = (((double) (r133 * r134)) / Math.pow(2495.0d, 2.0d)) * 300.0d;
            r141 = 60.0d;
            if (r140 >= 60.0d) goto L53;
        L61:
            if (r136 >= 4990) goto L63;
        L67:
            int r144 = r136 / 1280;
            if (r144 != 0) goto L70;
            int r145 = 1;
        L71:
            int r146 = r135 / r145;
            int r147 = r136 / r145;
            double r148 = (((double) (r146 * r147)) / Math.pow(2560.0d, 2.0d)) * 300.0d;
            if (r148 < 100.0d) goto L95;
        L74:
            r139 = r148;
        L95:
            r134 = r147;
            r133 = r146;
            r141 = r139;
            goto L97
        L70:
            r145 = r144;
            goto L71
        L63:
            if (r136 >= 10240) goto L67;
            r146 = r135 / 4;
            r147 = r136 / 4;
            r148 = (((double) (r146 * r147)) / Math.pow(2560.0d, 2.0d)) * 300.0d;
            if (r148 >= 100.0d) goto L74;
        L76:
            if (r138 <= 0.5625d) goto L78;
        L91:
            double r149 = 1280.0d / r138;
            int r150 = (int) Math.ceil(r137 / r149);
            r146 = r135 / r150;
            r147 = r136 / r150;
            double r151 = (((double) (r146 * r147)) / (r149 * 1280.0d)) * 500.0d;
            if (r151 < 100.0d) goto L95;
        L94:
            r139 = r151;
            goto L95
        L78:
            if (r138 <= 0.5d) goto L91;
            if (r136 < 1280) goto L82;
        L84:
            int r152 = r136 / 1280;
            if (r152 != 0) goto L87;
            int r153 = 1;
        L88:
            r146 = r135 / r153;
            r147 = r136 / r153;
            r151 = (((double) (r146 * r147)) / 3686400.0d) * 400.0d;
            if (r151 >= 100.0d) goto L94;
        L87:
            r153 = r152;
            goto L88
        L82:
            if ((r210.toFile().length() / 1024) >= 200) goto L84;
        L40:
            r136 = r134;
            goto L41
        L37:
            r135 = r133;
            goto L38
        }

        public final String d(VFSPath r100) {
            if (r100 != null) goto L4;
            StringBuilder r101 = new StringBuilder("Luban_" + System.currentTimeMillis() + UUID.randomUUID().toString());
        L6:
            if (this.f470050a.f470048c != Bitmap.CompressFormat.WEBP) goto L8;
            r101.append(".webp");
        L10:
            return this.f470050a.f470047b.getRealPath() + File.separator + r101;
        L8:
            r101.append(".jpeg");
            goto L10
        L4:
            String r102 = r100.getName();
            r101 = new StringBuilder(r102.substring(0, r102.lastIndexOf(".")));
            goto L6
        }

        public static VFSPath a(b r110, VFSPath r111) throws IOException {
            String r100 = r110.d(r111);
            String r101 = r111.getRealPath();
            int r102 = f(r101);
            if (r102 == 0) goto L12;
            long r103 = r111.toFile().length();
            Bitmap r112 = BitmapFactory.decodeFile(r101);
            Matrix r113 = new Matrix();
            r113.postRotate(r102);
            Bitmap r104 = Bitmap.createBitmap(r112, 0, 0, r112.getWidth(), r112.getHeight(), r113, true);
            if (r104 == r112) goto L11;
            if (r112.isRecycled() == true) goto L11;
            r112.recycle();
        L11:
            return r110.g(r100, r104, r103);
        L12:
            return r111;
        }

        public final VFSPath b(String r110, String r111, a r112) throws IOException {
            int r100 = r112.f470052a;
            int r101 = r112.f470053b;
            BitmapFactory.Options r102 = new BitmapFactory.Options();
            int r103 = 1;
            r102.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(r110, r102);
            int r104 = r102.outHeight;
            int r105 = r102.outWidth;
        L4:
            if ((r104 / r103) > r101) goto L13;
            if ((r105 / r103) > r100) goto L13;
            r102.inSampleSize = r103;
            r102.inJustDecodeBounds = false;
            Bitmap r106 = BitmapFactory.decodeFile(r110, r102);
            if (r106 == null) goto L12;
            int r113 = r112.f470054c;
            Matrix r107 = new Matrix();
            r107.postRotate(r113);
            r106 = Bitmap.createBitmap(r106, 0, 0, r106.getWidth(), r106.getHeight(), r107, true);
        L12:
            return g(r111, r106, r112.f470055d);
        L13:
            r103 = r103 * 2;
            goto L4
        }

        public final VFSPath g(String r100, Bitmap r101, long r102) throws IOException {
            Objects.requireNonNull(r101, "Luban Compressbitmap cannot be null");
            VFSFile r103 = ay4.d.a().i(r100.substring(0, r100.lastIndexOf(HTTP.URL_DEFAULT)));
            if (r103.exists() == false) goto L5;
        L8:
            ByteArrayOutputStream r104 = this.f470051b;
            if (r104 != null) goto L11;
            this.f470051b = new ByteArrayOutputStream(r101.getWidth() * r101.getHeight());
        L12:
            int r105 = 100;
            r101.compress(this.f470050a.f470048c, 100, this.f470051b);
        L14:
            if ((this.f470051b.size() / 1024) <= r102) goto L18;
            if (r105 <= 6) goto L18;
            this.f470051b.reset();
            r105 = r105 - 6;
            r101.compress(this.f470050a.f470048c, r105, this.f470051b);
        L18:
            r101.recycle();
            OutputStream r106 = ay4.d.a().m(r100);
            this.f470051b.writeTo(r106);
            r106.close();
            return ay4.d.a().z(r100);
        L11:
            r104.reset();
            goto L12
        L5:
            if (r103.mkdirs() == true) goto L8;
            return null;
        }
    }

    public c(VFSPath r100) {
        this.f470045a = new a(r100);
    }

    public static VFSPath a(Context r100) {
        int r101 = h.f460642c;
        h r102 = h.a.a(r100);
        r102.c(ay4.d.a());
        com.bytedance.ee.bear.diskmanager.dirs.b r103 = new com.bytedance.ee.bear.diskmanager.dirs.b();
        Intrinsics.checkNotNullParameter(r103, "pathProvider");
        VFSPath r104 = r102.a(r103).a();
        if (r104.toFile().mkdirs() == false) goto L5;
        return r104;
    L5:
        if (r104.toFile().exists() == true) goto L7;
    L8:
        return null;
    L7:
        if (r104.toFile().isDirectory() == false) goto L8;
        return r104;
    }
}
