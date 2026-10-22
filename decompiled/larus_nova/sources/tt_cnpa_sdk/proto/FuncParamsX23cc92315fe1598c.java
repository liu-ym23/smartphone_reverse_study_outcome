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
public final class FuncParamsX23cc92315fe1598c extends Message<FuncParamsX23cc92315fe1598c, Builder> {
    public static final ProtoAdapter<FuncParamsX23cc92315fe1598c> ADAPTER = null;
    public static final ByteString DEFAULT_BYTES = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", label = WireField.Label.REQUIRED, tag = 1)
    public final ByteString bytes;

    public static final class Builder extends Message.Builder<FuncParamsX23cc92315fe1598c, Builder> {
        public ByteString bytes;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX23cc92315fe1598c build() {
            ByteString r100 = this.bytes;
            if (r100 == null) goto L7;
            return new FuncParamsX23cc92315fe1598c(this.bytes, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, HTTP.CONTENT_RANGE_BYTES});
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
    }

    public static final class ProtoAdapter_FuncParamsX23cc92315fe1598c extends ProtoAdapter<FuncParamsX23cc92315fe1598c> {
        public ProtoAdapter_FuncParamsX23cc92315fe1598c() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX23cc92315fe1598c.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX23cc92315fe1598c decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.bytes(ProtoAdapter.BYTES.decode(r100));
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
        public int encodedSize2(FuncParamsX23cc92315fe1598c r100) {
            return ProtoAdapter.BYTES.encodedSizeWithTag(1, r100.bytes) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public FuncParamsX23cc92315fe1598c redact2(FuncParamsX23cc92315fe1598c r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX23cc92315fe1598c decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX23cc92315fe1598c r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX23cc92315fe1598c redact(FuncParamsX23cc92315fe1598c r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX23cc92315fe1598c r101) throws IOException {
            ProtoAdapter.BYTES.encodeWithTag(r100, 1, r101.bytes);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX23cc92315fe1598c r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX23cc92315fe1598c();
        DEFAULT_BYTES = ByteString.EMPTY;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (unknownFields().hashCode() * 37) + this.bytes.hashCode();
        this.hashCode = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.bytes = this.bytes;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(", bytes=");
        r100.append(this.bytes);
        StringBuilder r101 = r100.replace(0, 2, "FuncParamsX23cc92315fe1598c{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX23cc92315fe1598c(ByteString r100) {
        this(r100, ByteString.EMPTY);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof FuncParamsX23cc92315fe1598c) == true) goto L8;
        return false;
    L8:
        FuncParamsX23cc92315fe1598c r101 = (FuncParamsX23cc92315fe1598c) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.bytes.equals(r101.bytes) == false) goto L13;
        return true;
    }

    public FuncParamsX23cc92315fe1598c(ByteString r100, ByteString r101) {
        super(ADAPTER, r101);
        this.bytes = r100;
    }
}
