package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Channel;
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
public final class UpdateMessagesMeReadRequest extends Message<UpdateMessagesMeReadRequest, Builder> {
    public static final ProtoAdapter<UpdateMessagesMeReadRequest> ADAPTER = null;
    public static final Integer DEFAULT_MAX_POSITION = null;
    public static final Integer DEFAULT_MAX_POSITION_BADGE_COUNT = null;
    public static final String DEFAULT_THREAD_ID = "";
    public static final Integer DEFAULT_THREAD_MAX_POSITION = null;
    public static final Integer DEFAULT_THREAD_MAX_POSITION_BADGE_COUNT = null;
    public static final ProtoAdapter_UpdateMessagesMeReadRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Channel channel;
    public final List<Long> fold_ids;
    public final Integer max_position;
    public final Integer max_position_badge_count;
    public final List<String> message_ids;
    public final String thread_id;
    public final Integer thread_max_position;
    public final Integer thread_max_position_badge_count;

    public static final class Builder extends Message.Builder<UpdateMessagesMeReadRequest, Builder> implements d<UpdateMessagesMeReadRequest> {
        public Channel channel;
        public List<Long> fold_ids;
        public Integer max_position;
        public Integer max_position_badge_count;
        public List<String> message_ids;
        public String thread_id;
        public Integer thread_max_position;
        public Integer thread_max_position_badge_count;

        @Override // com.squareup.wire.Message.Builder
        public UpdateMessagesMeReadRequest build() {
            Integer r100 = this.max_position;
            if (r100 == null) goto L9;
            if (this.max_position_badge_count == null) goto L9;
            return new UpdateMessagesMeReadRequest(this.message_ids, this.channel, this.max_position, this.thread_id, this.thread_max_position, this.max_position_badge_count, this.thread_max_position_badge_count, this.fold_ids, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "max_position", this.max_position_badge_count, "max_position_badge_count"});
        }

        public Builder() {
            this.message_ids = Internal.newMutableList();
            this.fold_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder channel(Channel r100) {
            this.channel = r100;
            return this;
        }

        public Builder fold_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.fold_ids = r100;
            return this;
        }

        public Builder max_position(Integer r100) {
            this.max_position = r100;
            return this;
        }

        public Builder max_position_badge_count(Integer r100) {
            this.max_position_badge_count = r100;
            return this;
        }

        public Builder message_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_ids = r100;
            return this;
        }

        public Builder thread_id(String r100) {
            this.thread_id = r100;
            return this;
        }

        public Builder thread_max_position(Integer r100) {
            this.thread_max_position = r100;
            return this;
        }

        public Builder thread_max_position_badge_count(Integer r100) {
            this.thread_max_position_badge_count = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateMessagesMeReadRequest extends ProtoAdapter<UpdateMessagesMeReadRequest> implements c<UpdateMessagesMeReadRequest> {
        public ProtoAdapter_UpdateMessagesMeReadRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateMessagesMeReadRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateMessagesMeReadRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.max_position = -1;
            r101.thread_id = "";
            r101.thread_max_position = 0;
            r101.max_position_badge_count = 0;
            r101.thread_max_position_badge_count = 0;
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
            r101.fold_ids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L8:
            r101.thread_max_position_badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L9:
            r101.max_position_badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.thread_max_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.thread_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.max_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L13:
            r101.channel = Channel.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.message_ids.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(UpdateMessagesMeReadRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.asRepeated().encodedSizeWithTag(1, r100.message_ids);
            Channel r103 = r100.channel;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = Channel.ADAPTER.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            ProtoAdapter<Integer> r107 = ProtoAdapter.INT32;
            int r108 = r106 + r107.encodedSizeWithTag(3, r100.max_position);
            String r109 = r100.thread_id;
            if (r109 == null) goto L9;
            int r110 = r101.encodedSizeWithTag(4, r109);
        L10:
            int r111 = r108 + r110;
            Integer r112 = r100.thread_max_position;
            if (r112 == null) goto L13;
            int r113 = r107.encodedSizeWithTag(5, r112);
        L14:
            int r114 = (r111 + r113) + r107.encodedSizeWithTag(6, r100.max_position_badge_count);
            Integer r115 = r100.thread_max_position_badge_count;
            if (r115 == null) goto L18;
            r104 = r107.encodedSizeWithTag(7, r115);
        L18:
            return ((r114 + r104) + ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(8, r100.fold_ids)) + r100.unknownFields().size();
        L13:
            r113 = 0;
            goto L14
        L9:
            r110 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateMessagesMeReadRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateMessagesMeReadRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateMessagesMeReadRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 1, r101.message_ids);
            Channel r103 = r101.channel;
            if (r103 == null) goto L5;
            Channel.ADAPTER.encodeWithTag(r100, 2, r103);
        L5:
            ProtoAdapter<Integer> r104 = ProtoAdapter.INT32;
            r104.encodeWithTag(r100, 3, r101.max_position);
            String r105 = r101.thread_id;
            if (r105 == null) goto L8;
            r102.encodeWithTag(r100, 4, r105);
        L8:
            Integer r106 = r101.thread_max_position;
            if (r106 == null) goto L11;
            r104.encodeWithTag(r100, 5, r106);
        L11:
            r104.encodeWithTag(r100, 6, r101.max_position_badge_count);
            Integer r107 = r101.thread_max_position_badge_count;
            if (r107 == null) goto L14;
            r104.encodeWithTag(r100, 7, r107);
        L14:
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 8, r101.fold_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateMessagesMeReadRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateMessagesMeReadRequest r100 = new ProtoAdapter_UpdateMessagesMeReadRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_MAX_POSITION = -1;
        DEFAULT_THREAD_MAX_POSITION = 0;
        DEFAULT_MAX_POSITION_BADGE_COUNT = 0;
        DEFAULT_THREAD_MAX_POSITION_BADGE_COUNT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_ids = Internal.copyOf("message_ids", this.message_ids);
        r100.channel = this.channel;
        r100.max_position = this.max_position;
        r100.thread_id = this.thread_id;
        r100.thread_max_position = this.thread_max_position;
        r100.max_position_badge_count = this.max_position_badge_count;
        r100.thread_max_position_badge_count = this.thread_max_position_badge_count;
        r100.fold_ids = Internal.copyOf("fold_ids", this.fold_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateMessagesMeReadRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateMessagesMeReadRequest(List<String> r110, Channel r111, Integer r112, String r113, Integer r114, Integer r115, Integer r116, List<Long> r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public UpdateMessagesMeReadRequest(List<String> r100, Channel r101, Integer r102, String r103, Integer r104, Integer r105, Integer r106, List<Long> r107, ByteString r110) {
        super(ADAPTER, r110);
        this.message_ids = Internal.immutableCopyOf("message_ids", r100);
        this.channel = r101;
        this.max_position = r102;
        this.thread_id = r103;
        this.thread_max_position = r104;
        this.max_position_badge_count = r105;
        this.thread_max_position_badge_count = r106;
        this.fold_ids = Internal.immutableCopyOf("fold_ids", r107);
    }
}
