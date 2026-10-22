package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class BotAutoMuteConfig extends com.squareup.wire.Message<BotAutoMuteConfig, Builder> {
    public static final ProtoAdapter<BotAutoMuteConfig> ADAPTER = null;
    public static final Long DEFAULT_BOT_ID = null;
    private static final long serialVersionUID = 0;
    public final Long bot_id;
    public final AutoMuteConfig mute_config;

    public static final class Builder extends com.squareup.wire.Message.Builder<BotAutoMuteConfig, Builder> {
        public Long bot_id;
        public AutoMuteConfig mute_config;

        @Override // com.squareup.wire.Message.Builder
        public BotAutoMuteConfig build() {
            return new BotAutoMuteConfig(this.bot_id, this.mute_config, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder bot_id(Long r100) {
            this.bot_id = r100;
            return this;
        }

        public Builder mute_config(AutoMuteConfig r100) {
            this.mute_config = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BotAutoMuteConfig extends ProtoAdapter<BotAutoMuteConfig> {
        public ProtoAdapter_BotAutoMuteConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, BotAutoMuteConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BotAutoMuteConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.bot_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.bot_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mute_config = AutoMuteConfig.ADAPTER.decode(r100);
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
        public int encodedSize2(BotAutoMuteConfig r100) {
            Long r101 = r100.bot_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            AutoMuteConfig r104 = r100.mute_config;
            if (r104 == null) goto L10;
            r102 = AutoMuteConfig.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BotAutoMuteConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BotAutoMuteConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BotAutoMuteConfig r101) throws IOException {
            Long r102 = r101.bot_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            AutoMuteConfig r103 = r101.mute_config;
            if (r103 == null) goto L8;
            AutoMuteConfig.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BotAutoMuteConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BotAutoMuteConfig();
        DEFAULT_BOT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.bot_id = this.bot_id;
        r100.mute_config = this.mute_config;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BotAutoMuteConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public BotAutoMuteConfig(Long r100, AutoMuteConfig r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public BotAutoMuteConfig(Long r100, AutoMuteConfig r101, ByteString r102) {
        super(ADAPTER, r102);
        this.bot_id = r100;
        this.mute_config = r101;
    }
}
