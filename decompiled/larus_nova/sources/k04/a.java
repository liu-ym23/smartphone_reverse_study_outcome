package k04;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Size;
import android.util.TypedValue;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.camera.video.AudioStats;
import c64.b;
import c64.d;
import c64.f;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.awemeopen.infra.base.player.resize.VideoScaleModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import r14.d0;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f501259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f501260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0 f501261c;

    /* JADX INFO: renamed from: k04.a$a, reason: collision with other inner class name */
    public static final class C6495a {
    }

    static {
    }

    public a(boolean r100, Context r101, d0 r102) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f501259a = r100;
        this.f501260b = r101;
        this.f501261c = r102;
    }

    @Override // c64.d
    public final b a(int r310, int r311, int r312, int r313) {
        int r100 = r312;
        int r101 = r313;
        Resources r102 = this.f501260b.getResources();
        DisplayMetrics r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics());
        int r104 = r103.heightPixels;
        Context r105 = this.f501260b;
        Point r106 = new Point();
        ((WindowManager) r105.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getRealSize(r106);
        Resources r107 = r105.getResources();
        DisplayMetrics r108 = WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics());
        int r109 = r106.x;
        int r110 = r106.y;
        Double r111 = Double.valueOf(Math.round(Math.sqrt(Math.pow(((double) r109) / ((double) r108.xdpi), 2.0d) + Math.pow(((double) r110) / ((double) r108.ydpi), 2.0d)) * 10.0d) / 10.0d);
        if (this.f501259a == true) goto L5;
    L7:
        int r112 = r104;
    L8:
        float r113 = r100;
        double r114 = r113 / r104;
        if (r114 > 0.5d) goto L160;
        VideoScaleModel r115 = VideoScaleModel.FIT;
        d0 r116 = this.f501261c;
        if (r116 == null) goto L134;
        int r117 = f.f22591a;
        Double r118 = Double.valueOf(r116.b());
        d0 r119 = this.f501261c;
        if (r119 == null) goto L15;
        Double r120 = Double.valueOf(r119.d());
    L16:
        d0 r121 = this.f501261c;
        if (r121 == null) goto L19;
        Double r122 = Double.valueOf(r121.a());
    L20:
        d0 r123 = this.f501261c;
        if (r123 == null) goto L23;
        Double r124 = Double.valueOf(r123.c());
    L24:
        double r125 = r310;
        double r126 = r311;
        double r210 = r125 / r126;
        double r127 = r100;
        double r128 = r101;
        double r211 = r127 / r128;
        VideoScaleModel r212 = r115;
        if (r210 <= 0.625d) goto L27;
    L79:
        if (r310 <= 0) goto L132;
        if (r311 <= 0) goto L132;
        double r129 = r127 / r125;
        if (r118 == null) goto L130;
        if (r122 == null) goto L130;
        if (r120 == null) goto L130;
        if (r124 == null) goto L130;
        if (Intrinsics.areEqual(r120, AudioStats.AUDIO_AMPLITUDE_NONE) == false) goto L89;
    L120:
        double r130 = r128 / r126;
        if (r311 <= r313) goto L124;
    L128:
        double r131 = r130 * r125;
        int r132 = r313;
    L129:
        r100 = (int) r131;
    L133:
        Size r133 = new Size(r100, r132);
    L203:
        return new b(r133, ImageView.ScaleType.CENTER_CROP, r212);
    L124:
        if (r129 < r130) goto L130;
        if ((r129 - r130) > 0.05d) goto L128;
    L89:
        if (Intrinsics.areEqual(r124, 1.0d) == true) goto L120;
        if (r120.doubleValue() <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L130;
        if (r124.doubleValue() >= 1.0d) goto L130;
        if ((1.0d - r124.doubleValue()) >= r120.doubleValue()) goto L98;
        r120 = Double.valueOf(1.0d - r124.doubleValue());
    L98:
        double r134 = r128 / r126;
        if (r311 <= r313) goto L114;
        double r135 = ((double) (r311 - r313)) / r126;
        if (r135 <= (r120.doubleValue() * 2.0d)) goto L108;
        double r136 = 1.0d - (r135 - (r120.doubleValue() * 2.0d));
        if (r129 < r136) goto L130;
        if ((r129 - r136) <= 0.05d) goto L130;
        r132 = (int) (r126 * r136);
        r131 = r125 * r136;
        goto L129
    L108:
        double r137 = (((r120.doubleValue() * 2.0d) - r135) + 1.0d) * r134;
        if (r129 < r137) goto L130;
        if ((0.05d - r137) <= 0.05d) goto L130;
    L113:
        r100 = (int) (r125 * r137);
        r132 = (int) (r126 * r137);
        goto L133
    L114:
        double r138 = ((r120.doubleValue() * 2.0d) + 1.0d) * r134;
        if (r129 < r138) goto L130;
        if ((r129 - r138) <= 0.05d) goto L130;
    L119:
        r100 = (int) (r125 * r138);
        double r139 = r126 * r138;
    L131:
        r132 = (int) r139;
    L130:
        r139 = r126 * r129;
    L132:
        r132 = r100;
        goto L133
    L27:
        if (r211 > 0.625d) goto L79;
        if (r210 < 0.4699999988079071d) goto L79;
        if (r310 <= 0) goto L78;
        if (r311 <= 0) goto L78;
        double r140 = r128 / r126;
        if (r118 == null) goto L77;
        if (r122 == null) goto L77;
        if (r120 == null) goto L77;
        if (r124 == null) goto L77;
        if (Intrinsics.areEqual(r118, AudioStats.AUDIO_AMPLITUDE_NONE) == false) goto L41;
    L70:
        r129 = r127 / r125;
        if (r310 > r100) goto L130;
        if (r140 < r129) goto L77;
        if ((r140 - r129) > 0.05d) goto L130;
    L41:
        if (Intrinsics.areEqual(r122, 1.0d) == true) goto L70;
        if (r118.doubleValue() <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L77;
        if (r122.doubleValue() >= 1.0d) goto L77;
        if ((1.0d - r122.doubleValue()) >= r118.doubleValue()) goto L50;
        r118 = Double.valueOf(1.0d - r122.doubleValue());
    L50:
        double r141 = r127 / r125;
        if (r310 <= r100) goto L65;
        double r142 = ((double) (r310 - r100)) / r125;
        if (r142 <= (r118.doubleValue() * 2.0d)) goto L59;
        r137 = 1.0d - (r142 - (r118.doubleValue() * 2.0d));
        if (r140 < r137) goto L77;
        if ((r140 - r137) > 0.05d) goto L113;
    L59:
        double r143 = (((r118.doubleValue() * 2.0d) - r142) + 1.0d) * r141;
        if (r140 < r143) goto L77;
        if ((r140 - r143) <= 0.05d) goto L77;
        r132 = (int) (r126 * r143);
        r131 = r125 * r143;
        goto L129
    L65:
        r138 = ((r118.doubleValue() * 2.0d) + 1.0d) * r141;
        if (r140 < r138) goto L77;
        if ((r140 - r138) > 0.05d) goto L119;
    L77:
        r100 = (int) (r140 * r125);
        r132 = r313;
    L78:
        r100 = r313;
        goto L132
    L23:
        r124 = null;
        goto L24
    L19:
        r122 = null;
        goto L20
    L15:
        r120 = null;
        goto L16
    L134:
        r212 = r115;
        int r144 = f.f22591a;
        double r145 = ((double) r310) / ((double) r311);
        double r146 = ((double) r100) / ((double) r101);
        if (r145 <= 0.625d) goto L137;
    L146:
        if (r310 <= 0) goto L150;
        if (r311 <= 0) goto L150;
        int r147 = (r311 * r100) / r310;
        int r148 = r100;
    L152:
        Size r149 = new Size(r148, r147);
        if (r149.getWidth() >= r100) goto L155;
    L157:
        r133 = r149;
        goto L203
    L155:
        if (r149.getHeight() < r101) goto L157;
        r212 = VideoScaleModel.FILL;
    L150:
        r148 = r100;
    L151:
        r147 = r148;
        goto L152
    L137:
        if (r146 > 0.625d) goto L146;
        if (r145 < 0.4699999988079071d) goto L146;
        if (r310 <= 0) goto L145;
        if (r311 <= 0) goto L145;
        r148 = (r310 * r101) / r311;
        r147 = r101;
    L145:
        r148 = r101;
        goto L151
    L160:
        if (r114 < 0.6666666666666666d) goto L162;
    L189:
        int r150 = f.f22591a;
        if ((((double) r310) / ((double) r100)) <= (((double) r311) / ((double) r101))) goto L196;
        if (r310 <= 0) goto L195;
        if (r311 <= 0) goto L195;
        r101 = (r311 * r100) / r310;
    L202:
        return new b(new Size(r100, r101), ImageView.ScaleType.FIT_CENTER, VideoScaleModel.FIT);
    L195:
        r101 = r100;
        goto L202
    L196:
        if (r310 <= 0) goto L200;
        if (r311 <= 0) goto L200;
        r100 = (r310 * r101) / r311;
    L200:
        r100 = r101;
        goto L202
    L162:
        if ((r113 / r112) >= 0.6666666666666666d) goto L189;
        int r151 = f.f22591a;
        double r152 = ((double) r310) / ((double) r311);
        double r153 = ((double) r100) / ((double) r101);
        if (r152 <= 0.5625d) goto L167;
    L176:
        if (r310 <= 0) goto L180;
        if (r311 <= 0) goto L180;
        int r154 = (r311 * r100) / r310;
        int r155 = r100;
    L182:
        Size r156 = new Size(r155, r154);
        ImageView.ScaleType r157 = ImageView.ScaleType.CENTER_CROP;
        if (r156.getWidth() >= r100) goto L185;
    L187:
        VideoScaleModel r158 = VideoScaleModel.FIT;
    L204:
        return new b(r156, r157, r158);
    L185:
        if (r156.getHeight() < r101) goto L187;
        r158 = VideoScaleModel.FILL;
    L180:
        r155 = r100;
    L181:
        r154 = r155;
        goto L182
    L167:
        if (r153 > 0.5625d) goto L176;
        if (r152 < 0.4699999988079071d) goto L176;
        if (r310 <= 0) goto L175;
        if (r311 <= 0) goto L175;
        r155 = (r310 * r101) / r311;
        r154 = r101;
    L175:
        r155 = r101;
        goto L181
    L5:
        if (r111.doubleValue() < 7.9d) goto L7;
        r112 = r104 - ((int) TypedValue.applyDimension(1, 50.0f, r103));
        goto L8
    }
}
