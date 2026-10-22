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
public final class LarkBizFeedStructPayloadBfabc31623467351 extends Message<LarkBizFeedStructPayloadBfabc31623467351, Builder> {
    public static final ProtoAdapter<LarkBizFeedStructPayloadBfabc31623467351> ADAPTER = null;
    public static final Boolean DEFAULT_MARK_AS_UNREAD = null;
    private static final long serialVersionUID = 0;
    public final FeedCardEntity feed_entity;
    public final Boolean mark_as_unread;

    public static final class Builder extends Message.Builder<LarkBizFeedStructPayloadBfabc31623467351, Builder> {
        public FeedCardEntity feed_entity;
        public Boolean mark_as_unread;

        @Override // com.squareup.wire.Message.Builder
        public LarkBizFeedStructPayloadBfabc31623467351 build() {
            FeedCardEntity r100 = this.feed_entity;
            if (r100 == null) goto L9;
            if (this.mark_as_unread == null) goto L9;
            return new LarkBizFeedStructPayloadBfabc31623467351(this.feed_entity, this.mark_as_unread, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "feed_entity", this.mark_as_unread, "mark_as_unread"});
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

        public Builder mark_as_unread(Boolean r100) {
            this.mark_as_unread = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LarkBizFeedStructPayloadBfabc31623467351 extends ProtoAdapter<LarkBizFeedStructPayloadBfabc31623467351> {
        public ProtoAdapter_LarkBizFeedStructPayloadBfabc31623467351() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkBizFeedStructPayloadBfabc31623467351.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public LarkBizFeedStructPayloadBfabc31623467351 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.feed_entity = FeedCardEntity.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mark_as_unread = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(LarkBizFeedStructPayloadBfabc31623467351 r100) {
            return (FeedCardEntity.ADAPTER.encodedSizeWithTag(1, r100.feed_entity) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.mark_as_unread)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LarkBizFeedStructPayloadBfabc31623467351 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LarkBizFeedStructPayloadBfabc31623467351 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LarkBizFeedStructPayloadBfabc31623467351 r101) throws IOException {
            FeedCardEntity.ADAPTER.encodeWithTag(r100, 1, r101.feed_entity);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.mark_as_unread);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkBizFeedStructPayloadBfabc31623467351 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LarkBizFeedStructPayloadBfabc31623467351();
        DEFAULT_MARK_AS_UNREAD = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.feed_entity = this.feed_entity;
        r100.mark_as_unread = this.mark_as_unread;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LarkBizFeedStructPayloadBfabc31623467351.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LarkBizFeedStructPayloadBfabc31623467351(FeedCardEntity r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public LarkBizFeedStructPayloadBfabc31623467351(FeedCardEntity r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.feed_entity = r100;
        this.mark_as_unread = r101;
    }
}
