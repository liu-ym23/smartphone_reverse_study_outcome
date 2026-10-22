package com.ss.android.lark.pb.url_preview;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullUrlPreviewChattersListRequest extends Message<PullUrlPreviewChattersListRequest, Builder> {
    public static final ProtoAdapter<PullUrlPreviewChattersListRequest> ADAPTER = null;
    public static final String DEFAULT_COMPONENT_ID = "";
    public static final String DEFAULT_NEXT_TOKEN = "";
    public static final String DEFAULT_PREVIEW_ID = "";
    public static final FieldOptions FIELD_OPTIONS_MPREVIEW_ID = null;
    private static final long serialVersionUID = 0;
    public final String mcomponent_id;
    public final String mnext_token;
    public final String mpreview_id;

    public static final class Builder extends Message.Builder<PullUrlPreviewChattersListRequest, Builder> {
        public String mcomponent_id;
        public String mnext_token;
        public String mpreview_id;

        @Override // com.squareup.wire.Message.Builder
        public PullUrlPreviewChattersListRequest build() {
            String r100 = this.mpreview_id;
            if (r100 == null) goto L7;
            return new PullUrlPreviewChattersListRequest(this.mpreview_id, this.mcomponent_id, this.mnext_token, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mpreview_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder component_id(String r100) {
            this.mcomponent_id = r100;
            return this;
        }

        public Builder next_token(String r100) {
            this.mnext_token = r100;
            return this;
        }

        public Builder preview_id(String r100) {
            this.mpreview_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullUrlPreviewChattersListRequest extends ProtoAdapter<PullUrlPreviewChattersListRequest> {
        public ProtoAdapter_PullUrlPreviewChattersListRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullUrlPreviewChattersListRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullUrlPreviewChattersListRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mpreview_id = "";
            r101.mcomponent_id = "";
            r101.mnext_token = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mpreview_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mcomponent_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mnext_token = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(PullUrlPreviewChattersListRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.mpreview_id);
            String r103 = r100.mcomponent_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.mnext_token;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(3, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullUrlPreviewChattersListRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullUrlPreviewChattersListRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullUrlPreviewChattersListRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mpreview_id);
            String r103 = r101.mcomponent_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.mnext_token;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullUrlPreviewChattersListRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullUrlPreviewChattersListRequest();
        FIELD_OPTIONS_MPREVIEW_ID = new FieldOptions.Builder().FieldInfo("split,type=url_preview_token").build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mpreview_id = this.mpreview_id;
        r100.mcomponent_id = this.mcomponent_id;
        r100.mnext_token = this.mnext_token;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullUrlPreviewChattersListRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullUrlPreviewChattersListRequest(String r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PullUrlPreviewChattersListRequest(String r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mpreview_id = r100;
        this.mcomponent_id = r101;
        this.mnext_token = r102;
    }
}
