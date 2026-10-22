package dsc;

import io.github.alexzhirkevich.compottie.internal.effects.LayerEffect;
import java.util.List;
import kotlinx.serialization.json.JsonClassDiscriminator;

/* JADX INFO: loaded from: classes41.dex */
@JsonClassDiscriminator(discriminator = "ty")
public interface s extends zrc.d {
    boolean a();

    List<bsc.s> c();

    boolean d(prc.f r100);

    s deepCopy();

    boolean e(prc.f r100);

    List<LayerEffect> g();

    Integer getIndex();

    Integer getParent();

    Float getStartTime();

    bsc.x getTransform();

    boolean h();

    Boolean i();

    byte j();

    float k();

    orc.f l(orc.b r100, prc.f r101);

    bsc.u m();

    Integer q();

    Float r();

    asc.n t();

    Float u();

    Boolean v();

    void w(List<? extends LayerEffect> r100);

    s x();
}
