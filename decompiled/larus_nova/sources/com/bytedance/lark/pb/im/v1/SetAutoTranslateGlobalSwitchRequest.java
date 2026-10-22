package com.bytedance.lark.pb.im.v1;

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
public final class SetAutoTranslateGlobalSwitchRequest extends Message<SetAutoTranslateGlobalSwitchRequest, Builder> {
    public static final ProtoAdapter<SetAutoTranslateGlobalSwitchRequest> ADAPTER = null;
    public static final Boolean DEFAULT_IS_OPEN = null;
    public static final ProtoAdapter_SetAutoTranslateGlobalSwitchRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_open;

    public static final class Builder extends Message.Builder<SetAutoTranslateGlobalSwitchRequest, Builder> implements d<SetAutoTranslateGlobalSwitchRequest> {
        public Boolean is_open;

        @Override // com.squareup.wire.Message.Builder
        public SetAutoTranslateGlobalSwitchRequest build() {
            Boolean r100 = this.is_open;
            if (r100 == null) goto L7;
            return new SetAutoTranslateGlobalSwitchRequest(this.is_open, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "is_open"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_open(Boolean r100) {
            this.is_open = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SetAutoTranslateGlobalSwitchRequest extends ProtoAdapter<SetAutoTranslateGlobalSwitchRequest> implements c<SetAutoTranslateGlobalSwitchRequest> {
        public ProtoAdapter_SetAutoTranslateGlobalSwitchRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SetAutoTranslateGlobalSwitchRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetAutoTranslateGlobalSwitchRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.is_open = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.is_open = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(SetAutoTranslateGlobalSwitchRequest r100) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.is_open) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetAutoTranslateGlobalSwitchRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetAutoTranslateGlobalSwitchRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetAutoTranslateGlobalSwitchRequest r101) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.is_open);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetAutoTranslateGlobalSwitchRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SetAutoTranslateGlobalSwitchRequest r100 = new ProtoAdapter_SetAutoTranslateGlobalSwitchRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_IS_OPEN = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_open = this.is_open;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetAutoTranslateGlobalSwitchRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetAutoTranslateGlobalSwitchRequest(Boolean r100) {
        this(r100, ByteString.EMPTY);
    }

    public SetAutoTranslateGlobalSwitchRequest(Boolean r100, ByteString r101) {
        super(ADAPTER, r101);
        this.is_open = r100;
    }
}
