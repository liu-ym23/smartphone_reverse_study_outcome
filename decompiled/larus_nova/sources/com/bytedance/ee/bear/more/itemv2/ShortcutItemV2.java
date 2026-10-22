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
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes18.dex */
public class ShortcutItemV2 extends BaseMoreItem implements IGridMoreItem {
    private static final String MARK_FEED_EVENT = "pin_to_quickswitcher";
    private static final String REMOVE_MARK_FEED_EVENT = "unpin_to_quickswitcher";
    private static final String TAG = "ShortcutItemV2";
    private d mAnalyticService;
    private Context mApplicationContext;
    private String mFeedId;

    public class a implements x.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f234594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ShortcutItemV2 f234595b;

        public a(ShortcutItemV2 r100, boolean r101) {
            this.f234595b = r100;
            this.f234594a = r101;
        }
    }

    public static /* synthetic */ x a(String r100) {
        return lambda$onClick$0(r100);
    }

    public static /* synthetic */ void b(Throwable r100) {
        lambda$onClick$3(r100);
    }

    public static /* synthetic */ String c(ShortcutItemV2 r100, x r101) {
        return r100.lambda$onClick$1(r101);
    }

    public static /* synthetic */ void d(String r100) {
        lambda$onClick$2(r100);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return R.color.icon_n1;
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
        return R.drawable.ud_icon_set_top_cancel_outlined;
    L5:
        return R.drawable.ud_icon_set_top_outlined;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        if (isFeedShortcut() == false) goto L5;
        int r100 = R.string.Doc_More_CancelShortcut;
    L7:
        return getString(r100);
    L5:
        r100 = R.string.Doc_More_Shortcut;
        goto L7
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        c r100 = getMoreInfo();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r100.getUrl()) == true) goto L20;
        Uri r101 = UriProtector.parse(r100.getUrl());
        if (r101 == null) goto L21;
        boolean r102 = r101.getBooleanQueryParameter("enableShortcut", true);
        String r103 = UriProtector.getQueryParameter(r101, "sourceType");
        String r104 = UriProtector.getQueryParameter(r101, "docId");
        this.mFeedId = r104;
        if (TextUtils.isEmpty(r104) == false) goto L11;
        return false;
    L11:
        tt5.a.h(TAG, String.format("isVisible(enableShortcut:%b,source:%s)", new Object[]{Boolean.valueOf(r102), r103}));
        if (r102 == true) goto L14;
        return false;
    L14:
        if ("feed".equalsIgnoreCase(r103) == true) goto L16;
        return false;
    L16:
        if (r100.getType() == e.f541304o.f541317b) goto L24;
        return true;
    L24:
        return false;
    L21:
        return false;
    L20:
        return false;
    }

    public ShortcutItemV2(Activity r100) {
        this.mApplicationContext = r100.getApplicationContext();
        this.mAnalyticService = (d) org.koin.java.a.a(d.class);
    }

    public static /* synthetic */ Context access$000(ShortcutItemV2 r100) {
        return r100.mApplicationContext;
    }

    private static /* synthetic */ x lambda$onClick$0(String r100) throws Exception {
        return (x) org.koin.java.a.a(x.class);
    }

    private String lambda$onClick$1(x r210) throws Exception {
        boolean r100 = !r210.i(this.mFeedId);
        tt5.a.h(TAG, "getCallback()... onItemClick feedId = " + this.mFeedId + ", markShortcut = " + r100);
        r210.s(r100, this.mFeedId, new a(this, r100));
        if (getMoreInfo() == null) goto L6;
        reportShortcut(r100, getMoreInfo().getUrl());
    L6:
        if ((getMoreInfo() instanceof oj5.a) == false) goto L13;
        if (r100 == false) goto L9;
        String r101 = "top";
    L10:
        String r102 = r101;
        oj5.a r103 = (oj5.a) getMoreInfo();
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new i(getHost().getHostFragment().getArguments(), r103.f523532c, r103.getType(), false, r103.b(), r102, "ccm_docs_page_view", "", "", r103 instanceof f, r103.f523540k, r103.f523547r, r103.isOwner(), r103.L()));
        return "";
    L9:
        r101 = "top_cancel";
        goto L10
    L13:
        return "";
    }

    private static /* synthetic */ void lambda$onClick$2(String r100) throws Exception {
        tt5.a.b(TAG, "hostService markFeedCardShortcut success ");
    }

    private static void lambda$onClick$3(Throwable r100) throws Exception {
        tt5.a.e(TAG, "hostService markFeedCardShortcut fail", r100, false);
    }

    private void reportShortcut(boolean r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L11;
        BearUrl r102 = p.a().Z(r101);
        if (r102 == null) goto L12;
        if (r100 == false) goto L8;
        String r103 = MARK_FEED_EVENT;
    L9:
        HashMap r104 = new HashMap();
        r104.put("file_id", du5.b.g(r102.f222561b));
        r104.put("file_type", r102.f222560a);
        this.mAnalyticService.v(r103, r104);
        return;
    L8:
        r103 = REMOVE_MARK_FEED_EVENT;
        goto L9
    L12:
        return;
    }
}
