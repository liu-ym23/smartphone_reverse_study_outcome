package com.ss.android.lark.pb.chats;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullChatQRCodeTokenRequest extends Message<PullChatQRCodeTokenRequest, Builder> {
    public static final ProtoAdapter<PullChatQRCodeTokenRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Integer DEFAULT_EXPIRED_DAY = null;
    public static final Boolean DEFAULT_IS_UNLIMITED = null;
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final String mchat_id;
    public final Integer mexpired_day;
    public final Boolean mis_unlimited;

    public static final class Builder extends Message.Builder<PullChatQRCodeTokenRequest, Builder> {
        public String mchat_id;
        public Integer mexpired_day;
        public Boolean mis_unlimited;

        @Override // com.squareup.wire.Message.Builder
        public PullChatQRCodeTokenRequest build() {
            String r100 = this.mchat_id;
            if (r100 == null) goto L7;
            return new PullChatQRCodeTokenRequest(this.mchat_id, this.mexpired_day, this.mis_unlimited, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mchat_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.mchat_id = r100;
            return this;
        }

        public Builder expired_day(Integer r100) {
            this.mexpired_day = r100;
            return this;
        }

        public Builder is_unlimited(Boolean r100) {
            this.mis_unlimited = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullChatQRCodeTokenRequest extends ProtoAdapter<PullChatQRCodeTokenRequest> {
        public ProtoAdapter_PullChatQRCodeTokenRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullChatQRCodeTokenRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullChatQRCodeTokenRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mchat_id = "";
            r101.mexpired_day = 7;
            r101.mis_unlimited = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mchat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mexpired_day = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mis_unlimited = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(PullChatQRCodeTokenRequest r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.mchat_id);
            Integer r102 = r100.mexpired_day;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.INT32.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.mis_unlimited;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullChatQRCodeTokenRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullChatQRCodeTokenRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullChatQRCodeTokenRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.mchat_id);
            Integer r102 = r101.mexpired_day;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r102);
        L5:
            Boolean r103 = r101.mis_unlimited;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullChatQRCodeTokenRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullChatQRCodeTokenRequest();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().FieldInfo("split,type=channel").build();
        DEFAULT_EXPIRED_DAY = 7;
        DEFAULT_IS_UNLIMITED = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mchat_id = this.mchat_id;
        r100.mexpired_day = this.mexpired_day;
        r100.mis_unlimited = this.mis_unlimited;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullChatQRCodeTokenRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullChatQRCodeTokenRequest(String r100, Integer r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PullChatQRCodeTokenRequest(String r100, Integer r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mchat_id = r100;
        this.mexpired_day = r101;
        this.mis_unlimited = r102;
    }
}
