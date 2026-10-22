package luc;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes42.dex */
public final class k implements Iterable<String>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f510874a;

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new j(this.f510874a);
    }

    public k(f r100) {
        this.f510874a = r100;
    }
}
