package com.bytedance.lark.pb.todo.v1;

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

/* JADX INFO: loaded from: classes20.dex */
public final class TodoSetting extends Message<TodoSetting, Builder> {
    public static final ProtoAdapter<TodoSetting> ADAPTER = null;
    public static final Integer DEFAULT_DUE_REMINDER_OFFSET = null;
    public static final Boolean DEFAULT_ENABLE_DAILY_FOLLOW = null;
    public static final Boolean DEFAULT_ENABLE_DAILY_REMIND = null;
    public static final Boolean DEFAULT_SHOW_ENABLE_DAILY_FOLLOW = null;
    public static final Boolean DEFAULT_SHOW_OPEN_MEEGO_TIP = null;
    public static final Boolean DEFAULT_SHOW_SYNC_FROM_MEEGO = null;
    public static final Boolean DEFAULT_SYNC_FROM_MEEGO = null;
    private static final long serialVersionUID = 0;
    public final TodoBadgeConfig badge_config;
    public final Integer due_reminder_offset;
    public final Boolean enable_daily_follow;
    public final Boolean enable_daily_remind;
    public final List<TodoLaunchScreen> launch_screen;
    public final Map<String, TenantBrandTextField> meego_brand;
    public final Boolean show_enable_daily_follow;
    public final Boolean show_open_meego_tip;
    public final Boolean show_sync_from_meego;
    public final Boolean sync_from_meego;
    public final List<TodoListViewSetting> tab_view_settings;

    public static final class Builder extends Message.Builder<TodoSetting, Builder> {
        public TodoBadgeConfig badge_config;
        public Integer due_reminder_offset;
        public Boolean enable_daily_follow;
        public Boolean enable_daily_remind;
        public List<TodoLaunchScreen> launch_screen;
        public Map<String, TenantBrandTextField> meego_brand;
        public Boolean show_enable_daily_follow;
        public Boolean show_open_meego_tip;
        public Boolean show_sync_from_meego;
        public Boolean sync_from_meego;
        public List<TodoListViewSetting> tab_view_settings;

        @Override // com.squareup.wire.Message.Builder
        public TodoSetting build() {
            return new TodoSetting(this.enable_daily_remind, this.tab_view_settings, this.badge_config, this.due_reminder_offset, this.launch_screen, this.sync_from_meego, this.show_open_meego_tip, this.show_sync_from_meego, this.meego_brand, this.enable_daily_follow, this.show_enable_daily_follow, super.buildUnknownFields());
        }

        public Builder() {
            this.tab_view_settings = Internal.newMutableList();
            this.launch_screen = Internal.newMutableList();
            this.meego_brand = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder badge_config(TodoBadgeConfig r100) {
            this.badge_config = r100;
            return this;
        }

        public Builder due_reminder_offset(Integer r100) {
            this.due_reminder_offset = r100;
            return this;
        }

        public Builder enable_daily_follow(Boolean r100) {
            this.enable_daily_follow = r100;
            return this;
        }

        public Builder enable_daily_remind(Boolean r100) {
            this.enable_daily_remind = r100;
            return this;
        }

        public Builder launch_screen(List<TodoLaunchScreen> r100) {
            Internal.checkElementsNotNull(r100);
            this.launch_screen = r100;
            return this;
        }

        public Builder meego_brand(Map<String, TenantBrandTextField> r100) {
            Internal.checkElementsNotNull(r100);
            this.meego_brand = r100;
            return this;
        }

        public Builder show_enable_daily_follow(Boolean r100) {
            this.show_enable_daily_follow = r100;
            return this;
        }

        public Builder show_open_meego_tip(Boolean r100) {
            this.show_open_meego_tip = r100;
            return this;
        }

        public Builder show_sync_from_meego(Boolean r100) {
            this.show_sync_from_meego = r100;
            return this;
        }

        public Builder sync_from_meego(Boolean r100) {
            this.sync_from_meego = r100;
            return this;
        }

        public Builder tab_view_settings(List<TodoListViewSetting> r100) {
            Internal.checkElementsNotNull(r100);
            this.tab_view_settings = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TodoSetting extends ProtoAdapter<TodoSetting> {
        private final ProtoAdapter<Map<String, TenantBrandTextField>> meego_brand;

        public ProtoAdapter_TodoSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoSetting.class);
            this.meego_brand = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, TenantBrandTextField.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.enable_daily_remind = Boolean.TRUE;
            r101.due_reminder_offset = 30;
            Boolean r102 = Boolean.FALSE;
            r101.sync_from_meego = r102;
            r101.show_open_meego_tip = r102;
            r101.show_sync_from_meego = r102;
            r101.enable_daily_follow = r102;
            r101.show_enable_daily_follow = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            switch(r104) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            r101.show_enable_daily_follow = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.enable_daily_follow = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.meego_brand.putAll(this.meego_brand.decode(r100));
            goto L3
        L10:
            r101.show_sync_from_meego = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.show_open_meego_tip = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.sync_from_meego = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.launch_screen.add(TodoLaunchScreen.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.due_reminder_offset = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            r101.badge_config = TodoBadgeConfig.ADAPTER.decode(r100);
            goto L3
        L16:
            r101.tab_view_settings.add(TodoListViewSetting.ADAPTER.decode(r100));
            goto L3
        L17:
            r101.enable_daily_remind = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TodoSetting r100) {
            Boolean r101 = r100.enable_daily_remind;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + TodoListViewSetting.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.tab_view_settings);
            TodoBadgeConfig r105 = r100.badge_config;
            if (r105 == null) goto L9;
            int r106 = TodoBadgeConfig.ADAPTER.encodedSizeWithTag(3, r105);
        L10:
            int r107 = r104 + r106;
            Integer r108 = r100.due_reminder_offset;
            if (r108 == null) goto L13;
            int r109 = ProtoAdapter.INT32.encodedSizeWithTag(4, r108);
        L14:
            int r110 = (r107 + r109) + TodoLaunchScreen.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.launch_screen);
            Boolean r111 = r100.sync_from_meego;
            if (r111 == null) goto L17;
            int r112 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r111);
        L18:
            int r113 = r110 + r112;
            Boolean r114 = r100.show_open_meego_tip;
            if (r114 == null) goto L21;
            int r115 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r114);
        L22:
            int r116 = r113 + r115;
            Boolean r117 = r100.show_sync_from_meego;
            if (r117 == null) goto L25;
            int r118 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r117);
        L26:
            int r119 = (r116 + r118) + this.meego_brand.encodedSizeWithTag(9, r100.meego_brand);
            Boolean r120 = r100.enable_daily_follow;
            if (r120 == null) goto L29;
            int r121 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r120);
        L30:
            int r122 = r119 + r121;
            Boolean r123 = r100.show_enable_daily_follow;
            if (r123 == null) goto L34;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r123);
        L34:
            return (r122 + r102) + r100.unknownFields().size();
        L29:
            r121 = 0;
            goto L30
        L25:
            r118 = 0;
            goto L26
        L21:
            r115 = 0;
            goto L22
        L17:
            r112 = 0;
            goto L18
        L13:
            r109 = 0;
            goto L14
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TodoSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoSetting r101) throws IOException {
            Boolean r102 = r101.enable_daily_remind;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            TodoListViewSetting.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.tab_view_settings);
            TodoBadgeConfig r103 = r101.badge_config;
            if (r103 == null) goto L8;
            TodoBadgeConfig.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            Integer r104 = r101.due_reminder_offset;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r104);
        L11:
            TodoLaunchScreen.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.launch_screen);
            Boolean r105 = r101.sync_from_meego;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r105);
        L14:
            Boolean r106 = r101.show_open_meego_tip;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r106);
        L17:
            Boolean r107 = r101.show_sync_from_meego;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r107);
        L20:
            this.meego_brand.encodeWithTag(r100, 9, r101.meego_brand);
            Boolean r108 = r101.enable_daily_follow;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r108);
        L23:
            Boolean r109 = r101.show_enable_daily_follow;
            if (r109 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 11, r109);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TodoSetting();
        DEFAULT_ENABLE_DAILY_REMIND = Boolean.TRUE;
        DEFAULT_DUE_REMINDER_OFFSET = 30;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_SYNC_FROM_MEEGO = r100;
        DEFAULT_SHOW_OPEN_MEEGO_TIP = r100;
        DEFAULT_SHOW_SYNC_FROM_MEEGO = r100;
        DEFAULT_ENABLE_DAILY_FOLLOW = r100;
        DEFAULT_SHOW_ENABLE_DAILY_FOLLOW = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.enable_daily_remind = this.enable_daily_remind;
        r100.tab_view_settings = Internal.copyOf("tab_view_settings", this.tab_view_settings);
        r100.badge_config = this.badge_config;
        r100.due_reminder_offset = this.due_reminder_offset;
        r100.launch_screen = Internal.copyOf("launch_screen", this.launch_screen);
        r100.sync_from_meego = this.sync_from_meego;
        r100.show_open_meego_tip = this.show_open_meego_tip;
        r100.show_sync_from_meego = this.show_sync_from_meego;
        r100.meego_brand = Internal.copyOf("meego_brand", this.meego_brand);
        r100.enable_daily_follow = this.enable_daily_follow;
        r100.show_enable_daily_follow = this.show_enable_daily_follow;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoSetting(Boolean r110, List<TodoListViewSetting> r111, TodoBadgeConfig r112, Integer r113, List<TodoLaunchScreen> r114, Boolean r115, Boolean r210, Boolean r211, Map<String, TenantBrandTextField> r212, Boolean r213, Boolean r214) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, ByteString.EMPTY);
    }

    public TodoSetting(Boolean r100, List<TodoListViewSetting> r101, TodoBadgeConfig r102, Integer r103, List<TodoLaunchScreen> r104, Boolean r105, Boolean r106, Boolean r107, Map<String, TenantBrandTextField> r110, Boolean r111, Boolean r112, ByteString r113) {
        super(ADAPTER, r113);
        this.enable_daily_remind = r100;
        this.tab_view_settings = Internal.immutableCopyOf("tab_view_settings", r101);
        this.badge_config = r102;
        this.due_reminder_offset = r103;
        this.launch_screen = Internal.immutableCopyOf("launch_screen", r104);
        this.sync_from_meego = r105;
        this.show_open_meego_tip = r106;
        this.show_sync_from_meego = r107;
        this.meego_brand = Internal.immutableCopyOf("meego_brand", r110);
        this.enable_daily_follow = r111;
        this.show_enable_daily_follow = r112;
    }
}
