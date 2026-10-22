package space.permission_sdk.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class DriveExtraInfo extends Message<DriveExtraInfo, Builder> {
    public static final ProtoAdapter<DriveExtraInfo> ADAPTER = null;
    public static final DriveAppID DEFAULT_APP_ID = null;
    public static final String DEFAULT_EXTRA = "";
    public static final FieldOptions FIELD_OPTIONS_APP_ID = null;
    private static final long serialVersionUID = 0;
    public final DriveAppID app_id;
    public final String extra;

    public static final class Builder extends Message.Builder<DriveExtraInfo, Builder> {
        public DriveAppID app_id;
        public String extra;

        @Override // com.squareup.wire.Message.Builder
        public DriveExtraInfo build() {
            DriveAppID r100 = this.app_id;
            if (r100 == null) goto L7;
            return new DriveExtraInfo(this.app_id, this.extra, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "app_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_id(DriveAppID r100) {
            this.app_id = r100;
            return this;
        }

        public Builder extra(String r100) {
            this.extra = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DriveExtraInfo extends ProtoAdapter<DriveExtraInfo> {
        public ProtoAdapter_DriveExtraInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, DriveExtraInfo.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public DriveExtraInfo decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.app_id = DriveAppID.APPID_SPACE;
            r101.extra = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.app_id = DriveAppID.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.extra = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DriveExtraInfo r100) {
            int r101 = DriveAppID.ADAPTER.encodedSizeWithTag(1, r100.app_id);
            String r102 = r100.extra;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DriveExtraInfo decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DriveExtraInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DriveExtraInfo r101) throws IOException {
            DriveAppID.ADAPTER.encodeWithTag(r100, 1, r101.app_id);
            String r102 = r101.extra;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DriveExtraInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DriveExtraInfo();
        FIELD_OPTIONS_APP_ID = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_APP_ID = DriveAppID.APPID_SPACE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.app_id = this.app_id;
        r100.extra = this.extra;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DriveExtraInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DriveExtraInfo(DriveAppID r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DriveExtraInfo(DriveAppID r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.app_id = r100;
        this.extra = r101;
    }
}
