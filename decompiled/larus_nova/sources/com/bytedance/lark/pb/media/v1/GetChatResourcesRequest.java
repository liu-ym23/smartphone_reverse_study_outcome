package com.bytedance.lark.pb.media.v1;

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
public final class GetChatResourcesRequest extends Message<GetChatResourcesRequest, Builder> {
    public static final ProtoAdapter<GetChatResourcesRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Integer DEFAULT_COUNT = null;
    public static final Direction DEFAULT_DIRECTION = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final ProtoAdapter_GetChatResourcesRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final Integer count;
    public final Direction direction;
    public final String message_id;
    public final List<ChatResourceType> resource_types;

    public static final class Builder extends Message.Builder<GetChatResourcesRequest, Builder> implements d<GetChatResourcesRequest> {
        public String chat_id;
        public Integer count;
        public Direction direction;
        public String message_id;
        public List<ChatResourceType> resource_types;

        @Override // com.squareup.wire.Message.Builder
        public GetChatResourcesRequest build() {
            String r100 = this.chat_id;
            if (r100 == null) goto L9;
            if (this.direction == null) goto L9;
            return new GetChatResourcesRequest(this.chat_id, this.message_id, this.count, this.direction, this.resource_types, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "chat_id", this.direction, "direction"});
        }

        public Builder() {
            this.resource_types = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder count(Integer r100) {
            this.count = r100;
            return this;
        }

        public Builder direction(Direction r100) {
            this.direction = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder resource_types(List<ChatResourceType> r100) {
            Internal.checkElementsNotNull(r100);
            this.resource_types = r100;
            return this;
        }
    }

    public static final enum Direction extends Enum<Direction> implements WireEnum {
        private static final /* synthetic */ Direction[] $VALUES = null;
        public static final ProtoAdapter<Direction> ADAPTER = null;
        public static final Direction AFTER = null;
        public static final Direction BEFORE = null;
        public static final Direction BIDIRECT = null;
        private final int value;

        static {
            Direction r100 = new Direction("BEFORE", 0, 1);
            BEFORE = r100;
            Direction r101 = new Direction("AFTER", 1, 2);
            AFTER = r101;
            Direction r102 = new Direction("BIDIRECT", 2, 3);
            BIDIRECT = r102;
            $VALUES = new Direction[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Direction.class);
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Direction fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return BIDIRECT;
        L13:
            return AFTER;
        L15:
            return BEFORE;
        }

        public static Direction valueOf(String r100) {
            return (Direction) a.a(Direction.class, r100);
        }

        private Direction(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_GetChatResourcesRequest extends ProtoAdapter<GetChatResourcesRequest> implements c<GetChatResourcesRequest> {
        public ProtoAdapter_GetChatResourcesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatResourcesRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatResourcesRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.message_id = "";
            r101.count = 10;
            r101.direction = Direction.BEFORE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.direction = Direction.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.resource_types.add(ChatResourceType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetChatResourcesRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.chat_id);
            String r103 = r100.message_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Integer r107 = r100.count;
            if (r107 == null) goto L10;
            r104 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L10:
            return (((r106 + r104) + Direction.ADAPTER.encodedSizeWithTag(4, r100.direction)) + ChatResourceType.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.resource_types)) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetChatResourcesRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatResourcesRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatResourcesRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.chat_id);
            String r103 = r101.message_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            Integer r104 = r101.count;
            if (r104 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L8:
            Direction.ADAPTER.encodeWithTag(r100, 4, r101.direction);
            ChatResourceType.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.resource_types);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatResourcesRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetChatResourcesRequest r100 = new ProtoAdapter_GetChatResourcesRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_COUNT = 10;
        DEFAULT_DIRECTION = Direction.BEFORE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.message_id = this.message_id;
        r100.count = this.count;
        r100.direction = this.direction;
        r100.resource_types = Internal.copyOf("resource_types", this.resource_types);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatResourcesRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatResourcesRequest(String r100, String r101, Integer r110, Direction r111, List<ChatResourceType> r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public GetChatResourcesRequest(String r100, String r101, Integer r102, Direction r103, List<ChatResourceType> r104, ByteString r105) {
        super(ADAPTER, r105);
        this.chat_id = r100;
        this.message_id = r101;
        this.count = r102;
        this.direction = r103;
        this.resource_types = Internal.immutableCopyOf("resource_types", r104);
    }
}
