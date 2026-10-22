package com.bytedance.lark.pb.bitable.v1;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
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
public final class SimpleRecordOperation extends Message<SimpleRecordOperation, Builder> {
    public static final ProtoAdapter<SimpleRecordOperation> ADAPTER = null;
    public static final BitableActionType DEFAULT_ACTION_TYPE = null;
    public static final String DEFAULT_COMMAND = "";
    private static final long serialVersionUID = 0;
    public final BitableActionType action_type;
    public final List<SimpleRecordDataAction> actions;
    public final String command;

    public static final class Builder extends Message.Builder<SimpleRecordOperation, Builder> {
        public BitableActionType action_type;
        public List<SimpleRecordDataAction> actions;
        public String command;

        @Override // com.squareup.wire.Message.Builder
        public SimpleRecordOperation build() {
            return new SimpleRecordOperation(this.actions, this.command, this.action_type, super.buildUnknownFields());
        }

        public Builder() {
            this.actions = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action_type(BitableActionType r100) {
            this.action_type = r100;
            return this;
        }

        public Builder actions(List<SimpleRecordDataAction> r100) {
            Internal.checkElementsNotNull(r100);
            this.actions = r100;
            return this;
        }

        public Builder command(String r100) {
            this.command = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SimpleRecordOperation extends ProtoAdapter<SimpleRecordOperation> {
        public ProtoAdapter_SimpleRecordOperation() {
            super(FieldEncoding.LENGTH_DELIMITED, SimpleRecordOperation.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SimpleRecordOperation decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.command = "";
            r101.action_type = BitableActionType.BASE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.actions.add(SimpleRecordDataAction.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.command = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.action_type = BitableActionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SimpleRecordOperation r100) {
            int r101 = SimpleRecordDataAction.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.actions);
            String r102 = r100.command;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            BitableActionType r106 = r100.action_type;
            if (r106 == null) goto L10;
            r103 = BitableActionType.ADAPTER.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SimpleRecordOperation decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SimpleRecordOperation r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SimpleRecordOperation r101) throws IOException {
            SimpleRecordDataAction.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.actions);
            String r102 = r101.command;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            BitableActionType r103 = r101.action_type;
            if (r103 == null) goto L8;
            BitableActionType.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SimpleRecordOperation r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SimpleRecordOperation();
        DEFAULT_ACTION_TYPE = BitableActionType.BASE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.actions = Internal.copyOf(SlcCommonAction.KEY_ACTIONS, this.actions);
        r100.command = this.command;
        r100.action_type = this.action_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SimpleRecordOperation.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SimpleRecordOperation(List<SimpleRecordDataAction> r100, String r101, BitableActionType r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public SimpleRecordOperation(List<SimpleRecordDataAction> r100, String r101, BitableActionType r102, ByteString r103) {
        super(ADAPTER, r103);
        this.actions = Internal.immutableCopyOf(SlcCommonAction.KEY_ACTIONS, r100);
        this.command = r101;
        this.action_type = r102;
    }
}
