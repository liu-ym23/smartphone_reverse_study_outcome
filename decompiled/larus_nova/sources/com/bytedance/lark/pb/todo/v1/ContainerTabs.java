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
public final class ContainerTabs extends Message<ContainerTabs, Builder> {
    public static final ProtoAdapter<ContainerTabs> ADAPTER = null;
    public static final String DEFAULT_DEFAULT_TAB_GUID = "";
    private static final long serialVersionUID = 0;
    public final String default_tab_guid;
    public final List<ContainerTab> tabs;

    public static final class Builder extends Message.Builder<ContainerTabs, Builder> {
        public String default_tab_guid;
        public List<ContainerTab> tabs;

        @Override // com.squareup.wire.Message.Builder
        public ContainerTabs build() {
            return new ContainerTabs(this.tabs, this.default_tab_guid, super.buildUnknownFields());
        }

        public Builder() {
            this.tabs = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder default_tab_guid(String r100) {
            this.default_tab_guid = r100;
            return this;
        }

        public Builder tabs(List<ContainerTab> r100) {
            Internal.checkElementsNotNull(r100);
            this.tabs = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ContainerTabs extends ProtoAdapter<ContainerTabs> {
        public ProtoAdapter_ContainerTabs() {
            super(FieldEncoding.LENGTH_DELIMITED, ContainerTabs.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ContainerTabs decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.default_tab_guid = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.tabs.add(ContainerTab.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.default_tab_guid = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(ContainerTabs r100) {
            int r101 = ContainerTab.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.tabs);
            String r102 = r100.default_tab_guid;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ContainerTabs decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ContainerTabs r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ContainerTabs r101) throws IOException {
            ContainerTab.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.tabs);
            String r102 = r101.default_tab_guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ContainerTabs r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ContainerTabs();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.tabs = Internal.copyOf("tabs", this.tabs);
        r100.default_tab_guid = this.default_tab_guid;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ContainerTabs.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ContainerTabs(List<ContainerTab> r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ContainerTabs(List<ContainerTab> r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.tabs = Internal.immutableCopyOf("tabs", r100);
        this.default_tab_guid = r101;
    }
}
