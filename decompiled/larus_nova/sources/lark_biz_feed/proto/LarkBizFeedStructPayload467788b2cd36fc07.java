package lark_biz_feed.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class LarkBizFeedStructPayload467788b2cd36fc07 extends Message<LarkBizFeedStructPayload467788b2cd36fc07, Builder> {
    public static final ProtoAdapter<LarkBizFeedStructPayload467788b2cd36fc07> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> feed_ids;

    public static final class Builder extends Message.Builder<LarkBizFeedStructPayload467788b2cd36fc07, Builder> {
        public List<String> feed_ids;

        @Override // com.squareup.wire.Message.Builder
        public LarkBizFeedStructPayload467788b2cd36fc07 build() {
            return new LarkBizFeedStructPayload467788b2cd36fc07(this.feed_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.feed_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder feed_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.feed_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LarkBizFeedStructPayload467788b2cd36fc07 extends ProtoAdapter<LarkBizFeedStructPayload467788b2cd36fc07> {
        public ProtoAdapter_LarkBizFeedStructPayload467788b2cd36fc07() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkBizFeedStructPayload467788b2cd36fc07.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public LarkBizFeedStructPayload467788b2cd36fc07 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.feed_ids.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(LarkBizFeedStructPayload467788b2cd36fc07 r100) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.feed_ids) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LarkBizFeedStructPayload467788b2cd36fc07 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LarkBizFeedStructPayload467788b2cd36fc07 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LarkBizFeedStructPayload467788b2cd36fc07 r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.feed_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkBizFeedStructPayload467788b2cd36fc07 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LarkBizFeedStructPayload467788b2cd36fc07();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.feed_ids = Internal.copyOf("feed_ids", this.feed_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LarkBizFeedStructPayload467788b2cd36fc07.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LarkBizFeedStructPayload467788b2cd36fc07(List<String> r100) {
        this(r100, ByteString.EMPTY);
    }

    public LarkBizFeedStructPayload467788b2cd36fc07(List<String> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.feed_ids = Internal.immutableCopyOf("feed_ids", r100);
    }
}
