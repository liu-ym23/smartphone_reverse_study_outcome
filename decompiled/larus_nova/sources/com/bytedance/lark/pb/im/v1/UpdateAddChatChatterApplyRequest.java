package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.AddChatChatterApply;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UpdateAddChatChatterApplyRequest extends Message<UpdateAddChatChatterApplyRequest, Builder> {
    public static final ProtoAdapter<UpdateAddChatChatterApplyRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_INVITEE_ID = "";
    public static final Boolean DEFAULT_SHOW_BANNER = null;
    public static final AddChatChatterApply.Status DEFAULT_STATUS = null;
    public static final ProtoAdapter_UpdateAddChatChatterApplyRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final String invitee_id;
    public final Boolean show_banner;
    public final AddChatChatterApply.Status status;

    public static final class Builder extends Message.Builder<UpdateAddChatChatterApplyRequest, Builder> implements d<UpdateAddChatChatterApplyRequest> {
        public String chat_id;
        public String invitee_id;
        public Boolean show_banner;
        public AddChatChatterApply.Status status;

        @Override // com.squareup.wire.Message.Builder
        public UpdateAddChatChatterApplyRequest build() {
            String r100 = this.chat_id;
            if (r100 == null) goto L7;
            return new UpdateAddChatChatterApplyRequest(this.chat_id, this.show_banner, this.invitee_id, this.status, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "chat_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder invitee_id(String r100) {
            this.invitee_id = r100;
            return this;
        }

        public Builder show_banner(Boolean r100) {
            this.show_banner = r100;
            return this;
        }

        public Builder status(AddChatChatterApply.Status r100) {
            this.status = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateAddChatChatterApplyRequest extends ProtoAdapter<UpdateAddChatChatterApplyRequest> implements c<UpdateAddChatChatterApplyRequest> {
        public ProtoAdapter_UpdateAddChatChatterApplyRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateAddChatChatterApplyRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateAddChatChatterApplyRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.show_banner = Boolean.FALSE;
            r101.invitee_id = "";
            r101.status = AddChatChatterApply.Status.UNKNOWN_STATUS;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.show_banner = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.invitee_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.status = AddChatChatterApply.Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        public int encodedSize2(UpdateAddChatChatterApplyRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.chat_id);
            Boolean r103 = r100.show_banner;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.invitee_id;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            AddChatChatterApply.Status r110 = r100.status;
            if (r110 == null) goto L14;
            r104 = AddChatChatterApply.Status.ADAPTER.encodedSizeWithTag(4, r110);
        L14:
            return (r109 + r104) + r100.unknownFields().size();
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateAddChatChatterApplyRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateAddChatChatterApplyRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateAddChatChatterApplyRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.chat_id);
            Boolean r103 = r101.show_banner;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.invitee_id;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            AddChatChatterApply.Status r105 = r101.status;
            if (r105 == null) goto L11;
            AddChatChatterApply.Status.ADAPTER.encodeWithTag(r100, 4, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateAddChatChatterApplyRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateAddChatChatterApplyRequest r100 = new ProtoAdapter_UpdateAddChatChatterApplyRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SHOW_BANNER = Boolean.FALSE;
        DEFAULT_STATUS = AddChatChatterApply.Status.UNKNOWN_STATUS;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.show_banner = this.show_banner;
        r100.invitee_id = this.invitee_id;
        r100.status = this.status;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateAddChatChatterApplyRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateAddChatChatterApplyRequest(String r100, Boolean r101, String r102, AddChatChatterApply.Status r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public UpdateAddChatChatterApplyRequest(String r100, Boolean r101, String r102, AddChatChatterApply.Status r103, ByteString r104) {
        super(ADAPTER, r104);
        this.chat_id = r100;
        this.show_banner = r101;
        this.invitee_id = r102;
        this.status = r103;
    }
}
