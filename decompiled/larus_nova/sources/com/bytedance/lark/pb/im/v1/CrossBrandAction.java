package com.bytedance.lark.pb.im.v1;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CrossBrandAction extends Message<CrossBrandAction, Builder> {
    public static final ProtoAdapter<CrossBrandAction> ADAPTER = null;
    public static final String DEFAULT_CANCEL_BTN_ACTION_LINK = "";
    public static final String DEFAULT_CANCEL_BTN_CONTENT = "";
    public static final String DEFAULT_CONFIRM_BTN_ACTION_LINK = "";
    public static final String DEFAULT_CONFIRM_BTN_CONTENT = "";
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_MESSAGE = "";
    public static final CrossBrandActionUiStyleType DEFAULT_STYLE_TYPE = null;
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final String cancel_btn_action_Link;
    public final String cancel_btn_content;
    public final String confirm_btn_action_link;
    public final String confirm_btn_content;
    public final String content;
    public final String message;
    public final CrossBrandActionUiStyleType style_type;
    public final String title;
    public final Map<String, String> trace_info;

    public static final class Builder extends Message.Builder<CrossBrandAction, Builder> {
        public String cancel_btn_action_Link;
        public String cancel_btn_content;
        public String confirm_btn_action_link;
        public String confirm_btn_content;
        public String content;
        public String message;
        public CrossBrandActionUiStyleType style_type;
        public String title;
        public Map<String, String> trace_info;

        @Override // com.squareup.wire.Message.Builder
        public CrossBrandAction build() {
            CrossBrandActionUiStyleType r100 = this.style_type;
            if (r100 == null) goto L7;
            return new CrossBrandAction(this.style_type, this.message, this.title, this.content, this.confirm_btn_content, this.confirm_btn_action_link, this.cancel_btn_content, this.cancel_btn_action_Link, this.trace_info, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, MapMonitorConst.STYLE_TYPE});
        }

        public Builder() {
            this.trace_info = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cancel_btn_action_Link(String r100) {
            this.cancel_btn_action_Link = r100;
            return this;
        }

        public Builder cancel_btn_content(String r100) {
            this.cancel_btn_content = r100;
            return this;
        }

        public Builder confirm_btn_action_link(String r100) {
            this.confirm_btn_action_link = r100;
            return this;
        }

        public Builder confirm_btn_content(String r100) {
            this.confirm_btn_content = r100;
            return this;
        }

        public Builder content(String r100) {
            this.content = r100;
            return this;
        }

        public Builder message(String r100) {
            this.message = r100;
            return this;
        }

        public Builder style_type(CrossBrandActionUiStyleType r100) {
            this.style_type = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }

        public Builder trace_info(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.trace_info = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CrossBrandAction extends ProtoAdapter<CrossBrandAction> {
        private final ProtoAdapter<Map<String, String>> trace_info;

        public ProtoAdapter_CrossBrandAction() {
            super(FieldEncoding.LENGTH_DELIMITED, CrossBrandAction.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.trace_info = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CrossBrandAction decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.style_type = CrossBrandActionUiStyleType.STYLE_TYPE_UNKNOWN;
            r101.message = "";
            r101.title = "";
            r101.content = "";
            r101.confirm_btn_content = "";
            r101.confirm_btn_action_link = "";
            r101.cancel_btn_content = "";
            r101.cancel_btn_action_Link = "";
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
            r101.style_type = CrossBrandActionUiStyleType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.trace_info.putAll(this.trace_info.decode(r100));
            goto L3
        L8:
            r101.cancel_btn_action_Link = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.cancel_btn_content = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.confirm_btn_action_link = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.confirm_btn_content = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.content = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.message = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(CrossBrandAction r100) {
            int r101 = CrossBrandActionUiStyleType.ADAPTER.encodedSizeWithTag(1, r100.style_type);
            String r102 = r100.message;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            String r106 = r100.title;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            String r109 = r100.content;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.STRING.encodedSizeWithTag(4, r109);
        L14:
            int r111 = r108 + r110;
            String r112 = r100.confirm_btn_content;
            if (r112 == null) goto L17;
            int r113 = ProtoAdapter.STRING.encodedSizeWithTag(5, r112);
        L18:
            int r114 = r111 + r113;
            String r115 = r100.confirm_btn_action_link;
            if (r115 == null) goto L21;
            int r116 = ProtoAdapter.STRING.encodedSizeWithTag(6, r115);
        L22:
            int r117 = r114 + r116;
            String r118 = r100.cancel_btn_content;
            if (r118 == null) goto L25;
            int r119 = ProtoAdapter.STRING.encodedSizeWithTag(7, r118);
        L26:
            int r120 = r117 + r119;
            String r121 = r100.cancel_btn_action_Link;
            if (r121 == null) goto L30;
            r103 = ProtoAdapter.STRING.encodedSizeWithTag(8, r121);
        L30:
            return ((r120 + r103) + this.trace_info.encodedSizeWithTag(9, r100.trace_info)) + r100.unknownFields().size();
        L25:
            r119 = 0;
            goto L26
        L21:
            r116 = 0;
            goto L22
        L17:
            r113 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ CrossBrandAction decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CrossBrandAction r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CrossBrandAction r101) throws IOException {
            CrossBrandActionUiStyleType.ADAPTER.encodeWithTag(r100, 1, r101.style_type);
            String r102 = r101.message;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            String r103 = r101.title;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            String r104 = r101.content;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
        L11:
            String r105 = r101.confirm_btn_content;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r105);
        L14:
            String r106 = r101.confirm_btn_action_link;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r106);
        L17:
            String r107 = r101.cancel_btn_content;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r107);
        L20:
            String r108 = r101.cancel_btn_action_Link;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r108);
        L23:
            this.trace_info.encodeWithTag(r100, 9, r101.trace_info);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CrossBrandAction r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CrossBrandAction();
        DEFAULT_STYLE_TYPE = CrossBrandActionUiStyleType.STYLE_TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.style_type = this.style_type;
        r100.message = this.message;
        r100.title = this.title;
        r100.content = this.content;
        r100.confirm_btn_content = this.confirm_btn_content;
        r100.confirm_btn_action_link = this.confirm_btn_action_link;
        r100.cancel_btn_content = this.cancel_btn_content;
        r100.cancel_btn_action_Link = this.cancel_btn_action_Link;
        r100.trace_info = Internal.copyOf("trace_info", this.trace_info);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CrossBrandAction.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CrossBrandAction(CrossBrandActionUiStyleType r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, Map<String, String> r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public CrossBrandAction(CrossBrandActionUiStyleType r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, Map<String, String> r110, ByteString r111) {
        super(ADAPTER, r111);
        this.style_type = r100;
        this.message = r101;
        this.title = r102;
        this.content = r103;
        this.confirm_btn_content = r104;
        this.confirm_btn_action_link = r105;
        this.cancel_btn_content = r106;
        this.cancel_btn_action_Link = r107;
        this.trace_info = Internal.immutableCopyOf("trace_info", r110);
    }
}
