package com.bytedance.ee.bear.more.itemv2;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem;
import com.bytedance.ee.bear.more.q;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import java.lang.ref.WeakReference;
import java.util.Locale;
import oj5.c;
import oj5.e;
import oj5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class AddShortCutItemV2 extends BaseMoreItem implements IGridMoreItem {
    private static final String TAG = "AddShortCutItemV2";
    private Activity mActivity;

    public class a implements td5.a {
        public final /* synthetic */ AddShortCutItemV2 a;

        public a(AddShortCutItemV2 r1) {
            this.a = r1;
        }

        @Override // td5.a
        public final boolean a(Document r1) {
            return FolderVersion.isShareFolderV2(Integer.valueOf(r1.L1));
        }

        @Override // td5.a
        public final void b(Document r2, Context r3) {
            Toast.showText(r3, AddShortCutItemV2.access$000(this.a, 2131887320));
        }
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean needShowBadge() {
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return CommonMoreItemId.ADD_SHORT_CUT.getId();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public String getUnableTips() {
        if (j.a.a.getNetworkState().a() == true) goto L7;
        return getString(2131887951);
    L7:
        return getString(2131887803);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public void onClick() {
        c r1 = getMoreInfo();
        if (r1 != null) goto L6;
        tt5.a.b(TAG, "onClick: but more info is null");
        return;
    L6:
        boolean r2 = e.a(r1);
        WikiSelectorBean r8 = new WikiSelectorBean();
        if (r2 == false) goto L9;
        r8.i = r1.getToken();
        r8.j = r1.getType();
        r8.d = ((f) r1).O;
        r8.l = r1.E();
        r8.a = r1.getSpaceId();
        r8.o = r1.isOwner();
    L9:
        SpaceSelectorBean r7 = new SpaceSelectorBean();
        r7.a = r1.getType();
        r7.a(r1.getToken());
        r7.i = r1.isOwner();
        SelectorConfig r5 = new SelectorConfig();
        if (r2 == false) goto L12;
        SelectorType r3 = SelectorType.WIKI_SHORTCUT_TO;
    L13:
        r5.c(r3);
        r5.a(SelectorScope.ALL);
        r5.b(getString(2131889880));
        r5.g = 3025;
        r5.d = true;
        r5.i = ((rc5.a) org.koin.java.a.a(rc5.a.class)).B();
        if (FolderVersion.isShareFolderV2(Integer.valueOf(r1.C())) == true) goto L16;
        r5.e = true;
    L16:
        a r4 = new a(this);
        SelectorConfig.a r6 = SelectorConfig.CREATOR;
        WeakReference<td5.a> r9 = new WeakReference(r4);
        r6.getClass();
        SelectorConfig.k = r9;
        ((h) org.koin.java.a.a(h.class)).setActivity(this.mActivity);
        td5.f r10 = new td5.f();
        r10.a = 3;
        r10.f = Boolean.valueOf(getMoreInfo().m());
        r10.h = true;
        if (ForsetiHelper.s(getHost().getHostFragment()) == false) goto L19;
        ((com.bytedance.ee.bear.contract.route.parcelable.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.route.parcelable.f.class)).a(getHost().getHostFragment(), r5, r10, r7, r8);
    L21:
        if ((r1 instanceof oj5.a) == false) goto L24;
        oj5.a r11 = (oj5.a) getMoreInfo();
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new i(getHost().getHostFragment().getArguments(), r11.c, r11.getType(), false, r11.b(), "create_shortcut", "ccm_space_add_to_folder_view", "", "", r11 instanceof f, r11.k, r11.r, r1.isOwner(), r1.L()));
    L24:
        if (ForsetiHelper.s(getHost().getHostFragment()) == true) goto L27;
        getHost().a();
        return;
    L27:
        return;
    L19:
        ((com.bytedance.ee.bear.contract.route.parcelable.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.route.parcelable.f.class)).c(this.mActivity, r5, r10, r7, r8);
        goto L21
    L12:
        r3 = SelectorType.SPACE_ADD_SHORTCUT;
        goto L13
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return kac.a.b(2131255216);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        String r0 = getString(2131889880);
    L7:
        th = move-exception;
        tt5.a.e(TAG, "getTitle()...", th, false);
        return r0;
    L4:
        if (TextUtils.equals(((i0) org.koin.java.a.a(i0.class)).a(), Locale.CHINESE.getLanguage()) == false) goto L12;
        return r0.substring(0, 4) + "\n" + r0.substring(4);
    L12:
        return r0;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean isEnable() {
        if ((getMoreInfo() instanceof oj5.a) == false) goto L13;
        oj5.a r0 = (oj5.a) getMoreInfo();
        if (r0.p == false) goto L13;
        if (r0.q == false) goto L10;
        return false;
    L10:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).v(r0, r0.i.a, "VIEW").booleanValue() == true) goto L13;
        return false;
    L13:
        return j.a.a.getNetworkState().a();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        c r0 = getMoreInfo();
        if (r0 != null) goto L6;
        tt5.a.d(TAG, "moreInfo is null!");
        return false;
    L6:
        Integer r2 = r0.A();
        if (r2 != null) goto L10;
        return false;
    L10:
        if (r0.getType() != sbb.e.f.b) goto L12;
        return false;
    L12:
        if (FolderVersion.isShareFolderV2(r2) == true) goto L14;
        return false;
    L14:
        if (q.b(r0) == false) goto L16;
        return false;
    L16:
        if (((ww4.a) org.koin.java.a.a(ww4.a.class)).a().d().a == true) goto L18;
        return false;
    L18:
        if (r0.w() == true) goto L25;
        return true;
    L25:
        return false;
    }

    public AddShortCutItemV2(Activity r1) {
        this.mActivity = r1;
    }

    public static /* synthetic */ String access$000(AddShortCutItemV2 r0, int r1) {
        return r0.getString(r1);
    }
}
