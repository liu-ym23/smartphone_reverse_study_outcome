package com.bytedance.lark.pb.vote.v1;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
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
public final class VoteOption extends Message<VoteOption, Builder> {
    public static final ProtoAdapter<VoteOption> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    public static final Integer DEFAULT_INDEX = null;
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String content;
    public final Integer index;
    public final Type type;

    public static final class Builder extends Message.Builder<VoteOption, Builder> {
        public String content;
        public Integer index;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public VoteOption build() {
            return new VoteOption(this.index, this.content, this.type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder content(String r100) {
            this.content = r100;
            return this;
        }

        public Builder index(Integer r100) {
            this.index = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_VoteOption extends ProtoAdapter<VoteOption> {
        public ProtoAdapter_VoteOption() {
            super(FieldEncoding.LENGTH_DELIMITED, VoteOption.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public VoteOption decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.index = 0;
            r101.content = "";
            r101.type = Type.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.index = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.content = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        public int encodedSize2(VoteOption r100) {
            Integer r101 = r100.index;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.content;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Type r107 = r100.type;
            if (r107 == null) goto L14;
            r102 = Type.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ VoteOption decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(VoteOption r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, VoteOption r101) throws IOException {
            Integer r102 = r101.index;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.content;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Type r104 = r101.type;
            if (r104 == null) goto L11;
            Type.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, VoteOption r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type TEXT = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type(CardAdapter.TEXT, 1, 1);
            TEXT = r101;
            $VALUES = new Type[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return TEXT;
        L10:
            return UNKNOWN;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_VoteOption();
        DEFAULT_INDEX = 0;
        DEFAULT_TYPE = Type.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.index = this.index;
        r100.content = this.content;
        r100.type = this.type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return VoteOption.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public VoteOption(Integer r100, String r101, Type r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public VoteOption(Integer r100, String r101, Type r102, ByteString r103) {
        super(ADAPTER, r103);
        this.index = r100;
        this.content = r101;
        this.type = r102;
    }
}
