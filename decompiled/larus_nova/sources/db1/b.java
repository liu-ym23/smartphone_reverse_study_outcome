package db1;

import com.ss.bytedance.ies.audiorecord.api.model.KtvMidiData;
import java.util.Comparator;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f467795a = null;

    static {
        f467795a = new b();
    }

    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        return ((KtvMidiData) r100).getStartMs() - ((KtvMidiData) r101).getStartMs();
    }
}
