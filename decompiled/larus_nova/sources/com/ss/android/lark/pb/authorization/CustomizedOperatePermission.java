package com.ss.android.lark.pb.authorization;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class CustomizedOperatePermission extends Message<CustomizedOperatePermission, Builder> {
    public static final ProtoAdapter<CustomizedOperatePermission> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final CustomizedEntity mobject;
    public final PermissionType mperm_type;
    public final ResultType mresult;

    public static final class Builder extends Message.Builder<CustomizedOperatePermission, Builder> {
        public CustomizedEntity mobject;
        public PermissionType mperm_type;
        public ResultType mresult;

        @Override // com.squareup.wire.Message.Builder
        public CustomizedOperatePermission build() {
            return new CustomizedOperatePermission(this.mperm_type, this.mresult, this.mobject, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder object(CustomizedEntity r100) {
            this.mobject = r100;
            return this;
        }

        public Builder perm_type(PermissionType r100) {
            this.mperm_type = r100;
            return this;
        }

        public Builder result(ResultType r100) {
            this.mresult = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomizedOperatePermission extends ProtoAdapter<CustomizedOperatePermission> {
        public ProtoAdapter_CustomizedOperatePermission() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomizedOperatePermission.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CustomizedOperatePermission decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mperm_type = PermissionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mresult = ResultType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mobject = CustomizedEntity.ADAPTER.decode(r100);
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
        public int encodedSize2(CustomizedOperatePermission r100) {
            PermissionType r101 = r100.mperm_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = PermissionType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            ResultType r104 = r100.mresult;
            if (r104 == null) goto L9;
            int r105 = ResultType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            CustomizedEntity r107 = r100.mobject;
            if (r107 == null) goto L14;
            r102 = CustomizedEntity.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ CustomizedOperatePermission decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CustomizedOperatePermission r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CustomizedOperatePermission r101) throws IOException {
            PermissionType r102 = r101.mperm_type;
            if (r102 == null) goto L5;
            PermissionType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ResultType r103 = r101.mresult;
            if (r103 == null) goto L8;
            ResultType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            CustomizedEntity r104 = r101.mobject;
            if (r104 == null) goto L11;
            CustomizedEntity.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomizedOperatePermission r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomizedOperatePermission();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mperm_type = this.mperm_type;
        r100.mresult = this.mresult;
        r100.mobject = this.mobject;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CustomizedOperatePermission.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CustomizedOperatePermission(PermissionType r100, ResultType r101, CustomizedEntity r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public CustomizedOperatePermission(PermissionType r100, ResultType r101, CustomizedEntity r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mperm_type = r100;
        this.mresult = r101;
        this.mobject = r102;
    }
}
