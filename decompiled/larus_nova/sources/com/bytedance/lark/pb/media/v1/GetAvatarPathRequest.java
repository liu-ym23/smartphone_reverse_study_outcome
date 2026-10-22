package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetAvatarPathRequest extends Message<GetAvatarPathRequest, Builder> {
    public static final ProtoAdapter<GetAvatarPathRequest> ADAPTER = null;
    public static final Float DEFAULT_DPR = null;
    public static final Integer DEFAULT_DP_SIZE = null;
    public static final String DEFAULT_ENTITY_ID = "";
    public static final String DEFAULT_FORMAT = "webp";
    public static final String DEFAULT_KEY = "";
    public static final ProtoAdapter_GetAvatarPathRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Integer dp_size;
    public final Float dpr;
    public final String entity_id;
    public final String format;
    public final String key;

    public static final class Builder extends Message.Builder<GetAvatarPathRequest, Builder> implements d<GetAvatarPathRequest> {
        public Integer dp_size;
        public Float dpr;
        public String entity_id;
        public String format;
        public String key;

        @Override // com.squareup.wire.Message.Builder
        public GetAvatarPathRequest build() {
            String r100 = this.key;
            if (r100 == null) goto L11;
            if (this.dp_size == null) goto L11;
            if (this.dpr == null) goto L11;
            return new GetAvatarPathRequest(this.entity_id, this.key, this.dp_size, this.dpr, this.format, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "key", this.dp_size, "dp_size", this.dpr, "dpr"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder dp_size(Integer r100) {
            this.dp_size = r100;
            return this;
        }

        public Builder dpr(Float r100) {
            this.dpr = r100;
            return this;
        }

        public Builder entity_id(String r100) {
            this.entity_id = r100;
            return this;
        }

        public Builder format(String r100) {
            this.format = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetAvatarPathRequest extends ProtoAdapter<GetAvatarPathRequest> implements c<GetAvatarPathRequest> {
        public ProtoAdapter_GetAvatarPathRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetAvatarPathRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetAvatarPathRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.entity_id = "";
            r101.key = "";
            r101.dp_size = 0;
            r101.dpr = Float.valueOf(0.0f);
            r101.format = "webp";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.entity_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.dp_size = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.dpr = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.format = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetAvatarPathRequest r100) {
            String r101 = r100.entity_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ProtoAdapter<String> r104 = ProtoAdapter.STRING;
            int r105 = ((r103 + r104.encodedSizeWithTag(2, r100.key)) + ProtoAdapter.INT32.encodedSizeWithTag(3, r100.dp_size)) + ProtoAdapter.FLOAT.encodedSizeWithTag(4, r100.dpr);
            String r106 = r100.format;
            if (r106 == null) goto L10;
            r102 = r104.encodedSizeWithTag(5, r106);
        L10:
            return (r105 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetAvatarPathRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetAvatarPathRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetAvatarPathRequest r101) throws IOException {
            String r102 = r101.entity_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            r103.encodeWithTag(r100, 2, r101.key);
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r101.dp_size);
            ProtoAdapter.FLOAT.encodeWithTag(r100, 4, r101.dpr);
            String r104 = r101.format;
            if (r104 == null) goto L8;
            r103.encodeWithTag(r100, 5, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetAvatarPathRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetAvatarPathRequest r100 = new ProtoAdapter_GetAvatarPathRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_DP_SIZE = 0;
        DEFAULT_DPR = Float.valueOf(0.0f);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.entity_id = this.entity_id;
        r100.key = this.key;
        r100.dp_size = this.dp_size;
        r100.dpr = this.dpr;
        r100.format = this.format;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetAvatarPathRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetAvatarPathRequest(String r100, String r101, Integer r110, Float r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public GetAvatarPathRequest(String r100, String r101, Integer r102, Float r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.entity_id = r100;
        this.key = r101;
        this.dp_size = r102;
        this.dpr = r103;
        this.format = r104;
    }
}
