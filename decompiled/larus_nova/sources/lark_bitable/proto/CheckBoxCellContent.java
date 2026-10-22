package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class CheckBoxCellContent extends Message<CheckBoxCellContent, Builder> {
    public static final ProtoAdapter<CheckBoxCellContent> ADAPTER = null;
    public static final Boolean DEFAULT_CHECKED = null;
    private static final long serialVersionUID = 0;
    public final Boolean checked;

    public static final class Builder extends Message.Builder<CheckBoxCellContent, Builder> {
        public Boolean checked;

        @Override // com.squareup.wire.Message.Builder
        public CheckBoxCellContent build() {
            Boolean r100 = this.checked;
            if (r100 == null) goto L7;
            return new CheckBoxCellContent(this.checked, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "checked"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder checked(Boolean r100) {
            this.checked = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CheckBoxCellContent extends ProtoAdapter<CheckBoxCellContent> {
        public ProtoAdapter_CheckBoxCellContent() {
            super(FieldEncoding.LENGTH_DELIMITED, CheckBoxCellContent.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public CheckBoxCellContent decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.checked = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(CheckBoxCellContent r100) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.checked) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CheckBoxCellContent decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CheckBoxCellContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CheckBoxCellContent r101) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.checked);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CheckBoxCellContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CheckBoxCellContent();
        DEFAULT_CHECKED = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.checked = this.checked;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CheckBoxCellContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CheckBoxCellContent(Boolean r100) {
        this(r100, ByteString.EMPTY);
    }

    public CheckBoxCellContent(Boolean r100, ByteString r101) {
        super(ADAPTER, r101);
        this.checked = r100;
    }
}
