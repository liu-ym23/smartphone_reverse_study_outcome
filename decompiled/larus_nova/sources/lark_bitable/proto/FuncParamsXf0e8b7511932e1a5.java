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
public final class FuncParamsXf0e8b7511932e1a5 extends Message<FuncParamsXf0e8b7511932e1a5, Builder> {
    public static final ProtoAdapter<FuncParamsXf0e8b7511932e1a5> ADAPTER = null;
    public static final HomepageAction DEFAULT_ACTION = null;
    public static final HomepageListType DEFAULT_LIST_TYPE = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final HomepageAction action;
    public final HomepageListData data;
    public final HomepageListType list_type;

    public static final class Builder extends Message.Builder<FuncParamsXf0e8b7511932e1a5, Builder> {
        public ByteString _molten_ctx;
        public HomepageAction action;
        public HomepageListData data;
        public HomepageListType list_type;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXf0e8b7511932e1a5 build() {
            HomepageListType r100 = this.list_type;
            if (r100 == null) goto L11;
            if (this.action == null) goto L11;
            if (this.data == null) goto L11;
            return new FuncParamsXf0e8b7511932e1a5(this.list_type, this.action, this.data, this._molten_ctx, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "list_type", this.action, "action", this.data, "data"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder _molten_ctx(ByteString r100) {
            this._molten_ctx = r100;
            return this;
        }

        public Builder action(HomepageAction r100) {
            this.action = r100;
            return this;
        }

        public Builder data(HomepageListData r100) {
            this.data = r100;
            return this;
        }

        public Builder list_type(HomepageListType r100) {
            this.list_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXf0e8b7511932e1a5 extends ProtoAdapter<FuncParamsXf0e8b7511932e1a5> {
        public ProtoAdapter_FuncParamsXf0e8b7511932e1a5() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXf0e8b7511932e1a5.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXf0e8b7511932e1a5 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.list_type = HomepageListType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.action = HomepageAction.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.data = HomepageListData.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 255) goto L13;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsXf0e8b7511932e1a5 r100) {
            int r101 = (HomepageListType.ADAPTER.encodedSizeWithTag(1, r100.list_type) + HomepageAction.ADAPTER.encodedSizeWithTag(2, r100.action)) + HomepageListData.ADAPTER.encodedSizeWithTag(3, r100.data);
            ByteString r102 = r100._molten_ctx;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsXf0e8b7511932e1a5 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXf0e8b7511932e1a5 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXf0e8b7511932e1a5 r101) throws IOException {
            HomepageListType.ADAPTER.encodeWithTag(r100, 1, r101.list_type);
            HomepageAction.ADAPTER.encodeWithTag(r100, 2, r101.action);
            HomepageListData.ADAPTER.encodeWithTag(r100, 3, r101.data);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXf0e8b7511932e1a5 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXf0e8b7511932e1a5();
        DEFAULT_LIST_TYPE = HomepageListType.VAR_HOMEPAGE_LIST_TYPE_RECENT;
        DEFAULT_ACTION = HomepageAction.VAR_HOMEPAGE_ACTION_REFRESH;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.list_type = this.list_type;
        r100.action = this.action;
        r100.data = this.data;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXf0e8b7511932e1a5.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXf0e8b7511932e1a5(HomepageListType r100, HomepageAction r101, HomepageListData r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsXf0e8b7511932e1a5(HomepageListType r100, HomepageAction r101, HomepageListData r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.list_type = r100;
        this.action = r101;
        this.data = r102;
        this._molten_ctx = r103;
    }
}
