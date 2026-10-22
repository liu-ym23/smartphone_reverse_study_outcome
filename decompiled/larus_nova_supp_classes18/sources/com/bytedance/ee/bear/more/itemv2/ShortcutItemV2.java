package com.bytedance.ee.bear.more.itemv2;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.contract.x;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Flowable;
import java.util.HashMap;
import oj5.c;
import oj5.f;
import rj5.b0;
import rj5.c0;
import rj5.d0;
import rj5.e0;
import s45.p;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ShortcutItemV2 extends BaseMoreItem implements IGridMoreItem {
    private static final String MARK_FEED_EVENT = "pin_to_quickswitcher";
    private static final String REMOVE_MARK_FEED_EVENT = "unpin_to_quickswitcher";
    private static final String TAG = "ShortcutItemV2";
    private d mAnalyticService;
    private Context mApplicationContext;
    private String mFeedId;

    public class a implements x.a {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ShortcutItemV2 b;

        public a(ShortcutItemV2 r1, boolean r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static /* synthetic */ x a(String r0) {
        return lambda$onClick$0(r0);
    }

    public static /* synthetic */ void b(Throwable r0) {
        lambda$onClick$3(r0);
    }

    public static /* synthetic */ String c(ShortcutItemV2 r0, x r1) {
        return r0.lambda$onClick$1(r1);
    }

    public static /* synthetic */ void d(String r0) {
        lambda$onClick$2(r0);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public String getUnableTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean isEnable() {
        return true;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean needShowBadge() {
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return CommonMoreItemId.SHORT_CUT.getId();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public void onClick() {
        if (TextUtils.isEmpty(this.mFeedId) == false) goto L6;
        tt5.a.d(TAG, "onItemClick()... feedId is empty");
        return;
    L6:
        Flowable.just("").subscribeOn(fo5.d.b()).map(new b0()).map(new c0(this)).subscribe(new d0(), new e0());
    }

    private boolean isFeedShortcut() {
        if (getMoreInfo() != null) goto L5;
    L7:
        return false;
    L5:
        if (getMoreInfo().F() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        if (isFeedShortcut() == false) goto L5;
        return 2131255644;
    L5:
        return 2131255645;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        if (isFeedShortcut() == false) goto L5;
        int r0 = 2131888019;
    L7:
        return getString(r0);
    L5:
        r0 = 2131888033;
        goto L7
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        c r0 = getMoreInfo();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r0.getUrl()) == true) goto L20;
        Uri r2 = UriProtector.parse(r0.getUrl());
        if (r2 == null) goto L21;
        boolean r3 = r2.getBooleanQueryParameter("enableShortcut", true);
        String r5 = UriProtector.getQueryParameter(r2, "sourceType");
        String r4 = UriProtector.getQueryParameter(r2, "docId");
        this.mFeedId = r4;
        if (TextUtils.isEmpty(r4) == false) goto L11;
        return false;
    L11:
        tt5.a.h(TAG, String.format("isVisible(enableShortcut:%b,source:%s)", new Object[]{Boolean.valueOf(r3), r5}));
        if (r3 == true) goto L14;
        return false;
    L14:
        if ("feed".equalsIgnoreCase(r5) == true) goto L16;
        return false;
    L16:
        if (r0.getType() == e.o.b) goto L24;
        return true;
    L24:
        return false;
    L21:
        return false;
    L20:
        return false;
    }

    public ShortcutItemV2(Activity r1) {
        this.mApplicationContext = r1.getApplicationContext();
        this.mAnalyticService = (d) org.koin.java.a.a(d.class);
    }

    public static /* synthetic */ Context access$000(ShortcutItemV2 r0) {
        return r0.mApplicationContext;
    }

    private static /* synthetic */ x lambda$onClick$0(String r0) throws Exception {
        return (x) org.koin.java.a.a(x.class);
    }

    private String lambda$onClick$1(x r22) throws Exception {
        boolean r2 = !r22.i(this.mFeedId);
        tt5.a.h(TAG, "getCallback()... onItemClick feedId = " + this.mFeedId + ", markShortcut = " + r2);
        r22.s(r2, this.mFeedId, new a(this, r2));
        if (getMoreInfo() == null) goto L6;
        reportShortcut(r2, getMoreInfo().getUrl());
    L6:
        if ((getMoreInfo() instanceof oj5.a) == false) goto L13;
        if (r2 == false) goto L9;
        String r1 = "top";
    L10:
        String r8 = r1;
        oj5.a r3 = (oj5.a) getMoreInfo();
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new i(getHost().getHostFragment().getArguments(), r3.c, r3.getType(), false, r3.b(), r8, "ccm_docs_page_view", "", "", r3 instanceof f, r3.k, r3.r, r3.isOwner(), r3.L()));
        return "";
    L9:
        r1 = "top_cancel";
        goto L10
    L13:
        return "";
    }

    private static /* synthetic */ void lambda$onClick$2(String r1) throws Exception {
        tt5.a.b(TAG, "hostService markFeedCardShortcut success ");
    }

    private static void lambda$onClick$3(Throwable r3) throws Exception {
        tt5.a.e(TAG, "hostService markFeedCardShortcut fail", r3, false);
    }

    private void reportShortcut(boolean r4, String r5) {
        if (TextUtils.isEmpty(r5) == true) goto L11;
        BearUrl r6 = p.a().Z(r5);
        if (r6 == null) goto L12;
        if (r4 == false) goto L8;
        String r7 = MARK_FEED_EVENT;
    L9:
        HashMap r0 = new HashMap();
        r0.put("file_id", du5.b.g(r6.b));
        r0.put("file_type", r6.a);
        this.mAnalyticService.v(r7, r0);
        return;
    L8:
        r7 = REMOVE_MARK_FEED_EVENT;
        goto L9
    L12:
        return;
    }
}
