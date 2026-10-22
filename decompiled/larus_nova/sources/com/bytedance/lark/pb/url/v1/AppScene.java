package com.bytedance.lark.pb.url.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class AppScene extends Message<AppScene, Builder> {
    public static final ProtoAdapter<AppScene> ADAPTER = null;
    public static final String DEFAULT_BASE_CTX = "";
    public static final String DEFAULT_SOURCE_ID = "";
    public static final Long DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String base_ctx;
    public final String source_id;
    public final Long type;

    public static final class Builder extends Message.Builder<AppScene, Builder> {
        public String base_ctx;
        public String source_id;
        public Long type;

        @Override // com.squareup.wire.Message.Builder
        public AppScene build() {
            Long r100 = this.type;
            if (r100 == null) goto L7;
            return new AppScene(this.type, this.source_id, this.base_ctx, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder base_ctx(String r100) {
            this.base_ctx = r100;
            return this;
        }

        public Builder source_id(String r100) {
            this.source_id = r100;
            return this;
        }

        public Builder type(Long r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AppScene extends ProtoAdapter<AppScene> {
        public ProtoAdapter_AppScene() {
            super(FieldEncoding.LENGTH_DELIMITED, AppScene.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AppScene decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = 0L;
            r101.source_id = "";
            r101.base_ctx = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.type = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.base_ctx = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(AppScene r100) {
            int r101 = ProtoAdapter.INT64.encodedSizeWithTag(1, r100.type);
            String r102 = r100.source_id;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            String r106 = r100.base_ctx;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AppScene decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AppScene r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AppScene r101) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.type);
            String r102 = r101.source_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            String r103 = r101.base_ctx;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AppScene r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AppScene();
        DEFAULT_TYPE = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.source_id = this.source_id;
        r100.base_ctx = this.base_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AppScene.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AppScene(Long r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public AppScene(Long r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.type = r100;
        this.source_id = r101;
        this.base_ctx = r102;
    }
}
