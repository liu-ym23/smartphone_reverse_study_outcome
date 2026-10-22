package com.bytedance.sdk.account.platform;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.ss.android.account.l;
import java.util.Map;
import ua7.h;

/* JADX INFO: loaded from: classes22.dex */
public abstract class PlatformBindAdapter extends BaseAccountAdapter implements IPlatformBindAdapter {
    private Map<String, String> changeBindExtraParam;
    boolean isBindPlatformAndThirdMobileMode;
    private f mBindDelegate;
    private Map<String, String> switchBindExtraParam;
    private boolean verifyTicket;
    private boolean verifyType;

    public class a extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlatformBindAdapter f269239a;

        /* JADX INFO: renamed from: com.bytedance.sdk.account.platform.PlatformBindAdapter$a$a, reason: collision with other inner class name */
        public class C3762a implements IPlatformBindAdapter.BindController {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h f269240a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f269241b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a f269242c;

            /* JADX INFO: renamed from: com.bytedance.sdk.account.platform.PlatformBindAdapter$a$a$a, reason: collision with other inner class name */
            public class C3763a extends sa7.h<h> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ C3762a f269243a;

                public C3763a(C3762a r100) {
                    this.f269243a = r100;
                }

                @Override // sa7.h
                public final void onSuccess(ua7.b r100) {
                    PlatformBindAdapter r101 = this.f269243a.f269242c.f269239a;
                    r101.onBindSuccess((h) r100);
                }

                @Override // sa7.h
                public final void onError(ua7.b r100, int r101) {
                    PlatformBindAdapter r102 = this.f269243a.f269242c.f269239a;
                    r102.onBindError((h) r100);
                }
            }

            @Override // com.bytedance.sdk.account.platform.IPlatformBindAdapter.BindController
            public final void doNext() {
                C3763a r100 = new C3763a(this);
                int r101 = this.f269240a.f549253g;
                if (r101 != 1030) goto L6;
                PlatformBindAdapter r102 = this.f269242c.f269239a;
                r102.api.m(r102.platformId, r102.platform, this.f269241b, PlatformBindAdapter.access$000(r102), r100);
                return;
            L6:
                if (r101 != 1041) goto L10;
                PlatformBindAdapter r103 = this.f269242c.f269239a;
                r103.api.n(r103.platform, r103.platformId, this.f269241b, null, PlatformBindAdapter.access$100(r103), PlatformBindAdapter.access$200(this.f269242c.f269239a), PlatformBindAdapter.access$300(this.f269242c.f269239a), r100);
                return;
            }

            public C3762a(a r100, h r101, String r102) {
                this.f269242c = r100;
                this.f269240a = r101;
                this.f269241b = r102;
            }
        }

        public a(PlatformBindAdapter r100) {
            this.f269239a = r100;
        }

        @Override // com.ss.android.account.l
        public final void a(h r100) {
            this.f269239a.onBindError(r100);
        }

        @Override // com.ss.android.account.l
        public final void c(h r100) {
            this.f269239a.onBindSuccess(r100);
        }

        @Override // com.ss.android.account.l
        public final void b(h r100, String r101, String r102, String r110) {
            this.f269239a.onBindExist(r100, r101, r102, r110, new C3762a(this, r100, r110));
        }
    }

    public void cancelBind() {
        f r100 = this.mBindDelegate;
        if (r100 == null) goto L6;
        r100.cancelBind();
        this.mBindDelegate = null;
        return;
    }

    public static /* synthetic */ Map access$000(PlatformBindAdapter r100) {
        return r100.switchBindExtraParam;
    }

    public static /* synthetic */ boolean access$100(PlatformBindAdapter r100) {
        return r100.verifyType;
    }

    public static /* synthetic */ boolean access$200(PlatformBindAdapter r100) {
        return r100.verifyTicket;
    }

    public static /* synthetic */ Map access$300(PlatformBindAdapter r100) {
        return r100.changeBindExtraParam;
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onError(AuthorizeErrorResponse r100) {
        com.bytedance.sdk.account.monitor.c.i(this.platform, "bind", 0, r100.platformErrorCode, r100.platformErrorMsg, r100.isCancel);
        onBindError(getErrorResponse(r100));
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onSuccess(Bundle r100) {
        com.bytedance.sdk.account.monitor.c.i(this.platform, "bind", 1, null, null, false);
        f.a r101 = BaseAccountAdapter.delegateMap.get(this.platform);
        if (r101 == null) goto L6;
        f r102 = r101.createBind(this);
        this.mBindDelegate = r102;
        r102.requestBind(r100);
        return;
    }

    public PlatformBindAdapter setBindPlatformAndThirdMobileMode(boolean r100) {
        this.isBindPlatformAndThirdMobileMode = r100;
        return this;
    }

    public PlatformBindAdapter setChangeBindExtraParam(Map<String, String> r100) {
        this.changeBindExtraParam = r100;
        return this;
    }

    public PlatformBindAdapter setSwitchBindExtraParam(Map<String, String> r100) {
        this.switchBindExtraParam = r100;
        return this;
    }

    public PlatformBindAdapter setVerifyTicket(boolean r100) {
        this.verifyTicket = r100;
        return this;
    }

    public PlatformBindAdapter setVerifyType(boolean r100) {
        this.verifyType = r100;
        return this;
    }

    public PlatformBindAdapter(Context r100, String r101, String r102) {
        super(r100, r101, r102);
        this.verifyType = false;
        this.verifyTicket = false;
        this.isBindPlatformAndThirdMobileMode = false;
    }

    public PlatformBindAdapter(Context r100, String r101, String r102, boolean r103) {
        super(r100, r101, r102);
        this.verifyType = false;
        this.verifyTicket = false;
        this.isBindPlatformAndThirdMobileMode = r103;
    }

    public PlatformBindAdapter(Context r100, String r101, String r102, Map<String, String> r103) {
        this(r100, r101, r102);
        this.mExtendParam = r103;
    }
}
