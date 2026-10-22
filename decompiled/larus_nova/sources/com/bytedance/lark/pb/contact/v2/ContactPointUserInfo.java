package com.bytedance.lark.pb.contact.v2;

import com.bytedance.lark.pb.basic.v1.UserInfo;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ContactPointUserInfo extends Message<ContactPointUserInfo, Builder> {
    public static final ProtoAdapter<ContactPointUserInfo> ADAPTER = null;
    public static final String DEFAULT_CONTACT_POINT = "";
    public static final UserContactStatus DEFAULT_CONTACT_STATUS = null;
    public static final Boolean DEFAULT_SHOULD_HIDDEN = null;
    private static final long serialVersionUID = 0;
    public final String contact_point;
    public final UserContactStatus contact_status;
    public final Boolean should_hidden;
    public final UserInfo user_info;

    public static final class Builder extends Message.Builder<ContactPointUserInfo, Builder> {
        public String contact_point;
        public UserContactStatus contact_status;
        public Boolean should_hidden;
        public UserInfo user_info;

        @Override // com.squareup.wire.Message.Builder
        public ContactPointUserInfo build() {
            String r100 = this.contact_point;
            if (r100 == null) goto L9;
            if (this.user_info == null) goto L9;
            return new ContactPointUserInfo(this.contact_point, this.user_info, this.contact_status, this.should_hidden, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "contact_point", this.user_info, "user_info"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder contact_point(String r100) {
            this.contact_point = r100;
            return this;
        }

        public Builder contact_status(UserContactStatus r100) {
            this.contact_status = r100;
            return this;
        }

        public Builder should_hidden(Boolean r100) {
            this.should_hidden = r100;
            return this;
        }

        public Builder user_info(UserInfo r100) {
            this.user_info = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ContactPointUserInfo extends ProtoAdapter<ContactPointUserInfo> {
        public ProtoAdapter_ContactPointUserInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ContactPointUserInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ContactPointUserInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.contact_point = "";
            r101.contact_status = UserContactStatus.CONTACT_STATUS_NOT_FRIEND;
            r101.should_hidden = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.contact_point = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.user_info = UserInfo.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.contact_status = UserContactStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.should_hidden = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ContactPointUserInfo r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.contact_point) + UserInfo.ADAPTER.encodedSizeWithTag(2, r100.user_info);
            UserContactStatus r102 = r100.contact_status;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = UserContactStatus.ADAPTER.encodedSizeWithTag(3, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.should_hidden;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ContactPointUserInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ContactPointUserInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ContactPointUserInfo r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.contact_point);
            UserInfo.ADAPTER.encodeWithTag(r100, 2, r101.user_info);
            UserContactStatus r102 = r101.contact_status;
            if (r102 == null) goto L5;
            UserContactStatus.ADAPTER.encodeWithTag(r100, 3, r102);
        L5:
            Boolean r103 = r101.should_hidden;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ContactPointUserInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ContactPointUserInfo();
        DEFAULT_CONTACT_STATUS = UserContactStatus.CONTACT_STATUS_NOT_FRIEND;
        DEFAULT_SHOULD_HIDDEN = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.contact_point = this.contact_point;
        r100.user_info = this.user_info;
        r100.contact_status = this.contact_status;
        r100.should_hidden = this.should_hidden;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ContactPointUserInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ContactPointUserInfo(String r100, UserInfo r101, UserContactStatus r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public ContactPointUserInfo(String r100, UserInfo r101, UserContactStatus r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.contact_point = r100;
        this.user_info = r101;
        this.contact_status = r102;
        this.should_hidden = r103;
    }
}
