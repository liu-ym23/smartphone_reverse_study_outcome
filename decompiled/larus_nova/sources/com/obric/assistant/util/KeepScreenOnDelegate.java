package com.obric.assistant.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class KeepScreenOnDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final va8.l f393573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f393574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<TextView> f393575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f393576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<KeepScreenOnReason> f393577e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<KeepScreenOnReason, Long> f393578f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f393579g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f393580h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f393581i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f393582j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<TextView, b> f393583k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<View, c> f393584l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final f1 f393585m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final g1 f393586n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/util/KeepScreenOnDelegate$KeepScreenOnReason;", "", "<init>", "(Ljava/lang/String;I)V", "PageResumeTail", "InputTextTail", "TouchTail", "TtsPlaying", "MessageGenerating", "VoiceVisible", "SpeakerVisible", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum KeepScreenOnReason extends Enum<KeepScreenOnReason> {
        public static final KeepScreenOnReason InputTextTail = null;
        public static final KeepScreenOnReason MessageGenerating = null;
        public static final KeepScreenOnReason PageResumeTail = null;
        public static final KeepScreenOnReason SpeakerVisible = null;
        public static final KeepScreenOnReason TouchTail = null;
        public static final KeepScreenOnReason TtsPlaying = null;
        public static final KeepScreenOnReason VoiceVisible = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KeepScreenOnReason[] f393587a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f393588b = null;

        public static EnumEntries<KeepScreenOnReason> getEntries() {
            return f393588b;
        }

        static {
            KeepScreenOnReason r100 = new KeepScreenOnReason("PageResumeTail", 0);
            PageResumeTail = r100;
            KeepScreenOnReason r101 = new KeepScreenOnReason("InputTextTail", 1);
            InputTextTail = r101;
            KeepScreenOnReason r102 = new KeepScreenOnReason("TouchTail", 2);
            TouchTail = r102;
            KeepScreenOnReason r103 = new KeepScreenOnReason("TtsPlaying", 3);
            TtsPlaying = r103;
            KeepScreenOnReason r104 = new KeepScreenOnReason("MessageGenerating", 4);
            MessageGenerating = r104;
            KeepScreenOnReason r105 = new KeepScreenOnReason("VoiceVisible", 5);
            VoiceVisible = r105;
            KeepScreenOnReason r110 = new KeepScreenOnReason("SpeakerVisible", 6);
            SpeakerVisible = r110;
            KeepScreenOnReason[] r111 = {r100, r101, r102, r103, r104, r105, r110};
            f393587a = r111;
            f393588b = EnumEntriesKt.enumEntries(r111);
        }

        public static KeepScreenOnReason[] values() {
            return (KeepScreenOnReason[]) f393587a.clone();
        }

        public static KeepScreenOnReason valueOf(String r100) {
            return (KeepScreenOnReason) r27.a.a(KeepScreenOnReason.class, r100);
        }

        public KeepScreenOnReason(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f393589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextWatcher f393590b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f393589a, r101.f393589a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f393590b, r101.f393590b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f393589a.hashCode() * 31) + this.f393590b.hashCode();
        }

        public final String toString() {
            return "InputWatcherRegistration(inputViewName=" + this.f393589a + ", watcher=" + this.f393590b + ')';
        }

        public b(String r100, l1 r101) {
            Intrinsics.checkNotNullParameter(r100, "inputViewName");
            Intrinsics.checkNotNullParameter(r101, "watcher");
            this.f393589a = r100;
            this.f393590b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f393591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewTreeObserver f393592b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f393591a, r101.f393591a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f393592b, r101.f393592b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f393591a.hashCode() * 31) + this.f393592b.hashCode();
        }

        public final String toString() {
            return "InputWatcherRescanRegistration(root=" + this.f393591a + ", observer=" + this.f393592b + ')';
        }

        public c(View r100, ViewTreeObserver r101) {
            Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
            Intrinsics.checkNotNullParameter(r101, "observer");
            this.f393591a = r100;
            this.f393592b = r101;
        }
    }

    static {
    }

    public final void b() {
        this.f393579g = true;
        Iterator r100 = CollectionsKt.toList(((LinkedHashMap) this.f393584l).keySet()).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        g((View) r100.next(), MapMonitorConst.EVENT_DESTROY);
        goto L4
    L6:
        Iterator r101 = CollectionsKt.toList(((LinkedHashMap) this.f393583k).keySet()).iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        f((TextView) r101.next());
        goto L8
    L10:
        this.f393576d.removeCallbacksAndMessages(null);
        this.f393577e.clear();
        ((LinkedHashMap) this.f393578f).clear();
        if (this.f393582j == false) goto L15;
        View r102 = this.f393581i;
        if (r102 == null) goto L15;
        i(r102, false, MapMonitorConst.EVENT_DESTROY);
    L15:
        this.f393581i = null;
        this.f393582j = false;
    }

    public final void e() {
        this.f393579g = true;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        b();
        return;
    L5:
        this.f393576d.post(new d1(this));
    }

    public final void c() {
        if (this.f393579g == false) goto L5;
        return;
    L5:
        LinkedHashSet r100 = new LinkedHashSet();
        va8.l r101 = this.f393573a;
        if (r101 == null) goto L10;
        ConstraintLayout r102 = r101.getRootView();
        if (r102 == null) goto L10;
        r100.add(r102);
        r100.add(r102.getRootView());
    L10:
        va8.l r103 = this.f393573a;
        if (r103 == null) goto L15;
        ViewGroup r104 = r103.d();
        if (r104 == null) goto L15;
        r100.add(r104);
    L15:
        va8.l r105 = this.f393573a;
        if (r105 == null) goto L20;
        FrameLayout r106 = r105.getInput();
        if (r106 == null) goto L20;
        r100.add(r106);
    L20:
        Set r107 = ((LinkedHashMap) this.f393584l).keySet();
        ArrayList r108 = new ArrayList();
        Iterator r109 = r107.iterator();
    L22:
        if (r109.hasNext() == false) goto L26;
        Object r110 = r109.next();
        if ((!r100.contains((View) r110)) == false) goto L22;
        r108.add(r110);
        goto L22
    L26:
        Iterator r111 = CollectionsKt.toList(r108).iterator();
    L28:
        if (r111.hasNext() == false) goto L30;
        g((View) r111.next(), "rootRemoved");
        goto L28
    L30:
        Iterator r112 = r100.iterator();
    L32:
        if (r112.hasNext() == false) goto L50;
        View r113 = (View) r112.next();
        ViewTreeObserver r114 = r113.getViewTreeObserver();
        c r115 = (c) ((LinkedHashMap) this.f393584l).get(r113);
        if (r115 == null) goto L40;
        if (r115.f393592b != r114) goto L40;
        if (r114.isAlive() == true) goto L32;
    L40:
        if (r115 == null) goto L47;
        if (r115.f393592b != r114) goto L44;
        String r116 = "observerNotAlive";
    L45:
        g(r113, r116);
        goto L47
    L44:
        r116 = "observerChanged";
    L47:
        if (r114.isAlive() == false) goto L48;
        r114.addOnGlobalLayoutListener(this.f393586n);
        Map<View, c> r117 = this.f393584l;
        Intrinsics.checkNotNull(r114);
        r117.put(r113, new c(r113, r114));
        FLogger.f375446a.i("KeepScreenOnDelegate", "addInputWatcherRescanListenerOnMain, root = " + r113 + ", observer = " + r114);
        goto L32
    L48:
        FLogger.f375446a.i("KeepScreenOnDelegate", "ensureInputWatcherRescanRegistrationOnMain, observer is not alive, root = " + r113);
        goto L32
    }

    public final void d() {
        if (this.f393579g == false) goto L5;
        return;
    L5:
        LinkedHashMap r100 = new LinkedHashMap();
        a(r100, this.f393575c.invoke(), "input_text");
        va8.l r101 = this.f393573a;
        TextView r102 = null;
        if (r101 == null) goto L10;
        ViewGroup r103 = r101.d();
        if (r103 == null) goto L10;
        TextView r104 = (TextView) r103.findViewById(R.id.input_edit);
    L11:
        a(r100, r104, "input_edit");
        va8.l r105 = this.f393573a;
        if (r105 == null) goto L16;
        ConstraintLayout r106 = r105.getRootView();
        if (r106 == null) goto L16;
        TextView r107 = (TextView) r106.findViewById(R.id.input_edit);
    L17:
        a(r100, r107, "input_edit");
        va8.l r108 = this.f393573a;
        if (r108 == null) goto L24;
        ConstraintLayout r109 = r108.getRootView();
        if (r109 == null) goto L24;
        View r110 = r109.getRootView();
        if (r110 == null) goto L24;
        r102 = (TextView) r110.findViewById(R.id.input_edit);
    L24:
        a(r100, r102, "input_edit");
        Set r111 = r100.keySet();
        Set r112 = ((LinkedHashMap) this.f393583k).keySet();
        ArrayList r113 = new ArrayList();
        Iterator r114 = r112.iterator();
    L26:
        if (r114.hasNext() == false) goto L30;
        Object r115 = r114.next();
        if ((!r111.contains((TextView) r115)) == false) goto L26;
        r113.add(r115);
        goto L26
    L30:
        Iterator r116 = CollectionsKt.toList(r113).iterator();
    L32:
        if (r116.hasNext() == false) goto L34;
        f((TextView) r116.next());
        goto L32
    L34:
        Iterator r117 = r100.entrySet().iterator();
    L36:
        if (r117.hasNext() == false) goto L40;
        Map.Entry r118 = (Map.Entry) r117.next();
        TextView r119 = (TextView) r118.getKey();
        String r120 = (String) r118.getValue();
        if (this.f393583k.containsKey(r119) == true) goto L36;
        l1 r121 = new l1(r120, this);
        r119.addTextChangedListener(r121);
        this.f393583k.put(r119, new b(r120, r121));
        FLogger.f375446a.i("KeepScreenOnDelegate", "ensureInputWatchersOnMain, watcher registered, inputViewName = " + r120 + ", inputView = " + r119);
        goto L36
    L40:
        return;
    L16:
        r107 = null;
    L10:
        r104 = null;
        goto L11
    }

    public final void j() {
        c();
        d();
        long r100 = SystemClock.uptimeMillis();
        Map<KeepScreenOnReason, Long> r101 = this.f393578f;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator r103 = ((LinkedHashMap) r101).entrySet().iterator();
    L3:
        boolean r104 = true;
        if (r103.hasNext() == false) goto L11;
        Map.Entry r105 = (Map.Entry) r103.next();
        if (((Number) r105.getValue()).longValue() <= r100) goto L9;
        r104 = false;
    L9:
        if (r104 == false) goto L3;
        r102.put(r105.getKey(), r105.getValue());
        goto L3
    L11:
        ArrayList r106 = new ArrayList(r102.size());
        Iterator r107 = r102.entrySet().iterator();
    L13:
        if (r107.hasNext() == false) goto L15;
        r106.add((KeepScreenOnReason) ((Map.Entry) r107.next()).getKey());
        goto L13
    L15:
        Iterator r108 = r106.iterator();
    L17:
        if (r108.hasNext() == false) goto L19;
        this.f393578f.remove((KeepScreenOnReason) r108.next());
        goto L17
    L19:
        va8.l r109 = this.f393573a;
        if (r109 == null) goto L24;
        ViewGroup r110 = r109.getRootView();
        if (r110 == null) goto L24;
    L28:
        if (r110 != null) goto L30;
    L47:
        String r111 = "syncNotEligible, currentTargetView = " + r110 + ", isWindowHost = " + this.f393574b.invoke().booleanValue() + ", pageResumed = " + this.f393580h;
        if (this.f393582j == false) goto L52;
        View r112 = this.f393581i;
        if (r112 == null) goto L52;
        i(r112, false, r111);
    L52:
        this.f393581i = null;
        this.f393582j = false;
    L53:
        this.f393576d.removeCallbacks(this.f393585m);
        Long r113 = (Long) CollectionsKt.minOrNull(((LinkedHashMap) this.f393578f).values());
        if (r113 == null) goto L64;
        this.f393576d.postDelayed(this.f393585m, RangesKt.coerceAtLeast(r113.longValue() - r100, 0));
        return;
    L64:
        return;
    L30:
        if (this.f393574b.invoke().booleanValue() == true) goto L32;
    L38:
        boolean r114 = false;
    L39:
        if (r114 == false) goto L47;
        View r115 = this.f393581i;
        if (r115 != r110) goto L43;
    L46:
        i(r110, true, "syncEligible");
        this.f393581i = r110;
        this.f393582j = true;
        goto L53
    L43:
        if (this.f393582j == false) goto L46;
        if (r115 == null) goto L46;
        i(r115, false, "targetViewChanged, newTargetView = " + r110);
        goto L46
    L32:
        if (this.f393580h == false) goto L38;
        if ((!this.f393577e.isEmpty()) == false) goto L36;
    L37:
        r114 = true;
        goto L39
    L36:
        if ((!this.f393578f.isEmpty()) == false) goto L38;
    L24:
        va8.l r116 = this.f393573a;
        if (r116 == null) goto L27;
        r110 = r116.d();
        goto L28
    L27:
        r110 = null;
        goto L28
    }

    public final void f(TextView r100) {
        b r101 = this.f393583k.remove(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        FLogger.f375446a.i("KeepScreenOnDelegate", "removeInputWatcherOnMain, inputViewName = " + r101.f393589a + ", inputView = " + r100);
        r100.removeTextChangedListener(r101.f393590b);
    }

    public final void h(final Function0<Unit> r100) {
        if (this.f393579g == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L8;
        r100.invoke();
        return;
    L8:
        this.f393576d.post(new j1(this, r100));
    }

    public final void g(View r100, String r101) {
        c r102 = this.f393584l.remove(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        ViewTreeObserver r103 = r102.f393592b;
        if (r103.isAlive() == false) goto L8;
        r103.removeOnGlobalLayoutListener(this.f393586n);
    L8:
        FLogger.f375446a.i("KeepScreenOnDelegate", "removeInputWatcherRescanListenerOnMain, root = " + r102.f393591a + ", observer = " + r103 + ", observerAlive = " + r103.isAlive() + ", reason = " + r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.obric.assistant.util.f1] */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.obric.assistant.util.g1] */
    public KeepScreenOnDelegate(va8.l r100, Function0<Boolean> r101, Function0<? extends TextView> r102) {
        Intrinsics.checkNotNullParameter(r101, "isWindowHostProvider");
        Intrinsics.checkNotNullParameter(r102, "inputTextViewProvider");
        this.f393573a = r100;
        this.f393574b = r101;
        this.f393575c = r102;
        this.f393576d = new Handler(Looper.getMainLooper());
        this.f393577e = new LinkedHashSet();
        this.f393578f = new LinkedHashMap();
        this.f393583k = new LinkedHashMap();
        this.f393584l = new LinkedHashMap();
        this.f393585m = new f1(this);
        this.f393586n = new g1(this);
        h(new h1(this));
    }

    public static void a(Map r100, TextView r101, String r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r100.containsKey(r101) == true) goto L9;
        r100.put(r101, r102);
        return;
    }

    public final void i(View r100, boolean r101, String r102) {
        FLogger.f375446a.i("KeepScreenOnDelegate", "setKeepScreenOnOnMain, targetView = " + r100 + ", value = " + r101 + ", reason = " + r102 + ", activeReasons = " + this.f393577e + ", tailReasons = " + ((LinkedHashMap) this.f393578f).keySet());
        r100.setKeepScreenOn(r101);
    }
}
