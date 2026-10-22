package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class LeanModeCfg extends com.squareup.wire.Message<LeanModeCfg, Builder> {
    public static final ProtoAdapter<LeanModeCfg> ADAPTER = null;
    public static final Boolean DEFAULT_ALL_DEVICES_IN_LEAN_MODE = null;
    public static final Boolean DEFAULT_CAN_USE_LEAN_MODE = null;
    public static final Boolean DEFAULT_DEVICE_HAVE_AUTHORITY = null;
    public static final Long DEFAULT_LEAN_MODE_CFG_UPDATED_AT_MICRO_SEC = null;
    private static final long serialVersionUID = 0;
    public final Boolean all_devices_in_lean_mode;
    public final Boolean can_use_lean_mode;
    public final Boolean device_have_authority;
    public final Long lean_mode_cfg_updated_at_micro_sec;

    public static final class Builder extends com.squareup.wire.Message.Builder<LeanModeCfg, Builder> {
        public Boolean all_devices_in_lean_mode;
        public Boolean can_use_lean_mode;
        public Boolean device_have_authority;
        public Long lean_mode_cfg_updated_at_micro_sec;

        @Override // com.squareup.wire.Message.Builder
        public LeanModeCfg build() {
            return new LeanModeCfg(this.all_devices_in_lean_mode, this.lean_mode_cfg_updated_at_micro_sec, this.can_use_lean_mode, this.device_have_authority, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder all_devices_in_lean_mode(Boolean r100) {
            this.all_devices_in_lean_mode = r100;
            return this;
        }

        public Builder can_use_lean_mode(Boolean r100) {
            this.can_use_lean_mode = r100;
            return this;
        }

        public Builder device_have_authority(Boolean r100) {
            this.device_have_authority = r100;
            return this;
        }

        public Builder lean_mode_cfg_updated_at_micro_sec(Long r100) {
            this.lean_mode_cfg_updated_at_micro_sec = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LeanModeCfg extends ProtoAdapter<LeanModeCfg> {
        public ProtoAdapter_LeanModeCfg() {
            super(FieldEncoding.LENGTH_DELIMITED, LeanModeCfg.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public LeanModeCfg decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.all_devices_in_lean_mode = r102;
            r101.lean_mode_cfg_updated_at_micro_sec = 0L;
            r101.can_use_lean_mode = r102;
            r101.device_have_authority = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            if (r104 != 1) goto L8;
            r101.all_devices_in_lean_mode = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.lean_mode_cfg_updated_at_micro_sec = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.can_use_lean_mode = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L13;
            r101.device_have_authority = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(LeanModeCfg r100) {
            Boolean r101 = r100.all_devices_in_lean_mode;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.lean_mode_cfg_updated_at_micro_sec;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.can_use_lean_mode;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.device_have_authority;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ LeanModeCfg decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LeanModeCfg r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LeanModeCfg r101) throws IOException {
            Boolean r102 = r101.all_devices_in_lean_mode;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.lean_mode_cfg_updated_at_micro_sec;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.can_use_lean_mode;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.device_have_authority;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LeanModeCfg r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LeanModeCfg();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_ALL_DEVICES_IN_LEAN_MODE = r100;
        DEFAULT_LEAN_MODE_CFG_UPDATED_AT_MICRO_SEC = 0L;
        DEFAULT_CAN_USE_LEAN_MODE = r100;
        DEFAULT_DEVICE_HAVE_AUTHORITY = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.all_devices_in_lean_mode = this.all_devices_in_lean_mode;
        r100.lean_mode_cfg_updated_at_micro_sec = this.lean_mode_cfg_updated_at_micro_sec;
        r100.can_use_lean_mode = this.can_use_lean_mode;
        r100.device_have_authority = this.device_have_authority;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LeanModeCfg.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public LeanModeCfg(Boolean r100, Long r101, Boolean r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public LeanModeCfg(Boolean r100, Long r101, Boolean r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.all_devices_in_lean_mode = r100;
        this.lean_mode_cfg_updated_at_micro_sec = r101;
        this.can_use_lean_mode = r102;
        this.device_have_authority = r103;
    }
}
