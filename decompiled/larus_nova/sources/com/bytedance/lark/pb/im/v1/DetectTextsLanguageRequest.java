package com.bytedance.lark.pb.im.v1;

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
public final class DetectTextsLanguageRequest extends Message<DetectTextsLanguageRequest, Builder> {
    public static final ProtoAdapter<DetectTextsLanguageRequest> ADAPTER = null;
    public static final ProtoAdapter_DetectTextsLanguageRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> text_list;

    public static final class Builder extends Message.Builder<DetectTextsLanguageRequest, Builder> implements d<DetectTextsLanguageRequest> {
        public List<String> text_list;

        @Override // com.squareup.wire.Message.Builder
        public DetectTextsLanguageRequest build() {
            return new DetectTextsLanguageRequest(this.text_list, super.buildUnknownFields());
        }

        public Builder() {
            this.text_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder text_list(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.text_list = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DetectTextsLanguageRequest extends ProtoAdapter<DetectTextsLanguageRequest> implements c<DetectTextsLanguageRequest> {
        public ProtoAdapter_DetectTextsLanguageRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DetectTextsLanguageRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DetectTextsLanguageRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.text_list.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DetectTextsLanguageRequest r100) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.text_list) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DetectTextsLanguageRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DetectTextsLanguageRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DetectTextsLanguageRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.text_list);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DetectTextsLanguageRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_DetectTextsLanguageRequest r100 = new ProtoAdapter_DetectTextsLanguageRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.text_list = Internal.copyOf("text_list", this.text_list);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DetectTextsLanguageRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DetectTextsLanguageRequest(List<String> r100) {
        this(r100, ByteString.EMPTY);
    }

    public DetectTextsLanguageRequest(List<String> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.text_list = Internal.immutableCopyOf("text_list", r100);
    }
}
