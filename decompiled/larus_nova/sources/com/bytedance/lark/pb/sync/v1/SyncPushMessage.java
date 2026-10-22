package com.bytedance.lark.pb.sync.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class SyncPushMessage extends Message<SyncPushMessage, Builder> {
    public static final ProtoAdapter<SyncPushMessage> ADAPTER = null;
    public static final String DEFAULT_APP_NAME = "";
    public static final ProtoAdapter_SyncPushMessage RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String app_name;
    public final SyncMessage message;

    public static final class Builder extends Message.Builder<SyncPushMessage, Builder> implements d<SyncPushMessage> {
        public String app_name;
        public SyncMessage message;

        @Override // com.squareup.wire.Message.Builder
        public SyncPushMessage build() {
            SyncMessage r100 = this.message;
            if (r100 == null) goto L9;
            if (this.app_name == null) goto L9;
            return new SyncPushMessage(this.message, this.app_name, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "message", this.app_name, "app_name"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_name(String r100) {
            this.app_name = r100;
            return this;
        }

        public Builder message(SyncMessage r100) {
            this.message = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SyncPushMessage extends ProtoAdapter<SyncPushMessage> implements c<SyncPushMessage> {
        public ProtoAdapter_SyncPushMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, SyncPushMessage.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SyncPushMessage decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.app_name = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.message = SyncMessage.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.app_name = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SyncPushMessage r100) {
            return (SyncMessage.ADAPTER.encodedSizeWithTag(1, r100.message) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.app_name)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SyncPushMessage decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SyncPushMessage r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SyncPushMessage r101) throws IOException {
            SyncMessage.ADAPTER.encodeWithTag(r100, 1, r101.message);
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.app_name);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SyncPushMessage r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SyncPushMessage r100 = new ProtoAdapter_SyncPushMessage();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message = this.message;
        r100.app_name = this.app_name;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SyncPushMessage.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SyncPushMessage(SyncMessage r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SyncPushMessage(SyncMessage r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.message = r100;
        this.app_name = r101;
    }
}
