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
public final class UpdateThreadsMeReadRequest extends Message<UpdateThreadsMeReadRequest, Builder> {
    public static final ProtoAdapter<UpdateThreadsMeReadRequest> ADAPTER = null;
    public static final Integer DEFAULT_READ_POSITION = null;
    public static final Integer DEFAULT_READ_POSITION_BADGE_COUNT = null;
    public static final ProtoAdapter_UpdateThreadsMeReadRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Channel channel;
    public final Integer read_position;
    public final Integer read_position_badge_count;
    public final List<String> thread_ids;

    public static final class Builder extends Message.Builder<UpdateThreadsMeReadRequest, Builder> implements d<UpdateThreadsMeReadRequest> {
        public Channel channel;
        public Integer read_position;
        public Integer read_position_badge_count;
        public List<String> thread_ids;

        @Override // com.squareup.wire.Message.Builder
        public UpdateThreadsMeReadRequest build() {
            Channel r100 = this.channel;
            if (r100 == null) goto L11;
            if (this.read_position == null) goto L11;
            if (this.read_position_badge_count == null) goto L11;
            return new UpdateThreadsMeReadRequest(this.channel, this.thread_ids, this.read_position, this.read_position_badge_count, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "channel", this.read_position, "read_position", this.read_position_badge_count, "read_position_badge_count"});
        }

        public Builder() {
            this.thread_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder channel(Channel r100) {
            this.channel = r100;
            return this;
        }

        public Builder read_position(Integer r100) {
            this.read_position = r100;
            return this;
        }

        public Builder read_position_badge_count(Integer r100) {
            this.read_position_badge_count = r100;
            return this;
        }

        public Builder thread_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.thread_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateThreadsMeReadRequest extends ProtoAdapter<UpdateThreadsMeReadRequest> implements c<UpdateThreadsMeReadRequest> {
        public ProtoAdapter_UpdateThreadsMeReadRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateThreadsMeReadRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateThreadsMeReadRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.read_position = 0;
            r101.read_position_badge_count = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.channel = Channel.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.thread_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.read_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.read_position_badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UpdateThreadsMeReadRequest r100) {
            int r101 = Channel.ADAPTER.encodedSizeWithTag(1, r100.channel) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.thread_ids);
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            return ((r101 + r102.encodedSizeWithTag(3, r100.read_position)) + r102.encodedSizeWithTag(4, r100.read_position_badge_count)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateThreadsMeReadRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateThreadsMeReadRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateThreadsMeReadRequest r101) throws IOException {
            Channel.ADAPTER.encodeWithTag(r100, 1, r101.channel);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.thread_ids);
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.encodeWithTag(r100, 3, r101.read_position);
            r102.encodeWithTag(r100, 4, r101.read_position_badge_count);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateThreadsMeReadRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateThreadsMeReadRequest r100 = new ProtoAdapter_UpdateThreadsMeReadRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_READ_POSITION = 0;
        DEFAULT_READ_POSITION_BADGE_COUNT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.channel = this.channel;
        r100.thread_ids = Internal.copyOf("thread_ids", this.thread_ids);
        r100.read_position = this.read_position;
        r100.read_position_badge_count = this.read_position_badge_count;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateThreadsMeReadRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateThreadsMeReadRequest(Channel r100, List<String> r101, Integer r102, Integer r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public UpdateThreadsMeReadRequest(Channel r100, List<String> r101, Integer r102, Integer r103, ByteString r104) {
        super(ADAPTER, r104);
        this.channel = r100;
        this.thread_ids = Internal.immutableCopyOf("thread_ids", r101);
        this.read_position = r102;
        this.read_position_badge_count = r103;
    }
}
