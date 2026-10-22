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

/* JADX INFO: loaded from: classes20.dex */
public final class ASRTextResult extends Message<ASRTextResult, Builder> {
    public static final ProtoAdapter<ASRTextResult> ADAPTER = null;
    public static final String DEFAULT_RESULT = "";
    private static final long serialVersionUID = 0;
    public final List<NERInfo> ner_info;
    public final String result;
    public final RichText rich_text_result;

    public static final class Builder extends Message.Builder<ASRTextResult, Builder> {
        public List<NERInfo> ner_info;
        public String result;
        public RichText rich_text_result;

        @Override // com.squareup.wire.Message.Builder
        public ASRTextResult build() {
            return new ASRTextResult(this.result, this.ner_info, this.rich_text_result, super.buildUnknownFields());
        }

        public Builder() {
            this.ner_info = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ner_info(List<NERInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.ner_info = r100;
            return this;
        }

        public Builder result(String r100) {
            this.result = r100;
            return this;
        }

        public Builder rich_text_result(RichText r100) {
            this.rich_text_result = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ASRTextResult extends ProtoAdapter<ASRTextResult> {
        public ProtoAdapter_ASRTextResult() {
            super(FieldEncoding.LENGTH_DELIMITED, ASRTextResult.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ASRTextResult decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.result = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.result = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.ner_info.add(NERInfo.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.rich_text_result = RichText.ADAPTER.decode(r100);
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
        public int encodedSize2(ASRTextResult r100) {
            String r101 = r100.result;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + NERInfo.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.ner_info);
            RichText r105 = r100.rich_text_result;
            if (r105 == null) goto L10;
            r102 = RichText.ADAPTER.encodedSizeWithTag(3, r105);
        L10:
            return (r104 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ASRTextResult decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ASRTextResult r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ASRTextResult r101) throws IOException {
            String r102 = r101.result;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            NERInfo.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.ner_info);
            RichText r103 = r101.rich_text_result;
            if (r103 == null) goto L8;
            RichText.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ASRTextResult r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ASRTextResult();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.result = this.result;
        r100.ner_info = Internal.copyOf("ner_info", this.ner_info);
        r100.rich_text_result = this.rich_text_result;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ASRTextResult.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ASRTextResult(String r100, List<NERInfo> r101, RichText r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ASRTextResult(String r100, List<NERInfo> r101, RichText r102, ByteString r103) {
        super(ADAPTER, r103);
        this.result = r100;
        this.ner_info = Internal.immutableCopyOf("ner_info", r101);
        this.rich_text_result = r102;
    }
}
