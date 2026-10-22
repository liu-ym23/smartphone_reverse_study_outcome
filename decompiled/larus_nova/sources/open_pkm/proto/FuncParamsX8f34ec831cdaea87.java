package open_pkm.proto;

import androidx.camera.video.AudioStats;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsX8f34ec831cdaea87 extends Message<FuncParamsX8f34ec831cdaea87, Builder> {
    public static final ProtoAdapter<FuncParamsX8f34ec831cdaea87> ADAPTER = null;
    public static final Double DEFAULT_DOWNLOAD_PROGRESS = null;
    public static final PkmPrepareStep DEFAULT_STEP = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final Double download_progress;
    public final PkmMeta meta;
    public final PkmPackage pkg;
    public final TtPkgHeader pkg_header;
    public final PkmPrepareStep step;

    public static final class Builder extends Message.Builder<FuncParamsX8f34ec831cdaea87, Builder> {
        public ByteString _molten_ctx;
        public Double download_progress;
        public PkmMeta meta;
        public PkmPackage pkg;
        public TtPkgHeader pkg_header;
        public PkmPrepareStep step;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX8f34ec831cdaea87 build() {
            PkmPrepareStep r100 = this.step;
            if (r100 == null) goto L9;
            if (this.download_progress == null) goto L9;
            return new FuncParamsX8f34ec831cdaea87(this.step, this.download_progress, this.meta, this.pkg, this.pkg_header, this._molten_ctx, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "step", this.download_progress, "download_progress"});
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

        public Builder download_progress(Double r100) {
            this.download_progress = r100;
            return this;
        }

        public Builder meta(PkmMeta r100) {
            this.meta = r100;
            return this;
        }

        public Builder pkg(PkmPackage r100) {
            this.pkg = r100;
            return this;
        }

        public Builder pkg_header(TtPkgHeader r100) {
            this.pkg_header = r100;
            return this;
        }

        public Builder step(PkmPrepareStep r100) {
            this.step = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX8f34ec831cdaea87 extends ProtoAdapter<FuncParamsX8f34ec831cdaea87> {
        public ProtoAdapter_FuncParamsX8f34ec831cdaea87() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX8f34ec831cdaea87.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX8f34ec831cdaea87 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            if (r103 != 1) goto L8;
            r101.step = PkmPrepareStep.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.download_progress = ProtoAdapter.DOUBLE.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.meta = PkmMeta.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.pkg = PkmPackage.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L16;
            r101.pkg_header = TtPkgHeader.ADAPTER.decode(r100);
            goto L3
        L16:
            if (r103 != 255) goto L17;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L17:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsX8f34ec831cdaea87 r100) {
            int r101 = PkmPrepareStep.ADAPTER.encodedSizeWithTag(1, r100.step) + ProtoAdapter.DOUBLE.encodedSizeWithTag(2, r100.download_progress);
            PkmMeta r102 = r100.meta;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = PkmMeta.ADAPTER.encodedSizeWithTag(3, r102);
        L6:
            int r105 = r101 + r104;
            PkmPackage r106 = r100.pkg;
            if (r106 == null) goto L9;
            int r107 = PkmPackage.ADAPTER.encodedSizeWithTag(4, r106);
        L10:
            int r108 = r105 + r107;
            TtPkgHeader r109 = r100.pkg_header;
            if (r109 == null) goto L13;
            int r110 = TtPkgHeader.ADAPTER.encodedSizeWithTag(5, r109);
        L14:
            int r111 = r108 + r110;
            ByteString r112 = r100._molten_ctx;
            if (r112 == null) goto L18;
            r103 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r112);
        L18:
            return (r111 + r103) + r100.unknownFields().size();
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX8f34ec831cdaea87 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX8f34ec831cdaea87 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX8f34ec831cdaea87 r101) throws IOException {
            PkmPrepareStep.ADAPTER.encodeWithTag(r100, 1, r101.step);
            ProtoAdapter.DOUBLE.encodeWithTag(r100, 2, r101.download_progress);
            PkmMeta r102 = r101.meta;
            if (r102 == null) goto L5;
            PkmMeta.ADAPTER.encodeWithTag(r100, 3, r102);
        L5:
            PkmPackage r103 = r101.pkg;
            if (r103 == null) goto L8;
            PkmPackage.ADAPTER.encodeWithTag(r100, 4, r103);
        L8:
            TtPkgHeader r104 = r101.pkg_header;
            if (r104 == null) goto L11;
            TtPkgHeader.ADAPTER.encodeWithTag(r100, 5, r104);
        L11:
            ByteString r105 = r101._molten_ctx;
            if (r105 == null) goto L14;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX8f34ec831cdaea87 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX8f34ec831cdaea87();
        DEFAULT_STEP = PkmPrepareStep.VAR_PKM_PREPARE_STEP_LOAD_META_START;
        DEFAULT_DOWNLOAD_PROGRESS = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.step = this.step;
        r100.download_progress = this.download_progress;
        r100.meta = this.meta;
        r100.pkg = this.pkg;
        r100.pkg_header = this.pkg_header;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX8f34ec831cdaea87.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX8f34ec831cdaea87(PkmPrepareStep r100, Double r110, PkmMeta r111, PkmPackage r112, TtPkgHeader r113, ByteString r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public FuncParamsX8f34ec831cdaea87(PkmPrepareStep r100, Double r101, PkmMeta r102, PkmPackage r103, TtPkgHeader r104, ByteString r105, ByteString r106) {
        super(ADAPTER, r106);
        this.step = r100;
        this.download_progress = r101;
        this.meta = r102;
        this.pkg = r103;
        this.pkg_header = r104;
        this._molten_ctx = r105;
    }
}
