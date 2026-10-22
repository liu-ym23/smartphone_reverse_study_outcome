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
public final class BitableAppInfo extends Message<BitableAppInfo, Builder> {
    public static final ProtoAdapter<BitableAppInfo> ADAPTER = null;
    public static final Integer DEFAULT_BIZ_TYPE = null;
    private static final long serialVersionUID = 0;
    public final Integer biz_type;

    public static final class Builder extends Message.Builder<BitableAppInfo, Builder> {
        public Integer biz_type;

        @Override // com.squareup.wire.Message.Builder
        public BitableAppInfo build() {
            Integer r100 = this.biz_type;
            if (r100 == null) goto L7;
            return new BitableAppInfo(this.biz_type, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "biz_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder biz_type(Integer r100) {
            this.biz_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BitableAppInfo extends ProtoAdapter<BitableAppInfo> {
        public ProtoAdapter_BitableAppInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, BitableAppInfo.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public BitableAppInfo decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.biz_type = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(BitableAppInfo r100) {
            return ProtoAdapter.INT32.encodedSizeWithTag(1, r100.biz_type) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BitableAppInfo decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BitableAppInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BitableAppInfo r101) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r101.biz_type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BitableAppInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BitableAppInfo();
        DEFAULT_BIZ_TYPE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.biz_type = this.biz_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BitableAppInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BitableAppInfo(Integer r100) {
        this(r100, ByteString.EMPTY);
    }

    public BitableAppInfo(Integer r100, ByteString r101) {
        super(ADAPTER, r101);
        this.biz_type = r100;
    }
}
