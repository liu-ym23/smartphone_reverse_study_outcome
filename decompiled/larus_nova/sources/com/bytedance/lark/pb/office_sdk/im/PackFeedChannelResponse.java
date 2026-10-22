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
public final class PackFeedChannelResponse extends Message<PackFeedChannelResponse, Builder> {
    public static final ProtoAdapter<PackFeedChannelResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<OpenFeedChannel> feed_channel;

    public static final class Builder extends Message.Builder<PackFeedChannelResponse, Builder> {
        public List<OpenFeedChannel> feed_channel;

        @Override // com.squareup.wire.Message.Builder
        public PackFeedChannelResponse build() {
            return new PackFeedChannelResponse(this.feed_channel, super.buildUnknownFields());
        }

        public Builder() {
            this.feed_channel = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder feed_channel(List<OpenFeedChannel> r100) {
            Internal.checkElementsNotNull(r100);
            this.feed_channel = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PackFeedChannelResponse extends ProtoAdapter<PackFeedChannelResponse> {
        public ProtoAdapter_PackFeedChannelResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PackFeedChannelResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PackFeedChannelResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.feed_channel.add(OpenFeedChannel.ADAPTER.decode(r100));
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
        public int encodedSize2(PackFeedChannelResponse r100) {
            return OpenFeedChannel.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.feed_channel) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PackFeedChannelResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PackFeedChannelResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PackFeedChannelResponse r101) throws IOException {
            OpenFeedChannel.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.feed_channel);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PackFeedChannelResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PackFeedChannelResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.feed_channel = Internal.copyOf("feed_channel", this.feed_channel);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PackFeedChannelResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PackFeedChannelResponse(List<OpenFeedChannel> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PackFeedChannelResponse(List<OpenFeedChannel> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.feed_channel = Internal.immutableCopyOf("feed_channel", r100);
    }
}
