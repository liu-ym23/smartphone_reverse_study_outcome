package com.ss.android.lark.pb.compliance;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class MGetIMFileRiskTagRequest extends Message<MGetIMFileRiskTagRequest, Builder> {
    public static final ProtoAdapter<MGetIMFileRiskTagRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> mobject_id;
    public final SourceTerminal msource_terminal;

    public static final class Builder extends Message.Builder<MGetIMFileRiskTagRequest, Builder> {
        public List<String> mobject_id;
        public SourceTerminal msource_terminal;

        @Override // com.squareup.wire.Message.Builder
        public MGetIMFileRiskTagRequest build() {
            return new MGetIMFileRiskTagRequest(this.mobject_id, this.msource_terminal, super.buildUnknownFields());
        }

        public Builder() {
            this.mobject_id = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder object_id(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mobject_id = r100;
            return this;
        }

        public Builder source_terminal(SourceTerminal r100) {
            this.msource_terminal = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MGetIMFileRiskTagRequest extends ProtoAdapter<MGetIMFileRiskTagRequest> {
        public ProtoAdapter_MGetIMFileRiskTagRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MGetIMFileRiskTagRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MGetIMFileRiskTagRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mobject_id.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.msource_terminal = SourceTerminal.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        public int encodedSize2(MGetIMFileRiskTagRequest r100) {
            int r101 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.mobject_id);
            SourceTerminal r102 = r100.msource_terminal;
            if (r102 == null) goto L5;
            int r103 = SourceTerminal.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MGetIMFileRiskTagRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MGetIMFileRiskTagRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MGetIMFileRiskTagRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.mobject_id);
            SourceTerminal r102 = r101.msource_terminal;
            if (r102 == null) goto L5;
            SourceTerminal.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MGetIMFileRiskTagRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MGetIMFileRiskTagRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mobject_id = Internal.copyOf("mobject_id", this.mobject_id);
        r100.msource_terminal = this.msource_terminal;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MGetIMFileRiskTagRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MGetIMFileRiskTagRequest(List<String> r100, SourceTerminal r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public MGetIMFileRiskTagRequest(List<String> r100, SourceTerminal r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mobject_id = Internal.immutableCopyOf("mobject_id", r100);
        this.msource_terminal = r101;
    }
}
