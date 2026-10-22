package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class SetInOfflineModeRequest extends com.squareup.wire.Message<SetInOfflineModeRequest, Builder> {
    public static final ProtoAdapter<SetInOfflineModeRequest> ADAPTER = null;
    public static final Boolean DEFAULT_IS_OFFLINE = null;
    public static final ProtoAdapter_SetInOfflineModeRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_offline;

    public static final class Builder extends com.squareup.wire.Message.Builder<SetInOfflineModeRequest, Builder> implements b<SetInOfflineModeRequest> {
        public Boolean is_offline;

        @Override // com.squareup.wire.Message.Builder
        public SetInOfflineModeRequest build() {
            Boolean r100 = this.is_offline;
            if (r100 == null) goto L7;
            return new SetInOfflineModeRequest(this.is_offline, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "is_offline"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder is_offline(Boolean r100) {
            this.is_offline = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SetInOfflineModeRequest extends ProtoAdapter<SetInOfflineModeRequest> implements a<SetInOfflineModeRequest> {
        public ProtoAdapter_SetInOfflineModeRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SetInOfflineModeRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetInOfflineModeRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.is_offline = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.is_offline = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(SetInOfflineModeRequest r100) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.is_offline) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetInOfflineModeRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetInOfflineModeRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetInOfflineModeRequest r101) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.is_offline);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetInOfflineModeRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SetInOfflineModeRequest r100 = new ProtoAdapter_SetInOfflineModeRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_IS_OFFLINE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_offline = this.is_offline;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetInOfflineModeRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetInOfflineModeRequest(Boolean r100) {
        this(r100, ByteString.EMPTY);
    }

    public SetInOfflineModeRequest(Boolean r100, ByteString r101) {
        super(ADAPTER, r101);
        this.is_offline = r100;
    }
}
