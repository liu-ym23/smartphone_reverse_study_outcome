package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class WorkflowConf extends Message<WorkflowConf, Builder> {
    public static final ProtoAdapter<WorkflowConf> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final NodeGroupsConfig node_groups_config;

    public static final class Builder extends Message.Builder<WorkflowConf, Builder> {
        public NodeGroupsConfig node_groups_config;

        @Override // com.squareup.wire.Message.Builder
        public WorkflowConf build() {
            return new WorkflowConf(this.node_groups_config, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder node_groups_config(NodeGroupsConfig r100) {
            this.node_groups_config = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_WorkflowConf extends ProtoAdapter<WorkflowConf> {
        public ProtoAdapter_WorkflowConf() {
            super(FieldEncoding.LENGTH_DELIMITED, WorkflowConf.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public WorkflowConf decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.node_groups_config = NodeGroupsConfig.ADAPTER.decode(r100);
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
        public int encodedSize2(WorkflowConf r100) {
            NodeGroupsConfig r101 = r100.node_groups_config;
            if (r101 == null) goto L5;
            int r102 = NodeGroupsConfig.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ WorkflowConf decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(WorkflowConf r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, WorkflowConf r101) throws IOException {
            NodeGroupsConfig r102 = r101.node_groups_config;
            if (r102 == null) goto L5;
            NodeGroupsConfig.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WorkflowConf r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_WorkflowConf();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.node_groups_config = this.node_groups_config;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return WorkflowConf.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public WorkflowConf(NodeGroupsConfig r100) {
        this(r100, ByteString.EMPTY);
    }

    public WorkflowConf(NodeGroupsConfig r100, ByteString r101) {
        super(ADAPTER, r101);
        this.node_groups_config = r100;
    }
}
