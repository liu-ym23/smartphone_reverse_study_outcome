package com.google.protobuf;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final class MethodOptions extends com.squareup.wire.Message<MethodOptions, Builder> {
    public static final ProtoAdapter<MethodOptions> ADAPTER = null;
    public static final Boolean DEFAULT_DEPRECATED = null;
    public static final IdempotencyLevel DEFAULT_IDEMPOTENCY_LEVEL = null;
    private static final long serialVersionUID = 0;
    public final Boolean deprecated;
    public final IdempotencyLevel idempotency_level;
    public final List<UninterpretedOption> uninterpreted_option;

    public static final class Builder extends com.squareup.wire.Message.Builder<MethodOptions, Builder> {
        public Boolean deprecated;
        public IdempotencyLevel idempotency_level;
        public List<UninterpretedOption> uninterpreted_option;

        @Override // com.squareup.wire.Message.Builder
        public MethodOptions build() {
            return new MethodOptions(this.deprecated, this.idempotency_level, this.uninterpreted_option, super.buildUnknownFields());
        }

        public Builder() {
            this.uninterpreted_option = com.squareup.wire.internal.Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder deprecated(Boolean r100) {
            this.deprecated = r100;
            return this;
        }

        public Builder idempotency_level(IdempotencyLevel r100) {
            this.idempotency_level = r100;
            return this;
        }

        public Builder uninterpreted_option(List<UninterpretedOption> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.uninterpreted_option = r100;
            return this;
        }
    }

    public static final enum IdempotencyLevel extends java.lang.Enum<IdempotencyLevel> implements WireEnum {
        private static final /* synthetic */ IdempotencyLevel[] $VALUES = null;
        public static final ProtoAdapter<IdempotencyLevel> ADAPTER = null;
        public static final IdempotencyLevel IDEMPOTENCY_UNKNOWN = null;
        public static final IdempotencyLevel IDEMPOTENT = null;
        public static final IdempotencyLevel NO_SIDE_EFFECTS = null;
        private final int value;

        static {
            IdempotencyLevel r100 = new IdempotencyLevel("IDEMPOTENCY_UNKNOWN", 0, 0);
            IDEMPOTENCY_UNKNOWN = r100;
            IdempotencyLevel r101 = new IdempotencyLevel("NO_SIDE_EFFECTS", 1, 1);
            NO_SIDE_EFFECTS = r101;
            IdempotencyLevel r102 = new IdempotencyLevel("IDEMPOTENT", 2, 2);
            IDEMPOTENT = r102;
            $VALUES = new IdempotencyLevel[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(IdempotencyLevel.class);
        }

        public static IdempotencyLevel[] values() {
            return (IdempotencyLevel[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static IdempotencyLevel fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return IDEMPOTENT;
        L12:
            return NO_SIDE_EFFECTS;
        L14:
            return IDEMPOTENCY_UNKNOWN;
        }

        public static IdempotencyLevel valueOf(String r100) {
            return (IdempotencyLevel) a.a(IdempotencyLevel.class, r100);
        }

        private IdempotencyLevel(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_MethodOptions extends ProtoAdapter<MethodOptions> {
        public ProtoAdapter_MethodOptions() {
            super(FieldEncoding.LENGTH_DELIMITED, MethodOptions.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MethodOptions decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.deprecated = Boolean.FALSE;
            r101.idempotency_level = IdempotencyLevel.IDEMPOTENCY_UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 33) goto L8;
            r101.deprecated = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 34) goto L10;
            r101.idempotency_level = IdempotencyLevel.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 999) goto L11;
            r101.uninterpreted_option.add(UninterpretedOption.ADAPTER.decode(r100));
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
        public int encodedSize2(MethodOptions r100) {
            Boolean r101 = r100.deprecated;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(33, r101);
        L6:
            IdempotencyLevel r104 = r100.idempotency_level;
            if (r104 == null) goto L10;
            r102 = IdempotencyLevel.ADAPTER.encodedSizeWithTag(34, r104);
        L10:
            return ((r103 + r102) + UninterpretedOption.ADAPTER.asRepeated().encodedSizeWithTag(999, r100.uninterpreted_option)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MethodOptions decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MethodOptions r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MethodOptions r101) throws IOException {
            Boolean r102 = r101.deprecated;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 33, r102);
        L5:
            IdempotencyLevel r103 = r101.idempotency_level;
            if (r103 == null) goto L8;
            IdempotencyLevel.ADAPTER.encodeWithTag(r100, 34, r103);
        L8:
            UninterpretedOption.ADAPTER.asRepeated().encodeWithTag(r100, 999, r101.uninterpreted_option);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MethodOptions r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MethodOptions();
        DEFAULT_DEPRECATED = Boolean.FALSE;
        DEFAULT_IDEMPOTENCY_LEVEL = IdempotencyLevel.IDEMPOTENCY_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.deprecated = this.deprecated;
        r100.idempotency_level = this.idempotency_level;
        r100.uninterpreted_option = com.squareup.wire.internal.Internal.copyOf("uninterpreted_option", this.uninterpreted_option);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MethodOptions.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public MethodOptions(Boolean r100, IdempotencyLevel r101, List<UninterpretedOption> r102) {
        this(r100, r101, r102, okio.ByteString.EMPTY);
    }

    public MethodOptions(Boolean r100, IdempotencyLevel r101, List<UninterpretedOption> r102, okio.ByteString r103) {
        super(ADAPTER, r103);
        this.deprecated = r100;
        this.idempotency_level = r101;
        this.uninterpreted_option = com.squareup.wire.internal.Internal.immutableCopyOf("uninterpreted_option", r102);
    }
}
