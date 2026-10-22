package tfc;

import android.widget.SeekBar;
import com.ss.android.photoeditor.mosaic.MosaicPhotoEditorPlugin;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MosaicPhotoEditorPlugin f545821a;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r100) {
    }

    public f(MosaicPhotoEditorPlugin r100) {
        this.f545821a = r100;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r100) {
        sfc.a.f541747a.getClass();
        sfc.a.C7605a.c();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
        MosaicPhotoEditorPlugin.g(this.f545821a, r101);
        sfc.a.f541747a.getClass();
        sfc.a.f541753g = true;
    }
}
