package rqc;

import android.content.Intent;
import android.net.Uri;
import com.yalantis.ucrop.UCropActivity;

/* JADX INFO: loaded from: classes41.dex */
public final class g implements sqc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UCropActivity f538966a;

    public g(UCropActivity r100) {
        this.f538966a = r100;
    }

    @Override // sqc.a
    public final void b(Throwable r100) {
        this.f538966a.O1(r100);
        this.f538966a.finish();
    }

    @Override // sqc.a
    public final void a(Uri r100, int r101, int r102, int r110, int r111) {
        UCropActivity r103 = this.f538966a;
        float r104 = r103.f464384r.getTargetAspectRatio();
        Uri r105 = (Uri) r103.getIntent().getParcelableExtra("com.yalantis.ucrop.InputUri");
        r103.setResult(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUri", r100).putExtra("com.yalantis.ucrop.InputUri", r105).putExtra("com.yalantis.ucrop.CropAspectRatio", r104).putExtra("com.yalantis.ucrop.ImageWidth", r110).putExtra("com.yalantis.ucrop.ImageHeight", r111).putExtra("com.yalantis.ucrop.OffsetX", r101).putExtra("com.yalantis.ucrop.OffsetY", r102));
        this.f538966a.finish();
    }
}
