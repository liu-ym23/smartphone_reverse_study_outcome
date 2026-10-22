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
public final class LarkBizFeedStructPayload227619f5325cb7cd extends Message<LarkBizFeedStructPayload227619f5325cb7cd, Builder> {
    public static final ProtoAdapter<LarkBizFeedStructPayload227619f5325cb7cd> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final FeedCardEntity feed_entity;

    public static final class Builder extends Message.Builder<LarkBizFeedStructPayload227619f5325cb7cd, Builder> {
        public FeedCardEntity feed_entity;

        @Override // com.squareup.wire.Message.Builder
        public LarkBizFeedStructPayload227619f5325cb7cd build() {
            FeedCardEntity r100 = this.feed_entity;
            if (r100 == null) goto L7;
            return new LarkBizFeedStructPayload227619f5325cb7cd(this.feed_entity, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "feed_entity"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder feed_entity(FeedCardEntity r100) {
            this.feed_entity = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LarkBizFeedStructPayload227619f5325cb7cd extends ProtoAdapter<LarkBizFeedStructPayload227619f5325cb7cd> {
        public ProtoAdapter_LarkBizFeedStructPayload227619f5325cb7cd() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkBizFeedStructPayload227619f5325cb7cd.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public LarkBizFeedStructPayload227619f5325cb7cd decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.feed_entity = FeedCardEntity.ADAPTER.decode(r100);
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
        public int encodedSize2(LarkBizFeedStructPayload227619f5325cb7cd r100) {
            return FeedCardEntity.ADAPTER.encodedSizeWithTag(1, r100.feed_entity) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LarkBizFeedStructPayload227619f5325cb7cd decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LarkBizFeedStructPayload227619f5325cb7cd r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LarkBizFeedStructPayload227619f5325cb7cd r101) throws IOException {
            FeedCardEntity.ADAPTER.encodeWithTag(r100, 1, r101.feed_entity);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkBizFeedStructPayload227619f5325cb7cd r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LarkBizFeedStructPayload227619f5325cb7cd();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.feed_entity = this.feed_entity;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LarkBizFeedStructPayload227619f5325cb7cd.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LarkBizFeedStructPayload227619f5325cb7cd(FeedCardEntity r100) {
        this(r100, ByteString.EMPTY);
    }

    public LarkBizFeedStructPayload227619f5325cb7cd(FeedCardEntity r100, ByteString r101) {
        super(ADAPTER, r101);
        this.feed_entity = r100;
    }
}
