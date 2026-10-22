package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.ChannelDataScene;
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
public final class GetFilteredThreadsRequest extends Message<GetFilteredThreadsRequest, Builder> {
    public static final ProtoAdapter<GetFilteredThreadsRequest> ADAPTER = null;
    public static final String DEFAULT_CHANNEL_ID = "";
    public static final Integer DEFAULT_COUNT = null;
    public static final String DEFAULT_CURSOR = "";
    public static final String DEFAULT_FILTER_ID = "";
    public static final Integer DEFAULT_PRELOAD_COUNT = null;
    public static final ChannelDataScene DEFAULT_SCENE = null;
    public static final ProtoAdapter_GetFilteredThreadsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String channel_id;
    public final Integer count;
    public final String cursor;
    public final ExtendData extend_data;
    public final String filter_id;
    public final Integer preload_count;
    public final ChannelDataScene scene;

    public static final class Builder extends Message.Builder<GetFilteredThreadsRequest, Builder> implements d<GetFilteredThreadsRequest> {
        public String channel_id;
        public Integer count;
        public String cursor;
        public ExtendData extend_data;
        public String filter_id;
        public Integer preload_count;
        public ChannelDataScene scene;

        @Override // com.squareup.wire.Message.Builder
        public GetFilteredThreadsRequest build() {
            String r100 = this.channel_id;
            if (r100 == null) goto L9;
            if (this.filter_id == null) goto L9;
            return new GetFilteredThreadsRequest(this.channel_id, this.filter_id, this.scene, this.cursor, this.count, this.preload_count, this.extend_data, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "channel_id", this.filter_id, "filter_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder channel_id(String r100) {
            this.channel_id = r100;
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

        public Builder extend_data(ExtendData r100) {
            this.extend_data = r100;
            return this;
        }

        public Builder filter_id(String r100) {
            this.filter_id = r100;
            return this;
        }

        public Builder preload_count(Integer r100) {
            this.preload_count = r100;
            return this;
        }

        public Builder scene(ChannelDataScene r100) {
            this.scene = r100;
            return this;
        }
    }

    public static final class ExtendData extends Message<ExtendData, Builder> {
        public static final ProtoAdapter<ExtendData> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> extend_filter_ids;

        public static final class Builder extends Message.Builder<ExtendData, Builder> {
            public List<String> extend_filter_ids;

            @Override // com.squareup.wire.Message.Builder
            public ExtendData build() {
                return new ExtendData(this.extend_filter_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.extend_filter_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder extend_filter_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.extend_filter_ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ExtendData extends ProtoAdapter<ExtendData> {
            public ProtoAdapter_ExtendData() {
                super(FieldEncoding.LENGTH_DELIMITED, ExtendData.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ExtendData decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.extend_filter_ids.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(ExtendData r100) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.extend_filter_ids) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ExtendData decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ExtendData r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ExtendData r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.extend_filter_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExtendData r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ExtendData();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.extend_filter_ids = Internal.copyOf("extend_filter_ids", this.extend_filter_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ExtendData.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ExtendData(List<String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public ExtendData(List<String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.extend_filter_ids = Internal.immutableCopyOf("extend_filter_ids", r100);
        }
    }

    public static final class ProtoAdapter_GetFilteredThreadsRequest extends ProtoAdapter<GetFilteredThreadsRequest> implements c<GetFilteredThreadsRequest> {
        public ProtoAdapter_GetFilteredThreadsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetFilteredThreadsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetFilteredThreadsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.channel_id = "";
            r101.filter_id = "";
            r101.scene = ChannelDataScene.FIRST_SCREEN;
            r101.cursor = "";
            r101.count = 10;
            r101.preload_count = 30;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L19;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
            r101.scene = ChannelDataScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.extend_data = ExtendData.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.preload_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L9:
            r101.count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.cursor = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.filter_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.channel_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetFilteredThreadsRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.channel_id) + r101.encodedSizeWithTag(2, r100.filter_id);
            ChannelDataScene r103 = r100.scene;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ChannelDataScene.ADAPTER.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.cursor;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            Integer r110 = r100.count;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(5, r110);
        L14:
            int r112 = r109 + r111;
            Integer r113 = r100.preload_count;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.INT32.encodedSizeWithTag(6, r113);
        L18:
            int r115 = r112 + r114;
            ExtendData r116 = r100.extend_data;
            if (r116 == null) goto L22;
            r104 = ExtendData.ADAPTER.encodedSizeWithTag(7, r116);
        L22:
            return (r115 + r104) + r100.unknownFields().size();
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetFilteredThreadsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetFilteredThreadsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetFilteredThreadsRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.channel_id);
            r102.encodeWithTag(r100, 2, r101.filter_id);
            ChannelDataScene r103 = r101.scene;
            if (r103 == null) goto L5;
            ChannelDataScene.ADAPTER.encodeWithTag(r100, 3, r103);
        L5:
            String r104 = r101.cursor;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            Integer r105 = r101.count;
            if (r105 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r105);
        L11:
            Integer r106 = r101.preload_count;
            if (r106 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r106);
        L14:
            ExtendData r107 = r101.extend_data;
            if (r107 == null) goto L17;
            ExtendData.ADAPTER.encodeWithTag(r100, 7, r107);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetFilteredThreadsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetFilteredThreadsRequest r100 = new ProtoAdapter_GetFilteredThreadsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SCENE = ChannelDataScene.FIRST_SCREEN;
        DEFAULT_COUNT = 10;
        DEFAULT_PRELOAD_COUNT = 30;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.channel_id = this.channel_id;
        r100.filter_id = this.filter_id;
        r100.scene = this.scene;
        r100.cursor = this.cursor;
        r100.count = this.count;
        r100.preload_count = this.preload_count;
        r100.extend_data = this.extend_data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetFilteredThreadsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetFilteredThreadsRequest(String r110, String r111, ChannelDataScene r112, String r113, Integer r114, Integer r115, ExtendData r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public GetFilteredThreadsRequest(String r100, String r101, ChannelDataScene r102, String r103, Integer r104, Integer r105, ExtendData r106, ByteString r107) {
        super(ADAPTER, r107);
        this.channel_id = r100;
        this.filter_id = r101;
        this.scene = r102;
        this.cursor = r103;
        this.count = r104;
        this.preload_count = r105;
        this.extend_data = r106;
    }
}
