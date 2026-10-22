package com.bytedance.lark.pb.url.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetTempPreviewByBatchRequest extends Message<GetTempPreviewByBatchRequest, Builder> {
    public static final ProtoAdapter<GetTempPreviewByBatchRequest> ADAPTER = null;
    public static final Long DEFAULT_APP_ID = null;
    public static final ProtoAdapter_GetTempPreviewByBatchRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long app_id;
    public final AppScene app_scene;
    public final List<String> urls;

    public static final class Builder extends Message.Builder<GetTempPreviewByBatchRequest, Builder> implements d<GetTempPreviewByBatchRequest> {
        public Long app_id;
        public AppScene app_scene;
        public List<String> urls;

        @Override // com.squareup.wire.Message.Builder
        public GetTempPreviewByBatchRequest build() {
            Long r100 = this.app_id;
            if (r100 == null) goto L9;
            if (this.app_scene == null) goto L9;
            return new GetTempPreviewByBatchRequest(this.app_id, this.urls, this.app_scene, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "app_id", this.app_scene, "app_scene"});
        }

        public Builder() {
            this.urls = Internal.newMutableList();
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

        public Builder urls(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.urls = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetTempPreviewByBatchRequest extends ProtoAdapter<GetTempPreviewByBatchRequest> implements c<GetTempPreviewByBatchRequest> {
        public ProtoAdapter_GetTempPreviewByBatchRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTempPreviewByBatchRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetTempPreviewByBatchRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.app_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.app_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.urls.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(GetTempPreviewByBatchRequest r100) {
            return ((ProtoAdapter.INT64.encodedSizeWithTag(1, r100.app_id) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.urls)) + AppScene.ADAPTER.encodedSizeWithTag(3, r100.app_scene)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTempPreviewByBatchRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetTempPreviewByBatchRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetTempPreviewByBatchRequest r101) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.app_id);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.urls);
            AppScene.ADAPTER.encodeWithTag(r100, 3, r101.app_scene);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetTempPreviewByBatchRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetTempPreviewByBatchRequest r100 = new ProtoAdapter_GetTempPreviewByBatchRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_APP_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.app_id = this.app_id;
        r100.urls = Internal.copyOf("urls", this.urls);
        r100.app_scene = this.app_scene;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetTempPreviewByBatchRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetTempPreviewByBatchRequest(Long r100, List<String> r101, AppScene r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetTempPreviewByBatchRequest(Long r100, List<String> r101, AppScene r102, ByteString r103) {
        super(ADAPTER, r103);
        this.app_id = r100;
        this.urls = Internal.immutableCopyOf("urls", r101);
        this.app_scene = r102;
    }
}
