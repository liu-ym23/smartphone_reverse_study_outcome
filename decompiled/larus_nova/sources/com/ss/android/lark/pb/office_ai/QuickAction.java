package com.ss.android.lark.pb.office_ai;

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

/* JADX INFO: loaded from: classes37.dex */
public final class QuickAction extends Message<QuickAction, Builder> {
    public static final ProtoAdapter<QuickAction> ADAPTER = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_DISPLAY_NAME = "";
    public static final String DEFAULT_ICON = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_QUERY_TEMPLATE = "";
    private static final long serialVersionUID = 0;
    public final FollowUpFrom mFollowUpFrom;
    public final QuickActionType maction_type;
    public final ContentAlign mcontent_align;
    public final String mdescription;
    public final DisplayConfig mdisplay_config;
    public final String mdisplay_name;
    public final Map<String, String> mextra_map;
    public final String micon;
    public final IconConfig micon_config;
    public final String mid;
    public final LinkConfig mlink_config;
    public final String mname;
    public final List<Param> mparam_details;
    public final String mquery_template;

    public static final class Builder extends Message.Builder<QuickAction, Builder> {
        public FollowUpFrom mFollowUpFrom;
        public QuickActionType maction_type;
        public ContentAlign mcontent_align;
        public String mdescription;
        public DisplayConfig mdisplay_config;
        public String mdisplay_name;
        public Map<String, String> mextra_map;
        public String micon;
        public IconConfig micon_config;
        public String mid;
        public LinkConfig mlink_config;
        public String mname;
        public List<Param> mparam_details;
        public String mquery_template;

        @Override // com.squareup.wire.Message.Builder
        public QuickAction build() {
            return new QuickAction(this.mid, this.mname, this.mdescription, this.mextra_map, this.mparam_details, this.mdisplay_name, this.maction_type, this.mFollowUpFrom, this.micon, this.mdisplay_config, this.mquery_template, this.micon_config, this.mlink_config, this.mcontent_align, super.buildUnknownFields());
        }

        public Builder() {
            this.mextra_map = Internal.newMutableMap();
            this.mparam_details = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder FollowUpFrom(FollowUpFrom r100) {
            this.mFollowUpFrom = r100;
            return this;
        }

        public Builder action_type(QuickActionType r100) {
            this.maction_type = r100;
            return this;
        }

        public Builder content_align(ContentAlign r100) {
            this.mcontent_align = r100;
            return this;
        }

        public Builder description(String r100) {
            this.mdescription = r100;
            return this;
        }

        public Builder display_config(DisplayConfig r100) {
            this.mdisplay_config = r100;
            return this;
        }

        public Builder display_name(String r100) {
            this.mdisplay_name = r100;
            return this;
        }

        public Builder extra_map(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mextra_map = r100;
            return this;
        }

        public Builder icon(String r100) {
            this.micon = r100;
            return this;
        }

        public Builder icon_config(IconConfig r100) {
            this.micon_config = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder link_config(LinkConfig r100) {
            this.mlink_config = r100;
            return this;
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }

        public Builder param_details(List<Param> r100) {
            Internal.checkElementsNotNull(r100);
            this.mparam_details = r100;
            return this;
        }

        public Builder query_template(String r100) {
            this.mquery_template = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_QuickAction extends ProtoAdapter<QuickAction> {
        private final ProtoAdapter<Map<String, String>> mextra_map;

        public ProtoAdapter_QuickAction() {
            super(FieldEncoding.LENGTH_DELIMITED, QuickAction.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mextra_map = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public QuickAction decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            r101.mname = "";
            r101.mdescription = "";
            r101.mdisplay_name = "";
            r101.micon = "";
            r101.mquery_template = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            switch(r103) {
                case 1: goto L26;
                case 2: goto L25;
                case 3: goto L24;
                case 4: goto L23;
                case 5: goto L22;
                case 6: goto L21;
                case 7: goto L31;
                case 8: goto L29;
                case 9: goto L12;
                case 10: goto L11;
                case 11: goto L10;
                case 12: goto L9;
                case 13: goto L8;
                case 14: goto L7;
                default: goto L6;
            };
        L29:
            r101.mFollowUpFrom = FollowUpFrom.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L31:
            r101.maction_type = QuickActionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mcontent_align = ContentAlign.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.mlink_config = LinkConfig.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.micon_config = IconConfig.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.mquery_template = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.mdisplay_config = DisplayConfig.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.micon = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.mdisplay_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.mparam_details.add(Param.ADAPTER.decode(r100));
            goto L3
        L23:
            r101.mextra_map.putAll(this.mextra_map.decode(r100));
            goto L3
        L24:
            r101.mdescription = ProtoAdapter.STRING.decode(r100);
            goto L3
        L25:
            r101.mname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L26:
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(QuickAction r100) {
            String r101 = r100.mid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mname;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mdescription;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = ((r106 + r108) + this.mextra_map.encodedSizeWithTag(4, r100.mextra_map)) + Param.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.mparam_details);
            String r110 = r100.mdisplay_name;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(6, r110);
        L18:
            int r112 = r109 + r111;
            QuickActionType r113 = r100.maction_type;
            if (r113 == null) goto L21;
            int r114 = QuickActionType.ADAPTER.encodedSizeWithTag(7, r113);
        L22:
            int r115 = r112 + r114;
            FollowUpFrom r116 = r100.mFollowUpFrom;
            if (r116 == null) goto L25;
            int r117 = FollowUpFrom.ADAPTER.encodedSizeWithTag(8, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.micon;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(9, r119);
        L30:
            int r121 = r118 + r120;
            DisplayConfig r122 = r100.mdisplay_config;
            if (r122 == null) goto L33;
            int r123 = DisplayConfig.ADAPTER.encodedSizeWithTag(10, r122);
        L34:
            int r124 = r121 + r123;
            String r125 = r100.mquery_template;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.STRING.encodedSizeWithTag(11, r125);
        L38:
            int r127 = r124 + r126;
            IconConfig r128 = r100.micon_config;
            if (r128 == null) goto L41;
            int r129 = IconConfig.ADAPTER.encodedSizeWithTag(12, r128);
        L42:
            int r130 = r127 + r129;
            LinkConfig r131 = r100.mlink_config;
            if (r131 == null) goto L45;
            int r132 = LinkConfig.ADAPTER.encodedSizeWithTag(13, r131);
        L46:
            int r133 = r130 + r132;
            ContentAlign r134 = r100.mcontent_align;
            if (r134 == null) goto L50;
            r102 = ContentAlign.ADAPTER.encodedSizeWithTag(14, r134);
        L50:
            return (r133 + r102) + r100.unknownFields().size();
        L45:
            r132 = 0;
            goto L46
        L41:
            r129 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
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
        public /* bridge */ /* synthetic */ QuickAction decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(QuickAction r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, QuickAction r101) throws IOException {
            String r102 = r101.mid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mname;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mdescription;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            this.mextra_map.encodeWithTag(r100, 4, r101.mextra_map);
            Param.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.mparam_details);
            String r105 = r101.mdisplay_name;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r105);
        L14:
            QuickActionType r106 = r101.maction_type;
            if (r106 == null) goto L17;
            QuickActionType.ADAPTER.encodeWithTag(r100, 7, r106);
        L17:
            FollowUpFrom r107 = r101.mFollowUpFrom;
            if (r107 == null) goto L20;
            FollowUpFrom.ADAPTER.encodeWithTag(r100, 8, r107);
        L20:
            String r108 = r101.micon;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r108);
        L23:
            DisplayConfig r109 = r101.mdisplay_config;
            if (r109 == null) goto L26;
            DisplayConfig.ADAPTER.encodeWithTag(r100, 10, r109);
        L26:
            String r110 = r101.mquery_template;
            if (r110 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r100, 11, r110);
        L29:
            IconConfig r111 = r101.micon_config;
            if (r111 == null) goto L32;
            IconConfig.ADAPTER.encodeWithTag(r100, 12, r111);
        L32:
            LinkConfig r112 = r101.mlink_config;
            if (r112 == null) goto L35;
            LinkConfig.ADAPTER.encodeWithTag(r100, 13, r112);
        L35:
            ContentAlign r113 = r101.mcontent_align;
            if (r113 == null) goto L38;
            ContentAlign.ADAPTER.encodeWithTag(r100, 14, r113);
        L38:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, QuickAction r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_QuickAction();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mname = this.mname;
        r100.mdescription = this.mdescription;
        r100.mextra_map = Internal.copyOf("mextra_map", this.mextra_map);
        r100.mparam_details = Internal.copyOf("mparam_details", this.mparam_details);
        r100.mdisplay_name = this.mdisplay_name;
        r100.maction_type = this.maction_type;
        r100.mFollowUpFrom = this.mFollowUpFrom;
        r100.micon = this.micon;
        r100.mdisplay_config = this.mdisplay_config;
        r100.mquery_template = this.mquery_template;
        r100.micon_config = this.micon_config;
        r100.mlink_config = this.mlink_config;
        r100.mcontent_align = this.mcontent_align;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return QuickAction.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public QuickAction(String r110, String r111, String r112, Map<String, String> r210, List<Param> r211, String r212, QuickActionType r213, FollowUpFrom r214, String r215, DisplayConfig r216, String r217, IconConfig r218, LinkConfig r219, ContentAlign r310) {
        this(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, ByteString.EMPTY);
    }

    public QuickAction(String r100, String r101, String r102, Map<String, String> r103, List<Param> r104, String r105, QuickActionType r110, FollowUpFrom r111, String r112, DisplayConfig r113, String r114, IconConfig r115, LinkConfig r116, ContentAlign r117, ByteString r118) {
        super(ADAPTER, r118);
        this.mid = r100;
        this.mname = r101;
        this.mdescription = r102;
        this.mextra_map = Internal.immutableCopyOf("mextra_map", r103);
        this.mparam_details = Internal.immutableCopyOf("mparam_details", r104);
        this.mdisplay_name = r105;
        this.maction_type = r110;
        this.mFollowUpFrom = r111;
        this.micon = r112;
        this.mdisplay_config = r113;
        this.mquery_template = r114;
        this.micon_config = r115;
        this.mlink_config = r116;
        this.mcontent_align = r117;
    }
}
