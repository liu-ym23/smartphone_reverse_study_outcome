package f55;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.drive.biz.extra_info.LikeCircleImageView;
import com.bytedance.ee.bear.drive.biz.extra_info.LikeInfoView;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import w55.n;

/* JADX INFO: loaded from: classes16.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LikeInfoView f475637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LikeCircleImageView f475638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ee.bear.drive.report.c f475639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AccountService$Account f475640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f475641e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f475642f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f475643g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f475644h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DriveViewModel f475645i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Boolean f475646j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<String> f475647k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HashMap<String, String> f475648l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f475649m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final f55.a f475650n;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f475651a;

        public a(f r100) {
            this.f475651a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LikeInfoView.LikeState r101 = this.f475651a.f475637a.getState();
            tt5.a.k("LikeWrapper", "onClick: state" + r101);
            int r102 = b.f475652a[r101.ordinal()];
            if (r102 != 1) goto L5;
            f r103 = this.f475651a;
            r103.getClass();
            r103.f475641e.add(((hg5.b) org.koin.java.a.a(hg5.b.class)).f(r103.f475644h, new h(r103)));
            f r104 = this.f475651a;
            r104.f475639c.y(r104.f475644h, "cancel_praise");
        L9:
            this.f475651a.f475639c.m((f85.a) this.f475651a.f475645i.getFileModel(), IStrategyStateSupplier.KEY_INFO_LIKE, "none");
            return;
        L5:
            if (r102 != 2) goto L9;
            f r105 = this.f475651a;
            r105.getClass();
            r105.f475641e.add(((hg5.b) org.koin.java.a.a(hg5.b.class)).h(r105.f475644h, new j(r105)));
            f r106 = this.f475651a;
            r106.f475639c.y(r106.f475644h, "confirm_praise");
            goto L9
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f475652a = null;

        static {
            int[] r100 = new int[LikeInfoView.LikeState.values().length];
            f475652a = r100;
            r100[LikeInfoView.LikeState.LIKED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f475652a[LikeInfoView.LikeState.UNLIKE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static void a(f r100) {
        Toast.showFailureText(r100.f475637a.getContext(), r100.f475637a.getResources().getString(R.string.Drive_Drive_LikeFail), 1);
    }

    public static void b(f r100, boolean r101) {
        String r102 = r100.f475640d.avatarUrl;
        String r103 = r100.f475638b.getCurrentAvatarMap().get(r100.f475640d.uid);
        List<String> r104 = r100.f475638b.getCurrentAvatarList();
        if (r101 == false) goto L11;
        if (r104 != null) goto L7;
        r104 = new ArrayList();
    L7:
        if (r104.contains(r102) == false) goto L9;
    L19:
        r100.c(r104, null);
        return;
    L9:
        if (r104.contains(r103) == true) goto L19;
        ListProtector.add(r104, 0, r102);
        goto L19
    L11:
        if (r104 != null) goto L13;
    L15:
        if (r104 == null) goto L19;
        if (r104.contains(r103) == false) goto L19;
        r104.remove(r103);
        goto L19
    L13:
        if (r104.contains(r102) == false) goto L15;
        r104.remove(r102);
        goto L15
    }

    public final void c(List<String> r100, HashMap<String, String> r101) {
        this.f475647k = r100;
        this.f475648l = r101;
        int r102 = com.bytedance.ee.bear.middleground.permission.b.f233101a;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.i("ccm.permission.set_user_restricted_client", false) != true) goto L5;
        boolean r103 = this.f475646j.booleanValue();
    L6:
        Boolean r104 = Boolean.valueOf(r103);
        this.f475646j = r104;
        if (r104 == null) goto L29;
        if (r100 != null) goto L11;
        return;
    L11:
        if (r104.booleanValue() == false) goto L15;
        this.f475638b.d(r100);
        if (r101 == null) goto L30;
        this.f475638b.f222966e = r101;
        return;
    L30:
        return;
    L15:
        this.f475638b.d(r100);
        LikeCircleImageView r105 = this.f475638b;
        r105.getClass();
        if (n.f558339d == false) goto L22;
        if (hu5.a.d(r105.f222965d) == true) goto L34;
        int r106 = r105.a(1);
        FrameLayout r107 = r105.f222964c;
        com.bytedance.ee.util.ui.g.c(r107, r107.getWidth(), r106).setDuration(150).start();
        r105.f222962a.setVisibility(0);
        r105.f222963b.setVisibility(8);
        r105.f222962a.setImageResource(R.drawable.facade_common_avatar_default_person);
        return;
    L34:
        return;
    L22:
        if (hu5.a.d(r105.f222965d) == false) goto L25;
        return;
    L25:
        if (r105.f222964c.getWidth() != 0) goto L27;
        int r108 = r105.getResources().getDimensionPixelSize(R.dimen.drive_like_file_circle_view);
        com.bytedance.ee.util.ui.g.c(r105.f222964c, 0, r108).setDuration(150).start();
    L27:
        r105.f222962a.setVisibility(0);
        r105.f222963b.setVisibility(8);
        r105.f222962a.setImageResource(R.drawable.facade_common_avatar_default_person);
        return;
    L29:
        return;
    L5:
        r103 = true;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [f55.a] */
    public f(DriveViewModel r100, LikeInfoView r101, LikeCircleImageView r102) {
        this.f475641e = new CompositeDisposable();
        this.f475646j = Boolean.TRUE;
        this.f475647k = null;
        this.f475648l = null;
        this.f475649m = new a(this);
        this.f475650n = new f55.a(this);
        this.f475645i = r100;
        this.f475644h = r100.getOpenEntity().getFileId();
        NetService r103 = (NetService) org.koin.java.a.a(NetService.class);
        this.f475640d = ((h0) org.koin.java.a.a(h0.class)).G2();
        this.f475638b = r102;
        this.f475637a = r101;
        this.f475639c = o75.b.a().Ke();
        boolean r104 = ((b0) org.koin.java.a.a(b0.class)).b();
        this.f475643g = r104;
        if (r104 == false) goto L5;
        r102.setVisibility(8);
        r101.setVisibility(8);
    L5:
        r101.b(0);
        r101.c(false);
        r102.d(new ArrayList());
        r102.f222966e = new HashMap();
    }
}
