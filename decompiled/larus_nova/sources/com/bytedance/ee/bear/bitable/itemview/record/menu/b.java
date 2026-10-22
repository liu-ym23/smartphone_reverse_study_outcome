package com.bytedance.ee.bear.bitable.itemview.record.menu;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f214155h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f214156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f214157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f214158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gv4.a f214159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f214160e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f214161f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f214162g;

    public static final class a {
    }

    static {
    }

    public final String a() {
        String r100 = this.f214161f;
        return UriProtector.parse(r100).buildUpon().clearQuery().appendQueryParameter("ccm_open_type", "im_navigation").toString();
    L5:
        e = move-exception;
        tt5.a.e("NavigationItem", "parse origin url err ", e, false);
        return r100;
    }

    public final void b() {
        ImageView r100 = this.f214157b;
        if (this.f214160e == false) goto L5;
        int r101 = R.drawable.ud_icon_more_launcher_no_outlined;
    L6:
        r100.setImageResource(r101);
        return;
    L5:
        r101 = R.drawable.ud_icon_more_launcher_outlined;
        goto L6
    }

    public final Context getContext() {
        return this.f214156a;
    }

    public b(Context r100, AppCompatImageView r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "addToNavigationView");
        this.f214156a = r100;
        this.f214157b = r101;
        this.f214158c = r102;
        m.z(r101, false);
        r101.setOnClickListener(new com.bytedance.ee.bear.bitable.itemview.record.menu.a(this));
        if (TextUtils.isEmpty(this.f214161f) == true) goto L9;
        String r105 = a();
        if (r105 == null) goto L14;
        vqb.a r106 = vqb.b.a();
        if (r106 == null) goto L15;
        r106.isExistFavoriteTab(r105, TabAppInfo.BizType.CCM, new Navigation$requestHasAddToNavigation$1$1(this));
        return;
    L15:
        return;
    L14:
        return;
    L9:
        Disposable r107 = this.f214162g;
        if (r107 == null) goto L12;
        r107.dispose();
    L12:
        this.f214162g = ((com.bytedance.ee.bear.share.b) org.koin.java.a.c(com.bytedance.ee.bear.share.b.class, null, null, 6)).c(r103, r104).subscribe(new c(this), d.f214164a);
    }
}
