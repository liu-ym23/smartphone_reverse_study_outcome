package com.larus.apm.api;

import android.util.EventsUtils;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import org.xmlpull.v1.XmlPullParser;
import p48.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\b\u0010\u0007\u001a\u00020\u0004H&R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/larus/apm/api/IExtraParams;", XmlPullParser.NO_NAMESPACE, "staticParams", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "getStaticParams", "()Ljava/util/Map;", "getAppVariant", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IExtraParams {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/larus/apm/api/IExtraParams$Companion;", "Lcom/larus/apm/api/IExtraParams;", "<init>", "()V", "KEY_GIT_COMMIT_ID", XmlPullParser.NO_NAMESPACE, "KEY_BUILD_JOB_ID", "KEY_GIT_BRANCH", "KEY_PROCESS_NAME", "KEY_PROCESS_ID", "KEY_APP_VARIANT", "impl", "getImpl", "()Lcom/larus/apm/api/IExtraParams;", "impl$delegate", "Lkotlin/Lazy;", "staticParams", XmlPullParser.NO_NAMESPACE, "getStaticParams", "()Ljava/util/Map;", "getAppVariant", "api_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final class Companion implements IExtraParams {
        public static final /* synthetic */ Companion b = null;
        public static final Lazy<IExtraParams> c = null;

        private Companion() {
        }

        static {
            b = new Companion();
            c = LazyKt.lazy(new c());
        }

        @Override // com.larus.apm.api.IExtraParams
        public final String b() {
            IExtraParams r0 = c.getValue();
            if (r0 == null) goto L6;
            String r1 = r0.b();
            if (r1 == null) goto L6;
            return r1;
        L6:
            return XmlPullParser.NO_NAMESPACE;
        }

        @Override // com.larus.apm.api.IExtraParams
        public final Map<String, String> c() {
            IExtraParams r0 = c.getValue();
            if (r0 == null) goto L7;
            Map<String, String> r1 = r0.c();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return MapsKt.emptyMap();
        }
    }

    static {
        a = Companion.b;
    }

    String b();

    Map<String, String> c();
}
