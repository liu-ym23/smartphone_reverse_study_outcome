package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetFileStateResponse extends Message<GetFileStateResponse, Builder> {
    public static final ProtoAdapter<GetFileStateResponse> ADAPTER = null;
    public static final State DEFAULT_STATE = null;
    public static final ProtoAdapter_GetFileStateResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final State state;

    public static final class Builder extends Message.Builder<GetFileStateResponse, Builder> implements d<GetFileStateResponse> {
        public State state;

        @Override // com.squareup.wire.Message.Builder
        public GetFileStateResponse build() {
            State r100 = this.state;
            if (r100 == null) goto L7;
            return new GetFileStateResponse(this.state, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "state"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder state(State r100) {
            this.state = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetFileStateResponse extends ProtoAdapter<GetFileStateResponse> implements c<GetFileStateResponse> {
        public ProtoAdapter_GetFileStateResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetFileStateResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetFileStateResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.state = State.NORMAL;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.state = State.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetFileStateResponse r100) {
            return State.ADAPTER.encodedSizeWithTag(1, r100.state) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetFileStateResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetFileStateResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetFileStateResponse r101) throws IOException {
            State.ADAPTER.encodeWithTag(r100, 1, r101.state);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetFileStateResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum State extends Enum<State> implements WireEnum {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final ProtoAdapter<State> ADAPTER = null;
        public static final State DELETED = null;
        public static final State FREED_UP = null;
        public static final State NORMAL = null;
        public static final State RECOVERABLE = null;
        public static final State UNRECOVERABLE = null;
        private final int value;

        static {
            State r100 = new State(EffectConstants.NORMAL, 0, 1);
            NORMAL = r100;
            State r101 = new State("DELETED", 1, 2);
            DELETED = r101;
            State r102 = new State("RECOVERABLE", 2, 3);
            RECOVERABLE = r102;
            State r103 = new State("UNRECOVERABLE", 3, 4);
            UNRECOVERABLE = r103;
            State r104 = new State("FREED_UP", 4, 5);
            FREED_UP = r104;
            $VALUES = new State[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(State.class);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static State fromValue(int r100) {
            if (r100 == 1) goto L23;
            if (r100 == 2) goto L21;
            if (r100 == 3) goto L19;
            if (r100 == 4) goto L17;
            if (r100 == 5) goto L15;
            return null;
        L15:
            return FREED_UP;
        L17:
            return UNRECOVERABLE;
        L19:
            return RECOVERABLE;
        L21:
            return DELETED;
        L23:
            return NORMAL;
        }

        public static State valueOf(String r100) {
            return (State) a.a(State.class, r100);
        }

        private State(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_GetFileStateResponse r100 = new ProtoAdapter_GetFileStateResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STATE = State.NORMAL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.state = this.state;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetFileStateResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetFileStateResponse(State r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetFileStateResponse(State r100, ByteString r101) {
        super(ADAPTER, r101);
        this.state = r100;
    }
}
