package com.bytedance.lark.pb.space.doc.v1;

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
public final class CCMPreloadCompleteNotify extends Message<CCMPreloadCompleteNotify, Builder> {
    public static final ProtoAdapter<CCMPreloadCompleteNotify> ADAPTER = null;
    public static final Boolean DEFAULT_CAN_RETRY = null;
    public static final Integer DEFAULT_CODE = null;
    public static final String DEFAULT_COMPLETE_TYPE = "";
    public static final String DEFAULT_DOCX_TOKEN = "";
    public static final Integer DEFAULT_DOC_TYPE = null;
    public static final String DEFAULT_FAILED_STEP = "";
    public static final ProtoAdapter_CCMPreloadCompleteNotify RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean can_retry;
    public final Integer code;
    public final String complete_type;
    public final Integer doc_type;
    public final String docx_token;
    public final String failed_step;
    public final List<String> fetch_types;

    public static final class Builder extends Message.Builder<CCMPreloadCompleteNotify, Builder> implements d<CCMPreloadCompleteNotify> {
        public Boolean can_retry;
        public Integer code;
        public String complete_type;
        public Integer doc_type;
        public String docx_token;
        public String failed_step;
        public List<String> fetch_types;

        @Override // com.squareup.wire.Message.Builder
        public CCMPreloadCompleteNotify build() {
            String r100 = this.docx_token;
            if (r100 == null) goto L11;
            if (this.complete_type == null) goto L11;
            if (this.code == null) goto L11;
            return new CCMPreloadCompleteNotify(this.docx_token, this.complete_type, this.code, this.can_retry, this.doc_type, this.failed_step, this.fetch_types, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "docx_token", this.complete_type, "complete_type", this.code, "code"});
        }

        public Builder() {
            this.fetch_types = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder can_retry(Boolean r100) {
            this.can_retry = r100;
            return this;
        }

        public Builder code(Integer r100) {
            this.code = r100;
            return this;
        }

        public Builder complete_type(String r100) {
            this.complete_type = r100;
            return this;
        }

        public Builder doc_type(Integer r100) {
            this.doc_type = r100;
            return this;
        }

        public Builder docx_token(String r100) {
            this.docx_token = r100;
            return this;
        }

        public Builder failed_step(String r100) {
            this.failed_step = r100;
            return this;
        }

        public Builder fetch_types(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.fetch_types = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CCMPreloadCompleteNotify extends ProtoAdapter<CCMPreloadCompleteNotify> implements c<CCMPreloadCompleteNotify> {
        public ProtoAdapter_CCMPreloadCompleteNotify() {
            super(FieldEncoding.LENGTH_DELIMITED, CCMPreloadCompleteNotify.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CCMPreloadCompleteNotify decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.docx_token = "";
            r101.complete_type = "";
            r101.code = 0;
            r101.can_retry = Boolean.FALSE;
            r101.doc_type = 0;
            r101.failed_step = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.fetch_types.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            r101.failed_step = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.doc_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.can_retry = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            r101.complete_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.docx_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CCMPreloadCompleteNotify r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.docx_token) + r101.encodedSizeWithTag(2, r100.complete_type);
            ProtoAdapter<Integer> r103 = ProtoAdapter.INT32;
            int r104 = r102 + r103.encodedSizeWithTag(3, r100.code);
            Boolean r105 = r100.can_retry;
            int r106 = 0;
            if (r105 == null) goto L5;
            int r107 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r105);
        L6:
            int r108 = r104 + r107;
            Integer r109 = r100.doc_type;
            if (r109 == null) goto L9;
            int r110 = r103.encodedSizeWithTag(5, r109);
        L10:
            int r111 = r108 + r110;
            String r112 = r100.failed_step;
            if (r112 == null) goto L14;
            r106 = r101.encodedSizeWithTag(6, r112);
        L14:
            return ((r111 + r106) + r101.asRepeated().encodedSizeWithTag(7, r100.fetch_types)) + r100.unknownFields().size();
        L9:
            r110 = 0;
            goto L10
        L5:
            r107 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CCMPreloadCompleteNotify decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CCMPreloadCompleteNotify r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CCMPreloadCompleteNotify r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.docx_token);
            r102.encodeWithTag(r100, 2, r101.complete_type);
            ProtoAdapter<Integer> r103 = ProtoAdapter.INT32;
            r103.encodeWithTag(r100, 3, r101.code);
            Boolean r104 = r101.can_retry;
            if (r104 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
        L5:
            Integer r105 = r101.doc_type;
            if (r105 == null) goto L8;
            r103.encodeWithTag(r100, 5, r105);
        L8:
            String r106 = r101.failed_step;
            if (r106 == null) goto L11;
            r102.encodeWithTag(r100, 6, r106);
        L11:
            r102.asRepeated().encodeWithTag(r100, 7, r101.fetch_types);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CCMPreloadCompleteNotify r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CCMPreloadCompleteNotify r100 = new ProtoAdapter_CCMPreloadCompleteNotify();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_CODE = 0;
        DEFAULT_CAN_RETRY = Boolean.FALSE;
        DEFAULT_DOC_TYPE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.docx_token = this.docx_token;
        r100.complete_type = this.complete_type;
        r100.code = this.code;
        r100.can_retry = this.can_retry;
        r100.doc_type = this.doc_type;
        r100.failed_step = this.failed_step;
        r100.fetch_types = Internal.copyOf("fetch_types", this.fetch_types);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CCMPreloadCompleteNotify.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CCMPreloadCompleteNotify(String r110, String r111, Integer r112, Boolean r113, Integer r114, String r115, List<String> r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public CCMPreloadCompleteNotify(String r100, String r101, Integer r102, Boolean r103, Integer r104, String r105, List<String> r106, ByteString r107) {
        super(ADAPTER, r107);
        this.docx_token = r100;
        this.complete_type = r101;
        this.code = r102;
        this.can_retry = r103;
        this.doc_type = r104;
        this.failed_step = r105;
        this.fetch_types = Internal.immutableCopyOf("fetch_types", r106);
    }
}
