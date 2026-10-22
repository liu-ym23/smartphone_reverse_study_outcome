package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class AttachmentCellContent extends Message<AttachmentCellContent, Builder> {
    public static final ProtoAdapter<AttachmentCellContent> ADAPTER = null;
    public static final Boolean DEFAULT_IS_CAMERA_ONLY = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_camera_only;
    public final List<AttachmentCellItem> items;

    public static final class Builder extends Message.Builder<AttachmentCellContent, Builder> {
        public Boolean is_camera_only;
        public List<AttachmentCellItem> items;

        @Override // com.squareup.wire.Message.Builder
        public AttachmentCellContent build() {
            Boolean r100 = this.is_camera_only;
            if (r100 == null) goto L7;
            return new AttachmentCellContent(this.items, this.is_camera_only, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "is_camera_only"});
        }

        public Builder() {
            this.items = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_camera_only(Boolean r100) {
            this.is_camera_only = r100;
            return this;
        }

        public Builder items(List<AttachmentCellItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.items = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AttachmentCellContent extends ProtoAdapter<AttachmentCellContent> {
        public ProtoAdapter_AttachmentCellContent() {
            super(FieldEncoding.LENGTH_DELIMITED, AttachmentCellContent.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public AttachmentCellContent decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.items.add(AttachmentCellItem.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.is_camera_only = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(AttachmentCellContent r100) {
            return (AttachmentCellItem.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.items) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.is_camera_only)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AttachmentCellContent decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AttachmentCellContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AttachmentCellContent r101) throws IOException {
            AttachmentCellItem.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.items);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.is_camera_only);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AttachmentCellContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AttachmentCellContent();
        DEFAULT_IS_CAMERA_ONLY = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.items = Internal.copyOf("items", this.items);
        r100.is_camera_only = this.is_camera_only;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AttachmentCellContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AttachmentCellContent(List<AttachmentCellItem> r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public AttachmentCellContent(List<AttachmentCellItem> r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.items = Internal.immutableCopyOf("items", r100);
        this.is_camera_only = r101;
    }
}
