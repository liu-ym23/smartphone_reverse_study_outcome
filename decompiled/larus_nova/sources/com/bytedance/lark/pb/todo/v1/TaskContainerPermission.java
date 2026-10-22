package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskContainerPermission extends Message<TaskContainerPermission, Builder> {
    public static final ProtoAdapter<TaskContainerPermission> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Integer, Boolean> permissions;

    public static final enum Action extends Enum<Action> implements WireEnum {
        private static final /* synthetic */ Action[] $VALUES = null;
        public static final ProtoAdapter<Action> ADAPTER = null;
        public static final Action DELETE_CONTAINER = null;
        public static final Action EDIT_CONTAINER = null;
        public static final Action EDIT_TASK = null;
        public static final Action MANAGE_EDITOR = null;
        public static final Action MANAGE_INHERIT = null;
        public static final Action MANAGE_OWNER = null;
        public static final Action MANAGE_VIEWER = null;
        public static final Action UNKNOWN_ACTION = null;
        public static final Action VIEW = null;
        private final int value;

        static {
            Action r100 = new Action("UNKNOWN_ACTION", 0, 0);
            UNKNOWN_ACTION = r100;
            Action r101 = new Action("VIEW", 1, 1);
            VIEW = r101;
            Action r102 = new Action("EDIT_CONTAINER", 2, 2);
            EDIT_CONTAINER = r102;
            Action r103 = new Action("DELETE_CONTAINER", 3, 3);
            DELETE_CONTAINER = r103;
            Action r104 = new Action("EDIT_TASK", 4, 4);
            EDIT_TASK = r104;
            Action r105 = new Action("MANAGE_OWNER", 5, 5);
            MANAGE_OWNER = r105;
            Action r110 = new Action("MANAGE_EDITOR", 6, 6);
            MANAGE_EDITOR = r110;
            Action r111 = new Action("MANAGE_VIEWER", 7, 7);
            MANAGE_VIEWER = r111;
            Action r112 = new Action("MANAGE_INHERIT", 8, 8);
            MANAGE_INHERIT = r112;
            $VALUES = new Action[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
            ADAPTER = ProtoAdapter.newEnumAdapter(Action.class);
        }

        public static Action[] values() {
            return (Action[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Action fromValue(int r100) {
            switch(r100) {
                case 0: goto L22;
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
            return MANAGE_INHERIT;
        L8:
            return MANAGE_VIEWER;
        L10:
            return MANAGE_EDITOR;
        L12:
            return MANAGE_OWNER;
        L14:
            return EDIT_TASK;
        L16:
            return DELETE_CONTAINER;
        L18:
            return EDIT_CONTAINER;
        L20:
            return VIEW;
        L22:
            return UNKNOWN_ACTION;
        }

        public static Action valueOf(String r100) {
            return (Action) a.a(Action.class, r100);
        }

        private Action(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<TaskContainerPermission, Builder> {
        public Map<Integer, Boolean> permissions;

        @Override // com.squareup.wire.Message.Builder
        public TaskContainerPermission build() {
            return new TaskContainerPermission(this.permissions, super.buildUnknownFields());
        }

        public Builder() {
            this.permissions = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder permissions(Map<Integer, Boolean> r100) {
            Internal.checkElementsNotNull(r100);
            this.permissions = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskContainerPermission extends ProtoAdapter<TaskContainerPermission> {
        private final ProtoAdapter<Map<Integer, Boolean>> permissions;

        public ProtoAdapter_TaskContainerPermission() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskContainerPermission.class);
            this.permissions = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, ProtoAdapter.BOOL);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskContainerPermission decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.permissions.putAll(this.permissions.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskContainerPermission r100) {
            return this.permissions.encodedSizeWithTag(1, r100.permissions) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskContainerPermission decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskContainerPermission r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskContainerPermission r101) throws IOException {
            this.permissions.encodeWithTag(r100, 1, r101.permissions);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskContainerPermission r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskContainerPermission();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.permissions = Internal.copyOf(ComplianceResult.JsonKey.PERMISSIONS, this.permissions);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskContainerPermission.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskContainerPermission(Map<Integer, Boolean> r100) {
        this(r100, ByteString.EMPTY);
    }

    public TaskContainerPermission(Map<Integer, Boolean> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.permissions = Internal.immutableCopyOf(ComplianceResult.JsonKey.PERMISSIONS, r100);
    }
}
