package rfc;

import com.ss.android.photoeditor.base.view.ColorChoiceView;
import com.ss.android.photoeditor.graffiti.GraffitiPhotoEditorPlugin;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements ColorChoiceView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GraffitiPhotoEditorPlugin f537652a;

    public a(GraffitiPhotoEditorPlugin r100) {
        this.f537652a = r100;
    }

    @Override // com.ss.android.photoeditor.base.view.ColorChoiceView.b
    public final void a(int r100, ColorChoiceView.ChoiceColor r101) {
        this.f537652a.f449192a.setPaintColor(r100);
        sfc.a.C7605a r102 = sfc.a.f541747a;
        int r103 = r101.ID;
        r102.getClass();
        List<Integer> r104 = sfc.a.f541755i;
        ArrayList r105 = (ArrayList) r104;
        r105.add(Integer.valueOf(r103));
        sfc.a.C7605a.b("color");
    }
}
