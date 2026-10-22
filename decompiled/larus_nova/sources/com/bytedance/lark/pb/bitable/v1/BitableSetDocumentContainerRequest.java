package com.bytedance.lark.pb.bitable.v1;

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
public final class BitableSetDocumentContainerRequest extends Message<BitableSetDocumentContainerRequest, Builder> {
    public static final ProtoAdapter<BitableSetDocumentContainerRequest> ADAPTER = null;
    public static final Action DEFAULT_ACTION = null;
    public static final String DEFAULT_CONTAINER_ID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final BitableDocumentType DEFAULT_TYPE = null;
    public static final String DEFAULT_URL = "";
    public static final ProtoAdapter_BitableSetDocumentContainerRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Action action;
    public final String container_id;
    public final String token;
    public final BitableDocumentType type;
    public final String url;

    public static final enum Action extends Enum<Action> implements WireEnum {
        private static final /* synthetic */ Action[] $VALUES = null;
        public static final ProtoAdapter<Action> ADAPTER = null;
        public static final Action ENTER_DOCUMENT = null;
        public static final Action EXIT_DOCUMENT = null;
        public static final Action PRELOAD = null;
        private final int value;

        static {
            Action r100 = new Action("PRELOAD", 0, 1);
            PRELOAD = r100;
            Action r101 = new Action("ENTER_DOCUMENT", 1, 2);
            ENTER_DOCUMENT = r101;
            Action r102 = new Action("EXIT_DOCUMENT", 2, 3);
            EXIT_DOCUMENT = r102;
            $VALUES = new Action[]{r100, r101, r102};
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
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return EXIT_DOCUMENT;
        L13:
            return ENTER_DOCUMENT;
        L15:
            return PRELOAD;
        }

        public static Action valueOf(String r100) {
            return (Action) a.a(Action.class, r100);
        }

        private Action(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<BitableSetDocumentContainerRequest, Builder> implements d<BitableSetDocumentContainerRequest> {
        public Action action;
        public String container_id;
        public String token;
        public BitableDocumentType type;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public BitableSetDocumentContainerRequest build() {
            return new BitableSetDocumentContainerRequest(this.container_id, this.token, this.type, this.url, this.action, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action(Action r100) {
            this.action = r100;
            return this;
        }

        public Builder container_id(String r100) {
            this.container_id = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }

        public Builder type(BitableDocumentType r100) {
            this.type = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BitableSetDocumentContainerRequest extends ProtoAdapter<BitableSetDocumentContainerRequest> implements c<BitableSetDocumentContainerRequest> {
        public ProtoAdapter_BitableSetDocumentContainerRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, BitableSetDocumentContainerRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BitableSetDocumentContainerRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.container_id = "";
            r101.token = "";
            r101.type = BitableDocumentType.MAIN;
            r101.url = "";
            r101.action = Action.PRELOAD;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            if (r103 != 1) goto L8;
            r101.container_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.type = BitableDocumentType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.action = Action.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BitableSetDocumentContainerRequest r100) {
            String r101 = r100.container_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.token;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            BitableDocumentType r107 = r100.type;
            if (r107 == null) goto L13;
            int r108 = BitableDocumentType.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.url;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Action r113 = r100.action;
            if (r113 == null) goto L22;
            r102 = Action.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
        L17:
            r111 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ BitableSetDocumentContainerRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BitableSetDocumentContainerRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BitableSetDocumentContainerRequest r101) throws IOException {
            String r102 = r101.container_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.token;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            BitableDocumentType r104 = r101.type;
            if (r104 == null) goto L11;
            BitableDocumentType.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.url;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Action r106 = r101.action;
            if (r106 == null) goto L17;
            Action.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BitableSetDocumentContainerRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_BitableSetDocumentContainerRequest r100 = new ProtoAdapter_BitableSetDocumentContainerRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TYPE = BitableDocumentType.MAIN;
        DEFAULT_ACTION = Action.PRELOAD;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.container_id = this.container_id;
        r100.token = this.token;
        r100.type = this.type;
        r100.url = this.url;
        r100.action = this.action;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BitableSetDocumentContainerRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BitableSetDocumentContainerRequest(String r100, String r101, BitableDocumentType r110, String r111, Action r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public BitableSetDocumentContainerRequest(String r100, String r101, BitableDocumentType r102, String r103, Action r104, ByteString r105) {
        super(ADAPTER, r105);
        this.container_id = r100;
        this.token = r101;
        this.type = r102;
        this.url = r103;
        this.action = r104;
    }
}
