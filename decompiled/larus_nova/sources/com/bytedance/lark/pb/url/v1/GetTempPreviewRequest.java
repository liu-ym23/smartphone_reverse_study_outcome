package com.bytedance.lark.pb.url.v1;

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
public final class GetTempPreviewRequest extends Message<GetTempPreviewRequest, Builder> {
    public static final ProtoAdapter<GetTempPreviewRequest> ADAPTER = null;
    public static final Long DEFAULT_APP_ID = null;
    public static final String DEFAULT_URL = "";
    public static final ProtoAdapter_GetTempPreviewRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long app_id;
    public final AppScene app_scene;
    public final String url;

    public static final class Builder extends Message.Builder<GetTempPreviewRequest, Builder> implements d<GetTempPreviewRequest> {
        public Long app_id;
        public AppScene app_scene;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public GetTempPreviewRequest build() {
            Long r100 = this.app_id;
            if (r100 == null) goto L11;
            if (this.url == null) goto L11;
            if (this.app_scene == null) goto L11;
            return new GetTempPreviewRequest(this.app_id, this.url, this.app_scene, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "app_id", this.url, "url", this.app_scene, "app_scene"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_id(Long r100) {
            this.app_id = r100;
            return this;
        }

        public Builder app_scene(AppScene r100) {
            this.app_scene = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetTempPreviewRequest extends ProtoAdapter<GetTempPreviewRequest> implements c<GetTempPreviewRequest> {
        public ProtoAdapter_GetTempPreviewRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTempPreviewRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetTempPreviewRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.app_id = 0L;
            r101.url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.app_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.app_scene = AppScene.ADAPTER.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetTempPreviewRequest r100) {
            return ((ProtoAdapter.INT64.encodedSizeWithTag(1, r100.app_id) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.url)) + AppScene.ADAPTER.encodedSizeWithTag(3, r100.app_scene)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTempPreviewRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetTempPreviewRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetTempPreviewRequest r101) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.app_id);
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.url);
            AppScene.ADAPTER.encodeWithTag(r100, 3, r101.app_scene);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetTempPreviewRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetTempPreviewRequest r100 = new ProtoAdapter_GetTempPreviewRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_APP_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.app_id = this.app_id;
        r100.url = this.url;
        r100.app_scene = this.app_scene;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetTempPreviewRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetTempPreviewRequest(Long r100, String r101, AppScene r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetTempPreviewRequest(Long r100, String r101, AppScene r102, ByteString r103) {
        super(ADAPTER, r103);
        this.app_id = r100;
        this.url = r101;
        this.app_scene = r102;
    }
}
