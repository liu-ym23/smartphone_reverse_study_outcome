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
public final class FuncParamsXf1672a73e1398765 extends Message<FuncParamsXf1672a73e1398765, Builder> {
    public static final ProtoAdapter<FuncParamsXf1672a73e1398765> ADAPTER = null;
    public static final String DEFAULT_FILE_PATH = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
    public final String file_path;

    public static final class Builder extends Message.Builder<FuncParamsXf1672a73e1398765, Builder> {
        public String file_path;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXf1672a73e1398765 build() {
            String r100 = this.file_path;
            if (r100 == null) goto L7;
            return new FuncParamsXf1672a73e1398765(this.file_path, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "file_path"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder file_path(String r100) {
            this.file_path = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXf1672a73e1398765 extends ProtoAdapter<FuncParamsXf1672a73e1398765> {
        public ProtoAdapter_FuncParamsXf1672a73e1398765() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXf1672a73e1398765.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXf1672a73e1398765 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.file_path(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(FuncParamsXf1672a73e1398765 r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.file_path) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public FuncParamsXf1672a73e1398765 redact2(FuncParamsXf1672a73e1398765 r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsXf1672a73e1398765 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXf1672a73e1398765 r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsXf1672a73e1398765 redact(FuncParamsXf1672a73e1398765 r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXf1672a73e1398765 r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.file_path);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXf1672a73e1398765 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXf1672a73e1398765();
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (unknownFields().hashCode() * 37) + this.file_path.hashCode();
        this.hashCode = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.file_path = this.file_path;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(", file_path=");
        r100.append(this.file_path);
        StringBuilder r101 = r100.replace(0, 2, "FuncParamsXf1672a73e1398765{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXf1672a73e1398765(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof FuncParamsXf1672a73e1398765) == true) goto L8;
        return false;
    L8:
        FuncParamsXf1672a73e1398765 r101 = (FuncParamsXf1672a73e1398765) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.file_path.equals(r101.file_path) == false) goto L13;
        return true;
    }

    public FuncParamsXf1672a73e1398765(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.file_path = r100;
    }
}
