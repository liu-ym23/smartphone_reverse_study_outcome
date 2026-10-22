package vd8;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b implements com.larus.bmhome.chat.list.cell.spacer.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f554213a;

    public b(p r100) {
        this.f554213a = r100;
    }

    @Override // com.larus.bmhome.chat.list.cell.spacer.i
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "spacerId");
        Set<String> r101 = a.f554211b;
        a.f554211b.remove(r100);
        this.f554213a.f554242f.a(r100);
    }

    @Override // com.larus.bmhome.chat.list.cell.spacer.i
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "spacerId");
        this.f554213a.f554242f.b(r100);
    }

    @Override // com.larus.bmhome.chat.list.cell.spacer.i
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "spacerId");
        this.f554213a.f554242f.c(r100);
    }

    @Override // com.larus.bmhome.chat.list.cell.spacer.i
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "spacerId");
        Set<String> r101 = a.f554211b;
        a.f554211b.add(r100);
        this.f554213a.f554242f.d(r100);
    }
}
