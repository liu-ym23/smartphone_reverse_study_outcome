package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SearchResponseExtras extends Message<SearchResponseExtras, Builder> {
    public static final ProtoAdapter<SearchResponseExtras> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ResultSummary result_summary;

    public static final class Builder extends Message.Builder<SearchResponseExtras, Builder> {
        public ResultSummary result_summary;

        @Override // com.squareup.wire.Message.Builder
        public SearchResponseExtras build() {
            return new SearchResponseExtras(this.result_summary, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder result_summary(ResultSummary r100) {
            this.result_summary = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchResponseExtras extends ProtoAdapter<SearchResponseExtras> {
        public ProtoAdapter_SearchResponseExtras() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchResponseExtras.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchResponseExtras decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.result_summary = ResultSummary.ADAPTER.decode(r100);
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
        public int encodedSize2(SearchResponseExtras r100) {
            ResultSummary r101 = r100.result_summary;
            if (r101 == null) goto L5;
            int r102 = ResultSummary.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SearchResponseExtras decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchResponseExtras r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchResponseExtras r101) throws IOException {
            ResultSummary r102 = r101.result_summary;
            if (r102 == null) goto L5;
            ResultSummary.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchResponseExtras r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class ResultSummary extends Message<ResultSummary, Builder> {
        public static final ProtoAdapter<ResultSummary> ADAPTER = null;
        public static final String DEFAULT_ERR_MSG = "";
        public static final Boolean DEFAULT_HAVE_ERR = null;
        public static final Integer DEFAULT_RECALL_NUMS = null;
        public static final SearchEntityType DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final String err_msg;
        public final Boolean have_err;
        public final Integer recall_nums;
        public final SearchEntityType type;

        public static final class Builder extends Message.Builder<ResultSummary, Builder> {
            public String err_msg;
            public Boolean have_err;
            public Integer recall_nums;
            public SearchEntityType type;

            @Override // com.squareup.wire.Message.Builder
            public ResultSummary build() {
                SearchEntityType r100 = this.type;
                if (r100 == null) goto L9;
                if (this.have_err == null) goto L9;
                return new ResultSummary(this.type, this.recall_nums, this.have_err, this.err_msg, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "type", this.have_err, "have_err"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder err_msg(String r100) {
                this.err_msg = r100;
                return this;
            }

            public Builder have_err(Boolean r100) {
                this.have_err = r100;
                return this;
            }

            public Builder recall_nums(Integer r100) {
                this.recall_nums = r100;
                return this;
            }

            public Builder type(SearchEntityType r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ResultSummary extends ProtoAdapter<ResultSummary> {
            public ProtoAdapter_ResultSummary() {
                super(FieldEncoding.LENGTH_DELIMITED, ResultSummary.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ResultSummary decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = SearchEntityType.UNKNOWN;
                r101.recall_nums = 0;
                r101.have_err = Boolean.FALSE;
                r101.err_msg = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.type = SearchEntityType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.recall_nums = ProtoAdapter.INT32.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.have_err = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.err_msg = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ResultSummary r100) {
                int r101 = SearchEntityType.ADAPTER.encodedSizeWithTag(1, r100.type);
                Integer r102 = r100.recall_nums;
                int r103 = 0;
                if (r102 == null) goto L5;
                int r104 = ProtoAdapter.INT32.encodedSizeWithTag(2, r102);
            L6:
                int r105 = (r101 + r104) + ProtoAdapter.BOOL.encodedSizeWithTag(3, r100.have_err);
                String r106 = r100.err_msg;
                if (r106 == null) goto L10;
                r103 = ProtoAdapter.STRING.encodedSizeWithTag(4, r106);
            L10:
                return (r105 + r103) + r100.unknownFields().size();
            L5:
                r104 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ResultSummary decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ResultSummary r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ResultSummary r101) throws IOException {
                SearchEntityType.ADAPTER.encodeWithTag(r100, 1, r101.type);
                Integer r102 = r101.recall_nums;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r102);
            L5:
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r101.have_err);
                String r103 = r101.err_msg;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ResultSummary r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ResultSummary();
            DEFAULT_TYPE = SearchEntityType.UNKNOWN;
            DEFAULT_RECALL_NUMS = 0;
            DEFAULT_HAVE_ERR = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.recall_nums = this.recall_nums;
            r100.have_err = this.have_err;
            r100.err_msg = this.err_msg;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ResultSummary.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ResultSummary(SearchEntityType r100, Integer r101, Boolean r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public ResultSummary(SearchEntityType r100, Integer r101, Boolean r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.type = r100;
            this.recall_nums = r101;
            this.have_err = r102;
            this.err_msg = r103;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchResponseExtras();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.result_summary = this.result_summary;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchResponseExtras.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchResponseExtras(ResultSummary r100) {
        this(r100, ByteString.EMPTY);
    }

    public SearchResponseExtras(ResultSummary r100, ByteString r101) {
        super(ADAPTER, r101);
        this.result_summary = r100;
    }
}
