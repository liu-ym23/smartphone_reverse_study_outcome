package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class AgentInfo extends Message<AgentInfo, Builder> {
    public static final ProtoAdapter<AgentInfo> ADAPTER = null;
    public static final String DEFAULT_APP_DESCRIPTION = "";
    public static final String DEFAULT_APP_ID = "";
    public static final String DEFAULT_APP_NAME = "";
    public static final String DEFAULT_ICON_URL = "";
    private static final long serialVersionUID = 0;
    public final String app_description;
    public final String app_id;
    public final String app_name;
    public final String icon_url;
    public final SimpleAgentTodo latest_todo_in_progress;

    public static final class Builder extends Message.Builder<AgentInfo, Builder> {
        public String app_description;
        public String app_id;
        public String app_name;
        public String icon_url;
        public SimpleAgentTodo latest_todo_in_progress;

        @Override // com.squareup.wire.Message.Builder
        public AgentInfo build() {
            return new AgentInfo(this.app_id, this.app_name, this.icon_url, this.app_description, this.latest_todo_in_progress, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_description(String r100) {
            this.app_description = r100;
            return this;
        }

        public Builder app_id(String r100) {
            this.app_id = r100;
            return this;
        }

        public Builder app_name(String r100) {
            this.app_name = r100;
            return this;
        }

        public Builder icon_url(String r100) {
            this.icon_url = r100;
            return this;
        }

        public Builder latest_todo_in_progress(SimpleAgentTodo r100) {
            this.latest_todo_in_progress = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AgentInfo extends ProtoAdapter<AgentInfo> {
        public ProtoAdapter_AgentInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, AgentInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AgentInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.app_id = "";
            r101.app_name = "";
            r101.icon_url = "";
            r101.app_description = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.app_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.app_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.icon_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.app_description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.latest_todo_in_progress = SimpleAgentTodo.ADAPTER.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AgentInfo r100) {
            String r101 = r100.app_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.app_name;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.icon_url;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.app_description;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            SimpleAgentTodo r113 = r100.latest_todo_in_progress;
            if (r113 == null) goto L22;
            r102 = SimpleAgentTodo.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ AgentInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AgentInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AgentInfo r101) throws IOException {
            String r102 = r101.app_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.app_name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.icon_url;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.app_description;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            SimpleAgentTodo r106 = r101.latest_todo_in_progress;
            if (r106 == null) goto L17;
            SimpleAgentTodo.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AgentInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AgentInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.app_id = this.app_id;
        r100.app_name = this.app_name;
        r100.icon_url = this.icon_url;
        r100.app_description = this.app_description;
        r100.latest_todo_in_progress = this.latest_todo_in_progress;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AgentInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AgentInfo(String r100, String r101, String r110, String r111, SimpleAgentTodo r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public AgentInfo(String r100, String r101, String r102, String r103, SimpleAgentTodo r104, ByteString r105) {
        super(ADAPTER, r105);
        this.app_id = r100;
        this.app_name = r101;
        this.icon_url = r102;
        this.app_description = r103;
        this.latest_todo_in_progress = r104;
    }
}
