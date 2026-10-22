package com.bytedance.ee.bear.more.itemv2;

import com.bytedance.ee.bear.contract.x;
import com.bytedance.ee.bear.lark.dependency.m;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import fo5.d;
import io.reactivex.Flowable;
import oj5.c;
import oj5.f;
import rj5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ContactServiceItemV2 extends BaseMoreItem implements ITextMoreItem {
    private static final String TAG = "ContactServiceItemV2";

    public static /* synthetic */ String a(x r0) {
        return lambda$onClick$1(r0);
    }

    public static /* synthetic */ void b(ContactServiceItemV2 r0, String r1) {
        r0.lambda$onClick$2(r1);
    }

    public static /* synthetic */ x c(String r0) {
        return lambda$onClick$0(r0);
    }

    public static /* synthetic */ void d(Throwable r0) {
        lambda$onClick$3(r0);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return 2131254866;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public final /* synthetic */ MoreUiAction getMoreAction() {
        return ITextMoreItem.CC.$default$getMoreAction(this);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getStateTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getUnableTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean isEnable() {
        return true;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean needShowBadge() {
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onDisableClick() {
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return CommonMoreItemId.CONTACT_SERVICE.getId();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        return ((m) org.koin.java.a.a(m.class)).getBoolean("suite_help_service_doc");
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(2131889018);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onClick() {
        c r0 = getMoreInfo();
        tt5.a.b(TAG, "onClick: moreInfo = " + r0);
        com.bytedance.ee.bear.more.c.b(r0, "contact");
        String r1 = "null";
        if (r0 == null) goto L5;
        String r5 = r0.getToken();
    L6:
        if (r0 == null) goto L8;
        int r6 = r0.getType();
    L9:
        if (r0 != null) goto L11;
    L13:
        boolean r7 = false;
    L14:
        if (r0 == null) goto L16;
        r1 = r0.b();
    L16:
        String r8 = r1;
        if ((r0 instanceof oj5.a) == false) goto L19;
        com.bytedance.ee.bear.more.c.c(new i(getHost().getHostFragment().getArguments(), r5, r6, r7, r8, "contact_us", "none", "", "", r0 instanceof f, ((oj5.a) r0).k, r0.H(), r0.isOwner(), r0.L()));
    L19:
        if (r0 == null) goto L22;
        Flowable.just("").subscribeOn(d.b()).map(new rj5.b()).map(new rj5.c()).observeOn(d.d()).subscribe(new rj5.d(this), new e());
        return;
    L22:
        return;
    L11:
        if (r0.isShareFolder() == false) goto L13;
        r7 = true;
        goto L14
    L8:
        r6 = -1;
        goto L9
    L5:
        r5 = "null";
        goto L6
    }

    public ContactServiceItemV2() {
    }

    private static /* synthetic */ x lambda$onClick$0(String r0) throws Exception {
        return (x) org.koin.java.a.a(x.class);
    }

    private static /* synthetic */ String lambda$onClick$1(x r0) throws Exception {
        r0.r();
        return "";
    }

    private /* synthetic */ void lambda$onClick$2(String r2) throws Exception {
        getHost().a();
        tt5.a.b(TAG, "hostService goToCustomService success ");
    }

    private static void lambda$onClick$3(Throwable r3) throws Exception {
        tt5.a.e(TAG, "hostService goToCustomService fail", r3, false);
    }
}
