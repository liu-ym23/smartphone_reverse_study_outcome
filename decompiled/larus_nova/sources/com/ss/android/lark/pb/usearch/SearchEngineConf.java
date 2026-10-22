package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class SearchEngineConf extends Message<SearchEngineConf, Builder> {
    public static final ProtoAdapter<SearchEngineConf> ADAPTER = null;
    public static final String DEFAULT_ICON_URL = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_SELECTED = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_QUERY_PARAM = "";
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final String micon_url;
    public final String mid;
    public final Boolean mis_selected;
    public final String mname;
    public final String mquery_param;
    public final String murl;

    public static final class Builder extends Message.Builder<SearchEngineConf, Builder> {
        public String micon_url;
        public String mid;
        public Boolean mis_selected;
        public String mname;
        public String mquery_param;
        public String murl;

        @Override // com.squareup.wire.Message.Builder
        public SearchEngineConf build() {
            return new SearchEngineConf(this.mid, this.micon_url, this.murl, this.mname, this.mquery_param, this.mis_selected, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder icon_url(String r100) {
            this.micon_url = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder is_selected(Boolean r100) {
            this.mis_selected = r100;
            return this;
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }

        public Builder query_param(String r100) {
            this.mquery_param = r100;
            return this;
        }

        public Builder url(String r100) {
            this.murl = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchEngineConf extends ProtoAdapter<SearchEngineConf> {
        public ProtoAdapter_SearchEngineConf() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchEngineConf.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchEngineConf decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            r101.micon_url = "";
            r101.murl = "";
            r101.mname = "";
            r101.mquery_param = "";
            r101.mis_selected = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.mis_selected = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.mquery_param = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.mname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.murl = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.micon_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SearchEngineConf r100) {
            String r101 = r100.mid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.micon_url;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.murl;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mname;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.mquery_param;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.mis_selected;
            if (r116 == null) goto L26;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ SearchEngineConf decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchEngineConf r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchEngineConf r101) throws IOException {
            String r102 = r101.mid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.micon_url;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.murl;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mname;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.mquery_param;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            Boolean r107 = r101.mis_selected;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchEngineConf r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchEngineConf();
        DEFAULT_IS_SELECTED = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.micon_url = this.micon_url;
        r100.murl = this.murl;
        r100.mname = this.mname;
        r100.mquery_param = this.mquery_param;
        r100.mis_selected = this.mis_selected;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchEngineConf.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchEngineConf(String r100, String r110, String r111, String r112, String r113, Boolean r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public SearchEngineConf(String r100, String r101, String r102, String r103, String r104, Boolean r105, ByteString r106) {
        super(ADAPTER, r106);
        this.mid = r100;
        this.micon_url = r101;
        this.murl = r102;
        this.mname = r103;
        this.mquery_param = r104;
        this.mis_selected = r105;
    }
}
