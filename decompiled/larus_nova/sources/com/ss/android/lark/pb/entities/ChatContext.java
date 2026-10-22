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
public final class ChatContext extends com.squareup.wire.Message<ChatContext, Builder> {
    public static final ProtoAdapter<ChatContext> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> mextra_map;
    public final AISceneObject mobject;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatContext, Builder> {
        public Map<String, String> mextra_map;
        public AISceneObject mobject;

        @Override // com.squareup.wire.Message.Builder
        public ChatContext build() {
            return new ChatContext(this.mextra_map, this.mobject, super.buildUnknownFields());
        }

        public Builder() {
            this.mextra_map = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder extra_map(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mextra_map = r100;
            return this;
        }

        public Builder object(AISceneObject r100) {
            this.mobject = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatContext extends ProtoAdapter<ChatContext> {
        private final ProtoAdapter<Map<String, String>> mextra_map;

        public ProtoAdapter_ChatContext() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatContext.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mextra_map = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatContext decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mextra_map.putAll(this.mextra_map.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mobject = AISceneObject.ADAPTER.decode(r100);
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
        public int encodedSize2(ChatContext r100) {
            int r101 = this.mextra_map.encodedSizeWithTag(1, r100.mextra_map);
            AISceneObject r102 = r100.mobject;
            if (r102 == null) goto L5;
            int r103 = AISceneObject.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ChatContext decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatContext r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatContext r101) throws IOException {
            this.mextra_map.encodeWithTag(r100, 1, r101.mextra_map);
            AISceneObject r102 = r101.mobject;
            if (r102 == null) goto L5;
            AISceneObject.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatContext r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatContext();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mextra_map = Internal.copyOf("mextra_map", this.mextra_map);
        r100.mobject = this.mobject;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatContext.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatContext(Map<String, String> r100, AISceneObject r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ChatContext(Map<String, String> r100, AISceneObject r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mextra_map = Internal.immutableCopyOf("mextra_map", r100);
        this.mobject = r101;
    }
}
