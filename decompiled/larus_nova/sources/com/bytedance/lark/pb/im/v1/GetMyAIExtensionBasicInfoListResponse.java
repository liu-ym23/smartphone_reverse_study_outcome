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
public final class GetMyAIExtensionBasicInfoListResponse extends Message<GetMyAIExtensionBasicInfoListResponse, Builder> {
    public static final ProtoAdapter<GetMyAIExtensionBasicInfoListResponse> ADAPTER = null;
    public static final String DEFAULT_CREATE_URL = "";
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final ProtoAdapter_GetMyAIExtensionBasicInfoListResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String create_url;
    public final List<MyAIExtensionBasicInfo> extension_list;
    public final Boolean has_more;

    public static final class Builder extends Message.Builder<GetMyAIExtensionBasicInfoListResponse, Builder> implements d<GetMyAIExtensionBasicInfoListResponse> {
        public String create_url;
        public List<MyAIExtensionBasicInfo> extension_list;
        public Boolean has_more;

        @Override // com.squareup.wire.Message.Builder
        public GetMyAIExtensionBasicInfoListResponse build() {
            return new GetMyAIExtensionBasicInfoListResponse(this.extension_list, this.has_more, this.create_url, super.buildUnknownFields());
        }

        public Builder() {
            this.extension_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder create_url(String r100) {
            this.create_url = r100;
            return this;
        }

        public Builder extension_list(List<MyAIExtensionBasicInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.extension_list = r100;
            return this;
        }

        public Builder has_more(Boolean r100) {
            this.has_more = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetMyAIExtensionBasicInfoListResponse extends ProtoAdapter<GetMyAIExtensionBasicInfoListResponse> implements c<GetMyAIExtensionBasicInfoListResponse> {
        public ProtoAdapter_GetMyAIExtensionBasicInfoListResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetMyAIExtensionBasicInfoListResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetMyAIExtensionBasicInfoListResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.has_more = Boolean.FALSE;
            r101.create_url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.extension_list.add(MyAIExtensionBasicInfo.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.has_more = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.create_url = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(GetMyAIExtensionBasicInfoListResponse r100) {
            int r101 = MyAIExtensionBasicInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.extension_list);
            Boolean r102 = r100.has_more;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            String r106 = r100.create_url;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetMyAIExtensionBasicInfoListResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetMyAIExtensionBasicInfoListResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetMyAIExtensionBasicInfoListResponse r101) throws IOException {
            MyAIExtensionBasicInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.extension_list);
            Boolean r102 = r101.has_more;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            String r103 = r101.create_url;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetMyAIExtensionBasicInfoListResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetMyAIExtensionBasicInfoListResponse r100 = new ProtoAdapter_GetMyAIExtensionBasicInfoListResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_HAS_MORE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.extension_list = Internal.copyOf("extension_list", this.extension_list);
        r100.has_more = this.has_more;
        r100.create_url = this.create_url;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetMyAIExtensionBasicInfoListResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetMyAIExtensionBasicInfoListResponse(List<MyAIExtensionBasicInfo> r100, Boolean r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetMyAIExtensionBasicInfoListResponse(List<MyAIExtensionBasicInfo> r100, Boolean r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.extension_list = Internal.immutableCopyOf("extension_list", r100);
        this.has_more = r101;
        this.create_url = r102;
    }
}
