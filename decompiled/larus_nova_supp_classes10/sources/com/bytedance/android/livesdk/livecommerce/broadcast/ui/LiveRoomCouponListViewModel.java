package com.bytedance.android.livesdk.livecommerce.broadcast.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.model.g;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseViewModel;
import com.bytedance.android.livesdk.livecommerce.broadcast.bindcoupon.ui.ECBindCouponFragment;
import com.bytedance.android.livesdk.livecommerce.broadcast.viewbinder.LiveRoomNewCouponViewBinder;
import com.bytedance.android.livesdk.livecommerce.event.c2;
import com.bytedance.android.livesdk.livecommerce.event.w1;
import com.bytedance.android.livesdk.livecommerce.event.x1;
import com.bytedance.android.livesdk.livecommerce.multitype.MultiTypeAdapter;
import com.bytedance.android.livesdk.livecommerce.room.controller.CoreRequests;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import com.bytedance.android.livesdk.livecommerce.utils.x;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sg2.h;
import si2.p;
import vi2.m;
import vi2.v0;
import xi2.l;
import xi2.n;
import xi2.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class LiveRoomCouponListViewModel extends ECBaseViewModel implements dh2.a.InterfaceC0136a, com.bytedance.android.livesdk.livecommerce.view.countdown.e.a, LiveRoomNewCouponViewBinder.a {
    public static final int MSG_DISMISS_END_COUPON_GUIDE = 2;
    public static final int MSG_DISMISS_FUNCTION_GUIDE = 1;
    private MutableLiveData<Pair<Integer, Integer>> mAdapterAppendData;
    private MutableLiveData<Void> mAdapterChangeData;
    private String mAnchorId;
    private dh2.a mBindCouponManager;
    private WeakReference<Context> mContextWeakReference;
    private String mCouponBindNotice;
    private String mCouponCipherText;
    private ch2.a mCouponDataHelper;
    private MutableLiveData<String> mCouponDetailGuideData;
    private String mCouponExplain;
    private int mCurrentPage;
    private MutableLiveData<Void> mDismissFunctionGuideData;
    private MutableLiveData<p> mDistributeCouponData;
    private h mDistributeCouponManager;
    private v0<xi2.p> mDistributeCouponResponseIApiObserver;
    private MutableLiveData<xi2.p> mDistributeResponse;
    private MutableLiveData<View> mEndCouponGuideData;
    private String mEndCouponHint;
    private String mEndCouponToast;
    private v0<r> mEndDistributeCouponResponseIApiObserver;
    private String mEnterFrom;
    private MutableLiveData<Void> mFullLoadingData;
    private MutableLiveData<Void> mFullLoadingFinishData;
    private boolean mHasMore;
    private String mRoomId;
    private MutableLiveData<Integer> mScrollData;
    private long mStartDistributeTime;
    private String mWillDistributeCouponId;

    public class a implements v0<n> {
        public final /* synthetic */ f a;
        public final /* synthetic */ LiveRoomCouponListViewModel b;

        @Override // vi2.v0
        public final void onError(Throwable r3) {
            LiveRoomCouponListFragment r4 = ((com.bytedance.android.livesdk.livecommerce.broadcast.ui.a) this.a).a.a;
            r4.r.setText(th.a.g(r4.getContext(), 2131896731));
        }

        @Override // vi2.v0
        public final void onSuccess(n r6) {
            n r7 = r6;
            if (((g) r7).statusCode != 0) goto L13;
            LiveRoomCouponListViewModel.access$002(this.b, r7.hasMore);
            LiveRoomCouponListViewModel.access$102(this.b, r7.page + 1);
            int r0 = ((ArrayList) LiveRoomCouponListViewModel.access$200(this.b).a).size();
            ch2.a r1 = LiveRoomCouponListViewModel.access$200(this.b);
            r1.getClass();
            List<l> r2 = r7.couponList;
            if (r2 == null) goto L10;
            Iterator<l> r3 = r2.iterator();
        L8:
            if (r3.hasNext() == false) goto L10;
            p r4 = k.b(r3.next());
            ((ArrayList) r1.a).add(r4);
        L10:
            int r8 = r7.couponList.size();
            this.b.getAdapterAppendData().postValue(new Pair(Integer.valueOf(r0), Integer.valueOf(r8)));
            LiveRoomCouponListFragment r9 = ((com.bytedance.android.livesdk.livecommerce.broadcast.ui.a) this.a).a.a;
            r9.r.setText(th.a.g(r9.getContext(), 2131896731));
            return;
        }

        public a(LiveRoomCouponListViewModel r1, f r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements v0<n> {
        public final /* synthetic */ LiveRoomCouponListViewModel a;

        public b(LiveRoomCouponListViewModel r1) {
            this.a = r1;
        }

        @Override // vi2.v0
        public final void onError(Throwable r2) {
            this.a.getLoadingErrorData().postValue(null);
        }

        @Override // vi2.v0
        public final void onSuccess(n r8) {
            n r9 = r8;
            int r0 = ((g) r9).statusCode;
            if (r0 != 0) goto L36;
            n.a r1 = r9.extra;
            if (r1 == null) goto L7;
            LiveRoomCouponListViewModel.access$302(this.a, r1.couponBindNotice);
            LiveRoomCouponListViewModel.access$402(this.a, r9.extra.couponCipherText);
            LiveRoomCouponListViewModel.access$502(this.a, r9.extra.endCouponToast);
            LiveRoomCouponListViewModel.access$602(this.a, r9.extra.endCouponNotice);
        L7:
            LiveRoomCouponListViewModel.access$002(this.a, r9.hasMore);
            boolean r3 = true;
            LiveRoomCouponListViewModel.access$102(this.a, r9.page + 1);
            LiveRoomCouponListViewModel.access$702(this.a, r9.couponExplain);
            LiveRoomCouponListViewModel.access$200(this.a).a(r9);
            this.a.getAdapterChangeData().postValue(null);
            this.a.getLoadingFinishData().postValue(null);
            if (LiveRoomCouponListViewModel.access$800(this.a) == null) goto L30;
            Context r2 = (Context) LiveRoomCouponListViewModel.access$800(this.a).get();
            if (r2 == null) goto L30;
            SharedPreferences r4 = x.b(r2);
            if (r4 != null) goto L14;
        L16:
            boolean r5 = false;
        L17:
            if (r5 == true) goto L30;
            n.a r6 = r9.extra;
            if (r6 == null) goto L30;
            if (TextUtils.isEmpty(r6.couponDetailNotice) == true) goto L30;
            this.a.getCouponDetailGuideData().postValue(r9.extra.couponDetailNotice);
            SharedPreferences r10 = x.b(r2);
            if (r10 == null) goto L30;
            if (TextUtils.isEmpty("ec_coupon_detail_guide") == true) goto L30;
            SharedPreferences.Editor r11 = r10.edit();
            if (r11 == null) goto L30;
            r11.putBoolean("ec_coupon_detail_guide", true);
            r11.apply();
            goto L30
        L14:
            if (TextUtils.isEmpty("ec_coupon_detail_guide") == true) goto L16;
            r5 = r4.getBoolean("ec_coupon_detail_guide", false);
        L30:
            if (LiveRoomCouponListViewModel.access$900(this.a).a == 2) goto L33;
            r3 = false;
        L33:
            if (r3 == false) goto L42;
            this.a.getFullLoadingData().postValue(null);
            LiveRoomCouponListViewModel.access$1002(this.a, new com.bytedance.android.livesdk.livecommerce.broadcast.ui.c(this));
            h r12 = LiveRoomCouponListViewModel.access$900(this.a);
            v0 r7 = LiveRoomCouponListViewModel.access$1000(this.a);
            r12.getClass();
            r12.b = new WeakReference(r7);
            return;
        L42:
            return;
        L36:
            if (r0 == 11272) goto L38;
        L40:
            this.a.getLoadingErrorData().postValue(null);
            return;
        L38:
            if (((g) r9).statusMessage == null) goto L40;
            this.a.getPermissionDeniedData().postValue(((g) r9).statusMessage);
        }
    }

    public class c implements v0<r> {
        public final /* synthetic */ LiveRoomCouponListViewModel a;

        public c(LiveRoomCouponListViewModel r1) {
            this.a = r1;
        }

        @Override // vi2.v0
        public final void onError(Throwable r2) {
            this.a.getFullLoadingFinishData().postValue(null);
            LiveRoomCouponListViewModel.access$1500(this.a);
            LiveRoomCouponListViewModel.access$1402(this.a, null);
        }

        @Override // vi2.v0
        public final void onSuccess(r r2) {
            this.a.getFullLoadingFinishData().postValue(null);
            LiveRoomCouponListViewModel.access$1300(this.a);
            LiveRoomCouponListViewModel.access$1402(this.a, null);
        }
    }

    public class d implements v0<xi2.p> {
        public final /* synthetic */ LiveRoomCouponListViewModel a;

        public d(LiveRoomCouponListViewModel r1) {
            this.a = r1;
        }

        @Override // vi2.v0
        public final void onError(Throwable r2) {
            this.a.getFullLoadingFinishData().postValue(null);
            LiveRoomCouponListViewModel.access$1200(this.a);
            LiveRoomCouponListViewModel.access$1002(this.a, null);
        }

        @Override // vi2.v0
        public final void onSuccess(xi2.p r2) {
            MutableLiveData<xi2.p> r0 = this.a.getDistributeResponse();
            r0.postValue(r2);
            this.a.getFullLoadingFinishData().postValue(null);
            LiveRoomCouponListViewModel.access$1100(this.a);
            LiveRoomCouponListViewModel.access$1002(this.a, null);
        }
    }

    public class e implements v0<n> {
        public final /* synthetic */ LiveRoomCouponListViewModel a;

        public e(LiveRoomCouponListViewModel r1) {
            this.a = r1;
        }

        @Override // vi2.v0
        public final void onError(Throwable r2) {
            this.a.getFullLoadingFinishData().postValue(null);
            this.a.getToastInt().postValue(2131896712);
        }

        @Override // vi2.v0
        public final void onSuccess(n r4) {
            n r5 = r4;
            int r0 = ((g) r5).statusCode;
            if (r0 != 0) goto L6;
            this.a.getFullLoadingFinishData().postValue(null);
            LiveRoomCouponListViewModel.access$702(this.a, r5.couponExplain);
            LiveRoomCouponListViewModel.access$200(this.a).a(r5);
            this.a.getAdapterChangeData().postValue(null);
            LiveRoomCouponListViewModel.access$002(this.a, r5.hasMore);
            return;
        L6:
            if (r0 == 11272) goto L8;
        L10:
            this.a.getFullLoadingFinishData().postValue(null);
            this.a.getToastInt().postValue(2131896712);
            return;
        L8:
            if (((g) r5).statusMessage == null) goto L10;
            this.a.getPermissionDeniedData().postValue(((g) r5).statusMessage);
        }
    }

    public interface f {
    }

    private void onCouponDistributeFail() {
        this.mWillDistributeCouponId = null;
        getAdapterChangeData().postValue(null);
    }

    private void onCouponDistributeSuccess() {
        this.mWillDistributeCouponId = null;
        h r1 = this.mDistributeCouponManager;
        p r2 = r1.d;
        if (r2 == null) goto L5;
        r2.l = 1;
        r1.d = null;
    L5:
        getFullLoadingFinishData().postValue(null);
        getAdapterChangeData().postValue(null);
    }

    private void onEndDistributeFailed() {
        this.mWillDistributeCouponId = null;
    }

    private void onEndDistributeSuccess() {
        this.mWillDistributeCouponId = null;
        h r1 = this.mDistributeCouponManager;
        p r2 = r1.d;
        if (r2 == null) goto L5;
        r2.l = 0;
        r1.d = null;
    L5:
        getFullLoadingFinishData().postValue(null);
        getAdapterChangeData().postValue(null);
    }

    public void cancelDistributeCoupon() {
        this.mWillDistributeCouponId = null;
    }

    public MutableLiveData<Pair<Integer, Integer>> getAdapterAppendData() {
        if (this.mAdapterAppendData != null) goto L6;
        this.mAdapterAppendData = new MutableLiveData();
    L6:
        return this.mAdapterAppendData;
    }

    public MutableLiveData<Void> getAdapterChangeData() {
        if (this.mAdapterChangeData != null) goto L6;
        this.mAdapterChangeData = new MutableLiveData();
    L6:
        return this.mAdapterChangeData;
    }

    public MutableLiveData<String> getCouponDetailGuideData() {
        if (this.mCouponDetailGuideData != null) goto L6;
        this.mCouponDetailGuideData = new MutableLiveData();
    L6:
        return this.mCouponDetailGuideData;
    }

    public MutableLiveData<Void> getDismissFunctionGuideData() {
        if (this.mDismissFunctionGuideData != null) goto L6;
        this.mDismissFunctionGuideData = new MutableLiveData();
    L6:
        return this.mDismissFunctionGuideData;
    }

    public MutableLiveData<p> getDistributeCouponData() {
        if (this.mDistributeCouponData != null) goto L6;
        this.mDistributeCouponData = new MutableLiveData();
    L6:
        return this.mDistributeCouponData;
    }

    public MutableLiveData<xi2.p> getDistributeResponse() {
        if (this.mDistributeResponse != null) goto L6;
        this.mDistributeResponse = new MutableLiveData();
    L6:
        return this.mDistributeResponse;
    }

    public MutableLiveData<View> getEndCouponGuideData() {
        if (this.mEndCouponGuideData != null) goto L6;
        this.mEndCouponGuideData = new MutableLiveData();
    L6:
        return this.mEndCouponGuideData;
    }

    public MutableLiveData<Void> getFullLoadingData() {
        if (this.mFullLoadingData != null) goto L6;
        this.mFullLoadingData = new MutableLiveData();
    L6:
        return this.mFullLoadingData;
    }

    public MutableLiveData<Void> getFullLoadingFinishData() {
        if (this.mFullLoadingFinishData != null) goto L6;
        this.mFullLoadingFinishData = new MutableLiveData();
    L6:
        return this.mFullLoadingFinishData;
    }

    public MutableLiveData<Integer> getScrollData() {
        if (this.mScrollData != null) goto L6;
        this.mScrollData = new MutableLiveData();
    L6:
        return this.mScrollData;
    }

    public LiveRoomCouponListViewModel() {
        this.mAdapterChangeData = null;
        this.mAdapterAppendData = null;
        this.mScrollData = null;
        this.mDistributeCouponData = null;
        this.mFullLoadingData = null;
        this.mFullLoadingFinishData = null;
        this.mCouponDetailGuideData = null;
        this.mDismissFunctionGuideData = null;
        this.mEndCouponGuideData = null;
        this.mDistributeResponse = null;
        this.mDistributeCouponManager = h.a.a;
        this.mCouponDataHelper = new ch2.a();
        this.mEnterFrom = "";
    }

    private void refreshData() {
        getFullLoadingData().postValue(null);
        CompositeDisposable r0 = CoreRequests.a;
        CoreRequests.b(this.mRoomId, this.mAnchorId, this.mEnterFrom, 0, new e(this));
    }

    private void requestData() {
        getLoadingData().postValue(null);
        CompositeDisposable r0 = CoreRequests.a;
        CoreRequests.b(this.mRoomId, this.mAnchorId, this.mEnterFrom, 0, new b(this));
    }

    public void clickRetry() {
        requestData();
    }

    public String getCouponBindNotice() {
        return this.mCouponBindNotice;
    }

    public String getEndCouponHint() {
        return this.mEndCouponHint;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public void start() {
        requestData();
    }

    public static /* synthetic */ v0 access$1000(LiveRoomCouponListViewModel r0) {
        return r0.mDistributeCouponResponseIApiObserver;
    }

    public static /* synthetic */ void access$1100(LiveRoomCouponListViewModel r0) {
        r0.onCouponDistributeSuccess();
    }

    public static /* synthetic */ void access$1200(LiveRoomCouponListViewModel r0) {
        r0.onCouponDistributeFail();
    }

    public static /* synthetic */ void access$1300(LiveRoomCouponListViewModel r0) {
        r0.onEndDistributeSuccess();
    }

    public static /* synthetic */ void access$1500(LiveRoomCouponListViewModel r0) {
        r0.onEndDistributeFailed();
    }

    public static /* synthetic */ ch2.a access$200(LiveRoomCouponListViewModel r0) {
        return r0.mCouponDataHelper;
    }

    public static /* synthetic */ WeakReference access$800(LiveRoomCouponListViewModel r0) {
        return r0.mContextWeakReference;
    }

    public static /* synthetic */ h access$900(LiveRoomCouponListViewModel r0) {
        return r0.mDistributeCouponManager;
    }

    public void bindCoupon(FragmentManager r8) {
        if (this.mBindCouponManager != null) goto L5;
        this.mBindCouponManager = new dh2.a();
    L5:
        dh2.a r0 = this.mBindCouponManager;
        String r1 = this.mRoomId;
        String r2 = this.mCouponCipherText;
        String r3 = this.mCouponBindNotice;
        String r4 = this.mAnchorId;
        r0.getClass();
        if (r8 == null) goto L19;
        ECBindCouponFragment r5 = new ECBindCouponFragment();
        Bundle r6 = new Bundle();
        r6.putString("room_id", r1);
        r6.putString("anchor_id", r4);
        r6.putString("cipher_text", r2);
        r6.putString("bind_notice", r3);
        r5.setArguments(r6);
        WeakReference<dh2.a.InterfaceC0136a> r7 = r5.x;
        if (r7 == null) goto L10;
        r7.clear();
    L10:
        r5.x = new WeakReference(this);
        LandscapeRestrictionOperation r9 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r5, "bind_coupon_fragment", r9);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r5, r9) == true) goto L20;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L14:
        r5.show(r8, "bind_coupon_fragment");
        return;
    L20:
        return;
    }

    public void bindDataAdapter(MultiTypeAdapter r3) {
        List<p> r0 = this.mCouponDataHelper.a;
        r3.getClass();
        r0.getClass();
        ui2.c r4 = r3.g;
        ((ArrayList) r4.a).clear();
        ((ArrayList) r4.b).clear();
        ((ArrayList) r4.a).add(r0);
        List<ui2.c.a> r5 = r4.b;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new ui2.b());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.broadcast.viewbinder.LiveRoomNewCouponViewBinder.a
    public void distributeCoupon(p r3) {
        if (this.mWillDistributeCouponId == null) goto L5;
        return;
    L5:
        h r0 = this.mDistributeCouponManager;
        if (r0 != null) goto L8;
    L16:
        this.mWillDistributeCouponId = r3.j;
        getDistributeCouponData().postValue(r3);
        return;
    L8:
        if (r3.l != 0) goto L16;
        if (r0.e == true) goto L16;
        if (this.mEndCouponToast == null) goto L14;
        getToastString().postValue(this.mEndCouponToast);
        return;
    L14:
        getToastInt().postValue(2131896357);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.countdown.e.a
    public void handleMsg(Message r2) {
        if (r2 == null) goto L10;
        int r3 = r2.what;
        if (r3 != 1) goto L6;
    L8:
        getDismissFunctionGuideData().postValue(null);
        return;
    L6:
        if (r3 == 2) goto L8;
        return;
    }

    @Override // dh2.a.InterfaceC0136a
    public void onBindDone(List<p> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isEmpty() == true) goto L8;
        requestData();
        getScrollData().postValue(0);
        return;
    }

    public void setEnterFrom(String r1) {
        this.mEnterFrom = r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.broadcast.viewbinder.LiveRoomNewCouponViewBinder.a
    public void showBubble(View r2) {
        getEndCouponGuideData().postValue(r2);
    }

    public static /* synthetic */ boolean access$002(LiveRoomCouponListViewModel r0, boolean r1) {
        r0.mHasMore = r1;
        return r1;
    }

    public static /* synthetic */ v0 access$1002(LiveRoomCouponListViewModel r0, v0 r1) {
        r0.mDistributeCouponResponseIApiObserver = r1;
        return r1;
    }

    public static /* synthetic */ int access$102(LiveRoomCouponListViewModel r0, int r1) {
        r0.mCurrentPage = r1;
        return r1;
    }

    public static /* synthetic */ v0 access$1402(LiveRoomCouponListViewModel r0, v0 r1) {
        r0.mEndDistributeCouponResponseIApiObserver = r1;
        return r1;
    }

    public static /* synthetic */ String access$302(LiveRoomCouponListViewModel r0, String r1) {
        r0.mCouponBindNotice = r1;
        return r1;
    }

    public static /* synthetic */ String access$402(LiveRoomCouponListViewModel r0, String r1) {
        r0.mCouponCipherText = r1;
        return r1;
    }

    public static /* synthetic */ String access$502(LiveRoomCouponListViewModel r0, String r1) {
        r0.mEndCouponToast = r1;
        return r1;
    }

    public static /* synthetic */ String access$602(LiveRoomCouponListViewModel r0, String r1) {
        r0.mEndCouponHint = r1;
        return r1;
    }

    public static /* synthetic */ String access$702(LiveRoomCouponListViewModel r0, String r1) {
        r0.mCouponExplain = r1;
        return r1;
    }

    public void endDistributeCoupon(final Context r10, p r11) {
        this.mEndDistributeCouponResponseIApiObserver = new c(this);
        h r0 = this.mDistributeCouponManager;
        v0<r> r1 = this.mEndDistributeCouponResponseIApiObserver;
        r0.getClass();
        r0.c = new WeakReference(r1);
        final h r2 = this.mDistributeCouponManager;
        String r3 = this.mRoomId;
        String r4 = r11.j;
        boolean r5 = true;
        if (r2.a == 1) goto L5;
        r5 = false;
    L6:
        if (r5 == false) goto L9;
        getFullLoadingData().postValue(null);
        c2 r12 = new c2();
        r12.f("coupon_id", r11.j);
        r12.f("anchor_id", this.mAnchorId);
        r12.d("coupon_type", r11.a);
        r12.f("room_id", this.mRoomId);
        r12.k();
        new w1(r11.j, this.mRoomId, this.mAnchorId, r11.a, SystemClock.elapsedRealtime() - this.mStartDistributeTime).k();
        return;
    L9:
        return;
    L5:
        r2.a = 2;
        String r6 = vi2.h.a;
        String r7 = vi2.h.d(si2.g.w);
        vi2.h.e(null, null, r7, new vi2.n(r3, r4, r7)).observeOn(AndroidSchedulers.mainThread()).subscribe(new sg2.f(r2, r10), new sg2.g(r2, r10));
        goto L6
    }

    public void openDistributeCouponDescFragment(Context r5, FragmentManager r6) {
        String r7 = th.a.g(r5, 2131896425);
        String r0 = this.mCouponExplain;
        ECWebFragment r1 = new ECWebFragment();
        Bundle r2 = new Bundle();
        r2.putString("title", r7);
        r2.putString("url", r0);
        r1.setArguments(r2);
        INVOKEVIRTUAL_com_bytedance_android_livesdk_livecommerce_broadcast_ui_LiveRoomCouponListViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r1, r6, "coupon_introduction_fragment");
    }

    public void realDistributeCoupon(final Context r14, p r15) {
        this.mDistributeCouponResponseIApiObserver = new d(this);
        h r0 = this.mDistributeCouponManager;
        v0<xi2.p> r1 = this.mDistributeCouponResponseIApiObserver;
        r0.getClass();
        r0.b = new WeakReference(r1);
        final h r2 = this.mDistributeCouponManager;
        final String r5 = this.mRoomId;
        final String r6 = r15.j;
        final String r7 = r15.n;
        final int r8 = r15.m;
        String r3 = this.mEnterFrom;
        if (r2.a == 1) goto L5;
        boolean r16 = false;
    L6:
        if (r16 == false) goto L13;
        getFullLoadingData().postValue(null);
        String r4 = r15.j;
        String r9 = this.mRoomId;
        String r10 = this.mAnchorId;
        int r11 = r15.a;
        if (r15.r != 1) goto L10;
        boolean r12 = true;
    L11:
        new x1(r4, r9, r10, r11, r12).k();
        this.mStartDistributeTime = SystemClock.elapsedRealtime();
        return;
    L10:
        r12 = false;
        goto L11
    L13:
        return;
    L5:
        r2.a = 2;
        String r13 = vi2.h.a;
        String r17 = vi2.h.d(si2.g.v);
        vi2.h.e(null, null, r17, new m(r5, r6, r3, r17)).observeOn(AndroidSchedulers.mainThread()).subscribe(new sg2.d(r2, r5, r6, r7, r8, r14), new sg2.e(r2, r14));
        r16 = true;
        goto L6
    }

    public void requestMore(MultiTypeAdapter r5, f r6) {
        CompositeDisposable r7 = CoreRequests.a;
        CoreRequests.b(this.mRoomId, this.mAnchorId, this.mEnterFrom, this.mCurrentPage, new a(this, r6));
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_livesdk_livecommerce_broadcast_ui_LiveRoomCouponListViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(ECWebFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        ECWebFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public void init(String r1, String r2, Context r3) {
        this.mRoomId = r1;
        this.mAnchorId = r2;
        if (r3 == null) goto L6;
        this.mContextWeakReference = new WeakReference(r3);
        return;
    }
}
