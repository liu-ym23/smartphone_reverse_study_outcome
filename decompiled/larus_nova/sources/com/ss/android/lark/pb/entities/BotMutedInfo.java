package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class BotMutedInfo extends com.squareup.wire.Message<BotMutedInfo, Builder> {
    public static final ProtoAdapter<BotMutedInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Boolean> mmuted_scenes;

    public static final class Builder extends com.squareup.wire.Message.Builder<BotMutedInfo, Builder> {
        public Map<String, Boolean> mmuted_scenes;

        @Override // com.squareup.wire.Message.Builder
        public BotMutedInfo build() {
            return new BotMutedInfo(this.mmuted_scenes, super.buildUnknownFields());
        }

        public Builder() {
            this.mmuted_scenes = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder muted_scenes(Map<String, Boolean> r100) {
            Internal.checkElementsNotNull(r100);
            this.mmuted_scenes = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BotMutedInfo extends ProtoAdapter<BotMutedInfo> {
        private final ProtoAdapter<Map<String, Boolean>> mmuted_scenes;

        public ProtoAdapter_BotMutedInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, BotMutedInfo.class);
            this.mmuted_scenes = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.BOOL);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BotMutedInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mmuted_scenes.putAll(this.mmuted_scenes.decode(r100));
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
        public int encodedSize2(BotMutedInfo r100) {
            return this.mmuted_scenes.encodedSizeWithTag(1, r100.mmuted_scenes) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BotMutedInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BotMutedInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BotMutedInfo r101) throws IOException {
            this.mmuted_scenes.encodeWithTag(r100, 1, r101.mmuted_scenes);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BotMutedInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BotMutedInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmuted_scenes = Internal.copyOf("mmuted_scenes", this.mmuted_scenes);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BotMutedInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public BotMutedInfo(Map<String, Boolean> r100) {
        this(r100, ByteString.EMPTY);
    }

    public BotMutedInfo(Map<String, Boolean> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mmuted_scenes = Internal.immutableCopyOf("mmuted_scenes", r100);
    }
}
