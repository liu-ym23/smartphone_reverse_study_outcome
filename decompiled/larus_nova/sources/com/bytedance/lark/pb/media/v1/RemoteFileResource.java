package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class RemoteFileResource extends Message<RemoteFileResource, Builder> {
    public static final ProtoAdapter<RemoteFileResource> ADAPTER = null;
    public static final String DEFAULT_FS_UNIT = "";
    public static final DownloadFileScene DEFAULT_SCENE = null;
    private static final long serialVersionUID = 0;
    public final String fs_unit;
    public final DownloadFileOptions options;
    public final DownloadFileScene scene;

    public static final class Builder extends Message.Builder<RemoteFileResource, Builder> {
        public String fs_unit;
        public DownloadFileOptions options;
        public DownloadFileScene scene;

        @Override // com.squareup.wire.Message.Builder
        public RemoteFileResource build() {
            String r100 = this.fs_unit;
            if (r100 == null) goto L7;
            return new RemoteFileResource(this.fs_unit, this.scene, this.options, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "fs_unit"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder fs_unit(String r100) {
            this.fs_unit = r100;
            return this;
        }

        public Builder options(DownloadFileOptions r100) {
            this.options = r100;
            return this;
        }

        public Builder scene(DownloadFileScene r100) {
            this.scene = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RemoteFileResource extends ProtoAdapter<RemoteFileResource> {
        public ProtoAdapter_RemoteFileResource() {
            super(FieldEncoding.LENGTH_DELIMITED, RemoteFileResource.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RemoteFileResource decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.fs_unit = "";
            r101.scene = DownloadFileScene.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.fs_unit = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 4) goto L10;
            r101.scene = DownloadFileScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 5) goto L11;
            r101.options = DownloadFileOptions.ADAPTER.decode(r100);
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
        public int encodedSize2(RemoteFileResource r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.fs_unit);
            DownloadFileScene r102 = r100.scene;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = DownloadFileScene.ADAPTER.encodedSizeWithTag(4, r102);
        L6:
            int r105 = r101 + r104;
            DownloadFileOptions r106 = r100.options;
            if (r106 == null) goto L10;
            r103 = DownloadFileOptions.ADAPTER.encodedSizeWithTag(5, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RemoteFileResource decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RemoteFileResource r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RemoteFileResource r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.fs_unit);
            DownloadFileScene r102 = r101.scene;
            if (r102 == null) goto L5;
            DownloadFileScene.ADAPTER.encodeWithTag(r100, 4, r102);
        L5:
            DownloadFileOptions r103 = r101.options;
            if (r103 == null) goto L8;
            DownloadFileOptions.ADAPTER.encodeWithTag(r100, 5, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RemoteFileResource r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RemoteFileResource();
        DEFAULT_SCENE = DownloadFileScene.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.fs_unit = this.fs_unit;
        r100.scene = this.scene;
        r100.options = this.options;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RemoteFileResource.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public RemoteFileResource(String r100, DownloadFileScene r101, DownloadFileOptions r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public RemoteFileResource(String r100, DownloadFileScene r101, DownloadFileOptions r102, ByteString r103) {
        super(ADAPTER, r103);
        this.fs_unit = r100;
        this.scene = r101;
        this.options = r102;
    }
}
