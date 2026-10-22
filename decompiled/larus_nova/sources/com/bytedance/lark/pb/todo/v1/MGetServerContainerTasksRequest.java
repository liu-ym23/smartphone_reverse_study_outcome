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
public final class MGetServerContainerTasksRequest extends Message<MGetServerContainerTasksRequest, Builder> {
    public static final ProtoAdapter<MGetServerContainerTasksRequest> ADAPTER = null;
    public static final String DEFAULT_CONTAINER_GUID = "";
    public static final ProtoAdapter_MGetServerContainerTasksRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String container_guid;
    public final List<String> task_guids;

    public static final class Builder extends Message.Builder<MGetServerContainerTasksRequest, Builder> implements d<MGetServerContainerTasksRequest> {
        public String container_guid;
        public List<String> task_guids;

        @Override // com.squareup.wire.Message.Builder
        public MGetServerContainerTasksRequest build() {
            return new MGetServerContainerTasksRequest(this.container_guid, this.task_guids, super.buildUnknownFields());
        }

        public Builder() {
            this.task_guids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder container_guid(String r100) {
            this.container_guid = r100;
            return this;
        }

        public Builder task_guids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.task_guids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MGetServerContainerTasksRequest extends ProtoAdapter<MGetServerContainerTasksRequest> implements c<MGetServerContainerTasksRequest> {
        public ProtoAdapter_MGetServerContainerTasksRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MGetServerContainerTasksRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MGetServerContainerTasksRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.container_guid = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.container_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.task_guids.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(MGetServerContainerTasksRequest r100) {
            String r101 = r100.container_guid;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.task_guids)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MGetServerContainerTasksRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MGetServerContainerTasksRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MGetServerContainerTasksRequest r101) throws IOException {
            String r102 = r101.container_guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.task_guids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MGetServerContainerTasksRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MGetServerContainerTasksRequest r100 = new ProtoAdapter_MGetServerContainerTasksRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.container_guid = this.container_guid;
        r100.task_guids = Internal.copyOf("task_guids", this.task_guids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MGetServerContainerTasksRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MGetServerContainerTasksRequest(String r100, List<String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public MGetServerContainerTasksRequest(String r100, List<String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.container_guid = r100;
        this.task_guids = Internal.immutableCopyOf("task_guids", r101);
    }
}
