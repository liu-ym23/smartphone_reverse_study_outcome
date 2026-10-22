package open_app.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.cert.manager.constants.EventConstant;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsXf62a6b8ca76d7c2d extends Message<FuncParamsXf62a6b8ca76d7c2d, Builder> {
    public static final ProtoAdapter<FuncParamsXf62a6b8ca76d7c2d> ADAPTER = null;
    public static final String DEFAULT_RAW_DATA = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final Map<String, UserSummary> data;
    public final String raw_data;

    public static final class Builder extends Message.Builder<FuncParamsXf62a6b8ca76d7c2d, Builder> {
        public ByteString _molten_ctx;
        public Map<String, UserSummary> data;
        public String raw_data;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXf62a6b8ca76d7c2d build() {
            String r100 = this.raw_data;
            if (r100 == null) goto L7;
            return new FuncParamsXf62a6b8ca76d7c2d(this.data, this.raw_data, this._molten_ctx, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, EventConstant.Key.RAW_DATA});
        }

        public Builder() {
            this.data = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder _molten_ctx(ByteString r100) {
            this._molten_ctx = r100;
            return this;
        }

        public Builder data(Map<String, UserSummary> r100) {
            Internal.checkElementsNotNull(r100);
            this.data = r100;
            return this;
        }

        public Builder raw_data(String r100) {
            this.raw_data = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXf62a6b8ca76d7c2d extends ProtoAdapter<FuncParamsXf62a6b8ca76d7c2d> {
        private final ProtoAdapter<Map<String, UserSummary>> data;

        public ProtoAdapter_FuncParamsXf62a6b8ca76d7c2d() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXf62a6b8ca76d7c2d.class);
            this.data = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, UserSummary.ADAPTER);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXf62a6b8ca76d7c2d decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.data.putAll(this.data.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.raw_data = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 255) goto L11;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
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
        public int encodedSize2(FuncParamsXf62a6b8ca76d7c2d r100) {
            int r101 = this.data.encodedSizeWithTag(1, r100.data) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.raw_data);
            ByteString r102 = r100._molten_ctx;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsXf62a6b8ca76d7c2d decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXf62a6b8ca76d7c2d r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXf62a6b8ca76d7c2d r101) throws IOException {
            this.data.encodeWithTag(r100, 1, r101.data);
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.raw_data);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXf62a6b8ca76d7c2d r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXf62a6b8ca76d7c2d();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.data = Internal.copyOf("data", this.data);
        r100.raw_data = this.raw_data;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXf62a6b8ca76d7c2d.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXf62a6b8ca76d7c2d(Map<String, UserSummary> r100, String r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FuncParamsXf62a6b8ca76d7c2d(Map<String, UserSummary> r100, String r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.data = Internal.immutableCopyOf("data", r100);
        this.raw_data = r101;
        this._molten_ctx = r102;
    }
}
