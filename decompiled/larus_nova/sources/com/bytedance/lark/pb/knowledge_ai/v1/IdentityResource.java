package com.bytedance.lark.pb.knowledge_ai.v1;

import com.bytedance.lark.pb.basic.v1.ImageSetPassThrough;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class IdentityResource extends Message<IdentityResource, Builder> {
    public static final ProtoAdapter<IdentityResource> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, ImageSetPassThrough> images;

    public static final class Builder extends Message.Builder<IdentityResource, Builder> {
        public Map<String, ImageSetPassThrough> images;

        @Override // com.squareup.wire.Message.Builder
        public IdentityResource build() {
            return new IdentityResource(this.images, super.buildUnknownFields());
        }

        public Builder() {
            this.images = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder images(Map<String, ImageSetPassThrough> r100) {
            Internal.checkElementsNotNull(r100);
            this.images = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_IdentityResource extends ProtoAdapter<IdentityResource> {
        private final ProtoAdapter<Map<String, ImageSetPassThrough>> images;

        public ProtoAdapter_IdentityResource() {
            super(FieldEncoding.LENGTH_DELIMITED, IdentityResource.class);
            this.images = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ImageSetPassThrough.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public IdentityResource decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.images.putAll(this.images.decode(r100));
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
        public int encodedSize2(IdentityResource r100) {
            return this.images.encodedSizeWithTag(1, r100.images) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ IdentityResource decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(IdentityResource r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, IdentityResource r101) throws IOException {
            this.images.encodeWithTag(r100, 1, r101.images);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, IdentityResource r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_IdentityResource();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.images = Internal.copyOf("images", this.images);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return IdentityResource.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public IdentityResource(Map<String, ImageSetPassThrough> r100) {
        this(r100, ByteString.EMPTY);
    }

    public IdentityResource(Map<String, ImageSetPassThrough> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.images = Internal.immutableCopyOf("images", r100);
    }
}
