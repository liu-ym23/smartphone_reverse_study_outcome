package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TodoSourceMeego extends Message<TodoSourceMeego, Builder> {
    public static final ProtoAdapter<TodoSourceMeego> ADAPTER = null;
    public static final String DEFAULT_MEEGO_LINK = "";
    public static final String DEFAULT_PROJECT_KEY = "";
    public static final String DEFAULT_STATE_KEY = "";
    public static final String DEFAULT_SUBTASK_ID = "";
    public static final String DEFAULT_WORK_ITEM_ICON_COLOR = "";
    public static final String DEFAULT_WORK_ITEM_ICON_KEY = "";
    public static final String DEFAULT_WORK_ITEM_ID = "";
    public static final String DEFAULT_WORK_ITEM_NAME = "";
    public static final String DEFAULT_WORK_ITEM_TYPE_KEY = "";
    private static final long serialVersionUID = 0;
    public final String meego_link;
    public final String project_key;
    public final String state_key;
    public final String subtask_id;
    public final String work_item_icon_color;
    public final String work_item_icon_key;
    public final String work_item_id;
    public final String work_item_name;
    public final String work_item_type_key;

    public static final class Builder extends Message.Builder<TodoSourceMeego, Builder> {
        public String meego_link;
        public String project_key;
        public String state_key;
        public String subtask_id;
        public String work_item_icon_color;
        public String work_item_icon_key;
        public String work_item_id;
        public String work_item_name;
        public String work_item_type_key;

        @Override // com.squareup.wire.Message.Builder
        public TodoSourceMeego build() {
            return new TodoSourceMeego(this.project_key, this.work_item_type_key, this.work_item_id, this.state_key, this.subtask_id, this.work_item_name, this.work_item_icon_key, this.work_item_icon_color, this.meego_link, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder meego_link(String r100) {
            this.meego_link = r100;
            return this;
        }

        public Builder project_key(String r100) {
            this.project_key = r100;
            return this;
        }

        public Builder state_key(String r100) {
            this.state_key = r100;
            return this;
        }

        public Builder subtask_id(String r100) {
            this.subtask_id = r100;
            return this;
        }

        public Builder work_item_icon_color(String r100) {
            this.work_item_icon_color = r100;
            return this;
        }

        public Builder work_item_icon_key(String r100) {
            this.work_item_icon_key = r100;
            return this;
        }

        public Builder work_item_id(String r100) {
            this.work_item_id = r100;
            return this;
        }

        public Builder work_item_name(String r100) {
            this.work_item_name = r100;
            return this;
        }

        public Builder work_item_type_key(String r100) {
            this.work_item_type_key = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TodoSourceMeego extends ProtoAdapter<TodoSourceMeego> {
        public ProtoAdapter_TodoSourceMeego() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoSourceMeego.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoSourceMeego decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.project_key = "";
            r101.work_item_type_key = "";
            r101.work_item_id = "";
            r101.state_key = "";
            r101.subtask_id = "";
            r101.work_item_name = "";
            r101.work_item_icon_key = "";
            r101.work_item_icon_color = "";
            r101.meego_link = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r101.meego_link = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.work_item_icon_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.work_item_icon_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.work_item_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.subtask_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.state_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.work_item_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.work_item_type_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.project_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TodoSourceMeego r100) {
            String r101 = r100.project_key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.work_item_type_key;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.work_item_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.state_key;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.subtask_id;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.work_item_name;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.work_item_icon_key;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.work_item_icon_color;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            String r125 = r100.meego_link;
            if (r125 == null) goto L38;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(9, r125);
        L38:
            return (r124 + r102) + r100.unknownFields().size();
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
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
        public /* bridge */ /* synthetic */ TodoSourceMeego decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoSourceMeego r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoSourceMeego r101) throws IOException {
            String r102 = r101.project_key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.work_item_type_key;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.work_item_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.state_key;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.subtask_id;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.work_item_name;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.work_item_icon_key;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.work_item_icon_color;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            String r110 = r101.meego_link;
            if (r110 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r110);
        L29:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoSourceMeego r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TodoSourceMeego();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.project_key = this.project_key;
        r100.work_item_type_key = this.work_item_type_key;
        r100.work_item_id = this.work_item_id;
        r100.state_key = this.state_key;
        r100.subtask_id = this.subtask_id;
        r100.work_item_name = this.work_item_name;
        r100.work_item_icon_key = this.work_item_icon_key;
        r100.work_item_icon_color = this.work_item_icon_color;
        r100.meego_link = this.meego_link;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoSourceMeego.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoSourceMeego(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public TodoSourceMeego(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, ByteString r111) {
        super(ADAPTER, r111);
        this.project_key = r100;
        this.work_item_type_key = r101;
        this.work_item_id = r102;
        this.state_key = r103;
        this.subtask_id = r104;
        this.work_item_name = r105;
        this.work_item_icon_key = r106;
        this.work_item_icon_color = r107;
        this.meego_link = r110;
    }
}
