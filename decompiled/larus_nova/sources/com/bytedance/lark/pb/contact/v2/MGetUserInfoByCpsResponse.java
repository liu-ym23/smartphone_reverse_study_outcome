package com.bytedance.lark.pb.contact.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class MGetUserInfoByCpsResponse extends Message<MGetUserInfoByCpsResponse, Builder> {
    public static final ProtoAdapter<MGetUserInfoByCpsResponse> ADAPTER = null;
    public static final ProtoAdapter_MGetUserInfoByCpsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<ContactPointUserInfo> cp_user_infos;

    public static final class Builder extends Message.Builder<MGetUserInfoByCpsResponse, Builder> implements d<MGetUserInfoByCpsResponse> {
        public List<ContactPointUserInfo> cp_user_infos;

        @Override // com.squareup.wire.Message.Builder
        public MGetUserInfoByCpsResponse build() {
            return new MGetUserInfoByCpsResponse(this.cp_user_infos, super.buildUnknownFields());
        }

        public Builder() {
            this.cp_user_infos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cp_user_infos(List<ContactPointUserInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.cp_user_infos = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MGetUserInfoByCpsResponse extends ProtoAdapter<MGetUserInfoByCpsResponse> implements c<MGetUserInfoByCpsResponse> {
        public ProtoAdapter_MGetUserInfoByCpsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, MGetUserInfoByCpsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MGetUserInfoByCpsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.cp_user_infos.add(ContactPointUserInfo.ADAPTER.decode(r100));
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
        public int encodedSize2(MGetUserInfoByCpsResponse r100) {
            return ContactPointUserInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.cp_user_infos) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MGetUserInfoByCpsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MGetUserInfoByCpsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MGetUserInfoByCpsResponse r101) throws IOException {
            ContactPointUserInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.cp_user_infos);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MGetUserInfoByCpsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MGetUserInfoByCpsResponse r100 = new ProtoAdapter_MGetUserInfoByCpsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.cp_user_infos = Internal.copyOf("cp_user_infos", this.cp_user_infos);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MGetUserInfoByCpsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MGetUserInfoByCpsResponse(List<ContactPointUserInfo> r100) {
        this(r100, ByteString.EMPTY);
    }

    public MGetUserInfoByCpsResponse(List<ContactPointUserInfo> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.cp_user_infos = Internal.immutableCopyOf("cp_user_infos", r100);
    }
}
