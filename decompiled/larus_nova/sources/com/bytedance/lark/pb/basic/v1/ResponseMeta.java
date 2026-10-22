package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ResponseMeta extends com.squareup.wire.Message<ResponseMeta, Builder> {
    public static final ProtoAdapter<ResponseMeta> ADAPTER = null;
    public static final Long DEFAULT_USER_ID = null;
    public static final Boolean DEFAULT_VERIFY_USER_ID = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> biz_response_meta;
    public final Long user_id;
    public final Boolean verify_user_id;

    public static final class Builder extends com.squareup.wire.Message.Builder<ResponseMeta, Builder> {
        public Map<String, String> biz_response_meta;
        public Long user_id;
        public Boolean verify_user_id;

        @Override // com.squareup.wire.Message.Builder
        public ResponseMeta build() {
            return new ResponseMeta(this.verify_user_id, this.user_id, this.biz_response_meta, super.buildUnknownFields());
        }

        public Builder() {
            this.biz_response_meta = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder biz_response_meta(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.biz_response_meta = r100;
            return this;
        }

        public Builder user_id(Long r100) {
            this.user_id = r100;
            return this;
        }

        public Builder verify_user_id(Boolean r100) {
            this.verify_user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ResponseMeta extends ProtoAdapter<ResponseMeta> {
        private final ProtoAdapter<Map<String, String>> biz_response_meta;

        public ProtoAdapter_ResponseMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, ResponseMeta.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.biz_response_meta = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ResponseMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.verify_user_id = Boolean.FALSE;
            r101.user_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.verify_user_id = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.user_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.biz_response_meta.putAll(this.biz_response_meta.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ResponseMeta r100) {
            Boolean r101 = r100.verify_user_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.user_id;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.UINT64.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + this.biz_response_meta.encodedSizeWithTag(3, r100.biz_response_meta)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ResponseMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ResponseMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ResponseMeta r101) throws IOException {
            Boolean r102 = r101.verify_user_id;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.user_id;
            if (r103 == null) goto L8;
            ProtoAdapter.UINT64.encodeWithTag(r100, 2, r103);
        L8:
            this.biz_response_meta.encodeWithTag(r100, 3, r101.biz_response_meta);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ResponseMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ResponseMeta();
        DEFAULT_VERIFY_USER_ID = Boolean.FALSE;
        DEFAULT_USER_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.verify_user_id = this.verify_user_id;
        r100.user_id = this.user_id;
        r100.biz_response_meta = Internal.copyOf("biz_response_meta", this.biz_response_meta);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ResponseMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ResponseMeta(Boolean r100, Long r101, Map<String, String> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ResponseMeta(Boolean r100, Long r101, Map<String, String> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.verify_user_id = r100;
        this.user_id = r101;
        this.biz_response_meta = Internal.immutableCopyOf("biz_response_meta", r102);
    }
}
