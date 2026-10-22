package open_app.proto;

import com.android.ttcjpaysdk.thirdparty.fingerprint.CJPayFingerprintSharedPrefUtils;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class TtCode extends Message<TtCode, Builder> {
    public static final ProtoAdapter<TtCode> ADAPTER = null;
    public static final String DEFAULT_CODE = "";
    public static final String DEFAULT_IV = "";
    public static final String DEFAULT_KEY = "";
    private static final long serialVersionUID = 0;
    public final String code;

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    public final String f524830iv;
    public final String key;

    public static final class Builder extends Message.Builder<TtCode, Builder> {
        public String code;

        /* JADX INFO: renamed from: iv, reason: collision with root package name */
        public String f524831iv;
        public String key;

        @Override // com.squareup.wire.Message.Builder
        public TtCode build() {
            String r100 = this.key;
            if (r100 == null) goto L11;
            if (this.f524831iv == null) goto L11;
            if (this.code == null) goto L11;
            return new TtCode(this.key, this.f524831iv, this.code, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "key", this.f524831iv, CJPayFingerprintSharedPrefUtils.KEY_IV, this.code, "code"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder code(String r100) {
            this.code = r100;
            return this;
        }

        public Builder iv(String r100) {
            this.f524831iv = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TtCode extends ProtoAdapter<TtCode> {
        public ProtoAdapter_TtCode() {
            super(FieldEncoding.LENGTH_DELIMITED, TtCode.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public TtCode decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.f524831iv = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.code = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TtCode r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((r101.encodedSizeWithTag(1, r100.key) + r101.encodedSizeWithTag(2, r100.f524830iv)) + r101.encodedSizeWithTag(3, r100.code)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TtCode decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TtCode r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TtCode r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.key);
            r102.encodeWithTag(r100, 2, r101.f524830iv);
            r102.encodeWithTag(r100, 3, r101.code);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TtCode r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TtCode();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.f524831iv = this.f524830iv;
        r100.code = this.code;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TtCode.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TtCode(String r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public TtCode(String r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.key = r100;
        this.f524830iv = r101;
        this.code = r102;
    }
}
