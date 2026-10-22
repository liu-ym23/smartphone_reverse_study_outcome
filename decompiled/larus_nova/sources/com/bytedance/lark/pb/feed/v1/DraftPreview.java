package com.bytedance.lark.pb.feed.v1;

import com.bytedance.lark.pb.basic.v1.CloudDraftContent;
import com.bytedance.lark.pb.basic.v1.DraftAttachmentSnapshot;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class DraftPreview extends Message<DraftPreview, Builder> {
    public static final ProtoAdapter<DraftPreview> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    private static final long serialVersionUID = 0;
    public final DraftAttachmentSnapshot attachment_snapshot;
    public final CloudDraftContent cloud_draft_content;
    public final String content;

    public static final class Builder extends Message.Builder<DraftPreview, Builder> {
        public DraftAttachmentSnapshot attachment_snapshot;
        public CloudDraftContent cloud_draft_content;
        public String content;

        @Override // com.squareup.wire.Message.Builder
        public DraftPreview build() {
            String r100 = this.content;
            if (r100 == null) goto L7;
            return new DraftPreview(this.content, this.cloud_draft_content, this.attachment_snapshot, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "content"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder attachment_snapshot(DraftAttachmentSnapshot r100) {
            this.attachment_snapshot = r100;
            return this;
        }

        public Builder cloud_draft_content(CloudDraftContent r100) {
            this.cloud_draft_content = r100;
            return this;
        }

        public Builder content(String r100) {
            this.content = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DraftPreview extends ProtoAdapter<DraftPreview> {
        public ProtoAdapter_DraftPreview() {
            super(FieldEncoding.LENGTH_DELIMITED, DraftPreview.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DraftPreview decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.content = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.content = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.cloud_draft_content = CloudDraftContent.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.attachment_snapshot = DraftAttachmentSnapshot.ADAPTER.decode(r100);
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
        public int encodedSize2(DraftPreview r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.content);
            CloudDraftContent r102 = r100.cloud_draft_content;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = CloudDraftContent.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            DraftAttachmentSnapshot r106 = r100.attachment_snapshot;
            if (r106 == null) goto L10;
            r103 = DraftAttachmentSnapshot.ADAPTER.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DraftPreview decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DraftPreview r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DraftPreview r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.content);
            CloudDraftContent r102 = r101.cloud_draft_content;
            if (r102 == null) goto L5;
            CloudDraftContent.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            DraftAttachmentSnapshot r103 = r101.attachment_snapshot;
            if (r103 == null) goto L8;
            DraftAttachmentSnapshot.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DraftPreview r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DraftPreview();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.content = this.content;
        r100.cloud_draft_content = this.cloud_draft_content;
        r100.attachment_snapshot = this.attachment_snapshot;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DraftPreview.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DraftPreview(String r100, CloudDraftContent r101, DraftAttachmentSnapshot r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public DraftPreview(String r100, CloudDraftContent r101, DraftAttachmentSnapshot r102, ByteString r103) {
        super(ADAPTER, r103);
        this.content = r100;
        this.cloud_draft_content = r101;
        this.attachment_snapshot = r102;
    }
}
