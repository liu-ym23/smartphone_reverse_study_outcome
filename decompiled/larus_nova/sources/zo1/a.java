package zo1;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class a implements f<s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, i> f573098a;

    /* JADX INFO: renamed from: zo1.a$a, reason: collision with other inner class name */
    public static final class C8481a {
    }

    static {
    }

    @Override // zo1.d
    public final void a() {
        Intrinsics.checkNotNullParameter("onRoomExit", "event");
        Iterator<Map.Entry<String, i>> r100 = this.f573098a.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        i r101 = r100.next().getValue();
        r101.getClass();
        Intrinsics.checkNotNullParameter("onRoomExit", "event");
        r101.f573100a.clear();
        r101.f573101b.clear();
        goto L4
    }

    public final i e() {
        return this.f573098a.get("ready");
    }

    public final i n() {
        return this.f573098a.get("showing");
    }

    public a() {
        this.f573098a = new HashMap();
    }

    @Override // zo1.f
    public final List<s> b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        i r101 = this.f573098a.get(r100);
        if (r101 == null) goto L7;
        List r102 = r101.f573100a;
        if (r102 == null) goto L7;
        return r102;
    L7:
        return new ArrayList();
    }

    @Override // zo1.f
    public Integer getComponentByGroupId(int r100) {
        return -1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // zo1.f
    public final void d(String r100, g<s> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "observer");
        i r102 = this.f573098a.get(r100);
        if (r102 == null) goto L6;
        Intrinsics.checkNotNullParameter(r101, "observer");
        r102.f573101b.add((g<T>) r101);
        return;
    }
}
