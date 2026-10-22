package com.larus.im.internal.network.chunk;

import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.protocol.bean.FetchChunkMessageUplinkBody;
import com.larus.im.internal.protocol.bean.UplinkMessageChannel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UplinkMessageChannel f349106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f349107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f349108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FetchChunkMessageUplinkBody f349109d;

    public static final class a extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f349110e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f349111f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final MessageEntity f349112g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final FetchChunkMessageUplinkBody f349113h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f349110e, r101.f349110e) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f349111f, r101.f349111f) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f349112g, r101.f349112g) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f349113h, r101.f349113h) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f349110e.hashCode() * 31;
            String r101 = this.f349111f;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((((r100 + r102) * 31) + this.f349112g.hashCode()) * 31) + this.f349113h.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "HttpChunkFetchConfig(messageId=" + this.f349110e + ", chunkToken=" + this.f349111f + ", message=" + this.f349112g + ", uplinkBody=" + this.f349113h + ')';
        }

        @Override // com.larus.im.internal.network.chunk.e
        public final String a() {
            return this.f349111f;
        }

        @Override // com.larus.im.internal.network.chunk.e
        public final FetchChunkMessageUplinkBody b() {
            return this.f349113h;
        }

        public a(String r100, String r101, MessageEntity r102, FetchChunkMessageUplinkBody r103) {
            Intrinsics.checkNotNullParameter(r100, "messageId");
            Intrinsics.checkNotNullParameter(r102, "message");
            Intrinsics.checkNotNullParameter(r103, "uplinkBody");
            super(UplinkMessageChannel.DEFAULT, r100, r101, r103);
            this.f349110e = r100;
            this.f349111f = r101;
            this.f349112g = r102;
            this.f349113h = r103;
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f349114e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f349115f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final me9.b f349116g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final me9.a f349117h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final FetchChunkMessageUplinkBody f349118i;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f349114e, r101.f349114e) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f349115f, r101.f349115f) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f349116g, r101.f349116g) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f349117h, r101.f349117h) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f349118i, r101.f349118i) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f349114e.hashCode() * 31;
            String r101 = this.f349115f;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((r100 + r103) * 31) + this.f349116g.hashCode()) * 31;
            me9.a r105 = this.f349117h;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return ((r104 + r102) * 31) + this.f349118i.hashCode();
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "SseChunkFetchConfig(conversationId=" + this.f349114e + ", chunkToken=" + this.f349115f + ", launchMode=" + this.f349116g + ", retryConfig=" + this.f349117h + ", uplinkBody=" + this.f349118i + ')';
        }

        @Override // com.larus.im.internal.network.chunk.e
        public final String a() {
            return this.f349115f;
        }

        @Override // com.larus.im.internal.network.chunk.e
        public final FetchChunkMessageUplinkBody b() {
            return this.f349118i;
        }

        public b(String r100, String r101, me9.b r102, me9.a r103, FetchChunkMessageUplinkBody r104) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            Intrinsics.checkNotNullParameter(r102, "launchMode");
            Intrinsics.checkNotNullParameter(r104, "uplinkBody");
            super(UplinkMessageChannel.SSE, r100, r101, r104);
            this.f349114e = r100;
            this.f349115f = r101;
            this.f349116g = r102;
            this.f349117h = r103;
            this.f349118i = r104;
        }
    }

    public String a() {
        return this.f349108c;
    }

    public FetchChunkMessageUplinkBody b() {
        return this.f349109d;
    }

    public e(UplinkMessageChannel r100, String r101, String r102, FetchChunkMessageUplinkBody r103) {
        this.f349106a = r100;
        this.f349107b = r101;
        this.f349108c = r102;
        this.f349109d = r103;
    }
}
