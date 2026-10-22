package ova;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements Function1<Character, Boolean> {
    public e() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Character r100) {
        return Boolean.valueOf(Character.isWhitespace(r100.charValue()));
    }
}
