package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullRenderDSLTemplatesRequest extends Message<PullRenderDSLTemplatesRequest, Builder> {
    public static final ProtoAdapter<PullRenderDSLTemplatesRequest> ADAPTER = null;
    public static final Boolean DEFAULT_IS_QUERY_TEMPLATE = null;
    public static final String DEFAULT_LOCALE = "";
    public static final ByteString DEFAULT_TEMPLATES = null;
    private static final long serialVersionUID = 0;
    public final Boolean mis_query_template;
    public final String mlocale;
    public final ByteString mtemplates;

    public static final class Builder extends Message.Builder<PullRenderDSLTemplatesRequest, Builder> {
        public Boolean mis_query_template;
        public String mlocale;
        public ByteString mtemplates;

        @Override // com.squareup.wire.Message.Builder
        public PullRenderDSLTemplatesRequest build() {
            return new PullRenderDSLTemplatesRequest(this.mlocale, this.mtemplates, this.mis_query_template, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_query_template(Boolean r100) {
            this.mis_query_template = r100;
            return this;
        }

        public Builder locale(String r100) {
            this.mlocale = r100;
            return this;
        }

        public Builder templates(ByteString r100) {
            this.mtemplates = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullRenderDSLTemplatesRequest extends ProtoAdapter<PullRenderDSLTemplatesRequest> {
        public ProtoAdapter_PullRenderDSLTemplatesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullRenderDSLTemplatesRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullRenderDSLTemplatesRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mlocale = "";
            r101.mtemplates = ByteString.EMPTY;
            r101.mis_query_template = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mlocale = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mtemplates = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mis_query_template = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(PullRenderDSLTemplatesRequest r100) {
            String r101 = r100.mlocale;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ByteString r104 = r100.mtemplates;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BYTES.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.mis_query_template;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ PullRenderDSLTemplatesRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullRenderDSLTemplatesRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullRenderDSLTemplatesRequest r101) throws IOException {
            String r102 = r101.mlocale;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ByteString r103 = r101.mtemplates;
            if (r103 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.mis_query_template;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullRenderDSLTemplatesRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullRenderDSLTemplatesRequest();
        DEFAULT_TEMPLATES = ByteString.EMPTY;
        DEFAULT_IS_QUERY_TEMPLATE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mlocale = this.mlocale;
        r100.mtemplates = this.mtemplates;
        r100.mis_query_template = this.mis_query_template;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullRenderDSLTemplatesRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullRenderDSLTemplatesRequest(String r100, ByteString r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PullRenderDSLTemplatesRequest(String r100, ByteString r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mlocale = r100;
        this.mtemplates = r101;
        this.mis_query_template = r102;
    }
}
