package com.bytedance.lark.pb.search.v1;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.lark.pb.basic.v1.ActionType;
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
public final class ChatterPermissionsRequest extends Message<ChatterPermissionsRequest, Builder> {
    public static final ProtoAdapter<ChatterPermissionsRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<ActionType> actions;

    public static final class Builder extends Message.Builder<ChatterPermissionsRequest, Builder> {
        public List<ActionType> actions;

        @Override // com.squareup.wire.Message.Builder
        public ChatterPermissionsRequest build() {
            return new ChatterPermissionsRequest(this.actions, super.buildUnknownFields());
        }

        public Builder() {
            this.actions = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder actions(List<ActionType> r100) {
            Internal.checkElementsNotNull(r100);
            this.actions = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatterPermissionsRequest extends ProtoAdapter<ChatterPermissionsRequest> {
        public ProtoAdapter_ChatterPermissionsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatterPermissionsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatterPermissionsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.actions.add(ActionType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ChatterPermissionsRequest r100) {
            return ActionType.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.actions) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ChatterPermissionsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatterPermissionsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatterPermissionsRequest r101) throws IOException {
            ActionType.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.actions);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatterPermissionsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatterPermissionsRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.actions = Internal.copyOf(SlcCommonAction.KEY_ACTIONS, this.actions);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatterPermissionsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatterPermissionsRequest(List<ActionType> r100) {
        this(r100, ByteString.EMPTY);
    }

    public ChatterPermissionsRequest(List<ActionType> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.actions = Internal.immutableCopyOf(SlcCommonAction.KEY_ACTIONS, r100);
    }
}
