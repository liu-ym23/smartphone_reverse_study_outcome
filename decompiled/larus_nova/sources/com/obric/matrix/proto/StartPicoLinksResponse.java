package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.EnumAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
public final class StartPicoLinksResponse extends Message<StartPicoLinksResponse, Builder> {
    public static final ProtoAdapter<StartPicoLinksResponse> ADAPTER = null;
    public static final Phase DEFAULT_PHASE = null;
    private static final long serialVersionUID = 0;

    @SerializedName("phase")
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksResponse$Phase#ADAPTER", tag = 1)
    public final Phase phase;

    @SerializedName("phaseData")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, String> phaseData;

    public static final class Builder extends Message.Builder<StartPicoLinksResponse, Builder> {
        public Phase phase;
        public Map<String, String> phaseData;

        @Override // com.squareup.wire.Message.Builder
        public StartPicoLinksResponse build() {
            return new StartPicoLinksResponse(this.phase, this.phaseData, super.buildUnknownFields());
        }

        public Builder() {
            this.phase = Phase.SYNC_INVOKE;
            this.phaseData = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder phase(Phase r100) {
            this.phase = r100;
            return this;
        }

        public Builder phaseData(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.phaseData = r100;
            return this;
        }
    }

    public static final enum Phase extends Enum<Phase> implements WireEnum {
        private static final /* synthetic */ Phase[] $VALUES = null;
        public static final ProtoAdapter<Phase> ADAPTER = null;
        public static final Phase ASYNC_CALLBACK = null;
        public static final Phase SYNC_INVOKE = null;
        public static final Phase URL_REDIRECT = null;
        private final int value;

        public static final class ProtoAdapter_Phase extends EnumAdapter<Phase> {
            public ProtoAdapter_Phase() {
                super(Phase.class);
            }

            @Override // com.squareup.wire.EnumAdapter
            public Phase fromValue(int r100) {
                return Phase.fromValue(r100);
            }

            @Override // com.squareup.wire.EnumAdapter
            public /* bridge */ /* synthetic */ WireEnum fromValue(int r100) {
                return fromValue(r100);
            }
        }

        static {
            Phase r100 = new Phase("SYNC_INVOKE", 0, 0);
            SYNC_INVOKE = r100;
            Phase r101 = new Phase("ASYNC_CALLBACK", 1, 1);
            ASYNC_CALLBACK = r101;
            Phase r102 = new Phase("URL_REDIRECT", 2, 2);
            URL_REDIRECT = r102;
            $VALUES = new Phase[]{r100, r101, r102};
            ADAPTER = new ProtoAdapter_Phase();
        }

        public static Phase[] values() {
            return (Phase[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            return this.value;
        }

        public static Phase fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return URL_REDIRECT;
        L12:
            return ASYNC_CALLBACK;
        L14:
            return SYNC_INVOKE;
        }

        public static Phase valueOf(String r100) {
            return (Phase) a.a(Phase.class, r100);
        }

        private Phase(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_StartPicoLinksResponse extends ProtoAdapter<StartPicoLinksResponse> {
        private final ProtoAdapter<Map<String, String>> phaseData;

        public ProtoAdapter_StartPicoLinksResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, StartPicoLinksResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.phaseData = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public StartPicoLinksResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.phase(Phase.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.phaseData.putAll(this.phaseData.decode(r100));
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
        public int encodedSize2(StartPicoLinksResponse r100) {
            return (Phase.ADAPTER.encodedSizeWithTag(1, r100.phase) + this.phaseData.encodedSizeWithTag(2, r100.phaseData)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public StartPicoLinksResponse redact2(StartPicoLinksResponse r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StartPicoLinksResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(StartPicoLinksResponse r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StartPicoLinksResponse redact(StartPicoLinksResponse r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, StartPicoLinksResponse r101) throws IOException {
            Phase.ADAPTER.encodeWithTag(r100, 1, r101.phase);
            this.phaseData.encodeWithTag(r100, 2, r101.phaseData);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, StartPicoLinksResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_StartPicoLinksResponse();
        DEFAULT_PHASE = Phase.SYNC_INVOKE;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L10;
        int r101 = unknownFields().hashCode() * 37;
        Phase r102 = this.phase;
        if (r102 == null) goto L7;
        int r103 = r102.hashCode();
    L8:
        int r104 = ((r101 + r103) * 37) + this.phaseData.hashCode();
        this.hashCode = r104;
        return r104;
    L7:
        r103 = 0;
        goto L8
    L10:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.phase = this.phase;
        r100.phaseData = Internal.copyOf("phaseData", this.phaseData);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.phase == null) goto L5;
        r100.append(", phase=");
        r100.append(this.phase);
    L5:
        Map<String, String> r101 = this.phaseData;
        if (r101 != null) goto L8;
    L10:
        StringBuilder r102 = r100.replace(0, 2, "StartPicoLinksResponse{");
        r102.append('}');
        return r102.toString();
    L8:
        if (r101.isEmpty() == true) goto L10;
        r100.append(", phaseData=");
        r100.append(this.phaseData);
        goto L10
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof StartPicoLinksResponse) == true) goto L8;
        return false;
    L8:
        StartPicoLinksResponse r101 = (StartPicoLinksResponse) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.phase, r101.phase) == false) goto L15;
        if (this.phaseData.equals(r101.phaseData) == false) goto L15;
        return true;
    }

    public StartPicoLinksResponse(Phase r100, Map<String, String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public StartPicoLinksResponse(Phase r100, Map<String, String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.phase = r100;
        this.phaseData = Internal.immutableCopyOf("phaseData", r101);
    }
}
