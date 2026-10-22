package com.bytedance.lark.pb.space.drive.v1;

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
public final class CancelAllUploadRequest extends Message<CancelAllUploadRequest, Builder> {
    public static final ProtoAdapter<CancelAllUploadRequest> ADAPTER = null;
    public static final UploadScene DEFAULT_SCENE = null;
    public static final ProtoAdapter_CancelAllUploadRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final UploadScene scene;

    public static final class Builder extends Message.Builder<CancelAllUploadRequest, Builder> implements d<CancelAllUploadRequest> {
        public UploadScene scene;

        @Override // com.squareup.wire.Message.Builder
        public CancelAllUploadRequest build() {
            return new CancelAllUploadRequest(this.scene, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder scene(UploadScene r100) {
            this.scene = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CancelAllUploadRequest extends ProtoAdapter<CancelAllUploadRequest> implements c<CancelAllUploadRequest> {
        public ProtoAdapter_CancelAllUploadRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CancelAllUploadRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CancelAllUploadRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.scene = UploadScene.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.scene = UploadScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CancelAllUploadRequest r100) {
            UploadScene r101 = r100.scene;
            if (r101 == null) goto L5;
            int r102 = UploadScene.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CancelAllUploadRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CancelAllUploadRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CancelAllUploadRequest r101) throws IOException {
            UploadScene r102 = r101.scene;
            if (r102 == null) goto L5;
            UploadScene.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CancelAllUploadRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CancelAllUploadRequest r100 = new ProtoAdapter_CancelAllUploadRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SCENE = UploadScene.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.scene = this.scene;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CancelAllUploadRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CancelAllUploadRequest(UploadScene r100) {
        this(r100, ByteString.EMPTY);
    }

    public CancelAllUploadRequest(UploadScene r100, ByteString r101) {
        super(ADAPTER, r101);
        this.scene = r100;
    }
}
