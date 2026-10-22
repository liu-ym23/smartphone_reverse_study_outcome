package com.ss.android.lark.pb.chats;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.ChatShareTargetScene;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullChatLinkTokenRequest extends Message<PullChatLinkTokenRequest, Builder> {
    public static final ProtoAdapter<PullChatLinkTokenRequest> ADAPTER = null;
    public static final String DEFAULT_APP_NAME = "";
    public static final String DEFAULT_CHAT_ID = "";
    public static final Integer DEFAULT_EXPIRED_DAY = null;
    public static final Boolean DEFAULT_IS_UNLIMITED = null;
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final String mapp_name;
    public final String mchat_id;
    public final Integer mexpired_day;
    public final Boolean mis_unlimited;
    public final ChatShareTargetScene mtarget_scene;

    public static final class Builder extends Message.Builder<PullChatLinkTokenRequest, Builder> {
        public String mapp_name;
        public String mchat_id;
        public Integer mexpired_day;
        public Boolean mis_unlimited;
        public ChatShareTargetScene mtarget_scene;

        @Override // com.squareup.wire.Message.Builder
        public PullChatLinkTokenRequest build() {
            String r100 = this.mchat_id;
            if (r100 == null) goto L7;
            return new PullChatLinkTokenRequest(this.mchat_id, this.mexpired_day, this.mapp_name, this.mis_unlimited, this.mtarget_scene, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mchat_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_name(String r100) {
            this.mapp_name = r100;
            return this;
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

        public Builder target_scene(ChatShareTargetScene r100) {
            this.mtarget_scene = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullChatLinkTokenRequest extends ProtoAdapter<PullChatLinkTokenRequest> {
        public ProtoAdapter_PullChatLinkTokenRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullChatLinkTokenRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullChatLinkTokenRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mchat_id = "";
            r101.mexpired_day = 7;
            r101.mapp_name = "";
            r101.mis_unlimited = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.mchat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mexpired_day = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mapp_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.mis_unlimited = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.mtarget_scene = ChatShareTargetScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PullChatLinkTokenRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.mchat_id);
            Integer r103 = r100.mexpired_day;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.mapp_name;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            Boolean r110 = r100.mis_unlimited;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            ChatShareTargetScene r113 = r100.mtarget_scene;
            if (r113 == null) goto L18;
            r104 = ChatShareTargetScene.ADAPTER.encodedSizeWithTag(5, r113);
        L18:
            return (r112 + r104) + r100.unknownFields().size();
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullChatLinkTokenRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullChatLinkTokenRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullChatLinkTokenRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mchat_id);
            Integer r103 = r101.mexpired_day;
            if (r103 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.mapp_name;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            Boolean r105 = r101.mis_unlimited;
            if (r105 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L11:
            ChatShareTargetScene r106 = r101.mtarget_scene;
            if (r106 == null) goto L14;
            ChatShareTargetScene.ADAPTER.encodeWithTag(r100, 5, r106);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullChatLinkTokenRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullChatLinkTokenRequest();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().FieldInfo("split,type=channel").build();
        DEFAULT_EXPIRED_DAY = 7;
        DEFAULT_IS_UNLIMITED = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mchat_id = this.mchat_id;
        r100.mexpired_day = this.mexpired_day;
        r100.mapp_name = this.mapp_name;
        r100.mis_unlimited = this.mis_unlimited;
        r100.mtarget_scene = this.mtarget_scene;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullChatLinkTokenRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullChatLinkTokenRequest(String r100, Integer r101, String r110, Boolean r111, ChatShareTargetScene r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public PullChatLinkTokenRequest(String r100, Integer r101, String r102, Boolean r103, ChatShareTargetScene r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mchat_id = r100;
        this.mexpired_day = r101;
        this.mapp_name = r102;
        this.mis_unlimited = r103;
        this.mtarget_scene = r104;
    }
}
