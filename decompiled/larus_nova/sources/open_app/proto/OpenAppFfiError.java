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
public final class OpenAppFfiError extends Message<OpenAppFfiError, Builder> {
    public static final ProtoAdapter<OpenAppFfiError> ADAPTER = null;
    public static final Integer DEFAULT_ERROR_CODE = null;
    public static final String DEFAULT_ERROR_MSG = "";
    private static final long serialVersionUID = 0;
    public final Integer error_code;
    public final String error_msg;

    public static final class Builder extends Message.Builder<OpenAppFfiError, Builder> {
        public Integer error_code;
        public String error_msg;

        @Override // com.squareup.wire.Message.Builder
        public OpenAppFfiError build() {
            String r100 = this.error_msg;
            if (r100 == null) goto L9;
            if (this.error_code == null) goto L9;
            return new OpenAppFfiError(this.error_msg, this.error_code, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "error_msg", this.error_code, "error_code"});
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
    }

    public static final class ProtoAdapter_OpenAppFfiError extends ProtoAdapter<OpenAppFfiError> {
        public ProtoAdapter_OpenAppFfiError() {
            super(FieldEncoding.LENGTH_DELIMITED, OpenAppFfiError.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public OpenAppFfiError decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.error_msg = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.error_code = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(OpenAppFfiError r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.error_msg) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.error_code)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OpenAppFfiError decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OpenAppFfiError r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OpenAppFfiError r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.error_msg);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.error_code);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OpenAppFfiError r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OpenAppFfiError();
        DEFAULT_ERROR_CODE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.error_msg = this.error_msg;
        r100.error_code = this.error_code;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OpenAppFfiError.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OpenAppFfiError(String r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public OpenAppFfiError(String r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.error_msg = r100;
        this.error_code = r101;
    }
}
