package com.bytedance.lark.pb.im.v1;

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
public final class PushDoubaoSmartReply extends Message<PushDoubaoSmartReply, Builder> {
    public static final ProtoAdapter<PushDoubaoSmartReply> ADAPTER = null;
    public static final ProtoAdapter_PushDoubaoSmartReply RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DoubaoSmartReply doubao_smart_reply;

    public static final class Builder extends Message.Builder<PushDoubaoSmartReply, Builder> implements d<PushDoubaoSmartReply> {
        public DoubaoSmartReply doubao_smart_reply;

        @Override // com.squareup.wire.Message.Builder
        public PushDoubaoSmartReply build() {
            return new PushDoubaoSmartReply(this.doubao_smart_reply, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder doubao_smart_reply(DoubaoSmartReply r100) {
            this.doubao_smart_reply = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushDoubaoSmartReply extends ProtoAdapter<PushDoubaoSmartReply> implements c<PushDoubaoSmartReply> {
        public ProtoAdapter_PushDoubaoSmartReply() {
            super(FieldEncoding.LENGTH_DELIMITED, PushDoubaoSmartReply.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushDoubaoSmartReply decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.doubao_smart_reply = DoubaoSmartReply.ADAPTER.decode(r100);
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
        public int encodedSize2(PushDoubaoSmartReply r100) {
            DoubaoSmartReply r101 = r100.doubao_smart_reply;
            if (r101 == null) goto L5;
            int r102 = DoubaoSmartReply.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushDoubaoSmartReply decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushDoubaoSmartReply r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushDoubaoSmartReply r101) throws IOException {
            DoubaoSmartReply r102 = r101.doubao_smart_reply;
            if (r102 == null) goto L5;
            DoubaoSmartReply.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushDoubaoSmartReply r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushDoubaoSmartReply r100 = new ProtoAdapter_PushDoubaoSmartReply();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.doubao_smart_reply = this.doubao_smart_reply;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushDoubaoSmartReply.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushDoubaoSmartReply(DoubaoSmartReply r100) {
        this(r100, ByteString.EMPTY);
    }

    public PushDoubaoSmartReply(DoubaoSmartReply r100, ByteString r101) {
        super(ADAPTER, r101);
        this.doubao_smart_reply = r100;
    }
}
