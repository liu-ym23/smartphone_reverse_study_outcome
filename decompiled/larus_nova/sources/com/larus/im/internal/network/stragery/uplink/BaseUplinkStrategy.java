package com.larus.im.internal.network.stragery.uplink;

import android.os.SystemClock;
import com.larus.im.callback.IMError;
import com.larus.im.internal.network.NetworkCommonAbility;
import com.larus.im.internal.network.channel.g;
import com.larus.im.internal.network.channel.i;
import com.larus.im.internal.protocol.bean.DownlinkBody;
import com.larus.im.internal.protocol.bean.DownlinkMessage;
import com.larus.im.internal.protocol.bean.UplinkMessage;
import com.larus.im.internal.protocol.bean.UplinkMessageChannel;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseUplinkStrategy {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<BaseUplinkStrategy> f349542f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final MessageSseUplinkStrategy f349543g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final MessageUplinkStrategy f349544h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vt7.a<String, d> f349545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f349546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f349547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vt7.b<b> f349548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<DownlinkMessage, Unit> f349549e;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.im.internal.network.stragery.uplink.BaseUplinkStrategy$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes30.dex */
        public /* synthetic */ class C4370a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f349550a = null;

            static {
                int[] r100 = new int[UplinkMessageChannel.values().length];
                r100[UplinkMessageChannel.SSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                f349550a = r100;
            }
        }
    }

    public interface b {
        void a(DownlinkBody r100);
    }

    /* JADX INFO: loaded from: classes30.dex */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f349551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f349552b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f349553c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.larus.im.internal.network.e<DownlinkMessage> f349554d;

        public c() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f349551a == r101.f349551a) goto L12;
            return false;
        L12:
            if (this.f349552b == r101.f349552b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f349553c, r101.f349553c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f349554d, r101.f349554d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            if (this.f349551a == false) goto L5;
            int r100 = 1231;
        L7:
            return (((((r100 * 31) + this.f349552b) * 31) + this.f349553c.hashCode()) * 31) + this.f349554d.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "ResponseInfo(byHttp=" + this.f349551a + ", retryTimes=" + this.f349552b + ", logId=" + this.f349553c + ", downlink=" + this.f349554d + ')';
        }

        public /* synthetic */ c(int r100) {
            this(false, 0, "", new com.larus.im.internal.network.e.g(new IMError(-1, "CHUNK_REQ_TIMEOUT", null, null, 12, null), 2));
        }

        public c(boolean r100, int r101, String r102, com.larus.im.internal.network.e<DownlinkMessage> r103) {
            Intrinsics.checkNotNullParameter(r102, "logId");
            Intrinsics.checkNotNullParameter(r103, "downlink");
            this.f349551a = r100;
            this.f349552b = r101;
            this.f349553c = r102;
            this.f349554d = r103;
        }
    }

    /* JADX INFO: loaded from: classes30.dex */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UplinkMessage f349555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f349556b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f349557c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Function1<? super c, Unit> f349558d;

        public d() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f349555a, r101.f349555a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f349556b, r101.f349556b) == true) goto L15;
            return false;
        L15:
            if (this.f349557c == r101.f349557c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f349558d, r101.f349558d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f349555a.hashCode() * 31) + this.f349556b.hashCode()) * 31;
            long r101 = this.f349557c;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            Function1<? super c, Unit> r103 = this.f349558d;
            if (r103 != null) goto L5;
            int r104 = 0;
        L7:
            return r102 + r104;
        L5:
            r104 = r103.hashCode();
            goto L7
        }

        public final String toString() {
            return "UplinkingInfo(uplink=" + this.f349555a + ", seqId=" + this.f349556b + ", sendStartTime=" + this.f349557c + ", ackCallback=" + this.f349558d + ')';
        }

        public d(UplinkMessage r100) {
            String r101 = r100.sequenceId;
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            long r102 = SystemClock.elapsedRealtime();
            Intrinsics.checkNotNullParameter(r100, "uplink");
            Intrinsics.checkNotNullParameter(r101, "seqId");
            this.f349555a = r100;
            this.f349556b = r101;
            this.f349557c = r102;
            this.f349558d = null;
        }
    }

    public abstract void a(DownlinkMessage r100);

    public abstract Object b(UplinkMessage r100, boolean r101, Continuation<? super com.larus.im.internal.network.e<DownlinkBody>> r102);

    static {
        ConcurrentLinkedQueue<BaseUplinkStrategy> r100 = new ConcurrentLinkedQueue();
        f349542f = r100;
        MessageSseUplinkStrategy r101 = new MessageSseUplinkStrategy();
        f349543g = r101;
        MessageUplinkStrategy r102 = new MessageUplinkStrategy();
        f349544h = r102;
        r100.add(r102);
        r100.add(r101);
    }

    public BaseUplinkStrategy() {
        this.f349545a = new vt7.a();
        NetworkCommonAbility r100 = NetworkCommonAbility.f349012a;
        this.f349546b = NetworkCommonAbility.f349014c;
        this.f349547c = NetworkCommonAbility.f349015d;
        this.f349548d = new vt7.b();
        this.f349549e = new BaseUplinkStrategy$wsReceiveListener$1(this);
    }
}
