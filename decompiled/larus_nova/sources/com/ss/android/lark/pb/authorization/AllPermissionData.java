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
public final class AllPermissionData extends Message<AllPermissionData, Builder> {
    public static final ProtoAdapter<AllPermissionData> ADAPTER = null;
    public static final Long DEFAULT_EXPIRE_TIME = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    private static final long serialVersionUID = 0;
    public final List<CustomizedOperatePermission> mcustomized_operate_permission_data;
    public final Long mexpire_time;
    public final List<ExtendedOperatePermission> mextended_operate_permission_data;
    public final List<OperatePermission> moperate_permission_data;
    public final Long mupdate_time;

    public static final class Builder extends Message.Builder<AllPermissionData, Builder> {
        public List<CustomizedOperatePermission> mcustomized_operate_permission_data;
        public Long mexpire_time;
        public List<ExtendedOperatePermission> mextended_operate_permission_data;
        public List<OperatePermission> moperate_permission_data;
        public Long mupdate_time;

        @Override // com.squareup.wire.Message.Builder
        public AllPermissionData build() {
            Long r100 = this.mupdate_time;
            if (r100 == null) goto L9;
            if (this.mexpire_time == null) goto L9;
            return new AllPermissionData(this.mupdate_time, this.mexpire_time, this.moperate_permission_data, this.mextended_operate_permission_data, this.mcustomized_operate_permission_data, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "mupdate_time", this.mexpire_time, "mexpire_time"});
        }

        public Builder() {
            this.moperate_permission_data = Internal.newMutableList();
            this.mextended_operate_permission_data = Internal.newMutableList();
            this.mcustomized_operate_permission_data = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder customized_operate_permission_data(List<CustomizedOperatePermission> r100) {
            Internal.checkElementsNotNull(r100);
            this.mcustomized_operate_permission_data = r100;
            return this;
        }

        public Builder expire_time(Long r100) {
            this.mexpire_time = r100;
            return this;
        }

        public Builder extended_operate_permission_data(List<ExtendedOperatePermission> r100) {
            Internal.checkElementsNotNull(r100);
            this.mextended_operate_permission_data = r100;
            return this;
        }

        public Builder operate_permission_data(List<OperatePermission> r100) {
            Internal.checkElementsNotNull(r100);
            this.moperate_permission_data = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.mupdate_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AllPermissionData extends ProtoAdapter<AllPermissionData> {
        public ProtoAdapter_AllPermissionData() {
            super(FieldEncoding.LENGTH_DELIMITED, AllPermissionData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AllPermissionData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mupdate_time = 0L;
            r101.mexpire_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mupdate_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mexpire_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.moperate_permission_data.add(OperatePermission.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.mextended_operate_permission_data.add(ExtendedOperatePermission.ADAPTER.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.mcustomized_operate_permission_data.add(CustomizedOperatePermission.ADAPTER.decode(r100));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AllPermissionData r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            return ((((r101.encodedSizeWithTag(1, r100.mupdate_time) + r101.encodedSizeWithTag(2, r100.mexpire_time)) + OperatePermission.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.moperate_permission_data)) + ExtendedOperatePermission.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.mextended_operate_permission_data)) + CustomizedOperatePermission.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.mcustomized_operate_permission_data)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AllPermissionData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AllPermissionData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AllPermissionData r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.mupdate_time);
            r102.encodeWithTag(r100, 2, r101.mexpire_time);
            OperatePermission.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.moperate_permission_data);
            ExtendedOperatePermission.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.mextended_operate_permission_data);
            CustomizedOperatePermission.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.mcustomized_operate_permission_data);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AllPermissionData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AllPermissionData();
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_EXPIRE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mupdate_time = this.mupdate_time;
        r100.mexpire_time = this.mexpire_time;
        r100.moperate_permission_data = Internal.copyOf("moperate_permission_data", this.moperate_permission_data);
        r100.mextended_operate_permission_data = Internal.copyOf("mextended_operate_permission_data", this.mextended_operate_permission_data);
        r100.mcustomized_operate_permission_data = Internal.copyOf("mcustomized_operate_permission_data", this.mcustomized_operate_permission_data);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AllPermissionData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AllPermissionData(Long r100, Long r101, List<OperatePermission> r110, List<ExtendedOperatePermission> r111, List<CustomizedOperatePermission> r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public AllPermissionData(Long r100, Long r101, List<OperatePermission> r102, List<ExtendedOperatePermission> r103, List<CustomizedOperatePermission> r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mupdate_time = r100;
        this.mexpire_time = r101;
        this.moperate_permission_data = Internal.immutableCopyOf("moperate_permission_data", r102);
        this.mextended_operate_permission_data = Internal.immutableCopyOf("mextended_operate_permission_data", r103);
        this.mcustomized_operate_permission_data = Internal.immutableCopyOf("mcustomized_operate_permission_data", r104);
    }
}
