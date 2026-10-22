package nlb;

import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageDecoder;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends rlb.a<rlb.c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f519565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f519566d;

    @Override // rlb.a, rlb.b
    public final Object make() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        this.f538503b = c.a(this.f519565c);
        rlb.c r100 = (rlb.c) super.make();
        if ((r100 instanceof MSkiaImageDecoder) == false) goto L5;
        boolean r101 = this.f519566d;
        ((MSkiaImageDecoder) r100).mIsSecret = r101;
    L5:
        return r100;
    }

    public a(Class r100, g r101, boolean r102) {
        this.f519565c = r101;
        this.f519566d = r102;
        super(r100);
    }
}
