package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskViewSort extends Message<TaskViewSort, Builder> {
    public static final ProtoAdapter<TaskViewSort> ADAPTER = null;
    public static final String DEFAULT_FIELD_KEY = "";
    public static final OrderType DEFAULT_ORDER = null;
    private static final long serialVersionUID = 0;
    public final String field_key;
    public final OrderType order;

    public static final class Builder extends Message.Builder<TaskViewSort, Builder> {
        public String field_key;
        public OrderType order;

        @Override // com.squareup.wire.Message.Builder
        public TaskViewSort build() {
            return new TaskViewSort(this.field_key, this.order, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder field_key(String r100) {
            this.field_key = r100;
            return this;
        }

        public Builder order(OrderType r100) {
            this.order = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskViewSort extends ProtoAdapter<TaskViewSort> {
        public ProtoAdapter_TaskViewSort() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskViewSort.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskViewSort decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.field_key = "";
            r101.order = OrderType.ASC;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.field_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.order = OrderType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        public int encodedSize2(TaskViewSort r100) {
            String r101 = r100.field_key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            OrderType r104 = r100.order;
            if (r104 == null) goto L10;
            r102 = OrderType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskViewSort decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskViewSort r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskViewSort r101) throws IOException {
            String r102 = r101.field_key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            OrderType r103 = r101.order;
            if (r103 == null) goto L8;
            OrderType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskViewSort r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskViewSort();
        DEFAULT_ORDER = OrderType.ASC;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.field_key = this.field_key;
        r100.order = this.order;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskViewSort.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskViewSort(String r100, OrderType r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TaskViewSort(String r100, OrderType r101, ByteString r102) {
        super(ADAPTER, r102);
        this.field_key = r100;
        this.order = r101;
    }
}
