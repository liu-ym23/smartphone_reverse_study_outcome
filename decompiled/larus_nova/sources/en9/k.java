package en9;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.larus.office.base.plugins.toolbar.colorpicker.CircleColorView;
import com.larus.office.base.plugins.toolbar.model.FlowDocColorStop;
import com.larus.office.base.plugins.toolbar.view.RoundedView;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f473226a = null;

    static {
        f473226a = new k();
    }

    public k() {
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [en9.g] */
    /* JADX WARN: Type inference failed for: r13v12, types: [en9.i] */
    public static void a(final View r110, in9.d r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        if (r111 != null) goto L5;
        return;
    L5:
        boolean r100 = true;
        int r101 = 0;
        String r102 = "linear";
        Integer r103 = null;
        List<FlowDocColorStop> r104 = null;
        if ((r110 instanceof CircleColorView) == false) goto L40;
        in9.a r105 = r111.a();
        if (Intrinsics.areEqual(r111.getType(), "rgba") == false) goto L12;
        if (r105 == null) goto L12;
        ((CircleColorView) r110).setColor(b(r105.a(), r105.f(), r105.e(), r105.c()));
        return;
    L12:
        if (r105 == null) goto L14;
        r104 = r105.d();
    L14:
        List<FlowDocColorStop> r106 = r104;
        if (r106 != null) goto L17;
    L20:
        if (r100 == true) goto L38;
        List<FlowDocColorStop> r107 = r104;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator<T> r109 = r107.iterator();
    L23:
        if (r109.hasNext() == false) goto L28;
        FlowDocColorStop r112 = (FlowDocColorStop) r109.next();
        String r113 = r112.getColor();
        if (r113 != null) goto L27;
        r113 = "";
    L27:
        r108.add(new l(r112.getAlpha(), r113, r112.getOffset()));
        goto L23
    L28:
        String r114 = r111.getType();
        if (r114 == null) goto L32;
        r102 = r114;
    L32:
        if (r105 == null) goto L36;
        Float r115 = r105.b();
        if (r115 == null) goto L36;
        r101 = (int) r115.floatValue();
    L36:
        ((CircleColorView) r110).setGradientColor(new m(r101, r102, r108));
        return;
    L38:
        ((CircleColorView) r110).setColor(-1);
        return;
    L17:
        if (r106.isEmpty() == true) goto L20;
        r100 = false;
        goto L20
    L40:
        in9.a r116 = r111.a();
        if (Intrinsics.areEqual(r111.getType(), "rgba") == false) goto L48;
        if (r116 == null) goto L48;
        int r117 = b(r116.a(), r116.f(), r116.e(), r116.c());
        if ((r110 instanceof RoundedView) == false) goto L46;
        ((RoundedView) r110).setColor(r117);
        return;
    L46:
        r110.setBackgroundColor(r117);
        return;
    L48:
        if (r116 == null) goto L50;
        List<FlowDocColorStop> r118 = r116.d();
    L51:
        List<FlowDocColorStop> r119 = r118;
        if (r119 != null) goto L54;
    L57:
        boolean r120 = true;
    L58:
        if (r120 == false) goto L61;
        r110.setBackgroundColor(-1);
        return;
    L61:
        List<FlowDocColorStop> r121 = r118;
        ArrayList r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));
        Iterator<T> r123 = r121.iterator();
    L63:
        if (r123.hasNext() == false) goto L72;
        FlowDocColorStop r124 = (FlowDocColorStop) r123.next();
        k r125 = f473226a;
        String r126 = r124.getColor();
        if (r126 != null) goto L67;
        r126 = "";
    L67:
        float r127 = r124.getAlpha();
        r125.getClass();
        int r128 = Color.parseColor(r126);     // Catch: IllegalArgumentException -> L70
    L71:
        r122.add(Integer.valueOf(Color.argb((int) (RangesKt.coerceIn(r127, 0.0f, 1.0f) * 255), Color.red(r128), Color.green(r128), Color.blue(r128))));
    L70:
        r128 = -16777216;
        goto L71
    L72:
        int[] r129 = CollectionsKt.toIntArray(r122);
        String r130 = r111.getType();
        if (r130 == null) goto L77;
        r102 = r130;
    L77:
        if (Intrinsics.areEqual(r102, "radial") == false) goto L94;
        final GradientDrawable r131 = new GradientDrawable();
        r131.setGradientType(1);
        r131.setColors(r129);
        r131.setGradientCenter(0.5f, 0.5f);
        Integer r132 = Integer.valueOf(Math.max(r110.getWidth(), r110.getHeight()));
        if (r132.intValue() > 0) goto L82;
        r100 = false;
    L82:
        if (r100 == false) goto L84;
        r103 = r132;
    L84:
        if (r103 == null) goto L86;
        int r133 = r103.intValue();
    L87:
        r131.setGradientRadius(r133);
        if ((r110 instanceof RoundedView) == false) goto L93;
        final ?? r134 = new g(r131, r110);
        if (((RoundedView) r110).getHeight() <= 0) goto L92;
        r134.invoke();
        return;
    L92:
        r110.post(new h(r134));
        return;
    L93:
        r110.setBackground(r131);
        return;
    L86:
        r133 = 100;
        goto L87
    L94:
        if (r116 == null) goto L98;
        Float r135 = r116.b();
        if (r135 == null) goto L98;
        int r136 = (int) r135.floatValue();
    L99:
        int r137 = ((r136 % 360) + 360) % 360;
        if (r137 < 0) goto L103;
        if (r137 >= 23) goto L103;
        boolean r138 = true;
    L104:
        if (r138 == false) goto L106;
    L151:
        GradientDrawable.Orientation r139 = GradientDrawable.Orientation.LEFT_RIGHT;
    L152:
        final GradientDrawable r140 = new GradientDrawable(r139, r129);
        if ((r110 instanceof RoundedView) == false) goto L158;
        final ?? r141 = new i(r140, r110);
        if (((RoundedView) r110).getHeight() <= 0) goto L157;
        r141.invoke();
        return;
    L157:
        r110.post(new j(r141));
        return;
    L158:
        r110.setBackground(r140);
        return;
    L106:
        if (r137 >= 338) goto L151;
        if (23 > r137) goto L112;
        if (r137 >= 68) goto L112;
        boolean r142 = true;
    L113:
        if (r142 == false) goto L116;
        r139 = GradientDrawable.Orientation.BL_TR;
        goto L152
    L116:
        if (68 > r137) goto L119;
        if (r137 >= 113) goto L119;
        boolean r143 = true;
    L120:
        if (r143 == false) goto L123;
        r139 = GradientDrawable.Orientation.BOTTOM_TOP;
        goto L152
    L123:
        if (113 > r137) goto L126;
        if (r137 >= 158) goto L126;
        boolean r144 = true;
    L127:
        if (r144 == false) goto L130;
        r139 = GradientDrawable.Orientation.BR_TL;
        goto L152
    L130:
        if (158 > r137) goto L133;
        if (r137 >= 203) goto L133;
        boolean r145 = true;
    L134:
        if (r145 == false) goto L137;
        r139 = GradientDrawable.Orientation.RIGHT_LEFT;
        goto L152
    L137:
        if (203 > r137) goto L140;
        if (r137 >= 248) goto L140;
        boolean r146 = true;
    L141:
        if (r146 == false) goto L143;
        r139 = GradientDrawable.Orientation.TR_BL;
        goto L152
    L143:
        if (248 <= r137) goto L145;
    L147:
        r100 = false;
    L148:
        if (r100 == false) goto L150;
        r139 = GradientDrawable.Orientation.TOP_BOTTOM;
        goto L152
    L150:
        r139 = GradientDrawable.Orientation.TL_BR;
        goto L152
    L145:
        if (r137 >= 293) goto L147;
    L140:
        r146 = false;
    L133:
        r145 = false;
    L126:
        r144 = false;
    L119:
        r143 = false;
    L112:
        r142 = false;
    L103:
        r138 = false;
    L98:
        r136 = 0;
        goto L99
    L54:
        if (r119.isEmpty() == true) goto L57;
        r120 = false;
        goto L58
    L50:
        r118 = null;
        goto L51
    }

    public static boolean c(Context r100, in9.d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "colorValue");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L48
        List<FlowDocColorStop> r103 = null;
        Float r104 = null;
        if (Intrinsics.areEqual(r101.getType(), "rgba") == false) goto L19;
        in9.a r105 = r101.a();     // Catch: Throwable -> L48
        if (r105 == null) goto L8;
        Integer r106 = r105.f();     // Catch: Throwable -> L48
    L9:
        if (r105 == null) goto L11;
        Integer r107 = r105.e();     // Catch: Throwable -> L48
    L12:
        if (r105 == null) goto L14;
        Integer r108 = r105.c();     // Catch: Throwable -> L48
    L15:
        if (r105 == null) goto L18;
        r104 = r105.a();     // Catch: Throwable -> L48
    L18:
        return d(r100, r106, r107, r108, r104);
    L14:
        r108 = null;
        goto L15
    L11:
        r107 = null;
        goto L12
    L8:
        r106 = null;
        goto L9
    L19:
        in9.a r109 = r101.a();     // Catch: Throwable -> L48
        if (r109 == null) goto L22;
        r103 = r109.d();     // Catch: Throwable -> L48
    L22:
        List<FlowDocColorStop> r110 = r103;     // Catch: Throwable -> L48
        if (r110 != null) goto L25;
    L28:
        boolean r111 = true;
    L29:
        if (r111 == false) goto L31;
        return false;
    L31:
        List<FlowDocColorStop> r112 = r103;     // Catch: Throwable -> L48
        if ((r112 instanceof Collection) == true) goto L34;
    L36:
        Iterator<T> r113 = r112.iterator();     // Catch: Throwable -> L48
    L38:
        if (r113.hasNext() == false) goto L46;
        FlowDocColorStop r114 = (FlowDocColorStop) r113.next();     // Catch: Throwable -> L48
        int r115 = Color.parseColor(r114.getColor());     // Catch: Exception -> L43 Throwable -> L48
        boolean r116 = d(r100, Integer.valueOf(Color.red(r115)), Integer.valueOf(Color.green(r115)), Integer.valueOf(Color.blue(r115)), Float.valueOf(r114.getAlpha()));     // Catch: Throwable -> L48
    L44:
        if (r116 == true) goto L38;
        return false;
    L43:
        r116 = false;
    L46:
        return true;
    L34:
        if (r112.isEmpty() == false) goto L36;
    L25:
        if (r110.isEmpty() == true) goto L28;
        r111 = false;
    L48:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        Throwable r118 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r118 == null) goto L52;
        FLogger.f375446a.e("ColorRenderUtil", "shouldShowBorder", r118);
    L52:
        return false;
    }

    public static int b(Float r100, Integer r101, Integer r102, Integer r103) {
        float r104 = 1.0f;
        if (r100 == null) goto L5;
        r104 = RangesKt.coerceIn(r100.floatValue(), 0.0f, 1.0f);
    L5:
        int r105 = (int) (r104 * 255);
        int r106 = 0;
        if (r101 == null) goto L8;
        int r107 = RangesKt.coerceIn(r101.intValue(), 0, 255);
    L9:
        if (r102 == null) goto L11;
        int r108 = RangesKt.coerceIn(r102.intValue(), 0, 255);
    L12:
        if (r103 == null) goto L15;
        r106 = RangesKt.coerceIn(r103.intValue(), 0, 255);
    L15:
        return Color.argb(r105, r107, r108, r106);
    L11:
        r108 = 0;
        goto L12
    L8:
        r107 = 0;
        goto L9
    }

    public static boolean d(Context r110, Integer r111, Integer r210, Integer r211, Float r212) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r111 == null) goto L42;
        if (r210 == null) goto L43;
        if (r211 == null) goto L44;
        if (r212 == null) goto L47;
        int r100 = r111.intValue();
        double r101 = ((double) r100) / 255.0d;
        double r102 = ((double) r210.intValue()) / 255.0d;
        double r103 = ((double) r211.intValue()) / 255.0d;
        if (r101 > 0.03928d) goto L11;
        double r104 = r101 / 12.92d;
    L13:
        if (r102 > 0.03928d) goto L15;
        double r105 = r102 / 12.92d;
    L17:
        if (r103 > 0.03928d) goto L19;
        double r106 = r103 / 12.92d;
    L20:
        double r107 = ((r104 * 0.2126d) + (r105 * 0.7152d)) + (r106 * 0.0722d);
        if (r107 > 0.008856d) goto L23;
        double r108 = r107 * 903.3d;
    L24:
        float r109 = RangesKt.coerceIn(r212.floatValue(), 0.0f, 1.0f);
        boolean r112 = v19.h.f552477a;
        if (v19.h.a(null) == false) goto L37;
        if (AudioStats.AUDIO_AMPLITUDE_NONE <= r108) goto L29;
    L31:
        boolean r113 = false;
    L32:
        if (r113 == false) goto L34;
    L40:
        return true;
    L34:
        if (r109 < 0.2d) goto L40;
        return false;
    L29:
        if (r108 > 20.0d) goto L31;
        r113 = true;
        goto L32
    L37:
        if (r108 >= 94.0d) goto L40;
        if (r109 < 0.2d) goto L40;
        return false;
    L23:
        r108 = (Math.pow(r107, 0.3333333333333333d) * 116.0d) - 16.0d;
        goto L24
    L19:
        r106 = Math.pow((r103 + 0.055d) / 1.055d, 2.4d);
        goto L20
    L15:
        r105 = Math.pow((r102 + 0.055d) / 1.055d, 2.4d);
        goto L17
    L11:
        r104 = Math.pow((r101 + 0.055d) / 1.055d, 2.4d);
        goto L13
    L47:
        return false;
    L44:
        return false;
    L43:
        return false;
    L42:
        return false;
    }
}
