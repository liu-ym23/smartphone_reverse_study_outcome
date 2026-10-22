package com.ss.android.lark.pb.hongbao;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.HongbaoCover;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullHongbaoCoverListResponse extends Message<PullHongbaoCoverListResponse, Builder> {
    public static final ProtoAdapter<PullHongbaoCoverListResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Category> mcategory_list;
    public final Map<Long, CoverList> mcovers;
    public final List<HongbaoCover> mrecommend_covers;

    public static final class Builder extends Message.Builder<PullHongbaoCoverListResponse, Builder> {
        public List<Category> mcategory_list;
        public Map<Long, CoverList> mcovers;
        public List<HongbaoCover> mrecommend_covers;

        @Override // com.squareup.wire.Message.Builder
        public PullHongbaoCoverListResponse build() {
            return new PullHongbaoCoverListResponse(this.mcategory_list, this.mcovers, this.mrecommend_covers, super.buildUnknownFields());
        }

        public Builder() {
            this.mcategory_list = Internal.newMutableList();
            this.mcovers = Internal.newMutableMap();
            this.mrecommend_covers = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder category_list(List<Category> r100) {
            Internal.checkElementsNotNull(r100);
            this.mcategory_list = r100;
            return this;
        }

        public Builder covers(Map<Long, CoverList> r100) {
            Internal.checkElementsNotNull(r100);
            this.mcovers = r100;
            return this;
        }

        public Builder recommend_covers(List<HongbaoCover> r100) {
            Internal.checkElementsNotNull(r100);
            this.mrecommend_covers = r100;
            return this;
        }
    }

    public static final class Category extends Message<Category, Builder> {
        public static final ProtoAdapter<Category> ADAPTER = null;
        public static final Long DEFAULT_ID = null;
        public static final String DEFAULT_NAME = "";
        public static final Integer DEFAULT_ORDER = null;
        private static final long serialVersionUID = 0;
        public final Long mid;
        public final String mname;
        public final Integer morder;

        public static final class Builder extends Message.Builder<Category, Builder> {
            public Long mid;
            public String mname;
            public Integer morder;

            @Override // com.squareup.wire.Message.Builder
            public Category build() {
                return new Category(this.mid, this.mname, this.morder, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder id(Long r100) {
                this.mid = r100;
                return this;
            }

            public Builder name(String r100) {
                this.mname = r100;
                return this;
            }

            public Builder order(Integer r100) {
                this.morder = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Category extends ProtoAdapter<Category> {
            public ProtoAdapter_Category() {
                super(FieldEncoding.LENGTH_DELIMITED, Category.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Category decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mid = 0L;
                r101.mname = "";
                r101.morder = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.mid = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mname = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.morder = ProtoAdapter.INT32.decode(r100);
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
            public int encodedSize2(Category r100) {
                Long r101 = r100.mid;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mname;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Integer r107 = r100.morder;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ Category decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Category r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Category r101) throws IOException {
                Long r102 = r101.mid;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mname;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Integer r104 = r101.morder;
                if (r104 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Category r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Category();
            DEFAULT_ID = 0L;
            DEFAULT_ORDER = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mid = this.mid;
            r100.mname = this.mname;
            r100.morder = this.morder;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Category.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Category(Long r100, String r101, Integer r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Category(Long r100, String r101, Integer r102, ByteString r103) {
            super(ADAPTER, r103);
            this.mid = r100;
            this.mname = r101;
            this.morder = r102;
        }
    }

    public static final class CoverList extends Message<CoverList, Builder> {
        public static final ProtoAdapter<CoverList> ADAPTER = null;
        public static final Long DEFAULT_CATEGORY_ID = null;
        private static final long serialVersionUID = 0;
        public final Long mcategory_id;
        public final List<HongbaoCover> mcovers;

        public static final class Builder extends Message.Builder<CoverList, Builder> {
            public Long mcategory_id;
            public List<HongbaoCover> mcovers;

            @Override // com.squareup.wire.Message.Builder
            public CoverList build() {
                return new CoverList(this.mcategory_id, this.mcovers, super.buildUnknownFields());
            }

            public Builder() {
                this.mcovers = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder category_id(Long r100) {
                this.mcategory_id = r100;
                return this;
            }

            public Builder covers(List<HongbaoCover> r100) {
                Internal.checkElementsNotNull(r100);
                this.mcovers = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CoverList extends ProtoAdapter<CoverList> {
            public ProtoAdapter_CoverList() {
                super(FieldEncoding.LENGTH_DELIMITED, CoverList.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CoverList decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mcategory_id = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mcategory_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mcovers.add(HongbaoCover.ADAPTER.decode(r100));
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
            public int encodedSize2(CoverList r100) {
                Long r101 = r100.mcategory_id;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L7:
                return (r102 + HongbaoCover.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.mcovers)) + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CoverList decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CoverList r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CoverList r101) throws IOException {
                Long r102 = r101.mcategory_id;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                HongbaoCover.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.mcovers);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CoverList r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CoverList();
            DEFAULT_CATEGORY_ID = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mcategory_id = this.mcategory_id;
            r100.mcovers = Internal.copyOf("mcovers", this.mcovers);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CoverList.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public CoverList(Long r100, List<HongbaoCover> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public CoverList(Long r100, List<HongbaoCover> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mcategory_id = r100;
            this.mcovers = Internal.immutableCopyOf("mcovers", r101);
        }
    }

    public static final class ProtoAdapter_PullHongbaoCoverListResponse extends ProtoAdapter<PullHongbaoCoverListResponse> {
        private final ProtoAdapter<Map<Long, CoverList>> mcovers;

        public ProtoAdapter_PullHongbaoCoverListResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullHongbaoCoverListResponse.class);
            this.mcovers = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, CoverList.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullHongbaoCoverListResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mcategory_list.add(Category.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mcovers.putAll(this.mcovers.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mrecommend_covers.add(HongbaoCover.ADAPTER.decode(r100));
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
        public int encodedSize2(PullHongbaoCoverListResponse r100) {
            return ((Category.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mcategory_list) + this.mcovers.encodedSizeWithTag(2, r100.mcovers)) + HongbaoCover.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.mrecommend_covers)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullHongbaoCoverListResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullHongbaoCoverListResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullHongbaoCoverListResponse r101) throws IOException {
            Category.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mcategory_list);
            this.mcovers.encodeWithTag(r100, 2, r101.mcovers);
            HongbaoCover.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.mrecommend_covers);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullHongbaoCoverListResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullHongbaoCoverListResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mcategory_list = Internal.copyOf("mcategory_list", this.mcategory_list);
        r100.mcovers = Internal.copyOf("mcovers", this.mcovers);
        r100.mrecommend_covers = Internal.copyOf("mrecommend_covers", this.mrecommend_covers);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullHongbaoCoverListResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullHongbaoCoverListResponse(List<Category> r100, Map<Long, CoverList> r101, List<HongbaoCover> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PullHongbaoCoverListResponse(List<Category> r100, Map<Long, CoverList> r101, List<HongbaoCover> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mcategory_list = Internal.immutableCopyOf("mcategory_list", r100);
        this.mcovers = Internal.immutableCopyOf("mcovers", r101);
        this.mrecommend_covers = Internal.immutableCopyOf("mrecommend_covers", r102);
    }
}
