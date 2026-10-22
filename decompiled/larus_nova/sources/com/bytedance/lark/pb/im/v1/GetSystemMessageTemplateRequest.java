package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetSystemMessageTemplateRequest extends Message<GetSystemMessageTemplateRequest, Builder> {
    public static final ProtoAdapter<GetSystemMessageTemplateRequest> ADAPTER = null;
    public static final Boolean DEFAULT_IS_PULL_ALL = null;
    public static final String DEFAULT_LOCALE_IDENTIFIER = "";
    public static final ProtoAdapter_GetSystemMessageTemplateRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_pull_all;
    public final String locale_identifier;

    public static final class Builder extends Message.Builder<GetSystemMessageTemplateRequest, Builder> implements d<GetSystemMessageTemplateRequest> {
        public Boolean is_pull_all;
        public String locale_identifier;

        @Override // com.squareup.wire.Message.Builder
        public GetSystemMessageTemplateRequest build() {
            return new GetSystemMessageTemplateRequest(this.locale_identifier, this.is_pull_all, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_pull_all(Boolean r100) {
            this.is_pull_all = r100;
            return this;
        }

        public Builder locale_identifier(String r100) {
            this.locale_identifier = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSystemMessageTemplateRequest extends ProtoAdapter<GetSystemMessageTemplateRequest> implements c<GetSystemMessageTemplateRequest> {
        public ProtoAdapter_GetSystemMessageTemplateRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSystemMessageTemplateRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetSystemMessageTemplateRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.locale_identifier = "";
            r101.is_pull_all = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.locale_identifier = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.is_pull_all = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(GetSystemMessageTemplateRequest r100) {
            String r101 = r100.locale_identifier;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.is_pull_all;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetSystemMessageTemplateRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetSystemMessageTemplateRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetSystemMessageTemplateRequest r101) throws IOException {
            String r102 = r101.locale_identifier;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.is_pull_all;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetSystemMessageTemplateRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetSystemMessageTemplateRequest r100 = new ProtoAdapter_GetSystemMessageTemplateRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_IS_PULL_ALL = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.locale_identifier = this.locale_identifier;
        r100.is_pull_all = this.is_pull_all;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetSystemMessageTemplateRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetSystemMessageTemplateRequest(String r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetSystemMessageTemplateRequest(String r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.locale_identifier = r100;
        this.is_pull_all = r101;
    }
}
