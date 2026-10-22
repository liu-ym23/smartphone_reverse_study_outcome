package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class AdvGrammarSelectorResult extends Message<AdvGrammarSelectorResult, Builder> {
    public static final ProtoAdapter<AdvGrammarSelectorResult> ADAPTER = null;
    public static final Integer DEFAULT_END_INDEX = null;
    public static final Integer DEFAULT_START_INDEX = null;
    private static final long serialVersionUID = 0;
    public final Integer mend_index;
    public final SearchResult mresult_meta;
    public final AdvGrammarConf.SelectorType mselectorType;
    public final Integer mstart_index;

    public static final class Builder extends Message.Builder<AdvGrammarSelectorResult, Builder> {
        public Integer mend_index;
        public SearchResult mresult_meta;
        public AdvGrammarConf.SelectorType mselectorType;
        public Integer mstart_index;

        @Override // com.squareup.wire.Message.Builder
        public AdvGrammarSelectorResult build() {
            return new AdvGrammarSelectorResult(this.mstart_index, this.mend_index, this.mresult_meta, this.mselectorType, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder end_index(Integer r100) {
            this.mend_index = r100;
            return this;
        }

        public Builder result_meta(SearchResult r100) {
            this.mresult_meta = r100;
            return this;
        }

        public Builder selectorType(AdvGrammarConf.SelectorType r100) {
            this.mselectorType = r100;
            return this;
        }

        public Builder start_index(Integer r100) {
            this.mstart_index = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AdvGrammarSelectorResult extends ProtoAdapter<AdvGrammarSelectorResult> {
        public ProtoAdapter_AdvGrammarSelectorResult() {
            super(FieldEncoding.LENGTH_DELIMITED, AdvGrammarSelectorResult.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AdvGrammarSelectorResult decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mstart_index = 0;
            r101.mend_index = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mstart_index = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mend_index = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mresult_meta = SearchResult.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mselectorType = AdvGrammarConf.SelectorType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        public int encodedSize2(AdvGrammarSelectorResult r100) {
            Integer r101 = r100.mstart_index;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.mend_index;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            SearchResult r107 = r100.mresult_meta;
            if (r107 == null) goto L13;
            int r108 = SearchResult.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            AdvGrammarConf.SelectorType r110 = r100.mselectorType;
            if (r110 == null) goto L18;
            r102 = AdvGrammarConf.SelectorType.ADAPTER.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ AdvGrammarSelectorResult decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AdvGrammarSelectorResult r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AdvGrammarSelectorResult r101) throws IOException {
            Integer r102 = r101.mstart_index;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.mend_index;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            SearchResult r104 = r101.mresult_meta;
            if (r104 == null) goto L11;
            SearchResult.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            AdvGrammarConf.SelectorType r105 = r101.mselectorType;
            if (r105 == null) goto L14;
            AdvGrammarConf.SelectorType.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AdvGrammarSelectorResult r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AdvGrammarSelectorResult();
        DEFAULT_START_INDEX = 0;
        DEFAULT_END_INDEX = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mstart_index = this.mstart_index;
        r100.mend_index = this.mend_index;
        r100.mresult_meta = this.mresult_meta;
        r100.mselectorType = this.mselectorType;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AdvGrammarSelectorResult.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AdvGrammarSelectorResult(Integer r100, Integer r101, SearchResult r102, AdvGrammarConf.SelectorType r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public AdvGrammarSelectorResult(Integer r100, Integer r101, SearchResult r102, AdvGrammarConf.SelectorType r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mstart_index = r100;
        this.mend_index = r101;
        this.mresult_meta = r102;
        this.mselectorType = r103;
    }
}
