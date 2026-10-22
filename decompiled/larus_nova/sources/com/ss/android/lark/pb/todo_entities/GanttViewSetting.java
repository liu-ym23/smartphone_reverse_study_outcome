package com.ss.android.lark.pb.todo_entities;

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

/* JADX INFO: loaded from: classes37.dex */
public final class GanttViewSetting extends Message<GanttViewSetting, Builder> {
    public static final ProtoAdapter<GanttViewSetting> ADAPTER = null;
    public static final Boolean DEFAULT_IS_HIDDEN_WEEKEND = null;
    public static final Boolean DEFAULT_IS_HIGHLIGHT_OVERDUE_TASK = null;
    public static final Boolean DEFAULT_IS_SHOW_CRITICAL_PATH = null;
    public static final Boolean DEFAULT_IS_TIMELINE_MODE = null;
    private static final long serialVersionUID = 0;
    public final ColorSetting mcolor_setting;
    public final Boolean mis_hidden_weekend;
    public final Boolean mis_highlight_overdue_task;
    public final Boolean mis_show_critical_path;
    public final Boolean mis_timeline_mode;
    public final MoveType mmove_type;
    public final ZoomLevel mzoom_level;

    public static final class Builder extends Message.Builder<GanttViewSetting, Builder> {
        public ColorSetting mcolor_setting;
        public Boolean mis_hidden_weekend;
        public Boolean mis_highlight_overdue_task;
        public Boolean mis_show_critical_path;
        public Boolean mis_timeline_mode;
        public MoveType mmove_type;
        public ZoomLevel mzoom_level;

        @Override // com.squareup.wire.Message.Builder
        public GanttViewSetting build() {
            return new GanttViewSetting(this.mis_hidden_weekend, this.mis_show_critical_path, this.mis_highlight_overdue_task, this.mcolor_setting, this.mmove_type, this.mzoom_level, this.mis_timeline_mode, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder color_setting(ColorSetting r100) {
            this.mcolor_setting = r100;
            return this;
        }

        public Builder is_hidden_weekend(Boolean r100) {
            this.mis_hidden_weekend = r100;
            return this;
        }

        public Builder is_highlight_overdue_task(Boolean r100) {
            this.mis_highlight_overdue_task = r100;
            return this;
        }

        public Builder is_show_critical_path(Boolean r100) {
            this.mis_show_critical_path = r100;
            return this;
        }

        public Builder is_timeline_mode(Boolean r100) {
            this.mis_timeline_mode = r100;
            return this;
        }

        public Builder move_type(MoveType r100) {
            this.mmove_type = r100;
            return this;
        }

        public Builder zoom_level(ZoomLevel r100) {
            this.mzoom_level = r100;
            return this;
        }
    }

    public static final class ColorSetting extends Message<ColorSetting, Builder> {
        public static final ProtoAdapter<ColorSetting> ADAPTER = null;
        public static final Integer DEFAULT_CUSTOM_COLOR_INDEX = null;
        public static final String DEFAULT_FOLLOW_COLOR_OF_FIELD_KEY = "";
        private static final long serialVersionUID = 0;
        public final Integer mcustom_color_index;
        public final String mfollow_color_of_field_key;
        public final Type mtype;

        public static final class Builder extends Message.Builder<ColorSetting, Builder> {
            public Integer mcustom_color_index;
            public String mfollow_color_of_field_key;
            public Type mtype;

            @Override // com.squareup.wire.Message.Builder
            public ColorSetting build() {
                return new ColorSetting(this.mtype, this.mcustom_color_index, this.mfollow_color_of_field_key, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder custom_color_index(Integer r100) {
                this.mcustom_color_index = r100;
                this.mfollow_color_of_field_key = null;
                return this;
            }

            public Builder follow_color_of_field_key(String r100) {
                this.mfollow_color_of_field_key = r100;
                this.mcustom_color_index = null;
                return this;
            }

            public Builder type(Type r100) {
                this.mtype = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ColorSetting extends ProtoAdapter<ColorSetting> {
            public ProtoAdapter_ColorSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, ColorSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ColorSetting decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.custom_color_index(0);
                r101.follow_color_of_field_key("");
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.mtype = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 101) goto L10;
                r101.custom_color_index(ProtoAdapter.INT32.decode(r100));
                goto L3
            L10:
                if (r103 != 102) goto L11;
                r101.follow_color_of_field_key(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(ColorSetting r100) {
                Type r101 = r100.mtype;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.mcustom_color_index;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT32.encodedSizeWithTag(101, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.mfollow_color_of_field_key;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(102, r107);
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
            public /* bridge */ /* synthetic */ ColorSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ColorSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ColorSetting r101) throws IOException {
                Type r102 = r101.mtype;
                if (r102 == null) goto L5;
                Type.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.mcustom_color_index;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 101, r103);
            L8:
                String r104 = r101.mfollow_color_of_field_key;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 102, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ColorSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type CUSTOM = null;
            public static final Type FOLLOW_FIELD = null;
            public static final Type UNKNOWN = null;
            private final int value;

            static {
                Type r100 = new Type("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Type r101 = new Type("CUSTOM", 1, 1);
                CUSTOM = r101;
                Type r102 = new Type("FOLLOW_FIELD", 2, 2);
                FOLLOW_FIELD = r102;
                $VALUES = new Type[]{r100, r101, r102};
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
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return FOLLOW_FIELD;
            L12:
                return CUSTOM;
            L14:
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

        static {
            ADAPTER = new ProtoAdapter_ColorSetting();
            DEFAULT_CUSTOM_COLOR_INDEX = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mtype = this.mtype;
            r100.mcustom_color_index = this.mcustom_color_index;
            r100.mfollow_color_of_field_key = this.mfollow_color_of_field_key;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ColorSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ColorSetting(Type r100, Integer r101, String r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public ColorSetting(Type r100, Integer r101, String r102, ByteString r103) {
            super(ADAPTER, r103);
            if (Internal.countNonNull(r101, r102) > 1) goto L7;
            this.mtype = r100;
            this.mcustom_color_index = r101;
            this.mfollow_color_of_field_key = r102;
            return;
        L7:
            throw new IllegalArgumentException("at most one of mcustom_color_index, mfollow_color_of_field_key may be non-null");
        }
    }

    public static final class ProtoAdapter_GanttViewSetting extends ProtoAdapter<GanttViewSetting> {
        public ProtoAdapter_GanttViewSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, GanttViewSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GanttViewSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.mis_hidden_weekend = r102;
            r101.mis_show_critical_path = r102;
            r101.mis_highlight_overdue_task = r102;
            r101.mis_timeline_mode = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L20;
            switch(r104) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L22;
                case 6: goto L24;
                case 7: goto L7;
                default: goto L6;
            };
        L22:
            r101.mmove_type = MoveType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L24:
            r101.mzoom_level = ZoomLevel.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mis_timeline_mode = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L16:
            r101.mcolor_setting = ColorSetting.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.mis_highlight_overdue_task = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            r101.mis_show_critical_path = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L19:
            r101.mis_hidden_weekend = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L20:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GanttViewSetting r100) {
            Boolean r101 = r100.mis_hidden_weekend;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.mis_show_critical_path;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.mis_highlight_overdue_task;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ColorSetting r110 = r100.mcolor_setting;
            if (r110 == null) goto L17;
            int r111 = ColorSetting.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            MoveType r113 = r100.mmove_type;
            if (r113 == null) goto L21;
            int r114 = MoveType.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            ZoomLevel r116 = r100.mzoom_level;
            if (r116 == null) goto L25;
            int r117 = ZoomLevel.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Boolean r119 = r100.mis_timeline_mode;
            if (r119 == null) goto L30;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
        L30:
            return (r118 + r102) + r100.unknownFields().size();
        L25:
            r117 = 0;
            goto L26
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
        public /* bridge */ /* synthetic */ GanttViewSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GanttViewSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GanttViewSetting r101) throws IOException {
            Boolean r102 = r101.mis_hidden_weekend;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.mis_show_critical_path;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.mis_highlight_overdue_task;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            ColorSetting r105 = r101.mcolor_setting;
            if (r105 == null) goto L14;
            ColorSetting.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            MoveType r106 = r101.mmove_type;
            if (r106 == null) goto L17;
            MoveType.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            ZoomLevel r107 = r101.mzoom_level;
            if (r107 == null) goto L20;
            ZoomLevel.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            Boolean r108 = r101.mis_timeline_mode;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GanttViewSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum ZoomLevel extends Enum<ZoomLevel> implements WireEnum {
        private static final /* synthetic */ ZoomLevel[] $VALUES = null;
        public static final ProtoAdapter<ZoomLevel> ADAPTER = null;
        public static final ZoomLevel MONTH = null;
        public static final ZoomLevel UNKNOWN = null;
        public static final ZoomLevel WEEK = null;
        public static final ZoomLevel YEAR = null;
        private final int value;

        static {
            ZoomLevel r100 = new ZoomLevel("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ZoomLevel r101 = new ZoomLevel("WEEK", 1, 1);
            WEEK = r101;
            ZoomLevel r102 = new ZoomLevel("MONTH", 2, 2);
            MONTH = r102;
            ZoomLevel r103 = new ZoomLevel("YEAR", 3, 3);
            YEAR = r103;
            $VALUES = new ZoomLevel[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(ZoomLevel.class);
        }

        public static ZoomLevel[] values() {
            return (ZoomLevel[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ZoomLevel fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return YEAR;
        L14:
            return MONTH;
        L16:
            return WEEK;
        L18:
            return UNKNOWN;
        }

        public static ZoomLevel valueOf(String r100) {
            return (ZoomLevel) a.a(ZoomLevel.class, r100);
        }

        private ZoomLevel(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GanttViewSetting();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_HIDDEN_WEEKEND = r100;
        DEFAULT_IS_SHOW_CRITICAL_PATH = r100;
        DEFAULT_IS_HIGHLIGHT_OVERDUE_TASK = r100;
        DEFAULT_IS_TIMELINE_MODE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mis_hidden_weekend = this.mis_hidden_weekend;
        r100.mis_show_critical_path = this.mis_show_critical_path;
        r100.mis_highlight_overdue_task = this.mis_highlight_overdue_task;
        r100.mcolor_setting = this.mcolor_setting;
        r100.mmove_type = this.mmove_type;
        r100.mzoom_level = this.mzoom_level;
        r100.mis_timeline_mode = this.mis_timeline_mode;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GanttViewSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GanttViewSetting(Boolean r110, Boolean r111, Boolean r112, ColorSetting r113, MoveType r114, ZoomLevel r115, Boolean r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public GanttViewSetting(Boolean r100, Boolean r101, Boolean r102, ColorSetting r103, MoveType r104, ZoomLevel r105, Boolean r106, ByteString r107) {
        super(ADAPTER, r107);
        this.mis_hidden_weekend = r100;
        this.mis_show_critical_path = r101;
        this.mis_highlight_overdue_task = r102;
        this.mcolor_setting = r103;
        this.mmove_type = r104;
        this.mzoom_level = r105;
        this.mis_timeline_mode = r106;
    }
}
