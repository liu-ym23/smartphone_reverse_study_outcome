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

/* JADX INFO: loaded from: classes20.dex */
public final class NodeGroupsConfig extends Message<NodeGroupsConfig, Builder> {
    public static final ProtoAdapter<NodeGroupsConfig> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Groups> groups;

    public static final class Builder extends Message.Builder<NodeGroupsConfig, Builder> {
        public List<Groups> groups;

        @Override // com.squareup.wire.Message.Builder
        public NodeGroupsConfig build() {
            return new NodeGroupsConfig(this.groups, super.buildUnknownFields());
        }

        public Builder() {
            this.groups = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder groups(List<Groups> r100) {
            Internal.checkElementsNotNull(r100);
            this.groups = r100;
            return this;
        }
    }

    public static final class Groups extends Message<Groups, Builder> {
        public static final ProtoAdapter<Groups> ADAPTER = null;
        public static final String DEFAULT_ID = "";
        public static final String DEFAULT_LAYOUT_ALGORITHM = "";
        public static final String DEFAULT_NAME = "";
        private static final long serialVersionUID = 0;
        public final List<Groups> groups;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public final String f253775id;
        public final String layout_algorithm;
        public final String name;
        public final List<String> nodes;

        public static final class Builder extends Message.Builder<Groups, Builder> {
            public List<Groups> groups;

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            public String f253776id;
            public String layout_algorithm;
            public String name;
            public List<String> nodes;

            @Override // com.squareup.wire.Message.Builder
            public Groups build() {
                return new Groups(this.f253776id, this.name, this.nodes, this.groups, this.layout_algorithm, super.buildUnknownFields());
            }

            public Builder() {
                this.nodes = Internal.newMutableList();
                this.groups = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder groups(List<Groups> r100) {
                Internal.checkElementsNotNull(r100);
                this.groups = r100;
                return this;
            }

            public Builder id(String r100) {
                this.f253776id = r100;
                return this;
            }

            public Builder layout_algorithm(String r100) {
                this.layout_algorithm = r100;
                return this;
            }

            public Builder name(String r100) {
                this.name = r100;
                return this;
            }

            public Builder nodes(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.nodes = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Groups extends ProtoAdapter<Groups> {
            public ProtoAdapter_Groups() {
                super(FieldEncoding.LENGTH_DELIMITED, Groups.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Groups decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.f253776id = "";
                r101.name = "";
                r101.layout_algorithm = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.f253776id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.nodes.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.groups.add(Groups.ADAPTER.decode(r100));
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.layout_algorithm = ProtoAdapter.STRING.decode(r100);
                goto L3
            L15:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Groups r100) {
                String r101 = r100.f253775id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.name;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                ProtoAdapter<String> r107 = ProtoAdapter.STRING;
                int r108 = (r106 + r107.asRepeated().encodedSizeWithTag(3, r100.nodes)) + Groups.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.groups);
                String r109 = r100.layout_algorithm;
                if (r109 == null) goto L14;
                r102 = r107.encodedSizeWithTag(5, r109);
            L14:
                return (r108 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Groups decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Groups r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Groups r101) throws IOException {
                String r102 = r101.f253775id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.name;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                ProtoAdapter<String> r104 = ProtoAdapter.STRING;
                r104.asRepeated().encodeWithTag(r100, 3, r101.nodes);
                Groups.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.groups);
                String r105 = r101.layout_algorithm;
                if (r105 == null) goto L11;
                r104.encodeWithTag(r100, 5, r105);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Groups r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Groups();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.f253776id = this.f253775id;
            r100.name = this.name;
            r100.nodes = Internal.copyOf("nodes", this.nodes);
            r100.groups = Internal.copyOf("groups", this.groups);
            r100.layout_algorithm = this.layout_algorithm;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Groups.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Groups(String r100, String r101, List<String> r110, List<Groups> r111, String r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public Groups(String r100, String r101, List<String> r102, List<Groups> r103, String r104, ByteString r105) {
            super(ADAPTER, r105);
            this.f253775id = r100;
            this.name = r101;
            this.nodes = Internal.immutableCopyOf("nodes", r102);
            this.groups = Internal.immutableCopyOf("groups", r103);
            this.layout_algorithm = r104;
        }
    }

    public static final class ProtoAdapter_NodeGroupsConfig extends ProtoAdapter<NodeGroupsConfig> {
        public ProtoAdapter_NodeGroupsConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, NodeGroupsConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public NodeGroupsConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.groups.add(Groups.ADAPTER.decode(r100));
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
        public int encodedSize2(NodeGroupsConfig r100) {
            return Groups.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.groups) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ NodeGroupsConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(NodeGroupsConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, NodeGroupsConfig r101) throws IOException {
            Groups.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.groups);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, NodeGroupsConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_NodeGroupsConfig();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.groups = Internal.copyOf("groups", this.groups);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return NodeGroupsConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public NodeGroupsConfig(List<Groups> r100) {
        this(r100, ByteString.EMPTY);
    }

    public NodeGroupsConfig(List<Groups> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.groups = Internal.immutableCopyOf("groups", r100);
    }
}
