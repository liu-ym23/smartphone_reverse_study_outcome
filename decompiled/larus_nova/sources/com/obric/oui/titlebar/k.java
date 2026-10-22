package com.obric.oui.titlebar;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.SurfaceControl;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.obric.oui.button.OButtonGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class k {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f403620g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f403621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f403622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f403623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f403624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f403625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SurfaceControl f403626f;

    public static final class a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ int f403627i = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f403628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f403629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f403630c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f403631d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f403632e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final View.OnClickListener f403633f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f403634g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f403635h;

        /* JADX INFO: renamed from: com.obric.oui.titlebar.k$a$a, reason: collision with other inner class name */
        public static final class C4681a {
            @JvmStatic
            public static a a(int r100, View.OnClickListener r101) {
                return new a(1, r100, null, r101);
            }
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f403628a == r101.f403628a) goto L12;
            return false;
        L12:
            if (this.f403629b == r101.f403629b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f403630c, r101.f403630c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f403631d, r101.f403631d) == true) goto L21;
            return false;
        L21:
            if (this.f403632e == r101.f403632e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f403633f, r101.f403633f) == true) goto L27;
            return false;
        L27:
            if (this.f403634g == r101.f403634g) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f403635h, r101.f403635h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r1v12, types: [int] */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v18 */
        public final int hashCode() {
            int r100 = ((this.f403628a * 31) + this.f403629b) * 31;
            String r101 = this.f403630c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f403631d;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (((r104 + r106) * 31) + this.f403632e) * 31;
            View.OnClickListener r108 = this.f403633f;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            boolean r111 = this.f403634g;
            ?? r112 = r111;
            if (r111 == false) goto L17;
            r112 = 1;
        L17:
            int r113 = (r110 + r112) * 31;
            String r114 = this.f403635h;
            if (r114 == null) goto L22;
            r102 = r114.hashCode();
        L22:
            return r113 + r102;
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "ActionItem(type=" + this.f403628a + ", iconRes=" + this.f403629b + ", text=" + this.f403630c + ", id=" + this.f403631d + ", tintColor=" + this.f403632e + ", onClickListener=" + this.f403633f + ", enabled=" + this.f403634g + ", iconResourceName=" + this.f403635h + ')';
        }

        public final int getType() {
            return this.f403628a;
        }

        public final a b(boolean r100) {
            return a(this, 0, null, 0, null, r100, null, 191);
        }

        public /* synthetic */ a(int r110, int r111, String r112, View.OnClickListener r113) {
            this(r110, r111, r112, null, 0, r113, true, null);
        }

        public a(int r100, int r101, String r102, String r103, int r104, View.OnClickListener r105, boolean r106, String r107) {
            this.f403628a = r100;
            this.f403629b = r101;
            this.f403630c = r102;
            this.f403631d = r103;
            this.f403632e = r104;
            this.f403633f = r105;
            this.f403634g = r106;
            this.f403635h = r107;
        }

        public static a a(a r110, int r111, String r112, int r113, View.OnClickListener r114, boolean r115, String r116, int r117) {
            if ((r117 & 1) == 0) goto L5;
            int r100 = r110.f403628a;
        L7:
            if ((r117 & 2) == 0) goto L9;
            int r101 = r110.f403629b;
        L11:
            if ((r117 & 4) == 0) goto L13;
            String r102 = r110.f403630c;
        L14:
            String r103 = r102;
            if ((r117 & 8) == 0) goto L17;
            String r104 = r110.f403631d;
        L19:
            if ((r117 & 16) == 0) goto L21;
            int r105 = r110.f403632e;
        L23:
            if ((r117 & 32) == 0) goto L25;
            View.OnClickListener r106 = r110.f403633f;
        L27:
            if ((r117 & 64) == 0) goto L29;
            boolean r118 = r110.f403634g;
        L31:
            if ((r117 & 128) == 0) goto L33;
            String r119 = r110.f403635h;
        L34:
            r110.getClass();
            return new a(r100, r101, r103, r104, r105, r106, r118, r119);
        L33:
            r119 = r116;
            goto L34
        L29:
            r118 = r115;
            goto L31
        L25:
            r106 = r114;
            goto L27
        L21:
            r105 = r113;
            goto L23
        L17:
            r104 = r112;
            goto L19
        L13:
            r102 = null;
            goto L14
        L9:
            r101 = r111;
            goto L11
        L5:
            r100 = 0;
            goto L7
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f403636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f403637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f403638c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f403639d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f403640e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f403641f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f403636a == r101.f403636a) goto L12;
            return false;
        L12:
            if (this.f403637b == r101.f403637b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f403638c, r101.f403638c) == true) goto L18;
            return false;
        L18:
            if (this.f403639d == r101.f403639d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f403640e, r101.f403640e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f403641f, r101.f403641f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f403636a * 31) + this.f403637b) * 31;
            String r101 = this.f403638c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((r100 + r103) * 31) + this.f403639d) * 31;
            String r105 = this.f403640e;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f403641f;
            if (r108 == null) goto L15;
            r102 = r108.hashCode();
        L15:
            return r107 + r102;
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "ActionKey(type=" + this.f403636a + ", iconRes=" + this.f403637b + ", text=" + this.f403638c + ", tintColor=" + this.f403639d + ", id=" + this.f403640e + ", iconResourceName=" + this.f403641f + ')';
        }

        public final int getType() {
            return this.f403636a;
        }

        public static b a(b r100, int r101, int r110, int r111) {
            if ((r111 & 1) == 0) goto L5;
            int r102 = r100.f403636a;
        L7:
            if ((r111 & 2) == 0) goto L9;
            r101 = r100.f403637b;
        L9:
            int r103 = r101;
            if ((r111 & 4) == 0) goto L12;
            String r104 = r100.f403638c;
        L14:
            if ((r111 & 8) == 0) goto L16;
            r110 = r100.f403639d;
        L16:
            int r105 = r110;
            if ((r111 & 16) == 0) goto L19;
            String r106 = r100.f403640e;
        L21:
            if ((r111 & 32) == 0) goto L23;
            String r107 = r100.f403641f;
        L25:
            return new b(r102, r103, r104, r105, r106, r107);
        L23:
            r107 = null;
            goto L25
        L19:
            r106 = null;
            goto L21
        L12:
            r104 = null;
            goto L14
        L5:
            r102 = 0;
            goto L7
        }

        public b(int r100, int r101, String r102, int r103, String r104, String r105) {
            this.f403636a = r100;
            this.f403637b = r101;
            this.f403638c = r102;
            this.f403639d = r103;
            this.f403640e = r104;
            this.f403641f = r105;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<a> f403642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<a> f403643b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<a> f403644c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List<a> f403645d;

        public c() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f403642a, r101.f403642a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f403643b, r101.f403643b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f403644c, r101.f403644c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f403645d, r101.f403645d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f403642a.hashCode() * 31) + this.f403643b.hashCode()) * 31) + this.f403644c.hashCode()) * 31) + this.f403645d.hashCode();
        }

        public final String toString() {
            return "ActionsState(start=" + this.f403642a + ", center=" + this.f403643b + ", subEnd=" + this.f403644c + ", end=" + this.f403645d + ')';
        }

        public /* synthetic */ c(int r100) {
            this(CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList());
        }

        public c(List<a> r100, List<a> r101, List<a> r102, List<a> r103) {
            Intrinsics.checkNotNullParameter(r100, "start");
            Intrinsics.checkNotNullParameter(r101, "center");
            Intrinsics.checkNotNullParameter(r102, "subEnd");
            Intrinsics.checkNotNullParameter(r103, "end");
            this.f403642a = r100;
            this.f403643b = r101;
            this.f403644c = r102;
            this.f403645d = r103;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OButtonGroup.b f403646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OButtonGroup.b f403647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final OButtonGroup.b f403648c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final OButtonGroup.b f403649d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f403650e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Integer f403651f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f403652g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f403646a, r101.f403646a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f403647b, r101.f403647b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f403648c, r101.f403648c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f403649d, r101.f403649d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(Float.valueOf(this.f403650e), Float.valueOf(r101.f403650e)) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f403651f, r101.f403651f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(Float.valueOf(this.f403652g), Float.valueOf(r101.f403652g)) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((((this.f403646a.hashCode() * 31) + this.f403647b.hashCode()) * 31) + this.f403648c.hashCode()) * 31) + this.f403649d.hashCode()) * 31) + Float.floatToIntBits(this.f403650e)) * 31;
            Integer r101 = this.f403651f;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((r100 + r102) * 31) + Float.floatToIntBits(this.f403652g);
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "AnimationState(startState=" + this.f403646a + ", centerState=" + this.f403647b + ", subEndState=" + this.f403648c + ", endState=" + this.f403649d + ", subEndTranslationX=" + this.f403650e + ", freezeEndAreaWidth=" + this.f403651f + ", centerTranslationX=" + this.f403652g + ')';
        }

        public d(OButtonGroup.b r100, OButtonGroup.b r101, OButtonGroup.b r102, OButtonGroup.b r103, float r104, Integer r105, float r106) {
            Intrinsics.checkNotNullParameter(r100, "startState");
            Intrinsics.checkNotNullParameter(r101, "centerState");
            Intrinsics.checkNotNullParameter(r102, "subEndState");
            Intrinsics.checkNotNullParameter(r103, "endState");
            this.f403646a = r100;
            this.f403647b = r101;
            this.f403648c = r102;
            this.f403649d = r103;
            this.f403650e = r104;
            this.f403651f = r105;
            this.f403652g = r106;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f403653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f403654b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f403655c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f403656d;

        public e() {
            this(0, 0, 0, 0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (this.f403653a == r101.f403653a) goto L12;
            return false;
        L12:
            if (this.f403654b == r101.f403654b) goto L15;
            return false;
        L15:
            if (this.f403655c == r101.f403655c) goto L18;
            return false;
        L18:
            if (this.f403656d == r101.f403656d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f403653a * 31) + this.f403654b) * 31) + this.f403655c) * 31) + this.f403656d;
        }

        public final String toString() {
            return "BoundsState(width=" + this.f403653a + ", height=" + this.f403654b + ", screenX=" + this.f403655c + ", screenY=" + this.f403656d + ')';
        }

        public e(int r100, int r101, int r102, int r103) {
            this.f403653a = r100;
            this.f403654b = r101;
            this.f403655c = r102;
            this.f403656d = r103;
        }
    }

    public static final class f {
        public f() {
        }

        @JvmStatic
        public static k b(Bundle r110) {
            Intrinsics.checkNotNullParameter(r110, "bundle");
            r110.setClassLoader(k.class.getClassLoader());
            e r100 = new e(r110.getInt("width"), r110.getInt("height"), r110.getInt("screen_x"), r110.getInt("screen_y"));
            g r101 = new g(r110.getInt("start_title_width"), r110.getInt("center_title_width"), r110.getInt("center_custom_width"), r110.getInt("center_custom_height"), r110.getInt("content_top_inset"));
            c r102 = new c(c(r110, "start_actions"), c(r110, "center_actions"), c(r110, "sub_end_actions"), c(r110, "end_actions"));
            h r103 = new h(r110.getInt("start_button_style"), r110.getInt("center_button_style"), r110.getInt("sub_end_button_style"), r110.getInt("end_button_style"));
            Bundle r104 = r110.getBundle("animation_state");
            if (r104 == null) goto L16;
            OButtonGroup.b r105 = d(r104, "start");
            if (r105 == null) goto L16;
            OButtonGroup.b r111 = d(r104, "center");
            if (r111 == null) goto L16;
            OButtonGroup.b r112 = d(r104, "sub_end");
            if (r112 == null) goto L16;
            OButtonGroup.b r113 = d(r104, "end");
            if (r113 == null) goto L16;
            float r114 = r104.getFloat("sub_end_translation_x");
            if (r104.getBoolean("has_freeze_end_area_width") == false) goto L20;
            Integer r115 = Integer.valueOf(r104.getInt("freeze_end_area_width"));
        L21:
            d r116 = new d(r105, r111, r112, r113, r114, r115, r104.getFloat("center_translation_x"));
        L22:
            Parcelable r106 = r110.getParcelable("interrupted_overlay_surface");
            if ((r106 instanceof SurfaceControl) == false) goto L25;
            SurfaceControl r107 = (SurfaceControl) r106;
        L27:
            return new k(r100, r101, r102, r103, r116, r107);
        L25:
            r107 = null;
            goto L27
        L20:
            r115 = null;
        L16:
            r116 = null;
            goto L22
        }

        public static List c(Bundle r210, String r211) {
            int[] r100 = r210.getIntArray(Intrinsics.stringPlus(r211, "_types"));
            if (r100 == null) goto L5;
            int[] r101 = r210.getIntArray(Intrinsics.stringPlus(r211, "_icons"));
            if (r101 != null) goto L9;
            r101 = new int[r100.length];
        L9:
            String[] r102 = r210.getStringArray(Intrinsics.stringPlus(r211, "_texts"));
            if (r102 != null) goto L12;
            r102 = new String[r100.length];
        L12:
            String[] r103 = r210.getStringArray(Intrinsics.stringPlus(r211, "_ids"));
            if (r103 != null) goto L15;
            r103 = new String[r100.length];
        L15:
            int[] r104 = r210.getIntArray(Intrinsics.stringPlus(r211, "_tints"));
            if (r104 != null) goto L18;
            r104 = new int[r100.length];
        L18:
            boolean[] r105 = r210.getBooleanArray(Intrinsics.stringPlus(r211, "_enableds"));
            if (r105 != null) goto L24;
            int r106 = r100.length;
            boolean[] r110 = new boolean[r106];
            int r111 = 0;
        L21:
            if (r111 >= r106) goto L23;
            r110[r111] = true;
            r111 = r111 + 1;
            goto L21
        L23:
            r105 = r110;
        L24:
            String[] r107 = r210.getStringArray(Intrinsics.stringPlus(r211, "_icon_names"));
            if (r107 != null) goto L27;
            r107 = new String[r100.length];
        L27:
            ArrayList r108 = new ArrayList(r100.length);
            int r112 = r100.length;
            int r113 = 0;
            int r114 = 0;
        L28:
            if (r113 >= r112) goto L48;
            int r115 = r100[r113];
            int r212 = r114 + 1;
            if (r114 >= 0) goto L32;
        L34:
            int r116 = 0;
        L35:
            String r117 = (String) ArraysKt.getOrNull(r102, r114);
            String r118 = (String) ArraysKt.getOrNull(r103, r114);
            if (r114 >= 0) goto L38;
        L40:
            int r119 = 0;
        L42:
            if (r114 >= 0) goto L44;
        L46:
            boolean r213 = true;
        L47:
            r108.add(new a(r115, r116, r117, r118, r119, null, r213, (String) ArraysKt.getOrNull(r107, r114)));
            r113 = r113 + 1;
            r114 = r212;
            goto L28
        L44:
            if (r114 > ArraysKt.getLastIndex(r105)) goto L46;
            r213 = r105[r114];
            goto L47
        L38:
            if (r114 > ArraysKt.getLastIndex(r104)) goto L40;
            r119 = r104[r114];
            goto L42
        L32:
            if (r114 > ArraysKt.getLastIndex(r101)) goto L34;
            r116 = r101[r114];
            goto L35
        L48:
            return r108;
        L5:
            return CollectionsKt.emptyList();
        }

        public static OButtonGroup.b d(Bundle r210, String r211) {
            Bundle r100 = r210.getBundle(r211);
            if (r100 != null) goto L5;
            return null;
        L5:
            Iterable r101 = r100.getParcelableArrayList("items");
            if (r101 != null) goto L8;
            r101 = CollectionsKt.emptyList();
        L8:
            int r102 = r100.getInt(RemoteMessageConst.Notification.VISIBILITY);
            float r103 = r100.getFloat("alpha");
            float r104 = r100.getFloat("scale_x");
            float r110 = r100.getFloat("scale_y");
            float r111 = r100.getFloat("group_blur");
            int r105 = r100.getInt("group_width");
            ArrayList r112 = new ArrayList();
            Iterator r106 = r101.iterator();
        L10:
            if (r106.hasNext() == false) goto L18;
            Bundle r113 = (Bundle) r106.next();
            int r114 = k.f403620g;
            if (r113.getBoolean("has_action_key") == false) goto L14;
            OButtonGroup.d r115 = new OButtonGroup.d(new b(r113.getInt("type"), r113.getInt("icon_res"), r113.getString("text"), r113.getInt("tint_color"), r113.getString("id"), r113.getString("icon_resource_name")), r113.getInt(RemoteMessageConst.Notification.VISIBILITY), r113.getFloat("alpha"), r113.getFloat("scale_x", 1.0f), r113.getFloat("scale_y", 1.0f));
        L15:
            if (r115 == null) goto L10;
            r112.add(r115);
            goto L10
        L14:
            r115 = null;
            goto L15
        L18:
            return new OButtonGroup.b(r102, r103, r104, r110, r111, r105, r112);
        }

        public static int f(Context r100, String r101) {
            boolean r102 = true;
            if (r101 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L11;
            return 0;
        L11:
            String r104 = StringsKt.substringBefore(r101, '/', "");
            String r105 = StringsKt.substringAfter(r101, '/', "");
            if (r104.length() != 0) goto L14;
            boolean r106 = true;
        L15:
            if (r106 == false) goto L17;
        L24:
            return 0;
        L17:
            if (r105.length() == 0) goto L20;
            r102 = false;
        L20:
            if (r102 == true) goto L24;
            return r100.getResources().getIdentifier(r105, r104, r100.getPackageName());
        L14:
            r106 = false;
            goto L15
        L5:
            if (r101.length() == 0) goto L8;
            r103 = false;
            goto L9
        }

        public static OButtonGroup.b g(OButtonGroup.b r110, Context r111) {
            List<OButtonGroup.d> r100 = r110.f399084g;
            ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
            Iterator<T> r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L17;
            OButtonGroup.d r103 = (OButtonGroup.d) r102.next();
            Object r104 = r103.f399113a;
            if ((r104 instanceof b) == false) goto L8;
            b r105 = (b) r104;
        L9:
            if (r105 == null) goto L16;
            if (r105.getType() != 1) goto L16;
            int r106 = k.f403620g;
            int r107 = f(r111, r105.f403641f);
            if (r107 == 0) goto L16;
            r103 = new OButtonGroup.d(b.a(r105, r107, 0, 61), r103.f399114b, r103.f399115c, r103.f399116d, r103.f399117e);
        L16:
            r101.add(r103);
            goto L4
        L8:
            r105 = null;
            goto L9
        L17:
            int r108 = r110.f399078a;
            float r109 = r110.f399079b;
            float r112 = r110.f399080c;
            float r113 = r110.f399081d;
            float r114 = r110.f399082e;
            int r115 = r110.f399083f;
            Intrinsics.checkNotNullParameter(r101, "items");
            return new OButtonGroup.b(r108, r109, r112, r113, r114, r115, r101);
        }

        public static List h(List r110, Context r111) {
            List r112 = r110;
            ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
            Iterator r113 = r112.iterator();
        L4:
            if (r113.hasNext() == false) goto L12;
            a r101 = (a) r113.next();
            int r102 = k.f403620g;
            if (r101.getType() != 1) goto L11;
            int r103 = f(r111, r101.f403635h);
            if (r103 == 0) goto L11;
            r101 = a.a(r101, r103, null, 0, null, false, null, 253);
        L11:
            r100.add(r101);
            goto L4
        L12:
            return r100;
        }

        public static final void a(Bundle r100, String r101, List r102) {
            int r103 = k.f403620g;
            String r104 = Intrinsics.stringPlus(r101, "_types");
            List r105 = r102;
            ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
            Iterator r107 = r105.iterator();
        L4:
            if (r107.hasNext() == false) goto L6;
            r106.add(Integer.valueOf(((a) r107.next()).getType()));
            goto L4
        L6:
            r100.putIntArray(r104, CollectionsKt.toIntArray(r106));
            String r108 = Intrinsics.stringPlus(r101, "_icons");
            ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
            Iterator r110 = r105.iterator();
        L8:
            if (r110.hasNext() == false) goto L10;
            r109.add(Integer.valueOf(((a) r110.next()).f403629b));
            goto L8
        L10:
            r100.putIntArray(r108, CollectionsKt.toIntArray(r109));
            String r111 = Intrinsics.stringPlus(r101, "_texts");
            ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
            Iterator r113 = r105.iterator();
        L12:
            if (r113.hasNext() == false) goto L14;
            r112.add(((a) r113.next()).f403630c);
            goto L12
        L14:
            Object[] r114 = r112.toArray(new String[0]);
            if (r114 == null) goto L43;
            r100.putStringArray(r111, (String[]) r114);
            String r115 = Intrinsics.stringPlus(r101, "_ids");
            ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
            Iterator r117 = r105.iterator();
        L18:
            if (r117.hasNext() == false) goto L20;
            r116.add(((a) r117.next()).f403631d);
            goto L18
        L20:
            Object[] r118 = r116.toArray(new String[0]);
            if (r118 == null) goto L41;
            r100.putStringArray(r115, (String[]) r118);
            String r119 = Intrinsics.stringPlus(r101, "_tints");
            ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
            Iterator r121 = r105.iterator();
        L24:
            if (r121.hasNext() == false) goto L26;
            r120.add(Integer.valueOf(((a) r121.next()).f403632e));
            goto L24
        L26:
            r100.putIntArray(r119, CollectionsKt.toIntArray(r120));
            String r122 = Intrinsics.stringPlus(r101, "_enableds");
            ArrayList r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
            Iterator r124 = r105.iterator();
        L28:
            if (r124.hasNext() == false) goto L30;
            r123.add(Boolean.valueOf(((a) r124.next()).f403634g));
            goto L28
        L30:
            r100.putBooleanArray(r122, CollectionsKt.toBooleanArray(r123));
            String r125 = Intrinsics.stringPlus(r101, "_icon_names");
            ArrayList r126 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
            Iterator r127 = r105.iterator();
        L32:
            if (r127.hasNext() == false) goto L34;
            r126.add(((a) r127.next()).f403635h);
            goto L32
        L34:
            Object[] r128 = r126.toArray(new String[0]);
            if (r128 == null) goto L39;
            r100.putStringArray(r125, (String[]) r128);
            return;
        L39:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        L41:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        L43:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        public static void e(Bundle r110, String r111, OButtonGroup.b r112) {
            Bundle r100 = new Bundle();
            r100.putInt(RemoteMessageConst.Notification.VISIBILITY, r112.f399078a);
            r100.putFloat("alpha", r112.f399079b);
            r100.putFloat("scale_x", r112.f399080c);
            r100.putFloat("scale_y", r112.f399081d);
            r100.putFloat("group_blur", r112.f399082e);
            r100.putInt("group_width", r112.f399083f);
            List<OButtonGroup.d> r113 = r112.f399084g;
            ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
            Iterator<T> r114 = r113.iterator();
        L4:
            if (r114.hasNext() == false) goto L13;
            OButtonGroup.d r102 = (OButtonGroup.d) r114.next();
            int r103 = k.f403620g;
            Object r104 = r102.f399113a;
            if ((r104 instanceof b) == false) goto L8;
            b r105 = (b) r104;
        L9:
            Bundle r106 = new Bundle();
            r106.putInt(RemoteMessageConst.Notification.VISIBILITY, r102.f399114b);
            r106.putFloat("alpha", r102.f399115c);
            r106.putFloat("scale_x", r102.f399116d);
            r106.putFloat("scale_y", r102.f399117e);
            if (r105 == null) goto L12;
            r106.putBoolean("has_action_key", true);
            r106.putInt("type", r105.getType());
            r106.putInt("icon_res", r105.f403637b);
            r106.putString("text", r105.f403638c);
            r106.putInt("tint_color", r105.f403639d);
            r106.putString("id", r105.f403640e);
            r106.putString("icon_resource_name", r105.f403641f);
        L12:
            r101.add(r106);
            goto L4
        L8:
            r105 = null;
            goto L9
        L13:
            r100.putParcelableArrayList("items", new ArrayList(r101));
            Unit r115 = Unit.INSTANCE;
            r110.putBundle(r111, r100);
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f403657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f403658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f403659c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f403660d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f403661e;

        public g() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (this.f403657a == r101.f403657a) goto L12;
            return false;
        L12:
            if (this.f403658b == r101.f403658b) goto L15;
            return false;
        L15:
            if (this.f403659c == r101.f403659c) goto L18;
            return false;
        L18:
            if (this.f403660d == r101.f403660d) goto L21;
            return false;
        L21:
            if (this.f403661e == r101.f403661e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f403657a * 31) + this.f403658b) * 31) + this.f403659c) * 31) + this.f403660d) * 31) + this.f403661e;
        }

        public final String toString() {
            return "ContentState(startTitleWidth=" + this.f403657a + ", centerTitleWidth=" + this.f403658b + ", centerCustomWidth=" + this.f403659c + ", centerCustomHeight=" + this.f403660d + ", contentTopInset=" + this.f403661e + ')';
        }

        public /* synthetic */ g(int r100) {
            this(0, 0, 0, 0, 0);
        }

        public g(int r100, int r101, int r102, int r103, int r104) {
            this.f403657a = r100;
            this.f403658b = r101;
            this.f403659c = r102;
            this.f403660d = r103;
            this.f403661e = r104;
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f403662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f403663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f403664c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f403665d;

        public h() {
            this(0, 0, 0, 0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            h r101 = (h) r100;
            if (this.f403662a == r101.f403662a) goto L12;
            return false;
        L12:
            if (this.f403663b == r101.f403663b) goto L15;
            return false;
        L15:
            if (this.f403664c == r101.f403664c) goto L18;
            return false;
        L18:
            if (this.f403665d == r101.f403665d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f403662a * 31) + this.f403663b) * 31) + this.f403664c) * 31) + this.f403665d;
        }

        public final String toString() {
            return "StyleState(startButtonStyle=" + this.f403662a + ", centerButtonStyle=" + this.f403663b + ", subEndButtonStyle=" + this.f403664c + ", endButtonStyle=" + this.f403665d + ')';
        }

        public h(int r100, int r101, int r102, int r103) {
            this.f403662a = r100;
            this.f403663b = r101;
            this.f403664c = r102;
            this.f403665d = r103;
        }
    }

    static {
        new f();
    }

    public k() {
        this(null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f403621a, r101.f403621a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f403622b, r101.f403622b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f403623c, r101.f403623c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f403624d, r101.f403624d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f403625e, r101.f403625e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f403626f, r101.f403626f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f403621a.hashCode() * 31) + this.f403622b.hashCode()) * 31) + this.f403623c.hashCode()) * 31) + this.f403624d.hashCode()) * 31;
        d r101 = this.f403625e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        SurfaceControl r105 = this.f403626f;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "OFloatingTitleBarState(bounds=" + this.f403621a + ", content=" + this.f403622b + ", actions=" + this.f403623c + ", style=" + this.f403624d + ", animationState=" + this.f403625e + ", interruptedOverlaySurface=" + this.f403626f + ')';
    }

    public final Bundle c() {
        Bundle r100 = new Bundle();
        e r101 = this.f403621a;
        r100.putInt("width", r101.f403653a);
        r100.putInt("height", r101.f403654b);
        r100.putInt("screen_x", r101.f403655c);
        r100.putInt("screen_y", r101.f403656d);
        g r102 = this.f403622b;
        r100.putInt("start_title_width", r102.f403657a);
        r100.putInt("center_title_width", r102.f403658b);
        r100.putInt("center_custom_width", r102.f403659c);
        r100.putInt("center_custom_height", r102.f403660d);
        r100.putInt("content_top_inset", r102.f403661e);
        f.a(r100, "start_actions", this.f403623c.f403642a);
        f.a(r100, "center_actions", this.f403623c.f403643b);
        f.a(r100, "sub_end_actions", this.f403623c.f403644c);
        f.a(r100, "end_actions", this.f403623c.f403645d);
        h r103 = this.f403624d;
        r100.putInt("start_button_style", r103.f403662a);
        r100.putInt("center_button_style", r103.f403663b);
        r100.putInt("sub_end_button_style", r103.f403664c);
        r100.putInt("end_button_style", r103.f403665d);
        d r104 = this.f403625e;
        if (r104 == null) goto L14;
        Bundle r105 = new Bundle();
        f.e(r105, "start", r104.f403646a);
        f.e(r105, "center", r104.f403647b);
        f.e(r105, "sub_end", r104.f403648c);
        f.e(r105, "end", r104.f403649d);
        r105.putFloat("sub_end_translation_x", r104.f403650e);
        if (r104.f403651f == null) goto L8;
        boolean r106 = true;
    L9:
        r105.putBoolean("has_freeze_end_area_width", r106);
        Integer r107 = r104.f403651f;
        if (r107 == null) goto L13;
        r105.putInt("freeze_end_area_width", r107.intValue());
    L13:
        r105.putFloat("center_translation_x", r104.f403652g);
        Unit r108 = Unit.INSTANCE;
        r100.putBundle("animation_state", r105);
        goto L14
    L8:
        r106 = false;
    L14:
        SurfaceControl r109 = this.f403626f;
        if (r109 == null) goto L18;
        r100.putParcelable("interrupted_overlay_surface", r109);
    L18:
        return r100;
    }

    public final k b(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        c r100 = this.f403623c;
        c r101 = new c(f.h(r100.f403642a, r110), f.h(r100.f403643b, r110), f.h(r100.f403644c, r110), f.h(r100.f403645d, r110));
        d r102 = this.f403625e;
        if (r102 != null) goto L5;
        d r103 = null;
    L7:
        return a(this, null, null, r101, null, r103, 43);
    L5:
        OButtonGroup.b r104 = f.g(r102.f403646a, r110);
        OButtonGroup.b r105 = f.g(r102.f403647b, r110);
        OButtonGroup.b r106 = f.g(r102.f403648c, r110);
        OButtonGroup.b r111 = f.g(r102.f403649d, r110);
        float r112 = r102.f403650e;
        Integer r113 = r102.f403651f;
        float r114 = r102.f403652g;
        Intrinsics.checkNotNullParameter(r104, "startState");
        Intrinsics.checkNotNullParameter(r105, "centerState");
        Intrinsics.checkNotNullParameter(r106, "subEndState");
        Intrinsics.checkNotNullParameter(r111, "endState");
        r103 = new d(r104, r105, r106, r111, r112, r113, r114);
        goto L7
    }

    public /* synthetic */ k(e r110, g r111, c r112, h r113, int r114) {
        int r100 = 0;
        if ((r114 & 1) == 0) goto L5;
        r110 = new e(0, 0, 0, 0);
    L5:
        e r101 = r110;
        if ((r114 & 2) == 0) goto L8;
        r111 = new g(r100);
    L8:
        g r102 = r111;
        if ((r114 & 4) == 0) goto L11;
        r112 = new c(r100);
    L11:
        c r103 = r112;
        if ((r114 & 8) == 0) goto L14;
        r113 = new h(0, 0, 0, 0);
    L14:
        this(r101, r102, r103, r113, null, null);
    }

    public k(e r100, g r101, c r102, h r103, d r104, SurfaceControl r105) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r103, "style");
        this.f403621a = r100;
        this.f403622b = r101;
        this.f403623c = r102;
        this.f403624d = r103;
        this.f403625e = r104;
        this.f403626f = r105;
    }

    public static k a(k r100, e r101, g r102, c r110, h r111, d r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        r101 = r100.f403621a;
    L5:
        e r103 = r101;
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.f403622b;
    L8:
        g r104 = r102;
        if ((r113 & 4) == 0) goto L11;
        r110 = r100.f403623c;
    L11:
        c r105 = r110;
        if ((r113 & 8) == 0) goto L14;
        r111 = r100.f403624d;
    L14:
        h r106 = r111;
        if ((r113 & 16) == 0) goto L17;
        r112 = r100.f403625e;
    L17:
        d r107 = r112;
        if ((r113 & 32) == 0) goto L20;
        SurfaceControl r108 = r100.f403626f;
    L21:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "bounds");
        Intrinsics.checkNotNullParameter(r104, "content");
        Intrinsics.checkNotNullParameter(r105, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r106, "style");
        return new k(r103, r104, r105, r106, r107, r108);
    L20:
        r108 = null;
        goto L21
    }
}
