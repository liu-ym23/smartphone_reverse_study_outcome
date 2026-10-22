package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UpdateChatTabRequest extends Message<UpdateChatTabRequest, Builder> {
    public static final ProtoAdapter<UpdateChatTabRequest> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final ProtoAdapter_UpdateChatTabRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long chat_id;
    public final List<Long> delete_tab_ids;
    public final List<Long> reorder_tab_ids;
    public final Map<Long, ChatTab> update_tab_details;

    public static final class Builder extends Message.Builder<UpdateChatTabRequest, Builder> implements d<UpdateChatTabRequest> {
        public Long chat_id;
        public List<Long> delete_tab_ids;
        public List<Long> reorder_tab_ids;
        public Map<Long, ChatTab> update_tab_details;

        @Override // com.squareup.wire.Message.Builder
        public UpdateChatTabRequest build() {
            return new UpdateChatTabRequest(this.chat_id, this.delete_tab_ids, this.reorder_tab_ids, this.update_tab_details, super.buildUnknownFields());
        }

        public Builder() {
            this.delete_tab_ids = Internal.newMutableList();
            this.reorder_tab_ids = Internal.newMutableList();
            this.update_tab_details = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(Long r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder delete_tab_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.delete_tab_ids = r100;
            return this;
        }

        public Builder reorder_tab_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.reorder_tab_ids = r100;
            return this;
        }

        public Builder update_tab_details(Map<Long, ChatTab> r100) {
            Internal.checkElementsNotNull(r100);
            this.update_tab_details = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateChatTabRequest extends ProtoAdapter<UpdateChatTabRequest> implements c<UpdateChatTabRequest> {
        private final ProtoAdapter<Map<Long, ChatTab>> update_tab_details;

        public ProtoAdapter_UpdateChatTabRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateChatTabRequest.class);
            this.update_tab_details = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, ChatTab.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateChatTabRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.delete_tab_ids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.reorder_tab_ids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.update_tab_details.putAll(this.update_tab_details.decode(r100));
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
        public int encodedSize2(UpdateChatTabRequest r100) {
            Long r101 = r100.chat_id;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
            return (((r102 + r103.asRepeated().encodedSizeWithTag(2, r100.delete_tab_ids)) + r103.asRepeated().encodedSizeWithTag(3, r100.reorder_tab_ids)) + this.update_tab_details.encodedSizeWithTag(4, r100.update_tab_details)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateChatTabRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateChatTabRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateChatTabRequest r101) throws IOException {
            Long r102 = r101.chat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
            r103.asRepeated().encodeWithTag(r100, 2, r101.delete_tab_ids);
            r103.asRepeated().encodeWithTag(r100, 3, r101.reorder_tab_ids);
            this.update_tab_details.encodeWithTag(r100, 4, r101.update_tab_details);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateChatTabRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateChatTabRequest r100 = new ProtoAdapter_UpdateChatTabRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_CHAT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.delete_tab_ids = Internal.copyOf("delete_tab_ids", this.delete_tab_ids);
        r100.reorder_tab_ids = Internal.copyOf("reorder_tab_ids", this.reorder_tab_ids);
        r100.update_tab_details = Internal.copyOf("update_tab_details", this.update_tab_details);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateChatTabRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateChatTabRequest(Long r100, List<Long> r101, List<Long> r102, Map<Long, ChatTab> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public UpdateChatTabRequest(Long r100, List<Long> r101, List<Long> r102, Map<Long, ChatTab> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.chat_id = r100;
        this.delete_tab_ids = Internal.immutableCopyOf("delete_tab_ids", r101);
        this.reorder_tab_ids = Internal.immutableCopyOf("reorder_tab_ids", r102);
        this.update_tab_details = Internal.immutableCopyOf("update_tab_details", r103);
    }
}
