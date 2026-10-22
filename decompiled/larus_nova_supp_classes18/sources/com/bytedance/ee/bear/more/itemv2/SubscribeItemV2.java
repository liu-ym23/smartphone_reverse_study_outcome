package com.bytedance.ee.bear.more.itemv2;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService;
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
import jg5.e;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oj5.c;
import oj5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
        public final /* synthetic */ SubscribeItemV2 a;
        public final /* synthetic */ c b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ ISwitchMoreItem.a d;

        public static final class a implements Runnable {
            public final /* synthetic */ SubscribeItemV2 a;
            public final /* synthetic */ c b;
            public final /* synthetic */ boolean c;
            public final /* synthetic */ ISwitchMoreItem.a d;

            public a(SubscribeItemV2 r1, c r2, boolean r3, ISwitchMoreItem.a r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SubscribeItemV2.access$setLoading$p(this.a, false);     // Catch: Throwable -> L4
                this.b.g(this.c);     // Catch: Throwable -> L4
                SubscribeItemV2.access$notifyItemChange(this.a, this.d);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final void onFail() {
            m.a(new com.bytedance.ee.bear.more.itemv2.b(this.a, this.d));
        }

        public final void onSuccess() {
            m.a(new a(this.a, this.b, this.c, this.d));
        }

        public b(SubscribeItemV2 r1, c r2, boolean r3, ISwitchMoreItem.a r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return 2131255845;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return "subscribe";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(2131887836);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ILoadingSwitchMoreItem
    public boolean isCheck() {
        c r0 = getMoreInfo();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isSubscribe();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        if ((getMoreInfo() instanceof oj5.a) == true) goto L6;
        tt5.a.k(TAG, "getMoreInfo() is not DocMoreInfo!");
        return false;
    L6:
        c r0 = getMoreInfo();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.more.export.DocMoreInfo");
        oj5.a r1 = (oj5.a) r0;
        if (r1.p == false) goto L11;
        tt5.a.h(TAG, "shortcut is not supported");
        return false;
    L11:
        if (CollectionsKt.listOf(new Integer[]{2, 22, 3}).contains(Integer.valueOf(r1.i())) == true) goto L14;
        tt5.a.h(TAG, "type is not supported: " + r1.i());
        return false;
    L14:
        AccountService.Account r2 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r2 == null) goto L18;
        String r3 = r2.tenantId;
        if (r3 == null) goto L18;
    L19:
        boolean r4 = TextUtils.equals(r3, r1.a());
        int r5 = r1.h.getCrossTenantSubscribeType();
        tt5.a.h(TAG, "docMoreInfo.getRealType(): " + r1.i() + ", isSameTenant: " + r4 + ", crossTenantSubscribeType: " + r5);
        if (r4 == true) goto L26;
        if (r5 != 1) goto L25;
        return true;
    L25:
        return canEdit(r1);
    L26:
        return true;
    L18:
        r3 = "";
        goto L19
    }

    public SubscribeItemV2() {
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ILoadingSwitchMoreItem
    public boolean isLoading() {
        return this.isLoading;
    }

    private final boolean canEdit(oj5.a r8) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.a.g() == false) goto L7;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).t(r8.o, r8, BizDomain.FileBizDomainCCM, "EDIT", r8.i.a).getAllow();
    L7:
        return r8.n();
    }

    private final void notifyItemChange(ISwitchMoreItem.a r2) {
        if (com.bytedance.ee.util.ui.b.a(getHost().getHostFragment().getActivity()) == true) goto L5;
    L7:
        tt5.a.d(TAG, "activity is not active or panel not showing");
        return;
    L5:
        if (getHost().isShowing() == false) goto L7;
        r2.notifyItemChanged();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ILoadingSwitchMoreItem
    public void onCheckStateChange(ISwitchMoreItem.a r20) {
        Intrinsics.checkNotNullParameter(r20, "delegate");
        c r2 = getMoreInfo();
        tt5.a.h(TAG, "onItemCheck. ");
        if (r2 == null) goto L16;
        boolean r3 = !r2.isSubscribe();
        if (r3 == false) goto L7;
        String r5 = "add_subscribe";
    L8:
        com.bytedance.ee.bear.more.c.b(r2, r5);
        this.isLoading = true;
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).X(new f0(q.a(r2), q.getType(r2), r3, 0, new b(this, r2, r3, r20)));
        if ((r2 instanceof oj5.a) == false) goto L17;
        Bundle r6 = getHost().getHostFragment().getArguments();
        oj5.a r4 = (oj5.a) r2;
        String r7 = r4.c;
        int r8 = r4.getType();
        String r9 = r4.b();
        if (r3 == false) goto L13;
        String r10 = "follow_open";
    L14:
        com.bytedance.ee.bear.more.c.c(new i(r6, r7, r8, false, r9, r10, "none", "", "", r2 instanceof f, r4.k, r4.r, r4.isOwner(), r4.L()));
        return;
    L13:
        r10 = "follow_close";
        goto L14
    L17:
        return;
    L7:
        r5 = "remove_subscribe";
        goto L8
    }

    public static final /* synthetic */ void access$notifyItemChange(SubscribeItemV2 r0, ISwitchMoreItem.a r1) {
        r0.notifyItemChange(r1);
    }

    public static final /* synthetic */ void access$setLoading$p(SubscribeItemV2 r0, boolean r1) {
        r0.isLoading = r1;
    }
}
