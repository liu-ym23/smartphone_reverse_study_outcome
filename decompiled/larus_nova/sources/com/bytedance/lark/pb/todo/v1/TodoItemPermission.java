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

/* JADX INFO: loaded from: classes20.dex */
public final class TodoItemPermission extends Message<TodoItemPermission, Builder> {
    public static final ProtoAdapter<TodoItemPermission> ADAPTER = null;
    public static final Boolean DEFAULT_IS_EDITABLE = null;
    public static final Boolean DEFAULT_IS_READABLE = null;
    private static final long serialVersionUID = 0;
    public final Map<Integer, Boolean> can_edit_commit_keys;
    public final Map<Integer, Boolean> can_read_commit_keys;
    public final Boolean is_editable;
    public final Boolean is_readable;

    public static final class Builder extends Message.Builder<TodoItemPermission, Builder> {
        public Map<Integer, Boolean> can_edit_commit_keys;
        public Map<Integer, Boolean> can_read_commit_keys;
        public Boolean is_editable;
        public Boolean is_readable;

        @Override // com.squareup.wire.Message.Builder
        public TodoItemPermission build() {
            return new TodoItemPermission(this.can_edit_commit_keys, this.can_read_commit_keys, this.is_editable, this.is_readable, super.buildUnknownFields());
        }

        public Builder() {
            this.can_edit_commit_keys = Internal.newMutableMap();
            this.can_read_commit_keys = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder can_edit_commit_keys(Map<Integer, Boolean> r100) {
            Internal.checkElementsNotNull(r100);
            this.can_edit_commit_keys = r100;
            return this;
        }

        public Builder can_read_commit_keys(Map<Integer, Boolean> r100) {
            Internal.checkElementsNotNull(r100);
            this.can_read_commit_keys = r100;
            return this;
        }

        public Builder is_editable(Boolean r100) {
            this.is_editable = r100;
            return this;
        }

        public Builder is_readable(Boolean r100) {
            this.is_readable = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TodoItemPermission extends ProtoAdapter<TodoItemPermission> {
        private final ProtoAdapter<Map<Integer, Boolean>> can_edit_commit_keys;
        private final ProtoAdapter<Map<Integer, Boolean>> can_read_commit_keys;

        public ProtoAdapter_TodoItemPermission() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoItemPermission.class);
            ProtoAdapter<Integer> r100 = ProtoAdapter.INT32;
            ProtoAdapter<Boolean> r101 = ProtoAdapter.BOOL;
            this.can_edit_commit_keys = ProtoAdapter.newMapAdapter(r100, r101);
            this.can_read_commit_keys = ProtoAdapter.newMapAdapter(r100, r101);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoItemPermission decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.is_editable = r102;
            r101.is_readable = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            if (r104 != 1) goto L8;
            r101.can_edit_commit_keys.putAll(this.can_edit_commit_keys.decode(r100));
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.can_read_commit_keys.putAll(this.can_read_commit_keys.decode(r100));
            goto L3
        L10:
            if (r104 != 100) goto L12;
            r101.is_editable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 101) goto L13;
            r101.is_readable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TodoItemPermission r100) {
            int r101 = this.can_edit_commit_keys.encodedSizeWithTag(1, r100.can_edit_commit_keys) + this.can_read_commit_keys.encodedSizeWithTag(2, r100.can_read_commit_keys);
            Boolean r102 = r100.is_editable;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(100, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.is_readable;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(101, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TodoItemPermission decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoItemPermission r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoItemPermission r101) throws IOException {
            this.can_edit_commit_keys.encodeWithTag(r100, 1, r101.can_edit_commit_keys);
            this.can_read_commit_keys.encodeWithTag(r100, 2, r101.can_read_commit_keys);
            Boolean r102 = r101.is_editable;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 100, r102);
        L5:
            Boolean r103 = r101.is_readable;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 101, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoItemPermission r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TodoItemPermission();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_EDITABLE = r100;
        DEFAULT_IS_READABLE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.can_edit_commit_keys = Internal.copyOf("can_edit_commit_keys", this.can_edit_commit_keys);
        r100.can_read_commit_keys = Internal.copyOf("can_read_commit_keys", this.can_read_commit_keys);
        r100.is_editable = this.is_editable;
        r100.is_readable = this.is_readable;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoItemPermission.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoItemPermission(Map<Integer, Boolean> r100, Map<Integer, Boolean> r101, Boolean r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public TodoItemPermission(Map<Integer, Boolean> r100, Map<Integer, Boolean> r101, Boolean r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.can_edit_commit_keys = Internal.immutableCopyOf("can_edit_commit_keys", r100);
        this.can_read_commit_keys = Internal.immutableCopyOf("can_read_commit_keys", r101);
        this.is_editable = r102;
        this.is_readable = r103;
    }
}
