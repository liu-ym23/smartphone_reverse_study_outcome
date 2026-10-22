package yh0;

import android.content.Intent;
import android.view.View;
import com.bytedance.android.livesdk.ability.IAbility;

/* JADX INFO: loaded from: classes46.dex */
public interface c extends IAbility {
    void F4(boolean r100);

    com.bytedance.android.live.ui.c Y0();

    View c();

    boolean isPickingImage();

    View j();

    void k(String r100, ye1.a r101);

    void onActivityResult(int r100, int r101, Intent r102);

    void onSei(String r100);
}
