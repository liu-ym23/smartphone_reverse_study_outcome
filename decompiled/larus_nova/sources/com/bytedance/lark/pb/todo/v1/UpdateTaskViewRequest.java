package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UpdateTaskViewRequest extends Message<UpdateTaskViewRequest, Builder> {
    public static final ProtoAdapter<UpdateTaskViewRequest> ADAPTER = null;
    public static final ProtoAdapter_UpdateTaskViewRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<UpdateField> update_fields;
    public final TaskView view;

    public static final class Builder extends Message.Builder<UpdateTaskViewRequest, Builder> implements d<UpdateTaskViewRequest> {
        public List<UpdateField> update_fields;
        public TaskView view;

        @Override // com.squareup.wire.Message.Builder
        public UpdateTaskViewRequest build() {
            return new UpdateTaskViewRequest(this.view, this.update_fields, super.buildUnknownFields());
        }

        public Builder() {
            this.update_fields = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder update_fields(List<UpdateField> r100) {
            Internal.checkElementsNotNull(r100);
            this.update_fields = r100;
            return this;
        }

        public Builder view(TaskView r100) {
            this.view = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateTaskViewRequest extends ProtoAdapter<UpdateTaskViewRequest> implements c<UpdateTaskViewRequest> {
        public ProtoAdapter_UpdateTaskViewRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateTaskViewRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateTaskViewRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.view = TaskView.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.update_fields.add(UpdateField.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
        public int encodedSize2(UpdateTaskViewRequest r100) {
            TaskView r101 = r100.view;
            if (r101 == null) goto L5;
            int r102 = TaskView.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + UpdateField.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.update_fields)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateTaskViewRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateTaskViewRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateTaskViewRequest r101) throws IOException {
            TaskView r102 = r101.view;
            if (r102 == null) goto L5;
            TaskView.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            UpdateField.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.update_fields);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateTaskViewRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum UpdateField extends Enum<UpdateField> implements WireEnum {
        private static final /* synthetic */ UpdateField[] $VALUES = null;
        public static final ProtoAdapter<UpdateField> ADAPTER = null;
        public static final UpdateField ADMIN_SETTING = null;
        public static final UpdateField SHOW_SUB_TASKS = null;
        public static final UpdateField USE_SERVER_DATA = null;
        public static final UpdateField VIEW_FIELDS = null;
        public static final UpdateField VIEW_FILTERS = null;
        public static final UpdateField VIEW_GROUPS = null;
        public static final UpdateField VIEW_SETTING = null;
        public static final UpdateField VIEW_SORTS = null;
        private final int value;

        static {
            UpdateField r100 = new UpdateField("VIEW_FIELDS", 0, 1);
            VIEW_FIELDS = r100;
            UpdateField r101 = new UpdateField("VIEW_GROUPS", 1, 2);
            VIEW_GROUPS = r101;
            UpdateField r102 = new UpdateField("VIEW_SORTS", 2, 3);
            VIEW_SORTS = r102;
            UpdateField r103 = new UpdateField("VIEW_FILTERS", 3, 4);
            VIEW_FILTERS = r103;
            UpdateField r104 = new UpdateField("SHOW_SUB_TASKS", 4, 5);
            SHOW_SUB_TASKS = r104;
            UpdateField r110 = new UpdateField("VIEW_SETTING", 5, 6);
            VIEW_SETTING = r110;
            UpdateField r111 = new UpdateField("ADMIN_SETTING", 6, 7);
            ADMIN_SETTING = r111;
            UpdateField r112 = new UpdateField("USE_SERVER_DATA", 7, 8);
            USE_SERVER_DATA = r112;
            $VALUES = new UpdateField[]{r100, r101, r102, r103, r104, r110, r111, r112};
            ADAPTER = ProtoAdapter.newEnumAdapter(UpdateField.class);
        }

        public static UpdateField[] values() {
            return (UpdateField[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static UpdateField fromValue(int r100) {
            switch(r100) {
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L14;
                case 5: goto L12;
                case 6: goto L10;
                case 7: goto L8;
                case 8: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return USE_SERVER_DATA;
        L8:
            return ADMIN_SETTING;
        L10:
            return VIEW_SETTING;
        L12:
            return SHOW_SUB_TASKS;
        L14:
            return VIEW_FILTERS;
        L16:
            return VIEW_SORTS;
        L18:
            return VIEW_GROUPS;
        L20:
            return VIEW_FIELDS;
        }

        public static UpdateField valueOf(String r100) {
            return (UpdateField) a.a(UpdateField.class, r100);
        }

        private UpdateField(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_UpdateTaskViewRequest r100 = new ProtoAdapter_UpdateTaskViewRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.view = this.view;
        r100.update_fields = Internal.copyOf("update_fields", this.update_fields);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateTaskViewRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateTaskViewRequest(TaskView r100, List<UpdateField> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public UpdateTaskViewRequest(TaskView r100, List<UpdateField> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.view = r100;
        this.update_fields = Internal.immutableCopyOf("update_fields", r101);
    }
}
