package com.bytedance.lark.pb.search.v2;

import com.bytedance.lark.pb.search.common.SearchTabName;
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
public final class SearchAction extends Message<SearchAction, Builder> {
    public static final ProtoAdapter<SearchAction> ADAPTER = null;
    public static final String DEFAULT_APP_ID = "";
    public static final Boolean DEFAULT_CAPSULE_RECOMMEND_ENABLE = null;
    public static final String DEFAULT_QUERY = "";
    public static final SearchTabName DEFAULT_TAB = null;
    private static final long serialVersionUID = 0;
    public final String app_id;
    public final Boolean capsule_recommend_enable;
    public final List<SearchActionFilter> filters;
    public final String query;

    /* JADX INFO: renamed from: tab, reason: collision with root package name */
    public final SearchTabName f253729tab;

    public static final class Builder extends Message.Builder<SearchAction, Builder> {
        public String app_id;
        public Boolean capsule_recommend_enable;
        public List<SearchActionFilter> filters;
        public String query;

        /* JADX INFO: renamed from: tab, reason: collision with root package name */
        public SearchTabName f253730tab;

        @Override // com.squareup.wire.Message.Builder
        public SearchAction build() {
            return new SearchAction(this.query, this.f253730tab, this.filters, this.app_id, this.capsule_recommend_enable, super.buildUnknownFields());
        }

        public Builder() {
            this.filters = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_id(String r100) {
            this.app_id = r100;
            return this;
        }

        public Builder capsule_recommend_enable(Boolean r100) {
            this.capsule_recommend_enable = r100;
            return this;
        }

        public Builder filters(List<SearchActionFilter> r100) {
            Internal.checkElementsNotNull(r100);
            this.filters = r100;
            return this;
        }

        public Builder query(String r100) {
            this.query = r100;
            return this;
        }

        public Builder tab(SearchTabName r100) {
            this.f253730tab = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchAction extends ProtoAdapter<SearchAction> {
        public ProtoAdapter_SearchAction() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchAction.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchAction decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.query = "";
            r101.f253730tab = SearchTabName.UNKNOWN_TAB;
            r101.app_id = "";
            r101.capsule_recommend_enable = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.query = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.f253730tab = SearchTabName.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.filters.add(SearchActionFilter.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.app_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.capsule_recommend_enable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SearchAction r100) {
            String r101 = r100.query;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            SearchTabName r104 = r100.f253729tab;
            if (r104 == null) goto L9;
            int r105 = SearchTabName.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = (r103 + r105) + SearchActionFilter.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.filters);
            String r107 = r100.app_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(4, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.capsule_recommend_enable;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ SearchAction decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchAction r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchAction r101) throws IOException {
            String r102 = r101.query;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            SearchTabName r103 = r101.f253729tab;
            if (r103 == null) goto L8;
            SearchTabName.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            SearchActionFilter.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.filters);
            String r104 = r101.app_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
        L11:
            Boolean r105 = r101.capsule_recommend_enable;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchAction r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchAction();
        DEFAULT_TAB = SearchTabName.UNKNOWN_TAB;
        DEFAULT_CAPSULE_RECOMMEND_ENABLE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.query = this.query;
        r100.f253730tab = this.f253729tab;
        r100.filters = Internal.copyOf("filters", this.filters);
        r100.app_id = this.app_id;
        r100.capsule_recommend_enable = this.capsule_recommend_enable;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchAction.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchAction(String r100, SearchTabName r101, List<SearchActionFilter> r110, String r111, Boolean r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public SearchAction(String r100, SearchTabName r101, List<SearchActionFilter> r102, String r103, Boolean r104, ByteString r105) {
        super(ADAPTER, r105);
        this.query = r100;
        this.f253729tab = r101;
        this.filters = Internal.immutableCopyOf("filters", r102);
        this.app_id = r103;
        this.capsule_recommend_enable = r104;
    }
}
