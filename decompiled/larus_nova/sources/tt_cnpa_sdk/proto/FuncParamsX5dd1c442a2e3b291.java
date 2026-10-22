package tt_cnpa_sdk.proto;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class FuncParamsX5dd1c442a2e3b291 extends Message<FuncParamsX5dd1c442a2e3b291, Builder> {
    public static final ProtoAdapter<FuncParamsX5dd1c442a2e3b291> ADAPTER = null;
    public static final ByteString DEFAULT_BYTES = null;
    public static final Boolean DEFAULT_NEED_VERIFY = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", label = WireField.Label.REQUIRED, tag = 1)
    public final ByteString bytes;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", label = WireField.Label.REQUIRED, tag = 2)
    public final Boolean need_verify;

    public static final class Builder extends Message.Builder<FuncParamsX5dd1c442a2e3b291, Builder> {
        public ByteString bytes;
        public Boolean need_verify;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX5dd1c442a2e3b291 build() {
            ByteString r100 = this.bytes;
            if (r100 == null) goto L9;
            if (this.need_verify == null) goto L9;
            return new FuncParamsX5dd1c442a2e3b291(this.bytes, this.need_verify, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, HTTP.CONTENT_RANGE_BYTES, this.need_verify, "need_verify"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder bytes(ByteString r100) {
            this.bytes = r100;
            return this;
        }

        public Builder need_verify(Boolean r100) {
            this.need_verify = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX5dd1c442a2e3b291 extends ProtoAdapter<FuncParamsX5dd1c442a2e3b291> {
        public ProtoAdapter_FuncParamsX5dd1c442a2e3b291() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX5dd1c442a2e3b291.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX5dd1c442a2e3b291 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.bytes(ProtoAdapter.BYTES.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.need_verify(ProtoAdapter.BOOL.decode(r100));
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
        public int encodedSize2(FuncParamsX5dd1c442a2e3b291 r100) {
            return (ProtoAdapter.BYTES.encodedSizeWithTag(1, r100.bytes) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.need_verify)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public FuncParamsX5dd1c442a2e3b291 redact2(FuncParamsX5dd1c442a2e3b291 r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX5dd1c442a2e3b291 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX5dd1c442a2e3b291 r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX5dd1c442a2e3b291 redact(FuncParamsX5dd1c442a2e3b291 r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX5dd1c442a2e3b291 r101) throws IOException {
            ProtoAdapter.BYTES.encodeWithTag(r100, 1, r101.bytes);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.need_verify);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX5dd1c442a2e3b291 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX5dd1c442a2e3b291();
        DEFAULT_BYTES = ByteString.EMPTY;
        DEFAULT_NEED_VERIFY = Boolean.FALSE;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (((unknownFields().hashCode() * 37) + this.bytes.hashCode()) * 37) + this.need_verify.hashCode();
        this.hashCode = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.bytes = this.bytes;
        r100.need_verify = this.need_verify;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(", bytes=");
        r100.append(this.bytes);
        r100.append(", need_verify=");
        r100.append(this.need_verify);
        StringBuilder r101 = r100.replace(0, 2, "FuncParamsX5dd1c442a2e3b291{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof FuncParamsX5dd1c442a2e3b291) == true) goto L8;
        return false;
    L8:
        FuncParamsX5dd1c442a2e3b291 r101 = (FuncParamsX5dd1c442a2e3b291) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (this.bytes.equals(r101.bytes) == false) goto L15;
        if (this.need_verify.equals(r101.need_verify) == false) goto L15;
        return true;
    }

    public FuncParamsX5dd1c442a2e3b291(ByteString r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FuncParamsX5dd1c442a2e3b291(ByteString r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.bytes = r100;
        this.need_verify = r101;
    }
}
