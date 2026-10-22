package open_app.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class GetMessageContentError extends Message<GetMessageContentError, Builder> {
    public static final ProtoAdapter<GetMessageContentError> ADAPTER = null;
    public static final Integer DEFAULT_ERROR_CODE = null;
    public static final String DEFAULT_ERROR_MSG = "";
    public static final GetMessageContentErrorKind DEFAULT_KIND = null;
    private static final long serialVersionUID = 0;
    public final Integer error_code;
    public final String error_msg;
    public final GetMessageContentErrorKind kind;

    public static final class Builder extends Message.Builder<GetMessageContentError, Builder> {
        public Integer error_code;
        public String error_msg;
        public GetMessageContentErrorKind kind;

        @Override // com.squareup.wire.Message.Builder
        public GetMessageContentError build() {
            GetMessageContentErrorKind r100 = this.kind;
            if (r100 == null) goto L11;
            if (this.error_code == null) goto L11;
            if (this.error_msg == null) goto L11;
            return new GetMessageContentError(this.kind, this.error_code, this.error_msg, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "kind", this.error_code, "error_code", this.error_msg, "error_msg"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder error_code(Integer r100) {
            this.error_code = r100;
            return this;
        }

        public Builder error_msg(String r100) {
            this.error_msg = r100;
            return this;
        }

        public Builder kind(GetMessageContentErrorKind r100) {
            this.kind = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetMessageContentError extends ProtoAdapter<GetMessageContentError> {
        public ProtoAdapter_GetMessageContentError() {
            super(FieldEncoding.LENGTH_DELIMITED, GetMessageContentError.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public GetMessageContentError decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.kind = GetMessageContentErrorKind.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.error_code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.error_msg = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetMessageContentError r100) {
            return ((GetMessageContentErrorKind.ADAPTER.encodedSizeWithTag(1, r100.kind) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.error_code)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r100.error_msg)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetMessageContentError decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetMessageContentError r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetMessageContentError r101) throws IOException {
            GetMessageContentErrorKind.ADAPTER.encodeWithTag(r100, 1, r101.kind);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.error_code);
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r101.error_msg);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetMessageContentError r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetMessageContentError();
        DEFAULT_KIND = GetMessageContentErrorKind.VAR_GET_MESSAGE_CONTENT_ERROR_KIND_INTERNAL_ERROR;
        DEFAULT_ERROR_CODE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.kind = this.kind;
        r100.error_code = this.error_code;
        r100.error_msg = this.error_msg;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetMessageContentError.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetMessageContentError(GetMessageContentErrorKind r100, Integer r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetMessageContentError(GetMessageContentErrorKind r100, Integer r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.kind = r100;
        this.error_code = r101;
        this.error_msg = r102;
    }
}
