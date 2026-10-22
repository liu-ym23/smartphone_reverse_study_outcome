package space.permission_sdk.v1;

import annotation.Debug;
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
public final class PermissionDeniedV2 extends Message<PermissionDeniedV2, Builder> {
    public static final ProtoAdapter<PermissionDeniedV2> ADAPTER = null;
    public static final PermissionDeniedReason DEFAULT_REASON = null;
    public static final String DEFAULT_SECURITY_RAW = "";
    public static final FieldOptions FIELD_OPTIONS_REASON = null;
    public static final FieldOptions FIELD_OPTIONS_SECURITY_RAW = null;
    private static final long serialVersionUID = 0;
    public final PermissionDeniedReason reason;
    public final String security_raw;

    public static final class Builder extends Message.Builder<PermissionDeniedV2, Builder> {
        public PermissionDeniedReason reason;
        public String security_raw;

        @Override // com.squareup.wire.Message.Builder
        public PermissionDeniedV2 build() {
            PermissionDeniedReason r100 = this.reason;
            if (r100 == null) goto L7;
            return new PermissionDeniedV2(this.reason, this.security_raw, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "reason"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder reason(PermissionDeniedReason r100) {
            this.reason = r100;
            return this;
        }

        public Builder security_raw(String r100) {
            this.security_raw = r100;
            return this;
        }
    }

    public static final enum PermissionDeniedReason extends Enum<PermissionDeniedReason> implements WireEnum {
        private static final /* synthetic */ PermissionDeniedReason[] $VALUES = null;
        public static final ProtoAdapter<PermissionDeniedReason> ADAPTER = null;
        public static final PermissionDeniedReason authz = null;
        public static final PermissionDeniedReason dlp_content_detecting = null;
        public static final PermissionDeniedReason dlp_content_sensitive = null;
        public static final PermissionDeniedReason file_policy = null;
        public static final PermissionDeniedReason internal_error = null;
        public static final PermissionDeniedReason net_failed = null;
        public static final PermissionDeniedReason tt_block = null;
        public static final PermissionDeniedReason unknown = null;
        public static final PermissionDeniedReason userpermission_denied = null;
        public static final PermissionDeniedReason userpermission_others = null;
        private final int value;

        static {
            PermissionDeniedReason r100 = new PermissionDeniedReason("unknown", 0, 0);
            unknown = r100;
            PermissionDeniedReason r101 = new PermissionDeniedReason("net_failed", 1, 1);
            net_failed = r101;
            PermissionDeniedReason r102 = new PermissionDeniedReason("authz", 2, 2);
            authz = r102;
            PermissionDeniedReason r103 = new PermissionDeniedReason("file_policy", 3, 3);
            file_policy = r103;
            PermissionDeniedReason r104 = new PermissionDeniedReason("dlp_content_detecting", 4, 4);
            dlp_content_detecting = r104;
            PermissionDeniedReason r105 = new PermissionDeniedReason("dlp_content_sensitive", 5, 5);
            dlp_content_sensitive = r105;
            PermissionDeniedReason r110 = new PermissionDeniedReason("tt_block", 6, 6);
            tt_block = r110;
            PermissionDeniedReason r111 = new PermissionDeniedReason("userpermission_denied", 7, 7);
            userpermission_denied = r111;
            PermissionDeniedReason r112 = new PermissionDeniedReason("userpermission_others", 8, 8);
            userpermission_others = r112;
            PermissionDeniedReason r113 = new PermissionDeniedReason("internal_error", 9, 9);
            internal_error = r113;
            $VALUES = new PermissionDeniedReason[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
            ADAPTER = ProtoAdapter.newEnumAdapter(PermissionDeniedReason.class);
        }

        public static PermissionDeniedReason[] values() {
            return (PermissionDeniedReason[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static PermissionDeniedReason fromValue(int r100) {
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

        public static PermissionDeniedReason valueOf(String r100) {
            return (PermissionDeniedReason) a.a(PermissionDeniedReason.class, r100);
        }

        private PermissionDeniedReason(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_PermissionDeniedV2 extends ProtoAdapter<PermissionDeniedV2> {
        public ProtoAdapter_PermissionDeniedV2() {
            super(FieldEncoding.LENGTH_DELIMITED, PermissionDeniedV2.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public PermissionDeniedV2 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.reason = PermissionDeniedReason.unknown;
            r101.security_raw = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.reason = PermissionDeniedReason.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.security_raw = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(PermissionDeniedV2 r100) {
            int r101 = PermissionDeniedReason.ADAPTER.encodedSizeWithTag(1, r100.reason);
            String r102 = r100.security_raw;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PermissionDeniedV2 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PermissionDeniedV2 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PermissionDeniedV2 r101) throws IOException {
            PermissionDeniedReason.ADAPTER.encodeWithTag(r100, 1, r101.reason);
            String r102 = r101.security_raw;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PermissionDeniedV2 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PermissionDeniedV2();
        FIELD_OPTIONS_REASON = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_SECURITY_RAW = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_REASON = PermissionDeniedReason.unknown;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.reason = this.reason;
        r100.security_raw = this.security_raw;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PermissionDeniedV2.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PermissionDeniedV2(PermissionDeniedReason r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PermissionDeniedV2(PermissionDeniedReason r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.reason = r100;
        this.security_raw = r101;
    }
}
