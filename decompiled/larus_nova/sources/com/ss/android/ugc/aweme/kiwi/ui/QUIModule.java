package com.ss.android.ugc.aweme.kiwi.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.livecommerce.playback.banner.a;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/kiwi/ui/QUIModule;", "", "kiwi_release"}, k = 1, mv = {1, 4, 0})
public abstract class QUIModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public QUIManager f450917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public QModel f450918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public QIPresenter f450919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f450920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f450921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f450922f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f450923g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public QUIModule f450924h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<? extends QUIModule> f450925i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f450926j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewGroup.LayoutParams f450927k;

    public QUIModule() {
        this(0);
    }

    public String b() {
        return "";
    }

    public boolean d() {
        return this instanceof a;
    }

    public void e(Context r100) {
    }

    public abstract View f(Context r100, ViewGroup r101);

    public void g(View r100) {
    }

    public abstract QIPresenter h();

    public List<QUIModule> i() {
        return null;
    }

    public int j(QModel r100) {
        return 0;
    }

    public final QUIManager a() {
        QUIManager r100 = this.f450917a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("uiManager");
    L5:
        return r100;
    }

    public /* synthetic */ QUIModule(int r100) {
        this(-1, null);
    }

    public QUIAction c(ArrayList r100) {
        return QUIAction.NONE;
    }

    public QUIModule(int r100, ViewGroup.LayoutParams r101) {
        this.f450926j = r100;
        this.f450927k = r101;
    }
}
