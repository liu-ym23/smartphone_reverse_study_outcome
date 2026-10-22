package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushUserGroupEntitiesRequest extends Message<PushUserGroupEntitiesRequest, Builder> {
    public static final ProtoAdapter<PushUserGroupEntitiesRequest> ADAPTER = null;
    public static final ProtoAdapter_PushUserGroupEntitiesRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, UserGroupEntity> user_groups;

    public static final class Builder extends Message.Builder<PushUserGroupEntitiesRequest, Builder> implements d<PushUserGroupEntitiesRequest> {
        public Map<Long, UserGroupEntity> user_groups;

        @Override // com.squareup.wire.Message.Builder
        public PushUserGroupEntitiesRequest build() {
            return new PushUserGroupEntitiesRequest(this.user_groups, super.buildUnknownFields());
        }

        public Builder() {
            this.user_groups = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder user_groups(Map<Long, UserGroupEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.user_groups = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushUserGroupEntitiesRequest extends ProtoAdapter<PushUserGroupEntitiesRequest> implements c<PushUserGroupEntitiesRequest> {
        private final ProtoAdapter<Map<Long, UserGroupEntity>> user_groups;

        public ProtoAdapter_PushUserGroupEntitiesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PushUserGroupEntitiesRequest.class);
            this.user_groups = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, UserGroupEntity.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushUserGroupEntitiesRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.user_groups.putAll(this.user_groups.decode(r100));
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
        public int encodedSize2(PushUserGroupEntitiesRequest r100) {
            return this.user_groups.encodedSizeWithTag(1, r100.user_groups) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushUserGroupEntitiesRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushUserGroupEntitiesRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushUserGroupEntitiesRequest r101) throws IOException {
            this.user_groups.encodeWithTag(r100, 1, r101.user_groups);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushUserGroupEntitiesRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushUserGroupEntitiesRequest r100 = new ProtoAdapter_PushUserGroupEntitiesRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_groups = Internal.copyOf("user_groups", this.user_groups);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushUserGroupEntitiesRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushUserGroupEntitiesRequest(Map<Long, UserGroupEntity> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PushUserGroupEntitiesRequest(Map<Long, UserGroupEntity> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.user_groups = Internal.immutableCopyOf("user_groups", r100);
    }
}
