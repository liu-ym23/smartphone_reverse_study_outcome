package wp9;

import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes31.dex */
public final class d implements lp9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f560620a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f560621b = null;

    public d() {
    }

    static {
        f560620a = new d();
        f560621b = LazyKt.lazy(new c());
    }

    public static kq9.a c() {
        return (kq9.a) f560621b.getValue();
    }

    @Override // lp9.b
    public final boolean e() {
        FLogger.f375446a.i("AlbumFastInputConfigManager", "isAttachmentLeftCameraEnabled enableAttachmentLeftCamera=" + c().a());
        return c().a();
    }

    @Override // lp9.b
    public final boolean a() {
        if (c().b() == false) goto L5;
    L8:
        return true;
    L5:
        if (c().c() == true) goto L8;
        return false;
    }

    @Override // lp9.b
    public final boolean b(String r100, Integer r101) {
        FLogger.f375446a.i("AlbumFastInputConfigManager", "isUgcBotInputEnabled conversationId=" + r100 + " botConversationType=" + r101 + " enableUgcBotInput=" + c().c());
        if (com.larus.bmhome.utils.i.e(r100, r101) == false) goto L7;
        return false;
    L7:
        return c().c();
    }

    @Override // lp9.b
    public final boolean d(String r100, Integer r101) {
        FLogger.f375446a.i("AlbumFastInputConfigManager", "isMainBotInputEnabled conversationId=" + r100 + " botConversationType=" + r101 + " enableMainBotInput=" + c().b());
        if (com.larus.bmhome.utils.i.e(r100, r101) == true) goto L7;
        return false;
    L7:
        return c().b();
    }
}
