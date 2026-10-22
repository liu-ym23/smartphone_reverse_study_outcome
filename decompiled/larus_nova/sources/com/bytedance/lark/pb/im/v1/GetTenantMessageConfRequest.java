package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
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
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetTenantMessageConfRequest extends Message<GetTenantMessageConfRequest, Builder> {
    public static final ProtoAdapter<GetTenantMessageConfRequest> ADAPTER = null;
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final ProtoAdapter_GetTenantMessageConfRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<ConfType> conf_types;
    public final SyncDataStrategy sync_data_strategy;

    public static final class Builder extends Message.Builder<GetTenantMessageConfRequest, Builder> implements d<GetTenantMessageConfRequest> {
        public List<ConfType> conf_types;
        public SyncDataStrategy sync_data_strategy;

        @Override // com.squareup.wire.Message.Builder
        public GetTenantMessageConfRequest build() {
            return new GetTenantMessageConfRequest(this.conf_types, this.sync_data_strategy, super.buildUnknownFields());
        }

        public Builder() {
            this.conf_types = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder conf_types(List<ConfType> r100) {
            Internal.checkElementsNotNull(r100);
            this.conf_types = r100;
            return this;
        }

        public Builder sync_data_strategy(SyncDataStrategy r100) {
            this.sync_data_strategy = r100;
            return this;
        }
    }

    public static final enum ConfType extends Enum<ConfType> implements WireEnum {
        private static final /* synthetic */ ConfType[] $VALUES = null;
        public static final ProtoAdapter<ConfType> ADAPTER = null;
        public static final ConfType EditEffectiveTime = null;
        public static final ConfType InputBoxPlaceholder = null;
        public static final ConfType IsSupportRestrictMessage = null;
        public static final ConfType RecallEffectiveTime = null;
        public static final ConfType UNKNOWN = null;
        private final int value;

        static {
            ConfType r100 = new ConfType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ConfType r101 = new ConfType("RecallEffectiveTime", 1, 1);
            RecallEffectiveTime = r101;
            ConfType r102 = new ConfType("EditEffectiveTime", 2, 2);
            EditEffectiveTime = r102;
            ConfType r103 = new ConfType("InputBoxPlaceholder", 3, 3);
            InputBoxPlaceholder = r103;
            ConfType r104 = new ConfType("IsSupportRestrictMessage", 4, 4);
            IsSupportRestrictMessage = r104;
            $VALUES = new ConfType[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(ConfType.class);
        }

        public static ConfType[] values() {
            return (ConfType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ConfType fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return IsSupportRestrictMessage;
        L16:
            return InputBoxPlaceholder;
        L18:
            return EditEffectiveTime;
        L20:
            return RecallEffectiveTime;
        L22:
            return UNKNOWN;
        }

        public static ConfType valueOf(String r100) {
            return (ConfType) a.a(ConfType.class, r100);
        }

        private ConfType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_GetTenantMessageConfRequest extends ProtoAdapter<GetTenantMessageConfRequest> implements c<GetTenantMessageConfRequest> {
        public ProtoAdapter_GetTenantMessageConfRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTenantMessageConfRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetTenantMessageConfRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.sync_data_strategy = SyncDataStrategy.TRY_LOCAL;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.conf_types.add(ConfType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.sync_data_strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetTenantMessageConfRequest r100) {
            int r101 = ConfType.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.conf_types);
            SyncDataStrategy r102 = r100.sync_data_strategy;
            if (r102 == null) goto L5;
            int r103 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTenantMessageConfRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetTenantMessageConfRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetTenantMessageConfRequest r101) throws IOException {
            ConfType.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.conf_types);
            SyncDataStrategy r102 = r101.sync_data_strategy;
            if (r102 == null) goto L5;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetTenantMessageConfRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetTenantMessageConfRequest r100 = new ProtoAdapter_GetTenantMessageConfRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.TRY_LOCAL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.conf_types = Internal.copyOf("conf_types", this.conf_types);
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetTenantMessageConfRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetTenantMessageConfRequest(List<ConfType> r100, SyncDataStrategy r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetTenantMessageConfRequest(List<ConfType> r100, SyncDataStrategy r101, ByteString r102) {
        super(ADAPTER, r102);
        this.conf_types = Internal.immutableCopyOf("conf_types", r100);
        this.sync_data_strategy = r101;
    }
}
