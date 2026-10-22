package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.obric.miniapp.alarm.AccountType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetMyGroupChatsRequest extends Message<GetMyGroupChatsRequest, Builder> {
    public static final ProtoAdapter<GetMyGroupChatsRequest> ADAPTER = null;
    public static final Integer DEFAULT_COUNT = null;
    public static final SyncDataStrategy DEFAULT_STRATEGY = null;
    public static final Long DEFAULT_TIME = null;
    public static final Type DEFAULT_TYPE = null;
    public static final ProtoAdapter_GetMyGroupChatsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Integer count;
    public final SyncDataStrategy strategy;
    public final Long time;
    public final Type type;

    public static final class Builder extends Message.Builder<GetMyGroupChatsRequest, Builder> implements d<GetMyGroupChatsRequest> {
        public Integer count;
        public SyncDataStrategy strategy;
        public Long time;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public GetMyGroupChatsRequest build() {
            Type r100 = this.type;
            if (r100 == null) goto L7;
            return new GetMyGroupChatsRequest(this.type, this.time, this.count, this.strategy, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder count(Integer r100) {
            this.count = r100;
            return this;
        }

        public Builder strategy(SyncDataStrategy r100) {
            this.strategy = r100;
            return this;
        }

        public Builder time(Long r100) {
            this.time = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetMyGroupChatsRequest extends ProtoAdapter<GetMyGroupChatsRequest> implements c<GetMyGroupChatsRequest> {
        public ProtoAdapter_GetMyGroupChatsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetMyGroupChatsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetMyGroupChatsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = Type.MANAGE;
            r101.time = 0L;
            r101.count = 20;
            r101.strategy = SyncDataStrategy.FORCE_SERVER;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetMyGroupChatsRequest r100) {
            int r101 = Type.ADAPTER.encodedSizeWithTag(1, r100.type);
            Long r102 = r100.time;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.INT64.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Integer r106 = r100.count;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.INT32.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            SyncDataStrategy r109 = r100.strategy;
            if (r109 == null) goto L14;
            r103 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(4, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetMyGroupChatsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetMyGroupChatsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetMyGroupChatsRequest r101) throws IOException {
            Type.ADAPTER.encodeWithTag(r100, 1, r101.type);
            Long r102 = r101.time;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r102);
        L5:
            Integer r103 = r101.count;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r103);
        L8:
            SyncDataStrategy r104 = r101.strategy;
            if (r104 == null) goto L11;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetMyGroupChatsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type ADMINISTRATE = null;
        public static final Type ALL = null;
        public static final Type JOIN = null;
        public static final Type MANAGE = null;
        private final int value;

        static {
            Type r100 = new Type("MANAGE", 0, 1);
            MANAGE = r100;
            Type r101 = new Type("JOIN", 1, 2);
            JOIN = r101;
            Type r102 = new Type("ADMINISTRATE", 2, 3);
            ADMINISTRATE = r102;
            Type r103 = new Type(AccountType.ALL, 3, 4);
            ALL = r103;
            $VALUES = new Type[]{r100, r101, r102, r103};
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
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return null;
        L13:
            return ALL;
        L15:
            return ADMINISTRATE;
        L17:
            return JOIN;
        L19:
            return MANAGE;
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
        ProtoAdapter_GetMyGroupChatsRequest r100 = new ProtoAdapter_GetMyGroupChatsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TYPE = Type.MANAGE;
        DEFAULT_TIME = 0L;
        DEFAULT_COUNT = 20;
        DEFAULT_STRATEGY = SyncDataStrategy.FORCE_SERVER;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.time = this.time;
        r100.count = this.count;
        r100.strategy = this.strategy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetMyGroupChatsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetMyGroupChatsRequest(Type r100, Long r101, Integer r102, SyncDataStrategy r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetMyGroupChatsRequest(Type r100, Long r101, Integer r102, SyncDataStrategy r103, ByteString r104) {
        super(ADAPTER, r104);
        this.type = r100;
        this.time = r101;
        this.count = r102;
        this.strategy = r103;
    }
}
