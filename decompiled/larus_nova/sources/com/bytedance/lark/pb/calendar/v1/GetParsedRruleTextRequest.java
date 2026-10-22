package com.bytedance.lark.pb.calendar.v1;

import com.bytedance.lark.pb.basic.v1.LanguageType;
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
public final class GetParsedRruleTextRequest extends Message<GetParsedRruleTextRequest, Builder> {
    public static final ProtoAdapter<GetParsedRruleTextRequest> ADAPTER = null;
    public static final LanguageType DEFAULT_LANGUAGE_TYPE = null;
    public static final String DEFAULT_RRULE = "";
    public static final String DEFAULT_TIMEZONE = "";
    public static final ProtoAdapter_GetParsedRruleTextRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final LanguageType language_type;
    public final String rrule;
    public final String timezone;

    public static final class Builder extends Message.Builder<GetParsedRruleTextRequest, Builder> implements d<GetParsedRruleTextRequest> {
        public LanguageType language_type;
        public String rrule;
        public String timezone;

        @Override // com.squareup.wire.Message.Builder
        public GetParsedRruleTextRequest build() {
            String r100 = this.rrule;
            if (r100 == null) goto L9;
            if (this.language_type == null) goto L9;
            return new GetParsedRruleTextRequest(this.rrule, this.language_type, this.timezone, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "rrule", this.language_type, "language_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder language_type(LanguageType r100) {
            this.language_type = r100;
            return this;
        }

        public Builder rrule(String r100) {
            this.rrule = r100;
            return this;
        }

        public Builder timezone(String r100) {
            this.timezone = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetParsedRruleTextRequest extends ProtoAdapter<GetParsedRruleTextRequest> implements c<GetParsedRruleTextRequest> {
        public ProtoAdapter_GetParsedRruleTextRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetParsedRruleTextRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetParsedRruleTextRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.rrule = "";
            r101.language_type = LanguageType.UNKNOWN_LANGUAGE;
            r101.timezone = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.rrule = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.language_type = LanguageType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.timezone = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetParsedRruleTextRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.rrule) + LanguageType.ADAPTER.encodedSizeWithTag(2, r100.language_type);
            String r103 = r100.timezone;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(3, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetParsedRruleTextRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetParsedRruleTextRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetParsedRruleTextRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.rrule);
            LanguageType.ADAPTER.encodeWithTag(r100, 2, r101.language_type);
            String r103 = r101.timezone;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetParsedRruleTextRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetParsedRruleTextRequest r100 = new ProtoAdapter_GetParsedRruleTextRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_LANGUAGE_TYPE = LanguageType.UNKNOWN_LANGUAGE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.rrule = this.rrule;
        r100.language_type = this.language_type;
        r100.timezone = this.timezone;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetParsedRruleTextRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetParsedRruleTextRequest(String r100, LanguageType r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetParsedRruleTextRequest(String r100, LanguageType r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.rrule = r100;
        this.language_type = r101;
        this.timezone = r102;
    }
}
