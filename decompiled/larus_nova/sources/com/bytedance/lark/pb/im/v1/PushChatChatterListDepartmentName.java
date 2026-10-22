package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushChatChatterListDepartmentName extends Message<PushChatChatterListDepartmentName, Builder> {
    public static final ProtoAdapter<PushChatChatterListDepartmentName> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final ProtoAdapter_PushChatChatterListDepartmentName RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final Map<String, String> chatter_id_to_department_name;

    public static final class Builder extends Message.Builder<PushChatChatterListDepartmentName, Builder> implements d<PushChatChatterListDepartmentName> {
        public String chat_id;
        public Map<String, String> chatter_id_to_department_name;

        @Override // com.squareup.wire.Message.Builder
        public PushChatChatterListDepartmentName build() {
            return new PushChatChatterListDepartmentName(this.chatter_id_to_department_name, this.chat_id, super.buildUnknownFields());
        }

        public Builder() {
            this.chatter_id_to_department_name = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder chatter_id_to_department_name(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatter_id_to_department_name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushChatChatterListDepartmentName extends ProtoAdapter<PushChatChatterListDepartmentName> implements c<PushChatChatterListDepartmentName> {
        private final ProtoAdapter<Map<String, String>> chatter_id_to_department_name;

        public ProtoAdapter_PushChatChatterListDepartmentName() {
            super(FieldEncoding.LENGTH_DELIMITED, PushChatChatterListDepartmentName.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.chatter_id_to_department_name = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushChatChatterListDepartmentName decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.chatter_id_to_department_name.putAll(this.chatter_id_to_department_name.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushChatChatterListDepartmentName r100) {
            int r101 = this.chatter_id_to_department_name.encodedSizeWithTag(1, r100.chatter_id_to_department_name);
            String r102 = r100.chat_id;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushChatChatterListDepartmentName decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushChatChatterListDepartmentName r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushChatChatterListDepartmentName r101) throws IOException {
            this.chatter_id_to_department_name.encodeWithTag(r100, 1, r101.chatter_id_to_department_name);
            String r102 = r101.chat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushChatChatterListDepartmentName r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushChatChatterListDepartmentName r100 = new ProtoAdapter_PushChatChatterListDepartmentName();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chatter_id_to_department_name = Internal.copyOf("chatter_id_to_department_name", this.chatter_id_to_department_name);
        r100.chat_id = this.chat_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushChatChatterListDepartmentName.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushChatChatterListDepartmentName(Map<String, String> r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PushChatChatterListDepartmentName(Map<String, String> r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.chatter_id_to_department_name = Internal.immutableCopyOf("chatter_id_to_department_name", r100);
        this.chat_id = r101;
    }
}
