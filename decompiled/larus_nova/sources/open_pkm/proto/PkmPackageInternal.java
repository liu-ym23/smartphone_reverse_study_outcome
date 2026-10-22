package open_pkm.proto;

import com.optimize.statistics.FrescoMonitorConst;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class PkmPackageInternal extends Message<PkmPackageInternal, Builder> {
    public static final ProtoAdapter<PkmPackageInternal> ADAPTER = null;
    public static final LoadStatus DEFAULT_LOAD_STATUS = null;
    public static final PkmFrom DEFAULT_PKG_INIT_FROM = null;
    public static final PkmFrom DEFAULT_PKG_RESULT_FROM = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    private static final long serialVersionUID = 0;
    public final LoadStatus load_status;
    public final PkmPackage pkg;
    public final PkmFrom pkg_init_from;
    public final PkmFrom pkg_result_from;
    public final Long update_time;

    public static final class Builder extends Message.Builder<PkmPackageInternal, Builder> {
        public LoadStatus load_status;
        public PkmPackage pkg;
        public PkmFrom pkg_init_from;
        public PkmFrom pkg_result_from;
        public Long update_time;

        @Override // com.squareup.wire.Message.Builder
        public PkmPackageInternal build() {
            PkmPackage r100 = this.pkg;
            if (r100 == null) goto L15;
            if (this.pkg_init_from == null) goto L15;
            if (this.pkg_result_from == null) goto L15;
            if (this.load_status == null) goto L15;
            if (this.update_time == null) goto L15;
            return new PkmPackageInternal(this.pkg, this.pkg_init_from, this.pkg_result_from, this.load_status, this.update_time, super.buildUnknownFields());
        L15:
            throw Internal.missingRequiredFields(new Object[]{r100, "pkg", this.pkg_init_from, "pkg_init_from", this.pkg_result_from, "pkg_result_from", this.load_status, FrescoMonitorConst.LOAD_STATUS, this.update_time, "update_time"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder load_status(LoadStatus r100) {
            this.load_status = r100;
            return this;
        }

        public Builder pkg(PkmPackage r100) {
            this.pkg = r100;
            return this;
        }

        public Builder pkg_init_from(PkmFrom r100) {
            this.pkg_init_from = r100;
            return this;
        }

        public Builder pkg_result_from(PkmFrom r100) {
            this.pkg_result_from = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PkmPackageInternal extends ProtoAdapter<PkmPackageInternal> {
        public ProtoAdapter_PkmPackageInternal() {
            super(FieldEncoding.LENGTH_DELIMITED, PkmPackageInternal.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public PkmPackageInternal decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L30;
            if (r103 != 1) goto L8;
            r101.pkg = PkmPackage.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.pkg_init_from = PkmFrom.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
        L27:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.pkg_result_from = PkmFrom.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.load_status = LoadStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L30:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PkmPackageInternal r100) {
            int r101 = PkmPackage.ADAPTER.encodedSizeWithTag(1, r100.pkg);
            ProtoAdapter<PkmFrom> r102 = PkmFrom.ADAPTER;
            return ((((r101 + r102.encodedSizeWithTag(2, r100.pkg_init_from)) + r102.encodedSizeWithTag(3, r100.pkg_result_from)) + LoadStatus.ADAPTER.encodedSizeWithTag(4, r100.load_status)) + ProtoAdapter.INT64.encodedSizeWithTag(5, r100.update_time)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PkmPackageInternal decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PkmPackageInternal r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PkmPackageInternal r101) throws IOException {
            PkmPackage.ADAPTER.encodeWithTag(r100, 1, r101.pkg);
            ProtoAdapter<PkmFrom> r102 = PkmFrom.ADAPTER;
            r102.encodeWithTag(r100, 2, r101.pkg_init_from);
            r102.encodeWithTag(r100, 3, r101.pkg_result_from);
            LoadStatus.ADAPTER.encodeWithTag(r100, 4, r101.load_status);
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r101.update_time);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PkmPackageInternal r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PkmPackageInternal();
        PkmFrom r100 = PkmFrom.VAR_PKM_FROM_NORMAL;
        DEFAULT_PKG_INIT_FROM = r100;
        DEFAULT_PKG_RESULT_FROM = r100;
        DEFAULT_LOAD_STATUS = LoadStatus.VAR_LOAD_STATUS_INITIAL;
        DEFAULT_UPDATE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.pkg = this.pkg;
        r100.pkg_init_from = this.pkg_init_from;
        r100.pkg_result_from = this.pkg_result_from;
        r100.load_status = this.load_status;
        r100.update_time = this.update_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PkmPackageInternal.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PkmPackageInternal(PkmPackage r100, PkmFrom r101, PkmFrom r110, LoadStatus r111, Long r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public PkmPackageInternal(PkmPackage r100, PkmFrom r101, PkmFrom r102, LoadStatus r103, Long r104, ByteString r105) {
        super(ADAPTER, r105);
        this.pkg = r100;
        this.pkg_init_from = r101;
        this.pkg_result_from = r102;
        this.load_status = r103;
        this.update_time = r104;
    }
}
