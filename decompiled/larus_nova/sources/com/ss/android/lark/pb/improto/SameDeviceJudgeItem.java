package com.ss.android.lark.pb.improto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class SameDeviceJudgeItem extends Message<SameDeviceJudgeItem, Builder> {
    public static final ProtoAdapter<SameDeviceJudgeItem> ADAPTER = null;
    public static final String DEFAULT_DEVICE_FINGERPRINT = "";
    public static final Long DEFAULT_DID = null;
    public static final Long DEFAULT_REPORT_TIME_MS = null;
    public static final Long DEFAULT_UID = null;
    private static final long serialVersionUID = 0;
    public final AppId mapp_id;
    public final String mdevice_fingerprint;
    public final Long mdid;
    public final AppId mpeer_app_id;
    public final Long mreport_time_ms;
    public final Long muid;

    public static final class Builder extends Message.Builder<SameDeviceJudgeItem, Builder> {
        public AppId mapp_id;
        public String mdevice_fingerprint;
        public Long mdid;
        public AppId mpeer_app_id;
        public Long mreport_time_ms;
        public Long muid;

        @Override // com.squareup.wire.Message.Builder
        public SameDeviceJudgeItem build() {
            Long r100 = this.muid;
            if (r100 == null) goto L11;
            if (this.mdid == null) goto L11;
            if (this.mdevice_fingerprint == null) goto L11;
            return new SameDeviceJudgeItem(this.mapp_id, this.muid, this.mdid, this.mdevice_fingerprint, this.mpeer_app_id, this.mreport_time_ms, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "muid", this.mdid, "mdid", this.mdevice_fingerprint, "mdevice_fingerprint"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_id(AppId r100) {
            this.mapp_id = r100;
            return this;
        }

        public Builder device_fingerprint(String r100) {
            this.mdevice_fingerprint = r100;
            return this;
        }

        public Builder did(Long r100) {
            this.mdid = r100;
            return this;
        }

        public Builder peer_app_id(AppId r100) {
            this.mpeer_app_id = r100;
            return this;
        }

        public Builder report_time_ms(Long r100) {
            this.mreport_time_ms = r100;
            return this;
        }

        public Builder uid(Long r100) {
            this.muid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SameDeviceJudgeItem extends ProtoAdapter<SameDeviceJudgeItem> {
        public ProtoAdapter_SameDeviceJudgeItem() {
            super(FieldEncoding.LENGTH_DELIMITED, SameDeviceJudgeItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SameDeviceJudgeItem decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.muid = 0L;
            r101.mdid = 0L;
            r101.mdevice_fingerprint = "";
            r101.mreport_time_ms = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L30;
            if (r103 != 1) goto L8;
            r101.mapp_id = AppId.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L28
        L28:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.muid = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mdid = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.mdevice_fingerprint = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L16;
            r101.mpeer_app_id = AppId.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L16:
            if (r103 != 7) goto L17;
            r101.mreport_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L17:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L30:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SameDeviceJudgeItem r100) {
            AppId r101 = r100.mapp_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = AppId.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            ProtoAdapter<Long> r104 = ProtoAdapter.INT64;
            int r105 = ((r103 + r104.encodedSizeWithTag(2, r100.muid)) + r104.encodedSizeWithTag(3, r100.mdid)) + ProtoAdapter.STRING.encodedSizeWithTag(4, r100.mdevice_fingerprint);
            AppId r106 = r100.mpeer_app_id;
            if (r106 == null) goto L9;
            int r107 = AppId.ADAPTER.encodedSizeWithTag(5, r106);
        L10:
            int r108 = r105 + r107;
            Long r109 = r100.mreport_time_ms;
            if (r109 == null) goto L14;
            r102 = r104.encodedSizeWithTag(7, r109);
        L14:
            return (r108 + r102) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SameDeviceJudgeItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SameDeviceJudgeItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SameDeviceJudgeItem r101) throws IOException {
            AppId r102 = r101.mapp_id;
            if (r102 == null) goto L5;
            AppId.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
            r103.encodeWithTag(r100, 2, r101.muid);
            r103.encodeWithTag(r100, 3, r101.mdid);
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r101.mdevice_fingerprint);
            AppId r104 = r101.mpeer_app_id;
            if (r104 == null) goto L8;
            AppId.ADAPTER.encodeWithTag(r100, 5, r104);
        L8:
            Long r105 = r101.mreport_time_ms;
            if (r105 == null) goto L11;
            r103.encodeWithTag(r100, 7, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SameDeviceJudgeItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SameDeviceJudgeItem();
        DEFAULT_UID = 0L;
        DEFAULT_DID = 0L;
        DEFAULT_REPORT_TIME_MS = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mapp_id = this.mapp_id;
        r100.muid = this.muid;
        r100.mdid = this.mdid;
        r100.mdevice_fingerprint = this.mdevice_fingerprint;
        r100.mpeer_app_id = this.mpeer_app_id;
        r100.mreport_time_ms = this.mreport_time_ms;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SameDeviceJudgeItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SameDeviceJudgeItem(AppId r100, Long r110, Long r111, String r112, AppId r113, Long r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public SameDeviceJudgeItem(AppId r100, Long r101, Long r102, String r103, AppId r104, Long r105, ByteString r106) {
        super(ADAPTER, r106);
        this.mapp_id = r100;
        this.muid = r101;
        this.mdid = r102;
        this.mdevice_fingerprint = r103;
        this.mpeer_app_id = r104;
        this.mreport_time_ms = r105;
    }
}
