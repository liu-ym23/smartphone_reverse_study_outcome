package com.bytedance.lark.pb.im.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetChatThemeListResponse extends Message<GetChatThemeListResponse, Builder> {
    public static final ProtoAdapter<GetChatThemeListResponse> ADAPTER = null;
    public static final Long DEFAULT_GROUP_USED_THEME_ID = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final Long DEFAULT_NEXT_POS = null;
    public static final Long DEFAULT_USER_USED_THEME_ID = null;
    public static final ProtoAdapter_GetChatThemeListResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, ByteString> chat_themes;
    public final Long group_used_theme_id;
    public final Boolean has_more;
    public final Long next_pos;
    public final List<ThemeListItem> theme_items;
    public final Long user_used_theme_id;

    public static final class Builder extends Message.Builder<GetChatThemeListResponse, Builder> implements d<GetChatThemeListResponse> {
        public Map<Long, ByteString> chat_themes;
        public Long group_used_theme_id;
        public Boolean has_more;
        public Long next_pos;
        public List<ThemeListItem> theme_items;
        public Long user_used_theme_id;

        @Override // com.squareup.wire.Message.Builder
        public GetChatThemeListResponse build() {
            return new GetChatThemeListResponse(this.theme_items, this.chat_themes, this.next_pos, this.has_more, this.user_used_theme_id, this.group_used_theme_id, super.buildUnknownFields());
        }

        public Builder() {
            this.theme_items = Internal.newMutableList();
            this.chat_themes = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_themes(Map<Long, ByteString> r100) {
            Internal.checkElementsNotNull(r100);
            this.chat_themes = r100;
            return this;
        }

        public Builder group_used_theme_id(Long r100) {
            this.group_used_theme_id = r100;
            return this;
        }

        public Builder has_more(Boolean r100) {
            this.has_more = r100;
            return this;
        }

        public Builder next_pos(Long r100) {
            this.next_pos = r100;
            return this;
        }

        public Builder theme_items(List<ThemeListItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.theme_items = r100;
            return this;
        }

        public Builder user_used_theme_id(Long r100) {
            this.user_used_theme_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetChatThemeListResponse extends ProtoAdapter<GetChatThemeListResponse> implements c<GetChatThemeListResponse> {
        private final ProtoAdapter<Map<Long, ByteString>> chat_themes;

        public ProtoAdapter_GetChatThemeListResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatThemeListResponse.class);
            this.chat_themes = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, ProtoAdapter.BYTES);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatThemeListResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.next_pos = 0L;
            r101.has_more = Boolean.FALSE;
            r101.user_used_theme_id = 0L;
            r101.group_used_theme_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.group_used_theme_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.user_used_theme_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L9:
            r101.has_more = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.next_pos = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            r101.chat_themes.putAll(this.chat_themes.decode(r100));
            goto L3
        L12:
            r101.theme_items.add(ThemeListItem.ADAPTER.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetChatThemeListResponse r100) {
            int r101 = ThemeListItem.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.theme_items) + this.chat_themes.encodedSizeWithTag(2, r100.chat_themes);
            Long r102 = r100.next_pos;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.INT64.encodedSizeWithTag(3, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.has_more;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r106);
        L10:
            int r108 = r105 + r107;
            Long r109 = r100.user_used_theme_id;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.INT64.encodedSizeWithTag(5, r109);
        L14:
            int r111 = r108 + r110;
            Long r112 = r100.group_used_theme_id;
            if (r112 == null) goto L18;
            r103 = ProtoAdapter.INT64.encodedSizeWithTag(6, r112);
        L18:
            return (r111 + r103) + r100.unknownFields().size();
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetChatThemeListResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatThemeListResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatThemeListResponse r101) throws IOException {
            ThemeListItem.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.theme_items);
            this.chat_themes.encodeWithTag(r100, 2, r101.chat_themes);
            Long r102 = r101.next_pos;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r102);
        L5:
            Boolean r103 = r101.has_more;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r103);
        L8:
            Long r104 = r101.user_used_theme_id;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r104);
        L11:
            Long r105 = r101.group_used_theme_id;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatThemeListResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class ThemeListItem extends Message<ThemeListItem, Builder> {
        public static final ProtoAdapter<ThemeListItem> ADAPTER = null;
        public static final Long DEFAULT_POS = null;
        public static final Long DEFAULT_THEME_ID = null;
        private static final long serialVersionUID = 0;
        public final Long pos;
        public final Long theme_id;

        public static final class Builder extends Message.Builder<ThemeListItem, Builder> {
            public Long pos;
            public Long theme_id;

            @Override // com.squareup.wire.Message.Builder
            public ThemeListItem build() {
                return new ThemeListItem(this.pos, this.theme_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder pos(Long r100) {
                this.pos = r100;
                return this;
            }

            public Builder theme_id(Long r100) {
                this.theme_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ThemeListItem extends ProtoAdapter<ThemeListItem> {
            public ProtoAdapter_ThemeListItem() {
                super(FieldEncoding.LENGTH_DELIMITED, ThemeListItem.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ThemeListItem decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.pos = 0L;
                r101.theme_id = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.pos = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.theme_id = ProtoAdapter.INT64.decode(r100);
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
            public int encodedSize2(ThemeListItem r100) {
                Long r101 = r100.pos;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.theme_id;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ThemeListItem decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ThemeListItem r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ThemeListItem r101) throws IOException {
                Long r102 = r101.pos;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.theme_id;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ThemeListItem r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ThemeListItem();
            DEFAULT_POS = 0L;
            DEFAULT_THEME_ID = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.pos = this.pos;
            r100.theme_id = this.theme_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ThemeListItem.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ThemeListItem(Long r100, Long r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public ThemeListItem(Long r100, Long r101, ByteString r102) {
            super(ADAPTER, r102);
            this.pos = r100;
            this.theme_id = r101;
        }
    }

    static {
        ProtoAdapter_GetChatThemeListResponse r100 = new ProtoAdapter_GetChatThemeListResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_NEXT_POS = 0L;
        DEFAULT_HAS_MORE = Boolean.FALSE;
        DEFAULT_USER_USED_THEME_ID = 0L;
        DEFAULT_GROUP_USED_THEME_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.theme_items = Internal.copyOf("theme_items", this.theme_items);
        r100.chat_themes = Internal.copyOf("chat_themes", this.chat_themes);
        r100.next_pos = this.next_pos;
        r100.has_more = this.has_more;
        r100.user_used_theme_id = this.user_used_theme_id;
        r100.group_used_theme_id = this.group_used_theme_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatThemeListResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatThemeListResponse(List<ThemeListItem> r100, Map<Long, ByteString> r110, Long r111, Boolean r112, Long r113, Long r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public GetChatThemeListResponse(List<ThemeListItem> r100, Map<Long, ByteString> r101, Long r102, Boolean r103, Long r104, Long r105, ByteString r106) {
        super(ADAPTER, r106);
        this.theme_items = Internal.immutableCopyOf("theme_items", r100);
        this.chat_themes = Internal.immutableCopyOf("chat_themes", r101);
        this.next_pos = r102;
        this.has_more = r103;
        this.user_used_theme_id = r104;
        this.group_used_theme_id = r105;
    }
}
