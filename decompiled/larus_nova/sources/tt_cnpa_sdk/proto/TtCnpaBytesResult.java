package tt_cnpa_sdk.proto;

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
public final class TtCnpaBytesResult extends Message<TtCnpaBytesResult, Builder> {
    public static final ProtoAdapter<TtCnpaBytesResult> ADAPTER = null;
    public static final ByteString DEFAULT_BYTES_RESULT = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 1)
    public final ByteString bytes_result;

    @WireField(adapter = "tt_cnpa_sdk.proto.TtCnpaResult#ADAPTER", label = WireField.Label.REQUIRED, tag = 2)
    public final TtCnpaResult result;

    public static final class Builder extends Message.Builder<TtCnpaBytesResult, Builder> {
        public ByteString bytes_result;
        public TtCnpaResult result;

        @Override // com.squareup.wire.Message.Builder
        public TtCnpaBytesResult build() {
            TtCnpaResult r100 = this.result;
            if (r100 == null) goto L7;
            return new TtCnpaBytesResult(this.bytes_result, this.result, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "result"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder bytes_result(ByteString r100) {
            this.bytes_result = r100;
            return this;
        }

        public Builder result(TtCnpaResult r100) {
            this.result = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TtCnpaBytesResult extends ProtoAdapter<TtCnpaBytesResult> {
        public ProtoAdapter_TtCnpaBytesResult() {
            super(FieldEncoding.LENGTH_DELIMITED, TtCnpaBytesResult.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public TtCnpaBytesResult decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.bytes_result(ProtoAdapter.BYTES.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.result(TtCnpaResult.ADAPTER.decode(r100));
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
        public int encodedSize2(TtCnpaBytesResult r100) {
            return (ProtoAdapter.BYTES.encodedSizeWithTag(1, r100.bytes_result) + TtCnpaResult.ADAPTER.encodedSizeWithTag(2, r100.result)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public TtCnpaBytesResult redact2(TtCnpaBytesResult r100) {
            Builder r101 = r100.newBuilder();
            r101.result = TtCnpaResult.ADAPTER.redact(r101.result);
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TtCnpaBytesResult decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TtCnpaBytesResult r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TtCnpaBytesResult redact(TtCnpaBytesResult r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TtCnpaBytesResult r101) throws IOException {
            ProtoAdapter.BYTES.encodeWithTag(r100, 1, r101.bytes_result);
            TtCnpaResult.ADAPTER.encodeWithTag(r100, 2, r101.result);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TtCnpaBytesResult r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TtCnpaBytesResult();
        DEFAULT_BYTES_RESULT = ByteString.EMPTY;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L10;
        int r101 = unknownFields().hashCode() * 37;
        ByteString r102 = this.bytes_result;
        if (r102 == null) goto L7;
        int r103 = r102.hashCode();
    L8:
        int r104 = ((r101 + r103) * 37) + this.result.hashCode();
        this.hashCode = r104;
        return r104;
    L7:
        r103 = 0;
        goto L8
    L10:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.bytes_result = this.bytes_result;
        r100.result = this.result;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.bytes_result == null) goto L5;
        r100.append(", bytes_result=");
        r100.append(this.bytes_result);
    L5:
        r100.append(", result=");
        r100.append(this.result);
        StringBuilder r101 = r100.replace(0, 2, "TtCnpaBytesResult{");
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
        if ((r100 instanceof TtCnpaBytesResult) == true) goto L8;
        return false;
    L8:
        TtCnpaBytesResult r101 = (TtCnpaBytesResult) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.bytes_result, r101.bytes_result) == false) goto L15;
        if (this.result.equals(r101.result) == false) goto L15;
        return true;
    }

    public TtCnpaBytesResult(ByteString r100, TtCnpaResult r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TtCnpaBytesResult(ByteString r100, TtCnpaResult r101, ByteString r102) {
        super(ADAPTER, r102);
        this.bytes_result = r100;
        this.result = r101;
    }
}
