package com.larus.chat.gallery.api;

import android.app.Dialog;
import com.larus.chat.gallery.impl.preview.toolbar.action.k0;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.InputDraftSnapshot;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes26.dex */
public interface q extends n, u, t, s, x {
    void b(Function1<? super List<AttachmentSnapshot>, Unit> r100);

    void c(Dialog r100);

    List<o> d();

    PreviewSelectionLimit e(String r100);

    void f(Function1<? super List<AttachmentSnapshot>, Unit> r100);

    l getCapability();

    String getTitle(String r100);

    InputDraftSnapshot i(String r100);

    String j();

    String k();

    boolean l(PreviewSourceAction r100, String r101);

    Boolean n();

    String o();

    z p();

    PreviewSelectionLimit r(PreviewMediaType r100);

    void u();

    boolean v(PreviewSourceAction r100, String r101, k0 r102);

    boolean w(String r100);
}
