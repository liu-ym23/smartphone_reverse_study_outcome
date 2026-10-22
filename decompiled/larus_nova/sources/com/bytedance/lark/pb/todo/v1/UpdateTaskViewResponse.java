package com.bytedance.lark.pb.todo.v1;

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
public final class UpdateTaskViewResponse extends Message<UpdateTaskViewResponse, Builder> {
    public static final ProtoAdapter<UpdateTaskViewResponse> ADAPTER = null;
    public static final ProtoAdapter_UpdateTaskViewResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, TodoUser> related_users;
    public final TaskView view;

    public static final class Builder extends Message.Builder<UpdateTaskViewResponse, Builder> implements d<UpdateTaskViewResponse> {
        public Map<Long, TodoUser> related_users;
        public TaskView view;

        @Override // com.squareup.wire.Message.Builder
        public UpdateTaskViewResponse build() {
            return new UpdateTaskViewResponse(this.view, this.related_users, super.buildUnknownFields());
        }

        public Builder() {
            this.related_users = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder related_users(Map<Long, TodoUser> r100) {
            Internal.checkElementsNotNull(r100);
            this.related_users = r100;
            return this;
        }

        public Builder view(TaskView r100) {
            this.view = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateTaskViewResponse extends ProtoAdapter<UpdateTaskViewResponse> implements c<UpdateTaskViewResponse> {
        private final ProtoAdapter<Map<Long, TodoUser>> related_users;

        public ProtoAdapter_UpdateTaskViewResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateTaskViewResponse.class);
            this.related_users = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, TodoUser.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateTaskViewResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.view = TaskView.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.related_users.putAll(this.related_users.decode(r100));
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
        public int encodedSize2(UpdateTaskViewResponse r100) {
            TaskView r101 = r100.view;
            if (r101 == null) goto L5;
            int r102 = TaskView.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + this.related_users.encodedSizeWithTag(2, r100.related_users)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateTaskViewResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateTaskViewResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateTaskViewResponse r101) throws IOException {
            TaskView r102 = r101.view;
            if (r102 == null) goto L5;
            TaskView.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            this.related_users.encodeWithTag(r100, 2, r101.related_users);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateTaskViewResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateTaskViewResponse r100 = new ProtoAdapter_UpdateTaskViewResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.view = this.view;
        r100.related_users = Internal.copyOf("related_users", this.related_users);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateTaskViewResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateTaskViewResponse(TaskView r100, Map<Long, TodoUser> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public UpdateTaskViewResponse(TaskView r100, Map<Long, TodoUser> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.view = r100;
        this.related_users = Internal.immutableCopyOf("related_users", r101);
    }
}
