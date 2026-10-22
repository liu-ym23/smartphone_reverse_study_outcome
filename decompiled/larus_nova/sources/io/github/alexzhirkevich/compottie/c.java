package io.github.alexzhirkevich.compottie;

import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes41.dex */
@JvmInline
public final class c implements x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f490733b;

    @Override // io.github.alexzhirkevich.compottie.x
    public final String getKey() {
        return "string_" + this.f490733b.hashCode();
    }

    public final int hashCode() {
        return this.f490733b.hashCode();
    }

    public final String toString() {
        return "JsonString(jsonString='" + this.f490733b + "')";
    }

    public /* synthetic */ c(String r100) {
        this.f490733b = r100;
    }

    @Override // io.github.alexzhirkevich.compottie.x
    public final Object a(Continuation<? super LottieComposition> r100) {
        String r101 = this.f490733b;
        Intrinsics.checkNotNullParameter(b.f490731a, "<this>");
        return BuildersKt.withContext(Dispatchers.getIO(), new JsonStringImpl$load$2(r101, null), r100);
    }

    public final boolean equals(Object r100) {
        String r101 = this.f490733b;
        if ((r100 instanceof c) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r101, ((c) r100).f490733b) == false) goto L11;
        return true;
    L11:
        return false;
    }
}
