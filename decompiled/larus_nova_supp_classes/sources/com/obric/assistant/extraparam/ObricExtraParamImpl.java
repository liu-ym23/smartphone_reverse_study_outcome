package com.obric.assistant.extraparam;

import android.os.Build;
import android.util.EventsUtils;
import com.larus.apm.api.IExtraParams;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.platform.depend.IBuildContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import n9a.f;
import org.xmlpull.v1.XmlPullParser;
import t9a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\bH\u0016R\u0016\u0010\u0004\u001a\n \u0005*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/extraparam/ObricExtraParamImpl;", "Lcom/larus/apm/api/IExtraParams;", "<init>", "()V", "real", "kotlin.jvm.PlatformType", "_staticParams", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "get_staticParams", "()Ljava/util/Map;", "_staticParams$delegate", "Lkotlin/Lazy;", "staticParams", XmlPullParser.NO_NAMESPACE, "getStaticParams", "getAppVariant", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ObricExtraParamImpl implements IExtraParams {
    public static final /* synthetic */ int d = 0;
    public final IExtraParams b;
    public final Lazy c;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.apm.api.IExtraParams
    public final String b() {
        f r0 = f.a;
        IBuildContext.Companion r1 = IBuildContext.a;
        String r5 = null;
        if (StringsKt.startsWith$default(r1.a(), "obric", false, 2, null) == false) goto L6;
        r5 = r1.a() + "_pacific_" + Build.MODEL;
        ILogDepend.a.d("AssistantFeature", "appVariant: " + r5);
    L6:
        String r2 = XmlPullParser.NO_NAMESPACE;
        if (r5 != null) goto L9;
        r5 = XmlPullParser.NO_NAMESPACE;
    L9:
        String r3 = b.a().g();
        if (r3 == null) goto L13;
        r2 = r3;
    L13:
        FLogger.a.d("ObricExtraParamImpl", "getAppVariant: " + r2 + ", " + r5);
        return r2;
    }

    @Override // com.larus.apm.api.IExtraParams
    public final Map<String, String> c() {
        return (Map) this.c.getValue();
    }

    public ObricExtraParamImpl() {
        this.b = (IExtraParams) ServiceManager.get().getServiceForReal(IExtraParams.class);
        this.c = LazyKt.lazy(new aea.a(this));
    }
}
