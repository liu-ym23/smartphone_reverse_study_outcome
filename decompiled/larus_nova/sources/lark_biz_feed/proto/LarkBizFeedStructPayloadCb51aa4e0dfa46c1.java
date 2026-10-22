package lark_biz_feed.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class LarkBizFeedStructPayloadCb51aa4e0dfa46c1 extends Message<LarkBizFeedStructPayloadCb51aa4e0dfa46c1, Builder> {
    public static final ProtoAdapter<LarkBizFeedStructPayloadCb51aa4e0dfa46c1> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ChannelEntity channel_entity;

    public static final class Builder extends Message.Builder<LarkBizFeedStructPayloadCb51aa4e0dfa46c1, Builder> {
        public ChannelEntity channel_entity;

        @Override // com.squareup.wire.Message.Builder
        public LarkBizFeedStructPayloadCb51aa4e0dfa46c1 build() {
            ChannelEntity r100 = this.channel_entity;
            if (r100 == null) goto L7;
            return new LarkBizFeedStructPayloadCb51aa4e0dfa46c1(this.channel_entity, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "channel_entity"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder channel_entity(ChannelEntity r100) {
            this.channel_entity = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LarkBizFeedStructPayloadCb51aa4e0dfa46c1 extends ProtoAdapter<LarkBizFeedStructPayloadCb51aa4e0dfa46c1> {
        public ProtoAdapter_LarkBizFeedStructPayloadCb51aa4e0dfa46c1() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkBizFeedStructPayloadCb51aa4e0dfa46c1.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public LarkBizFeedStructPayloadCb51aa4e0dfa46c1 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.channel_entity = ChannelEntity.ADAPTER.decode(r100);
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
        public int encodedSize2(LarkBizFeedStructPayloadCb51aa4e0dfa46c1 r100) {
            return ChannelEntity.ADAPTER.encodedSizeWithTag(1, r100.channel_entity) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LarkBizFeedStructPayloadCb51aa4e0dfa46c1 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LarkBizFeedStructPayloadCb51aa4e0dfa46c1 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LarkBizFeedStructPayloadCb51aa4e0dfa46c1 r101) throws IOException {
            ChannelEntity.ADAPTER.encodeWithTag(r100, 1, r101.channel_entity);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkBizFeedStructPayloadCb51aa4e0dfa46c1 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LarkBizFeedStructPayloadCb51aa4e0dfa46c1();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.channel_entity = this.channel_entity;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LarkBizFeedStructPayloadCb51aa4e0dfa46c1.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LarkBizFeedStructPayloadCb51aa4e0dfa46c1(ChannelEntity r100) {
        this(r100, ByteString.EMPTY);
    }

    public LarkBizFeedStructPayloadCb51aa4e0dfa46c1(ChannelEntity r100, ByteString r101) {
        super(ADAPTER, r101);
        this.channel_entity = r100;
    }
}
