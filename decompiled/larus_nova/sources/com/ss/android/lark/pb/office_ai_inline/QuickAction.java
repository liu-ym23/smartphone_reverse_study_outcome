package com.ss.android.lark.pb.office_ai_inline;

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
    public static final Long DEFAULT_ACTION_TYPE = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_ICON = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PROMPT_TASK = "";
    public static final String DEFAULT_PROMPT_TASK_VERSION = "";
    private static final long serialVersionUID = 0;
    public final Long maction_type;
    public final String mdescription;
    public final Map<String, String> mextra_map;
    public final String micon;
    public final String mid;
    public final String mname;
    public final List<QuickActionParam> mparam_details;
    public final List<String> mparams;
    public final String mprompt_task;
    public final String mprompt_task_version;

    public static final class Builder extends Message.Builder<QuickAction, Builder> {
        public Long maction_type;
        public String mdescription;
        public Map<String, String> mextra_map;
        public String micon;
        public String mid;
        public String mname;
        public List<QuickActionParam> mparam_details;
        public List<String> mparams;
        public String mprompt_task;
        public String mprompt_task_version;

        @Override // com.squareup.wire.Message.Builder
        public QuickAction build() {
            return new QuickAction(this.mid, this.mname, this.mdescription, this.micon, this.maction_type, this.mprompt_task, this.mprompt_task_version, this.mparams, this.mextra_map, this.mparam_details, super.buildUnknownFields());
        }

        public Builder() {
            this.mparams = Internal.newMutableList();
            this.mextra_map = Internal.newMutableMap();
            this.mparam_details = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action_type(Long r100) {
            this.maction_type = r100;
            return this;
        }

        public Builder description(String r100) {
            this.mdescription = r100;
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

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }

        public Builder param_details(List<QuickActionParam> r100) {
            Internal.checkElementsNotNull(r100);
            this.mparam_details = r100;
            return this;
        }

        public Builder params(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mparams = r100;
            return this;
        }

        public Builder prompt_task(String r100) {
            this.mprompt_task = r100;
            return this;
        }

        public Builder prompt_task_version(String r100) {
            this.mprompt_task_version = r100;
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
            r101.micon = "";
            r101.maction_type = 0L;
            r101.mprompt_task = "";
            r101.mprompt_task_version = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r101.mparam_details.add(QuickActionParam.ADAPTER.decode(r100));
            goto L3
        L8:
            r101.mextra_map.putAll(this.mextra_map.decode(r100));
            goto L3
        L9:
            r101.mparams.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            r101.mprompt_task_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.mprompt_task = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.maction_type = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            r101.micon = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.mdescription = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.mname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
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
            int r109 = r106 + r108;
            String r110 = r100.micon;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.maction_type;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.mprompt_task;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.mprompt_task_version;
            if (r119 == null) goto L30;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            return ((((r118 + r102) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(8, r100.mparams)) + this.mextra_map.encodedSizeWithTag(9, r100.mextra_map)) + QuickActionParam.ADAPTER.asRepeated().encodedSizeWithTag(10, r100.mparam_details)) + r100.unknownFields().size();
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
            String r105 = r101.micon;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Long r106 = r101.maction_type;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.mprompt_task;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.mprompt_task_version;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 8, r101.mparams);
            this.mextra_map.encodeWithTag(r100, 9, r101.mextra_map);
            QuickActionParam.ADAPTER.asRepeated().encodeWithTag(r100, 10, r101.mparam_details);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, QuickAction r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_QuickAction();
        DEFAULT_ACTION_TYPE = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mname = this.mname;
        r100.mdescription = this.mdescription;
        r100.micon = this.micon;
        r100.maction_type = this.maction_type;
        r100.mprompt_task = this.mprompt_task;
        r100.mprompt_task_version = this.mprompt_task_version;
        r100.mparams = Internal.copyOf("mparams", this.mparams);
        r100.mextra_map = Internal.copyOf("mextra_map", this.mextra_map);
        r100.mparam_details = Internal.copyOf("mparam_details", this.mparam_details);
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

    public QuickAction(String r110, String r111, String r112, String r113, Long r114, String r115, String r116, List<String> r210, Map<String, String> r211, List<QuickActionParam> r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public QuickAction(String r100, String r101, String r102, String r103, Long r104, String r105, String r106, List<String> r107, Map<String, String> r110, List<QuickActionParam> r111, ByteString r112) {
        super(ADAPTER, r112);
        this.mid = r100;
        this.mname = r101;
        this.mdescription = r102;
        this.micon = r103;
        this.maction_type = r104;
        this.mprompt_task = r105;
        this.mprompt_task_version = r106;
        this.mparams = Internal.immutableCopyOf("mparams", r107);
        this.mextra_map = Internal.immutableCopyOf("mextra_map", r110);
        this.mparam_details = Internal.immutableCopyOf("mparam_details", r111);
    }
}
