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
public final class LarkBizFeedStructPayload2eaf423772123ddd extends Message<LarkBizFeedStructPayload2eaf423772123ddd, Builder> {
    public static final ProtoAdapter<LarkBizFeedStructPayload2eaf423772123ddd> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final Long chat_id;

    public static final class Builder extends Message.Builder<LarkBizFeedStructPayload2eaf423772123ddd, Builder> {
        public Long chat_id;

        @Override // com.squareup.wire.Message.Builder
        public LarkBizFeedStructPayload2eaf423772123ddd build() {
            Long r100 = this.chat_id;
            if (r100 == null) goto L7;
            return new LarkBizFeedStructPayload2eaf423772123ddd(this.chat_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "chat_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(Long r100) {
            this.chat_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LarkBizFeedStructPayload2eaf423772123ddd extends ProtoAdapter<LarkBizFeedStructPayload2eaf423772123ddd> {
        public ProtoAdapter_LarkBizFeedStructPayload2eaf423772123ddd() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkBizFeedStructPayload2eaf423772123ddd.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public LarkBizFeedStructPayload2eaf423772123ddd decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.chat_id = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(LarkBizFeedStructPayload2eaf423772123ddd r100) {
            return ProtoAdapter.INT64.encodedSizeWithTag(1, r100.chat_id) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LarkBizFeedStructPayload2eaf423772123ddd decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LarkBizFeedStructPayload2eaf423772123ddd r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LarkBizFeedStructPayload2eaf423772123ddd r101) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.chat_id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkBizFeedStructPayload2eaf423772123ddd r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LarkBizFeedStructPayload2eaf423772123ddd();
        DEFAULT_CHAT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LarkBizFeedStructPayload2eaf423772123ddd.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LarkBizFeedStructPayload2eaf423772123ddd(Long r100) {
        this(r100, ByteString.EMPTY);
    }

    public LarkBizFeedStructPayload2eaf423772123ddd(Long r100, ByteString r101) {
        super(ADAPTER, r101);
        this.chat_id = r100;
    }
}
