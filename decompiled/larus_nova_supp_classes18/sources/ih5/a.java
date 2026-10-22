package ih5;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.lock.LockBannerView;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.component.universe_design.image.UDAvatarList;
import com.larksuite.component.universe_design.notice.UDNotice;
import ih5.d;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a<T extends d> extends LinearLayout implements e {
    public final int a;
    public UDAvatarList b;
    public LinearLayout c;
    public LinearLayout d;
    public LockBannerView e;
    public final c f;
    public T g;

    /* JADX INFO: renamed from: ih5.a$a, reason: collision with other inner class name */
    public static final class C0247a {
    }

    static {
    }

    @Override // ih5.e
    public final void a() {
    }

    public abstract /* synthetic */ void setCollaborateEnable(boolean r1);

    public final LinearLayout getInputLayoutFromXml() {
        KeyEvent.Callback r0 = this.c;
        if (r0 != null) goto L6;
        r0 = findViewById(2131375329);
        this.c = (LinearLayout) r0;
    L6:
        return (LinearLayout) r0;
    }

    public final LockBannerView getLockBannerFromXml() {
        UDNotice r0 = this.e;
        if (r0 != null) goto L6;
        r0 = findViewById(2131379161);
        this.e = (LockBannerView) r0;
    L6:
        return (LockBannerView) r0;
    }

    public final UDAvatarList getMemberListFromXml() {
        UDAvatarList r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131379839);
        this.b = r0;
    L6:
        return r0;
    }

    public final LinearLayout getMemberListLayoutFromXml() {
        KeyEvent.Callback r0 = this.d;
        if (r0 != null) goto L6;
        r0 = findViewById(2131379840);
        this.d = (LinearLayout) r0;
    L6:
        return (LinearLayout) r0;
    }

    public final T getPresenter() {
        T r0 = this.g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        return null;
    }

    @Override // ih5.e
    public final void b() {
        getLockBannerFromXml().setVisibility(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getPresenter().onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getPresenter().c();
    }

    public final c getAdapter() {
        return this.f;
    }

    public int getType() {
        return this.a;
    }

    public void c(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        if (ax4.d.b(r3, 1002) == false) goto L5;
    L8:
        tt5.a.h("BaseShareMemberView", "code = delete or forbidden, ignore");
        return;
    L5:
        if (ax4.d.b(r3, 4) == true) goto L8;
        Toast.showFailureText(getContext(), getContext().getString(2131888226));
    }

    public void e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        LayoutInflater.from(r2).inflate(2131564193, this);
        getMemberListFromXml().setAdapter(this.f);
        getInputLayoutFromXml().setAlpha(0.3f);
        getMemberListLayoutFromXml().setAlpha(0.3f);
    }

    public final void setInputLayoutFromXml(LinearLayout r1) {
        this.c = r1;
    }

    public final void setLockBannerFromXml(LockBannerView r1) {
        this.e = r1;
    }

    public final void setMemberListFromXml(UDAvatarList r1) {
        this.b = r1;
    }

    public final void setMemberListLayoutFromXml(LinearLayout r1) {
        this.d = r1;
    }

    public final void setPresenter(T r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    public a(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = r3;
        this.f = new c();
        e(r2);
    }

    public void d(ArrayList<UserInfo> r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "userInfos");
        c r0 = this.f;
        UDAvatarList r1 = getMemberListFromXml();
        r0.c = r6;
        r0.d = r7;
        int r3 = 0;
        if (r6.size() == 1) goto L5;
    L7:
        boolean r2 = false;
    L8:
        r0.e = Boolean.valueOf(r2);
        if (r7 <= r6.size()) goto L11;
        r3 = 1;
    L11:
        int r8 = r6.size() + r3;
        if (r8 <= 0) goto L14;
        r1.setMaxCount(Math.min(r8, 5));
    L14:
        r0.a();
        return;
    L5:
        if (r7 != 2) goto L7;
        r2 = true;
        goto L8
    }
}
