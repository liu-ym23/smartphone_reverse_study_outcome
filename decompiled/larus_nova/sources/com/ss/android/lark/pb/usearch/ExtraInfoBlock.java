package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ExtraInfoBlock extends Message<ExtraInfoBlock, Builder> {
    public static final ProtoAdapter<ExtraInfoBlock> ADAPTER = null;
    public static final Boolean DEFAULT_IS_NEED_HOVER = null;
    public static final String DEFAULT_SEGMENT_SEPARATOR = "";
    private static final long serialVersionUID = 0;
    public final ExtraInfoBlockIcon mblock_icon;
    public final List<ExtraInfoBlockSegment> mblock_segments;
    public final Boolean mis_need_hover;
    public final String msegment_separator;

    public static final class Builder extends Message.Builder<ExtraInfoBlock, Builder> {
        public ExtraInfoBlockIcon mblock_icon;
        public List<ExtraInfoBlockSegment> mblock_segments;
        public Boolean mis_need_hover;
        public String msegment_separator;

        @Override // com.squareup.wire.Message.Builder
        public ExtraInfoBlock build() {
            return new ExtraInfoBlock(this.mblock_segments, this.msegment_separator, this.mblock_icon, this.mis_need_hover, super.buildUnknownFields());
        }

        public Builder() {
            this.mblock_segments = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder block_icon(ExtraInfoBlockIcon r100) {
            this.mblock_icon = r100;
            return this;
        }

        public Builder block_segments(List<ExtraInfoBlockSegment> r100) {
            Internal.checkElementsNotNull(r100);
            this.mblock_segments = r100;
            return this;
        }

        public Builder is_need_hover(Boolean r100) {
            this.mis_need_hover = r100;
            return this;
        }

        public Builder segment_separator(String r100) {
            this.msegment_separator = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ExtraInfoBlock extends ProtoAdapter<ExtraInfoBlock> {
        public ProtoAdapter_ExtraInfoBlock() {
            super(FieldEncoding.LENGTH_DELIMITED, ExtraInfoBlock.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ExtraInfoBlock decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.msegment_separator = "";
            r101.mis_need_hover = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mblock_segments.add(ExtraInfoBlockSegment.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.msegment_separator = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mblock_icon = ExtraInfoBlockIcon.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mis_need_hover = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(ExtraInfoBlock r100) {
            int r101 = ExtraInfoBlockSegment.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mblock_segments);
            String r102 = r100.msegment_separator;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            ExtraInfoBlockIcon r106 = r100.mblock_icon;
            if (r106 == null) goto L9;
            int r107 = ExtraInfoBlockIcon.ADAPTER.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            Boolean r109 = r100.mis_need_hover;
            if (r109 == null) goto L14;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ExtraInfoBlock decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ExtraInfoBlock r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ExtraInfoBlock r101) throws IOException {
            ExtraInfoBlockSegment.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mblock_segments);
            String r102 = r101.msegment_separator;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            ExtraInfoBlockIcon r103 = r101.mblock_icon;
            if (r103 == null) goto L8;
            ExtraInfoBlockIcon.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            Boolean r104 = r101.mis_need_hover;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExtraInfoBlock r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ExtraInfoBlock();
        DEFAULT_IS_NEED_HOVER = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mblock_segments = Internal.copyOf("mblock_segments", this.mblock_segments);
        r100.msegment_separator = this.msegment_separator;
        r100.mblock_icon = this.mblock_icon;
        r100.mis_need_hover = this.mis_need_hover;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ExtraInfoBlock.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ExtraInfoBlock(List<ExtraInfoBlockSegment> r100, String r101, ExtraInfoBlockIcon r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public ExtraInfoBlock(List<ExtraInfoBlockSegment> r100, String r101, ExtraInfoBlockIcon r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mblock_segments = Internal.immutableCopyOf("mblock_segments", r100);
        this.msegment_separator = r101;
        this.mblock_icon = r102;
        this.mis_need_hover = r103;
    }
}
