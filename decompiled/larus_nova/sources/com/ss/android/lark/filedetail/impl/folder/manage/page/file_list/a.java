package com.ss.android.lark.filedetail.impl.folder.manage.page.file_list;

import android.content.Context;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.filedetail.dto.FolderManageLaunchParams;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends BasePresenter<i, j, j.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f421757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FolderManageLaunchParams f421758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f421759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FileListPresenter$callback$1 f421760d;

    /* JADX INFO: renamed from: com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.a$a, reason: collision with other inner class name */
    public static final class C4969a {
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return new b(this);
    }

    public final Context getContext() {
        return this.f421757a;
    }

    public static final /* synthetic */ j H8(a r100) {
        return r100.getView();
    }

    public static final void I8(a r100) {
        if (r100.f421759c.get() == false) goto L22;
        int r101 = pfb.d.f529030a;
        FolderManageLaunchParams r102 = r100.f421758b;
        String r103 = r102.f421495b;
        int r104 = r102.f421498e;
        long r105 = r100.getModel().t3();
        if (r103 != null) goto L7;
    L10:
        boolean r106 = true;
    L11:
        if (r106 == false) goto L14;
    L20:
        pfb.d.a.d(r100.f421758b.f421495b, r100.getModel().M(), r100.f421758b.f421498e);
        r100.f421759c.set(false);
        return;
    L14:
        if (r104 != 7) goto L16;
    L18:
        String r107 = "file_search_mobile";
    L19:
        pfb.d.a.b(r103, "im_chat_file_manage_view", MapsKt.mapOf(new Pair[]{TuplesKt.to("source", r107), TuplesKt.to("total_item_count", Long.valueOf(r105))}));
        goto L20
    L16:
        if (r104 == 8) goto L18;
        r107 = "none";
        goto L19
    L7:
        if (r103.length() == 0) goto L10;
        r106 = false;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.FileListPresenter$callback$1] */
    public a(Context r100, FileListFragment.a r101, FolderManageLaunchParams r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dependency");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f421757a = r100;
        this.f421758b = r102;
        this.f421759c = new AtomicBoolean(true);
        this.f421760d = new FileListPresenter$callback$1(this);
        FileListModel r103 = new FileListModel(r102, r101.a().getFirst().longValue());
        FileListView r104 = new FileListView(r100, r101, r102);
        r104.f421746i = new b(this);
        setModel(r103);
        setView(r104);
    }
}
