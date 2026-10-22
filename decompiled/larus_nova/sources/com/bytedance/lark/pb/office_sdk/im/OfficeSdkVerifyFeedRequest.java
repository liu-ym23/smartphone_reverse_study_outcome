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
public final class OfficeSdkVerifyFeedRequest extends Message<OfficeSdkVerifyFeedRequest, Builder> {
    public static final ProtoAdapter<OfficeSdkVerifyFeedRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<MetaFeed> meta_feed;

    public static final class Builder extends Message.Builder<OfficeSdkVerifyFeedRequest, Builder> {
        public List<MetaFeed> meta_feed;

        @Override // com.squareup.wire.Message.Builder
        public OfficeSdkVerifyFeedRequest build() {
            return new OfficeSdkVerifyFeedRequest(this.meta_feed, super.buildUnknownFields());
        }

        public Builder() {
            this.meta_feed = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder meta_feed(List<MetaFeed> r100) {
            Internal.checkElementsNotNull(r100);
            this.meta_feed = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_OfficeSdkVerifyFeedRequest extends ProtoAdapter<OfficeSdkVerifyFeedRequest> {
        public ProtoAdapter_OfficeSdkVerifyFeedRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, OfficeSdkVerifyFeedRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OfficeSdkVerifyFeedRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.meta_feed.add(MetaFeed.ADAPTER.decode(r100));
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
        public int encodedSize2(OfficeSdkVerifyFeedRequest r100) {
            return MetaFeed.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.meta_feed) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OfficeSdkVerifyFeedRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OfficeSdkVerifyFeedRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OfficeSdkVerifyFeedRequest r101) throws IOException {
            MetaFeed.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.meta_feed);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OfficeSdkVerifyFeedRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OfficeSdkVerifyFeedRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.meta_feed = Internal.copyOf("meta_feed", this.meta_feed);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OfficeSdkVerifyFeedRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OfficeSdkVerifyFeedRequest(List<MetaFeed> r100) {
        this(r100, ByteString.EMPTY);
    }

    public OfficeSdkVerifyFeedRequest(List<MetaFeed> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.meta_feed = Internal.immutableCopyOf("meta_feed", r100);
    }
}
