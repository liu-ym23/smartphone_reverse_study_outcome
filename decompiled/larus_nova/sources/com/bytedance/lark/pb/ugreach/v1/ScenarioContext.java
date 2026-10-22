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

/* JADX INFO: loaded from: classes20.dex */
public final class ScenarioContext extends Message<ScenarioContext, Builder> {
    public static final ProtoAdapter<ScenarioContext> ADAPTER = null;
    public static final Integer DEFAULT_PRIORITY = null;
    public static final String DEFAULT_SCENARIO_ID = "";
    private static final long serialVersionUID = 0;
    public final List<ReachPointEntity> entities;
    public final LocalRule local_rule;
    public final Integer priority;
    public final String scenario_id;
    public final List<String> share_scenario_ids;

    public static final class Builder extends Message.Builder<ScenarioContext, Builder> {
        public List<ReachPointEntity> entities;
        public LocalRule local_rule;
        public Integer priority;
        public String scenario_id;
        public List<String> share_scenario_ids;

        @Override // com.squareup.wire.Message.Builder
        public ScenarioContext build() {
            return new ScenarioContext(this.scenario_id, this.local_rule, this.priority, this.share_scenario_ids, this.entities, super.buildUnknownFields());
        }

        public Builder() {
            this.share_scenario_ids = Internal.newMutableList();
            this.entities = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder entities(List<ReachPointEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.entities = r100;
            return this;
        }

        public Builder local_rule(LocalRule r100) {
            this.local_rule = r100;
            return this;
        }

        public Builder priority(Integer r100) {
            this.priority = r100;
            return this;
        }

        public Builder scenario_id(String r100) {
            this.scenario_id = r100;
            return this;
        }

        public Builder share_scenario_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.share_scenario_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ScenarioContext extends ProtoAdapter<ScenarioContext> {
        public ProtoAdapter_ScenarioContext() {
            super(FieldEncoding.LENGTH_DELIMITED, ScenarioContext.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ScenarioContext decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.scenario_id = "";
            r101.priority = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.scenario_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.local_rule = LocalRule.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.priority = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.share_scenario_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.entities.add(ReachPointEntity.ADAPTER.decode(r100));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ScenarioContext r100) {
            String r101 = r100.scenario_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            LocalRule r104 = r100.local_rule;
            if (r104 == null) goto L9;
            int r105 = LocalRule.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.priority;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            return (((r106 + r102) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(4, r100.share_scenario_ids)) + ReachPointEntity.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.entities)) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ScenarioContext decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ScenarioContext r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ScenarioContext r101) throws IOException {
            String r102 = r101.scenario_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            LocalRule r103 = r101.local_rule;
            if (r103 == null) goto L8;
            LocalRule.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.priority;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 4, r101.share_scenario_ids);
            ReachPointEntity.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.entities);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ScenarioContext r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ScenarioContext();
        DEFAULT_PRIORITY = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.scenario_id = this.scenario_id;
        r100.local_rule = this.local_rule;
        r100.priority = this.priority;
        r100.share_scenario_ids = Internal.copyOf("share_scenario_ids", this.share_scenario_ids);
        r100.entities = Internal.copyOf("entities", this.entities);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ScenarioContext.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ScenarioContext(String r100, LocalRule r101, Integer r110, List<String> r111, List<ReachPointEntity> r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public ScenarioContext(String r100, LocalRule r101, Integer r102, List<String> r103, List<ReachPointEntity> r104, ByteString r105) {
        super(ADAPTER, r105);
        this.scenario_id = r100;
        this.local_rule = r101;
        this.priority = r102;
        this.share_scenario_ids = Internal.immutableCopyOf("share_scenario_ids", r103);
        this.entities = Internal.immutableCopyOf("entities", r104);
    }
}
