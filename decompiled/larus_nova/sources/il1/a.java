package il1;

import com.bytedance.android.live.core.utils.s1;
import com.ss.ugc.live.barrage.barrage.AbsBarrage;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a<T> {
    public a() {
    }

    public static AbsBarrage.b a(float r100) {
        return new AbsBarrage.b((int) ((r100 / 100.0f) * 255), s1.f(8.0f), new olc.b(), 20);
    }
}
