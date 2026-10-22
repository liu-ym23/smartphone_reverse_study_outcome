package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class OpAfterError extends Message<OpAfterError, Builder> {
    public static final ProtoAdapter<OpAfterError> ADAPTER = null;
    public static final OpType DEFAULT_OP_TYPE = null;
    public static final String DEFAULT_PARAMS = "";
    public static final String DEFAULT_TEXT = "";
    private static final long serialVersionUID = 0;
    public final OpType op_type;
    public final String params;
    public final String text;

    public static final class Builder extends Message.Builder<OpAfterError, Builder> {
        public OpType op_type;
        public String params;
        public String text;

        @Override // com.squareup.wire.Message.Builder
        public OpAfterError build() {
            return new OpAfterError(this.op_type, this.text, this.params, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder op_type(OpType r100) {
            this.op_type = r100;
            return this;
        }

        public Builder params(String r100) {
            this.params = r100;
            return this;
        }

        public Builder text(String r100) {
            this.text = r100;
            return this;
        }
    }

    public static final enum OpType extends Enum<OpType> implements WireEnum {
        private static final /* synthetic */ OpType[] $VALUES = null;
        public static final ProtoAdapter<OpType> ADAPTER = null;
        public static final OpType IGNORE_QUOTA_SEARCH = null;
        private final int value;

        static {
            OpType r100 = new OpType("IGNORE_QUOTA_SEARCH", 0, 1);
            IGNORE_QUOTA_SEARCH = r100;
            $VALUES = new OpType[]{r100};
            ADAPTER = ProtoAdapter.newEnumAdapter(OpType.class);
        }

        public static OpType[] values() {
            return (OpType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static OpType fromValue(int r100) {
            if (r100 == 1) goto L7;
            return null;
        L7:
            return IGNORE_QUOTA_SEARCH;
        }

        public static OpType valueOf(String r100) {
            return (OpType) a.a(OpType.class, r100);
        }

        private OpType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_OpAfterError extends ProtoAdapter<OpAfterError> {
        public ProtoAdapter_OpAfterError() {
            super(FieldEncoding.LENGTH_DELIMITED, OpAfterError.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OpAfterError decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.op_type = OpType.IGNORE_QUOTA_SEARCH;
            r101.text = "";
            r101.params = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.op_type = OpType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.params = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(OpAfterError r100) {
            OpType r101 = r100.op_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = OpType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.text;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.params;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ OpAfterError decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OpAfterError r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OpAfterError r101) throws IOException {
            OpType r102 = r101.op_type;
            if (r102 == null) goto L5;
            OpType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.text;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.params;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OpAfterError r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OpAfterError();
        DEFAULT_OP_TYPE = OpType.IGNORE_QUOTA_SEARCH;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.op_type = this.op_type;
        r100.text = this.text;
        r100.params = this.params;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OpAfterError.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OpAfterError(OpType r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public OpAfterError(OpType r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.op_type = r100;
        this.text = r101;
        this.params = r102;
    }
}
