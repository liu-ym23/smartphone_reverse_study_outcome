package com.bytedance.ee.bear.more.itemv2;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$DataSource;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.more.protocol3.panel.y;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import oj5.f;
import org.json.JSONException;
import org.json.JSONObject;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J(\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/more/itemv2/SecretMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/ITextMoreItem;", "<init>", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getId", "", "canModify", "", "moreInfo", "Lcom/bytedance/ee/bear/more/export/IMoreInfo;", "canVisitSecretLabel", "isVisible", "isEnable", "getUnableTips", "getTitle", "getIcon", "", "getIconTint", "getStateTips", "onDisableClick", "", SendEventContainerMethodParamModel.EventKinds.onClick, "onRelease", "showSecretLevelFragment", ResourceData.KEY_TOKEN, ResourceData.KEY_TYPE, "meta", "Lcom/bytedance/ee/bear/DocMetaInfo;", WikiFolderPushPlugin.WIKI_TOKEN, "Companion", "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SecretMoreItem extends BaseMoreItem implements ITextMoreItem {
    public static final a Companion = null;
    private static final String TAG = "SecretMoreItem";
    private final CompositeDisposable compositeDisposable;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ SecretMoreItem a;
        public final /* synthetic */ Ref.ObjectRef<String> b;
        public final /* synthetic */ Ref.IntRef c;
        public final /* synthetic */ Ref.ObjectRef<String> d;

        public b(SecretMoreItem r1, Ref.ObjectRef<String> r2, Ref.IntRef r3, Ref.ObjectRef<String> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r5) {
            DocMetaInfo r6 = (DocMetaInfo) r5;
            SecretMoreItem r0 = this.a;
            String r1 = (String) this.b.element;
            int r2 = this.c.element;
            Intrinsics.checkNotNull(r6);
            SecretMoreItem.access$showSecretLevelFragment(r0, r1, r2, r6, (String) this.d.element);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ SecretMoreItem a;

        public c(SecretMoreItem r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            tt5.a.f(SecretMoreItem.TAG, (Throwable) r3, false);
            FragmentActivity r4 = this.a.getHost().getHostFragment().getActivity();
            if (com.bytedance.ee.util.ui.b.a(r4) == false) goto L7;
            Toast.showFailureText(r4, 2131887384);
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return TAG;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public final /* synthetic */ MoreUiAction getMoreAction() {
        return ITextMoreItem.CC.$default$getMoreAction(this);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public final /* synthetic */ boolean needShowBadge() {
        return ITextMoreItem.CC.$default$needShowBadge(this);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onDisableClick() {
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.sec_label_show") == false) goto L5;
        return 2131255592;
    L5:
        oj5.c r0 = getMoreInfo();
        if ((r0 instanceof oj5.a) == true) goto L8;
        return 2131255592;
    L8:
        if (canModify(r0) == true) goto L12;
        return 2131255591;
    L12:
        return 2131255592;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.sec_label_show") == true) goto L5;
        oj5.c r0 = getMoreInfo();
        if ((r0 instanceof oj5.a) == false) goto L12;
        if (canModify(r0) == true) goto L12;
        return getString(2131889254);
    L12:
        return getString(2131889255);
    L5:
        return getString(2131889255);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onClick() {
        oj5.c r1 = getMoreInfo();
        if (r1 != null) goto L5;
        return;
    L5:
        boolean r2 = r1 instanceof oj5.a;
        if (r2 == true) goto L9;
        return;
    L9:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.sec_label_show") == false) goto L11;
    L13:
        oj5.a r3 = (oj5.a) r1;
        DocMetaInfo r4 = r3.g;
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        r5.element = r3.c;
        Ref.IntRef r6 = new Ref.IntRef();
        r6.element = r3.getType();
        String r7 = r3.b();
        if (r7 != null) goto L16;
        r7 = "null";
    L16:
        String r13 = r7;
        Ref.ObjectRef r8 = new Ref.ObjectRef();
        r8.element = "";
        boolean r11 = false;
        if (r6.element != 16) goto L25;
        if (r3.o.length() <= 0) goto L21;
        boolean r9 = true;
    L22:
        if (r9 == false) goto L25;
        r5.element = r3.o + "";
        r6.element = r3.i();
        r8.element = r3.c + "";
    L32:
        if (r2 == false) goto L35;
        com.bytedance.ee.bear.more.c.c(new i(getHost().getHostFragment().getArguments(), (String) r5.element, r6.element, false, r13, "security_setting", "ccm_permission_security_setting_view", "", "", r1 instanceof f, r3.k, r3.r, r3.isOwner(), r3.L()));
    L35:
        if (r4.isGetSecDetailFail() == false) goto L37;
        this.compositeDisposable.add(((a4) org.koin.java.a.c(a4.class, null, null, 6)).b((String) r5.element, r6.element).subscribe(new b(this, r5, r6, r8), new c(this)));
        return;
    L37:
        showSecretLevelFragment((String) r5.element, r6.element, r4, (String) r8.element);
        return;
    L21:
        r9 = false;
    L25:
        if ((r1 instanceof f) == false) goto L31;
        f r10 = (f) r1;
        if (r10.O.length() <= 0) goto L29;
        r11 = true;
    L29:
        if (r11 == false) goto L31;
        r8.element = r10.O + "";
    L31:
        r8.element = ((String) r5.element) + "";
        goto L32
    L11:
        if (canModify(r1) == true) goto L13;
    }

    public SecretMoreItem() {
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getStateTips() {
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L6;
        return "";
    L6:
        if ((r0 instanceof oj5.a) == true) goto L8;
        return "";
    L8:
        DocMetaInfo r1 = ((oj5.a) r0).g;
        if (r1.isSecCreateFail() == true) goto L22;
        if (r1.isNoSec() == false) goto L16;
        if (r1.isVisibleSecList() == true) goto L22;
    L16:
        if (r1.isGetSecDetailFail() == false) goto L20;
        return getString(2131887383);
    L20:
        return r1.getSecretLevel().getName();
    L22:
        return getString(2131887389);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getUnableTips() {
        if (y.a() == true) goto L5;
        return "";
    L5:
        if (j.a.a.getNetworkState().a() == false) goto L7;
        return "";
    L7:
        return getString(2131887951);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean isEnable() {
        if (y.a() == true) goto L6;
        y.c(TAG, getId());
        return true;
    L6:
        boolean r0 = j.a.a.getNetworkState().a();
        String r2 = getId();
        if (r0 == false) goto L9;
        String r4 = "";
    L10:
        y.b(TAG, r2, true, r0, r4, DocFeed$Value$DataSource.NETWORK);
        return r0;
    L9:
        r4 = DocFeed$Value$DataSource.NETWORK;
        goto L10
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L6;
        return false;
    L6:
        if ((r0 instanceof oj5.a) == true) goto L8;
        return false;
    L8:
        boolean r2 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.sec_label_show");
        oj5.a r3 = (oj5.a) r0;
        if (r3.getType() != e.n.b) goto L11;
        boolean r4 = fj5.a.b(r3.i());
    L12:
        boolean r5 = r3.g.isVisibleSecList();
        if (r2 == true) goto L20;
        if (r4 == false) goto L26;
        if (r5 == true) goto L17;
        return false;
    L17:
        if (canVisitSecretLabel(r0) == false) goto L28;
        return true;
    L28:
        return false;
    L26:
        return false;
    L20:
        boolean r1 = canModify(r0);
        if (r4 == false) goto L29;
        if (r5 == false) goto L30;
        if (r1 == false) goto L31;
        return true;
    L31:
        return false;
    L30:
        return false;
    L29:
        return false;
    L11:
        r4 = fj5.a.c(r3.getType(), r3.j.isDocV2());
        goto L12
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public void onRelease() {
        super.onRelease();
        this.compositeDisposable.clear();
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L5;
        return;
    L5:
        String r1 = String.valueOf(canModify(r0));
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L8
        r2.put("is_security_icon_show", "true");     // Catch: JSONException -> L8
        r2.put("is_have_change_perm", r1);     // Catch: JSONException -> L8
        ((d) org.koin.java.a.a(d.class)).i("ccm_space_docs_more_menu_view", r2);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    private final boolean canModify(oj5.c r8) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L7;
        return r8.c().a.canModifySecretLevel();
    L7:
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).t(r8.getToken(), r8, BizDomain.FileBizDomainCCM, "SECRET_MODIFY", r8.c().a).getAllow();
    }

    private final boolean canVisitSecretLabel(oj5.c r8) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L7;
        return r8.c().a.canVisitSecretLevel();
    L7:
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).t(r8.getToken(), r8, BizDomain.FileBizDomainCCM, "SECRET_LEVEL_VISIBLE", r8.c().a).getAllow();
    }

    private final void showSecretLevelFragment(String r12, int r13, DocMetaInfo r14, String r15) {
        FragmentActivity r2 = getHost().getHostFragment().getActivity();
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L6;
        return;
    L6:
        if (com.bytedance.ee.util.ui.b.a(r2) == true) goto L9;
        return;
    L9:
        if (r14.isGetSecDetailFail() == false) goto L12;
        tt5.a.h(TAG, "isGetSecDetailFail");
        Toast.showFailureText(r2, 2131887384);
        return;
    L12:
        boolean r8 = canModify(r0);
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).k6(r2, r12, r13, r14, r15, "from_docs_more_menu", r8, getHost().getHostFragment(), true);
        if (ForsetiHelper.s(getHost().getHostFragment()) == true) goto L16;
        getHost().a();
        return;
    }

    public static final /* synthetic */ void access$showSecretLevelFragment(SecretMoreItem r0, String r1, int r2, DocMetaInfo r3, String r4) {
        r0.showSecretLevelFragment(r1, r2, r3, r4);
    }
}
