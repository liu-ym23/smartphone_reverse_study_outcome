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
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oj5.c;
import oj5.f;

/* JADX INFO: loaded from: classes18.dex */
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubscribeCommentItemV2 f234596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f234597b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f234598c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ISwitchMoreItem.a f234599d;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SubscribeCommentItemV2 f234600a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ c f234601b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ boolean f234602c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ISwitchMoreItem.a f234603d;

            public a(SubscribeCommentItemV2 r100, c r101, boolean r102, ISwitchMoreItem.a r103) {
                this.f234600a = r100;
                this.f234601b = r101;
                this.f234602c = r102;
                this.f234603d = r103;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SubscribeCommentItemV2.access$setLoading$p(this.f234600a, false);     // Catch: Throwable -> L4
                this.f234601b.G(this.f234602c);     // Catch: Throwable -> L4
                SubscribeCommentItemV2.access$notifyItemChange(this.f234600a, this.f234603d);     // Catch: Throwable -> L4
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
            m.a(new com.bytedance.ee.bear.more.itemv2.a(this.f234596a, this.f234599d));
        }

        @Override // com.bytedance.ee.bear.contract.c0.e
        public final void onSuccess() {
            m.a(new a(this.f234596a, this.f234597b, this.f234598c, this.f234599d));
        }

        public b(SubscribeCommentItemV2 r100, c r101, boolean r102, ISwitchMoreItem.a r103) {
            this.f234596a = r100;
            this.f234597b = r101;
            this.f234598c = r102;
            this.f234599d = r103;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return R.drawable.ud_icon_comment_subscribe_outlined;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return R.color.icon_n1;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return "subscribeComment";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(R.string.LarkCCM_Docs_FollowComments_Menu_Mob);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ILoadingSwitchMoreItem
    public boolean isCheck() {
        c r100 = getMoreInfo();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.P();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        if ((getMoreInfo() instanceof oj5.a) == false) goto L20;
        c r100 = getMoreInfo();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.more.export.DocMoreInfo");
        oj5.a r101 = (oj5.a) r100;
        if (r101.f523545p == false) goto L7;
        return false;
    L7:
        boolean r102 = com.bytedance.ee.bear.appsetting.c.a.f206237a.i("ccm.docs.follow_comment_enable", false);
        if (r101.i() != 2) goto L10;
    L13:
        boolean r103 = true;
    L14:
        boolean r104 = r101.f523538i.f234420b.isOwner();
        if (r102 == false) goto L21;
        if (r103 == false) goto L22;
        if (r104 == true) goto L23;
        return true;
    L23:
        return false;
    L22:
        return false;
    L21:
        return false;
    L10:
        if (r101.i() == 22) goto L13;
        r103 = false;
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
        boolean r101 = !r100.P();
        if (r101 == false) goto L7;
        String r102 = "add_subscribe_comment";
    L8:
        com.bytedance.ee.bear.more.c.b(r100, r102);
        this.isLoading = true;
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).X(new f0(q.a(r100), q.getType(r100), r101, 1, new b(this, r100, r101, r210)));
        if ((r100 instanceof oj5.a) == false) goto L17;
        Bundle r103 = getHost().getHostFragment().getArguments();
        oj5.a r104 = (oj5.a) r100;
        String r105 = r104.f523532c;
        int r106 = r104.getType();
        String r107 = r104.b();
        if (r101 == false) goto L13;
        String r108 = "follow_comment_open";
    L14:
        com.bytedance.ee.bear.more.c.c(new i(r103, r105, r106, false, r107, r108, "none", "", "", r100 instanceof f, r104.f523540k, r104.f523547r, r104.isOwner(), r104.L()));
        return;
    L13:
        r108 = "follow_comment_close";
        goto L14
    L17:
        return;
    L7:
        r102 = "remove_subscribe_comment";
        goto L8
    }

    public static final /* synthetic */ void access$notifyItemChange(SubscribeCommentItemV2 r100, ISwitchMoreItem.a r101) {
        r100.notifyItemChange(r101);
    }

    public static final /* synthetic */ void access$setLoading$p(SubscribeCommentItemV2 r100, boolean r101) {
        r100.isLoading = r101;
    }
}
