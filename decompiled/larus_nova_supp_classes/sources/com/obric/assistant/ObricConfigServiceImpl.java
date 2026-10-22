package com.obric.assistant;

import android.util.EventsUtils;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.IObricConfigService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001dH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0016\u0010\u0007R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u0018\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/ObricConfigServiceImpl;", "Lcom/obric/assistant/common/spi/IObricConfigService;", "<init>", "()V", "romBuildType", XmlPullParser.NO_NAMESPACE, "getRomBuildType", "()Ljava/lang/String;", "romBuildType$delegate", "Lkotlin/Lazy;", "romVersion", "getRomVersion", "romVersion$delegate", "romFullVersion", "getRomFullVersion", "romFullVersion$delegate", "romReleaseDate", XmlPullParser.NO_NAMESPACE, "getRomReleaseDate", "()I", "romReleaseDate$delegate", "releaseRegion", "getReleaseRegion", "releaseRegion$delegate", "isUTRom", XmlPullParser.NO_NAMESPACE, "()Z", "isUTRom$delegate", "getCommonParams", XmlPullParser.NO_NAMESPACE, "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ObricConfigServiceImpl implements IObricConfigService {
    public static final /* synthetic */ int g = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.common.spi.IObricConfigService
    public final Map<String, String> getCommonParams() {
        LinkedHashMap r1 = new LinkedHashMap();
        IObricAvailableManager r2 = (IObricAvailableManager) ServiceManager.get().getService(IObricAvailableManager.class);     // Catch: Exception -> L12
        boolean r3 = false;
        if (r2 != null) goto L6;
    L8:
        if (r3 == false) goto L10;
        r1.put("o_not_default_assistant", "1");     // Catch: Exception -> L12
    L10:
        r1.put("obric_os_build_type", (String) this.a.getValue());     // Catch: Exception -> L12
        r1.put("o_rom_version", (String) this.b.getValue());     // Catch: Exception -> L12
        r1.put("o_rom_full_version", (String) this.c.getValue());     // Catch: Exception -> L12
        r1.put("o_rom_release_date", String.valueOf(((Number) this.d.getValue()).intValue()));     // Catch: Exception -> L12
        r1.put("o_release_region", (String) this.e.getValue());     // Catch: Exception -> L12
        r1.put("o_is_ut_rom", String.valueOf(((Boolean) this.f.getValue()).booleanValue()));     // Catch: Exception -> L12
    L14:
        FLogger.a.d("ObricAppServiceImpl", "getCommonParams: " + r1);
        return r1;
    L6:
        if (r2.b() == true) goto L8;
        r3 = true;
    L12:
        e = move-exception;
        FLogger.a.e("ObricAppServiceImpl", "getCommonParams error", e);
        goto L14
    }

    public ObricConfigServiceImpl() {
        this.a = LazyKt.lazy(new b1());
        this.b = LazyKt.lazy(new c1());
        this.c = LazyKt.lazy(new d1());
        this.d = LazyKt.lazy(new e1());
        this.e = LazyKt.lazy(new f1());
        this.f = LazyKt.lazy(new g1());
    }
}
