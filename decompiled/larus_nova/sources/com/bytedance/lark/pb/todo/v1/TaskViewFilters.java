package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskViewFilters extends Message<TaskViewFilters, Builder> {
    public static final ProtoAdapter<TaskViewFilters> ADAPTER = null;
    public static final FilterConjunction DEFAULT_CONJUNCTION = null;
    private static final long serialVersionUID = 0;
    public final List<FilterCondition> conditions;
    public final FilterConjunction conjunction;

    public static final class Builder extends Message.Builder<TaskViewFilters, Builder> {
        public List<FilterCondition> conditions;
        public FilterConjunction conjunction;

        @Override // com.squareup.wire.Message.Builder
        public TaskViewFilters build() {
            return new TaskViewFilters(this.conjunction, this.conditions, super.buildUnknownFields());
        }

        public Builder() {
            this.conditions = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder conditions(List<FilterCondition> r100) {
            Internal.checkElementsNotNull(r100);
            this.conditions = r100;
            return this;
        }

        public Builder conjunction(FilterConjunction r100) {
            this.conjunction = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskViewFilters extends ProtoAdapter<TaskViewFilters> {
        public ProtoAdapter_TaskViewFilters() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskViewFilters.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskViewFilters decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.conjunction = FilterConjunction.AND;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.conjunction = FilterConjunction.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.conditions.add(FilterCondition.ADAPTER.decode(r100));
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
        public int encodedSize2(TaskViewFilters r100) {
            FilterConjunction r101 = r100.conjunction;
            if (r101 == null) goto L5;
            int r102 = FilterConjunction.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + FilterCondition.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.conditions)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskViewFilters decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskViewFilters r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskViewFilters r101) throws IOException {
            FilterConjunction r102 = r101.conjunction;
            if (r102 == null) goto L5;
            FilterConjunction.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            FilterCondition.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.conditions);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskViewFilters r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskViewFilters();
        DEFAULT_CONJUNCTION = FilterConjunction.AND;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.conjunction = this.conjunction;
        r100.conditions = Internal.copyOf("conditions", this.conditions);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskViewFilters.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskViewFilters(FilterConjunction r100, List<FilterCondition> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TaskViewFilters(FilterConjunction r100, List<FilterCondition> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.conjunction = r100;
        this.conditions = Internal.immutableCopyOf("conditions", r101);
    }
}
