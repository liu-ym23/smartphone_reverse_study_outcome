package zka;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import androidx.core.util.Consumer;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.miniapp.calendar.proxy.function.AppletVersionInfo;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class b extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f572711a;

    public b(a r100, Handler r101) {
        this.f572711a = r100;
        super(r101);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r100, Uri r101) {
        a r102 = this.f572711a;
        r102.getClass();
        if (r101 == null) goto L32;
        List<String> r103 = r101.getPathSegments();
        if (r103.size() >= 3) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(ListProtector.get(r103, 0), "ai_package_version") == false) goto L34;
        String r104 = (String) ListProtector.get(r103, 1);
        String r105 = (String) ListProtector.get(r103, 2);
        String r106 = UriProtector.getQueryParameter(r101, RuleConditionBean.VERSION_CODE_KEY);
        if (r106 == null) goto L27;
        Long r107 = StringsKt.toLongOrNull(r106);
        if (r107 == null) goto L30;
        long r108 = r107.longValue();
        Intrinsics.checkNotNull(r104);
        Intrinsics.checkNotNull(r105);
        AppletVersionInfo r109 = new AppletVersionInfo(r104, r105, r108);
        CopyOnWriteArraySet<Consumer<AppletVersionInfo>> r110 = r102.f572710b.get("*|*");
        if (r110 == null) goto L21;
        Iterator<T> r111 = r110.iterator();
    L19:
        if (r111.hasNext() == false) goto L21;
        ((Consumer) r111.next()).accept(r109);
    L21:
        CopyOnWriteArraySet<Consumer<AppletVersionInfo>> r112 = r102.f572710b.get(r104 + '|' + r105);
        if (r112 == null) goto L31;
        Iterator<T> r113 = r112.iterator();
    L25:
        if (r113.hasNext() == false) goto L35;
        ((Consumer) r113.next()).accept(r109);
        goto L25
    L35:
        return;
    L31:
        return;
    L30:
        return;
    L27:
        return;
    L34:
        return;
    }
}
