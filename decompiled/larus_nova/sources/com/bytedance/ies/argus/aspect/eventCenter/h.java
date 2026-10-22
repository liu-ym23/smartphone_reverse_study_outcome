package com.bytedance.ies.argus.aspect.eventCenter;

import com.bytedance.ies.argus.api.params.LoadTemplateParams;
import com.bytedance.ies.argus.bean.ArgusLynxViewAspect;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.service.security.ILynxSecurityService;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h extends b<LynxView> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f245865j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Long f245866k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Long f245867l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ConcurrentHashMap<String, ld7.d> f245868m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LoadTemplateParams f245869n;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f245870a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f245871b = null;

        static {
            int[] r100 = new int[ArgusLynxViewAspect.values().length];
            r100[ArgusLynxViewAspect.ABOUT_TO_LOAD_TEMPLATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L4:
            f245870a = r100;
            int[] r101 = new int[ILynxSecurityService.LynxTasmType.values().length];
            r101[ILynxSecurityService.LynxTasmType.TYPE_TEMPLATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L12:
            r101[ILynxSecurityService.LynxTasmType.TYPE_DYNAMIC_COMPONENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L7:
            f245871b = r101;
        }
    }

    public h() {
        this.f245868m = new ConcurrentHashMap();
    }

    public final LoadTemplateParams i(ILynxSecurityService.LynxTasmType r100) {
        Intrinsics.checkNotNullParameter(r100, "tasmType");
        int r101 = a.f245871b[r100.ordinal()];
        if (r101 == 1) goto L10;
        if (r101 != 2) goto L8;
        return null;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return this.f245869n;
    }
}
