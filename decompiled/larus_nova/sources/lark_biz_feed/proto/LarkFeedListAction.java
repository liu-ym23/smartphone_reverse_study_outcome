package lark_biz_feed.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class LarkFeedListAction extends Message<LarkFeedListAction, Builder> {
    public static final ProtoAdapter<LarkFeedListAction> ADAPTER = null;
    public static final Boolean DEFAULT_PAUSE_DATA_CHANGE_NOTIFY = null;
    public static final Boolean DEFAULT_RESUME_DATA_CHANGE_NOTIFY = null;
    public static final Boolean DEFAULT_SETUP = null;
    private static final long serialVersionUID = 0;
    public final LarkBizFeedStructPayload6f39b401968ec98b clear_badge;
    public final LarkBizFeedStructPayload2b2517acb416c4dd data_loading_check;
    public final LarkBizFeedStructPayload6818d699db356952 delete_item;
    public final LarkBizFeedStructPayloadCb51aa4e0dfa46c1 hide_item;
    public final LarkBizFeedStructPayloadBfabc31623467351 mark_item_as_un_read;
    public final Boolean pause_data_change_notify;
    public final LarkBizFeedStructPayload467788b2cd36fc07 preload_items_data;
    public final LarkBizFeedStructPayload7e251b9c83581426 preload_items_dependency;
    public final LarkBizFeedStructPayloadBbbf6bfd1b7d76e7 preload_next_unread;
    public final LarkBizFeedStructPayload69115a2878680bc6 refresh;
    public final Boolean resume_data_change_notify;
    public final LarkBizFeedStructPayload227619f5325cb7cd set_done;
    public final LarkBizFeedStructPayload4c1debabb59c79d0 set_no_disturb;
    public final LarkBizFeedStructPayloadB8cbcc55056b5a14 set_topping;
    public final Boolean setup;
    public final LarkBizFeedStructPayload2eaf423772123ddd switch_auto_mute;

    public static final class Builder extends Message.Builder<LarkFeedListAction, Builder> {
        public LarkBizFeedStructPayload6f39b401968ec98b clear_badge;
        public LarkBizFeedStructPayload2b2517acb416c4dd data_loading_check;
        public LarkBizFeedStructPayload6818d699db356952 delete_item;
        public LarkBizFeedStructPayloadCb51aa4e0dfa46c1 hide_item;
        public LarkBizFeedStructPayloadBfabc31623467351 mark_item_as_un_read;
        public Boolean pause_data_change_notify;
        public LarkBizFeedStructPayload467788b2cd36fc07 preload_items_data;
        public LarkBizFeedStructPayload7e251b9c83581426 preload_items_dependency;
        public LarkBizFeedStructPayloadBbbf6bfd1b7d76e7 preload_next_unread;
        public LarkBizFeedStructPayload69115a2878680bc6 refresh;
        public Boolean resume_data_change_notify;
        public LarkBizFeedStructPayload227619f5325cb7cd set_done;
        public LarkBizFeedStructPayload4c1debabb59c79d0 set_no_disturb;
        public LarkBizFeedStructPayloadB8cbcc55056b5a14 set_topping;
        public Boolean setup;
        public LarkBizFeedStructPayload2eaf423772123ddd switch_auto_mute;

        @Override // com.squareup.wire.Message.Builder
        public LarkFeedListAction build() {
            return new LarkFeedListAction(this.setup, this.pause_data_change_notify, this.resume_data_change_notify, this.refresh, this.clear_badge, this.mark_item_as_un_read, this.set_topping, this.set_no_disturb, this.switch_auto_mute, this.delete_item, this.hide_item, this.set_done, this.preload_items_data, this.preload_items_dependency, this.data_loading_check, this.preload_next_unread, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder clear_badge(LarkBizFeedStructPayload6f39b401968ec98b r100) {
            this.clear_badge = r100;
            this.setup = null;
            this.pause_data_change_notify = null;
            this.resume_data_change_notify = null;
            this.refresh = null;
            this.mark_item_as_un_read = null;
            this.set_topping = null;
            this.set_no_disturb = null;
            this.switch_auto_mute = null;
            this.delete_item = null;
            this.hide_item = null;
            this.set_done = null;
            this.preload_items_data = null;
            this.preload_items_dependency = null;
            this.data_loading_check = null;
            this.preload_next_unread = null;
            return this;
        }

        public Builder data_loading_check(LarkBizFeedStructPayload2b2517acb416c4dd r100) {
            this.data_loading_check = r100;
            this.setup = null;
            this.pause_data_change_notify = null;
            this.resume_data_change_notify = null;
            this.refresh = null;
            this.clear_badge = null;
            this.mark_item_as_un_read = null;
            this.set_topping = null;
            this.set_no_disturb = null;
            this.switch_auto_mute = null;
            this.delete_item = null;
            this.hide_item = null;
            this.set_done = null;
            this.preload_items_data = null;
            this.preload_items_dependency = null;
            this.preload_next_unread = null;
            return this;
        }

        public Builder delete_item(LarkBizFeedStructPayload6818d699db356952 r100) {
            this.delete_item = r100;
            this.setup = null;
            this.pause_data_change_notify = null;
            this.resume_data_change_notify = null;
            this.refresh = null;
            this.clear_badge = null;
            this.mark_item_as_un_read = null;
            this.set_topping = null;
            this.set_no_disturb = null;
            this.switch_auto_mute = null;
            this.hide_item = null;
            this.set_done = null;
            this.preload_items_data = null;
            this.preload_items_dependency = null;
            this.data_loading_check = null;
            this.preload_next_unread = null;
            return this;
        }

        public Builder hide_item(LarkBizFeedStructPayloadCb51aa4e0dfa46c1 r100) {
            this.hide_item = r100;
            this.setup = null;
            this.pause_data_change_notify = null;
            this.resume_data_change_notify = null;
            this.refresh = null;
            this.clear_badge = null;
            this.mark_item_as_un_read = null;
            this.set_topping = null;
            this.set_no_disturb = null;
            this.switch_auto_mute = null;
            this.delete_item = null;
            this.set_done = null;
            this.preload_items_data = null;
            this.preload_items_dependency = null;
            this.data_loading_check = null;
            this.preload_next_unread = null;
            return this;
        }

        public Builder mark_item_as_un_read(LarkBizFeedStructPayloadBfabc31623467351 r100) {
            this.mark_item_as_un_read = r100;
            this.setup = null;
            this.pause_data_change_notify = null;
            this.resume_data_change_notify = null;
            this.refresh = null;
            this.clear_badge = null;
            this.set_topping = null;
            this.set_no_disturb = null;
            this.switch_auto_mute = null;
            this.delete_item = null;
            this.hide_item = null;
            this.set_done = null;
            this.preload_items_data = null;
            this.preload_items_dependency = null;
            this.data_loading_check = null;
            this.preload_next_unread = null;
            return this;
        }

        public Builder pause_data_change_notify(Boolean r100) {
            this.pause_data_change_notify = r100;
            this.setup = null;
            this.resume_data_change_notify = null;
            this.refresh = null;
            this.clear_badge = null;
            this.mark_item_as_un_read = null;
            this.set_topping = null;
            this.set_no_disturb = null;
            this.switch_auto_mute = null;
            this.delete_item = null;
            this.hide_item = null;
            this.set_done = null;
            this.preload_items_data = null;
            this.preload_items_dependency = null;
            this.data_loading_check = null;
            this.preload_next_unread = null;
            return this;
        }

        public Builder preload_items_data(LarkBizFeedStructPayload467788b2cd36fc07 r100) {
            this.preload_items_data = r100;
            this.setup = null;
            this.pause_data_change_notify = null;
            this.resume_data_change_notify = null;
            this.refresh = null;
            this.clear_badge = null;
            this.mark_item_as_un_read = null;
            this.set_topping = null;
            this.set_no_disturb = null;
            this.switch_auto_mute = null;
            this.delete_item = null;
            this.hide_item = null;
            this.set_done = null;
            this.preload_items_dependency = null;
            this.data_loading_check = null;
            this.preload_next_unread = null;
            return this;
        }

        public Builder preload_items_dependency(LarkBizFeedStructPayload7e251b9c83581426 r100) {
            this.preload_items_dependency = r100;
            this.setup = null;
            this.pause_data_change_notify = null;
            this.resume_data_change_notify = null;
            this.refresh = null;
            this.clear_badge = null;
            this.mark_item_as_un_read = null;
            this.set_topping = null;
            this.set_no_disturb = null;
            this.switch_auto_mute = null;
            this.delete_item = null;
            this.hide_item = null;
            this.set_done = null;
            this.preload_items_data = null;
            this.data_loading_check = null;
            this.preload_next_unread = null;
            return this;
        }

        public Builder preload_next_unread(LarkBizFeedStructPayloadBbbf6bfd1b7d76e7 r100) {
            this.preload_next_unread = r100;
            this.setup = null;
            this.pause_data_change_notify = null;
            this.resume_data_change_notify = null;
            this.refresh = null;
            this.clear_badge = null;
            this.mark_item_as_un_read = null;
            this.set_topping = null;
            this.set_no_disturb = null;
            this.switch_auto_mute = null;
            this.delete_item = null;
            this.hide_item = null;
            this.set_done = null;
            this.preload_items_data = null;
            this.preload_items_dependency = null;
            this.data_loading_check = null;
            return this;
        }

        public Builder refresh(LarkBizFeedStructPayload69115a2878680bc6 r100) {
            this.refresh = r100;
            this.setup = null;
            this.pause_data_change_notify = null;
            this.resume_data_change_notify = null;
            this.clear_badge = null;
            this.mark_item_as_un_read = null;
            this.set_topping = null;
            this.set_no_disturb = null;
            this.switch_auto_mute = null;
            this.delete_item = null;
            this.hide_item = null;
            this.set_done = null;
            this.preload_items_data = null;
            this.preload_items_dependency = null;
            this.data_loading_check = null;
            this.preload_next_unread = null;
            return this;
        }

        public Builder resume_data_change_notify(Boolean r100) {
            this.resume_data_change_notify = r100;
            this.setup = null;
            this.pause_data_change_notify = null;
            this.refresh = null;
            this.clear_badge = null;
            this.mark_item_as_un_read = null;
            this.set_topping = null;
            this.set_no_disturb = null;
            this.switch_auto_mute = null;
            this.delete_item = null;
            this.hide_item = null;
            this.set_done = null;
            this.preload_items_data = null;
            this.preload_items_dependency = null;
            this.data_loading_check = null;
            this.preload_next_unread = null;
            return this;
        }

        public Builder set_done(LarkBizFeedStructPayload227619f5325cb7cd r100) {
            this.set_done = r100;
            this.setup = null;
            this.pause_data_change_notify = null;
            this.resume_data_change_notify = null;
            this.refresh = null;
            this.clear_badge = null;
            this.mark_item_as_un_read = null;
            this.set_topping = null;
            this.set_no_disturb = null;
            this.switch_auto_mute = null;
            this.delete_item = null;
            this.hide_item = null;
            this.preload_items_data = null;
            this.preload_items_dependency = null;
            this.data_loading_check = null;
            this.preload_next_unread = null;
            return this;
        }

        public Builder set_no_disturb(LarkBizFeedStructPayload4c1debabb59c79d0 r100) {
            this.set_no_disturb = r100;
            this.setup = null;
            this.pause_data_change_notify = null;
            this.resume_data_change_notify = null;
            this.refresh = null;
            this.clear_badge = null;
            this.mark_item_as_un_read = null;
            this.set_topping = null;
            this.switch_auto_mute = null;
            this.delete_item = null;
            this.hide_item = null;
            this.set_done = null;
            this.preload_items_data = null;
            this.preload_items_dependency = null;
            this.data_loading_check = null;
            this.preload_next_unread = null;
            return this;
        }

        public Builder set_topping(LarkBizFeedStructPayloadB8cbcc55056b5a14 r100) {
            this.set_topping = r100;
            this.setup = null;
            this.pause_data_change_notify = null;
            this.resume_data_change_notify = null;
            this.refresh = null;
            this.clear_badge = null;
            this.mark_item_as_un_read = null;
            this.set_no_disturb = null;
            this.switch_auto_mute = null;
            this.delete_item = null;
            this.hide_item = null;
            this.set_done = null;
            this.preload_items_data = null;
            this.preload_items_dependency = null;
            this.data_loading_check = null;
            this.preload_next_unread = null;
            return this;
        }

        public Builder setup(Boolean r100) {
            this.setup = r100;
            this.pause_data_change_notify = null;
            this.resume_data_change_notify = null;
            this.refresh = null;
            this.clear_badge = null;
            this.mark_item_as_un_read = null;
            this.set_topping = null;
            this.set_no_disturb = null;
            this.switch_auto_mute = null;
            this.delete_item = null;
            this.hide_item = null;
            this.set_done = null;
            this.preload_items_data = null;
            this.preload_items_dependency = null;
            this.data_loading_check = null;
            this.preload_next_unread = null;
            return this;
        }

        public Builder switch_auto_mute(LarkBizFeedStructPayload2eaf423772123ddd r100) {
            this.switch_auto_mute = r100;
            this.setup = null;
            this.pause_data_change_notify = null;
            this.resume_data_change_notify = null;
            this.refresh = null;
            this.clear_badge = null;
            this.mark_item_as_un_read = null;
            this.set_topping = null;
            this.set_no_disturb = null;
            this.delete_item = null;
            this.hide_item = null;
            this.set_done = null;
            this.preload_items_data = null;
            this.preload_items_dependency = null;
            this.data_loading_check = null;
            this.preload_next_unread = null;
            return this;
        }
    }

    public static final class ProtoAdapter_LarkFeedListAction extends ProtoAdapter<LarkFeedListAction> {
        public ProtoAdapter_LarkFeedListAction() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkFeedListAction.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public LarkFeedListAction decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L23;
            switch(r103) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L12;
                case 12: goto L11;
                case 13: goto L10;
                case 14: goto L9;
                case 15: goto L8;
                case 16: goto L7;
                default: goto L6;
            };
        L7:
            r101.preload_next_unread(LarkBizFeedStructPayloadBbbf6bfd1b7d76e7.ADAPTER.decode(r100));
            goto L3
        L8:
            r101.data_loading_check(LarkBizFeedStructPayload2b2517acb416c4dd.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.preload_items_dependency(LarkBizFeedStructPayload7e251b9c83581426.ADAPTER.decode(r100));
            goto L3
        L10:
            r101.preload_items_data(LarkBizFeedStructPayload467788b2cd36fc07.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.set_done(LarkBizFeedStructPayload227619f5325cb7cd.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.hide_item(LarkBizFeedStructPayloadCb51aa4e0dfa46c1.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.delete_item(LarkBizFeedStructPayload6818d699db356952.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.switch_auto_mute(LarkBizFeedStructPayload2eaf423772123ddd.ADAPTER.decode(r100));
            goto L3
        L15:
            r101.set_no_disturb(LarkBizFeedStructPayload4c1debabb59c79d0.ADAPTER.decode(r100));
            goto L3
        L16:
            r101.set_topping(LarkBizFeedStructPayloadB8cbcc55056b5a14.ADAPTER.decode(r100));
            goto L3
        L17:
            r101.mark_item_as_un_read(LarkBizFeedStructPayloadBfabc31623467351.ADAPTER.decode(r100));
            goto L3
        L18:
            r101.clear_badge(LarkBizFeedStructPayload6f39b401968ec98b.ADAPTER.decode(r100));
            goto L3
        L19:
            r101.refresh(LarkBizFeedStructPayload69115a2878680bc6.ADAPTER.decode(r100));
            goto L3
        L20:
            r101.resume_data_change_notify(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L21:
            r101.pause_data_change_notify(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L22:
            r101.setup(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L23:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(LarkFeedListAction r100) {
            Boolean r101 = r100.setup;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.pause_data_change_notify;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.resume_data_change_notify;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            LarkBizFeedStructPayload69115a2878680bc6 r110 = r100.refresh;
            if (r110 == null) goto L17;
            int r111 = LarkBizFeedStructPayload69115a2878680bc6.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            LarkBizFeedStructPayload6f39b401968ec98b r113 = r100.clear_badge;
            if (r113 == null) goto L21;
            int r114 = LarkBizFeedStructPayload6f39b401968ec98b.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            LarkBizFeedStructPayloadBfabc31623467351 r116 = r100.mark_item_as_un_read;
            if (r116 == null) goto L25;
            int r117 = LarkBizFeedStructPayloadBfabc31623467351.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            LarkBizFeedStructPayloadB8cbcc55056b5a14 r119 = r100.set_topping;
            if (r119 == null) goto L29;
            int r120 = LarkBizFeedStructPayloadB8cbcc55056b5a14.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            LarkBizFeedStructPayload4c1debabb59c79d0 r122 = r100.set_no_disturb;
            if (r122 == null) goto L33;
            int r123 = LarkBizFeedStructPayload4c1debabb59c79d0.ADAPTER.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            LarkBizFeedStructPayload2eaf423772123ddd r125 = r100.switch_auto_mute;
            if (r125 == null) goto L37;
            int r126 = LarkBizFeedStructPayload2eaf423772123ddd.ADAPTER.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            LarkBizFeedStructPayload6818d699db356952 r128 = r100.delete_item;
            if (r128 == null) goto L41;
            int r129 = LarkBizFeedStructPayload6818d699db356952.ADAPTER.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            LarkBizFeedStructPayloadCb51aa4e0dfa46c1 r131 = r100.hide_item;
            if (r131 == null) goto L45;
            int r132 = LarkBizFeedStructPayloadCb51aa4e0dfa46c1.ADAPTER.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            LarkBizFeedStructPayload227619f5325cb7cd r134 = r100.set_done;
            if (r134 == null) goto L49;
            int r135 = LarkBizFeedStructPayload227619f5325cb7cd.ADAPTER.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            LarkBizFeedStructPayload467788b2cd36fc07 r137 = r100.preload_items_data;
            if (r137 == null) goto L53;
            int r138 = LarkBizFeedStructPayload467788b2cd36fc07.ADAPTER.encodedSizeWithTag(13, r137);
        L54:
            int r139 = r136 + r138;
            LarkBizFeedStructPayload7e251b9c83581426 r140 = r100.preload_items_dependency;
            if (r140 == null) goto L57;
            int r141 = LarkBizFeedStructPayload7e251b9c83581426.ADAPTER.encodedSizeWithTag(14, r140);
        L58:
            int r142 = r139 + r141;
            LarkBizFeedStructPayload2b2517acb416c4dd r143 = r100.data_loading_check;
            if (r143 == null) goto L61;
            int r144 = LarkBizFeedStructPayload2b2517acb416c4dd.ADAPTER.encodedSizeWithTag(15, r143);
        L62:
            int r145 = r142 + r144;
            LarkBizFeedStructPayloadBbbf6bfd1b7d76e7 r146 = r100.preload_next_unread;
            if (r146 == null) goto L66;
            r102 = LarkBizFeedStructPayloadBbbf6bfd1b7d76e7.ADAPTER.encodedSizeWithTag(16, r146);
        L66:
            return (r145 + r102) + r100.unknownFields().size();
        L61:
            r144 = 0;
            goto L62
        L57:
            r141 = 0;
            goto L58
        L53:
            r138 = 0;
            goto L54
        L49:
            r135 = 0;
            goto L50
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
        public /* bridge */ /* synthetic */ LarkFeedListAction decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LarkFeedListAction r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LarkFeedListAction r101) throws IOException {
            Boolean r102 = r101.setup;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.pause_data_change_notify;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.resume_data_change_notify;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            LarkBizFeedStructPayload69115a2878680bc6 r105 = r101.refresh;
            if (r105 == null) goto L14;
            LarkBizFeedStructPayload69115a2878680bc6.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            LarkBizFeedStructPayload6f39b401968ec98b r106 = r101.clear_badge;
            if (r106 == null) goto L17;
            LarkBizFeedStructPayload6f39b401968ec98b.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            LarkBizFeedStructPayloadBfabc31623467351 r107 = r101.mark_item_as_un_read;
            if (r107 == null) goto L20;
            LarkBizFeedStructPayloadBfabc31623467351.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            LarkBizFeedStructPayloadB8cbcc55056b5a14 r108 = r101.set_topping;
            if (r108 == null) goto L23;
            LarkBizFeedStructPayloadB8cbcc55056b5a14.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            LarkBizFeedStructPayload4c1debabb59c79d0 r109 = r101.set_no_disturb;
            if (r109 == null) goto L26;
            LarkBizFeedStructPayload4c1debabb59c79d0.ADAPTER.encodeWithTag(r100, 8, r109);
        L26:
            LarkBizFeedStructPayload2eaf423772123ddd r110 = r101.switch_auto_mute;
            if (r110 == null) goto L29;
            LarkBizFeedStructPayload2eaf423772123ddd.ADAPTER.encodeWithTag(r100, 9, r110);
        L29:
            LarkBizFeedStructPayload6818d699db356952 r111 = r101.delete_item;
            if (r111 == null) goto L32;
            LarkBizFeedStructPayload6818d699db356952.ADAPTER.encodeWithTag(r100, 10, r111);
        L32:
            LarkBizFeedStructPayloadCb51aa4e0dfa46c1 r112 = r101.hide_item;
            if (r112 == null) goto L35;
            LarkBizFeedStructPayloadCb51aa4e0dfa46c1.ADAPTER.encodeWithTag(r100, 11, r112);
        L35:
            LarkBizFeedStructPayload227619f5325cb7cd r113 = r101.set_done;
            if (r113 == null) goto L38;
            LarkBizFeedStructPayload227619f5325cb7cd.ADAPTER.encodeWithTag(r100, 12, r113);
        L38:
            LarkBizFeedStructPayload467788b2cd36fc07 r114 = r101.preload_items_data;
            if (r114 == null) goto L41;
            LarkBizFeedStructPayload467788b2cd36fc07.ADAPTER.encodeWithTag(r100, 13, r114);
        L41:
            LarkBizFeedStructPayload7e251b9c83581426 r115 = r101.preload_items_dependency;
            if (r115 == null) goto L44;
            LarkBizFeedStructPayload7e251b9c83581426.ADAPTER.encodeWithTag(r100, 14, r115);
        L44:
            LarkBizFeedStructPayload2b2517acb416c4dd r116 = r101.data_loading_check;
            if (r116 == null) goto L47;
            LarkBizFeedStructPayload2b2517acb416c4dd.ADAPTER.encodeWithTag(r100, 15, r116);
        L47:
            LarkBizFeedStructPayloadBbbf6bfd1b7d76e7 r117 = r101.preload_next_unread;
            if (r117 == null) goto L50;
            LarkBizFeedStructPayloadBbbf6bfd1b7d76e7.ADAPTER.encodeWithTag(r100, 16, r117);
        L50:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkFeedListAction r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LarkFeedListAction();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_SETUP = r100;
        DEFAULT_PAUSE_DATA_CHANGE_NOTIFY = r100;
        DEFAULT_RESUME_DATA_CHANGE_NOTIFY = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.setup = this.setup;
        r100.pause_data_change_notify = this.pause_data_change_notify;
        r100.resume_data_change_notify = this.resume_data_change_notify;
        r100.refresh = this.refresh;
        r100.clear_badge = this.clear_badge;
        r100.mark_item_as_un_read = this.mark_item_as_un_read;
        r100.set_topping = this.set_topping;
        r100.set_no_disturb = this.set_no_disturb;
        r100.switch_auto_mute = this.switch_auto_mute;
        r100.delete_item = this.delete_item;
        r100.hide_item = this.hide_item;
        r100.set_done = this.set_done;
        r100.preload_items_data = this.preload_items_data;
        r100.preload_items_dependency = this.preload_items_dependency;
        r100.data_loading_check = this.data_loading_check;
        r100.preload_next_unread = this.preload_next_unread;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LarkFeedListAction.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LarkFeedListAction(Boolean r110, Boolean r210, Boolean r211, LarkBizFeedStructPayload69115a2878680bc6 r212, LarkBizFeedStructPayload6f39b401968ec98b r213, LarkBizFeedStructPayloadBfabc31623467351 r214, LarkBizFeedStructPayloadB8cbcc55056b5a14 r215, LarkBizFeedStructPayload4c1debabb59c79d0 r216, LarkBizFeedStructPayload2eaf423772123ddd r217, LarkBizFeedStructPayload6818d699db356952 r218, LarkBizFeedStructPayloadCb51aa4e0dfa46c1 r219, LarkBizFeedStructPayload227619f5325cb7cd r310, LarkBizFeedStructPayload467788b2cd36fc07 r311, LarkBizFeedStructPayload7e251b9c83581426 r312, LarkBizFeedStructPayload2b2517acb416c4dd r313, LarkBizFeedStructPayloadBbbf6bfd1b7d76e7 r314) {
        this(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, ByteString.EMPTY);
    }

    public LarkFeedListAction(Boolean r110, Boolean r111, Boolean r210, LarkBizFeedStructPayload69115a2878680bc6 r211, LarkBizFeedStructPayload6f39b401968ec98b r212, LarkBizFeedStructPayloadBfabc31623467351 r213, LarkBizFeedStructPayloadB8cbcc55056b5a14 r214, LarkBizFeedStructPayload4c1debabb59c79d0 r215, LarkBizFeedStructPayload2eaf423772123ddd r216, LarkBizFeedStructPayload6818d699db356952 r217, LarkBizFeedStructPayloadCb51aa4e0dfa46c1 r218, LarkBizFeedStructPayload227619f5325cb7cd r219, LarkBizFeedStructPayload467788b2cd36fc07 r310, LarkBizFeedStructPayload7e251b9c83581426 r311, LarkBizFeedStructPayload2b2517acb416c4dd r312, LarkBizFeedStructPayloadBbbf6bfd1b7d76e7 r313, ByteString r314) {
        super(ADAPTER, r314);
        if (Internal.countNonNull(r110, r111, r210, r211, new Object[]{r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313}) > 1) goto L7;
        this.setup = r110;
        this.pause_data_change_notify = r111;
        this.resume_data_change_notify = r210;
        this.refresh = r211;
        this.clear_badge = r212;
        this.mark_item_as_un_read = r213;
        this.set_topping = r214;
        this.set_no_disturb = r215;
        this.switch_auto_mute = r216;
        this.delete_item = r217;
        this.hide_item = r218;
        this.set_done = r219;
        this.preload_items_data = r310;
        this.preload_items_dependency = r311;
        this.data_loading_check = r312;
        this.preload_next_unread = r313;
        return;
    L7:
        throw new IllegalArgumentException("at most one of setup, pause_data_change_notify, resume_data_change_notify, refresh, clear_badge, mark_item_as_un_read, set_topping, set_no_disturb, switch_auto_mute, delete_item, hide_item, set_done, preload_items_data, preload_items_dependency, data_loading_check, preload_next_unread may be non-null");
    }
}
