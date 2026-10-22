package com.obric.assistant;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.IObricFeatureService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/ObricFeatureServiceImpl;", "Lcom/obric/assistant/common/spi/IObricFeatureService;", "<init>", "()V", "keepAliveLevel", "", "getKeepAliveLevel", "()Ljava/lang/String;", "keepAliveLevel$delegate", "Lkotlin/Lazy;", "isFeatureEnable", "", "isObricFeatureEnable", "isObricOs", "getObricProductName", "getObricKeepAliveLevel", "isEmulatorOs", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricFeatureServiceImpl implements IObricFeatureService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f385159b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f385160a;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final String f() {
        FLogger.f375446a.i("ObricFeatureServiceImpl", "getObricKeepAliveLevel, " + ((String) this.f385160a.getValue()));
        return (String) this.f385160a.getValue();
    }

    public ObricFeatureServiceImpl() {
        this.f385160a = LazyKt.lazy(new i1());
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final boolean a() {
        return t9a.b.a().a();
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final boolean b() {
        return t9a.b.a().b();
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final boolean c() {
        return t9a.b.a().a();
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final String d() {
        return t9a.b.a().d();
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final boolean e() {
        return t9a.b.a().e();
    }
}
