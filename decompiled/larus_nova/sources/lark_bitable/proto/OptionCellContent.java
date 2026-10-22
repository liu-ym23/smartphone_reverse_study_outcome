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
public final class OptionCellContent extends Message<OptionCellContent, Builder> {
    public static final ProtoAdapter<OptionCellContent> ADAPTER = null;
    public static final Boolean DEFAULT_IS_EXTEND = null;
    private static final long serialVersionUID = 0;
    public final List<OptionValue> content;
    public final Boolean is_extend;

    public static final class Builder extends Message.Builder<OptionCellContent, Builder> {
        public List<OptionValue> content;
        public Boolean is_extend;

        @Override // com.squareup.wire.Message.Builder
        public OptionCellContent build() {
            Boolean r100 = this.is_extend;
            if (r100 == null) goto L7;
            return new OptionCellContent(this.content, this.is_extend, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "is_extend"});
        }

        public Builder() {
            this.content = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder content(List<OptionValue> r100) {
            Internal.checkElementsNotNull(r100);
            this.content = r100;
            return this;
        }

        public Builder is_extend(Boolean r100) {
            this.is_extend = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_OptionCellContent extends ProtoAdapter<OptionCellContent> {
        public ProtoAdapter_OptionCellContent() {
            super(FieldEncoding.LENGTH_DELIMITED, OptionCellContent.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public OptionCellContent decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.content.add(OptionValue.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.is_extend = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(OptionCellContent r100) {
            return (OptionValue.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.content) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.is_extend)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OptionCellContent decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OptionCellContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OptionCellContent r101) throws IOException {
            OptionValue.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.content);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.is_extend);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OptionCellContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OptionCellContent();
        DEFAULT_IS_EXTEND = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.content = Internal.copyOf("content", this.content);
        r100.is_extend = this.is_extend;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OptionCellContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OptionCellContent(List<OptionValue> r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public OptionCellContent(List<OptionValue> r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.content = Internal.immutableCopyOf("content", r100);
        this.is_extend = r101;
    }
}
