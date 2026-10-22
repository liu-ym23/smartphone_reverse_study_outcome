package com.larus.bmhome.chat.camera.command;

import com.larus.feishu.office.im.impl.base.q0;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionData;
import com.larus.platform.model.action.SuggestedActionScene;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public interface p {
    void G8(q0 r100);

    void a(SuggestedActionScene r100, String r101, boolean r102, String r103, Function1<? super List<SuggestedAction>, Unit> r104);

    void b(SuggestedActionScene r100, String r101, boolean r102, Function1<? super List<SuggestedAction>, Unit> r103);

    void c(String r100, iq9.e r101);

    void d(SuggestedActionData r100);

    boolean d3();

    void preload(String r100);

    List<SuggestedAction> r4(SuggestedActionScene r100, String r101, boolean r102);
}
