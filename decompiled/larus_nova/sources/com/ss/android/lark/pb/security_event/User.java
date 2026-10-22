package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class User extends Message<User, Builder> {
    public static final ProtoAdapter<User> ADAPTER = null;
    public static final String DEFAULT_USERID = "";
    private static final long serialVersionUID = 0;
    public final String mUserID;
    public final I18nText mUserName;
    public final UserType mUserType;

    public static final class Builder extends Message.Builder<User, Builder> {
        public String mUserID;
        public I18nText mUserName;
        public UserType mUserType;

        @Override // com.squareup.wire.Message.Builder
        public User build() {
            return new User(this.mUserID, this.mUserType, this.mUserName, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder UserID(String r100) {
            this.mUserID = r100;
            return this;
        }

        public Builder UserName(I18nText r100) {
            this.mUserName = r100;
            return this;
        }

        public Builder UserType(UserType r100) {
            this.mUserType = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_User extends ProtoAdapter<User> {
        public ProtoAdapter_User() {
            super(FieldEncoding.LENGTH_DELIMITED, User.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public User decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mUserID = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mUserID = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mUserType = UserType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mUserName = I18nText.ADAPTER.decode(r100);
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
        public int encodedSize2(User r100) {
            String r101 = r100.mUserID;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            UserType r104 = r100.mUserType;
            if (r104 == null) goto L9;
            int r105 = UserType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            I18nText r107 = r100.mUserName;
            if (r107 == null) goto L14;
            r102 = I18nText.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ User decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(User r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, User r101) throws IOException {
            String r102 = r101.mUserID;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            UserType r103 = r101.mUserType;
            if (r103 == null) goto L8;
            UserType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            I18nText r104 = r101.mUserName;
            if (r104 == null) goto L11;
            I18nText.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, User r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_User();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mUserID = this.mUserID;
        r100.mUserType = this.mUserType;
        r100.mUserName = this.mUserName;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return User.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public User(String r100, UserType r101, I18nText r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public User(String r100, UserType r101, I18nText r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mUserID = r100;
        this.mUserType = r101;
        this.mUserName = r102;
    }
}
