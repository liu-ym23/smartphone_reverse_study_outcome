package com.larus.browsertakeover.cdp;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.camera.core.CameraInfo;
import androidx.camera.video.AudioStats;
import androidx.core.app.NotificationCompat;
import com.bytedance.ee.space.sync.PushAction$ESubType;
import com.larus.browsertakeover.session.BrowserTakeoverSession;
import com.larus.browsertakeover.transport.BrowserTransport;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.ttvideoengine.model.SubInfo;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import com.ss.ttvideoengine.preRender.PlayBufferManager;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import iv8.a0;
import iv8.b1;
import iv8.d0;
import iv8.e0;
import iv8.f0;
import iv8.h0;
import iv8.o0;
import iv8.r0;
import iv8.s;
import iv8.s0;
import iv8.t;
import iv8.u;
import iv8.u0;
import iv8.v;
import iv8.w;
import iv8.x0;
import iv8.y0;
import iv8.z0;
import java.net.URI;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class BrowserCdpClient {
    public static final Regex N = null;
    public static final Set<String> O = null;
    public static final String P = null;
    public static final String Q = null;
    public static final Set<String> R = null;
    public volatile boolean A;
    public volatile boolean B;
    public volatile boolean C;
    public volatile float D;
    public volatile float E;
    public volatile c F;
    public String G;
    public boolean H;
    public b I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public i f319380J;
    public h K;
    public h L;
    public boolean M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BrowserTransport f319381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f319382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final jv8.a f319383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f319384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ExecutorService f319385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicInteger f319386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicInteger f319387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicInteger f319388h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicInteger f319389i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicInteger f319390j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f319391k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, k> f319392l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f319393m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinkedHashMap<Integer, String> f319394n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f319395o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final HashMap<String, f> f319396p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Object f319397q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.larus.browsertakeover.cdp.b<m> f319398r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f319399s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f319400t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final iv8.f f319401u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile boolean f319402v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile boolean f319403w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile String f319404x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile String f319405y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile String f319406z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/browsertakeover/cdp/BrowserCdpClient$State;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECTING", "ATTACHING", "READY", com.byted.cast.common.bean.State.DISCONNECTED, "ERROR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        public static final State ATTACHING = null;
        public static final State CONNECTING = null;
        public static final State DISCONNECTED = null;
        public static final State ERROR = null;
        public static final State READY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f319407a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f319408b = null;

        public static EnumEntries<State> getEntries() {
            return f319408b;
        }

        static {
            State r100 = new State("CONNECTING", 0);
            CONNECTING = r100;
            State r101 = new State("ATTACHING", 1);
            ATTACHING = r101;
            State r102 = new State("READY", 2);
            READY = r102;
            State r103 = new State(com.byted.cast.common.bean.State.DISCONNECTED, 3);
            DISCONNECTED = r103;
            State r104 = new State("ERROR", 4);
            ERROR = r104;
            State[] r105 = {r100, r101, r102, r103, r104};
            f319407a = r105;
            f319408b = EnumEntriesKt.enumEntries(r105);
        }

        public static State[] values() {
            return (State[]) f319407a.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f319409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f319410b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f319411c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f319412d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f319413e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f319414f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f319415g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f319416h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f319417i;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f319409a, r101.f319409a) == true) goto L12;
            return false;
        L12:
            if (this.f319410b == r101.f319410b) goto L15;
            return false;
        L15:
            if (this.f319411c == r101.f319411c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f319412d, r101.f319412d) == true) goto L21;
            return false;
        L21:
            if (Float.compare(this.f319413e, r101.f319413e) == 0) goto L24;
            return false;
        L24:
            if (Float.compare(this.f319414f, r101.f319414f) == 0) goto L27;
            return false;
        L27:
            if (Float.compare(this.f319415g, r101.f319415g) == 0) goto L30;
            return false;
        L30:
            if (Float.compare(this.f319416h, r101.f319416h) == 0) goto L33;
            return false;
        L33:
            if (this.f319417i == r101.f319417i) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((((((((((this.f319409a.hashCode() * 31) + this.f319410b) * 31) + this.f319411c) * 31) + this.f319412d.hashCode()) * 31) + Float.floatToIntBits(this.f319413e)) * 31) + Float.floatToIntBits(this.f319414f)) * 31) + Float.floatToIntBits(this.f319415g)) * 31) + Float.floatToIntBits(this.f319416h)) * 31;
            if (this.f319417i == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "EncodedFrame(data=" + this.f319409a + ", connectionGeneration=" + this.f319410b + ", pageGeneration=" + this.f319411c + ", targetSessionId=" + this.f319412d + ", deviceWidth=" + this.f319413e + ", deviceHeight=" + this.f319414f + ", offsetTop=" + this.f319415g + ", pageScaleFactor=" + this.f319416h + ", fromVideo=" + this.f319417i + ')';
        }

        public b(String r100, int r101, int r102, String r103, float r104, float r105, float r106, float r107, boolean r110) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Intrinsics.checkNotNullParameter(r103, "targetSessionId");
            this.f319409a = r100;
            this.f319410b = r101;
            this.f319411c = r102;
            this.f319412d = r103;
            this.f319413e = r104;
            this.f319414f = r105;
            this.f319415g = r106;
            this.f319416h = r107;
            this.f319417i = r110;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f319418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f319419b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f319420c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f319421d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f319418a == r101.f319418a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f319419b, r101.f319419b) == true) goto L15;
            return false;
        L15:
            if (Float.compare(this.f319420c, r101.f319420c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.f319421d, r101.f319421d) == 0) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f319418a * 31) + this.f319419b.hashCode()) * 31) + Float.floatToIntBits(this.f319420c)) * 31) + Float.floatToIntBits(this.f319421d);
        }

        public final String toString() {
            return "ExpectedScreencastGeometry(pageGeneration=" + this.f319418a + ", targetSessionId=" + this.f319419b + ", width=" + this.f319420c + ", height=" + this.f319421d + ')';
        }

        public c(int r100, String r101, float r102, float r103) {
            Intrinsics.checkNotNullParameter(r101, "targetSessionId");
            this.f319418a = r100;
            this.f319419b = r101;
            this.f319420c = r102;
            this.f319421d = r103;
        }
    }

    public interface d {
        void OH(String r100);

        void R50(Bitmap r100, float r101, float r102, float r103);

        void iu(String r100);

        void ko(l r100);

        void m70(i r100);

        void pW(String r100, String r101);

        void v30(State r100);
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f319422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f319423b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (this.f319422a == r101.f319422a) goto L12;
            return false;
        L12:
            if (this.f319423b == r101.f319423b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f319422a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f319423b;
            return r101 + ((int) (r102 ^ (r102 >>> 32)));
        }

        public final String toString() {
            return "count=" + this.f319422a + " suppressed=" + this.f319423b;
        }

        public e(long r100, long r101) {
            this.f319422a = r100;
            this.f319423b = r101;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f319424a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f319425b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f319426c;

        public f() {
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Integer f319427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f319428b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f319429c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (Intrinsics.areEqual(this.f319427a, r101.f319427a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f319428b, r101.f319428b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f319429c, r101.f319429c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.f319427a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.f319428b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f319429c;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "NavigationHistory(previousId=" + this.f319427a + ", nextId=" + this.f319428b + ", currentUrl=" + this.f319429c + ')';
        }

        public g(Integer r100, Integer r101, String r102) {
            this.f319427a = r100;
            this.f319428b = r101;
            this.f319429c = r102;
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f319430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f319431b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f319432c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            h r101 = (h) r100;
            if (Intrinsics.areEqual(this.f319430a, r101.f319430a) == true) goto L12;
            return false;
        L12:
            if (this.f319431b == r101.f319431b) goto L15;
            return false;
        L15:
            if (this.f319432c == r101.f319432c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f319430a.hashCode() * 31) + this.f319431b) * 31;
            if (this.f319432c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "NavigationRequest(page=" + this.f319430a + ", revision=" + this.f319431b + ", action=" + this.f319432c + ')';
        }

        public h(j r100, int r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "page");
            this.f319430a = r100;
            this.f319431b = r101;
            this.f319432c = r102;
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f319433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f319434b;

        public i() {
            this(false, false);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L8;
            return false;
        L8:
            i r101 = (i) r100;
            if (this.f319433a == r101.f319433a) goto L12;
            return false;
        L12:
            if (this.f319434b == r101.f319434b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f319433a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f319434b == true) goto L11;
            r100 = 1237;
        L11:
            return r102 + r100;
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "NavigationState(canGoBack=" + this.f319433a + ", canGoForward=" + this.f319434b + ')';
        }

        public i(boolean r100, boolean r101) {
            this.f319433a = r100;
            this.f319434b = r101;
        }
    }

    public static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f319435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f319436b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f319437c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j) == true) goto L8;
            return false;
        L8:
            j r101 = (j) r100;
            if (this.f319435a == r101.f319435a) goto L12;
            return false;
        L12:
            if (this.f319436b == r101.f319436b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f319437c, r101.f319437c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f319435a * 31) + this.f319436b) * 31) + this.f319437c.hashCode();
        }

        public final String toString() {
            return "PageToken(connectionGeneration=" + this.f319435a + ", pageGeneration=" + this.f319436b + ", targetSessionId=" + this.f319437c + ')';
        }

        public j(int r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "targetSessionId");
            this.f319435a = r100;
            this.f319436b = r101;
            this.f319437c = r102;
        }
    }

    public static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f319438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f319439b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f319440c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f319441d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Function1<JSONObject, Unit> f319442e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Set<Integer> f319443f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof k) == true) goto L8;
            return false;
        L8:
            k r101 = (k) r100;
            if (Intrinsics.areEqual(this.f319438a, r101.f319438a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f319439b, r101.f319439b) == true) goto L15;
            return false;
        L15:
            if (this.f319440c == r101.f319440c) goto L18;
            return false;
        L18:
            if (this.f319441d == r101.f319441d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f319442e, r101.f319442e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f319443f, r101.f319443f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f319438a.hashCode() * 31;
            String r101 = this.f319439b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((r100 + r103) * 31) + this.f319440c) * 31;
            if (this.f319441d == false) goto L9;
            int r105 = 1231;
        L10:
            int r106 = (((r104 + r105) * 31) + this.f319442e.hashCode()) * 31;
            Set<Integer> r107 = this.f319443f;
            if (r107 == null) goto L15;
            r102 = r107.hashCode();
        L15:
            return r106 + r102;
        L9:
            r105 = 1237;
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "PendingCommand(method=" + this.f319438a + ", targetSessionId=" + this.f319439b + ", pageGeneration=" + this.f319440c + ", allowStalePageGeneration=" + this.f319441d + ", callback=" + this.f319442e + ", retryIds=" + this.f319443f + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public k(String r100, String r101, int r102, boolean r103, Function1<? super JSONObject, Unit> r104, Set<Integer> r105) {
            Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
            Intrinsics.checkNotNullParameter(r104, "callback");
            this.f319438a = r100;
            this.f319439b = r101;
            this.f319440c = r102;
            this.f319441d = r103;
            this.f319442e = r104;
            this.f319443f = r105;
        }
    }

    public static final class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f319444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f319445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f319446c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f319447d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f319448e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f319449f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f319450g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof l) == true) goto L8;
            return false;
        L8:
            l r101 = (l) r100;
            if (this.f319444a == r101.f319444a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f319445b, r101.f319445b) == true) goto L15;
            return false;
        L15:
            if (this.f319446c == r101.f319446c) goto L18;
            return false;
        L18:
            if (this.f319447d == r101.f319447d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f319448e, r101.f319448e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f319449f, r101.f319449f) == true) goto L27;
            return false;
        L27:
            if (this.f319450g == r101.f319450g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f319444a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = ((r101 * 31) + this.f319445b.hashCode()) * 31;
            if (this.f319446c == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (r102 + r103) * 31;
            if (this.f319447d == true) goto L15;
            r100 = 1237;
        L15:
            return ((((((r104 + r100) * 31) + this.f319448e.hashCode()) * 31) + this.f319449f.hashCode()) * 31) + this.f319450g;
        L9:
            r103 = 1237;
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "RemoteEditableFocus(editable=" + this.f319444a + ", inputMode=" + this.f319445b + ", isPassword=" + this.f319446c + ", multiline=" + this.f319447d + ", enterKeyHint=" + this.f319448e + ", focusSerial=" + this.f319449f + ", inspectionId=" + this.f319450g + ')';
        }

        public l(boolean r100, String r101, boolean r102, boolean r103, String r104, String r105, int r106) {
            Intrinsics.checkNotNullParameter(r101, "inputMode");
            Intrinsics.checkNotNullParameter(r104, "enterKeyHint");
            Intrinsics.checkNotNullParameter(r105, "focusSerial");
            this.f319444a = r100;
            this.f319445b = r101;
            this.f319446c = r102;
            this.f319447d = r103;
            this.f319448e = r104;
            this.f319449f = r105;
            this.f319450g = r106;
        }

        public /* synthetic */ l(boolean r110, String r111, boolean r112, boolean r113, String r114, String r115, int r116, int r117) {
            if ((r117 & 2) == 0) goto L5;
            String r100 = "text";
        L7:
            if ((r117 & 4) == 0) goto L9;
            boolean r101 = false;
        L11:
            if ((r117 & 8) == 0) goto L13;
            boolean r102 = false;
        L15:
            if ((r117 & 16) == 0) goto L17;
            String r103 = "";
        L19:
            if ((r117 & 32) == 0) goto L21;
            String r104 = "";
        L23:
            if ((r117 & 64) == 0) goto L25;
            int r105 = 0;
        L26:
            this(r110, r100, r101, r102, r103, r104, r105);
            return;
        L25:
            r105 = r116;
            goto L26
        L21:
            r104 = r115;
            goto L23
        L17:
            r103 = r114;
            goto L19
        L13:
            r102 = r113;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }
    }

    public static final class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f319451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f319452b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof m) == true) goto L8;
            return false;
        L8:
            m r101 = (m) r100;
            if (Intrinsics.areEqual(this.f319451a, r101.f319451a) == true) goto L12;
            return false;
        L12:
            if (this.f319452b == r101.f319452b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f319451a.hashCode() * 31) + this.f319452b;
        }

        public final String toString() {
            return "RemoteInputToken(page=" + this.f319451a + ", generation=" + this.f319452b + ')';
        }

        public m(j r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "page");
            this.f319451a = r100;
            this.f319452b = r101;
        }
    }

    static {
        N = new Regex("[A-Za-z][A-Za-z0-9_]*\\.[A-Za-z][A-Za-z0-9_]*");
        O = SetsKt.setOf(new String[]{"Runtime.evaluate", "Input.insertText", "Input.dispatchKeyEvent", "Input.dispatchMouseEvent", "Page.screencastFrame", "Page.screencastFrameAck"});
        P = "(() => {\n  const fallback = {\n    editable: false,\n    inputMode: 'text',\n    password: false,\n    multiline: false,\n    enterKeyHint: ''\n  };\n  const lower = (value, limit) =>\n    typeof value === 'string' && value.length <= limit ? value.toLowerCase() : '';\n  try {\n    let element = document.activeElement;\n    let depth = 0;\n    while (element && depth++ < 32) {\n      if (element.shadowRoot && element.shadowRoot.activeElement) {\n        element = element.shadowRoot.activeElement;\n        continue;\n      }\n      const localName = lower(element.localName, 32);\n      if (localName === 'iframe' || localName === 'frame') {\n        let childDocument = null;\n        try {\n          childDocument = element.contentDocument;\n        } catch (_) {}\n        if (!childDocument || !childDocument.activeElement) return fallback;\n        element = childDocument.activeElement;\n        continue;\n      }\n      break;\n    }\n    if (!element) return fallback;\n\n    const tag = lower(element.localName, 32);\n    const type = lower(element.type, 32) || 'text';\n    const declaredInputMode = lower(element.inputMode, 16);\n    const enterKeyHint = lower(element.enterKeyHint, 16);\n    const textInputTypes = new Set([\n      'text', 'search', 'email', 'password', 'tel', 'url', 'number'\n    ]);\n    const contentEditable = element.isContentEditable ||\n      lower(element.ownerDocument && element.ownerDocument.designMode, 8) === 'on';\n    const editable = !element.disabled && !element.readOnly && (\n      (tag === 'input' && textInputTypes.has(type)) ||\n      tag === 'textarea' ||\n      contentEditable\n    );\n    if (!editable || declaredInputMode === 'none') return fallback;\n\n    let inputMode = declaredInputMode || type || 'text';\n    if ((tag === 'textarea' || contentEditable) && !declaredInputMode) inputMode = 'text';\n    if (type === 'number' && !declaredInputMode) inputMode = 'decimal';\n    let focusSerial = '';\n    try {\n      const stateKey = Symbol.for('larus.cloudBrowserFocusIdentity');\n      let focusState = window[stateKey];\n      if (!focusState || !focusState.ids || typeof focusState.nextId !== 'number' ||\n          typeof focusState.documentId !== 'string') {\n        const documentId = Array.from(crypto.getRandomValues(new Uint32Array(2)),\n          value => value.toString(16).padStart(8, '0')).join('');\n        focusState = { ids: new WeakMap(), nextId: 1, documentId };\n        Object.defineProperty(window, stateKey, {\n          value: focusState,\n          configurable: true\n        });\n      }\n      let focusId = focusState.ids.get(element);\n      if (!focusId) {\n        focusId = focusState.nextId++;\n        focusState.ids.set(element, focusId);\n      }\n      // A new document must not reuse the previous document's numeric focus id.\n      focusSerial = focusState.documentId + ':' + String(focusId);\n    } catch (_) {}\n    return {\n      editable: true,\n      inputMode,\n      password: type === 'password',\n      multiline: tag === 'textarea' || contentEditable,\n      enterKeyHint,\n      focusSerial\n    };\n  } catch (_) {\n    return fallback;\n  }\n})()";
        Q = "(expectedFocusSerial, visibleTop, visibleBottom) => {\n  try {\n    if (!Number.isFinite(visibleTop) || !Number.isFinite(visibleBottom) ||\n        visibleTop < 0 || visibleBottom > 32768 || visibleBottom - visibleTop < 24) return false;\n    const frames = [];\n    let element = document.activeElement;\n    for (let depth = 0; element && depth < 32; depth++) {\n      if (element.shadowRoot && element.shadowRoot.activeElement) {\n        element = element.shadowRoot.activeElement;\n      } else if (element.localName === 'iframe' || element.localName === 'frame') {\n        const child = element.contentDocument;\n        if (!child || !child.activeElement) return false;\n        frames.push(element);\n        element = child.activeElement;\n      } else {\n        break;\n      }\n    }\n    const state = window[Symbol.for('larus.cloudBrowserFocusIdentity')];\n    if (!element || !element.isConnected || !state || !state.ids ||\n        state.documentId + ':' + String(state.ids.get(element)) !== expectedFocusSerial ||\n        element.disabled || element.readOnly || element.inputMode === 'none') return null;\n\n    const contentEditable = element.isContentEditable ||\n      element.ownerDocument.designMode.toLowerCase() === 'on';\n    if (!contentEditable && element.localName !== 'textarea' &&\n        !(element.localName === 'input' &&\n          ['text', 'search', 'email', 'password', 'tel', 'url', 'number'].includes(element.type))) return false;\n    const parent = node => node.parentElement || (node.getRootNode && node.getRootNode().host);\n    const safeRect = rect => rect && Number.isFinite(rect.top) &&\n      Number.isFinite(rect.bottom) && rect.bottom > rect.top;\n\n    // Convert same-origin frame coordinates only when the path is unscaled.\n    // Unknown transforms/zoom fail closed instead of scrolling the wrong area.\n    for (const frame of frames) {\n      const rect = frame.getBoundingClientRect();\n      if (Math.abs(rect.width - frame.offsetWidth) > 1 ||\n          Math.abs(rect.height - frame.offsetHeight) > 1) return false;\n    }\n    const topOffset = doc => {\n      let offset = 0;\n      for (let i = frames.length - 1; doc !== document && i >= 0; i--) {\n        const frame = frames[i];\n        if (frame.contentDocument !== doc) continue;\n        offset += frame.getBoundingClientRect().top + frame.clientTop;\n        doc = frame.ownerDocument;\n      }\n      return doc === document ? offset : NaN;\n    };\n    const targetRect = () => {\n      let rect = element.getBoundingClientRect();\n      if (contentEditable) {\n        const selection = element.ownerDocument.defaultView.getSelection();\n        if (selection && selection.focusNode && element.contains(selection.focusNode)) {\n          const caret = element.ownerDocument.createRange();\n          caret.setStart(selection.focusNode, selection.focusOffset);\n          caret.collapse(true);\n          const caretRect = caret.getBoundingClientRect();\n          if (safeRect(caretRect)) rect = caretRect;\n        }\n      }\n      if (!safeRect(rect)) return null;\n      const offset = topOffset(element.ownerDocument);\n      return { top: rect.top + offset, bottom: rect.bottom + offset };\n    };\n    const delta = (rect, top, bottom) => {\n      if (!safeRect(rect) || !Number.isFinite(top) || !Number.isFinite(bottom) || bottom <= top) return 0;\n      if (rect.bottom - rect.top > bottom - top) {\n        // A tall textarea has no reliable DOM caret rect. Keep an already\n        // visible portion stable instead of alternately aligning its edges.\n        if (rect.bottom > top && rect.top < bottom) return 0;\n        return rect.top >= bottom ? rect.top - bottom + Math.min(24, bottom - top) :\n          rect.bottom - top - Math.min(24, bottom - top);\n      }\n      return rect.top < top ? rect.top - top : rect.bottom > bottom ? rect.bottom - bottom : 0;\n    };\n    const visibleBand = (top, bottom) => {\n      const clippedTop = Math.max(top, visibleTop);\n      const clippedBottom = Math.min(bottom, visibleBottom);\n      // An offscreen frame/container is first scrolled locally, then its\n      // ancestors reveal it. Do not manufacture an inverted visible band.\n      return clippedBottom > clippedTop ? [clippedTop, clippedBottom] : [top, bottom];\n    };\n\n    let node = element;\n    let budget = 96;\n    while (node && budget > 0) {\n      const doc = node.ownerDocument;\n      const view = doc.defaultView;\n      for (let ancestor = node; ancestor && budget-- > 0; ancestor = parent(ancestor)) {\n        const style = view.getComputedStyle(ancestor);\n        if (style.transform !== 'none' || (style.zoom && style.zoom !== '1' && style.zoom !== 'normal')) return false;\n      }\n      if (doc === document) break;\n      node = frames.find(frame => frame.contentDocument === doc);\n    }\n    if (budget <= 0) return false;\n\n    node = element;\n    budget = 96;\n    while (node && budget > 0) {\n      const doc = node.ownerDocument;\n      const view = doc.defaultView;\n      let fixedInDocument = view.getComputedStyle(node).position === 'fixed';\n      for (let ancestor = parent(node); ancestor && budget-- > 0; ancestor = parent(ancestor)) {\n        const style = view.getComputedStyle(ancestor);\n        if (!fixedInDocument && ancestor !== doc.scrollingElement && ancestor.clientHeight > 0 &&\n            ancestor.scrollHeight > ancestor.clientHeight &&\n            ['auto', 'scroll', 'overlay'].includes(style.overflowY)) {\n          const top = ancestor.getBoundingClientRect().top + ancestor.clientTop + topOffset(doc);\n          const band = visibleBand(top, top + ancestor.clientHeight);\n          const amount = delta(targetRect(), band[0], band[1]);\n          if (Math.abs(amount) > 1 && Math.abs(amount) <= 32768) {\n            ancestor.scrollBy({ top: amount, behavior: 'instant' });\n          }\n        }\n        if (style.position === 'fixed') fixedInDocument = true;\n      }\n      const offset = topOffset(doc);\n      const band = doc === document ? [visibleTop, visibleBottom] :\n        visibleBand(offset, offset + view.innerHeight);\n      const amount = delta(targetRect(), band[0], band[1]);\n      if (!fixedInDocument && Math.abs(amount) > 1 && Math.abs(amount) <= 32768) {\n        view.scrollBy({ top: amount, behavior: 'instant' });\n      }\n      if (doc === document) break;\n      node = frames.find(frame => frame.contentDocument === doc);\n    }\n    const finalRect = targetRect();\n    let clipTop = visibleTop;\n    let clipBottom = visibleBottom;\n    node = element;\n    budget = 96;\n    while (node && budget > 0) {\n      const doc = node.ownerDocument;\n      for (let ancestor = parent(node); ancestor && budget-- > 0; ancestor = parent(ancestor)) {\n        if (ancestor === doc.scrollingElement ||\n            !['auto', 'scroll', 'overlay', 'hidden', 'clip'].includes(\n              doc.defaultView.getComputedStyle(ancestor).overflowY)) continue;\n        const top = ancestor.getBoundingClientRect().top + ancestor.clientTop + topOffset(doc);\n        clipTop = Math.max(clipTop, top);\n        clipBottom = Math.min(clipBottom, top + ancestor.clientHeight);\n      }\n      if (doc === document) break;\n      const offset = topOffset(doc);\n      clipTop = Math.max(clipTop, offset);\n      clipBottom = Math.min(clipBottom, offset + doc.defaultView.innerHeight);\n      node = frames.find(frame => frame.contentDocument === doc);\n    }\n    return budget > 0 && clipBottom > clipTop && safeRect(finalRect) &&\n      Math.abs(delta(finalRect, clipTop, clipBottom)) <= 1;\n  } catch (_) {\n    // Cross-origin/closed roots or disappearing DOM cannot safely be adjusted.\n    return false;\n  }\n}";
        R = SetsKt.setOf(new String[]{"Target.getTargets", "Target.attachToTarget", "Page.enable", "Page.startScreencast"});
    }

    public final void P() {
        final int r100 = this.f319391k.incrementAndGet();
        K(new s0(r100, this));
    }

    public final void Q() {
        this.f319389i.incrementAndGet();
        c(false, false);
        this.f319388h.incrementAndGet();
        t();
        this.F = null;
        this.f319404x = null;
        this.f319405y = null;
        this.f319406z = null;
        this.D = 1.0f;
        this.E = 1.0f;
        c0(false);
    }

    public final void W() {
        if (this.f319399s == false) goto L5;
        return;
    L5:
        if (this.f319398r.b() == 0) goto L14;
        this.f319399s = true;
        long r100 = SystemClock.elapsedRealtime();
        long r101 = RangesKt.coerceAtLeast((this.f319400t + 50) - r100, 0);
        if (r101 != 0) goto L10;
        this.f319384d.post(this.f319401u);
        return;
    L10:
        this.f319384d.postDelayed(this.f319401u, r101);
        return;
    }

    public final JSONObject X() {
        return new JSONObject().put(SubInfo.KEY_FORMAT, LoadParams.ImageFormat.JPEG).put(GearStrategyConsts.EV_QUALITY, this.f319383c.f500585c).put("maxWidth", this.f319383c.f500583a).put("maxHeight", this.f319383c.f500584b).put("everyNthFrame", 1);
    }

    public final j d() {
        String r100 = this.f319404x;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (this.A == true) goto L9;
        return null;
    L9:
        return new j(this.f319387g.get(), this.f319388h.get(), r100);
    }

    public final void f() {
        Object r100 = this.f319397q;
        monitor-enter(r100);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (this.C == true) goto L7;
    L18:
        monitor-exit(r100);
        return;
    L7:
        if (this.H == true) goto L18;
        b r101 = this.I;     // Catch: Throwable -> L20
        if (r101 != null) goto L14;
        monitor-exit(r100);
        return;
    L14:
        this.I = null;     // Catch: Throwable -> L20
        this.H = true;     // Catch: Throwable -> L20
        monitor-exit(r100);
        e(r101);
    }

    public final void g() {
        String r100 = this.f319404x;
        if (this.f319402v == false) goto L10;
        if (r100 == null) goto L10;
        if (n() == true) goto L8;
    L9:
        Y(this, "Page.stopScreencast", new JSONObject(), r100, false, null, 24);
        goto L10
    L8:
        if (this.B == true) goto L9;
    L10:
        this.f319387g.incrementAndGet();
        this.f319402v = false;
        this.f319392l.clear();
        LinkedHashMap<Integer, String> r101 = this.f319394n;
        monitor-enter(r101);
        this.f319394n.clear();     // Catch: Throwable -> L24
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r101);
        Object r103 = this.f319397q;
        monitor-enter(r103);
        this.I = null;     // Catch: Throwable -> L21
        monitor-exit(r103);
        Q();
        this.G = null;
        this.f319381a.disconnect();
        return;
    L21:
        th = move-exception;
        throw th;
    L24:
        th = move-exception;
        throw th;
    }

    public final boolean n() {
        if (this.f319381a.a() != BrowserTransport.FrameSource.RTP_CDP) goto L5;
        return true;
    L5:
        return false;
    }

    public final void t() {
        int r100 = this.f319390j.incrementAndGet();
        l r110 = new l(false, null, false, false, null, null, r100, 62);
        this.f319384d.post(new h0(r100, this, null, r110));
    }

    public final boolean y() {
        if (this.f319381a.c() != BrowserTransport.EndpointMode.PAGE) goto L5;
        return true;
    L5:
        return false;
    }

    public static String S(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        return CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN;
    L11:
        if (r100.length() <= 128) goto L13;
    L15:
        return "<invalid>";
    L13:
        if (N.matches(r100) == false) goto L15;
        return r100;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static boolean z(JSONObject r100) {
        if (Intrinsics.areEqual(r100.optString("type"), "page") == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r100.optString(PushAction$ESubType.KEY_NAME), PlayBufferManager.PRERENDER_KEY) == false) goto L7;
        return false;
    L7:
        if (StringsKt.startsWith$default(r100.optString("url"), "devtools://", false, 2, null) == true) goto L12;
        return true;
    L12:
        return false;
    }

    public final void H(final String r100) {
        final int r101 = this.f319387g.get();
        this.f319384d.post(new t(this, r101, r100));
    }

    public final void J(final State r100) {
        final int r101 = this.f319387g.get();
        this.f319384d.post(new w(this, r101, r100));
    }

    public final void K(final Function0<Unit> r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        this.f319384d.post(new iv8.k(r100));
    }

    public final void L(i r100) {
        if (this.f319403w == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.f319380J, r100) == true) goto L10;
        this.f319380J = r100;
        this.f319382b.m70(r100);
        return;
    }

    public final k N(int r100) {
        Object r101 = this.f319393m;
        monitor-enter(r101);
        k r102 = this.f319392l.remove(Integer.valueOf(r100));     // Catch: Throwable -> L16
        if (r102 == null) goto L13;
        Set<Integer> r103 = r102.f319443f;     // Catch: Throwable -> L16
        if (r103 == null) goto L14;
        Iterator<T> r104 = r103.iterator();     // Catch: Throwable -> L16
    L10:
        if (r104.hasNext() == false) goto L14;
        int r105 = ((Number) r104.next()).intValue();     // Catch: Throwable -> L16
        this.f319392l.remove(Integer.valueOf(r105));     // Catch: Throwable -> L16
    L14:
        monitor-exit(r101);
        return r102;
    L13:
        r102 = null;
    L16:
        th = move-exception;
        throw th;
    }

    public final void O(final h r100) {
        Z(r100, "Runtime.evaluate", new JSONObject().put("expression", "window.location.href").put("returnByValue", true).put(NotificationCompat.GROUP_KEY_SILENT, true), new u0(this, r100));
    }

    public final e T(String r110) {
        HashMap<String, f> r100 = this.f319396p;
        monitor-enter(r100);
        f r101 = this.f319396p.get(r110);     // Catch: Throwable -> L22
        if (r101 == null) goto L7;
    L14:
        long r102 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L22
        long r103 = r101.f319424a + 1;     // Catch: Throwable -> L22
        r101.f319424a = r103;     // Catch: Throwable -> L22
        if (r103 > 1) goto L17;
    L19:
        e r111 = new e(r103, r101.f319425b);     // Catch: Throwable -> L22
        r101.f319425b = 0;     // Catch: Throwable -> L22
        r101.f319426c = r102;     // Catch: Throwable -> L22
    L20:
        monitor-exit(r100);
        return r111;
    L17:
        if ((r102 - r101.f319426c) >= 5000) goto L19;
        r101.f319425b++;     // Catch: Throwable -> L22
        r111 = null;
        goto L20
    L7:
        if (this.f319396p.size() < 63) goto L10;
        r110 = "other";
    L10:
        HashMap<String, f> r104 = this.f319396p;     // Catch: Throwable -> L22
        f r105 = r104.get(r110);     // Catch: Throwable -> L22
        if (r105 != null) goto L13;
        r105 = new f();     // Catch: Throwable -> L22
        r104.put(r110, r105);     // Catch: Throwable -> L22
    L13:
        r101 = r105;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public final void U(final boolean r100) {
        final j r101 = d();
        if (r101 != null) goto L5;
        return;
    L5:
        K(new a0(this, r101, r100));
    }

    public final void b0(RemoteInputCommand.Key r100) {
        if (this.A == true) goto L5;
        return;
    L5:
        a0(this, "Input.dispatchKeyEvent", A(r100, RemoteInputCommand.Phase.DOWN));
        a0(this, "Input.dispatchKeyEvent", A(r100, RemoteInputCommand.Phase.UP));
    }

    public final void c0(boolean r100) {
        this.A = r100;
        if (r100 == true) goto L13;
        P();
        this.B = false;
        this.C = false;
        Object r101 = this.f319397q;
        monitor-enter(r101);
        this.I = null;     // Catch: Throwable -> L10
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r101);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void e(final b r100) {
        this.f319385e.execute(new x0(r100, this));     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e r101 = T("frame_decode_rejected:decoder_executor_rejected");
        if (r101 == null) goto L8;
        FLogger.f375446a.i("BrowserCdpClient", "client=" + this.f319395o + " generation=" + this.f319387g.get() + " event=frame_decode_rejected reasons=decoder_executor_rejected frameConnectionGeneration=" + r100.f319410b + " framePageGeneration=" + r100.f319411c + ' ' + r101);
    L8:
        monitor-enter(this.f319397q);
        this.I = null;     // Catch: Throwable -> L13
        this.H = false;     // Catch: Throwable -> L13
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void k(final int r100) {
        Y(this, "Target.getTargets", new JSONObject(), null, false, new u(r100, this), 12);
    }

    public final void p(JSONObject r100) {
        String r101 = null;
        if (r100 == null) goto L9;
        String r102 = r100.optString("targetId");
        if (r102 == null) goto L9;
        if ((!StringsKt.isBlank(r102)) == false) goto L9;
        r101 = r102;
    L9:
        if (r101 != null) goto L11;
    L15:
        FLogger.f375446a.e("BrowserCdpClient", "cloud browser target crashed");
        G("cdp", "target_crashed");
        Q();
        J(State.ERROR);
        return;
    L11:
        if (Intrinsics.areEqual(r101, this.f319405y) == true) goto L15;
        if (Intrinsics.areEqual(r101, this.f319406z) == true) goto L15;
    }

    public final boolean v(j r100) {
        if (r100.f319435a == this.f319387g.get()) goto L5;
    L11:
        return false;
    L5:
        if (r100.f319436b != this.f319388h.get()) goto L11;
        if (Intrinsics.areEqual(r100.f319437c, this.f319404x) == false) goto L11;
        if (this.A == false) goto L11;
        return true;
    }

    public final boolean x(h r100) {
        if (this.K == r100) goto L5;
    L9:
        return false;
    L5:
        if (r100.f319431b != this.f319391k.get()) goto L9;
        if (v(r100.f319430a) == false) goto L9;
        return true;
    }

    public static JSONObject A(RemoteInputCommand.Key r100, RemoteInputCommand.Phase r101) {
        return new JSONObject().put("type", r101.getCdpType()).put("key", r100.getKey()).put("code", r100.getCode()).put("windowsVirtualKeyCode", r100.getVirtualKeyCode()).put("nativeVirtualKeyCode", r100.getVirtualKeyCode());
    }

    public static Integer F(JSONObject r100, String r110) {
        Object r101 = r100.opt(r110);
        if ((r101 instanceof Number) == false) goto L5;
        Number r102 = (Number) r101;
    L6:
        if (r102 == null) goto L30;
        Double r103 = Double.valueOf(r102.doubleValue());
        double r104 = r103.doubleValue();
        boolean r105 = false;
        if (Double.isInfinite(r104) == false) goto L10;
    L12:
        boolean r111 = false;
    L13:
        if (r111 == true) goto L15;
    L24:
        if (r105 == true) goto L27;
        r103 = null;
    L27:
        if (r103 != null) goto L29;
        return null;
    L29:
        return Integer.valueOf((int) r103.doubleValue());
    L15:
        if (r104 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L24;
        if (r104 > 2.147483647E9d) goto L24;
        if ((r104 % 1.0d) != AudioStats.AUDIO_AMPLITUDE_NONE) goto L21;
        boolean r112 = true;
    L22:
        if (r112 == false) goto L24;
        r105 = true;
        goto L24
    L21:
        r112 = false;
        goto L22
    L10:
        if (Double.isNaN(r104) == true) goto L12;
        r111 = true;
        goto L13
    L30:
        return null;
    L5:
        r102 = null;
        goto L6
    }

    public static Double m(JSONObject r100, String r101) {
        Object r102 = r100.opt(r101);
        if ((r102 instanceof Number) == false) goto L5;
        Number r103 = (Number) r102;
    L6:
        if (r103 == null) goto L16;
        Double r104 = Double.valueOf(r103.doubleValue());
        double r105 = r104.doubleValue();
        if (Double.isInfinite(r105) == false) goto L10;
    L12:
        boolean r106 = false;
    L13:
        if (r106 == true) goto L15;
        return null;
    L15:
        return r104;
    L10:
        if (Double.isNaN(r105) == true) goto L12;
        r106 = true;
        goto L13
    L16:
        return null;
    L5:
        r103 = null;
        goto L6
    }

    public final void D(String r100, String r101) {
        e r102 = T(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        FLogger.f375446a.d("BrowserCdpClient", "client=" + this.f319395o + " generation=" + this.f319387g.get() + " event=" + r100 + ' ' + r102 + " method=" + S(r101));
    }

    public final void G(final String r100, final String r101) {
        final int r102 = this.f319387g.get();
        this.f319384d.post(new iv8.d(this, r102, r100, r101));
    }

    public final void R(final Function0<Unit> r100, final Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        if (n() == true) goto L7;
        r101.invoke();
        return;
    L7:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L10;
        this.f319384d.post(new iv8.b(this, r100, r101));
        return;
    L10:
        j r102 = d();
        if (r102 != null) goto L13;
        m r103 = null;
    L14:
        if (r103 != null) goto L16;
    L47:
        r101.invoke();
        return;
    L16:
        if (this.f319398r.b() == 0) goto L47;
        com.larus.browsertakeover.cdp.b<m> r104 = this.f319398r;
        monitor-enter(r104);
        Intrinsics.checkNotNullParameter(r101, "action");     // Catch: Throwable -> L44
        if (r100 == null) goto L23;
        boolean r105 = true;
    L24:
        if (r105 == false) goto L26;
    L27:
        if (r105 == true) goto L29;
    L33:
        r104.f319467d.addLast(new com.larus.browsertakeover.cdp.b.AbstractC4136b.a(r103, r101, r100));     // Catch: Throwable -> L44
        r104.f319468e++;     // Catch: Throwable -> L44
        r104.f319469f++;     // Catch: Throwable -> L44
        if (r105 == false) goto L36;
        r104.f319470g++;     // Catch: Throwable -> L44
    L36:
        b1 r106 = new b1(true, 1);     // Catch: Throwable -> L44
        monitor-exit(r104);
    L39:
        if (r106.f495980a == true) goto L42;
        FLogger.f375446a.i("BrowserCdpClient", "client=" + this.f319395o + " generation=" + this.f319387g.get() + " event=input_barrier_rejected pendingUnits=" + this.f319398r.b());
        return;
    L42:
        W();
        return;
    L29:
        if (r104.f319470g < 1) goto L33;
    L30:
        r106 = new b1(false, 0);     // Catch: Throwable -> L44
        monitor-exit(r104);
        goto L39
    L26:
        if ((r104.f319469f - r104.f319470g) >= r104.f319465b) goto L30;
    L23:
        r105 = false;
    L44:
        th = move-exception;
        throw th;
    L13:
        r103 = new m(r102, this.f319389i.get());
        goto L14
    }

    public final h b(j r100, boolean r101) {
        final h r102 = new h(r100, this.f319391k.get(), r101);
        this.K = r102;
        L(new i(false, false));
        this.f319384d.postDelayed(new o0(this, r102), 10000);
        return r102;
    }

    public final void c(boolean r100, boolean r101) {
        com.larus.browsertakeover.cdp.b<m> r102 = this.f319398r;
        monitor-enter(r102);
        ArrayDeque<com.larus.browsertakeover.cdp.b.AbstractC4136b<m>> r103 = r102.f319467d;     // Catch: Throwable -> L26
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L26
        Iterator<com.larus.browsertakeover.cdp.b.AbstractC4136b<m>> r105 = r103.iterator();     // Catch: Throwable -> L26
    L6:
        if (r105.hasNext() == false) goto L15;
        com.larus.browsertakeover.cdp.b.AbstractC4136b<m> r106 = r105.next();     // Catch: Throwable -> L26
        Function0<Unit> r107 = null;
        if ((r106 instanceof com.larus.browsertakeover.cdp.b.AbstractC4136b.a) == false) goto L10;
        com.larus.browsertakeover.cdp.b.AbstractC4136b.a r108 = (com.larus.browsertakeover.cdp.b.AbstractC4136b.a) r106;     // Catch: Throwable -> L26
    L11:
        if (r108 == null) goto L13;
        r107 = r108.f319473c;     // Catch: Throwable -> L26
    L13:
        if (r107 == null) goto L6;
        r104.add(r107);     // Catch: Throwable -> L26
        goto L6
    L10:
        r108 = null;
        goto L11
    L15:
        r102.f319467d.clear();     // Catch: Throwable -> L26
        r102.f319468e = 0;     // Catch: Throwable -> L26
        r102.f319469f = 0;     // Catch: Throwable -> L26
        r102.f319470g = 0;     // Catch: Throwable -> L26
        monitor-exit(r102);
        this.f319384d.removeCallbacks(this.f319401u);
        this.f319399s = false;
        if (r100 == false) goto L20;
        this.f319400t = 0;
    L20:
        if (r101 == false) goto L25;
        Iterator r109 = r104.iterator();
    L23:
        if (r109.hasNext() == false) goto L37;
        ((Function0) r109.next()).invoke();
        goto L23
    L37:
        return;
    L25:
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public final boolean e0(float r100, float r101) {
        if (this.A == true) goto L5;
        return false;
    L5:
        if (Float.isInfinite(r100) == false) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == true) goto L12;
        return false;
    L12:
        if (Float.isInfinite(r101) == false) goto L14;
    L16:
        boolean r103 = false;
    L17:
        if (r103 == true) goto L19;
        return false;
    L19:
        if (r100 >= 0.0f) goto L21;
        return false;
    L21:
        if (r101 >= 0.0f) goto L23;
        return false;
    L23:
        if (r100 <= this.D) goto L25;
        return false;
    L25:
        if (r101 > this.E) goto L34;
        return true;
    L34:
        return false;
    L14:
        if (Float.isNaN(r101) == true) goto L16;
        r103 = true;
        goto L17
    L7:
        if (Float.isNaN(r100) == true) goto L9;
        r102 = true;
        goto L10
    }

    public final void h(final String r100, final Function1<? super m, b1> r101) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
        this.f319384d.post(new iv8.j(this, r100, r101));
        return;
    L6:
        j r102 = d();
        if (r102 != null) goto L9;
        m r103 = null;
    L10:
        if (r103 != null) goto L12;
        return;
    L12:
        b1 r104 = r101.invoke(r103);
        if (r104.f495980a == true) goto L27;
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("client=");
        r106.append(this.f319395o);
        r106.append(" generation=");
        r106.append(this.f319387g.get());
        r106.append(" event=input_queue_rejected kind=");
        r106.append(r100);
        r106.append(" pendingUnits=");
        r106.append(this.f319398r.b());
        r106.append(" barrierPending=");
        com.larus.browsertakeover.cdp.b<m> r107 = this.f319398r;
        monitor-enter(r107);
        if (r107.f319469f <= 0) goto L19;
        boolean r108 = true;
    L20:
        monitor-exit(r107);
        r106.append(r108);
        r105.i("BrowserCdpClient", r106.toString());
        return;
    L19:
        r108 = false;
    L23:
        th = move-exception;
        throw th;
    L27:
        if (r104.f495981b <= 0) goto L32;
        W();
        return;
    L32:
        return;
    L9:
        r103 = new m(r102, this.f319389i.get());
        goto L10
    }

    public final void j(String r100, String r101) {
        FLogger.f375446a.e("BrowserCdpClient", "browser initialization failed, method=" + r100);
        if (Intrinsics.areEqual(r100, "Page.screencastFrame") == false) goto L5;
    L8:
        G(PortraitEngine.LABEL_FIRST_FRAME, "first_frame_timeout");
    L10:
        if (this.B == false) goto L12;
        a0(this, "Page.stopScreencast", new JSONObject());
    L12:
        this.f319392l.clear();
        LinkedHashMap<Integer, String> r102 = this.f319394n;
        monitor-enter(r102);
        this.f319394n.clear();     // Catch: Throwable -> L18
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r102);
        Q();
        J(State.ERROR);
        return;
    L18:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(r100, "RTP.firstFrame") == true) goto L8;
        G("cdp", r101);
        goto L10
    }

    public final void l(h r100, boolean r101) {
        if (x(r100) == true) goto L5;
        return;
    L5:
        this.K = null;
        if (r101 == false) goto L8;
    L9:
        this.M = false;
        U(false);
        return;
    L8:
        if (this.M == true) goto L9;
    }

    public final void q(JSONObject r100, int r101) {
        if (r100 == null) goto L22;
        JSONObject r102 = r100.optJSONObject("targetInfo");
        if (r102 != null) goto L7;
        return;
    L7:
        if (this.A == true) goto L9;
        return;
    L9:
        if (z(r102) == true) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r102.optString("openerId"), this.f319405y) == true) goto L14;
        return;
    L14:
        String r103 = r102.optString("targetId");
        Intrinsics.checkNotNull(r103);
        if ((!StringsKt.isBlank(r103)) == true) goto L18;
        r103 = null;
    L18:
        if (r103 != null) goto L20;
        return;
    L20:
        a(r103, r101, r102.optString("url"));
        return;
    }

    public final void r(final String r110, final int r111) {
        FLogger.f375446a.i("BrowserCdpClient", "CDP page initialization started, endpointMode=" + this.f319381a.c());
        Y(this, "Page.enable", new JSONObject(), r110, false, new v(this, r110, r111), 8);
    }

    public final void u(int r100, j r101) {
        if (r100 == this.f319390j.get()) goto L5;
        return;
    L5:
        if (v(r101) == false) goto L9;
        t();
        return;
    }

    public final boolean w(String r100, int r101) {
        if (this.f319403w == false) goto L5;
    L11:
        return false;
    L5:
        if (this.f319402v == false) goto L11;
        if (r101 != this.f319387g.get()) goto L11;
        if (Intrinsics.areEqual(r100, this.f319404x) == false) goto L11;
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v18, types: [iv8.f] */
    public BrowserCdpClient(BrowserTransport r100, BrowserTakeoverSession.d r101, jv8.a r102) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_TRANSPORT);
        Intrinsics.checkNotNullParameter(r101, "listener");
        Intrinsics.checkNotNullParameter(r102, "captureParameters");
        this.f319381a = r100;
        this.f319382b = r101;
        this.f319383c = r102;
        this.f319384d = new Handler(Looper.getMainLooper());
        this.f319385e = PThreadExecutorsUtils.newSingleThreadExecutor(new iv8.e());
        this.f319386f = new AtomicInteger(1);
        this.f319387g = new AtomicInteger(0);
        this.f319388h = new AtomicInteger(0);
        this.f319389i = new AtomicInteger(0);
        this.f319390j = new AtomicInteger(0);
        this.f319391k = new AtomicInteger(0);
        this.f319392l = new ConcurrentHashMap();
        this.f319393m = new Object();
        this.f319394n = new LinkedHashMap();
        this.f319395o = Integer.toString(System.identityHashCode(this), CharsKt.checkRadix(16));
        this.f319396p = new HashMap();
        this.f319397q = new Object();
        this.f319398r = new com.larus.browsertakeover.cdp.b();
        this.f319401u = new iv8.f(this);
        this.D = 1.0f;
        this.E = 1.0f;
        this.f319380J = new i(false, false);
    }

    public static JSONObject E(String r100, float r101, float r102) {
        return new JSONObject().put("type", r100).put("x", r101).put("y", r102);
    }

    public static void a0(BrowserCdpClient r100, String r101, JSONObject r102) {
        String r103 = r100.f319404x;
        if (r103 == null) goto L7;
        Y(r100, r101, r102, r103, false, null, 8);
        return;
    }

    public final void a(final String r110, final int r111, final String r112) {
        if (Intrinsics.areEqual(r110, this.f319405y) == true) goto L5;
    L7:
        this.f319406z = r110;
        J(State.ATTACHING);
        String r100 = this.f319404x;
        this.f319388h.incrementAndGet();
        this.F = null;
        this.f319404x = null;
        this.f319405y = null;
        c0(false);
        if (r100 == null) goto L10;
        Y(this, "Page.stopScreencast", new JSONObject(), r100, false, null, 24);
        Y(this, "Target.detachFromTarget", new JSONObject().put("sessionId", r100), null, false, null, 28);
    L10:
        Y(this, "Target.attachToTarget", new JSONObject().put("targetId", r110).put("flatten", true), null, true, new f0(r111, this, r110, r112), 4);
        return;
    L5:
        if (this.f319404x == null) goto L7;
    }

    public static void V(final BrowserCdpClient r100, final j r101, Integer r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        final boolean r104 = true;
    L7:
        if ((r103 & 2) == 0) goto L10;
        r101 = null;
    L10:
        if ((r103 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if (r101 != null) goto L16;
        r101 = r100.d();
        if (r101 != null) goto L16;
        return;
    L16:
        if (r102 == null) goto L18;
        final int r105 = r102.intValue();
    L19:
        r100.f319384d.postDelayed(new iv8.c(r100, r105, r101, r104), 140);
        return;
    L18:
        r105 = r100.f319390j.incrementAndGet();
        goto L19
    L5:
        r104 = false;
        goto L7
    }

    public final void I(String r110, final int r111, final String r112, final Integer r113) {
        Object r100 = "";
        final int r101 = this.f319388h.get();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L24
        URI r103 = new URI(r110);     // Catch: Throwable -> L24
        Set r114 = SetsKt.setOf(new String[]{"https", "http"});     // Catch: Throwable -> L24
        String r104 = r103.getScheme();     // Catch: Throwable -> L24
        String r105 = null;
        if (r104 == null) goto L6;
        String r106 = r104.toLowerCase(Locale.US);     // Catch: Throwable -> L24
    L8:
        if (CollectionsKt.contains(r114, r106) == true) goto L10;
    L9:
        r105 = "";
    L22:
        Object r115 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L24
    L27:
        if (Result.m9455isFailureimpl(r115) == true) goto L30;
        r100 = r115;
    L30:
        final String r107 = (String) r100;
        this.f319384d.post(new e0(this, r111, r112, r101, r113, r107));
        return;
    L10:
        String r116 = r103.getHost();     // Catch: Throwable -> L24
        if (r116 == null) goto L20;
        String r117 = r116.toLowerCase(Locale.US);     // Catch: Throwable -> L24
        if (r117 == null) goto L20;
        if (r117.length() > 253) goto L17;
        boolean r108 = true;
    L18:
        if (r108 == false) goto L20;
        r105 = r117;
        goto L20
    L17:
        r108 = false;
    L20:
        if (r105 != null) goto L22;
    L6:
        r106 = null;
    L24:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    }

    public final void M(float r110, float r111, final j r112, final int r113) {
        final AtomicBoolean r100 = new AtomicBoolean(false);
        if (Y(this, "Input.dispatchMouseEvent", E("mouseReleased", r110, r111).put("button", "left").put("buttons", 0).put("clickCount", 1), r112.f319437c, false, new y0(r100, this, r112, r113), 8) == false) goto L5;
    L8:
        this.f319384d.postDelayed(new z0(r100, this, r113, r112), 2000);
        return;
    L5:
        if (r100.compareAndSet(false, true) == false) goto L8;
        u(r113, r112);
    }

    public final void Z(final h r110, String r111, JSONObject r112, final Function1<? super JSONObject, Unit> r113) {
        if (x(r110) == true) goto L6;
        return;
    L6:
        if (this.f319392l.size() < 64) goto L10;
        l(r110, false);
        return;
    L10:
        if (Y(this, r111, r112, r110.f319430a.f319437c, false, new r0(this, r110, r113), 8) == true) goto L13;
        l(r110, false);
        return;
    }

    public final boolean d0(int r110, String r111, JSONObject r112, k r113) {
        if (r113 != null) goto L5;
    L7:
        LinkedHashMap<Integer, String> r100 = this.f319394n;
        monitor-enter(r100);
        Integer r101 = Integer.valueOf(r110);     // Catch: Throwable -> L31
        this.f319394n.put(r101, r111);     // Catch: Throwable -> L31
        if (this.f319394n.size() <= 256) goto L12;
        Iterator<Integer> r102 = this.f319394n.keySet().iterator();     // Catch: Throwable -> L31
        r102.next();     // Catch: Throwable -> L31
        r102.remove();     // Catch: Throwable -> L31
    L12:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r100);
        C(this, "cdp_send", "command", r111, Integer.valueOf(r110), 16);
        if (this.f319381a.send(r112.toString()) == true) goto L29;
        k r114 = N(r110);
        LinkedHashMap<Integer, String> r104 = this.f319394n;
        monitor-enter(r104);
        String r105 = this.f319394n.remove(Integer.valueOf(r110));     // Catch: Throwable -> L26
        monitor-exit(r104);
        B("cdp_send_failed", "command", r111, Integer.valueOf(r110), true);
        if (R.contains(r111) == false) goto L25;
        if (r113 == null) goto L24;
        if (r114 != r113) goto L25;
    L24:
        j(r111, "send_failed");
    L25:
        return false;
    L26:
        th = move-exception;
        throw th;
    L29:
        return true;
    L31:
        th = move-exception;
        throw th;
    L5:
        if (this.f319392l.get(Integer.valueOf(r110)) == r113) goto L7;
        return false;
    }

    public final void o(JSONObject r110, String r111, int r112, boolean r113) {
        if (r110 != null) goto L4;
        return;
    L4:
        if (this.B == false) goto L77;
        int r100 = r110.optInt("sessionId", -1);
        if (r100 >= 0) goto L9;
        return;
    L9:
        if (r113 == true) goto L11;
        Y(this, "Page.screencastFrameAck", new JSONObject().put("sessionId", r100), r111, false, null, 24);
    L11:
        String r101 = r110.optString("data");
        Intrinsics.checkNotNull(r101);
        boolean r102 = false;
        if (r101.length() != 0) goto L14;
        boolean r103 = true;
    L16:
        if (r103 == true) goto L62;
        if (r101.length() > 6291456) goto L62;
        JSONObject r114 = r110.optJSONObject("metadata");
        if (r114 != null) goto L23;
        return;
    L23:
        Double r104 = m(r114, "deviceWidth");
        if (r104 == null) goto L60;
        float r105 = (float) r104.doubleValue();
        Double r106 = m(r114, "deviceHeight");
        if (r106 == null) goto L67;
        float r107 = (float) r106.doubleValue();
        Double r108 = m(r114, "offsetTop");
        if (r108 == null) goto L68;
        float r109 = (float) r108.doubleValue();
        Double r115 = m(r114, "pageScaleFactor");
        if (r115 == null) goto L69;
        float r116 = (float) r115.doubleValue();
        if (1.0f <= r105) goto L34;
    L36:
        boolean r117 = false;
    L37:
        if (r117 == true) goto L39;
        return;
    L39:
        if (1.0f <= r107) goto L41;
    L43:
        if (r102 == true) goto L45;
        return;
    L45:
        if (r109 >= 0.0f) goto L47;
        return;
    L47:
        if (r109 < r107) goto L49;
        return;
    L49:
        if (Math.abs(r116 - 1.0f) > 0.01f) goto L74;
        this.F = new c(this.f319388h.get(), r111, r105, r107);
        b r118 = new b(r101, r112, this.f319388h.get(), r111, r105, r107, r109, r116, r113);
        Object r119 = this.f319397q;
        monitor-enter(r119);
        this.I = r118;     // Catch: Throwable -> L57
        Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L57
        monitor-exit(r119);
        f();
        return;
    L57:
        th = move-exception;
        throw th;
    L74:
        return;
    L41:
        if (r107 > 32768.0f) goto L43;
        r102 = true;
        goto L43
    L34:
        if (r105 > 32768.0f) goto L36;
        r117 = true;
        goto L37
    L69:
        return;
    L68:
        return;
    L67:
        return;
    L60:
        return;
    L62:
        if (r101.length() <= 6291456) goto L76;
        FLogger.f375446a.e("BrowserCdpClient", "dropped oversized frame");
        return;
    L76:
        return;
    L14:
        r103 = false;
        goto L16
    }

    public final void s(final int r110, final j r111, final boolean r112, final boolean r210) {
        if (r110 == this.f319390j.get()) goto L5;
        return;
    L5:
        if (v(r111) == true) goto L7;
        return;
    L7:
        if (this.A == false) goto L13;
        final AtomicBoolean r113 = new AtomicBoolean(false);
        Y(this, "Runtime.evaluate", new JSONObject().put("expression", P).put("returnByValue", true).put("awaitPromise", false).put("userGesture", false).put(NotificationCompat.GROUP_KEY_SILENT, true), r111.f319437c, false, new iv8.h(r110, this, r111, r113, r112), 8);
        this.f319384d.postDelayed(new iv8.i(r113, r110, this, r111, r210), 1500);
        return;
    }

    public final void B(String r100, String r101, String r102, Integer r103, boolean r104) {
        String r105 = S(r102);
        e r106 = null;
        if (O.contains(r105) == false) goto L6;
        String r107 = r105;
    L9:
        if (r107 == null) goto L13;
        r106 = T(r100 + ':' + r101 + ':' + r107);
        if (r106 != null) goto L13;
        return;
    L13:
        StringBuilder r108 = new StringBuilder("client=");
        r108.append(this.f319395o);
        r108.append(" generation=");
        r108.append(this.f319387g.get());
        r108.append(" event=");
        r108.append(r100);
        r108.append(" kind=");
        r108.append(r101);
        r108.append(" id=");
        Object r109 = r103;
        if (r103 != null) goto L16;
        r109 = "-";
    L16:
        r108.append(r109);
        r108.append(" method=");
        r108.append(r105);
        if (r106 == null) goto L19;
        String r110 = " " + r106;
    L20:
        r108.append(r110);
        String r111 = r108.toString();
        if (r104 == false) goto L23;
        FLogger.f375446a.e("BrowserCdpClient", r111);
        return;
    L23:
        if (r106 == null) goto L25;
        FLogger.f375446a.d("BrowserCdpClient", r111);
        return;
    L25:
        FLogger.f375446a.i("BrowserCdpClient", r111);
        return;
    L19:
        r110 = "";
        goto L20
    L6:
        if (StringsKt.startsWith$default(r105, "Input.", false, 2, null) == false) goto L8;
        r107 = "Input.other";
        goto L9
    L8:
        r107 = null;
        goto L9
    }

    public static /* synthetic */ void C(BrowserCdpClient r100, String r101, String r102, String r103, Integer r110, int r111) {
        if ((r111 & 8) == 0) goto L5;
        r110 = null;
    L5:
        r100.B(r101, r102, r103, r110, false);
    }

    public static final void i(AtomicBoolean r100, final BrowserCdpClient r101, final j r102, final int r110, final Function1<? super Boolean, Unit> r111, final boolean r112) {
        if (r100.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        r101.f319384d.post(new d0(r101, r102, r110, r111, r112));
    }

    public static boolean Y(final BrowserCdpClient r110, String r111, JSONObject r112, String r113, boolean r210, Function1 r211, int r212) {
        if ((r212 & 4) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r212 & 8) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r212 & 16) == 0) goto L13;
        Function1 r102 = null;
    L15:
        if (r110.f319402v == true) goto L17;
        return false;
    L17:
        if (r110.f319403w == true) goto L42;
        if (r102 != null) goto L21;
    L23:
        final int r114 = r110.f319386f.getAndIncrement();
        JSONObject r115 = new JSONObject().put("id", r114).put(com.alipay.sdk.m.p.e.f25671s, r111).put("params", r112);
        if (r100 != null) goto L26;
    L28:
        if (r102 == null) goto L38;
        int r103 = r110.f319388h.get();
        if (r110.y() == true) goto L32;
    L34:
        Set r104 = null;
    L35:
        k r105 = new k(r111, r100, r103, r101, r102, r104);
        r110.f319392l.put(Integer.valueOf(r114), r105);
        long r116 = SystemClock.elapsedRealtime() + 10000;
        r110.f319384d.postDelayed(new iv8.a(r110, r114), 10000);
        if (r105.f319443f == null) goto L38;
        r110.f319384d.postDelayed(new s(r110, r110.f319387g.get(), r114, 1, r105, r116), 1000);
        goto L38
    L32:
        if (Intrinsics.areEqual(r111, "Page.enable") == false) goto L34;
        r104 = SetsKt.mutableSetOf(new Integer[]{Integer.valueOf(r114)});
    L38:
        Intrinsics.checkNotNull(r115);
        return r110.d0(r114, r111, r115, null);
    L26:
        if (r110.y() == true) goto L28;
        r115.put("sessionId", r100);
        goto L28
    L21:
        if (r110.f319392l.size() < 64) goto L23;
        FLogger.f375446a.e("BrowserCdpClient", "too many pending CDP commands");
        r110.G("cdp", "pending_command_limit");
        r110.J(State.ERROR);
        return false;
    L42:
        return false;
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
