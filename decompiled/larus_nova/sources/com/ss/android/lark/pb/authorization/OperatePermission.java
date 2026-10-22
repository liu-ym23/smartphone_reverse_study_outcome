package com.ss.android.lark.pb.authorization;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class OperatePermission extends Message<OperatePermission, Builder> {
    public static final ProtoAdapter<OperatePermission> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Entity mobject;
    public final PermissionType mperm_type;
    public final ResultType mresult;

    public static final class Builder extends Message.Builder<OperatePermission, Builder> {
        public Entity mobject;
        public PermissionType mperm_type;
        public ResultType mresult;

        @Override // com.squareup.wire.Message.Builder
        public OperatePermission build() {
            PermissionType r100 = this.mperm_type;
            if (r100 == null) goto L11;
            if (this.mresult == null) goto L11;
            if (this.mobject == null) goto L11;
            return new OperatePermission(this.mperm_type, this.mresult, this.mobject, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "mperm_type", this.mresult, "mresult", this.mobject, "mobject"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder object(Entity r100) {
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

    public static final class ProtoAdapter_OperatePermission extends ProtoAdapter<OperatePermission> {
        public ProtoAdapter_OperatePermission() {
            super(FieldEncoding.LENGTH_DELIMITED, OperatePermission.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OperatePermission decode(ProtoReader r100) throws IOException {
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
            r101.mobject = Entity.ADAPTER.decode(r100);
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
        public int encodedSize2(OperatePermission r100) {
            return ((PermissionType.ADAPTER.encodedSizeWithTag(1, r100.mperm_type) + ResultType.ADAPTER.encodedSizeWithTag(2, r100.mresult)) + Entity.ADAPTER.encodedSizeWithTag(3, r100.mobject)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OperatePermission decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OperatePermission r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OperatePermission r101) throws IOException {
            PermissionType.ADAPTER.encodeWithTag(r100, 1, r101.mperm_type);
            ResultType.ADAPTER.encodeWithTag(r100, 2, r101.mresult);
            Entity.ADAPTER.encodeWithTag(r100, 3, r101.mobject);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OperatePermission r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OperatePermission();
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
        return OperatePermission.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OperatePermission(PermissionType r100, ResultType r101, Entity r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public OperatePermission(PermissionType r100, ResultType r101, Entity r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mperm_type = r100;
        this.mresult = r101;
        this.mobject = r102;
    }
}
