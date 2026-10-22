package com.bytedance.ee.bear.more.itemv2;

import android.os.Bundle;
import com.bytedance.ee.bear.contract.c0;
import com.bytedance.ee.bear.contract.f0;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ILoadingSwitchMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ISwitchMoreItem;
import com.bytedance.ee.bear.more.q;
import com.bytedance.ee.util.ui.m;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oj5.c;
import oj5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/more/itemv2/SubscribeCommentItemV2;", "Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/ILoadingSwitchMoreItem;", "<init>", "()V", "isLoading", "", "getId", "", "getTitle", "getIcon", "", "getIconTint", "isCheck", "isVisible", "onCheckStateChange", "", "delegate", "Lcom/bytedance/ee/bear/more/moreprotocol/ISwitchMoreItem$ItemNotifyDelegate;", "notifyItemChange", "Companion", "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubscribeCommentItemV2 extends BaseMoreItem implements ILoadingSwitchMoreItem {
    public static final a Companion = null;
    public static final String TAG = "SubscribeCommentItem";
    private boolean isLoading;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements c0.e {
        public final /* synthetic */ SubscribeCommentItemV2 a;
        public final /* synthetic */ c b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ ISwitchMoreItem.a d;

        public static final class a implements Runnable {
            public final /* synthetic */ SubscribeCommentItemV2 a;
            public final /* synthetic */ c b;
            public final /* synthetic */ boolean c;
            public final /* synthetic */ ISwitchMoreItem.a d;

            public a(SubscribeCommentItemV2 r1, c r2, boolean r3, ISwitchMoreItem.a r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SubscribeCommentItemV2.access$setLoading$p(this.a, false);     // Catch: Throwable -> L4
                this.b.G(this.c);     // Catch: Throwable -> L4
                SubscribeCommentItemV2.access$notifyItemChange(this.a, this.d);     // Catch: Throwable -> L4
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
            m.a(new com.bytedance.ee.bear.more.itemv2.a(this.a, this.d));
        }

        public final void onSuccess() {
            m.a(new a(this.a, this.b, this.c, this.d));
        }

        public b(SubscribeCommentItemV2 r1, c r2, boolean r3, ISwitchMoreItem.a r4) {
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
        return 2131254145;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return "subscribeComment";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(2131889068);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ILoadingSwitchMoreItem
    public boolean isCheck() {
        c r0 = getMoreInfo();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.P();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        if ((getMoreInfo() instanceof oj5.a) == false) goto L20;
        c r0 = getMoreInfo();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.more.export.DocMoreInfo");
        oj5.a r1 = (oj5.a) r0;
        if (r1.p == false) goto L7;
        return false;
    L7:
        boolean r2 = com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.docs.follow_comment_enable", false);
        if (r1.i() != 2) goto L10;
    L13:
        boolean r3 = true;
    L14:
        boolean r4 = r1.i.b.isOwner();
        if (r2 == false) goto L21;
        if (r3 == false) goto L22;
        if (r4 == true) goto L23;
        return true;
    L23:
        return false;
    L22:
        return false;
    L21:
        return false;
    L10:
        if (r1.i() == 22) goto L13;
        r3 = false;
        goto L14
    L20:
        return false;
    }

    public SubscribeCommentItemV2() {
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ILoadingSwitchMoreItem
    public boolean isLoading() {
        return this.isLoading;
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
        boolean r3 = !r2.P();
        if (r3 == false) goto L7;
        String r5 = "add_subscribe_comment";
    L8:
        com.bytedance.ee.bear.more.c.b(r2, r5);
        this.isLoading = true;
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).X(new f0(q.a(r2), q.getType(r2), r3, 1, new b(this, r2, r3, r20)));
        if ((r2 instanceof oj5.a) == false) goto L17;
        Bundle r6 = getHost().getHostFragment().getArguments();
        oj5.a r4 = (oj5.a) r2;
        String r7 = r4.c;
        int r8 = r4.getType();
        String r9 = r4.b();
        if (r3 == false) goto L13;
        String r10 = "follow_comment_open";
    L14:
        com.bytedance.ee.bear.more.c.c(new i(r6, r7, r8, false, r9, r10, "none", "", "", r2 instanceof f, r4.k, r4.r, r4.isOwner(), r4.L()));
        return;
    L13:
        r10 = "follow_comment_close";
        goto L14
    L17:
        return;
    L7:
        r5 = "remove_subscribe_comment";
        goto L8
    }

    public static final /* synthetic */ void access$notifyItemChange(SubscribeCommentItemV2 r0, ISwitchMoreItem.a r1) {
        r0.notifyItemChange(r1);
    }

    public static final /* synthetic */ void access$setLoading$p(SubscribeCommentItemV2 r0, boolean r1) {
        r0.isLoading = r1;
    }
}
