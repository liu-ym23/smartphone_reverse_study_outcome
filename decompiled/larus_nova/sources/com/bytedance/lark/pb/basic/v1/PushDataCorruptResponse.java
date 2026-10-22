package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class PushDataCorruptResponse extends com.squareup.wire.Message<PushDataCorruptResponse, Builder> {
    public static final ProtoAdapter<PushDataCorruptResponse> ADAPTER = null;
    public static final String DEFAULT_DATABASE_URL = "";
    public static final String DEFAULT_ERROR_MESSAGE = "";
    public static final Reason DEFAULT_REASON = null;
    public static final Integer DEFAULT_SQLITE_ERROR_CODE = null;
    public static final ProtoAdapter_PushDataCorruptResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String database_url;
    public final String error_message;
    public final Reason reason;
    public final Integer sqlite_error_code;

    public static final class Builder extends com.squareup.wire.Message.Builder<PushDataCorruptResponse, Builder> implements b<PushDataCorruptResponse> {
        public String database_url;
        public String error_message;
        public Reason reason;
        public Integer sqlite_error_code;

        @Override // com.squareup.wire.Message.Builder
        public PushDataCorruptResponse build() {
            return new PushDataCorruptResponse(this.reason, this.error_message, this.sqlite_error_code, this.database_url, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder database_url(String r100) {
            this.database_url = r100;
            return this;
        }

        public Builder error_message(String r100) {
            this.error_message = r100;
            return this;
        }

        public Builder reason(Reason r100) {
            this.reason = r100;
            return this;
        }

        public Builder sqlite_error_code(Integer r100) {
            this.sqlite_error_code = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushDataCorruptResponse extends ProtoAdapter<PushDataCorruptResponse> implements a<PushDataCorruptResponse> {
        public ProtoAdapter_PushDataCorruptResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PushDataCorruptResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushDataCorruptResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.reason = Reason.DATABASE_CORRUPT;
            r101.error_message = "";
            r101.sqlite_error_code = 0;
            r101.database_url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 2) goto L8;
            r101.reason = Reason.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 3) goto L10;
            r101.error_message = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 4) goto L12;
            r101.sqlite_error_code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 5) goto L13;
            r101.database_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushDataCorruptResponse r100) {
            Reason r101 = r100.reason;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Reason.ADAPTER.encodedSizeWithTag(2, r101);
        L6:
            String r104 = r100.error_message;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(3, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.sqlite_error_code;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(4, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.database_url;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(5, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushDataCorruptResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushDataCorruptResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushDataCorruptResponse r101) throws IOException {
            Reason r102 = r101.reason;
            if (r102 == null) goto L5;
            Reason.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            String r103 = r101.error_message;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            Integer r104 = r101.sqlite_error_code;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r104);
        L11:
            String r105 = r101.database_url;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushDataCorruptResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Reason extends Enum<Reason> implements WireEnum {
        private static final /* synthetic */ Reason[] $VALUES = null;
        public static final ProtoAdapter<Reason> ADAPTER = null;
        public static final Reason DATABASE_CORRUPT = null;
        public static final Reason DATABASE_HOLD_BY_NOTHER_PROCESS = null;
        public static final Reason DISK_FULL = null;
        private final int value;

        static {
            Reason r100 = new Reason("DATABASE_CORRUPT", 0, 1);
            DATABASE_CORRUPT = r100;
            Reason r101 = new Reason("DISK_FULL", 1, 2);
            DISK_FULL = r101;
            Reason r102 = new Reason("DATABASE_HOLD_BY_NOTHER_PROCESS", 2, 3);
            DATABASE_HOLD_BY_NOTHER_PROCESS = r102;
            $VALUES = new Reason[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Reason.class);
        }

        public static Reason[] values() {
            return (Reason[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Reason fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return DATABASE_HOLD_BY_NOTHER_PROCESS;
        L13:
            return DISK_FULL;
        L15:
            return DATABASE_CORRUPT;
        }

        public static Reason valueOf(String r100) {
            return (Reason) r27.a.a(Reason.class, r100);
        }

        private Reason(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_PushDataCorruptResponse r100 = new ProtoAdapter_PushDataCorruptResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_REASON = Reason.DATABASE_CORRUPT;
        DEFAULT_SQLITE_ERROR_CODE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.reason = this.reason;
        r100.error_message = this.error_message;
        r100.sqlite_error_code = this.sqlite_error_code;
        r100.database_url = this.database_url;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushDataCorruptResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushDataCorruptResponse(Reason r100, String r101, Integer r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PushDataCorruptResponse(Reason r100, String r101, Integer r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.reason = r100;
        this.error_message = r101;
        this.sqlite_error_code = r102;
        this.database_url = r103;
    }
}
