package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class DoubaoResource extends com.squareup.wire.Message<DoubaoResource, Builder> {
    public static final ProtoAdapter<DoubaoResource> ADAPTER = null;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_STORAGE_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String name;
    public final Integer storage_type;

    public static final class Builder extends com.squareup.wire.Message.Builder<DoubaoResource, Builder> {
        public String name;
        public Integer storage_type;

        @Override // com.squareup.wire.Message.Builder
        public DoubaoResource build() {
            String r100 = this.name;
            if (r100 == null) goto L9;
            if (this.storage_type == null) goto L9;
            return new DoubaoResource(this.name, this.storage_type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "name", this.storage_type, "storage_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder storage_type(Integer r100) {
            this.storage_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DoubaoResource extends ProtoAdapter<DoubaoResource> {
        public ProtoAdapter_DoubaoResource() {
            super(FieldEncoding.LENGTH_DELIMITED, DoubaoResource.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DoubaoResource decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.name = "";
            r101.storage_type = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.storage_type = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(DoubaoResource r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.name) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.storage_type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DoubaoResource decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DoubaoResource r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DoubaoResource r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.name);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.storage_type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DoubaoResource r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DoubaoResource();
        DEFAULT_STORAGE_TYPE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.name = this.name;
        r100.storage_type = this.storage_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DoubaoResource.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public DoubaoResource(String r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DoubaoResource(String r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.name = r100;
        this.storage_type = r101;
    }
}
