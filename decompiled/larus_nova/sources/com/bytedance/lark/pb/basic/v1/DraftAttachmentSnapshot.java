package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class DraftAttachmentSnapshot extends com.squareup.wire.Message<DraftAttachmentSnapshot, Builder> {
    public static final ProtoAdapter<DraftAttachmentSnapshot> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<DraftAttachment> attachments;

    public static final class Builder extends com.squareup.wire.Message.Builder<DraftAttachmentSnapshot, Builder> {
        public List<DraftAttachment> attachments;

        @Override // com.squareup.wire.Message.Builder
        public DraftAttachmentSnapshot build() {
            return new DraftAttachmentSnapshot(this.attachments, super.buildUnknownFields());
        }

        public Builder() {
            this.attachments = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder attachments(List<DraftAttachment> r100) {
            Internal.checkElementsNotNull(r100);
            this.attachments = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DraftAttachmentSnapshot extends ProtoAdapter<DraftAttachmentSnapshot> {
        public ProtoAdapter_DraftAttachmentSnapshot() {
            super(FieldEncoding.LENGTH_DELIMITED, DraftAttachmentSnapshot.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DraftAttachmentSnapshot decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.attachments.add(DraftAttachment.ADAPTER.decode(r100));
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
        public int encodedSize2(DraftAttachmentSnapshot r100) {
            return DraftAttachment.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.attachments) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DraftAttachmentSnapshot decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DraftAttachmentSnapshot r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DraftAttachmentSnapshot r101) throws IOException {
            DraftAttachment.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.attachments);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DraftAttachmentSnapshot r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DraftAttachmentSnapshot();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.attachments = Internal.copyOf("attachments", this.attachments);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DraftAttachmentSnapshot.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public DraftAttachmentSnapshot(List<DraftAttachment> r100) {
        this(r100, ByteString.EMPTY);
    }

    public DraftAttachmentSnapshot(List<DraftAttachment> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.attachments = Internal.immutableCopyOf("attachments", r100);
    }
}
