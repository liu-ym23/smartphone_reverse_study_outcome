package com.bytedance.lark.pb.search.common;

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
public final class JumpTabInfo extends Message<JumpTabInfo, Builder> {
    public static final ProtoAdapter<JumpTabInfo> ADAPTER = null;
    public static final String DEFAULT_TITLE_HIGHLIGHTED = "";
    private static final long serialVersionUID = 0;
    public final List<JumpTab> jump_tabs;
    public final String title_highlighted;

    public static final class Builder extends Message.Builder<JumpTabInfo, Builder> {
        public List<JumpTab> jump_tabs;
        public String title_highlighted;

        @Override // com.squareup.wire.Message.Builder
        public JumpTabInfo build() {
            return new JumpTabInfo(this.title_highlighted, this.jump_tabs, super.buildUnknownFields());
        }

        public Builder() {
            this.jump_tabs = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder jump_tabs(List<JumpTab> r100) {
            Internal.checkElementsNotNull(r100);
            this.jump_tabs = r100;
            return this;
        }

        public Builder title_highlighted(String r100) {
            this.title_highlighted = r100;
            return this;
        }
    }

    public static final class JumpTab extends Message<JumpTab, Builder> {
        public static final ProtoAdapter<JumpTab> ADAPTER = null;
        public static final String DEFAULT_APP_LINK = "";
        public static final String DEFAULT_FORMATTED_TEXT = "";
        public static final String DEFAULT_ICON_URL = "";
        public static final SearchTabName DEFAULT_SEARCH_TAB = null;
        private static final long serialVersionUID = 0;
        public final String app_link;
        public final String formatted_text;
        public final String icon_url;
        public final SearchTabName search_tab;

        public static final class Builder extends Message.Builder<JumpTab, Builder> {
            public String app_link;
            public String formatted_text;
            public String icon_url;
            public SearchTabName search_tab;

            @Override // com.squareup.wire.Message.Builder
            public JumpTab build() {
                return new JumpTab(this.formatted_text, this.search_tab, this.app_link, this.icon_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder app_link(String r100) {
                this.app_link = r100;
                return this;
            }

            public Builder formatted_text(String r100) {
                this.formatted_text = r100;
                return this;
            }

            public Builder icon_url(String r100) {
                this.icon_url = r100;
                return this;
            }

            public Builder search_tab(SearchTabName r100) {
                this.search_tab = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_JumpTab extends ProtoAdapter<JumpTab> {
            public ProtoAdapter_JumpTab() {
                super(FieldEncoding.LENGTH_DELIMITED, JumpTab.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public JumpTab decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.formatted_text = "";
                r101.search_tab = SearchTabName.UNKNOWN_TAB;
                r101.app_link = "";
                r101.icon_url = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.formatted_text = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.search_tab = SearchTabName.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.app_link = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.icon_url = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(JumpTab r100) {
                String r101 = r100.formatted_text;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                SearchTabName r104 = r100.search_tab;
                if (r104 == null) goto L9;
                int r105 = SearchTabName.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.app_link;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.icon_url;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
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
            public /* bridge */ /* synthetic */ JumpTab decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(JumpTab r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, JumpTab r101) throws IOException {
                String r102 = r101.formatted_text;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                SearchTabName r103 = r101.search_tab;
                if (r103 == null) goto L8;
                SearchTabName.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.app_link;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.icon_url;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, JumpTab r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_JumpTab();
            DEFAULT_SEARCH_TAB = SearchTabName.UNKNOWN_TAB;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.formatted_text = this.formatted_text;
            r100.search_tab = this.search_tab;
            r100.app_link = this.app_link;
            r100.icon_url = this.icon_url;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return JumpTab.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public JumpTab(String r100, SearchTabName r101, String r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public JumpTab(String r100, SearchTabName r101, String r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.formatted_text = r100;
            this.search_tab = r101;
            this.app_link = r102;
            this.icon_url = r103;
        }
    }

    public static final class ProtoAdapter_JumpTabInfo extends ProtoAdapter<JumpTabInfo> {
        public ProtoAdapter_JumpTabInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, JumpTabInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public JumpTabInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.title_highlighted = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.title_highlighted = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.jump_tabs.add(JumpTab.ADAPTER.decode(r100));
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
        public int encodedSize2(JumpTabInfo r100) {
            String r101 = r100.title_highlighted;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + JumpTab.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.jump_tabs)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ JumpTabInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(JumpTabInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, JumpTabInfo r101) throws IOException {
            String r102 = r101.title_highlighted;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            JumpTab.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.jump_tabs);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, JumpTabInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_JumpTabInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.title_highlighted = this.title_highlighted;
        r100.jump_tabs = Internal.copyOf("jump_tabs", this.jump_tabs);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return JumpTabInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public JumpTabInfo(String r100, List<JumpTab> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public JumpTabInfo(String r100, List<JumpTab> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.title_highlighted = r100;
        this.jump_tabs = Internal.immutableCopyOf("jump_tabs", r101);
    }
}
