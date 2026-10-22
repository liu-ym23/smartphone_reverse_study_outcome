package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ShareSceneLinkResponse extends Message<ShareSceneLinkResponse, Builder> {
    public static final ProtoAdapter<ShareSceneLinkResponse> ADAPTER = null;
    public static final String DEFAULT_LINK = "";
    private static final long serialVersionUID = 0;
    public final String mlink;

    public static final class Builder extends Message.Builder<ShareSceneLinkResponse, Builder> {
        public String mlink;

        @Override // com.squareup.wire.Message.Builder
        public ShareSceneLinkResponse build() {
            return new ShareSceneLinkResponse(this.mlink, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder link(String r100) {
            this.mlink = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ShareSceneLinkResponse extends ProtoAdapter<ShareSceneLinkResponse> {
        public ProtoAdapter_ShareSceneLinkResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, ShareSceneLinkResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ShareSceneLinkResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mlink = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mlink = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(ShareSceneLinkResponse r100) {
            String r101 = r100.mlink;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ShareSceneLinkResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ShareSceneLinkResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ShareSceneLinkResponse r101) throws IOException {
            String r102 = r101.mlink;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ShareSceneLinkResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ShareSceneLinkResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mlink = this.mlink;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ShareSceneLinkResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ShareSceneLinkResponse(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public ShareSceneLinkResponse(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mlink = r100;
    }
}
