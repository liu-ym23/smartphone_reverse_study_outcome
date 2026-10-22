package com.ss.android.lark.pb.settings;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class UserEmployeeType extends Message<UserEmployeeType, Builder> {
    public static final ProtoAdapter<UserEmployeeType> ADAPTER = null;
    public static final String DEFAULT_EMPLOYEE_TYPE_ID = "";
    public static final String DEFAULT_EMPLOYEE_TYPE_NAME = "";
    private static final long serialVersionUID = 0;
    public final Map<String, String> memployee_type_i18n_name;
    public final String memployee_type_id;
    public final String memployee_type_name;

    public static final class Builder extends Message.Builder<UserEmployeeType, Builder> {
        public Map<String, String> memployee_type_i18n_name;
        public String memployee_type_id;
        public String memployee_type_name;

        @Override // com.squareup.wire.Message.Builder
        public UserEmployeeType build() {
            return new UserEmployeeType(this.memployee_type_id, this.memployee_type_name, this.memployee_type_i18n_name, super.buildUnknownFields());
        }

        public Builder() {
            this.memployee_type_i18n_name = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder employee_type_i18n_name(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.memployee_type_i18n_name = r100;
            return this;
        }

        public Builder employee_type_id(String r100) {
            this.memployee_type_id = r100;
            return this;
        }

        public Builder employee_type_name(String r100) {
            this.memployee_type_name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UserEmployeeType extends ProtoAdapter<UserEmployeeType> {
        private final ProtoAdapter<Map<String, String>> memployee_type_i18n_name;

        public ProtoAdapter_UserEmployeeType() {
            super(FieldEncoding.LENGTH_DELIMITED, UserEmployeeType.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.memployee_type_i18n_name = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UserEmployeeType decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.memployee_type_id = "";
            r101.memployee_type_name = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.memployee_type_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.memployee_type_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.memployee_type_i18n_name.putAll(this.memployee_type_i18n_name.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UserEmployeeType r100) {
            String r101 = r100.memployee_type_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.memployee_type_name;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + this.memployee_type_i18n_name.encodedSizeWithTag(3, r100.memployee_type_i18n_name)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UserEmployeeType decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserEmployeeType r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserEmployeeType r101) throws IOException {
            String r102 = r101.memployee_type_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.memployee_type_name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            this.memployee_type_i18n_name.encodeWithTag(r100, 3, r101.memployee_type_i18n_name);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserEmployeeType r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserEmployeeType();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.memployee_type_id = this.memployee_type_id;
        r100.memployee_type_name = this.memployee_type_name;
        r100.memployee_type_i18n_name = Internal.copyOf("memployee_type_i18n_name", this.memployee_type_i18n_name);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserEmployeeType.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserEmployeeType(String r100, String r101, Map<String, String> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public UserEmployeeType(String r100, String r101, Map<String, String> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.memployee_type_id = r100;
        this.memployee_type_name = r101;
        this.memployee_type_i18n_name = Internal.immutableCopyOf("memployee_type_i18n_name", r102);
    }
}
