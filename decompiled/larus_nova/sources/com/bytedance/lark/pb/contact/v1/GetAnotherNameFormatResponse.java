package com.bytedance.lark.pb.contact.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetAnotherNameFormatResponse extends Message<GetAnotherNameFormatResponse, Builder> {
    public static final ProtoAdapter<GetAnotherNameFormatResponse> ADAPTER = null;
    public static final FormatRule DEFAULT_RULE = null;
    public static final ProtoAdapter_GetAnotherNameFormatResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final FormatRule rule;

    public static final class Builder extends Message.Builder<GetAnotherNameFormatResponse, Builder> implements d<GetAnotherNameFormatResponse> {
        public FormatRule rule;

        @Override // com.squareup.wire.Message.Builder
        public GetAnotherNameFormatResponse build() {
            return new GetAnotherNameFormatResponse(this.rule, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder rule(FormatRule r100) {
            this.rule = r100;
            return this;
        }
    }

    public static final enum FormatRule extends Enum<FormatRule> implements WireEnum {
        private static final /* synthetic */ FormatRule[] $VALUES = null;
        public static final ProtoAdapter<FormatRule> ADAPTER = null;
        public static final FormatRule ANOTHER_NAME_FIRST = null;
        public static final FormatRule NAME_FIRST = null;
        public static final FormatRule UNKNOWN = null;
        private final int value;

        static {
            FormatRule r100 = new FormatRule("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            FormatRule r101 = new FormatRule("NAME_FIRST", 1, 1);
            NAME_FIRST = r101;
            FormatRule r102 = new FormatRule("ANOTHER_NAME_FIRST", 2, 2);
            ANOTHER_NAME_FIRST = r102;
            $VALUES = new FormatRule[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(FormatRule.class);
        }

        public static FormatRule[] values() {
            return (FormatRule[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static FormatRule fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return ANOTHER_NAME_FIRST;
        L12:
            return NAME_FIRST;
        L14:
            return UNKNOWN;
        }

        public static FormatRule valueOf(String r100) {
            return (FormatRule) a.a(FormatRule.class, r100);
        }

        private FormatRule(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_GetAnotherNameFormatResponse extends ProtoAdapter<GetAnotherNameFormatResponse> implements c<GetAnotherNameFormatResponse> {
        public ProtoAdapter_GetAnotherNameFormatResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetAnotherNameFormatResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetAnotherNameFormatResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.rule = FormatRule.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.rule = FormatRule.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetAnotherNameFormatResponse r100) {
            FormatRule r101 = r100.rule;
            if (r101 == null) goto L5;
            int r102 = FormatRule.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetAnotherNameFormatResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetAnotherNameFormatResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetAnotherNameFormatResponse r101) throws IOException {
            FormatRule r102 = r101.rule;
            if (r102 == null) goto L5;
            FormatRule.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetAnotherNameFormatResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetAnotherNameFormatResponse r100 = new ProtoAdapter_GetAnotherNameFormatResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_RULE = FormatRule.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.rule = this.rule;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetAnotherNameFormatResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetAnotherNameFormatResponse(FormatRule r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetAnotherNameFormatResponse(FormatRule r100, ByteString r101) {
        super(ADAPTER, r101);
        this.rule = r100;
    }
}
