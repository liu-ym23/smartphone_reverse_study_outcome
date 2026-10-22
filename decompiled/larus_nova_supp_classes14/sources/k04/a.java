package k04;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Size;
import android.util.TypedValue;
import android.view.WindowManager;
import android.widget.ImageView;
import c64.b;
import c64.d;
import c64.f;
import com.bytedance.awemeopen.infra.base.player.resize.VideoScaleModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import r14.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements d {
    public final boolean a;
    public final Context b;
    public final d0 c;

    /* JADX INFO: renamed from: k04.a$a, reason: collision with other inner class name */
    public static final class C0140a {
    }

    static {
    }

    public a(boolean r2, Context r3, d0 r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final b a(int r33, int r34, int r35, int r36) {
        int r3 = r35;
        int r4 = r36;
        Resources r5 = this.b.getResources();
        DisplayMetrics r6 = WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics());
        int r7 = r6.heightPixels;
        Context r8 = this.b;
        Point r9 = new Point();
        ((WindowManager) r8.getSystemService("window")).getDefaultDisplay().getRealSize(r9);
        Resources r10 = r8.getResources();
        DisplayMetrics r11 = WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics());
        int r12 = r9.x;
        int r13 = r9.y;
        Double r14 = Double.valueOf(Math.round(Math.sqrt(Math.pow(((double) r12) / ((double) r11.xdpi), 2.0d) + Math.pow(((double) r13) / ((double) r11.ydpi), 2.0d)) * 10.0d) / 10.0d);
        if (this.a == true) goto L5;
    L7:
        int r15 = r7;
    L8:
        float r16 = r3;
        double r17 = r16 / r7;
        if (r17 > 0.5d) goto L160;
        VideoScaleModel r18 = VideoScaleModel.FIT;
        d0 r19 = this.c;
        if (r19 == null) goto L134;
        int r110 = f.a;
        Double r20 = Double.valueOf(r19.b());
        d0 r111 = this.c;
        if (r111 == null) goto L15;
        Double r112 = Double.valueOf(r111.d());
    L16:
        d0 r113 = this.c;
        if (r113 == null) goto L19;
        Double r114 = Double.valueOf(r113.a());
    L20:
        d0 r115 = this.c;
        if (r115 == null) goto L23;
        Double r116 = Double.valueOf(r115.c());
    L24:
        double r21 = r33;
        double r117 = r34;
        double r22 = r21 / r117;
        double r23 = r3;
        double r24 = r4;
        double r26 = r23 / r24;
        VideoScaleModel r28 = r18;
        if (r22 <= 0.625d) goto L27;
    L79:
        if (r33 <= 0) goto L132;
        if (r34 <= 0) goto L132;
        double r25 = r23 / r21;
        if (r20 == null) goto L130;
        if (r114 == null) goto L130;
        if (r112 == null) goto L130;
        if (r116 == null) goto L130;
        if (Intrinsics.areEqual(r112, 0.0d) == false) goto L89;
    L120:
        double r27 = r24 / r117;
        if (r34 <= r36) goto L124;
    L128:
        double r29 = r27 * r21;
        int r1 = r36;
    L129:
        r3 = (int) r29;
    L133:
        Size r2 = new Size(r3, r1);
    L203:
        return new b(r2, ImageView.ScaleType.CENTER_CROP, r28);
    L124:
        if (r25 < r27) goto L130;
        if ((r25 - r27) > 0.05d) goto L128;
    L89:
        if (Intrinsics.areEqual(r116, 1.0d) == true) goto L120;
        if (r112.doubleValue() <= 0.0d) goto L130;
        if (r116.doubleValue() >= 1.0d) goto L130;
        if ((1.0d - r116.doubleValue()) >= r112.doubleValue()) goto L98;
        r112 = Double.valueOf(1.0d - r116.doubleValue());
    L98:
        double r30 = r24 / r117;
        if (r34 <= r36) goto L114;
        double r31 = ((double) (r34 - r36)) / r117;
        if (r31 <= (r112.doubleValue() * 2.0d)) goto L108;
        double r32 = 1.0d - (r31 - (r112.doubleValue() * 2.0d));
        if (r25 < r32) goto L130;
        if ((r25 - r32) <= 0.05d) goto L130;
        r1 = (int) (r117 * r32);
        r29 = r21 * r32;
        goto L129
    L108:
        double r37 = (((r112.doubleValue() * 2.0d) - r31) + 1.0d) * r30;
        if (r25 < r37) goto L130;
        if ((0.05d - r37) <= 0.05d) goto L130;
    L113:
        r3 = (int) (r21 * r37);
        r1 = (int) (r117 * r37);
        goto L133
    L114:
        double r38 = ((r112.doubleValue() * 2.0d) + 1.0d) * r30;
        if (r25 < r38) goto L130;
        if ((r25 - r38) <= 0.05d) goto L130;
    L119:
        r3 = (int) (r21 * r38);
        double r118 = r117 * r38;
    L131:
        r1 = (int) r118;
    L130:
        r118 = r117 * r25;
    L132:
        r1 = r3;
        goto L133
    L27:
        if (r26 > 0.625d) goto L79;
        if (r22 < 0.4699999988079071d) goto L79;
        if (r33 <= 0) goto L78;
        if (r34 <= 0) goto L78;
        double r39 = r24 / r117;
        if (r20 == null) goto L77;
        if (r114 == null) goto L77;
        if (r112 == null) goto L77;
        if (r116 == null) goto L77;
        if (Intrinsics.areEqual(r20, 0.0d) == false) goto L41;
    L70:
        r25 = r23 / r21;
        if (r33 > r3) goto L130;
        if (r39 < r25) goto L77;
        if ((r39 - r25) > 0.05d) goto L130;
    L41:
        if (Intrinsics.areEqual(r114, 1.0d) == true) goto L70;
        if (r20.doubleValue() <= 0.0d) goto L77;
        if (r114.doubleValue() >= 1.0d) goto L77;
        if ((1.0d - r114.doubleValue()) >= r20.doubleValue()) goto L50;
        r20 = Double.valueOf(1.0d - r114.doubleValue());
    L50:
        double r40 = r23 / r21;
        if (r33 <= r3) goto L65;
        double r41 = ((double) (r33 - r3)) / r21;
        if (r41 <= (r20.doubleValue() * 2.0d)) goto L59;
        r37 = 1.0d - (r41 - (r20.doubleValue() * 2.0d));
        if (r39 < r37) goto L77;
        if ((r39 - r37) > 0.05d) goto L113;
    L59:
        double r119 = (((r20.doubleValue() * 2.0d) - r41) + 1.0d) * r40;
        if (r39 < r119) goto L77;
        if ((r39 - r119) <= 0.05d) goto L77;
        r1 = (int) (r117 * r119);
        r29 = r21 * r119;
        goto L129
    L65:
        r38 = ((r20.doubleValue() * 2.0d) + 1.0d) * r40;
        if (r39 < r38) goto L77;
        if ((r39 - r38) > 0.05d) goto L119;
    L77:
        r3 = (int) (r39 * r21);
        r1 = r36;
    L78:
        r3 = r36;
        goto L132
    L23:
        r116 = null;
        goto L24
    L19:
        r114 = null;
        goto L20
    L15:
        r112 = null;
        goto L16
    L134:
        r28 = r18;
        int r42 = f.a;
        double r43 = ((double) r33) / ((double) r34);
        double r44 = ((double) r3) / ((double) r4);
        if (r43 <= 0.625d) goto L137;
    L146:
        if (r33 <= 0) goto L150;
        if (r34 <= 0) goto L150;
        int r45 = (r34 * r3) / r33;
        int r46 = r3;
    L152:
        Size r47 = new Size(r46, r45);
        if (r47.getWidth() >= r3) goto L155;
    L157:
        r2 = r47;
        goto L203
    L155:
        if (r47.getHeight() < r4) goto L157;
        r28 = VideoScaleModel.FILL;
    L150:
        r46 = r3;
    L151:
        r45 = r46;
        goto L152
    L137:
        if (r44 > 0.625d) goto L146;
        if (r43 < 0.4699999988079071d) goto L146;
        if (r33 <= 0) goto L145;
        if (r34 <= 0) goto L145;
        r46 = (r33 * r4) / r34;
        r45 = r4;
    L145:
        r46 = r4;
        goto L151
    L160:
        if (r17 < 0.6666666666666666d) goto L162;
    L189:
        int r48 = f.a;
        if ((((double) r33) / ((double) r3)) <= (((double) r34) / ((double) r4))) goto L196;
        if (r33 <= 0) goto L195;
        if (r34 <= 0) goto L195;
        r4 = (r34 * r3) / r33;
    L202:
        return new b(new Size(r3, r4), ImageView.ScaleType.FIT_CENTER, VideoScaleModel.FIT);
    L195:
        r4 = r3;
        goto L202
    L196:
        if (r33 <= 0) goto L200;
        if (r34 <= 0) goto L200;
        r3 = (r33 * r4) / r34;
    L200:
        r3 = r4;
        goto L202
    L162:
        if ((r16 / r15) >= 0.6666666666666666d) goto L189;
        int r49 = f.a;
        double r50 = ((double) r33) / ((double) r34);
        double r51 = ((double) r3) / ((double) r4);
        if (r50 <= 0.5625d) goto L167;
    L176:
        if (r33 <= 0) goto L180;
        if (r34 <= 0) goto L180;
        int r52 = (r34 * r3) / r33;
        int r53 = r3;
    L182:
        Size r54 = new Size(r53, r52);
        ImageView.ScaleType r55 = ImageView.ScaleType.CENTER_CROP;
        if (r54.getWidth() >= r3) goto L185;
    L187:
        VideoScaleModel r56 = VideoScaleModel.FIT;
    L204:
        return new b(r54, r55, r56);
    L185:
        if (r54.getHeight() < r4) goto L187;
        r56 = VideoScaleModel.FILL;
    L180:
        r53 = r3;
    L181:
        r52 = r53;
        goto L182
    L167:
        if (r51 > 0.5625d) goto L176;
        if (r50 < 0.4699999988079071d) goto L176;
        if (r33 <= 0) goto L175;
        if (r34 <= 0) goto L175;
        r53 = (r33 * r4) / r34;
        r52 = r4;
    L175:
        r53 = r4;
        goto L181
    L5:
        if (r14.doubleValue() < 7.9d) goto L7;
        r15 = r7 - ((int) TypedValue.applyDimension(1, 50.0f, r6));
        goto L8
    }
}
