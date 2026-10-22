package com.bytedance.lark.pb.tool.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushCpuManagerMagicShareSceneDowngradeStrategy extends Message<PushCpuManagerMagicShareSceneDowngradeStrategy, Builder> {
    public static final ProtoAdapter<PushCpuManagerMagicShareSceneDowngradeStrategy> ADAPTER = null;
    public static final FieldOptions FIELD_OPTIONS_MS_STRATEGY = null;
    public static final ProtoAdapter_PushCpuManagerMagicShareSceneDowngradeStrategy RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final MagicShareDowngradeStrategy ms_strategy;

    public static final class Builder extends Message.Builder<PushCpuManagerMagicShareSceneDowngradeStrategy, Builder> implements d<PushCpuManagerMagicShareSceneDowngradeStrategy> {
        public MagicShareDowngradeStrategy ms_strategy;

        @Override // com.squareup.wire.Message.Builder
        public PushCpuManagerMagicShareSceneDowngradeStrategy build() {
            return new PushCpuManagerMagicShareSceneDowngradeStrategy(this.ms_strategy, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ms_strategy(MagicShareDowngradeStrategy r100) {
            this.ms_strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushCpuManagerMagicShareSceneDowngradeStrategy extends ProtoAdapter<PushCpuManagerMagicShareSceneDowngradeStrategy> implements c<PushCpuManagerMagicShareSceneDowngradeStrategy> {
        public ProtoAdapter_PushCpuManagerMagicShareSceneDowngradeStrategy() {
            super(FieldEncoding.LENGTH_DELIMITED, PushCpuManagerMagicShareSceneDowngradeStrategy.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushCpuManagerMagicShareSceneDowngradeStrategy decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.ms_strategy = MagicShareDowngradeStrategy.ADAPTER.decode(r100);
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushCpuManagerMagicShareSceneDowngradeStrategy r100) {
            MagicShareDowngradeStrategy r101 = r100.ms_strategy;
            if (r101 == null) goto L5;
            int r102 = MagicShareDowngradeStrategy.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushCpuManagerMagicShareSceneDowngradeStrategy decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushCpuManagerMagicShareSceneDowngradeStrategy r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushCpuManagerMagicShareSceneDowngradeStrategy r101) throws IOException {
            MagicShareDowngradeStrategy r102 = r101.ms_strategy;
            if (r102 == null) goto L5;
            MagicShareDowngradeStrategy.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushCpuManagerMagicShareSceneDowngradeStrategy r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushCpuManagerMagicShareSceneDowngradeStrategy r100 = new ProtoAdapter_PushCpuManagerMagicShareSceneDowngradeStrategy();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        FIELD_OPTIONS_MS_STRATEGY = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.ms_strategy = this.ms_strategy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushCpuManagerMagicShareSceneDowngradeStrategy.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushCpuManagerMagicShareSceneDowngradeStrategy(MagicShareDowngradeStrategy r100) {
        this(r100, ByteString.EMPTY);
    }

    public PushCpuManagerMagicShareSceneDowngradeStrategy(MagicShareDowngradeStrategy r100, ByteString r101) {
        super(ADAPTER, r101);
        this.ms_strategy = r100;
    }
}
