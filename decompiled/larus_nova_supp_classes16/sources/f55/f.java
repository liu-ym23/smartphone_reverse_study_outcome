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
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import w55.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public final LikeInfoView a;
    public final LikeCircleImageView b;
    public final com.bytedance.ee.bear.drive.report.c c;
    public final AccountService$Account d;
    public final CompositeDisposable e;
    public String f;
    public final boolean g;
    public final String h;
    public final DriveViewModel i;
    public Boolean j;
    public List<String> k;
    public HashMap<String, String> l;
    public final a m;
    public final f55.a n;

    public class a implements View.OnClickListener {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            LikeInfoView.LikeState r5 = this.a.a.getState();
            tt5.a.k("LikeWrapper", "onClick: state" + r5);
            int r6 = b.a[r5.ordinal()];
            if (r6 != 1) goto L5;
            f r7 = this.a;
            r7.getClass();
            r7.e.add(((hg5.b) org.koin.java.a.a(hg5.b.class)).f(r7.h, new h(r7)));
            f r8 = this.a;
            r8.c.y(r8.h, "cancel_praise");
        L9:
            this.a.c.m((f85.a) this.a.i.getFileModel(), "like", "none");
            return;
        L5:
            if (r6 != 2) goto L9;
            f r9 = this.a;
            r9.getClass();
            r9.e.add(((hg5.b) org.koin.java.a.a(hg5.b.class)).h(r9.h, new j(r9)));
            f r10 = this.a;
            r10.c.y(r10.h, "confirm_praise");
            goto L9
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LikeInfoView.LikeState.values().length];
            a = r0;
            r0[LikeInfoView.LikeState.LIKED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[LikeInfoView.LikeState.UNLIKE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static void a(f r2) {
        Toast.showFailureText(r2.a.getContext(), r2.a.getResources().getString(2131888415), 1);
    }

    public static void b(f r3, boolean r4) {
        String r0 = r3.d.avatarUrl;
        String r1 = r3.b.getCurrentAvatarMap().get(r3.d.uid);
        List<String> r2 = r3.b.getCurrentAvatarList();
        if (r4 == false) goto L11;
        if (r2 != null) goto L7;
        r2 = new ArrayList();
    L7:
        if (r2.contains(r0) == false) goto L9;
    L19:
        r3.c(r2, null);
        return;
    L9:
        if (r2.contains(r1) == true) goto L19;
        ListProtector.add(r2, 0, r0);
        goto L19
    L11:
        if (r2 != null) goto L13;
    L15:
        if (r2 == null) goto L19;
        if (r2.contains(r1) == false) goto L19;
        r2.remove(r1);
        goto L19
    L13:
        if (r2.contains(r0) == false) goto L15;
        r2.remove(r0);
        goto L15
    }

    public final void c(List<String> r8, HashMap<String, String> r9) {
        this.k = r8;
        this.l = r9;
        int r0 = com.bytedance.ee.bear.middleground.permission.b.a;
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.permission.set_user_restricted_client", false) != true) goto L5;
        boolean r1 = this.j.booleanValue();
    L6:
        Boolean r2 = Boolean.valueOf(r1);
        this.j = r2;
        if (r2 == null) goto L29;
        if (r8 != null) goto L11;
        return;
    L11:
        if (r2.booleanValue() == false) goto L15;
        this.b.d(r8);
        if (r9 == null) goto L30;
        this.b.e = r9;
        return;
    L30:
        return;
    L15:
        this.b.d(r8);
        LikeCircleImageView r10 = this.b;
        r10.getClass();
        if (n.d == false) goto L22;
        if (hu5.a.d(r10.d) == true) goto L34;
        int r11 = r10.a(1);
        FrameLayout r3 = r10.c;
        com.bytedance.ee.util.ui.g.c(r3, r3.getWidth(), r11).setDuration(150).start();
        r10.a.setVisibility(0);
        r10.b.setVisibility(8);
        r10.a.setImageResource(2131235294);
        return;
    L34:
        return;
    L22:
        if (hu5.a.d(r10.d) == false) goto L25;
        return;
    L25:
        if (r10.c.getWidth() != 0) goto L27;
        int r12 = r10.getResources().getDimensionPixelSize(2131166314);
        com.bytedance.ee.util.ui.g.c(r10.c, 0, r12).setDuration(150).start();
    L27:
        r10.a.setVisibility(0);
        r10.b.setVisibility(8);
        r10.a.setImageResource(2131235294);
        return;
    L29:
        return;
    L5:
        r1 = true;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [f55.a] */
    public f(DriveViewModel r2, LikeInfoView r3, LikeCircleImageView r4) {
        this.e = new CompositeDisposable();
        this.j = Boolean.TRUE;
        this.k = null;
        this.l = null;
        this.m = new a(this);
        this.n = new f55.a(this);
        this.i = r2;
        this.h = r2.getOpenEntity().getFileId();
        NetService r5 = (NetService) org.koin.java.a.a(NetService.class);
        this.d = ((h0) org.koin.java.a.a(h0.class)).G2();
        this.b = r4;
        this.a = r3;
        this.c = o75.b.a().Ke();
        boolean r6 = ((b0) org.koin.java.a.a(b0.class)).b();
        this.g = r6;
        if (r6 == false) goto L5;
        r4.setVisibility(8);
        r3.setVisibility(8);
    L5:
        r3.b(0);
        r3.c(false);
        r4.d(new ArrayList());
        r4.e = new HashMap();
    }
}
