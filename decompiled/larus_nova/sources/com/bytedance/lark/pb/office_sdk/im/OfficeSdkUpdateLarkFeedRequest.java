package com.bytedance.lark.pb.office_sdk.im;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class OfficeSdkUpdateLarkFeedRequest extends Message<OfficeSdkUpdateLarkFeedRequest, Builder> {
    public static final ProtoAdapter<OfficeSdkUpdateLarkFeedRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<PairFeed> feeds;

    public static final class Builder extends Message.Builder<OfficeSdkUpdateLarkFeedRequest, Builder> {
        public List<PairFeed> feeds;

        @Override // com.squareup.wire.Message.Builder
        public OfficeSdkUpdateLarkFeedRequest build() {
            return new OfficeSdkUpdateLarkFeedRequest(this.feeds, super.buildUnknownFields());
        }

        public Builder() {
            this.feeds = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder feeds(List<PairFeed> r100) {
            Internal.checkElementsNotNull(r100);
            this.feeds = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_OfficeSdkUpdateLarkFeedRequest extends ProtoAdapter<OfficeSdkUpdateLarkFeedRequest> {
        public ProtoAdapter_OfficeSdkUpdateLarkFeedRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, OfficeSdkUpdateLarkFeedRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OfficeSdkUpdateLarkFeedRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.feeds.add(PairFeed.ADAPTER.decode(r100));
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
        public int encodedSize2(OfficeSdkUpdateLarkFeedRequest r100) {
            return PairFeed.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.feeds) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OfficeSdkUpdateLarkFeedRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OfficeSdkUpdateLarkFeedRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OfficeSdkUpdateLarkFeedRequest r101) throws IOException {
            PairFeed.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.feeds);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OfficeSdkUpdateLarkFeedRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OfficeSdkUpdateLarkFeedRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.feeds = Internal.copyOf("feeds", this.feeds);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OfficeSdkUpdateLarkFeedRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OfficeSdkUpdateLarkFeedRequest(List<PairFeed> r100) {
        this(r100, ByteString.EMPTY);
    }

    public OfficeSdkUpdateLarkFeedRequest(List<PairFeed> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.feeds = Internal.immutableCopyOf("feeds", r100);
    }
}
