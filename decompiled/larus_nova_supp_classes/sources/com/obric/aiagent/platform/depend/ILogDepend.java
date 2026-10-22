package com.obric.aiagent.platform.depend;

import android.util.EventsUtils;
import com.obric.aiagent.platform.IAIAgentPlatform;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J$\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J$\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J2\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00052 \u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013H\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/aiagent/platform/depend/ILogDepend;", XmlPullParser.NO_NAMESPACE, "v", XmlPullParser.NO_NAMESPACE, "tag", XmlPullParser.NO_NAMESPACE, "msg", "d", "i", "w", "tr", XmlPullParser.NO_NAMESPACE, "e", "isDebug", XmlPullParser.NO_NAMESPACE, "getDirPath", "uploadAllLog", "scene", "callback", "Lkotlin/Function3;", XmlPullParser.NO_NAMESPACE, "Companion", "AndroidLogcat", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface ILogDepend {
    public static final Companion a = null;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J%\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\t\u0010\f\u001a\u00020\u0007H\u0096\u0001J\u001b\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J3\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00072 \u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013H\u0096\u0001J\u001b\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J%\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001¨\u0006\u0017"}, d2 = {"Lcom/obric/aiagent/platform/depend/ILogDepend$Companion;", "Lcom/obric/aiagent/platform/depend/ILogDepend;", "<init>", "()V", "d", XmlPullParser.NO_NAMESPACE, "tag", XmlPullParser.NO_NAMESPACE, "msg", "e", "tr", XmlPullParser.NO_NAMESPACE, "getDirPath", "i", "isDebug", XmlPullParser.NO_NAMESPACE, "uploadAllLog", "scene", "callback", "Lkotlin/Function3;", XmlPullParser.NO_NAMESPACE, "v", "w", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final class Companion implements ILogDepend {
        public static final /* synthetic */ Companion e = null;
        public final /* synthetic */ ILogDepend d;

        static {
            e = new Companion();
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void d(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            this.d.d(r2, r3);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void e(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            this.d.e(r2, r3);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void e(String r2, String r3, Throwable r4) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            this.d.e(r2, r3, r4);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final String getDirPath() {
            return this.d.getDirPath();
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void i(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            this.d.i(r2, r3);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final boolean isDebug() {
            return this.d.isDebug();
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void w(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            this.d.w(r2, r3);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public final void w(String r2, String r3, Throwable r4) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            this.d.w(r2, r3, r4);
        }

        private Companion() {
            IAIAgentPlatform r0 = r9a.a.a();
            if (r0 == null) goto L6;
            ILogDepend r1 = r0.getLogger();
            if (r1 == null) goto L6;
        L9:
            this.d = r1;
            return;
        L6:
            r1 = (ILogDepend) ServiceManager.get().getService(ILogDepend.class, false, false);
            if (r1 != null) goto L9;
            r1 = AndroidLogcat.d;
            goto L9
        }
    }

    static {
        a = Companion.e;
    }

    void d(String r1, String r2);

    void e(String r1, String r2);

    void e(String r1, String r2, Throwable r3);

    String getDirPath();

    void i(String r1, String r2);

    boolean isDebug();

    void w(String r1, String r2);

    void w(String r1, String r2, Throwable r3);
}
