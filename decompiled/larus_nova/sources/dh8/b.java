package dh8;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.bmhome.utils.w2;
import com.larus.im.bean.message.Message;
import com.larus.utils.i;
import com.larus.utils.i0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import v19.c7;
import vd9.r;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f468639a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f468640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f468641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LinkedHashSet<String> f468642d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final LinkedHashSet<String> f468643e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, Integer> f468644f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final LinkedHashSet<String> f468645g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f468646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f468647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Map<String, Boolean> f468648j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Set<String> f468649k = null;

    public b() {
    }

    static {
        f468639a = new b();
        f468642d = new LinkedHashSet();
        f468643e = new LinkedHashSet();
        f468644f = new LinkedHashMap();
        f468645g = new LinkedHashSet();
        f468648j = new LinkedHashMap();
        f468649k = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        if (Intrinsics.areEqual(f468640b, r100) == true) goto L6;
        f468640b = r100;
        f468642d.clear();
        ((LinkedHashMap) f468644f).clear();
        f468645g.clear();
        ((LinkedHashMap) f468648j).clear();
        f468649k.clear();
        f468646h = false;
        f468647i = null;
        f468641c++;
        return;
    }

    public static int b(Context r100) {
        Resources r101 = r100.getResources();
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 34) goto L5;
    L8:
        int r103 = 0;
        Integer r104 = null;
        if (r102 >= 34) goto L65;
    L25:
        Integer r105 = null;
    L26:
        if (r105 == null) goto L28;
        int r106 = r105.intValue();
    L29:
        Activity r107 = i.getActivity(r100);
        if (r107 == null) goto L36;
        Window r108 = r107.getWindow();
        if (r108 == null) goto L36;
        View r109 = r108.peekDecorView();
        if (r109 == null) goto L36;
        WindowInsetsCompat r110 = ViewCompat.getRootWindowInsets(r109);
    L37:
        if (r110 == null) goto L41;
        Insets r111 = r110.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.statusBars());
        if (r111 == null) goto L41;
        int r112 = r111.top;
    L51:
        if (r110 == null) goto L55;
        Insets r113 = r110.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.navigationBars());
        if (r113 == null) goto L55;
        r103 = r113.bottom;
    L64:
        return RangesKt.coerceAtLeast((r106 - r112) - r103, 1);
    L55:
        i0.f375410a.getClass();
        Integer r114 = Integer.valueOf(i0.f());
        if (r114.intValue() <= 0) goto L58;
        boolean r115 = true;
    L59:
        if (r115 == false) goto L61;
        r104 = r114;
    L61:
        if (r104 == null) goto L64;
        r103 = r101.getDimensionPixelSize(r104.intValue());
        goto L64
    L58:
        r115 = false;
    L41:
        i0.f375410a.getClass();
        Integer r116 = Integer.valueOf(i0.h());
        if (r116.intValue() <= 0) goto L44;
        boolean r117 = true;
    L45:
        if (r117 == true) goto L48;
        r116 = null;
    L48:
        if (r116 == null) goto L50;
        r112 = r101.getDimensionPixelSize(r116.intValue());
        goto L51
    L50:
        r112 = 0;
        goto L51
    L44:
        r117 = false;
    L36:
        r110 = null;
        goto L37
    L28:
        r106 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).heightPixels;
        goto L29
    L65:
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L12
        Object r119 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type android.view.WindowManager");     // Catch: Throwable -> L12
        Object r120 = Result.m9449constructorimpl(Integer.valueOf(((WindowManager) r119).getCurrentWindowMetrics().getBounds().height()));     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r120) == false) goto L17;
        r120 = null;
    L17:
        r105 = (Integer) r120;
        if (r105 == null) goto L25;
        if (r105.intValue() <= 0) goto L22;
        boolean r121 = true;
    L23:
        if (r121 == false) goto L25;
    L22:
        r121 = false;
    L12:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L5:
        if (r101.getConfiguration().screenHeightDp <= 0) goto L8;
        return RangesKt.coerceAtLeast(MathKt.roundToInt(r101.getConfiguration().screenHeightDp * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density), 1);
    }

    public static Message c(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (h(r100) == false) goto L6;
        return r100;
    L6:
        if (d.x0(r100) == false) goto L10;
        List<Message> r101 = r100.getSubList();
        if (r101 == null) goto L13;
        ConcurrentHashMap<String, Integer> r102 = w2.f315144a;
        return (Message) CollectionsKt.getOrNull(r101, w2.a(r100.getMessageId()));
    L13:
        return null;
    L10:
        f468639a.getClass();
        if (g(r100) == true) goto L13;
        return r100;
    }

    public static int e(int r100) {
        return RangesKt.coerceIn(r100 / 3, c7.b(160), c7.b(320));
    }

    public static boolean f(Message r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = r100.getMessageId();
        if (r101 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L14;
        return false;
    L14:
        if (r100.getContentType() == 1) goto L31;
        if (h(r100) == true) goto L31;
        if (r100.getContentType() != 66) goto L23;
        return f(c(r100));
    L23:
        if (r100.getContentType() != 9999) goto L32;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((!r.a(r100).isEmpty()) == true) goto L27;
        return false;
    L27:
        if (com.larus.im.bean.message.a.m0(r100) == false) goto L34;
        return true;
    L34:
        return false;
    L32:
        return false;
    L31:
        return com.larus.im.bean.message.a.m0(r100);
    L8:
        if (StringsKt.contains$default(r101, "#", false, 2, null) != true) goto L10;
        r102 = true;
        goto L11
    }

    public static boolean g(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (Intrinsics.areEqual(r100.getBizContentType(), "crowd_test_tab") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100.getBizContentType(), "crowd_test_selection") == true) goto L8;
        return false;
    }

    public static boolean h(Message r100) {
        if (r100.isNewBlockType() == true) goto L32;
        String r101 = com.larus.im.bean.message.a.D(r100);
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        return false;
    L13:
        if (r100.getContentType() != 66) goto L34;
        List<Message> r103 = r100.getSubList();
        if (r103 != null) goto L17;
    L20:
        boolean r104 = true;
    L21:
        if (r104 == false) goto L35;
        String r105 = com.larus.im.bean.message.a.O(r100);
        if (r105 != null) goto L25;
    L28:
        boolean r106 = true;
    L29:
        if (r106 == true) goto L36;
        return true;
    L36:
        return false;
    L25:
        if (r105.length() == 0) goto L28;
        r106 = false;
        goto L29
    L35:
        return false;
    L17:
        if (r103.isEmpty() == true) goto L20;
        r104 = false;
        goto L21
    L34:
        return false;
    L7:
        if (StringsKt.isBlank(r101) == true) goto L10;
        r102 = false;
        goto L11
    L32:
        return false;
    }

    public static String j(Message r100) {
        String r101 = com.larus.im.bean.message.a.D(r100);
        String r102 = null;
        if (r101 != null) goto L5;
    L9:
        String r103 = r100.getMessageId();
        if (r103 != null) goto L12;
    L14:
        if (r102 != null) goto L17;
        return o(r100);
    L17:
        return r102;
    L12:
        if ((!StringsKt.isBlank(r103)) == false) goto L14;
        r102 = r103;
        goto L14
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L9;
        return r101;
    }

    public static String n(Message r100) {
        String r101 = com.larus.im.bean.message.a.D(r100);
        boolean r102 = true;
        if (r101 != null) goto L5;
    L10:
        List<Message> r103 = r100.getSubList();
        if (d.x0(r100) == false) goto L22;
        List<Message> r104 = r103;
        if (r104 != null) goto L15;
    L18:
        if (r102 == true) goto L22;
        return r100.getMessageId();
    L15:
        if (r104.isEmpty() == true) goto L18;
        r102 = false;
    L22:
        return null;
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L10;
        return r101;
    }

    public static String o(Message r100) {
        String r101 = r100.getLocalMessageId();
        if (r101 != null) goto L5;
    L9:
        String r102 = r100.getMessageId();
        if (r102 != null) goto L14;
        return "";
    L14:
        return r102;
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L9;
        return r101;
    }

    public static String d(String r100, String r101) {
        return r100 + ':' + r101;
    }

    public static boolean k(String r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "messages");
        if (Intrinsics.areEqual(f468640b, r100) == true) goto L6;
        a(r100);
    L6:
        if (f468646h == false) goto L8;
    L33:
        return false;
    L8:
        if (((ArrayList) r101).isEmpty() == true) goto L33;
        Iterator r102 = r101.iterator();
    L11:
        String r103 = null;
        if (r102.hasNext() == false) goto L27;
        Object r104 = r102.next();
        Message r105 = (Message) r104;
        if (d.G0(r105) == false) goto L16;
    L24:
        boolean r106 = false;
    L25:
        if (r106 == false) goto L11;
    L28:
        Message r107 = (Message) r104;
        if (r107 == null) goto L31;
        r103 = j(r107);
    L31:
        f468647i = r103;
        f468646h = true;
        f468641c++;
        return true;
    L16:
        if (d.O0(r105) == true) goto L24;
        if (d.Y(r105) == true) goto L24;
        if (g(r105) == true) goto L24;
        if (b0.f(r105) == true) goto L24;
        r106 = true;
        goto L25
    L27:
        r104 = null;
        goto L28
    }

    public static void l(Message r100, Message r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        List r102 = CollectionsKt.listOfNotNull(r101);
        if (r101 == null) goto L5;
        List<Message> r103 = r101.getSubList();
    L6:
        if (r103 != null) goto L8;
        r103 = CollectionsKt.emptyList();
    L8:
        List r104 = CollectionsKt.plus(r102, CollectionsKt.filterNotNull(r103));
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r106 = r104.iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        r105.add(o((Message) r106.next()));
        goto L10
    L12:
        Set r107 = CollectionsKt.toSet(r105);
        List r108 = CollectionsKt.listOf(r100);
        List<Message> r109 = r100.getSubList();
        if (r109 != null) goto L15;
        r109 = CollectionsKt.emptyList();
    L15:
        Iterator r110 = CollectionsKt.plus(r108, CollectionsKt.filterNotNull(r109)).iterator();
    L17:
        if (r110.hasNext() == false) goto L27;
        Message r111 = (Message) r110.next();
        f468639a.getClass();
        String r112 = o(r111);
        if (d.G0(r111) == true) goto L17;
        if ((!StringsKt.isBlank(r112)) == false) goto L17;
        if (r107.contains(r112) == true) goto L17;
        if (b0.f(r111) == true) goto L17;
        f468649k.add(r111.getConversationId() + ':' + r112);
        goto L17
    L27:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static Integer m(Message r100, String r101) {
        String r102 = com.larus.im.bean.message.a.D(r100);
        boolean r103 = false;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L16;
        Integer r105 = com.larus.im.bean.message.a.M(r100);
        if (r105 == null) goto L13;
        int r106 = r105.intValue();
    L15:
        return Integer.valueOf(r106);
    L13:
        r106 = w2.a(r101);
        goto L15
    L16:
        List<Message> r107 = r100.getSubList();
        if (d.x0(r100) == false) goto L34;
        List<Message> r108 = r107;
        if (r108 != null) goto L21;
    L24:
        boolean r109 = true;
    L25:
        if (r109 == true) goto L34;
        Integer r110 = Integer.valueOf(w2.a(r101));
        int r111 = r110.intValue();
        if (r111 >= 0) goto L30;
    L32:
        if (r103 == false) goto L34;
        return r110;
    L30:
        if (r111 >= r108.size()) goto L32;
        r103 = true;
        goto L32
    L21:
        if (r108.isEmpty() == true) goto L24;
        r109 = false;
    L34:
        return null;
    L5:
        if (StringsKt.isBlank(r102) == true) goto L8;
        r104 = false;
        goto L9
    }

    public static String i(Message r100, String r101, Integer r102) {
        Message r103 = c(r100);
        if (r103 == null) goto L9;
        String r104 = o(r103);
        if ((!StringsKt.isBlank(r104)) == true) goto L8;
        r104 = null;
    L8:
        if (r104 == null) goto L9;
        return r104;
    L9:
        if (r102 == null) goto L12;
        return r101 + "#pending:" + r102.intValue();
    L12:
        return o(r100);
    }
}
