package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class ChatSecurityConfig extends com.squareup.wire.Message<ChatSecurityConfig, Builder> {
    public static final ProtoAdapter<ChatSecurityConfig> ADAPTER = null;
    public static final Integer DEFAULT_LIMIT = null;
    public static final Boolean DEFAULT_OPEN_SECURITY = null;
    public static final Integer DEFAULT_URGENT_LIMIT = null;
    private static final long serialVersionUID = 0;
    public final Integer mlimit;
    public final Boolean mopen_security;
    public final Read mread;
    public final Integer murgent_limit;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatSecurityConfig, Builder> {
        public Integer mlimit;
        public Boolean mopen_security;
        public Read mread;
        public Integer murgent_limit;

        @Override // com.squareup.wire.Message.Builder
        public ChatSecurityConfig build() {
            return new ChatSecurityConfig(this.mopen_security, this.mlimit, this.mread, this.murgent_limit, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder limit(Integer r100) {
            this.mlimit = r100;
            return this;
        }

        public Builder open_security(Boolean r100) {
            this.mopen_security = r100;
            return this;
        }

        public Builder read(Read r100) {
            this.mread = r100;
            return this;
        }

        public Builder urgent_limit(Integer r100) {
            this.murgent_limit = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatSecurityConfig extends ProtoAdapter<ChatSecurityConfig> {
        public ProtoAdapter_ChatSecurityConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatSecurityConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatSecurityConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mopen_security = Boolean.FALSE;
            r101.mlimit = 0;
            r101.murgent_limit = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mopen_security = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mlimit = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mread = Read.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.murgent_limit = ProtoAdapter.INT32.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ChatSecurityConfig r100) {
            Boolean r101 = r100.mopen_security;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.mlimit;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Read r107 = r100.mread;
            if (r107 == null) goto L13;
            int r108 = Read.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Integer r110 = r100.murgent_limit;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ ChatSecurityConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatSecurityConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatSecurityConfig r101) throws IOException {
            Boolean r102 = r101.mopen_security;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.mlimit;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            Read r104 = r101.mread;
            if (r104 == null) goto L11;
            Read.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Integer r105 = r101.murgent_limit;
            if (r105 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatSecurityConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class Read extends com.squareup.wire.Message<Read, Builder> {
        public static final ProtoAdapter<Read> ADAPTER = null;
        public static final Integer DEFAULT_LIMIT = null;
        private static final long serialVersionUID = 0;
        public final Integer mlimit;
        public final ReadShowType mread_show_type;

        public static final class Builder extends com.squareup.wire.Message.Builder<Read, Builder> {
            public Integer mlimit;
            public ReadShowType mread_show_type;

            @Override // com.squareup.wire.Message.Builder
            public Read build() {
                return new Read(this.mread_show_type, this.mlimit, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder limit(Integer r100) {
                this.mlimit = r100;
                return this;
            }

            public Builder read_show_type(ReadShowType r100) {
                this.mread_show_type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Read extends ProtoAdapter<Read> {
            public ProtoAdapter_Read() {
                super(FieldEncoding.LENGTH_DELIMITED, Read.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Read decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mlimit = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.mread_show_type = ReadShowType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mlimit = ProtoAdapter.INT32.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Read r100) {
                ReadShowType r101 = r100.mread_show_type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ReadShowType.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.mlimit;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Read decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Read r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Read r101) throws IOException {
                ReadShowType r102 = r101.mread_show_type;
                if (r102 == null) goto L5;
                ReadShowType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.mlimit;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Read r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum ReadShowType extends Enum<ReadShowType> implements WireEnum {
            private static final /* synthetic */ ReadShowType[] $VALUES = null;
            public static final ProtoAdapter<ReadShowType> ADAPTER = null;
            public static final ReadShowType NO_LIMIT = null;
            public static final ReadShowType ONE_COLUMN_WITH_LIMIT = null;
            public static final ReadShowType TWO_COLUMN_WITH_LIMIT = null;
            public static final ReadShowType UNKNOWN = null;
            private final int value;

            static {
                ReadShowType r100 = new ReadShowType("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                ReadShowType r101 = new ReadShowType("NO_LIMIT", 1, 1);
                NO_LIMIT = r101;
                ReadShowType r102 = new ReadShowType("TWO_COLUMN_WITH_LIMIT", 2, 2);
                TWO_COLUMN_WITH_LIMIT = r102;
                ReadShowType r103 = new ReadShowType("ONE_COLUMN_WITH_LIMIT", 3, 3);
                ONE_COLUMN_WITH_LIMIT = r103;
                $VALUES = new ReadShowType[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(ReadShowType.class);
            }

            public static ReadShowType[] values() {
                return (ReadShowType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static ReadShowType fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return ONE_COLUMN_WITH_LIMIT;
            L14:
                return TWO_COLUMN_WITH_LIMIT;
            L16:
                return NO_LIMIT;
            L18:
                return UNKNOWN;
            }

            public static ReadShowType valueOf(String r100) {
                return (ReadShowType) a.a(ReadShowType.class, r100);
            }

            private ReadShowType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Read();
            DEFAULT_LIMIT = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mread_show_type = this.mread_show_type;
            r100.mlimit = this.mlimit;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Read.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Read(ReadShowType r100, Integer r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public Read(ReadShowType r100, Integer r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mread_show_type = r100;
            this.mlimit = r101;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatSecurityConfig();
        DEFAULT_OPEN_SECURITY = Boolean.FALSE;
        DEFAULT_LIMIT = 0;
        DEFAULT_URGENT_LIMIT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mopen_security = this.mopen_security;
        r100.mlimit = this.mlimit;
        r100.mread = this.mread;
        r100.murgent_limit = this.murgent_limit;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatSecurityConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatSecurityConfig(Boolean r100, Integer r101, Read r102, Integer r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public ChatSecurityConfig(Boolean r100, Integer r101, Read r102, Integer r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mopen_security = r100;
        this.mlimit = r101;
        this.mread = r102;
        this.murgent_limit = r103;
    }
}
