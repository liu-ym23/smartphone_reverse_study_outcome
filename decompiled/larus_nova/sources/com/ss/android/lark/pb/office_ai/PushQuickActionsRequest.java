package com.ss.android.lark.pb.office_ai;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PushQuickActionsRequest extends Message<PushQuickActionsRequest, Builder> {
    public static final ProtoAdapter<PushQuickActionsRequest> ADAPTER = null;
    public static final String DEFAULT_AI_CHAT_MODE_ID = "";
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_ROUND_ID = "";
    public static final String DEFAULT_ROUND_LAST_POSITION = "";
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final String mai_chat_mode_id;
    public final String mchat_id;
    public final String mround_id;
    public final String mround_last_position;

    public static final class Builder extends Message.Builder<PushQuickActionsRequest, Builder> {
        public String mai_chat_mode_id;
        public String mchat_id;
        public String mround_id;
        public String mround_last_position;

        @Override // com.squareup.wire.Message.Builder
        public PushQuickActionsRequest build() {
            return new PushQuickActionsRequest(this.mchat_id, this.mai_chat_mode_id, this.mround_id, this.mround_last_position, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ai_chat_mode_id(String r100) {
            this.mai_chat_mode_id = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.mchat_id = r100;
            return this;
        }

        public Builder round_id(String r100) {
            this.mround_id = r100;
            return this;
        }

        public Builder round_last_position(String r100) {
            this.mround_last_position = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushQuickActionsRequest extends ProtoAdapter<PushQuickActionsRequest> {
        public ProtoAdapter_PushQuickActionsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PushQuickActionsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushQuickActionsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mchat_id = "";
            r101.mai_chat_mode_id = "";
            r101.mround_id = "";
            r101.mround_last_position = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mchat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mai_chat_mode_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mround_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mround_last_position = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushQuickActionsRequest r100) {
            String r101 = r100.mchat_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mai_chat_mode_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mround_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mround_last_position;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushQuickActionsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushQuickActionsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushQuickActionsRequest r101) throws IOException {
            String r102 = r101.mchat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mai_chat_mode_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mround_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mround_last_position;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushQuickActionsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PushQuickActionsRequest();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().FieldInfo("split,type=channel").build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mchat_id = this.mchat_id;
        r100.mai_chat_mode_id = this.mai_chat_mode_id;
        r100.mround_id = this.mround_id;
        r100.mround_last_position = this.mround_last_position;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushQuickActionsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushQuickActionsRequest(String r100, String r101, String r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PushQuickActionsRequest(String r100, String r101, String r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mchat_id = r100;
        this.mai_chat_mode_id = r101;
        this.mround_id = r102;
        this.mround_last_position = r103;
    }
}
