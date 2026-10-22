package com.larus.business.accessbility.api;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/larus/business/accessbility/api/IAccessibilityService;", "", "initAccessibilitySdk", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "start", "stop", "isAccessibilityEnabled", "", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAccessibilityService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f319826a = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0001J\t\u0010\n\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u000b\u001a\u00020\u0005H\u0096\u0001¨\u0006\f"}, d2 = {"Lcom/larus/business/accessbility/api/IAccessibilityService$Companion;", "Lcom/larus/business/accessbility/api/IAccessibilityService;", "<init>", "()V", "initAccessibilitySdk", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isAccessibilityEnabled", "", "start", "stop", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IAccessibilityService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f319827c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IAccessibilityService f319828b;

        static {
            f319827c = new Companion();
        }

        @Override // com.larus.business.accessbility.api.IAccessibilityService
        public final boolean a() {
            return this.f319828b.a();
        }

        @Override // com.larus.business.accessbility.api.IAccessibilityService
        public final void b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f319828b.b(r100);
        }

        @Override // com.larus.business.accessbility.api.IAccessibilityService
        public final void start() {
            this.f319828b.start();
        }

        private Companion() {
            this.f319828b = (IAccessibilityService) ServiceManager.get().getService(IAccessibilityService.class);
        }
    }

    static {
        f319826a = Companion.f319827c;
    }

    boolean a();

    void b(Context r100);

    void start();
}
