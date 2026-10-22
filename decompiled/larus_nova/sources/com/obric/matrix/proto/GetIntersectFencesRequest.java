package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes33.dex */
public final class GetIntersectFencesRequest extends Message<GetIntersectFencesRequest, Builder> {
    public static final ProtoAdapter<GetIntersectFencesRequest> ADAPTER = null;
    public static final Boolean DEFAULT_FILTER_ADJACENCY = null;
    public static final Boolean DEFAULT_WITH_BORDER_INFO = null;
    public static final Boolean DEFAULT_WITH_OVERLAP_FROM = null;
    public static final Boolean DEFAULT_WITH_OVERLAP_TARGET = null;
    private static final long serialVersionUID = 0;

    @SerializedName("fence_to_cal")
    @WireField(adapter = "com.obric.matrix.proto.Fence#ADAPTER", tag = 3)
    public final Fence fence_to_cal;

    @SerializedName("filter_adjacency")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 7)
    public final Boolean filter_adjacency;

    @SerializedName("from_dataset")
    @WireField(adapter = "com.obric.matrix.proto.TargetDataset#ADAPTER", tag = 4)
    public final TargetDataset from_dataset;

    @SerializedName("from_fence_id_list")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 5)
    public final List<String> from_fence_id_list;

    @SerializedName("properties_filter")
    @WireField(adapter = "com.obric.matrix.proto.StringArray#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, StringArray> properties_filter;

    @SerializedName("target_dataset")
    @WireField(adapter = "com.obric.matrix.proto.TargetDataset#ADAPTER", tag = 1)
    public final TargetDataset target_dataset;

    @SerializedName("with_border_info")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 6)
    public final Boolean with_border_info;

    @SerializedName("with_overlap_from")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean with_overlap_from;

    @SerializedName("with_overlap_target")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 9)
    public final Boolean with_overlap_target;

    public static final class Builder extends Message.Builder<GetIntersectFencesRequest, Builder> {
        public Fence fence_to_cal;
        public Boolean filter_adjacency;
        public TargetDataset from_dataset;
        public List<String> from_fence_id_list;
        public Map<String, StringArray> properties_filter;
        public TargetDataset target_dataset;
        public Boolean with_border_info;
        public Boolean with_overlap_from;
        public Boolean with_overlap_target;

        @Override // com.squareup.wire.Message.Builder
        public GetIntersectFencesRequest build() {
            return new GetIntersectFencesRequest(this.target_dataset, this.properties_filter, this.fence_to_cal, this.from_dataset, this.from_fence_id_list, this.with_border_info, this.filter_adjacency, this.with_overlap_from, this.with_overlap_target, super.buildUnknownFields());
        }

        public Builder() {
            Boolean r100 = Boolean.FALSE;
            this.with_border_info = r100;
            this.filter_adjacency = r100;
            this.with_overlap_from = r100;
            this.with_overlap_target = r100;
            this.properties_filter = Internal.newMutableMap();
            this.from_fence_id_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder fence_to_cal(Fence r100) {
            this.fence_to_cal = r100;
            return this;
        }

        public Builder filter_adjacency(Boolean r100) {
            this.filter_adjacency = r100;
            return this;
        }

        public Builder from_dataset(TargetDataset r100) {
            this.from_dataset = r100;
            return this;
        }

        public Builder from_fence_id_list(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.from_fence_id_list = r100;
            return this;
        }

        public Builder properties_filter(Map<String, StringArray> r100) {
            Internal.checkElementsNotNull(r100);
            this.properties_filter = r100;
            return this;
        }

        public Builder target_dataset(TargetDataset r100) {
            this.target_dataset = r100;
            return this;
        }

        public Builder with_border_info(Boolean r100) {
            this.with_border_info = r100;
            return this;
        }

        public Builder with_overlap_from(Boolean r100) {
            this.with_overlap_from = r100;
            return this;
        }

        public Builder with_overlap_target(Boolean r100) {
            this.with_overlap_target = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetIntersectFencesRequest extends ProtoAdapter<GetIntersectFencesRequest> {
        private final ProtoAdapter<Map<String, StringArray>> properties_filter;

        public ProtoAdapter_GetIntersectFencesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetIntersectFencesRequest.class);
            this.properties_filter = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, StringArray.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetIntersectFencesRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r101.with_overlap_target(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L8:
            r101.with_overlap_from(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L9:
            r101.filter_adjacency(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L10:
            r101.with_border_info(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L11:
            r101.from_fence_id_list.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            r101.from_dataset(TargetDataset.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.fence_to_cal(Fence.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.properties_filter.putAll(this.properties_filter.decode(r100));
            goto L3
        L15:
            r101.target_dataset(TargetDataset.ADAPTER.decode(r100));
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
        public int encodedSize2(GetIntersectFencesRequest r100) {
            ProtoAdapter<TargetDataset> r101 = TargetDataset.ADAPTER;
            int r102 = (((r101.encodedSizeWithTag(1, r100.target_dataset) + this.properties_filter.encodedSizeWithTag(2, r100.properties_filter)) + Fence.ADAPTER.encodedSizeWithTag(3, r100.fence_to_cal)) + r101.encodedSizeWithTag(4, r100.from_dataset)) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(5, r100.from_fence_id_list);
            ProtoAdapter<Boolean> r103 = ProtoAdapter.BOOL;
            return ((((r102 + r103.encodedSizeWithTag(6, r100.with_border_info)) + r103.encodedSizeWithTag(7, r100.filter_adjacency)) + r103.encodedSizeWithTag(8, r100.with_overlap_from)) + r103.encodedSizeWithTag(9, r100.with_overlap_target)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public GetIntersectFencesRequest redact2(GetIntersectFencesRequest r100) {
            Builder r101 = r100.newBuilder();
            TargetDataset r102 = r101.target_dataset;
            if (r102 == null) goto L5;
            r101.target_dataset = TargetDataset.ADAPTER.redact(r102);
        L5:
            Internal.redactElements(r101.properties_filter, StringArray.ADAPTER);
            Fence r103 = r101.fence_to_cal;
            if (r103 == null) goto L8;
            r101.fence_to_cal = Fence.ADAPTER.redact(r103);
        L8:
            TargetDataset r104 = r101.from_dataset;
            if (r104 == null) goto L11;
            r101.from_dataset = TargetDataset.ADAPTER.redact(r104);
        L11:
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetIntersectFencesRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetIntersectFencesRequest r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetIntersectFencesRequest redact(GetIntersectFencesRequest r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetIntersectFencesRequest r101) throws IOException {
            ProtoAdapter<TargetDataset> r102 = TargetDataset.ADAPTER;
            r102.encodeWithTag(r100, 1, r101.target_dataset);
            this.properties_filter.encodeWithTag(r100, 2, r101.properties_filter);
            Fence.ADAPTER.encodeWithTag(r100, 3, r101.fence_to_cal);
            r102.encodeWithTag(r100, 4, r101.from_dataset);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 5, r101.from_fence_id_list);
            ProtoAdapter<Boolean> r103 = ProtoAdapter.BOOL;
            r103.encodeWithTag(r100, 6, r101.with_border_info);
            r103.encodeWithTag(r100, 7, r101.filter_adjacency);
            r103.encodeWithTag(r100, 8, r101.with_overlap_from);
            r103.encodeWithTag(r100, 9, r101.with_overlap_target);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetIntersectFencesRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetIntersectFencesRequest();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_WITH_BORDER_INFO = r100;
        DEFAULT_FILTER_ADJACENCY = r100;
        DEFAULT_WITH_OVERLAP_FROM = r100;
        DEFAULT_WITH_OVERLAP_TARGET = r100;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L33;
        int r101 = unknownFields().hashCode() * 37;
        TargetDataset r102 = this.target_dataset;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (((r101 + r104) * 37) + this.properties_filter.hashCode()) * 37;
        Fence r106 = this.fence_to_cal;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        TargetDataset r109 = this.from_dataset;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (((r108 + r110) * 37) + this.from_fence_id_list.hashCode()) * 37;
        Boolean r112 = this.with_border_info;
        if (r112 == null) goto L19;
        int r113 = r112.hashCode();
    L20:
        int r114 = (r111 + r113) * 37;
        Boolean r115 = this.filter_adjacency;
        if (r115 == null) goto L23;
        int r116 = r115.hashCode();
    L24:
        int r117 = (r114 + r116) * 37;
        Boolean r118 = this.with_overlap_from;
        if (r118 == null) goto L27;
        int r119 = r118.hashCode();
    L28:
        int r120 = (r117 + r119) * 37;
        Boolean r121 = this.with_overlap_target;
        if (r121 == null) goto L31;
        r103 = r121.hashCode();
    L31:
        int r122 = r120 + r103;
        this.hashCode = r122;
        return r122;
    L27:
        r119 = 0;
        goto L28
    L23:
        r116 = 0;
        goto L24
    L19:
        r113 = 0;
        goto L20
    L15:
        r110 = 0;
        goto L16
    L11:
        r107 = 0;
        goto L12
    L7:
        r104 = 0;
        goto L8
    L33:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.target_dataset = this.target_dataset;
        r100.properties_filter = Internal.copyOf("properties_filter", this.properties_filter);
        r100.fence_to_cal = this.fence_to_cal;
        r100.from_dataset = this.from_dataset;
        r100.from_fence_id_list = Internal.copyOf("from_fence_id_list", this.from_fence_id_list);
        r100.with_border_info = this.with_border_info;
        r100.filter_adjacency = this.filter_adjacency;
        r100.with_overlap_from = this.with_overlap_from;
        r100.with_overlap_target = this.with_overlap_target;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.target_dataset == null) goto L5;
        r100.append(", target_dataset=");
        r100.append(this.target_dataset);
    L5:
        Map<String, StringArray> r101 = this.properties_filter;
        if (r101 == null) goto L11;
        if (r101.isEmpty() == true) goto L11;
        r100.append(", properties_filter=");
        r100.append(this.properties_filter);
    L11:
        if (this.fence_to_cal == null) goto L14;
        r100.append(", fence_to_cal=");
        r100.append(this.fence_to_cal);
    L14:
        if (this.from_dataset == null) goto L16;
        r100.append(", from_dataset=");
        r100.append(this.from_dataset);
    L16:
        List<String> r102 = this.from_fence_id_list;
        if (r102 == null) goto L22;
        if (r102.isEmpty() == true) goto L22;
        r100.append(", from_fence_id_list=");
        r100.append(this.from_fence_id_list);
    L22:
        if (this.with_border_info == null) goto L25;
        r100.append(", with_border_info=");
        r100.append(this.with_border_info);
    L25:
        if (this.filter_adjacency == null) goto L28;
        r100.append(", filter_adjacency=");
        r100.append(this.filter_adjacency);
    L28:
        if (this.with_overlap_from == null) goto L31;
        r100.append(", with_overlap_from=");
        r100.append(this.with_overlap_from);
    L31:
        if (this.with_overlap_target == null) goto L33;
        r100.append(", with_overlap_target=");
        r100.append(this.with_overlap_target);
    L33:
        StringBuilder r103 = r100.replace(0, 2, "GetIntersectFencesRequest{");
        r103.append('}');
        return r103.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetIntersectFencesRequest) == true) goto L8;
        return false;
    L8:
        GetIntersectFencesRequest r101 = (GetIntersectFencesRequest) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L29:
        return false;
    L11:
        if (Internal.equals(this.target_dataset, r101.target_dataset) == false) goto L29;
        if (this.properties_filter.equals(r101.properties_filter) == false) goto L29;
        if (Internal.equals(this.fence_to_cal, r101.fence_to_cal) == false) goto L29;
        if (Internal.equals(this.from_dataset, r101.from_dataset) == false) goto L29;
        if (this.from_fence_id_list.equals(r101.from_fence_id_list) == false) goto L29;
        if (Internal.equals(this.with_border_info, r101.with_border_info) == false) goto L29;
        if (Internal.equals(this.filter_adjacency, r101.filter_adjacency) == false) goto L29;
        if (Internal.equals(this.with_overlap_from, r101.with_overlap_from) == false) goto L29;
        if (Internal.equals(this.with_overlap_target, r101.with_overlap_target) == false) goto L29;
        return true;
    }

    public GetIntersectFencesRequest(TargetDataset r110, Map<String, StringArray> r111, Fence r112, TargetDataset r113, List<String> r114, Boolean r115, Boolean r116, Boolean r117, Boolean r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public GetIntersectFencesRequest(TargetDataset r100, Map<String, StringArray> r101, Fence r102, TargetDataset r103, List<String> r104, Boolean r105, Boolean r106, Boolean r107, Boolean r110, ByteString r111) {
        super(ADAPTER, r111);
        this.target_dataset = r100;
        this.properties_filter = Internal.immutableCopyOf("properties_filter", r101);
        this.fence_to_cal = r102;
        this.from_dataset = r103;
        this.from_fence_id_list = Internal.immutableCopyOf("from_fence_id_list", r104);
        this.with_border_info = r105;
        this.filter_adjacency = r106;
        this.with_overlap_from = r107;
        this.with_overlap_target = r110;
    }
}
