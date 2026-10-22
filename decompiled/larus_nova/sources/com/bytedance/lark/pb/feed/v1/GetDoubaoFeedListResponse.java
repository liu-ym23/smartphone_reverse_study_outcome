package com.bytedance.lark.pb.feed.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetDoubaoFeedListResponse extends Message<GetDoubaoFeedListResponse, Builder> {
    public static final ProtoAdapter<GetDoubaoFeedListResponse> ADAPTER = null;
    public static final ProtoAdapter_GetDoubaoFeedListResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final FeedCursor next_cursor;
    public final List<FeedEntityPreview> previews;

    public static final class Builder extends Message.Builder<GetDoubaoFeedListResponse, Builder> implements d<GetDoubaoFeedListResponse> {
        public FeedCursor next_cursor;
        public List<FeedEntityPreview> previews;

        @Override // com.squareup.wire.Message.Builder
        public GetDoubaoFeedListResponse build() {
            return new GetDoubaoFeedListResponse(this.next_cursor, this.previews, super.buildUnknownFields());
        }

        public Builder() {
            this.previews = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder next_cursor(FeedCursor r100) {
            this.next_cursor = r100;
            return this;
        }

        public Builder previews(List<FeedEntityPreview> r100) {
            Internal.checkElementsNotNull(r100);
            this.previews = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetDoubaoFeedListResponse extends ProtoAdapter<GetDoubaoFeedListResponse> implements c<GetDoubaoFeedListResponse> {
        public ProtoAdapter_GetDoubaoFeedListResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetDoubaoFeedListResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetDoubaoFeedListResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.next_cursor = FeedCursor.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.previews.add(FeedEntityPreview.ADAPTER.decode(r100));
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
        public int encodedSize2(GetDoubaoFeedListResponse r100) {
            FeedCursor r101 = r100.next_cursor;
            if (r101 == null) goto L5;
            int r102 = FeedCursor.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + FeedEntityPreview.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.previews)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetDoubaoFeedListResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetDoubaoFeedListResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetDoubaoFeedListResponse r101) throws IOException {
            FeedCursor r102 = r101.next_cursor;
            if (r102 == null) goto L5;
            FeedCursor.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            FeedEntityPreview.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.previews);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetDoubaoFeedListResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetDoubaoFeedListResponse r100 = new ProtoAdapter_GetDoubaoFeedListResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.next_cursor = this.next_cursor;
        r100.previews = Internal.copyOf("previews", this.previews);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetDoubaoFeedListResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetDoubaoFeedListResponse(FeedCursor r100, List<FeedEntityPreview> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetDoubaoFeedListResponse(FeedCursor r100, List<FeedEntityPreview> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.next_cursor = r100;
        this.previews = Internal.immutableCopyOf("previews", r101);
    }
}
