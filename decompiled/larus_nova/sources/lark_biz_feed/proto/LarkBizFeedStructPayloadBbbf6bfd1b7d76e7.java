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
public final class LarkBizFeedStructPayloadBbbf6bfd1b7d76e7 extends Message<LarkBizFeedStructPayloadBbbf6bfd1b7d76e7, Builder> {
    public static final ProtoAdapter<LarkBizFeedStructPayloadBbbf6bfd1b7d76e7> ADAPTER = null;
    public static final String DEFAULT_FEED_ID = "";
    private static final long serialVersionUID = 0;
    public final String feed_id;

    public static final class Builder extends Message.Builder<LarkBizFeedStructPayloadBbbf6bfd1b7d76e7, Builder> {
        public String feed_id;

        @Override // com.squareup.wire.Message.Builder
        public LarkBizFeedStructPayloadBbbf6bfd1b7d76e7 build() {
            String r100 = this.feed_id;
            if (r100 == null) goto L7;
            return new LarkBizFeedStructPayloadBbbf6bfd1b7d76e7(this.feed_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "feed_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder feed_id(String r100) {
            this.feed_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LarkBizFeedStructPayloadBbbf6bfd1b7d76e7 extends ProtoAdapter<LarkBizFeedStructPayloadBbbf6bfd1b7d76e7> {
        public ProtoAdapter_LarkBizFeedStructPayloadBbbf6bfd1b7d76e7() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkBizFeedStructPayloadBbbf6bfd1b7d76e7.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public LarkBizFeedStructPayloadBbbf6bfd1b7d76e7 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.feed_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(LarkBizFeedStructPayloadBbbf6bfd1b7d76e7 r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.feed_id) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LarkBizFeedStructPayloadBbbf6bfd1b7d76e7 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LarkBizFeedStructPayloadBbbf6bfd1b7d76e7 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LarkBizFeedStructPayloadBbbf6bfd1b7d76e7 r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.feed_id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkBizFeedStructPayloadBbbf6bfd1b7d76e7 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LarkBizFeedStructPayloadBbbf6bfd1b7d76e7();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.feed_id = this.feed_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LarkBizFeedStructPayloadBbbf6bfd1b7d76e7.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LarkBizFeedStructPayloadBbbf6bfd1b7d76e7(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public LarkBizFeedStructPayloadBbbf6bfd1b7d76e7(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.feed_id = r100;
    }
}
