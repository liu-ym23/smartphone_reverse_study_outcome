package com.lark.wire;

import com.byted.cast.common.Constants;
import com.lark.wire.Message;
import com.lark.wire.Message.a;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 '*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0000*\u0014\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00020\u0004:\u0002&'B\u001f\b\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0016\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0017J\u000b\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0004J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0006\u0010\u001e\u001a\u00020\"J\u0006\u0010#\u001a\u00020\bJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%R\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068G¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u001c\u0010\u0007\u001a\u00020\b8WX\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u0007\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u00108\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/lark/wire/Message;", "M", "B", "Lcom/lark/wire/Message$Builder;", "Ljava/io/Serializable;", "adapter", "Lcom/lark/wire/ProtoAdapter;", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/wire/ProtoAdapter;Lokio/ByteString;)V", "()Lcom/lark/wire/ProtoAdapter;", "unknownFields$annotations", "()V", "()Lokio/ByteString;", "cachedSerializedSize", "", "getCachedSerializedSize$wire_runtime", "()I", "setCachedSerializedSize$wire_runtime", "(I)V", "hashCode", "newBuilder", "()Lcom/lark/wire/Message$Builder;", "withoutUnknownFields", "()Lcom/lark/wire/Message;", "toString", "", "writeReplace", "", "encode", "", Constants.ROLE_SINK, "Lokio/BufferedSink;", "", "encodeByteString", "stream", "Ljava/io/OutputStream;", "Builder", "Companion", "wire-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class Message<M extends Message<M, B>, B extends a<M, B>> implements Serializable {
    public static final b Companion = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient ProtoAdapter<M> f282712a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient ByteString f282713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient int f282714d;
    protected transient int hashCode;

    public static abstract class a<M extends Message<M, B>, B extends a<M, B>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient ByteString f282715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public transient Buffer f282716b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public transient j0 f282717c;

        public abstract M b();

        public final ByteString c() {
            Buffer r100 = this.f282716b;
            if (r100 == null) goto L6;
            Intrinsics.checkNotNull(r100);
            this.f282715a = r100.readByteString();
            this.f282716b = null;
            this.f282717c = null;
        L6:
            return this.f282715a;
        }

        public a() {
            this.f282715a = ByteString.EMPTY;
        }

        public final void a(ByteString r100) {
            Intrinsics.checkNotNullParameter(r100, "unknownFields");
            if (r100.size() > 0) goto L5;
            return;
        L5:
            if (this.f282716b != null) goto L7;
            this.f282716b = new Buffer();
            Buffer r101 = this.f282716b;
            Intrinsics.checkNotNull(r101);
            j0 r102 = new j0(r101);
            this.f282717c = r102;
            Intrinsics.checkNotNull(r102);
            r102.a(this.f282715a);
            this.f282715a = ByteString.EMPTY;
        L7:
            j0 r103 = this.f282717c;
            Intrinsics.checkNotNull(r103);
            r103.a(r100);
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    public static /* synthetic */ void unknownFields$annotations() {
    }

    public abstract B newBuilder();

    public final byte[] encode() {
        ProtoAdapter<M> r100 = this.f282712a;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type M of com.lark.wire.Message");
        r100.getClass();
        Buffer r101 = new Buffer();
        r100.h(r101, this);
        return r101.readByteArray();
    }

    public final ByteString encodeByteString() {
        ProtoAdapter<M> r100 = this.f282712a;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type M of com.lark.wire.Message");
        r100.getClass();
        Buffer r101 = new Buffer();
        r100.h(r101, this);
        return r101.readByteString();
    }

    public String toString() {
        ProtoAdapter<M> r100 = this.f282712a;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type M of com.lark.wire.Message");
        r100.getClass();
        return String.valueOf(this);
    }

    public ByteString unknownFields() {
        ByteString r100 = this.f282713c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return ByteString.EMPTY;
    }

    public final Object writeReplace() throws ObjectStreamException {
        byte[] r100 = encode();
        Class<?> r101 = getClass();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.lang.Class<M of com.lark.wire.Message>");
        return new MessageSerializedForm(r100, r101);
    }

    public final M withoutUnknownFields() {
        a r100 = newBuilder();
        r100.getClass();
        r100.f282715a = ByteString.EMPTY;
        Buffer r101 = r100.f282716b;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r101.clear();
        r100.f282716b = null;
    L5:
        r100.f282717c = null;
        return (M) r100.b();
    }

    public final ProtoAdapter<M> adapter() {
        return this.f282712a;
    }

    public final int getCachedSerializedSize$wire_runtime() {
        return this.f282714d;
    }

    public final void encode(OutputStream r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "stream");
        ProtoAdapter<M> r101 = this.f282712a;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type M of com.lark.wire.Message");
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "stream");
        BufferedSink r102 = Okio.buffer(Okio.sink(r100));
        r101.h(r102, this);
        r102.emit();
    }

    public final void setCachedSerializedSize$wire_runtime(int r100) {
        this.f282714d = r100;
    }

    public final void encode(BufferedSink r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        ProtoAdapter<M> r101 = this.f282712a;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type M of com.lark.wire.Message");
        r101.h(r100, this);
    }

    public Message(ProtoAdapter<M> r100, ByteString r101) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        Intrinsics.checkNotNullParameter(r101, "unknownFields");
        this.f282712a = r100;
        this.f282713c = r101;
    }
}
