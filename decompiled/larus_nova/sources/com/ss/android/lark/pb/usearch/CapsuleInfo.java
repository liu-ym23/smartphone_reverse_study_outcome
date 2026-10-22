package com.ss.android.lark.pb.usearch;

import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
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

/* JADX INFO: loaded from: classes37.dex */
public final class CapsuleInfo extends Message<CapsuleInfo, Builder> {
    public static final ProtoAdapter<CapsuleInfo> ADAPTER = null;
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final CapsuleType mcapsule_type;
    public final List<SearchResult> mfilter_entities;
    public final SearchAction msearch_action;
    public final String mtitle;

    public static final class Builder extends Message.Builder<CapsuleInfo, Builder> {
        public CapsuleType mcapsule_type;
        public List<SearchResult> mfilter_entities;
        public SearchAction msearch_action;
        public String mtitle;

        @Override // com.squareup.wire.Message.Builder
        public CapsuleInfo build() {
            return new CapsuleInfo(this.mcapsule_type, this.msearch_action, this.mtitle, this.mfilter_entities, super.buildUnknownFields());
        }

        public Builder() {
            this.mfilter_entities = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder capsule_type(CapsuleType r100) {
            this.mcapsule_type = r100;
            return this;
        }

        public Builder filter_entities(List<SearchResult> r100) {
            Internal.checkElementsNotNull(r100);
            this.mfilter_entities = r100;
            return this;
        }

        public Builder search_action(SearchAction r100) {
            this.msearch_action = r100;
            return this;
        }

        public Builder title(String r100) {
            this.mtitle = r100;
            return this;
        }
    }

    public static final enum CapsuleType extends Enum<CapsuleType> implements WireEnum {
        private static final /* synthetic */ CapsuleType[] $VALUES = null;
        public static final ProtoAdapter<CapsuleType> ADAPTER = null;
        public static final CapsuleType FILTER = null;
        public static final CapsuleType FILTER_VALUE = null;
        public static final CapsuleType TAB = null;
        public static final CapsuleType UNKNOWN = null;
        private final int value;

        static {
            CapsuleType r100 = new CapsuleType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            CapsuleType r101 = new CapsuleType("TAB", 1, 1);
            TAB = r101;
            CapsuleType r102 = new CapsuleType(LocalSubStickerItem.BEAUTY_TYPE_FILTER, 2, 2);
            FILTER = r102;
            CapsuleType r103 = new CapsuleType("FILTER_VALUE", 3, 3);
            FILTER_VALUE = r103;
            $VALUES = new CapsuleType[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(CapsuleType.class);
        }

        public static CapsuleType[] values() {
            return (CapsuleType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static CapsuleType fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return FILTER_VALUE;
        L14:
            return FILTER;
        L16:
            return TAB;
        L18:
            return UNKNOWN;
        }

        public static CapsuleType valueOf(String r100) {
            return (CapsuleType) a.a(CapsuleType.class, r100);
        }

        private CapsuleType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_CapsuleInfo extends ProtoAdapter<CapsuleInfo> {
        public ProtoAdapter_CapsuleInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, CapsuleInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CapsuleInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mtitle = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mcapsule_type = CapsuleType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.msearch_action = SearchAction.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mtitle = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mfilter_entities.add(SearchResult.ADAPTER.decode(r100));
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
        public int encodedSize2(CapsuleInfo r100) {
            CapsuleType r101 = r100.mcapsule_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = CapsuleType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            SearchAction r104 = r100.msearch_action;
            if (r104 == null) goto L9;
            int r105 = SearchAction.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mtitle;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            return ((r106 + r102) + SearchResult.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.mfilter_entities)) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CapsuleInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CapsuleInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CapsuleInfo r101) throws IOException {
            CapsuleType r102 = r101.mcapsule_type;
            if (r102 == null) goto L5;
            CapsuleType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            SearchAction r103 = r101.msearch_action;
            if (r103 == null) goto L8;
            SearchAction.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mtitle;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            SearchResult.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.mfilter_entities);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CapsuleInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CapsuleInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mcapsule_type = this.mcapsule_type;
        r100.msearch_action = this.msearch_action;
        r100.mtitle = this.mtitle;
        r100.mfilter_entities = Internal.copyOf("mfilter_entities", this.mfilter_entities);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CapsuleInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CapsuleInfo(CapsuleType r100, SearchAction r101, String r102, List<SearchResult> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public CapsuleInfo(CapsuleType r100, SearchAction r101, String r102, List<SearchResult> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mcapsule_type = r100;
        this.msearch_action = r101;
        this.mtitle = r102;
        this.mfilter_entities = Internal.immutableCopyOf("mfilter_entities", r103);
    }
}
