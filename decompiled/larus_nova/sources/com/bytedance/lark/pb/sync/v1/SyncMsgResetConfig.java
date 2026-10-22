package com.bytedance.lark.pb.sync.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SyncMsgResetConfig extends Message<SyncMsgResetConfig, Builder> {
    public static final ProtoAdapter<SyncMsgResetConfig> ADAPTER = null;
    public static final String DEFAULT_FROM_BIZ_KEY_VALUE = "";
    public static final Long DEFAULT_FROM_LAST_MSG_VALUE = null;
    public static final SyncMsgResetType DEFAULT_RESET_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String from_biz_key_value;
    public final Long from_last_msg_value;
    public final SyncMsgResetType reset_type;

    public static final class Builder extends Message.Builder<SyncMsgResetConfig, Builder> {
        public String from_biz_key_value;
        public Long from_last_msg_value;
        public SyncMsgResetType reset_type;

        @Override // com.squareup.wire.Message.Builder
        public SyncMsgResetConfig build() {
            SyncMsgResetType r100 = this.reset_type;
            if (r100 == null) goto L7;
            return new SyncMsgResetConfig(this.reset_type, this.from_last_msg_value, this.from_biz_key_value, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "reset_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder from_biz_key_value(String r100) {
            this.from_biz_key_value = r100;
            return this;
        }

        public Builder from_last_msg_value(Long r100) {
            this.from_last_msg_value = r100;
            return this;
        }

        public Builder reset_type(SyncMsgResetType r100) {
            this.reset_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SyncMsgResetConfig extends ProtoAdapter<SyncMsgResetConfig> {
        public ProtoAdapter_SyncMsgResetConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SyncMsgResetConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SyncMsgResetConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.reset_type = SyncMsgResetType.FROM_LAST_MSG;
            r101.from_last_msg_value = 0L;
            r101.from_biz_key_value = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.reset_type = SyncMsgResetType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 3) goto L10;
            r101.from_last_msg_value = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 4) goto L11;
            r101.from_biz_key_value = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SyncMsgResetConfig r100) {
            int r101 = SyncMsgResetType.ADAPTER.encodedSizeWithTag(1, r100.reset_type);
            Long r102 = r100.from_last_msg_value;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.INT64.encodedSizeWithTag(3, r102);
        L6:
            int r105 = r101 + r104;
            String r106 = r100.from_biz_key_value;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.STRING.encodedSizeWithTag(4, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SyncMsgResetConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SyncMsgResetConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SyncMsgResetConfig r101) throws IOException {
            SyncMsgResetType.ADAPTER.encodeWithTag(r100, 1, r101.reset_type);
            Long r102 = r101.from_last_msg_value;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r102);
        L5:
            String r103 = r101.from_biz_key_value;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SyncMsgResetConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SyncMsgResetConfig();
        DEFAULT_RESET_TYPE = SyncMsgResetType.FROM_LAST_MSG;
        DEFAULT_FROM_LAST_MSG_VALUE = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.reset_type = this.reset_type;
        r100.from_last_msg_value = this.from_last_msg_value;
        r100.from_biz_key_value = this.from_biz_key_value;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SyncMsgResetConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SyncMsgResetConfig(SyncMsgResetType r100, Long r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public SyncMsgResetConfig(SyncMsgResetType r100, Long r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.reset_type = r100;
        this.from_last_msg_value = r101;
        this.from_biz_key_value = r102;
    }
}
