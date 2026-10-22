package xkc;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public final class c implements a.f<List<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f564417a;

    public c(a r100) {
        this.f564417a = r100;
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(List<String> r100) {
        ((ArrayList) this.f564417a.f564394g).addAll(r100);
    }

    @Override // xkc.a.f
    public /* bridge */ /* synthetic */ void call(List<String> r100) {
        call2(r100);
    }
}
