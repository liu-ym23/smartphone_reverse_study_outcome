package ztc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.renderscript.RSRuntimeException;
import com.alibaba.gaiax.render.view.basic.GXView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes41.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f573647a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f573648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f573649b;

        public final void a() {
            d r100 = this.f573649b.f573647a;
            d.a r101 = r100.f573654d;
            Context r102 = this.f573648a;
            Bitmap r103 = r100.f573653c;
            b r104 = r100.f573652b;
            int r105 = r104.f573641a;
            int r106 = r104.f573644d;
            int r107 = r105 / r106;
            int r108 = r104.f573642b / r106;
            int[] r109 = {r107, r108};
            int r110 = 0;
        L3:
            if (r110 >= 2) goto L8;
            if (r109[r110] == 0) goto L6;
            r110 = r110 + 1;
            goto L3
        L6:
            boolean r111 = true;
        L9:
            if (r111 == false) goto L11;
            r101 = r101;
            Bitmap r112 = null;
        L66:
            com.alibaba.gaiax.render.view.basic.d r113 = (com.alibaba.gaiax.render.view.basic.d) r101;
            GXView.b(r113.f24973a, r113.f24974b, r112);
            return;
        L11:
            Bitmap r114 = Bitmap.createBitmap(r107, r108, Bitmap.Config.ARGB_8888);
            Canvas r115 = new Canvas(r114);
            float r116 = 1.0f / r104.f573644d;
            r115.scale(r116, r116);
            Paint r117 = new Paint();
            r117.setFlags(3);
            r117.setColorFilter(new PorterDuffColorFilter(r104.f573645e, PorterDuff.Mode.SRC_ATOP));
            Rect r118 = r104.f573646f;
            if (r118 == null) goto L14;
            r115.drawBitmap(r103, new Rect(r118.left, r118.top, r118.right, r118.bottom), new Rect(0, 0, r104.f573641a, r104.f573642b), r117);
        L68:
            ztc.a.a(r102, r114, r104.f573643c);     // Catch: RSRuntimeException -> L17
            r101 = r101;
            r112 = r114;
        L63:
            if (r104.f573644d == 1) goto L66;
            Bitmap r119 = Bitmap.createScaledBitmap(r112, r104.f573641a, r104.f573642b, true);
            r112.recycle();
            r112 = r119;
        L17:
            int r120 = r104.f573643c;
            if (r120 >= 1) goto L20;
            r112 = null;
            goto L63
        L20:
            int r121 = r114.getWidth();
            int r122 = r114.getHeight();
            int r123 = r121 * r122;
            int[] r124 = new int[r123];
            r114.getPixels(r124, 0, r121, 0, 0, r121, r122);
            int r125 = r121 - 1;
            int r126 = r122 - 1;
            int r127 = (r120 + r120) + 1;
            int[] r128 = new int[r123];
            int[] r129 = new int[r123];
            int[] r130 = new int[r123];
            int[] r131 = new int[Math.max(r121, r122)];
            int r132 = (r127 + 1) >> 1;
            int r133 = r132 * r132;
            int r134 = r133 * 256;
            int[] r135 = new int[r134];
            int r136 = 0;
        L21:
            if (r136 >= r134) goto L23;
            r135[r136] = r136 / r133;
            r136 = r136 + 1;
            goto L21
        L23:
            int[][] r137 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r127, 3});
            int r138 = r120 + 1;
            int r139 = 0;
            int r140 = 0;
            int r141 = 0;
        L24:
            if (r139 >= r122) goto L41;
            Bitmap r210 = r114;
            int r142 = -r120;
            int r211 = 0;
            int r212 = 0;
            int r213 = 0;
            int r214 = 0;
            int r215 = 0;
            int r216 = 0;
            int r310 = 0;
            int r311 = 0;
            int r312 = 0;
        L27:
            if (r142 > r120) goto L33;
            int r313 = r122;
            int r314 = r126;
            int r143 = r124[r140 + Math.min(r125, Math.max(r142, 0))];
            int[] r315 = r137[r142 + r120];
            r315[0] = (r143 & 16711680) >> 16;
            r315[1] = (r143 & 65280) >> 8;
            r315[2] = r143 & 255;
            int r144 = r138 - Math.abs(r142);
            int r316 = r315[0];
            r211 = r211 + (r316 * r144);
            int r145 = r315[1];
            r212 = r212 + (r145 * r144);
            int r317 = r315[2];
            r213 = r213 + (r144 * r317);
            if (r142 <= 0) goto L31;
            r310 = r310 + r316;
            r311 = r311 + r145;
            r312 = r312 + r317;
        L32:
            r142 = r142 + 1;
            r122 = r313;
            r126 = r314;
            goto L27
        L31:
            r214 = r214 + r316;
            r215 = r215 + r145;
            r216 = r216 + r317;
            goto L32
        L33:
            int r318 = r122;
            int r319 = r126;
            int r146 = r120;
            int r147 = 0;
        L34:
            if (r147 >= r121) goto L40;
            r128[r140] = r135[r211];
            r129[r140] = r135[r212];
            r130[r140] = r135[r213];
            int r217 = r211 - r214;
            int r218 = r212 - r215;
            int r219 = r213 - r216;
            int[] r148 = r137[((r146 - r120) + r127) % r127];
            int r220 = r214 - r148[0];
            int r221 = r215 - r148[1];
            int r222 = r216 - r148[2];
            if (r139 != 0) goto L39;
            r131[r147] = Math.min((r147 + r120) + 1, r125);
        L39:
            int r149 = r124[r141 + r131[r147]];
            int r320 = (r149 & 16711680) >> 16;
            r148[0] = r320;
            int r321 = (r149 & 65280) >> 8;
            r148[1] = r321;
            int r150 = r149 & 255;
            r148[2] = r150;
            int r322 = r310 + r320;
            int r323 = r311 + r321;
            int r324 = r312 + r150;
            r211 = r217 + r322;
            r212 = r218 + r323;
            r213 = r219 + r324;
            r146 = (r146 + 1) % r127;
            int[] r151 = r137[r146 % r127];
            int r325 = r151[0];
            r214 = r220 + r325;
            int r326 = r151[1];
            r215 = r221 + r326;
            int r152 = r151[2];
            r216 = r222 + r152;
            r310 = r322 - r325;
            r311 = r323 - r326;
            r312 = r324 - r152;
            r140 = r140 + 1;
            r147 = r147 + 1;
            r135 = r135;
            goto L34
        L40:
            r141 = r141 + r121;
            r139 = r139 + 1;
            r114 = r210;
            r122 = r318;
            r126 = r319;
            goto L24
        L41:
            int[] r327 = r135;
            Bitmap r223 = r114;
            int r328 = r122;
            int r329 = r126;
            int r153 = 0;
        L42:
            if (r153 >= r121) goto L60;
            int r154 = -r120;
            int r155 = r154 * r121;
            int r156 = 0;
            int r157 = 0;
            int r158 = 0;
            int r159 = 0;
            int r160 = 0;
            int r224 = 0;
            int r225 = 0;
            int r226 = 0;
            int r227 = 0;
        L44:
            if (r154 > r120) goto L53;
            int[] r228 = r131;
            int r229 = Math.max(0, r155) + r153;
            int[] r330 = r137[r154 + r120];
            r330[0] = r128[r229];
            r330[1] = r129[r229];
            r330[2] = r130[r229];
            int r161 = r138 - Math.abs(r154);
            r156 = r156 + (r128[r229] * r161);
            r157 = r157 + (r129[r229] * r161);
            r158 = r158 + (r130[r229] * r161);
            if (r154 <= 0) goto L48;
            r225 = r225 + r330[0];
            r226 = r226 + r330[1];
            r227 = r227 + r330[2];
        L49:
            int r162 = r329;
            if (r154 >= r162) goto L52;
            r155 = r155 + r121;
        L52:
            r154 = r154 + 1;
            r329 = r162;
            r131 = r228;
            goto L44
        L48:
            r159 = r159 + r330[0];
            r160 = r160 + r330[1];
            r224 = r224 + r330[2];
            goto L49
        L53:
            int[] r230 = r131;
            int r163 = r329;
            int r231 = r153;
            int r331 = r120;
            int r164 = r328;
            int r165 = 0;
        L54:
            if (r165 >= r164) goto L59;
            r124[r231] = (((r124[r231] & (-16777216)) | (r327[r156] << 16)) | (r327[r157] << 8)) | r327[r158];
            int r166 = r156 - r159;
            int r167 = r157 - r160;
            int r168 = r158 - r224;
            int[] r332 = r137[((r331 - r120) + r127) % r127];
            int r169 = r159 - r332[0];
            int r170 = r160 - r332[1];
            int r232 = r224 - r332[2];
            int r333 = r120;
            if (r153 != 0) goto L58;
            r230[r165] = Math.min(r165 + r138, r163) * r121;
        L58:
            int r171 = r230[r165] + r153;
            int r334 = r128[r171];
            r332[0] = r334;
            int r335 = r129[r171];
            r332[1] = r335;
            int r172 = r130[r171];
            r332[2] = r172;
            int r233 = r225 + r334;
            int r234 = r226 + r335;
            int r235 = r227 + r172;
            r156 = r166 + r233;
            r157 = r167 + r234;
            r158 = r168 + r235;
            r331 = (r331 + 1) % r127;
            int[] r173 = r137[r331];
            int r336 = r173[0];
            r159 = r169 + r336;
            int r337 = r173[1];
            r160 = r170 + r337;
            int r174 = r173[2];
            r224 = r232 + r174;
            r225 = r233 - r336;
            r226 = r234 - r337;
            r227 = r235 - r174;
            r231 = r231 + r121;
            r165 = r165 + 1;
            r120 = r333;
            goto L54
        L59:
            r153 = r153 + 1;
            r329 = r163;
            r328 = r164;
            r131 = r230;
            goto L42
        L60:
            r223.setPixels(r124, 0, r121, 0, 0, r121, r328);
            r112 = r223;
            goto L63
        L14:
            r115.drawBitmap(r103, 0.0f, 0.0f, r117);
            goto L68
        L8:
            r111 = false;
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

        public a(c r100, Context r101) {
            this.f573649b = r100;
            this.f573648a = r101;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context r100 = this.f573647a.f573651a.get();     // Catch: Throwable -> L6
        if (this.f573647a.f573654d == null) goto L9;
        new Handler(Looper.getMainLooper()).post(new a(this, r100));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public c(d r100) {
        this.f573647a = r100;
    }
}
