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
public final class LarkBizFeedStructPayload7e251b9c83581426 extends Message<LarkBizFeedStructPayload7e251b9c83581426, Builder> {
    public static final ProtoAdapter<LarkBizFeedStructPayload7e251b9c83581426> ADAPTER = null;
    public static final Integer DEFAULT_POSITION = null;
    private static final long serialVersionUID = 0;
    public final List<String> feed_ids;
    public final Integer position;

    public static final class Builder extends Message.Builder<LarkBizFeedStructPayload7e251b9c83581426, Builder> {
        public List<String> feed_ids;
        public Integer position;

        @Override // com.squareup.wire.Message.Builder
        public LarkBizFeedStructPayload7e251b9c83581426 build() {
            Integer r100 = this.position;
            if (r100 == null) goto L7;
            return new LarkBizFeedStructPayload7e251b9c83581426(this.feed_ids, this.position, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "position"});
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

        public Builder position(Integer r100) {
            this.position = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LarkBizFeedStructPayload7e251b9c83581426 extends ProtoAdapter<LarkBizFeedStructPayload7e251b9c83581426> {
        public ProtoAdapter_LarkBizFeedStructPayload7e251b9c83581426() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkBizFeedStructPayload7e251b9c83581426.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public LarkBizFeedStructPayload7e251b9c83581426 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.feed_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.position = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(LarkBizFeedStructPayload7e251b9c83581426 r100) {
            return (ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.feed_ids) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.position)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LarkBizFeedStructPayload7e251b9c83581426 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LarkBizFeedStructPayload7e251b9c83581426 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LarkBizFeedStructPayload7e251b9c83581426 r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.feed_ids);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.position);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkBizFeedStructPayload7e251b9c83581426 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LarkBizFeedStructPayload7e251b9c83581426();
        DEFAULT_POSITION = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.feed_ids = Internal.copyOf("feed_ids", this.feed_ids);
        r100.position = this.position;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LarkBizFeedStructPayload7e251b9c83581426.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LarkBizFeedStructPayload7e251b9c83581426(List<String> r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public LarkBizFeedStructPayload7e251b9c83581426(List<String> r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.feed_ids = Internal.immutableCopyOf("feed_ids", r100);
        this.position = r101;
    }
}
