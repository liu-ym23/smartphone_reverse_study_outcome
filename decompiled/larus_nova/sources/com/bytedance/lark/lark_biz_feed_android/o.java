package com.bytedance.lark.lark_biz_feed_android;

import kotlin.NoWhenBranchMatchedException;
import lark_biz_feed.proto.ChannelEntity;
import lark_biz_feed.proto.LarkBizFeedStructPayload227619f5325cb7cd;
import lark_biz_feed.proto.LarkBizFeedStructPayload2b2517acb416c4dd;
import lark_biz_feed.proto.LarkBizFeedStructPayload2eaf423772123ddd;
import lark_biz_feed.proto.LarkBizFeedStructPayload467788b2cd36fc07;
import lark_biz_feed.proto.LarkBizFeedStructPayload4c1debabb59c79d0;
import lark_biz_feed.proto.LarkBizFeedStructPayload6818d699db356952;
import lark_biz_feed.proto.LarkBizFeedStructPayload69115a2878680bc6;
import lark_biz_feed.proto.LarkBizFeedStructPayload6f39b401968ec98b;
import lark_biz_feed.proto.LarkBizFeedStructPayload7e251b9c83581426;
import lark_biz_feed.proto.LarkBizFeedStructPayloadB8cbcc55056b5a14;
import lark_biz_feed.proto.LarkBizFeedStructPayloadBbbf6bfd1b7d76e7;
import lark_biz_feed.proto.LarkBizFeedStructPayloadBfabc31623467351;
import lark_biz_feed.proto.LarkBizFeedStructPayloadCb51aa4e0dfa46c1;
import lark_biz_feed.proto.LarkFeedListAction;

/* JADX INFO: loaded from: classes8.dex */
public abstract class o {
    public o() {
    }

    public final LarkFeedListAction a() {
        if ((this instanceof d0) == false) goto L6;
        return new LarkFeedListAction.Builder().setup(Boolean.TRUE).build();
    L6:
        if ((this instanceof u) == false) goto L9;
        return new LarkFeedListAction.Builder().pause_data_change_notify(Boolean.TRUE).build();
    L9:
        if ((this instanceof z) == false) goto L12;
        return new LarkFeedListAction.Builder().resume_data_change_notify(Boolean.TRUE).build();
    L12:
        if ((this instanceof y) == false) goto L15;
        return new LarkFeedListAction.Builder().refresh(new LarkBizFeedStructPayload69115a2878680bc6(((y) this).f253213a.into())).build();
    L15:
        if ((this instanceof p) == false) goto L18;
        return new LarkFeedListAction.Builder().clear_badge(new LarkBizFeedStructPayload6f39b401968ec98b(((p) this).f253188a.a())).build();
    L18:
        if ((this instanceof t) == false) goto L21;
        t r100 = (t) this;
        return new LarkFeedListAction.Builder().mark_item_as_un_read(new LarkBizFeedStructPayloadBfabc31623467351(r100.f253197a.a(), Boolean.valueOf(r100.f253198b))).build();
    L21:
        if ((this instanceof c0) == false) goto L24;
        c0 r101 = (c0) this;
        return new LarkFeedListAction.Builder().set_topping(new LarkBizFeedStructPayloadB8cbcc55056b5a14(r101.f253150a.a(), Boolean.valueOf(r101.f253151b))).build();
    L24:
        if ((this instanceof b0) == false) goto L27;
        b0 r102 = (b0) this;
        return new LarkFeedListAction.Builder().set_no_disturb(new LarkBizFeedStructPayload4c1debabb59c79d0(r102.f253146a.a(), Boolean.valueOf(r102.f253147b))).build();
    L27:
        if ((this instanceof e0) == false) goto L30;
        return new LarkFeedListAction.Builder().switch_auto_mute(new LarkBizFeedStructPayload2eaf423772123ddd(Long.valueOf(((e0) this).f253158a))).build();
    L30:
        if ((this instanceof r) == false) goto L33;
        return new LarkFeedListAction.Builder().delete_item(new LarkBizFeedStructPayload6818d699db356952(((r) this).f253194a.a())).build();
    L33:
        if ((this instanceof s) == false) goto L40;
        LarkFeedListAction.Builder r103 = new LarkFeedListAction.Builder();
        f r104 = ((s) this).f253196a;
        String r105 = r104.f253161a;
        FeedCardType r106 = r104.f253162b;
        if (r106 == null) goto L37;
        lark_biz_feed.proto.FeedCardType r107 = r106.into();
    L67:
        return r103.hide_item(new LarkBizFeedStructPayloadCb51aa4e0dfa46c1(new ChannelEntity(r105, r107))).build();
    L37:
        r107 = null;
        goto L67
    L40:
        if ((this instanceof a0) == false) goto L43;
        return new LarkFeedListAction.Builder().set_done(new LarkBizFeedStructPayload227619f5325cb7cd(((a0) this).f253145a.a())).build();
    L43:
        if ((this instanceof v) == false) goto L46;
        return new LarkFeedListAction.Builder().preload_items_data(new LarkBizFeedStructPayload467788b2cd36fc07(((v) this).f253202a)).build();
    L46:
        if ((this instanceof w) == false) goto L49;
        w r108 = (w) this;
        return new LarkFeedListAction.Builder().preload_items_dependency(new LarkBizFeedStructPayload7e251b9c83581426(r108.f253206a, Integer.valueOf(r108.f253207b))).build();
    L49:
        if ((this instanceof q) == false) goto L52;
        q r109 = (q) this;
        return new LarkFeedListAction.Builder().data_loading_check(new LarkBizFeedStructPayload2b2517acb416c4dd(r109.f253190a.into(), Integer.valueOf(r109.f253191b), Boolean.valueOf(r109.f253192c))).build();
    L52:
        if ((this instanceof x) == false) goto L56;
        return new LarkFeedListAction.Builder().preload_next_unread(new LarkBizFeedStructPayloadBbbf6bfd1b7d76e7(((x) this).f253208a)).build();
    L56:
        throw new NoWhenBranchMatchedException();
    }
}
