package com.ss.android.lark.pb.messages;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class GenLarkReportUrlRequest extends Message<GenLarkReportUrlRequest, Builder> {
    public static final ProtoAdapter<GenLarkReportUrlRequest> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final String DEFAULT_LANG_TYPE = "";
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final Long mchat_id;
    public final String mlang_type;

    public static final class Builder extends Message.Builder<GenLarkReportUrlRequest, Builder> {
        public Long mchat_id;
        public String mlang_type;

        @Override // com.squareup.wire.Message.Builder
        public GenLarkReportUrlRequest build() {
            Long r100 = this.mchat_id;
            if (r100 == null) goto L9;
            if (this.mlang_type == null) goto L9;
            return new GenLarkReportUrlRequest(this.mchat_id, this.mlang_type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "mchat_id", this.mlang_type, "mlang_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(Long r100) {
            this.mchat_id = r100;
            return this;
        }

        public Builder lang_type(String r100) {
            this.mlang_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GenLarkReportUrlRequest extends ProtoAdapter<GenLarkReportUrlRequest> {
        public ProtoAdapter_GenLarkReportUrlRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GenLarkReportUrlRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GenLarkReportUrlRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mchat_id = 0L;
            r101.mlang_type = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mchat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mlang_type = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(GenLarkReportUrlRequest r100) {
            return (ProtoAdapter.INT64.encodedSizeWithTag(1, r100.mchat_id) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.mlang_type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GenLarkReportUrlRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GenLarkReportUrlRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GenLarkReportUrlRequest r101) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.mchat_id);
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.mlang_type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GenLarkReportUrlRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GenLarkReportUrlRequest();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().FieldInfo("split,type=channel").build();
        DEFAULT_CHAT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mchat_id = this.mchat_id;
        r100.mlang_type = this.mlang_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GenLarkReportUrlRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GenLarkReportUrlRequest(Long r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GenLarkReportUrlRequest(Long r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mchat_id = r100;
        this.mlang_type = r101;
    }
}
