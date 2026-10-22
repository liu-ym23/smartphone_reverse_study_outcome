package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.UrlPreviewHangPoint;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class PreviewPush implements a2b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a2b.d f411542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a2b.f f411543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f411544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList<tya.a> f411545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<Throwable, Unit> f411546e;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.sdk.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PreviewPush f411547a;

        public b(PreviewPush r100) {
            this.f411547a = r100;
        }

        @Override // com.ss.android.lark.sdk.f.a
        public final void a() {
            this.f411547a.f411542a.a();
        }
    }

    static {
    }

    @Override // a2b.c
    public final void N4(tya.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.ss.android.lark.sdk.f.b(this.f411545d, r100, new b(this));
        this.f411544c.execute(x0.f411698a);
    }

    @Override // a2b.c
    public final void v9(tya.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.ss.android.lark.sdk.f.a(this.f411545d, r100, new PreviewPush$startPush$1(this));
    }

    @Inject
    public PreviewPush(a2b.d r100, a2b.f r101) {
        Intrinsics.checkNotNullParameter(r100, "pushRepo");
        Intrinsics.checkNotNullParameter(r101, "previewService");
        this.f411542a = r100;
        this.f411543b = r101;
        this.f411544c = CoreThreadPool.getDefault().getSingleScheduledThreadPool("thread-pool-message-preview-push");
        this.f411545d = new CopyOnWriteArrayList();
        this.f411546e = PreviewPush$onError$1.INSTANCE;
    }

    public final List<UrlPreviewHangPoint> a(String r100, List<String> r101) {
        Message r102 = ImSdkService.f().za(r100);
        if (r102 != null) goto L5;
        return null;
    L5:
        uxb.b r103 = r102.getMessageContent();
        if ((r103 instanceof BaseTextContent) == false) goto L8;
        BaseTextContent r104 = (BaseTextContent) r103;
    L9:
        if (r104 != null) goto L11;
        return null;
    L11:
        Collection<PreviewHangPoint> r105 = r104.getPreviewHangPoints().values();
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r105.iterator();
    L13:
        if (r107.hasNext() == false) goto L18;
        PreviewHangPoint r108 = (PreviewHangPoint) r107.next();
        if (CollectionsKt.contains(r101, r108.getPreviewId()) == false) goto L13;
        r106.add(new UrlPreviewHangPoint.Builder().url(r108.getUrl()).preview_id(r108.getPreviewId()).need_local_preview(Boolean.valueOf(r108.getNeedLocalPreview())).is_lazy_load(Boolean.valueOf(r108.isLazyLoad())).build());
        goto L13
    L18:
        return CollectionsKt.toList(r106);
    L8:
        r104 = null;
        goto L9
    }
}
