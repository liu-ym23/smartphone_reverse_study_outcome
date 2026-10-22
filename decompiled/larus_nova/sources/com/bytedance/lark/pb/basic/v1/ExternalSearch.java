package com.bytedance.lark.pb.basic.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ExternalSearch extends com.squareup.wire.Message<ExternalSearch, Builder> {
    public static final ProtoAdapter<ExternalSearch> ADAPTER = null;
    public static final String DEFAULT_ICON_URL = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_TITLE = "";
    public static final FieldOptions FIELD_OPTIONS_ICON_URL = null;
    public static final FieldOptions FIELD_OPTIONS_ID = null;
    public static final FieldOptions FIELD_OPTIONS_TITLE = null;
    private static final long serialVersionUID = 0;
    public final String icon_url;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253495id;
    public final String title;

    public static final class Builder extends com.squareup.wire.Message.Builder<ExternalSearch, Builder> {
        public String icon_url;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253496id;
        public String title;

        @Override // com.squareup.wire.Message.Builder
        public ExternalSearch build() {
            String r100 = this.f253496id;
            if (r100 == null) goto L7;
            return new ExternalSearch(this.f253496id, this.title, this.icon_url, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder icon_url(String r100) {
            this.icon_url = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253496id = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ExternalSearch extends ProtoAdapter<ExternalSearch> {
        public ProtoAdapter_ExternalSearch() {
            super(FieldEncoding.LENGTH_DELIMITED, ExternalSearch.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ExternalSearch decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253496id = "";
            r101.title = "";
            r101.icon_url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.f253496id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.icon_url = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(ExternalSearch r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253495id);
            String r103 = r100.title;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.icon_url;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(3, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ExternalSearch decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ExternalSearch r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ExternalSearch r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253495id);
            String r103 = r101.title;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.icon_url;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExternalSearch r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ExternalSearch();
        FIELD_OPTIONS_ID = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_TITLE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_ICON_URL = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253496id = this.f253495id;
        r100.title = this.title;
        r100.icon_url = this.icon_url;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ExternalSearch.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ExternalSearch(String r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ExternalSearch(String r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.f253495id = r100;
        this.title = r101;
        this.icon_url = r102;
    }
}
