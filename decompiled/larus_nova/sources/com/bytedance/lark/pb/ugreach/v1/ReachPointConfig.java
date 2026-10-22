package com.bytedance.lark.pb.ugreach.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class ReachPointConfig extends Message<ReachPointConfig, Builder> {
    public static final ProtoAdapter<ReachPointConfig> ADAPTER = null;
    public static final Long DEFAULT_CACHE_PERIOD = null;
    public static final DataStrategy DEFAULT_DATA_STRATEGY = null;
    private static final long serialVersionUID = 0;
    public final Long cache_period;
    public final DataStrategy data_strategy;
    public final ReachPointRelation relation;

    public static final class Builder extends Message.Builder<ReachPointConfig, Builder> {
        public Long cache_period;
        public DataStrategy data_strategy;
        public ReachPointRelation relation;

        @Override // com.squareup.wire.Message.Builder
        public ReachPointConfig build() {
            return new ReachPointConfig(this.relation, this.data_strategy, this.cache_period, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cache_period(Long r100) {
            this.cache_period = r100;
            return this;
        }

        public Builder data_strategy(DataStrategy r100) {
            this.data_strategy = r100;
            return this;
        }

        public Builder relation(ReachPointRelation r100) {
            this.relation = r100;
            return this;
        }
    }

    public static final enum DataStrategy extends Enum<DataStrategy> implements WireEnum {
        private static final /* synthetic */ DataStrategy[] $VALUES = null;
        public static final ProtoAdapter<DataStrategy> ADAPTER = null;
        public static final DataStrategy REALTIME = null;
        public static final DataStrategy SUPPORT_CACHE = null;
        public static final DataStrategy UNKNOWN = null;
        private final int value;

        static {
            DataStrategy r100 = new DataStrategy("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            DataStrategy r101 = new DataStrategy("SUPPORT_CACHE", 1, 1);
            SUPPORT_CACHE = r101;
            DataStrategy r102 = new DataStrategy("REALTIME", 2, 2);
            REALTIME = r102;
            $VALUES = new DataStrategy[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(DataStrategy.class);
        }

        public static DataStrategy[] values() {
            return (DataStrategy[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static DataStrategy fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return REALTIME;
        L12:
            return SUPPORT_CACHE;
        L14:
            return UNKNOWN;
        }

        public static DataStrategy valueOf(String r100) {
            return (DataStrategy) a.a(DataStrategy.class, r100);
        }

        private DataStrategy(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_ReachPointConfig extends ProtoAdapter<ReachPointConfig> {
        public ProtoAdapter_ReachPointConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, ReachPointConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ReachPointConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.data_strategy = DataStrategy.UNKNOWN;
            r101.cache_period = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.relation = ReachPointRelation.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.data_strategy = DataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.cache_period = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(ReachPointConfig r100) {
            ReachPointRelation r101 = r100.relation;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ReachPointRelation.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            DataStrategy r104 = r100.data_strategy;
            if (r104 == null) goto L9;
            int r105 = DataStrategy.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.cache_period;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ ReachPointConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ReachPointConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ReachPointConfig r101) throws IOException {
            ReachPointRelation r102 = r101.relation;
            if (r102 == null) goto L5;
            ReachPointRelation.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            DataStrategy r103 = r101.data_strategy;
            if (r103 == null) goto L8;
            DataStrategy.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.cache_period;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ReachPointConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ReachPointConfig();
        DEFAULT_DATA_STRATEGY = DataStrategy.UNKNOWN;
        DEFAULT_CACHE_PERIOD = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.relation = this.relation;
        r100.data_strategy = this.data_strategy;
        r100.cache_period = this.cache_period;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ReachPointConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ReachPointConfig(ReachPointRelation r100, DataStrategy r101, Long r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ReachPointConfig(ReachPointRelation r100, DataStrategy r101, Long r102, ByteString r103) {
        super(ADAPTER, r103);
        this.relation = r100;
        this.data_strategy = r101;
        this.cache_period = r102;
    }
}
