package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class TriggerDataCleanRequest extends com.squareup.wire.Message<TriggerDataCleanRequest, Builder> {
    public static final ProtoAdapter<TriggerDataCleanRequest> ADAPTER = null;
    public static final CleanType DEFAULT_CLEAN_TYPE = null;
    public static final Integer DEFAULT_EXEC_TIME_LIMIT = null;
    public static final Integer DEFAULT_TIME_LIMIT = null;
    public static final ProtoAdapter_TriggerDataCleanRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final CleanType clean_type;
    public final Integer exec_time_limit;
    public final Integer time_limit;

    public static final class Builder extends com.squareup.wire.Message.Builder<TriggerDataCleanRequest, Builder> implements d<TriggerDataCleanRequest> {
        public CleanType clean_type;
        public Integer exec_time_limit;
        public Integer time_limit;

        @Override // com.squareup.wire.Message.Builder
        public TriggerDataCleanRequest build() {
            return new TriggerDataCleanRequest(this.time_limit, this.exec_time_limit, this.clean_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder clean_type(CleanType r100) {
            this.clean_type = r100;
            return this;
        }

        public Builder exec_time_limit(Integer r100) {
            this.exec_time_limit = r100;
            return this;
        }

        public Builder time_limit(Integer r100) {
            this.time_limit = r100;
            return this;
        }
    }

    public static final enum CleanType extends Enum<CleanType> implements WireEnum {
        private static final /* synthetic */ CleanType[] $VALUES = null;
        public static final ProtoAdapter<CleanType> ADAPTER = null;
        public static final CleanType AUTO = null;
        public static final CleanType USER = null;
        private final int value;

        static {
            CleanType r100 = new CleanType("AUTO", 0, 1);
            AUTO = r100;
            CleanType r101 = new CleanType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 2);
            USER = r101;
            $VALUES = new CleanType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(CleanType.class);
        }

        public static CleanType[] values() {
            return (CleanType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static CleanType fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return USER;
        L11:
            return AUTO;
        }

        public static CleanType valueOf(String r100) {
            return (CleanType) a.a(CleanType.class, r100);
        }

        private CleanType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_TriggerDataCleanRequest extends ProtoAdapter<TriggerDataCleanRequest> implements c<TriggerDataCleanRequest> {
        public ProtoAdapter_TriggerDataCleanRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, TriggerDataCleanRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TriggerDataCleanRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.time_limit = 0;
            r101.exec_time_limit = 30;
            r101.clean_type = CleanType.AUTO;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.time_limit = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.exec_time_limit = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.clean_type = CleanType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        public int encodedSize2(TriggerDataCleanRequest r100) {
            Integer r101 = r100.time_limit;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.exec_time_limit;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            CleanType r107 = r100.clean_type;
            if (r107 == null) goto L14;
            r102 = CleanType.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ TriggerDataCleanRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TriggerDataCleanRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TriggerDataCleanRequest r101) throws IOException {
            Integer r102 = r101.time_limit;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.exec_time_limit;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            CleanType r104 = r101.clean_type;
            if (r104 == null) goto L11;
            CleanType.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TriggerDataCleanRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_TriggerDataCleanRequest r100 = new ProtoAdapter_TriggerDataCleanRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TIME_LIMIT = 0;
        DEFAULT_EXEC_TIME_LIMIT = 30;
        DEFAULT_CLEAN_TYPE = CleanType.AUTO;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.time_limit = this.time_limit;
        r100.exec_time_limit = this.exec_time_limit;
        r100.clean_type = this.clean_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TriggerDataCleanRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TriggerDataCleanRequest(Integer r100, Integer r101, CleanType r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public TriggerDataCleanRequest(Integer r100, Integer r101, CleanType r102, ByteString r103) {
        super(ADAPTER, r103);
        this.time_limit = r100;
        this.exec_time_limit = r101;
        this.clean_type = r102;
    }
}
