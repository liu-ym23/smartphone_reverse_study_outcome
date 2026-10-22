package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class BannerAction extends Message<BannerAction, Builder> {
    public static final ProtoAdapter<BannerAction> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DisableFilterOption mdisable_filter_option;
    public final HighlightFilter mhighlight_filter;
    public final NoAction mno_action;
    public final ReSearch mre_search;
    public final RouteTo mroute_to;
    public final SelectFilterOption mselect_filter_option;

    public static final class Builder extends Message.Builder<BannerAction, Builder> {
        public DisableFilterOption mdisable_filter_option;
        public HighlightFilter mhighlight_filter;
        public NoAction mno_action;
        public ReSearch mre_search;
        public RouteTo mroute_to;
        public SelectFilterOption mselect_filter_option;

        @Override // com.squareup.wire.Message.Builder
        public BannerAction build() {
            return new BannerAction(this.mno_action, this.mhighlight_filter, this.mselect_filter_option, this.mdisable_filter_option, this.mre_search, this.mroute_to, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder disable_filter_option(DisableFilterOption r100) {
            this.mdisable_filter_option = r100;
            this.mno_action = null;
            this.mhighlight_filter = null;
            this.mselect_filter_option = null;
            this.mre_search = null;
            this.mroute_to = null;
            return this;
        }

        public Builder highlight_filter(HighlightFilter r100) {
            this.mhighlight_filter = r100;
            this.mno_action = null;
            this.mselect_filter_option = null;
            this.mdisable_filter_option = null;
            this.mre_search = null;
            this.mroute_to = null;
            return this;
        }

        public Builder no_action(NoAction r100) {
            this.mno_action = r100;
            this.mhighlight_filter = null;
            this.mselect_filter_option = null;
            this.mdisable_filter_option = null;
            this.mre_search = null;
            this.mroute_to = null;
            return this;
        }

        public Builder re_search(ReSearch r100) {
            this.mre_search = r100;
            this.mno_action = null;
            this.mhighlight_filter = null;
            this.mselect_filter_option = null;
            this.mdisable_filter_option = null;
            this.mroute_to = null;
            return this;
        }

        public Builder route_to(RouteTo r100) {
            this.mroute_to = r100;
            this.mno_action = null;
            this.mhighlight_filter = null;
            this.mselect_filter_option = null;
            this.mdisable_filter_option = null;
            this.mre_search = null;
            return this;
        }

        public Builder select_filter_option(SelectFilterOption r100) {
            this.mselect_filter_option = r100;
            this.mno_action = null;
            this.mhighlight_filter = null;
            this.mdisable_filter_option = null;
            this.mre_search = null;
            this.mroute_to = null;
            return this;
        }
    }

    public static final class DisableFilterOption extends Message<DisableFilterOption, Builder> {
        public static final ProtoAdapter<DisableFilterOption> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final SearchActionFilter mfilter_option;

        public static final class Builder extends Message.Builder<DisableFilterOption, Builder> {
            public SearchActionFilter mfilter_option;

            @Override // com.squareup.wire.Message.Builder
            public DisableFilterOption build() {
                return new DisableFilterOption(this.mfilter_option, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder filter_option(SearchActionFilter r100) {
                this.mfilter_option = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DisableFilterOption extends ProtoAdapter<DisableFilterOption> {
            public ProtoAdapter_DisableFilterOption() {
                super(FieldEncoding.LENGTH_DELIMITED, DisableFilterOption.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DisableFilterOption decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mfilter_option = SearchActionFilter.ADAPTER.decode(r100);
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
            public int encodedSize2(DisableFilterOption r100) {
                SearchActionFilter r101 = r100.mfilter_option;
                if (r101 == null) goto L5;
                int r102 = SearchActionFilter.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DisableFilterOption decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DisableFilterOption r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DisableFilterOption r101) throws IOException {
                SearchActionFilter r102 = r101.mfilter_option;
                if (r102 == null) goto L5;
                SearchActionFilter.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DisableFilterOption r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DisableFilterOption();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mfilter_option = this.mfilter_option;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DisableFilterOption.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DisableFilterOption(SearchActionFilter r100) {
            this(r100, ByteString.EMPTY);
        }

        public DisableFilterOption(SearchActionFilter r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mfilter_option = r100;
        }
    }

    public static final class HighlightFilter extends Message<HighlightFilter, Builder> {
        public static final ProtoAdapter<HighlightFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final SearchActionFilter mfilter;

        public static final class Builder extends Message.Builder<HighlightFilter, Builder> {
            public SearchActionFilter mfilter;

            @Override // com.squareup.wire.Message.Builder
            public HighlightFilter build() {
                return new HighlightFilter(this.mfilter, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder filter(SearchActionFilter r100) {
                this.mfilter = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_HighlightFilter extends ProtoAdapter<HighlightFilter> {
            public ProtoAdapter_HighlightFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, HighlightFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public HighlightFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mfilter = SearchActionFilter.ADAPTER.decode(r100);
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
            public int encodedSize2(HighlightFilter r100) {
                SearchActionFilter r101 = r100.mfilter;
                if (r101 == null) goto L5;
                int r102 = SearchActionFilter.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ HighlightFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(HighlightFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, HighlightFilter r101) throws IOException {
                SearchActionFilter r102 = r101.mfilter;
                if (r102 == null) goto L5;
                SearchActionFilter.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HighlightFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_HighlightFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mfilter = this.mfilter;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return HighlightFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public HighlightFilter(SearchActionFilter r100) {
            this(r100, ByteString.EMPTY);
        }

        public HighlightFilter(SearchActionFilter r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mfilter = r100;
        }
    }

    public static final class NoAction extends Message<NoAction, Builder> {
        public static final ProtoAdapter<NoAction> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends Message.Builder<NoAction, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public NoAction build() {
                return new NoAction(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_NoAction extends ProtoAdapter<NoAction> {
            public ProtoAdapter_NoAction() {
                super(FieldEncoding.LENGTH_DELIMITED, NoAction.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public NoAction decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(NoAction r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ NoAction decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(NoAction r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, NoAction r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, NoAction r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_NoAction();
        }

        public NoAction() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return NoAction.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public NoAction(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class ProtoAdapter_BannerAction extends ProtoAdapter<BannerAction> {
        public ProtoAdapter_BannerAction() {
            super(FieldEncoding.LENGTH_DELIMITED, BannerAction.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BannerAction decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
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
            r101.route_to(RouteTo.ADAPTER.decode(r100));
            goto L3
        L8:
            r101.re_search(ReSearch.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.disable_filter_option(DisableFilterOption.ADAPTER.decode(r100));
            goto L3
        L10:
            r101.select_filter_option(SelectFilterOption.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.highlight_filter(HighlightFilter.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.no_action(NoAction.ADAPTER.decode(r100));
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
        public int encodedSize2(BannerAction r100) {
            NoAction r101 = r100.mno_action;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = NoAction.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            HighlightFilter r104 = r100.mhighlight_filter;
            if (r104 == null) goto L9;
            int r105 = HighlightFilter.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            SelectFilterOption r107 = r100.mselect_filter_option;
            if (r107 == null) goto L13;
            int r108 = SelectFilterOption.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            DisableFilterOption r110 = r100.mdisable_filter_option;
            if (r110 == null) goto L17;
            int r111 = DisableFilterOption.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            ReSearch r113 = r100.mre_search;
            if (r113 == null) goto L21;
            int r114 = ReSearch.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            RouteTo r116 = r100.mroute_to;
            if (r116 == null) goto L26;
            r102 = RouteTo.ADAPTER.encodedSizeWithTag(6, r116);
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
        public /* bridge */ /* synthetic */ BannerAction decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BannerAction r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BannerAction r101) throws IOException {
            NoAction r102 = r101.mno_action;
            if (r102 == null) goto L5;
            NoAction.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            HighlightFilter r103 = r101.mhighlight_filter;
            if (r103 == null) goto L8;
            HighlightFilter.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            SelectFilterOption r104 = r101.mselect_filter_option;
            if (r104 == null) goto L11;
            SelectFilterOption.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            DisableFilterOption r105 = r101.mdisable_filter_option;
            if (r105 == null) goto L14;
            DisableFilterOption.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            ReSearch r106 = r101.mre_search;
            if (r106 == null) goto L17;
            ReSearch.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            RouteTo r107 = r101.mroute_to;
            if (r107 == null) goto L20;
            RouteTo.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BannerAction r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class ReSearch extends Message<ReSearch, Builder> {
        public static final ProtoAdapter<ReSearch> ADAPTER = null;
        public static final String DEFAULT_QUERY = "";
        private static final long serialVersionUID = 0;
        public final List<SearchActionFilter> mfilters;
        public final String mquery;

        public static final class Builder extends Message.Builder<ReSearch, Builder> {
            public List<SearchActionFilter> mfilters;
            public String mquery;

            @Override // com.squareup.wire.Message.Builder
            public ReSearch build() {
                return new ReSearch(this.mquery, this.mfilters, super.buildUnknownFields());
            }

            public Builder() {
                this.mfilters = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder filters(List<SearchActionFilter> r100) {
                Internal.checkElementsNotNull(r100);
                this.mfilters = r100;
                return this;
            }

            public Builder query(String r100) {
                this.mquery = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ReSearch extends ProtoAdapter<ReSearch> {
            public ProtoAdapter_ReSearch() {
                super(FieldEncoding.LENGTH_DELIMITED, ReSearch.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ReSearch decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mquery = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mquery = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mfilters.add(SearchActionFilter.ADAPTER.decode(r100));
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
            public int encodedSize2(ReSearch r100) {
                String r101 = r100.mquery;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return (r102 + SearchActionFilter.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.mfilters)) + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ReSearch decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ReSearch r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ReSearch r101) throws IOException {
                String r102 = r101.mquery;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                SearchActionFilter.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.mfilters);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ReSearch r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ReSearch();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mquery = this.mquery;
            r100.mfilters = Internal.copyOf("mfilters", this.mfilters);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ReSearch.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ReSearch(String r100, List<SearchActionFilter> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public ReSearch(String r100, List<SearchActionFilter> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mquery = r100;
            this.mfilters = Internal.immutableCopyOf("mfilters", r101);
        }
    }

    public static final class RouteTo extends Message<RouteTo, Builder> {
        public static final ProtoAdapter<RouteTo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final ShellApi mshell_api;

        public static final class Builder extends Message.Builder<RouteTo, Builder> {
            public ShellApi mshell_api;

            @Override // com.squareup.wire.Message.Builder
            public RouteTo build() {
                return new RouteTo(this.mshell_api, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder shell_api(ShellApi r100) {
                this.mshell_api = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_RouteTo extends ProtoAdapter<RouteTo> {
            public ProtoAdapter_RouteTo() {
                super(FieldEncoding.LENGTH_DELIMITED, RouteTo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public RouteTo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mshell_api = ShellApi.ADAPTER.decode(r100);
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
            public int encodedSize2(RouteTo r100) {
                ShellApi r101 = r100.mshell_api;
                if (r101 == null) goto L5;
                int r102 = ShellApi.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ RouteTo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(RouteTo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, RouteTo r101) throws IOException {
                ShellApi r102 = r101.mshell_api;
                if (r102 == null) goto L5;
                ShellApi.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RouteTo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_RouteTo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mshell_api = this.mshell_api;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return RouteTo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public RouteTo(ShellApi r100) {
            this(r100, ByteString.EMPTY);
        }

        public RouteTo(ShellApi r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mshell_api = r100;
        }
    }

    public static final class SelectFilterOption extends Message<SelectFilterOption, Builder> {
        public static final ProtoAdapter<SelectFilterOption> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final SearchActionFilter mfilter_option;

        public static final class Builder extends Message.Builder<SelectFilterOption, Builder> {
            public SearchActionFilter mfilter_option;

            @Override // com.squareup.wire.Message.Builder
            public SelectFilterOption build() {
                return new SelectFilterOption(this.mfilter_option, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder filter_option(SearchActionFilter r100) {
                this.mfilter_option = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SelectFilterOption extends ProtoAdapter<SelectFilterOption> {
            public ProtoAdapter_SelectFilterOption() {
                super(FieldEncoding.LENGTH_DELIMITED, SelectFilterOption.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SelectFilterOption decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mfilter_option = SearchActionFilter.ADAPTER.decode(r100);
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
            public int encodedSize2(SelectFilterOption r100) {
                SearchActionFilter r101 = r100.mfilter_option;
                if (r101 == null) goto L5;
                int r102 = SearchActionFilter.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SelectFilterOption decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SelectFilterOption r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SelectFilterOption r101) throws IOException {
                SearchActionFilter r102 = r101.mfilter_option;
                if (r102 == null) goto L5;
                SearchActionFilter.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SelectFilterOption r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SelectFilterOption();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mfilter_option = this.mfilter_option;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SelectFilterOption.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SelectFilterOption(SearchActionFilter r100) {
            this(r100, ByteString.EMPTY);
        }

        public SelectFilterOption(SearchActionFilter r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mfilter_option = r100;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BannerAction();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mno_action = this.mno_action;
        r100.mhighlight_filter = this.mhighlight_filter;
        r100.mselect_filter_option = this.mselect_filter_option;
        r100.mdisable_filter_option = this.mdisable_filter_option;
        r100.mre_search = this.mre_search;
        r100.mroute_to = this.mroute_to;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BannerAction.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BannerAction(NoAction r100, HighlightFilter r110, SelectFilterOption r111, DisableFilterOption r112, ReSearch r113, RouteTo r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public BannerAction(NoAction r100, HighlightFilter r101, SelectFilterOption r102, DisableFilterOption r103, ReSearch r104, RouteTo r105, ByteString r106) {
        super(ADAPTER, r106);
        if (Internal.countNonNull(r100, r101, r102, r103, new Object[]{r104, r105}) > 1) goto L7;
        this.mno_action = r100;
        this.mhighlight_filter = r101;
        this.mselect_filter_option = r102;
        this.mdisable_filter_option = r103;
        this.mre_search = r104;
        this.mroute_to = r105;
        return;
    L7:
        throw new IllegalArgumentException("at most one of mno_action, mhighlight_filter, mselect_filter_option, mdisable_filter_option, mre_search, mroute_to may be non-null");
    }
}
