package rfc;

import android.widget.SeekBar;
import com.ss.android.photoeditor.graffiti.GraffitiPhotoEditorPlugin;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GraffitiPhotoEditorPlugin f537653a;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r100) {
    }

    public b(GraffitiPhotoEditorPlugin r100) {
        this.f537653a = r100;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r100) {
        sfc.a.f541747a.getClass();
        sfc.a.C7605a.b("thickness");
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
        GraffitiPhotoEditorPlugin.e(this.f537653a, r101);
        sfc.a.f541747a.getClass();
        sfc.a.f541752f = true;
    }
}
