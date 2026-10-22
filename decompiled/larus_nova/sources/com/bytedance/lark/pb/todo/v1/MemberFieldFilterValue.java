package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class MemberFieldFilterValue extends Message<MemberFieldFilterValue, Builder> {
    public static final ProtoAdapter<MemberFieldFilterValue> ADAPTER = null;
    public static final Long DEFAULT_MEMBER_ID = null;
    public static final Type DEFAULT_MEMBER_TYPE = null;
    private static final long serialVersionUID = 0;
    public final Long member_id;
    public final Type member_type;

    public static final class Builder extends Message.Builder<MemberFieldFilterValue, Builder> {
        public Long member_id;
        public Type member_type;

        @Override // com.squareup.wire.Message.Builder
        public MemberFieldFilterValue build() {
            return new MemberFieldFilterValue(this.member_type, this.member_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder member_id(Long r100) {
            this.member_id = r100;
            return this;
        }

        public Builder member_type(Type r100) {
            this.member_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MemberFieldFilterValue extends ProtoAdapter<MemberFieldFilterValue> {
        public ProtoAdapter_MemberFieldFilterValue() {
            super(FieldEncoding.LENGTH_DELIMITED, MemberFieldFilterValue.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MemberFieldFilterValue decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.member_type = Type.UNKNOWN;
            r101.member_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.member_type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.member_id = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(MemberFieldFilterValue r100) {
            Type r101 = r100.member_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.member_id;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MemberFieldFilterValue decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MemberFieldFilterValue r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MemberFieldFilterValue r101) throws IOException {
            Type r102 = r101.member_type;
            if (r102 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.member_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MemberFieldFilterValue r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type APP = null;
        public static final Type UNKNOWN = null;
        public static final Type USER = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
            USER = r101;
            Type r102 = new Type("APP", 2, 2);
            APP = r102;
            $VALUES = new Type[]{r100, r101, r102};
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
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return APP;
        L12:
            return USER;
        L14:
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
        ADAPTER = new ProtoAdapter_MemberFieldFilterValue();
        DEFAULT_MEMBER_TYPE = Type.UNKNOWN;
        DEFAULT_MEMBER_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.member_type = this.member_type;
        r100.member_id = this.member_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MemberFieldFilterValue.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MemberFieldFilterValue(Type r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public MemberFieldFilterValue(Type r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.member_type = r100;
        this.member_id = r101;
    }
}
