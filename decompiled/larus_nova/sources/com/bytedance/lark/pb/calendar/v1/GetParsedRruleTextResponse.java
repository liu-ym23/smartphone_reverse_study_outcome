package com.bytedance.lark.pb.calendar.v1;

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
public final class GetParsedRruleTextResponse extends Message<GetParsedRruleTextResponse, Builder> {
    public static final ProtoAdapter<GetParsedRruleTextResponse> ADAPTER = null;
    public static final String DEFAULT_FREQ_PART = "";
    public static final String DEFAULT_PARSED_RRULE = "";
    public static final String DEFAULT_UNTIL_PART = "";
    public static final ProtoAdapter_GetParsedRruleTextResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String freq_part;
    public final String parsed_rrule;
    public final String until_part;

    public static final class Builder extends Message.Builder<GetParsedRruleTextResponse, Builder> implements d<GetParsedRruleTextResponse> {
        public String freq_part;
        public String parsed_rrule;
        public String until_part;

        @Override // com.squareup.wire.Message.Builder
        public GetParsedRruleTextResponse build() {
            String r100 = this.parsed_rrule;
            if (r100 == null) goto L7;
            return new GetParsedRruleTextResponse(this.parsed_rrule, this.freq_part, this.until_part, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "parsed_rrule"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder freq_part(String r100) {
            this.freq_part = r100;
            return this;
        }

        public Builder parsed_rrule(String r100) {
            this.parsed_rrule = r100;
            return this;
        }

        public Builder until_part(String r100) {
            this.until_part = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetParsedRruleTextResponse extends ProtoAdapter<GetParsedRruleTextResponse> implements c<GetParsedRruleTextResponse> {
        public ProtoAdapter_GetParsedRruleTextResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetParsedRruleTextResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetParsedRruleTextResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.parsed_rrule = "";
            r101.freq_part = "";
            r101.until_part = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.parsed_rrule = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.freq_part = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.until_part = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(GetParsedRruleTextResponse r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.parsed_rrule);
            String r103 = r100.freq_part;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.until_part;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(3, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetParsedRruleTextResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetParsedRruleTextResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetParsedRruleTextResponse r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.parsed_rrule);
            String r103 = r101.freq_part;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.until_part;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetParsedRruleTextResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetParsedRruleTextResponse r100 = new ProtoAdapter_GetParsedRruleTextResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.parsed_rrule = this.parsed_rrule;
        r100.freq_part = this.freq_part;
        r100.until_part = this.until_part;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetParsedRruleTextResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetParsedRruleTextResponse(String r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetParsedRruleTextResponse(String r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.parsed_rrule = r100;
        this.freq_part = r101;
        this.until_part = r102;
    }
}
