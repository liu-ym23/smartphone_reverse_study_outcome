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
public final class Resource extends Message<Resource, Builder> {
    public static final ProtoAdapter<Resource> ADAPTER = null;
    public static final Boolean DEFAULT_IS_ENCRYPTED = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_PATH = "";
    private static final long serialVersionUID = 0;
    public final Boolean is_encrypted;
    public final String key;
    public final String path;

    public static final class Builder extends Message.Builder<Resource, Builder> {
        public Boolean is_encrypted;
        public String key;
        public String path;

        @Override // com.squareup.wire.Message.Builder
        public Resource build() {
            String r100 = this.key;
            if (r100 == null) goto L9;
            if (this.path == null) goto L9;
            return new Resource(this.key, this.path, this.is_encrypted, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "key", this.path, "path"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_encrypted(Boolean r100) {
            this.is_encrypted = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder path(String r100) {
            this.path = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Resource extends ProtoAdapter<Resource> {
        public ProtoAdapter_Resource() {
            super(FieldEncoding.LENGTH_DELIMITED, Resource.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Resource decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            r101.path = "";
            r101.is_encrypted = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.is_encrypted = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(Resource r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.key) + r101.encodedSizeWithTag(2, r100.path);
            Boolean r103 = r100.is_encrypted;
            if (r103 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Resource decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Resource r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Resource r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.key);
            r102.encodeWithTag(r100, 2, r101.path);
            Boolean r103 = r101.is_encrypted;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Resource r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Resource();
        DEFAULT_IS_ENCRYPTED = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.path = this.path;
        r100.is_encrypted = this.is_encrypted;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Resource.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Resource(String r100, String r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public Resource(String r100, String r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.key = r100;
        this.path = r101;
        this.is_encrypted = r102;
    }
}
