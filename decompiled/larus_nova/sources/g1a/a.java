package g1a;

import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.ugc.perf.impl.d;
import com.larus.ugc.perf.impl.e;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f479628a = null;

    static {
        f479628a = new a();
    }

    public a() {
    }

    @Override // com.larus.ugc.perf.impl.d
    public final void c(e r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
    }

    @Override // com.larus.ugc.perf.impl.d
    public final void h(e r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
    }

    @Override // com.larus.ugc.perf.impl.d
    public final void a(e r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Message r101 = r100.f375104a;
        Integer r102 = null;
        if (r101 == null) goto L7;
        CreationMsgContentData r103 = dp8.e.c(r101);
        if (r103 == null) goto L7;
        CreationInfo r104 = r103.creationInfo;
    L8:
        long r105 = AppHost.f326268a.getUpdateVersionCode();
        if (r104 == null) goto L15;
        String r106 = r104.supportVersion;
        if (r106 == null) goto L15;
        Long r107 = StringsKt.toLongOrNull(r106);
        if (r107 == null) goto L15;
        long r108 = r107.longValue();
    L17:
        if (r105 >= r108) goto L19;
        return;
    L19:
        if (r104 == null) goto L21;
        r102 = r104.layoutType;
    L21:
        if (r102 != null) goto L24;
    L25:
        if (r102 != null) goto L28;
        return;
    L28:
        if (r102.intValue() != 2) goto L31;
    L29:
        com.larus.ugc.perf.impl.genimg.d.f375121d.a(r100);
        return;
    L31:
        return;
    L24:
        if (r102.intValue() == 1) goto L29;
    L15:
        r108 = -1;
    L7:
        r104 = null;
        goto L8
    }

    @Override // com.larus.ugc.perf.impl.d
    public final void d(e r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Message r101 = r100.f375104a;
        if (r101 == null) goto L9;
        CreationMsgContentData r102 = dp8.e.c(r101);
        if (r102 == null) goto L9;
        CreationInfo r103 = r102.creationInfo;
        if (r103 == null) goto L9;
        Integer r104 = r103.layoutType;
    L10:
        if (r104 != null) goto L13;
    L14:
        if (r104 != null) goto L17;
        return;
    L17:
        if (r104.intValue() != 2) goto L20;
    L18:
        com.larus.ugc.perf.impl.genimg.d.f375121d.getClass();
        Intrinsics.checkNotNullParameter(r100, "source");
        return;
    L20:
        return;
    L13:
        if (r104.intValue() == 1) goto L18;
    L9:
        r104 = null;
        goto L10
    }
}
