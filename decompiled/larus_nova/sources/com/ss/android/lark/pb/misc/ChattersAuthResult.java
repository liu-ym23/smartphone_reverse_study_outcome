package com.ss.android.lark.pb.misc;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ChattersAuthResult extends Message<ChattersAuthResult, Builder> {
    public static final ProtoAdapter<ChattersAuthResult> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, DeniedReason> mdenied_reasons;

    public static final class Builder extends Message.Builder<ChattersAuthResult, Builder> {
        public Map<String, DeniedReason> mdenied_reasons;

        @Override // com.squareup.wire.Message.Builder
        public ChattersAuthResult build() {
            return new ChattersAuthResult(this.mdenied_reasons, super.buildUnknownFields());
        }

        public Builder() {
            this.mdenied_reasons = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder denied_reasons(Map<String, DeniedReason> r100) {
            Internal.checkElementsNotNull(r100);
            this.mdenied_reasons = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChattersAuthResult extends ProtoAdapter<ChattersAuthResult> {
        private final ProtoAdapter<Map<String, DeniedReason>> mdenied_reasons;

        public ProtoAdapter_ChattersAuthResult() {
            super(FieldEncoding.LENGTH_DELIMITED, ChattersAuthResult.class);
            this.mdenied_reasons = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, DeniedReason.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChattersAuthResult decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mdenied_reasons.putAll(this.mdenied_reasons.decode(r100));
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
        public int encodedSize2(ChattersAuthResult r100) {
            return this.mdenied_reasons.encodedSizeWithTag(1, r100.mdenied_reasons) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ChattersAuthResult decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChattersAuthResult r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChattersAuthResult r101) throws IOException {
            this.mdenied_reasons.encodeWithTag(r100, 1, r101.mdenied_reasons);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChattersAuthResult r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChattersAuthResult();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mdenied_reasons = Internal.copyOf("mdenied_reasons", this.mdenied_reasons);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChattersAuthResult.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChattersAuthResult(Map<String, DeniedReason> r100) {
        this(r100, ByteString.EMPTY);
    }

    public ChattersAuthResult(Map<String, DeniedReason> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mdenied_reasons = Internal.immutableCopyOf("mdenied_reasons", r100);
    }
}
