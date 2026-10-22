package com.bytedance.lark.pb.search.sections.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class Action extends Message<Action, Builder> {
    public static final ProtoAdapter<Action> ADAPTER = null;
    public static final ActionType DEFAULT_TYPE = null;
    public static final String DEFAULT_URI = "";
    private static final long serialVersionUID = 0;
    public final Map<String, String> params;
    public final ActionType type;
    public final String uri;

    public static final enum ActionType extends Enum<ActionType> implements WireEnum {
        private static final /* synthetic */ ActionType[] $VALUES = null;
        public static final ProtoAdapter<ActionType> ADAPTER = null;
        public static final ActionType SEARCH_INSIDE = null;
        public static final ActionType SEARCH_OUTSIDE = null;
        public static final ActionType UNKNOWN = null;
        private final int value;

        static {
            ActionType r100 = new ActionType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ActionType r101 = new ActionType("SEARCH_INSIDE", 1, 1);
            SEARCH_INSIDE = r101;
            ActionType r102 = new ActionType("SEARCH_OUTSIDE", 2, 2);
            SEARCH_OUTSIDE = r102;
            $VALUES = new ActionType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ActionType.class);
        }

        public static ActionType[] values() {
            return (ActionType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ActionType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return SEARCH_OUTSIDE;
        L12:
            return SEARCH_INSIDE;
        L14:
            return UNKNOWN;
        }

        public static ActionType valueOf(String r100) {
            return (ActionType) a.a(ActionType.class, r100);
        }

        private ActionType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<Action, Builder> {
        public Map<String, String> params;
        public ActionType type;
        public String uri;

        @Override // com.squareup.wire.Message.Builder
        public Action build() {
            return new Action(this.type, this.uri, this.params, super.buildUnknownFields());
        }

        public Builder() {
            this.params = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder params(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.params = r100;
            return this;
        }

        public Builder type(ActionType r100) {
            this.type = r100;
            return this;
        }

        public Builder uri(String r100) {
            this.uri = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Action extends ProtoAdapter<Action> {
        private final ProtoAdapter<Map<String, String>> params;

        public ProtoAdapter_Action() {
            super(FieldEncoding.LENGTH_DELIMITED, Action.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.params = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Action decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = ActionType.UNKNOWN;
            r101.uri = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.type = ActionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.uri = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.params.putAll(this.params.decode(r100));
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
        public int encodedSize2(Action r100) {
            ActionType r101 = r100.type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ActionType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.uri;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + this.params.encodedSizeWithTag(3, r100.params)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Action decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Action r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Action r101) throws IOException {
            ActionType r102 = r101.type;
            if (r102 == null) goto L5;
            ActionType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.uri;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            this.params.encodeWithTag(r100, 3, r101.params);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Action r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Action();
        DEFAULT_TYPE = ActionType.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.uri = this.uri;
        r100.params = Internal.copyOf("params", this.params);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Action.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Action(ActionType r100, String r101, Map<String, String> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public Action(ActionType r100, String r101, Map<String, String> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.type = r100;
        this.uri = r101;
        this.params = Internal.immutableCopyOf("params", r102);
    }
}
