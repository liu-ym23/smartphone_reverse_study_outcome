package com.ss.android.lark.pb.authorization;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PermissionTypeInfo extends Message<PermissionTypeInfo, Builder> {
    public static final ProtoAdapter<PermissionTypeInfo> ADAPTER = null;
    public static final Boolean DEFAULT_FORCE_CLEAR = null;
    private static final long serialVersionUID = 0;
    public final Boolean mforce_clear;
    public final PermissionType mperm_type;

    public static final class Builder extends Message.Builder<PermissionTypeInfo, Builder> {
        public Boolean mforce_clear;
        public PermissionType mperm_type;

        @Override // com.squareup.wire.Message.Builder
        public PermissionTypeInfo build() {
            return new PermissionTypeInfo(this.mperm_type, this.mforce_clear, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder force_clear(Boolean r100) {
            this.mforce_clear = r100;
            return this;
        }

        public Builder perm_type(PermissionType r100) {
            this.mperm_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PermissionTypeInfo extends ProtoAdapter<PermissionTypeInfo> {
        public ProtoAdapter_PermissionTypeInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, PermissionTypeInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PermissionTypeInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mforce_clear = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mperm_type = PermissionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mforce_clear = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(PermissionTypeInfo r100) {
            PermissionType r101 = r100.mperm_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = PermissionType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.mforce_clear;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PermissionTypeInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PermissionTypeInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PermissionTypeInfo r101) throws IOException {
            PermissionType r102 = r101.mperm_type;
            if (r102 == null) goto L5;
            PermissionType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.mforce_clear;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PermissionTypeInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PermissionTypeInfo();
        DEFAULT_FORCE_CLEAR = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mperm_type = this.mperm_type;
        r100.mforce_clear = this.mforce_clear;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PermissionTypeInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PermissionTypeInfo(PermissionType r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PermissionTypeInfo(PermissionType r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mperm_type = r100;
        this.mforce_clear = r101;
    }
}
