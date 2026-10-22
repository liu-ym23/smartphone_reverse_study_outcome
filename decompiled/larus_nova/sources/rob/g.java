package rob;

import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.ItemType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ItemType f538812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f538813b;

    public Object a() {
        return this.f538813b;
    }

    public final ItemType getType() {
        return this.f538812a;
    }

    public g(ItemType r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f538812a = r100;
        this.f538813b = r101;
    }
}
