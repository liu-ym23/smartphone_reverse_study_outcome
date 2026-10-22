package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsX0aae7bf6900be3c2 extends Message<FuncParamsX0aae7bf6900be3c2, Builder> {
    public static final ProtoAdapter<FuncParamsX0aae7bf6900be3c2> ADAPTER = null;
    public static final String DEFAULT_CONTAINER_ID = "";
    public static final Long DEFAULT_UID = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final String container_id;
    public final ForegroundUserContainerScope context;
    public final Long uid;

    public static final class Builder extends Message.Builder<FuncParamsX0aae7bf6900be3c2, Builder> {
        public ByteString _molten_ctx;
        public String container_id;
        public ForegroundUserContainerScope context;
        public Long uid;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX0aae7bf6900be3c2 build() {
            ForegroundUserContainerScope r100 = this.context;
            if (r100 == null) goto L11;
            if (this.container_id == null) goto L11;
            if (this.uid == null) goto L11;
            return new FuncParamsX0aae7bf6900be3c2(this.context, this.container_id, this.uid, this._molten_ctx, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, PerfLog.PARAM_KEY_CONTEXT_ID, this.container_id, "container_id", this.uid, "uid"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder _molten_ctx(ByteString r100) {
            this._molten_ctx = r100;
            return this;
        }

        public Builder container_id(String r100) {
            this.container_id = r100;
            return this;
        }

        public Builder context(ForegroundUserContainerScope r100) {
            this.context = r100;
            return this;
        }

        public Builder uid(Long r100) {
            this.uid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX0aae7bf6900be3c2 extends ProtoAdapter<FuncParamsX0aae7bf6900be3c2> {
        public ProtoAdapter_FuncParamsX0aae7bf6900be3c2() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX0aae7bf6900be3c2.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX0aae7bf6900be3c2 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.context = ForegroundUserContainerScope.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.container_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.uid = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L12:
            if (r103 != 255) goto L13;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsX0aae7bf6900be3c2 r100) {
            int r101 = (ForegroundUserContainerScope.ADAPTER.encodedSizeWithTag(1, r100.context) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.container_id)) + ProtoAdapter.UINT64.encodedSizeWithTag(3, r100.uid);
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
        public /* bridge */ /* synthetic */ FuncParamsX0aae7bf6900be3c2 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX0aae7bf6900be3c2 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX0aae7bf6900be3c2 r101) throws IOException {
            ForegroundUserContainerScope.ADAPTER.encodeWithTag(r100, 1, r101.context);
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.container_id);
            ProtoAdapter.UINT64.encodeWithTag(r100, 3, r101.uid);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX0aae7bf6900be3c2 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX0aae7bf6900be3c2();
        DEFAULT_UID = 0L;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.context = this.context;
        r100.container_id = this.container_id;
        r100.uid = this.uid;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX0aae7bf6900be3c2.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX0aae7bf6900be3c2(ForegroundUserContainerScope r100, String r101, Long r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsX0aae7bf6900be3c2(ForegroundUserContainerScope r100, String r101, Long r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.context = r100;
        this.container_id = r101;
        this.uid = r102;
        this._molten_ctx = r103;
    }
}
