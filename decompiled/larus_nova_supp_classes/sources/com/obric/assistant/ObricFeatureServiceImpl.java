package com.obric.assistant;

import android.util.EventsUtils;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.IObricFeatureService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;
import t9a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/ObricFeatureServiceImpl;", "Lcom/obric/assistant/common/spi/IObricFeatureService;", "<init>", "()V", "keepAliveLevel", XmlPullParser.NO_NAMESPACE, "getKeepAliveLevel", "()Ljava/lang/String;", "keepAliveLevel$delegate", "Lkotlin/Lazy;", "isFeatureEnable", XmlPullParser.NO_NAMESPACE, "isObricFeatureEnable", "isObricOs", "getObricProductName", "getObricKeepAliveLevel", "isEmulatorOs", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ObricFeatureServiceImpl implements IObricFeatureService {
    public static final /* synthetic */ int b = 0;
    public final Lazy a;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final String f() {
        FLogger.a.i("ObricFeatureServiceImpl", "getObricKeepAliveLevel, " + ((String) this.a.getValue()));
        return (String) this.a.getValue();
    }

    public ObricFeatureServiceImpl() {
        this.a = LazyKt.lazy(new i1());
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final boolean a() {
        return b.a().a();
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final boolean b() {
        return b.a().b();
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final boolean c() {
        return b.a().a();
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final String d() {
        return b.a().d();
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final boolean e() {
        return b.a().e();
    }
}
