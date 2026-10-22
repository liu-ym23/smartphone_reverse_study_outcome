package com.obric.aiagent.platform.depend;

import com.obric.aiagent.platform.IAIAgentPlatform;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u00022\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/aiagent/platform/depend/ISysLogDepend;", "Lcom/obric/aiagent/platform/depend/ILogDepend;", "Companion", "Empty", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISysLogDepend extends ILogDepend {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f384998c = null;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J%\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\t\u0010\f\u001a\u00020\u0007H\u0096\u0001J\u001b\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J3\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00072 \u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013H\u0096\u0001J\u001b\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J%\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001¨\u0006\u0017"}, d2 = {"Lcom/obric/aiagent/platform/depend/ISysLogDepend$Companion;", "Lcom/obric/aiagent/platform/depend/ISysLogDepend;", "<init>", "()V", "d", "", "tag", "", "msg", "e", "tr", "", "getDirPath", RXScreenCaptureService.KEY_INDEX, "isDebug", "", "uploadAllLog", "scene", "callback", "Lkotlin/Function3;", "", BaseSwitches.V, "w", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ISysLogDepend {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ Companion f384999e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ISysLogDepend f385000d;

        static {
            f384999e = new Companion();
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void d(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            this.f385000d.d(r100, r101);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void e(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            this.f385000d.e(r100, r101);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void e(String r100, String r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            this.f385000d.e(r100, r101, r102);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final String getDirPath() {
            return this.f385000d.getDirPath();
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void i(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            this.f385000d.i(r100, r101);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final boolean isDebug() {
            return this.f385000d.isDebug();
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void w(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            this.f385000d.w(r100, r101);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void w(String r100, String r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            this.f385000d.w(r100, r101, r102);
        }

        private Companion() {
            IAIAgentPlatform r100 = r9a.a.a();
            if (r100 == null) goto L5;
            r100.d();
        L5:
            ISysLogDepend r101 = (ISysLogDepend) ServiceManager.get().getService(ISysLogDepend.class, false, false);
            if (r101 != null) goto L8;
            r101 = Empty.f385001d;
        L8:
            this.f385000d = r101;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/aiagent/platform/depend/ISysLogDepend$Empty;", "Lcom/obric/aiagent/platform/depend/ILogDepend;", "Lcom/obric/aiagent/platform/depend/ISysLogDepend;", "<init>", "()V", BaseSwitches.V, "", "tag", "", "msg", "d", RXScreenCaptureService.KEY_INDEX, "w", "tr", "", "e", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Empty implements ILogDepend, ISysLogDepend {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Empty f385001d = null;

        static {
            f385001d = new Empty();
        }

        private Empty() {
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void d(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void e(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void e(String r100, String r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r100, "tag");
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final String getDirPath() {
            return "";
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void i(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final boolean isDebug() {
            return false;
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void w(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void w(String r100, String r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r100, "tag");
        }
    }

    static {
        f384998c = Companion.f384999e;
    }
}
