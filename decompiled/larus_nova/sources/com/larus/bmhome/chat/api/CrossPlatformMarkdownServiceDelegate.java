package com.larus.bmhome.chat.api;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larus.list.arch.IFlowListCell;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nH\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/api/CrossPlatformMarkdownServiceDelegate;", "Lcom/larus/bmhome/chat/api/ICrossPlatformMarkdownService;", "<init>", "()V", "IMPL", "isWidgetCell", "", LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL, "", "getAllVisibleWidget", "", "Landroid/view/View;", "clearAllVisibleWidget", "", "provideCustomDataHandler", "Lcom/larus/business/markdown/api/depend/ICustomDataHandler;", "findVisibleWidget", "viewGroup", "Landroid/view/ViewGroup;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CrossPlatformMarkdownServiceDelegate implements ICrossPlatformMarkdownService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CrossPlatformMarkdownServiceDelegate f297160a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ICrossPlatformMarkdownService f297161b = null;

    private CrossPlatformMarkdownServiceDelegate() {
    }

    static {
        f297160a = new CrossPlatformMarkdownServiceDelegate();
        f297161b = (ICrossPlatformMarkdownService) ServiceManager.get().getService(ICrossPlatformMarkdownService.class);
    }

    @Override // com.larus.bmhome.chat.api.ICrossPlatformMarkdownService
    public final List<View> b() {
        ICrossPlatformMarkdownService r100 = f297161b;
        if (r100 == null) goto L7;
        List<View> r101 = r100.b();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return CollectionsKt.emptyList();
    }

    @Override // com.larus.bmhome.chat.api.ICrossPlatformMarkdownService
    public final void c() {
        ICrossPlatformMarkdownService r100 = f297161b;
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    @Override // com.larus.bmhome.chat.api.ICrossPlatformMarkdownService
    public final void a(ViewGroup r100) {
        ICrossPlatformMarkdownService r101 = f297161b;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.larus.bmhome.chat.api.ICrossPlatformMarkdownService
    public final boolean d(IFlowListCell r100) {
        ICrossPlatformMarkdownService r101 = f297161b;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.d(r100);
    }
}
