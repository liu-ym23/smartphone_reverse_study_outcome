package lark_biz_feed.proto;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class LarkBizFeedStructPayload69115a2878680bc6 extends Message<LarkBizFeedStructPayload69115a2878680bc6, Builder> {
    public static final ProtoAdapter<LarkBizFeedStructPayload69115a2878680bc6> ADAPTER = null;
    public static final FeedFilterType DEFAULT_FOLDER = null;
    private static final long serialVersionUID = 0;
    public final FeedFilterType folder;

    public static final class Builder extends Message.Builder<LarkBizFeedStructPayload69115a2878680bc6, Builder> {
        public FeedFilterType folder;

        @Override // com.squareup.wire.Message.Builder
        public LarkBizFeedStructPayload69115a2878680bc6 build() {
            FeedFilterType r100 = this.folder;
            if (r100 == null) goto L7;
            return new LarkBizFeedStructPayload69115a2878680bc6(this.folder, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, DocumentType.FOLDER_NAME});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder folder(FeedFilterType r100) {
            this.folder = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LarkBizFeedStructPayload69115a2878680bc6 extends ProtoAdapter<LarkBizFeedStructPayload69115a2878680bc6> {
        public ProtoAdapter_LarkBizFeedStructPayload69115a2878680bc6() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkBizFeedStructPayload69115a2878680bc6.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public LarkBizFeedStructPayload69115a2878680bc6 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.folder = FeedFilterType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(LarkBizFeedStructPayload69115a2878680bc6 r100) {
            return FeedFilterType.ADAPTER.encodedSizeWithTag(1, r100.folder) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LarkBizFeedStructPayload69115a2878680bc6 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LarkBizFeedStructPayload69115a2878680bc6 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LarkBizFeedStructPayload69115a2878680bc6 r101) throws IOException {
            FeedFilterType.ADAPTER.encodeWithTag(r100, 1, r101.folder);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkBizFeedStructPayload69115a2878680bc6 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LarkBizFeedStructPayload69115a2878680bc6();
        DEFAULT_FOLDER = FeedFilterType.VAR_FEED_FILTER_TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.folder = this.folder;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LarkBizFeedStructPayload69115a2878680bc6.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LarkBizFeedStructPayload69115a2878680bc6(FeedFilterType r100) {
        this(r100, ByteString.EMPTY);
    }

    public LarkBizFeedStructPayload69115a2878680bc6(FeedFilterType r100, ByteString r101) {
        super(ADAPTER, r101);
        this.folder = r100;
    }
}
