package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ChatToolkit extends com.squareup.wire.Message<ChatToolkit, Builder> {
    public static final ProtoAdapter<ChatToolkit> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Long> mids;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatToolkit, Builder> {
        public List<Long> mids;

        @Override // com.squareup.wire.Message.Builder
        public ChatToolkit build() {
            return new ChatToolkit(this.mids, super.buildUnknownFields());
        }

        public Builder() {
            this.mids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.mids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatToolkit extends ProtoAdapter<ChatToolkit> {
        public ProtoAdapter_ChatToolkit() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatToolkit.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatToolkit decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mids.add(ProtoAdapter.INT64.decode(r100));
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
        public int encodedSize2(ChatToolkit r100) {
            return ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(1, r100.mids) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ChatToolkit decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatToolkit r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatToolkit r101) throws IOException {
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 1, r101.mids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatToolkit r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatToolkit();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mids = Internal.copyOf("mids", this.mids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatToolkit.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatToolkit(List<Long> r100) {
        this(r100, ByteString.EMPTY);
    }

    public ChatToolkit(List<Long> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mids = Internal.immutableCopyOf("mids", r100);
    }
}
