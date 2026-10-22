package com.ss.android.lark.pb.authorization;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PermissionExtra extends Message<PermissionExtra, Builder> {
    public static final ProtoAdapter<PermissionExtra> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<FeatureGateInfo> mfeature_gate_infos;
    public final List<PermissionTypeInfo> mpermission_type_infos;

    public static final class Builder extends Message.Builder<PermissionExtra, Builder> {
        public List<FeatureGateInfo> mfeature_gate_infos;
        public List<PermissionTypeInfo> mpermission_type_infos;

        @Override // com.squareup.wire.Message.Builder
        public PermissionExtra build() {
            return new PermissionExtra(this.mfeature_gate_infos, this.mpermission_type_infos, super.buildUnknownFields());
        }

        public Builder() {
            this.mfeature_gate_infos = Internal.newMutableList();
            this.mpermission_type_infos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder feature_gate_infos(List<FeatureGateInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.mfeature_gate_infos = r100;
            return this;
        }

        public Builder permission_type_infos(List<PermissionTypeInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.mpermission_type_infos = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PermissionExtra extends ProtoAdapter<PermissionExtra> {
        public ProtoAdapter_PermissionExtra() {
            super(FieldEncoding.LENGTH_DELIMITED, PermissionExtra.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PermissionExtra decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mfeature_gate_infos.add(FeatureGateInfo.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mpermission_type_infos.add(PermissionTypeInfo.ADAPTER.decode(r100));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PermissionExtra r100) {
            return (FeatureGateInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mfeature_gate_infos) + PermissionTypeInfo.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.mpermission_type_infos)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PermissionExtra decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PermissionExtra r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PermissionExtra r101) throws IOException {
            FeatureGateInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mfeature_gate_infos);
            PermissionTypeInfo.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.mpermission_type_infos);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PermissionExtra r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PermissionExtra();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mfeature_gate_infos = Internal.copyOf("mfeature_gate_infos", this.mfeature_gate_infos);
        r100.mpermission_type_infos = Internal.copyOf("mpermission_type_infos", this.mpermission_type_infos);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PermissionExtra.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PermissionExtra(List<FeatureGateInfo> r100, List<PermissionTypeInfo> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PermissionExtra(List<FeatureGateInfo> r100, List<PermissionTypeInfo> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mfeature_gate_infos = Internal.immutableCopyOf("mfeature_gate_infos", r100);
        this.mpermission_type_infos = Internal.immutableCopyOf("mpermission_type_infos", r101);
    }
}
