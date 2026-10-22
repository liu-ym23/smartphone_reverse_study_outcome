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
public final class UpdateFeedCardUnreadRequest extends Message<UpdateFeedCardUnreadRequest, Builder> {
    public static final ProtoAdapter<UpdateFeedCardUnreadRequest> ADAPTER = null;
    public static final FeedCard.EntityType DEFAULT_ENTITY_TYPE = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_MARK_AS_UNREAD = null;
    public static final ProtoAdapter_UpdateFeedCardUnreadRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final FeedCard.EntityType entity_type;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253633id;
    public final Boolean mark_as_unread;

    public static final class Builder extends Message.Builder<UpdateFeedCardUnreadRequest, Builder> implements d<UpdateFeedCardUnreadRequest> {
        public FeedCard.EntityType entity_type;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253634id;
        public Boolean mark_as_unread;

        @Override // com.squareup.wire.Message.Builder
        public UpdateFeedCardUnreadRequest build() {
            return new UpdateFeedCardUnreadRequest(this.f253634id, this.entity_type, this.mark_as_unread, super.buildUnknownFields());
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
            this.f253634id = r100;
            return this;
        }

        public Builder mark_as_unread(Boolean r100) {
            this.mark_as_unread = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateFeedCardUnreadRequest extends ProtoAdapter<UpdateFeedCardUnreadRequest> implements c<UpdateFeedCardUnreadRequest> {
        public ProtoAdapter_UpdateFeedCardUnreadRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateFeedCardUnreadRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateFeedCardUnreadRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253634id = "";
            r101.entity_type = FeedCard.EntityType.UNKNOWN_ENTITY;
            r101.mark_as_unread = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.f253634id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.entity_type = FeedCard.EntityType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mark_as_unread = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(UpdateFeedCardUnreadRequest r100) {
            String r101 = r100.f253633id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            FeedCard.EntityType r104 = r100.entity_type;
            if (r104 == null) goto L9;
            int r105 = FeedCard.EntityType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.mark_as_unread;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateFeedCardUnreadRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateFeedCardUnreadRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateFeedCardUnreadRequest r101) throws IOException {
            String r102 = r101.f253633id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            FeedCard.EntityType r103 = r101.entity_type;
            if (r103 == null) goto L8;
            FeedCard.EntityType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.mark_as_unread;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateFeedCardUnreadRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateFeedCardUnreadRequest r100 = new ProtoAdapter_UpdateFeedCardUnreadRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_ENTITY_TYPE = FeedCard.EntityType.UNKNOWN_ENTITY;
        DEFAULT_MARK_AS_UNREAD = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253634id = this.f253633id;
        r100.entity_type = this.entity_type;
        r100.mark_as_unread = this.mark_as_unread;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateFeedCardUnreadRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateFeedCardUnreadRequest(String r100, FeedCard.EntityType r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public UpdateFeedCardUnreadRequest(String r100, FeedCard.EntityType r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.f253633id = r100;
        this.entity_type = r101;
        this.mark_as_unread = r102;
    }
}
