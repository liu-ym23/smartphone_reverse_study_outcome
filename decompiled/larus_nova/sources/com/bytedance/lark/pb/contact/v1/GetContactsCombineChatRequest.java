package com.bytedance.lark.pb.contact.v1;

import com.bytedance.lark.pb.basic.v1.ActionType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetContactsCombineChatRequest extends Message<GetContactsCombineChatRequest, Builder> {
    public static final ProtoAdapter<GetContactsCombineChatRequest> ADAPTER = null;
    public static final ActionType DEFAULT_BUSINESS_SCENE = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Integer DEFAULT_COUNT = null;
    public static final String DEFAULT_CURSOR = "0";
    public static final ProtoAdapter_GetContactsCombineChatRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ActionType business_scene;
    public final String chat_id;
    public final Integer count;
    public final String cursor;

    public static final class Builder extends Message.Builder<GetContactsCombineChatRequest, Builder> implements d<GetContactsCombineChatRequest> {
        public ActionType business_scene;
        public String chat_id;
        public Integer count;
        public String cursor;

        @Override // com.squareup.wire.Message.Builder
        public GetContactsCombineChatRequest build() {
            return new GetContactsCombineChatRequest(this.chat_id, this.cursor, this.count, this.business_scene, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder business_scene(ActionType r100) {
            this.business_scene = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder count(Integer r100) {
            this.count = r100;
            return this;
        }

        public Builder cursor(String r100) {
            this.cursor = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetContactsCombineChatRequest extends ProtoAdapter<GetContactsCombineChatRequest> implements c<GetContactsCombineChatRequest> {
        public ProtoAdapter_GetContactsCombineChatRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetContactsCombineChatRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetContactsCombineChatRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.cursor = "0";
            r101.count = 20;
            r101.business_scene = ActionType.UNKNOWN_ACTION;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.cursor = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.business_scene = ActionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
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
        public int encodedSize2(GetContactsCombineChatRequest r100) {
            String r101 = r100.chat_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.cursor;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.count;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ActionType r110 = r100.business_scene;
            if (r110 == null) goto L18;
            r102 = ActionType.ADAPTER.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ GetContactsCombineChatRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetContactsCombineChatRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetContactsCombineChatRequest r101) throws IOException {
            String r102 = r101.chat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.cursor;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.count;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            ActionType r105 = r101.business_scene;
            if (r105 == null) goto L14;
            ActionType.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetContactsCombineChatRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetContactsCombineChatRequest r100 = new ProtoAdapter_GetContactsCombineChatRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_COUNT = 20;
        DEFAULT_BUSINESS_SCENE = ActionType.UNKNOWN_ACTION;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.cursor = this.cursor;
        r100.count = this.count;
        r100.business_scene = this.business_scene;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetContactsCombineChatRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetContactsCombineChatRequest(String r100, String r101, Integer r102, ActionType r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetContactsCombineChatRequest(String r100, String r101, Integer r102, ActionType r103, ByteString r104) {
        super(ADAPTER, r104);
        this.chat_id = r100;
        this.cursor = r101;
        this.count = r102;
        this.business_scene = r103;
    }
}
