package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.ChatApplication;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetChatApplicationsRequest extends Message<GetChatApplicationsRequest, Builder> {
    public static final ProtoAdapter<GetChatApplicationsRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Integer DEFAULT_COUNT = null;
    public static final String DEFAULT_CURSOR = "";
    public static final GetType DEFAULT_GET_TYPE = null;
    public static final Boolean DEFAULT_IGNORE_CHAT_ID_WHEN_EMPTY = null;
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final ChatApplication.Type DEFAULT_TYPE = null;
    public static final ProtoAdapter_GetChatApplicationsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final Integer count;
    public final String cursor;
    public final GetType get_type;
    public final Boolean ignore_chat_id_when_empty;
    public final SyncDataStrategy sync_data_strategy;
    public final ChatApplication.Type type;

    public static final class Builder extends Message.Builder<GetChatApplicationsRequest, Builder> implements d<GetChatApplicationsRequest> {
        public String chat_id;
        public Integer count;
        public String cursor;
        public GetType get_type;
        public Boolean ignore_chat_id_when_empty;
        public SyncDataStrategy sync_data_strategy;
        public ChatApplication.Type type;

        @Override // com.squareup.wire.Message.Builder
        public GetChatApplicationsRequest build() {
            String r100 = this.cursor;
            if (r100 == null) goto L13;
            if (this.count == null) goto L13;
            if (this.type == null) goto L13;
            if (this.get_type == null) goto L13;
            return new GetChatApplicationsRequest(this.cursor, this.count, this.type, this.get_type, this.chat_id, this.sync_data_strategy, this.ignore_chat_id_when_empty, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, EffectConfiguration.KEY_CURSOR, this.count, "count", this.type, "type", this.get_type, "get_type"});
        }

        public Builder() {
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

        public Builder cursor(String r100) {
            this.cursor = r100;
            return this;
        }

        public Builder get_type(GetType r100) {
            this.get_type = r100;
            return this;
        }

        public Builder ignore_chat_id_when_empty(Boolean r100) {
            this.ignore_chat_id_when_empty = r100;
            return this;
        }

        public Builder sync_data_strategy(SyncDataStrategy r100) {
            this.sync_data_strategy = r100;
            return this;
        }

        public Builder type(ChatApplication.Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final enum GetType extends Enum<GetType> implements WireEnum {
        private static final /* synthetic */ GetType[] $VALUES = null;
        public static final ProtoAdapter<GetType> ADAPTER = null;
        public static final GetType AFTER = null;
        public static final GetType BEFORE = null;
        private final int value;

        static {
            GetType r100 = new GetType("BEFORE", 0, 1);
            BEFORE = r100;
            GetType r101 = new GetType("AFTER", 1, 2);
            AFTER = r101;
            $VALUES = new GetType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(GetType.class);
        }

        public static GetType[] values() {
            return (GetType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static GetType fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return AFTER;
        L11:
            return BEFORE;
        }

        public static GetType valueOf(String r100) {
            return (GetType) a.a(GetType.class, r100);
        }

        private GetType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_GetChatApplicationsRequest extends ProtoAdapter<GetChatApplicationsRequest> implements c<GetChatApplicationsRequest> {
        public ProtoAdapter_GetChatApplicationsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatApplicationsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatApplicationsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.cursor = "";
            r101.count = 10;
            r101.type = ChatApplication.Type.UNKNOWN_TYPE;
            r101.get_type = GetType.BEFORE;
            r101.chat_id = "";
            r101.sync_data_strategy = SyncDataStrategy.FORCE_SERVER;
            r101.ignore_chat_id_when_empty = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L23;
            switch(r103) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L27;
                case 4: goto L29;
                case 5: goto L12;
                case 6: goto L25;
                case 7: goto L7;
                default: goto L6;
            };
        L25:
            r101.sync_data_strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L27:
            r101.type = ChatApplication.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L29:
            r101.get_type = GetType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.ignore_chat_id_when_empty = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L22:
            r101.cursor = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(GetChatApplicationsRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = ((r101.encodedSizeWithTag(1, r100.cursor) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.count)) + ChatApplication.Type.ADAPTER.encodedSizeWithTag(3, r100.type)) + GetType.ADAPTER.encodedSizeWithTag(4, r100.get_type);
            String r103 = r100.chat_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(5, r103);
        L6:
            int r106 = r102 + r105;
            SyncDataStrategy r107 = r100.sync_data_strategy;
            if (r107 == null) goto L9;
            int r108 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(6, r107);
        L10:
            int r109 = r106 + r108;
            Boolean r110 = r100.ignore_chat_id_when_empty;
            if (r110 == null) goto L14;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r110);
        L14:
            return (r109 + r104) + r100.unknownFields().size();
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetChatApplicationsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatApplicationsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatApplicationsRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.cursor);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.count);
            ChatApplication.Type.ADAPTER.encodeWithTag(r100, 3, r101.type);
            GetType.ADAPTER.encodeWithTag(r100, 4, r101.get_type);
            String r103 = r101.chat_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 5, r103);
        L5:
            SyncDataStrategy r104 = r101.sync_data_strategy;
            if (r104 == null) goto L8;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 6, r104);
        L8:
            Boolean r105 = r101.ignore_chat_id_when_empty;
            if (r105 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatApplicationsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetChatApplicationsRequest r100 = new ProtoAdapter_GetChatApplicationsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_COUNT = 10;
        DEFAULT_TYPE = ChatApplication.Type.UNKNOWN_TYPE;
        DEFAULT_GET_TYPE = GetType.BEFORE;
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.FORCE_SERVER;
        DEFAULT_IGNORE_CHAT_ID_WHEN_EMPTY = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.cursor = this.cursor;
        r100.count = this.count;
        r100.type = this.type;
        r100.get_type = this.get_type;
        r100.chat_id = this.chat_id;
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.ignore_chat_id_when_empty = this.ignore_chat_id_when_empty;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatApplicationsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatApplicationsRequest(String r110, Integer r111, ChatApplication.Type r112, GetType r113, String r114, SyncDataStrategy r115, Boolean r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public GetChatApplicationsRequest(String r100, Integer r101, ChatApplication.Type r102, GetType r103, String r104, SyncDataStrategy r105, Boolean r106, ByteString r107) {
        super(ADAPTER, r107);
        this.cursor = r100;
        this.count = r101;
        this.type = r102;
        this.get_type = r103;
        this.chat_id = r104;
        this.sync_data_strategy = r105;
        this.ignore_chat_id_when_empty = r106;
    }
}
