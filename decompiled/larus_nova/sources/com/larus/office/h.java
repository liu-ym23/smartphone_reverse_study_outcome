package com.larus.office;

import android.os.Bundle;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes20.dex */
public interface h extends com.bytedance.ee.bear.browser.plugin.i {
    boolean Ac();

    void Dd(boolean r100);

    a Ff();

    void Ll(int r100);

    void O7();

    void Of(Function1<? super i, Unit> r100);

    void Pj(a r100);

    void R9(a r100);

    void S9(c r100);

    void Sm(Bundle r100);

    void T3(int r100);

    boolean T8();

    void V5(c r100);

    int Ve();

    int Y6();

    boolean Zh(String r100);

    e Zm();

    boolean en();

    boolean f9(String r100, int r101);

    String getHostDocTitle();

    boolean id(j r100);

    boolean isActionBarVisible();

    void pd(String r100, Function1<? super Boolean, Unit> r101);

    void qj();

    boolean re(String r100);

    void registerHostDocTitleChangeListener(Function1<? super String, Unit> r100);

    void sk(int r100);

    void unregisterHostDocTitleChangeListener(Function1<? super String, Unit> r100);

    void y3(OfficeInputParam r100);

    List<c> zk();
}
