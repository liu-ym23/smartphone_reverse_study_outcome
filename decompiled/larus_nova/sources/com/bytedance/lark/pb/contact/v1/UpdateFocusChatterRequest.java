package com.bytedance.lark.pb.contact.v1;

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
public final class UpdateFocusChatterRequest extends Message<UpdateFocusChatterRequest, Builder> {
    public static final ProtoAdapter<UpdateFocusChatterRequest> ADAPTER = null;
    public static final Operate DEFAULT_OPERATE = null;
    public static final ProtoAdapter_UpdateFocusChatterRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Long> chatter_ids;
    public final Operate operate;

    public static final class Builder extends Message.Builder<UpdateFocusChatterRequest, Builder> implements d<UpdateFocusChatterRequest> {
        public List<Long> chatter_ids;
        public Operate operate;

        @Override // com.squareup.wire.Message.Builder
        public UpdateFocusChatterRequest build() {
            return new UpdateFocusChatterRequest(this.chatter_ids, this.operate, super.buildUnknownFields());
        }

        public Builder() {
            this.chatter_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chatter_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatter_ids = r100;
            return this;
        }

        public Builder operate(Operate r100) {
            this.operate = r100;
            return this;
        }
    }

    public static final enum Operate extends Enum<Operate> implements WireEnum {
        private static final /* synthetic */ Operate[] $VALUES = null;
        public static final ProtoAdapter<Operate> ADAPTER = null;
        public static final Operate ADD = null;
        public static final Operate DELETE = null;
        private final int value;

        static {
            Operate r100 = new Operate("ADD", 0, 1);
            ADD = r100;
            Operate r101 = new Operate("DELETE", 1, 2);
            DELETE = r101;
            $VALUES = new Operate[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Operate.class);
        }

        public static Operate[] values() {
            return (Operate[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Operate fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return DELETE;
        L11:
            return ADD;
        }

        public static Operate valueOf(String r100) {
            return (Operate) a.a(Operate.class, r100);
        }

        private Operate(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_UpdateFocusChatterRequest extends ProtoAdapter<UpdateFocusChatterRequest> implements c<UpdateFocusChatterRequest> {
        public ProtoAdapter_UpdateFocusChatterRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateFocusChatterRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateFocusChatterRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.operate = Operate.ADD;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.chatter_ids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.operate = Operate.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
        public int encodedSize2(UpdateFocusChatterRequest r100) {
            int r101 = ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(1, r100.chatter_ids);
            Operate r102 = r100.operate;
            if (r102 == null) goto L5;
            int r103 = Operate.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateFocusChatterRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateFocusChatterRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateFocusChatterRequest r101) throws IOException {
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 1, r101.chatter_ids);
            Operate r102 = r101.operate;
            if (r102 == null) goto L5;
            Operate.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateFocusChatterRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateFocusChatterRequest r100 = new ProtoAdapter_UpdateFocusChatterRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_OPERATE = Operate.ADD;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chatter_ids = Internal.copyOf("chatter_ids", this.chatter_ids);
        r100.operate = this.operate;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateFocusChatterRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateFocusChatterRequest(List<Long> r100, Operate r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public UpdateFocusChatterRequest(List<Long> r100, Operate r101, ByteString r102) {
        super(ADAPTER, r102);
        this.chatter_ids = Internal.immutableCopyOf("chatter_ids", r100);
        this.operate = r101;
    }
}
