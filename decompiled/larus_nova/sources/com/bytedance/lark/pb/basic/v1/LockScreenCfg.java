package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class LockScreenCfg extends com.squareup.wire.Message<LockScreenCfg, Builder> {
    public static final ProtoAdapter<LockScreenCfg> ADAPTER = null;
    public static final Boolean DEFAULT_IS_LOCK_SCREEN_ENABLED = null;
    public static final Long DEFAULT_LOCK_SCREEN_CFG_UPDATED_AT_MICRO_SEC = null;
    public static final String DEFAULT_LOCK_SCREEN_PASSWORD = "";
    private static final long serialVersionUID = 0;
    public final Boolean is_lock_screen_enabled;
    public final Long lock_screen_cfg_updated_at_micro_sec;
    public final String lock_screen_password;

    public static final class Builder extends com.squareup.wire.Message.Builder<LockScreenCfg, Builder> {
        public Boolean is_lock_screen_enabled;
        public Long lock_screen_cfg_updated_at_micro_sec;
        public String lock_screen_password;

        @Override // com.squareup.wire.Message.Builder
        public LockScreenCfg build() {
            return new LockScreenCfg(this.is_lock_screen_enabled, this.lock_screen_password, this.lock_screen_cfg_updated_at_micro_sec, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder is_lock_screen_enabled(Boolean r100) {
            this.is_lock_screen_enabled = r100;
            return this;
        }

        public Builder lock_screen_cfg_updated_at_micro_sec(Long r100) {
            this.lock_screen_cfg_updated_at_micro_sec = r100;
            return this;
        }

        public Builder lock_screen_password(String r100) {
            this.lock_screen_password = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LockScreenCfg extends ProtoAdapter<LockScreenCfg> {
        public ProtoAdapter_LockScreenCfg() {
            super(FieldEncoding.LENGTH_DELIMITED, LockScreenCfg.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public LockScreenCfg decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.is_lock_screen_enabled = Boolean.FALSE;
            r101.lock_screen_password = "";
            r101.lock_screen_cfg_updated_at_micro_sec = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.is_lock_screen_enabled = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.lock_screen_password = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.lock_screen_cfg_updated_at_micro_sec = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(LockScreenCfg r100) {
            Boolean r101 = r100.is_lock_screen_enabled;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.lock_screen_password;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.lock_screen_cfg_updated_at_micro_sec;
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
        public /* bridge */ /* synthetic */ LockScreenCfg decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LockScreenCfg r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LockScreenCfg r101) throws IOException {
            Boolean r102 = r101.is_lock_screen_enabled;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.lock_screen_password;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.lock_screen_cfg_updated_at_micro_sec;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LockScreenCfg r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LockScreenCfg();
        DEFAULT_IS_LOCK_SCREEN_ENABLED = Boolean.FALSE;
        DEFAULT_LOCK_SCREEN_CFG_UPDATED_AT_MICRO_SEC = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_lock_screen_enabled = this.is_lock_screen_enabled;
        r100.lock_screen_password = this.lock_screen_password;
        r100.lock_screen_cfg_updated_at_micro_sec = this.lock_screen_cfg_updated_at_micro_sec;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LockScreenCfg.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public LockScreenCfg(Boolean r100, String r101, Long r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public LockScreenCfg(Boolean r100, String r101, Long r102, ByteString r103) {
        super(ADAPTER, r103);
        this.is_lock_screen_enabled = r100;
        this.lock_screen_password = r101;
        this.lock_screen_cfg_updated_at_micro_sec = r102;
    }
}
