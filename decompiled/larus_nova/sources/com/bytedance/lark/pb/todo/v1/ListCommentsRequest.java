package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class ListCommentsRequest extends Message<ListCommentsRequest, Builder> {
    public static final ProtoAdapter<ListCommentsRequest> ADAPTER = null;
    public static final Integer DEFAULT_COUNT = null;
    public static final Direction DEFAULT_DIRECTION = null;
    public static final Integer DEFAULT_POSITION = null;
    public static final String DEFAULT_TODO_GUID = "";
    public static final ProtoAdapter_ListCommentsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Integer count;
    public final Direction direction;
    public final Integer position;
    public final String todo_guid;

    public static final class Builder extends Message.Builder<ListCommentsRequest, Builder> implements d<ListCommentsRequest> {
        public Integer count;
        public Direction direction;
        public Integer position;
        public String todo_guid;

        @Override // com.squareup.wire.Message.Builder
        public ListCommentsRequest build() {
            return new ListCommentsRequest(this.todo_guid, this.position, this.count, this.direction, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder count(Integer r100) {
            this.count = r100;
            return this;
        }

        public Builder direction(Direction r100) {
            this.direction = r100;
            return this;
        }

        public Builder position(Integer r100) {
            this.position = r100;
            return this;
        }

        public Builder todo_guid(String r100) {
            this.todo_guid = r100;
            return this;
        }
    }

    public static final enum Direction extends Enum<Direction> implements WireEnum {
        private static final /* synthetic */ Direction[] $VALUES = null;
        public static final ProtoAdapter<Direction> ADAPTER = null;
        public static final Direction DOWN = null;
        public static final Direction UP = null;
        private final int value;

        static {
            Direction r100 = new Direction("UP", 0, 0);
            UP = r100;
            Direction r101 = new Direction("DOWN", 1, 1);
            DOWN = r101;
            $VALUES = new Direction[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Direction.class);
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Direction fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return DOWN;
        L10:
            return UP;
        }

        public static Direction valueOf(String r100) {
            return (Direction) a.a(Direction.class, r100);
        }

        private Direction(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_ListCommentsRequest extends ProtoAdapter<ListCommentsRequest> implements c<ListCommentsRequest> {
        public ProtoAdapter_ListCommentsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, ListCommentsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ListCommentsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.todo_guid = "";
            r101.position = 0;
            r101.count = 0;
            r101.direction = Direction.UP;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.todo_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.direction = Direction.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ListCommentsRequest r100) {
            String r101 = r100.todo_guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.position;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.count;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Direction r110 = r100.direction;
            if (r110 == null) goto L18;
            r102 = Direction.ADAPTER.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ ListCommentsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ListCommentsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ListCommentsRequest r101) throws IOException {
            String r102 = r101.todo_guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.position;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.count;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            Direction r105 = r101.direction;
            if (r105 == null) goto L14;
            Direction.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ListCommentsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_ListCommentsRequest r100 = new ProtoAdapter_ListCommentsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_POSITION = 0;
        DEFAULT_COUNT = 0;
        DEFAULT_DIRECTION = Direction.UP;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.todo_guid = this.todo_guid;
        r100.position = this.position;
        r100.count = this.count;
        r100.direction = this.direction;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ListCommentsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ListCommentsRequest(String r100, Integer r101, Integer r102, Direction r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public ListCommentsRequest(String r100, Integer r101, Integer r102, Direction r103, ByteString r104) {
        super(ADAPTER, r104);
        this.todo_guid = r100;
        this.position = r101;
        this.count = r102;
        this.direction = r103;
    }
}
