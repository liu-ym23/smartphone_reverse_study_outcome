package com.bytedance.lark.pb.im.v1;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetChannelThreadsResponse extends Message<GetChannelThreadsResponse, Builder> {
    public static final ProtoAdapter<GetChannelThreadsResponse> ADAPTER = null;
    public static final Boolean DEFAULT_DATA_COMPLETE = null;
    public static final Integer DEFAULT_NEW_AT_REPLY_COUNT = null;
    public static final Integer DEFAULT_NEW_REPLY_COUNT = null;
    public static final Integer DEFAULT_SHOW_EXPIRED_PERIOD = null;
    public static final ProtoAdapter_GetChannelThreadsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean data_complete;
    public final Entity entity;
    public final List<Integer> invalid_positions;
    public final List<Integer> missing_positions;
    public final Integer new_at_reply_count;
    public final List<String> new_at_reply_ids;
    public final Integer new_reply_count;
    public final Integer show_expired_period;
    public final List<ThreadItem> thread_items;

    public static final class Builder extends Message.Builder<GetChannelThreadsResponse, Builder> implements d<GetChannelThreadsResponse> {
        public Boolean data_complete;
        public Entity entity;
        public List<Integer> invalid_positions;
        public List<Integer> missing_positions;
        public Integer new_at_reply_count;
        public List<String> new_at_reply_ids;
        public Integer new_reply_count;
        public Integer show_expired_period;
        public List<ThreadItem> thread_items;

        @Override // com.squareup.wire.Message.Builder
        public GetChannelThreadsResponse build() {
            return new GetChannelThreadsResponse(this.thread_items, this.invalid_positions, this.entity, this.data_complete, this.missing_positions, this.new_reply_count, this.new_at_reply_ids, this.new_at_reply_count, this.show_expired_period, super.buildUnknownFields());
        }

        public Builder() {
            this.thread_items = Internal.newMutableList();
            this.invalid_positions = Internal.newMutableList();
            this.missing_positions = Internal.newMutableList();
            this.new_at_reply_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder data_complete(Boolean r100) {
            this.data_complete = r100;
            return this;
        }

        public Builder entity(Entity r100) {
            this.entity = r100;
            return this;
        }

        public Builder invalid_positions(List<Integer> r100) {
            Internal.checkElementsNotNull(r100);
            this.invalid_positions = r100;
            return this;
        }

        public Builder missing_positions(List<Integer> r100) {
            Internal.checkElementsNotNull(r100);
            this.missing_positions = r100;
            return this;
        }

        public Builder new_at_reply_count(Integer r100) {
            this.new_at_reply_count = r100;
            return this;
        }

        public Builder new_at_reply_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.new_at_reply_ids = r100;
            return this;
        }

        public Builder new_reply_count(Integer r100) {
            this.new_reply_count = r100;
            return this;
        }

        public Builder show_expired_period(Integer r100) {
            this.show_expired_period = r100;
            return this;
        }

        public Builder thread_items(List<ThreadItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.thread_items = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetChannelThreadsResponse extends ProtoAdapter<GetChannelThreadsResponse> implements c<GetChannelThreadsResponse> {
        public ProtoAdapter_GetChannelThreadsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChannelThreadsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChannelThreadsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.data_complete = Boolean.FALSE;
            r101.new_reply_count = 0;
            r101.new_at_reply_count = 0;
            r101.show_expired_period = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r101.show_expired_period = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L8:
            r101.new_at_reply_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L9:
            r101.new_at_reply_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            r101.new_reply_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.missing_positions.add(ProtoAdapter.INT32.decode(r100));
            goto L3
        L12:
            r101.data_complete = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.entity = Entity.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.invalid_positions.add(ProtoAdapter.INT32.decode(r100));
            goto L3
        L15:
            r101.thread_items.add(ThreadItem.ADAPTER.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetChannelThreadsResponse r100) {
            int r101 = ThreadItem.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.thread_items);
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            int r103 = r101 + r102.asRepeated().encodedSizeWithTag(2, r100.invalid_positions);
            Entity r104 = r100.entity;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = Entity.ADAPTER.encodedSizeWithTag(3, r104);
        L6:
            int r107 = r103 + r106;
            Boolean r108 = r100.data_complete;
            if (r108 == null) goto L9;
            int r109 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r108);
        L10:
            int r110 = (r107 + r109) + r102.asRepeated().encodedSizeWithTag(5, r100.missing_positions);
            Integer r111 = r100.new_reply_count;
            if (r111 == null) goto L13;
            int r112 = r102.encodedSizeWithTag(6, r111);
        L14:
            int r113 = (r110 + r112) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(7, r100.new_at_reply_ids);
            Integer r114 = r100.new_at_reply_count;
            if (r114 == null) goto L17;
            int r115 = r102.encodedSizeWithTag(8, r114);
        L18:
            int r116 = r113 + r115;
            Integer r117 = r100.show_expired_period;
            if (r117 == null) goto L22;
            r105 = ProtoAdapter.UINT32.encodedSizeWithTag(9, r117);
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
        public /* bridge */ /* synthetic */ GetChannelThreadsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChannelThreadsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChannelThreadsResponse r101) throws IOException {
            ThreadItem.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.thread_items);
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.asRepeated().encodeWithTag(r100, 2, r101.invalid_positions);
            Entity r103 = r101.entity;
            if (r103 == null) goto L5;
            Entity.ADAPTER.encodeWithTag(r100, 3, r103);
        L5:
            Boolean r104 = r101.data_complete;
            if (r104 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
        L8:
            r102.asRepeated().encodeWithTag(r100, 5, r101.missing_positions);
            Integer r105 = r101.new_reply_count;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 6, r105);
        L11:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 7, r101.new_at_reply_ids);
            Integer r106 = r101.new_at_reply_count;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 8, r106);
        L14:
            Integer r107 = r101.show_expired_period;
            if (r107 == null) goto L17;
            ProtoAdapter.UINT32.encodeWithTag(r100, 9, r107);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChannelThreadsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class ThreadItem extends Message<ThreadItem, Builder> {
        public static final ProtoAdapter<ThreadItem> ADAPTER = null;
        public static final String DEFAULT_ITEM_ID = "";
        public static final ChannelDataType DEFAULT_ITEM_TYPE = null;
        private static final long serialVersionUID = 0;
        public final String item_id;
        public final ChannelDataType item_type;

        public static final class Builder extends Message.Builder<ThreadItem, Builder> {
            public String item_id;
            public ChannelDataType item_type;

            @Override // com.squareup.wire.Message.Builder
            public ThreadItem build() {
                String r100 = this.item_id;
                if (r100 == null) goto L9;
                if (this.item_type == null) goto L9;
                return new ThreadItem(this.item_id, this.item_type, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "item_id", this.item_type, ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder item_id(String r100) {
                this.item_id = r100;
                return this;
            }

            public Builder item_type(ChannelDataType r100) {
                this.item_type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ThreadItem extends ProtoAdapter<ThreadItem> {
            public ProtoAdapter_ThreadItem() {
                super(FieldEncoding.LENGTH_DELIMITED, ThreadItem.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ThreadItem decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.item_id = "";
                r101.item_type = ChannelDataType.NORMAL_DATA;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.item_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.item_type = ChannelDataType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
            public int encodedSize2(ThreadItem r100) {
                return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.item_id) + ChannelDataType.ADAPTER.encodedSizeWithTag(2, r100.item_type)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ThreadItem decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ThreadItem r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ThreadItem r101) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.item_id);
                ChannelDataType.ADAPTER.encodeWithTag(r100, 2, r101.item_type);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ThreadItem r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ThreadItem();
            DEFAULT_ITEM_TYPE = ChannelDataType.NORMAL_DATA;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.item_id = this.item_id;
            r100.item_type = this.item_type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ThreadItem.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ThreadItem(String r100, ChannelDataType r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public ThreadItem(String r100, ChannelDataType r101, ByteString r102) {
            super(ADAPTER, r102);
            this.item_id = r100;
            this.item_type = r101;
        }
    }

    static {
        ProtoAdapter_GetChannelThreadsResponse r100 = new ProtoAdapter_GetChannelThreadsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_DATA_COMPLETE = Boolean.FALSE;
        DEFAULT_NEW_REPLY_COUNT = 0;
        DEFAULT_NEW_AT_REPLY_COUNT = 0;
        DEFAULT_SHOW_EXPIRED_PERIOD = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.thread_items = Internal.copyOf("thread_items", this.thread_items);
        r100.invalid_positions = Internal.copyOf("invalid_positions", this.invalid_positions);
        r100.entity = this.entity;
        r100.data_complete = this.data_complete;
        r100.missing_positions = Internal.copyOf("missing_positions", this.missing_positions);
        r100.new_reply_count = this.new_reply_count;
        r100.new_at_reply_ids = Internal.copyOf("new_at_reply_ids", this.new_at_reply_ids);
        r100.new_at_reply_count = this.new_at_reply_count;
        r100.show_expired_period = this.show_expired_period;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChannelThreadsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChannelThreadsResponse(List<ThreadItem> r110, List<Integer> r111, Entity r112, Boolean r113, List<Integer> r114, Integer r115, List<String> r116, Integer r117, Integer r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public GetChannelThreadsResponse(List<ThreadItem> r100, List<Integer> r101, Entity r102, Boolean r103, List<Integer> r104, Integer r105, List<String> r106, Integer r107, Integer r110, ByteString r111) {
        super(ADAPTER, r111);
        this.thread_items = Internal.immutableCopyOf("thread_items", r100);
        this.invalid_positions = Internal.immutableCopyOf("invalid_positions", r101);
        this.entity = r102;
        this.data_complete = r103;
        this.missing_positions = Internal.immutableCopyOf("missing_positions", r104);
        this.new_reply_count = r105;
        this.new_at_reply_ids = Internal.immutableCopyOf("new_at_reply_ids", r106);
        this.new_at_reply_count = r107;
        this.show_expired_period = r110;
    }
}
