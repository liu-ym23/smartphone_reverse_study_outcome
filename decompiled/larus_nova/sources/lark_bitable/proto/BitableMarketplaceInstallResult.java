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
public final class BitableMarketplaceInstallResult extends Message<BitableMarketplaceInstallResult, Builder> {
    public static final ProtoAdapter<BitableMarketplaceInstallResult> ADAPTER = null;
    public static final String DEFAULT_BASE_APP_TOKEN = "";
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final String base_app_token;
    public final String url;

    public static final class Builder extends Message.Builder<BitableMarketplaceInstallResult, Builder> {
        public String base_app_token;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public BitableMarketplaceInstallResult build() {
            String r100 = this.url;
            if (r100 == null) goto L9;
            if (this.base_app_token == null) goto L9;
            return new BitableMarketplaceInstallResult(this.url, this.base_app_token, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "url", this.base_app_token, "base_app_token"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder base_app_token(String r100) {
            this.base_app_token = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BitableMarketplaceInstallResult extends ProtoAdapter<BitableMarketplaceInstallResult> {
        public ProtoAdapter_BitableMarketplaceInstallResult() {
            super(FieldEncoding.LENGTH_DELIMITED, BitableMarketplaceInstallResult.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public BitableMarketplaceInstallResult decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.base_app_token = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(BitableMarketplaceInstallResult r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (r101.encodedSizeWithTag(1, r100.url) + r101.encodedSizeWithTag(2, r100.base_app_token)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BitableMarketplaceInstallResult decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BitableMarketplaceInstallResult r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BitableMarketplaceInstallResult r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.url);
            r102.encodeWithTag(r100, 2, r101.base_app_token);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BitableMarketplaceInstallResult r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BitableMarketplaceInstallResult();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.url = this.url;
        r100.base_app_token = this.base_app_token;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BitableMarketplaceInstallResult.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BitableMarketplaceInstallResult(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public BitableMarketplaceInstallResult(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.url = r100;
        this.base_app_token = r101;
    }
}
