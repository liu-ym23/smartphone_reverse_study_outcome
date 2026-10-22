package com.larus.browsertakeover.signaling;

import android.os.Handler;
import android.os.Looper;
import com.larus.im.internal.jni.bean.RoomMeta;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class LocalPcSignaling {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f319572a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/browsertakeover/signaling/LocalPcSignaling$Failure;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_TARGET", "HTTP_REJECTED", "INVALID_ROOM_META", "PEER_REJECTED", "TIMEOUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Failure extends Enum<Failure> {
        public static final Failure HTTP_REJECTED = null;
        public static final Failure INVALID_ROOM_META = null;
        public static final Failure INVALID_TARGET = null;
        public static final Failure PEER_REJECTED = null;
        public static final Failure TIMEOUT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Failure[] f319573a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f319574b = null;

        public static EnumEntries<Failure> getEntries() {
            return f319574b;
        }

        static {
            Failure r100 = new Failure("INVALID_TARGET", 0);
            INVALID_TARGET = r100;
            Failure r101 = new Failure("HTTP_REJECTED", 1);
            HTTP_REJECTED = r101;
            Failure r102 = new Failure("INVALID_ROOM_META", 2);
            INVALID_ROOM_META = r102;
            Failure r103 = new Failure("PEER_REJECTED", 3);
            PEER_REJECTED = r103;
            Failure r104 = new Failure("TIMEOUT", 4);
            TIMEOUT = r104;
            Failure[] r105 = {r100, r101, r102, r103, r104};
            f319573a = r105;
            f319574b = EnumEntriesKt.enumEntries(r105);
        }

        public static Failure[] values() {
            return (Failure[]) f319573a.clone();
        }

        public static Failure valueOf(String r100) {
            return (Failure) r27.a.a(Failure.class, r100);
        }

        public Failure(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void cancel();
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f319575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f319576b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f319577c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f319578d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<String, String> f319579e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Function1<? super RoomMeta, Unit> f319580f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Function1<? super Failure, Unit> f319581g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Handler f319582h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f319583i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f319584j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f319585k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f319586l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f319587m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final c f319588n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final f f319589o;

        public final void a() {
            if (this.f319584j == false) goto L5;
            return;
        L5:
            this.f319584j = true;
            this.f319582h.removeCallbacks(this.f319588n);
            if (this.f319587m == false) goto L9;
            this.f319587m = false;
            com.larus.im.d.b().unregisterDispatchCommandListener(this.f319589o);
        L9:
            this.f319580f = null;
            this.f319581g = null;
        }

        @Override // com.larus.browsertakeover.signaling.LocalPcSignaling.a
        public final void cancel() {
            c(new com.larus.browsertakeover.signaling.b(this));
        }

        public final void b(Failure r100) {
            if (this.f319584j == false) goto L5;
            return;
        L5:
            Function1<? super Failure, Unit> r101 = this.f319581g;
            a();
            if (r101 == null) goto L9;
            r101.invoke(r100);
            return;
        }

        public final void c(final Function0<Unit> r100) {
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
            r100.invoke();
            return;
        L5:
            this.f319582h.post(new d(r100));
        }

        /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.browsertakeover.signaling.c] */
        public b(String r100, int r101, String r102, String r103, Map r104, com.larus.browsertakeover.session.b r105, com.larus.browsertakeover.session.c r106) {
            Intrinsics.checkNotNullParameter(r100, "deviceId");
            Intrinsics.checkNotNullParameter(r102, "sourceDeviceId");
            Intrinsics.checkNotNullParameter(r103, "conversationId");
            this.f319575a = r100;
            this.f319576b = r101;
            this.f319577c = r102;
            this.f319578d = r103;
            this.f319579e = r104;
            this.f319580f = r105;
            this.f319581g = r106;
            this.f319582h = new Handler(Looper.getMainLooper());
            this.f319583i = UUID.randomUUID().toString();
            this.f319588n = new c(this);
            this.f319589o = new f(this);
        }
    }

    static {
    }
}
