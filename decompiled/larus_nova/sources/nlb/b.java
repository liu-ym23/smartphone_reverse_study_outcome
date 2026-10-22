package nlb;

import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends rlb.a<rlb.d> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f519567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f519568d;

    @Override // rlb.a, rlb.b
    public final Object make() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        this.f538503b = c.a(this.f519567c);
        rlb.d r100 = (rlb.d) super.make();
        if ((r100 instanceof MSkiaImageRegionDecoder) == false) goto L5;
        boolean r101 = this.f519568d;
        ((MSkiaImageRegionDecoder) r100).mIsSecret = r101;
    L5:
        return r100;
    }

    public b(Class r100, g r101, boolean r102) {
        this.f519567c = r101;
        this.f519568d = r102;
        super(r100);
    }
}
