package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class TodoChat extends Message<TodoChat, Builder> {
    public static final ProtoAdapter<TodoChat> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_CHAT_ID = "";
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final String mavatar_key;
    public final String mchat_id;
    public final Boolean mis_cross_tenant;
    public final String mname;

    public static final class Builder extends Message.Builder<TodoChat, Builder> {
        public String mavatar_key;
        public String mchat_id;
        public Boolean mis_cross_tenant;
        public String mname;

        @Override // com.squareup.wire.Message.Builder
        public TodoChat build() {
            return new TodoChat(this.mchat_id, this.mname, this.mavatar_key, this.mis_cross_tenant, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder avatar_key(String r100) {
            this.mavatar_key = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.mchat_id = r100;
            return this;
        }

        public Builder is_cross_tenant(Boolean r100) {
            this.mis_cross_tenant = r100;
            return this;
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TodoChat extends ProtoAdapter<TodoChat> {
        public ProtoAdapter_TodoChat() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoChat.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoChat decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mchat_id = "";
            r101.mname = "";
            r101.mavatar_key = "";
            r101.mis_cross_tenant = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mchat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mavatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mis_cross_tenant = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(TodoChat r100) {
            String r101 = r100.mchat_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mname;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mavatar_key;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.mis_cross_tenant;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ TodoChat decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoChat r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoChat r101) throws IOException {
            String r102 = r101.mchat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mname;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mavatar_key;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.mis_cross_tenant;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoChat r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TodoChat();
        DEFAULT_IS_CROSS_TENANT = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mchat_id = this.mchat_id;
        r100.mname = this.mname;
        r100.mavatar_key = this.mavatar_key;
        r100.mis_cross_tenant = this.mis_cross_tenant;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoChat.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoChat(String r100, String r101, String r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public TodoChat(String r100, String r101, String r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mchat_id = r100;
        this.mname = r101;
        this.mavatar_key = r102;
        this.mis_cross_tenant = r103;
    }
}
