package com.bytedance.lark.pb.ugreach.v1;

import androidx.camera.video.AudioStats;
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
public final class GetUGSDKSettingsResponse extends Message<GetUGSDKSettingsResponse, Builder> {
    public static final ProtoAdapter<GetUGSDKSettingsResponse> ADAPTER = null;
    public static final ProtoAdapter_GetUGSDKSettingsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> event_names;
    public final List<ScenarioContext> scenarios;
    public final SDKInnerStrategy sdk_strategy;

    public static final class Builder extends Message.Builder<GetUGSDKSettingsResponse, Builder> implements d<GetUGSDKSettingsResponse> {
        public List<String> event_names;
        public List<ScenarioContext> scenarios;
        public SDKInnerStrategy sdk_strategy;

        @Override // com.squareup.wire.Message.Builder
        public GetUGSDKSettingsResponse build() {
            return new GetUGSDKSettingsResponse(this.sdk_strategy, this.scenarios, this.event_names, super.buildUnknownFields());
        }

        public Builder() {
            this.scenarios = Internal.newMutableList();
            this.event_names = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder event_names(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.event_names = r100;
            return this;
        }

        public Builder scenarios(List<ScenarioContext> r100) {
            Internal.checkElementsNotNull(r100);
            this.scenarios = r100;
            return this;
        }

        public Builder sdk_strategy(SDKInnerStrategy r100) {
            this.sdk_strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUGSDKSettingsResponse extends ProtoAdapter<GetUGSDKSettingsResponse> implements c<GetUGSDKSettingsResponse> {
        public ProtoAdapter_GetUGSDKSettingsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUGSDKSettingsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUGSDKSettingsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.sdk_strategy = SDKInnerStrategy.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.scenarios.add(ScenarioContext.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.event_names.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetUGSDKSettingsResponse r100) {
            SDKInnerStrategy r101 = r100.sdk_strategy;
            if (r101 == null) goto L5;
            int r102 = SDKInnerStrategy.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return ((r102 + ScenarioContext.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.scenarios)) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(3, r100.event_names)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUGSDKSettingsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUGSDKSettingsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUGSDKSettingsResponse r101) throws IOException {
            SDKInnerStrategy r102 = r101.sdk_strategy;
            if (r102 == null) goto L5;
            SDKInnerStrategy.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ScenarioContext.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.scenarios);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 3, r101.event_names);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUGSDKSettingsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class SDKInnerStrategy extends Message<SDKInnerStrategy, Builder> {
        public static final ProtoAdapter<SDKInnerStrategy> ADAPTER = null;
        public static final Double DEFAULT_REQUEST_TIMEOUT_DURATION = null;
        public static final Boolean DEFAULT_SOLVE_CONFLICT_USE_GRAPH = null;
        public static final Boolean DEFAULT_UPLOAD_STATUS_USE_LOOP = null;
        private static final long serialVersionUID = 0;
        public final Double request_timeout_duration;
        public final Boolean solve_conflict_use_graph;
        public final Boolean upload_status_use_loop;

        public static final class Builder extends Message.Builder<SDKInnerStrategy, Builder> {
            public Double request_timeout_duration;
            public Boolean solve_conflict_use_graph;
            public Boolean upload_status_use_loop;

            @Override // com.squareup.wire.Message.Builder
            public SDKInnerStrategy build() {
                return new SDKInnerStrategy(this.solve_conflict_use_graph, this.request_timeout_duration, this.upload_status_use_loop, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder request_timeout_duration(Double r100) {
                this.request_timeout_duration = r100;
                return this;
            }

            public Builder solve_conflict_use_graph(Boolean r100) {
                this.solve_conflict_use_graph = r100;
                return this;
            }

            public Builder upload_status_use_loop(Boolean r100) {
                this.upload_status_use_loop = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SDKInnerStrategy extends ProtoAdapter<SDKInnerStrategy> {
            public ProtoAdapter_SDKInnerStrategy() {
                super(FieldEncoding.LENGTH_DELIMITED, SDKInnerStrategy.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SDKInnerStrategy decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.solve_conflict_use_graph = r102;
                r101.request_timeout_duration = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
                r101.upload_status_use_loop = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L15;
                if (r104 != 1) goto L8;
                r101.solve_conflict_use_graph = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.request_timeout_duration = ProtoAdapter.DOUBLE.decode(r100);
                goto L3
            L10:
                if (r104 != 3) goto L11;
                r101.upload_status_use_loop = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L11:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(SDKInnerStrategy r100) {
                Boolean r101 = r100.solve_conflict_use_graph;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Double r104 = r100.request_timeout_duration;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.DOUBLE.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.upload_status_use_loop;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SDKInnerStrategy decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SDKInnerStrategy r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SDKInnerStrategy r101) throws IOException {
                Boolean r102 = r101.solve_conflict_use_graph;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Double r103 = r101.request_timeout_duration;
                if (r103 == null) goto L8;
                ProtoAdapter.DOUBLE.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.upload_status_use_loop;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SDKInnerStrategy r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SDKInnerStrategy();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_SOLVE_CONFLICT_USE_GRAPH = r100;
            DEFAULT_REQUEST_TIMEOUT_DURATION = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
            DEFAULT_UPLOAD_STATUS_USE_LOOP = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.solve_conflict_use_graph = this.solve_conflict_use_graph;
            r100.request_timeout_duration = this.request_timeout_duration;
            r100.upload_status_use_loop = this.upload_status_use_loop;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SDKInnerStrategy.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SDKInnerStrategy(Boolean r100, Double r101, Boolean r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public SDKInnerStrategy(Boolean r100, Double r101, Boolean r102, ByteString r103) {
            super(ADAPTER, r103);
            this.solve_conflict_use_graph = r100;
            this.request_timeout_duration = r101;
            this.upload_status_use_loop = r102;
        }
    }

    static {
        ProtoAdapter_GetUGSDKSettingsResponse r100 = new ProtoAdapter_GetUGSDKSettingsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.sdk_strategy = this.sdk_strategy;
        r100.scenarios = Internal.copyOf("scenarios", this.scenarios);
        r100.event_names = Internal.copyOf("event_names", this.event_names);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUGSDKSettingsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUGSDKSettingsResponse(SDKInnerStrategy r100, List<ScenarioContext> r101, List<String> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetUGSDKSettingsResponse(SDKInnerStrategy r100, List<ScenarioContext> r101, List<String> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.sdk_strategy = r100;
        this.scenarios = Internal.immutableCopyOf("scenarios", r101);
        this.event_names = Internal.immutableCopyOf("event_names", r102);
    }
}
