package uu0;

import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.profit.dress.config.h;
import com.bytedance.android.live.profit.dress.l;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f551721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f551722b;

    public static final class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final l f551723c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, c5> f551724d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f551725e;

        /* JADX WARN: Multi-variable type inference failed */
        public a(h r100, l r101, Map<String, ? extends c5> r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "previewConfig");
            Intrinsics.checkNotNullParameter(r101, "dress");
            Intrinsics.checkNotNullParameter(r102, "pieceOverrides");
            super(r100);
            this.f551723c = r101;
            this.f551724d = r102;
            this.f551725e = r103;
        }
    }

    /* JADX INFO: renamed from: uu0.b$b, reason: collision with other inner class name */
    public static final class C7933b extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final gm2.h f551726c;

        public C7933b(h r100, gm2.h r101) {
            Intrinsics.checkNotNullParameter(r100, "previewConfig");
            Intrinsics.checkNotNullParameter(r101, "msg");
            super(r100);
            this.f551726c = r101;
        }
    }

    public b(h r100) {
        this.f551722b = r100;
        this.f551721a = new LinkedHashMap();
    }
}
