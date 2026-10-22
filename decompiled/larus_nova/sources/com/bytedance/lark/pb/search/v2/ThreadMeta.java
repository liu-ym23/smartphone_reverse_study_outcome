package com.bytedance.lark.pb.search.v2;

import com.bytedance.lark.pb.basic.v1.Channel;
import com.bytedance.lark.pb.search.v1.SearchAtInfo;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ThreadMeta extends Message<ThreadMeta, Builder> {
    public static final ProtoAdapter<ThreadMeta> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_ID = "";
    public static final Integer DEFAULT_NEW_MESSAGE_COUNT = null;
    public static final Integer DEFAULT_NO_BADGED_NEW_MESSAGE_COUNT = null;
    public static final String DEFAULT_TOPIC = "";
    public static final Long DEFAULT_UPDATE_TIME = null;
    private static final long serialVersionUID = 0;
    public final SearchAtInfo at_info;
    public final Channel channel;
    public final String chat_id;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253743id;
    public final Integer new_message_count;
    public final Integer no_badged_new_message_count;
    public final String topic;
    public final Long update_time;

    public static final class Builder extends Message.Builder<ThreadMeta, Builder> {
        public SearchAtInfo at_info;
        public Channel channel;
        public String chat_id;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253744id;
        public Integer new_message_count;
        public Integer no_badged_new_message_count;
        public String topic;
        public Long update_time;

        @Override // com.squareup.wire.Message.Builder
        public ThreadMeta build() {
            String r100 = this.f253744id;
            if (r100 == null) goto L7;
            return new ThreadMeta(this.f253744id, this.chat_id, this.channel, this.topic, this.new_message_count, this.no_badged_new_message_count, this.update_time, this.at_info, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder at_info(SearchAtInfo r100) {
            this.at_info = r100;
            return this;
        }

        public Builder channel(Channel r100) {
            this.channel = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253744id = r100;
            return this;
        }

        public Builder new_message_count(Integer r100) {
            this.new_message_count = r100;
            return this;
        }

        public Builder no_badged_new_message_count(Integer r100) {
            this.no_badged_new_message_count = r100;
            return this;
        }

        public Builder topic(String r100) {
            this.topic = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ThreadMeta extends ProtoAdapter<ThreadMeta> {
        public ProtoAdapter_ThreadMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, ThreadMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ThreadMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253744id = "";
            r101.chat_id = "";
            r101.topic = "";
            r101.new_message_count = 0;
            r101.no_badged_new_message_count = 0;
            r101.update_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            switch(r103) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            r101.at_info = SearchAtInfo.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L9:
            r101.no_badged_new_message_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.new_message_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.topic = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.channel = Channel.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.f253744id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ThreadMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253743id);
            String r103 = r100.chat_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Channel r107 = r100.channel;
            if (r107 == null) goto L9;
            int r108 = Channel.ADAPTER.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.topic;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            Integer r113 = r100.new_message_count;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.INT32.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            Integer r116 = r100.no_badged_new_message_count;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.INT32.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            Long r119 = r100.update_time;
            if (r119 == null) goto L25;
            int r120 = ProtoAdapter.INT64.encodedSizeWithTag(7, r119);
        L26:
            int r121 = r118 + r120;
            SearchAtInfo r122 = r100.at_info;
            if (r122 == null) goto L30;
            r104 = SearchAtInfo.ADAPTER.encodedSizeWithTag(8, r122);
        L30:
            return (r121 + r104) + r100.unknownFields().size();
        L25:
            r120 = 0;
            goto L26
        L21:
            r117 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ ThreadMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ThreadMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ThreadMeta r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253743id);
            String r103 = r101.chat_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            Channel r104 = r101.channel;
            if (r104 == null) goto L8;
            Channel.ADAPTER.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.topic;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            Integer r106 = r101.new_message_count;
            if (r106 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r106);
        L14:
            Integer r107 = r101.no_badged_new_message_count;
            if (r107 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r107);
        L17:
            Long r108 = r101.update_time;
            if (r108 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r108);
        L20:
            SearchAtInfo r109 = r101.at_info;
            if (r109 == null) goto L23;
            SearchAtInfo.ADAPTER.encodeWithTag(r100, 8, r109);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ThreadMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ThreadMeta();
        DEFAULT_NEW_MESSAGE_COUNT = 0;
        DEFAULT_NO_BADGED_NEW_MESSAGE_COUNT = 0;
        DEFAULT_UPDATE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253744id = this.f253743id;
        r100.chat_id = this.chat_id;
        r100.channel = this.channel;
        r100.topic = this.topic;
        r100.new_message_count = this.new_message_count;
        r100.no_badged_new_message_count = this.no_badged_new_message_count;
        r100.update_time = this.update_time;
        r100.at_info = this.at_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ThreadMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ThreadMeta(String r110, String r111, Channel r112, String r113, Integer r114, Integer r115, Long r116, SearchAtInfo r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public ThreadMeta(String r100, String r101, Channel r102, String r103, Integer r104, Integer r105, Long r106, SearchAtInfo r107, ByteString r110) {
        super(ADAPTER, r110);
        this.f253743id = r100;
        this.chat_id = r101;
        this.channel = r102;
        this.topic = r103;
        this.new_message_count = r104;
        this.no_badged_new_message_count = r105;
        this.update_time = r106;
        this.at_info = r107;
    }
}
