package com.ss.android.lark.pb.department;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.users.Profile;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ProfileFields extends Message<ProfileFields, Builder> {
    public static final ProtoAdapter<ProfileFields> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Profile.Field> mprofile_fields;

    public static final class Builder extends Message.Builder<ProfileFields, Builder> {
        public List<Profile.Field> mprofile_fields;

        @Override // com.squareup.wire.Message.Builder
        public ProfileFields build() {
            return new ProfileFields(this.mprofile_fields, super.buildUnknownFields());
        }

        public Builder() {
            this.mprofile_fields = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder profile_fields(List<Profile.Field> r100) {
            Internal.checkElementsNotNull(r100);
            this.mprofile_fields = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ProfileFields extends ProtoAdapter<ProfileFields> {
        public ProtoAdapter_ProfileFields() {
            super(FieldEncoding.LENGTH_DELIMITED, ProfileFields.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ProfileFields decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mprofile_fields.add(Profile.Field.ADAPTER.decode(r100));
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
        public int encodedSize2(ProfileFields r100) {
            return Profile.Field.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mprofile_fields) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ProfileFields decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ProfileFields r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ProfileFields r101) throws IOException {
            Profile.Field.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mprofile_fields);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ProfileFields r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ProfileFields();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mprofile_fields = Internal.copyOf("mprofile_fields", this.mprofile_fields);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ProfileFields.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ProfileFields(List<Profile.Field> r100) {
        this(r100, ByteString.EMPTY);
    }

    public ProfileFields(List<Profile.Field> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mprofile_fields = Internal.immutableCopyOf("mprofile_fields", r100);
    }
}
