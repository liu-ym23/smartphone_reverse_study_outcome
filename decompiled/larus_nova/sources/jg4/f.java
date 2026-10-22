package jg4;

import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes15.dex */
public interface f {
    void a(j r100, a r101, LyricsDisplayConfig r102);

    void reset();

    void setSizeChangeListener(Function2<? super Integer, ? super Integer, Unit> r100);
}
