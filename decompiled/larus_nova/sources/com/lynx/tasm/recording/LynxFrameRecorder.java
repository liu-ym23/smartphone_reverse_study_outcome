package com.lynx.tasm.recording;

import android.os.SystemClock;
import android.view.Choreographer;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.lynx.react.bridge.mapbuffer.MapBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.tasm.behavior.s0;
import com.lynx.tasm.behavior.ui.PropBundle;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class LynxFrameRecorder {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final LynxFrameRecorder f383583k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f383584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Integer> f383585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Integer> f383586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Integer> f383587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, c> f383588e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, d> f383589f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Float> f383590g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<Integer, i> f383591h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<Integer, k> f383592i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicInteger f383593j;

    public static final enum ByteReplayMask extends Enum<ByteReplayMask> {
        public static final ByteReplayMask IGNORE = null;
        public static final ByteReplayMask NAME = null;
        public static final ByteReplayMask NONE = null;
        public static final ByteReplayMask STRICT = null;
        public static final ByteReplayMask TRUE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ByteReplayMask[] f383594a = null;

        static {
            ByteReplayMask r100 = new ByteReplayMask(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            ByteReplayMask r101 = new ByteReplayMask("TRUE", 1);
            TRUE = r101;
            ByteReplayMask r102 = new ByteReplayMask("IGNORE", 2);
            IGNORE = r102;
            ByteReplayMask r103 = new ByteReplayMask("NAME", 3);
            NAME = r103;
            ByteReplayMask r104 = new ByteReplayMask("STRICT", 4);
            STRICT = r104;
            f383594a = new ByteReplayMask[]{r100, r101, r102, r103, r104};
        }

        public static ByteReplayMask[] values() {
            return (ByteReplayMask[]) f383594a.clone();
        }

        public static ByteReplayMask valueOf(String r100) {
            return (ByteReplayMask) r27.a.a(ByteReplayMask.class, r100);
        }

        public ByteReplayMask(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f383595a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f383596b = null;

        static {
            int[] r100 = new int[ByteReplayMask.values().length];
            f383596b = r100;
            r100[ByteReplayMask.TRUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L67:
            f383596b[ByteReplayMask.IGNORE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L51:
            f383596b[ByteReplayMask.NAME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L63:
            f383596b[ByteReplayMask.STRICT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L69:
            f383596b[ByteReplayMask.NONE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
        L12:
            int[] r101 = new int[ReadableType.values().length];
            f383595a = r101;
            r101[ReadableType.Null.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L73:
            f383595a[ReadableType.Boolean.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L79:
            f383595a[ReadableType.Int.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L47:
            f383595a[ReadableType.Long.ordinal()] = 4;     // Catch: NoSuchFieldError -> L35
        L57:
            f383595a[ReadableType.Number.ordinal()] = 5;     // Catch: NoSuchFieldError -> L36
        L77:
            f383595a[ReadableType.String.ordinal()] = 6;     // Catch: NoSuchFieldError -> L37
        L45:
            f383595a[ReadableType.Map.ordinal()] = 7;     // Catch: NoSuchFieldError -> L38
        L71:
            f383595a[ReadableType.Array.ordinal()] = 8;     // Catch: NoSuchFieldError -> L39
        L75:
            f383595a[ReadableType.ByteArray.ordinal()] = 9;     // Catch: NoSuchFieldError -> L40
        L59:
            f383595a[ReadableType.ByteBuffer.ordinal()] = 10;     // Catch: NoSuchFieldError -> L41
        L65:
            f383595a[ReadableType.PiperData.ordinal()] = 11;     // Catch: NoSuchFieldError -> L42
        L53:
            f383595a[ReadableType.TemplateData.ordinal()] = 12;     // Catch: NoSuchFieldError -> L43
        L55:
            f383595a[ReadableType.LynxObject.ordinal()] = 13;     // Catch: NoSuchFieldError -> L44
            return;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f383597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f383598b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, Object> f383599c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, Object> f383600d;

        public b() {
            throw null;
        }

        public b(int r100, String r101, Map r102, Map r103) {
            this.f383597a = r100;
            this.f383598b = r101;
            this.f383599c = r102;
            this.f383600d = r103;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f383601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Deque<JSONObject> f383602b;

        public c() {
            this.f383602b = new ArrayDeque();
            this.f383601a = 1024;
        }

        public static void a(c r100, JSONObject r101) {
            monitor-enter(r100);
        L13:
            th = move-exception;
            throw th;
        L4:
            if (r100.f383601a > 0) goto L8;
            monitor-exit(r100);
            return;
        L8:
            if (((ArrayDeque) r100.f383602b).size() < r100.f383601a) goto L10;
            ((ArrayDeque) r100.f383602b).removeFirst();     // Catch: Throwable -> L13
        L10:
            ((ArrayDeque) r100.f383602b).addLast(r101);     // Catch: Throwable -> L13
            monitor-exit(r100);
        }
    }

    public interface d {
        void a(JSONObject r100);
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f383603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f383604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, Object> f383605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, Object> f383606d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f383607e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f383608f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f383609g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f383610h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final float f383611i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final float f383612j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final float[] f383613k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final float[] f383614l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final float[] f383615m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final float[] f383616n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final float[] f383617o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final float f383618p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final String f383619q;

        public e() {
            throw null;
        }

        public e(int r100, String r101, Map r102, Map r103, int r104, int r105, float r106, float r110, float r111, float r112, float[] r113, float[] r114, float[] r115, float[] r116, float[] r117, float r118, String r119) {
            this.f383603a = r100;
            this.f383604b = r101;
            this.f383605c = r102;
            this.f383606d = r103;
            this.f383607e = r104;
            this.f383608f = r105;
            this.f383609g = r106;
            this.f383610h = r110;
            this.f383611i = r111;
            this.f383612j = r112;
            this.f383613k = r113;
            this.f383614l = r114;
            this.f383615m = r115;
            this.f383616n = r116;
            this.f383617o = r117;
            this.f383618p = r118;
            this.f383619q = r119;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f383620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f383621b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, Object> f383622c;

        public f() {
            throw null;
        }

        public f(int r100, String r101, Map r102) {
            this.f383620a = r100;
            this.f383621b = r101;
            this.f383622c = r102;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f383623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f383624b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Integer> f383625c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ByteReplayMask f383626d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f383627e;

        public g() {
            this.f383624b = -1;
            this.f383625c = new ArrayList();
            this.f383626d = ByteReplayMask.NONE;
            this.f383627e = false;
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f383628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f383629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f383630c;

        public h(int r100, int r101, Integer r102) {
            this.f383628a = r100;
            this.f383629b = r101;
            this.f383630c = r102;
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f383631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<p> f383632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f383633c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Choreographer.FrameCallback f383634d;

        public i(int r100) {
            this.f383632b = new ArrayList();
            this.f383633c = false;
            this.f383634d = null;
            this.f383631a = r100;
        }
    }

    public static final class j implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f383635a;

        public j() {
            this.f383635a = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(r100, "lynx-frame-recorder-" + this.f383635a.getAndIncrement());
            ThreadMethodProxy.setPriority(r101, 4);
            return r101;
        }
    }

    public static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f383636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<Integer, g> f383637b;

        public k(int r100) {
            this.f383637b = new HashMap();
            this.f383636a = r100;
        }

        public final void a(int r100) {
            Map<Integer, g> r101 = this.f383637b;
            HashMap r102 = (HashMap) r101;
            g r103 = (g) r102.get(Integer.valueOf(r100));
            if (r103 != null) goto L5;
            return;
        L5:
            Iterator r104 = new ArrayList(r103.f383625c).iterator();
        L7:
            if (r104.hasNext() == false) goto L9;
            a(((Integer) r104.next()).intValue());
            goto L7
        L9:
            b(r100);
            Map<Integer, g> r105 = this.f383637b;
            HashMap r106 = (HashMap) r105;
            r106.remove(Integer.valueOf(r100));
        }

        public final void b(int r100) {
            Map<Integer, g> r101 = this.f383637b;
            HashMap r102 = (HashMap) r101;
            g r103 = (g) r102.get(Integer.valueOf(r100));
            if (r103 == null) goto L12;
            int r104 = r103.f383624b;
            if (r104 < 0) goto L13;
            Map<Integer, g> r105 = this.f383637b;
            HashMap r106 = (HashMap) r105;
            g r107 = (g) r106.get(Integer.valueOf(r104));
            if (r107 == null) goto L10;
            List<Integer> r108 = r107.f383625c;
            ArrayList r109 = (ArrayList) r108;
            r109.remove(Integer.valueOf(r100));
        L10:
            r103.f383624b = -1;
            return;
        L13:
            return;
        }

        public final g d(int r100) {
            Map<Integer, g> r101 = this.f383637b;
            HashMap r102 = (HashMap) r101;
            g r103 = (g) r102.get(Integer.valueOf(r100));
            if (r103 != null) goto L6;
            g r104 = new g();
            Map<Integer, g> r105 = this.f383637b;
            HashMap r106 = (HashMap) r105;
            r106.put(Integer.valueOf(r100), r104);
            return r104;
        L6:
            return r103;
        }

        public final Integer e(int r100) {
            Map<Integer, g> r101 = this.f383637b;
            HashMap r102 = (HashMap) r101;
            g r103 = (g) r102.get(Integer.valueOf(r100));
            if (r103 == null) goto L11;
            int r104 = r103.f383624b;
            if (r104 >= 0) goto L7;
            return null;
        L7:
            if (g(r104) == false) goto L10;
            return null;
        L10:
            return Integer.valueOf(r103.f383624b);
        L11:
            return null;
        }

        public final boolean f(int r100) {
            g r101 = (g) ((HashMap) this.f383637b).get(Integer.valueOf(r100));
            if (r101 != null) goto L5;
        L9:
            boolean r102 = false;
        L10:
            if (r102 == true) goto L49;
            g r103 = (g) ((HashMap) this.f383637b).get(Integer.valueOf(r100));
            if (r103 == null) goto L47;
            String r104 = r103.f383623a;
            LynxFrameRecorder r105 = LynxFrameRecorder.f383583k;
            if ("image".equals(r104) == false) goto L16;
        L25:
            boolean r106 = true;
        L26:
            if (r106 == false) goto L47;
            Integer r107 = Integer.valueOf(r100);
            int r108 = ((HashMap) this.f383637b).size() + 1;
        L28:
            if (r107 == null) goto L42;
            int r109 = r108 - 1;
            if (r108 <= 0) goto L42;
            g r110 = (g) ((HashMap) this.f383637b).get(r107);
            if (r110 == null) goto L42;
            if (r110.f383626d == ByteReplayMask.STRICT) goto L36;
            int r111 = r110.f383624b;
            if (r111 < 0) goto L40;
            r107 = Integer.valueOf(r111);
        L41:
            r108 = r109;
            goto L28
        L40:
            r107 = null;
            goto L41
        L36:
            boolean r112 = true;
        L43:
            if (r112 == false) goto L47;
            if (g(r100) == true) goto L47;
            boolean r113 = true;
        L48:
            if (r113 == true) goto L49;
            return false;
        L42:
            r112 = false;
            goto L43
        L16:
            if ("inline-image".equals(r104) == true) goto L25;
            if ("video".equals(r104) == true) goto L25;
            if ("audio".equals(r104) == true) goto L25;
            if ("x-video-engine".equals(r104) == true) goto L25;
            r106 = false;
        L47:
            r113 = false;
        L49:
            return true;
        L5:
            if (r101.f383626d != ByteReplayMask.IGNORE) goto L9;
            if (g(r100) == true) goto L9;
            r102 = true;
            goto L10
        }

        public final boolean g(int r100) {
            g r101 = (g) ((HashMap) this.f383637b).get(Integer.valueOf(r100));
            if (r101 != null) goto L5;
            return false;
        L5:
            int r102 = r101.f383624b;
            if (r102 < 0) goto L8;
            Integer r103 = Integer.valueOf(r102);
        L9:
            int r104 = ((HashMap) this.f383637b).size() + 1;
        L10:
            if (r103 == null) goto L24;
            int r105 = r104 - 1;
            if (r104 <= 0) goto L24;
            if (f(r103.intValue()) == true) goto L15;
            g r106 = (g) ((HashMap) this.f383637b).get(r103);
            if (r106 == null) goto L18;
            int r107 = r106.f383624b;
            if (r107 < 0) goto L22;
            r103 = Integer.valueOf(r107);
        L23:
            r104 = r105;
            goto L10
        L22:
            r103 = null;
            goto L23
        L18:
            return false;
        L15:
            return true;
        L24:
            return false;
        L8:
            r103 = null;
            goto L9
        }

        public final boolean i(int r100) {
            g r101 = (g) ((HashMap) this.f383637b).get(Integer.valueOf(r100));
            if (r101 != null) goto L5;
        L7:
            if (r101 != null) goto L9;
        L11:
            Integer r102 = Integer.valueOf(r100);
            int r103 = ((HashMap) this.f383637b).size() + 1;
        L13:
            if (r102 == null) goto L29;
            int r104 = r103 - 1;
            if (r103 <= 0) goto L29;
            g r105 = (g) ((HashMap) this.f383637b).get(r102);
            if (r105 == null) goto L29;
            ByteReplayMask r106 = r105.f383626d;
            if (r106 == ByteReplayMask.TRUE) goto L38;
            if (r106 == ByteReplayMask.STRICT) goto L39;
            int r107 = r105.f383624b;
            if (r107 < 0) goto L27;
            r102 = Integer.valueOf(r107);
        L28:
            r103 = r104;
            goto L13
        L27:
            r102 = null;
            goto L28
        L39:
            return true;
        L38:
            return true;
        L29:
            return false;
        L9:
            if (r101.f383626d != ByteReplayMask.NAME) goto L11;
            return true;
        L5:
            if (r101.f383627e == false) goto L7;
            return true;
        }

        public final Map<String, Object> c(int r110, Map<String, Object> r111) {
            Map<Integer, g> r100 = this.f383637b;
            HashMap r101 = (HashMap) r100;
            g r112 = (g) r101.get(Integer.valueOf(r110));
            LynxFrameRecorder r102 = LynxFrameRecorder.f383583k;
            if (r111 != null) goto L11;
            if (r112 != null) goto L6;
            ByteReplayMask r113 = ByteReplayMask.NONE;
        L7:
            String r114 = LynxFrameRecorder.f(r113);
            if (r114 != null) goto L10;
            return null;
        L10:
            LinkedHashMap r115 = new LinkedHashMap();
            r115.put("lynx-data-bytereplay-mask", r114);
            LinkedHashMap r116 = new LinkedHashMap();
            r116.put(SlcElement.KEY_PROPS, Collections.unmodifiableMap(r115));
            return Collections.unmodifiableMap(r116);
        L6:
            r113 = r112.f383626d;
            goto L7
        L11:
            LinkedHashMap r103 = new LinkedHashMap(r111);
            Map<String, Object> r117 = LynxFrameRecorder.h(r111);
            if (r117 == null) goto L51;
            LinkedHashMap r104 = new LinkedHashMap();
            Iterator<Map.Entry<String, Object>> r118 = r117.entrySet().iterator();
        L15:
            if (r118.hasNext() == false) goto L41;
            Map.Entry<String, Object> r105 = r118.next();
            String r106 = r105.getKey();
            Object r107 = r105.getValue();
            boolean r108 = true;
            if (LynxFrameRecorder.j(r106) == false) goto L19;
        L34:
            if (r108 == true) goto L36;
            r104.put(r106, r107);
            goto L15
        L36:
            if ((r107 instanceof CharSequence) == false) goto L38;
            String r109 = LynxFrameRecorder.m(String.valueOf(r107));
        L39:
            r104.put(r106, r109);
            goto L15
        L38:
            r109 = "*";
            goto L39
        L19:
            if ("src".equals(r106) == false) goto L21;
        L30:
            boolean r119 = true;
        L31:
            if (r119 == true) goto L34;
            r108 = false;
            goto L34
        L21:
            if ("source".equals(r106) == true) goto L30;
            if ("url".equals(r106) == true) goto L30;
            if ("uri".equals(r106) == true) goto L30;
            if ("poster".equals(r106) == true) goto L30;
            r119 = false;
            goto L31
        L41:
            if (r112 != null) goto L43;
            ByteReplayMask r120 = ByteReplayMask.NONE;
        L44:
            String r121 = LynxFrameRecorder.f(r120);
            if (r121 != null) goto L47;
        L49:
            r103.put(SlcElement.KEY_PROPS, Collections.unmodifiableMap(r104));
            goto L51
        L47:
            if (r104.containsKey("lynx-data-bytereplay-mask") == true) goto L49;
            r104.put("lynx-data-bytereplay-mask", r121);
            goto L49
        L43:
            r120 = r112.f383626d;
        L51:
            return Collections.unmodifiableMap(r103);
        }

        public final void h(int r100, int r101) {
            g r102 = d(r100);
            b(r100);
            r102.f383624b = r101;
            if (r101 < 0) goto L8;
            g r103 = d(r101);
            List<Integer> r104 = r103.f383625c;
            ArrayList r105 = (ArrayList) r104;
            if (r105.contains(Integer.valueOf(r100)) == true) goto L9;
            List<Integer> r106 = r103.f383625c;
            ArrayList r107 = (ArrayList) r106;
            r107.add(Integer.valueOf(r100));
            return;
        L9:
            return;
        }

        public static void j(g r100, Map r101, boolean r102) {
            boolean r103 = true;
            boolean r104 = false;
            if (r102 == true) goto L11;
            Map<String, Object> r105 = LynxFrameRecorder.h(r101);
            if (r105 != null) goto L7;
        L9:
            boolean r106 = false;
        L10:
            if (r106 == true) goto L11;
        L31:
            String r107 = r100.f383623a;
            if ("input".equals(r107) == false) goto L34;
        L37:
            boolean r108 = true;
        L38:
            if (r108 == true) goto L40;
            r100.f383627e = false;
            return;
        L40:
            if (r102 == true) goto L48;
            Map<String, Object> r109 = LynxFrameRecorder.h(r101);
            if (r109 != null) goto L44;
        L46:
            r103 = false;
        L47:
            if (r103 == true) goto L48;
            return;
        L44:
            if (r109.containsKey("type") == false) goto L46;
        L48:
            Map<String, Object> r110 = LynxFrameRecorder.h(r101);
            if (r110 == null) goto L52;
            r104 = "password".equals(r110.get("type"));
        L52:
            r100.f383627e = r104;
            return;
        L34:
            if ("x-input".equals(r107) == true) goto L37;
            r108 = false;
            goto L38
        L7:
            if (r105.containsKey("lynx-data-bytereplay-mask") == false) goto L9;
            r106 = true;
        L11:
            Map<String, Object> r111 = LynxFrameRecorder.h(r101);
            if (r111 != null) goto L14;
            ByteReplayMask r112 = ByteReplayMask.NONE;
        L30:
            r100.f383626d = r112;
            goto L31
        L14:
            Object r113 = r111.get("lynx-data-bytereplay-mask");
            if (r113 != null) goto L17;
            r112 = ByteReplayMask.NONE;
            goto L30
        L17:
            String r114 = String.valueOf(r113);
            if ("true".equals(r114) == false) goto L21;
            r112 = ByteReplayMask.TRUE;
            goto L30
        L21:
            if ("ignore".equals(r114) == false) goto L24;
            r112 = ByteReplayMask.IGNORE;
            goto L30
        L24:
            if ("name".equals(r114) == false) goto L27;
            r112 = ByteReplayMask.NAME;
            goto L30
        L27:
            if ("strict".equals(r114) == false) goto L29;
            r112 = ByteReplayMask.STRICT;
            goto L30
        L29:
            r112 = ByteReplayMask.NONE;
            goto L30
        }
    }

    public final class l implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f383638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f383639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LynxFrameRecorder f383640c;

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(final long r100) {
            this.f383640c.f383584a.execute(new com.lynx.tasm.recording.j(this, r100));
        }

        public l(LynxFrameRecorder r100, int r101, int r102) {
            this.f383640c = r100;
            this.f383638a = r101;
            this.f383639b = r102;
        }
    }

    public static final class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<n> f383641a;

        public m() {
            throw null;
        }

        public m(List r100) {
            this.f383641a = r100;
        }
    }

    public static final class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f383642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f383643b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f383644c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f383645d;

        public n(float r100, float r101, int r102, Integer r103) {
            this.f383642a = r100;
            this.f383643b = r101;
            this.f383644c = r102;
            this.f383645d = r103;
        }
    }

    public static final class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<p> f383646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Float f383647b;

        public o() {
            throw null;
        }

        public o(List r100, Float r101) {
            this.f383646a = r100;
            this.f383647b = r101;
        }
    }

    public static final class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f383648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f383649b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f383650c;

        public p(int r100, Object r101, long r102) {
            this.f383648a = r100;
            this.f383649b = r101;
            this.f383650c = r102;
        }
    }

    public static final class q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f383651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f383652b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f383653c;

        public q(int r100, String r101, String r102) {
            this.f383651a = r100;
            this.f383652b = r101;
            this.f383653c = r102;
        }
    }

    public static final class r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f383654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f383655b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f383656c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f383657d;

        public r(int r100, String r101, int r102, int r103) {
            this.f383654a = r100;
            this.f383655b = r101;
            this.f383656c = r102;
            this.f383657d = r103;
        }
    }

    public static final class s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f383658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f383659b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f383660c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f383661d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f383662e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float[] f383663f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float[] f383664g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float[] f383665h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final float[] f383666i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final float[] f383667j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final float f383668k;

        public s(int r100, float r101, float r102, float r103, float r104, float[] r105, float[] r106, float[] r107, float[] r108, float[] r110, float r111) {
            this.f383658a = r100;
            this.f383659b = r101;
            this.f383660c = r102;
            this.f383661d = r103;
            this.f383662e = r104;
            this.f383663f = r105;
            this.f383664g = r106;
            this.f383665h = r107;
            this.f383666i = r108;
            this.f383667j = r110;
            this.f383668k = r111;
        }
    }

    public static final class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f383669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Boolean f383670b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, Object> f383671c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, Object> f383672d;

        public t() {
            throw null;
        }

        public t(int r100, Boolean r101, Map r102, Map r103) {
            this.f383669a = r100;
            this.f383670b = r101;
            this.f383671c = r102;
            this.f383672d = r103;
        }
    }

    static {
        f383583k = new LynxFrameRecorder();
    }

    public LynxFrameRecorder() {
        j r100 = new j();
        this.f383585b = new ConcurrentHashMap();
        this.f383586c = new ConcurrentHashMap();
        this.f383587d = new ConcurrentHashMap();
        this.f383588e = new ConcurrentHashMap();
        this.f383589f = new ConcurrentHashMap();
        this.f383590g = new ConcurrentHashMap();
        this.f383591h = new HashMap();
        this.f383592i = new HashMap();
        this.f383593j = new AtomicInteger(1);
        this.f383584a = PThreadExecutorsUtils.newSingleThreadExecutor(r100);
    }

    public static Map<String, Object> A(Object r100) {
        if ((r100 instanceof Map) == true) goto L6;
        return null;
    L6:
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator r102 = ((Map) r100).entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        Map.Entry r103 = (Map.Entry) r102.next();
        Object r104 = r103.getKey();
        if (r104 == null) goto L8;
        r101.put(String.valueOf(r104), r103.getValue());
        goto L8
    L12:
        return r101;
    }

    public static float[] b(float[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return (float[]) r100.clone();
    }

    public static String f(ByteReplayMask r100) {
        int r101 = a.f383596b[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "true";
    L5:
        if (r101 != 2) goto L7;
        return "ignore";
    L7:
        if (r101 != 3) goto L9;
        return "name";
    L9:
        if (r101 == 4) goto L12;
        return null;
    L12:
        return "strict";
    }

    public static Map<String, Object> h(Map<String, Object> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return A(r100.get(SlcElement.KEY_PROPS));
    }

    public static boolean j(String r100) {
        if ("value".equals(r100) == false) goto L5;
    L12:
        return true;
    L5:
        if ("text".equals(r100) == true) goto L12;
        if ("default-value".equals(r100) == true) goto L12;
        if ("defaultValue".equals(r100) == true) goto L12;
        return false;
    }

    public static String m(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = 0;
        int r102 = r100.codePointCount(0, r100.length());
        StringBuilder r103 = new StringBuilder(r102);
    L6:
        if (r101 >= r102) goto L9;
        r103.append("*");
        r101 = r101 + 1;
        goto L6
    L9:
        return r103.toString();
    }

    public static Map<String, Object> q(Map<String, Object> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L17;
        Map.Entry<String, Object> r103 = r102.next();
        String r104 = r103.getKey();
        Object r105 = r103.getValue();
        if (j(r104) == true) goto L11;
        r101.put(r104, r(r105));
        goto L7
    L11:
        if ((r105 instanceof CharSequence) == false) goto L13;
        String r106 = m(String.valueOf(r105));
    L14:
        r101.put(r104, r106);
        goto L7
    L13:
        r106 = "*";
        goto L14
    L17:
        return Collections.unmodifiableMap(r101);
    }

    public static Object r(Object r100) {
        Map<String, Object> r101 = A(r100);
        if (r101 == null) goto L7;
        return q(r101);
    L7:
        if ((r100 instanceof Iterable) == false) goto L14;
        ArrayList r102 = new ArrayList();
        Iterator r103 = ((Iterable) r100).iterator();
    L10:
        if (r103.hasNext() == false) goto L13;
        r102.add(r(r103.next()));
        goto L10
    L13:
        return Collections.unmodifiableList(r102);
    L14:
        if (r100 != null) goto L16;
        return r100;
    L16:
        if (r100.getClass().isArray() == false) goto L25;
        ArrayList r104 = new ArrayList();
        int r105 = Array.getLength(r100);
        int r106 = 0;
    L18:
        if (r106 >= r105) goto L21;
        r104.add(r(Array.get(r100, r106)));
        r106 = r106 + 1;
        goto L18
    L21:
        return Collections.unmodifiableList(r104);
    L25:
        return r100;
    }

    public static Object s(f6a.a r100) {
        if (r100 != null) goto L5;
    L30:
        return null;
    L5:
        if (r100.isNull() == true) goto L30;
        ReadableType r101 = r100.getType();
        switch(a.f383595a[r101.ordinal()]) {
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L27;
            case 4: goto L25;
            case 5: goto L23;
            case 6: goto L21;
            case 7: goto L19;
            case 8: goto L17;
            case 9: goto L11;
            default: goto L10;
        };
    L11:
        byte[] r102 = r100.asByteArray();
        if (r102 != null) goto L15;
        return null;
    L15:
        return (byte[]) r102.clone();
    L10:
        return String.valueOf(r100);
    L17:
        return u(r100.asArray());
    L19:
        return v(r100.asMap());
    L21:
        return r100.asString();
    L23:
        return Double.valueOf(r100.asDouble());
    L25:
        return Long.valueOf(r100.asLong());
    L27:
        return Integer.valueOf(r100.asInt());
    L29:
        return Boolean.valueOf(r100.asBoolean());
    }

    public static Map<String, Object> t(PropBundle r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put(SlcElement.KEY_PROPS, v(r100.getProps()));
        r101.put("eventHandlers", u(r100.getEventHandlers()));
        r101.put("gestures", u(r100.getGestures()));
        return Collections.unmodifiableMap(r101);
    }

    public static List<Object> u(ReadableArray r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList(r100.size());
        int r102 = r100.size();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L25;
        switch(a.f383595a[r100.getType(r103).ordinal()]) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L11;
            case 10: goto L9;
            case 11: goto L10;
            default: goto L9;
        };
    L9:
        Object r104 = s(r100.getDynamic(r103));
    L23:
        r101.add(r104);
        r103 = r103 + 1;
        goto L6
    L10:
        r104 = String.valueOf(r100.getPiperData(r103));
        goto L23
    L11:
        byte[] r105 = r100.getByteArray(r103);
        if (r105 == null) goto L22;
        r104 = (byte[]) r105.clone();
        goto L23
    L15:
        r104 = u(r100.getArray(r103));
        goto L23
    L16:
        r104 = v(r100.getMap(r103));
        goto L23
    L17:
        r104 = r100.getString(r103);
        goto L23
    L18:
        r104 = Double.valueOf(r100.getDouble(r103));
        goto L23
    L19:
        r104 = Long.valueOf(r100.getLong(r103));
        goto L23
    L20:
        r104 = Integer.valueOf(r100.getInt(r103));
        goto L23
    L21:
        r104 = Boolean.valueOf(r100.getBoolean(r103));
    L22:
        r104 = null;
        goto L23
    L25:
        return Collections.unmodifiableList(r101);
    }

    public static Map<String, Object> v(ReadableMap r100) {
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        LinkedHashMap r102 = new LinkedHashMap();
        ReadableMapKeySetIterator r103 = r100.keySetIterator();
    L7:
        if (r103.hasNextKey() == false) goto L31;
        String r104 = r103.nextKey();
        ReadableType r105 = r100.getType(r104);
        switch(a.f383595a[r105.ordinal()]) {
            case 1: goto L29;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L17;
            case 10: goto L13;
            case 11: goto L12;
            case 12: goto L11;
            default: goto L10;
        };
    L10:
        r101 = s(r100.getDynamic(r104));
        goto L29
    L11:
        r101 = String.valueOf(r100.getTemplateData(r104));
        goto L29
    L12:
        r101 = String.valueOf(r100.getPiperData(r104));
        goto L29
    L13:
        ByteBuffer r106 = r100.getByteBuffer(r104);
        if (r106 == null) goto L29;
        ByteBuffer r107 = r106.asReadOnlyBuffer();
        byte[] r108 = new byte[r107.remaining()];
        r107.get(r108);
        r101 = r108;
        goto L29
    L17:
        byte[] r109 = r100.getByteArray(r104);
        if (r109 == null) goto L29;
        r101 = (byte[]) r109.clone();
        goto L29
    L21:
        r101 = u(r100.getArray(r104));
        goto L29
    L22:
        r101 = v(r100.getMap(r104));
        goto L29
    L23:
        r101 = r100.getString(r104);
        goto L29
    L24:
        r101 = Double.valueOf(r100.getDouble(r104));
        goto L29
    L25:
        r101 = Long.valueOf(r100.getLong(r104));
        goto L29
    L26:
        r101 = Integer.valueOf(r100.getInt(r104));
        goto L29
    L27:
        r101 = Boolean.valueOf(r100.getBoolean(r104));
    L29:
        r102.put(r104, r101);
        goto L7
    L31:
        return Collections.unmodifiableMap(r102);
    }

    public static Map<String, Object> w(ReadableMapBuffer r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        JavaOnlyMap r101 = new JavaOnlyMap();
        Iterator<MapBuffer.a> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L19;
        MapBuffer.a r103 = r102.next();
        int r104 = r103.getKey();
        MapBuffer.DataType r105 = r103.getType();
        String r106 = s0.f382200a[r104];
        switch(com.lynx.react.bridge.mapbuffer.b.f381451a[r105.ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L7;
        };
    L11:
        r101.put(r106, null);
        goto L7
    L12:
        r101.put(r106, Double.valueOf(r103.b()));
        goto L7
    L13:
        r101.put(r106, r103.getString());
        goto L7
    L14:
        r101.put(r106, Long.valueOf(r103.c()));
        goto L7
    L15:
        r101.put(r106, Boolean.valueOf(r103.e()));
        goto L7
    L16:
        r101.put(r106, Integer.valueOf(r103.a()));
        goto L7
    L17:
        r101.put(r106, new com.lynx.react.bridge.mapbuffer.e(r103.f()));
        goto L7
    L19:
        return v(r101);
    }

    public static JSONObject y(Map<String, Object> r100) {
        if (r100 != null) goto L4;
        r100 = Collections.emptyMap();
    L4:
        Object r101 = z(r100);
        if ((r101 instanceof JSONObject) == false) goto L8;
        return (JSONObject) r101;
    L8:
        return new JSONObject();
    }

    public static Object z(Object r100) {
        if (r100 != null) goto L6;
        return JSONObject.NULL;
    L6:
        if ((r100 instanceof JSONObject) == false) goto L8;
        return r100;
    L8:
        if ((r100 instanceof JSONArray) == false) goto L10;
        return r100;
    L10:
        if (r100 != JSONObject.NULL) goto L13;
        return r100;
    L13:
        if ((r100 instanceof p) == false) goto L17;
        p r101 = (p) r100;
        JSONObject r102 = new JSONObject();
        n(r102, "eventType", Integer.valueOf(r101.f383648a));
        n(r102, "opTime", Long.valueOf(r101.f383650c));
        n(r102, "data", r101.f383649b);
        return r102;
    L17:
        if ((r100 instanceof o) == false) goto L23;
        o r103 = (o) r100;
        JSONObject r104 = new JSONObject();
        n(r104, "operations", r103.f383646a);
        Float r105 = r103.f383647b;
        if (r105 == null) goto L21;
        n(r104, "screenDensity", r105);
    L21:
        return r104;
    L23:
        if ((r100 instanceof b) == false) goto L27;
        b r106 = (b) r100;
        JSONObject r107 = new JSONObject();
        n(r107, "sign", Integer.valueOf(r106.f383597a));
        n(r107, "tagName", r106.f383598b);
        n(r107, "bundle", r106.f383599c);
        n(r107, "initialStyles", r106.f383600d);
        return r107;
    L27:
        if ((r100 instanceof h) == false) goto L31;
        h r108 = (h) r100;
        JSONObject r109 = new JSONObject();
        n(r109, "parentSign", Integer.valueOf(r108.f383628a));
        n(r109, "childSign", Integer.valueOf(r108.f383629b));
        n(r109, "index", r108.f383630c);
        return r109;
    L31:
        if ((r100 instanceof t) == false) goto L38;
        t r110 = (t) r100;
        JSONObject r111 = new JSONObject();
        n(r111, "sign", Integer.valueOf(r110.f383669a));
        Boolean r112 = r110.f383670b;
        if (r112 == null) goto L35;
        n(r111, "tendToFlatten", r112);
    L35:
        n(r111, "bundle", r110.f383671c);
        n(r111, "styles", r110.f383672d);
        return r111;
    L38:
        if ((r100 instanceof s) == false) goto L42;
        s r113 = (s) r100;
        JSONObject r114 = new JSONObject();
        n(r114, "sign", Integer.valueOf(r113.f383658a));
        n(r114, "x", Float.valueOf(r113.f383659b));
        n(r114, "y", Float.valueOf(r113.f383660c));
        n(r114, "width", Float.valueOf(r113.f383661d));
        n(r114, "height", Float.valueOf(r113.f383662e));
        n(r114, "paddings", r113.f383663f);
        n(r114, "margins", r113.f383664g);
        n(r114, "borders", r113.f383665h);
        n(r114, "bounds", r113.f383666i);
        n(r114, "sticky", r113.f383667j);
        n(r114, "maxHeight", Float.valueOf(r113.f383668k));
        return r114;
    L42:
        if ((r100 instanceof q) == false) goto L46;
        q r115 = (q) r100;
        JSONObject r116 = new JSONObject();
        n(r116, "sign", Integer.valueOf(r115.f383651a));
        n(r116, "type", r115.f383652b);
        n(r116, "text", r115.f383653c);
        return r116;
    L46:
        if ((r100 instanceof r) == false) goto L50;
        r r117 = (r) r100;
        JSONObject r118 = new JSONObject();
        n(r118, "sign", Integer.valueOf(r117.f383654a));
        n(r118, "value", r117.f383655b);
        n(r118, "selectionStart", Integer.valueOf(r117.f383656c));
        n(r118, "selectionEnd", Integer.valueOf(r117.f383657d));
        return r118;
    L50:
        if ((r100 instanceof f) == false) goto L54;
        f r119 = (f) r100;
        JSONObject r120 = new JSONObject();
        n(r120, "sign", Integer.valueOf(r119.f383620a));
        n(r120, com.alipay.sdk.m.p.e.f25671s, r119.f383621b);
        n(r120, "params", r119.f383622c);
        return r120;
    L54:
        if ((r100 instanceof m) == false) goto L58;
        JSONObject r121 = new JSONObject();
        n(r121, "points", ((m) r100).f383641a);
        return r121;
    L58:
        if ((r100 instanceof n) == false) goto L62;
        n r122 = (n) r100;
        JSONObject r123 = new JSONObject();
        n(r123, "x", Float.valueOf(r122.f383642a));
        n(r123, "y", Float.valueOf(r122.f383643b));
        n(r123, "touchId", Integer.valueOf(r122.f383644c));
        n(r123, "targetId", r122.f383645d);
        return r123;
    L62:
        if ((r100 instanceof PropBundle) == false) goto L66;
        return y(t((PropBundle) r100));
    L66:
        if ((r100 instanceof ReadableMap) == false) goto L70;
        return y(v((ReadableMap) r100));
    L70:
        if ((r100 instanceof ReadableArray) == false) goto L80;
        List<Object> r124 = u((ReadableArray) r100);
        if (r124 != null) goto L74;
        r124 = Collections.emptyList();
    L74:
        Object r125 = z(r124);
        if ((r125 instanceof JSONArray) == false) goto L78;
        return (JSONArray) r125;
    L78:
        return new JSONArray();
    L80:
        if ((r100 instanceof ReadableMapBuffer) == true) goto L82;
        int r126 = 0;
        if ((r100 instanceof float[]) == false) goto L92;
        float[] r127 = (float[]) r100;
        JSONArray r128 = new JSONArray();
        int r129 = r127.length;
    L86:
        if (r126 >= r129) goto L90;
        r128.put(r127[r126]);     // Catch: JSONException -> L127
    L89:
        r126 = r126 + 1;
        goto L86
    L90:
        return r128;
    L92:
        if ((r100 instanceof Map) == false) goto L102;
        JSONObject r130 = new JSONObject();
        Iterator r131 = ((Map) r100).entrySet().iterator();
    L95:
        if (r131.hasNext() == false) goto L100;
        Map.Entry r132 = (Map.Entry) r131.next();
        r130.put(String.valueOf(r132.getKey()), z(r132.getValue()));     // Catch: JSONException -> L99
        goto L95
    L100:
        return r130;
    L102:
        if ((r100 instanceof Iterable) == false) goto L109;
        JSONArray r133 = new JSONArray();
        Iterator r134 = ((Iterable) r100).iterator();
    L105:
        if (r134.hasNext() == false) goto L107;
        r133.put(z(r134.next()));
        goto L105
    L107:
        return r133;
    L109:
        if (r100.getClass().isArray() == false) goto L115;
        JSONArray r135 = new JSONArray();
        int r136 = Array.getLength(r100);
    L111:
        if (r126 >= r136) goto L113;
        r135.put(z(Array.get(r100, r126)));
        r126 = r126 + 1;
        goto L111
    L113:
        return r135;
    L115:
        if ((r100 instanceof CharSequence) == false) goto L117;
        return r100;
    L117:
        if ((r100 instanceof Boolean) == false) goto L119;
        return r100;
    L119:
        if ((r100 instanceof Number) == false) goto L122;
        return r100;
    L122:
        if ((r100 instanceof Enum) == false) goto L126;
        return ((Enum) r100).name();
    L126:
        return String.valueOf(r100);
    L82:
        return y(w((ReadableMapBuffer) r100));
    }

    public final Integer e(int r100) {
        Integer r101 = this.f383585b.get(Integer.valueOf(r100));
        if (r101 != null) goto L5;
        return null;
    L5:
        Integer r102 = this.f383586c.get(Integer.valueOf(r100));
        if (r102 != null) goto L8;
    L10:
        return r101;
    L8:
        if (r102.equals(r101) == false) goto L10;
        return null;
    }

    public final Float i(int r100) {
        Float r101 = this.f383590g.get(Integer.valueOf(r100));
        if (r101 != null) goto L5;
    L7:
        return null;
    L5:
        if (r101.floatValue() <= 0.0f) goto L7;
        return r101;
    }

    public final boolean k(int r100) {
        if (r100 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (e(r100) == null) goto L6;
        return true;
    }

    public final void x(final int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        final Integer r101 = e(r100);
        if (r101 != null) goto L8;
        this.f383588e.remove(Integer.valueOf(r100));
        this.f383590g.remove(Integer.valueOf(r100));
        return;
    L8:
        this.f383586c.put(Integer.valueOf(r100), r101);
        this.f383584a.execute(new com.lynx.tasm.recording.a(this, r100, r101));
    }

    public static float[] c(float[] r100, int r101) {
        return new float[]{r100[r101], r100[r101 + 1], r100[r101 + 2], r100[r101 + 3]};
    }

    public final k g(int r100, int r101) {
        Map<Integer, k> r102 = this.f383592i;
        HashMap r103 = (HashMap) r102;
        k r104 = (k) r103.get(Integer.valueOf(r100));
        if (r104 != null) goto L5;
    L6:
        k r105 = new k(r101);
        Map<Integer, k> r106 = this.f383592i;
        HashMap r107 = (HashMap) r106;
        r107.put(Integer.valueOf(r100), r105);
        return r105;
    L5:
        if (r104.f383636a != r101) goto L6;
        return r104;
    }

    public final boolean l(int r100, int r101) {
        Integer r102 = this.f383585b.get(Integer.valueOf(r100));
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.intValue() != r101) goto L7;
        return true;
    }

    public static Map a(Map r100, g r101, boolean r102) {
        if (r100 != null) goto L4;
        return null;
    L4:
        LinkedHashMap r103 = new LinkedHashMap(r100);
        Map<String, Object> r104 = h(r100);
        if (r104 == null) goto L24;
        LinkedHashMap r105 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r106 = r104.entrySet().iterator();
    L8:
        if (r106.hasNext() == false) goto L22;
        Map.Entry<String, Object> r107 = r106.next();
        String r108 = r107.getKey();
        Object r109 = r107.getValue();
        if (r102 == true) goto L15;
        if (r101 == null) goto L21;
        if (r101.f383627e == true) goto L15;
    L21:
        r105.put(r108, r109);
    L15:
        if (j(r108) == false) goto L21;
        if ((r109 instanceof CharSequence) == false) goto L19;
        String r110 = m(String.valueOf(r109));
    L20:
        r105.put(r108, r110);
        goto L8
    L19:
        r110 = "*";
        goto L20
    L22:
        r103.put(SlcElement.KEY_PROPS, Collections.unmodifiableMap(r105));
    L24:
        return Collections.unmodifiableMap(r103);
    }

    public static void n(JSONObject r100, String r101, Object r102) {
        r100.put(r101, z(r102));     // Catch: JSONException -> L4
        return;
    }

    public final void p(final int r110, final int r111, final Object r112, final long r113) {
        final Integer r100 = e(r110);
        if (r100 != null) goto L5;
        return;
    L5:
        this.f383584a.execute(new com.lynx.tasm.recording.d(this, r110, r100, r111, r112, r113));
    }

    public final void d(int r100, int r101, int r102, Object r103, long r104) {
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L11
        r105.put("time", r104);     // Catch: JSONException -> L11
        r105.put("trackType", r101);     // Catch: JSONException -> L11
        JSONObject r106 = new JSONObject();     // Catch: JSONException -> L11
        r106.put("eventType", r102);     // Catch: JSONException -> L11
        r106.put("data", z(r103));     // Catch: JSONException -> L11
        r105.put("event", r106);     // Catch: JSONException -> L11
        c r107 = this.f383588e.get(Integer.valueOf(r100));     // Catch: JSONException -> L11
        if (r107 != null) goto L7;
        r107 = new c();     // Catch: JSONException -> L11
        c r108 = this.f383588e.putIfAbsent(Integer.valueOf(r100), r107);     // Catch: JSONException -> L11
        if (r108 == null) goto L7;
        r107 = r108;
    L7:
        c.a(r107, r105);     // Catch: JSONException -> L11
        d r109 = this.f383589f.get(Integer.valueOf(r100));     // Catch: JSONException -> L11
        if (r109 == null) goto L14;
        r109.a(r105);     // Catch: JSONException -> L11
        return;
    L14:
        return;
    }

    public final void o(int r100, int r101, String r102, int r110, int r111) {
        if (r102 != null) goto L4;
        return;
    L4:
        long r103 = SystemClock.uptimeMillis();
        p(r100, 110, new r(r101, r102, r110, r111), r103);
    }
}
