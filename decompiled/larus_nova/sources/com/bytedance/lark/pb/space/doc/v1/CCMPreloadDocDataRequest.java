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
public final class CCMPreloadDocDataRequest extends Message<CCMPreloadDocDataRequest, Builder> {
    public static final ProtoAdapter<CCMPreloadDocDataRequest> ADAPTER = null;
    public static final String DEFAULT_APP_VERSION = "";
    public static final String DEFAULT_DOCX_TOKEN = "";
    public static final String DEFAULT_DOC_TOKEN = "";
    public static final Integer DEFAULT_EMBED_DOC_LIMIT = null;
    public static final String DEFAULT_EVENT_TYPE = "";
    public static final Integer DEFAULT_OPEN_TYPE = null;
    public static final Integer DEFAULT_RESOURCE_LIMIT = null;
    public static final String DEFAULT_SHEET_ID = "";
    public static final String DEFAULT_SSR_DOMAIN = "";
    public static final Integer DEFAULT_TYPE = null;
    public static final ProtoAdapter_CCMPreloadDocDataRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String app_version;
    public final String doc_token;
    public final String docx_token;
    public final Integer embed_doc_limit;
    public final String event_type;
    public final List<String> fetch_types;
    public final Integer open_type;
    public final Integer resource_limit;
    public final String sheet_id;
    public final String ssr_domain;
    public final Integer type;

    public static final class Builder extends Message.Builder<CCMPreloadDocDataRequest, Builder> implements d<CCMPreloadDocDataRequest> {
        public String app_version;
        public String doc_token;
        public String docx_token;
        public Integer embed_doc_limit;
        public String event_type;
        public List<String> fetch_types;
        public Integer open_type;
        public Integer resource_limit;
        public String sheet_id;
        public String ssr_domain;
        public Integer type;

        @Override // com.squareup.wire.Message.Builder
        public CCMPreloadDocDataRequest build() {
            String r100 = this.docx_token;
            if (r100 == null) goto L9;
            if (this.type == null) goto L9;
            return new CCMPreloadDocDataRequest(this.docx_token, this.type, this.open_type, this.event_type, this.resource_limit, this.embed_doc_limit, this.fetch_types, this.doc_token, this.sheet_id, this.ssr_domain, this.app_version, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "docx_token", this.type, "type"});
        }

        public Builder() {
            this.fetch_types = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_version(String r100) {
            this.app_version = r100;
            return this;
        }

        public Builder doc_token(String r100) {
            this.doc_token = r100;
            return this;
        }

        public Builder docx_token(String r100) {
            this.docx_token = r100;
            return this;
        }

        public Builder embed_doc_limit(Integer r100) {
            this.embed_doc_limit = r100;
            return this;
        }

        public Builder event_type(String r100) {
            this.event_type = r100;
            return this;
        }

        public Builder fetch_types(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.fetch_types = r100;
            return this;
        }

        public Builder open_type(Integer r100) {
            this.open_type = r100;
            return this;
        }

        public Builder resource_limit(Integer r100) {
            this.resource_limit = r100;
            return this;
        }

        public Builder sheet_id(String r100) {
            this.sheet_id = r100;
            return this;
        }

        public Builder ssr_domain(String r100) {
            this.ssr_domain = r100;
            return this;
        }

        public Builder type(Integer r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CCMPreloadDocDataRequest extends ProtoAdapter<CCMPreloadDocDataRequest> implements c<CCMPreloadDocDataRequest> {
        public ProtoAdapter_CCMPreloadDocDataRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CCMPreloadDocDataRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CCMPreloadDocDataRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.docx_token = "";
            r101.type = 0;
            r101.open_type = 0;
            r101.event_type = "";
            r101.resource_limit = 0;
            r101.embed_doc_limit = 0;
            r101.doc_token = "";
            r101.sheet_id = "";
            r101.ssr_domain = "";
            r101.app_version = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            switch(r103) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            r101.app_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.ssr_domain = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.sheet_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.doc_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.fetch_types.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            r101.embed_doc_limit = ProtoAdapter.INT32.decode(r100);
            goto L3
        L13:
            r101.resource_limit = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            r101.event_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.open_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L16:
            r101.type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L17:
            r101.docx_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CCMPreloadDocDataRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.docx_token);
            ProtoAdapter<Integer> r103 = ProtoAdapter.INT32;
            int r104 = r102 + r103.encodedSizeWithTag(2, r100.type);
            Integer r105 = r100.open_type;
            int r106 = 0;
            if (r105 == null) goto L5;
            int r107 = r103.encodedSizeWithTag(3, r105);
        L6:
            int r108 = r104 + r107;
            String r109 = r100.event_type;
            if (r109 == null) goto L9;
            int r110 = r101.encodedSizeWithTag(4, r109);
        L10:
            int r111 = r108 + r110;
            Integer r112 = r100.resource_limit;
            if (r112 == null) goto L13;
            int r113 = r103.encodedSizeWithTag(5, r112);
        L14:
            int r114 = r111 + r113;
            Integer r115 = r100.embed_doc_limit;
            if (r115 == null) goto L17;
            int r116 = r103.encodedSizeWithTag(6, r115);
        L18:
            int r117 = (r114 + r116) + r101.asRepeated().encodedSizeWithTag(7, r100.fetch_types);
            String r118 = r100.doc_token;
            if (r118 == null) goto L21;
            int r119 = r101.encodedSizeWithTag(8, r118);
        L22:
            int r120 = r117 + r119;
            String r121 = r100.sheet_id;
            if (r121 == null) goto L25;
            int r122 = r101.encodedSizeWithTag(9, r121);
        L26:
            int r123 = r120 + r122;
            String r124 = r100.ssr_domain;
            if (r124 == null) goto L29;
            int r125 = r101.encodedSizeWithTag(10, r124);
        L30:
            int r126 = r123 + r125;
            String r127 = r100.app_version;
            if (r127 == null) goto L34;
            r106 = r101.encodedSizeWithTag(11, r127);
        L34:
            return (r126 + r106) + r100.unknownFields().size();
        L29:
            r125 = 0;
            goto L30
        L25:
            r122 = 0;
            goto L26
        L21:
            r119 = 0;
            goto L22
        L17:
            r116 = 0;
            goto L18
        L13:
            r113 = 0;
            goto L14
        L9:
            r110 = 0;
            goto L10
        L5:
            r107 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CCMPreloadDocDataRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CCMPreloadDocDataRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CCMPreloadDocDataRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.docx_token);
            ProtoAdapter<Integer> r103 = ProtoAdapter.INT32;
            r103.encodeWithTag(r100, 2, r101.type);
            Integer r104 = r101.open_type;
            if (r104 == null) goto L5;
            r103.encodeWithTag(r100, 3, r104);
        L5:
            String r105 = r101.event_type;
            if (r105 == null) goto L8;
            r102.encodeWithTag(r100, 4, r105);
        L8:
            Integer r106 = r101.resource_limit;
            if (r106 == null) goto L11;
            r103.encodeWithTag(r100, 5, r106);
        L11:
            Integer r107 = r101.embed_doc_limit;
            if (r107 == null) goto L14;
            r103.encodeWithTag(r100, 6, r107);
        L14:
            r102.asRepeated().encodeWithTag(r100, 7, r101.fetch_types);
            String r108 = r101.doc_token;
            if (r108 == null) goto L17;
            r102.encodeWithTag(r100, 8, r108);
        L17:
            String r109 = r101.sheet_id;
            if (r109 == null) goto L20;
            r102.encodeWithTag(r100, 9, r109);
        L20:
            String r110 = r101.ssr_domain;
            if (r110 == null) goto L23;
            r102.encodeWithTag(r100, 10, r110);
        L23:
            String r111 = r101.app_version;
            if (r111 == null) goto L26;
            r102.encodeWithTag(r100, 11, r111);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CCMPreloadDocDataRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CCMPreloadDocDataRequest r100 = new ProtoAdapter_CCMPreloadDocDataRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TYPE = 0;
        DEFAULT_OPEN_TYPE = 0;
        DEFAULT_RESOURCE_LIMIT = 0;
        DEFAULT_EMBED_DOC_LIMIT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.docx_token = this.docx_token;
        r100.type = this.type;
        r100.open_type = this.open_type;
        r100.event_type = this.event_type;
        r100.resource_limit = this.resource_limit;
        r100.embed_doc_limit = this.embed_doc_limit;
        r100.fetch_types = Internal.copyOf("fetch_types", this.fetch_types);
        r100.doc_token = this.doc_token;
        r100.sheet_id = this.sheet_id;
        r100.ssr_domain = this.ssr_domain;
        r100.app_version = this.app_version;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CCMPreloadDocDataRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CCMPreloadDocDataRequest(String r110, Integer r111, Integer r112, String r113, Integer r114, Integer r115, List<String> r210, String r211, String r212, String r213, String r214) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, ByteString.EMPTY);
    }

    public CCMPreloadDocDataRequest(String r100, Integer r101, Integer r102, String r103, Integer r104, Integer r105, List<String> r106, String r107, String r110, String r111, String r112, ByteString r113) {
        super(ADAPTER, r113);
        this.docx_token = r100;
        this.type = r101;
        this.open_type = r102;
        this.event_type = r103;
        this.resource_limit = r104;
        this.embed_doc_limit = r105;
        this.fetch_types = Internal.immutableCopyOf("fetch_types", r106);
        this.doc_token = r107;
        this.sheet_id = r110;
        this.ssr_domain = r111;
        this.app_version = r112;
    }
}
