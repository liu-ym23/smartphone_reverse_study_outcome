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
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushTodoExtraInfoChangedNotification extends Message<PushTodoExtraInfoChangedNotification, Builder> {
    public static final ProtoAdapter<PushTodoExtraInfoChangedNotification> ADAPTER = null;
    public static final ProtoAdapter_PushTodoExtraInfoChangedNotification RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TodoExtraInfo> extra_infos;

    public static final class Builder extends Message.Builder<PushTodoExtraInfoChangedNotification, Builder> implements d<PushTodoExtraInfoChangedNotification> {
        public List<TodoExtraInfo> extra_infos;

        @Override // com.squareup.wire.Message.Builder
        public PushTodoExtraInfoChangedNotification build() {
            return new PushTodoExtraInfoChangedNotification(this.extra_infos, super.buildUnknownFields());
        }

        public Builder() {
            this.extra_infos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder extra_infos(List<TodoExtraInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.extra_infos = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushTodoExtraInfoChangedNotification extends ProtoAdapter<PushTodoExtraInfoChangedNotification> implements c<PushTodoExtraInfoChangedNotification> {
        public ProtoAdapter_PushTodoExtraInfoChangedNotification() {
            super(FieldEncoding.LENGTH_DELIMITED, PushTodoExtraInfoChangedNotification.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushTodoExtraInfoChangedNotification decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.extra_infos.add(TodoExtraInfo.ADAPTER.decode(r100));
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
        public int encodedSize2(PushTodoExtraInfoChangedNotification r100) {
            return TodoExtraInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.extra_infos) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushTodoExtraInfoChangedNotification decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushTodoExtraInfoChangedNotification r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushTodoExtraInfoChangedNotification r101) throws IOException {
            TodoExtraInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.extra_infos);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushTodoExtraInfoChangedNotification r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushTodoExtraInfoChangedNotification r100 = new ProtoAdapter_PushTodoExtraInfoChangedNotification();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.extra_infos = Internal.copyOf("extra_infos", this.extra_infos);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushTodoExtraInfoChangedNotification.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushTodoExtraInfoChangedNotification(List<TodoExtraInfo> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PushTodoExtraInfoChangedNotification(List<TodoExtraInfo> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.extra_infos = Internal.immutableCopyOf("extra_infos", r100);
    }
}
