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
public final class EditMessageAttachmentUpdate extends com.squareup.wire.Message<EditMessageAttachmentUpdate, Builder> {
    public static final ProtoAdapter<EditMessageAttachmentUpdate> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<File> file_attachments;

    public static final class Builder extends com.squareup.wire.Message.Builder<EditMessageAttachmentUpdate, Builder> {
        public List<File> file_attachments;

        @Override // com.squareup.wire.Message.Builder
        public EditMessageAttachmentUpdate build() {
            return new EditMessageAttachmentUpdate(this.file_attachments, super.buildUnknownFields());
        }

        public Builder() {
            this.file_attachments = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder file_attachments(List<File> r100) {
            Internal.checkElementsNotNull(r100);
            this.file_attachments = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EditMessageAttachmentUpdate extends ProtoAdapter<EditMessageAttachmentUpdate> {
        public ProtoAdapter_EditMessageAttachmentUpdate() {
            super(FieldEncoding.LENGTH_DELIMITED, EditMessageAttachmentUpdate.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EditMessageAttachmentUpdate decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.file_attachments.add(File.ADAPTER.decode(r100));
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
        public int encodedSize2(EditMessageAttachmentUpdate r100) {
            return File.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.file_attachments) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ EditMessageAttachmentUpdate decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EditMessageAttachmentUpdate r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EditMessageAttachmentUpdate r101) throws IOException {
            File.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.file_attachments);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EditMessageAttachmentUpdate r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EditMessageAttachmentUpdate();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.file_attachments = Internal.copyOf("file_attachments", this.file_attachments);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EditMessageAttachmentUpdate.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public EditMessageAttachmentUpdate(List<File> r100) {
        this(r100, ByteString.EMPTY);
    }

    public EditMessageAttachmentUpdate(List<File> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.file_attachments = Internal.immutableCopyOf("file_attachments", r100);
    }
}
