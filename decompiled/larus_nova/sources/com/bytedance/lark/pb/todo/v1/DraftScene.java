package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class DraftScene extends Message<DraftScene, Builder> {
    public static final ProtoAdapter<DraftScene> ADAPTER = null;
    public static final Scene DEFAULT_SCENE = null;
    public static final String DEFAULT_SCENE_ID = "";
    private static final long serialVersionUID = 0;
    public final Scene scene;
    public final String scene_id;

    public static final class Builder extends Message.Builder<DraftScene, Builder> {
        public Scene scene;
        public String scene_id;

        @Override // com.squareup.wire.Message.Builder
        public DraftScene build() {
            return new DraftScene(this.scene, this.scene_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder scene(Scene r100) {
            this.scene = r100;
            return this;
        }

        public Builder scene_id(String r100) {
            this.scene_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DraftScene extends ProtoAdapter<DraftScene> {
        public ProtoAdapter_DraftScene() {
            super(FieldEncoding.LENGTH_DELIMITED, DraftScene.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DraftScene decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.scene = Scene.UNKNOWN_SCENE;
            r101.scene_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.scene = Scene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.scene_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DraftScene r100) {
            Scene r101 = r100.scene;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Scene.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.scene_id;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DraftScene decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DraftScene r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DraftScene r101) throws IOException {
            Scene r102 = r101.scene;
            if (r102 == null) goto L5;
            Scene.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.scene_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DraftScene r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Scene extends Enum<Scene> implements WireEnum {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final ProtoAdapter<Scene> ADAPTER = null;
        public static final Scene CHAT = null;
        public static final Scene CHAT_SIDEBAR = null;
        public static final Scene TODO_CENTER = null;
        public static final Scene UNKNOWN_SCENE = null;
        private final int value;

        static {
            Scene r100 = new Scene("UNKNOWN_SCENE", 0, 0);
            UNKNOWN_SCENE = r100;
            Scene r101 = new Scene("TODO_CENTER", 1, 1);
            TODO_CENTER = r101;
            Scene r102 = new Scene("CHAT", 2, 2);
            CHAT = r102;
            Scene r103 = new Scene("CHAT_SIDEBAR", 3, 3);
            CHAT_SIDEBAR = r103;
            $VALUES = new Scene[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(Scene.class);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Scene fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return CHAT_SIDEBAR;
        L14:
            return CHAT;
        L16:
            return TODO_CENTER;
        L18:
            return UNKNOWN_SCENE;
        }

        public static Scene valueOf(String r100) {
            return (Scene) a.a(Scene.class, r100);
        }

        private Scene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DraftScene();
        DEFAULT_SCENE = Scene.UNKNOWN_SCENE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.scene = this.scene;
        r100.scene_id = this.scene_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DraftScene.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DraftScene(Scene r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DraftScene(Scene r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.scene = r100;
        this.scene_id = r101;
    }
}
