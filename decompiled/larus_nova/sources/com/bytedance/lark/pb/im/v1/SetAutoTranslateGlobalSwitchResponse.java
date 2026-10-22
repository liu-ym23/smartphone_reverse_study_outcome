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
public final class SetAutoTranslateGlobalSwitchResponse extends Message<SetAutoTranslateGlobalSwitchResponse, Builder> {
    public static final ProtoAdapter<SetAutoTranslateGlobalSwitchResponse> ADAPTER = null;
    public static final ProtoAdapter_SetAutoTranslateGlobalSwitchResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<SetAutoTranslateGlobalSwitchResponse, Builder> implements d<SetAutoTranslateGlobalSwitchResponse> {
        @Override // com.squareup.wire.Message.Builder
        public SetAutoTranslateGlobalSwitchResponse build() {
            return new SetAutoTranslateGlobalSwitchResponse(super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }
    }

    public static final class ProtoAdapter_SetAutoTranslateGlobalSwitchResponse extends ProtoAdapter<SetAutoTranslateGlobalSwitchResponse> implements c<SetAutoTranslateGlobalSwitchResponse> {
        public ProtoAdapter_SetAutoTranslateGlobalSwitchResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SetAutoTranslateGlobalSwitchResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetAutoTranslateGlobalSwitchResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L6;
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L6:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SetAutoTranslateGlobalSwitchResponse r100) {
            return r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetAutoTranslateGlobalSwitchResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetAutoTranslateGlobalSwitchResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetAutoTranslateGlobalSwitchResponse r101) throws IOException {
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetAutoTranslateGlobalSwitchResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SetAutoTranslateGlobalSwitchResponse r100 = new ProtoAdapter_SetAutoTranslateGlobalSwitchResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    public SetAutoTranslateGlobalSwitchResponse() {
        this(ByteString.EMPTY);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetAutoTranslateGlobalSwitchResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetAutoTranslateGlobalSwitchResponse(ByteString r100) {
        super(ADAPTER, r100);
    }
}
