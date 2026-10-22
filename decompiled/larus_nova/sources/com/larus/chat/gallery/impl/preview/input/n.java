package com.larus.chat.gallery.impl.preview.input;

import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.CameraResultRoute;
import com.larus.chat.gallery.impl.preview.provider.w0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class n implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f324390a = null;

    static {
        f324390a = new n();
    }

    public n() {
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final String a() {
        return "";
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final com.larus.chat.gallery.api.o b() {
        return null;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final boolean c(ChildResultMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        return true;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final com.larus.chat.gallery.api.o d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemKey");
        return null;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final void detach() {
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final boolean e() {
        return false;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final boolean f(CameraResultRoute r100) {
        if (r100 != null) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final void g() {
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final com.larus.chat.gallery.api.q getSession() {
        return null;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final boolean h(CameraOutputContext r100, xy8.d r101) {
        Intrinsics.checkNotNullParameter(r100, "outputContext");
        return false;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final int i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemKey");
        return -1;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final void j(w0 r100) {
        Intrinsics.checkNotNullParameter(r100, "onSelectionChanged");
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final boolean k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemKey");
        return false;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final List<com.larus.chat.gallery.api.o> l() {
        return CollectionsKt.emptyList();
    }
}
