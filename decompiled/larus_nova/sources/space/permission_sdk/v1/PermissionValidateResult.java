package space.permission_sdk.v1;

import annotation.Debug;
import com.google.protobuf.EnumOptions;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final class PermissionValidateResult extends Message<PermissionValidateResult, Builder> {
    public static final ProtoAdapter<PermissionValidateResult> ADAPTER = null;
    public static final PermissionDenied DEFAULT_DENIED = null;
    public static final PermissionGranted DEFAULT_GRANTED = null;
    public static final FieldOptions FIELD_OPTIONS_DENIEDV2 = null;
    public static final FieldOptions FIELD_OPTIONS_GRANTED = null;
    private static final long serialVersionUID = 0;
    public final PermissionDenied Denied;
    public final PermissionDeniedV2 DeniedV2;
    public final PermissionGranted Granted;

    public static final class Builder extends Message.Builder<PermissionValidateResult, Builder> {
        public PermissionDenied Denied;
        public PermissionDeniedV2 DeniedV2;
        public PermissionGranted Granted;

        @Override // com.squareup.wire.Message.Builder
        public PermissionValidateResult build() {
            return new PermissionValidateResult(this.Denied, this.Granted, this.DeniedV2, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder Denied(PermissionDenied r100) {
            this.Denied = r100;
            this.Granted = null;
            this.DeniedV2 = null;
            return this;
        }

        public Builder DeniedV2(PermissionDeniedV2 r100) {
            this.DeniedV2 = r100;
            this.Denied = null;
            this.Granted = null;
            return this;
        }

        public Builder Granted(PermissionGranted r100) {
            this.Granted = r100;
            this.Denied = null;
            this.DeniedV2 = null;
            return this;
        }
    }

    public static final enum PermissionDenied extends Enum<PermissionDenied> implements WireEnum {
        private static final /* synthetic */ PermissionDenied[] $VALUES = null;
        public static final ProtoAdapter<PermissionDenied> ADAPTER = null;
        public static final EnumOptions ENUM_OPTIONS = null;
        public static final PermissionDenied authz = null;
        public static final PermissionDenied dlp_content_detecting = null;
        public static final PermissionDenied dlp_content_sensitive = null;
        public static final PermissionDenied file_policy = null;
        public static final PermissionDenied internal_error = null;
        public static final PermissionDenied net_failed = null;
        public static final PermissionDenied tt_block = null;
        public static final PermissionDenied unknown = null;
        public static final PermissionDenied userpermission_denied = null;
        public static final PermissionDenied userpermission_others = null;
        private final int value;

        static {
            PermissionDenied r100 = new PermissionDenied("unknown", 0, 0);
            unknown = r100;
            PermissionDenied r101 = new PermissionDenied("net_failed", 1, 1);
            net_failed = r101;
            PermissionDenied r102 = new PermissionDenied("authz", 2, 2);
            authz = r102;
            PermissionDenied r103 = new PermissionDenied("file_policy", 3, 3);
            file_policy = r103;
            PermissionDenied r104 = new PermissionDenied("dlp_content_detecting", 4, 4);
            dlp_content_detecting = r104;
            PermissionDenied r105 = new PermissionDenied("dlp_content_sensitive", 5, 5);
            dlp_content_sensitive = r105;
            PermissionDenied r110 = new PermissionDenied("tt_block", 6, 6);
            tt_block = r110;
            PermissionDenied r111 = new PermissionDenied("userpermission_denied", 7, 7);
            userpermission_denied = r111;
            PermissionDenied r112 = new PermissionDenied("userpermission_others", 8, 8);
            userpermission_others = r112;
            PermissionDenied r113 = new PermissionDenied("internal_error", 9, 9);
            internal_error = r113;
            $VALUES = new PermissionDenied[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
            ADAPTER = ProtoAdapter.newEnumAdapter(PermissionDenied.class);
            ENUM_OPTIONS = new EnumOptions.Builder().deprecated(Boolean.TRUE).build();
        }

        public static PermissionDenied[] values() {
            return (PermissionDenied[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static PermissionDenied fromValue(int r100) {
            switch(r100) {
                case 0: goto L24;
                case 1: goto L22;
                case 2: goto L20;
                case 3: goto L18;
                case 4: goto L16;
                case 5: goto L14;
                case 6: goto L12;
                case 7: goto L10;
                case 8: goto L8;
                case 9: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return internal_error;
        L8:
            return userpermission_others;
        L10:
            return userpermission_denied;
        L12:
            return tt_block;
        L14:
            return dlp_content_sensitive;
        L16:
            return dlp_content_detecting;
        L18:
            return file_policy;
        L20:
            return authz;
        L22:
            return net_failed;
        L24:
            return unknown;
        }

        public static PermissionDenied valueOf(String r100) {
            return (PermissionDenied) a.a(PermissionDenied.class, r100);
        }

        private PermissionDenied(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum PermissionGranted extends Enum<PermissionGranted> implements WireEnum {
        private static final /* synthetic */ PermissionGranted[] $VALUES = null;
        public static final ProtoAdapter<PermissionGranted> ADAPTER = null;
        public static final PermissionGranted permission_granted = null;
        private final int value;

        static {
            PermissionGranted r100 = new PermissionGranted("permission_granted", 0, 0);
            permission_granted = r100;
            $VALUES = new PermissionGranted[]{r100};
            ADAPTER = ProtoAdapter.newEnumAdapter(PermissionGranted.class);
        }

        public static PermissionGranted[] values() {
            return (PermissionGranted[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static PermissionGranted fromValue(int r100) {
            if (r100 == 0) goto L6;
            return null;
        L6:
            return permission_granted;
        }

        public static PermissionGranted valueOf(String r100) {
            return (PermissionGranted) a.a(PermissionGranted.class, r100);
        }

        private PermissionGranted(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_PermissionValidateResult extends ProtoAdapter<PermissionValidateResult> {
        public ProtoAdapter_PermissionValidateResult() {
            super(FieldEncoding.LENGTH_DELIMITED, PermissionValidateResult.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public PermissionValidateResult decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.Denied(PermissionDenied.unknown);
            r101.Granted(PermissionGranted.permission_granted);
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.Denied(PermissionDenied.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.Granted(PermissionGranted.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.DeniedV2(PermissionDeniedV2.ADAPTER.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PermissionValidateResult r100) {
            PermissionDenied r101 = r100.Denied;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = PermissionDenied.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            PermissionGranted r104 = r100.Granted;
            if (r104 == null) goto L9;
            int r105 = PermissionGranted.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            PermissionDeniedV2 r107 = r100.DeniedV2;
            if (r107 == null) goto L14;
            r102 = PermissionDeniedV2.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PermissionValidateResult decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PermissionValidateResult r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PermissionValidateResult r101) throws IOException {
            PermissionDenied r102 = r101.Denied;
            if (r102 == null) goto L5;
            PermissionDenied.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            PermissionGranted r103 = r101.Granted;
            if (r103 == null) goto L8;
            PermissionGranted.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            PermissionDeniedV2 r104 = r101.DeniedV2;
            if (r104 == null) goto L11;
            PermissionDeniedV2.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PermissionValidateResult r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PermissionValidateResult();
        FIELD_OPTIONS_GRANTED = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_DENIEDV2 = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_DENIED = PermissionDenied.unknown;
        DEFAULT_GRANTED = PermissionGranted.permission_granted;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.Denied = this.Denied;
        r100.Granted = this.Granted;
        r100.DeniedV2 = this.DeniedV2;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PermissionValidateResult.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PermissionValidateResult(PermissionDenied r100, PermissionGranted r101, PermissionDeniedV2 r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PermissionValidateResult(PermissionDenied r100, PermissionGranted r101, PermissionDeniedV2 r102, ByteString r103) {
        super(ADAPTER, r103);
        if (Internal.countNonNull(r100, r101, r102) > 1) goto L7;
        this.Denied = r100;
        this.Granted = r101;
        this.DeniedV2 = r102;
        return;
    L7:
        throw new IllegalArgumentException("at most one of Denied, Granted, DeniedV2 may be non-null");
    }
}
