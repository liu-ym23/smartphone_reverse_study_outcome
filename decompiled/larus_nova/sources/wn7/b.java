package wn7;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareStrategy;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import f06.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import oo7.g;
import oo7.i;
import oo7.j;
import oo7.k;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    public static class a implements in7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wn7.a f560474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f560475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f560476c;

        @Override // in7.a
        public final void onFailed() {
            j.a();
            wn7.a r100 = this.f560474a;
            if (r100 == null) goto L6;
            r100.a(null);
            return;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // in7.a
        public final void onSuccess(Bitmap r100) {
            j.a();
            ByteArrayOutputStream r101 = null;
            byte[] r102 = null;
            r102 = null;
            if (r100 != null) goto L5;
        L41:
            wn7.a r103 = this.f560474a;
            if (r103 == null) goto L56;
            r103.a(null);
            return;
        L56:
            return;
        L5:
            if (r100.isRecycled() == true) goto L41;
            wn7.a r104 = this.f560474a;
            if (r104 != null) goto L10;
            return;
        L10:
            if (this.f560475b == true) goto L12;
            ByteArrayOutputStream r105 = new ByteArrayOutputStream();     // Catch: Throwable -> L23 Exception -> L25
            r100.compress(Bitmap.CompressFormat.JPEG, 85, r105);     // Catch: Throwable -> L19 Exception -> L21
            r102 = r105.toByteArray();     // Catch: Throwable -> L19 Exception -> L21
        L50:
            r105.close();     // Catch: IOException -> L31
        L33:
            r104.a(r102);
            return;
        L31:
            e = move-exception;
            k.b(e.toString());
        L21:
            e = e;
        L27:
            k.f(e);     // Catch: Throwable -> L19
            if (r105 == null) goto L33;
        L19:
            th = th;
            r101 = r105;
        L34:
            if (r101 != null) goto L47;
        L39:
            throw th;
        L47:
            r101.close();     // Catch: IOException -> L37
        L37:
            e = move-exception;
            k.b(e.toString());
            goto L39
        L25:
            e = e;
            r105 = null;
        L23:
            th = th;
            goto L34
        L12:
            if (this.f560476c == false) goto L14;
            byte[] r106 = i.a(r100, 128);
        L15:
            r104.a(r106);
            return;
        L14:
            r106 = i.a(r100, 32);
            goto L15
        }

        public a(wn7.a r100, boolean r101, boolean r102) {
            this.f560474a = r100;
            this.f560475b = r101;
            this.f560476c = r102;
        }
    }

    public static int a(ExifInterface r110) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0};
        f06.b r111 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r104 = r103;
        int r105 = r104.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L15;
        f06.a r107 = r104[r106];
        int r112 = r106;
        int r113 = r105;
        f06.a[] r114 = r104;
        d r108 = r107.preInvoke(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH, "android/media/ExifInterface", "getAttributeInt", r110, r101, "int", r111);     // Catch: Exception -> L22
        if (r108.f474982a == true) goto L12;
        r100.add(r107);     // Catch: Exception -> L22
        goto L14
    L12:
        int r109 = 0;
    L17:
        if (r108.f474982a == false) goto L21;
        return ((Integer) r108.f474983b).intValue();
    L21:
        return r110.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, r109);
    L14:
        r106 = r112 + 1;
        r105 = r113;
        r104 = r114;
        goto L8
    L15:
        r109 = 0;
        r108 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static void b(ShareContent r100, wn7.a r101) {
        if (r100.getShareStrategy() != ShareStrategy.SHARE_WITH_COMPONENT) goto L5;
    L7:
        boolean r102 = false;
    L8:
        c(r100, r101, r102, false);
        return;
    L5:
        if (r100.getShareStrategy() == ShareStrategy.SHARE_WITH_COMPONET_OPTIMIZE) goto L7;
        r102 = true;
        goto L8
    }

    public static void c(ShareContent r210, wn7.a r211, boolean r212, boolean r213) {
        ByteArrayOutputStream r100 = null;
        if (r210 != null) goto L6;
        r211.a(null);
        return;
    L6:
        String r101 = r210.getImageUrl();
        if (TextUtils.isEmpty(r101) == false) goto L18;
        if (r210.getImage() == null) goto L15;
        Bitmap r102 = r210.getImage();
        if (r213 == false) goto L13;
        byte[] r103 = i.a(r102, 128);
    L14:
        r211.a(r103);
        return;
    L13:
        r103 = i.a(r102, 32);
        goto L14
    L15:
        r211.a(null);
        return;
    L18:
        if (g.a(r101) == false) goto L20;
        j.b(r210);
        eo7.a.b.f473353a.d(r101, new a(r211, r212, r213));
        return;
    L20:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r101);
        if (r104.exists() == false) goto L93;
        if (r212 == false) goto L91;
        if (r213 == false) goto L28;
        Bitmap r105 = BitmapFactory.decodeFile(r104.getAbsolutePath());
        r211.a(i.a(r105, 128));
        if (r105 == null) goto L141;
        r105.recycle();
        return;
    L141:
        return;
    L28:
        String r106 = r104.getAbsolutePath();
        BitmapFactory.Options r107 = new BitmapFactory.Options();
        r107.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r106, r107);
        int r108 = r107.outHeight;
        int r109 = r107.outWidth;
        if (r108 <= 0) goto L80;
        if (r109 <= 0) goto L80;
        float r110 = r109;
        float r111 = r108;
        float r112 = r110 / r111;
        if (r111 > 114.0f) goto L39;
        if (r110 > 114.0f) goto L39;
        int r113 = r108;
        int r114 = r109;
    L46:
        if (r113 <= 0) goto L80;
        if (r114 <= 0) goto L80;
        if (r108 > r113) goto L53;
        if (r109 > r114) goto L53;
        int r115 = 1;
    L59:
        if (((r109 * r108) / (r115 * r115)) <= ((r114 * r113) * 2)) goto L61;
        r115 = r115 + 1;
        goto L59
    L61:
        r107.inSampleSize = r115;
        r107.inJustDecodeBounds = false;
        r107.inPurgeable = true;
        r107.inInputShareable = true;
        r107.inTempStorage = new byte[16384];
        Bitmap r116 = BitmapFactory.decodeFile(r106, r107);     // Catch: OutOfMemoryError -> L79
        float r117 = r114;
        float r118 = r113;
        float r119 = r117 / 2.0f;
        float r120 = r118 / 2.0f;
        Matrix r121 = new Matrix();
        r121.setScale((r117 + 0.5f) / r107.outWidth, (r118 + 0.5f) / r107.outHeight, r119, r120);
        Bitmap r122 = Bitmap.createBitmap(r114, r113, Bitmap.Config.ARGB_8888);     // Catch: OutOfMemoryError -> L79
        Canvas r123 = new Canvas(r122);
        r123.setMatrix(r121);
        r123.drawBitmap(r116, r119 - (r116.getWidth() / 2), r120 - (r116.getHeight() / 2), new Paint(2));
        r116.recycle();
        int r124 = a(new ExifInterface(r106));     // Catch: IOException -> L77
        Matrix r125 = new Matrix();     // Catch: IOException -> L77
        if (r124 != 6) goto L70;
        r125.postRotate(90.0f);     // Catch: IOException -> L77
    L75:
        r122 = Bitmap.createBitmap(r122, 0, 0, r122.getWidth(), r122.getHeight(), r125, true);     // Catch: IOException -> L77
    L81:
        if (r122 != null) goto L84;
    L90:
        Bitmap r126 = null;
    L92:
        Bitmap r127 = r126;
    L128:
        if (r127 == null) goto L142;
        ByteArrayOutputStream r128 = new ByteArrayOutputStream();     // Catch: Throwable -> L105 Exception -> L107
        r127.compress(Bitmap.CompressFormat.JPEG, 85, r128);     // Catch: Throwable -> L101 Exception -> L103
        r211.a(r128.toByteArray());     // Catch: Throwable -> L101 Exception -> L103
        r128.close();     // Catch: IOException -> L99
    L127:
    L113:
        r127.recycle();
        return;
    L103:
        e = e;
        r100 = r128;
    L108:
        k.f(e);     // Catch: Throwable -> L105
        if (r100 == null) goto L113;
        r100.close();     // Catch: IOException -> L99
    L101:
        th = move-exception;
        Throwable r129 = th;
    L115:
        if (r128 != null) goto L135;
    L120:
        r127.recycle();
        throw r129;
    L135:
        r128.close();     // Catch: IOException -> L118
    L118:
        e = move-exception;
        k.b(e.toString());
    L107:
        e = e;
    L105:
        th = move-exception;
        r129 = th;
        r128 = r100;
        goto L115
    L142:
        return;
    L99:
        e = move-exception;
        k.b(e.toString());
        goto L113
    L84:
        if (r122.getHeight() <= r122.getWidth()) goto L86;
        int r130 = r122.getWidth();
    L130:
        r126 = Bitmap.createBitmap(r122, (r122.getWidth() - r130) / 2, (r122.getHeight() - r130) / 2, r130, r130);     // Catch: OutOfMemoryError -> L89
    L86:
        r130 = r122.getHeight();
        goto L130
    L70:
        if (r124 != 3) goto L73;
        r125.postRotate(180.0f);     // Catch: IOException -> L77
        goto L75
    L73:
        if (r124 != 8) goto L75;
        r125.postRotate(270.0f);     // Catch: IOException -> L77
    L77:
        e = move-exception;
        e.printStackTrace();
    L53:
        r115 = Math.round(r111 / r113);
        int r131 = Math.round(r110 / r114);
        if (r115 < r131) goto L59;
        r115 = r131;
    L39:
        if (r112 >= 1.0f) goto L42;
        float r132 = (114.0f / r110) * r111;
    L45:
        r113 = (int) r132;
        r114 = (int) 114.0f;
        goto L46
    L42:
        if (r112 <= 1.0f) goto L44;
        r114 = (int) ((114.0f / r111) * r110);
        r113 = (int) 114.0f;
        goto L46
    L44:
        r132 = 114.0f;
    L80:
        r122 = null;
        goto L81
    L91:
        r126 = BitmapFactory.decodeFile(r104.getAbsolutePath());
        goto L92
    L93:
        r127 = null;
        goto L128
    }
}
