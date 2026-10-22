package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class TagInfo extends com.squareup.wire.Message<TagInfo, Builder> {
    public static final ProtoAdapter<TagInfo> ADAPTER = null;
    public static final Boolean DEFAULT_IS_SHOW_TAG = null;
    private static final long serialVersionUID = 0;
    public final Boolean mis_show_tag;
    public final TagColor mtag_color;

    public static final class Builder extends com.squareup.wire.Message.Builder<TagInfo, Builder> {
        public Boolean mis_show_tag;
        public TagColor mtag_color;

        @Override // com.squareup.wire.Message.Builder
        public TagInfo build() {
            return new TagInfo(this.mis_show_tag, this.mtag_color, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder is_show_tag(Boolean r100) {
            this.mis_show_tag = r100;
            return this;
        }

        public Builder tag_color(TagColor r100) {
            this.mtag_color = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TagInfo extends ProtoAdapter<TagInfo> {
        public ProtoAdapter_TagInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, TagInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TagInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mis_show_tag = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mis_show_tag = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mtag_color = TagColor.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TagInfo r100) {
            Boolean r101 = r100.mis_show_tag;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            TagColor r104 = r100.mtag_color;
            if (r104 == null) goto L10;
            r102 = TagColor.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TagInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TagInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TagInfo r101) throws IOException {
            Boolean r102 = r101.mis_show_tag;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            TagColor r103 = r101.mtag_color;
            if (r103 == null) goto L8;
            TagColor.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TagInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TagInfo();
        DEFAULT_IS_SHOW_TAG = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mis_show_tag = this.mis_show_tag;
        r100.mtag_color = this.mtag_color;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TagInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TagInfo(Boolean r100, TagColor r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TagInfo(Boolean r100, TagColor r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mis_show_tag = r100;
        this.mtag_color = r101;
    }
}
