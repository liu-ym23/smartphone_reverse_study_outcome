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
public final class ResumeAllUploadRequest extends Message<ResumeAllUploadRequest, Builder> {
    public static final ProtoAdapter<ResumeAllUploadRequest> ADAPTER = null;
    public static final UploadScene DEFAULT_SCENE = null;
    public static final Boolean DEFAULT_WITH_FAILED = null;
    public static final ProtoAdapter_ResumeAllUploadRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final UploadScene scene;
    public final Boolean with_failed;

    public static final class Builder extends Message.Builder<ResumeAllUploadRequest, Builder> implements d<ResumeAllUploadRequest> {
        public UploadScene scene;
        public Boolean with_failed;

        @Override // com.squareup.wire.Message.Builder
        public ResumeAllUploadRequest build() {
            return new ResumeAllUploadRequest(this.with_failed, this.scene, super.buildUnknownFields());
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

        public Builder with_failed(Boolean r100) {
            this.with_failed = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ResumeAllUploadRequest extends ProtoAdapter<ResumeAllUploadRequest> implements c<ResumeAllUploadRequest> {
        public ProtoAdapter_ResumeAllUploadRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, ResumeAllUploadRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ResumeAllUploadRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.with_failed = Boolean.FALSE;
            r101.scene = UploadScene.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.with_failed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.scene = UploadScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ResumeAllUploadRequest r100) {
            Boolean r101 = r100.with_failed;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            UploadScene r104 = r100.scene;
            if (r104 == null) goto L10;
            r102 = UploadScene.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ResumeAllUploadRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ResumeAllUploadRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ResumeAllUploadRequest r101) throws IOException {
            Boolean r102 = r101.with_failed;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            UploadScene r103 = r101.scene;
            if (r103 == null) goto L8;
            UploadScene.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ResumeAllUploadRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_ResumeAllUploadRequest r100 = new ProtoAdapter_ResumeAllUploadRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_WITH_FAILED = Boolean.FALSE;
        DEFAULT_SCENE = UploadScene.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.with_failed = this.with_failed;
        r100.scene = this.scene;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ResumeAllUploadRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ResumeAllUploadRequest(Boolean r100, UploadScene r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ResumeAllUploadRequest(Boolean r100, UploadScene r101, ByteString r102) {
        super(ADAPTER, r102);
        this.with_failed = r100;
        this.scene = r101;
    }
}
