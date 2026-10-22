package com.bytedance.lark.pb.feed.v1;

import com.bytedance.lark.pb.basic.v1.FeedCard;
import com.obric.capabilitykit.EntityProvider;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PeakFeedCardRequest extends Message<PeakFeedCardRequest, Builder> {
    public static final ProtoAdapter<PeakFeedCardRequest> ADAPTER = null;
    public static final FeedCard.EntityType DEFAULT_ENTITY_TYPE = null;
    public static final String DEFAULT_ID = "";
    public static final ProtoAdapter_PeakFeedCardRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final FeedCard.EntityType entity_type;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253631id;

    public static final class Builder extends Message.Builder<PeakFeedCardRequest, Builder> implements d<PeakFeedCardRequest> {
        public FeedCard.EntityType entity_type;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253632id;

        @Override // com.squareup.wire.Message.Builder
        public PeakFeedCardRequest build() {
            String r100 = this.f253632id;
            if (r100 == null) goto L9;
            if (this.entity_type == null) goto L9;
            return new PeakFeedCardRequest(this.f253632id, this.entity_type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.entity_type, EntityProvider.KEY_ENTITY_TYPE});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder entity_type(FeedCard.EntityType r100) {
            this.entity_type = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253632id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PeakFeedCardRequest extends ProtoAdapter<PeakFeedCardRequest> implements c<PeakFeedCardRequest> {
        public ProtoAdapter_PeakFeedCardRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PeakFeedCardRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PeakFeedCardRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253632id = "";
            r101.entity_type = FeedCard.EntityType.UNKNOWN_ENTITY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.f253632id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.entity_type = FeedCard.EntityType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PeakFeedCardRequest r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.f253631id) + FeedCard.EntityType.ADAPTER.encodedSizeWithTag(2, r100.entity_type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PeakFeedCardRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PeakFeedCardRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PeakFeedCardRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.f253631id);
            FeedCard.EntityType.ADAPTER.encodeWithTag(r100, 2, r101.entity_type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PeakFeedCardRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PeakFeedCardRequest r100 = new ProtoAdapter_PeakFeedCardRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_ENTITY_TYPE = FeedCard.EntityType.UNKNOWN_ENTITY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253632id = this.f253631id;
        r100.entity_type = this.entity_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PeakFeedCardRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PeakFeedCardRequest(String r100, FeedCard.EntityType r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PeakFeedCardRequest(String r100, FeedCard.EntityType r101, ByteString r102) {
        super(ADAPTER, r102);
        this.f253631id = r100;
        this.entity_type = r101;
    }
}
