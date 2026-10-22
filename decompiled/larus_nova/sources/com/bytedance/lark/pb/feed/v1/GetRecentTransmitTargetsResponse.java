package com.bytedance.lark.pb.feed.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetRecentTransmitTargetsResponse extends Message<GetRecentTransmitTargetsResponse, Builder> {
    public static final ProtoAdapter<GetRecentTransmitTargetsResponse> ADAPTER = null;
    public static final ProtoAdapter_GetRecentTransmitTargetsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<RecentTransmitTarget> targets;

    public static final class Builder extends Message.Builder<GetRecentTransmitTargetsResponse, Builder> implements d<GetRecentTransmitTargetsResponse> {
        public List<RecentTransmitTarget> targets;

        @Override // com.squareup.wire.Message.Builder
        public GetRecentTransmitTargetsResponse build() {
            return new GetRecentTransmitTargetsResponse(this.targets, super.buildUnknownFields());
        }

        public Builder() {
            this.targets = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder targets(List<RecentTransmitTarget> r100) {
            Internal.checkElementsNotNull(r100);
            this.targets = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetRecentTransmitTargetsResponse extends ProtoAdapter<GetRecentTransmitTargetsResponse> implements c<GetRecentTransmitTargetsResponse> {
        public ProtoAdapter_GetRecentTransmitTargetsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetRecentTransmitTargetsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetRecentTransmitTargetsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.targets.add(RecentTransmitTarget.ADAPTER.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetRecentTransmitTargetsResponse r100) {
            return RecentTransmitTarget.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.targets) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetRecentTransmitTargetsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetRecentTransmitTargetsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetRecentTransmitTargetsResponse r101) throws IOException {
            RecentTransmitTarget.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.targets);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetRecentTransmitTargetsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class RecentTransmitTarget extends Message<RecentTransmitTarget, Builder> {
        public static final ProtoAdapter<RecentTransmitTarget> ADAPTER = null;
        public static final String DEFAULT_AVATAR_KEY = "";
        public static final String DEFAULT_CHATTER_ID = "";
        public static final String DEFAULT_CHAT_ID = "";
        public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
        public static final String DEFAULT_NAME = "";
        public static final TargetType DEFAULT_TARGET_TYPE = null;
        public static final String DEFAULT_THREAD_ID = "";
        public static final String DEFAULT_THREAD_SUB_TITLE = "";
        public static final Long DEFAULT_TIMESTAMP = null;
        private static final long serialVersionUID = 0;
        public final String avatar_key;
        public final String chat_id;
        public final String chatter_id;
        public final List<ExtType> ext_types;
        public final Boolean is_cross_tenant;
        public final String name;
        public final TargetType target_type;
        public final String thread_id;
        public final String thread_sub_title;
        public final Long timestamp;

        public static final class Builder extends Message.Builder<RecentTransmitTarget, Builder> {
            public String avatar_key;
            public String chat_id;
            public String chatter_id;
            public List<ExtType> ext_types;
            public Boolean is_cross_tenant;
            public String name;
            public TargetType target_type;
            public String thread_id;
            public String thread_sub_title;
            public Long timestamp;

            @Override // com.squareup.wire.Message.Builder
            public RecentTransmitTarget build() {
                TargetType r100 = this.target_type;
                if (r100 == null) goto L13;
                if (this.chat_id == null) goto L13;
                if (this.avatar_key == null) goto L13;
                if (this.name == null) goto L13;
                return new RecentTransmitTarget(this.target_type, this.chat_id, this.chatter_id, this.avatar_key, this.name, this.is_cross_tenant, this.ext_types, this.timestamp, this.thread_id, this.thread_sub_title, super.buildUnknownFields());
            L13:
                throw Internal.missingRequiredFields(new Object[]{r100, "target_type", this.chat_id, "chat_id", this.avatar_key, "avatar_key", this.name, "name"});
            }

            public Builder() {
                this.ext_types = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder avatar_key(String r100) {
                this.avatar_key = r100;
                return this;
            }

            public Builder chat_id(String r100) {
                this.chat_id = r100;
                return this;
            }

            public Builder chatter_id(String r100) {
                this.chatter_id = r100;
                return this;
            }

            public Builder ext_types(List<ExtType> r100) {
                Internal.checkElementsNotNull(r100);
                this.ext_types = r100;
                return this;
            }

            public Builder is_cross_tenant(Boolean r100) {
                this.is_cross_tenant = r100;
                return this;
            }

            public Builder name(String r100) {
                this.name = r100;
                return this;
            }

            public Builder target_type(TargetType r100) {
                this.target_type = r100;
                return this;
            }

            public Builder thread_id(String r100) {
                this.thread_id = r100;
                return this;
            }

            public Builder thread_sub_title(String r100) {
                this.thread_sub_title = r100;
                return this;
            }

            public Builder timestamp(Long r100) {
                this.timestamp = r100;
                return this;
            }
        }

        public static final enum ExtType extends Enum<ExtType> implements WireEnum {
            private static final /* synthetic */ ExtType[] $VALUES = null;
            public static final ProtoAdapter<ExtType> ADAPTER = null;
            public static final ExtType COMMON_TYPE = null;
            public static final ExtType ENCRYPTED_TYPE = null;
            public static final ExtType P2P_MY_AI_TYPE = null;
            public static final ExtType THREAD_TYPE = null;
            private final int value;

            static {
                ExtType r100 = new ExtType("COMMON_TYPE", 0, 0);
                COMMON_TYPE = r100;
                ExtType r101 = new ExtType("ENCRYPTED_TYPE", 1, 1);
                ENCRYPTED_TYPE = r101;
                ExtType r102 = new ExtType("P2P_MY_AI_TYPE", 2, 2);
                P2P_MY_AI_TYPE = r102;
                ExtType r103 = new ExtType("THREAD_TYPE", 3, 1000);
                THREAD_TYPE = r103;
                $VALUES = new ExtType[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(ExtType.class);
            }

            public static ExtType[] values() {
                return (ExtType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static ExtType fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 1000) goto L12;
                return null;
            L12:
                return THREAD_TYPE;
            L14:
                return P2P_MY_AI_TYPE;
            L16:
                return ENCRYPTED_TYPE;
            L18:
                return COMMON_TYPE;
            }

            public static ExtType valueOf(String r100) {
                return (ExtType) a.a(ExtType.class, r100);
            }

            private ExtType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_RecentTransmitTarget extends ProtoAdapter<RecentTransmitTarget> {
            public ProtoAdapter_RecentTransmitTarget() {
                super(FieldEncoding.LENGTH_DELIMITED, RecentTransmitTarget.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public RecentTransmitTarget decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.target_type = TargetType.UNKOWN_TYPE;
                r101.chat_id = "";
                r101.chatter_id = "";
                r101.avatar_key = "";
                r101.name = "";
                r101.is_cross_tenant = Boolean.FALSE;
                r101.timestamp = 0L;
                r101.thread_id = "";
                r101.thread_sub_title = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L23;
                switch(r103) {
                    case 1: goto L25;
                    case 2: goto L18;
                    case 3: goto L17;
                    case 4: goto L16;
                    case 5: goto L15;
                    case 6: goto L27;
                    case 7: goto L10;
                    case 8: goto L9;
                    case 9: goto L8;
                    case 10: goto L7;
                    default: goto L6;
                };
            L25:
                r101.target_type = TargetType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
            L21:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L27:
                r101.ext_types.add(ExtType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.thread_sub_title = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                r101.thread_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                r101.timestamp = ProtoAdapter.INT64.decode(r100);
                goto L3
            L10:
                r101.is_cross_tenant = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L15:
                r101.name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L16:
                r101.avatar_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L17:
                r101.chatter_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L18:
                r101.chat_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L23:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(RecentTransmitTarget r100) {
                int r101 = TargetType.ADAPTER.encodedSizeWithTag(1, r100.target_type);
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                int r103 = r101 + r102.encodedSizeWithTag(2, r100.chat_id);
                String r104 = r100.chatter_id;
                int r105 = 0;
                if (r104 == null) goto L5;
                int r106 = r102.encodedSizeWithTag(3, r104);
            L6:
                int r107 = ((r103 + r106) + r102.encodedSizeWithTag(4, r100.avatar_key)) + r102.encodedSizeWithTag(5, r100.name);
                Boolean r108 = r100.is_cross_tenant;
                if (r108 == null) goto L9;
                int r109 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r108);
            L10:
                int r110 = (r107 + r109) + ExtType.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.ext_types);
                Long r111 = r100.timestamp;
                if (r111 == null) goto L13;
                int r112 = ProtoAdapter.INT64.encodedSizeWithTag(8, r111);
            L14:
                int r113 = r110 + r112;
                String r114 = r100.thread_id;
                if (r114 == null) goto L17;
                int r115 = r102.encodedSizeWithTag(9, r114);
            L18:
                int r116 = r113 + r115;
                String r117 = r100.thread_sub_title;
                if (r117 == null) goto L22;
                r105 = r102.encodedSizeWithTag(10, r117);
            L22:
                return (r116 + r105) + r100.unknownFields().size();
            L17:
                r115 = 0;
                goto L18
            L13:
                r112 = 0;
                goto L14
            L9:
                r109 = 0;
                goto L10
            L5:
                r106 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ RecentTransmitTarget decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(RecentTransmitTarget r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, RecentTransmitTarget r101) throws IOException {
                TargetType.ADAPTER.encodeWithTag(r100, 1, r101.target_type);
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 2, r101.chat_id);
                String r103 = r101.chatter_id;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 3, r103);
            L5:
                r102.encodeWithTag(r100, 4, r101.avatar_key);
                r102.encodeWithTag(r100, 5, r101.name);
                Boolean r104 = r101.is_cross_tenant;
                if (r104 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 7, r104);
            L8:
                ExtType.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.ext_types);
                Long r105 = r101.timestamp;
                if (r105 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r100, 8, r105);
            L11:
                String r106 = r101.thread_id;
                if (r106 == null) goto L14;
                r102.encodeWithTag(r100, 9, r106);
            L14:
                String r107 = r101.thread_sub_title;
                if (r107 == null) goto L17;
                r102.encodeWithTag(r100, 10, r107);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RecentTransmitTarget r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum TargetType extends Enum<TargetType> implements WireEnum {
            private static final /* synthetic */ TargetType[] $VALUES = null;
            public static final ProtoAdapter<TargetType> ADAPTER = null;
            public static final TargetType CHAT = null;
            public static final TargetType REPLY_IN_THREAD = null;
            public static final TargetType THREAD = null;
            public static final TargetType UNKOWN_TYPE = null;
            private final int value;

            static {
                TargetType r100 = new TargetType("UNKOWN_TYPE", 0, 0);
                UNKOWN_TYPE = r100;
                TargetType r101 = new TargetType("CHAT", 1, 1);
                CHAT = r101;
                TargetType r102 = new TargetType("THREAD", 2, 2);
                THREAD = r102;
                TargetType r103 = new TargetType("REPLY_IN_THREAD", 3, 3);
                REPLY_IN_THREAD = r103;
                $VALUES = new TargetType[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(TargetType.class);
            }

            public static TargetType[] values() {
                return (TargetType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static TargetType fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return REPLY_IN_THREAD;
            L14:
                return THREAD;
            L16:
                return CHAT;
            L18:
                return UNKOWN_TYPE;
            }

            public static TargetType valueOf(String r100) {
                return (TargetType) a.a(TargetType.class, r100);
            }

            private TargetType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_RecentTransmitTarget();
            DEFAULT_TARGET_TYPE = TargetType.UNKOWN_TYPE;
            DEFAULT_IS_CROSS_TENANT = Boolean.FALSE;
            DEFAULT_TIMESTAMP = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.target_type = this.target_type;
            r100.chat_id = this.chat_id;
            r100.chatter_id = this.chatter_id;
            r100.avatar_key = this.avatar_key;
            r100.name = this.name;
            r100.is_cross_tenant = this.is_cross_tenant;
            r100.ext_types = Internal.copyOf("ext_types", this.ext_types);
            r100.timestamp = this.timestamp;
            r100.thread_id = this.thread_id;
            r100.thread_sub_title = this.thread_sub_title;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return RecentTransmitTarget.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public RecentTransmitTarget(TargetType r110, String r111, String r112, String r113, String r114, Boolean r115, List<ExtType> r116, Long r210, String r211, String r212) {
            this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
        }

        public RecentTransmitTarget(TargetType r100, String r101, String r102, String r103, String r104, Boolean r105, List<ExtType> r106, Long r107, String r110, String r111, ByteString r112) {
            super(ADAPTER, r112);
            this.target_type = r100;
            this.chat_id = r101;
            this.chatter_id = r102;
            this.avatar_key = r103;
            this.name = r104;
            this.is_cross_tenant = r105;
            this.ext_types = Internal.immutableCopyOf("ext_types", r106);
            this.timestamp = r107;
            this.thread_id = r110;
            this.thread_sub_title = r111;
        }
    }

    static {
        ProtoAdapter_GetRecentTransmitTargetsResponse r100 = new ProtoAdapter_GetRecentTransmitTargetsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.targets = Internal.copyOf("targets", this.targets);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetRecentTransmitTargetsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetRecentTransmitTargetsResponse(List<RecentTransmitTarget> r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetRecentTransmitTargetsResponse(List<RecentTransmitTarget> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.targets = Internal.immutableCopyOf("targets", r100);
    }
}
