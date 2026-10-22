package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ContentAlign extends Message<ContentAlign, Builder> {
    public static final ProtoAdapter<ContentAlign> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ContentAlignType micon_align;
    public final ContentAlignType mlink_icon_align;
    public final ContentAlignType mname_align;

    public static final class Builder extends Message.Builder<ContentAlign, Builder> {
        public ContentAlignType micon_align;
        public ContentAlignType mlink_icon_align;
        public ContentAlignType mname_align;

        @Override // com.squareup.wire.Message.Builder
        public ContentAlign build() {
            return new ContentAlign(this.micon_align, this.mname_align, this.mlink_icon_align, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder icon_align(ContentAlignType r100) {
            this.micon_align = r100;
            return this;
        }

        public Builder link_icon_align(ContentAlignType r100) {
            this.mlink_icon_align = r100;
            return this;
        }

        public Builder name_align(ContentAlignType r100) {
            this.mname_align = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ContentAlign extends ProtoAdapter<ContentAlign> {
        public ProtoAdapter_ContentAlign() {
            super(FieldEncoding.LENGTH_DELIMITED, ContentAlign.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ContentAlign decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.micon_align = ContentAlignType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mname_align = ContentAlignType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mlink_icon_align = ContentAlignType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ContentAlign r100) {
            ContentAlignType r101 = r100.micon_align;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ContentAlignType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            ContentAlignType r104 = r100.mname_align;
            if (r104 == null) goto L9;
            int r105 = ContentAlignType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ContentAlignType r107 = r100.mlink_icon_align;
            if (r107 == null) goto L14;
            r102 = ContentAlignType.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ContentAlign decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ContentAlign r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ContentAlign r101) throws IOException {
            ContentAlignType r102 = r101.micon_align;
            if (r102 == null) goto L5;
            ContentAlignType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ContentAlignType r103 = r101.mname_align;
            if (r103 == null) goto L8;
            ContentAlignType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            ContentAlignType r104 = r101.mlink_icon_align;
            if (r104 == null) goto L11;
            ContentAlignType.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ContentAlign r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ContentAlign();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.micon_align = this.micon_align;
        r100.mname_align = this.mname_align;
        r100.mlink_icon_align = this.mlink_icon_align;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ContentAlign.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ContentAlign(ContentAlignType r100, ContentAlignType r101, ContentAlignType r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ContentAlign(ContentAlignType r100, ContentAlignType r101, ContentAlignType r102, ByteString r103) {
        super(ADAPTER, r103);
        this.micon_align = r100;
        this.mname_align = r101;
        this.mlink_icon_align = r102;
    }
}
