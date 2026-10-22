package com.larus.browsertakeover.transport;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes26.dex */
public final class RtpCdpMessageCodec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RtpCdpMessageCodec f319663a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/browsertakeover/transport/RtpCdpMessageCodec$Reason;", "", "<init>", "(Ljava/lang/String;I)V", "EMPTY", "TOO_LARGE", "INVALID_MJPEG_ENVELOPE", "INVALID_UTF8", "INVALID_JSON", "UNSUPPORTED_ENVELOPE", "INVALID_CDP_EVENT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Reason extends Enum<Reason> {
        public static final Reason EMPTY = null;
        public static final Reason INVALID_CDP_EVENT = null;
        public static final Reason INVALID_JSON = null;
        public static final Reason INVALID_MJPEG_ENVELOPE = null;
        public static final Reason INVALID_UTF8 = null;
        public static final Reason TOO_LARGE = null;
        public static final Reason UNSUPPORTED_ENVELOPE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Reason[] f319664a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f319665b = null;

        public static EnumEntries<Reason> getEntries() {
            return f319665b;
        }

        static {
            Reason r100 = new Reason("EMPTY", 0);
            EMPTY = r100;
            Reason r101 = new Reason("TOO_LARGE", 1);
            TOO_LARGE = r101;
            Reason r102 = new Reason("INVALID_MJPEG_ENVELOPE", 2);
            INVALID_MJPEG_ENVELOPE = r102;
            Reason r103 = new Reason("INVALID_UTF8", 3);
            INVALID_UTF8 = r103;
            Reason r104 = new Reason("INVALID_JSON", 4);
            INVALID_JSON = r104;
            Reason r105 = new Reason("UNSUPPORTED_ENVELOPE", 5);
            UNSUPPORTED_ENVELOPE = r105;
            Reason r110 = new Reason("INVALID_CDP_EVENT", 6);
            INVALID_CDP_EVENT = r110;
            Reason[] r111 = {r100, r101, r102, r103, r104, r105, r110};
            f319664a = r111;
            f319665b = EnumEntriesKt.enumEntries(r111);
        }

        public static Reason[] values() {
            return (Reason[]) f319664a.clone();
        }

        public static Reason valueOf(String r100) {
            return (Reason) r27.a.a(Reason.class, r100);
        }

        public Reason(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static abstract class a {

        /* JADX INFO: renamed from: com.larus.browsertakeover.transport.RtpCdpMessageCodec$a$a, reason: collision with other inner class name */
        public static final class C4140a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final JSONObject f319666a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f319667b;

            public C4140a(JSONObject r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "event");
                Intrinsics.checkNotNullParameter(r101, "framing");
                this.f319666a = r100;
                this.f319667b = r101;
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Reason f319668a;

            public b(Reason r100) {
                Intrinsics.checkNotNullParameter(r100, "reason");
                this.f319668a = r100;
            }
        }

        public a() {
        }
    }

    static {
        f319663a = new RtpCdpMessageCodec();
    }

    public RtpCdpMessageCodec() {
    }

    public static boolean a(JSONObject r100) {
        if (r100.has("id") == false) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(r100.opt(com.alipay.sdk.m.p.e.f25671s), "Page.screencastFrame") == false) goto L9;
        if ((r100.opt("params") instanceof JSONObject) == false) goto L9;
        return true;
    }

    public static JSONObject b(String r100) {
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L14
        JSONTokener r103 = new JSONTokener(r100);     // Catch: Throwable -> L14
        Object r104 = r103.nextValue();     // Catch: Throwable -> L14
        if ((r104 instanceof JSONObject) == false) goto L6;
        JSONObject r105 = (JSONObject) r104;     // Catch: Throwable -> L14
    L7:
        if (r105 != null) goto L10;
    L11:
        r105 = null;
    L12:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L14
    L17:
        if (Result.m9455isFailureimpl(r106) == true) goto L21;
        r101 = r106;
    L21:
        return (JSONObject) r101;
    L10:
        if (r103.nextClean() == 0) goto L12;
    L6:
        r105 = null;
    L14:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
