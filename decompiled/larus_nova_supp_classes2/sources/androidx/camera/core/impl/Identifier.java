package androidx.camera.core.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class Identifier {
    public Identifier() {
    }

    public abstract Object getValue();

    public static Identifier create(Object r1) {
        return new AutoValue_Identifier(r1);
    }
}
