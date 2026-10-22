package com.ss.android.lark.chat.message.menu;

import android.text.Layout;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.utils.u;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.select.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlin.text.CharsKt;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class MessageLongPressTextSelectHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MessageLongPressTextSelectHelper f415451a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<Character> f415452b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<Class<? extends s>> f415453c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<Function2<CharSequence, Integer, IntRange>> f415454d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final WeakHashMap<LKUILightTextView, b> f415455e = null;

    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f415456b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<IntRange> f415457a;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.message.menu.MessageLongPressTextSelectHelper$a$a, reason: collision with other inner class name */
        public static final class C4860a {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f415457a, ((a) r100).f415457a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f415457a.hashCode();
        }

        public final String toString() {
            return "SentenceBoundaryClickableInfo(ranges=" + this.f415457a + ')';
        }

        static {
            f415456b = new a(CollectionsKt.emptyList());
        }

        public a(List<IntRange> r100) {
            Intrinsics.checkNotNullParameter(r100, "ranges");
            this.f415457a = r100;
        }

        public final IntRange a(int r100) {
            if (this.f415457a.isEmpty() == true) goto L15;
            if (r100 < 0) goto L15;
            int r101 = CollectionsKt.getLastIndex(this.f415457a);
            int r102 = 0;
        L7:
            if (r102 > r101) goto L15;
            int r103 = (r102 + r101) >>> 1;
            IntRange r104 = (IntRange) ListProtector.get(this.f415457a, r103);
            if (r100 < r104.getFirst()) goto L10;
            if (r100 <= r104.getLast()) goto L14;
            r102 = r103 + 1;
            goto L7
        L14:
            return r104;
        L10:
            r101 = r103 - 1;
        L15:
            return null;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f415458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f415459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f415460c;

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Float.compare(this.f415458a, r101.f415458a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f415459b, r101.f415459b) == 0) goto L15;
            return false;
        L15:
            if (this.f415460c == r101.f415460c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((Float.floatToIntBits(this.f415458a) * 31) + Float.floatToIntBits(this.f415459b)) * 31;
            if (this.f415460c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "TouchState(downX=" + this.f415458a + ", downY=" + this.f415459b + ", hasDown=" + this.f415460c + ')';
        }

        public b(int r100) {
            this.f415458a = 0.0f;
            this.f415459b = 0.0f;
            this.f415460c = false;
        }
    }

    public MessageLongPressTextSelectHelper() {
    }

    static {
        MessageLongPressTextSelectHelper r100 = new MessageLongPressTextSelectHelper();
        f415451a = r100;
        f415452b = SetsKt.setOf(new Character[]{'.', '!', '?', (char) 12290, (char) 65281, (char) 65311, (char) 8230});
        f415453c = SetsKt.setOf(new Class[]{com.ss.android.lark.coremd.nonimbiz.asl.a.class, com.ss.android.lark.coremd.nonimbiz.calendar.a.class});
        f415454d = CollectionsKt.listOf(new KFunction[]{new MessageLongPressTextSelectHelper$partialRangeStrategies$1(r100), new MessageLongPressTextSelectHelper$partialRangeStrategies$2(r100), new MessageLongPressTextSelectHelper$partialRangeStrategies$3(r100), new MessageLongPressTextSelectHelper$partialRangeStrategies$4(r100)});
        f415455e = new WeakHashMap();
    }

    public static boolean e(char r100) {
        if (Character.isLetterOrDigit(r100) == false) goto L5;
        return true;
    L5:
        if (13312 <= r100) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L12;
    L27:
        boolean r102 = true;
    L28:
        if (r102 == false) goto L30;
        return true;
    L30:
        if (r100 != '_') goto L32;
        return true;
    L32:
        if (r100 == '-') goto L39;
        return false;
    L39:
        return true;
    L12:
        if (19968 <= r100) goto L14;
    L16:
        boolean r103 = false;
    L17:
        if (r103 == true) goto L27;
        if (63744 <= r100) goto L21;
    L23:
        boolean r104 = false;
    L24:
        if (r104 == true) goto L27;
        r102 = false;
        goto L28
    L21:
        if (r100 >= 64256) goto L23;
        r104 = true;
        goto L24
    L14:
        if (r100 >= 40960) goto L16;
        r103 = true;
        goto L17
    L7:
        if (r100 >= 19904) goto L9;
        r101 = true;
        goto L10
    }

    public static IntRange a(CharSequence r100, int r101) {
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return null;
    L9:
        int r103 = Math.max(0, RangesKt.coerceIn(r101, 0, r100.length()) - 1);
        int r104 = Math.min(r100.length(), r103 + 2);
        if ((r104 - r103) < 2) goto L14;
        return RangesKt.until(r103, r104);
    L14:
        return RangesKt.until(Math.max(0, r100.length() - 2), r100.length());
    L5:
        r102 = false;
        goto L6
    }

    public static boolean c(CharSequence r100, IntRange r101) {
        IntRange r102 = g(r100, 0, r100.length());
        if (r102 != null) goto L5;
        IntRange r103 = null;
    L6:
        if (r103 != null) goto L9;
        return false;
    L9:
        if (r101.getFirst() == r103.getFirst()) goto L11;
        return false;
    L11:
        if (r101.getLast() != r103.getLast()) goto L15;
        return true;
    L15:
        return false;
    L5:
        r103 = h(r100, r102);
        goto L6
    }

    public static IntRange h(CharSequence r110, IntRange r111) {
        if ((r110 instanceof Spanned) == true) goto L5;
        return r111;
    L5:
        int r100 = r111.getFirst();
        int r112 = r111.getLast() + 1;
    L7:
        if (r100 >= r112) goto L42;
        Spanned r101 = (Spanned) r110;
        Object[] r102 = r101.getSpans(r100, r112, ReplacementSpan.class);
        ArrayList r103 = new ArrayList();
        int r104 = r102.length;
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L22;
        Object r106 = r102[r105];
        ReplacementSpan r113 = (ReplacementSpan) r106;
        int r114 = r101.getSpanStart(r113);
        int r115 = r101.getSpanEnd(r113);
        if (r100 > r114) goto L14;
        if (r114 >= r115) goto L14;
        boolean r116 = true;
    L15:
        if (r116 == false) goto L18;
        if (r115 != r112) goto L18;
        boolean r117 = true;
    L19:
        if (r117 == false) goto L21;
        r103.add(r106);
    L21:
        r105 = r105 + 1;
    L18:
        r117 = false;
    L14:
        r116 = false;
        goto L15
    L22:
        Iterator r107 = r103.iterator();
        if (r107.hasNext() == true) goto L25;
        Object r108 = null;
    L34:
        ReplacementSpan r109 = (ReplacementSpan) r108;
        if (r109 == null) goto L42;
        r112 = r101.getSpanStart(r109);
    L38:
        if (r100 >= r112) goto L7;
        int r118 = r112 - 1;
        if (CharsKt.isWhitespace(r110.charAt(r118)) == false) goto L7;
        r112 = r118;
        goto L38
    L25:
        r108 = r107.next();
        if (r107.hasNext() == false) goto L34;
        int r119 = r101.getSpanStart((ReplacementSpan) r108);
    L29:
        Object r120 = r107.next();
        int r121 = r101.getSpanStart((ReplacementSpan) r120);
        if (r119 >= r121) goto L33;
        r108 = r120;
        r119 = r121;
    L33:
        if (r107.hasNext() == true) goto L29;
    L42:
        if (r100 < r112) goto L44;
        return null;
    L44:
        return RangesKt.until(r100, r112);
    }

    public static IntRange b(CharSequence r100, int r101, boolean r102) {
        if (r102 == true) goto L4;
    L15:
        return null;
    L4:
        if ((r100 instanceof Spanned) == false) goto L15;
        com.ss.android.lark.widget.linked_emojicon.base.a r103 = (com.ss.android.lark.widget.linked_emojicon.base.a) ArraysKt.firstOrNull(((Spanned) r100).getSpans(r101, RangesKt.coerceAtMost(r101 + 1, r100.length()), com.ss.android.lark.widget.linked_emojicon.base.a.class));
        if (r103 == null) goto L15;
        Spanned r104 = (Spanned) r100;
        int r105 = r104.getSpanStart(r103);
        int r106 = r104.getSpanEnd(r103);
        if (r105 > r101) goto L12;
        if (r101 >= r106) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == false) goto L15;
        return RangesKt.until(r105, r106);
    L12:
        r107 = false;
        goto L13
    }

    public static IntRange g(CharSequence r100, int r101, int r102) {
        int r103 = RangesKt.coerceIn(r101, 0, r100.length());
        int r104 = RangesKt.coerceIn(r102, 0, r100.length());
    L3:
        if (r103 >= r104) goto L7;
        if (CharsKt.isWhitespace(r100.charAt(r103)) == false) goto L7;
        r103 = r103 + 1;
    L7:
        if (r104 <= r103) goto L11;
        int r105 = r104 - 1;
        if (CharsKt.isWhitespace(r100.charAt(r105)) == false) goto L11;
        r104 = r105;
    L11:
        if (r103 < r104) goto L15;
        return null;
    L15:
        return RangesKt.until(r103, r104);
    }

    public static boolean d(CharSequence r100, int r101, boolean r102, a r103) {
        if (r101 >= 0) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == true) goto L11;
        return false;
    L11:
        if (f415452b.contains(Character.valueOf(r100.charAt(r101))) == false) goto L13;
        return true;
    L13:
        if (b(r100, r101, r102) == null) goto L15;
        return true;
    L15:
        if (r103.a(r101) != null) goto L21;
        return false;
    L21:
        return true;
    L5:
        if (r101 >= r100.length()) goto L7;
        r104 = true;
        goto L8
    }

    @JvmStatic
    public static final void f(LKUILightTextView r110, m2b.a r111, boolean r112, Function3<? super CharSequence, ? super Boolean, ? super PartialReplyInfo.PartialContentRelativePosition, Unit> r113, Function0<Unit> r114, Integer r115) {
        Intrinsics.checkNotNullParameter(r110, "selectableView");
        Intrinsics.checkNotNullParameter(r113, "changeCopyTextAction");
        Intrinsics.checkNotNullParameter(r114, "onTextSelectedAction");
        MessageLongPressTextSelectHelper r100 = f415451a;
        r100.getClass();
        u r101 = u.a.f416743a;
        if (r101.f416739d == false) goto L9;
        if (com.ss.android.lark.chat.message.menu.a.b(r110) == false) goto L9;
        r101.f416742g = 2;
        r101.f416741f = true;
    L9:
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("lark.im.partial.select") == true) goto L12;
        r100.getClass();
        com.ss.android.lark.chat.message.menu.a.d(r110, r111, r112, r113, r114, r115, 64);
        return;
    L12:
        WeakHashMap<LKUILightTextView, b> r102 = f415455e;
        boolean r103 = false;
        if (r102.containsKey(r110) == true) goto L16;
        b r104 = new b(0);
        r102.put(r110, r104);
        r110.setOnTouchListener(new f(r110, r104));
    L16:
        Object r105 = r110.getTag(R.id.tag_nested_touch_target_view);
        if ((r105 instanceof LKUILightTextView) == false) goto L19;
        LKUILightTextView r106 = (LKUILightTextView) r105;
    L20:
        if (r106 == null) goto L36;
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("lark.im.partial.select") == true) goto L25;
    L31:
        boolean r116 = false;
    L32:
        if (r116 == false) goto L36;
        r101.f416742g = 2;
        r101.f416741f = true;
        r100.getClass();
        com.ss.android.lark.chat.message.menu.a.d(r106, r111, r112, r113, r114, r115, 64);
        return;
    L25:
        if (r101.f416739d == false) goto L31;
        if (com.ss.android.lark.chat.message.menu.a.b(r110) == false) goto L29;
    L30:
        r116 = true;
        goto L32
    L29:
        if (com.ss.android.lark.chat.message.menu.a.b(r106) == false) goto L31;
    L36:
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("lark.im.partial.select") == true) goto L39;
    L45:
        boolean r107 = false;
    L46:
        if (r107 == false) goto L123;
        b r108 = r102.get(r110);
        Layout r109 = r110.getLayout();
        if (r109 == null) goto L90;
        CharSequence r117 = r109.getText();
        if (r117.length() != 0) goto L53;
        boolean r118 = true;
    L54:
        if (r118 == true) goto L90;
        Layout r119 = r110.getLayout();
        if (r119 == null) goto L65;
        if (r108 != null) goto L61;
    L63:
        boolean r120 = false;
    L64:
        if (r120 == false) goto L65;
        float r121 = (r108.f415458a - r110.getTotalPaddingLeft()) + r110.getScrollX();
        float r122 = r108.f415459b;
        int r123 = r110.getGravity() & 112;
        if (r123 != 16) goto L69;
        float r124 = (r110.getMeasuredHeight() - com.ss.android.lark.widget.light.layout.e.a(r119)) / 2;
    L74:
        Integer r125 = Integer.valueOf(r119.getOffsetForHorizontal(r119.getLineForVertical((int) ((r122 - r124) + r110.getScrollY())), r121));
    L75:
        if (r125 == null) goto L90;
        int r126 = r125.intValue();
        if (r126 >= 0) goto L79;
    L81:
        boolean r127 = false;
    L82:
        if (r127 == false) goto L90;
        Iterator<T> r128 = f415454d.iterator();
    L86:
        if (r128.hasNext() == false) goto L90;
        IntRange r129 = (IntRange) ((Function2) r128.next()).invoke(r117, Integer.valueOf(r126));
        if (r129 == null) goto L86;
    L91:
        if (r129 == null) goto L123;
        f415451a.getClass();
        WeakReference<m> r130 = com.ss.android.lark.chat.message.menu.a.f415461a;
        Intrinsics.checkNotNullParameter(r110, "view");
        WeakReference<View> r131 = com.ss.android.lark.chat.message.menu.a.f415462b;
        if (r131 == null) goto L95;
        View r132 = r131.get();
    L97:
        if (Intrinsics.areEqual(r110, r132) == false) goto L121;
        Intrinsics.checkNotNullParameter(r129, "intRange");
        WeakReference<m> r133 = com.ss.android.lark.chat.message.menu.a.f415461a;
        if (r133 == null) goto L119;
        m r134 = r133.get();
        if (r134 == null) goto L119;
        u r135 = u.a.f416743a;
        r135.f416742g = 2;
        r135.f416741f = true;
        monitor-enter(r135);
        r135.f416736a = null;     // Catch: Throwable -> L115
        monitor-exit(r135);
        int r136 = r129.getFirst();
        int r137 = r129.getLast() + 1;
        CharSequence r138 = r134.f448440c.getContent();     // Catch: Exception -> L112
        if (r138 == null) goto L114;
        int r139 = r138.length();     // Catch: Exception -> L112
        r134.k(Math.max(0, Math.min(r136, r139)), Math.max(0, Math.min(r137, r139)));     // Catch: Exception -> L112
        r134.f448446i = true;     // Catch: Exception -> L112
        r134.g(null);     // Catch: Exception -> L112
        r134.j();     // Catch: Exception -> L112
    L114:
        r103 = true;
    L112:
        e = move-exception;
        e.toString();
    L115:
        th = move-exception;
        throw th;
    L119:
        if (r103 == false) goto L121;
        return;
    L121:
        u r140 = u.a.f416743a;
        r140.c();
        r140.f416742g = 2;
        r140.f416741f = true;
        com.ss.android.lark.chat.message.menu.a.c(r110, r111, r112, r113, r114, r115, r129);
        return;
    L95:
        r132 = null;
        goto L97
    L79:
        if (r126 > r117.length()) goto L81;
        r127 = true;
        goto L82
    L69:
        if (r123 == 80) goto L71;
        int r141 = r110.getPaddingTop();
    L72:
        r124 = r141;
        goto L74
    L71:
        r141 = (r110.getMeasuredHeight() - r110.getPaddingBottom()) - com.ss.android.lark.widget.light.layout.e.a(r119);
        goto L72
    L61:
        if (r108.f415460c != true) goto L63;
        r120 = true;
    L65:
        r125 = null;
        goto L75
    L53:
        r118 = false;
    L90:
        r129 = null;
    L123:
        f415451a.getClass();
        com.ss.android.lark.chat.message.menu.a.d(r110, r111, r112, r113, r114, r115, 64);
        return;
    L39:
        if (r101.f416739d == false) goto L45;
        if (com.ss.android.lark.chat.message.menu.a.b(r110) == false) goto L43;
    L44:
        r107 = true;
        goto L46
    L43:
        if (com.ss.android.lark.chat.message.menu.a.b(r110) == false) goto L45;
    L19:
        r106 = null;
        goto L20
    }
}
