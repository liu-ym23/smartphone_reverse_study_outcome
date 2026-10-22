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
public final class SubTitle extends Message<SubTitle, Builder> {
    public static final ProtoAdapter<SubTitle> ADAPTER = null;
    public static final ModelAction DEFAULT_ACTION = null;
    public static final String DEFAULT_SUB_TITLE_NAME = "";
    private static final long serialVersionUID = 0;
    public final ModelAction action;
    public final String sub_title_name;

    public static final class Builder extends Message.Builder<SubTitle, Builder> {
        public ModelAction action;
        public String sub_title_name;

        @Override // com.squareup.wire.Message.Builder
        public SubTitle build() {
            String r100 = this.sub_title_name;
            if (r100 == null) goto L7;
            return new SubTitle(this.sub_title_name, this.action, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "sub_title_name"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action(ModelAction r100) {
            this.action = r100;
            return this;
        }

        public Builder sub_title_name(String r100) {
            this.sub_title_name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SubTitle extends ProtoAdapter<SubTitle> {
        public ProtoAdapter_SubTitle() {
            super(FieldEncoding.LENGTH_DELIMITED, SubTitle.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public SubTitle decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.sub_title_name = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SubTitle r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.sub_title_name);
            ModelAction r102 = r100.action;
            if (r102 == null) goto L5;
            int r103 = ModelAction.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubTitle decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubTitle r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SubTitle r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.sub_title_name);
            ModelAction r102 = r101.action;
            if (r102 == null) goto L5;
            ModelAction.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SubTitle r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubTitle();
        DEFAULT_ACTION = ModelAction.VAR_MODEL_ACTION_JUMP_PAGE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.sub_title_name = this.sub_title_name;
        r100.action = this.action;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SubTitle.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SubTitle(String r100, ModelAction r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SubTitle(String r100, ModelAction r101, ByteString r102) {
        super(ADAPTER, r102);
        this.sub_title_name = r100;
        this.action = r101;
    }
}
