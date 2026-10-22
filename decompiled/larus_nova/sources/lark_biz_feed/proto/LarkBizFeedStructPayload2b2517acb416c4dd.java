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
public final class LarkBizFeedStructPayload2b2517acb416c4dd extends Message<LarkBizFeedStructPayload2b2517acb416c4dd, Builder> {
    public static final ProtoAdapter<LarkBizFeedStructPayload2b2517acb416c4dd> ADAPTER = null;
    public static final FeedFilterType DEFAULT_FOLDER = null;
    public static final Boolean DEFAULT_IS_SCROLLING = null;
    public static final Integer DEFAULT_POSITION = null;
    private static final long serialVersionUID = 0;
    public final FeedFilterType folder;
    public final Boolean is_scrolling;
    public final Integer position;

    public static final class Builder extends Message.Builder<LarkBizFeedStructPayload2b2517acb416c4dd, Builder> {
        public FeedFilterType folder;
        public Boolean is_scrolling;
        public Integer position;

        @Override // com.squareup.wire.Message.Builder
        public LarkBizFeedStructPayload2b2517acb416c4dd build() {
            FeedFilterType r100 = this.folder;
            if (r100 == null) goto L11;
            if (this.position == null) goto L11;
            if (this.is_scrolling == null) goto L11;
            return new LarkBizFeedStructPayload2b2517acb416c4dd(this.folder, this.position, this.is_scrolling, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, DocumentType.FOLDER_NAME, this.position, "position", this.is_scrolling, "is_scrolling"});
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

        public Builder is_scrolling(Boolean r100) {
            this.is_scrolling = r100;
            return this;
        }

        public Builder position(Integer r100) {
            this.position = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LarkBizFeedStructPayload2b2517acb416c4dd extends ProtoAdapter<LarkBizFeedStructPayload2b2517acb416c4dd> {
        public ProtoAdapter_LarkBizFeedStructPayload2b2517acb416c4dd() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkBizFeedStructPayload2b2517acb416c4dd.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public LarkBizFeedStructPayload2b2517acb416c4dd decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.folder = FeedFilterType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.is_scrolling = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(LarkBizFeedStructPayload2b2517acb416c4dd r100) {
            return ((FeedFilterType.ADAPTER.encodedSizeWithTag(1, r100.folder) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.position)) + ProtoAdapter.BOOL.encodedSizeWithTag(3, r100.is_scrolling)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LarkBizFeedStructPayload2b2517acb416c4dd decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LarkBizFeedStructPayload2b2517acb416c4dd r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LarkBizFeedStructPayload2b2517acb416c4dd r101) throws IOException {
            FeedFilterType.ADAPTER.encodeWithTag(r100, 1, r101.folder);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.position);
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r101.is_scrolling);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkBizFeedStructPayload2b2517acb416c4dd r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LarkBizFeedStructPayload2b2517acb416c4dd();
        DEFAULT_FOLDER = FeedFilterType.VAR_FEED_FILTER_TYPE_UNKNOWN;
        DEFAULT_POSITION = 0;
        DEFAULT_IS_SCROLLING = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.folder = this.folder;
        r100.position = this.position;
        r100.is_scrolling = this.is_scrolling;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LarkBizFeedStructPayload2b2517acb416c4dd.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LarkBizFeedStructPayload2b2517acb416c4dd(FeedFilterType r100, Integer r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public LarkBizFeedStructPayload2b2517acb416c4dd(FeedFilterType r100, Integer r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.folder = r100;
        this.position = r101;
        this.is_scrolling = r102;
    }
}
