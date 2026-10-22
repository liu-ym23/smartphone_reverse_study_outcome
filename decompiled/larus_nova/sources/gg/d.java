package gg;

import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes43.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hg.a f481096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f481097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f481098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f481099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f481100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ List f481101f;

    public d(hg.a r100, List r101, String r102, String r103, String r104, List r105) {
        this.f481096a = r100;
        this.f481097b = r101;
        this.f481098c = r102;
        this.f481099d = r103;
        this.f481100e = r104;
        this.f481101f = r105;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        ConcurrentHashMap<String, Map<String, hg.a>> r102 = c.f481088a;
        c.b(this.f481096a, this.f481097b, this.f481098c, this.f481099d, this.f481100e, this.f481101f);
    }
}
