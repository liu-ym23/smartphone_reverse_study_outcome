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
public final class FuncReturnX761cd52bf4d57b0f extends Message<FuncReturnX761cd52bf4d57b0f, Builder> {
    public static final ProtoAdapter<FuncReturnX761cd52bf4d57b0f> ADAPTER = null;
    public static final Long DEFAULT_RET = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.REQUIRED, tag = 1)
    public final Long ret;

    public static final class Builder extends Message.Builder<FuncReturnX761cd52bf4d57b0f, Builder> {
        public Long ret;

        @Override // com.squareup.wire.Message.Builder
        public FuncReturnX761cd52bf4d57b0f build() {
            Long r100 = this.ret;
            if (r100 == null) goto L7;
            return new FuncReturnX761cd52bf4d57b0f(this.ret, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "ret"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ret(Long r100) {
            this.ret = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncReturnX761cd52bf4d57b0f extends ProtoAdapter<FuncReturnX761cd52bf4d57b0f> {
        public ProtoAdapter_FuncReturnX761cd52bf4d57b0f() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncReturnX761cd52bf4d57b0f.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncReturnX761cd52bf4d57b0f decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.ret(ProtoAdapter.INT64.decode(r100));
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
        public int encodedSize2(FuncReturnX761cd52bf4d57b0f r100) {
            return ProtoAdapter.INT64.encodedSizeWithTag(1, r100.ret) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public FuncReturnX761cd52bf4d57b0f redact2(FuncReturnX761cd52bf4d57b0f r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncReturnX761cd52bf4d57b0f decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncReturnX761cd52bf4d57b0f r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncReturnX761cd52bf4d57b0f redact(FuncReturnX761cd52bf4d57b0f r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncReturnX761cd52bf4d57b0f r101) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.ret);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncReturnX761cd52bf4d57b0f r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncReturnX761cd52bf4d57b0f();
        DEFAULT_RET = 0L;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (unknownFields().hashCode() * 37) + this.ret.hashCode();
        this.hashCode = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.ret = this.ret;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(", ret=");
        r100.append(this.ret);
        StringBuilder r101 = r100.replace(0, 2, "FuncReturnX761cd52bf4d57b0f{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncReturnX761cd52bf4d57b0f(Long r100) {
        this(r100, ByteString.EMPTY);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof FuncReturnX761cd52bf4d57b0f) == true) goto L8;
        return false;
    L8:
        FuncReturnX761cd52bf4d57b0f r101 = (FuncReturnX761cd52bf4d57b0f) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.ret.equals(r101.ret) == false) goto L13;
        return true;
    }

    public FuncReturnX761cd52bf4d57b0f(Long r100, ByteString r101) {
        super(ADAPTER, r101);
        this.ret = r100;
    }
}
