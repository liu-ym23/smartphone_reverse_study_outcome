package rdc;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.widget.photopickerimpl.bean.Photo;
import com.ss.android.lark.widget.photopickernew.PhotoPickerFrameFragment2;
import com.ss.android.lark.widget.photopickernew.grid.GridCameraShowPlugin;
import com.ss.android.lark.widget.photopickernew.grid.GridImageShowPlugin;

/* JADX INFO: loaded from: classes38.dex */
public final class p implements odc.b<t, pdc.a<t, ? extends RecyclerView.ViewHolder>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f537370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f537371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f537372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ s f537373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ PhotoPickerFrameFragment2 f537374e;

    @Override // odc.b
    public final int getColumnCount() {
        return this.f537374e.f447877f.f447571p;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [rdc.n] */
    @Override // odc.b
    public final ldc.e a(int r100) {
        if (r100 != 0) goto L5;
        final Activity r101 = this.f537370a;
        return new GridCameraShowPlugin(new n(this, r101));
    L5:
        return new GridImageShowPlugin(PhotoPickerFrameFragment2.V90(this.f537374e), this.f537374e.f447877f, this.f537371b, this.f537372c, new o(this));
    }

    public int getType(int r100, t r101) {
        if (r100 == 0) goto L5;
    L10:
        return 1;
    L5:
        if (this.f537374e.f447877f.f447556a < 1) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        return 0;
    L7:
        r102 = false;
        goto L8
    }

    @Override // odc.b
    public /* bridge */ /* synthetic */ int getType(int r100, Photo r101) {
        return getType(r100, (t) r101);
    }

    public p(PhotoPickerFrameFragment2 r100, FragmentActivity r101, j r102, m r103, s r104) {
        this.f537374e = r100;
        this.f537370a = r101;
        this.f537371b = r102;
        this.f537372c = r103;
        this.f537373d = r104;
    }
}
