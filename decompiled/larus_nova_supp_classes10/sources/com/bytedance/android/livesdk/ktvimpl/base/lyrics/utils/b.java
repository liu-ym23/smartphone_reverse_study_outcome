package com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg4.c;
import mb0.e;
import mb0.f;
import org.json.JSONObject;
import ub0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final b a = null;

    public static abstract class a {
        public final int a;
        public final String b;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.b$a$a, reason: collision with other inner class name */
        public static final class C0010a extends a {
            public static final C0010a c = null;

            static {
                c = new C0010a();
            }

            public C0010a() {
                super(3, "file not exist");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.b$a$b, reason: collision with other inner class name */
        public static final class C0011b extends a {
            public static final C0011b c = null;

            static {
                c = new C0011b();
            }

            public C0011b() {
                super(2, "local path is empty");
            }
        }

        public static final class c extends a {
            public c(String r2) {
                Intrinsics.checkNotNullParameter(r2, "msg");
                super(4, r2);
            }
        }

        public static final class d extends a {
            public static final d c = null;

            static {
                c = new d();
            }

            public d() {
                super(1, "uri is empty");
            }
        }

        public a(int r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public b() {
    }

    static {
        a = new b();
    }

    public static d b(MusicPanel r10) {
        Intrinsics.checkNotNullParameter(r10, "musicPanel");
        final long r0 = r10.a.getMId();
        String r2 = r10.l;
        List r3 = r10.a.getMLyricUrlList();
        if (r3 == null) goto L6;
        String r4 = (String) CollectionsKt.firstOrNull(r3);
        if (r4 == null) goto L6;
    L7:
        int r11 = r10.a.getMLyricType();
        Intrinsics.checkNotNullParameter(r2, "localPath");
        Intrinsics.checkNotNullParameter(r4, "url");
        final d r12 = a(r0, r2, r4, r11);
        String r5 = bb0.b.b();
        ALogger.i(r5, ("开始解析歌词，id: " + r0) + ", invoke class :" + d.class.getSimpleName());
        UtilityKotlinExtentionsKt.s(0, false, false, new LyricsReaderHelper$parseSync$$inlined$apply$lambda$1(r12, r0), 7);
        return r12;
    L6:
        r4 = "";
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static d a(long r16, String r18, String r19, int r20) {
        Intrinsics.checkNotNullParameter(r18, "localPath");
        Intrinsics.checkNotNullParameter(r19, "url");
        PolarisFileWrapper r1 = new PolarisFileWrapper(r18);
        boolean r4 = true;
        if (r1.exists() == false) goto L60;
        List r10 = null;
        if (StringsKt.endsWith$default(r18, ".lrc", false, 2, null) == false) goto L8;
        int r2 = 2;
    L77:
        if (r2 == 2) goto L16;
        if (r2 == 3) goto L15;
        c r6 = null;
    L17:
        if (r6 == null) goto L28;
        Intrinsics.checkNotNullParameter(r1, "file");     // Catch: Exception -> L38
        com.bytedance.component.lyric.model.a r7 = r6.a(new PolarisFileInputStreamWrapper(r1));     // Catch: Exception -> L38
        if (r7 == null) goto L28;
        TreeMap r8 = r7.a;     // Catch: Exception -> L38
        if (r8 == null) goto L28;
        Collection r9 = r8.values();     // Catch: Exception -> L38
        if (r9 == null) goto L26;
        List r11 = CollectionsKt.toList(r9);     // Catch: Exception -> L38
        if (r11 == null) goto L26;
    L27:
        r10 = r11;
    L26:
        r11 = CollectionsKt.emptyList();     // Catch: Exception -> L38
    L28:
        List r12 = r10;     // Catch: Exception -> L38
        if (r12 != null) goto L31;
    L34:
        if (r4 == false) goto L36;
        String r5 = bb0.b.b();     // Catch: Exception -> L38
        ALogger.i(r5, ("parse result is null:" + r1) + ", invoke class :" + b.class.getSimpleName());     // Catch: Exception -> L38
        StringBuilder r13 = new StringBuilder("read nothing from file or type=");     // Catch: Exception -> L38
        r13.append(r2);     // Catch: Exception -> L38
        r13.append(" error");     // Catch: Exception -> L38
        Object r3 = new com.bytedance.android.livesdk.ktvimpl.base.util.c.a(r13.toString());     // Catch: Exception -> L38
    L44:
        if ((r3 instanceof com.bytedance.android.livesdk.ktvimpl.base.util.c.a) == false) goto L51;
        String r14 = (String) ((com.bytedance.android.livesdk.ktvimpl.base.util.c.a) r3).a;
        a.c r0 = new a.c(r14);
        pd2.d.n.getClass();
        pd2.d.O(r16, r19, r20, r0);
        KtvContext.Companion.getClass();
        if (KtvContext.a.d() == false) goto L49;
        f.e(r16, r19, r20, 4, r14);
    L49:
        return new d(r16, r20, CollectionsKt.emptyList());
    L51:
        if ((r3 instanceof com.bytedance.android.livesdk.ktvimpl.base.util.c.b) == false) goto L58;
        pd2.d.n.getClass();
        Intrinsics.checkNotNullParameter(r19, "lyricsUrl");
        JSONObject r15 = mb0.b.o(mb0.b.p(new JSONObject(), r16), r19);
        Intrinsics.checkNotNullParameter(r15, "$this$putLyricsType");
        pd2.d.w(LinkMonitorData.BusinessLyricsParseStatusSuccess, r15.put("lyrics_type", r20));
        KtvContext.Companion.getClass();
        if (KtvContext.a.d() == false) goto L56;
        int r17 = f.a;
        Intrinsics.checkNotNullParameter(r19, "lyricsUrl");
        JSONObject r110 = new JSONObject();
        e.a(r110, r16);
        Intrinsics.checkNotNullParameter(r110, "$this$putLyricsUrl");
        Intrinsics.checkNotNullParameter(r19, "lyricsUrl");
        r110.put("lyrics_url", r19);
        Intrinsics.checkNotNullParameter(r110, "$this$putLyricsType");
        r110.put("lyrics_type", r20);
        int r21 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.MusicPlayFlow, "lyricsParse", 0, null, r110, 88);
    L56:
        return new d(r16, r2, (List) ((com.bytedance.android.livesdk.ktvimpl.base.util.c.b) r3).a);
    L58:
        throw new NoWhenBranchMatchedException();
    L36:
        r3 = new com.bytedance.android.livesdk.ktvimpl.base.util.c.b(r10);     // Catch: Exception -> L38
        goto L44
    L31:
        if (r12.isEmpty() == true) goto L34;
        r4 = false;
        goto L34
    L15:
        r6 = new lg4.a();     // Catch: Exception -> L38
        goto L17
    L16:
        r6 = new lg4.b();     // Catch: Exception -> L38
    L38:
        e = move-exception;
        String r22 = e.getMessage();
        if (r22 != null) goto L42;
        r22 = "";
    L42:
        r3 = new com.bytedance.android.livesdk.ktvimpl.base.util.c.a(r22);
        goto L44
    L8:
        if (StringsKt.endsWith$default(r18, ".krc", false, 2, null) == false) goto L10;
        r2 = 3;
        goto L77
    L10:
        r2 = r20;
        goto L77
    L60:
        if (r19.length() != 0) goto L62;
        boolean r23 = true;
    L63:
        if (r23 == false) goto L66;
        a r24 = a.d.c;
    L72:
        pd2.d.n.getClass();
        pd2.d.O(r16, r19, r20, r24);
        KtvContext.Companion.getClass();
        if (KtvContext.a.d() == false) goto L76;
        f.e(r16, r19, r20, r24.a, r24.b);
    L76:
        return new d(r16, r20, CollectionsKt.emptyList());
    L66:
        if (r18.length() == 0) goto L69;
        r4 = false;
    L69:
        if (r4 == false) goto L71;
        r24 = a.C0011b.c;
        goto L72
    L71:
        r24 = a.C0010a.c;
        goto L72
    L62:
        r23 = false;
        goto L63
    }
}
