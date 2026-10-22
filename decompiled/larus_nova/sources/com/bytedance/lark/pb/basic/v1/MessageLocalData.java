package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class MessageLocalData extends com.squareup.wire.Message<MessageLocalData, Builder> {
    public static final ProtoAdapter<MessageLocalData> ADAPTER = null;
    public static final String DEFAULT_JSON_DATA_STRING = "";
    public static final ByteString DEFAULT_PB_DATA = null;
    private static final long serialVersionUID = 0;
    public final String json_data_string;
    public final ByteString pb_data;

    public static final class Builder extends com.squareup.wire.Message.Builder<MessageLocalData, Builder> {
        public String json_data_string;
        public ByteString pb_data;

        @Override // com.squareup.wire.Message.Builder
        public MessageLocalData build() {
            return new MessageLocalData(this.json_data_string, this.pb_data, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder json_data_string(String r100) {
            this.json_data_string = r100;
            return this;
        }

        public Builder pb_data(ByteString r100) {
            this.pb_data = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MessageLocalData extends ProtoAdapter<MessageLocalData> {
        public ProtoAdapter_MessageLocalData() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageLocalData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MessageLocalData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.json_data_string = "";
            r101.pb_data = ByteString.EMPTY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.json_data_string = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.pb_data = ProtoAdapter.BYTES.decode(r100);
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
        public int encodedSize2(MessageLocalData r100) {
            String r101 = r100.json_data_string;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ByteString r104 = r100.pb_data;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.BYTES.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MessageLocalData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessageLocalData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessageLocalData r101) throws IOException {
            String r102 = r101.json_data_string;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ByteString r103 = r101.pb_data;
            if (r103 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageLocalData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageLocalData();
        DEFAULT_PB_DATA = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.json_data_string = this.json_data_string;
        r100.pb_data = this.pb_data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessageLocalData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessageLocalData(String r100, ByteString r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public MessageLocalData(String r100, ByteString r101, ByteString r102) {
        super(ADAPTER, r102);
        this.json_data_string = r100;
        this.pb_data = r101;
    }
}
