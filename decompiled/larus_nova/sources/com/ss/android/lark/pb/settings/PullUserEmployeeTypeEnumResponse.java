package com.ss.android.lark.pb.settings;

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
public final class PullUserEmployeeTypeEnumResponse extends Message<PullUserEmployeeTypeEnumResponse, Builder> {
    public static final ProtoAdapter<PullUserEmployeeTypeEnumResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<UserEmployeeType> muser_employee_types;

    public static final class Builder extends Message.Builder<PullUserEmployeeTypeEnumResponse, Builder> {
        public List<UserEmployeeType> muser_employee_types;

        @Override // com.squareup.wire.Message.Builder
        public PullUserEmployeeTypeEnumResponse build() {
            return new PullUserEmployeeTypeEnumResponse(this.muser_employee_types, super.buildUnknownFields());
        }

        public Builder() {
            this.muser_employee_types = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder user_employee_types(List<UserEmployeeType> r100) {
            Internal.checkElementsNotNull(r100);
            this.muser_employee_types = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullUserEmployeeTypeEnumResponse extends ProtoAdapter<PullUserEmployeeTypeEnumResponse> {
        public ProtoAdapter_PullUserEmployeeTypeEnumResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullUserEmployeeTypeEnumResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullUserEmployeeTypeEnumResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.muser_employee_types.add(UserEmployeeType.ADAPTER.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PullUserEmployeeTypeEnumResponse r100) {
            return UserEmployeeType.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.muser_employee_types) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullUserEmployeeTypeEnumResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullUserEmployeeTypeEnumResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullUserEmployeeTypeEnumResponse r101) throws IOException {
            UserEmployeeType.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.muser_employee_types);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullUserEmployeeTypeEnumResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullUserEmployeeTypeEnumResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.muser_employee_types = Internal.copyOf("muser_employee_types", this.muser_employee_types);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullUserEmployeeTypeEnumResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullUserEmployeeTypeEnumResponse(List<UserEmployeeType> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PullUserEmployeeTypeEnumResponse(List<UserEmployeeType> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.muser_employee_types = Internal.immutableCopyOf("muser_employee_types", r100);
    }
}
