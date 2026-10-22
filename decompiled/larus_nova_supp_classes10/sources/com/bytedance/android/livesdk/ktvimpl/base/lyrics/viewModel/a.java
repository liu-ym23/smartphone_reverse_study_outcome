package com.bytedance.android.livesdk.ktvimpl.base.lyrics.viewModel;

import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.frame.c;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface a extends c {
    boolean a();

    KtvContext b();

    List<SongUniqueInfo> c();

    boolean e();

    void g(int r1);

    boolean h();

    boolean i();

    MusicPanel j();

    void m(b r1);
}
