package com.bytedance.lark.pb.tool.v1;

import com.bytedance.lark.pb.basic.v1.LeanModeCfg;
import com.bytedance.lark.pb.basic.v1.LockScreenCfg;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class LeanModeConfig extends Message<LeanModeConfig, Builder> {
    public static final ProtoAdapter<LeanModeConfig> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final LeanModeCfg lean_mode_cfg;
    public final LockScreenCfg lock_screen_cfg;

    public static final class Builder extends Message.Builder<LeanModeConfig, Builder> {
        public LeanModeCfg lean_mode_cfg;
        public LockScreenCfg lock_screen_cfg;

        @Override // com.squareup.wire.Message.Builder
        public LeanModeConfig build() {
            return new LeanModeConfig(this.lock_screen_cfg, this.lean_mode_cfg, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder lean_mode_cfg(LeanModeCfg r100) {
            this.lean_mode_cfg = r100;
            return this;
        }

        public Builder lock_screen_cfg(LockScreenCfg r100) {
            this.lock_screen_cfg = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LeanModeConfig extends ProtoAdapter<LeanModeConfig> {
        public ProtoAdapter_LeanModeConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, LeanModeConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public LeanModeConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 2) goto L8;
            r101.lock_screen_cfg = LockScreenCfg.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 3) goto L9;
            r101.lean_mode_cfg = LeanModeCfg.ADAPTER.decode(r100);
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
        public int encodedSize2(LeanModeConfig r100) {
            LockScreenCfg r101 = r100.lock_screen_cfg;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = LockScreenCfg.ADAPTER.encodedSizeWithTag(2, r101);
        L6:
            LeanModeCfg r104 = r100.lean_mode_cfg;
            if (r104 == null) goto L10;
            r102 = LeanModeCfg.ADAPTER.encodedSizeWithTag(3, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LeanModeConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LeanModeConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LeanModeConfig r101) throws IOException {
            LockScreenCfg r102 = r101.lock_screen_cfg;
            if (r102 == null) goto L5;
            LockScreenCfg.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            LeanModeCfg r103 = r101.lean_mode_cfg;
            if (r103 == null) goto L8;
            LeanModeCfg.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LeanModeConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LeanModeConfig();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.lock_screen_cfg = this.lock_screen_cfg;
        r100.lean_mode_cfg = this.lean_mode_cfg;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LeanModeConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LeanModeConfig(LockScreenCfg r100, LeanModeCfg r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public LeanModeConfig(LockScreenCfg r100, LeanModeCfg r101, ByteString r102) {
        super(ADAPTER, r102);
        this.lock_screen_cfg = r100;
        this.lean_mode_cfg = r101;
    }
}
