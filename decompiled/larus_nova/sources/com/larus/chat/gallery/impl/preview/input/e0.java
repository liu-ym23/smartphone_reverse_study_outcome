package com.larus.chat.gallery.impl.preview.input;

import com.larus.camera.api.params.CameraOutputContext;
import com.larus.platform.model.action.SuggestedAction;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public interface e0 {

    public static final class a {
        public static boolean a(e0 r100, SuggestedAction r101, xy8.d r102) {
            Intrinsics.checkNotNullParameter(r101, "action");
            Intrinsics.checkNotNullParameter(r102, "data");
            String r103 = r101.getDisplayName();
            if (r103 != null) goto L6;
            r103 = "";
        L6:
            return r100.e(r103, r102, null);
        }
    }

    void a(com.larus.chat.gallery.impl.preview.provider.a0 r100);

    boolean b(SuggestedAction r100, xy8.d r101, String r102);

    void c(boolean r100);

    boolean d();

    boolean e(String r100, xy8.d r101, zy8.s r102);

    boolean f(String r100, CameraOutputContext r101, Map<String, String> r102);

    boolean g(SuggestedAction r100, CameraOutputContext r101, Map<String, String> r102);

    boolean h(String r100, xy8.d r101);

    SuggestedAction i();
}
