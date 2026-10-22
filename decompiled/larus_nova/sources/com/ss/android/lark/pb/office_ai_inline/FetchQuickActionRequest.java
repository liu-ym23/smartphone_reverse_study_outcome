package com.ss.android.lark.pb.office_ai_inline;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class FetchQuickActionRequest extends Message<FetchQuickActionRequest, Builder> {
    public static final ProtoAdapter<FetchQuickActionRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Scenario mscenario;
    public final Map<String, String> mtrigger_params_map;

    public static final class Builder extends Message.Builder<FetchQuickActionRequest, Builder> {
        public Scenario mscenario;
        public Map<String, String> mtrigger_params_map;

        @Override // com.squareup.wire.Message.Builder
        public FetchQuickActionRequest build() {
            return new FetchQuickActionRequest(this.mscenario, this.mtrigger_params_map, super.buildUnknownFields());
        }

        public Builder() {
            this.mtrigger_params_map = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder scenario(Scenario r100) {
            this.mscenario = r100;
            return this;
        }

        public Builder trigger_params_map(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mtrigger_params_map = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FetchQuickActionRequest extends ProtoAdapter<FetchQuickActionRequest> {
        private final ProtoAdapter<Map<String, String>> mtrigger_params_map;

        public ProtoAdapter_FetchQuickActionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, FetchQuickActionRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mtrigger_params_map = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FetchQuickActionRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mscenario = Scenario.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mtrigger_params_map.putAll(this.mtrigger_params_map.decode(r100));
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
        public int encodedSize2(FetchQuickActionRequest r100) {
            Scenario r101 = r100.mscenario;
            if (r101 == null) goto L5;
            int r102 = Scenario.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + this.mtrigger_params_map.encodedSizeWithTag(2, r100.mtrigger_params_map)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FetchQuickActionRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FetchQuickActionRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FetchQuickActionRequest r101) throws IOException {
            Scenario r102 = r101.mscenario;
            if (r102 == null) goto L5;
            Scenario.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            this.mtrigger_params_map.encodeWithTag(r100, 2, r101.mtrigger_params_map);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FetchQuickActionRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FetchQuickActionRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mscenario = this.mscenario;
        r100.mtrigger_params_map = Internal.copyOf("mtrigger_params_map", this.mtrigger_params_map);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FetchQuickActionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FetchQuickActionRequest(Scenario r100, Map<String, String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FetchQuickActionRequest(Scenario r100, Map<String, String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mscenario = r100;
        this.mtrigger_params_map = Internal.immutableCopyOf("mtrigger_params_map", r101);
    }
}
