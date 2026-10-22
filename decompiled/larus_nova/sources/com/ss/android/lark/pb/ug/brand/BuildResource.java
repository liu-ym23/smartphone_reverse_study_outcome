package com.ss.android.lark.pb.ug.brand;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class BuildResource extends Message<BuildResource, Builder> {
    public static final ProtoAdapter<BuildResource> ADAPTER = null;
    public static final String DEFAULT_RESOURCE_URL = "";
    public static final String DEFAULT_TASK_ID = "";
    private static final long serialVersionUID = 0;
    public final Platform mplatform;
    public final String mresource_url;
    public final String mtask_id;

    public static final class Builder extends Message.Builder<BuildResource, Builder> {
        public Platform mplatform;
        public String mresource_url;
        public String mtask_id;

        @Override // com.squareup.wire.Message.Builder
        public BuildResource build() {
            String r100 = this.mresource_url;
            if (r100 == null) goto L11;
            if (this.mtask_id == null) goto L11;
            if (this.mplatform == null) goto L11;
            return new BuildResource(this.mresource_url, this.mtask_id, this.mplatform, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "mresource_url", this.mtask_id, "mtask_id", this.mplatform, "mplatform"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder platform(Platform r100) {
            this.mplatform = r100;
            return this;
        }

        public Builder resource_url(String r100) {
            this.mresource_url = r100;
            return this;
        }

        public Builder task_id(String r100) {
            this.mtask_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BuildResource extends ProtoAdapter<BuildResource> {
        public ProtoAdapter_BuildResource() {
            super(FieldEncoding.LENGTH_DELIMITED, BuildResource.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BuildResource decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mresource_url = "";
            r101.mtask_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mresource_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mtask_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mplatform = Platform.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
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
        public int encodedSize2(BuildResource r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((r101.encodedSizeWithTag(1, r100.mresource_url) + r101.encodedSizeWithTag(2, r100.mtask_id)) + Platform.ADAPTER.encodedSizeWithTag(3, r100.mplatform)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BuildResource decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BuildResource r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BuildResource r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mresource_url);
            r102.encodeWithTag(r100, 2, r101.mtask_id);
            Platform.ADAPTER.encodeWithTag(r100, 3, r101.mplatform);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BuildResource r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BuildResource();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mresource_url = this.mresource_url;
        r100.mtask_id = this.mtask_id;
        r100.mplatform = this.mplatform;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BuildResource.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BuildResource(String r100, String r101, Platform r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public BuildResource(String r100, String r101, Platform r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mresource_url = r100;
        this.mtask_id = r101;
        this.mplatform = r102;
    }
}
