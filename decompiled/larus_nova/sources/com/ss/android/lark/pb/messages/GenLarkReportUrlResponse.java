package com.ss.android.lark.pb.messages;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class GenLarkReportUrlResponse extends Message<GenLarkReportUrlResponse, Builder> {
    public static final ProtoAdapter<GenLarkReportUrlResponse> ADAPTER = null;
    public static final Boolean DEFAULT_OPEN_PC_CUSTOMIZED_WV = null;
    public static final String DEFAULT_REPORT_URL = "";
    private static final long serialVersionUID = 0;
    public final Boolean mopen_pc_customized_wv;
    public final String mreport_url;

    public static final class Builder extends Message.Builder<GenLarkReportUrlResponse, Builder> {
        public Boolean mopen_pc_customized_wv;
        public String mreport_url;

        @Override // com.squareup.wire.Message.Builder
        public GenLarkReportUrlResponse build() {
            String r100 = this.mreport_url;
            if (r100 == null) goto L7;
            return new GenLarkReportUrlResponse(this.mreport_url, this.mopen_pc_customized_wv, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mreport_url"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder open_pc_customized_wv(Boolean r100) {
            this.mopen_pc_customized_wv = r100;
            return this;
        }

        public Builder report_url(String r100) {
            this.mreport_url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GenLarkReportUrlResponse extends ProtoAdapter<GenLarkReportUrlResponse> {
        public ProtoAdapter_GenLarkReportUrlResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GenLarkReportUrlResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GenLarkReportUrlResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mreport_url = "";
            r101.mopen_pc_customized_wv = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mreport_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mopen_pc_customized_wv = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(GenLarkReportUrlResponse r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.mreport_url);
            Boolean r102 = r100.mopen_pc_customized_wv;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GenLarkReportUrlResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GenLarkReportUrlResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GenLarkReportUrlResponse r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.mreport_url);
            Boolean r102 = r101.mopen_pc_customized_wv;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GenLarkReportUrlResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GenLarkReportUrlResponse();
        DEFAULT_OPEN_PC_CUSTOMIZED_WV = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mreport_url = this.mreport_url;
        r100.mopen_pc_customized_wv = this.mopen_pc_customized_wv;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GenLarkReportUrlResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GenLarkReportUrlResponse(String r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GenLarkReportUrlResponse(String r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mreport_url = r100;
        this.mopen_pc_customized_wv = r101;
    }
}
