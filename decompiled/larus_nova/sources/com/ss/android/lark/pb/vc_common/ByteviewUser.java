package com.ss.android.lark.pb.vc_common;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.annotation.Debug;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ByteviewUser extends Message<ByteviewUser, Builder> {
    public static final ProtoAdapter<ByteviewUser> ADAPTER = null;
    public static final String DEFAULT_DEVICE_ID = "";
    public static final String DEFAULT_USER_ID = "";
    public static final FieldOptions FIELD_OPTIONS_MDEVICE_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MUSER_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MUSER_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String mdevice_id;
    public final String muser_id;
    public final ParticipantType muser_type;

    public static final class Builder extends Message.Builder<ByteviewUser, Builder> {
        public String mdevice_id;
        public String muser_id;
        public ParticipantType muser_type;

        @Override // com.squareup.wire.Message.Builder
        public ByteviewUser build() {
            String r100 = this.muser_id;
            if (r100 == null) goto L11;
            if (this.mdevice_id == null) goto L11;
            if (this.muser_type == null) goto L11;
            return new ByteviewUser(this.muser_id, this.mdevice_id, this.muser_type, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "muser_id", this.mdevice_id, "mdevice_id", this.muser_type, "muser_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder device_id(String r100) {
            this.mdevice_id = r100;
            return this;
        }

        public Builder user_id(String r100) {
            this.muser_id = r100;
            return this;
        }

        public Builder user_type(ParticipantType r100) {
            this.muser_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ByteviewUser extends ProtoAdapter<ByteviewUser> {
        public ProtoAdapter_ByteviewUser() {
            super(FieldEncoding.LENGTH_DELIMITED, ByteviewUser.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ByteviewUser decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.muser_id = "";
            r101.mdevice_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.muser_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mdevice_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.muser_type = ParticipantType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ByteviewUser r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((r101.encodedSizeWithTag(1, r100.muser_id) + r101.encodedSizeWithTag(2, r100.mdevice_id)) + ParticipantType.ADAPTER.encodedSizeWithTag(3, r100.muser_type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ByteviewUser decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ByteviewUser r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ByteviewUser r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.muser_id);
            r102.encodeWithTag(r100, 2, r101.mdevice_id);
            ParticipantType.ADAPTER.encodeWithTag(r100, 3, r101.muser_type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ByteviewUser r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ByteviewUser();
        FIELD_OPTIONS_MUSER_ID = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_MDEVICE_ID = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_MUSER_TYPE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.muser_id = this.muser_id;
        r100.mdevice_id = this.mdevice_id;
        r100.muser_type = this.muser_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ByteviewUser.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ByteviewUser(String r100, String r101, ParticipantType r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ByteviewUser(String r100, String r101, ParticipantType r102, ByteString r103) {
        super(ADAPTER, r103);
        this.muser_id = r100;
        this.mdevice_id = r101;
        this.muser_type = r102;
    }
}
