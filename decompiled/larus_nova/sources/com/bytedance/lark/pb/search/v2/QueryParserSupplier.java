package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class QueryParserSupplier extends Message<QueryParserSupplier, Builder> {
    public static final ProtoAdapter<QueryParserSupplier> ADAPTER = null;
    public static final QueryParseInfo DEFAULT_SCENE = null;
    private static final long serialVersionUID = 0;
    public final List<String> query;
    public final QueryParseInfo scene;
    public final List<SearchEntityType> type;

    public static final class Builder extends Message.Builder<QueryParserSupplier, Builder> {
        public List<String> query;
        public QueryParseInfo scene;
        public List<SearchEntityType> type;

        @Override // com.squareup.wire.Message.Builder
        public QueryParserSupplier build() {
            QueryParseInfo r100 = this.scene;
            if (r100 == null) goto L7;
            return new QueryParserSupplier(this.scene, this.query, this.type, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "scene"});
        }

        public Builder() {
            this.query = Internal.newMutableList();
            this.type = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder query(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.query = r100;
            return this;
        }

        public Builder scene(QueryParseInfo r100) {
            this.scene = r100;
            return this;
        }

        public Builder type(List<SearchEntityType> r100) {
            Internal.checkElementsNotNull(r100);
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_QueryParserSupplier extends ProtoAdapter<QueryParserSupplier> {
        public ProtoAdapter_QueryParserSupplier() {
            super(FieldEncoding.LENGTH_DELIMITED, QueryParserSupplier.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public QueryParserSupplier decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.scene = QueryParseInfo.PINYIN_TO_CHINESE_NAME;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.scene = QueryParseInfo.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.query.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.type.add(SearchEntityType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(QueryParserSupplier r100) {
            return ((QueryParseInfo.ADAPTER.encodedSizeWithTag(1, r100.scene) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.query)) + SearchEntityType.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ QueryParserSupplier decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(QueryParserSupplier r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, QueryParserSupplier r101) throws IOException {
            QueryParseInfo.ADAPTER.encodeWithTag(r100, 1, r101.scene);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.query);
            SearchEntityType.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, QueryParserSupplier r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum QueryParseInfo extends Enum<QueryParseInfo> implements WireEnum {
        private static final /* synthetic */ QueryParseInfo[] $VALUES = null;
        public static final ProtoAdapter<QueryParseInfo> ADAPTER = null;
        public static final QueryParseInfo PINYIN_TO_CHINESE_NAME = null;
        private final int value;

        static {
            QueryParseInfo r100 = new QueryParseInfo("PINYIN_TO_CHINESE_NAME", 0, 1);
            PINYIN_TO_CHINESE_NAME = r100;
            $VALUES = new QueryParseInfo[]{r100};
            ADAPTER = ProtoAdapter.newEnumAdapter(QueryParseInfo.class);
        }

        public static QueryParseInfo[] values() {
            return (QueryParseInfo[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static QueryParseInfo fromValue(int r100) {
            if (r100 == 1) goto L7;
            return null;
        L7:
            return PINYIN_TO_CHINESE_NAME;
        }

        public static QueryParseInfo valueOf(String r100) {
            return (QueryParseInfo) a.a(QueryParseInfo.class, r100);
        }

        private QueryParseInfo(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_QueryParserSupplier();
        DEFAULT_SCENE = QueryParseInfo.PINYIN_TO_CHINESE_NAME;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.scene = this.scene;
        r100.query = Internal.copyOf("query", this.query);
        r100.type = Internal.copyOf("type", this.type);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return QueryParserSupplier.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public QueryParserSupplier(QueryParseInfo r100, List<String> r101, List<SearchEntityType> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public QueryParserSupplier(QueryParseInfo r100, List<String> r101, List<SearchEntityType> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.scene = r100;
        this.query = Internal.immutableCopyOf("query", r101);
        this.type = Internal.immutableCopyOf("type", r102);
    }
}
