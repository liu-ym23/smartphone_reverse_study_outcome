package com.bytedance.lark.pb.todo.v1;

import com.bytedance.lark.pb.basic.v1.Chat;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetRecommendedContentsResponse extends Message<GetRecommendedContentsResponse, Builder> {
    public static final ProtoAdapter<GetRecommendedContentsResponse> ADAPTER = null;
    public static final ProtoAdapter_GetRecommendedContentsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Chat> chats;
    public final Map<String, Chatter> chatters;
    public final List<RecommendContent> recommend_contents;

    public static final class Builder extends Message.Builder<GetRecommendedContentsResponse, Builder> implements d<GetRecommendedContentsResponse> {
        public Map<String, Chat> chats;
        public Map<String, Chatter> chatters;
        public List<RecommendContent> recommend_contents;

        @Override // com.squareup.wire.Message.Builder
        public GetRecommendedContentsResponse build() {
            return new GetRecommendedContentsResponse(this.recommend_contents, this.chats, this.chatters, super.buildUnknownFields());
        }

        public Builder() {
            this.recommend_contents = Internal.newMutableList();
            this.chats = Internal.newMutableMap();
            this.chatters = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chats(Map<String, Chat> r100) {
            Internal.checkElementsNotNull(r100);
            this.chats = r100;
            return this;
        }

        public Builder chatters(Map<String, Chatter> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatters = r100;
            return this;
        }

        public Builder recommend_contents(List<RecommendContent> r100) {
            Internal.checkElementsNotNull(r100);
            this.recommend_contents = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetRecommendedContentsResponse extends ProtoAdapter<GetRecommendedContentsResponse> implements c<GetRecommendedContentsResponse> {
        private final ProtoAdapter<Map<String, Chat>> chats;
        private final ProtoAdapter<Map<String, Chatter>> chatters;

        public ProtoAdapter_GetRecommendedContentsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetRecommendedContentsResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.chats = ProtoAdapter.newMapAdapter(r100, Chat.ADAPTER);
            this.chatters = ProtoAdapter.newMapAdapter(r100, Chatter.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetRecommendedContentsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.recommend_contents.add(RecommendContent.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.chats.putAll(this.chats.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.chatters.putAll(this.chatters.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetRecommendedContentsResponse r100) {
            return ((RecommendContent.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.recommend_contents) + this.chats.encodedSizeWithTag(2, r100.chats)) + this.chatters.encodedSizeWithTag(3, r100.chatters)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetRecommendedContentsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetRecommendedContentsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetRecommendedContentsResponse r101) throws IOException {
            RecommendContent.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.recommend_contents);
            this.chats.encodeWithTag(r100, 2, r101.chats);
            this.chatters.encodeWithTag(r100, 3, r101.chatters);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetRecommendedContentsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class RecommendContent extends Message<RecommendContent, Builder> {
        public static final ProtoAdapter<RecommendContent> ADAPTER = null;
        public static final Type DEFAULT_CONTENT_TYPE = null;
        public static final String DEFAULT_DEPARTMENT = "";
        public static final String DEFAULT_ID = "";
        private static final long serialVersionUID = 0;
        public final Type content_type;
        public final String department;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public final String f253773id;

        public static final class Builder extends Message.Builder<RecommendContent, Builder> {
            public Type content_type;
            public String department;

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            public String f253774id;

            @Override // com.squareup.wire.Message.Builder
            public RecommendContent build() {
                return new RecommendContent(this.f253774id, this.content_type, this.department, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder content_type(Type r100) {
                this.content_type = r100;
                return this;
            }

            public Builder department(String r100) {
                this.department = r100;
                return this;
            }

            public Builder id(String r100) {
                this.f253774id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_RecommendContent extends ProtoAdapter<RecommendContent> {
            public ProtoAdapter_RecommendContent() {
                super(FieldEncoding.LENGTH_DELIMITED, RecommendContent.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public RecommendContent decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.f253774id = "";
                r101.content_type = Type.UNKNOWN;
                r101.department = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.f253774id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.content_type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.department = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(RecommendContent r100) {
                String r101 = r100.f253773id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Type r104 = r100.content_type;
                if (r104 == null) goto L9;
                int r105 = Type.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.department;
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
            public /* bridge */ /* synthetic */ RecommendContent decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(RecommendContent r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, RecommendContent r101) throws IOException {
                String r102 = r101.f253773id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Type r103 = r101.content_type;
                if (r103 == null) goto L8;
                Type.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.department;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RecommendContent r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type CHAT = null;
            public static final Type CHATTER = null;
            public static final Type UNKNOWN = null;
            private final int value;

            static {
                Type r100 = new Type("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Type r101 = new Type("CHATTER", 1, 1);
                CHATTER = r101;
                Type r102 = new Type("CHAT", 2, 2);
                CHAT = r102;
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
                return CHAT;
            L12:
                return CHATTER;
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
            ADAPTER = new ProtoAdapter_RecommendContent();
            DEFAULT_CONTENT_TYPE = Type.UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.f253774id = this.f253773id;
            r100.content_type = this.content_type;
            r100.department = this.department;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return RecommendContent.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public RecommendContent(String r100, Type r101, String r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public RecommendContent(String r100, Type r101, String r102, ByteString r103) {
            super(ADAPTER, r103);
            this.f253773id = r100;
            this.content_type = r101;
            this.department = r102;
        }
    }

    static {
        ProtoAdapter_GetRecommendedContentsResponse r100 = new ProtoAdapter_GetRecommendedContentsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.recommend_contents = Internal.copyOf("recommend_contents", this.recommend_contents);
        r100.chats = Internal.copyOf("chats", this.chats);
        r100.chatters = Internal.copyOf("chatters", this.chatters);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetRecommendedContentsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetRecommendedContentsResponse(List<RecommendContent> r100, Map<String, Chat> r101, Map<String, Chatter> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetRecommendedContentsResponse(List<RecommendContent> r100, Map<String, Chat> r101, Map<String, Chatter> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.recommend_contents = Internal.immutableCopyOf("recommend_contents", r100);
        this.chats = Internal.immutableCopyOf("chats", r101);
        this.chatters = Internal.immutableCopyOf("chatters", r102);
    }
}
