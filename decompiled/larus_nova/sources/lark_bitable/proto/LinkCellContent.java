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
public final class LinkCellContent extends Message<LinkCellContent, Builder> {
    public static final ProtoAdapter<LinkCellContent> ADAPTER = null;
    public static final ModelAction DEFAULT_ACTION = null;
    private static final long serialVersionUID = 0;
    public final ModelAction action;
    public final List<LinkCapsule> content;

    public static final class Builder extends Message.Builder<LinkCellContent, Builder> {
        public ModelAction action;
        public List<LinkCapsule> content;

        @Override // com.squareup.wire.Message.Builder
        public LinkCellContent build() {
            ModelAction r100 = this.action;
            if (r100 == null) goto L7;
            return new LinkCellContent(this.content, this.action, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "action"});
        }

        public Builder() {
            this.content = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action(ModelAction r100) {
            this.action = r100;
            return this;
        }

        public Builder content(List<LinkCapsule> r100) {
            Internal.checkElementsNotNull(r100);
            this.content = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LinkCellContent extends ProtoAdapter<LinkCellContent> {
        public ProtoAdapter_LinkCellContent() {
            super(FieldEncoding.LENGTH_DELIMITED, LinkCellContent.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public LinkCellContent decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.content.add(LinkCapsule.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.action = ModelAction.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(LinkCellContent r100) {
            return (LinkCapsule.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.content) + ModelAction.ADAPTER.encodedSizeWithTag(2, r100.action)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LinkCellContent decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LinkCellContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LinkCellContent r101) throws IOException {
            LinkCapsule.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.content);
            ModelAction.ADAPTER.encodeWithTag(r100, 2, r101.action);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LinkCellContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LinkCellContent();
        DEFAULT_ACTION = ModelAction.VAR_MODEL_ACTION_JUMP_PAGE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.content = Internal.copyOf("content", this.content);
        r100.action = this.action;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LinkCellContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LinkCellContent(List<LinkCapsule> r100, ModelAction r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public LinkCellContent(List<LinkCapsule> r100, ModelAction r101, ByteString r102) {
        super(ADAPTER, r102);
        this.content = Internal.immutableCopyOf("content", r100);
        this.action = r101;
    }
}
