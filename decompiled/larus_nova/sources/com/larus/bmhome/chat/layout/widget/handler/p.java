package com.larus.bmhome.chat.layout.widget.handler;

import android.graphics.Color;
import android.text.SpannableString;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.layout.widget.ForegroundAlphaSpan;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes25.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f305051a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, a> f305052b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Set<TextView>> f305053c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f305054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f305055e = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CharSequence f305056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f305057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<Integer, Integer> f305058c;

        public a() {
            throw null;
        }

        public a(CharSequence r100, String r101) {
            LinkedHashMap r102 = new LinkedHashMap();
            Intrinsics.checkNotNullParameter(r100, "content");
            Intrinsics.checkNotNullParameter(r101, "extra");
            Intrinsics.checkNotNullParameter(r102, "alphaMap");
            this.f305056a = r100;
            this.f305057b = r101;
            this.f305058c = r102;
        }
    }

    static {
        f305051a = CoroutineScopeKt.MainScope();
        f305052b = new LinkedHashMap();
        f305053c = new LinkedHashMap();
        f305055e = 300;
    }

    public static void a(String r110) {
        a r100 = (a) ((LinkedHashMap) f305052b).get(r110);
        if (r100 != null) goto L5;
        return;
    L5:
        Set r111 = (Set) ((LinkedHashMap) f305053c).get(r110);
        if (r111 != null) goto L8;
        return;
    L8:
        Map<Integer, Integer> r101 = r100.f305058c;
        SpannableString r102 = new SpannableString(r100.f305056a);
        List r103 = CollectionsKt.sorted(CollectionsKt.toList(r101.keySet()));
        Iterator r104 = r103.iterator();
        int r105 = 0;
    L10:
        if (r104.hasNext() == false) goto L25;
        Object r106 = r104.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        int r108 = ((Number) r106).intValue();
        if (r102.length() <= r108) goto L24;
        if (r107 >= r103.size()) goto L20;
        int r109 = RangesKt.coerceAtMost(((Number) ListProtector.get(r103, r107)).intValue(), r102.length());
    L21:
        Integer r112 = r101.get(Integer.valueOf(r108));
        if (r112 == null) goto L24;
        int r113 = r112.intValue();
        r102.setSpan(new ForegroundAlphaSpan(Color.argb(r113, 0, 0, 0), r113), r108, r109, 17);
        goto L24
    L20:
        r109 = r102.length();
    L24:
        r105 = r107;
        goto L10
    L25:
        Iterator r114 = r111.iterator();
    L27:
        if (r114.hasNext() == false) goto L32;
        TextView r115 = (TextView) r114.next();
        if (r115.isAttachedToWindow() == true) goto L30;
        r114.remove();
        goto L27
    L30:
        r115.setText(r102);
        goto L27
    }

    public static String b(String r100, String r101) {
        return r100 + '#' + r101;
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "viewTag");
        Set r102 = ((LinkedHashMap) f305053c).keySet();
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Object r105 = r104.next();
        if (Intrinsics.areEqual((String) r105, b(r100, r101)) == false) goto L4;
        r103.add(r105);
        goto L4
    L8:
        Set r106 = ((LinkedHashMap) f305052b).keySet();
        ArrayList r107 = new ArrayList();
        Iterator r108 = r106.iterator();
    L10:
        if (r108.hasNext() == false) goto L14;
        Object r109 = r108.next();
        if (Intrinsics.areEqual((String) r109, b(r100, r101)) == false) goto L10;
        r107.add(r109);
        goto L10
    L14:
        Iterator r110 = r103.iterator();
    L16:
        if (r110.hasNext() == false) goto L18;
        String r111 = (String) r110.next();
        f305053c.remove(r111);
        goto L16
    L18:
        Iterator r112 = r107.iterator();
    L20:
        if (r112.hasNext() == false) goto L22;
        String r113 = (String) r112.next();
        f305052b.remove(r113);
        goto L20
    }

    public static void c(Integer r100, String r101, String r102, CharSequence r110, String r111, CustomMarkdownTextView r112) {
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r102, "viewTag");
        Intrinsics.checkNotNullParameter(r110, "content");
        Intrinsics.checkNotNullParameter(r111, "extra");
        Intrinsics.checkNotNullParameter(r112, "textView");
        if (r100 != null) goto L6;
    L7:
        if (r100 != null) goto L10;
        return;
    L10:
        if (r100.intValue() == 3) goto L13;
        return;
    L13:
        if (r110.length() > r111.length()) goto L15;
        return;
    L15:
        String r103 = b(r101, r102);
        Map<String, a> r104 = f305052b;
        LinkedHashMap r105 = (LinkedHashMap) r104;
        if (r105.get(r103) != null) goto L19;
        r104.put(r103, new a(r110, r111));
        return;
    L19:
        a r106 = (a) r105.get(r103);
        if (r106 != null) goto L22;
        return;
    L22:
        CharSequence r107 = r106.f305056a;
        CharSequence r108 = r107.subSequence(0, r107.length() - r106.f305057b.length());
        if (r110.length() <= r108.length()) goto L25;
        r106.f305058c.put(Integer.valueOf(r108.length()), 0);
    L25:
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r106.f305056a = r110;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r106.f305057b = r111;
        if (r106.f305058c.isEmpty() == false) goto L28;
        return;
    L28:
        Map<String, Set<TextView>> r109 = f305053c;
        LinkedHashMap r113 = (LinkedHashMap) r109;
        if (r113.get(r103) != null) goto L31;
        r109.put(r103, new LinkedHashSet());
    L31:
        Set r114 = (Set) r113.get(r103);
        if (r114 == null) goto L34;
        r114.add(r112);
    L34:
        a(r103);
        if (f305054d == true) goto L40;
        f305054d = true;
        BuildersKt.launch$default(f305051a, null, null, new StreamAlphaSpanHandler$loop$1(null), 3, null);
        return;
    L40:
        return;
    L6:
        if (r100.intValue() == 1) goto L13;
        goto L7
    }
}
