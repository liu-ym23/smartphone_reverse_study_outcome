package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class FriendApplicationData extends com.squareup.wire.Message<FriendApplicationData, Builder> {
    public static final ProtoAdapter<FriendApplicationData> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final Long DEFAULT_USER_ID = null;
    public static final String DEFAULT_USER_NAME = "";
    private static final long serialVersionUID = 0;
    public final String avatar_key;
    public final Long user_id;
    public final String user_name;

    public static final class Builder extends com.squareup.wire.Message.Builder<FriendApplicationData, Builder> {
        public String avatar_key;
        public Long user_id;
        public String user_name;

        @Override // com.squareup.wire.Message.Builder
        public FriendApplicationData build() {
            return new FriendApplicationData(this.user_id, this.user_name, this.avatar_key, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder user_id(Long r100) {
            this.user_id = r100;
            return this;
        }

        public Builder user_name(String r100) {
            this.user_name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FriendApplicationData extends ProtoAdapter<FriendApplicationData> {
        public ProtoAdapter_FriendApplicationData() {
            super(FieldEncoding.LENGTH_DELIMITED, FriendApplicationData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FriendApplicationData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.user_id = 0L;
            r101.user_name = "";
            r101.avatar_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.user_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.user_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(FriendApplicationData r100) {
            Long r101 = r100.user_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.user_name;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.avatar_key;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ FriendApplicationData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FriendApplicationData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FriendApplicationData r101) throws IOException {
            Long r102 = r101.user_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.user_name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.avatar_key;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FriendApplicationData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FriendApplicationData();
        DEFAULT_USER_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_id = this.user_id;
        r100.user_name = this.user_name;
        r100.avatar_key = this.avatar_key;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FriendApplicationData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public FriendApplicationData(Long r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FriendApplicationData(Long r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.user_id = r100;
        this.user_name = r101;
        this.avatar_key = r102;
    }
}
