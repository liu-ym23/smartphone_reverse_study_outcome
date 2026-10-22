package ih5;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.lock.LockBannerView;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.component.universe_design.image.UDAvatarList;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import ih5.d;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class a<T extends d> extends LinearLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f489853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UDAvatarList f489854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f489855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout f489856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LockBannerView f489857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f489858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public T f489859g;

    /* JADX INFO: renamed from: ih5.a$a, reason: collision with other inner class name */
    public static final class C6268a {
    }

    static {
    }

    @Override // ih5.e
    public final void a() {
    }

    public abstract /* synthetic */ void setCollaborateEnable(boolean r100);

    public final LinearLayout getInputLayoutFromXml() {
        KeyEvent.Callback r100 = this.f489855c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.inputLayout);
        this.f489855c = (LinearLayout) r100;
    L6:
        return (LinearLayout) r100;
    }

    public final LockBannerView getLockBannerFromXml() {
        KeyEvent.Callback r100 = this.f489857e;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.lockBanner);
        this.f489857e = (LockBannerView) r100;
    L6:
        return (LockBannerView) r100;
    }

    public final UDAvatarList getMemberListFromXml() {
        KeyEvent.Callback r100 = this.f489854b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.memberList);
        this.f489854b = (UDAvatarList) r100;
    L6:
        return (UDAvatarList) r100;
    }

    public final LinearLayout getMemberListLayoutFromXml() {
        KeyEvent.Callback r100 = this.f489856d;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.memberListLayout);
        this.f489856d = (LinearLayout) r100;
    L6:
        return (LinearLayout) r100;
    }

    public final T getPresenter() {
        T r100 = this.f489859g;
        if (r100 == null) goto L5;
        return r100;
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
        return this.f489858f;
    }

    public int getType() {
        return this.f489853a;
    }

    public void c(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        if (ax4.d.b(r100, 1002) == false) goto L5;
    L8:
        tt5.a.h("BaseShareMemberView", "code = delete or forbidden, ignore");
        return;
    L5:
        if (ax4.d.b(r100, 4) == true) goto L8;
        Toast.showFailureText(getContext(), getContext().getString(R.string.Doc_Share_LoadFailed));
    }

    public void e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LayoutInflater.from(r100).inflate(R.layout.permission_share_collaborate_view_v2, this);
        getMemberListFromXml().setAdapter(this.f489858f);
        getInputLayoutFromXml().setAlpha(0.3f);
        getMemberListLayoutFromXml().setAlpha(0.3f);
    }

    public final void setInputLayoutFromXml(LinearLayout r100) {
        this.f489855c = r100;
    }

    public final void setLockBannerFromXml(LockBannerView r100) {
        this.f489857e = r100;
    }

    public final void setMemberListFromXml(UDAvatarList r100) {
        this.f489854b = r100;
    }

    public final void setMemberListLayoutFromXml(LinearLayout r100) {
        this.f489856d = r100;
    }

    public final void setPresenter(T r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f489859g = r100;
    }

    public a(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f489853a = r101;
        this.f489858f = new c();
        e(r100);
    }

    public void d(ArrayList<UserInfo> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "userInfos");
        c r102 = this.f489858f;
        UDAvatarList r103 = getMemberListFromXml();
        r102.f489864c = r100;
        r102.f489865d = r101;
        int r104 = 0;
        if (r100.size() == 1) goto L5;
    L7:
        boolean r105 = false;
    L8:
        r102.f489866e = Boolean.valueOf(r105);
        if (r101 <= r100.size()) goto L11;
        r104 = 1;
    L11:
        int r106 = r100.size() + r104;
        if (r106 <= 0) goto L14;
        r103.setMaxCount(Math.min(r106, 5));
    L14:
        r102.a();
        return;
    L5:
        if (r101 != 2) goto L7;
        r105 = true;
        goto L8
    }
}
