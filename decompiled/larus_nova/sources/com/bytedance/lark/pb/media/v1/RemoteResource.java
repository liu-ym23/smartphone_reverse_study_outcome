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
public final class RemoteResource extends Message<RemoteResource, Builder> {
    public static final ProtoAdapter<RemoteResource> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final RemoteFileResource file_resource;
    public final RemoteResourceWithFsUnit resource_with_fs_unit;

    public static final class Builder extends Message.Builder<RemoteResource, Builder> {
        public RemoteFileResource file_resource;
        public RemoteResourceWithFsUnit resource_with_fs_unit;

        @Override // com.squareup.wire.Message.Builder
        public RemoteResource build() {
            return new RemoteResource(this.resource_with_fs_unit, this.file_resource, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder file_resource(RemoteFileResource r100) {
            this.file_resource = r100;
            this.resource_with_fs_unit = null;
            return this;
        }

        public Builder resource_with_fs_unit(RemoteResourceWithFsUnit r100) {
            this.resource_with_fs_unit = r100;
            this.file_resource = null;
            return this;
        }
    }

    public static final class ProtoAdapter_RemoteResource extends ProtoAdapter<RemoteResource> {
        public ProtoAdapter_RemoteResource() {
            super(FieldEncoding.LENGTH_DELIMITED, RemoteResource.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RemoteResource decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.resource_with_fs_unit(RemoteResourceWithFsUnit.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.file_resource(RemoteFileResource.ADAPTER.decode(r100));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(RemoteResource r100) {
            RemoteResourceWithFsUnit r101 = r100.resource_with_fs_unit;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = RemoteResourceWithFsUnit.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            RemoteFileResource r104 = r100.file_resource;
            if (r104 == null) goto L10;
            r102 = RemoteFileResource.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RemoteResource decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RemoteResource r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RemoteResource r101) throws IOException {
            RemoteResourceWithFsUnit r102 = r101.resource_with_fs_unit;
            if (r102 == null) goto L5;
            RemoteResourceWithFsUnit.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            RemoteFileResource r103 = r101.file_resource;
            if (r103 == null) goto L8;
            RemoteFileResource.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RemoteResource r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RemoteResource();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.resource_with_fs_unit = this.resource_with_fs_unit;
        r100.file_resource = this.file_resource;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RemoteResource.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public RemoteResource(RemoteResourceWithFsUnit r100, RemoteFileResource r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public RemoteResource(RemoteResourceWithFsUnit r100, RemoteFileResource r101, ByteString r102) {
        super(ADAPTER, r102);
        if (Internal.countNonNull(r100, r101) > 1) goto L7;
        this.resource_with_fs_unit = r100;
        this.file_resource = r101;
        return;
    L7:
        throw new IllegalArgumentException("at most one of resource_with_fs_unit, file_resource may be non-null");
    }
}
