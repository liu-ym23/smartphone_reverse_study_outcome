package message_gateway.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class Message extends com.squareup.wire.Message<Message, Builder> {
    public static final ProtoAdapter<Message> ADAPTER = null;
    public static final ByteString DEFAULT_BODY = null;
    private static final long serialVersionUID = 0;
    public final ByteString body;
    public final List<Header> headers;

    public static final class Builder extends com.squareup.wire.Message.Builder<Message, Builder> {
        public ByteString body;
        public List<Header> headers;

        @Override // com.squareup.wire.Message.Builder
        public Message build() {
            return new Message(this.headers, this.body, super.buildUnknownFields());
        }

        public Builder() {
            this.headers = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder body(ByteString r100) {
            this.body = r100;
            return this;
        }

        public Builder headers(List<Header> r100) {
            Internal.checkElementsNotNull(r100);
            this.headers = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Message extends ProtoAdapter<Message> {
        public ProtoAdapter_Message() {
            super(FieldEncoding.LENGTH_DELIMITED, Message.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public Message decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.body = ByteString.EMPTY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.headers.add(Header.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.body = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Message r100) {
            int r101 = Header.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.headers);
            ByteString r102 = r100.body;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BYTES.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Message decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Message r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Message r101) throws IOException {
            Header.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.headers);
            ByteString r102 = r101.body;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Message r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Message();
        DEFAULT_BODY = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.headers = Internal.copyOf("headers", this.headers);
        r100.body = this.body;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Message.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Message(List<Header> r100, ByteString r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public Message(List<Header> r100, ByteString r101, ByteString r102) {
        super(ADAPTER, r102);
        this.headers = Internal.immutableCopyOf("headers", r100);
        this.body = r101;
    }
}
