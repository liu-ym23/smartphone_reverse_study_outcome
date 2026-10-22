package com.ss.android.lark.pb.videochat_my_ai;

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
public final class EmptyStateInfo extends Message<EmptyStateInfo, Builder> {
    public static final ProtoAdapter<EmptyStateInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<EmptyStateMaterial> mempty_state_materials;

    public static final class Builder extends Message.Builder<EmptyStateInfo, Builder> {
        public List<EmptyStateMaterial> mempty_state_materials;

        @Override // com.squareup.wire.Message.Builder
        public EmptyStateInfo build() {
            return new EmptyStateInfo(this.mempty_state_materials, super.buildUnknownFields());
        }

        public Builder() {
            this.mempty_state_materials = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder empty_state_materials(List<EmptyStateMaterial> r100) {
            Internal.checkElementsNotNull(r100);
            this.mempty_state_materials = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EmptyStateInfo extends ProtoAdapter<EmptyStateInfo> {
        public ProtoAdapter_EmptyStateInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, EmptyStateInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EmptyStateInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mempty_state_materials.add(EmptyStateMaterial.ADAPTER.decode(r100));
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
        public int encodedSize2(EmptyStateInfo r100) {
            return EmptyStateMaterial.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mempty_state_materials) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ EmptyStateInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EmptyStateInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EmptyStateInfo r101) throws IOException {
            EmptyStateMaterial.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mempty_state_materials);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EmptyStateInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EmptyStateInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mempty_state_materials = Internal.copyOf("mempty_state_materials", this.mempty_state_materials);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EmptyStateInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public EmptyStateInfo(List<EmptyStateMaterial> r100) {
        this(r100, ByteString.EMPTY);
    }

    public EmptyStateInfo(List<EmptyStateMaterial> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mempty_state_materials = Internal.immutableCopyOf("mempty_state_materials", r100);
    }
}
