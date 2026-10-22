package gd0;

import android.content.Intent;
import android.view.View;
import com.bytedance.android.livesdk.ability.IAbility;

/* JADX INFO: loaded from: classes46.dex */
public interface f extends IAbility {
    com.bytedance.android.live.ui.c Y0();

    View c();

    boolean isPickingImage();

    void onActivityResult(int r100, int r101, Intent r102);
}
