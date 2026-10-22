package com.obric.assistant.extraparam;

import android.os.Build;
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
import t9a.b;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\bH\u0016R\u0016\u0010\u0004\u001a\n \u0005*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/extraparam/ObricExtraParamImpl;", "Lcom/larus/apm/api/IExtraParams;", "<init>", "()V", "real", "kotlin.jvm.PlatformType", "_staticParams", "", "", "get_staticParams", "()Ljava/util/Map;", "_staticParams$delegate", "Lkotlin/Lazy;", "staticParams", "", "getStaticParams", "getAppVariant", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricExtraParamImpl implements IExtraParams {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f389198d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IExtraParams f389199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f389200c;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.apm.api.IExtraParams
    public final String b() {
        f r100 = f.f518415a;
        IBuildContext.Companion r101 = IBuildContext.f384980a;
        String r102 = null;
        if (StringsKt.startsWith$default(r101.a(), "obric", false, 2, null) == false) goto L6;
        r102 = r101.a() + "_pacific_" + Build.MODEL;
        ILogDepend.f384986a.d("AssistantFeature", "appVariant: " + r102);
    L6:
        String r103 = "";
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        String r104 = b.a().g();
        if (r104 == null) goto L13;
        r103 = r104;
    L13:
        FLogger.f375446a.d("ObricExtraParamImpl", "getAppVariant: " + r103 + ", " + r102);
        return r103;
    }

    @Override // com.larus.apm.api.IExtraParams
    public final Map<String, String> c() {
        return (Map) this.f389200c.getValue();
    }

    public ObricExtraParamImpl() {
        this.f389199b = (IExtraParams) ServiceManager.get().getServiceForReal(IExtraParams.class);
        this.f389200c = LazyKt.lazy(new aea.a(this));
    }
}
