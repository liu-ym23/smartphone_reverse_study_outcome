package com.bytedance.lark.pb.url.v1;

import com.bytedance.lark.pb.basic.v1.URLPreviewComponent;
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
public final class PullUrlPreviewChattersListResponse extends Message<PullUrlPreviewChattersListResponse, Builder> {
    public static final ProtoAdapter<PullUrlPreviewChattersListResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final String DEFAULT_NEXT_TOKEN = "";
    public static final ProtoAdapter_PullUrlPreviewChattersListResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> chatter_ids;
    public final List<URLPreviewComponent.ChattersPreviewProperty.ChatterInfo> chatter_infos;
    public final Boolean has_more;
    public final String next_token;

    public static final class Builder extends Message.Builder<PullUrlPreviewChattersListResponse, Builder> implements d<PullUrlPreviewChattersListResponse> {
        public List<String> chatter_ids;
        public List<URLPreviewComponent.ChattersPreviewProperty.ChatterInfo> chatter_infos;
        public Boolean has_more;
        public String next_token;

        @Override // com.squareup.wire.Message.Builder
        public PullUrlPreviewChattersListResponse build() {
            return new PullUrlPreviewChattersListResponse(this.chatter_ids, this.chatter_infos, this.has_more, this.next_token, super.buildUnknownFields());
        }

        public Builder() {
            this.chatter_ids = Internal.newMutableList();
            this.chatter_infos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chatter_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatter_ids = r100;
            return this;
        }

        public Builder chatter_infos(List<URLPreviewComponent.ChattersPreviewProperty.ChatterInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatter_infos = r100;
            return this;
        }

        public Builder has_more(Boolean r100) {
            this.has_more = r100;
            return this;
        }

        public Builder next_token(String r100) {
            this.next_token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullUrlPreviewChattersListResponse extends ProtoAdapter<PullUrlPreviewChattersListResponse> implements c<PullUrlPreviewChattersListResponse> {
        public ProtoAdapter_PullUrlPreviewChattersListResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullUrlPreviewChattersListResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullUrlPreviewChattersListResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.has_more = Boolean.FALSE;
            r101.next_token = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.chatter_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.chatter_infos.add(URLPreviewComponent.ChattersPreviewProperty.ChatterInfo.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.has_more = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.next_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PullUrlPreviewChattersListResponse r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.asRepeated().encodedSizeWithTag(1, r100.chatter_ids) + URLPreviewComponent.ChattersPreviewProperty.ChatterInfo.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.chatter_infos);
            Boolean r103 = r100.has_more;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.next_token;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(4, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullUrlPreviewChattersListResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullUrlPreviewChattersListResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullUrlPreviewChattersListResponse r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 1, r101.chatter_ids);
            URLPreviewComponent.ChattersPreviewProperty.ChatterInfo.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.chatter_infos);
            Boolean r103 = r101.has_more;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L5:
            String r104 = r101.next_token;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullUrlPreviewChattersListResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PullUrlPreviewChattersListResponse r100 = new ProtoAdapter_PullUrlPreviewChattersListResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_HAS_MORE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chatter_ids = Internal.copyOf("chatter_ids", this.chatter_ids);
        r100.chatter_infos = Internal.copyOf("chatter_infos", this.chatter_infos);
        r100.has_more = this.has_more;
        r100.next_token = this.next_token;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullUrlPreviewChattersListResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullUrlPreviewChattersListResponse(List<String> r100, List<URLPreviewComponent.ChattersPreviewProperty.ChatterInfo> r101, Boolean r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PullUrlPreviewChattersListResponse(List<String> r100, List<URLPreviewComponent.ChattersPreviewProperty.ChatterInfo> r101, Boolean r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.chatter_ids = Internal.immutableCopyOf("chatter_ids", r100);
        this.chatter_infos = Internal.immutableCopyOf("chatter_infos", r101);
        this.has_more = r102;
        this.next_token = r103;
    }
}
