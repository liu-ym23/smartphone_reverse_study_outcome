package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushEmojis extends Message<PushEmojis, Builder> {
    public static final ProtoAdapter<PushEmojis> ADAPTER = null;
    public static final Integer DEFAULT_VERSION = null;
    public static final ProtoAdapter_PushEmojis RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Emoji> emojis;
    public final Integer version;

    public static final class Builder extends Message.Builder<PushEmojis, Builder> implements d<PushEmojis> {
        public Map<String, Emoji> emojis;
        public Integer version;

        @Override // com.squareup.wire.Message.Builder
        public PushEmojis build() {
            return new PushEmojis(this.emojis, this.version, super.buildUnknownFields());
        }

        public Builder() {
            this.emojis = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder emojis(Map<String, Emoji> r100) {
            Internal.checkElementsNotNull(r100);
            this.emojis = r100;
            return this;
        }

        public Builder version(Integer r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushEmojis extends ProtoAdapter<PushEmojis> implements c<PushEmojis> {
        private final ProtoAdapter<Map<String, Emoji>> emojis;

        public ProtoAdapter_PushEmojis() {
            super(FieldEncoding.LENGTH_DELIMITED, PushEmojis.class);
            this.emojis = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, Emoji.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushEmojis decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.version = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.emojis.putAll(this.emojis.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.version = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(PushEmojis r100) {
            int r101 = this.emojis.encodedSizeWithTag(1, r100.emojis);
            Integer r102 = r100.version;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushEmojis decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushEmojis r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushEmojis r101) throws IOException {
            this.emojis.encodeWithTag(r100, 1, r101.emojis);
            Integer r102 = r101.version;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushEmojis r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushEmojis r100 = new ProtoAdapter_PushEmojis();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_VERSION = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.emojis = Internal.copyOf("emojis", this.emojis);
        r100.version = this.version;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushEmojis.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushEmojis(Map<String, Emoji> r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PushEmojis(Map<String, Emoji> r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.emojis = Internal.immutableCopyOf("emojis", r100);
        this.version = r101;
    }
}
