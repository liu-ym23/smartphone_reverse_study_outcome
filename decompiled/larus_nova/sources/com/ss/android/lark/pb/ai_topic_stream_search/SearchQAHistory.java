package com.ss.android.lark.pb.ai_topic_stream_search;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class SearchQAHistory extends Message<SearchQAHistory, Builder> {
    public static final ProtoAdapter<SearchQAHistory> ADAPTER = null;
    public static final String DEFAULT_ANSWER = "";
    public static final String DEFAULT_APP_LINK = "";
    public static final String DEFAULT_CACHE_KEY = "";
    public static final String DEFAULT_EXPIRE_TIME = "";
    public static final String DEFAULT_QUERY = "";
    private static final long serialVersionUID = 0;
    public final String manswer;
    public final String mapp_link;
    public final String mcache_key;
    public final String mexpire_time;
    public final String mquery;
    public final TopicInfo mtopic_info;

    public static final class Builder extends Message.Builder<SearchQAHistory, Builder> {
        public String manswer;
        public String mapp_link;
        public String mcache_key;
        public String mexpire_time;
        public String mquery;
        public TopicInfo mtopic_info;

        @Override // com.squareup.wire.Message.Builder
        public SearchQAHistory build() {
            return new SearchQAHistory(this.mapp_link, this.mquery, this.manswer, this.mexpire_time, this.mcache_key, this.mtopic_info, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder answer(String r100) {
            this.manswer = r100;
            return this;
        }

        public Builder app_link(String r100) {
            this.mapp_link = r100;
            return this;
        }

        public Builder cache_key(String r100) {
            this.mcache_key = r100;
            return this;
        }

        public Builder expire_time(String r100) {
            this.mexpire_time = r100;
            return this;
        }

        public Builder query(String r100) {
            this.mquery = r100;
            return this;
        }

        public Builder topic_info(TopicInfo r100) {
            this.mtopic_info = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchQAHistory extends ProtoAdapter<SearchQAHistory> {
        public ProtoAdapter_SearchQAHistory() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchQAHistory.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchQAHistory decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mapp_link = "";
            r101.mquery = "";
            r101.manswer = "";
            r101.mexpire_time = "";
            r101.mcache_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.mtopic_info = TopicInfo.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.mcache_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.mexpire_time = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.manswer = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.mquery = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.mapp_link = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SearchQAHistory r100) {
            String r101 = r100.mapp_link;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mquery;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.manswer;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mexpire_time;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.mcache_key;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            TopicInfo r116 = r100.mtopic_info;
            if (r116 == null) goto L26;
            r102 = TopicInfo.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SearchQAHistory decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchQAHistory r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchQAHistory r101) throws IOException {
            String r102 = r101.mapp_link;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mquery;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.manswer;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mexpire_time;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.mcache_key;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            TopicInfo r107 = r101.mtopic_info;
            if (r107 == null) goto L20;
            TopicInfo.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchQAHistory r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchQAHistory();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mapp_link = this.mapp_link;
        r100.mquery = this.mquery;
        r100.manswer = this.manswer;
        r100.mexpire_time = this.mexpire_time;
        r100.mcache_key = this.mcache_key;
        r100.mtopic_info = this.mtopic_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchQAHistory.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchQAHistory(String r100, String r110, String r111, String r112, String r113, TopicInfo r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public SearchQAHistory(String r100, String r101, String r102, String r103, String r104, TopicInfo r105, ByteString r106) {
        super(ADAPTER, r106);
        this.mapp_link = r100;
        this.mquery = r101;
        this.manswer = r102;
        this.mexpire_time = r103;
        this.mcache_key = r104;
        this.mtopic_info = r105;
    }
}
