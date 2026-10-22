package com.obric.aiagent.platform.depend;

import com.obric.aiagent.platform.IAIAgentPlatform;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J$\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J$\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J2\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00052 \u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013H\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/aiagent/platform/depend/ILogDepend;", "", BaseSwitches.V, "", "tag", "", "msg", "d", RXScreenCaptureService.KEY_INDEX, "w", "tr", "", "e", "isDebug", "", "getDirPath", "uploadAllLog", "scene", "callback", "Lkotlin/Function3;", "", "Companion", "AndroidLogcat", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILogDepend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f384986a = null;

    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/aiagent/platform/depend/ILogDepend$AndroidLogcat;", "Lcom/obric/aiagent/platform/depend/ILogDepend;", "<init>", "()V", BaseSwitches.V, "", "tag", "", "msg", "d", RXScreenCaptureService.KEY_INDEX, "w", "tr", "", "e", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AndroidLogcat implements ILogDepend {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AndroidLogcat f384987d = null;

        static {
            f384987d = new AndroidLogcat();
        }

        private AndroidLogcat() {
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final String getDirPath() {
            return "";
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final boolean isDebug() {
            return false;
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void d(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            IAppContext.Companion r102 = IAppContext.f384977a;
            if (r102.isDebugChannel() == true) goto L6;
            r102.isTestChannel();
            return;
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void e(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            IAppContext.Companion r102 = IAppContext.f384977a;
            if (r102.isDebugChannel() == true) goto L6;
            r102.isTestChannel();
            return;
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void i(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            IAppContext.Companion r102 = IAppContext.f384977a;
            if (r102.isDebugChannel() == true) goto L6;
            r102.isTestChannel();
            return;
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void w(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            IAppContext.Companion r102 = IAppContext.f384977a;
            if (r102.isDebugChannel() == true) goto L6;
            r102.isTestChannel();
            return;
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void e(String r100, String r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            IAppContext.Companion r103 = IAppContext.f384977a;
            if (r103.isDebugChannel() == true) goto L6;
            r103.isTestChannel();
            return;
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void w(String r100, String r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            IAppContext.Companion r103 = IAppContext.f384977a;
            if (r103.isDebugChannel() == true) goto L6;
            r103.isTestChannel();
            return;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J%\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\t\u0010\f\u001a\u00020\u0007H\u0096\u0001J\u001b\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J3\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00072 \u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013H\u0096\u0001J\u001b\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J%\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001¨\u0006\u0017"}, d2 = {"Lcom/obric/aiagent/platform/depend/ILogDepend$Companion;", "Lcom/obric/aiagent/platform/depend/ILogDepend;", "<init>", "()V", "d", "", "tag", "", "msg", "e", "tr", "", "getDirPath", RXScreenCaptureService.KEY_INDEX, "isDebug", "", "uploadAllLog", "scene", "callback", "Lkotlin/Function3;", "", BaseSwitches.V, "w", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ILogDepend {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ Companion f384988e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ILogDepend f384989d;

        static {
            f384988e = new Companion();
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void d(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            this.f384989d.d(r100, r101);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void e(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            this.f384989d.e(r100, r101);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void e(String r100, String r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            this.f384989d.e(r100, r101, r102);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final String getDirPath() {
            return this.f384989d.getDirPath();
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void i(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            this.f384989d.i(r100, r101);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final boolean isDebug() {
            return this.f384989d.isDebug();
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void w(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            this.f384989d.w(r100, r101);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void w(String r100, String r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            this.f384989d.w(r100, r101, r102);
        }

        private Companion() {
            IAIAgentPlatform r100 = r9a.a.a();
            if (r100 == null) goto L6;
            ILogDepend r101 = r100.getLogger();
            if (r101 == null) goto L6;
        L9:
            this.f384989d = r101;
            return;
        L6:
            r101 = (ILogDepend) ServiceManager.get().getService(ILogDepend.class, false, false);
            if (r101 != null) goto L9;
            r101 = AndroidLogcat.f384987d;
            goto L9
        }
    }

    static {
        f384986a = Companion.f384988e;
    }

    void d(String r100, String r101);

    void e(String r100, String r101);

    void e(String r100, String r101, Throwable r102);

    String getDirPath();

    void i(String r100, String r101);

    boolean isDebug();

    void w(String r100, String r101);

    void w(String r100, String r101, Throwable r102);
}
