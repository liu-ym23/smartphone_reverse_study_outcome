package com.bytedance.lark.pb.feed.v1;

import com.obric.miniapp.alarm.AccountType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetDoubaoFeedListRequest extends Message<GetDoubaoFeedListRequest, Builder> {
    public static final ProtoAdapter<GetDoubaoFeedListRequest> ADAPTER = null;
    public static final Integer DEFAULT_COUNT = null;
    public static final SearchFilter DEFAULT_SEARCH_FILTER = null;
    public static final ProtoAdapter_GetDoubaoFeedListRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Integer count;
    public final FeedCursor feed_cursor;
    public final SearchFilter search_filter;

    public static final class Builder extends Message.Builder<GetDoubaoFeedListRequest, Builder> implements d<GetDoubaoFeedListRequest> {
        public Integer count;
        public FeedCursor feed_cursor;
        public SearchFilter search_filter;

        @Override // com.squareup.wire.Message.Builder
        public GetDoubaoFeedListRequest build() {
            return new GetDoubaoFeedListRequest(this.feed_cursor, this.count, this.search_filter, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder count(Integer r100) {
            this.count = r100;
            return this;
        }

        public Builder feed_cursor(FeedCursor r100) {
            this.feed_cursor = r100;
            return this;
        }

        public Builder search_filter(SearchFilter r100) {
            this.search_filter = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetDoubaoFeedListRequest extends ProtoAdapter<GetDoubaoFeedListRequest> implements c<GetDoubaoFeedListRequest> {
        public ProtoAdapter_GetDoubaoFeedListRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetDoubaoFeedListRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetDoubaoFeedListRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.count = 0;
            r101.search_filter = SearchFilter.ALL;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.feed_cursor = FeedCursor.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.search_filter = SearchFilter.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        public int encodedSize2(GetDoubaoFeedListRequest r100) {
            FeedCursor r101 = r100.feed_cursor;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = FeedCursor.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.count;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            SearchFilter r107 = r100.search_filter;
            if (r107 == null) goto L14;
            r102 = SearchFilter.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ GetDoubaoFeedListRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetDoubaoFeedListRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetDoubaoFeedListRequest r101) throws IOException {
            FeedCursor r102 = r101.feed_cursor;
            if (r102 == null) goto L5;
            FeedCursor.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.count;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            SearchFilter r104 = r101.search_filter;
            if (r104 == null) goto L11;
            SearchFilter.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetDoubaoFeedListRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum SearchFilter extends Enum<SearchFilter> implements WireEnum {
        private static final /* synthetic */ SearchFilter[] $VALUES = null;
        public static final ProtoAdapter<SearchFilter> ADAPTER = null;
        public static final SearchFilter ALL = null;
        public static final SearchFilter CONTACT = null;
        public static final SearchFilter CONVERSATION = null;
        public static final SearchFilter GROUP = null;
        private final int value;

        static {
            SearchFilter r100 = new SearchFilter(AccountType.ALL, 0, 0);
            ALL = r100;
            SearchFilter r101 = new SearchFilter("CONVERSATION", 1, 1);
            CONVERSATION = r101;
            SearchFilter r102 = new SearchFilter("CONTACT", 2, 2);
            CONTACT = r102;
            SearchFilter r103 = new SearchFilter("GROUP", 3, 3);
            GROUP = r103;
            $VALUES = new SearchFilter[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(SearchFilter.class);
        }

        public static SearchFilter[] values() {
            return (SearchFilter[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SearchFilter fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return GROUP;
        L14:
            return CONTACT;
        L16:
            return CONVERSATION;
        L18:
            return ALL;
        }

        public static SearchFilter valueOf(String r100) {
            return (SearchFilter) a.a(SearchFilter.class, r100);
        }

        private SearchFilter(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_GetDoubaoFeedListRequest r100 = new ProtoAdapter_GetDoubaoFeedListRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_COUNT = 0;
        DEFAULT_SEARCH_FILTER = SearchFilter.ALL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.feed_cursor = this.feed_cursor;
        r100.count = this.count;
        r100.search_filter = this.search_filter;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetDoubaoFeedListRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetDoubaoFeedListRequest(FeedCursor r100, Integer r101, SearchFilter r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetDoubaoFeedListRequest(FeedCursor r100, Integer r101, SearchFilter r102, ByteString r103) {
        super(ADAPTER, r103);
        this.feed_cursor = r100;
        this.count = r101;
        this.search_filter = r102;
    }
}
