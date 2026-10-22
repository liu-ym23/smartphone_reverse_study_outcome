package im7;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import il7.m;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f490539a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static CopyOnWriteArrayList<g> f490540b;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"im7/f$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lim7/g;", "luckydog-task_release"}, k = 1, mv = {1, 4, 0})
    public static final class a extends TypeToken<CopyOnWriteArrayList<g>> {
        public a() {
        }
    }

    static {
        f490539a = new Gson();
    }

    public static void a(String r100, String r101, boolean r102) {
        if (TextUtils.isEmpty(r100) == false) goto L31;
        com.bytedance.ug.sdk.luckydog.api.log.a.c("WidgetBubbleManager", "setWidgetBubble widgetName =" + r100);
        return;
    L31:
    L28:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.a.c("WidgetBubbleManager", "setWidgetBubble fail, e=" + e.getMessage());
        return;
    L8:
        if (f490540b != null) goto L12;
        CopyOnWriteArrayList<g> r103 = (CopyOnWriteArrayList) f490539a.fromJson(m.a().e("lucky_widget_bubble_sp", ""), new a().getType());     // Catch: Exception -> L28
        f490540b = r103;     // Catch: Exception -> L28
        if (r103 != null) goto L12;
        f490540b = new CopyOnWriteArrayList();     // Catch: Exception -> L28
    L12:
        CopyOnWriteArrayList<g> r104 = f490540b;     // Catch: Exception -> L28
        if (r104 == null) goto L20;
        Iterator<T> r105 = r104.iterator();     // Catch: Exception -> L28
    L16:
        if (r105.hasNext() == false) goto L20;
        g r106 = (g) r105.next();     // Catch: Exception -> L28
        if (Intrinsics.areEqual(r106.f490541a, r100) == false) goto L16;
        r106.f490542b = r101;     // Catch: Exception -> L28
        r106.f490543c = r102;     // Catch: Exception -> L28
        boolean r107 = true;
    L21:
        if (r107 == false) goto L23;
        m.a().k("lucky_widget_bubble_sp", f490539a.toJson(f490540b));     // Catch: Exception -> L28
        return;
    L23:
        g r108 = new g(r100, r101, r102);     // Catch: Exception -> L28
        CopyOnWriteArrayList<g> r109 = f490540b;     // Catch: Exception -> L28
        if (r109 == null) goto L26;
        r109.add(r108);     // Catch: Exception -> L28
    L26:
        m.a().k("lucky_widget_bubble_sp", f490539a.toJson(f490540b));     // Catch: Exception -> L28
        return;
    L20:
        r107 = false;
        goto L21
    }
}
