package com.bytedance.lark.pb.media.v1;

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
public final class GetFileStateByUrlRequest extends Message<GetFileStateByUrlRequest, Builder> {
    public static final ProtoAdapter<GetFileStateByUrlRequest> ADAPTER = null;
    public static final DownloadFileScene DEFAULT_SCENE = null;
    public static final String DEFAULT_URL = "";
    public static final ProtoAdapter_GetFileStateByUrlRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DownloadFileScene scene;
    public final String url;

    public static final class Builder extends Message.Builder<GetFileStateByUrlRequest, Builder> implements d<GetFileStateByUrlRequest> {
        public DownloadFileScene scene;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public GetFileStateByUrlRequest build() {
            String r100 = this.url;
            if (r100 == null) goto L9;
            if (this.scene == null) goto L9;
            return new GetFileStateByUrlRequest(this.url, this.scene, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "url", this.scene, "scene"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder scene(DownloadFileScene r100) {
            this.scene = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetFileStateByUrlRequest extends ProtoAdapter<GetFileStateByUrlRequest> implements c<GetFileStateByUrlRequest> {
        public ProtoAdapter_GetFileStateByUrlRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetFileStateByUrlRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetFileStateByUrlRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.url = "";
            r101.scene = DownloadFileScene.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.scene = DownloadFileScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
        public int encodedSize2(GetFileStateByUrlRequest r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.url) + DownloadFileScene.ADAPTER.encodedSizeWithTag(2, r100.scene)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetFileStateByUrlRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetFileStateByUrlRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetFileStateByUrlRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.url);
            DownloadFileScene.ADAPTER.encodeWithTag(r100, 2, r101.scene);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetFileStateByUrlRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetFileStateByUrlRequest r100 = new ProtoAdapter_GetFileStateByUrlRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SCENE = DownloadFileScene.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.url = this.url;
        r100.scene = this.scene;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetFileStateByUrlRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetFileStateByUrlRequest(String r100, DownloadFileScene r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetFileStateByUrlRequest(String r100, DownloadFileScene r101, ByteString r102) {
        super(ADAPTER, r102);
        this.url = r100;
        this.scene = r101;
    }
}
