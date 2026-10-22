package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab;

import android.graphics.Rect;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab.TriggerType;
import com.bytedance.android.livesdk.message.model.MusicPanel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface f {

    public static final class a {
        public static /* synthetic */ void a(f r1, MusicPanel r2) {
            r1.G1(r2, TriggerType.Bind);
        }
    }

    void G1(MusicPanel r1, TriggerType r2);

    Rect J3();

    void v0(MusicPanel r1);
}
