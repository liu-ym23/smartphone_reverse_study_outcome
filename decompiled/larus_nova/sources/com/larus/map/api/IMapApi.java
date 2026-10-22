package com.larus.map.api;

import android.content.Context;
import com.larus.bmhome.chat.map.p;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wq9.e;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J=\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072#\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\fH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&¨\u0006\u0013"}, d2 = {"Lcom/larus/map/api/IMapApi;", "", "createMapStrategy", "Lcom/larus/platform/model/map/IFlowMapStrategy;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "is3DPluginInstalled", "", "load3DMapPluginAndCheckUpgrade", "", "silentInstall", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "getMapKey", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMapApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f358881a = null;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J=\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/map/api/IMapApi$Companion;", "Lcom/larus/map/api/IMapApi;", "<init>", "()V", "impl", "createMapStrategy", "Lcom/larus/platform/model/map/IFlowMapStrategy;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "is3DPluginInstalled", "", "load3DMapPluginAndCheckUpgrade", "", "silentInstall", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "getMapKey", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IMapApi {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f358882b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final IMapApi f358883c = null;

        private Companion() {
        }

        static {
            f358882b = new Companion();
            f358883c = (IMapApi) ServiceManager.get().getService(IMapApi.class);
        }

        @Override // com.larus.map.api.IMapApi
        public final String c() {
            IMapApi r100 = f358883c;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.c();
        }

        @Override // com.larus.map.api.IMapApi
        public final boolean d() {
            IMapApi r100 = f358883c;
            if (r100 != null) goto L5;
            return false;
        L5:
            if (r100.d() != true) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // com.larus.map.api.IMapApi
        public final e a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            IMapApi r101 = f358883c;
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.a(r100);
        }

        @Override // com.larus.map.api.IMapApi
        public final void b(Context r100, p r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            IMapApi r102 = f358883c;
            if (r102 == null) goto L6;
            r102.b(r100, r101);
            return;
        }
    }

    static {
        f358881a = Companion.f358882b;
    }

    e a(Context r100);

    void b(Context r100, p r101);

    String c();

    boolean d();
}
