package com.bytedance.lark.pb.todo.v1;

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
public final class GetSharedTodosRequest extends Message<GetSharedTodosRequest, Builder> {
    public static final ProtoAdapter<GetSharedTodosRequest> ADAPTER = null;
    public static final ProtoAdapter_GetSharedTodosRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final AuthScene auth_scene;
    public final List<String> guids;

    public static final class Builder extends Message.Builder<GetSharedTodosRequest, Builder> implements d<GetSharedTodosRequest> {
        public AuthScene auth_scene;
        public List<String> guids;

        @Override // com.squareup.wire.Message.Builder
        public GetSharedTodosRequest build() {
            return new GetSharedTodosRequest(this.guids, this.auth_scene, super.buildUnknownFields());
        }

        public Builder() {
            this.guids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder auth_scene(AuthScene r100) {
            this.auth_scene = r100;
            return this;
        }

        public Builder guids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.guids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSharedTodosRequest extends ProtoAdapter<GetSharedTodosRequest> implements c<GetSharedTodosRequest> {
        public ProtoAdapter_GetSharedTodosRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSharedTodosRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetSharedTodosRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.guids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.auth_scene = AuthScene.ADAPTER.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetSharedTodosRequest r100) {
            int r101 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.guids);
            AuthScene r102 = r100.auth_scene;
            if (r102 == null) goto L5;
            int r103 = AuthScene.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetSharedTodosRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetSharedTodosRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetSharedTodosRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.guids);
            AuthScene r102 = r101.auth_scene;
            if (r102 == null) goto L5;
            AuthScene.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetSharedTodosRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetSharedTodosRequest r100 = new ProtoAdapter_GetSharedTodosRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.guids = Internal.copyOf("guids", this.guids);
        r100.auth_scene = this.auth_scene;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetSharedTodosRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetSharedTodosRequest(List<String> r100, AuthScene r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetSharedTodosRequest(List<String> r100, AuthScene r101, ByteString r102) {
        super(ADAPTER, r102);
        this.guids = Internal.immutableCopyOf("guids", r100);
        this.auth_scene = r101;
    }
}
