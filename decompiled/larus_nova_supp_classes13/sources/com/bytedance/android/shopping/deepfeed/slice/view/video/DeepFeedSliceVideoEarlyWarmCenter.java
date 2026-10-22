package com.bytedance.android.shopping.deepfeed.slice.view.video;

import android.content.Context;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.api.video.ScaleType;
import com.bytedance.android.shopping.api.video.d;
import com.bytedance.android.shopping.api.video.e;
import com.bytedance.android.shopping.api.video.k;
import com.bytedance.android.shopping.api.video.l;
import com.bytedance.android.shopping.deepfeed.slice.view.f;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import he3.e2;
import he3.n2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedSliceVideoEarlyWarmCenter {
    public static final ConcurrentHashMap<String, a> a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/view/video/DeepFeedSliceVideoEarlyWarmCenter$WarmLevel;", "", "NONE", "PRELOADED", "PRERENDERED", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum WarmLevel extends Enum<WarmLevel> {
        public static final WarmLevel NONE = null;
        public static final WarmLevel PRELOADED = null;
        public static final WarmLevel PRERENDERED = null;
        public static final /* synthetic */ WarmLevel[] a = null;

        static {
            WarmLevel r1 = new WarmLevel("NONE", 0);
            NONE = r1;
            WarmLevel r2 = new WarmLevel("PRELOADED", 1);
            PRELOADED = r2;
            WarmLevel r3 = new WarmLevel("PRERENDERED", 2);
            PRERENDERED = r3;
            a = new WarmLevel[]{r1, r2, r3};
        }

        public static WarmLevel valueOf(String r1) {
            return (WarmLevel) r27.a.a(WarmLevel.class, r1);
        }

        public static WarmLevel[] values() {
            return (WarmLevel[]) a.clone();
        }

        public WarmLevel(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public WarmLevel a;
        public WeakReference<ECVideoPlayerView> b;
        public boolean c;

        public a() {
            this(null, 7);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public final int hashCode() {
            WarmLevel r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            WeakReference<ECVideoPlayerView> r4 = this.b;
            if (r4 == null) goto L9;
            r1 = r4.hashCode();
        L9:
            int r5 = (r3 + r1) * 31;
            boolean r6 = this.c;
            ?? r7 = r6;
            if (r6 == false) goto L13;
            r7 = 1;
        L13:
            return r5 + r7;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "WarmEntry(level=" + this.a + ", playerRef=" + this.b + ", attached=" + this.c + ")";
        }

        public a(WeakReference r3, int r4) {
            if ((r4 & 1) == 0) goto L5;
            WarmLevel r0 = WarmLevel.NONE;
        L7:
            if ((r4 & 2) == 0) goto L9;
            r3 = null;
        L9:
            Intrinsics.checkNotNullParameter(r0, "level");
            this.a = r0;
            this.b = r3;
            this.c = false;
            return;
        L5:
            r0 = null;
            goto L7
        }
    }

    static {
        a = new ConcurrentHashMap();
    }

    public static c b(f r12) {
        Intrinsics.checkNotNullParameter(r12, "data");
        String r0 = r12.b;
        boolean r2 = false;
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L9;
        String r8 = r0;
    L10:
        if (r8 != null) goto L13;
        return null;
    L13:
        if (r12.a.length() <= 0) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L18;
        String r4 = "vid:" + r12.a;
    L19:
        String r6 = r4;
        String r7 = r12.a;
        String r5 = r12.c;
        if (r5.length() <= 0) goto L22;
        r2 = true;
    L22:
        if (r2 == false) goto L24;
        String r9 = r5;
    L26:
        return new c(r6, r7, r8, r9, r12.e, r12.f);
    L24:
        r9 = null;
        goto L26
    L18:
        r4 = "src:".concat(r8);
        goto L19
    L15:
        r3 = false;
        goto L16
    L9:
        r8 = null;
        goto L10
    L5:
        r1 = false;
        goto L7
    }

    public static c c(InFeedProductV2 r12) {
        Integer r0 = null;
        if (r12 == null) goto L60;
        List<e2> r13 = com.bytedance.android.shopping.deepfeed.utlis.a.m(r12);
        if (r13 == null) goto L61;
        e2 r14 = (e2) CollectionsKt.firstOrNull(r13);
        if (r14 == null) goto L65;
        n2 r1 = r14.a();
        if (r1 == null) goto L62;
        List<String> r2 = r1.b();
        if (r2 == null) goto L63;
        String r3 = (String) CollectionsKt.firstOrNull(r2);
        if (r3 == null) goto L64;
        boolean r4 = true;
        if (r3.length() <= 0) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L21;
        String r8 = r3;
    L22:
        if (r8 == null) goto L66;
        String r6 = r14.e();
        if (r6 != null) goto L27;
        r6 = "";
    L27:
        String r7 = r6;
        if (r7.length() > 0) goto L31;
        r4 = false;
    L31:
        if (r4 == false) goto L33;
        String r9 = "vid:".concat(r7);
    L34:
        String r10 = r9;
        InFeedUrlModel r11 = r14.b();
        if (r11 == null) goto L39;
        List r15 = r11.getUrlList();
        if (r15 == null) goto L39;
        String r16 = (String) CollectionsKt.firstOrNull(r15);
    L40:
        Integer r17 = r14.f();
        if (r17 != null) goto L46;
        n2 r18 = r14.a();
        if (r18 == null) goto L45;
        r17 = r18.c();
        goto L46
    L45:
        r17 = null;
    L46:
        if (r17 == null) goto L48;
        int r19 = r17.intValue();
    L49:
        Integer r20 = r14.d();
        if (r20 != null) goto L54;
        n2 r110 = r14.a();
        if (r110 == null) goto L55;
        r0 = r110.a();
    L55:
        if (r0 == null) goto L57;
        int r111 = r0.intValue();
    L59:
        return new c(r10, r7, r8, r16, r19, r111);
    L57:
        r111 = 0;
        goto L59
    L54:
        r0 = r20;
        goto L55
    L48:
        r19 = 0;
    L39:
        r16 = null;
        goto L40
    L33:
        r9 = "src:".concat(r8);
        goto L34
    L66:
        return null;
    L21:
        r8 = null;
        goto L22
    L18:
        r5 = false;
        goto L19
    L64:
        return null;
    L63:
        return null;
    L62:
        return null;
    L65:
        return null;
    L61:
        return null;
    L60:
        return null;
    }

    public static boolean a(c r3, WarmLevel r4) {
        if (r3 == null) goto L24;
        String r5 = r3.a;
        if (r5 == null) goto L27;
        a r6 = a.get(r5);
        if (r6 != null) goto L10;
        return false;
    L10:
        WeakReference<ECVideoPlayerView> r1 = r6.b;
        if (r1 == null) goto L25;
        ECVideoPlayerView r2 = r1.get();
        if (r2 != null) goto L16;
        return false;
    L16:
        if (r6.a.ordinal() >= r4.ordinal()) goto L19;
        return false;
    L19:
        if (r2.getParent() == null) goto L21;
    L22:
        return true;
    L21:
        if (r6.c == false) goto L22;
        return false;
    L25:
        return false;
    L27:
        return false;
    L24:
        return false;
    }

    public static ECVideoPlayerView d(Context r22, c r23) {
        ConcurrentHashMap<String, a> r1 = a;
        a r2 = r1.get(r23.a);
        if (r2 == null) goto L9;
        WeakReference<ECVideoPlayerView> r3 = r2.b;
        if (r3 == null) goto L9;
        ECVideoPlayerView r4 = r3.get();
        if (r4 == null) goto L9;
        return r4;
    L9:
        l r12 = new l(AVScene.MALL_PRODUCT_INFLOW_LIVE_REPLAY, true, true, false, null, true, true, 40);
        boolean r5 = false;
        ECVideoPlayerView r6 = new ECVideoPlayerView(r22, null, 0, r12);
        String r7 = r23.b;
        if (r7.length() != 0) goto L12;
        r5 = true;
    L12:
        if (r5 == false) goto L14;
        r7 = r23.a;
    L14:
        String r8 = r7;
        k r9 = new k();
        Intrinsics.checkNotNullParameter(r8, "videoKey");
        r9.a = r8;
        Intrinsics.checkNotNullParameter(r8, "key");
        r9.b = r8;
        r9.a(r23.c);
        com.bytedance.android.shopping.api.video.b r10 = r9.b();
        if (r10 != null) goto L17;
        return null;
    L17:
        Intrinsics.checkNotNullParameter(r10, "playItem");
        ArrayList r11 = new ArrayList();
        r11.add(r10);
        d r13 = new d(true, true, 0, (int) r6.getDuration(), false, 484);
        Intrinsics.checkNotNullParameter(r13, "options");
        Intrinsics.checkNotNullParameter(r8, "newVid");
        e r14 = new e(r8, 0, null, r11, null, r13, -1, 0.0f, null, -1, -1, null, null);
        r6.w(ScaleType.CENTER_CROP);
        r6.b(r14);
        r1.put(r23.a, new a(new WeakReference(r6), 5));
        return r6;
    }

    public static void f(Context r1, c r2) {
        if (a(r2, WarmLevel.PRERENDERED) == false) goto L5;
        return;
    L5:
        ECVideoPlayerView r3 = d(r1, r2);
        if (r3 != null) goto L8;
        return;
    L8:
        r3.p();
        g(r2, r3, WarmLevel.PRERENDERED);
    }

    public static void e(Context r1, c r2, int r3) {
        if (a(r2, WarmLevel.PRELOADED) == false) goto L5;
        return;
    L5:
        ECVideoPlayerView r4 = d(r1, r2);
        if (r4 != null) goto L8;
        return;
    L8:
        r4.o(r3);
        g(r2, r4, WarmLevel.PRELOADED);
    }

    public static void g(c r4, ECVideoPlayerView r5, WarmLevel r6) {
        String r7 = r4.a;
        if (r7 == null) goto L16;
        ConcurrentHashMap<String, a> r0 = a;
        a r1 = r0.get(r7);
        if (r1 != null) goto L11;
        r1 = new a(null, 7);
        a r8 = r0.putIfAbsent(r7, r1);
        if (r8 == null) goto L11;
        r1 = r8;
    L11:
        a r2 = r1;
        r2.b = new WeakReference(r5);
        if (r6.ordinal() <= r2.a.ordinal()) goto L15;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r2.a = r6;
        return;
    L15:
        return;
    }
}
