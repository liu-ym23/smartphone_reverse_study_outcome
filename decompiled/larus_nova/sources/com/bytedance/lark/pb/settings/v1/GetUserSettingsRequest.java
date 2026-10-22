package com.bytedance.lark.pb.settings.v1;

import annotation.Debug;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.google.protobuf.FieldOptions;
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
public final class GetUserSettingsRequest extends Message<GetUserSettingsRequest, Builder> {
    public static final ProtoAdapter<GetUserSettingsRequest> ADAPTER = null;
    public static final ConfigPriority DEFAULT_CONFIG_PRIORITY = null;
    public static final Boolean DEFAULT_IGNORE_TTL = null;
    public static final Boolean DEFAULT_NEED_DOMAIN = null;
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final FieldOptions FIELD_OPTIONS_FIELDS = null;
    public static final FieldOptions FIELD_OPTIONS_IGNORE_TTL = null;
    public static final FieldOptions FIELD_OPTIONS_NEED_DOMAIN = null;
    public static final FieldOptions FIELD_OPTIONS_SYNC_DATA_STRATEGY = null;
    public static final ProtoAdapter_GetUserSettingsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ConfigPriority config_priority;
    public final List<String> fields;
    public final Boolean ignore_ttl;
    public final Boolean need_domain;
    public final SyncDataStrategy sync_data_strategy;

    public static final class Builder extends Message.Builder<GetUserSettingsRequest, Builder> implements d<GetUserSettingsRequest> {
        public ConfigPriority config_priority;
        public List<String> fields;
        public Boolean ignore_ttl;
        public Boolean need_domain;
        public SyncDataStrategy sync_data_strategy;

        @Override // com.squareup.wire.Message.Builder
        public GetUserSettingsRequest build() {
            SyncDataStrategy r100 = this.sync_data_strategy;
            if (r100 == null) goto L9;
            if (this.need_domain == null) goto L9;
            return new GetUserSettingsRequest(this.fields, this.sync_data_strategy, this.need_domain, this.ignore_ttl, this.config_priority, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "sync_data_strategy", this.need_domain, "need_domain"});
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

        public Builder ignore_ttl(Boolean r100) {
            this.ignore_ttl = r100;
            return this;
        }

        public Builder need_domain(Boolean r100) {
            this.need_domain = r100;
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

    public static final class ProtoAdapter_GetUserSettingsRequest extends ProtoAdapter<GetUserSettingsRequest> implements c<GetUserSettingsRequest> {
        public ProtoAdapter_GetUserSettingsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUserSettingsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUserSettingsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.sync_data_strategy = SyncDataStrategy.LOCAL;
            Boolean r102 = Boolean.FALSE;
            r101.need_domain = r102;
            r101.ignore_ttl = r102;
            r101.config_priority = ConfigPriority.SETTINGS_ONLY;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L27;
            if (r104 != 1) goto L8;
            r101.fields.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.sync_data_strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
        L24:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.need_domain = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L14;
            r101.ignore_ttl = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            if (r104 != 5) goto L15;
            r101.config_priority = ConfigPriority.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetUserSettingsRequest r100) {
            int r101 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.fields) + SyncDataStrategy.ADAPTER.encodedSizeWithTag(2, r100.sync_data_strategy);
            ProtoAdapter<Boolean> r102 = ProtoAdapter.BOOL;
            int r103 = r101 + r102.encodedSizeWithTag(3, r100.need_domain);
            Boolean r104 = r100.ignore_ttl;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = r102.encodedSizeWithTag(4, r104);
        L6:
            int r107 = r103 + r106;
            ConfigPriority r108 = r100.config_priority;
            if (r108 == null) goto L10;
            r105 = ConfigPriority.ADAPTER.encodedSizeWithTag(5, r108);
        L10:
            return (r107 + r105) + r100.unknownFields().size();
        L5:
            r106 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUserSettingsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUserSettingsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUserSettingsRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.fields);
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 2, r101.sync_data_strategy);
            ProtoAdapter<Boolean> r102 = ProtoAdapter.BOOL;
            r102.encodeWithTag(r100, 3, r101.need_domain);
            Boolean r103 = r101.ignore_ttl;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 4, r103);
        L5:
            ConfigPriority r104 = r101.config_priority;
            if (r104 == null) goto L8;
            ConfigPriority.ADAPTER.encodeWithTag(r100, 5, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUserSettingsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetUserSettingsRequest r100 = new ProtoAdapter_GetUserSettingsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        FIELD_OPTIONS_FIELDS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_SYNC_DATA_STRATEGY = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_NEED_DOMAIN = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_IGNORE_TTL = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.LOCAL;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_NEED_DOMAIN = r101;
        DEFAULT_IGNORE_TTL = r101;
        DEFAULT_CONFIG_PRIORITY = ConfigPriority.SETTINGS_ONLY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.fields = Internal.copyOf(SlcCommonAction.KEY_PARAMS, this.fields);
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.need_domain = this.need_domain;
        r100.ignore_ttl = this.ignore_ttl;
        r100.config_priority = this.config_priority;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUserSettingsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUserSettingsRequest(List<String> r100, SyncDataStrategy r101, Boolean r110, Boolean r111, ConfigPriority r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public GetUserSettingsRequest(List<String> r100, SyncDataStrategy r101, Boolean r102, Boolean r103, ConfigPriority r104, ByteString r105) {
        super(ADAPTER, r105);
        this.fields = Internal.immutableCopyOf(SlcCommonAction.KEY_PARAMS, r100);
        this.sync_data_strategy = r101;
        this.need_domain = r102;
        this.ignore_ttl = r103;
        this.config_priority = r104;
    }
}
