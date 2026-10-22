package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class UpdateSISettingResponse extends Message<UpdateSISettingResponse, Builder> {
    public static final ProtoAdapter<UpdateSISettingResponse> ADAPTER = null;
    public static final String DEFAULT_CHANNEL = "";
    public static final String DEFAULT_HIGHLIGHT_SUBTITLE_LANG = "";
    private static final long serialVersionUID = 0;
    public final String mchannel;
    public final SILanguage mhighlight_lang;
    public final SILanguage mhighlight_spoken_lang;
    public final String mhighlight_subtitle_lang;
    public final Status mstatus;
    public final List<SILanguage> msupport_lans;
    public final List<SILanguage> msupport_spoken_lans;
    public final Map<String, StringList> msupport_spoken_translate_map_lans;
    public final Map<String, StringList> msupport_translate_spoken_map_lans;

    public static final class Builder extends Message.Builder<UpdateSISettingResponse, Builder> {
        public String mchannel;
        public SILanguage mhighlight_lang;
        public SILanguage mhighlight_spoken_lang;
        public String mhighlight_subtitle_lang;
        public Status mstatus;
        public List<SILanguage> msupport_lans;
        public List<SILanguage> msupport_spoken_lans;
        public Map<String, StringList> msupport_spoken_translate_map_lans;
        public Map<String, StringList> msupport_translate_spoken_map_lans;

        @Override // com.squareup.wire.Message.Builder
        public UpdateSISettingResponse build() {
            return new UpdateSISettingResponse(this.mstatus, this.mchannel, this.mhighlight_subtitle_lang, this.mhighlight_lang, this.msupport_lans, this.msupport_spoken_lans, this.msupport_spoken_translate_map_lans, this.msupport_translate_spoken_map_lans, this.mhighlight_spoken_lang, super.buildUnknownFields());
        }

        public Builder() {
            this.msupport_lans = Internal.newMutableList();
            this.msupport_spoken_lans = Internal.newMutableList();
            this.msupport_spoken_translate_map_lans = Internal.newMutableMap();
            this.msupport_translate_spoken_map_lans = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder channel(String r100) {
            this.mchannel = r100;
            return this;
        }

        public Builder highlight_lang(SILanguage r100) {
            this.mhighlight_lang = r100;
            return this;
        }

        public Builder highlight_spoken_lang(SILanguage r100) {
            this.mhighlight_spoken_lang = r100;
            return this;
        }

        public Builder highlight_subtitle_lang(String r100) {
            this.mhighlight_subtitle_lang = r100;
            return this;
        }

        public Builder status(Status r100) {
            this.mstatus = r100;
            return this;
        }

        public Builder support_lans(List<SILanguage> r100) {
            Internal.checkElementsNotNull(r100);
            this.msupport_lans = r100;
            return this;
        }

        public Builder support_spoken_lans(List<SILanguage> r100) {
            Internal.checkElementsNotNull(r100);
            this.msupport_spoken_lans = r100;
            return this;
        }

        public Builder support_spoken_translate_map_lans(Map<String, StringList> r100) {
            Internal.checkElementsNotNull(r100);
            this.msupport_spoken_translate_map_lans = r100;
            return this;
        }

        public Builder support_translate_spoken_map_lans(Map<String, StringList> r100) {
            Internal.checkElementsNotNull(r100);
            this.msupport_translate_spoken_map_lans = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateSISettingResponse extends ProtoAdapter<UpdateSISettingResponse> {
        private final ProtoAdapter<Map<String, StringList>> msupport_spoken_translate_map_lans;
        private final ProtoAdapter<Map<String, StringList>> msupport_translate_spoken_map_lans;

        public ProtoAdapter_UpdateSISettingResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateSISettingResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            ProtoAdapter<StringList> r101 = StringList.ADAPTER;
            this.msupport_spoken_translate_map_lans = ProtoAdapter.newMapAdapter(r100, r101);
            this.msupport_translate_spoken_map_lans = ProtoAdapter.newMapAdapter(r100, r101);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateSISettingResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mchannel = "";
            r101.mhighlight_subtitle_lang = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L21;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L21:
            r101.mstatus = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mhighlight_spoken_lang = SILanguage.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.msupport_translate_spoken_map_lans.putAll(this.msupport_translate_spoken_map_lans.decode(r100));
            goto L3
        L9:
            r101.msupport_spoken_translate_map_lans.putAll(this.msupport_spoken_translate_map_lans.decode(r100));
            goto L3
        L10:
            r101.msupport_spoken_lans.add(SILanguage.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.msupport_lans.add(SILanguage.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.mhighlight_lang = SILanguage.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.mhighlight_subtitle_lang = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.mchannel = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UpdateSISettingResponse r100) {
            Status r101 = r100.mstatus;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Status.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mchannel;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mhighlight_subtitle_lang;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            SILanguage r110 = r100.mhighlight_lang;
            if (r110 == null) goto L17;
            int r111 = SILanguage.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            ProtoAdapter<SILanguage> r113 = SILanguage.ADAPTER;
            int r114 = (((r112 + r113.asRepeated().encodedSizeWithTag(5, r100.msupport_lans)) + r113.asRepeated().encodedSizeWithTag(6, r100.msupport_spoken_lans)) + this.msupport_spoken_translate_map_lans.encodedSizeWithTag(7, r100.msupport_spoken_translate_map_lans)) + this.msupport_translate_spoken_map_lans.encodedSizeWithTag(8, r100.msupport_translate_spoken_map_lans);
            SILanguage r115 = r100.mhighlight_spoken_lang;
            if (r115 == null) goto L22;
            r102 = r113.encodedSizeWithTag(9, r115);
        L22:
            return (r114 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ UpdateSISettingResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateSISettingResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateSISettingResponse r101) throws IOException {
            Status r102 = r101.mstatus;
            if (r102 == null) goto L5;
            Status.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mchannel;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mhighlight_subtitle_lang;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            SILanguage r105 = r101.mhighlight_lang;
            if (r105 == null) goto L14;
            SILanguage.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            ProtoAdapter<SILanguage> r106 = SILanguage.ADAPTER;
            r106.asRepeated().encodeWithTag(r100, 5, r101.msupport_lans);
            r106.asRepeated().encodeWithTag(r100, 6, r101.msupport_spoken_lans);
            this.msupport_spoken_translate_map_lans.encodeWithTag(r100, 7, r101.msupport_spoken_translate_map_lans);
            this.msupport_translate_spoken_map_lans.encodeWithTag(r100, 8, r101.msupport_translate_spoken_map_lans);
            SILanguage r107 = r101.mhighlight_spoken_lang;
            if (r107 == null) goto L17;
            r106.encodeWithTag(r100, 9, r107);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateSISettingResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class SILanguage extends Message<SILanguage, Builder> {
        public static final ProtoAdapter<SILanguage> ADAPTER = null;
        public static final String DEFAULT_DESCRIPTION_I18N = "";
        public static final String DEFAULT_LANGUAGE = "";
        private static final long serialVersionUID = 0;
        public final String mdescription_i18n;
        public final String mlanguage;

        public static final class Builder extends Message.Builder<SILanguage, Builder> {
            public String mdescription_i18n;
            public String mlanguage;

            @Override // com.squareup.wire.Message.Builder
            public SILanguage build() {
                return new SILanguage(this.mlanguage, this.mdescription_i18n, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder description_i18n(String r100) {
                this.mdescription_i18n = r100;
                return this;
            }

            public Builder language(String r100) {
                this.mlanguage = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SILanguage extends ProtoAdapter<SILanguage> {
            public ProtoAdapter_SILanguage() {
                super(FieldEncoding.LENGTH_DELIMITED, SILanguage.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SILanguage decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mlanguage = "";
                r101.mdescription_i18n = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mlanguage = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mdescription_i18n = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(SILanguage r100) {
                String r101 = r100.mlanguage;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mdescription_i18n;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SILanguage decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SILanguage r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SILanguage r101) throws IOException {
                String r102 = r101.mlanguage;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mdescription_i18n;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SILanguage r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SILanguage();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mlanguage = this.mlanguage;
            r100.mdescription_i18n = this.mdescription_i18n;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SILanguage.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SILanguage(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public SILanguage(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mlanguage = r100;
            this.mdescription_i18n = r101;
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status FAIL = null;
        public static final Status SUCCESS = null;
        public static final Status UNKNOWN = null;
        public static final Status WAITING = null;
        private final int value;

        static {
            Status r100 = new Status("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Status r101 = new Status("SUCCESS", 1, 1);
            SUCCESS = r101;
            Status r102 = new Status("WAITING", 2, 2);
            WAITING = r102;
            Status r103 = new Status("FAIL", 3, 3);
            FAIL = r103;
            $VALUES = new Status[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Status fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return FAIL;
        L14:
            return WAITING;
        L16:
            return SUCCESS;
        L18:
            return UNKNOWN;
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        private Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class StringList extends Message<StringList, Builder> {
        public static final ProtoAdapter<StringList> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> mvalues;

        public static final class Builder extends Message.Builder<StringList, Builder> {
            public List<String> mvalues;

            @Override // com.squareup.wire.Message.Builder
            public StringList build() {
                return new StringList(this.mvalues, super.buildUnknownFields());
            }

            public Builder() {
                this.mvalues = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder values(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.mvalues = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_StringList extends ProtoAdapter<StringList> {
            public ProtoAdapter_StringList() {
                super(FieldEncoding.LENGTH_DELIMITED, StringList.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public StringList decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mvalues.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(StringList r100) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.mvalues) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ StringList decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(StringList r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, StringList r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.mvalues);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, StringList r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_StringList();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mvalues = Internal.copyOf("mvalues", this.mvalues);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return StringList.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public StringList(List<String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public StringList(List<String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mvalues = Internal.immutableCopyOf("mvalues", r100);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UpdateSISettingResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mstatus = this.mstatus;
        r100.mchannel = this.mchannel;
        r100.mhighlight_subtitle_lang = this.mhighlight_subtitle_lang;
        r100.mhighlight_lang = this.mhighlight_lang;
        r100.msupport_lans = Internal.copyOf("msupport_lans", this.msupport_lans);
        r100.msupport_spoken_lans = Internal.copyOf("msupport_spoken_lans", this.msupport_spoken_lans);
        r100.msupport_spoken_translate_map_lans = Internal.copyOf("msupport_spoken_translate_map_lans", this.msupport_spoken_translate_map_lans);
        r100.msupport_translate_spoken_map_lans = Internal.copyOf("msupport_translate_spoken_map_lans", this.msupport_translate_spoken_map_lans);
        r100.mhighlight_spoken_lang = this.mhighlight_spoken_lang;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateSISettingResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateSISettingResponse(Status r110, String r111, String r112, SILanguage r113, List<SILanguage> r114, List<SILanguage> r115, Map<String, StringList> r116, Map<String, StringList> r117, SILanguage r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public UpdateSISettingResponse(Status r100, String r101, String r102, SILanguage r103, List<SILanguage> r104, List<SILanguage> r105, Map<String, StringList> r106, Map<String, StringList> r107, SILanguage r110, ByteString r111) {
        super(ADAPTER, r111);
        this.mstatus = r100;
        this.mchannel = r101;
        this.mhighlight_subtitle_lang = r102;
        this.mhighlight_lang = r103;
        this.msupport_lans = Internal.immutableCopyOf("msupport_lans", r104);
        this.msupport_spoken_lans = Internal.immutableCopyOf("msupport_spoken_lans", r105);
        this.msupport_spoken_translate_map_lans = Internal.immutableCopyOf("msupport_spoken_translate_map_lans", r106);
        this.msupport_translate_spoken_map_lans = Internal.immutableCopyOf("msupport_translate_spoken_map_lans", r107);
        this.mhighlight_spoken_lang = r110;
    }
}
