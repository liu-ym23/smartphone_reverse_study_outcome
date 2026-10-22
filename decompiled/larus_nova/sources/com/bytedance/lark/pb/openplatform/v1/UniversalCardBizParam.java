package com.bytedance.lark.pb.openplatform.v1;

import annotation.Debug;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class UniversalCardBizParam extends Message<UniversalCardBizParam, Builder> {
    public static final ProtoAdapter<UniversalCardBizParam> ADAPTER = null;
    public static final String DEFAULT_BIZ_ID = "";
    public static final Integer DEFAULT_BIZ_TYPE = null;
    public static final FieldOptions FIELD_OPTIONS_BIZ_ID = null;
    public static final FieldOptions FIELD_OPTIONS_BIZ_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String biz_id;
    public final Integer biz_type;

    public static final class Builder extends Message.Builder<UniversalCardBizParam, Builder> {
        public String biz_id;
        public Integer biz_type;

        @Override // com.squareup.wire.Message.Builder
        public UniversalCardBizParam build() {
            Integer r100 = this.biz_type;
            if (r100 == null) goto L9;
            if (this.biz_id == null) goto L9;
            return new UniversalCardBizParam(this.biz_type, this.biz_id, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "biz_type", this.biz_id, AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder biz_id(String r100) {
            this.biz_id = r100;
            return this;
        }

        public Builder biz_type(Integer r100) {
            this.biz_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UniversalCardBizParam extends ProtoAdapter<UniversalCardBizParam> {
        public ProtoAdapter_UniversalCardBizParam() {
            super(FieldEncoding.LENGTH_DELIMITED, UniversalCardBizParam.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UniversalCardBizParam decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.biz_type = 0;
            r101.biz_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.biz_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.biz_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(UniversalCardBizParam r100) {
            return (ProtoAdapter.INT32.encodedSizeWithTag(1, r100.biz_type) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.biz_id)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UniversalCardBizParam decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UniversalCardBizParam r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UniversalCardBizParam r101) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r101.biz_type);
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.biz_id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UniversalCardBizParam r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UniversalCardBizParam();
        FIELD_OPTIONS_BIZ_TYPE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_BIZ_ID = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_BIZ_TYPE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.biz_type = this.biz_type;
        r100.biz_id = this.biz_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UniversalCardBizParam.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UniversalCardBizParam(Integer r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public UniversalCardBizParam(Integer r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.biz_type = r100;
        this.biz_id = r101;
    }
}
