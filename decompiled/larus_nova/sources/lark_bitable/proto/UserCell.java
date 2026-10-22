package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class UserCell extends Message<UserCell, Builder> {
    public static final ProtoAdapter<UserCell> ADAPTER = null;
    public static final String DEFAULT_AVATAR = "";
    public static final String DEFAULT_TEXT = "";
    private static final long serialVersionUID = 0;
    public final String avatar;
    public final String text;

    public static final class Builder extends Message.Builder<UserCell, Builder> {
        public String avatar;
        public String text;

        @Override // com.squareup.wire.Message.Builder
        public UserCell build() {
            String r100 = this.avatar;
            if (r100 == null) goto L9;
            if (this.text == null) goto L9;
            return new UserCell(this.avatar, this.text, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "avatar", this.text, "text"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder avatar(String r100) {
            this.avatar = r100;
            return this;
        }

        public Builder text(String r100) {
            this.text = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UserCell extends ProtoAdapter<UserCell> {
        public ProtoAdapter_UserCell() {
            super(FieldEncoding.LENGTH_DELIMITED, UserCell.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public UserCell decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.avatar = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.text = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(UserCell r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (r101.encodedSizeWithTag(1, r100.avatar) + r101.encodedSizeWithTag(2, r100.text)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UserCell decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserCell r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserCell r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.avatar);
            r102.encodeWithTag(r100, 2, r101.text);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserCell r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserCell();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.avatar = this.avatar;
        r100.text = this.text;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserCell.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserCell(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public UserCell(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.avatar = r100;
        this.text = r101;
    }
}
