package com.bytedance.ee.bear.more.itemv2;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.c0;
import com.bytedance.ee.bear.contract.f0;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ILoadingSwitchMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ISwitchMoreItem;
import com.bytedance.ee.bear.more.q;
import com.bytedance.ee.util.ui.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import jg5.e;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oj5.c;
import oj5.f;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/more/itemv2/SubscribeItemV2;", "Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/ILoadingSwitchMoreItem;", "<init>", "()V", "isLoading", "", "getId", "", "getTitle", "getIcon", "", "getIconTint", "isCheck", "isVisible", "canEdit", "moreInfo", "Lcom/bytedance/ee/bear/more/export/DocMoreInfo;", "onCheckStateChange", "", "delegate", "Lcom/bytedance/ee/bear/more/moreprotocol/ISwitchMoreItem$ItemNotifyDelegate;", "notifyItemChange", "Companion", "CrossTenantSubscribeType", "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubscribeItemV2 extends BaseMoreItem implements ILoadingSwitchMoreItem {
    public static final a Companion = null;
    public static final String TAG = "SubscribeItem";
    private boolean isLoading;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements c0.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubscribeItemV2 f234604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f234605b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f234606c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ISwitchMoreItem.a f234607d;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SubscribeItemV2 f234608a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ c f234609b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ boolean f234610c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ISwitchMoreItem.a f234611d;

            public a(SubscribeItemV2 r100, c r101, boolean r102, ISwitchMoreItem.a r103) {
                this.f234608a = r100;
                this.f234609b = r101;
                this.f234610c = r102;
                this.f234611d = r103;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SubscribeItemV2.access$setLoading$p(this.f234608a, false);     // Catch: Throwable -> L4
                this.f234609b.g(this.f234610c);     // Catch: Throwable -> L4
                SubscribeItemV2.access$notifyItemChange(this.f234608a, this.f234611d);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.ee.bear.contract.c0.e
        public final void onFail() {
            m.a(new com.bytedance.ee.bear.more.itemv2.b(this.f234604a, this.f234607d));
        }

        @Override // com.bytedance.ee.bear.contract.c0.e
        public final void onSuccess() {
            m.a(new a(this.f234604a, this.f234605b, this.f234606c, this.f234607d));
        }

        public b(SubscribeItemV2 r100, c r101, boolean r102, ISwitchMoreItem.a r103) {
            this.f234604a = r100;
            this.f234605b = r101;
            this.f234606c = r102;
            this.f234607d = r103;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return R.drawable.ud_icon_subscribe_add_outlined;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return R.color.icon_n1;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return "subscribe";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(R.string.Doc_Facade_Subscribe);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ILoadingSwitchMoreItem
    public boolean isCheck() {
        c r100 = getMoreInfo();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isSubscribe();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        if ((getMoreInfo() instanceof oj5.a) == true) goto L6;
        tt5.a.k(TAG, "getMoreInfo() is not DocMoreInfo!");
        return false;
    L6:
        c r100 = getMoreInfo();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.more.export.DocMoreInfo");
        oj5.a r101 = (oj5.a) r100;
        if (r101.f523545p == false) goto L11;
        tt5.a.h(TAG, "shortcut is not supported");
        return false;
    L11:
        if (CollectionsKt.listOf(new Integer[]{2, 22, 3}).contains(Integer.valueOf(r101.i())) == true) goto L14;
        tt5.a.h(TAG, "type is not supported: " + r101.i());
        return false;
    L14:
        AccountService$Account r102 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r102 == null) goto L18;
        String r103 = r102.tenantId;
        if (r103 == null) goto L18;
    L19:
        boolean r104 = TextUtils.equals(r103, r101.a());
        int r105 = r101.f523537h.getCrossTenantSubscribeType();
        tt5.a.h(TAG, "docMoreInfo.getRealType(): " + r101.i() + ", isSameTenant: " + r104 + ", crossTenantSubscribeType: " + r105);
        if (r104 == true) goto L26;
        if (r105 != 1) goto L25;
        return true;
    L25:
        return canEdit(r101);
    L26:
        return true;
    L18:
        r103 = "";
        goto L19
    }

    public SubscribeItemV2() {
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ILoadingSwitchMoreItem
    public boolean isLoading() {
        return this.isLoading;
    }

    private final boolean canEdit(oj5.a r100) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.f499003a.g() == false) goto L7;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).t(r100.f523544o, r100, BizDomain.FileBizDomainCCM, "EDIT", r100.f523538i.f234419a).getAllow();
    L7:
        return r100.n();
    }

    private final void notifyItemChange(ISwitchMoreItem.a r100) {
        if (com.bytedance.ee.util.ui.b.a(getHost().getHostFragment().getActivity()) == true) goto L5;
    L7:
        tt5.a.d(TAG, "activity is not active or panel not showing");
        return;
    L5:
        if (getHost().isShowing() == false) goto L7;
        r100.notifyItemChanged();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ILoadingSwitchMoreItem
    public void onCheckStateChange(ISwitchMoreItem.a r210) {
        Intrinsics.checkNotNullParameter(r210, "delegate");
        c r100 = getMoreInfo();
        tt5.a.h(TAG, "onItemCheck. ");
        if (r100 == null) goto L16;
        boolean r101 = !r100.isSubscribe();
        if (r101 == false) goto L7;
        String r102 = "add_subscribe";
    L8:
        com.bytedance.ee.bear.more.c.b(r100, r102);
        this.isLoading = true;
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).X(new f0(q.a(r100), q.getType(r100), r101, 0, new b(this, r100, r101, r210)));
        if ((r100 instanceof oj5.a) == false) goto L17;
        Bundle r103 = getHost().getHostFragment().getArguments();
        oj5.a r104 = (oj5.a) r100;
        String r105 = r104.f523532c;
        int r106 = r104.getType();
        String r107 = r104.b();
        if (r101 == false) goto L13;
        String r108 = "follow_open";
    L14:
        com.bytedance.ee.bear.more.c.c(new i(r103, r105, r106, false, r107, r108, "none", "", "", r100 instanceof f, r104.f523540k, r104.f523547r, r104.isOwner(), r104.L()));
        return;
    L13:
        r108 = "follow_close";
        goto L14
    L17:
        return;
    L7:
        r102 = "remove_subscribe";
        goto L8
    }

    public static final /* synthetic */ void access$notifyItemChange(SubscribeItemV2 r100, ISwitchMoreItem.a r101) {
        r100.notifyItemChange(r101);
    }

    public static final /* synthetic */ void access$setLoading$p(SubscribeItemV2 r100, boolean r101) {
        r100.isLoading = r101;
    }
}
