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
public final class FormulaCellContent extends Message<FormulaCellContent, Builder> {
    public static final ProtoAdapter<FormulaCellContent> ADAPTER = null;
    public static final Boolean DEFAULT_NEED_COMMA = null;
    private static final long serialVersionUID = 0;
    public final List<ICellContent> content;
    public final Boolean need_comma;

    public static final class Builder extends Message.Builder<FormulaCellContent, Builder> {
        public List<ICellContent> content;
        public Boolean need_comma;

        @Override // com.squareup.wire.Message.Builder
        public FormulaCellContent build() {
            Boolean r100 = this.need_comma;
            if (r100 == null) goto L7;
            return new FormulaCellContent(this.content, this.need_comma, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "need_comma"});
        }

        public Builder() {
            this.content = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder content(List<ICellContent> r100) {
            Internal.checkElementsNotNull(r100);
            this.content = r100;
            return this;
        }

        public Builder need_comma(Boolean r100) {
            this.need_comma = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FormulaCellContent extends ProtoAdapter<FormulaCellContent> {
        public ProtoAdapter_FormulaCellContent() {
            super(FieldEncoding.LENGTH_DELIMITED, FormulaCellContent.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FormulaCellContent decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.content.add(ICellContent.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.need_comma = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(FormulaCellContent r100) {
            return (ICellContent.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.content) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.need_comma)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FormulaCellContent decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FormulaCellContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FormulaCellContent r101) throws IOException {
            ICellContent.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.content);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.need_comma);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FormulaCellContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FormulaCellContent();
        DEFAULT_NEED_COMMA = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.content = Internal.copyOf("content", this.content);
        r100.need_comma = this.need_comma;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FormulaCellContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FormulaCellContent(List<ICellContent> r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FormulaCellContent(List<ICellContent> r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.content = Internal.immutableCopyOf("content", r100);
        this.need_comma = r101;
    }
}
