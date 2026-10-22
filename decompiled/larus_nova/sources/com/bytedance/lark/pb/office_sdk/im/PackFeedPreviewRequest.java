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
public final class PackFeedPreviewRequest extends Message<PackFeedPreviewRequest, Builder> {
    public static final ProtoAdapter<PackFeedPreviewRequest> ADAPTER = null;
    public static final String DEFAULT_LOCALE = "";
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final String locale;
    public final List<MetaFeed> meta_feed;
    public final Long version;

    public static final class Builder extends Message.Builder<PackFeedPreviewRequest, Builder> {
        public String locale;
        public List<MetaFeed> meta_feed;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public PackFeedPreviewRequest build() {
            String r100 = this.locale;
            if (r100 == null) goto L9;
            if (this.version == null) goto L9;
            return new PackFeedPreviewRequest(this.locale, this.version, this.meta_feed, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "locale", this.version, "version"});
        }

        public Builder() {
            this.meta_feed = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder locale(String r100) {
            this.locale = r100;
            return this;
        }

        public Builder meta_feed(List<MetaFeed> r100) {
            Internal.checkElementsNotNull(r100);
            this.meta_feed = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PackFeedPreviewRequest extends ProtoAdapter<PackFeedPreviewRequest> {
        public ProtoAdapter_PackFeedPreviewRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PackFeedPreviewRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PackFeedPreviewRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.locale = "";
            r101.version = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.locale = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.meta_feed.add(MetaFeed.ADAPTER.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PackFeedPreviewRequest r100) {
            return ((ProtoAdapter.STRING.encodedSizeWithTag(1, r100.locale) + ProtoAdapter.INT64.encodedSizeWithTag(2, r100.version)) + MetaFeed.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.meta_feed)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PackFeedPreviewRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PackFeedPreviewRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PackFeedPreviewRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.locale);
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r101.version);
            MetaFeed.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.meta_feed);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PackFeedPreviewRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PackFeedPreviewRequest();
        DEFAULT_VERSION = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.locale = this.locale;
        r100.version = this.version;
        r100.meta_feed = Internal.copyOf("meta_feed", this.meta_feed);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PackFeedPreviewRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PackFeedPreviewRequest(String r100, Long r101, List<MetaFeed> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PackFeedPreviewRequest(String r100, Long r101, List<MetaFeed> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.locale = r100;
        this.version = r101;
        this.meta_feed = Internal.immutableCopyOf("meta_feed", r102);
    }
}
