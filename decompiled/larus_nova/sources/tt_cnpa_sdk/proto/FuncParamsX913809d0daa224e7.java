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
public final class FuncParamsX913809d0daa224e7 extends Message<FuncParamsX913809d0daa224e7, Builder> {
    public static final ProtoAdapter<FuncParamsX913809d0daa224e7> ADAPTER = null;
    public static final String DEFAULT_TMP_DIR_PATH = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
    public final String tmp_dir_path;

    public static final class Builder extends Message.Builder<FuncParamsX913809d0daa224e7, Builder> {
        public String tmp_dir_path;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX913809d0daa224e7 build() {
            String r100 = this.tmp_dir_path;
            if (r100 == null) goto L7;
            return new FuncParamsX913809d0daa224e7(this.tmp_dir_path, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "tmp_dir_path"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder tmp_dir_path(String r100) {
            this.tmp_dir_path = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX913809d0daa224e7 extends ProtoAdapter<FuncParamsX913809d0daa224e7> {
        public ProtoAdapter_FuncParamsX913809d0daa224e7() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX913809d0daa224e7.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX913809d0daa224e7 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.tmp_dir_path(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(FuncParamsX913809d0daa224e7 r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.tmp_dir_path) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public FuncParamsX913809d0daa224e7 redact2(FuncParamsX913809d0daa224e7 r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX913809d0daa224e7 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX913809d0daa224e7 r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX913809d0daa224e7 redact(FuncParamsX913809d0daa224e7 r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX913809d0daa224e7 r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.tmp_dir_path);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX913809d0daa224e7 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX913809d0daa224e7();
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (unknownFields().hashCode() * 37) + this.tmp_dir_path.hashCode();
        this.hashCode = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.tmp_dir_path = this.tmp_dir_path;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(", tmp_dir_path=");
        r100.append(this.tmp_dir_path);
        StringBuilder r101 = r100.replace(0, 2, "FuncParamsX913809d0daa224e7{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX913809d0daa224e7(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof FuncParamsX913809d0daa224e7) == true) goto L8;
        return false;
    L8:
        FuncParamsX913809d0daa224e7 r101 = (FuncParamsX913809d0daa224e7) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.tmp_dir_path.equals(r101.tmp_dir_path) == false) goto L13;
        return true;
    }

    public FuncParamsX913809d0daa224e7(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.tmp_dir_path = r100;
    }
}
