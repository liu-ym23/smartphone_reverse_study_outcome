package com.ss.android.lark.pb.office_ai;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.pb.entities.ChatContext;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class FetchQuickActionByIDRequest extends Message<FetchQuickActionByIDRequest, Builder> {
    public static final ProtoAdapter<FetchQuickActionByIDRequest> ADAPTER = null;
    public static final String DEFAULT_ACTION_ID = "";
    public static final String DEFAULT_AI_CHAT_MODE_ID = "";
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_CHECK_ID = "";
    public static final String DEFAULT_SYSTEM_META_DATA = "";
    public static final Long DEFAULT_THREAD_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final String maction_id;
    public final String mai_chat_mode_id;
    public final ChatContext mchat_context;
    public final String mchat_id;
    public final String mcheck_id;
    public final String msystem_meta_data;
    public final Long mthread_id;

    public static final class Builder extends Message.Builder<FetchQuickActionByIDRequest, Builder> {
        public String maction_id;
        public String mai_chat_mode_id;
        public ChatContext mchat_context;
        public String mchat_id;
        public String mcheck_id;
        public String msystem_meta_data;
        public Long mthread_id;

        @Override // com.squareup.wire.Message.Builder
        public FetchQuickActionByIDRequest build() {
            return new FetchQuickActionByIDRequest(this.maction_id, this.mchat_id, this.mai_chat_mode_id, this.mcheck_id, this.mchat_context, this.msystem_meta_data, this.mthread_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action_id(String r100) {
            this.maction_id = r100;
            return this;
        }

        public Builder ai_chat_mode_id(String r100) {
            this.mai_chat_mode_id = r100;
            return this;
        }

        public Builder chat_context(ChatContext r100) {
            this.mchat_context = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.mchat_id = r100;
            return this;
        }

        public Builder check_id(String r100) {
            this.mcheck_id = r100;
            return this;
        }

        public Builder system_meta_data(String r100) {
            this.msystem_meta_data = r100;
            return this;
        }

        public Builder thread_id(Long r100) {
            this.mthread_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FetchQuickActionByIDRequest extends ProtoAdapter<FetchQuickActionByIDRequest> {
        public ProtoAdapter_FetchQuickActionByIDRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, FetchQuickActionByIDRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FetchQuickActionByIDRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.maction_id = "";
            r101.mchat_id = "";
            r101.mai_chat_mode_id = "";
            r101.mcheck_id = "";
            r101.msystem_meta_data = "";
            r101.mthread_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.mthread_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.msystem_meta_data = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.mchat_context = ChatContext.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.mcheck_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.mai_chat_mode_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.mchat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.maction_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FetchQuickActionByIDRequest r100) {
            String r101 = r100.maction_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mchat_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mai_chat_mode_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mcheck_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            ChatContext r113 = r100.mchat_context;
            if (r113 == null) goto L21;
            int r114 = ChatContext.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.msystem_meta_data;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Long r119 = r100.mthread_id;
            if (r119 == null) goto L30;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(7, r119);
        L30:
            return (r118 + r102) + r100.unknownFields().size();
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ FetchQuickActionByIDRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FetchQuickActionByIDRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FetchQuickActionByIDRequest r101) throws IOException {
            String r102 = r101.maction_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mchat_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mai_chat_mode_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mcheck_id;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            ChatContext r106 = r101.mchat_context;
            if (r106 == null) goto L17;
            ChatContext.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.msystem_meta_data;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            Long r108 = r101.mthread_id;
            if (r108 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FetchQuickActionByIDRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FetchQuickActionByIDRequest();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().FieldInfo("split,type=channel").build();
        DEFAULT_THREAD_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.maction_id = this.maction_id;
        r100.mchat_id = this.mchat_id;
        r100.mai_chat_mode_id = this.mai_chat_mode_id;
        r100.mcheck_id = this.mcheck_id;
        r100.mchat_context = this.mchat_context;
        r100.msystem_meta_data = this.msystem_meta_data;
        r100.mthread_id = this.mthread_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FetchQuickActionByIDRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FetchQuickActionByIDRequest(String r110, String r111, String r112, String r113, ChatContext r114, String r115, Long r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public FetchQuickActionByIDRequest(String r100, String r101, String r102, String r103, ChatContext r104, String r105, Long r106, ByteString r107) {
        super(ADAPTER, r107);
        this.maction_id = r100;
        this.mchat_id = r101;
        this.mai_chat_mode_id = r102;
        this.mcheck_id = r103;
        this.mchat_context = r104;
        this.msystem_meta_data = r105;
        this.mthread_id = r106;
    }
}
