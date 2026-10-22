package yl3;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.ByteArrayOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import wl3.e;
import wl3.f;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<? extends Object>[] f568307a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f568308b = null;

    /* JADX INFO: renamed from: yl3.a$a, reason: collision with other inner class name */
    public static final class RunnableC8353a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View[] f568309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f568310b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ zl3.a f568311c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f568312d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f568313e;

        public RunnableC8353a(View[] r100, String r101, zl3.a r102, Ref.ObjectRef r103, CountDownLatch r104) {
            this.f568309a = r100;
            this.f568310b = r101;
            this.f568311c = r102;
            this.f568312d = r103;
            this.f568313e = r104;
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [T, java.lang.String] */
        public final void a() {
            View[] r100 = this.f568309a;
            int r101 = r100.length;
            int r102 = 0;
            int r103 = 0;
        L3:
            if (r103 >= r101) goto L355;
            View r104 = r100[r103];
            if ((r104 instanceof ViewGroup) == false) goto L13;
            Activity r105 = a.a(((ViewGroup) r104).getChildAt(r102).getContext());
            if (r105 == null) goto L10;
            String r106 = r105.getClass().getName();
        L11:
            boolean r107 = true;
            if ((!Intrinsics.areEqual(r106, this.f568310b)) == true) goto L13;
            int[] r108 = new int[2];
            r104.getLocationOnScreen(r108);
            int r110 = r108[r102];
            ViewGroup r111 = (ViewGroup) r104;
            new Rect(r110, r108[1], r111.getWidth() + r110, r108[1] + r111.getHeight());
            List<zl3.a> r112 = this.f568311c.a();
            HashMap r113 = new HashMap();
            LinkedList r114 = new LinkedList();
            r114.push(r104);
        L16:
            if ((r114.isEmpty() ^ r107) == false) goto L350;
            int r115 = r114.size();
            int r116 = 0;
        L18:
            if (r116 >= r115) goto L16;
            View r117 = (View) r114.pop();
            if (r113.containsKey(r117) == false) goto L25;
            Object r109 = r113.get(r117);
            if (r109 != null) goto L24;
            Intrinsics.throwNpe();
        L24:
            zl3.a r118 = (zl3.a) r109;
        L26:
            zl3.a r119 = r118;
            if ((r117.getParent() instanceof View) == false) goto L80;
            Object r120 = r117.getParent();
            if (r120 == null) goto L79;
            if (r113.containsKey((View) r120) == false) goto L80;
            Object r121 = r117.getParent();
            if (r121 == null) goto L77;
            if (((zl3.a) r113.get((View) r121)) == null) goto L75;
            Object r122 = r117.getParent();
            if (r122 == null) goto L74;
            ((View) r122).getScrollX();
            r117.getLeft();
            r117.getTranslationX();
            r119.getClass();
            Object r123 = r117.getParent();
            if (r123 == null) goto L72;
            ((View) r123).getScrollY();
            r117.getTop();
            r117.getTranslationY();
            Object r124 = r117.getTag(e.f560190a);
            if (r124 != null) goto L43;
            int r210 = r101;
            int r211 = r115;
            zl3.a r125 = r119;
        L69:
            zl3.a r126 = r125;
        L81:
            String r127 = r117.getClass().getSimpleName();
            switch(r127.hashCode()) {
                case -1588574979: goto L109;
                case -938935918: goto L106;
                case -443652810: goto L103;
                case -195214475: goto L100;
                case 2666181: goto L97;
                case 1125864064: goto L94;
                case 1127291599: goto L91;
                case 1310765783: goto L88;
                case 2114496391: goto L85;
                default: goto L111;
            };
        L111:
            String r128 = r117.getClass().getSimpleName();
        L112:
            r126.d(r128);
            r126.A(r117.getWidth());
            r126.h(r117.getHeight());
            Context r129 = r117.getContext();
            if (r117.getId() != (-1)) goto L359;
            String r130 = "";
        L118:
            r126.i(r130);
            r126.g(System.identityHashCode(r117));
            r126.z(r117.getVisibility());
            r126.w(r117.getTranslationX());
            r126.x(r117.getTranslationY());
            r126.t(r117.getScrollX());
            r126.u(r117.getScrollY());
            ArrayList r131 = new ArrayList();
            Map<Integer, String> r132 = c.f568314a;
            Context r133 = r117.getContext();
            ViewGroup.LayoutParams r134 = r117.getLayoutParams();
            if ((r134 instanceof FrameLayout.LayoutParams) == false) goto L132;
            FrameLayout.LayoutParams r135 = (FrameLayout.LayoutParams) r134;
            ArrayList r136 = new ArrayList();
            r136.addAll(c.c(r135));
            Integer r137 = Integer.valueOf(r135.gravity);
            int r138 = r137.intValue();
            if (r138 == (-1)) goto L124;
            if (r138 == 0) goto L124;
            boolean r139 = true;
        L125:
            if (r139 == true) goto L128;
            r137 = null;
        L128:
            if (r137 == null) goto L130;
            b.a(r137.intValue());
            r136.add(new f("layout_gravity"));
        L130:
            Iterable r140 = r136;
        L213:
            int r141 = d.f568316a;
            if ((r117 instanceof EditText) == true) goto L242;
            if ((r117 instanceof Switch) == true) goto L242;
            if ((r117 instanceof ToggleButton) == true) goto L242;
            if ((r117 instanceof RadioButton) == true) goto L242;
            if ((r117 instanceof CheckBox) == true) goto L242;
            if ((r117 instanceof Button) == true) goto L242;
            if ((r117 instanceof TextView) == false) goto L235;
            TextView r142 = (TextView) r117;
            ArrayList r143 = new ArrayList();
            r143.addAll(d.b(r142));
            StringsKt.replace$default(r142.getText().toString(), "\"", "&quot;", false, 4, null);
            r143.add(new f("text"));
            String.format("#%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r142.getCurrentTextColor())}, 1));
            r143.add(new f("textColor"));
            r142.getTextSize();
            r143.add(new f("textSize"));
            Iterable r144 = r143;
        L253:
            Iterator r145 = r144.iterator();
        L255:
            if (r145.hasNext() == false) goto L259;
            f r146 = (f) r145.next();
            if (r131.contains(r146) == true) goto L255;
            r131.add(r146);
            goto L255
        L259:
            Iterator r147 = r140.iterator();
        L261:
            if (r147.hasNext() == false) goto L265;
            f r148 = (f) r147.next();
            if (r131.contains(r148) == true) goto L261;
            r131.add(r148);
            goto L261
        L265:
            int r149 = e.f560191b;
            if (r117.getTag(r149) == null) goto L277;
            Object r150 = r117.getTag(r149);
            if (r150 == null) goto L276;
            Iterator r151 = ((Collection) r150).iterator();
        L271:
            if (r151.hasNext() == false) goto L277;
            f r152 = (f) r151.next();
            if (r131.contains(r152) == true) goto L271;
            r131.add(r152);
            goto L271
        L276:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Collection<com.bytedance.android.tetrisinspectorbase.XmlAttribute>");
        L277:
            r126.B(r131);
            View r153 = r117;
        L278:
            if (r153 == null) goto L293;
            Object r154 = r153.getParent();
            if ((r154 instanceof RecyclerView) == true) goto L282;
            if ((r154 instanceof View) == true) goto L290;
            r153 = null;
            goto L278
        L290:
            r153 = (View) r154;
            goto L278
        L282:
            RecyclerView.Adapter r155 = ((RecyclerView) r154).getAdapter();     // Catch: Throwable -> L292
            if (r155 == null) goto L285;
            String r156 = r155.getClass().getSimpleName();     // Catch: Throwable -> L292
        L286:
            Pair r157 = new Pair(((RecyclerView) r154).getChildViewHolder(r153).getClass().getSimpleName(), r156);     // Catch: Throwable -> L292
        L294:
            if (r157 == null) goto L297;
            r126.y((String) r157.getFirst());
            r126.b((String) r157.getSecond());
        L297:
            if ((r117 instanceof ImageView) == false) goto L299;
            r126.s(((ImageView) r117).getScaleType().name());
        L299:
            CharSequence r158 = r117.getContentDescription();
            if (r158 == null) goto L302;
            String r159 = r158.toString();
        L303:
            r126.e(r159);
            Field r160 = View.class.getDeclaredField("mBackgroundResource");     // Catch: Exception -> L311
            r160.setAccessible(true);     // Catch: Exception -> L311
            Integer r161 = (Integer) r160.get(r117);     // Catch: Exception -> L311
            if (r161 == null) goto L307;
            int r162 = r161.intValue();     // Catch: Exception -> L311
        L308:
            if (r162 == 0) goto L313;
            String r163 = r117.getContext().getResources().getResourceEntryName(r162);     // Catch: Exception -> L311
        L314:
            r126.c(r163);
            if (Build.VERSION.SDK_INT < 26) goto L325;
            int r164 = r117.getFocusable();
            if (r164 != 0) goto L319;
            String r165 = "false";
        L323:
            r126.f(r165);
            goto L325
        L319:
            if (r164 == 1) goto L321;
            r165 = "auto";
            goto L323
        L321:
            r165 = "true";
        L325:
            if ((r117 instanceof TextView) == false) goto L337;
            TextView r166 = (TextView) r117;
            CharSequence r167 = r166.getText();
            if (r167 == null) goto L337;
            String r168 = r167.toString();
            if (r168 == null) goto L337;
            if (r168.length() <= 0) goto L333;
            boolean r169 = true;
            boolean r170 = true;
        L334:
            if (r170 != r169) goto L337;
            r126.v(r166.getText().toString());
            goto L337
        L333:
            r169 = true;
            r170 = false;
        L337:
            ViewGroup.LayoutParams r171 = r117.getLayoutParams();
            if ((r171 instanceof ViewGroup.MarginLayoutParams) == true) goto L341;
            r171 = null;
        L341:
            if (r171 == null) goto L343;
            ViewGroup.MarginLayoutParams r172 = (ViewGroup.MarginLayoutParams) r171;
            r126.k(r172.leftMargin);
            r126.m(r172.topMargin);
            r126.l(r172.rightMargin);
            r126.j(r172.bottomMargin);
        L343:
            r126.o(r117.getPaddingLeft());
            r126.q(r117.getPaddingTop());
            r126.p(r117.getPaddingRight());
            r126.n(r117.getPaddingBottom());
            if ((r117 instanceof ViewGroup) == false) goto L348;
            ViewGroup r173 = (ViewGroup) r117;
            int r174 = r173.getChildCount();
            int r175 = 0;
        L346:
            if (r175 >= r174) goto L348;
            View r176 = r173.getChildAt(r175);
            zl3.a r177 = new zl3.a();
            r113.put(r176, r177);
            r126.a().add(r177);
            r114.push(r176);
            r175 = r175 + 1;
        L348:
            r116 = r116 + 1;
            r100 = r100;
            r101 = r210;
            r115 = r211;
            r107 = true;
        L313:
            r163 = null;
            goto L314
        L307:
            r162 = 0;
        L311:
            e = move-exception;
            e.toString();
            goto L313
        L302:
            r159 = null;
            goto L303
        L285:
            r156 = null;
        L293:
            r157 = null;
            goto L294
        L235:
            if ((r117 instanceof SeekBar) == true) goto L242;
            if ((r117 instanceof RatingBar) == true) goto L242;
            if ((r117 instanceof ProgressBar) == true) goto L242;
            if ((r117 instanceof ImageView) == false) goto L247;
            ImageView r178 = (ImageView) r117;
            ArrayList r179 = new ArrayList();
            r179.addAll(d.b(r178));
            r178.getScaleType().name();
            r179.add(new f("scaleType"));
            r144 = r179;
            goto L253
        L247:
            if ((r117 instanceof LinearLayout) == false) goto L250;
            LinearLayout r180 = (LinearLayout) r117;
            ArrayList r181 = new ArrayList();
            r181.addAll(d.c(r180));
            r180.getOrientation();
            r181.add(new f("orientation"));
            r144 = r181;
            goto L253
        L250:
            if ((r117 instanceof ViewGroup) == false) goto L252;
            r144 = d.c((ViewGroup) r117);
            goto L253
        L252:
            r144 = d.b(r117);
        L242:
            r144 = d.b(r117);
        L124:
            r139 = false;
            goto L125
        L132:
            if ((r134 instanceof LinearLayout.LayoutParams) == false) goto L153;
            LinearLayout.LayoutParams r182 = (LinearLayout.LayoutParams) r134;
            r136 = new ArrayList();
            r136.addAll(c.c(r182));
            Float r183 = Float.valueOf(r182.weight);
            if (r183.floatValue() == 0.0f) goto L136;
            boolean r184 = true;
        L137:
            if (r184 == true) goto L140;
            r183 = null;
        L140:
            if (r183 == null) goto L142;
            String.valueOf(r183.floatValue());
            r136.add(new f("layout_weight"));
        L142:
            Integer r185 = Integer.valueOf(r182.gravity);
            int r186 = r185.intValue();
            if (r186 == (-1)) goto L146;
            if (r186 == 0) goto L146;
            boolean r187 = true;
        L147:
            if (r187 == true) goto L150;
            r185 = null;
        L150:
            if (r185 == null) goto L130;
            b.a(r185.intValue());
            r136.add(new f("layout_gravity"));
        L146:
            r187 = false;
            goto L147
        L136:
            r184 = false;
            goto L137
        L153:
            if ((r134 instanceof RelativeLayout.LayoutParams) == false) goto L159;
            RelativeLayout.LayoutParams r188 = (RelativeLayout.LayoutParams) r134;
            ArrayList r189 = new ArrayList();
            r189.addAll(c.c(r188));
            int[] r190 = r188.getRules();
            c.b(r133, r190, 2, r189);
            c.b(r133, r190, 4, r189);
            c.b(r133, r190, 8, r189);
            c.b(r133, r190, 5, r189);
            c.b(r133, r190, 7, r189);
            c.b(r133, r190, 6, r189);
            c.b(r133, r190, 3, r189);
            c.b(r133, r190, 0, r189);
            c.b(r133, r190, 1, r189);
            c.b(r133, r190, 18, r189);
            c.b(r133, r190, 19, r189);
            c.b(r133, r190, 16, r189);
            c.b(r133, r190, 17, r189);
            c.a(r190, 12, r189);
            c.a(r190, 9, r189);
            c.a(r190, 11, r189);
            c.a(r190, 10, r189);
            c.a(r190, 20, r189);
            c.a(r190, 21, r189);
            c.a(r190, 14, r189);
            c.a(r190, 13, r189);
            c.a(r190, 15, r189);
            if (r188.alignWithParent == false) goto L157;
            r189.add(new f("layout_alignWithParentIfMissing"));
        L157:
            r140 = r189;
            goto L213
        L159:
            if ((r134 instanceof ConstraintLayout.LayoutParams) == false) goto L210;
            ConstraintLayout.LayoutParams r191 = (ConstraintLayout.LayoutParams) r134;
            ArrayList r192 = new ArrayList();
            r192.addAll(c.c(r191));
            int r193 = r191.leftToLeft;
            if (r193 == (-1)) goto L166;
            if (r193 == 0) goto L165;
            int r194 = d.f568316a;
            d.a(r193, r133.getResources());
        L165:
            r192.add(new wl3.a("layout_constraintLeft_toLeftOf"));
        L166:
            int r195 = r191.leftToRight;
            if (r195 == (-1)) goto L172;
            if (r195 == 0) goto L171;
            int r196 = d.f568316a;
            d.a(r195, r133.getResources());
        L171:
            r192.add(new wl3.a("layout_constraintLeft_toRightOf"));
        L172:
            int r197 = r191.topToTop;
            if (r197 == (-1)) goto L178;
            if (r197 == 0) goto L177;
            int r198 = d.f568316a;
            d.a(r197, r133.getResources());
        L177:
            r192.add(new wl3.a("layout_constraintTop_toTopOf"));
        L178:
            int r199 = r191.topToBottom;
            if (r199 == (-1)) goto L184;
            if (r199 == 0) goto L183;
            int r1100 = d.f568316a;
            d.a(r199, r133.getResources());
        L183:
            r192.add(new wl3.a("layout_constraintTop_toBottomOf"));
        L184:
            int r200 = r191.rightToLeft;
            if (r200 == (-1)) goto L190;
            if (r200 == 0) goto L189;
            int r1101 = d.f568316a;
            d.a(r200, r133.getResources());
        L189:
            r192.add(new wl3.a("layout_constraintRight_toLeftOf"));
        L190:
            int r201 = r191.rightToRight;
            if (r201 == (-1)) goto L196;
            if (r201 == 0) goto L195;
            int r1102 = d.f568316a;
            d.a(r201, r133.getResources());
        L195:
            r192.add(new wl3.a("layout_constraintRight_toRightOf"));
        L196:
            int r202 = r191.bottomToTop;
            if (r202 == (-1)) goto L202;
            if (r202 == 0) goto L201;
            int r1103 = d.f568316a;
            d.a(r202, r133.getResources());
        L201:
            r192.add(new wl3.a("layout_constraintBottom_toTopOf"));
        L202:
            int r203 = r191.bottomToBottom;
            if (r203 == (-1)) goto L208;
            if (r203 == 0) goto L207;
            int r204 = d.f568316a;
            d.a(r203, r133.getResources());
        L207:
            r192.add(new wl3.a("layout_constraintBottom_toBottomOf"));
        L208:
            r140 = r192;
            goto L213
        L210:
            if ((r134 instanceof ViewGroup.MarginLayoutParams) == false) goto L212;
            r140 = c.c((ViewGroup.MarginLayoutParams) r134);
            goto L213
        L212:
            r140 = c.d(r134);
            goto L213
        L359:
            r130 = r129.getResources().getResourceEntryName(r117.getId());     // Catch: Exception -> L116
        L116:
            r130 = "0x" + Integer.toHexString(r117.getId());
            goto L118
        L85:
            if (r127.equals("ConstraintLayout") == false) goto L111;
            r128 = "C";
            goto L112
        L88:
            if (r127.equals("FrameLayout") == false) goto L111;
            r128 = FaceService.girlLabel;
            goto L112
        L91:
            if (r127.equals("LinearLayout") == false) goto L111;
            r128 = "L";
            goto L112
        L94:
            if (r127.equals("ImageView") == false) goto L111;
            r128 = "I";
            goto L112
        L97:
            if (r127.equals("View") == false) goto L111;
            r128 = "V";
            goto L112
        L100:
            if (r127.equals("AppCompatTextView") == false) goto L111;
            r128 = "ACT";
            goto L112
        L103:
            if (r127.equals("RelativeLayout") == false) goto L111;
            r128 = "R";
            goto L112
        L106:
            if (r127.equals("TextView") == false) goto L111;
            r128 = ExifInterface.GPS_DIRECTION_TRUE;
            goto L112
        L109:
            if (r127.equals("AppCompatImageView") == false) goto L111;
            r128 = "ACI";
            goto L112
        L43:
            if ((r124 instanceof wl3.c) == false) goto L46;
            r125 = r119;
            r125.r((wl3.c) r124);
        L45:
            r100 = r100;
            r210 = r101;
            r126 = r125;
            r211 = r115;
            goto L81
        L46:
            r125 = r119;
            if ((r124 instanceof wl3.b) == false) goto L49;
            r125.r(((wl3.b) r124).a());
            goto L45
        L49:
            wl3.c r205 = new wl3.c();
            Field[] r206 = r124.getClass().getDeclaredFields();
            int r207 = r206.length;
            int r208 = 0;
        L50:
            if (r208 >= r207) goto L68;
            int r212 = r101;
            Field r209 = r206[r208];
            int r213 = r207;
            Class<?> r214 = r209.getType();
            Field[] r215 = r206;
            if (ArraysKt.contains(a.f568307a, r214) == false) goto L54;
        L57:
            Annotation[] r216 = r209.getAnnotations();
            int r217 = r216.length;
            int r1104 = 0;
        L58:
            if (r1104 >= r217) goto L66;
            int r218 = r217;
            Annotation r219 = r216[r1104];
            Annotation[] r220 = r216;
            if ((r219 instanceof SerializedName) == false) goto L65;
            r209.setAccessible(true);
            String r221 = ((SerializedName) r219).value();
            Object r222 = r209.get(r124);
            if (r222 == null) goto L65;
            r205.a(new wl3.d(r221, r222.toString()));
        L65:
            r1104 = r1104 + 1;
            r217 = r218;
            r216 = r220;
            r124 = r124;
            goto L58
        L66:
            Object r223 = r124;
        L67:
            r208 = r208 + 1;
            r101 = r212;
            r207 = r213;
            r206 = r215;
            r115 = r115;
            r124 = r223;
            goto L50
        L54:
            if (r214.isPrimitive() == true) goto L57;
            r223 = r124;
            goto L67
        L68:
            r210 = r101;
            r211 = r115;
            r125.r(r205);
            goto L69
        L72:
            throw new TypeCastException("null cannot be cast to non-null type android.view.View");
        L74:
            throw new TypeCastException("null cannot be cast to non-null type android.view.View");
        L75:
            r100 = r100;
            r210 = r101;
            r211 = r115;
            r126 = r119;
            goto L81
        L77:
            throw new TypeCastException("null cannot be cast to non-null type android.view.View");
        L79:
            throw new TypeCastException("null cannot be cast to non-null type android.view.View");
        L80:
            r100 = r100;
            r210 = r101;
            r211 = r115;
            r126 = r119;
            r126.getClass();
            goto L81
        L25:
            r118 = new zl3.a();
            r113.put(r117, r118);
            goto L26
        L350:
            View[] r1105 = r100;
            int r224 = r101;
            Object r225 = r113.get(r104);
            if (r225 != null) goto L353;
            Intrinsics.throwNpe();
        L353:
            r112.add((zl3.a) r225);
        L354:
            r103 = r103 + 1;
            r100 = r1105;
            r101 = r224;
            r102 = 0;
            goto L3
        L10:
            r106 = null;
        L13:
            r1105 = r100;
            r224 = r101;
            goto L354
        L355:
            this.f568312d.element = GsonProtectorUtils.toJson(new Gson(), this.f568311c);
            this.f568313e.countDown();
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
    }

    public a() {
    }

    static {
        f568308b = new a();
        f568307a = new Class[]{String.class, Integer.class, Short.class, Long.class, Double.class, Float.class, Boolean.class};
    }

    public static final /* synthetic */ Activity a(Context r100) {
        return f568308b.getActivity(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] b(String r110) {
        CountDownLatch r100 = new CountDownLatch(1);
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L49;
        Class<?> r103 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L30;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L8
    L30:
        Object r104 = r103.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        Object r105 = r103.getMethod("getViewRootNames", new Class[0]).invoke(r104, new Object[0]);
        Method r106 = r103.getMethod("getRootView", new Class[]{String.class});
        if ((r105 instanceof Object[]) == false) goto L33;
        Object[] r107 = (Object[]) r105;
        int r108 = r107.length;
        View[] r109 = new View[r108];
        int r111 = 0;
    L35:
        if (r111 >= r108) goto L41;
        Object r112 = r106.invoke(r104, new Object[]{r107[r111]});
        if (r112 == null) goto L40;
        r109[r111] = (View) r112;
        r111 = r111 + 1;
        goto L35
    L40:
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
    L41:
        zl3.a r113 = new zl3.a();
        r113.d("Phone");
        Ref.ObjectRef r114 = new Ref.ObjectRef();
        r114.element = null;
        ((View) ArraysKt.first(r109)).post(new RunnableC8353a(r109, r110, r113, r114, r100));
        r100.await(10, TimeUnit.SECONDS);
        String r115 = (String) r114.element;
        if (r115 != null) goto L44;
        Intrinsics.throwNpe();
    L44:
        ByteArrayOutputStream r116 = new ByteArrayOutputStream(r115.length());
        GZIPOutputStream r117 = new GZIPOutputStream(r116);
        r117.write(r115.getBytes(Charsets.UTF_8));
        r117.close();
        byte[] r118 = r116.toByteArray();
        r116.close();
        return r118;
    L33:
        return new byte[0];
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L12:
        throw th;
    L49:
        r103 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L30;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        r103 = MiraPluginFix.forName("android.view.WindowManagerGlobal");
        goto L30
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }

    private final Activity getActivity(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof ContextWrapper) == true) goto L8;
        return null;
    L8:
        if ((r100 instanceof Activity) == false) goto L11;
        return (Activity) r100;
    L11:
        return getActivity(((ContextWrapper) r100).getBaseContext());
    }
}
