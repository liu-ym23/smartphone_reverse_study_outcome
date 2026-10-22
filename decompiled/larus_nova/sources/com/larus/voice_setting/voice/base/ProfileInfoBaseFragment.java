package com.larus.voice_setting.voice.base;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0012\u001a\u00020\u0013J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H&J\u0006\u0010\u0018\u001a\u00020\u0013J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0013H\u0002J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u0005J\u0006\u0010 \u001a\u00020\u0013J\u0006\u0010!\u001a\u00020\u0013J\u0006\u0010\"\u001a\u00020\u0005J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0005H\u0004J\b\u0010%\u001a\u00020\u0013H\u0016J\b\u0010&\u001a\u00020\u0013H\u0016J\b\u0010'\u001a\u00020\u0013H\u0016J\b\u0010(\u001a\u00020\u0013H\u0016J\b\u0010)\u001a\u00020\u0013H\u0016J\b\u0010*\u001a\u00020\u0013H\u0016J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020-H\u0016J\u0014\u0010.\u001a\u00020\u00132\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0017H\u0016J\u0014\u00100\u001a\u00020\u00132\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\r\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u00061"}, d2 = {"Lcom/larus/voice_setting/voice/base/ProfileInfoBaseFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "isCreate", "", "itemCount", "", "listener", "Landroid/view/View$OnLayoutChangeListener;", "resumeFromCreate", "handler", "Landroid/os/Handler;", "markEnterForeground", "getMarkEnterForeground", "()Z", "setMarkEnterForeground", "(Z)V", "setupLayoutChangeListener", "", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "tag", "", "refreshAppbarLayoutScrollStatus", "scrollStatusChanged", "()Ljava/lang/Boolean;", "resetScrollStatusChanged", "scrollStatus", "enableScroll", "enable", BasicTestActionHandler.TEST_ACTION_RESET, "scrollToTop", "scrollToNormal", "isAppBarExpand", "setTabPagerSwipeEnabled", "enabled", "onPause", "onStop", "onResume", "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "onLeaveMineTab", "onStateChange", "state", "Lcom/larus/voice_setting/voice/base/AppBarLayoutStateListener$State;", "onEnterMineTab", "previousPage", "updatePreviousPage", "flow-voice-setting-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ProfileInfoBaseFragment extends Fragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f376363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f376364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f376365f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f376366g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handler f376367h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f376368i;

    public static final class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProfileInfoBaseFragment f376369a;

        public a(ProfileInfoBaseFragment r100) {
            this.f376369a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            ProfileInfoBaseFragment r109 = this.f376369a;
            if (r109.f376363d == false) goto L10;
            FLogger.f375446a.i(r109.tag(), "[onLayoutChange][CREATE]");
            RecyclerView r110 = this.f376369a.getRecyclerView();
            if (r110 == null) goto L9;
            RecyclerView.Adapter r111 = r110.getAdapter();
            if (r111 == null) goto L9;
            this.f376369a.f376364e = r111.getItemCount();
        L9:
            final ProfileInfoBaseFragment r112 = this.f376369a;
            r112.f376367h.post(new j0(r112));
            this.f376369a.f376363d = false;
            return;
        L10:
            ActivityResultCaller r113 = r109.getParentFragment();
            com.larus.voice_setting.voice.base.a r114 = null;
            if ((r113 instanceof com.larus.voice_setting.voice.base.a) == false) goto L13;
            com.larus.voice_setting.voice.base.a r115 = (com.larus.voice_setting.voice.base.a) r113;
        L14:
            if (r115 == null) goto L16;
            Boolean r116 = Boolean.valueOf(r115.kt());
        L17:
            Boolean r117 = Boolean.TRUE;
            if (Intrinsics.areEqual(r116, r117) == false) goto L27;
            Lifecycle.State r118 = this.f376369a.getViewLifecycleOwner().getLifecycle().getCurrentState();
            FLogger.f375446a.i(this.f376369a.tag(), "[onLayoutChange][RESET] state:" + r118);
            if (r118 != Lifecycle.State.RESUMED) goto L22;
            this.f376369a.f376367h.removeCallbacksAndMessages(null);
            final ProfileInfoBaseFragment r119 = this.f376369a;
            r119.f376367h.post(new j0(r119));
        L22:
            ActivityResultCaller r120 = this.f376369a.getParentFragment();
            if ((r120 instanceof com.larus.voice_setting.voice.base.a) == false) goto L25;
            r114 = (com.larus.voice_setting.voice.base.a) r120;
        L25:
            if (r114 == null) goto L47;
            r114.UM();
            return;
        L47:
            return;
        L27:
            RecyclerView r121 = this.f376369a.getRecyclerView();
            if (r121 == null) goto L32;
            RecyclerView.Adapter r122 = r121.getAdapter();
            if (r122 == null) goto L32;
            int r123 = r122.getItemCount();
        L33:
            ProfileInfoBaseFragment r124 = this.f376369a;
            if (r123 > r124.f376364e) goto L36;
        L37:
            ProfileInfoBaseFragment r125 = this.f376369a;
            if (r123 < r125.f376364e) goto L40;
            return;
        L40:
            if (Intrinsics.areEqual(r125.W90(), r117) == false) goto L50;
        L41:
            FLogger.f375446a.i(this.f376369a.tag(), "[onLayoutChange][COUNT] item: " + this.f376369a.f376364e + ", total: " + r123);
            if (Intrinsics.areEqual(this.f376369a.W90(), r117) == false) goto L44;
            this.f376369a.Ol(false, true);
            return;
        L44:
            this.f376369a.V90();
            return;
        L50:
            return;
        L36:
            if (Intrinsics.areEqual(r124.W90(), Boolean.FALSE) == true) goto L41;
        L32:
            r123 = 0;
            goto L33
        L16:
            r116 = null;
            goto L17
        L13:
            r115 = null;
            goto L14
        }
    }

    public void S90(String r100) {
    }

    public void T90() {
    }

    public void U90(AppBarLayoutStateListener.State r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    public void Y90(String r100) {
    }

    public abstract RecyclerView getRecyclerView();

    public abstract String tag();

    public final void X90() {
        this.f376365f = new a(this);
        RecyclerView r100 = getRecyclerView();
        if (r100 == null) goto L6;
        r100.addOnLayoutChangeListener(this.f376365f);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        FLogger.f375446a.i(tag(), "[onDestroy]");
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        FLogger.f375446a.i(tag(), "[onDestroyView]");
        RecyclerView r100 = getRecyclerView();
        if (r100 == null) goto L5;
        r100.removeOnLayoutChangeListener(this.f376365f);
    L5:
        this.f376363d = true;
        this.f376364e = 0;
        this.f376366g = true;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        FLogger.f375446a.i(tag(), "[onPause]");
        Ol(false, true);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        FLogger.f375446a.i(tag(), "[onResume]");
        super.onResume();
        if (this.f376366g == true) goto L5;
        V90();
        return;
    L5:
        if (Intrinsics.areEqual(W90(), Boolean.FALSE) == false) goto L7;
        V90();
    L7:
        this.f376366g = false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        FLogger.f375446a.i(tag(), "[onStop]");
        super.onStop();
    }

    public ProfileInfoBaseFragment() {
        this.f376363d = true;
        this.f376366g = true;
        this.f376367h = new Handler(Looper.getMainLooper());
    }

    public final void V90() {
        RecyclerView r100 = getRecyclerView();
        if (r100 == null) goto L7;
        RecyclerView.Adapter r101 = r100.getAdapter();
        if (r101 == null) goto L7;
        this.f376364e = r101.getItemCount();
    L7:
        RecyclerView r102 = getRecyclerView();
        if (r102 == null) goto L55;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        RecyclerView.Adapter r103 = r102.getAdapter();
        if (r103 == null) goto L12;
        int r104 = r103.getItemCount();
    L13:
        boolean r105 = true;
        Boolean r106 = null;
        if ((r102.getLayoutManager() instanceof LinearLayoutManager) == false) goto L33;
        RecyclerView.LayoutManager r107 = r102.getLayoutManager();
        if ((r107 instanceof LinearLayoutManager) == false) goto L18;
        LinearLayoutManager r108 = (LinearLayoutManager) r107;
    L19:
        if (r108 == null) goto L52;
        int r109 = r108.findLastCompletelyVisibleItemPosition();
        FLogger.f375446a.i("checkEnableScroll", "[refreshAppbarLayoutScrollStatus]LinearLayoutManager last: " + r109 + ", total: " + r104);
        if (r109 != (-1)) goto L27;
        if (r104 > 0) goto L25;
        r105 = false;
    L25:
        Boolean r110 = Boolean.valueOf(r105);
    L31:
        r106 = r110;
        goto L52
    L27:
        if (r109 < (r104 - 1)) goto L30;
        r105 = false;
    L30:
        r110 = Boolean.valueOf(r105);
    L52:
        if (r106 == null) goto L56;
        Ol(r106.booleanValue(), false);
        return;
    L56:
        return;
    L18:
        r108 = null;
        goto L19
    L33:
        if ((r102.getLayoutManager() instanceof StaggeredGridLayoutManager) == false) goto L52;
        RecyclerView.LayoutManager r111 = r102.getLayoutManager();
        if ((r111 instanceof StaggeredGridLayoutManager) == false) goto L37;
        StaggeredGridLayoutManager r112 = (StaggeredGridLayoutManager) r111;
    L38:
        if (r112 == null) goto L52;
        int[] r113 = r112.findLastCompletelyVisibleItemPositions(null);
        if (r113 == null) goto L52;
        int r114 = ArraysKt.last(r113);
        FLogger.f375446a.i("checkEnableScroll", "[refreshAppbarLayoutScrollStatus]StaggeredGridLayoutManager last: " + r114 + ", total: " + r104);
        if (r114 != (-1)) goto L48;
        if (r104 > 0) goto L46;
        r105 = false;
    L46:
        r110 = Boolean.valueOf(r105);
        goto L31
    L48:
        if (r114 < (r104 - 1)) goto L51;
        r105 = false;
    L51:
        r110 = Boolean.valueOf(r105);
        goto L31
    L37:
        r112 = null;
        goto L38
    L12:
        r104 = 0;
        goto L13
    }

    public final Boolean W90() {
        ActivityResultCaller r100 = getParentFragment();
        if ((r100 instanceof com.larus.voice_setting.voice.base.a) == false) goto L5;
        com.larus.voice_setting.voice.base.a r101 = (com.larus.voice_setting.voice.base.a) r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return Boolean.valueOf(r101.tz());
    L5:
        r101 = null;
        goto L6
    }

    public final void Ol(boolean r100, boolean r101) {
        ActivityResultCaller r102 = getParentFragment();
        if ((r102 instanceof com.larus.voice_setting.voice.base.a) == false) goto L5;
        com.larus.voice_setting.voice.base.a r103 = (com.larus.voice_setting.voice.base.a) r102;
    L6:
        if (r103 == null) goto L9;
        r103.Ol(r100, r101);
        return;
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
