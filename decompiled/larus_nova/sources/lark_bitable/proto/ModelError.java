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
public final class ModelError extends Message<ModelError, Builder> {
    public static final ProtoAdapter<ModelError> ADAPTER = null;
    public static final Long DEFAULT_CODE = null;
    public static final String DEFAULT_MSG = "";
    private static final long serialVersionUID = 0;
    public final Long code;
    public final String msg;

    public static final class Builder extends Message.Builder<ModelError, Builder> {
        public Long code;
        public String msg;

        @Override // com.squareup.wire.Message.Builder
        public ModelError build() {
            Long r100 = this.code;
            if (r100 == null) goto L9;
            if (this.msg == null) goto L9;
            return new ModelError(this.code, this.msg, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "code", this.msg, "msg"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder code(Long r100) {
            this.code = r100;
            return this;
        }

        public Builder msg(String r100) {
            this.msg = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ModelError extends ProtoAdapter<ModelError> {
        public ProtoAdapter_ModelError() {
            super(FieldEncoding.LENGTH_DELIMITED, ModelError.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public ModelError decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.code = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.msg = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(ModelError r100) {
            return (ProtoAdapter.INT64.encodedSizeWithTag(1, r100.code) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.msg)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ModelError decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ModelError r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ModelError r101) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.code);
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.msg);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ModelError r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ModelError();
        DEFAULT_CODE = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.code = this.code;
        r100.msg = this.msg;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ModelError.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ModelError(Long r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ModelError(Long r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.code = r100;
        this.msg = r101;
    }
}
