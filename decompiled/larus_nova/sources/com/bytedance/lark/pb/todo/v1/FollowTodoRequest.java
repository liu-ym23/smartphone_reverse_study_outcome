package com.bytedance.lark.pb.todo.v1;

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
public final class FollowTodoRequest extends Message<FollowTodoRequest, Builder> {
    public static final ProtoAdapter<FollowTodoRequest> ADAPTER = null;
    public static final Boolean DEFAULT_IS_FOLLOW = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final String DEFAULT_TODO_GUID = "";
    public static final ProtoAdapter_FollowTodoRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final AuthScene auth_scene;
    public final Boolean is_follow;
    public final String message_id;
    public final String todo_guid;

    public static final class Builder extends Message.Builder<FollowTodoRequest, Builder> implements d<FollowTodoRequest> {
        public AuthScene auth_scene;
        public Boolean is_follow;
        public String message_id;
        public String todo_guid;

        @Override // com.squareup.wire.Message.Builder
        public FollowTodoRequest build() {
            return new FollowTodoRequest(this.todo_guid, this.message_id, this.is_follow, this.auth_scene, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder auth_scene(AuthScene r100) {
            this.auth_scene = r100;
            return this;
        }

        public Builder is_follow(Boolean r100) {
            this.is_follow = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder todo_guid(String r100) {
            this.todo_guid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FollowTodoRequest extends ProtoAdapter<FollowTodoRequest> implements c<FollowTodoRequest> {
        public ProtoAdapter_FollowTodoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, FollowTodoRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FollowTodoRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.todo_guid = "";
            r101.message_id = "";
            r101.is_follow = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.todo_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.is_follow = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.auth_scene = AuthScene.ADAPTER.decode(r100);
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
        public int encodedSize2(FollowTodoRequest r100) {
            String r101 = r100.todo_guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.message_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.is_follow;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            AuthScene r110 = r100.auth_scene;
            if (r110 == null) goto L18;
            r102 = AuthScene.ADAPTER.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ FollowTodoRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FollowTodoRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FollowTodoRequest r101) throws IOException {
            String r102 = r101.todo_guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.message_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.is_follow;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            AuthScene r105 = r101.auth_scene;
            if (r105 == null) goto L14;
            AuthScene.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FollowTodoRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_FollowTodoRequest r100 = new ProtoAdapter_FollowTodoRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_IS_FOLLOW = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.todo_guid = this.todo_guid;
        r100.message_id = this.message_id;
        r100.is_follow = this.is_follow;
        r100.auth_scene = this.auth_scene;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FollowTodoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FollowTodoRequest(String r100, String r101, Boolean r102, AuthScene r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FollowTodoRequest(String r100, String r101, Boolean r102, AuthScene r103, ByteString r104) {
        super(ADAPTER, r104);
        this.todo_guid = r100;
        this.message_id = r101;
        this.is_follow = r102;
        this.auth_scene = r103;
    }
}
