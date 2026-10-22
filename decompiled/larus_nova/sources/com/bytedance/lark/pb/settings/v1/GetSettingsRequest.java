package com.bytedance.lark.pb.settings.v1;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
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
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class GetSettingsRequest extends Message<GetSettingsRequest, Builder> {
    public static final ProtoAdapter<GetSettingsRequest> ADAPTER = null;
    public static final ConfigPriority DEFAULT_CONFIG_PRIORITY = null;
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final ProtoAdapter_GetSettingsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ConfigPriority config_priority;
    public final List<String> fields;
    public final SyncDataStrategy sync_data_strategy;

    public static final class Builder extends Message.Builder<GetSettingsRequest, Builder> implements b<GetSettingsRequest> {
        public ConfigPriority config_priority;
        public List<String> fields;
        public SyncDataStrategy sync_data_strategy;

        @Override // com.squareup.wire.Message.Builder
        public GetSettingsRequest build() {
            return new GetSettingsRequest(this.fields, this.sync_data_strategy, this.config_priority, super.buildUnknownFields());
        }

        public Builder() {
            this.fields = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder config_priority(ConfigPriority r100) {
            this.config_priority = r100;
            return this;
        }

        public Builder fields(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.fields = r100;
            return this;
        }

        public Builder sync_data_strategy(SyncDataStrategy r100) {
            this.sync_data_strategy = r100;
            return this;
        }
    }

    public static final enum ConfigPriority extends Enum<ConfigPriority> implements WireEnum {
        private static final /* synthetic */ ConfigPriority[] $VALUES = null;
        public static final ProtoAdapter<ConfigPriority> ADAPTER = null;
        public static final ConfigPriority LIBRA_FIRST = null;
        public static final ConfigPriority SETTINGS_ONLY = null;
        private final int value;

        static {
            ConfigPriority r100 = new ConfigPriority("SETTINGS_ONLY", 0, 0);
            SETTINGS_ONLY = r100;
            ConfigPriority r101 = new ConfigPriority("LIBRA_FIRST", 1, 1);
            LIBRA_FIRST = r101;
            $VALUES = new ConfigPriority[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(ConfigPriority.class);
        }

        public static ConfigPriority[] values() {
            return (ConfigPriority[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ConfigPriority fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return LIBRA_FIRST;
        L10:
            return SETTINGS_ONLY;
        }

        public static ConfigPriority valueOf(String r100) {
            return (ConfigPriority) a.a(ConfigPriority.class, r100);
        }

        private ConfigPriority(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_GetSettingsRequest extends ProtoAdapter<GetSettingsRequest> implements we6.a<GetSettingsRequest> {
        public ProtoAdapter_GetSettingsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSettingsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetSettingsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.sync_data_strategy = SyncDataStrategy.LOCAL;
            r101.config_priority = ConfigPriority.SETTINGS_ONLY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.fields.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.sync_data_strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.config_priority = ConfigPriority.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
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
        public int encodedSize2(GetSettingsRequest r100) {
            int r101 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.fields);
            SyncDataStrategy r102 = r100.sync_data_strategy;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            ConfigPriority r106 = r100.config_priority;
            if (r106 == null) goto L10;
            r103 = ConfigPriority.ADAPTER.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetSettingsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetSettingsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetSettingsRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.fields);
            SyncDataStrategy r102 = r101.sync_data_strategy;
            if (r102 == null) goto L5;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            ConfigPriority r103 = r101.config_priority;
            if (r103 == null) goto L8;
            ConfigPriority.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetSettingsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetSettingsRequest r100 = new ProtoAdapter_GetSettingsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.LOCAL;
        DEFAULT_CONFIG_PRIORITY = ConfigPriority.SETTINGS_ONLY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.fields = Internal.copyOf(SlcCommonAction.KEY_PARAMS, this.fields);
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.config_priority = this.config_priority;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetSettingsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetSettingsRequest(List<String> r100, SyncDataStrategy r101, ConfigPriority r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetSettingsRequest(List<String> r100, SyncDataStrategy r101, ConfigPriority r102, ByteString r103) {
        super(ADAPTER, r103);
        this.fields = Internal.immutableCopyOf(SlcCommonAction.KEY_PARAMS, r100);
        this.sync_data_strategy = r101;
        this.config_priority = r102;
    }
}
