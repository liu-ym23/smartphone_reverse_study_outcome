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
public final class ReachPointEntity extends Message<ReachPointEntity, Builder> {
    public static final ProtoAdapter<ReachPointEntity> ADAPTER = null;
    public static final String DEFAULT_REACH_POINT_ID = "";
    public static final String DEFAULT_SCENARIO_ID = "";
    public static final String DEFAULT_TYPE = "";
    private static final long serialVersionUID = 0;
    public final ReachPointConfig config;
    public final List<ReachPointMaterial> material;
    public final String reach_point_id;
    public final String scenario_id;
    public final String type;

    public static final class Builder extends Message.Builder<ReachPointEntity, Builder> {
        public ReachPointConfig config;
        public List<ReachPointMaterial> material;
        public String reach_point_id;
        public String scenario_id;
        public String type;

        @Override // com.squareup.wire.Message.Builder
        public ReachPointEntity build() {
            return new ReachPointEntity(this.reach_point_id, this.scenario_id, this.type, this.config, this.material, super.buildUnknownFields());
        }

        public Builder() {
            this.material = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder config(ReachPointConfig r100) {
            this.config = r100;
            return this;
        }

        public Builder material(List<ReachPointMaterial> r100) {
            Internal.checkElementsNotNull(r100);
            this.material = r100;
            return this;
        }

        public Builder reach_point_id(String r100) {
            this.reach_point_id = r100;
            return this;
        }

        public Builder scenario_id(String r100) {
            this.scenario_id = r100;
            return this;
        }

        public Builder type(String r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ReachPointEntity extends ProtoAdapter<ReachPointEntity> {
        public ProtoAdapter_ReachPointEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, ReachPointEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ReachPointEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.reach_point_id = "";
            r101.scenario_id = "";
            r101.type = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.reach_point_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.scenario_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.config = ReachPointConfig.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.material.add(ReachPointMaterial.ADAPTER.decode(r100));
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
        public int encodedSize2(ReachPointEntity r100) {
            String r101 = r100.reach_point_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.scenario_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.type;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ReachPointConfig r110 = r100.config;
            if (r110 == null) goto L18;
            r102 = ReachPointConfig.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            return ((r109 + r102) + ReachPointMaterial.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.material)) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ReachPointEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ReachPointEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ReachPointEntity r101) throws IOException {
            String r102 = r101.reach_point_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.scenario_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.type;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            ReachPointConfig r105 = r101.config;
            if (r105 == null) goto L14;
            ReachPointConfig.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            ReachPointMaterial.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.material);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ReachPointEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ReachPointEntity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.reach_point_id = this.reach_point_id;
        r100.scenario_id = this.scenario_id;
        r100.type = this.type;
        r100.config = this.config;
        r100.material = Internal.copyOf("material", this.material);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ReachPointEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ReachPointEntity(String r100, String r101, String r110, ReachPointConfig r111, List<ReachPointMaterial> r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public ReachPointEntity(String r100, String r101, String r102, ReachPointConfig r103, List<ReachPointMaterial> r104, ByteString r105) {
        super(ADAPTER, r105);
        this.reach_point_id = r100;
        this.scenario_id = r101;
        this.type = r102;
        this.config = r103;
        this.material = Internal.immutableCopyOf("material", r104);
    }
}
