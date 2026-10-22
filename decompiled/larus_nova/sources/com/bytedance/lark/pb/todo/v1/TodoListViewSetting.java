package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TodoListViewSetting extends Message<TodoListViewSetting, Builder> {
    public static final ProtoAdapter<TodoListViewSetting> ADAPTER = null;
    public static final TodoSortType DEFAULT_SORT_TYPE = null;
    public static final TodoListView.Type DEFAULT_VIEW = null;
    private static final long serialVersionUID = 0;
    public final TodoSortType sort_type;
    public final TodoListView.Type view;

    public static final class Builder extends Message.Builder<TodoListViewSetting, Builder> {
        public TodoSortType sort_type;
        public TodoListView.Type view;

        @Override // com.squareup.wire.Message.Builder
        public TodoListViewSetting build() {
            return new TodoListViewSetting(this.view, this.sort_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder sort_type(TodoSortType r100) {
            this.sort_type = r100;
            return this;
        }

        public Builder view(TodoListView.Type r100) {
            this.view = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TodoListViewSetting extends ProtoAdapter<TodoListViewSetting> {
        public ProtoAdapter_TodoListViewSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoListViewSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoListViewSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.view = TodoListView.Type.UNKNOWN;
            r101.sort_type = TodoSortType.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.view = TodoListView.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.sort_type = TodoSortType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TodoListViewSetting r100) {
            TodoListView.Type r101 = r100.view;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TodoListView.Type.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            TodoSortType r104 = r100.sort_type;
            if (r104 == null) goto L10;
            r102 = TodoSortType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TodoListViewSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoListViewSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoListViewSetting r101) throws IOException {
            TodoListView.Type r102 = r101.view;
            if (r102 == null) goto L5;
            TodoListView.Type.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            TodoSortType r103 = r101.sort_type;
            if (r103 == null) goto L8;
            TodoSortType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoListViewSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TodoListViewSetting();
        DEFAULT_VIEW = TodoListView.Type.UNKNOWN;
        DEFAULT_SORT_TYPE = TodoSortType.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.view = this.view;
        r100.sort_type = this.sort_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoListViewSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoListViewSetting(TodoListView.Type r100, TodoSortType r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TodoListViewSetting(TodoListView.Type r100, TodoSortType r101, ByteString r102) {
        super(ADAPTER, r102);
        this.view = r100;
        this.sort_type = r101;
    }
}
