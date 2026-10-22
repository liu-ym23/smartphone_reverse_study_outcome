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
public final class BannerMeta extends Message<BannerMeta, Builder> {
    public static final ProtoAdapter<BannerMeta> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_TRACKING_KEY = "";
    private static final long serialVersionUID = 0;
    public final List<BannerElementArray> melements;
    public final HighlightTheFilter mhighlight_the_filter;
    public final String mid;
    public final SelectFilterOptions mselect_filter_options;
    public final BannerStyle mstyle;
    public final String mtracking_key;

    public static final class Builder extends Message.Builder<BannerMeta, Builder> {
        public List<BannerElementArray> melements;
        public HighlightTheFilter mhighlight_the_filter;
        public String mid;
        public SelectFilterOptions mselect_filter_options;
        public BannerStyle mstyle;
        public String mtracking_key;

        @Override // com.squareup.wire.Message.Builder
        public BannerMeta build() {
            String r100 = this.mid;
            if (r100 == null) goto L7;
            return new BannerMeta(this.mid, this.melements, this.mstyle, this.mtracking_key, this.mhighlight_the_filter, this.mselect_filter_options, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mid"});
        }

        public Builder() {
            this.melements = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder elements(List<BannerElementArray> r100) {
            Internal.checkElementsNotNull(r100);
            this.melements = r100;
            return this;
        }

        public Builder highlight_the_filter(HighlightTheFilter r100) {
            this.mhighlight_the_filter = r100;
            this.mselect_filter_options = null;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder select_filter_options(SelectFilterOptions r100) {
            this.mselect_filter_options = r100;
            this.mhighlight_the_filter = null;
            return this;
        }

        public Builder style(BannerStyle r100) {
            this.mstyle = r100;
            return this;
        }

        public Builder tracking_key(String r100) {
            this.mtracking_key = r100;
            return this;
        }
    }

    public static final class HighlightTheFilter extends Message<HighlightTheFilter, Builder> {
        public static final ProtoAdapter<HighlightTheFilter> ADAPTER = null;
        public static final String DEFAULT_HIGHTLIGHT_SUMMARY = "";
        public static final String DEFAULT_INTRO = "";
        private static final long serialVersionUID = 0;
        public final SearchActionFilter mfilter;
        public final String mhightlight_summary;
        public final String mintro;

        public static final class Builder extends Message.Builder<HighlightTheFilter, Builder> {
            public SearchActionFilter mfilter;
            public String mhightlight_summary;
            public String mintro;

            @Override // com.squareup.wire.Message.Builder
            public HighlightTheFilter build() {
                return new HighlightTheFilter(this.mintro, this.mhightlight_summary, this.mfilter, super.buildUnknownFields());
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

            public Builder hightlight_summary(String r100) {
                this.mhightlight_summary = r100;
                return this;
            }

            public Builder intro(String r100) {
                this.mintro = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_HighlightTheFilter extends ProtoAdapter<HighlightTheFilter> {
            public ProtoAdapter_HighlightTheFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, HighlightTheFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public HighlightTheFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mintro = "";
                r101.mhightlight_summary = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.mintro = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mhightlight_summary = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mfilter = SearchActionFilter.ADAPTER.decode(r100);
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
            public int encodedSize2(HighlightTheFilter r100) {
                String r101 = r100.mintro;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mhightlight_summary;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                SearchActionFilter r107 = r100.mfilter;
                if (r107 == null) goto L14;
                r102 = SearchActionFilter.ADAPTER.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ HighlightTheFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(HighlightTheFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, HighlightTheFilter r101) throws IOException {
                String r102 = r101.mintro;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mhightlight_summary;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                SearchActionFilter r104 = r101.mfilter;
                if (r104 == null) goto L11;
                SearchActionFilter.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HighlightTheFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_HighlightTheFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mintro = this.mintro;
            r100.mhightlight_summary = this.mhightlight_summary;
            r100.mfilter = this.mfilter;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return HighlightTheFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public HighlightTheFilter(String r100, String r101, SearchActionFilter r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public HighlightTheFilter(String r100, String r101, SearchActionFilter r102, ByteString r103) {
            super(ADAPTER, r103);
            this.mintro = r100;
            this.mhightlight_summary = r101;
            this.mfilter = r102;
        }
    }

    public static final class ProtoAdapter_BannerMeta extends ProtoAdapter<BannerMeta> {
        public ProtoAdapter_BannerMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, BannerMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BannerMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            r101.mtracking_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L18;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r101.mstyle = BannerStyle.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mtracking_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.melements.add(BannerElementArray.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.select_filter_options(SelectFilterOptions.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.highlight_the_filter(HighlightTheFilter.ADAPTER.decode(r100));
            goto L3
        L15:
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BannerMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.mid) + BannerElementArray.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.melements);
            BannerStyle r103 = r100.mstyle;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = BannerStyle.ADAPTER.encodedSizeWithTag(5, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.mtracking_key;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(6, r107);
        L10:
            int r109 = r106 + r108;
            HighlightTheFilter r110 = r100.mhighlight_the_filter;
            if (r110 == null) goto L13;
            int r111 = HighlightTheFilter.ADAPTER.encodedSizeWithTag(2, r110);
        L14:
            int r112 = r109 + r111;
            SelectFilterOptions r113 = r100.mselect_filter_options;
            if (r113 == null) goto L18;
            r104 = SelectFilterOptions.ADAPTER.encodedSizeWithTag(3, r113);
        L18:
            return (r112 + r104) + r100.unknownFields().size();
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BannerMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BannerMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BannerMeta r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mid);
            BannerElementArray.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.melements);
            BannerStyle r103 = r101.mstyle;
            if (r103 == null) goto L5;
            BannerStyle.ADAPTER.encodeWithTag(r100, 5, r103);
        L5:
            String r104 = r101.mtracking_key;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 6, r104);
        L8:
            HighlightTheFilter r105 = r101.mhighlight_the_filter;
            if (r105 == null) goto L11;
            HighlightTheFilter.ADAPTER.encodeWithTag(r100, 2, r105);
        L11:
            SelectFilterOptions r106 = r101.mselect_filter_options;
            if (r106 == null) goto L14;
            SelectFilterOptions.ADAPTER.encodeWithTag(r100, 3, r106);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BannerMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class SelectFilterOptions extends Message<SelectFilterOptions, Builder> {
        public static final ProtoAdapter<SelectFilterOptions> ADAPTER = null;
        public static final String DEFAULT_INTRO = "";
        private static final long serialVersionUID = 0;
        public final List<SearchActionFilter> mfilter_options;
        public final String mintro;

        public static final class Builder extends Message.Builder<SelectFilterOptions, Builder> {
            public List<SearchActionFilter> mfilter_options;
            public String mintro;

            @Override // com.squareup.wire.Message.Builder
            public SelectFilterOptions build() {
                return new SelectFilterOptions(this.mintro, this.mfilter_options, super.buildUnknownFields());
            }

            public Builder() {
                this.mfilter_options = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder filter_options(List<SearchActionFilter> r100) {
                Internal.checkElementsNotNull(r100);
                this.mfilter_options = r100;
                return this;
            }

            public Builder intro(String r100) {
                this.mintro = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SelectFilterOptions extends ProtoAdapter<SelectFilterOptions> {
            public ProtoAdapter_SelectFilterOptions() {
                super(FieldEncoding.LENGTH_DELIMITED, SelectFilterOptions.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SelectFilterOptions decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mintro = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mintro = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mfilter_options.add(SearchActionFilter.ADAPTER.decode(r100));
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
            public int encodedSize2(SelectFilterOptions r100) {
                String r101 = r100.mintro;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return (r102 + SearchActionFilter.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.mfilter_options)) + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SelectFilterOptions decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SelectFilterOptions r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SelectFilterOptions r101) throws IOException {
                String r102 = r101.mintro;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                SearchActionFilter.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.mfilter_options);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SelectFilterOptions r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SelectFilterOptions();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mintro = this.mintro;
            r100.mfilter_options = Internal.copyOf("mfilter_options", this.mfilter_options);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SelectFilterOptions.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SelectFilterOptions(String r100, List<SearchActionFilter> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public SelectFilterOptions(String r100, List<SearchActionFilter> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mintro = r100;
            this.mfilter_options = Internal.immutableCopyOf("mfilter_options", r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BannerMeta();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.melements = Internal.copyOf("melements", this.melements);
        r100.mstyle = this.mstyle;
        r100.mtracking_key = this.mtracking_key;
        r100.mhighlight_the_filter = this.mhighlight_the_filter;
        r100.mselect_filter_options = this.mselect_filter_options;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BannerMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BannerMeta(String r100, List<BannerElementArray> r110, BannerStyle r111, String r112, HighlightTheFilter r113, SelectFilterOptions r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public BannerMeta(String r100, List<BannerElementArray> r101, BannerStyle r102, String r103, HighlightTheFilter r104, SelectFilterOptions r105, ByteString r106) {
        super(ADAPTER, r106);
        if (Internal.countNonNull(r104, r105) > 1) goto L7;
        this.mid = r100;
        this.melements = Internal.immutableCopyOf("melements", r101);
        this.mstyle = r102;
        this.mtracking_key = r103;
        this.mhighlight_the_filter = r104;
        this.mselect_filter_options = r105;
        return;
    L7:
        throw new IllegalArgumentException("at most one of mhighlight_the_filter, mselect_filter_options may be non-null");
    }
}
