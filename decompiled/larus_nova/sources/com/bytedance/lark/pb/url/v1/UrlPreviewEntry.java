package com.bytedance.lark.pb.url.v1;

import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class UrlPreviewEntry extends Message<UrlPreviewEntry, Builder> {
    public static final ProtoAdapter<UrlPreviewEntry> ADAPTER = null;
    public static final Integer DEFAULT_LENGTH = null;
    public static final Integer DEFAULT_OFFSET = null;
    public static final String DEFAULT_PREVIEW_ID = "";
    private static final long serialVersionUID = 0;
    public final Integer length;
    public final Integer offset;
    public final UrlPreviewEntity preview_entity;
    public final String preview_id;

    public static final class Builder extends Message.Builder<UrlPreviewEntry, Builder> {
        public Integer length;
        public Integer offset;
        public UrlPreviewEntity preview_entity;
        public String preview_id;

        @Override // com.squareup.wire.Message.Builder
        public UrlPreviewEntry build() {
            return new UrlPreviewEntry(this.offset, this.length, this.preview_id, this.preview_entity, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder length(Integer r100) {
            this.length = r100;
            return this;
        }

        public Builder offset(Integer r100) {
            this.offset = r100;
            return this;
        }

        public Builder preview_entity(UrlPreviewEntity r100) {
            this.preview_entity = r100;
            return this;
        }

        public Builder preview_id(String r100) {
            this.preview_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UrlPreviewEntry extends ProtoAdapter<UrlPreviewEntry> {
        public ProtoAdapter_UrlPreviewEntry() {
            super(FieldEncoding.LENGTH_DELIMITED, UrlPreviewEntry.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UrlPreviewEntry decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.offset = 0;
            r101.length = 0;
            r101.preview_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.offset = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.length = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.preview_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.preview_entity = UrlPreviewEntity.ADAPTER.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UrlPreviewEntry r100) {
            Integer r101 = r100.offset;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.length;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.preview_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            UrlPreviewEntity r110 = r100.preview_entity;
            if (r110 == null) goto L18;
            r102 = UrlPreviewEntity.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UrlPreviewEntry decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UrlPreviewEntry r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UrlPreviewEntry r101) throws IOException {
            Integer r102 = r101.offset;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.length;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.preview_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            UrlPreviewEntity r105 = r101.preview_entity;
            if (r105 == null) goto L14;
            UrlPreviewEntity.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UrlPreviewEntry r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UrlPreviewEntry();
        DEFAULT_OFFSET = 0;
        DEFAULT_LENGTH = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.offset = this.offset;
        r100.length = this.length;
        r100.preview_id = this.preview_id;
        r100.preview_entity = this.preview_entity;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UrlPreviewEntry.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UrlPreviewEntry(Integer r100, Integer r101, String r102, UrlPreviewEntity r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public UrlPreviewEntry(Integer r100, Integer r101, String r102, UrlPreviewEntity r103, ByteString r104) {
        super(ADAPTER, r104);
        this.offset = r100;
        this.length = r101;
        this.preview_id = r102;
        this.preview_entity = r103;
    }
}
