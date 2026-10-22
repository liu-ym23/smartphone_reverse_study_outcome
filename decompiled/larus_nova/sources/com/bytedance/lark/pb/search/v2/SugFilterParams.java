package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SugFilterParams extends Message<SugFilterParams, Builder> {
    public static final ProtoAdapter<SugFilterParams> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<SugTextType> raw_text;
    public final List<SugRichTextType> rich_text;

    public static final class Builder extends Message.Builder<SugFilterParams, Builder> {
        public List<SugTextType> raw_text;
        public List<SugRichTextType> rich_text;

        @Override // com.squareup.wire.Message.Builder
        public SugFilterParams build() {
            return new SugFilterParams(this.raw_text, this.rich_text, super.buildUnknownFields());
        }

        public Builder() {
            this.raw_text = Internal.newMutableList();
            this.rich_text = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder raw_text(List<SugTextType> r100) {
            Internal.checkElementsNotNull(r100);
            this.raw_text = r100;
            return this;
        }

        public Builder rich_text(List<SugRichTextType> r100) {
            Internal.checkElementsNotNull(r100);
            this.rich_text = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SugFilterParams extends ProtoAdapter<SugFilterParams> {
        public ProtoAdapter_SugFilterParams() {
            super(FieldEncoding.LENGTH_DELIMITED, SugFilterParams.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SugFilterParams decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.raw_text.add(SugTextType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.rich_text.add(SugRichTextType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SugFilterParams r100) {
            return (SugTextType.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.raw_text) + SugRichTextType.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.rich_text)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SugFilterParams decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SugFilterParams r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SugFilterParams r101) throws IOException {
            SugTextType.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.raw_text);
            SugRichTextType.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.rich_text);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SugFilterParams r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SugFilterParams();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.raw_text = Internal.copyOf("raw_text", this.raw_text);
        r100.rich_text = Internal.copyOf("rich_text", this.rich_text);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SugFilterParams.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SugFilterParams(List<SugTextType> r100, List<SugRichTextType> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SugFilterParams(List<SugTextType> r100, List<SugRichTextType> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.raw_text = Internal.immutableCopyOf("raw_text", r100);
        this.rich_text = Internal.immutableCopyOf("rich_text", r101);
    }
}
