package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class WorkflowEntity extends Message<WorkflowEntity, Builder> {
    public static final ProtoAdapter<WorkflowEntity> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Connection> connections;
    public final NodeGroupsConfig node_groups_config;
    public final List<Node> nodes;

    public static final class Builder extends Message.Builder<WorkflowEntity, Builder> {
        public List<Connection> connections;
        public NodeGroupsConfig node_groups_config;
        public List<Node> nodes;

        @Override // com.squareup.wire.Message.Builder
        public WorkflowEntity build() {
            return new WorkflowEntity(this.nodes, this.connections, this.node_groups_config, super.buildUnknownFields());
        }

        public Builder() {
            this.nodes = Internal.newMutableList();
            this.connections = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder connections(List<Connection> r100) {
            Internal.checkElementsNotNull(r100);
            this.connections = r100;
            return this;
        }

        public Builder node_groups_config(NodeGroupsConfig r100) {
            this.node_groups_config = r100;
            return this;
        }

        public Builder nodes(List<Node> r100) {
            Internal.checkElementsNotNull(r100);
            this.nodes = r100;
            return this;
        }
    }

    public static final class Connection extends Message<Connection, Builder> {
        public static final ProtoAdapter<Connection> ADAPTER = null;
        public static final String DEFAULT_SOURCE_STATE_KEY = "";
        public static final String DEFAULT_TARGET_STATE_KEY = "";
        private static final long serialVersionUID = 0;
        public final String source_state_key;
        public final String target_state_key;

        public static final class Builder extends Message.Builder<Connection, Builder> {
            public String source_state_key;
            public String target_state_key;

            @Override // com.squareup.wire.Message.Builder
            public Connection build() {
                return new Connection(this.source_state_key, this.target_state_key, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder source_state_key(String r100) {
                this.source_state_key = r100;
                return this;
            }

            public Builder target_state_key(String r100) {
                this.target_state_key = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Connection extends ProtoAdapter<Connection> {
            public ProtoAdapter_Connection() {
                super(FieldEncoding.LENGTH_DELIMITED, Connection.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Connection decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.source_state_key = "";
                r101.target_state_key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.source_state_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.target_state_key = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(Connection r100) {
                String r101 = r100.source_state_key;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.target_state_key;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Connection decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Connection r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Connection r101) throws IOException {
                String r102 = r101.source_state_key;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.target_state_key;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Connection r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Connection();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.source_state_key = this.source_state_key;
            r100.target_state_key = this.target_state_key;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Connection.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Connection(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public Connection(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.source_state_key = r100;
            this.target_state_key = r101;
        }
    }

    public static final class Node extends Message<Node, Builder> {
        public static final ProtoAdapter<Node> ADAPTER = null;
        public static final String DEFAULT_NAME = "";
        public static final String DEFAULT_STATE_KEY = "";
        public static final NodeState DEFAULT_STATUE = null;
        public static final String DEFAULT_UUID = "";
        private static final long serialVersionUID = 0;
        public final String name;
        public final String state_key;
        public final NodeState statue;
        public final String uuid;

        public static final class Builder extends Message.Builder<Node, Builder> {
            public String name;
            public String state_key;
            public NodeState statue;
            public String uuid;

            @Override // com.squareup.wire.Message.Builder
            public Node build() {
                return new Node(this.uuid, this.name, this.state_key, this.statue, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder name(String r100) {
                this.name = r100;
                return this;
            }

            public Builder state_key(String r100) {
                this.state_key = r100;
                return this;
            }

            public Builder statue(NodeState r100) {
                this.statue = r100;
                return this;
            }

            public Builder uuid(String r100) {
                this.uuid = r100;
                return this;
            }
        }

        public static final enum NodeState extends Enum<NodeState> implements WireEnum {
            private static final /* synthetic */ NodeState[] $VALUES = null;
            public static final ProtoAdapter<NodeState> ADAPTER = null;
            public static final NodeState PASSED = null;
            public static final NodeState REACHED = null;
            public static final NodeState UNREACH = null;
            private final int value;

            static {
                NodeState r100 = new NodeState("UNREACH", 0, 1);
                UNREACH = r100;
                NodeState r101 = new NodeState("REACHED", 1, 2);
                REACHED = r101;
                NodeState r102 = new NodeState("PASSED", 2, 3);
                PASSED = r102;
                $VALUES = new NodeState[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(NodeState.class);
            }

            public static NodeState[] values() {
                return (NodeState[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static NodeState fromValue(int r100) {
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L13;
                if (r100 == 3) goto L11;
                return null;
            L11:
                return PASSED;
            L13:
                return REACHED;
            L15:
                return UNREACH;
            }

            public static NodeState valueOf(String r100) {
                return (NodeState) a.a(NodeState.class, r100);
            }

            private NodeState(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_Node extends ProtoAdapter<Node> {
            public ProtoAdapter_Node() {
                super(FieldEncoding.LENGTH_DELIMITED, Node.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Node decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.uuid = "";
                r101.name = "";
                r101.state_key = "";
                r101.statue = NodeState.UNREACH;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.uuid = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.state_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.statue = NodeState.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Node r100) {
                String r101 = r100.uuid;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.name;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.state_key;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                NodeState r110 = r100.statue;
                if (r110 == null) goto L18;
                r102 = NodeState.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                return (r109 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Node decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Node r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Node r101) throws IOException {
                String r102 = r101.uuid;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.name;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.state_key;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                NodeState r105 = r101.statue;
                if (r105 == null) goto L14;
                NodeState.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Node r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Node();
            DEFAULT_STATUE = NodeState.UNREACH;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.uuid = this.uuid;
            r100.name = this.name;
            r100.state_key = this.state_key;
            r100.statue = this.statue;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Node.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Node(String r100, String r101, String r102, NodeState r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public Node(String r100, String r101, String r102, NodeState r103, ByteString r104) {
            super(ADAPTER, r104);
            this.uuid = r100;
            this.name = r101;
            this.state_key = r102;
            this.statue = r103;
        }
    }

    public static final class ProtoAdapter_WorkflowEntity extends ProtoAdapter<WorkflowEntity> {
        public ProtoAdapter_WorkflowEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, WorkflowEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public WorkflowEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.nodes.add(Node.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.connections.add(Connection.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.node_groups_config = NodeGroupsConfig.ADAPTER.decode(r100);
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
        public int encodedSize2(WorkflowEntity r100) {
            int r101 = Node.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.nodes) + Connection.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.connections);
            NodeGroupsConfig r102 = r100.node_groups_config;
            if (r102 == null) goto L5;
            int r103 = NodeGroupsConfig.ADAPTER.encodedSizeWithTag(3, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ WorkflowEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(WorkflowEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, WorkflowEntity r101) throws IOException {
            Node.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.nodes);
            Connection.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.connections);
            NodeGroupsConfig r102 = r101.node_groups_config;
            if (r102 == null) goto L5;
            NodeGroupsConfig.ADAPTER.encodeWithTag(r100, 3, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WorkflowEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_WorkflowEntity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.nodes = Internal.copyOf("nodes", this.nodes);
        r100.connections = Internal.copyOf("connections", this.connections);
        r100.node_groups_config = this.node_groups_config;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return WorkflowEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public WorkflowEntity(List<Node> r100, List<Connection> r101, NodeGroupsConfig r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public WorkflowEntity(List<Node> r100, List<Connection> r101, NodeGroupsConfig r102, ByteString r103) {
        super(ADAPTER, r103);
        this.nodes = Internal.immutableCopyOf("nodes", r100);
        this.connections = Internal.immutableCopyOf("connections", r101);
        this.node_groups_config = r102;
    }
}
