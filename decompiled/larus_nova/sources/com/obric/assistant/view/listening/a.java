package com.obric.assistant.view.listening;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.obric.assistant.voice.d f394305a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f394305a, ((a) r100).f394305a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f394305a.hashCode();
    }

    public final String toString() {
        return "ObricDelegatedListeningUiTarget(presentation=" + this.f394305a + ')';
    }

    public a(com.obric.assistant.voice.d r100) {
        Intrinsics.checkNotNullParameter(r100, "presentation");
        this.f394305a = r100;
    }
}
