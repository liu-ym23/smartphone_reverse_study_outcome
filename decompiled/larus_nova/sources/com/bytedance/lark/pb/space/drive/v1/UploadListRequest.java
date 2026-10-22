package com.bytedance.lark.pb.space.drive.v1;

import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
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
public final class UploadListRequest extends Message<UploadListRequest, Builder> {
    public static final ProtoAdapter<UploadListRequest> ADAPTER = null;
    public static final Boolean DEFAULT_FOR_PROGRESS = null;
    public static final String DEFAULT_MOUNT_NODE_TOKEN = "";
    public static final UploadScene DEFAULT_SCENE = null;
    public static final ProtoAdapter_UploadListRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean for_progress;
    public final String mount_node_token;
    public final UploadScene scene;

    public static final class Builder extends Message.Builder<UploadListRequest, Builder> implements d<UploadListRequest> {
        public Boolean for_progress;
        public String mount_node_token;
        public UploadScene scene;

        @Override // com.squareup.wire.Message.Builder
        public UploadListRequest build() {
            String r100 = this.mount_node_token;
            if (r100 == null) goto L7;
            return new UploadListRequest(this.mount_node_token, this.for_progress, this.scene, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, DrivePreviewOpenItem.EXTRA_MOUNT_NODE_TOKEN});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder for_progress(Boolean r100) {
            this.for_progress = r100;
            return this;
        }

        public Builder mount_node_token(String r100) {
            this.mount_node_token = r100;
            return this;
        }

        public Builder scene(UploadScene r100) {
            this.scene = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UploadListRequest extends ProtoAdapter<UploadListRequest> implements c<UploadListRequest> {
        public ProtoAdapter_UploadListRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UploadListRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UploadListRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mount_node_token = "";
            r101.for_progress = Boolean.FALSE;
            r101.scene = UploadScene.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mount_node_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.for_progress = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.scene = UploadScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UploadListRequest r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.mount_node_token);
            Boolean r102 = r100.for_progress;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            UploadScene r106 = r100.scene;
            if (r106 == null) goto L10;
            r103 = UploadScene.ADAPTER.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UploadListRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UploadListRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UploadListRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.mount_node_token);
            Boolean r102 = r101.for_progress;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            UploadScene r103 = r101.scene;
            if (r103 == null) goto L8;
            UploadScene.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UploadListRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UploadListRequest r100 = new ProtoAdapter_UploadListRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_FOR_PROGRESS = Boolean.FALSE;
        DEFAULT_SCENE = UploadScene.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mount_node_token = this.mount_node_token;
        r100.for_progress = this.for_progress;
        r100.scene = this.scene;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UploadListRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UploadListRequest(String r100, Boolean r101, UploadScene r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public UploadListRequest(String r100, Boolean r101, UploadScene r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mount_node_token = r100;
        this.for_progress = r101;
        this.scene = r102;
    }
}
