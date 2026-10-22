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
import okio.ByteString;

/* JADX INFO: loaded from: classes33.dex */
public final class GetIntersectFencesResponse extends Message<GetIntersectFencesResponse, Builder> {
    public static final ProtoAdapter<GetIntersectFencesResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("fences")
    @WireField(adapter = "com.obric.matrix.proto.Fence#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<Fence> fences;

    @SerializedName("overlap_froms")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", label = WireField.Label.REPEATED, tag = 2)
    public final List<Double> overlap_froms;

    @SerializedName("overlap_targets")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", label = WireField.Label.REPEATED, tag = 3)
    public final List<Double> overlap_targets;

    public static final class Builder extends Message.Builder<GetIntersectFencesResponse, Builder> {
        public List<Fence> fences;
        public List<Double> overlap_froms;
        public List<Double> overlap_targets;

        @Override // com.squareup.wire.Message.Builder
        public GetIntersectFencesResponse build() {
            return new GetIntersectFencesResponse(this.fences, this.overlap_froms, this.overlap_targets, super.buildUnknownFields());
        }

        public Builder() {
            this.fences = Internal.newMutableList();
            this.overlap_froms = Internal.newMutableList();
            this.overlap_targets = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder fences(List<Fence> r100) {
            Internal.checkElementsNotNull(r100);
            this.fences = r100;
            return this;
        }

        public Builder overlap_froms(List<Double> r100) {
            Internal.checkElementsNotNull(r100);
            this.overlap_froms = r100;
            return this;
        }

        public Builder overlap_targets(List<Double> r100) {
            Internal.checkElementsNotNull(r100);
            this.overlap_targets = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetIntersectFencesResponse extends ProtoAdapter<GetIntersectFencesResponse> {
        public ProtoAdapter_GetIntersectFencesResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetIntersectFencesResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetIntersectFencesResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.fences.add(Fence.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.overlap_froms.add(ProtoAdapter.DOUBLE.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.overlap_targets.add(ProtoAdapter.DOUBLE.decode(r100));
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
        public int encodedSize2(GetIntersectFencesResponse r100) {
            int r101 = Fence.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.fences);
            ProtoAdapter<Double> r102 = ProtoAdapter.DOUBLE;
            return ((r101 + r102.asRepeated().encodedSizeWithTag(2, r100.overlap_froms)) + r102.asRepeated().encodedSizeWithTag(3, r100.overlap_targets)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public GetIntersectFencesResponse redact2(GetIntersectFencesResponse r100) {
            Builder r101 = r100.newBuilder();
            Internal.redactElements(r101.fences, Fence.ADAPTER);
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetIntersectFencesResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetIntersectFencesResponse r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetIntersectFencesResponse redact(GetIntersectFencesResponse r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetIntersectFencesResponse r101) throws IOException {
            Fence.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.fences);
            ProtoAdapter<Double> r102 = ProtoAdapter.DOUBLE;
            r102.asRepeated().encodeWithTag(r100, 2, r101.overlap_froms);
            r102.asRepeated().encodeWithTag(r100, 3, r101.overlap_targets);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetIntersectFencesResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetIntersectFencesResponse();
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (((((unknownFields().hashCode() * 37) + this.fences.hashCode()) * 37) + this.overlap_froms.hashCode()) * 37) + this.overlap_targets.hashCode();
        this.hashCode = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.fences = Internal.copyOf("fences", this.fences);
        r100.overlap_froms = Internal.copyOf("overlap_froms", this.overlap_froms);
        r100.overlap_targets = Internal.copyOf("overlap_targets", this.overlap_targets);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        List<Fence> r101 = this.fences;
        if (r101 != null) goto L5;
    L7:
        List<Double> r102 = this.overlap_froms;
        if (r102 != null) goto L10;
    L12:
        List<Double> r103 = this.overlap_targets;
        if (r103 != null) goto L15;
    L17:
        StringBuilder r104 = r100.replace(0, 2, "GetIntersectFencesResponse{");
        r104.append('}');
        return r104.toString();
    L15:
        if (r103.isEmpty() == true) goto L17;
        r100.append(", overlap_targets=");
        r100.append(this.overlap_targets);
        goto L17
    L10:
        if (r102.isEmpty() == true) goto L12;
        r100.append(", overlap_froms=");
        r100.append(this.overlap_froms);
        goto L12
    L5:
        if (r101.isEmpty() == true) goto L7;
        r100.append(", fences=");
        r100.append(this.fences);
        goto L7
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetIntersectFencesResponse) == true) goto L8;
        return false;
    L8:
        GetIntersectFencesResponse r101 = (GetIntersectFencesResponse) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L17:
        return false;
    L11:
        if (this.fences.equals(r101.fences) == false) goto L17;
        if (this.overlap_froms.equals(r101.overlap_froms) == false) goto L17;
        if (this.overlap_targets.equals(r101.overlap_targets) == false) goto L17;
        return true;
    }

    public GetIntersectFencesResponse(List<Fence> r100, List<Double> r101, List<Double> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetIntersectFencesResponse(List<Fence> r100, List<Double> r101, List<Double> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.fences = Internal.immutableCopyOf("fences", r100);
        this.overlap_froms = Internal.immutableCopyOf("overlap_froms", r101);
        this.overlap_targets = Internal.immutableCopyOf("overlap_targets", r102);
    }
}
