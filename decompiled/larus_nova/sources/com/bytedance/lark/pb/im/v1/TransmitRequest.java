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
public final class TransmitRequest extends Message<TransmitRequest, Builder> {
    public static final ProtoAdapter<TransmitRequest> ADAPTER = null;
    public static final String DEFAULT_FILE_KEY = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_ORIGIN_MERGE_FORWARD_ID = "";
    public static final Type DEFAULT_TYPE = null;
    public static final ProtoAdapter_TransmitRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> chat_ids;
    public final String file_key;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253661id;
    public final String origin_merge_forward_id;
    public final List<Transmit2ThreadTarget> thread_targets;
    public final Type type;

    public static final class Builder extends Message.Builder<TransmitRequest, Builder> implements d<TransmitRequest> {
        public List<String> chat_ids;
        public String file_key;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253662id;
        public String origin_merge_forward_id;
        public List<Transmit2ThreadTarget> thread_targets;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public TransmitRequest build() {
            String r100 = this.f253662id;
            if (r100 == null) goto L9;
            if (this.type == null) goto L9;
            return new TransmitRequest(this.chat_ids, this.f253662id, this.type, this.thread_targets, this.file_key, this.origin_merge_forward_id, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.type, "type"});
        }

        public Builder() {
            this.chat_ids = Internal.newMutableList();
            this.thread_targets = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.chat_ids = r100;
            return this;
        }

        public Builder file_key(String r100) {
            this.file_key = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253662id = r100;
            return this;
        }

        public Builder origin_merge_forward_id(String r100) {
            this.origin_merge_forward_id = r100;
            return this;
        }

        public Builder thread_targets(List<Transmit2ThreadTarget> r100) {
            Internal.checkElementsNotNull(r100);
            this.thread_targets = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TransmitRequest extends ProtoAdapter<TransmitRequest> implements c<TransmitRequest> {
        public ProtoAdapter_TransmitRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, TransmitRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TransmitRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253662id = "";
            r101.type = Type.UNKNOWN;
            r101.file_key = "";
            r101.origin_merge_forward_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L18;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.origin_merge_forward_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.file_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.thread_targets.add(Transmit2ThreadTarget.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.f253662id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.chat_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TransmitRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = ((r101.asRepeated().encodedSizeWithTag(1, r100.chat_ids) + r101.encodedSizeWithTag(2, r100.f253661id)) + Type.ADAPTER.encodedSizeWithTag(3, r100.type)) + Transmit2ThreadTarget.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.thread_targets);
            String r103 = r100.file_key;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(5, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.origin_merge_forward_id;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(6, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TransmitRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TransmitRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TransmitRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 1, r101.chat_ids);
            r102.encodeWithTag(r100, 2, r101.f253661id);
            Type.ADAPTER.encodeWithTag(r100, 3, r101.type);
            Transmit2ThreadTarget.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.thread_targets);
            String r103 = r101.file_key;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 5, r103);
        L5:
            String r104 = r101.origin_merge_forward_id;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 6, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TransmitRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type FAVORITE = null;
        public static final Type MESSAGE = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("MESSAGE", 1, 1);
            MESSAGE = r101;
            Type r102 = new Type("FAVORITE", 2, 2);
            FAVORITE = r102;
            $VALUES = new Type[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return FAVORITE;
        L12:
            return MESSAGE;
        L14:
            return UNKNOWN;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_TransmitRequest r100 = new ProtoAdapter_TransmitRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TYPE = Type.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_ids = Internal.copyOf("chat_ids", this.chat_ids);
        r100.f253662id = this.f253661id;
        r100.type = this.type;
        r100.thread_targets = Internal.copyOf("thread_targets", this.thread_targets);
        r100.file_key = this.file_key;
        r100.origin_merge_forward_id = this.origin_merge_forward_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TransmitRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TransmitRequest(List<String> r100, String r110, Type r111, List<Transmit2ThreadTarget> r112, String r113, String r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public TransmitRequest(List<String> r100, String r101, Type r102, List<Transmit2ThreadTarget> r103, String r104, String r105, ByteString r106) {
        super(ADAPTER, r106);
        this.chat_ids = Internal.immutableCopyOf("chat_ids", r100);
        this.f253661id = r101;
        this.type = r102;
        this.thread_targets = Internal.immutableCopyOf("thread_targets", r103);
        this.file_key = r104;
        this.origin_merge_forward_id = r105;
    }
}
