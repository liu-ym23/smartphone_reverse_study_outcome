package com.bytedance.lark.pb.media.v1;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushSaveToNutStoreStateResponse extends Message<PushSaveToNutStoreStateResponse, Builder> {
    public static final ProtoAdapter<PushSaveToNutStoreStateResponse> ADAPTER = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final String DEFAULT_SOURCE_ID = "";
    public static final com.bytedance.lark.pb.basic.v1.Message.SourceType DEFAULT_SOURCE_TYPE = null;
    public static final SaveState DEFAULT_STATE = null;
    public static final Integer DEFAULT_STATE_CODE = null;
    public static final ProtoAdapter_PushSaveToNutStoreStateResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Entity entity;
    public final String message_id;
    public final String source_id;
    public final com.bytedance.lark.pb.basic.v1.Message.SourceType source_type;
    public final SaveState state;
    public final Integer state_code;

    public static final class Builder extends Message.Builder<PushSaveToNutStoreStateResponse, Builder> implements d<PushSaveToNutStoreStateResponse> {
        public Entity entity;
        public String message_id;
        public String source_id;
        public com.bytedance.lark.pb.basic.v1.Message.SourceType source_type;
        public SaveState state;
        public Integer state_code;

        @Override // com.squareup.wire.Message.Builder
        public PushSaveToNutStoreStateResponse build() {
            String r100 = this.message_id;
            if (r100 == null) goto L9;
            if (this.state == null) goto L9;
            return new PushSaveToNutStoreStateResponse(this.message_id, this.state, this.entity, this.source_id, this.source_type, this.state_code, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, MusicAppletPage.KEY_MESSAGE_ID, this.state, "state"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder entity(Entity r100) {
            this.entity = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder source_id(String r100) {
            this.source_id = r100;
            return this;
        }

        public Builder source_type(com.bytedance.lark.pb.basic.v1.Message.SourceType r100) {
            this.source_type = r100;
            return this;
        }

        public Builder state(SaveState r100) {
            this.state = r100;
            return this;
        }

        public Builder state_code(Integer r100) {
            this.state_code = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushSaveToNutStoreStateResponse extends ProtoAdapter<PushSaveToNutStoreStateResponse> implements c<PushSaveToNutStoreStateResponse> {
        public ProtoAdapter_PushSaveToNutStoreStateResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PushSaveToNutStoreStateResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushSaveToNutStoreStateResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_id = "";
            r101.state = SaveState.SUCCESS;
            r101.source_id = "";
            r101.source_type = com.bytedance.lark.pb.basic.v1.Message.SourceType.TYPE_FROM_UNKONWN;
            r101.state_code = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L23;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L21;
                case 6: goto L7;
                default: goto L6;
            };
        L21:
            r101.source_type = com.bytedance.lark.pb.basic.v1.Message.SourceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L23:
            r101.state = SaveState.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.state_code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            r101.source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.entity = Entity.ADAPTER.decode(r100);
            goto L3
        L18:
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushSaveToNutStoreStateResponse r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.message_id) + SaveState.ADAPTER.encodedSizeWithTag(2, r100.state);
            Entity r103 = r100.entity;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = Entity.ADAPTER.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.source_id;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            com.bytedance.lark.pb.basic.v1.Message.SourceType r110 = r100.source_type;
            if (r110 == null) goto L13;
            int r111 = com.bytedance.lark.pb.basic.v1.Message.SourceType.ADAPTER.encodedSizeWithTag(5, r110);
        L14:
            int r112 = r109 + r111;
            Integer r113 = r100.state_code;
            if (r113 == null) goto L18;
            r104 = ProtoAdapter.INT32.encodedSizeWithTag(6, r113);
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
        public /* bridge */ /* synthetic */ PushSaveToNutStoreStateResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushSaveToNutStoreStateResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushSaveToNutStoreStateResponse r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.message_id);
            SaveState.ADAPTER.encodeWithTag(r100, 2, r101.state);
            Entity r103 = r101.entity;
            if (r103 == null) goto L5;
            Entity.ADAPTER.encodeWithTag(r100, 3, r103);
        L5:
            String r104 = r101.source_id;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            com.bytedance.lark.pb.basic.v1.Message.SourceType r105 = r101.source_type;
            if (r105 == null) goto L11;
            com.bytedance.lark.pb.basic.v1.Message.SourceType.ADAPTER.encodeWithTag(r100, 5, r105);
        L11:
            Integer r106 = r101.state_code;
            if (r106 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r106);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushSaveToNutStoreStateResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum SaveState extends Enum<SaveState> implements WireEnum {
        private static final /* synthetic */ SaveState[] $VALUES = null;
        public static final ProtoAdapter<SaveState> ADAPTER = null;
        public static final SaveState FAILED = null;
        public static final SaveState INIT = null;
        public static final SaveState IN_PROGRESS = null;
        public static final SaveState SUCCESS = null;
        private final int value;

        static {
            SaveState r100 = new SaveState("SUCCESS", 0, 0);
            SUCCESS = r100;
            SaveState r101 = new SaveState("IN_PROGRESS", 1, 1);
            IN_PROGRESS = r101;
            SaveState r102 = new SaveState("FAILED", 2, 2);
            FAILED = r102;
            SaveState r103 = new SaveState(ErrorCode.INIT, 3, 100);
            INIT = r103;
            $VALUES = new SaveState[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(SaveState.class);
        }

        public static SaveState[] values() {
            return (SaveState[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SaveState fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 100) goto L12;
            return null;
        L12:
            return INIT;
        L14:
            return FAILED;
        L16:
            return IN_PROGRESS;
        L18:
            return SUCCESS;
        }

        public static SaveState valueOf(String r100) {
            return (SaveState) a.a(SaveState.class, r100);
        }

        private SaveState(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_PushSaveToNutStoreStateResponse r100 = new ProtoAdapter_PushSaveToNutStoreStateResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STATE = SaveState.SUCCESS;
        DEFAULT_SOURCE_TYPE = com.bytedance.lark.pb.basic.v1.Message.SourceType.TYPE_FROM_UNKONWN;
        DEFAULT_STATE_CODE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_id = this.message_id;
        r100.state = this.state;
        r100.entity = this.entity;
        r100.source_id = this.source_id;
        r100.source_type = this.source_type;
        r100.state_code = this.state_code;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushSaveToNutStoreStateResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushSaveToNutStoreStateResponse(String r100, SaveState r110, Entity r111, String r112, com.bytedance.lark.pb.basic.v1.Message.SourceType r113, Integer r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public PushSaveToNutStoreStateResponse(String r100, SaveState r101, Entity r102, String r103, com.bytedance.lark.pb.basic.v1.Message.SourceType r104, Integer r105, ByteString r106) {
        super(ADAPTER, r106);
        this.message_id = r100;
        this.state = r101;
        this.entity = r102;
        this.source_id = r103;
        this.source_type = r104;
        this.state_code = r105;
    }
}
