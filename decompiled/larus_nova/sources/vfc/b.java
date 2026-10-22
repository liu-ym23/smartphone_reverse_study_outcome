package vfc;

import android.widget.SeekBar;
import com.ss.android.photoeditor.mosaic.v2.MosaicPhotoEditorPluginV2;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MosaicPhotoEditorPluginV2 f554636a;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r100) {
    }

    public b(MosaicPhotoEditorPluginV2 r100) {
        this.f554636a = r100;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r100) {
        sfc.a.f541747a.getClass();
        sfc.a.C7605a.c();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
        MosaicPhotoEditorPluginV2.f(this.f554636a, r101);
        sfc.a.f541747a.getClass();
        sfc.a.f541753g = true;
    }
}
