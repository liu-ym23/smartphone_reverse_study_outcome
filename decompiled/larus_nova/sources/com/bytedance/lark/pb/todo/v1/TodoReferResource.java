package com.bytedance.lark.pb.todo.v1;

import com.bytedance.lark.pb.basic.v1.Entity;
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
public final class TodoReferResource extends Message<TodoReferResource, Builder> {
    public static final ProtoAdapter<TodoReferResource> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final ResourceType DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253783id;
    public final MessageResource msg;
    public final ResourceType type;

    public static final class Builder extends Message.Builder<TodoReferResource, Builder> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253784id;
        public MessageResource msg;
        public ResourceType type;

        @Override // com.squareup.wire.Message.Builder
        public TodoReferResource build() {
            return new TodoReferResource(this.f253784id, this.type, this.msg, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder id(String r100) {
            this.f253784id = r100;
            return this;
        }

        public Builder msg(MessageResource r100) {
            this.msg = r100;
            return this;
        }

        public Builder type(ResourceType r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class MessageResource extends Message<MessageResource, Builder> {
        public static final ProtoAdapter<MessageResource> ADAPTER = null;
        public static final String DEFAULT_MSG_ID = "";
        private static final long serialVersionUID = 0;
        public final Entity entity;
        public final String msg_id;

        public static final class Builder extends Message.Builder<MessageResource, Builder> {
            public Entity entity;
            public String msg_id;

            @Override // com.squareup.wire.Message.Builder
            public MessageResource build() {
                return new MessageResource(this.msg_id, this.entity, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder entity(Entity r100) {
                this.entity = r100;
                return this;
            }

            public Builder msg_id(String r100) {
                this.msg_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MessageResource extends ProtoAdapter<MessageResource> {
            public ProtoAdapter_MessageResource() {
                super(FieldEncoding.LENGTH_DELIMITED, MessageResource.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MessageResource decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.msg_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.msg_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.entity = Entity.ADAPTER.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(MessageResource r100) {
                String r101 = r100.msg_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Entity r104 = r100.entity;
                if (r104 == null) goto L10;
                r102 = Entity.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MessageResource decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MessageResource r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MessageResource r101) throws IOException {
                String r102 = r101.msg_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Entity r103 = r101.entity;
                if (r103 == null) goto L8;
                Entity.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageResource r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MessageResource();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.msg_id = this.msg_id;
            r100.entity = this.entity;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MessageResource.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public MessageResource(String r100, Entity r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public MessageResource(String r100, Entity r101, ByteString r102) {
            super(ADAPTER, r102);
            this.msg_id = r100;
            this.entity = r101;
        }
    }

    public static final class ProtoAdapter_TodoReferResource extends ProtoAdapter<TodoReferResource> {
        public ProtoAdapter_TodoReferResource() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoReferResource.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoReferResource decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253784id = "";
            r101.type = ResourceType.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.f253784id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.type = ResourceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 100) goto L11;
            r101.msg(MessageResource.ADAPTER.decode(r100));
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
        public int encodedSize2(TodoReferResource r100) {
            String r101 = r100.f253783id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ResourceType r104 = r100.type;
            if (r104 == null) goto L9;
            int r105 = ResourceType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            MessageResource r107 = r100.msg;
            if (r107 == null) goto L14;
            r102 = MessageResource.ADAPTER.encodedSizeWithTag(100, r107);
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
        public /* bridge */ /* synthetic */ TodoReferResource decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoReferResource r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoReferResource r101) throws IOException {
            String r102 = r101.f253783id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ResourceType r103 = r101.type;
            if (r103 == null) goto L8;
            ResourceType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            MessageResource r104 = r101.msg;
            if (r104 == null) goto L11;
            MessageResource.ADAPTER.encodeWithTag(r100, 100, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoReferResource r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum ResourceType extends Enum<ResourceType> implements WireEnum {
        private static final /* synthetic */ ResourceType[] $VALUES = null;
        public static final ProtoAdapter<ResourceType> ADAPTER = null;
        public static final ResourceType MESSAGE = null;
        public static final ResourceType UNKNOWN = null;
        private final int value;

        static {
            ResourceType r100 = new ResourceType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ResourceType r101 = new ResourceType("MESSAGE", 1, 1);
            MESSAGE = r101;
            $VALUES = new ResourceType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(ResourceType.class);
        }

        public static ResourceType[] values() {
            return (ResourceType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ResourceType fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return MESSAGE;
        L10:
            return UNKNOWN;
        }

        public static ResourceType valueOf(String r100) {
            return (ResourceType) a.a(ResourceType.class, r100);
        }

        private ResourceType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TodoReferResource();
        DEFAULT_TYPE = ResourceType.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253784id = this.f253783id;
        r100.type = this.type;
        r100.msg = this.msg;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoReferResource.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoReferResource(String r100, ResourceType r101, MessageResource r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public TodoReferResource(String r100, ResourceType r101, MessageResource r102, ByteString r103) {
        super(ADAPTER, r103);
        this.f253783id = r100;
        this.type = r101;
        this.msg = r102;
    }
}
