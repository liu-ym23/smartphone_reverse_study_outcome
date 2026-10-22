package com.bytedance.lark.pb.feed.v1;

import com.bytedance.lark.pb.basic.v1.FeedCard;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PeakFeedCardResponse extends Message<PeakFeedCardResponse, Builder> {
    public static final ProtoAdapter<PeakFeedCardResponse> ADAPTER = null;
    public static final ProtoAdapter_PeakFeedCardResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final FeedCard feed_card;

    public static final class Builder extends Message.Builder<PeakFeedCardResponse, Builder> implements d<PeakFeedCardResponse> {
        public FeedCard feed_card;

        @Override // com.squareup.wire.Message.Builder
        public PeakFeedCardResponse build() {
            return new PeakFeedCardResponse(this.feed_card, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder feed_card(FeedCard r100) {
            this.feed_card = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PeakFeedCardResponse extends ProtoAdapter<PeakFeedCardResponse> implements c<PeakFeedCardResponse> {
        public ProtoAdapter_PeakFeedCardResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PeakFeedCardResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PeakFeedCardResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.feed_card = FeedCard.ADAPTER.decode(r100);
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
        public int encodedSize2(PeakFeedCardResponse r100) {
            FeedCard r101 = r100.feed_card;
            if (r101 == null) goto L5;
            int r102 = FeedCard.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PeakFeedCardResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PeakFeedCardResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PeakFeedCardResponse r101) throws IOException {
            FeedCard r102 = r101.feed_card;
            if (r102 == null) goto L5;
            FeedCard.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PeakFeedCardResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PeakFeedCardResponse r100 = new ProtoAdapter_PeakFeedCardResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.feed_card = this.feed_card;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PeakFeedCardResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PeakFeedCardResponse(FeedCard r100) {
        this(r100, ByteString.EMPTY);
    }

    public PeakFeedCardResponse(FeedCard r100, ByteString r101) {
        super(ADAPTER, r101);
        this.feed_card = r100;
    }
}
