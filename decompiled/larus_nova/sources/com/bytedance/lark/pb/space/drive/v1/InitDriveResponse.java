package com.bytedance.lark.pb.space.drive.v1;

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
public final class InitDriveResponse extends Message<InitDriveResponse, Builder> {
    public static final ProtoAdapter<InitDriveResponse> ADAPTER = null;
    public static final Boolean DEFAULT_RESULT = null;
    public static final ProtoAdapter_InitDriveResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean result;

    public static final class Builder extends Message.Builder<InitDriveResponse, Builder> implements d<InitDriveResponse> {
        public Boolean result;

        @Override // com.squareup.wire.Message.Builder
        public InitDriveResponse build() {
            Boolean r100 = this.result;
            if (r100 == null) goto L7;
            return new InitDriveResponse(this.result, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "result"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder result(Boolean r100) {
            this.result = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_InitDriveResponse extends ProtoAdapter<InitDriveResponse> implements c<InitDriveResponse> {
        public ProtoAdapter_InitDriveResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, InitDriveResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public InitDriveResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.result = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.result = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(InitDriveResponse r100) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.result) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ InitDriveResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(InitDriveResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, InitDriveResponse r101) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.result);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, InitDriveResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_InitDriveResponse r100 = new ProtoAdapter_InitDriveResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_RESULT = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.result = this.result;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return InitDriveResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public InitDriveResponse(Boolean r100) {
        this(r100, ByteString.EMPTY);
    }

    public InitDriveResponse(Boolean r100, ByteString r101) {
        super(ADAPTER, r101);
        this.result = r100;
    }
}
