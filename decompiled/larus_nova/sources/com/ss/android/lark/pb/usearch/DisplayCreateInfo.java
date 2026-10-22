package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class DisplayCreateInfo extends Message<DisplayCreateInfo, Builder> {
    public static final ProtoAdapter<DisplayCreateInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final WikiCollaboratorInfo mwiki_collaborator_info;
    public final WikiTenantInfo mwiki_tenant_info;

    public static final class Builder extends Message.Builder<DisplayCreateInfo, Builder> {
        public WikiCollaboratorInfo mwiki_collaborator_info;
        public WikiTenantInfo mwiki_tenant_info;

        @Override // com.squareup.wire.Message.Builder
        public DisplayCreateInfo build() {
            return new DisplayCreateInfo(this.mwiki_collaborator_info, this.mwiki_tenant_info, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder wiki_collaborator_info(WikiCollaboratorInfo r100) {
            this.mwiki_collaborator_info = r100;
            return this;
        }

        public Builder wiki_tenant_info(WikiTenantInfo r100) {
            this.mwiki_tenant_info = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DisplayCreateInfo extends ProtoAdapter<DisplayCreateInfo> {
        public ProtoAdapter_DisplayCreateInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, DisplayCreateInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DisplayCreateInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mwiki_collaborator_info = WikiCollaboratorInfo.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mwiki_tenant_info = WikiTenantInfo.ADAPTER.decode(r100);
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
        public int encodedSize2(DisplayCreateInfo r100) {
            WikiCollaboratorInfo r101 = r100.mwiki_collaborator_info;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = WikiCollaboratorInfo.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            WikiTenantInfo r104 = r100.mwiki_tenant_info;
            if (r104 == null) goto L10;
            r102 = WikiTenantInfo.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DisplayCreateInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DisplayCreateInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DisplayCreateInfo r101) throws IOException {
            WikiCollaboratorInfo r102 = r101.mwiki_collaborator_info;
            if (r102 == null) goto L5;
            WikiCollaboratorInfo.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            WikiTenantInfo r103 = r101.mwiki_tenant_info;
            if (r103 == null) goto L8;
            WikiTenantInfo.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DisplayCreateInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DisplayCreateInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mwiki_collaborator_info = this.mwiki_collaborator_info;
        r100.mwiki_tenant_info = this.mwiki_tenant_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DisplayCreateInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DisplayCreateInfo(WikiCollaboratorInfo r100, WikiTenantInfo r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DisplayCreateInfo(WikiCollaboratorInfo r100, WikiTenantInfo r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mwiki_collaborator_info = r100;
        this.mwiki_tenant_info = r101;
    }
}
