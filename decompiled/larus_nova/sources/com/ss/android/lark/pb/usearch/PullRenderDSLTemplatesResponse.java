package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullRenderDSLTemplatesResponse extends Message<PullRenderDSLTemplatesResponse, Builder> {
    public static final ProtoAdapter<PullRenderDSLTemplatesResponse> ADAPTER = null;
    public static final ByteString DEFAULT_QUERY_TEMPLATE_INFO = null;
    private static final long serialVersionUID = 0;
    public final ByteString mquery_template_info;
    public final Map<String, String> mtemplates;

    public static final class Builder extends Message.Builder<PullRenderDSLTemplatesResponse, Builder> {
        public ByteString mquery_template_info;
        public Map<String, String> mtemplates;

        @Override // com.squareup.wire.Message.Builder
        public PullRenderDSLTemplatesResponse build() {
            return new PullRenderDSLTemplatesResponse(this.mtemplates, this.mquery_template_info, super.buildUnknownFields());
        }

        public Builder() {
            this.mtemplates = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder query_template_info(ByteString r100) {
            this.mquery_template_info = r100;
            return this;
        }

        public Builder templates(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mtemplates = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullRenderDSLTemplatesResponse extends ProtoAdapter<PullRenderDSLTemplatesResponse> {
        private final ProtoAdapter<Map<String, String>> mtemplates;

        public ProtoAdapter_PullRenderDSLTemplatesResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullRenderDSLTemplatesResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mtemplates = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullRenderDSLTemplatesResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mquery_template_info = ByteString.EMPTY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mtemplates.putAll(this.mtemplates.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mquery_template_info = ProtoAdapter.BYTES.decode(r100);
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
        public int encodedSize2(PullRenderDSLTemplatesResponse r100) {
            int r101 = this.mtemplates.encodedSizeWithTag(1, r100.mtemplates);
            ByteString r102 = r100.mquery_template_info;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BYTES.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullRenderDSLTemplatesResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullRenderDSLTemplatesResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullRenderDSLTemplatesResponse r101) throws IOException {
            this.mtemplates.encodeWithTag(r100, 1, r101.mtemplates);
            ByteString r102 = r101.mquery_template_info;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullRenderDSLTemplatesResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullRenderDSLTemplatesResponse();
        DEFAULT_QUERY_TEMPLATE_INFO = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtemplates = Internal.copyOf("mtemplates", this.mtemplates);
        r100.mquery_template_info = this.mquery_template_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullRenderDSLTemplatesResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullRenderDSLTemplatesResponse(Map<String, String> r100, ByteString r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PullRenderDSLTemplatesResponse(Map<String, String> r100, ByteString r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mtemplates = Internal.immutableCopyOf("mtemplates", r100);
        this.mquery_template_info = r101;
    }
}
