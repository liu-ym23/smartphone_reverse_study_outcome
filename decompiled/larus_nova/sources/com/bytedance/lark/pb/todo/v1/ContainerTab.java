package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class ContainerTab extends Message<ContainerTab, Builder> {
    public static final ProtoAdapter<ContainerTab> ADAPTER = null;
    public static final String DEFAULT_GUID = "";
    public static final String DEFAULT_NAME = "";
    public static final Type DEFAULT_TYPE = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final DashboardTabMeta dashboard_tab_meta;
    public final String guid;
    public final String name;
    public final Type type;
    public final Long version;
    public final ViewTabMeta view_tab_meta;

    public static final class Builder extends Message.Builder<ContainerTab, Builder> {
        public DashboardTabMeta dashboard_tab_meta;
        public String guid;
        public String name;
        public Type type;
        public Long version;
        public ViewTabMeta view_tab_meta;

        @Override // com.squareup.wire.Message.Builder
        public ContainerTab build() {
            return new ContainerTab(this.guid, this.type, this.name, this.version, this.view_tab_meta, this.dashboard_tab_meta, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder dashboard_tab_meta(DashboardTabMeta r100) {
            this.dashboard_tab_meta = r100;
            this.view_tab_meta = null;
            return this;
        }

        public Builder guid(String r100) {
            this.guid = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }

        public Builder view_tab_meta(ViewTabMeta r100) {
            this.view_tab_meta = r100;
            this.dashboard_tab_meta = null;
            return this;
        }
    }

    public static final class DashboardTabMeta extends Message<DashboardTabMeta, Builder> {
        public static final ProtoAdapter<DashboardTabMeta> ADAPTER = null;
        public static final Long DEFAULT_CREATOR_ID = null;
        public static final DashboardStatus DEFAULT_STATUS = null;
        public static final String DEFAULT_URL = "";
        private static final long serialVersionUID = 0;
        public final Long creator_id;
        public final DashboardStatus status;
        public final String url;

        public static final class Builder extends Message.Builder<DashboardTabMeta, Builder> {
            public Long creator_id;
            public DashboardStatus status;
            public String url;

            @Override // com.squareup.wire.Message.Builder
            public DashboardTabMeta build() {
                return new DashboardTabMeta(this.status, this.url, this.creator_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder creator_id(Long r100) {
                this.creator_id = r100;
                return this;
            }

            public Builder status(DashboardStatus r100) {
                this.status = r100;
                return this;
            }

            public Builder url(String r100) {
                this.url = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DashboardTabMeta extends ProtoAdapter<DashboardTabMeta> {
            public ProtoAdapter_DashboardTabMeta() {
                super(FieldEncoding.LENGTH_DELIMITED, DashboardTabMeta.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DashboardTabMeta decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.status = DashboardStatus.NOT_CREATED;
                r101.url = "";
                r101.creator_id = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.status = DashboardStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.creator_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DashboardTabMeta r100) {
                DashboardStatus r101 = r100.status;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = DashboardStatus.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.url;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Long r107 = r100.creator_id;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DashboardTabMeta decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DashboardTabMeta r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DashboardTabMeta r101) throws IOException {
                DashboardStatus r102 = r101.status;
                if (r102 == null) goto L5;
                DashboardStatus.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.url;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Long r104 = r101.creator_id;
                if (r104 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DashboardTabMeta r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DashboardTabMeta();
            DEFAULT_STATUS = DashboardStatus.NOT_CREATED;
            DEFAULT_CREATOR_ID = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.status = this.status;
            r100.url = this.url;
            r100.creator_id = this.creator_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DashboardTabMeta.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DashboardTabMeta(DashboardStatus r100, String r101, Long r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public DashboardTabMeta(DashboardStatus r100, String r101, Long r102, ByteString r103) {
            super(ADAPTER, r103);
            this.status = r100;
            this.url = r101;
            this.creator_id = r102;
        }
    }

    public static final class ProtoAdapter_ContainerTab extends ProtoAdapter<ContainerTab> {
        public ProtoAdapter_ContainerTab() {
            super(FieldEncoding.LENGTH_DELIMITED, ContainerTab.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ContainerTab decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.guid = "";
            r101.type = Type.UNKNOWN;
            r101.name = "";
            r101.version = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L22;
            if (r103 != 1) goto L8;
            r101.guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            switch(r103) {
                case 100: goto L15;
                case 101: goto L14;
                case 102: goto L13;
                default: goto L12;
            };
        L13:
            r101.dashboard_tab_meta(DashboardTabMeta.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.view_tab_meta(ViewTabMeta.ADAPTER.decode(r100));
            goto L3
        L15:
            r101.version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L22:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ContainerTab r100) {
            String r101 = r100.guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Type r104 = r100.type;
            if (r104 == null) goto L9;
            int r105 = Type.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.name;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.version;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(100, r110);
        L18:
            int r112 = r109 + r111;
            ViewTabMeta r113 = r100.view_tab_meta;
            if (r113 == null) goto L21;
            int r114 = ViewTabMeta.ADAPTER.encodedSizeWithTag(101, r113);
        L22:
            int r115 = r112 + r114;
            DashboardTabMeta r116 = r100.dashboard_tab_meta;
            if (r116 == null) goto L26;
            r102 = DashboardTabMeta.ADAPTER.encodedSizeWithTag(102, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ ContainerTab decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ContainerTab r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ContainerTab r101) throws IOException {
            String r102 = r101.guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Type r103 = r101.type;
            if (r103 == null) goto L8;
            Type.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.name;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.version;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 100, r105);
        L14:
            ViewTabMeta r106 = r101.view_tab_meta;
            if (r106 == null) goto L17;
            ViewTabMeta.ADAPTER.encodeWithTag(r100, 101, r106);
        L17:
            DashboardTabMeta r107 = r101.dashboard_tab_meta;
            if (r107 == null) goto L20;
            DashboardTabMeta.ADAPTER.encodeWithTag(r100, 102, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ContainerTab r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type ACTIVITY_RECORD = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type DASHBOARD = null;
        public static final Type UNKNOWN = null;
        public static final Type VIEW = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("VIEW", 1, 1);
            VIEW = r101;
            Type r102 = new Type("ACTIVITY_RECORD", 2, 2);
            ACTIVITY_RECORD = r102;
            Type r103 = new Type("DASHBOARD", 3, 3);
            DASHBOARD = r103;
            $VALUES = new Type[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return DASHBOARD;
        L14:
            return ACTIVITY_RECORD;
        L16:
            return VIEW;
        L18:
            return UNKNOWN;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ViewTabMeta extends Message<ViewTabMeta, Builder> {
        public static final ProtoAdapter<ViewTabMeta> ADAPTER = null;
        public static final String DEFAULT_VIEW_GUID = "";
        private static final long serialVersionUID = 0;
        public final String view_guid;

        public static final class Builder extends Message.Builder<ViewTabMeta, Builder> {
            public String view_guid;

            @Override // com.squareup.wire.Message.Builder
            public ViewTabMeta build() {
                return new ViewTabMeta(this.view_guid, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder view_guid(String r100) {
                this.view_guid = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ViewTabMeta extends ProtoAdapter<ViewTabMeta> {
            public ProtoAdapter_ViewTabMeta() {
                super(FieldEncoding.LENGTH_DELIMITED, ViewTabMeta.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ViewTabMeta decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.view_guid = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.view_guid = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(ViewTabMeta r100) {
                String r101 = r100.view_guid;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ViewTabMeta decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ViewTabMeta r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ViewTabMeta r101) throws IOException {
                String r102 = r101.view_guid;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ViewTabMeta r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ViewTabMeta();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.view_guid = this.view_guid;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ViewTabMeta.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ViewTabMeta(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public ViewTabMeta(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.view_guid = r100;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ContainerTab();
        DEFAULT_TYPE = Type.UNKNOWN;
        DEFAULT_VERSION = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.guid = this.guid;
        r100.type = this.type;
        r100.name = this.name;
        r100.version = this.version;
        r100.view_tab_meta = this.view_tab_meta;
        r100.dashboard_tab_meta = this.dashboard_tab_meta;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ContainerTab.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ContainerTab(String r100, Type r110, String r111, Long r112, ViewTabMeta r113, DashboardTabMeta r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public ContainerTab(String r100, Type r101, String r102, Long r103, ViewTabMeta r104, DashboardTabMeta r105, ByteString r106) {
        super(ADAPTER, r106);
        if (Internal.countNonNull(r104, r105) > 1) goto L7;
        this.guid = r100;
        this.type = r101;
        this.name = r102;
        this.version = r103;
        this.view_tab_meta = r104;
        this.dashboard_tab_meta = r105;
        return;
    L7:
        throw new IllegalArgumentException("at most one of view_tab_meta, dashboard_tab_meta may be non-null");
    }
}
