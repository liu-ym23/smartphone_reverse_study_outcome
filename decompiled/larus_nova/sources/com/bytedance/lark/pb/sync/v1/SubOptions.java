package com.bytedance.lark.pb.sync.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SubOptions extends Message<SubOptions, Builder> {
    public static final ProtoAdapter<SubOptions> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final SyncMsgResetConfig syncMsgResetConfig;

    public static final class Builder extends Message.Builder<SubOptions, Builder> {
        public SyncMsgResetConfig syncMsgResetConfig;

        @Override // com.squareup.wire.Message.Builder
        public SubOptions build() {
            return new SubOptions(this.syncMsgResetConfig, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder syncMsgResetConfig(SyncMsgResetConfig r100) {
            this.syncMsgResetConfig = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SubOptions extends ProtoAdapter<SubOptions> {
        public ProtoAdapter_SubOptions() {
            super(FieldEncoding.LENGTH_DELIMITED, SubOptions.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubOptions decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.syncMsgResetConfig = SyncMsgResetConfig.ADAPTER.decode(r100);
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
        public int encodedSize2(SubOptions r100) {
            SyncMsgResetConfig r101 = r100.syncMsgResetConfig;
            if (r101 == null) goto L5;
            int r102 = SyncMsgResetConfig.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubOptions decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubOptions r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SubOptions r101) throws IOException {
            SyncMsgResetConfig r102 = r101.syncMsgResetConfig;
            if (r102 == null) goto L5;
            SyncMsgResetConfig.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SubOptions r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubOptions();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.syncMsgResetConfig = this.syncMsgResetConfig;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SubOptions.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SubOptions(SyncMsgResetConfig r100) {
        this(r100, ByteString.EMPTY);
    }

    public SubOptions(SyncMsgResetConfig r100, ByteString r101) {
        super(ADAPTER, r101);
        this.syncMsgResetConfig = r100;
    }
}
