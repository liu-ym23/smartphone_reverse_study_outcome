package com.bytedance.lark.pb.office_sdk.basic;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class DoubaoContent extends Message<DoubaoContent, Builder> {
    public static final ProtoAdapter<DoubaoContent> ADAPTER = null;
    public static final ByteString DEFAULT_DOUBAO_DATA = null;
    public static final Long DEFAULT_DOUBAO_MSG_ID = null;
    public static final Long DEFAULT_QUERY_MSG_ID = null;
    public static final Long DEFAULT_QUERY_MSG_OWNER_ID = null;
    private static final long serialVersionUID = 0;
    public final ByteString doubao_data;
    public final Long doubao_msg_id;
    public final Long query_msg_id;
    public final Long query_msg_owner_id;

    public static final class Builder extends Message.Builder<DoubaoContent, Builder> {
        public ByteString doubao_data;
        public Long doubao_msg_id;
        public Long query_msg_id;
        public Long query_msg_owner_id;

        @Override // com.squareup.wire.Message.Builder
        public DoubaoContent build() {
            return new DoubaoContent(this.doubao_msg_id, this.doubao_data, this.query_msg_id, this.query_msg_owner_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder doubao_data(ByteString r100) {
            this.doubao_data = r100;
            return this;
        }

        public Builder doubao_msg_id(Long r100) {
            this.doubao_msg_id = r100;
            return this;
        }

        public Builder query_msg_id(Long r100) {
            this.query_msg_id = r100;
            return this;
        }

        public Builder query_msg_owner_id(Long r100) {
            this.query_msg_owner_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DoubaoContent extends ProtoAdapter<DoubaoContent> {
        public ProtoAdapter_DoubaoContent() {
            super(FieldEncoding.LENGTH_DELIMITED, DoubaoContent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DoubaoContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.doubao_msg_id = 0L;
            r101.doubao_data = ByteString.EMPTY;
            r101.query_msg_id = 0L;
            r101.query_msg_owner_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.doubao_msg_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.doubao_data = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.query_msg_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.query_msg_owner_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DoubaoContent r100) {
            Long r101 = r100.doubao_msg_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            ByteString r104 = r100.doubao_data;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BYTES.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.query_msg_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.query_msg_owner_id;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DoubaoContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DoubaoContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DoubaoContent r101) throws IOException {
            Long r102 = r101.doubao_msg_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            ByteString r103 = r101.doubao_data;
            if (r103 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.query_msg_id;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.query_msg_owner_id;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DoubaoContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DoubaoContent();
        DEFAULT_DOUBAO_MSG_ID = 0L;
        DEFAULT_DOUBAO_DATA = ByteString.EMPTY;
        DEFAULT_QUERY_MSG_ID = 0L;
        DEFAULT_QUERY_MSG_OWNER_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.doubao_msg_id = this.doubao_msg_id;
        r100.doubao_data = this.doubao_data;
        r100.query_msg_id = this.query_msg_id;
        r100.query_msg_owner_id = this.query_msg_owner_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DoubaoContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DoubaoContent(Long r100, ByteString r101, Long r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public DoubaoContent(Long r100, ByteString r101, Long r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.doubao_msg_id = r100;
        this.doubao_data = r101;
        this.query_msg_id = r102;
        this.query_msg_owner_id = r103;
    }
}
