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
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.ByteArrayOutputStream;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final Class<? extends Object>[] a = null;
    public static final a b = null;

    /* JADX INFO: renamed from: yl3.a$a, reason: collision with other inner class name */
    public static final class RunnableC0191a implements Runnable {
        public final /* synthetic */ View[] a;
        public final /* synthetic */ String b;
        public final /* synthetic */ zl3.a c;
        public final /* synthetic */ Ref.ObjectRef d;
        public final /* synthetic */ CountDownLatch e;

        public RunnableC0191a(View[] r1, String r2, zl3.a r3, Ref.ObjectRef r4, CountDownLatch r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            View[] r2 = this.a;
            int r3 = r2.length;
            int r4 = 0;
            int r5 = 0;
        L3:
            if (r5 >= r3) goto L355;
            View r6 = r2[r5];
            if ((r6 instanceof ViewGroup) == false) goto L13;
            Activity r0 = a.a(((ViewGroup) r6).getChildAt(r4).getContext());
            if (r0 == null) goto L10;
            String r1 = r0.getClass().getName();
        L11:
            boolean r8 = true;
            if ((!Intrinsics.areEqual(r1, this.b)) == true) goto L13;
            int[] r7 = new int[2];
            r6.getLocationOnScreen(r7);
            int r11 = r7[r4];
            ViewGroup r13 = (ViewGroup) r6;
            new Rect(r11, r7[1], r13.getWidth() + r11, r7[1] + r13.getHeight());
            List<zl3.a> r10 = this.c.a();
            HashMap r12 = new HashMap();
            LinkedList r14 = new LinkedList();
            r14.push(r6);
        L16:
            if ((r14.isEmpty() ^ r8) == false) goto L350;
            int r15 = r14.size();
            int r16 = 0;
        L18:
            if (r16 >= r15) goto L16;
            View r17 = (View) r14.pop();
            if (r12.containsKey(r17) == false) goto L25;
            Object r9 = r12.get(r17);
            if (r9 != null) goto L24;
            Intrinsics.throwNpe();
        L24:
            zl3.a r18 = (zl3.a) r9;
        L26:
            zl3.a r19 = r18;
            if ((r17.getParent() instanceof View) == false) goto L80;
            Object r20 = r17.getParent();
            if (r20 == null) goto L79;
            if (r12.containsKey((View) r20) == false) goto L80;
            Object r21 = r17.getParent();
            if (r21 == null) goto L77;
            if (((zl3.a) r12.get((View) r21)) == null) goto L75;
            Object r22 = r17.getParent();
            if (r22 == null) goto L74;
            ((View) r22).getScrollX();
            r17.getLeft();
            r17.getTranslationX();
            r19.getClass();
            Object r23 = r17.getParent();
            if (r23 == null) goto L72;
            ((View) r23).getScrollY();
            r17.getTop();
            r17.getTranslationY();
            Object r24 = r17.getTag(e.a);
            if (r24 != null) goto L43;
            int r25 = r3;
            int r26 = r15;
            zl3.a r27 = r19;
        L69:
            zl3.a r28 = r27;
        L81:
            String r29 = r17.getClass().getSimpleName();
            switch(r29.hashCode()) {
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
            String r30 = r17.getClass().getSimpleName();
        L112:
            r28.d(r30);
            r28.A(r17.getWidth());
            r28.h(r17.getHeight());
            Context r31 = r17.getContext();
            if (r17.getId() != (-1)) goto L359;
            String r32 = "";
        L118:
            r28.i(r32);
            r28.g(System.identityHashCode(r17));
            r28.z(r17.getVisibility());
            r28.w(r17.getTranslationX());
            r28.x(r17.getTranslationY());
            r28.t(r17.getScrollX());
            r28.u(r17.getScrollY());
            ArrayList r33 = new ArrayList();
            Map<Integer, String> r34 = c.a;
            Context r35 = r17.getContext();
            ConstraintLayout.LayoutParams r36 = r17.getLayoutParams();
            if ((r36 instanceof FrameLayout.LayoutParams) == false) goto L132;
            FrameLayout.LayoutParams r37 = (FrameLayout.LayoutParams) r36;
            ArrayList r38 = new ArrayList();
            r38.addAll(c.c(r37));
            Integer r39 = Integer.valueOf(r37.gravity);
            int r40 = r39.intValue();
            if (r40 == (-1)) goto L124;
            if (r40 == 0) goto L124;
            boolean r41 = true;
        L125:
            if (r41 == true) goto L128;
            r39 = null;
        L128:
            if (r39 == null) goto L130;
            b.a(r39.intValue());
            r38.add(new f("layout_gravity"));
        L130:
            Iterable r42 = r38;
        L213:
            int r43 = d.a;
            if ((r17 instanceof EditText) == true) goto L242;
            if ((r17 instanceof Switch) == true) goto L242;
            if ((r17 instanceof ToggleButton) == true) goto L242;
            if ((r17 instanceof RadioButton) == true) goto L242;
            if ((r17 instanceof CheckBox) == true) goto L242;
            if ((r17 instanceof Button) == true) goto L242;
            if ((r17 instanceof TextView) == false) goto L235;
            TextView r44 = (TextView) r17;
            ArrayList r45 = new ArrayList();
            r45.addAll(d.b(r44));
            StringsKt.replace$default(r44.getText().toString(), "\"", "&quot;", false, 4, null);
            r45.add(new f("text"));
            String.format("#%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r44.getCurrentTextColor())}, 1));
            r45.add(new f("textColor"));
            r44.getTextSize();
            r45.add(new f("textSize"));
            Iterable r46 = r45;
        L253:
            Iterator r47 = r46.iterator();
        L255:
            if (r47.hasNext() == false) goto L259;
            f r48 = (f) r47.next();
            if (r33.contains(r48) == true) goto L255;
            r33.add(r48);
            goto L255
        L259:
            Iterator r49 = r42.iterator();
        L261:
            if (r49.hasNext() == false) goto L265;
            f r50 = (f) r49.next();
            if (r33.contains(r50) == true) goto L261;
            r33.add(r50);
            goto L261
        L265:
            int r51 = e.b;
            if (r17.getTag(r51) == null) goto L277;
            Object r52 = r17.getTag(r51);
            if (r52 == null) goto L276;
            Iterator r53 = ((Collection) r52).iterator();
        L271:
            if (r53.hasNext() == false) goto L277;
            f r54 = (f) r53.next();
            if (r33.contains(r54) == true) goto L271;
            r33.add(r54);
            goto L271
        L276:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Collection<com.bytedance.android.tetrisinspectorbase.XmlAttribute>");
        L277:
            r28.B(r33);
            View r55 = r17;
        L278:
            if (r55 == null) goto L293;
            RecyclerView r56 = r55.getParent();
            if ((r56 instanceof RecyclerView) == true) goto L282;
            if ((r56 instanceof View) == true) goto L290;
            r55 = null;
            goto L278
        L290:
            r55 = (View) r56;
            goto L278
        L282:
            RecyclerView.Adapter r57 = r56.getAdapter();     // Catch: Throwable -> L292
            if (r57 == null) goto L285;
            String r58 = r57.getClass().getSimpleName();     // Catch: Throwable -> L292
        L286:
            Pair r59 = new Pair(r56.getChildViewHolder(r55).getClass().getSimpleName(), r58);     // Catch: Throwable -> L292
        L294:
            if (r59 == null) goto L297;
            r28.y((String) r59.getFirst());
            r28.b((String) r59.getSecond());
        L297:
            if ((r17 instanceof ImageView) == false) goto L299;
            r28.s(((ImageView) r17).getScaleType().name());
        L299:
            CharSequence r60 = r17.getContentDescription();
            if (r60 == null) goto L302;
            String r61 = r60.toString();
        L303:
            r28.e(r61);
            Field r62 = View.class.getDeclaredField("mBackgroundResource");     // Catch: Exception -> L311
            r62.setAccessible(true);     // Catch: Exception -> L311
            Integer r63 = (Integer) r62.get(r17);     // Catch: Exception -> L311
            if (r63 == null) goto L307;
            int r110 = r63.intValue();     // Catch: Exception -> L311
        L308:
            if (r110 == 0) goto L313;
            String r64 = r17.getContext().getResources().getResourceEntryName(r110);     // Catch: Exception -> L311
        L314:
            r28.c(r64);
            if (Build.VERSION.SDK_INT < 26) goto L325;
            int r65 = r17.getFocusable();
            if (r65 != 0) goto L319;
            String r66 = "false";
        L323:
            r28.f(r66);
            goto L325
        L319:
            if (r65 == 1) goto L321;
            r66 = "auto";
            goto L323
        L321:
            r66 = "true";
        L325:
            if ((r17 instanceof TextView) == false) goto L337;
            TextView r67 = (TextView) r17;
            CharSequence r68 = r67.getText();
            if (r68 == null) goto L337;
            String r69 = r68.toString();
            if (r69 == null) goto L337;
            if (r69.length() <= 0) goto L333;
            boolean r70 = true;
            boolean r71 = true;
        L334:
            if (r71 != r70) goto L337;
            r28.v(r67.getText().toString());
            goto L337
        L333:
            r70 = true;
            r71 = false;
        L337:
            ViewGroup.LayoutParams r72 = r17.getLayoutParams();
            if ((r72 instanceof ViewGroup.MarginLayoutParams) == true) goto L341;
            r72 = null;
        L341:
            if (r72 == null) goto L343;
            ViewGroup.MarginLayoutParams r73 = (ViewGroup.MarginLayoutParams) r72;
            r28.k(r73.leftMargin);
            r28.m(r73.topMargin);
            r28.l(r73.rightMargin);
            r28.j(r73.bottomMargin);
        L343:
            r28.o(r17.getPaddingLeft());
            r28.q(r17.getPaddingTop());
            r28.p(r17.getPaddingRight());
            r28.n(r17.getPaddingBottom());
            if ((r17 instanceof ViewGroup) == false) goto L348;
            ViewGroup r111 = (ViewGroup) r17;
            int r74 = r111.getChildCount();
            int r112 = 0;
        L346:
            if (r112 >= r74) goto L348;
            View r75 = r111.getChildAt(r112);
            zl3.a r76 = new zl3.a();
            r12.put(r75, r76);
            r28.a().add(r76);
            r14.push(r75);
            r112 = r112 + 1;
        L348:
            r16 = r16 + 1;
            r2 = r2;
            r3 = r25;
            r15 = r26;
            r8 = true;
        L313:
            r64 = null;
            goto L314
        L307:
            r110 = 0;
        L311:
            e = move-exception;
            e.toString();
            goto L313
        L302:
            r61 = null;
            goto L303
        L285:
            r58 = null;
        L293:
            r59 = null;
            goto L294
        L235:
            if ((r17 instanceof SeekBar) == true) goto L242;
            if ((r17 instanceof RatingBar) == true) goto L242;
            if ((r17 instanceof ProgressBar) == true) goto L242;
            if ((r17 instanceof ImageView) == false) goto L247;
            ImageView r77 = (ImageView) r17;
            ArrayList r78 = new ArrayList();
            r78.addAll(d.b(r77));
            r77.getScaleType().name();
            r78.add(new f("scaleType"));
            r46 = r78;
            goto L253
        L247:
            if ((r17 instanceof LinearLayout) == false) goto L250;
            LinearLayout r79 = (LinearLayout) r17;
            ArrayList r80 = new ArrayList();
            r80.addAll(d.c(r79));
            r79.getOrientation();
            r80.add(new f("orientation"));
            r46 = r80;
            goto L253
        L250:
            if ((r17 instanceof ViewGroup) == false) goto L252;
            r46 = d.c((ViewGroup) r17);
            goto L253
        L252:
            r46 = d.b(r17);
        L242:
            r46 = d.b(r17);
        L124:
            r41 = false;
            goto L125
        L132:
            if ((r36 instanceof LinearLayout.LayoutParams) == false) goto L153;
            LinearLayout.LayoutParams r81 = (LinearLayout.LayoutParams) r36;
            r38 = new ArrayList();
            r38.addAll(c.c(r81));
            Float r82 = Float.valueOf(r81.weight);
            if (r82.floatValue() == 0.0f) goto L136;
            boolean r113 = true;
        L137:
            if (r113 == true) goto L140;
            r82 = null;
        L140:
            if (r82 == null) goto L142;
            String.valueOf(r82.floatValue());
            r38.add(new f("layout_weight"));
        L142:
            Integer r83 = Integer.valueOf(r81.gravity);
            int r84 = r83.intValue();
            if (r84 == (-1)) goto L146;
            if (r84 == 0) goto L146;
            boolean r85 = true;
        L147:
            if (r85 == true) goto L150;
            r83 = null;
        L150:
            if (r83 == null) goto L130;
            b.a(r83.intValue());
            r38.add(new f("layout_gravity"));
        L146:
            r85 = false;
            goto L147
        L136:
            r113 = false;
            goto L137
        L153:
            if ((r36 instanceof RelativeLayout.LayoutParams) == false) goto L159;
            RelativeLayout.LayoutParams r86 = (RelativeLayout.LayoutParams) r36;
            ArrayList r87 = new ArrayList();
            r87.addAll(c.c(r86));
            int[] r88 = r86.getRules();
            c.b(r35, r88, 2, r87);
            c.b(r35, r88, 4, r87);
            c.b(r35, r88, 8, r87);
            c.b(r35, r88, 5, r87);
            c.b(r35, r88, 7, r87);
            c.b(r35, r88, 6, r87);
            c.b(r35, r88, 3, r87);
            c.b(r35, r88, 0, r87);
            c.b(r35, r88, 1, r87);
            c.b(r35, r88, 18, r87);
            c.b(r35, r88, 19, r87);
            c.b(r35, r88, 16, r87);
            c.b(r35, r88, 17, r87);
            c.a(r88, 12, r87);
            c.a(r88, 9, r87);
            c.a(r88, 11, r87);
            c.a(r88, 10, r87);
            c.a(r88, 20, r87);
            c.a(r88, 21, r87);
            c.a(r88, 14, r87);
            c.a(r88, 13, r87);
            c.a(r88, 15, r87);
            if (r86.alignWithParent == false) goto L157;
            r87.add(new f("layout_alignWithParentIfMissing"));
        L157:
            r42 = r87;
            goto L213
        L159:
            if ((r36 instanceof ConstraintLayout.LayoutParams) == false) goto L210;
            ConstraintLayout.LayoutParams r89 = r36;
            ArrayList r90 = new ArrayList();
            r90.addAll(c.c(r89));
            int r114 = r89.leftToLeft;
            if (r114 == (-1)) goto L166;
            if (r114 == 0) goto L165;
            int r115 = d.a;
            d.a(r114, r35.getResources());
        L165:
            r90.add(new wl3.a("layout_constraintLeft_toLeftOf"));
        L166:
            int r91 = r89.leftToRight;
            if (r91 == (-1)) goto L172;
            if (r91 == 0) goto L171;
            int r116 = d.a;
            d.a(r91, r35.getResources());
        L171:
            r90.add(new wl3.a("layout_constraintLeft_toRightOf"));
        L172:
            int r92 = r89.topToTop;
            if (r92 == (-1)) goto L178;
            if (r92 == 0) goto L177;
            int r117 = d.a;
            d.a(r92, r35.getResources());
        L177:
            r90.add(new wl3.a("layout_constraintTop_toTopOf"));
        L178:
            int r93 = r89.topToBottom;
            if (r93 == (-1)) goto L184;
            if (r93 == 0) goto L183;
            int r118 = d.a;
            d.a(r93, r35.getResources());
        L183:
            r90.add(new wl3.a("layout_constraintTop_toBottomOf"));
        L184:
            int r94 = r89.rightToLeft;
            if (r94 == (-1)) goto L190;
            if (r94 == 0) goto L189;
            int r119 = d.a;
            d.a(r94, r35.getResources());
        L189:
            r90.add(new wl3.a("layout_constraintRight_toLeftOf"));
        L190:
            int r95 = r89.rightToRight;
            if (r95 == (-1)) goto L196;
            if (r95 == 0) goto L195;
            int r120 = d.a;
            d.a(r95, r35.getResources());
        L195:
            r90.add(new wl3.a("layout_constraintRight_toRightOf"));
        L196:
            int r96 = r89.bottomToTop;
            if (r96 == (-1)) goto L202;
            if (r96 == 0) goto L201;
            int r121 = d.a;
            d.a(r96, r35.getResources());
        L201:
            r90.add(new wl3.a("layout_constraintBottom_toTopOf"));
        L202:
            int r97 = r89.bottomToBottom;
            if (r97 == (-1)) goto L208;
            if (r97 == 0) goto L207;
            int r98 = d.a;
            d.a(r97, r35.getResources());
        L207:
            r90.add(new wl3.a("layout_constraintBottom_toBottomOf"));
        L208:
            r42 = r90;
            goto L213
        L210:
            if ((r36 instanceof ViewGroup.MarginLayoutParams) == false) goto L212;
            r42 = c.c((ViewGroup.MarginLayoutParams) r36);
            goto L213
        L212:
            r42 = c.d(r36);
            goto L213
        L359:
            r32 = r31.getResources().getResourceEntryName(r17.getId());     // Catch: Exception -> L116
        L116:
            r32 = "0x" + Integer.toHexString(r17.getId());
            goto L118
        L85:
            if (r29.equals("ConstraintLayout") == false) goto L111;
            r30 = "C";
            goto L112
        L88:
            if (r29.equals("FrameLayout") == false) goto L111;
            r30 = "F";
            goto L112
        L91:
            if (r29.equals("LinearLayout") == false) goto L111;
            r30 = "L";
            goto L112
        L94:
            if (r29.equals("ImageView") == false) goto L111;
            r30 = "I";
            goto L112
        L97:
            if (r29.equals("View") == false) goto L111;
            r30 = "V";
            goto L112
        L100:
            if (r29.equals("AppCompatTextView") == false) goto L111;
            r30 = "ACT";
            goto L112
        L103:
            if (r29.equals("RelativeLayout") == false) goto L111;
            r30 = "R";
            goto L112
        L106:
            if (r29.equals("TextView") == false) goto L111;
            r30 = "T";
            goto L112
        L109:
            if (r29.equals("AppCompatImageView") == false) goto L111;
            r30 = "ACI";
            goto L112
        L43:
            if ((r24 instanceof wl3.c) == false) goto L46;
            r27 = r19;
            r27.r((wl3.c) r24);
        L45:
            r2 = r2;
            r25 = r3;
            r28 = r27;
            r26 = r15;
            goto L81
        L46:
            r27 = r19;
            if ((r24 instanceof wl3.b) == false) goto L49;
            r27.r(((wl3.b) r24).a());
            goto L45
        L49:
            wl3.c r99 = new wl3.c();
            Field[] r100 = r24.getClass().getDeclaredFields();
            int r101 = r100.length;
            int r102 = 0;
        L50:
            if (r102 >= r101) goto L68;
            int r210 = r3;
            Field r103 = r100[r102];
            int r211 = r101;
            Class<?> r104 = r103.getType();
            Field[] r212 = r100;
            if (ArraysKt.contains(a.a, r104) == false) goto L54;
        L57:
            SerializedName[] r105 = r103.getAnnotations();
            int r106 = r105.length;
            int r122 = 0;
        L58:
            if (r122 >= r106) goto L66;
            int r213 = r106;
            SerializedName r107 = r105[r122];
            SerializedName[] r214 = r105;
            if ((r107 instanceof SerializedName) == false) goto L65;
            r103.setAccessible(true);
            String r108 = r107.value();
            Object r109 = r103.get(r24);
            if (r109 == null) goto L65;
            r99.a(new wl3.d(r108, r109.toString()));
        L65:
            r122 = r122 + 1;
            r106 = r213;
            r105 = r214;
            r24 = r24;
            goto L58
        L66:
            Object r215 = r24;
        L67:
            r102 = r102 + 1;
            r3 = r210;
            r101 = r211;
            r100 = r212;
            r15 = r15;
            r24 = r215;
            goto L50
        L54:
            if (r104.isPrimitive() == true) goto L57;
            r215 = r24;
            goto L67
        L68:
            r25 = r3;
            r26 = r15;
            r27.r(r99);
            goto L69
        L72:
            throw new TypeCastException("null cannot be cast to non-null type android.view.View");
        L74:
            throw new TypeCastException("null cannot be cast to non-null type android.view.View");
        L75:
            r2 = r2;
            r25 = r3;
            r26 = r15;
            r28 = r19;
            goto L81
        L77:
            throw new TypeCastException("null cannot be cast to non-null type android.view.View");
        L79:
            throw new TypeCastException("null cannot be cast to non-null type android.view.View");
        L80:
            r2 = r2;
            r25 = r3;
            r26 = r15;
            r28 = r19;
            r28.getClass();
            goto L81
        L25:
            r18 = new zl3.a();
            r12.put(r17, r18);
            goto L26
        L350:
            View[] r123 = r2;
            int r216 = r3;
            Object r124 = r12.get(r6);
            if (r124 != null) goto L353;
            Intrinsics.throwNpe();
        L353:
            r10.add((zl3.a) r124);
        L354:
            r5 = r5 + 1;
            r2 = r123;
            r3 = r216;
            r4 = 0;
            goto L3
        L10:
            r1 = null;
        L13:
            r123 = r2;
            r216 = r3;
            goto L354
        L355:
            this.d.element = GsonProtectorUtils.toJson(new Gson(), this.c);
            this.e.countDown();
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
        b = new a();
        a = new Class[]{String.class, Integer.class, Short.class, Long.class, Double.class, Float.class, Boolean.class};
    }

    public static final /* synthetic */ Activity a(Context r1) {
        return b.getActivity(r1);
    }

    public static byte[] b(String r12) {
        CountDownLatch r6 = new CountDownLatch(1);
        ConcurrentHashMap r1 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r2 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L49;
        Class<?> r3 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L8
        if (r2 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L30;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L8
    L30:
        Object r4 = r3.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        Object r5 = r3.getMethod("getViewRootNames", new Class[0]).invoke(r4, new Object[0]);
        Method r7 = r3.getMethod("getRootView", new Class[]{String.class});
        if ((r5 instanceof Object[]) == false) goto L33;
        Object[] r8 = (Object[]) r5;
        int r9 = r8.length;
        View[] r10 = new View[r9];
        int r11 = 0;
    L35:
        if (r11 >= r9) goto L41;
        Object r13 = r7.invoke(r4, new Object[]{r8[r11]});
        if (r13 == null) goto L40;
        r10[r11] = (View) r13;
        r11 = r11 + 1;
        goto L35
    L40:
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
    L41:
        zl3.a r14 = new zl3.a();
        r14.d("Phone");
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        r15.element = null;
        ((View) ArraysKt.first(r10)).post(new RunnableC0191a(r10, r12, r14, r15, r6));
        r6.await(10, TimeUnit.SECONDS);
        String r16 = (String) r15.element;
        if (r16 != null) goto L44;
        Intrinsics.throwNpe();
    L44:
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(r16.length());
        GZIPOutputStream r17 = new GZIPOutputStream(r0);
        r17.write(r16.getBytes(Charsets.UTF_8));
        r17.close();
        byte[] r18 = r0.toByteArray();
        r0.close();
        return r18;
    L33:
        return new byte[0];
    L8:
        th = move-exception;
        if (r2 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L12:
        throw th;
    L49:
        r3 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L17
        if (r2 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L30;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        if (r2 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        r3 = MiraPluginFix.forName("android.view.WindowManagerGlobal");
        goto L30
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }

    private final Activity getActivity(Context r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if ((r3 instanceof ContextWrapper) == true) goto L8;
        return null;
    L8:
        if ((r3 instanceof Activity) == false) goto L11;
        return (Activity) r3;
    L11:
        return getActivity(((ContextWrapper) r3).getBaseContext());
    }
}
