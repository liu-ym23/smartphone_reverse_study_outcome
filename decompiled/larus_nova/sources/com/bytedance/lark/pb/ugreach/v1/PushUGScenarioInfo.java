package com.bytedance.lark.pb.ugreach.v1;

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
public final class PushUGScenarioInfo extends Message<PushUGScenarioInfo, Builder> {
    public static final ProtoAdapter<PushUGScenarioInfo> ADAPTER = null;
    public static final String DEFAULT_APP_ID = "";
    public static final String DEFAULT_SCENARIO_ID = "";
    public static final ProtoAdapter_PushUGScenarioInfo RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String app_id;
    public final LocalRule local_rule;
    public final UpdatedReachPoints reach_point_ids;
    public final String scenario_id;

    public static final class Builder extends Message.Builder<PushUGScenarioInfo, Builder> implements d<PushUGScenarioInfo> {
        public String app_id;
        public LocalRule local_rule;
        public UpdatedReachPoints reach_point_ids;
        public String scenario_id;

        @Override // com.squareup.wire.Message.Builder
        public PushUGScenarioInfo build() {
            return new PushUGScenarioInfo(this.app_id, this.scenario_id, this.local_rule, this.reach_point_ids, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_id(String r100) {
            this.app_id = r100;
            return this;
        }

        public Builder local_rule(LocalRule r100) {
            this.local_rule = r100;
            this.reach_point_ids = null;
            return this;
        }

        public Builder reach_point_ids(UpdatedReachPoints r100) {
            this.reach_point_ids = r100;
            this.local_rule = null;
            return this;
        }

        public Builder scenario_id(String r100) {
            this.scenario_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushUGScenarioInfo extends ProtoAdapter<PushUGScenarioInfo> implements c<PushUGScenarioInfo> {
        public ProtoAdapter_PushUGScenarioInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, PushUGScenarioInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushUGScenarioInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.app_id = "";
            r101.scenario_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.app_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.scenario_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 100) goto L12;
            r101.local_rule(LocalRule.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 101) goto L13;
            r101.reach_point_ids(UpdatedReachPoints.ADAPTER.decode(r100));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushUGScenarioInfo r100) {
            String r101 = r100.app_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.scenario_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            LocalRule r107 = r100.local_rule;
            if (r107 == null) goto L13;
            int r108 = LocalRule.ADAPTER.encodedSizeWithTag(100, r107);
        L14:
            int r109 = r106 + r108;
            UpdatedReachPoints r110 = r100.reach_point_ids;
            if (r110 == null) goto L18;
            r102 = UpdatedReachPoints.ADAPTER.encodedSizeWithTag(101, r110);
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
        public /* bridge */ /* synthetic */ PushUGScenarioInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushUGScenarioInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushUGScenarioInfo r101) throws IOException {
            String r102 = r101.app_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.scenario_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            LocalRule r104 = r101.local_rule;
            if (r104 == null) goto L11;
            LocalRule.ADAPTER.encodeWithTag(r100, 100, r104);
        L11:
            UpdatedReachPoints r105 = r101.reach_point_ids;
            if (r105 == null) goto L14;
            UpdatedReachPoints.ADAPTER.encodeWithTag(r100, 101, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushUGScenarioInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class UpdatedReachPoints extends Message<UpdatedReachPoints, Builder> {
        public static final ProtoAdapter<UpdatedReachPoints> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> reach_point_ids;

        public static final class Builder extends Message.Builder<UpdatedReachPoints, Builder> {
            public List<String> reach_point_ids;

            @Override // com.squareup.wire.Message.Builder
            public UpdatedReachPoints build() {
                return new UpdatedReachPoints(this.reach_point_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.reach_point_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder reach_point_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.reach_point_ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_UpdatedReachPoints extends ProtoAdapter<UpdatedReachPoints> {
            public ProtoAdapter_UpdatedReachPoints() {
                super(FieldEncoding.LENGTH_DELIMITED, UpdatedReachPoints.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UpdatedReachPoints decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.reach_point_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(UpdatedReachPoints r100) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.reach_point_ids) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ UpdatedReachPoints decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(UpdatedReachPoints r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, UpdatedReachPoints r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.reach_point_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdatedReachPoints r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UpdatedReachPoints();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.reach_point_ids = Internal.copyOf("reach_point_ids", this.reach_point_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return UpdatedReachPoints.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public UpdatedReachPoints(List<String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public UpdatedReachPoints(List<String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.reach_point_ids = Internal.immutableCopyOf("reach_point_ids", r100);
        }
    }

    static {
        ProtoAdapter_PushUGScenarioInfo r100 = new ProtoAdapter_PushUGScenarioInfo();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.app_id = this.app_id;
        r100.scenario_id = this.scenario_id;
        r100.local_rule = this.local_rule;
        r100.reach_point_ids = this.reach_point_ids;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushUGScenarioInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushUGScenarioInfo(String r100, String r101, LocalRule r102, UpdatedReachPoints r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PushUGScenarioInfo(String r100, String r101, LocalRule r102, UpdatedReachPoints r103, ByteString r104) {
        super(ADAPTER, r104);
        if (Internal.countNonNull(r102, r103) > 1) goto L7;
        this.app_id = r100;
        this.scenario_id = r101;
        this.local_rule = r102;
        this.reach_point_ids = r103;
        return;
    L7:
        throw new IllegalArgumentException("at most one of local_rule, reach_point_ids may be non-null");
    }
}
