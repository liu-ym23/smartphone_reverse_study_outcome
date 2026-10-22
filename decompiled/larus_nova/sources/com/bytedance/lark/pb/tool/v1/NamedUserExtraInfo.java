package com.bytedance.lark.pb.tool.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class NamedUserExtraInfo extends Message<NamedUserExtraInfo, Builder> {
    public static final ProtoAdapter<NamedUserExtraInfo> ADAPTER = null;
    public static final TenantTag DEFAULT_TENANT_TAG = null;
    public static final Boolean DEFAULT_USE_CLIENT_FG_ONLY = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> client_fg_data;
    public final TenantTag tenant_tag;
    public final Boolean use_client_fg_only;
    public final Map<String, Boolean> used_immutable_feature_gating;

    public static final class Builder extends Message.Builder<NamedUserExtraInfo, Builder> {
        public Map<String, String> client_fg_data;
        public TenantTag tenant_tag;
        public Boolean use_client_fg_only;
        public Map<String, Boolean> used_immutable_feature_gating;

        @Override // com.squareup.wire.Message.Builder
        public NamedUserExtraInfo build() {
            return new NamedUserExtraInfo(this.tenant_tag, this.client_fg_data, this.used_immutable_feature_gating, this.use_client_fg_only, super.buildUnknownFields());
        }

        public Builder() {
            this.client_fg_data = Internal.newMutableMap();
            this.used_immutable_feature_gating = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder client_fg_data(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.client_fg_data = r100;
            return this;
        }

        public Builder tenant_tag(TenantTag r100) {
            this.tenant_tag = r100;
            return this;
        }

        public Builder use_client_fg_only(Boolean r100) {
            this.use_client_fg_only = r100;
            return this;
        }

        public Builder used_immutable_feature_gating(Map<String, Boolean> r100) {
            Internal.checkElementsNotNull(r100);
            this.used_immutable_feature_gating = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_NamedUserExtraInfo extends ProtoAdapter<NamedUserExtraInfo> {
        private final ProtoAdapter<Map<String, String>> client_fg_data;
        private final ProtoAdapter<Map<String, Boolean>> used_immutable_feature_gating;

        public ProtoAdapter_NamedUserExtraInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, NamedUserExtraInfo.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.client_fg_data = ProtoAdapter.newMapAdapter(r100, r100);
            this.used_immutable_feature_gating = ProtoAdapter.newMapAdapter(r100, ProtoAdapter.BOOL);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public NamedUserExtraInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.tenant_tag = TenantTag.STANDARD;
            r101.use_client_fg_only = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.tenant_tag = TenantTag.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.client_fg_data.putAll(this.client_fg_data.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.used_immutable_feature_gating.putAll(this.used_immutable_feature_gating.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.use_client_fg_only = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(NamedUserExtraInfo r100) {
            TenantTag r101 = r100.tenant_tag;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TenantTag.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            int r104 = (r103 + this.client_fg_data.encodedSizeWithTag(2, r100.client_fg_data)) + this.used_immutable_feature_gating.encodedSizeWithTag(3, r100.used_immutable_feature_gating);
            Boolean r105 = r100.use_client_fg_only;
            if (r105 == null) goto L10;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r105);
        L10:
            return (r104 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ NamedUserExtraInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(NamedUserExtraInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, NamedUserExtraInfo r101) throws IOException {
            TenantTag r102 = r101.tenant_tag;
            if (r102 == null) goto L5;
            TenantTag.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            this.client_fg_data.encodeWithTag(r100, 2, r101.client_fg_data);
            this.used_immutable_feature_gating.encodeWithTag(r100, 3, r101.used_immutable_feature_gating);
            Boolean r103 = r101.use_client_fg_only;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, NamedUserExtraInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum TenantTag extends Enum<TenantTag> implements WireEnum {
        private static final /* synthetic */ TenantTag[] $VALUES = null;
        public static final ProtoAdapter<TenantTag> ADAPTER = null;
        public static final TenantTag SIMPLE = null;
        public static final TenantTag STANDARD = null;
        public static final TenantTag UNDEFINED = null;
        private final int value;

        static {
            TenantTag r100 = new TenantTag("STANDARD", 0, 0);
            STANDARD = r100;
            TenantTag r101 = new TenantTag("UNDEFINED", 1, 1);
            UNDEFINED = r101;
            TenantTag r102 = new TenantTag("SIMPLE", 2, 2);
            SIMPLE = r102;
            $VALUES = new TenantTag[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(TenantTag.class);
        }

        public static TenantTag[] values() {
            return (TenantTag[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static TenantTag fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return SIMPLE;
        L12:
            return UNDEFINED;
        L14:
            return STANDARD;
        }

        public static TenantTag valueOf(String r100) {
            return (TenantTag) a.a(TenantTag.class, r100);
        }

        private TenantTag(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_NamedUserExtraInfo();
        DEFAULT_TENANT_TAG = TenantTag.STANDARD;
        DEFAULT_USE_CLIENT_FG_ONLY = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.tenant_tag = this.tenant_tag;
        r100.client_fg_data = Internal.copyOf("client_fg_data", this.client_fg_data);
        r100.used_immutable_feature_gating = Internal.copyOf("used_immutable_feature_gating", this.used_immutable_feature_gating);
        r100.use_client_fg_only = this.use_client_fg_only;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return NamedUserExtraInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public NamedUserExtraInfo(TenantTag r100, Map<String, String> r101, Map<String, Boolean> r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public NamedUserExtraInfo(TenantTag r100, Map<String, String> r101, Map<String, Boolean> r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.tenant_tag = r100;
        this.client_fg_data = Internal.immutableCopyOf("client_fg_data", r101);
        this.used_immutable_feature_gating = Internal.immutableCopyOf("used_immutable_feature_gating", r102);
        this.use_client_fg_only = r103;
    }
}
