package zf0;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final py.k f571598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f571599c;

    public final String toString() {
        return "name:" + this.f571597a + ", id:" + this.f571599c + ", icon:" + ((String) ListProtector.get(this.f571598b.getUrls(), 0));
    }

    public a(String r100, py.k r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "icon");
        this.f571597a = r100;
        this.f571598b = r101;
        this.f571599c = r102;
    }
}
