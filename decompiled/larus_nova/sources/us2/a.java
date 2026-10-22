package us2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.uikit.recyclerview.LoadMoreRecyclerViewAdapter;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.admin.api.AdminApi2;
import com.bytedance.android.livesdk.admin.ui.AdminListAdapter;
import com.bytedance.android.livesdk.chatroom.ui.LiveProfileManageDialogV2;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.android.livesdk.user.f0;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import ita.i;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f551446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f551447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f551448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f551449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f551450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LiveProfileManageDialogV2.b f551451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f551452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ud1.a f551453h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AdminListAdapter f551454i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f551455j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Long f551456k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f551457l;

    /* JADX INFO: renamed from: us2.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC7926a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f551458a;

        public ViewOnClickListenerC7926a(a r100) {
            this.f551458a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LiveProfileManageDialogV2.b r101 = this.f551458a.getClickCallback();
            if (r101 == null) goto L6;
            r101.onClick(3);
            return;
        }
    }

    public static final class b {
    }

    public static final class c implements wd1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f551459a;

        @Override // wd1.a
        public final void U1(boolean r100, Exception r101) {
        }

        @Override // wd1.a
        public final void y1(boolean r100, User r101) {
            Intrinsics.checkNotNullParameter(r101, "user");
        }

        public c(a r100) {
            this.f551459a = r100;
        }

        @Override // wd1.a
        public final void y0(td1.e r100, Exception r101) {
            a r102 = this.f551459a;
            if (r102.f551450e == true) goto L5;
            return;
        L5:
            AdminListAdapter r103 = r102.f551454i;
            if (r103 != null) goto L9;
            return;
        L9:
            if (r101 != null) goto L22;
            if (r100 == null) goto L22;
            if (CollectionUtils.isEmpty(r100.f545504a) == true) goto L20;
            ((LoadingStatusView) this.f551459a.a(R.id.room_manage_list_status_view)).reset();
            this.f551459a.getClass();
            AdminListAdapter r104 = this.f551459a.f551454i;
            Intrinsics.checkNotNull(r104);
            r104.getClass();
            List<td1.d> r105 = r100.f545504a;
            if (r105 != null) goto L17;
            return;
        L17:
            if (r105.size() <= 0) goto L29;
            ((ArrayList) r104.f103094b).clear();
            ((ArrayList) r104.f103094b).addAll(r105);
            r104.notifyDataSetChanged();
            return;
        L29:
            return;
        L20:
            View r106 = this.f551459a.a(R.id.room_manage_list_status_view);
            Intrinsics.checkNotNull(r106);
            ((LoadingStatusView) r106).showEmpty();
            return;
        L22:
            Intrinsics.checkNotNull(r103);
            if (r103.getItemCount() != 0) goto L25;
            ((LoadingStatusView) this.f551459a.a(R.id.room_manage_list_status_view)).showError();
        L25:
            ExceptionUtils.handleException(this.f551459a.getContext(), r101);
        }
    }

    public static final class d implements bd2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f551460a;

        @Override // bd2.b
        public final void C2(boolean r100) {
        }

        @Override // bd2.b
        public final void x3(boolean r100, Exception r101) {
        }

        @Override // bd2.b
        public final void hideLoading() {
            boolean r100 = this.f551460a.f551450e;
        }

        public d(a r100) {
            this.f551460a = r100;
        }

        @Override // bd2.b
        public final void H3(dd2.c r100, Exception r101) {
            boolean r102 = this.f551460a.f551450e;
        }
    }

    public static final class e implements LoadMoreRecyclerViewAdapter.ILoadMore {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f551461a;

        public e(a r100) {
            this.f551461a = r100;
        }

        @Override // com.bytedance.android.live.uikit.recyclerview.LoadMoreRecyclerViewAdapter.ILoadMore
        public final void loadMore(boolean r100) {
            this.f551461a.getClass();
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f551462a;

        public f(a r100) {
            this.f551462a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(T r100) {
            if ((r100 instanceof sd1.a) == false) goto L10;
            a r101 = this.f551462a;
            if (r100 == 0) goto L8;
            r101.onEvent((sd1.a) r100);
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.admin.event.AdminSetEvent");
        L10:
            if ((r100 instanceof cd2.a) == false) goto L17;
            a r102 = this.f551462a;
            if (r100 == 0) goto L15;
            r102.onEvent((cd2.a) r100);
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.kickout.event.BanTalkEvent");
        L17:
            if ((r100 instanceof cd2.b) == false) goto L25;
            a r103 = this.f551462a;
            if (r100 == 0) goto L22;
            r103.onEvent((cd2.b) r100);
            return;
        L22:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.kickout.event.UserKickOutEvent");
        }
    }

    static {
    }

    public final void onEvent(cd2.a r100) {
    }

    public final void onEvent(cd2.b r100) {
    }

    public final void b() {
        Context r100 = getContext();
        int r101 = i.f495747a;
        if (NetworkUtils.isNetworkAvailable(r100) == true) goto L6;
        IESUIUtils.displayToast(getContext(), R.string.ttlive_core_network_unavailable);
        return;
    L6:
        ((LoadingStatusView) a(R.id.room_manage_list_status_view)).showLoading();
        String r102 = this.f551457l;
        if (r102 == null) goto L12;
        ud1.a r103 = this.f551453h;
        if (r103 == null) goto L13;
        Intrinsics.checkNotNullParameter(r102, "userId");
        l.d().getClass();
        ((AdminApi2) com.bytedance.android.live.network.c.b().e(AdminApi2.class)).fetchAdministrators(r102, ((f0) ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h()).a(r102), o.a(((f0) ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h()).f158651a)).compose(RxUtil.rxSchedulerHelper()).subscribe(new ud1.b(r103), new ud1.c(r103));
        return;
    L13:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f551450e = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f551450e = false;
        this.f551452g.dispose();
    }

    public final LiveProfileManageDialogV2.b getClickCallback() {
        return this.f551451f;
    }

    public final View a(int r100) {
        if (this.f551446a != null) goto L5;
        this.f551446a = new LinkedHashMap();
    L5:
        View r101 = this.f551446a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f551446a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final <T> void c(Class<T> r100) {
        this.f551452g.add(xs2.b.a().b(r100).subscribe(new f(this)));
    }

    public final void onEvent(sd1.a r100) {
        if (this.f551450e == false) goto L33;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.f541421a == true) goto L35;
        AdminListAdapter r101 = this.f551454i;
        if (r101 == null) goto L36;
        Intrinsics.checkNotNull(r101);
        String r102 = r100.f541422b;
        int r103 = ((ArrayList) r101.f103094b).size();
    L10:
        r103 = r103 - 1;
        if (r103 < 0) goto L19;
        td1.d r104 = (td1.d) ListProtector.get(r101.f103094b, r103);
        if (r104 == null) goto L10;
        User r105 = r104.mUser;
        if (r105 == null) goto L10;
        if (n0.a(r105.getIdStr(), r102) == false) goto L10;
        ListProtector.remove(r101.f103094b, r103);
        r101.notifyDataSetChanged();
    L19:
        AdminListAdapter r106 = this.f551454i;
        if (r106 != null) goto L22;
        return;
    L22:
        if (r106.getItemCount() != 0) goto L38;
        View r107 = a(R.id.room_manage_list_status_view);
        Intrinsics.checkNotNull(r107);
        ((LoadingStatusView) r107).showEmpty();
        return;
    L38:
        return;
    L36:
        return;
    L35:
        return;
    }

    public final void setClickCallback(LiveProfileManageDialogV2.b r100) {
        this.f551451f = r100;
    }

    public a(Context r100, Long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f551456k = r101;
        this.f551457l = r102;
        this.f551446a = new LinkedHashMap();
        this.f551452g = new CompositeDisposable();
        this.f551455j = new c(this);
        new d(this);
        new e(this);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_dialog_room_manage_list_layout_new, this, true);
        ((LinearLayout) a(R.id.room_manage_title_back)).setOnClickListener(new ViewOnClickListenerC7926a(this));
        c(sd1.a.class);
        c(cd2.a.class);
        c(cd2.b.class);
    }
}
