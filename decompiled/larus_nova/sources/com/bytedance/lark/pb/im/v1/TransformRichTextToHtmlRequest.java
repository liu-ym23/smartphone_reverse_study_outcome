package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.RichText;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class TransformRichTextToHtmlRequest extends Message<TransformRichTextToHtmlRequest, Builder> {
    public static final ProtoAdapter<TransformRichTextToHtmlRequest> ADAPTER = null;
    public static final ProtoAdapter_TransformRichTextToHtmlRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<ResourceExtraInfo> extra_infos;
    public final RichText rich_text;

    public static final class Builder extends Message.Builder<TransformRichTextToHtmlRequest, Builder> implements d<TransformRichTextToHtmlRequest> {
        public List<ResourceExtraInfo> extra_infos;
        public RichText rich_text;

        @Override // com.squareup.wire.Message.Builder
        public TransformRichTextToHtmlRequest build() {
            return new TransformRichTextToHtmlRequest(this.rich_text, this.extra_infos, super.buildUnknownFields());
        }

        public Builder() {
            this.extra_infos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder extra_infos(List<ResourceExtraInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.extra_infos = r100;
            return this;
        }

        public Builder rich_text(RichText r100) {
            this.rich_text = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TransformRichTextToHtmlRequest extends ProtoAdapter<TransformRichTextToHtmlRequest> implements c<TransformRichTextToHtmlRequest> {
        public ProtoAdapter_TransformRichTextToHtmlRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, TransformRichTextToHtmlRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TransformRichTextToHtmlRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.rich_text = RichText.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.extra_infos.add(ResourceExtraInfo.ADAPTER.decode(r100));
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
        public int encodedSize2(TransformRichTextToHtmlRequest r100) {
            RichText r101 = r100.rich_text;
            if (r101 == null) goto L5;
            int r102 = RichText.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + ResourceExtraInfo.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.extra_infos)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TransformRichTextToHtmlRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TransformRichTextToHtmlRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TransformRichTextToHtmlRequest r101) throws IOException {
            RichText r102 = r101.rich_text;
            if (r102 == null) goto L5;
            RichText.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ResourceExtraInfo.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.extra_infos);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TransformRichTextToHtmlRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_TransformRichTextToHtmlRequest r100 = new ProtoAdapter_TransformRichTextToHtmlRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.rich_text = this.rich_text;
        r100.extra_infos = Internal.copyOf("extra_infos", this.extra_infos);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TransformRichTextToHtmlRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TransformRichTextToHtmlRequest(RichText r100, List<ResourceExtraInfo> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TransformRichTextToHtmlRequest(RichText r100, List<ResourceExtraInfo> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.rich_text = r100;
        this.extra_infos = Internal.immutableCopyOf("extra_infos", r101);
    }
}
