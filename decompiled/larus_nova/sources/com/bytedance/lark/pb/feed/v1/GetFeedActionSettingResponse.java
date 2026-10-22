package com.bytedance.lark.pb.feed.v1;

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
public final class GetFeedActionSettingResponse extends Message<GetFeedActionSettingResponse, Builder> {
    public static final ProtoAdapter<GetFeedActionSettingResponse> ADAPTER = null;
    public static final ProtoAdapter_GetFeedActionSettingResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final FeedQuickActionSetting quick_action;
    public final FeedSlideActionSetting slide_action;

    public static final class Builder extends Message.Builder<GetFeedActionSettingResponse, Builder> implements d<GetFeedActionSettingResponse> {
        public FeedQuickActionSetting quick_action;
        public FeedSlideActionSetting slide_action;

        @Override // com.squareup.wire.Message.Builder
        public GetFeedActionSettingResponse build() {
            return new GetFeedActionSettingResponse(this.slide_action, this.quick_action, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder quick_action(FeedQuickActionSetting r100) {
            this.quick_action = r100;
            return this;
        }

        public Builder slide_action(FeedSlideActionSetting r100) {
            this.slide_action = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetFeedActionSettingResponse extends ProtoAdapter<GetFeedActionSettingResponse> implements c<GetFeedActionSettingResponse> {
        public ProtoAdapter_GetFeedActionSettingResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetFeedActionSettingResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetFeedActionSettingResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.slide_action = FeedSlideActionSetting.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.quick_action = FeedQuickActionSetting.ADAPTER.decode(r100);
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
        public int encodedSize2(GetFeedActionSettingResponse r100) {
            FeedSlideActionSetting r101 = r100.slide_action;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = FeedSlideActionSetting.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            FeedQuickActionSetting r104 = r100.quick_action;
            if (r104 == null) goto L10;
            r102 = FeedQuickActionSetting.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetFeedActionSettingResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetFeedActionSettingResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetFeedActionSettingResponse r101) throws IOException {
            FeedSlideActionSetting r102 = r101.slide_action;
            if (r102 == null) goto L5;
            FeedSlideActionSetting.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            FeedQuickActionSetting r103 = r101.quick_action;
            if (r103 == null) goto L8;
            FeedQuickActionSetting.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetFeedActionSettingResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetFeedActionSettingResponse r100 = new ProtoAdapter_GetFeedActionSettingResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.slide_action = this.slide_action;
        r100.quick_action = this.quick_action;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetFeedActionSettingResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetFeedActionSettingResponse(FeedSlideActionSetting r100, FeedQuickActionSetting r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetFeedActionSettingResponse(FeedSlideActionSetting r100, FeedQuickActionSetting r101, ByteString r102) {
        super(ADAPTER, r102);
        this.slide_action = r100;
        this.quick_action = r101;
    }
}
