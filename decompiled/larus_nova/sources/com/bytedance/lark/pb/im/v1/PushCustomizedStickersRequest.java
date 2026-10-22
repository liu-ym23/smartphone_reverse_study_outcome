package com.bytedance.lark.pb.im.v1;

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
public final class PushCustomizedStickersRequest extends Message<PushCustomizedStickersRequest, Builder> {
    public static final ProtoAdapter<PushCustomizedStickersRequest> ADAPTER = null;
    public static final AddDirection DEFAULT_ADD_DIRECTION = null;
    public static final Operation DEFAULT_OPERATION = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final ProtoAdapter_PushCustomizedStickersRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final AddDirection add_direction;
    public final Operation operation;
    public final List<Sticker> stickers;
    public final Long update_time;

    public static final enum AddDirection extends Enum<AddDirection> implements WireEnum {
        private static final /* synthetic */ AddDirection[] $VALUES = null;
        public static final ProtoAdapter<AddDirection> ADAPTER = null;
        public static final AddDirection HEAD = null;
        public static final AddDirection TAIL = null;
        private final int value;

        static {
            AddDirection r100 = new AddDirection("HEAD", 0, 1);
            HEAD = r100;
            AddDirection r101 = new AddDirection("TAIL", 1, 2);
            TAIL = r101;
            $VALUES = new AddDirection[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(AddDirection.class);
        }

        public static AddDirection[] values() {
            return (AddDirection[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static AddDirection fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return TAIL;
        L11:
            return HEAD;
        }

        public static AddDirection valueOf(String r100) {
            return (AddDirection) a.a(AddDirection.class, r100);
        }

        private AddDirection(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<PushCustomizedStickersRequest, Builder> implements d<PushCustomizedStickersRequest> {
        public AddDirection add_direction;
        public Operation operation;
        public List<Sticker> stickers;
        public Long update_time;

        @Override // com.squareup.wire.Message.Builder
        public PushCustomizedStickersRequest build() {
            return new PushCustomizedStickersRequest(this.operation, this.stickers, this.update_time, this.add_direction, super.buildUnknownFields());
        }

        public Builder() {
            this.stickers = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder add_direction(AddDirection r100) {
            this.add_direction = r100;
            return this;
        }

        public Builder operation(Operation r100) {
            this.operation = r100;
            return this;
        }

        public Builder stickers(List<Sticker> r100) {
            Internal.checkElementsNotNull(r100);
            this.stickers = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }
    }

    public static final enum Operation extends Enum<Operation> implements WireEnum {
        private static final /* synthetic */ Operation[] $VALUES = null;
        public static final ProtoAdapter<Operation> ADAPTER = null;
        public static final Operation ADD = null;
        public static final Operation DELETE = null;
        public static final Operation MODIFY = null;
        private final int value;

        static {
            Operation r100 = new Operation("ADD", 0, 1);
            ADD = r100;
            Operation r101 = new Operation("DELETE", 1, 2);
            DELETE = r101;
            Operation r102 = new Operation("MODIFY", 2, 3);
            MODIFY = r102;
            $VALUES = new Operation[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Operation.class);
        }

        public static Operation[] values() {
            return (Operation[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Operation fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return MODIFY;
        L13:
            return DELETE;
        L15:
            return ADD;
        }

        public static Operation valueOf(String r100) {
            return (Operation) a.a(Operation.class, r100);
        }

        private Operation(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_PushCustomizedStickersRequest extends ProtoAdapter<PushCustomizedStickersRequest> implements c<PushCustomizedStickersRequest> {
        public ProtoAdapter_PushCustomizedStickersRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PushCustomizedStickersRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushCustomizedStickersRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.operation = Operation.ADD;
            r101.update_time = 0L;
            r101.add_direction = AddDirection.HEAD;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.operation = Operation.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.stickers.add(Sticker.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.add_direction = AddDirection.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushCustomizedStickersRequest r100) {
            Operation r101 = r100.operation;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Operation.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + Sticker.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.stickers);
            Long r105 = r100.update_time;
            if (r105 == null) goto L9;
            int r106 = ProtoAdapter.INT64.encodedSizeWithTag(3, r105);
        L10:
            int r107 = r104 + r106;
            AddDirection r108 = r100.add_direction;
            if (r108 == null) goto L14;
            r102 = AddDirection.ADAPTER.encodedSizeWithTag(4, r108);
        L14:
            return (r107 + r102) + r100.unknownFields().size();
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushCustomizedStickersRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushCustomizedStickersRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushCustomizedStickersRequest r101) throws IOException {
            Operation r102 = r101.operation;
            if (r102 == null) goto L5;
            Operation.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Sticker.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.stickers);
            Long r103 = r101.update_time;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r103);
        L8:
            AddDirection r104 = r101.add_direction;
            if (r104 == null) goto L11;
            AddDirection.ADAPTER.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushCustomizedStickersRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushCustomizedStickersRequest r100 = new ProtoAdapter_PushCustomizedStickersRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_OPERATION = Operation.ADD;
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_ADD_DIRECTION = AddDirection.HEAD;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.operation = this.operation;
        r100.stickers = Internal.copyOf("stickers", this.stickers);
        r100.update_time = this.update_time;
        r100.add_direction = this.add_direction;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushCustomizedStickersRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushCustomizedStickersRequest(Operation r100, List<Sticker> r101, Long r102, AddDirection r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PushCustomizedStickersRequest(Operation r100, List<Sticker> r101, Long r102, AddDirection r103, ByteString r104) {
        super(ADAPTER, r104);
        this.operation = r100;
        this.stickers = Internal.immutableCopyOf("stickers", r101);
        this.update_time = r102;
        this.add_direction = r103;
    }
}
