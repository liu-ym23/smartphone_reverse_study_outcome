package com.bytedance.lark.pb.office_sdk.im;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class PairFeed extends Message<PairFeed, Builder> {
    public static final ProtoAdapter<PairFeed> ADAPTER = null;
    public static final String DEFAULT_BIZ_ID = "";
    public static final OfficeSdkFeedType DEFAULT_FEED_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String biz_id;
    public final OfficeSdkFeedType feed_type;

    public static final class Builder extends Message.Builder<PairFeed, Builder> {
        public String biz_id;
        public OfficeSdkFeedType feed_type;

        @Override // com.squareup.wire.Message.Builder
        public PairFeed build() {
            String r100 = this.biz_id;
            if (r100 == null) goto L9;
            if (this.feed_type == null) goto L9;
            return new PairFeed(this.biz_id, this.feed_type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, this.feed_type, "feed_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder biz_id(String r100) {
            this.biz_id = r100;
            return this;
        }

        public Builder feed_type(OfficeSdkFeedType r100) {
            this.feed_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PairFeed extends ProtoAdapter<PairFeed> {
        public ProtoAdapter_PairFeed() {
            super(FieldEncoding.LENGTH_DELIMITED, PairFeed.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PairFeed decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.biz_id = "";
            r101.feed_type = OfficeSdkFeedType.DOUBAO_CUSTOM;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.biz_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.feed_type = OfficeSdkFeedType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
        public int encodedSize2(PairFeed r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.biz_id) + OfficeSdkFeedType.ADAPTER.encodedSizeWithTag(2, r100.feed_type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PairFeed decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PairFeed r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PairFeed r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.biz_id);
            OfficeSdkFeedType.ADAPTER.encodeWithTag(r100, 2, r101.feed_type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PairFeed r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PairFeed();
        DEFAULT_FEED_TYPE = OfficeSdkFeedType.DOUBAO_CUSTOM;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.biz_id = this.biz_id;
        r100.feed_type = this.feed_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PairFeed.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PairFeed(String r100, OfficeSdkFeedType r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PairFeed(String r100, OfficeSdkFeedType r101, ByteString r102) {
        super(ADAPTER, r102);
        this.biz_id = r100;
        this.feed_type = r101;
    }
}
