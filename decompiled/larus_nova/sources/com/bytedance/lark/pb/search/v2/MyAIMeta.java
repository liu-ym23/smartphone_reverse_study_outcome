package com.bytedance.lark.pb.search.v2;

import com.bytedance.lark.pb.basic.v1.Chatter;
import com.google.protobuf.MessageOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class MyAIMeta extends Message<MyAIMeta, Builder> {
    public static final ProtoAdapter<MyAIMeta> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_P2P_CHAT_ID = "";
    public static final Chatter.Type DEFAULT_TYPE = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253723id;
    public final String p2p_chat_id;
    public final Chatter.Type type;

    public static final class Builder extends Message.Builder<MyAIMeta, Builder> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253724id;
        public String p2p_chat_id;
        public Chatter.Type type;

        @Override // com.squareup.wire.Message.Builder
        public MyAIMeta build() {
            return new MyAIMeta(this.f253724id, this.type, this.p2p_chat_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder id(String r100) {
            this.f253724id = r100;
            return this;
        }

        public Builder p2p_chat_id(String r100) {
            this.p2p_chat_id = r100;
            return this;
        }

        public Builder type(Chatter.Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MyAIMeta extends ProtoAdapter<MyAIMeta> {
        public ProtoAdapter_MyAIMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, MyAIMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MyAIMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253724id = "";
            r101.type = Chatter.Type.UNKNOWN;
            r101.p2p_chat_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.f253724id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.type = Chatter.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.p2p_chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MyAIMeta r100) {
            String r101 = r100.f253723id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Chatter.Type r104 = r100.type;
            if (r104 == null) goto L9;
            int r105 = Chatter.Type.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.p2p_chat_id;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MyAIMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MyAIMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MyAIMeta r101) throws IOException {
            String r102 = r101.f253723id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Chatter.Type r103 = r101.type;
            if (r103 == null) goto L8;
            Chatter.Type.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.p2p_chat_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MyAIMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MyAIMeta();
        MESSAGE_OPTIONS = new MessageOptions.Builder().deprecated(Boolean.TRUE).build();
        DEFAULT_TYPE = Chatter.Type.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253724id = this.f253723id;
        r100.type = this.type;
        r100.p2p_chat_id = this.p2p_chat_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MyAIMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MyAIMeta(String r100, Chatter.Type r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public MyAIMeta(String r100, Chatter.Type r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.f253723id = r100;
        this.type = r101;
        this.p2p_chat_id = r102;
    }
}
